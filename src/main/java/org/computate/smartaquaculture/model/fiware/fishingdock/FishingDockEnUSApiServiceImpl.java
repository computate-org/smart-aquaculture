package org.computate.smartaquaculture.model.fiware.fishingdock;

import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.util.GeoJsonUtil;
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
              JsonObject areaServed = GeoJsonUtil.merkatorRingsToGeoJsonPolygon(geometry);
              JsonObject location = GeoJsonUtil.convertCentroidOfPolygonToGeoJsonPoint(areaServed);
              JsonObject body = new JsonObject();
              String name = String.format("%s %s", result.getString(FishingDock.VAR_id), result.getString(FishingDock.VAR_name));
              String entityShortId = FishingDock.toId(name);
              body.put(FishingDock.VAR_entityShortId, entityShortId);
              body.put(FishingDock.VAR_name, name);
              body.put(FishingDock.VAR_areaServed, areaServed);
              body.put(FishingDock.VAR_location, location);

              JsonObject pageParams = new JsonObject();
              pageParams.put("body", body);
              pageParams.put("scopes", new JsonArray().add("GET").add("POST").add("PATCH").add("DELETE"));
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
          promise.complete();
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
}
