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
package org.computate.smartaquaculture.model.fiware.fishpopulation;

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
import org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FishPopulationGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishPopulationGenPageGen into the class FishPopulationGenPage. 
 * </li>
 * <h3>About the FishPopulationGenPage class and it's generated class FishPopulationGenPageGen&lt;PageLayout&gt;: </h3>extends FishPopulationGenPageGen
 * <p>
 * This Java class extends a generated Java class FishPopulationGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage">Find the class FishPopulationGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishPopulationGenPageGen<PageLayout>
 * <p>This <code>class FishPopulationGenPage extends FishPopulationGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FishPopulationGenPageGen. 
 * The generated <code>class FishPopulationGenPageGen extends PageLayout</code> which means that FishPopulationGenPage extends FishPopulationGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishPopulationGenPage class will inherit the helpful inherited class comments from the super class FishPopulationGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishPopulationGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FishPopulationGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishpopulation in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class FishPopulationGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(FishPopulationGenPage.class);

	///////////////////////////////
  // searchListFishPopulation_ //
	///////////////////////////////


  /**
   *  The entity searchListFishPopulation_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<FishPopulation> searchListFishPopulation_;

  /**
   * <br> The entity searchListFishPopulation_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:searchListFishPopulation_">Find the entity searchListFishPopulation_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListFishPopulation_(Wrap<SearchList<FishPopulation>> w);

  public SearchList<FishPopulation> getSearchListFishPopulation_() {
    return searchListFishPopulation_;
  }

  public void setSearchListFishPopulation_(SearchList<FishPopulation> searchListFishPopulation_) {
    this.searchListFishPopulation_ = searchListFishPopulation_;
  }
  public static SearchList<FishPopulation> staticSetSearchListFishPopulation_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishPopulationGenPage searchListFishPopulation_Init() {
    Wrap<SearchList<FishPopulation>> searchListFishPopulation_Wrap = new Wrap<SearchList<FishPopulation>>().var("searchListFishPopulation_");
    if(searchListFishPopulation_ == null) {
      _searchListFishPopulation_(searchListFishPopulation_Wrap);
      Optional.ofNullable(searchListFishPopulation_Wrap.getO()).ifPresent(o -> {
        setSearchListFishPopulation_(o);
      });
    }
    return (FishPopulationGenPage)this;
  }

	////////////////////////
  // listFishPopulation //
	////////////////////////


  /**
   *  The entity listFishPopulation
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listFishPopulation = new JsonArray();

  /**
   * <br> The entity listFishPopulation
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:listFishPopulation">Find the entity listFishPopulation in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listFishPopulation(JsonArray l);

  public JsonArray getListFishPopulation() {
    return listFishPopulation;
  }

  public void setListFishPopulation(JsonArray listFishPopulation) {
    this.listFishPopulation = listFishPopulation;
  }
  @JsonIgnore
  public void setListFishPopulation(String o) {
    this.listFishPopulation = FishPopulationGenPage.staticSetListFishPopulation(siteRequest_, o);
  }
  public static JsonArray staticSetListFishPopulation(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected FishPopulationGenPage listFishPopulationInit() {
    _listFishPopulation(listFishPopulation);
    return (FishPopulationGenPage)this;
  }

  public static String staticSearchListFishPopulation(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListFishPopulation(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListFishPopulation(SiteRequest siteRequest_, String o) {
    return FishPopulationGenPage.staticSearchListFishPopulation(siteRequest_, FishPopulationGenPage.staticSetListFishPopulation(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = FishPopulationGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected FishPopulationGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (FishPopulationGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return FishPopulationGenPage.staticSearchResultCount(siteRequest_, FishPopulationGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected FishPopulation result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<FishPopulation> w);

  public FishPopulation getResult() {
    return result;
  }

  public void setResult(FishPopulation result) {
    this.result = result;
  }
  public static FishPopulation staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected FishPopulationGenPage resultInit() {
    Wrap<FishPopulation> resultWrap = new Wrap<FishPopulation>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (FishPopulationGenPage)this;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
    this.pk = FishPopulationGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishPopulationGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (FishPopulationGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return FishPopulationGenPage.staticSearchPk(siteRequest_, FishPopulationGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = FishPopulationGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishPopulationGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (FishPopulationGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return FishPopulationGenPage.staticSearchSolrId(siteRequest_, FishPopulationGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	///////////////////////////
  // pageUriFishPopulation //
	///////////////////////////


  /**
   *  The entity pageUriFishPopulation
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriFishPopulation;

  /**
   * <br> The entity pageUriFishPopulation
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage&fq=entiteVar_enUS_indexed_string:pageUriFishPopulation">Find the entity pageUriFishPopulation in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriFishPopulation(Wrap<String> c);

  public String getPageUriFishPopulation() {
    return pageUriFishPopulation;
  }
  public void setPageUriFishPopulation(String o) {
    this.pageUriFishPopulation = FishPopulationGenPage.staticSetPageUriFishPopulation(siteRequest_, o);
  }
  public static String staticSetPageUriFishPopulation(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishPopulationGenPage pageUriFishPopulationInit() {
    Wrap<String> pageUriFishPopulationWrap = new Wrap<String>().var("pageUriFishPopulation");
    if(pageUriFishPopulation == null) {
      _pageUriFishPopulation(pageUriFishPopulationWrap);
      Optional.ofNullable(pageUriFishPopulationWrap.getO()).ifPresent(o -> {
        setPageUriFishPopulation(o);
      });
    }
    return (FishPopulationGenPage)this;
  }

  public static String staticSearchPageUriFishPopulation(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriFishPopulation(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriFishPopulation(SiteRequest siteRequest_, String o) {
    return FishPopulationGenPage.staticSearchPageUriFishPopulation(siteRequest_, FishPopulationGenPage.staticSetPageUriFishPopulation(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<FishPopulationGenPageGen<DEV>> promiseDeepFishPopulationGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepFishPopulationGenPage();
  }

  public Future<FishPopulationGenPageGen<DEV>> promiseDeepFishPopulationGenPage() {
    Promise<FishPopulationGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseFishPopulationGenPage(promise2);
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

  public Future<Void> promiseFishPopulationGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListFishPopulation_Init();
        listFishPopulationInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriFishPopulationInit();
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

  @Override public Future<? extends FishPopulationGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepFishPopulationGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestFishPopulationGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestFishPopulationGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainFishPopulationGenPage(v);
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
  public Object obtainFishPopulationGenPage(String var) {
    FishPopulationGenPage oFishPopulationGenPage = (FishPopulationGenPage)this;
    switch(var) {
      case "searchListFishPopulation_":
        return oFishPopulationGenPage.searchListFishPopulation_;
      case "listFishPopulation":
        return oFishPopulationGenPage.listFishPopulation;
      case "resultCount":
        return oFishPopulationGenPage.resultCount;
      case "result":
        return oFishPopulationGenPage.result;
      case "pk":
        return oFishPopulationGenPage.pk;
      case "solrId":
        return oFishPopulationGenPage.solrId;
      case "pageUriFishPopulation":
        return oFishPopulationGenPage.pageUriFishPopulation;
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
        o = relateFishPopulationGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateFishPopulationGenPage(String var, Object val) {
    FishPopulationGenPage oFishPopulationGenPage = (FishPopulationGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishPopulationGenPage o) {
    return staticSetFishPopulationGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetFishPopulationGenPage(String entityVar, SiteRequest siteRequest_, String v, FishPopulationGenPage o) {
    switch(entityVar) {
    case "listFishPopulation":
      return FishPopulationGenPage.staticSetListFishPopulation(siteRequest_, v);
    case "resultCount":
      return FishPopulationGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return FishPopulationGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return FishPopulationGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriFishPopulation":
      return FishPopulationGenPage.staticSetPageUriFishPopulation(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchFishPopulationGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchFishPopulationGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishPopulation":
      return FishPopulationGenPage.staticSearchListFishPopulation(siteRequest_, (JsonArray)o);
    case "resultCount":
      return FishPopulationGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishPopulationGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return FishPopulationGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriFishPopulation":
      return FishPopulationGenPage.staticSearchPageUriFishPopulation(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrFishPopulationGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrFishPopulationGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listFishPopulation":
      return FishPopulationGenPage.staticSearchStrListFishPopulation(siteRequest_, (String)o);
    case "resultCount":
      return FishPopulationGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return FishPopulationGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return FishPopulationGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriFishPopulation":
      return FishPopulationGenPage.staticSearchStrPageUriFishPopulation(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqFishPopulationGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqFishPopulationGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listFishPopulation":
      return FishPopulationGenPage.staticSearchFqListFishPopulation(siteRequest_, o);
    case "resultCount":
      return FishPopulationGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return FishPopulationGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return FishPopulationGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriFishPopulation":
      return FishPopulationGenPage.staticSearchFqPageUriFishPopulation(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "FishPopulationGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListFishPopulation_ = "searchListFishPopulation_";
  public static final String SET_searchListFishPopulation_ = "setSearchListFishPopulation_";
  public static final String VAR_listFishPopulation = "listFishPopulation";
  public static final String SET_listFishPopulation = "setListFishPopulation";
  public static final String VAR_resultCount = "resultCount";
  public static final String SET_resultCount = "setResultCount";
  public static final String VAR_result = "result";
  public static final String SET_result = "setResult";
  public static final String VAR_pk = "pk";
  public static final String SET_pk = "setPk";
  public static final String VAR_solrId = "solrId";
  public static final String SET_solrId = "setSolrId";
  public static final String VAR_pageUriFishPopulation = "pageUriFishPopulation";
  public static final String SET_pageUriFishPopulation = "setPageUriFishPopulation";

  public static final String DISPLAY_NAME_searchListFishPopulation_ = "";
  public static final String DISPLAY_NAME_listFishPopulation = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriFishPopulation = "";

  public static String displayNameForClass(String var) {
    return FishPopulationGenPage.displayNameFishPopulationGenPage(var);
  }
  public static String displayNameFishPopulationGenPage(String var) {
    switch(var) {
    case VAR_searchListFishPopulation_:
      return DISPLAY_NAME_searchListFishPopulation_;
    case VAR_listFishPopulation:
      return DISPLAY_NAME_listFishPopulation;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriFishPopulation:
      return DISPLAY_NAME_pageUriFishPopulation;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }
}
