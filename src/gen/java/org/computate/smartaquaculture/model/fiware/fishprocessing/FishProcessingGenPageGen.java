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
package org.computate.smartaquaculture.model.fiware.fishprocessing;

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
import org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FishProcessingGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishProcessingGenPageGen into the class FishProcessingGenPage. 
 * </li>
 * <h3>About the FishProcessingGenPage class and it's generated class FishProcessingGenPageGen&lt;PageLayout&gt;: </h3>extends FishProcessingGenPageGen
 * <p>
 * This Java class extends a generated Java class FishProcessingGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage">Find the class FishProcessingGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishProcessingGenPageGen<PageLayout>
 * <p>This <code>class FishProcessingGenPage extends FishProcessingGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FishProcessingGenPageGen. 
 * The generated <code>class FishProcessingGenPageGen extends PageLayout</code> which means that FishProcessingGenPage extends FishProcessingGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishProcessingGenPage class will inherit the helpful inherited class comments from the super class FishProcessingGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishProcessingGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FishProcessingGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishprocessing in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class FishProcessingGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(FishProcessingGenPage.class);

	///////////////////////////////
  // searchListFishProcessing_ //
	///////////////////////////////


  /**
   *  The entity searchListFishProcessing_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<FishProcessing> searchListFishProcessing_;

  /**
   * <br> The entity searchListFishProcessing_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:searchListFishProcessing_">Find the entity searchListFishProcessing_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListFishProcessing_(Wrap<SearchList<FishProcessing>> w);

  public SearchList<FishProcessing> getSearchListFishProcessing_() {
    return searchListFishProcessing_;
  }

  public void setSearchListFishProcessing_(SearchList<FishProcessing> searchListFishProcessing_) {
    this.searchListFishProcessing_ = searchListFishProcessing_;
  }
  public static SearchList<FishProcessing> staticSetSearchListFishProcessing_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishProcessingGenPage searchListFishProcessing_Init() {
    Wrap<SearchList<FishProcessing>> searchListFishProcessing_Wrap = new Wrap<SearchList<FishProcessing>>().var("searchListFishProcessing_");
    if(searchListFishProcessing_ == null) {
      _searchListFishProcessing_(searchListFishProcessing_Wrap);
      Optional.ofNullable(searchListFishProcessing_Wrap.getO()).ifPresent(o -> {
        setSearchListFishProcessing_(o);
      });
    }
    return (FishProcessingGenPage)this;
  }

	////////////////////////
  // listFishProcessing //
	////////////////////////


  /**
   *  The entity listFishProcessing
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listFishProcessing = new JsonArray();

  /**
   * <br> The entity listFishProcessing
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:listFishProcessing">Find the entity listFishProcessing in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listFishProcessing(JsonArray l);

  public JsonArray getListFishProcessing() {
    return listFishProcessing;
  }

  public void setListFishProcessing(JsonArray listFishProcessing) {
    this.listFishProcessing = listFishProcessing;
  }
  @JsonIgnore
  public void setListFishProcessing(String o) {
    this.listFishProcessing = FishProcessingGenPage.staticSetListFishProcessing(siteRequest_, o);
  }
  public static JsonArray staticSetListFishProcessing(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected FishProcessingGenPage listFishProcessingInit() {
    _listFishProcessing(listFishProcessing);
    return (FishProcessingGenPage)this;
  }

  public static String staticSearchListFishProcessing(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListFishProcessing(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListFishProcessing(SiteRequest siteRequest_, String o) {
    return FishProcessingGenPage.staticSearchListFishProcessing(siteRequest_, FishProcessingGenPage.staticSetListFishProcessing(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = FishProcessingGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected FishProcessingGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (FishProcessingGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return FishProcessingGenPage.staticSearchResultCount(siteRequest_, FishProcessingGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected FishProcessing result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<FishProcessing> w);

  public FishProcessing getResult() {
    return result;
  }

  public void setResult(FishProcessing result) {
    this.result = result;
  }
  public static FishProcessing staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishProcessingGenPage resultInit() {
    Wrap<FishProcessing> resultWrap = new Wrap<FishProcessing>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (FishProcessingGenPage)this;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
    this.pk = FishProcessingGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishProcessingGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (FishProcessingGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return FishProcessingGenPage.staticSearchPk(siteRequest_, FishProcessingGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = FishProcessingGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishProcessingGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (FishProcessingGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return FishProcessingGenPage.staticSearchSolrId(siteRequest_, FishProcessingGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	///////////////////////////
  // pageUriFishProcessing //
	///////////////////////////


  /**
   *  The entity pageUriFishProcessing
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriFishProcessing;

  /**
   * <br> The entity pageUriFishProcessing
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage&fq=entiteVar_enUS_indexed_string:pageUriFishProcessing">Find the entity pageUriFishProcessing in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriFishProcessing(Wrap<String> c);

  public String getPageUriFishProcessing() {
    return pageUriFishProcessing;
  }
  public void setPageUriFishProcessing(String o) {
    this.pageUriFishProcessing = FishProcessingGenPage.staticSetPageUriFishProcessing(siteRequest_, o);
  }
  public static String staticSetPageUriFishProcessing(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishProcessingGenPage pageUriFishProcessingInit() {
    Wrap<String> pageUriFishProcessingWrap = new Wrap<String>().var("pageUriFishProcessing");
    if(pageUriFishProcessing == null) {
      _pageUriFishProcessing(pageUriFishProcessingWrap);
      Optional.ofNullable(pageUriFishProcessingWrap.getO()).ifPresent(o -> {
        setPageUriFishProcessing(o);
      });
    }
    return (FishProcessingGenPage)this;
  }

  public static String staticSearchPageUriFishProcessing(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriFishProcessing(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriFishProcessing(SiteRequest siteRequest_, String o) {
    return FishProcessingGenPage.staticSearchPageUriFishProcessing(siteRequest_, FishProcessingGenPage.staticSetPageUriFishProcessing(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<FishProcessingGenPageGen<DEV>> promiseDeepFishProcessingGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepFishProcessingGenPage();
  }

  public Future<FishProcessingGenPageGen<DEV>> promiseDeepFishProcessingGenPage() {
    Promise<FishProcessingGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseFishProcessingGenPage(promise2);
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

  public Future<Void> promiseFishProcessingGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListFishProcessing_Init();
        listFishProcessingInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriFishProcessingInit();
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

  @Override public Future<? extends FishProcessingGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepFishProcessingGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestFishProcessingGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestFishProcessingGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainFishProcessingGenPage(v);
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
  public Object obtainFishProcessingGenPage(String var) {
    FishProcessingGenPage oFishProcessingGenPage = (FishProcessingGenPage)this;
    switch(var) {
      case "searchListFishProcessing_":
        return oFishProcessingGenPage.searchListFishProcessing_;
      case "listFishProcessing":
        return oFishProcessingGenPage.listFishProcessing;
      case "resultCount":
        return oFishProcessingGenPage.resultCount;
      case "result":
        return oFishProcessingGenPage.result;
      case "pk":
        return oFishProcessingGenPage.pk;
      case "solrId":
        return oFishProcessingGenPage.solrId;
      case "pageUriFishProcessing":
        return oFishProcessingGenPage.pageUriFishProcessing;
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
        o = relateFishProcessingGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateFishProcessingGenPage(String var, Object val) {
    FishProcessingGenPage oFishProcessingGenPage = (FishProcessingGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishProcessingGenPage o) {
    return staticSetFishProcessingGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetFishProcessingGenPage(String entityVar, SiteRequest siteRequest_, String v, FishProcessingGenPage o) {
    switch(entityVar) {
    case "listFishProcessing":
      return FishProcessingGenPage.staticSetListFishProcessing(siteRequest_, v);
    case "resultCount":
      return FishProcessingGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return FishProcessingGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return FishProcessingGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriFishProcessing":
      return FishProcessingGenPage.staticSetPageUriFishProcessing(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchFishProcessingGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchFishProcessingGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishProcessing":
      return FishProcessingGenPage.staticSearchListFishProcessing(siteRequest_, (JsonArray)o);
    case "resultCount":
      return FishProcessingGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishProcessingGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return FishProcessingGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriFishProcessing":
      return FishProcessingGenPage.staticSearchPageUriFishProcessing(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrFishProcessingGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrFishProcessingGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishProcessing":
      return FishProcessingGenPage.staticSearchStrListFishProcessing(siteRequest_, (String)o);
    case "resultCount":
      return FishProcessingGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishProcessingGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return FishProcessingGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriFishProcessing":
      return FishProcessingGenPage.staticSearchStrPageUriFishProcessing(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqFishProcessingGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqFishProcessingGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listFishProcessing":
      return FishProcessingGenPage.staticSearchFqListFishProcessing(siteRequest_, o);
    case "resultCount":
      return FishProcessingGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return FishProcessingGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return FishProcessingGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriFishProcessing":
      return FishProcessingGenPage.staticSearchFqPageUriFishProcessing(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "FishProcessingGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListFishProcessing_ = "searchListFishProcessing_";
  public static final String VAR_listFishProcessing = "listFishProcessing";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_pk = "pk";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriFishProcessing = "pageUriFishProcessing";

  public static final String DISPLAY_NAME_searchListFishProcessing_ = "";
  public static final String DISPLAY_NAME_listFishProcessing = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriFishProcessing = "";

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
    return FishProcessingGenPage.displayNameFishProcessingGenPage(var);
  }
  public static String displayNameFishProcessingGenPage(String var) {
    switch(var) {
    case VAR_searchListFishProcessing_:
      return DISPLAY_NAME_searchListFishProcessing_;
    case VAR_listFishProcessing:
      return DISPLAY_NAME_listFishProcessing;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriFishProcessing:
      return DISPLAY_NAME_pageUriFishProcessing;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionFishProcessingGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameFishProcessingGenPage(String var) {
    switch(var) {
    case VAR_searchListFishProcessing_:
      return "SearchList";
    case VAR_listFishProcessing:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "FishProcessing";
    case VAR_pk:
      return "Long";
    case VAR_solrId:
      return "String";
    case VAR_pageUriFishProcessing:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minFishProcessingGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}
