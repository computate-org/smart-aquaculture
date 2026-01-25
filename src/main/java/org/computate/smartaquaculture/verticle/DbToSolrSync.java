/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.smartaquaculture.verticle;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hubspot.jinjava.Jinjava;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.VertxBuilder;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgBuilder;
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;

import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.model.fiware.feedingoperation.FeedingOperation;
import org.computate.smartaquaculture.model.fiware.feeder.Feeder;
import org.computate.smartaquaculture.model.fiware.feed.Feed;
import org.computate.smartaquaculture.model.mapmodel.MapModel;
import org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation;
import org.computate.smartaquaculture.model.fiware.fishfarm.FishFarm;
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock;
import org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing;
import org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip;
import org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat;


/**
 * Description: A Java class to start the Vert.x application as a main method. 
 * Keyword: classSimpleNameVerticle
 **/
public class DbToSolrSync extends DbToSolrSyncGen<AbstractVerticle> {
  private static final Logger LOG = LoggerFactory.getLogger(DbToSolrSync.class);

  /**
   * The main method for the Vert.x application that runs the Vert.x Runner class
   **/
  public static void  main(String[] args) {
    Vertx vertx = Vertx.vertx();
    String configVarsPath = System.getenv(ConfigKeys.VARS_PATH);
    configureConfig(vertx).onSuccess(config -> {
      runDbToSolrSync(config).onSuccess(a -> {
        vertx.close();
        System.exit(0);
      }).onFailure(ex -> {
        LOG.error("Error syncing database to Solr", ex);
        vertx.close();
        System.exit(0);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("Error loading config: %s", configVarsPath), ex);
      vertx.close();
      System.exit(0);
    });
  }

  /**
   **/
  public static Future<JsonObject> configureConfig(Vertx vertx) {
    Promise<JsonObject> promise = Promise.promise();

    try {
      ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions();

      String configVarsPath = System.getenv(ComputateConfigKeys.VARS_PATH);
      if(StringUtils.isNotBlank(configVarsPath)) {
        Jinjava jinjava = ComputateConfigKeys.getJinjava();
        JsonObject config = ComputateConfigKeys.getConfig(jinjava);
        ConfigStoreOptions configOptions = new ConfigStoreOptions().setType("json").setConfig(config);
        retrieverOptions.addStore(configOptions);
      }

      ConfigStoreOptions storeEnv = new ConfigStoreOptions().setType("env");
      retrieverOptions.addStore(storeEnv);

      ConfigRetriever configRetriever = ConfigRetriever.create(vertx, retrieverOptions);
      configRetriever.getConfig().onSuccess(config -> {
        LOG.info("The config was configured successfully. ");
        promise.complete(config);
      }).onFailure(ex -> {
        LOG.error("Unable to configure site context. ", ex);
        promise.fail(ex);
      });
    } catch(Exception ex) {
      LOG.error("Unable to configure site context. ", ex);
      promise.fail(ex);
    }

    return promise.future();
  }

  /**
   * Description: Static method to sync Solr search engine records with database. 
   * Val.Complete.enUS: database to solr sync completed. 
   **/
  public static Future<Void> runDbToSolrSync(JsonObject config) {
    Promise<Void> promise = Promise.promise();
    try {
      Boolean enableZookeeperCluster = Boolean.valueOf(config.getString(ConfigKeys.ENABLE_ZOOKEEPER_CLUSTER));
      VertxOptions vertxOptions = new VertxOptions();
      EventBusOptions eventBusOptions = new EventBusOptions();
  
      ClusterManager clusterManager = null;
      if(enableZookeeperCluster) {
        JsonObject zkConfig = new JsonObject();
        String zookeeperHostName = config.getString(ConfigKeys.ZOOKEEPER_HOST_NAME);
        Integer zookeeperPort = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_PORT));
        String zookeeperHosts = Optional.ofNullable(config.getString(ConfigKeys.ZOOKEEPER_HOSTS)).orElse(zookeeperHostName + ":" + zookeeperPort);
        String clusterHostName = config.getString(ConfigKeys.CLUSTER_HOST_NAME);
        Integer clusterPort = Integer.parseInt(config.getString(ConfigKeys.CLUSTER_PORT));
        String clusterPublicHostName = config.getString(ConfigKeys.CLUSTER_PUBLIC_HOST_NAME);
        Integer clusterPublicPort = Integer.parseInt(config.getString(ConfigKeys.CLUSTER_PUBLIC_PORT));
        String zookeeperRetryPolicy = config.getString(ConfigKeys.ZOOKEEPER_RETRY_POLICY);
        Integer zookeeperBaseSleepTimeMillis = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_BASE_SLEEP_TIME_MILLIS));
        Integer zookeeperMaxSleepMillis = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_MAX_SLEEP_MILLIS));
        Integer zookeeperMaxRetries = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_MAX_RETRIES));
        Integer zookeeperConnectionTimeoutMillis = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_CONNECTION_TIMEOUT_MILLIS));
        Integer zookeeperSessionTimeoutMillis = Integer.parseInt(config.getString(ConfigKeys.ZOOKEEPER_SESSION_TIMEOUT_MILLIS));
        zkConfig.put("zookeeperHosts", zookeeperHosts);
        zkConfig.put("sessionTimeout", zookeeperSessionTimeoutMillis);
        zkConfig.put("connectTimeout", zookeeperConnectionTimeoutMillis);
        zkConfig.put("rootPath", config.getString(ConfigKeys.SITE_NAME));
        zkConfig.put("retry", new JsonObject()
            .put("policy", zookeeperRetryPolicy)
            .put("initialSleepTime", zookeeperBaseSleepTimeMillis)
            .put("intervalTimes", zookeeperMaxSleepMillis)
            .put("maxTimes", zookeeperMaxRetries)
        );
        clusterManager = new ZookeeperClusterManager(zkConfig);
  
        if(clusterHostName != null) {
          LOG.info(String.format("%s — %s", ConfigKeys.CLUSTER_HOST_NAME, clusterHostName));
          eventBusOptions.setHost(clusterHostName);
        }
        if(clusterPort != null) {
          LOG.info(String.format("%s — %s", ConfigKeys.CLUSTER_PORT, clusterPort));
          eventBusOptions.setPort(clusterPort);
        }
        if(clusterPublicHostName != null) {
          LOG.info(String.format("%s — %s", ConfigKeys.CLUSTER_PUBLIC_HOST_NAME, clusterPublicHostName));
          eventBusOptions.setClusterPublicHost(clusterPublicHostName);
        }
        if(clusterPublicPort != null) {
          LOG.info(String.format("%s — %s", ConfigKeys.CLUSTER_PUBLIC_PORT, clusterPublicPort));
          eventBusOptions.setClusterPublicPort(clusterPublicPort);
        }
      }
      Long vertxWarningExceptionSeconds = config.getLong(ConfigKeys.VERTX_WARNING_EXCEPTION_SECONDS);
      Long vertxMaxEventLoopExecuteTime = config.getLong(ConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME);
      Long vertxMaxWorkerExecuteTime = config.getLong(ConfigKeys.VERTX_MAX_WORKER_EXECUTE_TIME);
      vertxOptions.setEventBusOptions(eventBusOptions);
      vertxOptions.setWarningExceptionTime(vertxWarningExceptionSeconds);
      vertxOptions.setWarningExceptionTimeUnit(TimeUnit.SECONDS);
      vertxOptions.setMaxEventLoopExecuteTime(vertxMaxEventLoopExecuteTime);
      vertxOptions.setMaxEventLoopExecuteTimeUnit(TimeUnit.SECONDS);
      vertxOptions.setMaxWorkerExecuteTime(vertxMaxWorkerExecuteTime);
      vertxOptions.setMaxWorkerExecuteTimeUnit(TimeUnit.SECONDS);
      vertxOptions.setWorkerPoolSize(Integer.parseInt(config.getString(ConfigKeys.WORKER_POOL_SIZE)));
      VertxBuilder vertxBuilder = Vertx.builder();
      vertxBuilder.with(vertxOptions);
      vertxBuilder.withClusterManager(clusterManager);
      vertxBuilder.buildClustered().onSuccess(vertx -> {
        dbToSolrSync(vertx, config).onSuccess(a -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error("Starting the database Solr sync failed. ", ex);
          promise.fail(ex);
        });
      }).onFailure(ex -> {
        LOG.error("Starting the database Solr sync failed. ", ex);
        promise.fail(ex);
      });
    } catch (Exception ex) {
      LOG.error("Could not initialize the database schema.", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  /**
   * Description: Import initial data
   * Val.Complete.enUS: database to solr sync completed. 
   **/
  public static Future<Void> dbToSolrSync(Vertx vertx, JsonObject config) {
    Promise<Void> promise = Promise.promise();
    try {
      PgConnectOptions pgOptions = new PgConnectOptions();
      pgOptions.setPort(Integer.parseInt(config.getString(ConfigKeys.DATABASE_PORT)));
      pgOptions.setHost(config.getString(ConfigKeys.DATABASE_HOST_NAME));
      pgOptions.setDatabase(config.getString(ConfigKeys.DATABASE_DATABASE));
      pgOptions.setUser(config.getString(ConfigKeys.DATABASE_USERNAME));
      pgOptions.setPassword(config.getString(ConfigKeys.DATABASE_PASSWORD));
      pgOptions.setIdleTimeout(Integer.parseInt(config.getString(ConfigKeys.DATABASE_MAX_IDLE_TIME)));
      pgOptions.setIdleTimeoutUnit(TimeUnit.SECONDS);
      pgOptions.setConnectTimeout(Integer.parseInt(config.getString(ConfigKeys.DATABASE_CONNECT_TIMEOUT)));

      PoolOptions poolOptions = new PoolOptions();
      poolOptions.setMaxSize(Integer.parseInt(config.getString(ConfigKeys.DATABASE_MAX_POOL_SIZE)));
      poolOptions.setMaxWaitQueueSize(Integer.parseInt(config.getString(ConfigKeys.DATABASE_MAX_WAIT_QUEUE_SIZE)));

      Pool pgPool = PgBuilder.pool().connectingTo(pgOptions).with(poolOptions).using(vertx).build();
      dbToSolrSyncRecord(vertx, config, pgPool, FeedingOperation.CLASS_SIMPLE_NAME).onSuccess(q1 -> {
        dbToSolrSyncRecord(vertx, config, pgPool, Feeder.CLASS_SIMPLE_NAME).onSuccess(q2 -> {
          dbToSolrSyncRecord(vertx, config, pgPool, Feed.CLASS_SIMPLE_NAME).onSuccess(q3 -> {
            dbToSolrSyncRecord(vertx, config, pgPool, MapModel.CLASS_SIMPLE_NAME).onSuccess(q4 -> {
              dbToSolrSyncRecord(vertx, config, pgPool, FishPopulation.CLASS_SIMPLE_NAME).onSuccess(q5 -> {
                dbToSolrSyncRecord(vertx, config, pgPool, FishFarm.CLASS_SIMPLE_NAME).onSuccess(q6 -> {
                  dbToSolrSyncRecord(vertx, config, pgPool, FishingDock.CLASS_SIMPLE_NAME).onSuccess(q7 -> {
                    dbToSolrSyncRecord(vertx, config, pgPool, FishProcessing.CLASS_SIMPLE_NAME).onSuccess(q8 -> {
                      dbToSolrSyncRecord(vertx, config, pgPool, FishingTrip.CLASS_SIMPLE_NAME).onSuccess(q9 -> {
                        dbToSolrSyncRecord(vertx, config, pgPool, FishingBoat.CLASS_SIMPLE_NAME).onSuccess(q10 -> {
                          LOG.info(dbToSolrSyncComplete);
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
    } catch (Exception ex) {
      LOG.error("Could not initialize the database schema.", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  /**
   * Sync %s data from the database to Solr. 
   * Val.Complete.enUS: %s data sync completed. 
   * Val.Fail.enUS: %s data sync failed. 
   * Val.CounterResetFail.enUS: %s data sync failed to reset counter. 
   * Val.Skip.enUS: %s data sync skipped. 
   * Val.Started.enUS: %s data sync started. 
   **/
  public static Future<Void> dbToSolrSyncRecord(Vertx vertx, JsonObject config, Pool pgPool, String tableName) {
    Promise<Void> promise = Promise.promise();
    try {
      LOG.info(String.format(dbToSolrSyncRecordStarted, tableName));
      pgPool.withTransaction(sqlConnection -> {
        Promise<Void> promise1 = Promise.promise();
        sqlConnection.query(String.format("SELECT count(pk) FROM %s", tableName)).execute().onSuccess(countRowSet -> {
          try {
            Optional<Long> rowCountOptional = Optional.ofNullable(countRowSet.iterator().next()).map(row -> row.getLong(0));
            if(rowCountOptional.isPresent()) {
              Long apiCounterResume = config.getLong(ConfigKeys.API_COUNTER_RESUME);
              Integer apiCounterFetch = config.getInteger(ConfigKeys.API_COUNTER_FETCH);
              ApiCounter apiCounter = new ApiCounter();
  
              SiteRequest siteRequest = new SiteRequest();
              siteRequest.setConfig(config);
              siteRequest.initDeepSiteRequest(siteRequest);
    
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(apiCounterFetch.longValue());
              apiRequest.setNumFound(rowCountOptional.get());
              apiRequest.setNumPATCH(apiCounter.getQueueNum());
              apiRequest.setCreated(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));
              apiRequest.initDeepApiRequest(siteRequest);
              vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
    
              sqlConnection.prepare(String.format("SELECT pk FROM %s", tableName)).onSuccess(preparedStatement -> {
                apiCounter.setQueueNum(0L);
                apiCounter.setTotalNum(0L);
                try {
                  RowStream<Row> stream = preparedStatement.createStream(apiCounterFetch);
                  stream.pause();
                  stream.fetch(apiCounterFetch);
                  stream.exceptionHandler(ex -> {
                    LOG.error(String.format(dbToSolrSyncRecordFail, tableName), new RuntimeException(ex));
                    promise1.fail(ex);
                  });
                  stream.endHandler(v -> {
                    LOG.info(String.format(dbToSolrSyncRecordComplete, tableName));
                    promise1.complete();
                  });
                  stream.handler(row -> {
                    apiCounter.incrementQueueNum();
                    try {
                      vertx.eventBus().request(
                          String.format("ai-telemetry-enUS-%s", tableName)
                          , new JsonObject().put(
                              "context"
                              , new JsonObject().put(
                                  "params"
                                  , new JsonObject()
                                      .put("body", new JsonObject().put("pk", row.getLong(0).toString()))
                                      .put("path", new JsonObject())
                                      .put("cookie", new JsonObject())
                                      .put("scopes", new JsonArray().add("GET"))
                                      .put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + row.getLong(0))).put("var", new JsonArray().add("refresh:false")))
                              )
                          )
                          , new DeliveryOptions().addHeader("action", String.format("patch%sFuture", tableName))).onSuccess(a -> {
                        apiCounter.incrementTotalNum();
                        apiCounter.decrementQueueNum();
                        if(apiCounter.getQueueNum().compareTo(apiCounterResume) == 0) {
                          stream.fetch(apiCounterFetch);
                          apiRequest.setNumPATCH(apiCounter.getTotalNum());
                          apiRequest.setTimeRemaining(apiRequest.calculateTimeRemaining());
                          vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
                        }
                      }).onFailure(ex -> {
                        LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
                        promise1.fail(ex);
                      });
                    } catch (Exception ex) {
                      LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
                      promise1.fail(ex);
                    }
                  });
                } catch (Exception ex) {
                  LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
                  promise1.fail(ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
                promise1.fail(ex);
              });
            } else {
              promise1.complete();
            }
          } catch (Exception ex) {
            LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
            promise1.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
          promise1.fail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
        promise.fail(ex);
      });
    } catch (Exception ex) {
      LOG.error(String.format(dbToSolrSyncRecordFail, tableName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }
}
