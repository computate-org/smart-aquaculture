package org.computate.smartaquaculture.verticle;

import java.util.Map.Entry;

import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.user.SiteUser;
import org.computate.smartaquaculture.user.SiteUserEnUSApiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;

public class SiteRoutes {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteRoutes.class);
  
  public static void routes(Router router, ComputateOAuth2AuthHandlerImpl oauth2AuthHandler, JsonObject config, WebClient webClient, SiteUserEnUSApiServiceImpl apiSiteUser) {
  }
}
