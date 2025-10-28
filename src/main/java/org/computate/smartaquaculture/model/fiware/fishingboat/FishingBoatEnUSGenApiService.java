/**
 * Order: 12
 * Description: A fishing boat that catches fish from a fish population and returns the fish to a dock. 
 * AName: a fishing boat
 * Icon: <i class="fa-duotone fa-regular fa-ship"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640"><!--!Font Awesome Pro v7.1.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path opacity=".4" d="M141 363.5L296.5 301.3L296.5 464.5C297.3 465.1 298 465.6 298.7 466.2C297.5 465.3 296.2 464.4 294.9 463.4C266.8 442.3 233.6 431.8 200.5 432C197.5 432 194.5 432.1 191.4 432.3C170 413.7 152.6 390.3 141 363.5zM339.9 467.8C341.4 466.8 342.9 465.7 344.5 464.5L344.5 301.3L500 363.5C488.4 390.3 471.1 413.5 449.6 432.3C445.9 432.1 442.2 432 438.5 432C406 432.2 373.6 442.7 346.1 463.4C343.9 465 341.9 466.5 339.9 467.8z"/><path d="M375 501.7C413.4 472.7 465.6 472.7 504 501.7C520.9 514.4 536.9 523.2 551.8 526.3C565.5 529.1 579.2 527.2 594.1 516C604.7 508 619.7 510.1 627.7 520.7C635.7 531.3 633.6 546.3 623 554.3C596.6 574.2 568.8 578.7 542.3 573.4C517 568.3 494.2 554.5 475.1 540.1C453.8 524 425.2 524 403.9 540.1C379.7 558.4 351.6 576 320.5 576C289.4 576 261.4 558.3 237.1 540.1C215.8 524 187.2 524 165.9 540.1C142.2 558 111.8 575.6 77.9 575.4C57.5 575.3 37.2 568.7 18.1 554.3C7.5 546.3 5.4 531.3 13.4 520.7C21.4 510.1 36.4 508 47 516C58.3 524.5 68.6 527.4 78.2 527.5C95.8 527.6 115.5 518.1 137.1 501.8C175.5 472.8 227.7 472.8 266.1 501.8C290.1 519.9 306.8 528.1 320.6 528.1C334.4 528.1 351.1 519.9 375.1 501.8zM368.5 64C395 64 416.5 85.5 416.5 112L416.5 128L432.5 128C476.7 128 512.5 163.8 512.5 208L512.5 316.8L534.1 325.4C548.9 331.3 556.5 347.8 551.5 362.9C541.1 394.2 524.7 422.2 503.8 446C486.5 438.1 468.1 433.5 449.6 432.3C471 413.7 488.4 390.4 500 363.5L344.5 301.3L344.5 464.5C324.2 479.6 316.8 479.6 296.5 464.5L296.5 301.3L141 363.5C152.6 390.4 170 413.7 191.4 432.3C172.8 433.5 154.5 438.1 137.2 446C116.3 422.3 99.9 394.2 89.5 362.9C84.4 347.7 92.1 331.3 106.9 325.3L128.5 316.7L128.5 207.9C128.5 163.7 164.3 127.9 208.5 127.9L224.5 127.9L224.5 111.9C224.5 85.4 246 63.9 272.5 63.9L368.5 63.9zM208.5 176C190.8 176 176.5 190.3 176.5 208L176.5 297.6L296.7 249.5C312 243.4 329 243.4 344.3 249.5L464.5 297.6L464.5 208C464.5 190.3 450.2 176 432.5 176L208.5 176z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-boat
 * EditPageUri: /en-us/edit/fishing-boat/{entityShortId}
 * ApiUri: /en-us/api/fishing-boat
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingBoatViewer:
 *     GET:
 *   FishingBoatEditor:
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
 */
package org.computate.smartaquaculture.model.fiware.fishingboat;

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
public interface FishingBoatEnUSGenApiService {
	public void searchFishingBoat(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void getFishingBoat(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void patchFishingBoat(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void patchFishingBoatFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void postFishingBoat(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void postFishingBoatFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void deleteFishingBoat(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void deleteFishingBoatFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void putimportFishingBoat(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void putimportFishingBoatFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void searchpageFishingBoat(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void editpageFishingBoat(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void deletefilterFishingBoat(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
	public void deletefilterFishingBoatFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
}
