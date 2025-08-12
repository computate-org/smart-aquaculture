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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class TimeZoneEnUSApiServiceImpl extends TimeZoneEnUSGenApiServiceImpl {

	public Future<Void> importResult(String classSimpleName, String classApiAddress, String zoneId) {
		Promise<Void> promise = Promise.promise();
		try {
			JsonObject body = new JsonObject();
			body.put(TimeZone.VAR_id, zoneId);

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
				LOG.info(String.format("Imported %s %s", TimeZone.SingularName_enUS, zoneId));
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
  protected Future<Void> importData(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest,
      String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl,
      String varDownload) {
		Promise<Void> promise = Promise.promise();
		try {
      String[] timeZoneIds = java.util.TimeZone.getAvailableIDs();
			List<Future<?>> futures = new ArrayList<>();
			for(Integer i = 0; i < timeZoneIds.length; i++) {
        String timeZoneId = timeZoneIds[i];
				futures.add(Future.future(promise1 -> {
					importResult(classSimpleName, classApiAddress, timeZoneId).onComplete(b -> {
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
		} catch(Throwable ex) {
			LOG.error(String.format(importDataFail, classSimpleName), ex);
			promise.fail(ex);
		}
		return promise.future();
  }
}
