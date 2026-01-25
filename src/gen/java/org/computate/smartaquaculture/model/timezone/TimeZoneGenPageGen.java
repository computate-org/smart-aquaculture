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
package org.computate.smartaquaculture.model.timezone;

import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.page.PageLayout;
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
import org.computate.vertx.search.list.SearchList;
import org.computate.smartaquaculture.model.timezone.TimeZone;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.Integer;
import java.time.ZoneId;
import java.util.Locale;
import java.lang.Long;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.serialize.vertx.JsonArrayDeserializer;
import java.lang.Void;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these TimeZoneGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TimeZoneGenPageGen into the class TimeZoneGenPage. 
 * </li>
 * <h3>About the TimeZoneGenPage class and it's generated class TimeZoneGenPageGen&lt;PageLayout&gt;: </h3>extends TimeZoneGenPageGen
 * <p>
 * This Java class extends a generated Java class TimeZoneGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage">Find the class TimeZoneGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TimeZoneGenPageGen<PageLayout>
 * <p>This <code>class TimeZoneGenPage extends TimeZoneGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated TimeZoneGenPageGen. 
 * The generated <code>class TimeZoneGenPageGen extends PageLayout</code> which means that TimeZoneGenPage extends TimeZoneGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TimeZoneGenPage class will inherit the helpful inherited class comments from the super class TimeZoneGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TimeZoneGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class TimeZoneGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.timezone in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.timezone&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class TimeZoneGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(TimeZoneGenPage.class);

	/////////////////////////
  // searchListTimeZone_ //
	/////////////////////////


  /**
   *  The entity searchListTimeZone_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<TimeZone> searchListTimeZone_;

  /**
   * <br> The entity searchListTimeZone_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:searchListTimeZone_">Find the entity searchListTimeZone_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListTimeZone_(Wrap<SearchList<TimeZone>> w);

  public SearchList<TimeZone> getSearchListTimeZone_() {
    return searchListTimeZone_;
  }

  public void setSearchListTimeZone_(SearchList<TimeZone> searchListTimeZone_) {
    this.searchListTimeZone_ = searchListTimeZone_;
  }
  public static SearchList<TimeZone> staticSetSearchListTimeZone_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected TimeZoneGenPage searchListTimeZone_Init() {
    Wrap<SearchList<TimeZone>> searchListTimeZone_Wrap = new Wrap<SearchList<TimeZone>>().var("searchListTimeZone_");
    if(searchListTimeZone_ == null) {
      _searchListTimeZone_(searchListTimeZone_Wrap);
      Optional.ofNullable(searchListTimeZone_Wrap.getO()).ifPresent(o -> {
        setSearchListTimeZone_(o);
      });
    }
    return (TimeZoneGenPage)this;
  }

	//////////////////
  // listTimeZone //
	//////////////////


  /**
   *  The entity listTimeZone
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listTimeZone = new JsonArray();

  /**
   * <br> The entity listTimeZone
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:listTimeZone">Find the entity listTimeZone in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listTimeZone(JsonArray l);

  public JsonArray getListTimeZone() {
    return listTimeZone;
  }

  public void setListTimeZone(JsonArray listTimeZone) {
    this.listTimeZone = listTimeZone;
  }
  @JsonIgnore
  public void setListTimeZone(String o) {
    this.listTimeZone = TimeZoneGenPage.staticSetListTimeZone(siteRequest_, o);
  }
  public static JsonArray staticSetListTimeZone(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected TimeZoneGenPage listTimeZoneInit() {
    _listTimeZone(listTimeZone);
    return (TimeZoneGenPage)this;
  }

  public static String staticSearchListTimeZone(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListTimeZone(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListTimeZone(SiteRequest siteRequest_, String o) {
    return TimeZoneGenPage.staticSearchListTimeZone(siteRequest_, TimeZoneGenPage.staticSetListTimeZone(siteRequest_, o)).toString();
  }

	/////////////////
  // resultCount //
	/////////////////


  /**
   *  The entity resultCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer resultCount;

  /**
   * <br> The entity resultCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _resultCount(Wrap<Integer> w);

  public Integer getResultCount() {
    return resultCount;
  }

  public void setResultCount(Integer resultCount) {
    this.resultCount = resultCount;
  }
  @JsonIgnore
  public void setResultCount(String o) {
    this.resultCount = TimeZoneGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected TimeZoneGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (TimeZoneGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return TimeZoneGenPage.staticSearchResultCount(siteRequest_, TimeZoneGenPage.staticSetResultCount(siteRequest_, o)).toString();
  }

	////////////
  // result //
	////////////


  /**
   *  The entity result
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected TimeZone result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<TimeZone> w);

  public TimeZone getResult() {
    return result;
  }

  public void setResult(TimeZone result) {
    this.result = result;
  }
  public static TimeZone staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected TimeZoneGenPage resultInit() {
    Wrap<TimeZone> resultWrap = new Wrap<TimeZone>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (TimeZoneGenPage)this;
  }

	////////////
  // solrId //
	////////////


  /**
   *  The entity solrId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String solrId;

  /**
   * <br> The entity solrId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = TimeZoneGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected TimeZoneGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (TimeZoneGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return TimeZoneGenPage.staticSearchSolrId(siteRequest_, TimeZoneGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	/////////////////////
  // pageUriTimeZone //
	/////////////////////


  /**
   *  The entity pageUriTimeZone
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriTimeZone;

  /**
   * <br> The entity pageUriTimeZone
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZoneGenPage&fq=entiteVar_enUS_indexed_string:pageUriTimeZone">Find the entity pageUriTimeZone in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriTimeZone(Wrap<String> c);

  public String getPageUriTimeZone() {
    return pageUriTimeZone;
  }
  public void setPageUriTimeZone(String o) {
    this.pageUriTimeZone = TimeZoneGenPage.staticSetPageUriTimeZone(siteRequest_, o);
  }
  public static String staticSetPageUriTimeZone(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected TimeZoneGenPage pageUriTimeZoneInit() {
    Wrap<String> pageUriTimeZoneWrap = new Wrap<String>().var("pageUriTimeZone");
    if(pageUriTimeZone == null) {
      _pageUriTimeZone(pageUriTimeZoneWrap);
      Optional.ofNullable(pageUriTimeZoneWrap.getO()).ifPresent(o -> {
        setPageUriTimeZone(o);
      });
    }
    return (TimeZoneGenPage)this;
  }

  public static String staticSearchPageUriTimeZone(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriTimeZone(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriTimeZone(SiteRequest siteRequest_, String o) {
    return TimeZoneGenPage.staticSearchPageUriTimeZone(siteRequest_, TimeZoneGenPage.staticSetPageUriTimeZone(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<TimeZoneGenPageGen<DEV>> promiseDeepTimeZoneGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepTimeZoneGenPage();
  }

  public Future<TimeZoneGenPageGen<DEV>> promiseDeepTimeZoneGenPage() {
    Promise<TimeZoneGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseTimeZoneGenPage(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseTimeZoneGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListTimeZone_Init();
        listTimeZoneInit();
        resultCountInit();
        resultInit();
        solrIdInit();
        pageUriTimeZoneInit();
        promise2.complete();
      } catch(Exception ex) {
        promise2.fail(ex);
      }
      return promise2.future();
    }).onSuccess(a -> {
      promise.complete();
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  @Override public Future<? extends TimeZoneGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepTimeZoneGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestTimeZoneGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestTimeZoneGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainTimeZoneGenPage(v);
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
  public Object obtainTimeZoneGenPage(String var) {
    TimeZoneGenPage oTimeZoneGenPage = (TimeZoneGenPage)this;
    switch(var) {
      case "searchListTimeZone_":
        return oTimeZoneGenPage.searchListTimeZone_;
      case "listTimeZone":
        return oTimeZoneGenPage.listTimeZone;
      case "resultCount":
        return oTimeZoneGenPage.resultCount;
      case "result":
        return oTimeZoneGenPage.result;
      case "solrId":
        return oTimeZoneGenPage.solrId;
      case "pageUriTimeZone":
        return oTimeZoneGenPage.pageUriTimeZone;
      default:
        return super.obtainPageLayout(var);
    }
  }

  ///////////////
  // relate //
  ///////////////

  @Override public boolean relateForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = relateTimeZoneGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateTimeZoneGenPage(String var, Object val) {
    TimeZoneGenPage oTimeZoneGenPage = (TimeZoneGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, TimeZoneGenPage o) {
    return staticSetTimeZoneGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetTimeZoneGenPage(String entityVar, SiteRequest siteRequest_, String v, TimeZoneGenPage o) {
    switch(entityVar) {
    case "listTimeZone":
      return TimeZoneGenPage.staticSetListTimeZone(siteRequest_, v);
    case "resultCount":
      return TimeZoneGenPage.staticSetResultCount(siteRequest_, v);
    case "solrId":
      return TimeZoneGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriTimeZone":
      return TimeZoneGenPage.staticSetPageUriTimeZone(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchTimeZoneGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchTimeZoneGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listTimeZone":
      return TimeZoneGenPage.staticSearchListTimeZone(siteRequest_, (JsonArray)o);
    case "resultCount":
      return TimeZoneGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "solrId":
      return TimeZoneGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriTimeZone":
      return TimeZoneGenPage.staticSearchPageUriTimeZone(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrTimeZoneGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrTimeZoneGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listTimeZone":
      return TimeZoneGenPage.staticSearchStrListTimeZone(siteRequest_, (String)o);
    case "resultCount":
      return TimeZoneGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "solrId":
      return TimeZoneGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriTimeZone":
      return TimeZoneGenPage.staticSearchStrPageUriTimeZone(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqTimeZoneGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqTimeZoneGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listTimeZone":
      return TimeZoneGenPage.staticSearchFqListTimeZone(siteRequest_, o);
    case "resultCount":
      return TimeZoneGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "solrId":
      return TimeZoneGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriTimeZone":
      return TimeZoneGenPage.staticSearchFqPageUriTimeZone(siteRequest_, o);
      default:
        return PageLayout.staticSearchFqPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "TimeZoneGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.timezone.TimeZoneGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListTimeZone_ = "searchListTimeZone_";
  public static final String VAR_listTimeZone = "listTimeZone";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriTimeZone = "pageUriTimeZone";

  public static final String DISPLAY_NAME_searchListTimeZone_ = "";
  public static final String DISPLAY_NAME_listTimeZone = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriTimeZone = "";

  @Override
  public String idForClass() {
    return null;
  }

  @Override
  public String titleForClass() {
    return null;
  }

  @Override
  public String nameForClass() {
    return null;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return null;
  }

  @Override
  public String descriptionForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlEditPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlDownloadForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return TimeZoneGenPage.displayNameTimeZoneGenPage(var);
  }
  public static String displayNameTimeZoneGenPage(String var) {
    switch(var) {
    case VAR_searchListTimeZone_:
      return DISPLAY_NAME_searchListTimeZone_;
    case VAR_listTimeZone:
      return DISPLAY_NAME_listTimeZone;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriTimeZone:
      return DISPLAY_NAME_pageUriTimeZone;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionTimeZoneGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameTimeZoneGenPage(String var) {
    switch(var) {
    case VAR_searchListTimeZone_:
      return "SearchList";
    case VAR_listTimeZone:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "TimeZone";
    case VAR_solrId:
      return "String";
    case VAR_pageUriTimeZone:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minTimeZoneGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}
