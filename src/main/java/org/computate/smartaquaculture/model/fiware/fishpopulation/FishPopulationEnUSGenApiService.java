/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 6
 * Description: 
 * AName: a fish population
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3zM448 256a32 32 0 1 1 -64 0 32 32 0 1 1 64 0z"/><path class="fa-primary" d="M180.8 303.7c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8zM4.2 336.1L50 256 4.2 175.9c-6.9-12.1-5.2-27.2 4.2-37.5s24.3-13.3 36.9-7.5l99.5 45.6c10.5-11.9 22.5-23.8 35.7-35C219.7 108.5 272.6 80 336 80s116.3 28.5 155.5 61.5c39.1 33 66.9 72.4 81 99.8c4.7 9.2 4.7 20.1 0 29.3c-14.1 27.4-41.9 66.8-81 99.8C452.3 403.5 399.4 432 336 432s-116.3-28.5-155.5-61.5c-13.2-11.2-25.1-23.1-35.7-35L45.3 381.1c-12.6 5.8-27.6 2.8-36.9-7.5S-2.7 348.2 4.2 336.1zM416 224a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-population
 * EditPageUri: /en-us/edit/fish-population/{entityShortId}
 * ApiUri: /en-us/api/fish-population
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishPopulationViewer:
 *     GET:
 *   FishPopulationEditor:
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
 *     Admin:
 **/
package org.computate.smartaquaculture.model.fiware.fishpopulation;

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
public interface FishPopulationEnUSGenApiService {
  public void searchFishPopulation(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void getFishPopulation(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchFishPopulation(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void patchFishPopulationFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postFishPopulation(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void postFishPopulationFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteFishPopulation(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deleteFishPopulationFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportFishPopulation(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void putimportFishPopulationFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void searchpageFishPopulation(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void editpageFishPopulation(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterFishPopulation(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
  public void deletefilterFishPopulationFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler);
}
