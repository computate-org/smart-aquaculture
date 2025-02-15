package com.example.site.model.fiware.crowdflowobserved;

import com.example.site.request.SiteRequest;
import com.example.site.page.PageLayout;
import com.example.site.model.BaseModel;
import org.computate.vertx.api.ApiRequest;
import com.example.site.config.ConfigKeys;
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
import com.example.site.model.fiware.crowdflowobserved.CrowdFlowObserved;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these CrowdFlowObservedGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class CrowdFlowObservedGenPageGen into the class CrowdFlowObservedGenPage. 
 * </li>
 * <h3>About the CrowdFlowObservedGenPage class and it's generated class CrowdFlowObservedGenPageGen&lt;PageLayout&gt;: </h3>extends CrowdFlowObservedGenPageGen
 * <p>
 * This Java class extends a generated Java class CrowdFlowObservedGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage">Find the class CrowdFlowObservedGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends CrowdFlowObservedGenPageGen<PageLayout>
 * <p>This <code>class CrowdFlowObservedGenPage extends CrowdFlowObservedGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated CrowdFlowObservedGenPageGen. 
 * The generated <code>class CrowdFlowObservedGenPageGen extends PageLayout</code> which means that CrowdFlowObservedGenPage extends CrowdFlowObservedGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the CrowdFlowObservedGenPage class will inherit the helpful inherited class comments from the super class CrowdFlowObservedGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the CrowdFlowObservedGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class CrowdFlowObservedGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package com.example.site.model.fiware.crowdflowobserved in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class CrowdFlowObservedGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(CrowdFlowObservedGenPage.class);

	//////////////////////////////////
	// searchListCrowdFlowObserved_ //
	//////////////////////////////////


	/**	 The entity searchListCrowdFlowObserved_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<CrowdFlowObserved> searchListCrowdFlowObserved_;

	/**	<br> The entity searchListCrowdFlowObserved_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:searchListCrowdFlowObserved_">Find the entity searchListCrowdFlowObserved_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListCrowdFlowObserved_(Wrap<SearchList<CrowdFlowObserved>> w);

	public SearchList<CrowdFlowObserved> getSearchListCrowdFlowObserved_() {
		return searchListCrowdFlowObserved_;
	}

	public void setSearchListCrowdFlowObserved_(SearchList<CrowdFlowObserved> searchListCrowdFlowObserved_) {
		this.searchListCrowdFlowObserved_ = searchListCrowdFlowObserved_;
	}
	public static SearchList<CrowdFlowObserved> staticSetSearchListCrowdFlowObserved_(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected CrowdFlowObservedGenPage searchListCrowdFlowObserved_Init() {
		Wrap<SearchList<CrowdFlowObserved>> searchListCrowdFlowObserved_Wrap = new Wrap<SearchList<CrowdFlowObserved>>().var("searchListCrowdFlowObserved_");
		if(searchListCrowdFlowObserved_ == null) {
			_searchListCrowdFlowObserved_(searchListCrowdFlowObserved_Wrap);
			Optional.ofNullable(searchListCrowdFlowObserved_Wrap.getO()).ifPresent(o -> {
				setSearchListCrowdFlowObserved_(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	///////////////////////////
	// listCrowdFlowObserved //
	///////////////////////////


	/**	 The entity listCrowdFlowObserved
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonArrayDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listCrowdFlowObserved = new JsonArray();

	/**	<br> The entity listCrowdFlowObserved
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:listCrowdFlowObserved">Find the entity listCrowdFlowObserved in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listCrowdFlowObserved(JsonArray l);

	public JsonArray getListCrowdFlowObserved() {
		return listCrowdFlowObserved;
	}

	public void setListCrowdFlowObserved(JsonArray listCrowdFlowObserved) {
		this.listCrowdFlowObserved = listCrowdFlowObserved;
	}
	@JsonIgnore
	public void setListCrowdFlowObserved(String o) {
		this.listCrowdFlowObserved = CrowdFlowObservedGenPage.staticSetListCrowdFlowObserved(siteRequest_, o);
	}
	public static JsonArray staticSetListCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected CrowdFlowObservedGenPage listCrowdFlowObservedInit() {
		_listCrowdFlowObserved(listCrowdFlowObserved);
		return (CrowdFlowObservedGenPage)this;
	}

	public static String staticSearchListCrowdFlowObserved(SiteRequest siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return CrowdFlowObservedGenPage.staticSearchListCrowdFlowObserved(siteRequest_, CrowdFlowObservedGenPage.staticSetListCrowdFlowObserved(siteRequest_, o)).toString();
	}

	/////////////////
	// resultCount //
	/////////////////


	/**	 The entity resultCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer resultCount;

	/**	<br> The entity resultCount
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
		this.resultCount = CrowdFlowObservedGenPage.staticSetResultCount(siteRequest_, o);
	}
	public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected CrowdFlowObservedGenPage resultCountInit() {
		Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
		if(resultCount == null) {
			_resultCount(resultCountWrap);
			Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
				setResultCount(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
		return CrowdFlowObservedGenPage.staticSearchResultCount(siteRequest_, CrowdFlowObservedGenPage.staticSetResultCount(siteRequest_, o)).toString();
	}

	////////////
	// result //
	////////////


	/**	 The entity result
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected CrowdFlowObserved result;

	/**	<br> The entity result
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _result(Wrap<CrowdFlowObserved> w);

	public CrowdFlowObserved getResult() {
		return result;
	}

	public void setResult(CrowdFlowObserved result) {
		this.result = result;
	}
	public static CrowdFlowObserved staticSetResult(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected CrowdFlowObservedGenPage resultInit() {
		Wrap<CrowdFlowObserved> resultWrap = new Wrap<CrowdFlowObserved>().var("result");
		if(result == null) {
			_result(resultWrap);
			Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
				setResult(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	////////
	// pk //
	////////


	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br> The entity pk
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = CrowdFlowObservedGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected CrowdFlowObservedGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
		return CrowdFlowObservedGenPage.staticSearchPk(siteRequest_, CrowdFlowObservedGenPage.staticSetPk(siteRequest_, o)).toString();
	}

	////////////
	// solrId //
	////////////


	/**	 The entity solrId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String solrId;

	/**	<br> The entity solrId
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _solrId(Wrap<String> w);

	public String getSolrId() {
		return solrId;
	}
	public void setSolrId(String o) {
		this.solrId = CrowdFlowObservedGenPage.staticSetSolrId(siteRequest_, o);
	}
	public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObservedGenPage solrIdInit() {
		Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
		if(solrId == null) {
			_solrId(solrIdWrap);
			Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
				setSolrId(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
		return CrowdFlowObservedGenPage.staticSearchSolrId(siteRequest_, CrowdFlowObservedGenPage.staticSetSolrId(siteRequest_, o)).toString();
	}

	//////////////////////////////
	// pageUriCrowdFlowObserved //
	//////////////////////////////


	/**	 The entity pageUriCrowdFlowObserved
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriCrowdFlowObserved;

	/**	<br> The entity pageUriCrowdFlowObserved
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.crowdflowobserved.CrowdFlowObservedGenPage&fq=entiteVar_enUS_indexed_string:pageUriCrowdFlowObserved">Find the entity pageUriCrowdFlowObserved in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriCrowdFlowObserved(Wrap<String> c);

	public String getPageUriCrowdFlowObserved() {
		return pageUriCrowdFlowObserved;
	}
	public void setPageUriCrowdFlowObserved(String o) {
		this.pageUriCrowdFlowObserved = CrowdFlowObservedGenPage.staticSetPageUriCrowdFlowObserved(siteRequest_, o);
	}
	public static String staticSetPageUriCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObservedGenPage pageUriCrowdFlowObservedInit() {
		Wrap<String> pageUriCrowdFlowObservedWrap = new Wrap<String>().var("pageUriCrowdFlowObserved");
		if(pageUriCrowdFlowObserved == null) {
			_pageUriCrowdFlowObserved(pageUriCrowdFlowObservedWrap);
			Optional.ofNullable(pageUriCrowdFlowObservedWrap.getO()).ifPresent(o -> {
				setPageUriCrowdFlowObserved(o);
			});
		}
		return (CrowdFlowObservedGenPage)this;
	}

	public static String staticSearchPageUriCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriCrowdFlowObserved(SiteRequest siteRequest_, String o) {
		return CrowdFlowObservedGenPage.staticSearchPageUriCrowdFlowObserved(siteRequest_, CrowdFlowObservedGenPage.staticSetPageUriCrowdFlowObserved(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<CrowdFlowObservedGenPageGen<DEV>> promiseDeepCrowdFlowObservedGenPage(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepCrowdFlowObservedGenPage();
	}

	public Future<CrowdFlowObservedGenPageGen<DEV>> promiseDeepCrowdFlowObservedGenPage() {
		Promise<CrowdFlowObservedGenPageGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseCrowdFlowObservedGenPage(promise2);
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

	public Future<Void> promiseCrowdFlowObservedGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListCrowdFlowObserved_Init();
				listCrowdFlowObservedInit();
				resultCountInit();
				resultInit();
				pkInit();
				solrIdInit();
				pageUriCrowdFlowObservedInit();
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

	@Override public Future<? extends CrowdFlowObservedGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepCrowdFlowObservedGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestCrowdFlowObservedGenPage(SiteRequest siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestCrowdFlowObservedGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCrowdFlowObservedGenPage(v);
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
	public Object obtainCrowdFlowObservedGenPage(String var) {
		CrowdFlowObservedGenPage oCrowdFlowObservedGenPage = (CrowdFlowObservedGenPage)this;
		switch(var) {
			case "searchListCrowdFlowObserved_":
				return oCrowdFlowObservedGenPage.searchListCrowdFlowObserved_;
			case "listCrowdFlowObserved":
				return oCrowdFlowObservedGenPage.listCrowdFlowObserved;
			case "resultCount":
				return oCrowdFlowObservedGenPage.resultCount;
			case "result":
				return oCrowdFlowObservedGenPage.result;
			case "pk":
				return oCrowdFlowObservedGenPage.pk;
			case "solrId":
				return oCrowdFlowObservedGenPage.solrId;
			case "pageUriCrowdFlowObserved":
				return oCrowdFlowObservedGenPage.pageUriCrowdFlowObserved;
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
				o = relateCrowdFlowObservedGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateCrowdFlowObservedGenPage(String var, Object val) {
		CrowdFlowObservedGenPage oCrowdFlowObservedGenPage = (CrowdFlowObservedGenPage)this;
		switch(var) {
			default:
				return super.relatePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSetCrowdFlowObservedGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetCrowdFlowObservedGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSetListCrowdFlowObserved(siteRequest_, o);
		case "resultCount":
			return CrowdFlowObservedGenPage.staticSetResultCount(siteRequest_, o);
		case "pk":
			return CrowdFlowObservedGenPage.staticSetPk(siteRequest_, o);
		case "solrId":
			return CrowdFlowObservedGenPage.staticSetSolrId(siteRequest_, o);
		case "pageUriCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSetPageUriCrowdFlowObserved(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchCrowdFlowObservedGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchCrowdFlowObservedGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchListCrowdFlowObserved(siteRequest_, (JsonArray)o);
		case "resultCount":
			return CrowdFlowObservedGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
		case "pk":
			return CrowdFlowObservedGenPage.staticSearchPk(siteRequest_, (Long)o);
		case "solrId":
			return CrowdFlowObservedGenPage.staticSearchSolrId(siteRequest_, (String)o);
		case "pageUriCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchPageUriCrowdFlowObserved(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrCrowdFlowObservedGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrCrowdFlowObservedGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchStrListCrowdFlowObserved(siteRequest_, (String)o);
		case "resultCount":
			return CrowdFlowObservedGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
		case "pk":
			return CrowdFlowObservedGenPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "solrId":
			return CrowdFlowObservedGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
		case "pageUriCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchStrPageUriCrowdFlowObserved(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqCrowdFlowObservedGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqCrowdFlowObservedGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchFqListCrowdFlowObserved(siteRequest_, o);
		case "resultCount":
			return CrowdFlowObservedGenPage.staticSearchFqResultCount(siteRequest_, o);
		case "pk":
			return CrowdFlowObservedGenPage.staticSearchFqPk(siteRequest_, o);
		case "solrId":
			return CrowdFlowObservedGenPage.staticSearchFqSolrId(siteRequest_, o);
		case "pageUriCrowdFlowObserved":
			return CrowdFlowObservedGenPage.staticSearchFqPageUriCrowdFlowObserved(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "CrowdFlowObservedGenPage";
	public static final String VAR_searchListCrowdFlowObserved_ = "searchListCrowdFlowObserved_";
	public static final String VAR_listCrowdFlowObserved = "listCrowdFlowObserved";
	public static final String VAR_resultCount = "resultCount";
	public static final String VAR_result = "result";
	public static final String VAR_pk = "pk";
	public static final String VAR_solrId = "solrId";
	public static final String VAR_pageUriCrowdFlowObserved = "pageUriCrowdFlowObserved";

	public static final String DISPLAY_NAME_searchListCrowdFlowObserved_ = "";
	public static final String DISPLAY_NAME_listCrowdFlowObserved = "";
	public static final String DISPLAY_NAME_resultCount = "";
	public static final String DISPLAY_NAME_result = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_solrId = "";
	public static final String DISPLAY_NAME_pageUriCrowdFlowObserved = "";

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
	public String classStringFormatUrlEditPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlDisplayPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlUserPageForClass() {
		return null;
	}

	public static String displayNameForClass(String var) {
		return CrowdFlowObservedGenPage.displayNameCrowdFlowObservedGenPage(var);
	}
	public static String displayNameCrowdFlowObservedGenPage(String var) {
		switch(var) {
		case VAR_searchListCrowdFlowObserved_:
			return DISPLAY_NAME_searchListCrowdFlowObserved_;
		case VAR_listCrowdFlowObserved:
			return DISPLAY_NAME_listCrowdFlowObserved;
		case VAR_resultCount:
			return DISPLAY_NAME_resultCount;
		case VAR_result:
			return DISPLAY_NAME_result;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_solrId:
			return DISPLAY_NAME_solrId;
		case VAR_pageUriCrowdFlowObserved:
			return DISPLAY_NAME_pageUriCrowdFlowObserved;
		default:
			return PageLayout.displayNamePageLayout(var);
		}
	}

	public static String descriptionCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.descriptionPageLayout(var);
		}
	}

	public static String classSimpleNameCrowdFlowObservedGenPage(String var) {
		switch(var) {
		case VAR_searchListCrowdFlowObserved_:
			return "SearchList";
		case VAR_listCrowdFlowObserved:
			return "JsonArray";
		case VAR_resultCount:
			return "Integer";
		case VAR_result:
			return "CrowdFlowObserved";
		case VAR_pk:
			return "Long";
		case VAR_solrId:
			return "String";
		case VAR_pageUriCrowdFlowObserved:
			return "String";
			default:
				return PageLayout.classSimpleNamePageLayout(var);
		}
	}

	public static Integer htmColumnCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmColumnPageLayout(var);
		}
	}

	public static Integer htmRowCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmRowPageLayout(var);
		}
	}

	public static Integer htmCellCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmCellPageLayout(var);
		}
	}

	public static Integer lengthMinCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMinPageLayout(var);
		}
	}

	public static Integer lengthMaxCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMaxPageLayout(var);
		}
	}

	public static Integer maxCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.maxPageLayout(var);
		}
	}

	public static Integer minCrowdFlowObservedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.minPageLayout(var);
		}
	}
}
