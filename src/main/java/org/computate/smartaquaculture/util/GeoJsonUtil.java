/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.smartaquaculture.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class GeoJsonUtil {

  public static JsonObject merkatorToGeoJson(Double mercatorXLon, Double mercatorYLat)
  {
    if (Math.abs(mercatorXLon) < 180 && Math.abs(mercatorYLat) < 90)
      throw new RuntimeException(String.format("Invalid Mercator lon, lat", mercatorXLon, mercatorYLat));
  
    if ((Math.abs(mercatorXLon) > 20037508.3427892) || (Math.abs(mercatorYLat) > 20037508.3427892))
      throw new RuntimeException(String.format("Invalid Mercator lon, lat", mercatorXLon, mercatorYLat));
  
    double x = mercatorXLon;
    double y = mercatorYLat;
    double num3 = x / 6378137.0;
    double num4 = num3 * 57.295779513082323;
    double num5 = Math.floor((double)((num4 + 180.0) / 360.0));
    double num6 = num4 - (num5 * 360.0);
    double num7 = 1.5707963267948966 - (2.0 * Math.atan(Math.exp((-1.0 * y) / 6378137.0)));
    double geojsonXLon = num6;
    double geojsonYLat = num7 * 57.295779513082323;
    JsonObject geojson = new JsonObject();
    geojson.put("type", "Point");
    geojson.put("coordinates", new JsonArray().add(geojsonYLat).add(geojsonXLon));
    return geojson;
  }

  public static JsonArray merkatorToPointsJsonArray(Double mercatorXLon, Double mercatorYLat)
  {
    if (Math.abs(mercatorXLon) < 180 && Math.abs(mercatorYLat) < 90)
      throw new RuntimeException(String.format("Invalid Mercator lon, lat", mercatorXLon, mercatorYLat));
  
    if ((Math.abs(mercatorXLon) > 20037508.3427892) || (Math.abs(mercatorYLat) > 20037508.3427892))
      throw new RuntimeException(String.format("Invalid Mercator lon, lat", mercatorXLon, mercatorYLat));
  
    double x = mercatorXLon;
    double y = mercatorYLat;
    double num3 = x / 6378137.0;
    double num4 = num3 * 57.295779513082323;
    double num5 = Math.floor((double)((num4 + 180.0) / 360.0));
    double num6 = num4 - (num5 * 360.0);
    double num7 = 1.5707963267948966 - (2.0 * Math.atan(Math.exp((-1.0 * y) / 6378137.0)));
    double geojsonXLon = num6;
    double geojsonYLat = num7 * 57.295779513082323;
    return new JsonArray().add(geojsonXLon).add(geojsonYLat);
  }

  public static JsonObject merkatorRingsToGeoJsonPolygon(JsonObject geometry) {
    if(geometry == null)
      return null;
    JsonObject polygon = new JsonObject();
    JsonArray coordinates = new JsonArray();
    polygon.put("type", "Polygon");
    polygon.put("coordinates", coordinates);
    JsonArray rings = Optional.ofNullable(geometry.getJsonArray("rings")).orElse(null);
    if(rings == null)
      return null;
    rings.stream().map(o -> (JsonArray)o).forEach(ring -> {
      JsonArray shape = new JsonArray();
      ring.stream().map(o -> (JsonArray)o).forEach(ringPoints -> {
        JsonArray points = merkatorToPointsJsonArray(ringPoints.getDouble(0), ringPoints.getDouble(1));
        shape.add(points);
      });
      coordinates.add(shape);
    });
    return polygon;
  }

  public static JsonObject convertCentroidOfPolygonToGeoJsonPoint(JsonObject polygon) {
    if(polygon == null)
      return null;
    JsonArray points0 = polygon.getJsonArray("coordinates").getJsonArray(0);
    double x = 0, y = 0, z = 0;
    int size = points0.size();


    List<JsonArray> points1 = points0.stream().map(o -> (JsonArray)o).collect(Collectors.toList());
    for(JsonArray point : points1) {
        double lat = Math.toRadians(point.getDouble(1));
        double lon = Math.toRadians(point.getDouble(0));

        x += Math.cos(lat) * Math.cos(lon);
        y += Math.cos(lat) * Math.sin(lon);
        z += Math.sin(lat);
    }

    x /= size;
    y /= size;
    z /= size;

    double lon = Math.atan2(y, x);
    double hyp = Math.sqrt(x * x + y * y);
    double lat = Math.atan2(z, hyp);

    JsonObject point = new JsonObject()
        .put("type", "Point")
        .put("coordinates", new JsonArray().add(Math.toDegrees(lon)).add(Math.toDegrees(lat)))
        ;
    return point;
  }
}
