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
package org.computate.smartaquaculture.model.fiware.fishingboat;

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
import org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FishingBoatGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishingBoatGenPageGen into the class FishingBoatGenPage. 
 * </li>
 * <h3>About the FishingBoatGenPage class and it's generated class FishingBoatGenPageGen&lt;PageLayout&gt;: </h3>extends FishingBoatGenPageGen
 * <p>
 * This Java class extends a generated Java class FishingBoatGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage">Find the class FishingBoatGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishingBoatGenPageGen<PageLayout>
 * <p>This <code>class FishingBoatGenPage extends FishingBoatGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FishingBoatGenPageGen. 
 * The generated <code>class FishingBoatGenPageGen extends PageLayout</code> which means that FishingBoatGenPage extends FishingBoatGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishingBoatGenPage class will inherit the helpful inherited class comments from the super class FishingBoatGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishingBoatGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FishingBoatGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishingboat in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishingBoatGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(FishingBoatGenPage.class);

	////////////////////////////
  // searchListFishingBoat_ //
	////////////////////////////


  /**
   *  The entity searchListFishingBoat_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<FishingBoat> searchListFishingBoat_;

  /**
   * <br> The entity searchListFishingBoat_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:searchListFishingBoat_">Find the entity searchListFishingBoat_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListFishingBoat_(Wrap<SearchList<FishingBoat>> w);

  public SearchList<FishingBoat> getSearchListFishingBoat_() {
    return searchListFishingBoat_;
  }

  public void setSearchListFishingBoat_(SearchList<FishingBoat> searchListFishingBoat_) {
    this.searchListFishingBoat_ = searchListFishingBoat_;
  }
  public static SearchList<FishingBoat> staticSetSearchListFishingBoat_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishingBoatGenPage searchListFishingBoat_Init() {
    Wrap<SearchList<FishingBoat>> searchListFishingBoat_Wrap = new Wrap<SearchList<FishingBoat>>().var("searchListFishingBoat_");
    if(searchListFishingBoat_ == null) {
      _searchListFishingBoat_(searchListFishingBoat_Wrap);
      Optional.ofNullable(searchListFishingBoat_Wrap.getO()).ifPresent(o -> {
        setSearchListFishingBoat_(o);
      });
    }
    return (FishingBoatGenPage)this;
  }

	/////////////////////
  // listFishingBoat //
	/////////////////////


  /**
   *  The entity listFishingBoat
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listFishingBoat = new JsonArray();

  /**
   * <br> The entity listFishingBoat
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:listFishingBoat">Find the entity listFishingBoat in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listFishingBoat(JsonArray l);

  public JsonArray getListFishingBoat() {
    return listFishingBoat;
  }

  public void setListFishingBoat(JsonArray listFishingBoat) {
    this.listFishingBoat = listFishingBoat;
  }
  @JsonIgnore
  public void setListFishingBoat(String o) {
    this.listFishingBoat = FishingBoatGenPage.staticSetListFishingBoat(siteRequest_, o);
  }
  public static JsonArray staticSetListFishingBoat(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected FishingBoatGenPage listFishingBoatInit() {
    _listFishingBoat(listFishingBoat);
    return (FishingBoatGenPage)this;
  }

  public static String staticSearchListFishingBoat(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListFishingBoat(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListFishingBoat(SiteRequest siteRequest_, String o) {
    return FishingBoatGenPage.staticSearchListFishingBoat(siteRequest_, FishingBoatGenPage.staticSetListFishingBoat(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = FishingBoatGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected FishingBoatGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (FishingBoatGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return FishingBoatGenPage.staticSearchResultCount(siteRequest_, FishingBoatGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected FishingBoat result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<FishingBoat> w);

  public FishingBoat getResult() {
    return result;
  }

  public void setResult(FishingBoat result) {
    this.result = result;
  }
  public static FishingBoat staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishingBoatGenPage resultInit() {
    Wrap<FishingBoat> resultWrap = new Wrap<FishingBoat>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (FishingBoatGenPage)this;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
    this.pk = FishingBoatGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishingBoatGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (FishingBoatGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return FishingBoatGenPage.staticSearchPk(siteRequest_, FishingBoatGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = FishingBoatGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishingBoatGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (FishingBoatGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return FishingBoatGenPage.staticSearchSolrId(siteRequest_, FishingBoatGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	////////////////////////
  // pageUriFishingBoat //
	////////////////////////


  /**
   *  The entity pageUriFishingBoat
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriFishingBoat;

  /**
   * <br> The entity pageUriFishingBoat
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage&fq=entiteVar_enUS_indexed_string:pageUriFishingBoat">Find the entity pageUriFishingBoat in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriFishingBoat(Wrap<String> c);

  public String getPageUriFishingBoat() {
    return pageUriFishingBoat;
  }
  public void setPageUriFishingBoat(String o) {
    this.pageUriFishingBoat = FishingBoatGenPage.staticSetPageUriFishingBoat(siteRequest_, o);
  }
  public static String staticSetPageUriFishingBoat(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishingBoatGenPage pageUriFishingBoatInit() {
    Wrap<String> pageUriFishingBoatWrap = new Wrap<String>().var("pageUriFishingBoat");
    if(pageUriFishingBoat == null) {
      _pageUriFishingBoat(pageUriFishingBoatWrap);
      Optional.ofNullable(pageUriFishingBoatWrap.getO()).ifPresent(o -> {
        setPageUriFishingBoat(o);
      });
    }
    return (FishingBoatGenPage)this;
  }

  public static String staticSearchPageUriFishingBoat(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriFishingBoat(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriFishingBoat(SiteRequest siteRequest_, String o) {
    return FishingBoatGenPage.staticSearchPageUriFishingBoat(siteRequest_, FishingBoatGenPage.staticSetPageUriFishingBoat(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<FishingBoatGenPageGen<DEV>> promiseDeepFishingBoatGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepFishingBoatGenPage();
  }

  public Future<FishingBoatGenPageGen<DEV>> promiseDeepFishingBoatGenPage() {
    Promise<FishingBoatGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseFishingBoatGenPage(promise2);
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

  public Future<Void> promiseFishingBoatGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListFishingBoat_Init();
        listFishingBoatInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriFishingBoatInit();
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

  @Override public Future<? extends FishingBoatGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepFishingBoatGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestFishingBoatGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestFishingBoatGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainFishingBoatGenPage(v);
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
  public Object obtainFishingBoatGenPage(String var) {
    FishingBoatGenPage oFishingBoatGenPage = (FishingBoatGenPage)this;
    switch(var) {
      case "searchListFishingBoat_":
        return oFishingBoatGenPage.searchListFishingBoat_;
      case "listFishingBoat":
        return oFishingBoatGenPage.listFishingBoat;
      case "resultCount":
        return oFishingBoatGenPage.resultCount;
      case "result":
        return oFishingBoatGenPage.result;
      case "pk":
        return oFishingBoatGenPage.pk;
      case "solrId":
        return oFishingBoatGenPage.solrId;
      case "pageUriFishingBoat":
        return oFishingBoatGenPage.pageUriFishingBoat;
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
        o = relateFishingBoatGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateFishingBoatGenPage(String var, Object val) {
    FishingBoatGenPage oFishingBoatGenPage = (FishingBoatGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishingBoatGenPage o) {
    return staticSetFishingBoatGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetFishingBoatGenPage(String entityVar, SiteRequest siteRequest_, String v, FishingBoatGenPage o) {
    switch(entityVar) {
    case "listFishingBoat":
      return FishingBoatGenPage.staticSetListFishingBoat(siteRequest_, v);
    case "resultCount":
      return FishingBoatGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return FishingBoatGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return FishingBoatGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriFishingBoat":
      return FishingBoatGenPage.staticSetPageUriFishingBoat(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchFishingBoatGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchFishingBoatGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishingBoat":
      return FishingBoatGenPage.staticSearchListFishingBoat(siteRequest_, (JsonArray)o);
    case "resultCount":
      return FishingBoatGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishingBoatGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return FishingBoatGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriFishingBoat":
      return FishingBoatGenPage.staticSearchPageUriFishingBoat(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrFishingBoatGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrFishingBoatGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishingBoat":
      return FishingBoatGenPage.staticSearchStrListFishingBoat(siteRequest_, (String)o);
    case "resultCount":
      return FishingBoatGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishingBoatGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return FishingBoatGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriFishingBoat":
      return FishingBoatGenPage.staticSearchStrPageUriFishingBoat(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqFishingBoatGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqFishingBoatGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listFishingBoat":
      return FishingBoatGenPage.staticSearchFqListFishingBoat(siteRequest_, o);
    case "resultCount":
      return FishingBoatGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return FishingBoatGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return FishingBoatGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriFishingBoat":
      return FishingBoatGenPage.staticSearchFqPageUriFishingBoat(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "FishingBoatGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListFishingBoat_ = "searchListFishingBoat_";
  public static final String VAR_listFishingBoat = "listFishingBoat";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_pk = "pk";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriFishingBoat = "pageUriFishingBoat";

  public static final String DISPLAY_NAME_searchListFishingBoat_ = "";
  public static final String DISPLAY_NAME_listFishingBoat = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriFishingBoat = "";

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
    return FishingBoatGenPage.displayNameFishingBoatGenPage(var);
  }
  public static String displayNameFishingBoatGenPage(String var) {
    switch(var) {
    case VAR_searchListFishingBoat_:
      return DISPLAY_NAME_searchListFishingBoat_;
    case VAR_listFishingBoat:
      return DISPLAY_NAME_listFishingBoat;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriFishingBoat:
      return DISPLAY_NAME_pageUriFishingBoat;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionFishingBoatGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameFishingBoatGenPage(String var) {
    switch(var) {
    case VAR_searchListFishingBoat_:
      return "SearchList";
    case VAR_listFishingBoat:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "FishingBoat";
    case VAR_pk:
      return "Long";
    case VAR_solrId:
      return "String";
    case VAR_pageUriFishingBoat:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minFishingBoatGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}
