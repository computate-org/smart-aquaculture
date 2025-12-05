/**
 * Order: 10
 * Description: A fishing trip
 * AName: a fishing trip
 * Icon: <i class="fa-duotone fa-regular fa-fishing-rod"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M48 320l32 0 0 144-32 0 0-144z"/><path class="fa-primary" d="M280.4 48c-3.2 0-6.3 .5-9.3 1.4L206.6 69.2C136.1 90.9 88 156.1 88 229.8l0 42.9c22.7 3.8 40 23.6 40 47.3l0 144c0 26.5-21.5 48-48 48l-32 0c-26.5 0-48-21.5-48-48L0 320c0-23.8 17.3-43.5 40-47.3l0-42.9C40 135 101.8 51.2 192.5 23.4L256.9 3.5C264.5 1.2 272.4 0 280.4 0c44 0 79.6 35.7 79.6 79.6l0 56.4c0 13.3-10.7 24-24 24s-24-10.7-24-24l0-56.4C312 62.2 297.8 48 280.4 48zM48 320l0 144 32 0 0-144-32 0zm208 24c0-71.6 55.6-127.8 89-148.1c4.3-2.6 9.6-2.6 14 0c33.5 20.3 89 76.6 89 148.1c0 32-16 80-64 112l27.3 27.3c3 3 4.7 7.1 4.7 11.3l0 1.4c0 8.8-7.2 16-16 16l-96 0c-8.8 0-16-7.2-16-16l0-1.4c0-4.2 1.7-8.3 4.7-11.3L320 456c-48-32-64-80-64-112zm128-32a24 24 0 1 0 -48 0 24 24 0 1 0 48 0z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-trip
 * EditPageUri: /en-us/edit/fishing-trip/{entityShortId}
 * ApiUri: /en-us/api/fishing-trip
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingTripViewer:
 *     GET:
 *   FishingTripEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 **/
package org.computate.smartaquaculture.model.fiware.fishingtrip;

import io.vertx.ext.web.client.WebClient;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.service.WebApiServiceGen;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import com.hubspot.jinjava.Jinjava;
import io.vertx.core.WorkerExecutor;
import io.vertx.sqlclient.Pool;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.authorization.AuthorizationProvider;

/**
 * Translate: false
 * Gen: false
 * Generated: true
 **/
@WebApiServiceGen
@ProxyGen
public interface FishingTripEnUSGenApiService {
  public void searchFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void getFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void searchpageFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void editpageFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
}
