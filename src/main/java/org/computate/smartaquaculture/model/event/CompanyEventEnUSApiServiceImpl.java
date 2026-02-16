package org.computate.smartaquaculture.model.event;

import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.json.JsonObject;
import io.vertx.sqlclient.Pool;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.config.yaml.YamlProcessor;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class CompanyEventEnUSApiServiceImpl extends CompanyEventEnUSGenApiServiceImpl {
  @Override
  protected Future<Void> importModelFromFile(Vertx vertx, ComputateSiteRequest siteRequest, YamlProcessor yamlProcessor,
      String templatePath, String classCanonicalName, String classSimpleName, String classApiAddress,
      String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    // TODO Auto-generated method stub
    return super.importModelFromFile(vertx, siteRequest, yamlProcessor, templatePath, classCanonicalName, classSimpleName,
        classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload);
  }
}
