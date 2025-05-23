package org.computate.smartaquaculture.model.fiware.fishingtrip;

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
import org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTripPage;


/**
 * Translate: false
 * Generated: true
 **/
public class FishingTripEnUSGenApiServiceImpl extends BaseApiServiceImpl implements FishingTripEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(FishingTripEnUSGenApiServiceImpl.class);

	// Search //

	@Override
	public void searchFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "GET"));
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
						searchFishingTripList(siteRequest, false, true, false).onSuccess(listFishingTrip -> {
							response200SearchFishingTrip(listFishingTrip).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchFishingTrip succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchFishingTrip failed. ", ex2));
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
				LOG.error(String.format("searchFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200SearchFishingTrip(SearchList<FishingTrip> listFishingTrip) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
			List<String> fls = listFishingTrip.getRequest().getFields();
			JsonObject json = new JsonObject();
			JsonArray l = new JsonArray();
			listFishingTrip.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					for(String fieldName : json2.fieldNames()) {
						String v = FishingTrip.varIndexedFishingTrip(fieldName);
						if(v != null)
							fieldNames.add(FishingTrip.varIndexedFishingTrip(fieldName));
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
			response200Search(listFishingTrip.getRequest(), listFishingTrip.getResponse(), json);
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchFishingTrip(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
					responsePivotSearchFishingTrip(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// GET //

	@Override
	public void getFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "GET"));
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
						searchFishingTripList(siteRequest, false, true, false).onSuccess(listFishingTrip -> {
							response200GETFishingTrip(listFishingTrip).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("getFishingTrip succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("getFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("getFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("getFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("getFishingTrip failed. ", ex2));
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
				LOG.error(String.format("getFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200GETFishingTrip(SearchList<FishingTrip> listFishingTrip) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
			JsonObject json = JsonObject.mapFrom(listFishingTrip.getList().stream().findFirst().orElse(null));
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200GETFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PATCH //

	@Override
	public void patchFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchFishingTrip started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "PATCH"));
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
					if(authorizationDecisionResponse.failed() || !scopes.contains("PATCH")) {
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
						searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingTrip.getRequest().getRows());
								apiRequest.setNumFound(listFishingTrip.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingTrip.first());
								apiRequest.setId(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk().toString()).orElse(null));
								apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
								eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());

								listPATCHFishingTrip(apiRequest, listFishingTrip).onSuccess(e -> {
									response200PATCHFishingTrip(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("patchFishingTrip succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("patchFishingTrip failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("patchFishingTrip failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("patchFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("patchFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("patchFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchFishingTrip failed. ", ex2));
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
				LOG.error(String.format("patchFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listPATCHFishingTrip(ApiRequest apiRequest, SearchList<FishingTrip> listFishingTrip) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
		listFishingTrip.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingTrip o2 = jsonObject.mapTo(FishingTrip.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				patchFishingTripFuture(o2, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHFishingTrip failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingTrip.next().onSuccess(next -> {
				if(next) {
					listPATCHFishingTrip(apiRequest, listFishingTrip).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPATCHFishingTrip failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHFishingTrip failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
				searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
					try {
						FishingTrip o = listFishingTrip.first();
						if(o != null && listFishingTrip.getResponse().getResponse().getNumFound() == 1) {
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
							apiRequest.setId(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk().toString()).orElse(null));
							apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
							JsonObject jsonObject = JsonObject.mapFrom(o);
							FishingTrip o2 = jsonObject.mapTo(FishingTrip.class);
							o2.setSiteRequest_(siteRequest);
							patchFishingTripFuture(o2, false).onSuccess(o3 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchFishingTrip failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchFishingTrip failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchFishingTrip failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingTrip> patchFishingTripFuture(FishingTrip o, Boolean inheritPrimaryKey) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingTrip> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingTrip> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingTrip(siteRequest).onSuccess(a -> {
					sqlPATCHFishingTrip(o, inheritPrimaryKey).onSuccess(fishingTrip -> {
						persistFishingTrip(fishingTrip, true).onSuccess(c -> {
							relateFishingTrip(fishingTrip).onSuccess(d -> {
								indexFishingTrip(fishingTrip).onSuccess(o2 -> {
									if(apiRequest != null) {
										apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
										if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
											o2.apiRequestFishingTrip();
											if(apiRequest.getVars().size() > 0)
												eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
										}
									}
									promise1.complete(fishingTrip);
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
			}).compose(fishingTrip -> {
				Promise<FishingTrip> promise2 = Promise.promise();
				refreshFishingTrip(fishingTrip).onSuccess(a -> {
					promise2.complete(fishingTrip);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingTrip -> {
				promise.complete(fishingTrip);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchFishingTripFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingTrip> sqlPATCHFishingTrip(FishingTrip o, Boolean inheritPrimaryKey) {
		Promise<FishingTrip> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE FishingTrip SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			FishingTrip o2 = new FishingTrip();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setTimeZone":
							o2.setTimeZone(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_timeZone + "=$" + num);
							num++;
							bParams.add(o2.sqlTimeZone());
						break;
					case "setCreated":
							o2.setCreated(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_created + "=$" + num);
							num++;
							bParams.add(o2.sqlCreated());
						break;
					case "setDepartureDate":
							o2.setDepartureDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_departureDate + "=$" + num);
							num++;
							bParams.add(o2.sqlDepartureDate());
						break;
					case "setArrivalDate":
							o2.setArrivalDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_arrivalDate + "=$" + num);
							num++;
							bParams.add(o2.sqlArrivalDate());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setName":
							o2.setName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_name + "=$" + num);
							num++;
							bParams.add(o2.sqlName());
						break;
					case "setDescription":
							o2.setDescription(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_description + "=$" + num);
							num++;
							bParams.add(o2.sqlDescription());
						break;
					case "setSessionId":
							o2.setSessionId(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_sessionId + "=$" + num);
							num++;
							bParams.add(o2.sqlSessionId());
						break;
					case "setUserKey":
							o2.setUserKey(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_userKey + "=$" + num);
							num++;
							bParams.add(o2.sqlUserKey());
						break;
					case "setObjectTitle":
							o2.setObjectTitle(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_objectTitle + "=$" + num);
							num++;
							bParams.add(o2.sqlObjectTitle());
						break;
					case "setDisplayPage":
							o2.setDisplayPage(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(FishingTrip.VAR_displayPage + "=$" + num);
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
						RuntimeException ex2 = new RuntimeException("value FishingTrip failed", ex);
						LOG.error(String.format("relateFishingTrip failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					FishingTrip o3 = new FishingTrip();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHFishingTrip failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PATCHFishingTrip(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postFishingTrip started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "POST"));
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
					if(authorizationDecisionResponse.failed() || !scopes.contains("POST")) {
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
						eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
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
						eventBus.request(FishingTrip.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postFishingTripFuture")).onSuccess(a -> {
							JsonObject responseMessage = (JsonObject)a.body();
							JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
							apiRequest.setPk(Long.parseLong(responseBody.getString("pk")));
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
							LOG.debug(String.format("postFishingTrip succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("postFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("postFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postFishingTrip failed. ", ex2));
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
				LOG.error(String.format("postFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	@Override
	public void postFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}
				postFishingTripFuture(siteRequest, false).onSuccess(o -> {
					eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
				}).onFailure(ex -> {
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Throwable ex) {
				LOG.error(String.format("postFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postFishingTrip failed. ", ex2));
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
				LOG.error(String.format("postFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<FishingTrip> postFishingTripFuture(SiteRequest siteRequest, Boolean pk) {
		Promise<FishingTrip> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<FishingTrip> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingTrip(siteRequest).onSuccess(a -> {
					createFishingTrip(siteRequest).onSuccess(fishingTrip -> {
						sqlPOSTFishingTrip(fishingTrip, pk).onSuccess(b -> {
							persistFishingTrip(fishingTrip, false).onSuccess(c -> {
								relateFishingTrip(fishingTrip).onSuccess(d -> {
									indexFishingTrip(fishingTrip).onSuccess(o2 -> {
										promise1.complete(fishingTrip);
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
			}).compose(fishingTrip -> {
				Promise<FishingTrip> promise2 = Promise.promise();
				refreshFishingTrip(fishingTrip).onSuccess(a -> {
					try {
						ApiRequest apiRequest = siteRequest.getApiRequest_();
						if(apiRequest != null) {
							apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
							fishingTrip.apiRequestFishingTrip();
							eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
						}
						promise2.complete(fishingTrip);
					} catch(Exception ex) {
						LOG.error(String.format("postFishingTripFuture failed. "), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingTrip -> {
				try {
					ApiRequest apiRequest = siteRequest.getApiRequest_();
					if(apiRequest != null) {
						apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
						fishingTrip.apiRequestFishingTrip();
						eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
					}
					promise.complete(fishingTrip);
				} catch(Exception ex) {
					LOG.error(String.format("postFishingTripFuture failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postFishingTripFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingTrip> sqlPOSTFishingTrip(FishingTrip o, Boolean inheritPrimaryKey) {
		Promise<FishingTrip> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE FishingTrip SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingTrip o2 = new FishingTrip();
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
					case FishingTrip.VAR_timeZone:
						o2.setTimeZone(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_timeZone + "=$" + num);
						num++;
						bParams.add(o2.sqlTimeZone());
						break;
					case FishingTrip.VAR_created:
						o2.setCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_created + "=$" + num);
						num++;
						bParams.add(o2.sqlCreated());
						break;
					case FishingTrip.VAR_departureDate:
						o2.setDepartureDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_departureDate + "=$" + num);
						num++;
						bParams.add(o2.sqlDepartureDate());
						break;
					case FishingTrip.VAR_arrivalDate:
						o2.setArrivalDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_arrivalDate + "=$" + num);
						num++;
						bParams.add(o2.sqlArrivalDate());
						break;
					case FishingTrip.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case FishingTrip.VAR_name:
						o2.setName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_name + "=$" + num);
						num++;
						bParams.add(o2.sqlName());
						break;
					case FishingTrip.VAR_description:
						o2.setDescription(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_description + "=$" + num);
						num++;
						bParams.add(o2.sqlDescription());
						break;
					case FishingTrip.VAR_sessionId:
						o2.setSessionId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_sessionId + "=$" + num);
						num++;
						bParams.add(o2.sqlSessionId());
						break;
					case FishingTrip.VAR_userKey:
						o2.setUserKey(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_userKey + "=$" + num);
						num++;
						bParams.add(o2.sqlUserKey());
						break;
					case FishingTrip.VAR_objectTitle:
						o2.setObjectTitle(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_objectTitle + "=$" + num);
						num++;
						bParams.add(o2.sqlObjectTitle());
						break;
					case FishingTrip.VAR_displayPage:
						o2.setDisplayPage(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(FishingTrip.VAR_displayPage + "=$" + num);
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
						RuntimeException ex2 = new RuntimeException("value FishingTrip failed", ex);
						LOG.error(String.format("relateFishingTrip failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete(o2);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTFishingTrip failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200POSTFishingTrip(FishingTrip o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// DELETE //

	@Override
	public void deleteFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("deleteFishingTrip started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "DELETE"));
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
					if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
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
						searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingTrip.getRequest().getRows());
								apiRequest.setNumFound(listFishingTrip.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingTrip.first());
								apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
								eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());

								listDELETEFishingTrip(apiRequest, listFishingTrip).onSuccess(e -> {
									response200DELETEFishingTrip(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("deleteFishingTrip succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("deleteFishingTrip failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("deleteFishingTrip failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("deleteFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("deleteFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("deleteFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("deleteFishingTrip failed. ", ex2));
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
				LOG.error(String.format("deleteFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listDELETEFishingTrip(ApiRequest apiRequest, SearchList<FishingTrip> listFishingTrip) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
		listFishingTrip.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingTrip o2 = jsonObject.mapTo(FishingTrip.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				deleteFishingTripFuture(o).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listDELETEFishingTrip failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingTrip.next().onSuccess(next -> {
				if(next) {
					listDELETEFishingTrip(apiRequest, listFishingTrip).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listDELETEFishingTrip failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listDELETEFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listDELETEFishingTrip failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void deleteFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
				searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
					try {
						FishingTrip o = listFishingTrip.first();
						if(o != null && listFishingTrip.getResponse().getResponse().getNumFound() == 1) {
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
							apiRequest.setId(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk().toString()).orElse(null));
							apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
							deleteFishingTripFuture(o).onSuccess(o2 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("deleteFishingTrip failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("deleteFishingTrip failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("deleteFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("deleteFishingTrip failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingTrip> deleteFishingTripFuture(FishingTrip o) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingTrip> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingTrip> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingTrip(siteRequest).onSuccess(a -> {
					sqlDELETEFishingTrip(o).onSuccess(fishingTrip -> {
						relateFishingTrip(o).onSuccess(d -> {
							unindexFishingTrip(o).onSuccess(o2 -> {
								if(apiRequest != null) {
									apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
									if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
										o2.apiRequestFishingTrip();
										if(apiRequest.getVars().size() > 0)
											eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
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
			}).compose(fishingTrip -> {
				Promise<FishingTrip> promise2 = Promise.promise();
				refreshFishingTrip(o).onSuccess(a -> {
					promise2.complete(o);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingTrip -> {
				promise.complete(fishingTrip);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("deleteFishingTripFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlDELETEFishingTrip(FishingTrip o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("DELETE FROM FishingTrip ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingTrip o2 = new FishingTrip();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
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
					RuntimeException ex2 = new RuntimeException("value FishingTrip failed", ex);
					LOG.error(String.format("unrelateFishingTrip failed. "), ex2);
					a.handle(Future.failedFuture(ex2));
				});
			}));
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlDELETEFishingTrip failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlDELETEFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlDELETEFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200DELETEFishingTrip(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200DELETEFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PUTImport //

	@Override
	public void putimportFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportFishingTrip started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "PUT"));
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
					if(authorizationDecisionResponse.failed() || !scopes.contains("PUT")) {
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
						eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
						varsFishingTrip(siteRequest).onSuccess(d -> {
							listPUTImportFishingTrip(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportFishingTrip(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportFishingTrip succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportFishingTrip failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("putimportFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportFishingTrip failed. ", ex2));
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
				LOG.error(String.format("putimportFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listPUTImportFishingTrip(ApiRequest apiRequest, SiteRequest siteRequest) {
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
					eventBus.request(FishingTrip.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportFishingTripFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportFishingTrip failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				String pk = Optional.ofNullable(body.getString(FishingTrip.VAR_pk)).orElse(body.getString(FishingTrip.VAR_solrId));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}
				pgPool.getConnection().onSuccess(sqlConnection -> {
					String sqlQuery = String.format("select * from %s WHERE pk=$1", FishingTrip.CLASS_SIMPLE_NAME);
					sqlConnection.preparedQuery(sqlQuery)
							.execute(Tuple.tuple(Arrays.asList(pk))
							).onSuccess(result -> {
						sqlConnection.close().onSuccess(a -> {
							try {
								if(result.size() >= 1) {
									FishingTrip o = new FishingTrip();
									o.setSiteRequest_(siteRequest);
									for(Row definition : result.value()) {
										for(Integer i = 0; i < definition.size(); i++) {
											try {
												String columnName = definition.getColumnName(i);
												Object columnValue = definition.getValue(i);
												o.persistForClass(columnName, columnValue);
											} catch(Exception e) {
												LOG.error(String.format("persistFishingTrip failed. "), e);
											}
										}
									}
									FishingTrip o2 = new FishingTrip();
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
											if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
												body2.put("set" + StringUtils.capitalize(f), bodyVal);
										}
									}
									for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
										if(!body.fieldNames().contains(f)) {
											if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
												body2.putNull("set" + StringUtils.capitalize(f));
										}
									}
									if(result.size() >= 1) {
										apiRequest.setOriginal(o);
										apiRequest.setId(Optional.ofNullable(o.getPk()).map(v -> v.toString()).orElse(null));
										apiRequest.setPk(o.getPk());
									}
									siteRequest.setJsonObject(body2);
									patchFishingTripFuture(o, true).onSuccess(b -> {
										LOG.debug("Import FishingTrip {} succeeded, modified FishingTrip. ", body.getValue(FishingTrip.VAR_pk));
										eventHandler.handle(Future.succeededFuture());
									}).onFailure(ex -> {
										LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
										eventHandler.handle(Future.failedFuture(ex));
									});
								} else {
									postFishingTripFuture(siteRequest, true).onSuccess(b -> {
										LOG.debug("Import FishingTrip {} succeeded, created new FishingTrip. ", body.getValue(FishingTrip.VAR_pk));
										eventHandler.handle(Future.succeededFuture());
									}).onFailure(ex -> {
										LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
										eventHandler.handle(Future.failedFuture(ex));
									});
								}
							} catch(Exception ex) {
								LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							}
						}).onFailure(ex -> {
							LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
							eventHandler.handle(Future.failedFuture(ex));
						});
					}).onFailure(ex -> {
						LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					});
				}).onFailure(ex -> {
					LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportFishingTripFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportFishingTrip failed. ", ex2));
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
				LOG.error(String.format("putimportFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTImportFishingTrip(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// SearchPage //

	@Override
	public void searchpageFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "GET"));
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
						searchFishingTripList(siteRequest, false, true, false).onSuccess(listFishingTrip -> {
							response200SearchPageFishingTrip(listFishingTrip).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("searchpageFishingTrip succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("searchpageFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchpageFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageFishingTrip failed. ", ex2));
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
				LOG.error(String.format("searchpageFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public void searchpageFishingTripPageInit(FishingTripPage page, SearchList<FishingTrip> listFishingTrip) {
	}

	public String templateSearchPageFishingTrip(ServiceRequest serviceRequest) {
		return "en-us/search/fishing-trip/FishingTripSearchPage.htm";
	}
	public Future<ServiceResponse> response200SearchPageFishingTrip(SearchList<FishingTrip> listFishingTrip) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
			String pageTemplateUri = templateSearchPageFishingTrip(siteRequest.getServiceRequest());
			String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
			Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
			String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
			FishingTripPage page = new FishingTripPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listFishingTrip.size() >= 1)
				siteRequest.setRequestPk(listFishingTrip.get(0).getPk());
			page.setSearchListFishingTrip_(listFishingTrip);
			page.setSiteRequest_(siteRequest);
			page.setServiceRequest(siteRequest.getServiceRequest());
			page.setWebClient(webClient);
			page.setVertx(vertx);
			page.promiseDeepFishingTripPage(siteRequest).onSuccess(a -> {
				try {
					JsonObject ctx = ComputateConfigKeys.getPageContext(config);
					ctx.mergeIn(JsonObject.mapFrom(page));
					String renderedTemplate = jinjava.render(template, ctx.getMap());
					Buffer buffer = Buffer.buffer(renderedTemplate);
					promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
				} catch(Exception ex) {
					LOG.error(String.format("response200SearchPageFishingTrip failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchPageFishingTrip(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
					responsePivotSearchPageFishingTrip(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// EditPage //

	@Override
	public void editpageFishingTrip(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "GET"));
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
						searchFishingTripList(siteRequest, false, true, false).onSuccess(listFishingTrip -> {
							response200EditPageFishingTrip(listFishingTrip).onSuccess(response -> {
								eventHandler.handle(Future.succeededFuture(response));
								LOG.debug(String.format("editpageFishingTrip succeeded. "));
							}).onFailure(ex -> {
								LOG.error(String.format("editpageFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("editpageFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("editpageFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("editpageFishingTrip failed. ", ex2));
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
				LOG.error(String.format("editpageFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public void editpageFishingTripPageInit(FishingTripPage page, SearchList<FishingTrip> listFishingTrip) {
	}

	public String templateEditPageFishingTrip(ServiceRequest serviceRequest) {
		return "en-us/edit/fishing-trip/FishingTripEditPage.htm";
	}
	public Future<ServiceResponse> response200EditPageFishingTrip(SearchList<FishingTrip> listFishingTrip) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
			String pageTemplateUri = templateEditPageFishingTrip(siteRequest.getServiceRequest());
			String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
			Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
			String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
			FishingTripPage page = new FishingTripPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listFishingTrip.size() >= 1)
				siteRequest.setRequestPk(listFishingTrip.get(0).getPk());
			page.setSearchListFishingTrip_(listFishingTrip);
			page.setSiteRequest_(siteRequest);
			page.setServiceRequest(siteRequest.getServiceRequest());
			page.setWebClient(webClient);
			page.setVertx(vertx);
			page.promiseDeepFishingTripPage(siteRequest).onSuccess(a -> {
				try {
					JsonObject ctx = ComputateConfigKeys.getPageContext(config);
					ctx.mergeIn(JsonObject.mapFrom(page));
					String renderedTemplate = jinjava.render(template, ctx.getMap());
					Buffer buffer = Buffer.buffer(renderedTemplate);
					promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
				} catch(Exception ex) {
					LOG.error(String.format("response200EditPageFishingTrip failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200EditPageFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotEditPageFishingTrip(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
					responsePivotEditPageFishingTrip(pivotFields2, pivotArray2);
				}
			}
		}
	}

	// DELETEFilter //

	@Override
	public void deletefilterFishingTrip(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("deletefilterFishingTrip started. "));
		Boolean classPublicRead = false;
		user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
			String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
			MultiMap form = MultiMap.caseInsensitiveMultiMap();
			form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
			form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
			form.add("response_mode", "permissions");
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "GET"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "POST"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "DELETE"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PATCH"));
			form.add("permission", String.format("%s#%s", FishingTrip.CLASS_SIMPLE_NAME, "PUT"));
			if(pk != null)
				form.add("permission", String.format("%s-%s#%s", FishingTrip.CLASS_SIMPLE_NAME, pk, "DELETE"));
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
					if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
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
						searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
							try {
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listFishingTrip.getRequest().getRows());
								apiRequest.setNumFound(listFishingTrip.getResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listFishingTrip.first());
								apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
								eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());

								listDELETEFilterFishingTrip(apiRequest, listFishingTrip).onSuccess(e -> {
									response200DELETEFilterFishingTrip(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("deletefilterFishingTrip succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							} catch(Exception ex) {
								LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
								error(siteRequest, eventHandler, ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}
				} catch(Exception ex) {
					LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
					error(null, eventHandler, ex);
				}
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("deletefilterFishingTrip failed. ", ex2));
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
				LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<Void> listDELETEFilterFishingTrip(ApiRequest apiRequest, SearchList<FishingTrip> listFishingTrip) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequest siteRequest = listFishingTrip.getSiteRequest_(SiteRequest.class);
		listFishingTrip.getList().forEach(o -> {
			SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
			siteRequest2.setScopes(siteRequest.getScopes());
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			JsonObject jsonObject = JsonObject.mapFrom(o);
			FishingTrip o2 = jsonObject.mapTo(FishingTrip.class);
			o2.setSiteRequest_(siteRequest2);
			futures.add(Future.future(promise1 -> {
				deletefilterFishingTripFuture(o).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listDELETEFilterFishingTrip failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			listFishingTrip.next().onSuccess(next -> {
				if(next) {
					listDELETEFilterFishingTrip(apiRequest, listFishingTrip).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listDELETEFilterFishingTrip failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listDELETEFilterFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listDELETEFilterFishingTrip failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void deletefilterFishingTripFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
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
				searchFishingTripList(siteRequest, false, true, true).onSuccess(listFishingTrip -> {
					try {
						FishingTrip o = listFishingTrip.first();
						if(o != null && listFishingTrip.getResponse().getResponse().getNumFound() == 1) {
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
							apiRequest.setId(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk().toString()).orElse(null));
							apiRequest.setPk(Optional.ofNullable(listFishingTrip.first()).map(o2 -> o2.getPk()).orElse(null));
							deletefilterFishingTripFuture(o).onSuccess(o2 -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("deletefilterFishingTrip failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<FishingTrip> deletefilterFishingTripFuture(FishingTrip o) {
		SiteRequest siteRequest = o.getSiteRequest_();
		Promise<FishingTrip> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			Promise<FishingTrip> promise1 = Promise.promise();
			pgPool.withTransaction(sqlConnection -> {
				siteRequest.setSqlConnection(sqlConnection);
				varsFishingTrip(siteRequest).onSuccess(a -> {
					sqlDELETEFilterFishingTrip(o).onSuccess(fishingTrip -> {
						relateFishingTrip(o).onSuccess(d -> {
							unindexFishingTrip(o).onSuccess(o2 -> {
								if(apiRequest != null) {
									apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
									if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
										o2.apiRequestFishingTrip();
										if(apiRequest.getVars().size() > 0)
											eventBus.publish("websocketFishingTrip", JsonObject.mapFrom(apiRequest).toString());
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
			}).compose(fishingTrip -> {
				Promise<FishingTrip> promise2 = Promise.promise();
				refreshFishingTrip(o).onSuccess(a -> {
					promise2.complete(o);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(fishingTrip -> {
				promise.complete(fishingTrip);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("deletefilterFishingTripFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlDELETEFilterFishingTrip(FishingTrip o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("DELETE FROM FishingTrip ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			FishingTrip o2 = new FishingTrip();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
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
					RuntimeException ex2 = new RuntimeException("value FishingTrip failed", ex);
					LOG.error(String.format("unrelateFishingTrip failed. "), ex2);
					a.handle(Future.failedFuture(ex2));
				});
			}));
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlDELETEFilterFishingTrip failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlDELETEFilterFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlDELETEFilterFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200DELETEFilterFishingTrip(SiteRequest siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			if(json == null) {
				String pk = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("pk");
						String m = String.format("%s %s not found", "fishing trip", pk);
				promise.complete(new ServiceResponse(404
						, m
						, Buffer.buffer(new JsonObject().put("message", m).encodePrettily()), null));
			} else {
				promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
			}
		} catch(Exception ex) {
			LOG.error(String.format("response200DELETEFilterFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// General //

	public Future<FishingTrip> createFishingTrip(SiteRequest siteRequest) {
		Promise<FishingTrip> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

			sqlConnection.preparedQuery("INSERT INTO FishingTrip(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				FishingTrip o = new FishingTrip();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error("createFishingTrip failed. ", ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchFishingTripQ(SearchList<FishingTrip> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchFishingTripFq(SearchList<FishingTrip> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : FishingTrip.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : FishingTrip.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + SearchTool.escapeQueryChars(FishingTrip.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchFishingTripSort(SearchList<FishingTrip> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.sort(varIndexed, valueIndexed);
	}

	public void searchFishingTripRows(SearchList<FishingTrip> searchList, Long valueRows) {
			searchList.rows(valueRows != null ? valueRows : 10L);
	}

	public void searchFishingTripStart(SearchList<FishingTrip> searchList, Long valueStart) {
		searchList.start(valueStart);
	}

	public void searchFishingTripVar(SearchList<FishingTrip> searchList, String var, String value) {
		searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
	}

	public void searchFishingTripUri(SearchList<FishingTrip> searchList) {
	}

	public Future<ServiceResponse> varsFishingTrip(SiteRequest siteRequest) {
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
					LOG.error(String.format("searchFishingTrip failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<FishingTrip>> searchFishingTripList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify) {
		Promise<SearchList<FishingTrip>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<FishingTrip> searchList = new SearchList<FishingTrip>();
			String facetRange = null;
			Date facetRangeStart = null;
			Date facetRangeEnd = null;
			String facetRangeGap = null;
			String statsField = null;
			String statsFieldIndexed = null;
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.q("*:*");
			searchList.setC(FishingTrip.class);
			searchList.setSiteRequest_(siteRequest);
			searchList.facetMinCount(1);
			if(entityList != null) {
				for(String v : entityList) {
					searchList.fl(FishingTrip.varIndexedFishingTrip(v));
				}
			}

			String pk = serviceRequest.getParams().getJsonObject("path").getString("pk");
			if(pk != null) {
				searchList.fq("pk_docvalues_long:" + SearchTool.escapeQueryChars(pk));
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
								varsIndexed[i] = FishingTrip.varIndexedFishingTrip(entityVar);
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
									varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
									String entityQ = searchFishingTripFq(searchList, entityVar, valueIndexed, varIndexed);
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
									varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
									String entityFq = searchFishingTripFq(searchList, entityVar, valueIndexed, varIndexed);
									mFq.appendReplacement(sb, entityFq);
								}
								if(!sb.isEmpty()) {
									mFq.appendTail(sb);
									searchList.fq(sb.toString());
								}
							} else if(paramName.equals("sort")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
								valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
								varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
								searchFishingTripSort(searchList, entityVar, valueIndexed, varIndexed);
							} else if(paramName.equals("start")) {
								valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchFishingTripStart(searchList, valueStart);
							} else if(paramName.equals("rows")) {
								valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
								searchFishingTripRows(searchList, valueRows);
							} else if(paramName.equals("stats")) {
								searchList.stats((Boolean)paramObject);
							} else if(paramName.equals("stats.field")) {
								Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
								if(mStats.find()) {
									String solrLocalParams = mStats.group(1);
									entityVar = mStats.group(2).trim();
									varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
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
									varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
									searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									facetRange = entityVar;
								}
							} else if(paramName.equals("facet.field")) {
								entityVar = (String)paramObject;
								varIndexed = FishingTrip.varIndexedFishingTrip(entityVar);
								if(varIndexed != null)
									searchList.facetField(varIndexed);
							} else if(paramName.equals("var")) {
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								searchFishingTripVar(searchList, entityVar, valueIndexed);
							} else if(paramName.equals("cursorMark")) {
								valueCursorMark = (String)paramObject;
								searchList.cursorMark((String)paramObject);
							}
						}
						searchFishingTripUri(searchList);
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
			searchFishingTrip2(siteRequest, populate, store, modify, searchList);
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
					String gap = "DAY";
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
						LOG.error(String.format("searchFishingTrip failed. "), ex);
						promise.fail(ex);
					});
				} else {
					promise.complete(searchList);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("searchFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchFishingTrip2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<FishingTrip> searchList) {
	}

	public Future<Void> persistFishingTrip(FishingTrip o, Boolean patch) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT * FROM FishingTrip WHERE pk=$1")
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
									LOG.error(String.format("persistFishingTrip failed. "), e);
								}
							}
						}
					}
					o.promiseDeepForClass(siteRequest).onSuccess(a -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("persistFishingTrip failed. "), ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("persistFishingTrip failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("persistFishingTrip failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("persistFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> relateFishingTrip(FishingTrip o) {
		Promise<Void> promise = Promise.promise();
			promise.complete();
		return promise.future();
	}

	public String searchVar(String varIndexed) {
		return FishingTrip.searchVarFishingTrip(varIndexed);
	}

	@Override
	public String getClassApiAddress() {
		return FishingTrip.CLASS_API_ADDRESS_FishingTrip;
	}

	public Future<FishingTrip> indexFishingTrip(FishingTrip o) {
		Promise<FishingTrip> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			JsonObject json = new JsonObject();
			JsonObject add = new JsonObject();
			json.put("add", add);
			JsonObject doc = new JsonObject();
			add.put("doc", doc);
			o.indexFishingTrip(doc);
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
				LOG.error(String.format("indexFishingTrip failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<FishingTrip> unindexFishingTrip(FishingTrip o) {
		Promise<FishingTrip> promise = Promise.promise();
		try {
			SiteRequest siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				JsonObject json = new JsonObject();
				JsonObject delete = new JsonObject();
				json.put("delete", delete);
				String query = String.format("filter(%s:%s)", FishingTrip.VAR_solrId, o.obtainForClass(FishingTrip.VAR_solrId));
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
					LOG.error(String.format("unindexFishingTrip failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("unindexFishingTrip failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("unindexFishingTrip failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> refreshFishingTrip(FishingTrip o) {
		Promise<Void> promise = Promise.promise();
		SiteRequest siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);
				}

				CompositeFuture.all(futures).onSuccess(b -> {
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
					params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
					params.put("form", new JsonObject());
					params.put("path", new JsonObject());
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
					eventBus.request(FishingTrip.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchFishingTripFuture")).onSuccess(c -> {
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
			LOG.error(String.format("refreshFishingTrip failed. "), ex);
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
			FishingTrip page = new FishingTrip();
			page.setSiteRequest_((SiteRequest)siteRequest);

			page.persistForClass(FishingTrip.VAR_timeZone, FishingTrip.staticSetTimeZone(siteRequest2, (String)result.get(FishingTrip.VAR_timeZone)));
			page.persistForClass(FishingTrip.VAR_created, FishingTrip.staticSetCreated(siteRequest2, (String)result.get(FishingTrip.VAR_created), Optional.ofNullable(page.getTimeZone()).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")))));
			page.persistForClass(FishingTrip.VAR_departureDate, FishingTrip.staticSetDepartureDate(siteRequest2, (String)result.get(FishingTrip.VAR_departureDate), Optional.ofNullable(page.getTimeZone()).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")))));
			page.persistForClass(FishingTrip.VAR_arrivalDate, FishingTrip.staticSetArrivalDate(siteRequest2, (String)result.get(FishingTrip.VAR_arrivalDate), Optional.ofNullable(page.getTimeZone()).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")))));
			page.persistForClass(FishingTrip.VAR_archived, FishingTrip.staticSetArchived(siteRequest2, (String)result.get(FishingTrip.VAR_archived)));
			page.persistForClass(FishingTrip.VAR_name, FishingTrip.staticSetName(siteRequest2, (String)result.get(FishingTrip.VAR_name)));
			page.persistForClass(FishingTrip.VAR_description, FishingTrip.staticSetDescription(siteRequest2, (String)result.get(FishingTrip.VAR_description)));
			page.persistForClass(FishingTrip.VAR_sessionId, FishingTrip.staticSetSessionId(siteRequest2, (String)result.get(FishingTrip.VAR_sessionId)));
			page.persistForClass(FishingTrip.VAR_userKey, FishingTrip.staticSetUserKey(siteRequest2, (String)result.get(FishingTrip.VAR_userKey)));
			page.persistForClass(FishingTrip.VAR_objectTitle, FishingTrip.staticSetObjectTitle(siteRequest2, (String)result.get(FishingTrip.VAR_objectTitle)));
			page.persistForClass(FishingTrip.VAR_displayPage, FishingTrip.staticSetDisplayPage(siteRequest2, (String)result.get(FishingTrip.VAR_displayPage)));

			page.promiseDeepForClass((SiteRequest)siteRequest).onSuccess(a -> {
				try {
					JsonObject data = JsonObject.mapFrom(result);
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
