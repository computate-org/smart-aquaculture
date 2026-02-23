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

import org.computate.smartaquaculture.request.SiteRequest;
import io.vertx.core.AbstractVerticle;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.vertx.api.ApiRequest;
import org.computate.smartaquaculture.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these DbToSolrSync objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class DbToSolrSyncGen into the class DbToSolrSync. 
 * </li>
 * <h3>About the DbToSolrSync class and it's generated class DbToSolrSyncGen&lt;AbstractVerticle&gt;: </h3>extends DbToSolrSyncGen
 * <p>
 * This Java class extends a generated Java class DbToSolrSyncGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.verticle.DbToSolrSync">Find the class DbToSolrSync in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends DbToSolrSyncGen<AbstractVerticle>
 * <p>This <code>class DbToSolrSync extends DbToSolrSyncGen&lt;AbstractVerticle&gt;</code>, which means it extends a newly generated DbToSolrSyncGen. 
 * The generated <code>class DbToSolrSyncGen extends AbstractVerticle</code> which means that DbToSolrSync extends DbToSolrSyncGen which extends AbstractVerticle. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the DbToSolrSync class will inherit the helpful inherited class comments from the super class DbToSolrSyncGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class DbToSolrSync in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.verticle.DbToSolrSync&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.verticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.verticle&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class DbToSolrSyncGen<DEV> extends AbstractVerticle {
  protected static final Logger LOG = LoggerFactory.getLogger(DbToSolrSync.class);

  public static final String SITE_NAME = "smart-aquaculture";
  public static final String runDbToSolrSyncComplete1 = "database to solr sync completed. ";
  public static final String runDbToSolrSyncComplete = runDbToSolrSyncComplete1;

  public static final String dbToSolrSyncComplete1 = "database to solr sync completed. ";
  public static final String dbToSolrSyncComplete = dbToSolrSyncComplete1;

  public static final String dbToSolrSyncRecordComplete1 = "%s data sync completed. ";
  public static final String dbToSolrSyncRecordComplete = dbToSolrSyncRecordComplete1;
  public static final String dbToSolrSyncRecordFail1 = "%s data sync failed. ";
  public static final String dbToSolrSyncRecordFail = dbToSolrSyncRecordFail1;
  public static final String dbToSolrSyncRecordCounterResetFail1 = "%s data sync failed to reset counter. ";
  public static final String dbToSolrSyncRecordCounterResetFail = dbToSolrSyncRecordCounterResetFail1;
  public static final String dbToSolrSyncRecordSkip1 = "%s data sync skipped. ";
  public static final String dbToSolrSyncRecordSkip = dbToSolrSyncRecordSkip1;
  public static final String dbToSolrSyncRecordStarted1 = "%s data sync started. ";
  public static final String dbToSolrSyncRecordStarted = dbToSolrSyncRecordStarted1;


  //////////////
  // initDeep //
  //////////////

  public DbToSolrSync initDeepDbToSolrSync(SiteRequest siteRequest_) {
    initDeepDbToSolrSync();
    return (DbToSolrSync)this;
  }

  public void initDeepDbToSolrSync() {
    initDbToSolrSync();
  }

  public void initDbToSolrSync() {
  }

  public void initDeepForClass(SiteRequest siteRequest_) {
    initDeepDbToSolrSync(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainDbToSolrSync(v);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.obtainForClass(v);
      }
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainDbToSolrSync(String var) {
    DbToSolrSync oDbToSolrSync = (DbToSolrSync)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // relate //
  ///////////////

  public boolean relateForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = relateDbToSolrSync(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateDbToSolrSync(String var, Object val) {
    DbToSolrSync oDbToSolrSync = (DbToSolrSync)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, DbToSolrSync o) {
    return staticSetDbToSolrSync(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetDbToSolrSync(String entityVar, SiteRequest siteRequest_, String v, DbToSolrSync o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchDbToSolrSync(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchDbToSolrSync(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrDbToSolrSync(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrDbToSolrSync(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqDbToSolrSync(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqDbToSolrSync(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    return sb.toString();
  }

  public static final String[] DbToSolrSyncVals = new String[] { runDbToSolrSyncComplete1, dbToSolrSyncComplete1, dbToSolrSyncRecordComplete1, dbToSolrSyncRecordFail1, dbToSolrSyncRecordCounterResetFail1, dbToSolrSyncRecordSkip1, dbToSolrSyncRecordStarted1 };

  public static final String CLASS_SIMPLE_NAME = "DbToSolrSync";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.verticle.DbToSolrSync";
  public static final String CLASS_AUTH_RESOURCE = "";


  public static String displayNameForClass(String var) {
    return DbToSolrSync.displayNameDbToSolrSync(var);
  }
  public static String displayNameDbToSolrSync(String var) {
    switch(var) {
    default:
      return null;
    }
  }
}
