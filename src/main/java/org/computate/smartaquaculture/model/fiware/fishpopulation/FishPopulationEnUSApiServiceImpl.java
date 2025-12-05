package org.computate.smartaquaculture.model.fiware.fishpopulation;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.tool.GeoTool;

/**
 * Translate: false
 **/
public class FishPopulationEnUSApiServiceImpl extends FishPopulationEnUSGenApiServiceImpl {

  @Override
  public Future<FishPopulation> sqlPATCHFishPopulation(FishPopulation o, Boolean inheritPrimaryKey) {
    Promise<FishPopulation> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject jsonObject = siteRequest.getJsonObject();
      if(
          !"false".equals(siteRequest.getRequestVars().get("refresh"))
          && "true".equals(siteRequest.getRequestVars().get("simulation"))
          ) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime modified = o.getModified();
        ZonedDateTime incubationDate = o.getIncubationDate();
        List<Long> populationsAtBirth = o.getPopulationsAtBirth();
        List<Long> populationsNow = o.getPopulationsNow();
        BigDecimal incubationDaysNow = Optional.ofNullable(o.getIncubationDaysNow()).orElse(BigDecimal.ZERO);
        Duration duration = Duration.between(modified, now);
        BigDecimal durationMillis = new BigDecimal(duration.toMillis());
        MathContext mc = new MathContext(15);
        int scale = mc.getPrecision();

        if(incubationDate == null) {
          incubationDate = ZonedDateTime.now();
          jsonObject.put("setIncubationDate", FishPopulation.staticSearchIncubationDate(siteRequest, incubationDate));
        }
        if(incubationDaysNow.compareTo(BigDecimal.ZERO) <= 0) {
          BigDecimal incubationDaysBegin = Optional.ofNullable(o.getIncubationDaysBegin()).orElse(BigDecimal.ZERO);
          BigDecimal incubationDaysEnd = Optional.ofNullable(o.getIncubationDaysEnd()).orElse(BigDecimal.ZERO);
          BigDecimal incubationNumberMax = Optional.ofNullable(o.getIncubationNumberMax()).orElse(BigDecimal.ZERO);
          BigDecimal incubationNumberMin = Optional.ofNullable(o.getIncubationNumberMin()).orElse(BigDecimal.ZERO);
          BigDecimal percentPopulationPregnantMin = Optional.ofNullable(o.getPercentPopulationPregnantMin()).orElse(BigDecimal.ZERO);
          BigDecimal percentPopulationPregnantMax = Optional.ofNullable(o.getPercentPopulationPregnantMax()).orElse(BigDecimal.ZERO);
          Random random = new Random();

          BigDecimal previousPopulation = new BigDecimal(o.getPreviousPopulation());
          populationsNow.stream().forEach(p -> previousPopulation.add(new BigDecimal(p)));

          BigDecimal incubationDaysRandomFactor = new BigDecimal(new BigInteger(scale, random))
              .divide(new BigDecimal(BigInteger.ONE.shiftLeft(scale)), mc);
          BigDecimal incubationDaysRange = incubationDaysEnd.subtract(incubationDaysBegin);
          incubationDaysNow = incubationDaysNow.add(incubationDaysRange.multiply(incubationDaysRandomFactor, mc));

          BigDecimal incubationNumberRandomFactor = new BigDecimal(new BigInteger(scale, random))
              .divide(new BigDecimal(BigInteger.ONE.shiftLeft(scale)), mc);
          BigDecimal incubationNumberRange = incubationNumberMax.subtract(incubationNumberMin);
          BigDecimal incubationNumber = incubationNumberMin.add(incubationNumberRange.multiply(incubationNumberRandomFactor, mc));

          BigDecimal percentPopulationPregnantRandomFactor = new BigDecimal(new BigInteger(scale, random))
              .divide(new BigDecimal(BigInteger.ONE.shiftLeft(scale)), mc);
          BigDecimal percentPopulationPregnantRange = percentPopulationPregnantMax.subtract(percentPopulationPregnantMin);
          BigDecimal percentPopulationPregnant = percentPopulationPregnantMin.add(percentPopulationPregnantRange.multiply(percentPopulationPregnantRandomFactor, mc));

          BigDecimal populationIncrease = previousPopulation.multiply(percentPopulationPregnant.add(BigDecimal.ONE)).multiply(incubationNumber);

          populationsAtBirth.add(populationIncrease.longValue());
          populationsNow.add(populationIncrease.longValue());
          jsonObject.put("setPopulationsAtBirth", FishPopulation.staticJsonPopulationsAtBirth(populationsAtBirth));
        } else {
          incubationDaysNow = incubationDaysNow.subtract(new BigDecimal(1.0 / 24.0 / 60.0 / 60.0 / 1000.0).multiply(durationMillis, mc), mc);
        }
        jsonObject.put("setPopulationsNow", FishPopulation.staticJsonPopulationsNow(populationsNow));
        jsonObject.put("setIncubationDaysNow", FishPopulation.staticJsonIncubationDaysNow(incubationDaysNow));
        // BigDecimal mph = o.getAvgSpeedInMph();

        // CoordinateReferenceSystem sourceCRS = DefaultGeographicCRS.WGS84;
        // CoordinateReferenceSystem targetCRS = DefaultGeocentricCRS.CARTESIAN;
        // boolean lenient = true;
        // PrecisionModel precisionModel = new PrecisionModel(PrecisionModel.FLOATING);
        // int srid = 4326;
        // BigDecimal nextDistanceMeters = GeoTool.calculateMeters(mph, durationMillis, 5, RoundingMode.HALF_UP);
        // double tolerance = nextDistanceMeters.doubleValue();
        // GeometryFactory geometryFactory =  new GeometryFactory(precisionModel, srid);
        // Coordinate geojsonCoordinate = GeoJSONUtil.createCoordinate(Arrays.asList(oldLocation.getX(), oldLocation.getY()));
        // MathTransform sourceTransform = CRS.findMathTransform(sourceCRS, targetCRS, lenient);
        // MathTransform targetTransform = CRS.findMathTransform(targetCRS, sourceCRS, lenient);
        // Coordinate oldCoordinate = JTS.transform(geojsonCoordinate, null, sourceTransform);
        // org.locationtech.jts.geom.Point oldPoint = geometryFactory.createPoint(oldCoordinate);
        // Coordinate[] coordinates = path.getPoints().stream().map(point -> {
        //   try {
        //     return JTS.transform(new Coordinate(point.getX(), point.getY()), null, sourceTransform);
        //   } catch(Throwable ex) {
        //     ExceptionUtils.rethrow(ex);
        //     return null;
        //   }
        // }).collect(Collectors.toList()).toArray(Coordinate[]::new);
        // LineString lineString = geometryFactory.createLineString(coordinates);
        // Boolean isCoordinateOnLine = GeoTool.isCoordinateOnLine(lineString, oldPoint, tolerance);
        // LocationIndexedLine indexedLine = new LocationIndexedLine(lineString);
        // LinearLocation nearestLocation = indexedLine.project(oldCoordinate);
        // BigDecimal segmentFraction = new BigDecimal(nearestLocation.getSegmentFraction()).setScale(3, RoundingMode.HALF_UP);
        // Integer segmentIndex = nearestLocation.getSegmentIndex();
        // Integer nextSegmentIndex = isCoordinateOnLine ? (segmentFraction.equals(BigDecimal.ONE.setScale(3, RoundingMode.HALF_UP)) ? segmentIndex + 2 : segmentIndex + 1) : 0;
        // if(nextSegmentIndex >= lineString.getCoordinates().length)
        //   nextSegmentIndex = 0;
        // Coordinate nextCoordinate = lineString.getCoordinates()[nextSegmentIndex];
        // GeodeticCalculator gc = new GeodeticCalculator(DefaultGeocentricCRS.CARTESIAN);

        // double[] nextGeo = new double[sourceCRS.getCoordinateSystem().getDimension()];
        // targetTransform.transform(new double[] {nextCoordinate.getX(), nextCoordinate.getY(), nextCoordinate.getZ()}, 0, nextGeo, 0, 1);
        // gc.setStartingGeographicPoint(oldLocation.getX(), oldLocation.getY());
        // gc.setDestinationGeographicPoint(nextGeo[0], nextGeo[1]);
        // double azimuth = gc.getAzimuth();
        // BigDecimal nextCoordinateMeters = new BigDecimal(gc.getOrthodromicDistance());
        // if(nextDistanceMeters.compareTo(nextCoordinateMeters) > 0)
        //   nextDistanceMeters = nextCoordinateMeters;
        // gc.setStartingGeographicPoint(oldLocation.getX(), oldLocation.getY());
        // gc.setDirection(azimuth, nextDistanceMeters.doubleValue());
        // Point2D newPoint2D = gc.getDestinationGeographicPoint();

        // JsonObject locationJson = new JsonObject().put("type", "Point").put("coordinates", new JsonArray().add(newPoint2D.getX()).add(newPoint2D.getY()));
        // jsonObject.put("setLocation", locationJson);
      }
      super.sqlPATCHFishPopulation(o, inheritPrimaryKey).onSuccess(FishPopulation -> {
        if("true".equals(jsonObject.getString("setSimulation"))
            || "true".equals(siteRequest.getRequestVars().get("simulation"))
                && BooleanUtils.isNotFalse(o.getSimulation())
            ) {
          Long simulationDelayMillis = Optional.ofNullable(o.getSimulationDelayMillis()).orElse(500L);
          vertx.setTimer(simulationDelayMillis, a -> {
            workerExecutor.executeBlocking(() -> {
              Promise<Void> promise1 = Promise.promise();
              JsonObject params = new JsonObject();
              params.put("body", new JsonObject());
              params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
              params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
              params.put("form", new JsonObject());
              params.put("path", new JsonObject());
              params.put("scopes", new JsonArray().add("GET").add("PATCH"));
              JsonObject query = new JsonObject();
              Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
              Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
              if(softCommit == null && commitWithin == null)
                softCommit = true;
              if(softCommit != null)
                query.put("softCommit", softCommit);
              if(commitWithin != null)
                query.put("commitWithin", commitWithin);
              query.put("q", "*:*")
                  .put("fq", new JsonArray().add("pk:" + o.getPk()))
                  .put("var", new JsonArray().add("simulation:true"));
              params.put("query", query);
              JsonObject context = new JsonObject().put("params", params);
              JsonObject json = new JsonObject().put("context", context);
              eventBus.send(FishPopulation.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchFishPopulationFuture"));
              promise1.complete();
              return promise1.future();
            });
          });
          promise.complete(FishPopulation);
        } else {
          promise.complete(FishPopulation);
        }
      });
    } catch(Throwable ex) {
      LOG.error("Failed to calculate new point with geotools. ", ex);
      promise.fail(ex);
    }
    return promise.future();
  }
}
