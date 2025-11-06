package org.computate.smartaquaculture.model.fiware.fishingboat;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.geotools.api.referencing.crs.CoordinateReferenceSystem;
import org.geotools.api.referencing.operation.MathTransform;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geojson.GeoJSON;
import org.geotools.geojson.GeoJSONUtil;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.GeodeticCalculator;
import org.geotools.referencing.crs.DefaultGeocentricCRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.linearref.LinearLocation;
import org.locationtech.jts.linearref.LocationIndexedLine;

import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.tool.GeoTool;

/**
 * Translate: false
 **/
public class FishingBoatEnUSApiServiceImpl extends FishingBoatEnUSGenApiServiceImpl {

  @Override
  public Future<FishingBoat> sqlPATCHFishingBoat(FishingBoat o, Boolean inheritPrimaryKey) {
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Point oldLocation = o.getLocation();
      Path path = o.getPath();
      if(!"false".equals(siteRequest.getRequestVars().get("refresh")) && path != null && path.getPoints().size() >= 2 && jsonObject.getString("setLocation") == null) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime modified = o.getModified();
        Duration duration = Duration.between(modified, now);
        BigDecimal durationMillis = new BigDecimal(duration.toMillis());
        BigDecimal mph = o.getAvgSpeedInMph();
        BigDecimal nextDistanceMeters = GeoTool.calculateMeters(mph, durationMillis, 5, RoundingMode.HALF_UP);

        CoordinateReferenceSystem sourceCRS = DefaultGeographicCRS.WGS84;
        CoordinateReferenceSystem targetCRS = DefaultGeocentricCRS.CARTESIAN;
        boolean lenient = true;
        PrecisionModel precisionModel = new PrecisionModel(PrecisionModel.FLOATING);
        int srid = 4326;
        double tolerance = nextDistanceMeters.doubleValue();
        GeometryFactory geometryFactory =  new GeometryFactory(precisionModel, srid);
        Coordinate geojsonCoordinate = GeoJSONUtil.createCoordinate(Arrays.asList(oldLocation.getX(), oldLocation.getY()));
        MathTransform sourceTransform = CRS.findMathTransform(sourceCRS, targetCRS, lenient);
        MathTransform targetTransform = CRS.findMathTransform(targetCRS, sourceCRS, lenient);
        Coordinate oldCoordinate = JTS.transform(geojsonCoordinate, null, sourceTransform);
        org.locationtech.jts.geom.Point oldPoint = geometryFactory.createPoint(oldCoordinate);
        Coordinate[] coordinates = path.getPoints().stream().map(point -> {
          try {
            return JTS.transform(new Coordinate(point.getX(), point.getY()), null, sourceTransform);
          } catch(Throwable ex) {
            ExceptionUtils.rethrow(ex);
            return null;
          }
        }).collect(Collectors.toList()).toArray(Coordinate[]::new);
        LineString lineString = geometryFactory.createLineString(coordinates);
        LocationIndexedLine indexedLine = new LocationIndexedLine(lineString);
        LinearLocation nearestLocation = indexedLine.project(oldCoordinate);
        int nearestSegmentIndex = nearestLocation.getSegmentIndex();
        Coordinate nearestCoordinate = lineString.getCoordinates()[nearestSegmentIndex];
        Coordinate nextCoordinate = nearestCoordinate;
        if(GeoTool.isCoordinateOnLine(lineString, oldPoint, tolerance)) {
          int nextSegmentIndex = nearestSegmentIndex < (lineString.getCoordinates().length - 1) ? nearestSegmentIndex + 1 : 0;
          Coordinate possibleNextCoordinate = lineString.getCoordinates()[nextSegmentIndex];
          nearestLocation = indexedLine.indexOf(possibleNextCoordinate);
          LinearLocation location0 = indexedLine.project(nearestCoordinate);
          LinearLocation location1 = indexedLine.project(possibleNextCoordinate);
          LinearLocation loc0 = location0.compareTo(location1) <= 0 ? location0 : location1;
          LinearLocation loc1 = location0.compareTo(location1) <= 0 ? location1 : location0;
          double distanceToLine = lineString.distance(geometryFactory.createPoint(oldCoordinate));
          boolean isOnLine = distanceToLine < tolerance;
          boolean isBetweenIndices = nearestLocation.compareTo(loc0) > 0 && nearestLocation.compareTo(loc1) <= 1;
          if(isBetweenIndices) {
            nextCoordinate = possibleNextCoordinate;
          }
        } else {
          nextCoordinate = lineString.getCoordinates()[0];
          nearestLocation = indexedLine.indexOf(nextCoordinate);
        }

        GeodeticCalculator gc = new GeodeticCalculator(DefaultGeocentricCRS.CARTESIAN);
        double[] nextGeo = new double[sourceCRS.getCoordinateSystem().getDimension()];
        targetTransform.transform(new double[] {nextCoordinate.getX(), nextCoordinate.getY(), nextCoordinate.getZ()}, 0, nextGeo, 0, 1);
        gc.setStartingGeographicPoint(oldLocation.getX(), oldLocation.getY());
        gc.setDestinationGeographicPoint(nextGeo[0], nextGeo[1]);
        double totalDistance = gc.getOrthodromicDistance();
        double azimuth = gc.getAzimuth();
        double distanceInMeters = gc.getOrthodromicDistance();
        if (distanceInMeters > totalDistance || distanceInMeters < 0) {
          if(GeoTool.isCoordinateOnLine(lineString, oldPoint, 0.01)) {
            int nextSegmentIndex = nearestSegmentIndex < (lineString.getCoordinates().length - 1) ? nearestSegmentIndex + 1 : 0;
            nextCoordinate = lineString.getCoordinates()[nextSegmentIndex];
            nearestLocation = indexedLine.indexOf(nextCoordinate);
            nextGeo = new double[sourceCRS.getCoordinateSystem().getDimension()];
            targetTransform.transform(new double[] {nextCoordinate.getX(), nextCoordinate.getY(), nextCoordinate.getZ()}, 0, nextGeo, 0, 1);
            gc.setStartingGeographicPoint(oldLocation.getX(), oldLocation.getY());
            gc.setDestinationGeographicPoint(nextGeo[0], nextGeo[1]);
          }
        }
        gc.setStartingGeographicPoint(oldLocation.getX(), oldLocation.getY());
        gc.setDirection(azimuth, nextDistanceMeters.doubleValue());
        Point2D newPoint2D = gc.getDestinationGeographicPoint();
        // double newX = gc.getDestinationGeographicPoint().getX();
        // double newY = gc.getDestinationGeographicPoint().getY();
        // Point newLocation = path.getPoints().get(0);

        JsonObject locationJson = new JsonObject().put("type", "Point").put("coordinates", new JsonArray().add(newPoint2D.getX()).add(newPoint2D.getY()));
        // Coordinate newCoordinate = indexedLine.extractPoint(nearestLocation, distanceMeters.doubleValue());
        // newCoordinate.setZ(oldCoordinate.getZ());
        // double[] destPt = new double[sourceCRS.getCoordinateSystem().getDimension()];
        // targetTransform.transform(new double[] {newCoordinate.getX(), newCoordinate.getY(), newCoordinate.getZ()}, 0, destPt, 0, 1);
        // JsonObject locationJson = new JsonObject().put("type", "Point").put("coordinates", new JsonArray().add(destPt[0]).add(destPt[1]));
        // Point point = geometryFactory.createPoint(newCoordinate);
        jsonObject.put("setLocation", locationJson);
      }
      return super.sqlPATCHFishingBoat(o, inheritPrimaryKey);
    } catch(Throwable ex) {
      Promise<FishingBoat> promise = Promise.promise();
      LOG.error("Failed to calculate new point with geotools. ", ex);
      promise.fail(ex);
      return promise.future();
    }
  }
}
