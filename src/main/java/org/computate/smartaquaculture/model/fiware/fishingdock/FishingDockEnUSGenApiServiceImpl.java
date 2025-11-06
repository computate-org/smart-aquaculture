/**
 * Fiware: true
 * Order: 8
 * Description: A fishing dock
 * AName: a fishing dock
 * Icon: <i class="fa-duotone fa-regular fa-bridge-water"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M.8 455.3c4 17.2 21.2 27.9 38.4 23.9c24.5-5.7 44.9-16.5 58.2-25C126.5 469.7 159 480 192 480c31.9 0 60.6-9.9 80.4-18.9c5.8-2.7 11.1-5.3 15.6-7.7c4.5 2.4 9.7 5.1 15.6 7.7c19.8 9 48.5 18.9 80.4 18.9c33 0 65.5-10.3 94.5-25.8c13.4 8.4 33.7 19.3 58.2 25c17.2 4 34.4-6.7 38.4-23.9c.6-2.4 .8-4.9 .8-7.3c0-14.5-10-27.7-24.7-31.1c-18.1-4.2-36.2-13.3-50.6-25.2c-5.9-5-13.3-7.6-20.7-7.6c-6.5 0-12.9 2-18.5 5.9C439.4 405.2 410.9 416 384 416c-27.5 0-55-10.6-77.5-26.1c-11.1-7.9-25.9-7.9-37 0C247 405.4 219.5 416 192 416c-26.9 0-55.3-10.8-77.4-26.1C109 386 102.5 384 96 384c-7.4 0-14.8 2.6-20.7 7.6c-14.4 11.9-32.5 21-50.6 25.2c-17.2 4-27.9 21.2-23.9 38.4z"/><path class="fa-primary" d="M32 64C14.3 64 0 78.3 0 96l0 35.6C0 147.3 12.7 160 28.4 160C65.8 160 96 190.2 96 227.6l0 124.9c12.9 0 25.8 3.9 36.9 11.7c18 12.4 40.1 20.3 59.1 20.3c0-.2 0-.3 0-.5l0-128c0-53 43-96 96-96s96 43 96 96l0 128c0 .2 0 .3 0 .5c0 0 0 0 0 0c19 0 41.2-7.9 59.2-20.3c11.1-7.8 24-11.7 36.8-11.7l0-124.9c0-37.3 30.2-67.6 67.6-67.6c15.7 0 28.4-12.7 28.4-28.4L576 96c0-17.7-14.3-32-32-32L32 64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-dock
 * EditPageUri: /en-us/edit/fishing-dock/{entityShortId}
 * ApiUri: /en-us/api/fishing-dock
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingDockViewer:
 *     GET:
 *   FishingDockEditor:
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
package org.computate.smartaquaculture.model.fiware.fishingdock;

import org.computate.smartaquaculture.model.timezone.TimeZoneEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.timezone.TimeZone;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import com.hubspot.jinjava.Jinjava;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.computate.search.response.solr.SolrResponse.StatsField;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import java.nio.file.Path;
import java.nio.file.Files;
import com.google.common.io.Resources;
import java.nio.charset.StandardCharsets;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpResponseExpectation;
import java.nio.charset.Charset;
import io.vertx.ext.auth.authorization.RoleBasedAuthorization;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.lang3.BooleanUtils;
import org.computate.vertx.search.list.SearchList;
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockPage;


/**
 * Translate: false
 * Generated: true
 **/
