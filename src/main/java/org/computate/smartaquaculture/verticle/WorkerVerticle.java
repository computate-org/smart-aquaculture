
package org.computate.smartaquaculture.verticle;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.fiware.feed.Feed;
import org.computate.smartaquaculture.model.fiware.feed.FeedEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.feeder.Feeder;
import org.computate.smartaquaculture.model.fiware.feeder.FeederEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.feedingoperation.FeedingOperation;
import org.computate.smartaquaculture.model.fiware.feedingoperation.FeedingOperationEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.fishfarm.FishFarm;
import org.computate.smartaquaculture.model.fiware.fishfarm.FishFarmEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock;
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip;
import org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTripEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation;
import org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing;
import org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingEnUSApiServiceImpl;
import org.computate.smartaquaculture.model.timezone.TimeZone;
import org.computate.smartaquaculture.model.timezone.TimeZoneEnUSApiServiceImpl;
import org.computate.smartaquaculture.page.SitePage;
import org.computate.smartaquaculture.page.SitePageEnUSApiServiceImpl;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.api.BaseApiServiceInterface;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.loader.FileLocator;

import io.netty.handler.codec.mqtt.MqttQoS;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.vertx.amqp.AmqpClient;
import io.vertx.amqp.AmqpClientOptions;
import io.vertx.amqp.AmqpSender;
import io.vertx.amqp.AmqpSenderOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.pgclient.PgBuilder;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.rabbitmq.RabbitMQOptions;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;

/**
 */
