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
package org.computate.smartaquaculture.model.fiware.fishingdock;

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
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FishingDockGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishingDockGenPageGen into the class FishingDockGenPage. 
 * </li>
 * <h3>About the FishingDockGenPage class and it's generated class FishingDockGenPageGen&lt;PageLayout&gt;: </h3>extends FishingDockGenPageGen
 * <p>
 * This Java class extends a generated Java class FishingDockGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage">Find the class FishingDockGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishingDockGenPageGen<PageLayout>
 * <p>This <code>class FishingDockGenPage extends FishingDockGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FishingDockGenPageGen. 
 * The generated <code>class FishingDockGenPageGen extends PageLayout</code> which means that FishingDockGenPage extends FishingDockGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishingDockGenPage class will inherit the helpful inherited class comments from the super class FishingDockGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishingDockGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FishingDockGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishingdock in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishingDockGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(FishingDockGenPage.class);

	////////////////////////////
  // searchListFishingDock_ //
	////////////////////////////


  /**
   *  The entity searchListFishingDock_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<FishingDock> searchListFishingDock_;

  /**
   * <br> The entity searchListFishingDock_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:searchListFishingDock_">Find the entity searchListFishingDock_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListFishingDock_(Wrap<SearchList<FishingDock>> w);

  public SearchList<FishingDock> getSearchListFishingDock_() {
    return searchListFishingDock_;
  }

  public void setSearchListFishingDock_(SearchList<FishingDock> searchListFishingDock_) {
    this.searchListFishingDock_ = searchListFishingDock_;
  }
  public static SearchList<FishingDock> staticSetSearchListFishingDock_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishingDockGenPage searchListFishingDock_Init() {
    Wrap<SearchList<FishingDock>> searchListFishingDock_Wrap = new Wrap<SearchList<FishingDock>>().var("searchListFishingDock_");
    if(searchListFishingDock_ == null) {
      _searchListFishingDock_(searchListFishingDock_Wrap);
      Optional.ofNullable(searchListFishingDock_Wrap.getO()).ifPresent(o -> {
        setSearchListFishingDock_(o);
      });
    }
    return (FishingDockGenPage)this;
  }

	/////////////////////
  // listFishingDock //
	/////////////////////


  /**
   *  The entity listFishingDock
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listFishingDock = new JsonArray();

  /**
   * <br> The entity listFishingDock
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:listFishingDock">Find the entity listFishingDock in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listFishingDock(JsonArray l);

  public JsonArray getListFishingDock() {
    return listFishingDock;
  }

  public void setListFishingDock(JsonArray listFishingDock) {
    this.listFishingDock = listFishingDock;
  }
  @JsonIgnore
  public void setListFishingDock(String o) {
    this.listFishingDock = FishingDockGenPage.staticSetListFishingDock(siteRequest_, o);
  }
  public static JsonArray staticSetListFishingDock(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected FishingDockGenPage listFishingDockInit() {
    _listFishingDock(listFishingDock);
    return (FishingDockGenPage)this;
  }

  public static String staticSearchListFishingDock(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListFishingDock(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListFishingDock(SiteRequest siteRequest_, String o) {
    return FishingDockGenPage.staticSearchListFishingDock(siteRequest_, FishingDockGenPage.staticSetListFishingDock(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = FishingDockGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected FishingDockGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (FishingDockGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return FishingDockGenPage.staticSearchResultCount(siteRequest_, FishingDockGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected FishingDock result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<FishingDock> w);

  public FishingDock getResult() {
    return result;
  }

  public void setResult(FishingDock result) {
    this.result = result;
  }
  public static FishingDock staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishingDockGenPage resultInit() {
    Wrap<FishingDock> resultWrap = new Wrap<FishingDock>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (FishingDockGenPage)this;
  }

	////////
  // pk //
	////////


  /**
   *  The entity pk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long pk;

  /**
   * <br> The entity pk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pk(Wrap<Long> w);

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }
  @JsonIgnore
  public void setPk(String o) {
    this.pk = FishingDockGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishingDockGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (FishingDockGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return FishingDockGenPage.staticSearchPk(siteRequest_, FishingDockGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = FishingDockGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishingDockGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (FishingDockGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return FishingDockGenPage.staticSearchSolrId(siteRequest_, FishingDockGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	////////////////////////
  // pageUriFishingDock //
	////////////////////////


  /**
   *  The entity pageUriFishingDock
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriFishingDock;

  /**
   * <br> The entity pageUriFishingDock
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage&fq=entiteVar_enUS_indexed_string:pageUriFishingDock">Find the entity pageUriFishingDock in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriFishingDock(Wrap<String> c);

  public String getPageUriFishingDock() {
    return pageUriFishingDock;
  }
  public void setPageUriFishingDock(String o) {
    this.pageUriFishingDock = FishingDockGenPage.staticSetPageUriFishingDock(siteRequest_, o);
  }
  public static String staticSetPageUriFishingDock(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishingDockGenPage pageUriFishingDockInit() {
    Wrap<String> pageUriFishingDockWrap = new Wrap<String>().var("pageUriFishingDock");
    if(pageUriFishingDock == null) {
      _pageUriFishingDock(pageUriFishingDockWrap);
      Optional.ofNullable(pageUriFishingDockWrap.getO()).ifPresent(o -> {
        setPageUriFishingDock(o);
      });
    }
    return (FishingDockGenPage)this;
  }

  public static String staticSearchPageUriFishingDock(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriFishingDock(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriFishingDock(SiteRequest siteRequest_, String o) {
    return FishingDockGenPage.staticSearchPageUriFishingDock(siteRequest_, FishingDockGenPage.staticSetPageUriFishingDock(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<FishingDockGenPageGen<DEV>> promiseDeepFishingDockGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepFishingDockGenPage();
  }

  public Future<FishingDockGenPageGen<DEV>> promiseDeepFishingDockGenPage() {
    Promise<FishingDockGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseFishingDockGenPage(promise2);
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

  public Future<Void> promiseFishingDockGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListFishingDock_Init();
        listFishingDockInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriFishingDockInit();
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

  @Override public Future<? extends FishingDockGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepFishingDockGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestFishingDockGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestFishingDockGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainFishingDockGenPage(v);
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
  public Object obtainFishingDockGenPage(String var) {
    FishingDockGenPage oFishingDockGenPage = (FishingDockGenPage)this;
    switch(var) {
      case "searchListFishingDock_":
        return oFishingDockGenPage.searchListFishingDock_;
      case "listFishingDock":
        return oFishingDockGenPage.listFishingDock;
      case "resultCount":
        return oFishingDockGenPage.resultCount;
      case "result":
        return oFishingDockGenPage.result;
      case "pk":
        return oFishingDockGenPage.pk;
      case "solrId":
        return oFishingDockGenPage.solrId;
      case "pageUriFishingDock":
        return oFishingDockGenPage.pageUriFishingDock;
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
        o = relateFishingDockGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateFishingDockGenPage(String var, Object val) {
    FishingDockGenPage oFishingDockGenPage = (FishingDockGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishingDockGenPage o) {
    return staticSetFishingDockGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetFishingDockGenPage(String entityVar, SiteRequest siteRequest_, String v, FishingDockGenPage o) {
    switch(entityVar) {
    case "listFishingDock":
      return FishingDockGenPage.staticSetListFishingDock(siteRequest_, v);
    case "resultCount":
      return FishingDockGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return FishingDockGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return FishingDockGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriFishingDock":
      return FishingDockGenPage.staticSetPageUriFishingDock(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchFishingDockGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchFishingDockGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishingDock":
      return FishingDockGenPage.staticSearchListFishingDock(siteRequest_, (JsonArray)o);
    case "resultCount":
      return FishingDockGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishingDockGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return FishingDockGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriFishingDock":
      return FishingDockGenPage.staticSearchPageUriFishingDock(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrFishingDockGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrFishingDockGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishingDock":
      return FishingDockGenPage.staticSearchStrListFishingDock(siteRequest_, (String)o);
    case "resultCount":
      return FishingDockGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishingDockGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return FishingDockGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriFishingDock":
      return FishingDockGenPage.staticSearchStrPageUriFishingDock(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqFishingDockGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqFishingDockGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listFishingDock":
      return FishingDockGenPage.staticSearchFqListFishingDock(siteRequest_, o);
    case "resultCount":
      return FishingDockGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return FishingDockGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return FishingDockGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriFishingDock":
      return FishingDockGenPage.staticSearchFqPageUriFishingDock(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "FishingDockGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListFishingDock_ = "searchListFishingDock_";
  public static final String VAR_listFishingDock = "listFishingDock";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_pk = "pk";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriFishingDock = "pageUriFishingDock";

  public static final String DISPLAY_NAME_searchListFishingDock_ = "";
  public static final String DISPLAY_NAME_listFishingDock = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriFishingDock = "";

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
    return FishingDockGenPage.displayNameFishingDockGenPage(var);
  }
  public static String displayNameFishingDockGenPage(String var) {
    switch(var) {
    case VAR_searchListFishingDock_:
      return DISPLAY_NAME_searchListFishingDock_;
    case VAR_listFishingDock:
      return DISPLAY_NAME_listFishingDock;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriFishingDock:
      return DISPLAY_NAME_pageUriFishingDock;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionFishingDockGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameFishingDockGenPage(String var) {
    switch(var) {
    case VAR_searchListFishingDock_:
      return "SearchList";
    case VAR_listFishingDock:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "FishingDock";
    case VAR_pk:
      return "Long";
    case VAR_solrId:
      return "String";
    case VAR_pageUriFishingDock:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minFishingDockGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}