public class FishingDockEnUSGenApiServiceImpl extends BaseApiServiceImpl implements FishingDockEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(FishingDockEnUSGenApiServiceImpl.class);

	// Search //

	@Override
	public void searchFishingDock(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "GET"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					{
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, false).onSuccess(listFishingDock -> {
							response200SearchFishingDock(listFishingDock).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchFishingDock succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("searchFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200SearchFishingDock(SearchList<FishingDock> listFishingDock) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
			List<String> fls = listFishingDock.getRequest().getFields();
			JsonObject json = new JsonObject();
			JsonArray l = new JsonArray();
			listFishingDock.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					for(String fieldName : json2.fieldNames()) {
						String v = FishingDock.varIndexedFishingDock(fieldName);
						if(v != null)
							fieldNames.add(FishingDock.varIndexedFishingDock(fieldName));
					}
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk_docvalues_long");
						fieldNames.remove("created_docvalues_date");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);
			response200Search(listFishingDock.getRequest(), listFishingDock.getResponse(), json);
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchFishingDock(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		if(pivots != null) {
			for(SolrResponse.Pivot pivotField : pivots) {
				String entityIndexed = pivotField.getField();
				String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
				JsonObject pivotJson = new JsonObject();
				pivotArray.add(pivotJson);
				pivotJson.put("field", entityVar);
				pivotJson.put("value", pivotField.getValue());
				pivotJson.put("count", pivotField.getCount());
				Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
				List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
				if(pivotRanges != null) {
					JsonObject rangeJson = new JsonObject();
					pivotJson.put("ranges", rangeJson);
					for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
						rangeJson.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsObject = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsObject);
						rangeFacet.getCounts().forEach((value, count) -> {
							rangeFacetCountsObject.put(value, count);
						});
					}
				}
				if(pivotFields2 != null) {
					JsonArray pivotArray2 = new JsonArray();
					pivotJson.put("pivot", pivotArray2);
					responsePivotSearchFishingDock(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// GET //

	@Override
	public void getFishingDock(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "GET"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					{
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, false).onSuccess(listFishingDock -> {
							response200GETFishingDock(listFishingDock).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("getFishingDock succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("getFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("getFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("getFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("getFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("getFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200GETFishingDock(SearchList<FishingDock> listFishingDock) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
			JsonObject json = JsonObject.mapFrom(listFishingDock.getList().stream().findFirst().orElse(null));
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200GETFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PATCH //

	@Override
	public void patchFishingDock(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchFishingDock started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "PATCH"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					if(authorizationDecisionResponse.failed() && !scopes.contains("PATCH")) {
						String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
						eventHandler.handle(Future.succeededFuture(
							new ServiceResponse(403, "FORBIDDEN",
								Buffer.buffer().appendString(
									new JsonObject()
										.put("errorCode", "403")
										.put("errorMessage", msg)
										.encodePrettily()
									), MultiMap.caseInsensitiveMultiMap()
							)
						));
					} else {
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingDock.getRequest().getRows());
								apiRequest.setNumFound(listFishingDock.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingDock.first());
								apiRequest.setId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
								apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getSolrId()).orElse(null));
								eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());

								listPATCHFishingDock(apiRequest, listFishingDock).onSuccess(e -> {
									response200PATCHFishingDock(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("patchFishingDock succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("patchFishingDock failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("patchFishingDock failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("patchFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("patchFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("patchFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("patchFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listPATCHFishingDock(ApiRequest apiRequest, SearchList<FishingDock> listFishingDock) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
		listFishingDock.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingDock o2 = jsonObject.mapTo(FishingDock.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				patchFishingDockFuture(o2, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHFishingDock failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingDock.next().onSuccess(next -> {
				if(next) {
					listPATCHFishingDock(apiRequest, listFishingDock).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPATCHFishingDock failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHFishingDock failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHFishingDock failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchFishingDockFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
					scopes.stream().map(v -> v.toString()).forEach(scope -> {
						siteRequest.addScopes(scope);
					});
				});
				searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
					try {
						FishingDock o = listFishingDock.first();
						ApiRequest apiRequest = new ApiRequest();
						apiRequest.setRows(1L);
						apiRequest.setNumFound(1L);
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
							siteRequest.getRequestVars().put( "refresh", "false" );
						}
						FishingDock o2;
						if(o != null) {
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setId(Optional.ofNullable(listFishingDock.first()).map(o3 -> o3.getEntityShortId().toString()).orElse(null));
							apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o3 -> o3.getSolrId()).orElse(null));
							JsonObject jsonObject = JsonObject.mapFrom(o);
							o2 = jsonObject.mapTo(FishingDock.class);
							o2.setSiteRequest_(siteRequest);
							patchFishingDockFuture(o2, false).onSuccess(o3 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							String m = String.format("%s %s not found", "fishing dock", null);
							eventHandler.handle(Future.failedFuture(m));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchFishingDock failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchFishingDock failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchFishingDock failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingDock> patchFishingDockFuture(FishingDock o, Boolean inheritPrimaryKey) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingDock> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingDock> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingDock(siteRequest).onSuccess(a -> {
					JsonObject jsonObject = o.getSiteRequest_().getJsonObject();
					if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
						ngsildGetEntity(o).compose(ngsildData -> {
							Promise<JsonObject> promise2 = Promise.promise();
							if(ngsildData == null) {
								promise2.complete(jsonObject);
							} else {
								String setNgsildData = String.format("set%s",StringUtils.capitalize(FishingDock.VAR_ngsildData));
								jsonObject.put(setNgsildData, ngsildData);
								promise2.complete(jsonObject);
							}
							return promise2.future();
						}).compose(ngsildData -> {
							Promise<FishingDock> promise2 = Promise.promise();
							sqlPATCHFishingDock(o, inheritPrimaryKey).onSuccess(fishingDock -> {
								persistFishingDock(fishingDock, true).onSuccess(c -> {
									relateFishingDock(fishingDock).onSuccess(d -> {
										indexFishingDock(fishingDock).onSuccess(o2 -> {
											if(apiRequest != null) {
												apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
												if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
													o2.apiRequestFishingDock();
													if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
														eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
												}
											}
											promise2.complete(fishingDock);
										}).onFailure(ex -> {
											promise2.fail(ex);
										});
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
							return promise2.future();
						}).onSuccess(o2 -> {
							promise1.complete(o2);
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					} else {
						sqlPATCHFishingDock(o, inheritPrimaryKey).onSuccess(fishingDock -> {
							persistFishingDock(fishingDock, true).onSuccess(c -> {
								relateFishingDock(fishingDock).onSuccess(d -> {
									indexFishingDock(fishingDock).onSuccess(o2 -> {
										if(apiRequest != null) {
											apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
											if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
												o2.apiRequestFishingDock();
												if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
													eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
											}
										}
										promise1.complete(fishingDock);
									}).onFailure(ex -> {
										promise1.fail(ex);
									});
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(fishingDock -> {
				Promise<FishingDock> promise2 = Promise.promise();
				refreshFishingDock(fishingDock).onSuccess(a -> {
					promise2.complete(fishingDock);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingDock -> {
				promise.complete(fishingDock);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchFishingDockFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingDock> sqlPATCHFishingDock(FishingDock o, Boolean inheritPrimaryKey) {
		Promise<FishingDock> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE FishingDock SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			FishingDock o2 = new FishingDock();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setName":
							o2.setName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_name + "=$" + num);
							num++;
							bParams.add(o2.sqlName());
						break;
					case "setAddress":
							o2.setAddress(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_address + "=$" + num);
							num++;
							bParams.add(o2.sqlAddress());
						break;
					case "setDescription":
							o2.setDescription(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_description + "=$" + num);
							num++;
							bParams.add(o2.sqlDescription());
						break;
					case "setLocation":
							o2.setLocation(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_location + "=$" + num);
							num++;
							bParams.add(o2.sqlLocation());
						break;
					case "setCreated":
							o2.setCreated(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_created + "=$" + num);
							num++;
							bParams.add(o2.sqlCreated());
						break;
					case "setTimeZone":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								searchResult(siteRequest).query(TimeZone.varIndexedTimeZone(TimeZone.VAR_id), TimeZone.class, val).onSuccess(o3 -> {
									String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
									if(solrId2 != null) {
										solrIds.add(solrId2);
										classes.add("TimeZone");
									}
									sql(siteRequest).update(FishingDock.class, pk).set(FishingDock.VAR_timeZone, TimeZone.class, solrId2, val).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "removeTimeZone":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(solrId2 -> {
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).update(FishingDock.class, pk).setToNull(FishingDock.VAR_timeZone, TimeZone.class, null).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "setId":
							o2.setId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_id + "=$" + num);
							num++;
							bParams.add(o2.sqlId());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setNgsildTenant":
							o2.setNgsildTenant(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_ngsildTenant + "=$" + num);
							num++;
							bParams.add(o2.sqlNgsildTenant());
						break;
					case "setNgsildPath":
							o2.setNgsildPath(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_ngsildPath + "=$" + num);
							num++;
							bParams.add(o2.sqlNgsildPath());
						break;
					case "setAreaServed":
							o2.setAreaServed(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(String.format("%s=ST_GeomFromGeoJSON($%s)", FishingDock.VAR_areaServed, num));
							num++;
							bParams.add(o2.sqlAreaServed());
						break;
					case "setNgsildContext":
							o2.setNgsildContext(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_ngsildContext + "=$" + num);
							num++;
							bParams.add(o2.sqlNgsildContext());
						break;
					case "setNgsildData":
							o2.setNgsildData(jsonObject.getJsonObject(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_ngsildData + "=$" + num);
							num++;
							bParams.add(o2.sqlNgsildData());
						break;
					case "setSessionId":
							o2.setSessionId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_sessionId + "=$" + num);
							num++;
							bParams.add(o2.sqlSessionId());
						break;
					case "setColor":
							o2.setColor(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_color + "=$" + num);
							num++;
							bParams.add(o2.sqlColor());
						break;
					case "setUserKey":
							o2.setUserKey(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_userKey + "=$" + num);
							num++;
							bParams.add(o2.sqlUserKey());
						break;
					case "setObjectTitle":
							o2.setObjectTitle(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_objectTitle + "=$" + num);
							num++;
							bParams.add(o2.sqlObjectTitle());
						break;
					case "setDisplayPage":
							o2.setDisplayPage(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingDock.VAR_displayPage + "=$" + num);
							num++;
							bParams.add(o2.sqlDisplayPage());
						break;
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
				bParams.add(pk);
				num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value FishingDock failed", ex);
						LOG.error(String.format("relateFishingDock failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					FishingDock o3 = new FishingDock();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHFishingDock failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PATCHFishingDock(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postFishingDock(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postFishingDock started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "POST"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					if(authorizationDecisionResponse.failed() && !scopes.contains("POST")) {
						String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
						eventHandler.handle(Future.succeededFuture(
							new ServiceResponse(403, "FORBIDDEN",
								Buffer.buffer().appendString(
									new JsonObject()
										.put("errorCode", "403")
										.put("errorMessage", msg)
										.encodePrettily()
									), MultiMap.caseInsensitiveMultiMap()
							)
						));
					} else {
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						ApiRequest apiRequest = new ApiRequest();
						apiRequest.setRows(1L);
						apiRequest.setNumFound(1L);
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
						JsonObject params = new JsonObject();
						params.put("body", siteRequest.getJsonObject());
						params.put("path", new JsonObject());
						params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
						params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
						params.put("form", new JsonObject());
						JsonObject query = new JsonObject();
						Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
						Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
						if(softCommit == null && commitWithin == null)
							softCommit = true;
						if(softCommit != null)
							query.put("softCommit", softCommit);
						if(commitWithin != null)
							query.put("commitWithin", commitWithin);
						params.put("query", query);
						JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
						JsonObject json = new JsonObject().put("context", context);
						eventBus.request(FishingDock.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postFishingDockFuture")).onSuccess(a -> {
							JsonObject responseMessage = (JsonObject)a.body();
							JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
							apiRequest.setSolrId(responseBody.getString(FishingDock.VAR_solrId));
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
							LOG.debug(String.format("postFishingDock succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("postFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("postFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("postFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	@Override
	public void postFishingDockFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
					scopes.stream().map(v -> v.toString()).forEach(scope -> {
						siteRequest.addScopes(scope);
					});
				});
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}
				postFishingDockFuture(siteRequest, false).onSuccess(o -> {
					eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
				}).onFailure(ex -> {
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Throwable ex) {
				LOG.error(String.format("postFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("postFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<FishingDock> postFishingDockFuture(SiteRequest siteRequest, Boolean entityShortId) {
		Promise<FishingDock> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<FishingDock> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingDock(siteRequest).onSuccess(a -> {
					createFishingDock(siteRequest).onSuccess(fishingDock -> {
						sqlPOSTFishingDock(fishingDock, entityShortId).onSuccess(b -> {
							persistFishingDock(fishingDock, false).onSuccess(c -> {
								relateFishingDock(fishingDock).onSuccess(d -> {
									indexFishingDock(fishingDock).onSuccess(o2 -> {
										promise1.complete(fishingDock);
									}).onFailure(ex -> {
										promise1.fail(ex);
									});
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(fishingDock -> {
				Promise<FishingDock> promise2 = Promise.promise();
				refreshFishingDock(fishingDock).onSuccess(a -> {
					try {
						ApiRequest apiRequest = siteRequest.getApiRequest_();
						if(apiRequest != null) {
							apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
							fishingDock.apiRequestFishingDock();
							eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
						}
						promise2.complete(fishingDock);
					} catch(Exception ex) {
						LOG.error(String.format("postFishingDockFuture failed. "), ex);
						promise2.fail(ex);
					}
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingDock -> {
				try {
					ApiRequest apiRequest = siteRequest.getApiRequest_();
					if(apiRequest != null) {
						apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
						fishingDock.apiRequestFishingDock();
						eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
					}
					promise.complete(fishingDock);
				} catch(Exception ex) {
					LOG.error(String.format("postFishingDockFuture failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postFishingDockFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingDock> sqlPOSTFishingDock(FishingDock o, Boolean inheritPrimaryKey) {
		Promise<FishingDock> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE FishingDock SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingDock o2 = new FishingDock();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("sessionId=$" + num);
				num++;
				bParams.add(siteRequest.getSessionId());
			}
			if(siteRequest.getUserKey() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("userKey=$" + num);
				num++;
				bParams.add(siteRequest.getUserKey());
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case FishingDock.VAR_name:
						o2.setName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_name + "=$" + num);
						num++;
						bParams.add(o2.sqlName());
						break;
					case FishingDock.VAR_address:
						o2.setAddress(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_address + "=$" + num);
						num++;
						bParams.add(o2.sqlAddress());
						break;
					case FishingDock.VAR_description:
						o2.setDescription(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_description + "=$" + num);
						num++;
						bParams.add(o2.sqlDescription());
						break;
					case FishingDock.VAR_location:
						o2.setLocation(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_location + "=$" + num);
						num++;
						bParams.add(o2.sqlLocation());
						break;
					case FishingDock.VAR_created:
						o2.setCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_created + "=$" + num);
						num++;
						bParams.add(o2.sqlCreated());
						break;
					case FishingDock.VAR_timeZone:
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								searchResult(siteRequest).query(TimeZone.varIndexedTimeZone(TimeZone.VAR_id), TimeZone.class, val).onSuccess(o3 -> {
									String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
									if(solrId2 != null) {
										solrIds.add(solrId2);
										classes.add("TimeZone");
									}
									sql(siteRequest).update(FishingDock.class, pk).set(FishingDock.VAR_timeZone, TimeZone.class, solrId2, val).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case FishingDock.VAR_id:
						o2.setId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_id + "=$" + num);
						num++;
						bParams.add(o2.sqlId());
						break;
					case FishingDock.VAR_archived:
						o2.setArchived(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case FishingDock.VAR_ngsildTenant:
						o2.setNgsildTenant(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_ngsildTenant + "=$" + num);
						num++;
						bParams.add(o2.sqlNgsildTenant());
						break;
					case FishingDock.VAR_ngsildPath:
						o2.setNgsildPath(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_ngsildPath + "=$" + num);
						num++;
						bParams.add(o2.sqlNgsildPath());
						break;
					case FishingDock.VAR_areaServed:
						o2.setAreaServed(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_areaServed + "=$" + num);
						num++;
						bParams.add(o2.sqlAreaServed());
						break;
					case FishingDock.VAR_ngsildContext:
						o2.setNgsildContext(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_ngsildContext + "=$" + num);
						num++;
						bParams.add(o2.sqlNgsildContext());
						break;
					case FishingDock.VAR_ngsildData:
						o2.setNgsildData(jsonObject.getJsonObject(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_ngsildData + "=$" + num);
						num++;
						bParams.add(o2.sqlNgsildData());
						break;
					case FishingDock.VAR_sessionId:
						o2.setSessionId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_sessionId + "=$" + num);
						num++;
						bParams.add(o2.sqlSessionId());
						break;
					case FishingDock.VAR_color:
						o2.setColor(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_color + "=$" + num);
						num++;
						bParams.add(o2.sqlColor());
						break;
					case FishingDock.VAR_userKey:
						o2.setUserKey(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_userKey + "=$" + num);
						num++;
						bParams.add(o2.sqlUserKey());
						break;
					case FishingDock.VAR_objectTitle:
						o2.setObjectTitle(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_objectTitle + "=$" + num);
						num++;
						bParams.add(o2.sqlObjectTitle());
						break;
					case FishingDock.VAR_displayPage:
						o2.setDisplayPage(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingDock.VAR_displayPage + "=$" + num);
						num++;
						bParams.add(o2.sqlDisplayPage());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value FishingDock failed", ex);
						LOG.error(String.format("relateFishingDock failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete(o2);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTFishingDock failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200POSTFishingDock(FishingDock o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// DELETE //

	@Override
	public void deleteFishingDock(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("deleteFishingDock started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "DELETE"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					if(authorizationDecisionResponse.failed() && !scopes.contains("DELETE")) {
						String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
						eventHandler.handle(Future.succeededFuture(
							new ServiceResponse(403, "FORBIDDEN",
								Buffer.buffer().appendString(
									new JsonObject()
										.put("errorCode", "403")
										.put("errorMessage", msg)
										.encodePrettily()
									), MultiMap.caseInsensitiveMultiMap()
							)
						));
					} else {
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingDock.getRequest().getRows());
								apiRequest.setNumFound(listFishingDock.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingDock.first());
								apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getSolrId()).orElse(null));
								eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());

								listDELETEFishingDock(apiRequest, listFishingDock).onSuccess(e -> {
									response200DELETEFishingDock(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("deleteFishingDock succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("deleteFishingDock failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("deleteFishingDock failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("deleteFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("deleteFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("deleteFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("deleteFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("deleteFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listDELETEFishingDock(ApiRequest apiRequest, SearchList<FishingDock> listFishingDock) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
		listFishingDock.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingDock o2 = jsonObject.mapTo(FishingDock.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				deleteFishingDockFuture(o).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listDELETEFishingDock failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingDock.next().onSuccess(next -> {
				if(next) {
					listDELETEFishingDock(apiRequest, listFishingDock).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listDELETEFishingDock failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listDELETEFishingDock failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listDELETEFishingDock failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void deleteFishingDockFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
					scopes.stream().map(v -> v.toString()).forEach(scope -> {
						siteRequest.addScopes(scope);
					});
				});
				searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
					try {
						FishingDock o = listFishingDock.first();
						if(o != null && listFishingDock.getResponse().getResponse().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1L);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
							apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getSolrId()).orElse(null));
							deleteFishingDockFuture(o).onSuccess(o2 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("deleteFishingDock failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("deleteFishingDock failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("deleteFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("deleteFishingDock failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingDock> deleteFishingDockFuture(FishingDock o) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingDock> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingDock> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingDock(siteRequest).onSuccess(a -> {
					sqlDELETEFishingDock(o).onSuccess(fishingDock -> {
						relateFishingDock(o).onSuccess(d -> {
							unindexFishingDock(o).onSuccess(o2 -> {
								if(apiRequest != null) {
									apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
									if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
										o2.apiRequestFishingDock();
										if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
											eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
									}
								}
								promise1.complete();
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(fishingDock -> {
				Promise<FishingDock> promise2 = Promise.promise();
				refreshFishingDock(o).onSuccess(a -> {
					promise2.complete(o);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingDock -> {
				promise.complete(fishingDock);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("deleteFishingDockFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlDELETEFishingDock(FishingDock o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("DELETE FROM FishingDock ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingDock o2 = new FishingDock();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case FishingDock.VAR_timeZone:
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								searchResult(siteRequest).query(TimeZone.varIndexedTimeZone(TimeZone.VAR_id), TimeZone.class, val).onSuccess(o3 -> {
									String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
									if(solrId2 != null) {
										solrIds.add(solrId2);
										classes.add("TimeZone");
									}
									sql(siteRequest).update(FishingDock.class, pk).set(FishingDock.VAR_timeZone, TimeZone.class, null, null).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			bParams.add(pk);
			num++;
			futures2.add(0, Future.future(a -> {
				sqlConnection.preparedQuery(bSql.toString())
						.execute(Tuple.tuple(bParams)
						).onSuccess(b -> {
					a.handle(Future.succeededFuture());
				}).onFailure(ex -> {
					RuntimeException ex2 = new RuntimeException("value FishingDock failed", ex);
					LOG.error(String.format("unrelateFishingDock failed. "), ex2);
					a.handle(Future.failedFuture(ex2));
				});
			}));
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
						cbDeleteEntity(o).onSuccess(c -> {
							promise.complete();
						}).onFailure(ex -> {
							LOG.error(String.format("sqlDELETEFishingDock failed. "), ex);
							promise.fail(ex);
						});
					} else {
						promise.complete();
					}
				}).onFailure(ex -> {
					LOG.error(String.format("sqlDELETEFishingDock failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlDELETEFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlDELETEFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200DELETEFishingDock(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200DELETEFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTImport //

	@Override
	public void putimportFishingDock(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportFishingDock started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "PUT"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					if(authorizationDecisionResponse.failed() && !scopes.contains("PUT")) {
						String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
						eventHandler.handle(Future.succeededFuture(
							new ServiceResponse(403, "FORBIDDEN",
								Buffer.buffer().appendString(
									new JsonObject()
										.put("errorCode", "403")
										.put("errorMessage", msg)
										.encodePrettily()
									), MultiMap.caseInsensitiveMultiMap()
							)
						));
					} else {
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(Long.valueOf(jsonArray.size()));
						apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
						varsFishingDock(siteRequest).onSuccess(d -> {
							listPUTImportFishingDock(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportFishingDock(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportFishingDock succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportFishingDock failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("putimportFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("putimportFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listPUTImportFishingDock(ApiRequest apiRequest, SiteRequest siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
					params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request(FishingDock.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportFishingDockFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportFishingDock failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportFishingDockFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
					scopes.stream().map(v -> v.toString()).forEach(scope -> {
						siteRequest.addScopes(scope);
					});
				});
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				String entityShortId = Optional.ofNullable(body.getString(FishingDock.VAR_entityShortId)).orElse(body.getString(FishingDock.VAR_solrId));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<FishingDock> searchList = new SearchList<FishingDock>();
				searchList.setStore(true);
				searchList.q("*:*");
				searchList.setC(FishingDock.class);
				searchList.fq("archived_docvalues_boolean:false");
				searchList.fq("entityShortId_docvalues_string:" + SearchTool.escapeQueryChars(entityShortId));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							FishingDock o = searchList.getList().stream().findFirst().orElse(null);
							FishingDock o2 = new FishingDock();
							o2.setSiteRequest_(siteRequest);
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Object valsObj = o.obtainForClass(f);
									Collection<?> vals = valsObj instanceof JsonArray ? ((JsonArray)valsObj).getList() : (Collection<?>)valsObj;
									if(vals != null && bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										vals.clear();
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									} else {
										if(vals != null)
											vals.clear();
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.persistForClass(f, bodyVal);
									o2.relateForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "entityShortId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "entityShortId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(searchList.size() == 1) {
								apiRequest.setOriginal(o);
								apiRequest.setId(Optional.ofNullable(o.getEntityShortId()).map(v -> v.toString()).orElse(null));
								apiRequest.setSolrId(o.getSolrId());
							}
							siteRequest.setJsonObject(body2);
							patchFishingDockFuture(o, true).onSuccess(b -> {
								LOG.debug("Import FishingDock {} succeeded, modified FishingDock. ", body.getValue(FishingDock.VAR_entityShortId));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportFishingDockFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							postFishingDockFuture(siteRequest, true).onSuccess(b -> {
								LOG.debug("Import FishingDock {} succeeded, created new FishingDock. ", body.getValue(FishingDock.VAR_entityShortId));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportFishingDockFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putimportFishingDockFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putimportFishingDockFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportFishingDockFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("putimportFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTImportFishingDock(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// SearchPage //

	@Override
	public void searchpageFishingDock(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "GET"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					{
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, false).onSuccess(listFishingDock -> {
							response200SearchPageFishingDock(listFishingDock).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchpageFishingDock succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchpageFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchpageFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("searchpageFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public void searchpageFishingDockPageInit(JsonObject ctx, FishingDockPage page, SearchList<FishingDock> listFishingDock, Promise<Void> promise) {
		promise.complete();
	}

	public String templateSearchPageFishingDock(ServiceRequest serviceRequest) {
		return "en-us/search/fishing-dock/FishingDockSearchPage.htm";
	}
	public Future<ServiceResponse> response200SearchPageFishingDock(SearchList<FishingDock> listFishingDock) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
			String pageTemplateUri = templateSearchPageFishingDock(siteRequest.getServiceRequest());
			String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
			Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
			String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
			FishingDockPage page = new FishingDockPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listFishingDock.size() >= 1)
				siteRequest.setRequestPk(listFishingDock.get(0).getPk());
			page.setSearchListFishingDock_(listFishingDock);
			page.setSiteRequest_(siteRequest);
			page.setServiceRequest(siteRequest.getServiceRequest());
			page.setWebClient(webClient);
			page.setVertx(vertx);
			page.promiseDeepFishingDockPage(siteRequest).onSuccess(a -> {
				try {
					JsonObject ctx = ConfigKeys.getPageContext(config);
					ctx.mergeIn(JsonObject.mapFrom(page));
					Promise<Void> promise1 = Promise.promise();
					searchpageFishingDockPageInit(ctx, page, listFishingDock, promise1);
					promise1.future().onSuccess(b -> {
						String renderedTemplate = jinjava.render(template, ctx.getMap());
						Buffer buffer = Buffer.buffer(renderedTemplate);
						promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("response200SearchPageFishingDock failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchPageFishingDock(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		if(pivots != null) {
			for(SolrResponse.Pivot pivotField : pivots) {
				String entityIndexed = pivotField.getField();
				String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
				JsonObject pivotJson = new JsonObject();
				pivotArray.add(pivotJson);
				pivotJson.put("field", entityVar);
				pivotJson.put("value", pivotField.getValue());
				pivotJson.put("count", pivotField.getCount());
				Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
				List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
				if(pivotRanges != null) {
					JsonObject rangeJson = new JsonObject();
					pivotJson.put("ranges", rangeJson);
					for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
						rangeJson.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsObject = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsObject);
						rangeFacet.getCounts().forEach((value, count) -> {
							rangeFacetCountsObject.put(value, count);
						});
					}
				}
				if(pivotFields2 != null) {
					JsonArray pivotArray2 = new JsonArray();
					pivotJson.put("pivot", pivotArray2);
					responsePivotSearchPageFishingDock(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// EditPage //

	@Override
	public void editpageFishingDock(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			form.add("permission", String.format("%s-%s#%s", FishingDock.CLASS_AUTH_RESOURCE, entityShortId, "GET"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "GET"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					{
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, false).onSuccess(listFishingDock -> {
							response200EditPageFishingDock(listFishingDock).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("editpageFishingDock succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("editpageFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("editpageFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("editpageFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("editpageFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("editpageFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public void editpageFishingDockPageInit(JsonObject ctx, FishingDockPage page, SearchList<FishingDock> listFishingDock, Promise<Void> promise) {
		promise.complete();
	}

	public String templateEditPageFishingDock(ServiceRequest serviceRequest) {
		return "en-us/edit/fishing-dock/FishingDockEditPage.htm";
	}
	public Future<ServiceResponse> response200EditPageFishingDock(SearchList<FishingDock> listFishingDock) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
			String pageTemplateUri = templateEditPageFishingDock(siteRequest.getServiceRequest());
			String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
			Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
			String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
			FishingDockPage page = new FishingDockPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listFishingDock.size() >= 1)
				siteRequest.setRequestPk(listFishingDock.get(0).getPk());
			page.setSearchListFishingDock_(listFishingDock);
			page.setSiteRequest_(siteRequest);
			page.setServiceRequest(siteRequest.getServiceRequest());
			page.setWebClient(webClient);
			page.setVertx(vertx);
			page.promiseDeepFishingDockPage(siteRequest).onSuccess(a -> {
				try {
					JsonObject ctx = ConfigKeys.getPageContext(config);
					ctx.mergeIn(JsonObject.mapFrom(page));
					Promise<Void> promise1 = Promise.promise();
					editpageFishingDockPageInit(ctx, page, listFishingDock, promise1);
					promise1.future().onSuccess(b -> {
						String renderedTemplate = jinjava.render(template, ctx.getMap());
						Buffer buffer = Buffer.buffer(renderedTemplate);
						promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("response200EditPageFishingDock failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200EditPageFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotEditPageFishingDock(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		if(pivots != null) {
			for(SolrResponse.Pivot pivotField : pivots) {
				String entityIndexed = pivotField.getField();
				String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
				JsonObject pivotJson = new JsonObject();
				pivotArray.add(pivotJson);
				pivotJson.put("field", entityVar);
				pivotJson.put("value", pivotField.getValue());
				pivotJson.put("count", pivotField.getCount());
				Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
				List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
				if(pivotRanges != null) {
					JsonObject rangeJson = new JsonObject();
					pivotJson.put("ranges", rangeJson);
					for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
						rangeJson.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsObject = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsObject);
						rangeFacet.getCounts().forEach((value, count) -> {
							rangeFacetCountsObject.put(value, count);
						});
					}
				}
				if(pivotFields2 != null) {
					JsonArray pivotArray2 = new JsonArray();
					pivotJson.put("pivot", pivotArray2);
					responsePivotEditPageFishingDock(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// DELETEFilter //

	@Override
	public void deletefilterFishingDock(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("deletefilterFishingDock started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
			String FISHINGDOCK = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("FISHINGDOCK");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "GET"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "POST"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingDock.CLASS_AUTH_RESOURCE, "PUT"));
			if(entityShortId != null)
				form.add("permission", String.format("%s#%s", entityShortId, "DELETE"));
			webClient.post(
					config.getInteger(ComputateConfigKeys.AUTH_PORT)
					, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
					, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
					)
					.ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
					.putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
					.sendForm(form)
					.expecting(HttpResponseExpectation.SC_OK)
			.onComplete(authorizationDecisionResponse -> {
				try {
					HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
					JsonArray scopes = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
					if(authorizationDecisionResponse.failed() && !scopes.contains("DELETE")) {
						String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
						eventHandler.handle(Future.succeededFuture(
							new ServiceResponse(403, "FORBIDDEN",
								Buffer.buffer().appendString(
									new JsonObject()
										.put("errorCode", "403")
										.put("errorMessage", msg)
										.encodePrettily()
									), MultiMap.caseInsensitiveMultiMap()
							)
						));
					} else {
						siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
						List<String> scopes2 = siteRequest.getScopes();
						searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingDock.getRequest().getRows());
								apiRequest.setNumFound(listFishingDock.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingDock.first());
								apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getSolrId()).orElse(null));
								eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());

								listDELETEFilterFishingDock(apiRequest, listFishingDock).onSuccess(e -> {
									response200DELETEFilterFishingDock(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("deletefilterFishingDock succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("deletefilterFishingDock failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("deletefilterFishingDock failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("deletefilterFishingDock failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("deletefilterFishingDock failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("deletefilterFishingDock failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("deletefilterFishingDock failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
				eventHandler.handle(Future.succeededFuture(
					new ServiceResponse(401, "UNAUTHORIZED",
						Buffer.buffer().appendString(
							new JsonObject()
								.put("errorCode", "401")
								.put("errorMessage", "SSO Resource Permission check returned DENY")
								.encodePrettily()
							), MultiMap.caseInsensitiveMultiMap()
							)
					));
			} else {
				LOG.error(String.format("deletefilterFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listDELETEFilterFishingDock(ApiRequest apiRequest, SearchList<FishingDock> listFishingDock) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingDock.getSiteRequest_(SiteRequest.class);
		listFishingDock.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingDock o2 = jsonObject.mapTo(FishingDock.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				deletefilterFishingDockFuture(o).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listDELETEFilterFishingDock failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingDock.next().onSuccess(next -> {
				if(next) {
					listDELETEFilterFishingDock(apiRequest, listFishingDock).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listDELETEFilterFishingDock failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listDELETEFilterFishingDock failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listDELETEFilterFishingDock failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void deletefilterFishingDockFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
					scopes.stream().map(v -> v.toString()).forEach(scope -> {
						siteRequest.addScopes(scope);
					});
				});
				searchFishingDockList(siteRequest, false, true, true).onSuccess(listFishingDock -> {
					try {
						FishingDock o = listFishingDock.first();
						if(o != null && listFishingDock.getResponse().getResponse().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1L);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
							apiRequest.setSolrId(Optional.ofNullable(listFishingDock.first()).map(o2 -> o2.getSolrId()).orElse(null));
							deletefilterFishingDockFuture(o).onSuccess(o2 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("deletefilterFishingDock failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("deletefilterFishingDock failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("deletefilterFishingDock failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("deletefilterFishingDock failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingDock> deletefilterFishingDockFuture(FishingDock o) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingDock> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingDock> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingDock(siteRequest).onSuccess(a -> {
					sqlDELETEFilterFishingDock(o).onSuccess(fishingDock -> {
						relateFishingDock(o).onSuccess(d -> {
							unindexFishingDock(o).onSuccess(o2 -> {
								if(apiRequest != null) {
									apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
									if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
										o2.apiRequestFishingDock();
										if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
											eventBus.publish("websocketFishingDock", JsonObject.mapFrom(apiRequest).toString());
									}
								}
								promise1.complete();
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(fishingDock -> {
				Promise<FishingDock> promise2 = Promise.promise();
				refreshFishingDock(o).onSuccess(a -> {
					promise2.complete(o);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingDock -> {
				promise.complete(fishingDock);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("deletefilterFishingDockFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlDELETEFilterFishingDock(FishingDock o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("DELETE FROM FishingDock ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingDock o2 = new FishingDock();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case FishingDock.VAR_timeZone:
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								searchResult(siteRequest).query(TimeZone.varIndexedTimeZone(TimeZone.VAR_id), TimeZone.class, val).onSuccess(o3 -> {
									String solrId2 = Optional.ofNullable(o3).map(o4 -> o4.getSolrId()).filter(solrId3 -> !solrIds.contains(solrId3)).orElse(null);
									if(solrId2 != null) {
										solrIds.add(solrId2);
										classes.add("TimeZone");
									}
									sql(siteRequest).update(FishingDock.class, pk).set(FishingDock.VAR_timeZone, TimeZone.class, null, null).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			bParams.add(pk);
			num++;
			futures2.add(0, Future.future(a -> {
				sqlConnection.preparedQuery(bSql.toString())
						.execute(Tuple.tuple(bParams)
						).onSuccess(b -> {
					a.handle(Future.succeededFuture());
				}).onFailure(ex -> {
					RuntimeException ex2 = new RuntimeException("value FishingDock failed", ex);
					LOG.error(String.format("unrelateFishingDock failed. "), ex2);
					a.handle(Future.failedFuture(ex2));
				});
			}));
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
						cbDeleteEntity(o).onSuccess(c -> {
							promise.complete();
						}).onFailure(ex -> {
							LOG.error(String.format("sqlDELETEFilterFishingDock failed. "), ex);
							promise.fail(ex);
						});
					} else {
						promise.complete();
					}
				}).onFailure(ex -> {
					LOG.error(String.format("sqlDELETEFilterFishingDock failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlDELETEFilterFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlDELETEFilterFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200DELETEFilterFishingDock(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
				String m = String.format("%s %s not found", "fishing dock", entityShortId);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200DELETEFilterFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// General //

	public Future<FishingDock> createFishingDock(SiteRequest siteRequest) {
		Promise<FishingDock> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

			sqlConnection.preparedQuery("INSERT INTO FishingDock(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				FishingDock o = new FishingDock();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error("createFishingDock failed. ", ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchFishingDockQ(SearchList<FishingDock> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchFishingDockFq(SearchList<FishingDock> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : FishingDock.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : FishingDock.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + SearchTool.escapeQueryChars(FishingDock.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchFishingDockSort(SearchList<FishingDock> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.sort(varIndexed, valueIndexed);
	}

	public void searchFishingDockRows(SearchList<FishingDock> searchList, Long valueRows) {
			searchList.rows(valueRows != null ? valueRows : 10L);
	}

	public void searchFishingDockStart(SearchList<FishingDock> searchList, Long valueStart) {
		searchList.start(valueStart);
	}

	public void searchFishingDockVar(SearchList<FishingDock> searchList, String var, String value) {
		searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
	}

	public void searchFishingDockUri(SearchList<FishingDock> searchList) {
	}

	public Future<ServiceResponse> varsFishingDock(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();

			serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						siteRequest.getRequestVars().put(entityVar, valueIndexed);
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchFishingDock failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<FishingDock>> searchFishingDockList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify) {
		Promise<SearchList<FishingDock>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<FishingDock> searchList = new SearchList<FishingDock>();
			String facetRange = null;
			Date facetRangeStart = null;
			Date facetRangeEnd = null;
			String facetRangeGap = null;
			String statsField = null;
			String statsFieldIndexed = null;
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.q("*:*");
			searchList.setC(FishingDock.class);
			searchList.setSiteRequest_(siteRequest);
			searchList.facetMinCount(1);
			if(entityList != null) {
				for(String v : entityList) {
					searchList.fl(FishingDock.varIndexedFishingDock(v));
				}
			}

			String entityShortId = serviceRequest.getParams().getJsonObject("path").getString("entityShortId");
			if(entityShortId != null) {
				searchList.fq("entityShortId_docvalues_string:" + SearchTool.escapeQueryChars(entityShortId));
			}

			for(String paramName : serviceRequest.getParams().getJsonObject("query").fieldNames()) {
				Object paramValuesObject = serviceRequest.getParams().getJsonObject("query").getValue(paramName);
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Long valueStart = null;
				Long valueRows = null;
				String valueCursorMark = null;
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
						Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
						if(mFacetPivot.find()) {
							String solrLocalParams = mFacetPivot.group(1);
							String[] entityVars = mFacetPivot.group(2).trim().split(",");
							String[] varsIndexed = new String[entityVars.length];
							for(Integer i = 0; i < entityVars.length; i++) {
								entityVar = entityVars[i];
								varsIndexed[i] = FishingDock.varIndexedFishingDock(entityVar);
							}
							searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
						}
					} else if(paramValuesObject != null) {
						for(Object paramObject : paramObjects) {
							if(paramName.equals("q")) {
								Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
								StringBuffer sb = new StringBuffer();
								while(mQ.find()) {
									entityVar = mQ.group(1).trim();
									valueIndexed = mQ.group(2).trim();
									varIndexed = FishingDock.varIndexedFishingDock(entityVar);
									String entityQ = searchFishingDockFq(searchList, entityVar, valueIndexed, varIndexed);
									mQ.appendReplacement(sb, entityQ);
								}
								if(!sb.isEmpty()) {
									mQ.appendTail(sb);
									searchList.q(sb.toString());
								}
							} else if(paramName.equals("fq")) {
								Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
									StringBuffer sb = new StringBuffer();
								while(mFq.find()) {
									entityVar = mFq.group(1).trim();
									valueIndexed = mFq.group(2).trim();
									varIndexed = FishingDock.varIndexedFishingDock(entityVar);
									String entityFq = searchFishingDockFq(searchList, entityVar, valueIndexed, varIndexed);
									mFq.appendReplacement(sb, entityFq);
								}
								if(!sb.isEmpty()) {
									mFq.appendTail(sb);
									searchList.fq(sb.toString());
								}
							} else if(paramName.equals("sort")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = FishingDock.varIndexedFishingDock(entityVar);
								searchFishingDockSort(searchList, entityVar, valueIndexed, varIndexed);
							} else if(paramName.equals("start")) {
								valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchFishingDockStart(searchList, valueStart);
							} else if(paramName.equals("rows")) {
								valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchFishingDockRows(searchList, valueRows);
							} else if(paramName.equals("stats")) {
								searchList.stats((Boolean)paramObject);
							} else if(paramName.equals("stats.field")) {
								Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
								if(mStats.find()) {
									String solrLocalParams = mStats.group(1);
									entityVar = mStats.group(2).trim();
									varIndexed = FishingDock.varIndexedFishingDock(entityVar);
									searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									statsField = entityVar;
									statsFieldIndexed = varIndexed;
								}
							} else if(paramName.equals("facet")) {
								searchList.facet((Boolean)paramObject);
							} else if(paramName.equals("facet.range.start")) {
								String startMathStr = (String)paramObject;
								Date start = SearchTool.parseMath(startMathStr);
								searchList.facetRangeStart(start.toInstant().toString());
								facetRangeStart = start;
							} else if(paramName.equals("facet.range.end")) {
								String endMathStr = (String)paramObject;
								Date end = SearchTool.parseMath(endMathStr);
								searchList.facetRangeEnd(end.toInstant().toString());
								facetRangeEnd = end;
							} else if(paramName.equals("facet.range.gap")) {
								String gap = (String)paramObject;
								searchList.facetRangeGap(gap);
								facetRangeGap = gap;
							} else if(paramName.equals("facet.range")) {
								Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
								if(mFacetRange.find()) {
									String solrLocalParams = mFacetRange.group(1);
									entityVar = mFacetRange.group(2).trim();
									varIndexed = FishingDock.varIndexedFishingDock(entityVar);
									searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									facetRange = entityVar;
								}
							} else if(paramName.equals("facet.field")) {
								entityVar = (String)paramObject;
								varIndexed = FishingDock.varIndexedFishingDock(entityVar);
								if(varIndexed != null)
									searchList.facetField(varIndexed);
							} else if(paramName.equals("var")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								searchFishingDockVar(searchList, entityVar, valueIndexed);
							} else if(paramName.equals("cursorMark")) {
								valueCursorMark = (String)paramObject;
								searchList.cursorMark((String)paramObject);
							}
						}
						searchFishingDockUri(searchList);
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			}
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.sort("created_docvalues_date", "desc");
			}
			String facetRange2 = facetRange;
			Date facetRangeStart2 = facetRangeStart;
			Date facetRangeEnd2 = facetRangeEnd;
			String facetRangeGap2 = facetRangeGap;
			String statsField2 = statsField;
			String statsFieldIndexed2 = statsFieldIndexed;
			searchFishingDock2(siteRequest, populate, store, modify, searchList);
			searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
				if(facetRange2 != null && statsField2 != null && facetRange2.equals(statsField2)) {
					StatsField stats = searchList.getResponse().getStats().getStatsFields().get(statsFieldIndexed2);
					Instant min = Optional.ofNullable(stats.getMin()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
					Instant max = Optional.ofNullable(stats.getMax()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
					if(min.equals(max)) {
						min = min.minus(1, ChronoUnit.DAYS);
						max = max.plus(2, ChronoUnit.DAYS);
					}
					Duration duration = Duration.between(min, max);
					String gap = "HOUR";
					if(duration.toDays() >= 365)
						gap = "YEAR";
					else if(duration.toDays() >= 28)
						gap = "MONTH";
					else if(duration.toDays() >= 1)
						gap = "DAY";
					else if(duration.toHours() >= 1)
						gap = "HOUR";
					else if(duration.toMinutes() >= 1)
						gap = "MINUTE";
					else if(duration.toMillis() >= 1000)
						gap = "SECOND";
					else if(duration.toMillis() >= 1)
						gap = "MILLI";

					if(facetRangeStart2 == null)
						searchList.facetRangeStart(min.toString());
					if(facetRangeEnd2 == null)
						searchList.facetRangeEnd(max.toString());
					if(facetRangeGap2 == null)
						searchList.facetRangeGap(String.format("+1%s", gap));
					searchList.query().onSuccess(b -> {
						promise.complete(searchList);
					}).onFailure(ex -> {
						LOG.error(String.format("searchFishingDock failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete(searchList);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("searchFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchFishingDock2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<FishingDock> searchList) {
	}

	public Future<Void> persistFishingDock(FishingDock o, Boolean patch) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT name, address, description, location, created, timeZone, id, archived, ngsildTenant, ngsildPath, ST_AsGeoJSON(areaServed) as areaServed, ngsildContext, ngsildData, sessionId, color, userKey, objectTitle, displayPage FROM FishingDock WHERE pk=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					for(Row definition : result.value()) {
						for(Integer i = 0; i < definition.size(); i++) {
							String columnName = definition.getColumnName(i);
							Object columnValue = definition.getValue(i);
							if(!"pk".equals(columnName)) {
								try {
									o.persistForClass(columnName, columnValue);
								} catch(Exception e) {
									LOG.error(String.format("persistFishingDock failed. "), e);
								}
							}
						}
					}
					o.promiseDeepForClass(siteRequest).onSuccess(a -> {
						if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
							cbUpsertEntity(o, patch).onSuccess(b -> {
								promise.complete();
							}).onFailure(ex -> {
								LOG.error(String.format("persistFishingDock failed. "), ex);
								promise.fail(ex);
							});
						} else {
							promise.complete();
						}
					}).onFailure(ex -> {
						LOG.error(String.format("persistFishingDock failed. "), ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("persistFishingDock failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("persistFishingDock failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("persistFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> cbUpsertEntity(FishingDock o, Boolean patch) {
		Promise<Void> promise = Promise.promise();
		try {
			ZonedDateTime observedAt = ZonedDateTime.now(ZoneId.of("UTC"));
			String observedAtStr = observedAt.format(ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER);
			JsonArray entityArray = new JsonArray();
			JsonObject entityBody = new JsonObject();
			entityBody.put("@context", config.getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
			entityBody.put("id", o.getId());
			entityBody.put("type", FishingDock.CLASS_SIMPLE_NAME);
			entityBody.put("NGSILD-Tenant"
					, new JsonObject()
					.put("type", "Property")
					.put("value", o.getNgsildTenant())
					.put("observedAt", observedAtStr)
					);
			entityBody.put("NGSILD-Path"
					, new JsonObject()
					.put("type", "Property")
					.put("value", o.getNgsildPath())
					.put("observedAt", observedAtStr)
					);

			List<String> vars = FishingDock.varsFqForClass();
			for (String var : vars) {
				String ngsiType = FishingDock.ngsiType(var);
				String displayName = Optional.ofNullable(FishingDock.displayNameFishingDock(var)).orElse(var);
				if (ngsiType != null && displayName != null && !var.equals("id") && !var.equals("ngsildData")) {
					Object value = o.obtainForClass(var);
					if(value != null) {
						Object ngsildVal = FishingDock.ngsiFishingDock(var, o);
						String ngsildType = FishingDock.ngsiType(var);
						if(ngsildVal != null) {
							entityBody.put(displayName
									, new JsonObject()
									.put("type", ngsildType)
									.put("value", ngsildVal)
									.put("observedAt", observedAtStr)
									);
						}
					}
				}
			}
			entityArray.add(entityBody);
			LOG.debug(entityArray.encodePrettily());
			webClient.post(
					Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
					, config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
					, "/ngsi-ld/v1/entityOperations/upsert/"
					)
					.ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
					.putHeader("Content-Type", "application/ld+json")
					.putHeader("Fiware-Service", o.getNgsildTenant())
					.putHeader("Fiware-ServicePath", o.getNgsildPath())
					.putHeader("NGSILD-Tenant", o.getNgsildTenant())
					.putHeader("NGSILD-Path", o.getNgsildPath())
					.sendJson(entityArray)
					.expecting(HttpResponseExpectation.SC_NO_CONTENT.or(HttpResponseExpectation.SC_CREATED)).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("cbUpsertEntity failed. "), ex);
				promise.fail(ex);
			});
		} catch(Throwable ex) {
			LOG.error(String.format("cbUpsertEntity failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<JsonObject> ngsildGetEntity(FishingDock o) {
		Promise<JsonObject> promise = Promise.promise();
		try {
			String entityName = o.getName();
			String entityType = FishingDock.CLASS_SIMPLE_NAME;
			String entityId = o.getId();
			String ngsildUri = String.format("/ngsi-ld/v1/entities/%s", urlEncode(entityId));
			String ngsildContext = config.getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT);
			String link = String.format("<%s>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"", ngsildContext);

			webClient.get(
					Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
					, config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
					, ngsildUri
					)
					.ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
					.putHeader("Content-Type", "application/ld+json")
					.putHeader("Fiware-Service", o.getNgsildTenant())
					.putHeader("Fiware-ServicePath", o.getNgsildPath())
					.putHeader("NGSILD-Tenant", o.getNgsildTenant())
					.putHeader("NGSILD-Path", o.getNgsildPath())
					.putHeader("Link", link)
					.putHeader("Accept", "*/*")
					.send()
					.expecting(HttpResponseExpectation.SC_OK.or(HttpResponseExpectation.SC_NOT_FOUND)).onSuccess(entityResponse -> {
				JsonObject entity = entityResponse.bodyAsJsonObject();
				entity.remove("NGSILD data");
				promise.complete(entity);
			}).onFailure(ex -> {
				LOG.error(String.format("postIotServiceFuture failed. "), ex);
				promise.fail(ex);
			});
		} catch(Throwable ex) {
			LOG.error(String.format("postIotServiceFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> cbDeleteEntity(FishingDock o) {
		Promise<Void> promise = Promise.promise();
		try {
			webClient.delete(
					Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
					, config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
					, String.format("/ngsi-ld/v1/entities/%s", urlEncode(o.getId()))
					)
					.ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
					.putHeader("Content-Type", "application/ld+json")
					.putHeader("Fiware-Service", o.getNgsildTenant())
					.putHeader("Fiware-ServicePath", o.getNgsildPath())
					.putHeader("NGSILD-Tenant", o.getNgsildTenant())
					.putHeader("NGSILD-Path", o.getNgsildPath())
					.send()
					.expecting(HttpResponseExpectation.SC_NO_CONTENT).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				if("Response status code 404 is not equal to 204".equals(ex.getMessage())) {
					promise.complete();
				} else {
					LOG.error(String.format("cbDeleteEntity failed. "), ex);
					promise.fail(ex);
				}
			});
		} catch(Throwable ex) {
			LOG.error(String.format("cbDeleteEntity failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> relateFishingDock(FishingDock o) {
		Promise<Void> promise = Promise.promise();
		promise.complete();
		return promise.future();
	}

	public String searchVar(String varIndexed) {
		return FishingDock.searchVarFishingDock(varIndexed);
	}

	@Override
	public String getClassApiAddress() {
		return FishingDock.CLASS_API_ADDRESS_FishingDock;
	}

	public Future<FishingDock> indexFishingDock(FishingDock o) {
		Promise<FishingDock> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			JsonObject json = new JsonObject();
			JsonObject add = new JsonObject();
			json.put("add", add);
			JsonObject doc = new JsonObject();
			add.put("doc", doc);
			o.indexFishingDock(doc);
			String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
			Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
			String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
			Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
			Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
			Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
				if(softCommit == null && commitWithin == null)
					softCommit = true;
				else if(softCommit == null)
					softCommit = false;
			String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
			webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
				promise.complete(o);
			}).onFailure(ex -> {
				LOG.error(String.format("indexFishingDock failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingDock> unindexFishingDock(FishingDock o) {
		Promise<FishingDock> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				JsonObject json = new JsonObject();
				JsonObject delete = new JsonObject();
				json.put("delete", delete);
				String query = String.format("filter(%s:%s)", FishingDock.VAR_solrId, o.obtainForClass(FishingDock.VAR_solrId));
				delete.put("query", query);
				String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
				String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
				String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
				String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
				Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
				Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					else if(softCommit == null)
						softCommit = false;
				String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
				webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
					promise.complete(o);
				}).onFailure(ex -> {
					LOG.error(String.format("unindexFishingDock failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("unindexFishingDock failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("unindexFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> refreshFishingDock(FishingDock o) {
		Promise<Void> promise = Promise.promise();
		SiteRequest siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < solrIds.size(); i++) {
					String solrId2 = solrIds.get(i);
					String classSimpleName2 = classes.get(i);

					if("TimeZone".equals(classSimpleName2) && solrId2 != null) {
						SearchList<TimeZone> searchList2 = new SearchList<TimeZone>();
						searchList2.setStore(true);
						searchList2.q("*:*");
						searchList2.setC(TimeZone.class);
						searchList2.fq("solrId:" + solrId2);
						searchList2.rows(1L);
						futures.add(Future.future(promise2 -> {
							searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
								TimeZone o2 = searchList2.getList().stream().findFirst().orElse(null);
								if(o2 != null) {
									JsonObject params = new JsonObject();
									params.put("body", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("path", new JsonObject());
									params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("solrId:" + solrId2)).put("var", new JsonArray().add("refresh:false")));
									JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request("smart-aquaculture-enUS-TimeZone", json, new DeliveryOptions().addHeader("action", "patchTimeZoneFuture")).onSuccess(c -> {
										JsonObject responseMessage = (JsonObject)c.body();
										Integer statusCode = responseMessage.getInteger("statusCode");
										if(statusCode.equals(200))
											promise2.complete();
										else
											promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
						}));
					}
				}

				CompositeFuture.all(futures).onSuccess(b -> {
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
					query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk())).put("var", new JsonArray().add("refresh:false"));
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request(FishingDock.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchFishingDockFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
						Integer statusCode = responseMessage.getInteger("statusCode");
						if(statusCode.equals(200))
							promise.complete();
						else
							promise.fail(new RuntimeException(responseMessage.getString("statusMessage")));
					}).onFailure(ex -> {
						LOG.error("Refresh relations failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Refresh relations failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("refreshFishingDock failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public Future<JsonObject> generatePageBody(ComputateSiteRequest siteRequest, Map<String, Object> ctx, String templatePath, String classSimpleName) {
		Promise<JsonObject> promise = Promise.promise();
		try {
			Map<String, Object> result = (Map<String, Object>)ctx.get("result");
			SiteRequest siteRequest2 = (SiteRequest)siteRequest;
			String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);
			FishingDock page = new FishingDock();
			page.setSiteRequest_((SiteRequest)siteRequest);

			page.persistForClass(FishingDock.VAR_name, FishingDock.staticSetName(siteRequest2, (String)result.get(FishingDock.VAR_name)));
			page.persistForClass(FishingDock.VAR_address, FishingDock.staticSetAddress(siteRequest2, (String)result.get(FishingDock.VAR_address)));
			page.persistForClass(FishingDock.VAR_description, FishingDock.staticSetDescription(siteRequest2, (String)result.get(FishingDock.VAR_description)));
			page.persistForClass(FishingDock.VAR_location, FishingDock.staticSetLocation(siteRequest2, (String)result.get(FishingDock.VAR_location)));
			page.persistForClass(FishingDock.VAR_created, FishingDock.staticSetCreated(siteRequest2, (String)result.get(FishingDock.VAR_created), Optional.ofNullable(page.getTimeZone()).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")))));
			page.persistForClass(FishingDock.VAR_timeZone, FishingDock.staticSetTimeZone(siteRequest2, (String)result.get(FishingDock.VAR_timeZone)));
			page.persistForClass(FishingDock.VAR_id, FishingDock.staticSetId(siteRequest2, (String)result.get(FishingDock.VAR_id)));
			page.persistForClass(FishingDock.VAR_archived, FishingDock.staticSetArchived(siteRequest2, (String)result.get(FishingDock.VAR_archived)));
			page.persistForClass(FishingDock.VAR_ngsildTenant, FishingDock.staticSetNgsildTenant(siteRequest2, (String)result.get(FishingDock.VAR_ngsildTenant)));
			page.persistForClass(FishingDock.VAR_ngsildPath, FishingDock.staticSetNgsildPath(siteRequest2, (String)result.get(FishingDock.VAR_ngsildPath)));
			page.persistForClass(FishingDock.VAR_areaServed, FishingDock.staticSetAreaServed(siteRequest2, (String)result.get(FishingDock.VAR_areaServed)));
			page.persistForClass(FishingDock.VAR_ngsildContext, FishingDock.staticSetNgsildContext(siteRequest2, (String)result.get(FishingDock.VAR_ngsildContext)));
			page.persistForClass(FishingDock.VAR_ngsildData, FishingDock.staticSetNgsildData(siteRequest2, (String)result.get(FishingDock.VAR_ngsildData)));
			page.persistForClass(FishingDock.VAR_sessionId, FishingDock.staticSetSessionId(siteRequest2, (String)result.get(FishingDock.VAR_sessionId)));
			page.persistForClass(FishingDock.VAR_color, FishingDock.staticSetColor(siteRequest2, (String)result.get(FishingDock.VAR_color)));
			page.persistForClass(FishingDock.VAR_userKey, FishingDock.staticSetUserKey(siteRequest2, (String)result.get(FishingDock.VAR_userKey)));
			page.persistForClass(FishingDock.VAR_objectTitle, FishingDock.staticSetObjectTitle(siteRequest2, (String)result.get(FishingDock.VAR_objectTitle)));
			page.persistForClass(FishingDock.VAR_displayPage, FishingDock.staticSetDisplayPage(siteRequest2, (String)result.get(FishingDock.VAR_displayPage)));

			page.promiseDeepForClass((SiteRequest)siteRequest).onSuccess(o -> {
				try {
					JsonObject data = JsonObject.mapFrom(o);
					ctx.put("result", data.getMap());
					promise.complete(data);
				} catch(Exception ex) {
					LOG.error(String.format(importModelFail, classSimpleName), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("generatePageBody failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("generatePageBody failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