public class WorkerVerticle extends WorkerVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);

	public static final Integer FACET_LIMIT = 100;

	public final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss VV");

	private KafkaProducer<String, String> kafkaProducer;

	private MqttClient mqttClient;

	private AmqpClient amqpClient;

	private AmqpSender amqpSender;

	private RabbitMQClient rabbitmqClient;

	private ComputateOAuth2AuthHandlerImpl oauth2AuthHandler = null;

	public ComputateOAuth2AuthHandlerImpl getOauth2AuthHandler() {
		return oauth2AuthHandler;
	}

	public void setOauth2AuthHandler(ComputateOAuth2AuthHandlerImpl oauth2AuthHandler) {
		this.oauth2AuthHandler = oauth2AuthHandler;
	}

	private JsonObject i18n;

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database PostgreSQL. 
	 **/
	private Pool pgPool;

	public Pool getPgPool() {
		return pgPool;
	}

	public void setPgPool(Pool pgPool) {
		this.pgPool = pgPool;
	}

	private WebClient webClient;

	WorkerExecutor workerExecutor;

	Integer commitWithin;

	Jinjava jinjava;

	SdkTracerProvider sdkTracerProvider;
	public void setSdkTracerProvider(SdkTracerProvider sdkTracerProvider) {
		this.sdkTracerProvider = sdkTracerProvider;
	}

	SdkMeterProvider sdkMeterProvider;
	public void setSdkMeterProvider(SdkMeterProvider sdkMeterProvider) {
		this.sdkMeterProvider = sdkMeterProvider;
	}

	/**	
	 *	This is called by Vert.x when the verticle instance is deployed. 
	 *	Initialize a new site context object for storing information about the entire site in English. 
	 *	Setup the startPromise to handle the configuration steps and starting the server. 
	 **/
	@Override()
	public void start(Promise<Void> startPromise) throws Exception, Exception {
		commitWithin = Integer.parseInt(config().getString(ConfigKeys.SOLR_WORKER_COMMIT_WITHIN_MILLIS));

		try {
			configureI18n().onSuccess(a -> 
				configureData().onSuccess(b -> 
					configureJinjava().onSuccess(c -> 
						configureWebClient().onSuccess(d -> 
							configureSharedWorkerExecutor().onSuccess(e -> 
								configureKafka().onSuccess(f -> 
									configureMqtt().onSuccess(g -> 
										configureAmqp().onSuccess(h -> 
											configureRabbitmq().onSuccess(i -> 
												MainVerticle.authorizeData(vertx, config(), webClient).onComplete(j -> 
													importData().onSuccess(k -> 
														startPromise.complete()
													).onFailure(ex -> startPromise.fail(ex))
												).onFailure(ex -> startPromise.fail(ex))
											).onFailure(ex -> startPromise.fail(ex))
										).onFailure(ex -> startPromise.fail(ex))
									).onFailure(ex -> startPromise.fail(ex))
								).onFailure(ex -> startPromise.fail(ex))
							).onFailure(ex -> startPromise.fail(ex))
						).onFailure(ex -> startPromise.fail(ex))
					).onFailure(ex -> startPromise.fail(ex))
				).onFailure(ex -> startPromise.fail(ex))
			).onFailure(ex -> startPromise.fail(ex));
		} catch (Exception ex) {
			LOG.error("Couldn't start verticle. ", ex);
		}
	}

	/**
	 * Configure internationalization. 
	 * Val.FileError.enUS: Failed to load internationalization data from file: %s
	 * Val.Error.enUS: Failed to load internationalization data. 
	 * Val.Complete.enUS: Loading internationalization data is complete. 
	 * Val.Loaded.enUS: Loaded internationalization data: %s
	 **/
	public Future<JsonObject> configureI18n() {
		Promise<JsonObject> promise = Promise.promise();
		try {
			List<Future<String>> futures = new ArrayList<>();
			JsonArray i18nPaths = Optional.ofNullable(config().getValue(ConfigKeys.I18N_PATHS))
					.map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString()))
					.orElse(new JsonArray())
					;
			i18n = new JsonObject();
			i18nPaths.stream().map(o -> (String)o).forEach(i18nPath -> {
				futures.add(Future.future(promise1 -> {
					vertx.fileSystem().readFile(i18nPath).onSuccess(buffer -> {
						Yaml yaml = new Yaml();
						Map<String, Object> map = yaml.load(buffer.toString());
						i18n.mergeIn(new JsonObject(map));
						LOG.info(String.format(configureI18nLoaded, i18nPath));
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(configureI18nFileError, i18nPath), ex);
						promise1.fail(ex);
					});
				}));
			});
			Future.all(futures).onSuccess(b -> {
				LOG.info(configureI18nComplete);
				promise.complete(i18n);
			}).onFailure(ex -> {
				LOG.error(configureI18nError, ex);
				promise.fail(ex);
			});
		} catch (Throwable ex) {
			LOG.error(configureI18nError, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 **/
	public Future<Jinjava> configureJinjava() {
		Promise<Jinjava> promise = Promise.promise();

		try {
			jinjava = ComputateConfigKeys.getJinjava();
			String templatePath = config().getString(ConfigKeys.TEMPLATE_PATH);
			if(!StringUtils.isBlank(templatePath))
				jinjava.setResourceLocator(new FileLocator(new File(templatePath)));
			promise.complete(jinjava);
		} catch(Exception ex) {
			LOG.error("Jinjava failed to initialize.", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 **/
	private Future<Void> configureWebClient() {
		Promise<Void> promise = Promise.promise();

		try {
			Boolean sslVerify = Boolean.valueOf(config().getString(ConfigKeys.SSL_VERIFY));
			webClient = WebClient.create(vertx, new WebClientOptions().setVerifyHost(sslVerify).setTrustAll(!sslVerify));
			promise.complete();
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * 
	 * Val.ConnectionError.enUS: Could not open the database client connection. 
	 * Val.ConnectionSuccess.enUS: The database client connection was successful. 
	 * 
	 * Val.InitError.enUS: Could not initialize the database tables. 
	 * Val.InitSuccess.enUS: The database was initialized successfully. 
	 * 
	 *	Configure shared database connections across the cluster for massive scaling of the application. 
	 *	Return a promise that configures a shared database client connection. 
	 *	Load the database configuration into a shared io.vertx.ext.jdbc.JDBCClient for a scalable, clustered datasource connection pool. 
	 *	Initialize the database tables if not already created for the first time. 
	 **/
	private Future<Void> configureData() {
		Promise<Void> promise = Promise.promise();
		try {
			PgConnectOptions pgOptions = new PgConnectOptions();
			Integer jdbcMaxPoolSize = Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_POOL_SIZE));

			pgOptions.setPort(Integer.parseInt(config().getString(ConfigKeys.DATABASE_PORT)));
			pgOptions.setHost(config().getString(ConfigKeys.DATABASE_HOST_NAME));
			pgOptions.setDatabase(config().getString(ConfigKeys.DATABASE_DATABASE));
			pgOptions.setUser(config().getString(ConfigKeys.DATABASE_USERNAME));
			pgOptions.setPassword(config().getString(ConfigKeys.DATABASE_PASSWORD));
			pgOptions.setIdleTimeout(Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_IDLE_TIME)));
			pgOptions.setIdleTimeoutUnit(TimeUnit.HOURS);
			pgOptions.setConnectTimeout(Integer.parseInt(config().getString(ConfigKeys.DATABASE_CONNECT_TIMEOUT)));

			PoolOptions poolOptions = new PoolOptions();
			poolOptions.setMaxSize(jdbcMaxPoolSize);
			poolOptions.setMaxWaitQueueSize(Integer.parseInt(config().getString(ConfigKeys.DATABASE_MAX_WAIT_QUEUE_SIZE)));

			pgPool = PgBuilder.pool().connectingTo(pgOptions).with(poolOptions).using(vertx).build();

			MainVerticle.configureDatabaseSchema(vertx, config()).onComplete(a -> {
				LOG.info(configureDataInitSuccess);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(configureDataInitError, ex);
				promise.fail(ex);
			});
		} catch (Exception ex) {
			LOG.error(configureDataInitError, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * Val.Fail.enUS: Could not configure the shared worker executor. 
	 * Val.Complete.enUS: The shared worker executor "{}" was configured successfully. 
	 * 
	 *	Configure a shared worker executor for running blocking tasks in the background. 
	 *	Return a promise that configures the shared worker executor. 
	 **/
	private Future<Void> configureSharedWorkerExecutor() {
		Promise<Void> promise = Promise.promise();
		try {
			String name = "WorkerVerticle-WorkerExecutor";
			Integer workerPoolSize = System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? 5 : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE));
			Long vertxMaxWorkerExecuteTime = config().getLong(ConfigKeys.VERTX_MAX_WORKER_EXECUTE_TIME);
			workerExecutor = vertx.createSharedWorkerExecutor(name, workerPoolSize, vertxMaxWorkerExecuteTime, TimeUnit.SECONDS);
			LOG.info(configureSharedWorkerExecutorComplete, name);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureSharedWorkerExecutorFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Val.Success.enUS: The Kafka producer was initialized successfully. 
	 **/
	public Future<KafkaProducer<String, String>> configureKafka() {
		Promise<KafkaProducer<String, String>> promise = Promise.promise();

		try {
			if(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_KAFKA))) {
				Map<String, String> kafkaConfig = new HashMap<>();
				kafkaConfig.put("bootstrap.servers", config().getString(ConfigKeys.KAFKA_BROKERS));
				kafkaConfig.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
				kafkaConfig.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
				kafkaConfig.put("acks", "1");
				kafkaConfig.put("security.protocol", "SSL");
				kafkaConfig.put("ssl.keystore.type", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_TYPE));
				kafkaConfig.put("ssl.keystore.location", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_LOCATION));
				kafkaConfig.put("ssl.keystore.password", config().getString(ConfigKeys.KAFKA_SSL_KEYSTORE_PASSWORD));
				kafkaConfig.put("ssl.truststore.type", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_TYPE));
				kafkaConfig.put("ssl.truststore.location", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_LOCATION));
				kafkaConfig.put("ssl.truststore.password", config().getString(ConfigKeys.KAFKA_SSL_TRUSTSTORE_PASSWORD));

				kafkaProducer = KafkaProducer.createShared(vertx, config().getString(ConfigKeys.SITE_NAME), kafkaConfig);
				LOG.info(configureKafkaSuccess);
				promise.complete(kafkaProducer);
			} else {
				LOG.info(configureKafkaSuccess);
				promise.complete(null);
			}
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 **/
	public Future<MqttClient> configureMqtt() {
		Promise<MqttClient> promise = Promise.promise();

		try {
			if(BooleanUtils.isTrue(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_MQTT)))) {
				try {
					mqttClient = MqttClient.create(vertx);
					mqttClient.connect(Integer.parseInt(config().getString(ConfigKeys.MQTT_PORT)), config().getString(ConfigKeys.MQTT_HOST_NAME)).onSuccess(mqttConnection -> {
						try {
							mqttClient.publishHandler(message -> {
								LOG.info(String.format("MQTT: %s", message.payload().toString(Charset.defaultCharset())));
							}).subscribe("workbench-user1", MqttQoS.EXACTLY_ONCE.value());
							LOG.info("The MQTT client was initialized successfully.");
							promise.complete(mqttClient);
						} catch(Exception ex) {
							LOG.error("The MQTT client failed to initialize.", ex);
							promise.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error("The MQTT client failed to initialize.", ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error("The MQTT client failed to initialize.", ex);
					promise.fail(ex);
				}
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("The MQTT client failed to initialize.", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 **/
	public Future<AmqpClient> configureAmqp() {
		Promise<AmqpClient> promise = Promise.promise();

		try {
			if(BooleanUtils.isTrue(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_AMQP)))) {
				try {
					AmqpClientOptions options = new AmqpClientOptions()
							.setHost(config().getString(ConfigKeys.AMQP_HOST_NAME))
							.setPort(Integer.parseInt(config().getString(ConfigKeys.AMQP_PORT)))
							.setUsername(config().getString(ConfigKeys.AMQP_USERNAME))
							.setPassword(config().getString(ConfigKeys.AMQP_PASSWORD))
							.setVirtualHost(config().getString(ConfigKeys.AMQP_VIRTUAL_HOST))
							;
					amqpClient = AmqpClient.create(vertx, options);
					amqpClient.connect().onSuccess(amqpConnection -> {
						try {
							AmqpSenderOptions senderOptions = new AmqpSenderOptions();
							amqpConnection
									.createSender("my-queue", senderOptions)
									.onSuccess(sender -> {
								this.amqpSender = sender;
								LOG.info("The AMQP client was initialized successfully.");
								promise.complete(amqpClient);
							}).onFailure(ex -> {
								LOG.error("The AMQP client failed to initialize.", ex);
								promise.fail(ex);
							});
						} catch(Exception ex) {
							LOG.error("The AMQP client failed to initialize.", ex);
							promise.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error("The AMQP client failed to initialize.", ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error("The AMQP client failed to initialize.", ex);
					promise.fail(ex);
				}
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("The AMQP client failed to initialize.", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**
	 **/
	public Future<RabbitMQClient> configureRabbitmq() {
		Promise<RabbitMQClient> promise = Promise.promise();

		try {
			if(BooleanUtils.isTrue(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_RABBITMQ)))) {
				try {
					RabbitMQOptions options = new RabbitMQOptions()
							.setHost(config().getString(ConfigKeys.RABBITMQ_HOST_NAME))
							.setPort(Integer.parseInt(config().getString(ConfigKeys.RABBITMQ_PORT)))
							.setUser(config().getString(ConfigKeys.RABBITMQ_USERNAME))
							.setPassword(config().getString(ConfigKeys.RABBITMQ_PASSWORD))
							.setVirtualHost(config().getString(ConfigKeys.RABBITMQ_VIRTUAL_HOST))
							.setAutomaticRecoveryEnabled(true)
							;
					this.rabbitmqClient = RabbitMQClient.create(vertx, options);
					rabbitmqClient.start().onSuccess(a -> {
						LOG.info("The AMQP client was initialized successfully.");
						promise.complete(rabbitmqClient);
					}).onFailure(ex -> {
						LOG.error("The AMQP client failed to initialize.", ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error("The AMQP client failed to initialize.", ex);
					promise.fail(ex);
				}
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("The AMQP client failed to initialize.", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	public <API_IMPL extends BaseApiServiceInterface> void initializeApiService(API_IMPL service) {
		service.setVertx(vertx);
		service.setEventBus(vertx.eventBus());
		service.setConfig(config());
		service.setWorkerExecutor(workerExecutor);
		service.setOauth2AuthHandler(oauth2AuthHandler);
		service.setPgPool(pgPool);
		service.setKafkaProducer(kafkaProducer);
		service.setMqttClient(mqttClient);
		service.setAmqpClient(amqpClient);
		service.setRabbitmqClient(rabbitmqClient);
		service.setWebClient(webClient);
		service.setJinjava(jinjava);
		service.setI18n(i18n);
	}

	/**
	 * Description: Import initial data
	 * Val.Skip.enUS: The data import is disabled. 
	 **/
	private Future<Void> importData() {
		Promise<Void> promise = Promise.promise();
		if(Boolean.valueOf(config().getString(ConfigKeys.ENABLE_IMPORT_DATA))) {
			SiteRequest siteRequest = new SiteRequest();
			siteRequest.setConfig(config());
			siteRequest.setWebClient(webClient);
			siteRequest.initDeepSiteRequest(siteRequest);
			siteRequest.addScopes("GET");
			String templatePath = config().getString(ComputateConfigKeys.TEMPLATE_PATH);

			TimeZoneEnUSApiServiceImpl apiTimeZone = new TimeZoneEnUSApiServiceImpl();
			initializeApiService(apiTimeZone);
			FeedEnUSApiServiceImpl apiFeed = new FeedEnUSApiServiceImpl();
			initializeApiService(apiFeed);
			FeederEnUSApiServiceImpl apiFeeder = new FeederEnUSApiServiceImpl();
			initializeApiService(apiFeeder);
			FeedingOperationEnUSApiServiceImpl apiFeedingOperation = new FeedingOperationEnUSApiServiceImpl();
			initializeApiService(apiFeedingOperation);
			FishPopulationEnUSApiServiceImpl apiFishPopulation = new FishPopulationEnUSApiServiceImpl();
			initializeApiService(apiFishPopulation);
			SitePageEnUSApiServiceImpl apiSitePage = new SitePageEnUSApiServiceImpl();
			initializeApiService(apiSitePage);
			FishingTripEnUSApiServiceImpl apiFishingTrip = new FishingTripEnUSApiServiceImpl();
			initializeApiService(apiFishingTrip);
			FishFarmEnUSApiServiceImpl apiFishFarm = new FishFarmEnUSApiServiceImpl();
			initializeApiService(apiFishFarm);
			FishingDockEnUSApiServiceImpl apiFishingDock = new FishingDockEnUSApiServiceImpl();
			initializeApiService(apiFishingDock);
			FishProcessingEnUSApiServiceImpl apiFishProcessing = new FishProcessingEnUSApiServiceImpl();
			initializeApiService(apiFishProcessing);

			apiTimeZone.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, TimeZone.CLASS_CANONICAL_NAME, TimeZone.CLASS_SIMPLE_NAME, TimeZone.CLASS_API_ADDRESS_TimeZone, "id", "userPage", "download").onSuccess(q1 -> {
				apiFeed.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, Feed.CLASS_CANONICAL_NAME, Feed.CLASS_SIMPLE_NAME, Feed.CLASS_API_ADDRESS_Feed, "entityShortId", "userPage", "download").onSuccess(q2 -> {
					apiFeeder.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, Feeder.CLASS_CANONICAL_NAME, Feeder.CLASS_SIMPLE_NAME, Feeder.CLASS_API_ADDRESS_Feeder, "entityShortId", "userPage", "download").onSuccess(q3 -> {
						apiFeedingOperation.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FeedingOperation.CLASS_CANONICAL_NAME, FeedingOperation.CLASS_SIMPLE_NAME, FeedingOperation.CLASS_API_ADDRESS_FeedingOperation, "entityShortId", "userPage", "download").onSuccess(q4 -> {
							apiFishPopulation.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FishPopulation.CLASS_CANONICAL_NAME, FishPopulation.CLASS_SIMPLE_NAME, FishPopulation.CLASS_API_ADDRESS_FishPopulation, "entityShortId", "userPage", "download").onSuccess(q5 -> {
								apiSitePage.importTimer(Paths.get(templatePath, "/en-us/view/article"), vertx, siteRequest, SitePage.CLASS_CANONICAL_NAME, SitePage.CLASS_SIMPLE_NAME, SitePage.CLASS_API_ADDRESS_SitePage, "pageId", "userPage", "download").onSuccess(q6 -> {
									apiFishingTrip.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FishingTrip.CLASS_CANONICAL_NAME, FishingTrip.CLASS_SIMPLE_NAME, FishingTrip.CLASS_API_ADDRESS_FishingTrip, "entityShortId", "userPage", "download").onSuccess(q7 -> {
										apiFishFarm.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FishFarm.CLASS_CANONICAL_NAME, FishFarm.CLASS_SIMPLE_NAME, FishFarm.CLASS_API_ADDRESS_FishFarm, "entityShortId", "userPage", "download").onSuccess(q8 -> {
											apiFishingDock.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FishingDock.CLASS_CANONICAL_NAME, FishingDock.CLASS_SIMPLE_NAME, FishingDock.CLASS_API_ADDRESS_FishingDock, "entityShortId", "userPage", "download").onSuccess(q9 -> {
												apiFishProcessing.importTimer(Paths.get(templatePath, "TODO"), vertx, siteRequest, FishProcessing.CLASS_CANONICAL_NAME, FishProcessing.CLASS_SIMPLE_NAME, FishProcessing.CLASS_API_ADDRESS_FishProcessing, "entityShortId", "userPage", "download").onSuccess(q10 -> {
													LOG.info("data import complete");
													promise.complete();
												}).onFailure(ex -> promise.fail(ex));
											}).onFailure(ex -> promise.fail(ex));
										}).onFailure(ex -> promise.fail(ex));
									}).onFailure(ex -> promise.fail(ex));
								}).onFailure(ex -> promise.fail(ex));
							}).onFailure(ex -> promise.fail(ex));
						}).onFailure(ex -> promise.fail(ex));
					}).onFailure(ex -> promise.fail(ex));
				}).onFailure(ex -> promise.fail(ex));
			}).onFailure(ex -> promise.fail(ex));
		}
		else {
			LOG.info(importDataSkip);
			promise.complete();
		}
		return promise.future();
	}
}
