package org.computate.smartaquaculture.model.timezone;

import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.sqlclient.Pool;

import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class TimeZoneEnUSApiServiceImpl extends TimeZoneEnUSGenApiServiceImpl {

  public Future<Void> importResult(String classSimpleName, String classApiAddress, String location, String abbreviation, String name) {
    Promise<Void> promise = Promise.promise();
    try {
      JsonObject body = new JsonObject();
      String displayName = String.format("%s %s %s", location, name, abbreviation);
      body.put(TimeZone.VAR_location, location);
      body.put(TimeZone.VAR_abbreviation, abbreviation);
      body.put(TimeZone.VAR_name, name);
      body.put(TimeZone.VAR_displayName, displayName);
      body.put(TimeZone.VAR_id, location);

      JsonObject pageParams = new JsonObject();
      pageParams.put("body", body);
      pageParams.put("path", new JsonObject());
      pageParams.put("cookie", new JsonObject());
      pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
      JsonObject pageContext = new JsonObject().put("params", pageParams);
      JsonObject pageRequest = new JsonObject().put("context", pageContext);

      vertx.eventBus().request(classApiAddress, pageRequest, new DeliveryOptions()
          .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
          .addHeader("action", String.format("putimport%sFuture", classSimpleName))
          ).onSuccess(message -> {
        LOG.info(String.format("Imported %s %s", TimeZone.SingularName_enUS, location));
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<Void> importData(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest,
      String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl,
      String varDownload) {
    Promise<Void> promise = Promise.promise();
    try {
      ZonedDateTime dateTimeStarted = ZonedDateTime.now();
      String[] timeZoneIds = java.util.TimeZone.getAvailableIDs();

      List<Future<?>> futures = new ArrayList<>();
      for(Integer i = 0; i < timeZoneIds.length; i++) {
        String timeZoneId = timeZoneIds[i];
        java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone(timeZoneIds[i]);
        ZoneId zoneId = timeZone.toZoneId();
        String abbreviation = zoneId.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH);
        String name = zoneId.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        futures.add(Future.future(promise1 -> {
          importResult(classSimpleName, classApiAddress, timeZoneId, abbreviation, name).onComplete(b -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise1.fail(ex);
          });
        }));
      }
      Future.all(futures).onSuccess(b -> {
        vertx.timer(1L, TimeUnit.SECONDS).onSuccess(c -> {
          cleanupOldTimeZones(siteRequest, dateTimeStarted, classSimpleName).onSuccess(d -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise.fail(ex);
          });
        }).onFailure(ex -> {
          LOG.error(String.format(importDataFail, classSimpleName), ex);
          promise.fail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  protected Future<SearchList<TimeZone>> cleanupOldTimeZones(ComputateSiteRequest siteRequest, ZonedDateTime dateTimeStarted, String classSimpleName) {
    Promise<SearchList<TimeZone>> promise = Promise.promise();
    try {
      SearchList<TimeZone> searchList = new SearchList<TimeZone>();
      searchList.setStore(true);
      searchList.q("*:*");
      searchList.setC(TimeZone.class);
      searchList.fq(String.format("modified_docvalues_date:[* TO %s]", TimeZone.staticSearchCreated((SiteRequest)siteRequest, dateTimeStarted)));
      searchList.rows(1000);
      searchList.promiseDeepForClass(siteRequest).onSuccess(oldTimeZones -> {
        try {
          List<Future<?>> futures = new ArrayList<>();
          for(Integer i = 0; i < oldTimeZones.getList().size(); i++) {
            TimeZone oldTimeZone = oldTimeZones.getList().get(i);
            futures.add(Future.future(promise1 -> {
              try {
                String id = oldTimeZone.getId();

                JsonObject pageParams = new JsonObject();
                pageParams.put("scopes", new JsonArray().add("GET").add("DELETE"));
                pageParams.put("path", new JsonObject());
                pageParams.put("cookie", new JsonObject());
                pageParams.put("query", new JsonObject()
                  .put("softCommit", true)
                  .put("q", "*:*")
                  .put("var", new JsonArray().add("refresh:false"))
                  .put("fq", String.format("%s:%s", TimeZone.VAR_id, id))
                  );
                JsonObject pageContext = new JsonObject().put("params", pageParams);
                JsonObject pageRequest = new JsonObject().put("context", pageContext);

                vertx.eventBus().request(TimeZone.CLASS_API_ADDRESS_TimeZone, pageRequest, new DeliveryOptions()
                    .setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000)
                    .addHeader("action", String.format("delete%sFuture", classSimpleName))
                    ).onSuccess(message -> {
                  LOG.info(String.format("Deleted %s %s", TimeZone.SingularName_enUS, id));
                  promise1.complete(oldTimeZones);
                }).onFailure(ex -> {
                  LOG.error(String.format(importDataFail, classSimpleName), ex);
                  promise1.fail(ex);
                });
              } catch(Exception ex) {
                LOG.error(String.format(importDataFail, classSimpleName), ex);
                promise1.fail(ex);
              }
            }));
          }
          Future.all(futures).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise.fail(ex);
          });
        } catch(Throwable ex) {
          LOG.error(String.format(importDataFail, classSimpleName), ex);
          promise.fail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format(importDataFail, classSimpleName), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }
}
