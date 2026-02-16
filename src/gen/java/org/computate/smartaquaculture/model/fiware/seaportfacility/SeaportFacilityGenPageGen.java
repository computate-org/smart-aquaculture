package org.computate.smartaquaculture.model.fiware.seaportfacility;

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
import org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these SeaportFacilityGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class SeaportFacilityGenPageGen into the class SeaportFacilityGenPage. 
 * </li>
 * <h3>About the SeaportFacilityGenPage class and it's generated class SeaportFacilityGenPageGen&lt;PageLayout&gt;: </h3>extends SeaportFacilityGenPageGen
 * <p>
 * This Java class extends a generated Java class SeaportFacilityGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage">Find the class SeaportFacilityGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends SeaportFacilityGenPageGen<PageLayout>
 * <p>This <code>class SeaportFacilityGenPage extends SeaportFacilityGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated SeaportFacilityGenPageGen. 
 * The generated <code>class SeaportFacilityGenPageGen extends PageLayout</code> which means that SeaportFacilityGenPage extends SeaportFacilityGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the SeaportFacilityGenPage class will inherit the helpful inherited class comments from the super class SeaportFacilityGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the SeaportFacilityGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class SeaportFacilityGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.seaportfacility in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class SeaportFacilityGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(SeaportFacilityGenPage.class);

	////////////////////////////////
  // searchListSeaportFacility_ //
	////////////////////////////////


  /**
   *  The entity searchListSeaportFacility_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<SeaportFacility> searchListSeaportFacility_;

  /**
   * <br> The entity searchListSeaportFacility_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:searchListSeaportFacility_">Find the entity searchListSeaportFacility_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListSeaportFacility_(Wrap<SearchList<SeaportFacility>> w);

  public SearchList<SeaportFacility> getSearchListSeaportFacility_() {
    return searchListSeaportFacility_;
  }

  public void setSearchListSeaportFacility_(SearchList<SeaportFacility> searchListSeaportFacility_) {
    this.searchListSeaportFacility_ = searchListSeaportFacility_;
  }
  public static SearchList<SeaportFacility> staticSetSearchListSeaportFacility_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected SeaportFacilityGenPage searchListSeaportFacility_Init() {
    Wrap<SearchList<SeaportFacility>> searchListSeaportFacility_Wrap = new Wrap<SearchList<SeaportFacility>>().var("searchListSeaportFacility_");
    if(searchListSeaportFacility_ == null) {
      _searchListSeaportFacility_(searchListSeaportFacility_Wrap);
      Optional.ofNullable(searchListSeaportFacility_Wrap.getO()).ifPresent(o -> {
        setSearchListSeaportFacility_(o);
      });
    }
    return (SeaportFacilityGenPage)this;
  }

	/////////////////////////
  // listSeaportFacility //
	/////////////////////////


  /**
   *  The entity listSeaportFacility
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listSeaportFacility = new JsonArray();

  /**
   * <br> The entity listSeaportFacility
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:listSeaportFacility">Find the entity listSeaportFacility in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listSeaportFacility(JsonArray l);

  public JsonArray getListSeaportFacility() {
    return listSeaportFacility;
  }

  public void setListSeaportFacility(JsonArray listSeaportFacility) {
    this.listSeaportFacility = listSeaportFacility;
  }
  @JsonIgnore
  public void setListSeaportFacility(String o) {
    this.listSeaportFacility = SeaportFacilityGenPage.staticSetListSeaportFacility(siteRequest_, o);
  }
  public static JsonArray staticSetListSeaportFacility(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected SeaportFacilityGenPage listSeaportFacilityInit() {
    _listSeaportFacility(listSeaportFacility);
    return (SeaportFacilityGenPage)this;
  }

  public static String staticSearchListSeaportFacility(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListSeaportFacility(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListSeaportFacility(SiteRequest siteRequest_, String o) {
    return SeaportFacilityGenPage.staticSearchListSeaportFacility(siteRequest_, SeaportFacilityGenPage.staticSetListSeaportFacility(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = SeaportFacilityGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected SeaportFacilityGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (SeaportFacilityGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return SeaportFacilityGenPage.staticSearchResultCount(siteRequest_, SeaportFacilityGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected SeaportFacility result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<SeaportFacility> w);

  public SeaportFacility getResult() {
    return result;
  }

  public void setResult(SeaportFacility result) {
    this.result = result;
  }
  public static SeaportFacility staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected SeaportFacilityGenPage resultInit() {
    Wrap<SeaportFacility> resultWrap = new Wrap<SeaportFacility>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (SeaportFacilityGenPage)this;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
    this.pk = SeaportFacilityGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected SeaportFacilityGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (SeaportFacilityGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return SeaportFacilityGenPage.staticSearchPk(siteRequest_, SeaportFacilityGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = SeaportFacilityGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacilityGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (SeaportFacilityGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return SeaportFacilityGenPage.staticSearchSolrId(siteRequest_, SeaportFacilityGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	////////////////////////////
  // pageUriSeaportFacility //
	////////////////////////////


  /**
   *  The entity pageUriSeaportFacility
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriSeaportFacility;

  /**
   * <br> The entity pageUriSeaportFacility
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage&fq=entiteVar_enUS_indexed_string:pageUriSeaportFacility">Find the entity pageUriSeaportFacility in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriSeaportFacility(Wrap<String> c);

  public String getPageUriSeaportFacility() {
    return pageUriSeaportFacility;
  }
  public void setPageUriSeaportFacility(String o) {
    this.pageUriSeaportFacility = SeaportFacilityGenPage.staticSetPageUriSeaportFacility(siteRequest_, o);
  }
  public static String staticSetPageUriSeaportFacility(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacilityGenPage pageUriSeaportFacilityInit() {
    Wrap<String> pageUriSeaportFacilityWrap = new Wrap<String>().var("pageUriSeaportFacility");
    if(pageUriSeaportFacility == null) {
      _pageUriSeaportFacility(pageUriSeaportFacilityWrap);
      Optional.ofNullable(pageUriSeaportFacilityWrap.getO()).ifPresent(o -> {
        setPageUriSeaportFacility(o);
      });
    }
    return (SeaportFacilityGenPage)this;
  }

  public static String staticSearchPageUriSeaportFacility(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriSeaportFacility(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriSeaportFacility(SiteRequest siteRequest_, String o) {
    return SeaportFacilityGenPage.staticSearchPageUriSeaportFacility(siteRequest_, SeaportFacilityGenPage.staticSetPageUriSeaportFacility(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<SeaportFacilityGenPageGen<DEV>> promiseDeepSeaportFacilityGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepSeaportFacilityGenPage();
  }

  public Future<SeaportFacilityGenPageGen<DEV>> promiseDeepSeaportFacilityGenPage() {
    Promise<SeaportFacilityGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseSeaportFacilityGenPage(promise2);
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

  public Future<Void> promiseSeaportFacilityGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListSeaportFacility_Init();
        listSeaportFacilityInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriSeaportFacilityInit();
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

  @Override public Future<? extends SeaportFacilityGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepSeaportFacilityGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestSeaportFacilityGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestSeaportFacilityGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainSeaportFacilityGenPage(v);
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
  public Object obtainSeaportFacilityGenPage(String var) {
    SeaportFacilityGenPage oSeaportFacilityGenPage = (SeaportFacilityGenPage)this;
    switch(var) {
      case "searchListSeaportFacility_":
        return oSeaportFacilityGenPage.searchListSeaportFacility_;
      case "listSeaportFacility":
        return oSeaportFacilityGenPage.listSeaportFacility;
      case "resultCount":
        return oSeaportFacilityGenPage.resultCount;
      case "result":
        return oSeaportFacilityGenPage.result;
      case "pk":
        return oSeaportFacilityGenPage.pk;
      case "solrId":
        return oSeaportFacilityGenPage.solrId;
      case "pageUriSeaportFacility":
        return oSeaportFacilityGenPage.pageUriSeaportFacility;
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
        o = relateSeaportFacilityGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateSeaportFacilityGenPage(String var, Object val) {
    SeaportFacilityGenPage oSeaportFacilityGenPage = (SeaportFacilityGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, SeaportFacilityGenPage o) {
    return staticSetSeaportFacilityGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetSeaportFacilityGenPage(String entityVar, SiteRequest siteRequest_, String v, SeaportFacilityGenPage o) {
    switch(entityVar) {
    case "listSeaportFacility":
      return SeaportFacilityGenPage.staticSetListSeaportFacility(siteRequest_, v);
    case "resultCount":
      return SeaportFacilityGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return SeaportFacilityGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return SeaportFacilityGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriSeaportFacility":
      return SeaportFacilityGenPage.staticSetPageUriSeaportFacility(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchSeaportFacilityGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchSeaportFacilityGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listSeaportFacility":
      return SeaportFacilityGenPage.staticSearchListSeaportFacility(siteRequest_, (JsonArray)o);
    case "resultCount":
      return SeaportFacilityGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return SeaportFacilityGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return SeaportFacilityGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriSeaportFacility":
      return SeaportFacilityGenPage.staticSearchPageUriSeaportFacility(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrSeaportFacilityGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrSeaportFacilityGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listSeaportFacility":
      return SeaportFacilityGenPage.staticSearchStrListSeaportFacility(siteRequest_, (String)o);
    case "resultCount":
      return SeaportFacilityGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return SeaportFacilityGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return SeaportFacilityGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriSeaportFacility":
      return SeaportFacilityGenPage.staticSearchStrPageUriSeaportFacility(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqSeaportFacilityGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqSeaportFacilityGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listSeaportFacility":
      return SeaportFacilityGenPage.staticSearchFqListSeaportFacility(siteRequest_, o);
    case "resultCount":
      return SeaportFacilityGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return SeaportFacilityGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return SeaportFacilityGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriSeaportFacility":
      return SeaportFacilityGenPage.staticSearchFqPageUriSeaportFacility(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "SeaportFacilityGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListSeaportFacility_ = "searchListSeaportFacility_";
  public static final String VAR_listSeaportFacility = "listSeaportFacility";
  public static final String VAR_resultCount = "resultCount";
  public static final String VAR_result = "result";
  public static final String VAR_pk = "pk";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_pageUriSeaportFacility = "pageUriSeaportFacility";

  public static final String DISPLAY_NAME_searchListSeaportFacility_ = "";
  public static final String DISPLAY_NAME_listSeaportFacility = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriSeaportFacility = "";

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
    return SeaportFacilityGenPage.displayNameSeaportFacilityGenPage(var);
  }
  public static String displayNameSeaportFacilityGenPage(String var) {
    switch(var) {
    case VAR_searchListSeaportFacility_:
      return DISPLAY_NAME_searchListSeaportFacility_;
    case VAR_listSeaportFacility:
      return DISPLAY_NAME_listSeaportFacility;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriSeaportFacility:
      return DISPLAY_NAME_pageUriSeaportFacility;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }

  public static String descriptionSeaportFacilityGenPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return PageLayout.descriptionPageLayout(var);
    }
  }

  public static String classSimpleNameSeaportFacilityGenPage(String var) {
    switch(var) {
    case VAR_searchListSeaportFacility_:
      return "SearchList";
    case VAR_listSeaportFacility:
      return "JsonArray";
    case VAR_resultCount:
      return "Integer";
    case VAR_result:
      return "SeaportFacility";
    case VAR_pk:
      return "Long";
    case VAR_solrId:
      return "String";
    case VAR_pageUriSeaportFacility:
      return "String";
      default:
        return PageLayout.classSimpleNamePageLayout(var);
    }
  }

  public static Integer htmColumnSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmColumnPageLayout(var);
    }
  }

  public static Integer htmRowSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmRowPageLayout(var);
    }
  }

  public static Integer htmCellSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.htmCellPageLayout(var);
    }
  }

  public static Integer lengthMinSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMinPageLayout(var);
    }
  }

  public static Integer lengthMaxSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.lengthMaxPageLayout(var);
    }
  }

  public static Integer maxSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.maxPageLayout(var);
    }
  }

  public static Integer minSeaportFacilityGenPage(String var) {
    switch(var) {
      default:
        return PageLayout.minPageLayout(var);
    }
  }
}
