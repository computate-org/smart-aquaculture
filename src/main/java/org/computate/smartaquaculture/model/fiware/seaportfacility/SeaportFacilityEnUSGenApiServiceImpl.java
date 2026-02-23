package org.computate.smartaquaculture.model.fiware.seaportfacility;

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
import org.computate.i18n.I18n;
import org.yaml.snakeyaml.Yaml;
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
import org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityPage;


/**
 * Translate: false
 * Generated: true
 **/
public class SeaportFacilityEnUSGenApiServiceImpl extends BaseApiServiceImpl implements SeaportFacilityEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(SeaportFacilityEnUSGenApiServiceImpl.class);

  // SearchPageFrFR //

  @Override
  public void searchpagefrfrSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("frFR");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200SearchPageFrFRSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchpagefrfrSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchpagefrfrSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchpagefrfrSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchpagefrfrSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpagefrfrSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpagefrfrSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("searchpagefrfrSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpagefrfrSeaportFacilityPageInit(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("frFRUrlSearchPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPageFrFR()));
    ctx.put("frFRUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPageFrFR()));
    ctx.put("frFRUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownloadFrFR()));

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageFrFRSeaportFacility(ServiceRequest serviceRequest, SeaportFacility result) {
    return "fr-fr/rechercher/installations-portuaires/SeaportFacilitySearchPage.htm";
  }
  public void templateSearchPageFrFRSeaportFacility(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SeaportFacility result = listSeaportFacility.first();
      String pageTemplateUri = templateUriSearchPageFrFRSeaportFacility(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "fr-fr/rechercher/installations-portuaires/SeaportFacilitySearchPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateSearchPageFrFRSeaportFacility failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageFrFRSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      SeaportFacilityPage page = new SeaportFacilityPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSeaportFacility.size() >= 1)
        siteRequest.setRequestPk(listSeaportFacility.get(0).getPk());
      page.setSearchListSeaportFacility_(listSeaportFacility);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSeaportFacilityPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpagefrfrSeaportFacilityPageInit(ctx, page, listSeaportFacility, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateSearchPageFrFRSeaportFacility(ctx, page, listSeaportFacility, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200SearchPageFrFRSeaportFacility failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageFrFRSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageFrFRSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageFrFRSeaportFacility(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageFrFRSeaportFacility(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPageFrFR //

  @Override
  public void editpagefrfrSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("frFR");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200EditPageFrFRSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("editpagefrfrSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("editpagefrfrSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("editpagefrfrSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
            });
            }
          } catch(Exception ex) {
            LOG.error(String.format("editpagefrfrSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpagefrfrSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpagefrfrSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("editpagefrfrSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpagefrfrSeaportFacilityPageInit(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("frFRUrlSearchPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPageFrFR()));
    ctx.put("frFRUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPageFrFR()));
    ctx.put("frFRUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownloadFrFR()));

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageFrFRSeaportFacility(ServiceRequest serviceRequest, SeaportFacility result) {
    return "fr-fr/edition/installations-portuaires/SeaportFacilityEditPage.htm";
  }
  public void templateEditPageFrFRSeaportFacility(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SeaportFacility result = listSeaportFacility.first();
      String pageTemplateUri = templateUriEditPageFrFRSeaportFacility(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "fr-fr/edition/installations-portuaires/SeaportFacilityEditPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateEditPageFrFRSeaportFacility failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageFrFRSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      SeaportFacilityPage page = new SeaportFacilityPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSeaportFacility.size() >= 1)
        siteRequest.setRequestPk(listSeaportFacility.get(0).getPk());
      page.setSearchListSeaportFacility_(listSeaportFacility);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSeaportFacilityPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpagefrfrSeaportFacilityPageInit(ctx, page, listSeaportFacility, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateEditPageFrFRSeaportFacility(ctx, page, listSeaportFacility, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200EditPageFrFRSeaportFacility failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageFrFRSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageFrFRSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageFrFRSeaportFacility(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageFrFRSeaportFacility(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // Search //

  @Override
  public void searchSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200SearchSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("searchSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      List<String> fls = listSeaportFacility.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listSeaportFacility.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = SeaportFacility.varIndexedSeaportFacility(fieldName);
            if(v != null)
              fieldNames.add(SeaportFacility.varIndexedSeaportFacility(fieldName));
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
      response200Search(listSeaportFacility.getRequest(), listSeaportFacility.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchSeaportFacility(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchSeaportFacility(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200GETSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("getSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("getSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("getSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("getSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("getSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("getSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listSeaportFacility.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchSeaportFacility(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchSeaportFacility started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
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
              searchSeaportFacilityList(siteRequest, false, true, true, "PATCH").onSuccess(listSeaportFacility -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listSeaportFacility.getRequest().getRows());
                  apiRequest.setNumFound(listSeaportFacility.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listSeaportFacility.first());
                  apiRequest.setId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
                  apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());

                  listPATCHSeaportFacility(apiRequest, listSeaportFacility).onSuccess(e -> {
                    response200PATCHSeaportFacility(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("patchSeaportFacility succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("patchSeaportFacility failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchSeaportFacility failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("patchSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("patchSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("patchSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHSeaportFacility(ApiRequest apiRequest, SearchList<SeaportFacility> listSeaportFacility) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
    listSeaportFacility.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      SeaportFacility o2 = jsonObject.mapTo(SeaportFacility.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchSeaportFacilityFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHSeaportFacility failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listSeaportFacility.next().onSuccess(next -> {
        if(next) {
          listPATCHSeaportFacility(apiRequest, listSeaportFacility).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHSeaportFacility failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchSeaportFacilityFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchSeaportFacilityList(siteRequest, false, true, true, "PATCH").onSuccess(listSeaportFacility -> {
          try {
            SeaportFacility o = listSeaportFacility.first();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest);
            siteRequest.setApiRequest_(apiRequest);
            if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
              siteRequest.getRequestVars().put( "refresh", "false" );
            }
            SeaportFacility o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listSeaportFacility.first()).map(o3 -> o3.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(SeaportFacility.class);
              o2.setSiteRequest_(siteRequest);
              patchSeaportFacilityFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              String m = String.format("%s %s not found", "seaport facility", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchSeaportFacility failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchSeaportFacility failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchSeaportFacility failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<SeaportFacility> patchSeaportFacilityFuture(SeaportFacility o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<SeaportFacility> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<SeaportFacility> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsSeaportFacility(siteRequest).onSuccess(a -> {
          JsonObject jsonObject = o.getSiteRequest_().getJsonObject();
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            ngsildGetEntity(o).compose(ngsildData -> {
              Promise<JsonObject> promise2 = Promise.promise();
              if(ngsildData == null) {
                promise2.complete(jsonObject);
              } else {
                String setNgsildData = String.format("set%s",StringUtils.capitalize(SeaportFacility.VAR_ngsildData));
                jsonObject.put(setNgsildData, ngsildData);
                promise2.complete(jsonObject);
              }
              return promise2.future();
            }).compose(ngsildData -> {
              Promise<SeaportFacility> promise2 = Promise.promise();
              sqlPATCHSeaportFacility(o, inheritPrimaryKey).onSuccess(seaportFacility -> {
                persistSeaportFacility(seaportFacility, true).onSuccess(c -> {
                  relateSeaportFacility(seaportFacility).onSuccess(d -> {
                    indexSeaportFacility(seaportFacility).onSuccess(o2 -> {
                      if(apiRequest != null) {
                        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                        if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                          o2.apiRequestSeaportFacility();
                          if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                            eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
                        }
                      }
                      promise2.complete(seaportFacility);
                    }).onFailure(ex -> {
                      promise2.tryFail(ex);
                    });
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise2.tryFail(ex);
              });
              return promise2.future();
            }).onSuccess(o2 -> {
              promise1.complete(o2);
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          } else {
            sqlPATCHSeaportFacility(o, inheritPrimaryKey).onSuccess(seaportFacility -> {
              persistSeaportFacility(seaportFacility, true).onSuccess(c -> {
                relateSeaportFacility(seaportFacility).onSuccess(d -> {
                  indexSeaportFacility(seaportFacility).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestSeaportFacility();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(seaportFacility);
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(seaportFacility -> {
        Promise<SeaportFacility> promise2 = Promise.promise();
        refreshSeaportFacility(seaportFacility).onSuccess(a -> {
          promise2.complete(seaportFacility);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(seaportFacility -> {
        promise.complete(seaportFacility);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchSeaportFacilityFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SeaportFacility> sqlPATCHSeaportFacility(SeaportFacility o, Boolean inheritPrimaryKey) {
    Promise<SeaportFacility> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE SeaportFacility SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      SeaportFacility o2 = new SeaportFacility();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setName":
              o2.setName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_name + "=$" + num);
              num++;
              bParams.add(o2.sqlName());
            break;
          case "setAddress":
              o2.setAddress(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_address + "=$" + num);
              num++;
              bParams.add(o2.sqlAddress());
            break;
          case "setDescription":
              o2.setDescription(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_description + "=$" + num);
              num++;
              bParams.add(o2.sqlDescription());
            break;
          case "setAlternateName":
              o2.setAlternateName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_alternateName + "=$" + num);
              num++;
              bParams.add(o2.sqlAlternateName());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setLocation":
              o2.setLocation(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_location + "=$" + num);
              num++;
              bParams.add(o2.sqlLocation());
            break;
          case "setAuthorizedPropulsion":
              o2.setAuthorizedPropulsion(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_authorizedPropulsion + "=$" + num);
              num++;
              bParams.add(o2.sqlAuthorizedPropulsion());
            break;
          case "setId":
              o2.setId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_id + "=$" + num);
              num++;
              bParams.add(o2.sqlId());
            break;
          case "setBoatSupplyingServices":
              o2.setBoatSupplyingServices(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_boatSupplyingServices + "=$" + num);
              num++;
              bParams.add(o2.sqlBoatSupplyingServices());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setEntityShortId":
              o2.setEntityShortId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_entityShortId + "=$" + num);
              num++;
              bParams.add(o2.sqlEntityShortId());
            break;
          case "setContactPoint":
              o2.setContactPoint(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_contactPoint + "=$" + num);
              num++;
              bParams.add(o2.sqlContactPoint());
            break;
          case "setNgsildTenant":
              o2.setNgsildTenant(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_ngsildTenant + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildTenant());
            break;
          case "setContractingAuthority":
              o2.setContractingAuthority(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_contractingAuthority + "=$" + num);
              num++;
              bParams.add(o2.sqlContractingAuthority());
            break;
          case "setNgsildPath":
              o2.setNgsildPath(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_ngsildPath + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildPath());
            break;
          case "setContractingCompany":
              o2.setContractingCompany(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_contractingCompany + "=$" + num);
              num++;
              bParams.add(o2.sqlContractingCompany());
            break;
          case "setNgsildContext":
              o2.setNgsildContext(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_ngsildContext + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildContext());
            break;
          case "setCurrencyAccepted":
              o2.setCurrencyAccepted(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_currencyAccepted + "=$" + num);
              num++;
              bParams.add(o2.sqlCurrencyAccepted());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setNgsildData":
              o2.setNgsildData(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_ngsildData + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildData());
            break;
          case "setDataProvider":
              o2.setDataProvider(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_dataProvider + "=$" + num);
              num++;
              bParams.add(o2.sqlDataProvider());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setColor":
              o2.setColor(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_color + "=$" + num);
              num++;
              bParams.add(o2.sqlColor());
            break;
          case "setDateCreated":
              o2.setDateCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_dateCreated + "=$" + num);
              num++;
              bParams.add(o2.sqlDateCreated());
            break;
          case "setDateLastReported":
              o2.setDateLastReported(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_dateLastReported + "=$" + num);
              num++;
              bParams.add(o2.sqlDateLastReported());
            break;
          case "setDateModified":
              o2.setDateModified(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_dateModified + "=$" + num);
              num++;
              bParams.add(o2.sqlDateModified());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setElectricTransport":
              o2.setElectricTransport(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_electricTransport + "=$" + num);
              num++;
              bParams.add(o2.sqlElectricTransport());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setEndDate":
              o2.setEndDate(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_endDate + "=$" + num);
              num++;
              bParams.add(o2.sqlEndDate());
            break;
          case "setDisplayPageFrFR":
              o2.setDisplayPageFrFR(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_displayPageFrFR + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPageFrFR());
            break;
          case "setFacilities":
              o2.setFacilities(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_facilities + "=$" + num);
              num++;
              bParams.add(o2.sqlFacilities());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setMaxDraft":
              o2.setMaxDraft(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_maxDraft + "=$" + num);
              num++;
              bParams.add(o2.sqlMaxDraft());
            break;
          case "setEditPageFrFR":
              o2.setEditPageFrFR(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_editPageFrFR + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPageFrFR());
            break;
          case "setMaxLength":
              o2.setMaxLength(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_maxLength + "=$" + num);
              num++;
              bParams.add(o2.sqlMaxLength());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setMaxTonnage":
              o2.setMaxTonnage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_maxTonnage + "=$" + num);
              num++;
              bParams.add(o2.sqlMaxTonnage());
            break;
          case "setUserPageFrFR":
              o2.setUserPageFrFR(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_userPageFrFR + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPageFrFR());
            break;
          case "setMaxWidth":
              o2.setMaxWidth(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_maxWidth + "=$" + num);
              num++;
              bParams.add(o2.sqlMaxWidth());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_download + "=$" + num);
              num++;
              bParams.add(o2.sqlDownload());
            break;
          case "setMinLength":
              o2.setMinLength(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_minLength + "=$" + num);
              num++;
              bParams.add(o2.sqlMinLength());
            break;
          case "setDownloadFrFR":
              o2.setDownloadFrFR(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_downloadFrFR + "=$" + num);
              num++;
              bParams.add(o2.sqlDownloadFrFR());
            break;
          case "setNearbyServices":
              o2.setNearbyServices(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_nearbyServices + "=$" + num);
              num++;
              bParams.add(o2.sqlNearbyServices());
            break;
          case "setNumberOfPlace":
              o2.setNumberOfPlace(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_numberOfPlace + "=$" + num);
              num++;
              bParams.add(o2.sqlNumberOfPlace());
            break;
          case "setOpeningHours":
              o2.setOpeningHours(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_openingHours + "=$" + num);
              num++;
              bParams.add(o2.sqlOpeningHours());
            break;
          case "setOpeningHoursSpecification":
              o2.setOpeningHoursSpecification(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_openingHoursSpecification + "=$" + num);
              num++;
              bParams.add(o2.sqlOpeningHoursSpecification());
            break;
          case "setOwner":
              o2.setOwner(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_owner + "=$" + num);
              num++;
              bParams.add(o2.sqlOwner());
            break;
          case "setPaymentAccepted":
              o2.setPaymentAccepted(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_paymentAccepted + "=$" + num);
              num++;
              bParams.add(o2.sqlPaymentAccepted());
            break;
          case "setPortServicesProvided":
              o2.setPortServicesProvided(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_portServicesProvided + "=$" + num);
              num++;
              bParams.add(o2.sqlPortServicesProvided());
            break;
          case "setRefBoatAuthorized":
              o2.setRefBoatAuthorized(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_refBoatAuthorized + "=$" + num);
              num++;
              bParams.add(o2.sqlRefBoatAuthorized());
            break;
          case "setRefBoatPlaceAvailable":
              o2.setRefBoatPlaceAvailable(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_refBoatPlaceAvailable + "=$" + num);
              num++;
              bParams.add(o2.sqlRefBoatPlaceAvailable());
            break;
          case "setRefBoatPlacePricing":
              o2.setRefBoatPlacePricing(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_refBoatPlacePricing + "=$" + num);
              num++;
              bParams.add(o2.sqlRefBoatPlacePricing());
            break;
          case "setRefDevice":
              o2.setRefDevice(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_refDevice + "=$" + num);
              num++;
              bParams.add(o2.sqlRefDevice());
            break;
          case "setRefPointOfInterest":
              o2.setRefPointOfInterest(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_refPointOfInterest + "=$" + num);
              num++;
              bParams.add(o2.sqlRefPointOfInterest());
            break;
          case "setRentalSaleServices":
              o2.setRentalSaleServices(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_rentalSaleServices + "=$" + num);
              num++;
              bParams.add(o2.sqlRentalSaleServices());
            break;
          case "setRouteType":
              o2.setRouteType(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_routeType + "=$" + num);
              num++;
              bParams.add(o2.sqlRouteType());
            break;
          case "setSeeAlso":
              o2.setSeeAlso(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_seeAlso + "=$" + num);
              num++;
              bParams.add(o2.sqlSeeAlso());
            break;
          case "setSource":
              o2.setSource(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_source + "=$" + num);
              num++;
              bParams.add(o2.sqlSource());
            break;
          case "setStartDate":
              o2.setStartDate(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_startDate + "=$" + num);
              num++;
              bParams.add(o2.sqlStartDate());
            break;
          case "setTransportServices":
              o2.setTransportServices(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_transportServices + "=$" + num);
              num++;
              bParams.add(o2.sqlTransportServices());
            break;
          case "setTypeOfPort":
              o2.setTypeOfPort(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_typeOfPort + "=$" + num);
              num++;
              bParams.add(o2.sqlTypeOfPort());
            break;
          case "setWebSite":
              o2.setWebSite(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(SeaportFacility.VAR_webSite + "=$" + num);
              num++;
              bParams.add(o2.sqlWebSite());
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
            RuntimeException ex2 = new RuntimeException("value SeaportFacility failed", ex);
            LOG.error(String.format("relateSeaportFacility failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          SeaportFacility o3 = new SeaportFacility();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHSeaportFacility(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postSeaportFacility(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postSeaportFacility started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
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
              eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
              JsonObject params = new JsonObject();
              params.put("body", siteRequest.getJsonObject());
              params.put("path", new JsonObject());
              params.put("scopes", scopes2);
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
              eventBus.request(SeaportFacility.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postSeaportFacilityFuture")).onSuccess(a -> {
                JsonObject responseMessage = (JsonObject)a.body();
                JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
                apiRequest.setSolrId(responseBody.getString(SeaportFacility.VAR_solrId));
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
                LOG.debug(String.format("postSeaportFacility succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("postSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("postSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("postSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("postSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postSeaportFacilityFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
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
        postSeaportFacilityFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("postSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<SeaportFacility> postSeaportFacilityFuture(SiteRequest siteRequest, Boolean entityShortId) {
    Promise<SeaportFacility> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<SeaportFacility> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsSeaportFacility(siteRequest).onSuccess(a -> {
          createSeaportFacility(siteRequest).onSuccess(seaportFacility -> {
            sqlPOSTSeaportFacility(seaportFacility, entityShortId).onSuccess(b -> {
              persistSeaportFacility(seaportFacility, false).onSuccess(c -> {
                relateSeaportFacility(seaportFacility).onSuccess(d -> {
                  indexSeaportFacility(seaportFacility).onSuccess(o2 -> {
                    promise1.complete(seaportFacility);
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(seaportFacility -> {
        Promise<SeaportFacility> promise2 = Promise.promise();
        refreshSeaportFacility(seaportFacility).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              seaportFacility.apiRequestSeaportFacility();
              eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(seaportFacility);
          } catch(Exception ex) {
            LOG.error(String.format("postSeaportFacilityFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(seaportFacility -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            seaportFacility.apiRequestSeaportFacility();
            eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(seaportFacility);
        } catch(Exception ex) {
          LOG.error(String.format("postSeaportFacilityFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postSeaportFacilityFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SeaportFacility> sqlPOSTSeaportFacility(SeaportFacility o, Boolean inheritPrimaryKey) {
    Promise<SeaportFacility> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE SeaportFacility SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      SeaportFacility o2 = new SeaportFacility();
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
          case SeaportFacility.VAR_name:
            o2.setName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_name + "=$" + num);
            num++;
            bParams.add(o2.sqlName());
            break;
          case SeaportFacility.VAR_address:
            o2.setAddress(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_address + "=$" + num);
            num++;
            bParams.add(o2.sqlAddress());
            break;
          case SeaportFacility.VAR_description:
            o2.setDescription(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_description + "=$" + num);
            num++;
            bParams.add(o2.sqlDescription());
            break;
          case SeaportFacility.VAR_alternateName:
            o2.setAlternateName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_alternateName + "=$" + num);
            num++;
            bParams.add(o2.sqlAlternateName());
            break;
          case SeaportFacility.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case SeaportFacility.VAR_location:
            o2.setLocation(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_location + "=$" + num);
            num++;
            bParams.add(o2.sqlLocation());
            break;
          case SeaportFacility.VAR_authorizedPropulsion:
            o2.setAuthorizedPropulsion(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_authorizedPropulsion + "=$" + num);
            num++;
            bParams.add(o2.sqlAuthorizedPropulsion());
            break;
          case SeaportFacility.VAR_id:
            o2.setId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_id + "=$" + num);
            num++;
            bParams.add(o2.sqlId());
            break;
          case SeaportFacility.VAR_boatSupplyingServices:
            o2.setBoatSupplyingServices(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_boatSupplyingServices + "=$" + num);
            num++;
            bParams.add(o2.sqlBoatSupplyingServices());
            break;
          case SeaportFacility.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case SeaportFacility.VAR_entityShortId:
            o2.setEntityShortId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_entityShortId + "=$" + num);
            num++;
            bParams.add(o2.sqlEntityShortId());
            break;
          case SeaportFacility.VAR_contactPoint:
            o2.setContactPoint(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_contactPoint + "=$" + num);
            num++;
            bParams.add(o2.sqlContactPoint());
            break;
          case SeaportFacility.VAR_ngsildTenant:
            o2.setNgsildTenant(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_ngsildTenant + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildTenant());
            break;
          case SeaportFacility.VAR_contractingAuthority:
            o2.setContractingAuthority(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_contractingAuthority + "=$" + num);
            num++;
            bParams.add(o2.sqlContractingAuthority());
            break;
          case SeaportFacility.VAR_ngsildPath:
            o2.setNgsildPath(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_ngsildPath + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildPath());
            break;
          case SeaportFacility.VAR_contractingCompany:
            o2.setContractingCompany(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_contractingCompany + "=$" + num);
            num++;
            bParams.add(o2.sqlContractingCompany());
            break;
          case SeaportFacility.VAR_ngsildContext:
            o2.setNgsildContext(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_ngsildContext + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildContext());
            break;
          case SeaportFacility.VAR_currencyAccepted:
            o2.setCurrencyAccepted(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_currencyAccepted + "=$" + num);
            num++;
            bParams.add(o2.sqlCurrencyAccepted());
            break;
          case SeaportFacility.VAR_sessionId:
            o2.setSessionId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_sessionId + "=$" + num);
            num++;
            bParams.add(o2.sqlSessionId());
            break;
          case SeaportFacility.VAR_ngsildData:
            o2.setNgsildData(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_ngsildData + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildData());
            break;
          case SeaportFacility.VAR_dataProvider:
            o2.setDataProvider(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_dataProvider + "=$" + num);
            num++;
            bParams.add(o2.sqlDataProvider());
            break;
          case SeaportFacility.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case SeaportFacility.VAR_color:
            o2.setColor(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_color + "=$" + num);
            num++;
            bParams.add(o2.sqlColor());
            break;
          case SeaportFacility.VAR_dateCreated:
            o2.setDateCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_dateCreated + "=$" + num);
            num++;
            bParams.add(o2.sqlDateCreated());
            break;
          case SeaportFacility.VAR_dateLastReported:
            o2.setDateLastReported(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_dateLastReported + "=$" + num);
            num++;
            bParams.add(o2.sqlDateLastReported());
            break;
          case SeaportFacility.VAR_dateModified:
            o2.setDateModified(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_dateModified + "=$" + num);
            num++;
            bParams.add(o2.sqlDateModified());
            break;
          case SeaportFacility.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case SeaportFacility.VAR_electricTransport:
            o2.setElectricTransport(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_electricTransport + "=$" + num);
            num++;
            bParams.add(o2.sqlElectricTransport());
            break;
          case SeaportFacility.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case SeaportFacility.VAR_endDate:
            o2.setEndDate(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_endDate + "=$" + num);
            num++;
            bParams.add(o2.sqlEndDate());
            break;
          case SeaportFacility.VAR_displayPageFrFR:
            o2.setDisplayPageFrFR(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_displayPageFrFR + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPageFrFR());
            break;
          case SeaportFacility.VAR_facilities:
            o2.setFacilities(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_facilities + "=$" + num);
            num++;
            bParams.add(o2.sqlFacilities());
            break;
          case SeaportFacility.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case SeaportFacility.VAR_maxDraft:
            o2.setMaxDraft(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_maxDraft + "=$" + num);
            num++;
            bParams.add(o2.sqlMaxDraft());
            break;
          case SeaportFacility.VAR_editPageFrFR:
            o2.setEditPageFrFR(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_editPageFrFR + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPageFrFR());
            break;
          case SeaportFacility.VAR_maxLength:
            o2.setMaxLength(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_maxLength + "=$" + num);
            num++;
            bParams.add(o2.sqlMaxLength());
            break;
          case SeaportFacility.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case SeaportFacility.VAR_maxTonnage:
            o2.setMaxTonnage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_maxTonnage + "=$" + num);
            num++;
            bParams.add(o2.sqlMaxTonnage());
            break;
          case SeaportFacility.VAR_userPageFrFR:
            o2.setUserPageFrFR(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_userPageFrFR + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPageFrFR());
            break;
          case SeaportFacility.VAR_maxWidth:
            o2.setMaxWidth(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_maxWidth + "=$" + num);
            num++;
            bParams.add(o2.sqlMaxWidth());
            break;
          case SeaportFacility.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_download + "=$" + num);
            num++;
            bParams.add(o2.sqlDownload());
            break;
          case SeaportFacility.VAR_minLength:
            o2.setMinLength(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_minLength + "=$" + num);
            num++;
            bParams.add(o2.sqlMinLength());
            break;
          case SeaportFacility.VAR_downloadFrFR:
            o2.setDownloadFrFR(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_downloadFrFR + "=$" + num);
            num++;
            bParams.add(o2.sqlDownloadFrFR());
            break;
          case SeaportFacility.VAR_nearbyServices:
            o2.setNearbyServices(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_nearbyServices + "=$" + num);
            num++;
            bParams.add(o2.sqlNearbyServices());
            break;
          case SeaportFacility.VAR_numberOfPlace:
            o2.setNumberOfPlace(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_numberOfPlace + "=$" + num);
            num++;
            bParams.add(o2.sqlNumberOfPlace());
            break;
          case SeaportFacility.VAR_openingHours:
            o2.setOpeningHours(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_openingHours + "=$" + num);
            num++;
            bParams.add(o2.sqlOpeningHours());
            break;
          case SeaportFacility.VAR_openingHoursSpecification:
            o2.setOpeningHoursSpecification(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_openingHoursSpecification + "=$" + num);
            num++;
            bParams.add(o2.sqlOpeningHoursSpecification());
            break;
          case SeaportFacility.VAR_owner:
            o2.setOwner(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_owner + "=$" + num);
            num++;
            bParams.add(o2.sqlOwner());
            break;
          case SeaportFacility.VAR_paymentAccepted:
            o2.setPaymentAccepted(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_paymentAccepted + "=$" + num);
            num++;
            bParams.add(o2.sqlPaymentAccepted());
            break;
          case SeaportFacility.VAR_portServicesProvided:
            o2.setPortServicesProvided(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_portServicesProvided + "=$" + num);
            num++;
            bParams.add(o2.sqlPortServicesProvided());
            break;
          case SeaportFacility.VAR_refBoatAuthorized:
            o2.setRefBoatAuthorized(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_refBoatAuthorized + "=$" + num);
            num++;
            bParams.add(o2.sqlRefBoatAuthorized());
            break;
          case SeaportFacility.VAR_refBoatPlaceAvailable:
            o2.setRefBoatPlaceAvailable(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_refBoatPlaceAvailable + "=$" + num);
            num++;
            bParams.add(o2.sqlRefBoatPlaceAvailable());
            break;
          case SeaportFacility.VAR_refBoatPlacePricing:
            o2.setRefBoatPlacePricing(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_refBoatPlacePricing + "=$" + num);
            num++;
            bParams.add(o2.sqlRefBoatPlacePricing());
            break;
          case SeaportFacility.VAR_refDevice:
            o2.setRefDevice(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_refDevice + "=$" + num);
            num++;
            bParams.add(o2.sqlRefDevice());
            break;
          case SeaportFacility.VAR_refPointOfInterest:
            o2.setRefPointOfInterest(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_refPointOfInterest + "=$" + num);
            num++;
            bParams.add(o2.sqlRefPointOfInterest());
            break;
          case SeaportFacility.VAR_rentalSaleServices:
            o2.setRentalSaleServices(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_rentalSaleServices + "=$" + num);
            num++;
            bParams.add(o2.sqlRentalSaleServices());
            break;
          case SeaportFacility.VAR_routeType:
            o2.setRouteType(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_routeType + "=$" + num);
            num++;
            bParams.add(o2.sqlRouteType());
            break;
          case SeaportFacility.VAR_seeAlso:
            o2.setSeeAlso(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_seeAlso + "=$" + num);
            num++;
            bParams.add(o2.sqlSeeAlso());
            break;
          case SeaportFacility.VAR_source:
            o2.setSource(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_source + "=$" + num);
            num++;
            bParams.add(o2.sqlSource());
            break;
          case SeaportFacility.VAR_startDate:
            o2.setStartDate(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_startDate + "=$" + num);
            num++;
            bParams.add(o2.sqlStartDate());
            break;
          case SeaportFacility.VAR_transportServices:
            o2.setTransportServices(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_transportServices + "=$" + num);
            num++;
            bParams.add(o2.sqlTransportServices());
            break;
          case SeaportFacility.VAR_typeOfPort:
            o2.setTypeOfPort(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_typeOfPort + "=$" + num);
            num++;
            bParams.add(o2.sqlTypeOfPort());
            break;
          case SeaportFacility.VAR_webSite:
            o2.setWebSite(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(SeaportFacility.VAR_webSite + "=$" + num);
            num++;
            bParams.add(o2.sqlWebSite());
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
            RuntimeException ex2 = new RuntimeException("value SeaportFacility failed", ex);
            LOG.error(String.format("relateSeaportFacility failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTSeaportFacility(SeaportFacility o) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject json = JsonObject.mapFrom(o);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteSeaportFacility(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteSeaportFacility started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
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
              searchSeaportFacilityList(siteRequest, false, true, true, "DELETE").onSuccess(listSeaportFacility -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listSeaportFacility.getRequest().getRows());
                  apiRequest.setNumFound(listSeaportFacility.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listSeaportFacility.first());
                  apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());

                  listDELETESeaportFacility(apiRequest, listSeaportFacility).onSuccess(e -> {
                    response200DELETESeaportFacility(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deleteSeaportFacility succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deleteSeaportFacility failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteSeaportFacility failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deleteSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deleteSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("deleteSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETESeaportFacility(ApiRequest apiRequest, SearchList<SeaportFacility> listSeaportFacility) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
    listSeaportFacility.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      SeaportFacility o2 = jsonObject.mapTo(SeaportFacility.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteSeaportFacilityFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETESeaportFacility failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listSeaportFacility.next().onSuccess(next -> {
        if(next) {
          listDELETESeaportFacility(apiRequest, listSeaportFacility).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETESeaportFacility failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETESeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETESeaportFacility failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteSeaportFacilityFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchSeaportFacilityList(siteRequest, false, true, true, "DELETE").onSuccess(listSeaportFacility -> {
          try {
            SeaportFacility o = listSeaportFacility.first();
            if(o != null && listSeaportFacility.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deleteSeaportFacilityFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteSeaportFacility failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteSeaportFacility failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteSeaportFacility failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<SeaportFacility> deleteSeaportFacilityFuture(SeaportFacility o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<SeaportFacility> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<SeaportFacility> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsSeaportFacility(siteRequest).onSuccess(a -> {
          sqlDELETESeaportFacility(o).onSuccess(seaportFacility -> {
            relateSeaportFacility(o).onSuccess(d -> {
              unindexSeaportFacility(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestSeaportFacility();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(seaportFacility -> {
        Promise<SeaportFacility> promise2 = Promise.promise();
        refreshSeaportFacility(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(seaportFacility -> {
        promise.complete(seaportFacility);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteSeaportFacilityFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETESeaportFacility(SeaportFacility o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM SeaportFacility ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      SeaportFacility o2 = new SeaportFacility();
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
          RuntimeException ex2 = new RuntimeException("value SeaportFacility failed", ex);
          LOG.error(String.format("unrelateSeaportFacility failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            cbDeleteEntity(o).onSuccess(c -> {
              promise.complete();
            }).onFailure(ex -> {
              LOG.error(String.format("sqlDELETESeaportFacility failed. "), ex);
              promise.tryFail(ex);
            });
          } else {
            promise.complete();
          }
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETESeaportFacility failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETESeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETESeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETESeaportFacility(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETESeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportSeaportFacility(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportSeaportFacility started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
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
              eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
              varsSeaportFacility(siteRequest).onSuccess(d -> {
                listPUTImportSeaportFacility(apiRequest, siteRequest).onSuccess(e -> {
                  response200PUTImportSeaportFacility(siteRequest).onSuccess(response -> {
                    LOG.debug(String.format("putimportSeaportFacility succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportSeaportFacility failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("putimportSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("putimportSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportSeaportFacility(ApiRequest apiRequest, SiteRequest siteRequest) {
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
          eventBus.request(SeaportFacility.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportSeaportFacilityFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportSeaportFacility failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportSeaportFacilityFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
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
        String entityShortId = Optional.ofNullable(body.getString(SeaportFacility.VAR_entityShortId)).orElse(body.getString(SeaportFacility.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        pgPool.getConnection().onSuccess(sqlConnection -> {
          String sqlQuery = String.format("select * from %s WHERE entityShortId=$1", SeaportFacility.CLASS_SIMPLE_NAME);
          sqlConnection.preparedQuery(sqlQuery)
              .execute(Tuple.tuple(Arrays.asList(entityShortId))
              ).onSuccess(result -> {
            sqlConnection.close().onSuccess(a -> {
              try {
                if(result.size() >= 1) {
                  SeaportFacility o = new SeaportFacility();
                  o.setSiteRequest_(siteRequest);
                  for(Row definition : result.value()) {
                    for(Integer i = 0; i < definition.size(); i++) {
                      try {
                        String columnName = definition.getColumnName(i);
                        Object columnValue = definition.getValue(i);
                        o.persistForClass(columnName, columnValue);
                      } catch(Exception e) {
                        LOG.error(String.format("persistSeaportFacility failed. "), e);
                      }
                    }
                  }
                  SeaportFacility o2 = new SeaportFacility();
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
                  if(result.size() >= 1) {
                    apiRequest.setOriginal(o);
                    apiRequest.setId(Optional.ofNullable(o.getEntityShortId()).map(v -> v.toString()).orElse(null));
                    apiRequest.setSolrId(o.getSolrId());
                  }
                  siteRequest.setJsonObject(body2);
                  patchSeaportFacilityFuture(o, true).onSuccess(b -> {
                    LOG.debug("Import SeaportFacility {} succeeded, modified SeaportFacility. ", body.getValue(SeaportFacility.VAR_entityShortId));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                } else {
                  postSeaportFacilityFuture(siteRequest, true).onSuccess(b -> {
                    LOG.debug("Import SeaportFacility {} succeeded, created new SeaportFacility. ", body.getValue(SeaportFacility.VAR_entityShortId));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              }
            }).onFailure(ex -> {
              LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
              eventHandler.handle(Future.failedFuture(ex));
            });
          }).onFailure(ex -> {
            LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          });
        }).onFailure(ex -> {
          LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportSeaportFacilityFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("putimportSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportSeaportFacility(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200SearchPageSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchpageSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchpageSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchpageSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("searchpageSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageSeaportFacilityPageInit(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("frFRUrlSearchPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPageFrFR()));
    ctx.put("frFRUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPageFrFR()));
    ctx.put("frFRUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownloadFrFR()));

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageSeaportFacility(ServiceRequest serviceRequest, SeaportFacility result) {
    return "en-us/search/seaport-facilities/SeaportFacilitySearchPage.htm";
  }
  public void templateSearchPageSeaportFacility(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SeaportFacility result = listSeaportFacility.first();
      String pageTemplateUri = templateUriSearchPageSeaportFacility(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/seaport-facilities/SeaportFacilitySearchPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateSearchPageSeaportFacility failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      SeaportFacilityPage page = new SeaportFacilityPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSeaportFacility.size() >= 1)
        siteRequest.setRequestPk(listSeaportFacility.get(0).getPk());
      page.setSearchListSeaportFacility_(listSeaportFacility);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSeaportFacilityPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageSeaportFacilityPageInit(ctx, page, listSeaportFacility, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateSearchPageSeaportFacility(ctx, page, listSeaportFacility, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200SearchPageSeaportFacility failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageSeaportFacility(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotSearchPageSeaportFacility(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageSeaportFacility(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchSeaportFacilityList(siteRequest, false, true, false, "GET").onSuccess(listSeaportFacility -> {
                response200EditPageSeaportFacility(listSeaportFacility).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("editpageSeaportFacility succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("editpageSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("editpageSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
            });
            }
          } catch(Exception ex) {
            LOG.error(String.format("editpageSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("editpageSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageSeaportFacilityPageInit(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("frFRUrlSearchPage", String.format("%s%s", siteBaseUrl, "/fr-fr/rechercher/installations-portuaires"));
    ctx.put("frFRUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPageFrFR()));
    ctx.put("frFRUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPageFrFR()));
    ctx.put("frFRUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPageFrFR()));
    ctx.put("frFRUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownloadFrFR()));

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/seaport-facilities"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageSeaportFacility(ServiceRequest serviceRequest, SeaportFacility result) {
    return "en-us/edit/seaport-facilities/SeaportFacilityEditPage.htm";
  }
  public void templateEditPageSeaportFacility(JsonObject ctx, SeaportFacilityPage page, SearchList<SeaportFacility> listSeaportFacility, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      SeaportFacility result = listSeaportFacility.first();
      String pageTemplateUri = templateUriEditPageSeaportFacility(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/seaport-facilities/SeaportFacilityEditPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateEditPageSeaportFacility failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageSeaportFacility(SearchList<SeaportFacility> listSeaportFacility) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
      SeaportFacilityPage page = new SeaportFacilityPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listSeaportFacility.size() >= 1)
        siteRequest.setRequestPk(listSeaportFacility.get(0).getPk());
      page.setSearchListSeaportFacility_(listSeaportFacility);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepSeaportFacilityPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageSeaportFacilityPageInit(ctx, page, listSeaportFacility, promise1);
          promise1.future().onSuccess(b -> {
            Promise<String> promise2 = Promise.promise();
            templateEditPageSeaportFacility(ctx, page, listSeaportFacility, promise2);
            promise2.future().onSuccess(renderedTemplate -> {
              try {
                Buffer buffer = Buffer.buffer(renderedTemplate);
                promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
              } catch(Throwable ex) {
                LOG.error(String.format("response200EditPageSeaportFacility failed. "), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageSeaportFacility(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
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
          responsePivotEditPageSeaportFacility(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterSeaportFacility(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterSeaportFacility started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String SEAPORTFACILITY = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("SEAPORTFACILITY");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", SeaportFacility.CLASS_AUTH_RESOURCE, "Admin"));
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
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "SEAPORTFACILITY".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
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
              searchSeaportFacilityList(siteRequest, false, true, true, "DELETE").onSuccess(listSeaportFacility -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listSeaportFacility.getRequest().getRows());
                  apiRequest.setNumFound(listSeaportFacility.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listSeaportFacility.first());
                  apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());

                  listDELETEFilterSeaportFacility(apiRequest, listSeaportFacility).onSuccess(e -> {
                    response200DELETEFilterSeaportFacility(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deletefilterSeaportFacility succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterSeaportFacility failed. ", ex2));
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
        LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterSeaportFacility(ApiRequest apiRequest, SearchList<SeaportFacility> listSeaportFacility) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listSeaportFacility.getSiteRequest_(SiteRequest.class);
    listSeaportFacility.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      SeaportFacility o2 = jsonObject.mapTo(SeaportFacility.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterSeaportFacilityFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterSeaportFacility failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listSeaportFacility.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterSeaportFacility(apiRequest, listSeaportFacility).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterSeaportFacility failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterSeaportFacilityFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchSeaportFacilityList(siteRequest, false, true, true, "DELETE").onSuccess(listSeaportFacility -> {
          try {
            SeaportFacility o = listSeaportFacility.first();
            if(o != null && listSeaportFacility.getResponse().getResponse().getNumFound() == 1) {
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
              apiRequest.setId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listSeaportFacility.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deletefilterSeaportFacilityFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterSeaportFacility failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<SeaportFacility> deletefilterSeaportFacilityFuture(SeaportFacility o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<SeaportFacility> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<SeaportFacility> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsSeaportFacility(siteRequest).onSuccess(a -> {
          sqlDELETEFilterSeaportFacility(o).onSuccess(seaportFacility -> {
            relateSeaportFacility(o).onSuccess(d -> {
              unindexSeaportFacility(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestSeaportFacility();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketSeaportFacility", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(seaportFacility -> {
        Promise<SeaportFacility> promise2 = Promise.promise();
        refreshSeaportFacility(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(seaportFacility -> {
        promise.complete(seaportFacility);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterSeaportFacilityFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEFilterSeaportFacility(SeaportFacility o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM SeaportFacility ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      SeaportFacility o2 = new SeaportFacility();
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
          RuntimeException ex2 = new RuntimeException("value SeaportFacility failed", ex);
          LOG.error(String.format("unrelateSeaportFacility failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            cbDeleteEntity(o).onSuccess(c -> {
              promise.complete();
            }).onFailure(ex -> {
              LOG.error(String.format("sqlDELETEFilterSeaportFacility failed. "), ex);
              promise.tryFail(ex);
            });
          } else {
            promise.complete();
          }
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEFilterSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEFilterSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEFilterSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterSeaportFacility(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<SeaportFacility> createSeaportFacility(SiteRequest siteRequest) {
    Promise<SeaportFacility> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO SeaportFacility(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        SeaportFacility o = new SeaportFacility();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createSeaportFacility failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchSeaportFacilityQ(SearchList<SeaportFacility> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchSeaportFacilityFq(SearchList<SeaportFacility> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : SeaportFacility.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : SeaportFacility.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(SeaportFacility.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchSeaportFacilitySort(SearchList<SeaportFacility> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchSeaportFacilityRows(SearchList<SeaportFacility> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchSeaportFacilityStart(SearchList<SeaportFacility> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchSeaportFacilityVar(SearchList<SeaportFacility> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchSeaportFacilityUri(SearchList<SeaportFacility> searchList) {
  }

  public Future<ServiceResponse> varsSeaportFacility(SiteRequest siteRequest) {
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
          LOG.error(String.format("searchSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<SeaportFacility>> searchSeaportFacilityList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<SeaportFacility>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<SeaportFacility> searchList = new SearchList<SeaportFacility>();
      searchList.setScope(scope);
      String facetRange = null;
      Date facetRangeStart = null;
      Date facetRangeEnd = null;
      String facetRangeGap = null;
      String statsField = null;
      String statsFieldIndexed = null;
      searchList.setPopulate(populate);
      searchList.setStore(store);
      searchList.q("*:*");
      searchList.setC(SeaportFacility.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(SeaportFacility.varIndexedSeaportFacility(v));
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
                varsIndexed[i] = SeaportFacility.varIndexedSeaportFacility(entityVar);
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
                  varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
                  String entityQ = searchSeaportFacilityFq(searchList, entityVar, valueIndexed, varIndexed);
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
                  varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
                  String entityFq = searchSeaportFacilityFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
                searchSeaportFacilitySort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchSeaportFacilityStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchSeaportFacilityRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
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
                  varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = SeaportFacility.varIndexedSeaportFacility(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchSeaportFacilityVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchSeaportFacilityUri(searchList);
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
      searchSeaportFacility2(siteRequest, populate, store, modify, searchList);
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
            LOG.error(String.format("searchSeaportFacility failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchSeaportFacility2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<SeaportFacility> searchList) {
  }

  public Future<Void> persistSeaportFacility(SeaportFacility o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT name, address, description, alternateName, created, location, authorizedPropulsion, id, boatSupplyingServices, archived, entityShortId, contactPoint, ngsildTenant, contractingAuthority, ngsildPath, contractingCompany, ngsildContext, currencyAccepted, sessionId, ngsildData, dataProvider, userKey, color, dateCreated, dateLastReported, dateModified, objectTitle, electricTransport, displayPage, endDate, displayPageFrFR, facilities, editPage, maxDraft, editPageFrFR, maxLength, userPage, maxTonnage, userPageFrFR, maxWidth, download, minLength, downloadFrFR, nearbyServices, numberOfPlace, openingHours, openingHoursSpecification, owner, paymentAccepted, portServicesProvided, refBoatAuthorized, refBoatPlaceAvailable, refBoatPlacePricing, refDevice, refPointOfInterest, rentalSaleServices, routeType, seeAlso, source, startDate, transportServices, typeOfPort, webSite FROM SeaportFacility WHERE pk=$1")
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
                  LOG.error(String.format("persistSeaportFacility failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
              cbUpsertEntity(o, patch).onSuccess(b -> {
                promise.complete();
              }).onFailure(ex -> {
                LOG.error(String.format("persistSeaportFacility failed. "), ex);
                promise.tryFail(ex);
              });
            } else {
              promise.complete();
            }
          }).onFailure(ex -> {
            LOG.error(String.format("persistSeaportFacility failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistSeaportFacility failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistSeaportFacility failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> cbUpsertEntity(SeaportFacility o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      ZonedDateTime observedAt = ZonedDateTime.now(ZoneId.of("UTC"));
      String observedAtStr = observedAt.format(ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER);
      JsonArray entityArray = new JsonArray();
      JsonObject entityBody = new JsonObject();
      entityBody.put("@context", config.getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
      entityBody.put("id", o.getId());
      entityBody.put("type", SeaportFacility.CLASS_SIMPLE_NAME);
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

      List<String> vars = SeaportFacility.varsFqForClass();
      for (String var : vars) {
        String ngsiType = SeaportFacility.ngsiType(var);
        String displayName = Optional.ofNullable(SeaportFacility.displayNameSeaportFacility(var)).orElse(var);
        if (ngsiType != null && displayName != null && !var.equals("id") && !var.equals("ngsildData")) {
          Object value = o.obtainForClass(var);
          if(value != null) {
            Object ngsildVal = SeaportFacility.ngsiSeaportFacility(var, o);
            String ngsildType = SeaportFacility.ngsiType(var);
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
        promise.tryFail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format("cbUpsertEntity failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<JsonObject> ngsildGetEntity(SeaportFacility o) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      String entityName = o.getName();
      String entityType = SeaportFacility.CLASS_SIMPLE_NAME;
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
        promise.tryFail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format("postIotServiceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> cbDeleteEntity(SeaportFacility o) {
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
          promise.tryFail(ex);
        }
      });
    } catch(Throwable ex) {
      LOG.error(String.format("cbDeleteEntity failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateSeaportFacility(SeaportFacility o) {
    Promise<Void> promise = Promise.promise();
    promise.complete();
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return SeaportFacility.searchVarSeaportFacility(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return SeaportFacility.CLASS_API_ADDRESS_SeaportFacility;
  }

  public Future<SeaportFacility> indexSeaportFacility(SeaportFacility o) {
    Promise<SeaportFacility> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexSeaportFacility(doc);
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
        LOG.error(String.format("indexSeaportFacility failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SeaportFacility> unindexSeaportFacility(SeaportFacility o) {
    Promise<SeaportFacility> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", SeaportFacility.VAR_solrId, o.obtainForClass(SeaportFacility.VAR_solrId));
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
          LOG.error(String.format("unindexSeaportFacility failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexSeaportFacility failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshSeaportFacility(SeaportFacility o) {
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
        }

        CompositeFuture.all(futures).onSuccess(b -> {
          JsonObject params = new JsonObject();
          params.put("body", new JsonObject());
          params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
          params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
          params.put("form", new JsonObject());
          params.put("path", new JsonObject());
          params.put("scopes", siteRequest.getScopes());
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
          eventBus.request(SeaportFacility.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchSeaportFacilityFuture")).onSuccess(c -> {
            JsonObject responseMessage = (JsonObject)c.body();
            Integer statusCode = responseMessage.getInteger("statusCode");
            if(statusCode.equals(200))
              promise.complete();
            else
              promise.tryFail(new RuntimeException(responseMessage.getString("statusMessage")));
          }).onFailure(ex -> {
            LOG.error("Refresh relations failed. ", ex);
            promise.tryFail(ex);
          });
        }).onFailure(ex -> {
          LOG.error("Refresh relations failed. ", ex);
          promise.tryFail(ex);
        });
      } else {
        promise.complete();
      }
    } catch(Exception ex) {
      LOG.error(String.format("refreshSeaportFacility failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<JsonObject> generatePageBody(ComputateSiteRequest siteRequest, Map<String, Object> ctx, String templatePath, String classSimpleName, String pageTemplate) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      Map<String, Object> result = (Map<String, Object>)ctx.get("result");
      SiteRequest siteRequest2 = (SiteRequest)siteRequest;
      String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);
      SeaportFacility o = new SeaportFacility();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(SeaportFacility.VAR_name, SeaportFacility.staticSetName(siteRequest2, (String)result.get(SeaportFacility.VAR_name)));
      o.persistForClass(SeaportFacility.VAR_address, SeaportFacility.staticSetAddress(siteRequest2, (String)result.get(SeaportFacility.VAR_address)));
      o.persistForClass(SeaportFacility.VAR_description, SeaportFacility.staticSetDescription(siteRequest2, (String)result.get(SeaportFacility.VAR_description)));
      o.persistForClass(SeaportFacility.VAR_alternateName, SeaportFacility.staticSetAlternateName(siteRequest2, (String)result.get(SeaportFacility.VAR_alternateName)));
      o.persistForClass(SeaportFacility.VAR_created, SeaportFacility.staticSetCreated(siteRequest2, (String)result.get(SeaportFacility.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(SeaportFacility.VAR_location, SeaportFacility.staticSetLocation(siteRequest2, (String)result.get(SeaportFacility.VAR_location)));
      o.persistForClass(SeaportFacility.VAR_authorizedPropulsion, SeaportFacility.staticSetAuthorizedPropulsion(siteRequest2, (String)result.get(SeaportFacility.VAR_authorizedPropulsion)));
      o.persistForClass(SeaportFacility.VAR_id, SeaportFacility.staticSetId(siteRequest2, (String)result.get(SeaportFacility.VAR_id)));
      o.persistForClass(SeaportFacility.VAR_boatSupplyingServices, SeaportFacility.staticSetBoatSupplyingServices(siteRequest2, (String)result.get(SeaportFacility.VAR_boatSupplyingServices)));
      o.persistForClass(SeaportFacility.VAR_archived, SeaportFacility.staticSetArchived(siteRequest2, (String)result.get(SeaportFacility.VAR_archived)));
      o.persistForClass(SeaportFacility.VAR_entityShortId, SeaportFacility.staticSetEntityShortId(siteRequest2, (String)result.get(SeaportFacility.VAR_entityShortId)));
      o.persistForClass(SeaportFacility.VAR_contactPoint, SeaportFacility.staticSetContactPoint(siteRequest2, (String)result.get(SeaportFacility.VAR_contactPoint)));
      o.persistForClass(SeaportFacility.VAR_ngsildTenant, SeaportFacility.staticSetNgsildTenant(siteRequest2, (String)result.get(SeaportFacility.VAR_ngsildTenant)));
      o.persistForClass(SeaportFacility.VAR_contractingAuthority, SeaportFacility.staticSetContractingAuthority(siteRequest2, (String)result.get(SeaportFacility.VAR_contractingAuthority)));
      o.persistForClass(SeaportFacility.VAR_ngsildPath, SeaportFacility.staticSetNgsildPath(siteRequest2, (String)result.get(SeaportFacility.VAR_ngsildPath)));
      o.persistForClass(SeaportFacility.VAR_contractingCompany, SeaportFacility.staticSetContractingCompany(siteRequest2, (String)result.get(SeaportFacility.VAR_contractingCompany)));
      o.persistForClass(SeaportFacility.VAR_ngsildContext, SeaportFacility.staticSetNgsildContext(siteRequest2, (String)result.get(SeaportFacility.VAR_ngsildContext)));
      o.persistForClass(SeaportFacility.VAR_currencyAccepted, SeaportFacility.staticSetCurrencyAccepted(siteRequest2, (String)result.get(SeaportFacility.VAR_currencyAccepted)));
      o.persistForClass(SeaportFacility.VAR_sessionId, SeaportFacility.staticSetSessionId(siteRequest2, (String)result.get(SeaportFacility.VAR_sessionId)));
      o.persistForClass(SeaportFacility.VAR_ngsildData, SeaportFacility.staticSetNgsildData(siteRequest2, (String)result.get(SeaportFacility.VAR_ngsildData)));
      o.persistForClass(SeaportFacility.VAR_dataProvider, SeaportFacility.staticSetDataProvider(siteRequest2, (String)result.get(SeaportFacility.VAR_dataProvider)));
      o.persistForClass(SeaportFacility.VAR_userKey, SeaportFacility.staticSetUserKey(siteRequest2, (String)result.get(SeaportFacility.VAR_userKey)));
      o.persistForClass(SeaportFacility.VAR_color, SeaportFacility.staticSetColor(siteRequest2, (String)result.get(SeaportFacility.VAR_color)));
      o.persistForClass(SeaportFacility.VAR_dateCreated, SeaportFacility.staticSetDateCreated(siteRequest2, (String)result.get(SeaportFacility.VAR_dateCreated)));
      o.persistForClass(SeaportFacility.VAR_dateLastReported, SeaportFacility.staticSetDateLastReported(siteRequest2, (String)result.get(SeaportFacility.VAR_dateLastReported)));
      o.persistForClass(SeaportFacility.VAR_dateModified, SeaportFacility.staticSetDateModified(siteRequest2, (String)result.get(SeaportFacility.VAR_dateModified)));
      o.persistForClass(SeaportFacility.VAR_objectTitle, SeaportFacility.staticSetObjectTitle(siteRequest2, (String)result.get(SeaportFacility.VAR_objectTitle)));
      o.persistForClass(SeaportFacility.VAR_electricTransport, SeaportFacility.staticSetElectricTransport(siteRequest2, (String)result.get(SeaportFacility.VAR_electricTransport)));
      o.persistForClass(SeaportFacility.VAR_displayPage, SeaportFacility.staticSetDisplayPage(siteRequest2, (String)result.get(SeaportFacility.VAR_displayPage)));
      o.persistForClass(SeaportFacility.VAR_endDate, SeaportFacility.staticSetEndDate(siteRequest2, (String)result.get(SeaportFacility.VAR_endDate)));
      o.persistForClass(SeaportFacility.VAR_displayPageFrFR, SeaportFacility.staticSetDisplayPageFrFR(siteRequest2, (String)result.get(SeaportFacility.VAR_displayPageFrFR)));
      o.persistForClass(SeaportFacility.VAR_facilities, SeaportFacility.staticSetFacilities(siteRequest2, (String)result.get(SeaportFacility.VAR_facilities)));
      o.persistForClass(SeaportFacility.VAR_editPage, SeaportFacility.staticSetEditPage(siteRequest2, (String)result.get(SeaportFacility.VAR_editPage)));
      o.persistForClass(SeaportFacility.VAR_maxDraft, SeaportFacility.staticSetMaxDraft(siteRequest2, (String)result.get(SeaportFacility.VAR_maxDraft)));
      o.persistForClass(SeaportFacility.VAR_editPageFrFR, SeaportFacility.staticSetEditPageFrFR(siteRequest2, (String)result.get(SeaportFacility.VAR_editPageFrFR)));
      o.persistForClass(SeaportFacility.VAR_maxLength, SeaportFacility.staticSetMaxLength(siteRequest2, (String)result.get(SeaportFacility.VAR_maxLength)));
      o.persistForClass(SeaportFacility.VAR_userPage, SeaportFacility.staticSetUserPage(siteRequest2, (String)result.get(SeaportFacility.VAR_userPage)));
      o.persistForClass(SeaportFacility.VAR_maxTonnage, SeaportFacility.staticSetMaxTonnage(siteRequest2, (String)result.get(SeaportFacility.VAR_maxTonnage)));
      o.persistForClass(SeaportFacility.VAR_userPageFrFR, SeaportFacility.staticSetUserPageFrFR(siteRequest2, (String)result.get(SeaportFacility.VAR_userPageFrFR)));
      o.persistForClass(SeaportFacility.VAR_maxWidth, SeaportFacility.staticSetMaxWidth(siteRequest2, (String)result.get(SeaportFacility.VAR_maxWidth)));
      o.persistForClass(SeaportFacility.VAR_download, SeaportFacility.staticSetDownload(siteRequest2, (String)result.get(SeaportFacility.VAR_download)));
      o.persistForClass(SeaportFacility.VAR_minLength, SeaportFacility.staticSetMinLength(siteRequest2, (String)result.get(SeaportFacility.VAR_minLength)));
      o.persistForClass(SeaportFacility.VAR_downloadFrFR, SeaportFacility.staticSetDownloadFrFR(siteRequest2, (String)result.get(SeaportFacility.VAR_downloadFrFR)));
      o.persistForClass(SeaportFacility.VAR_nearbyServices, SeaportFacility.staticSetNearbyServices(siteRequest2, (String)result.get(SeaportFacility.VAR_nearbyServices)));
      o.persistForClass(SeaportFacility.VAR_numberOfPlace, SeaportFacility.staticSetNumberOfPlace(siteRequest2, (String)result.get(SeaportFacility.VAR_numberOfPlace)));
      o.persistForClass(SeaportFacility.VAR_openingHours, SeaportFacility.staticSetOpeningHours(siteRequest2, (String)result.get(SeaportFacility.VAR_openingHours)));
      o.persistForClass(SeaportFacility.VAR_openingHoursSpecification, SeaportFacility.staticSetOpeningHoursSpecification(siteRequest2, (String)result.get(SeaportFacility.VAR_openingHoursSpecification)));
      o.persistForClass(SeaportFacility.VAR_owner, SeaportFacility.staticSetOwner(siteRequest2, (String)result.get(SeaportFacility.VAR_owner)));
      o.persistForClass(SeaportFacility.VAR_paymentAccepted, SeaportFacility.staticSetPaymentAccepted(siteRequest2, (String)result.get(SeaportFacility.VAR_paymentAccepted)));
      o.persistForClass(SeaportFacility.VAR_portServicesProvided, SeaportFacility.staticSetPortServicesProvided(siteRequest2, (String)result.get(SeaportFacility.VAR_portServicesProvided)));
      o.persistForClass(SeaportFacility.VAR_refBoatAuthorized, SeaportFacility.staticSetRefBoatAuthorized(siteRequest2, (String)result.get(SeaportFacility.VAR_refBoatAuthorized)));
      o.persistForClass(SeaportFacility.VAR_refBoatPlaceAvailable, SeaportFacility.staticSetRefBoatPlaceAvailable(siteRequest2, (String)result.get(SeaportFacility.VAR_refBoatPlaceAvailable)));
      o.persistForClass(SeaportFacility.VAR_refBoatPlacePricing, SeaportFacility.staticSetRefBoatPlacePricing(siteRequest2, (String)result.get(SeaportFacility.VAR_refBoatPlacePricing)));
      o.persistForClass(SeaportFacility.VAR_refDevice, SeaportFacility.staticSetRefDevice(siteRequest2, (String)result.get(SeaportFacility.VAR_refDevice)));
      o.persistForClass(SeaportFacility.VAR_refPointOfInterest, SeaportFacility.staticSetRefPointOfInterest(siteRequest2, (String)result.get(SeaportFacility.VAR_refPointOfInterest)));
      o.persistForClass(SeaportFacility.VAR_rentalSaleServices, SeaportFacility.staticSetRentalSaleServices(siteRequest2, (String)result.get(SeaportFacility.VAR_rentalSaleServices)));
      o.persistForClass(SeaportFacility.VAR_routeType, SeaportFacility.staticSetRouteType(siteRequest2, (String)result.get(SeaportFacility.VAR_routeType)));
      o.persistForClass(SeaportFacility.VAR_seeAlso, SeaportFacility.staticSetSeeAlso(siteRequest2, (String)result.get(SeaportFacility.VAR_seeAlso)));
      o.persistForClass(SeaportFacility.VAR_source, SeaportFacility.staticSetSource(siteRequest2, (String)result.get(SeaportFacility.VAR_source)));
      o.persistForClass(SeaportFacility.VAR_startDate, SeaportFacility.staticSetStartDate(siteRequest2, (String)result.get(SeaportFacility.VAR_startDate)));
      o.persistForClass(SeaportFacility.VAR_transportServices, SeaportFacility.staticSetTransportServices(siteRequest2, (String)result.get(SeaportFacility.VAR_transportServices)));
      o.persistForClass(SeaportFacility.VAR_typeOfPort, SeaportFacility.staticSetTypeOfPort(siteRequest2, (String)result.get(SeaportFacility.VAR_typeOfPort)));
      o.persistForClass(SeaportFacility.VAR_webSite, SeaportFacility.staticSetWebSite(siteRequest2, (String)result.get(SeaportFacility.VAR_webSite)));

      o.promiseDeepForClass((SiteRequest)siteRequest).onSuccess(o2 -> {
        try {
          JsonObject data = JsonObject.mapFrom(o2);
          ctx.put("result", data.getMap());
          promise.complete(data);
        } catch(Exception ex) {
          LOG.error(String.format(importModelFail, classSimpleName), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("generatePageBody failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("generatePageBody failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
}
