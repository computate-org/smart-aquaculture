package org.computate.smartaquaculture.model.fiware.fishingdock;

import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * Translate: false
 **/
public class FishingDockEnUSApiServiceImpl extends FishingDockEnUSGenApiServiceImpl {

  protected Future<JsonArray> queryFishingDocks() {
    Promise<JsonArray> promise = Promise.promise();
    try {
      Integer sourceApiPort = Integer.parseInt(config.getString(ConfigKeys.PLAQUEMINES_PARISH_API_PORT));
      String sourceApiHostName = config.getString(ConfigKeys.PLAQUEMINES_PARISH_API_HOST_NAME);
      Boolean sourceApiSsl = Boolean.parseBoolean(config.getString(ConfigKeys.PLAQUEMINES_PARISH_API_SSL));
      String sourceApiUri = "/Search/SearchByField?f=json&value=%dock%&field=1";

      webClient.get(sourceApiPort, sourceApiHostName, sourceApiUri).ssl(sourceApiSsl)
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(response -> {
            String body = response.bodyAsString();
            Matcher m = Pattern.compile("<tr.*? data-id=\"([^\"]+)\"[\\w\\W]*?<td>[^<]*?<\\/td>[\\w\\W]*?<td>([^<]*?)<\\/td>[\\w\\W]*?<td>([^<]*?)<\\/td>[\\w\\W]*?(?=<\\/tr>|\\Z)", Pattern.MULTILINE)
                .matcher(body);
            JsonArray items = new JsonArray();
            boolean found = m.find();
            while (found) {
              String id = StringEscapeUtils.unescapeHtml4(m.group(1));
              String address = StringEscapeUtils.unescapeHtml4(m.group(2));
              String name = StringEscapeUtils.unescapeHtml4(m.group(3));
              items.add(new JsonObject()
                  .put(FishingDock.VAR_id, id)
                  .put(FishingDock.VAR_name, name)
                  );
              LOG.info(String.format("%s %s %s", id, address, name));
              found = m.find();
            }
            promise.complete(items);
      }).onFailure(ex -> {
        LOG.error(String.format("Querying FishingDock failed. ", FishingDock.CLASS_SIMPLE_NAME), ex);
        promise.fail(ex);
      });
    } catch (Throwable ex) {
      LOG.error("Querying FishingDock failed. ", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  private JsonObject merkatorToGeoJson(Double mercatorXLon, Double mercatorYLat)
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

  private JsonArray merkatorToPointsJsonArray(Double mercatorXLon, Double mercatorYLat)
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

  public JsonObject merkatorRingsToGeoJsonPolygon(JsonObject geometry) {
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

  public Future<Void> importResult(String classSimpleName, String classApiAddress, JsonObject result) {
    Promise<Void> promise = Promise.promise();
    try {
      Integer sourceApiPort = Integer.parseInt(config.getString(ConfigKeys.ARCGIS_API_PORT));
      String sourceApiHostName = config.getString(ConfigKeys.ARCGIS_API_HOST_NAME);
      Boolean sourceApiSsl = Boolean.parseBoolean(config.getString(ConfigKeys.ARCGIS_API_SSL));
      String assessId = result.getString(FishingDock.VAR_id);
      String sourceApiUri = "/fe3XWHMASK948q2c/arcgis/rest/services/PlaqueminesParcelLayer/FeatureServer/0/query?f=json&where=ASSESSID%3D%27" + assessId + "%27&returnGeometry=true&spatialRel=esriSpatialRelIntersects&outFields=*&outSR=102100";

      webClient.get(sourceApiPort, sourceApiHostName, sourceApiUri).ssl(sourceApiSsl)
          .send()
          .expecting(HttpResponseExpectation.SC_OK)
          .onSuccess(response -> {
            try {
              JsonObject arcgisBody = response.bodyAsJsonObject();
              JsonObject geometry = arcgisBody.getJsonArray("features").stream().map(o -> (JsonObject)o).filter(feature -> feature.containsKey("geometry")).findFirst().map(feature -> feature.getJsonObject("geometry")).orElse(null);
              JsonObject areaServed = merkatorRingsToGeoJsonPolygon(geometry);
              JsonObject location = convertCentroidOfPolygonToGeoJsonPoint(areaServed);
              JsonObject body = new JsonObject();
              String entityShortId = String.format("%s %s", result.getString(FishingDock.VAR_id), result.getString(FishingDock.VAR_name));
              String name = String.format("%s %s", result.getString(FishingDock.VAR_id), result.getString(FishingDock.VAR_name));
              body.put(FishingDock.VAR_entityShortId, entityShortId);
              body.put(FishingDock.VAR_name, name);
              body.put(FishingDock.VAR_areaServed, areaServed);
              body.put(FishingDock.VAR_location, location);

              JsonObject pageParams = new JsonObject();
              pageParams.put("body", body);
              pageParams.put("path", new JsonObject());
              pageParams.put("cookie", new JsonObject());
              pageParams.put("query",
              new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
              JsonObject pageContext = new JsonObject().put("params", pageParams);
              JsonObject pageRequest = new JsonObject().put("context", pageContext);

              vertx.eventBus().request(classApiAddress, pageRequest, new DeliveryOptions()
                  .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
                  .addHeader("action", String.format("putimport%sFuture", classSimpleName))).onSuccess(message -> {
                    // LOG.info(String.format("Imported %s %s", FishingDock.SingularName_enUS, nodeName));
                    promise.complete();
              }).onFailure(ex -> {
                LOG.error(String.format(importDataFail, classSimpleName), ex);
                promise.fail(ex);
              });
            } catch (Exception ex) {
              LOG.error(String.format(importDataFail, classSimpleName), ex);
              promise.fail(ex);
            }
      }).onFailure(ex -> {
        LOG.error(String.format("Querying FishingDock failed. ", FishingDock.CLASS_SIMPLE_NAME), ex);
        promise.fail(ex);
      });
    } catch (Throwable ex) {
      LOG.error("Querying FishingDock failed. ", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  // protected Future<SearchList<FishingDock>> cleanupOldFishingDocks(ComputateSiteRequest siteRequest,
  //     ZonedDateTime dateTimeStarted, String classSimpleName) {
  //   Promise<SearchList<FishingDock>> promise = Promise.promise();
  //   try {
  //     SearchList<FishingDock> searchList = new SearchList<FishingDock>();
  //     searchList.setStore(true);
  //     searchList.q("*:*");
  //     searchList.setC(FishingDock.class);
  //     searchList.fq(String.format("modified_docvalues_date:[* TO %s]",
  //         FishingDock.staticSearchCreated((SiteRequest) siteRequest, dateTimeStarted)));
  //     searchList.rows(100);
  //     searchList.promiseDeepForClass(siteRequest).onSuccess(oldFishingDocks -> {
  //       try {
  //         List<Future<?>> futures = new ArrayList<>();
  //         for (Integer i = 0; i < oldFishingDocks.getList().size(); i++) {
  //           FishingDock oldFishingDock = oldFishingDocks.getList().get(i);
  //           futures.add(Future.future(promise1 -> {
  //             try {
  //               String nodeName = oldFishingDock.getNodeName();

  //               JsonObject pageParams = new JsonObject();
  //               pageParams.put("scopes", new JsonArray().add("GET").add("DELETE"));
  //               pageParams.put("path", new JsonObject());
  //               pageParams.put("cookie", new JsonObject());
  //               pageParams.put("query", new JsonObject()
  //                   .put("softCommit", true)
  //                   .put("q", "*:*")
  //                   .put("var", new JsonArray().add("refresh:false"))
  //                   .put("fq", String.format("%s:%s", FishingDock.VAR_nodeName, oldFishingDock.getNodeName())));
  //               JsonObject pageContext = new JsonObject().put("params", pageParams);
  //               JsonObject pageRequest = new JsonObject().put("context", pageContext);

  //               vertx.eventBus().request(FishingDock.CLASS_API_ADDRESS_FishingDock, pageRequest, new DeliveryOptions()
  //                   .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
  //                   .addHeader("action", String.format("delete%sFuture", classSimpleName))).onSuccess(message -> {
  //                     LOG.info(String.format("Deleted %s %s", FishingDock.SingularName_enUS, nodeName));
  //                     promise1.complete(oldFishingDocks);
  //                   }).onFailure(ex -> {
  //                     LOG.error(String.format(importDataFail, classSimpleName), ex);
  //                     promise1.fail(ex);
  //                   });
  //             } catch (Exception ex) {
  //               LOG.error(String.format(importDataFail, classSimpleName), ex);
  //               promise1.fail(ex);
  //             }
  //           }));
  //         }
  //         Future.all(futures).onSuccess(b -> {
  //           promise.complete();
  //         }).onFailure(ex -> {
  //           LOG.error(String.format(importDataFail, classSimpleName), ex);
  //           promise.fail(ex);
  //         });
  //       } catch (Throwable ex) {
  //         LOG.error(String.format(importDataFail, classSimpleName), ex);
  //         promise.fail(ex);
  //       }
  //     }).onFailure(ex -> {
  //       LOG.error(String.format(importDataFail, classSimpleName), ex);
  //       promise.fail(ex);
  //     });
  //   } catch (Throwable ex) {
  //     LOG.error(String.format(importDataFail, classSimpleName), ex);
  //     promise.fail(ex);
  //   }
  //   return promise.future();
  // }

  @Override
  protected Future<Void> importData(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest,
      String classCanonicalName, String classSimpleName, String classApiAddress, String varPageId,
      String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    try {
      ZonedDateTime dateTimeStarted = ZonedDateTime.now();
      queryFishingDocks().onSuccess(nodes -> {
        List<Future<?>> futures = new ArrayList<>();
        for (Integer i = 0; i < nodes.size(); i++) {
          JsonObject item = nodes.getJsonObject(i);
          futures.add(Future.future(promise1 -> {
            importResult(classSimpleName, classApiAddress, item).onComplete(b -> {
              promise1.complete();
            }).onFailure(ex -> {
              LOG.error(String.format(importDataFail, classSimpleName), ex);
              promise1.fail(ex);
            });
          }));
        }
        Future.all(futures).onSuccess(b -> {
          // cleanupOldFishingDocks(siteRequest, dateTimeStarted, classSimpleName).onSuccess(oldAiNodes -> {
            promise.complete();
          // }).onFailure(ex -> {
          //   LOG.error(String.format(importDataFail, classSimpleName), ex);
          //   promise.fail(ex);
          // });
        }).onFailure(ex -> {
          LOG.error(String.format(importDataFail, classSimpleName), ex);
          promise.fail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch (Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  // public static final String PLAQUEMINES_PARISH_UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
  // public static final DateTimeFormatter PLAQUEMINES_PARISH_UTC_DATE_TIME_FORMATTER = DateTimeFormatter
  //     .ofPattern(PLAQUEMINES_PARISH_UTC_DATE_TIME_FORMAT, Locale.US);

  // @Override
  // public Future<SearchList<FishingDock>> searchFishingDockList(SiteRequest siteRequest, Boolean populate,
  //     Boolean store, Boolean modify) {
  //   Promise<SearchList<FishingDock>> promise = Promise.promise();
  //   if (BooleanUtils.toBoolean(config.getString(ConfigKeys.ENABLE_THIN_UI))) {
  //     queryFishingDocks().onSuccess(array -> {
  //       try {
  //         SearchList<FishingDock> searchList = new SearchList<FishingDock>();
  //         List<Future> futures = new ArrayList<>();
  //         String requestId = siteRequest.getServiceRequest().getParams().getJsonObject("path")
  //             .getString(FishingDock.VAR_nodeId);
  //         array.stream().map(o -> (JsonObject) o)
  //             .filter(result -> requestId == null || requestId.equals(result.getString(FishingDock.VAR_nodeId)))
  //             .forEach(result -> {
  //               JsonObject body = new JsonObject();
  //               body.put(FishingDock.VAR_solrId, result.getString(FishingDock.nodeIdPLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_leaseInfo, result.getJsonArray(FishingDock.leaseInfoPLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_networkInfo,
  //                   result.getJsonArray(FishingDock.networkInfoPLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeId, result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                   .getString(FishingDock.nodeIdPLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeIsMaintenance,
  //                   result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                       .getBoolean(FishingDock.nodeIsMaintenancePLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeLinks, result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                   .getJsonArray(FishingDock.nodeLinksPLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeName, result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                   .getString(FishingDock.nodeNamePLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodePowerState, result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                   .getString(FishingDock.nodePowerStatePLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeProvisionState,
  //                   result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                       .getString(FishingDock.nodeProvisionStatePLAQUEMINES_PARISH_enUS));
  //               body.put(FishingDock.VAR_nodeResourceClass,
  //                   result.getJsonObject(FishingDock.nodePLAQUEMINES_PARISH_enUS)
  //                       .getString(FishingDock.nodeResourceClassPLAQUEMINES_PARISH_enUS));

  //               FishingDock node = body.mapTo(FishingDock.class);
  //               node.setSiteRequest_(siteRequest);
  //               searchList.addList(node);

  //               futures.add(Future.future(promise1 -> {
  //                 node.promiseDeepFishingDock().onSuccess(b -> {
  //                   promise1.complete();
  //                 }).onFailure(ex -> {
  //                   LOG.error(String.format("searchFishingDock failed. "), ex);
  //                   promise1.fail(ex);
  //                 });
  //               }));
  //             });
  //         CompositeFuture.all(futures).onSuccess(a -> {
  //           searchList.promiseDeepForClass(siteRequest).onSuccess(b -> {
  //             promise.complete(searchList);
  //           }).onFailure(ex -> {
  //             LOG.error(String.format("searchFishingDock failed. "), ex);
  //             promise.fail(ex);
  //           });
  //         });
  //       } catch (Exception ex) {
  //         LOG.error(String.format("searchFishingDock failed. "), ex);
  //         promise.fail(ex);
  //       }
  //     }).onFailure(ex -> {
  //       LOG.error(String.format("searchFishingDock failed. "), ex);
  //       promise.fail(ex);
  //     });
  //   } else {
  //     super.searchFishingDockList(siteRequest, populate, store, modify).onSuccess(listFishingDock -> {
  //       promise.complete(listFishingDock);
  //     }).onFailure(ex -> {
  //       LOG.error(String.format("searchFishingDock failed. "), ex);
  //       promise.fail(ex);
  //     });
  //   }
  //   return promise.future();
  // }

  // @Override
  // public Future<ServiceResponse> response200SearchFishingDock(SearchList<FishingDock> listFishingDock) {
  //   Promise<ServiceResponse> promise = Promise.promise();
  //   try {
  //     List<String> fls = listFishingDock.getRequest().getFields();
  //     JsonObject json = new JsonObject();
  //     JsonArray l = new JsonArray();
  //     listFishingDock.getList().stream().forEach(o -> {
  //       JsonObject json2 = JsonObject.mapFrom(o);
  //       if (fls.size() > 0) {
  //         Set<String> fieldNames = new HashSet<String>();
  //         for (String fieldName : json2.fieldNames()) {
  //           String v = FishingDock.varIndexedFishingDock(fieldName);
  //           if (v != null)
  //             fieldNames.add(FishingDock.varIndexedFishingDock(fieldName));
  //         }
  //         if (fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
  //           fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings"))
  //               .orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
  //           fieldNames.remove("pk_docvalues_long");
  //           fieldNames.remove("created_docvalues_date");
  //         } else if (fls.size() >= 1) {
  //           fieldNames.removeAll(fls);
  //         }
  //         for (String fieldName : fieldNames) {
  //           if (!fls.contains(fieldName))
  //             json2.remove(fieldName);
  //         }
  //       }
  //       l.add(json2);
  //     });
  //     json.put("list", l);
  //     promise.complete(ServiceResponse
  //         .completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
  //   } catch (Exception ex) {
  //     LOG.error(String.format("response200SearchFishingDock failed. "), ex);
  //     promise.fail(ex);
  //   }
  //   return promise.future();
  // }
}
