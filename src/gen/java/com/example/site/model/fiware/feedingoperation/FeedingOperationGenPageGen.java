package com.example.site.model.fiware.feedingoperation;

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
import com.example.site.model.fiware.feedingoperation.FeedingOperation;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FeedingOperationGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FeedingOperationGenPageGen into the class FeedingOperationGenPage. 
 * </li>
 * <h3>About the FeedingOperationGenPage class and it's generated class FeedingOperationGenPageGen&lt;PageLayout&gt;: </h3>extends FeedingOperationGenPageGen
 * <p>
 * This Java class extends a generated Java class FeedingOperationGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage">Find the class FeedingOperationGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FeedingOperationGenPageGen<PageLayout>
 * <p>This <code>class FeedingOperationGenPage extends FeedingOperationGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FeedingOperationGenPageGen. 
 * The generated <code>class FeedingOperationGenPageGen extends PageLayout</code> which means that FeedingOperationGenPage extends FeedingOperationGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FeedingOperationGenPage class will inherit the helpful inherited class comments from the super class FeedingOperationGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FeedingOperationGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FeedingOperationGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package com.example.site.model.fiware.feedingoperation in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:com.example.site.model.fiware.feedingoperation&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FeedingOperationGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(FeedingOperationGenPage.class);

	/////////////////////////////////
	// searchListFeedingOperation_ //
	/////////////////////////////////


	/**	 The entity searchListFeedingOperation_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<FeedingOperation> searchListFeedingOperation_;

	/**	<br> The entity searchListFeedingOperation_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:searchListFeedingOperation_">Find the entity searchListFeedingOperation_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListFeedingOperation_(Wrap<SearchList<FeedingOperation>> w);

	public SearchList<FeedingOperation> getSearchListFeedingOperation_() {
		return searchListFeedingOperation_;
	}

	public void setSearchListFeedingOperation_(SearchList<FeedingOperation> searchListFeedingOperation_) {
		this.searchListFeedingOperation_ = searchListFeedingOperation_;
	}
	public static SearchList<FeedingOperation> staticSetSearchListFeedingOperation_(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected FeedingOperationGenPage searchListFeedingOperation_Init() {
		Wrap<SearchList<FeedingOperation>> searchListFeedingOperation_Wrap = new Wrap<SearchList<FeedingOperation>>().var("searchListFeedingOperation_");
		if(searchListFeedingOperation_ == null) {
			_searchListFeedingOperation_(searchListFeedingOperation_Wrap);
			Optional.ofNullable(searchListFeedingOperation_Wrap.getO()).ifPresent(o -> {
				setSearchListFeedingOperation_(o);
			});
		}
		return (FeedingOperationGenPage)this;
	}

	//////////////////////////
	// listFeedingOperation //
	//////////////////////////


	/**	 The entity listFeedingOperation
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonArrayDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listFeedingOperation = new JsonArray();

	/**	<br> The entity listFeedingOperation
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:listFeedingOperation">Find the entity listFeedingOperation in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listFeedingOperation(JsonArray l);

	public JsonArray getListFeedingOperation() {
		return listFeedingOperation;
	}

	public void setListFeedingOperation(JsonArray listFeedingOperation) {
		this.listFeedingOperation = listFeedingOperation;
	}
	@JsonIgnore
	public void setListFeedingOperation(String o) {
		this.listFeedingOperation = FeedingOperationGenPage.staticSetListFeedingOperation(siteRequest_, o);
	}
	public static JsonArray staticSetListFeedingOperation(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected FeedingOperationGenPage listFeedingOperationInit() {
		_listFeedingOperation(listFeedingOperation);
		return (FeedingOperationGenPage)this;
	}

	public static String staticSearchListFeedingOperation(SiteRequest siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListFeedingOperation(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListFeedingOperation(SiteRequest siteRequest_, String o) {
		return FeedingOperationGenPage.staticSearchListFeedingOperation(siteRequest_, FeedingOperationGenPage.staticSetListFeedingOperation(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
		this.resultCount = FeedingOperationGenPage.staticSetResultCount(siteRequest_, o);
	}
	public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected FeedingOperationGenPage resultCountInit() {
		Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
		if(resultCount == null) {
			_resultCount(resultCountWrap);
			Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
				setResultCount(o);
			});
		}
		return (FeedingOperationGenPage)this;
	}

	public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
		return FeedingOperationGenPage.staticSearchResultCount(siteRequest_, FeedingOperationGenPage.staticSetResultCount(siteRequest_, o)).toString();
	}

	////////////
	// result //
	////////////


	/**	 The entity result
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected FeedingOperation result;

	/**	<br> The entity result
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _result(Wrap<FeedingOperation> w);

	public FeedingOperation getResult() {
		return result;
	}

	public void setResult(FeedingOperation result) {
		this.result = result;
	}
	public static FeedingOperation staticSetResult(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected FeedingOperationGenPage resultInit() {
		Wrap<FeedingOperation> resultWrap = new Wrap<FeedingOperation>().var("result");
		if(result == null) {
			_result(resultWrap);
			Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
				setResult(o);
			});
		}
		return (FeedingOperationGenPage)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = FeedingOperationGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected FeedingOperationGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (FeedingOperationGenPage)this;
	}

	public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
		return FeedingOperationGenPage.staticSearchPk(siteRequest_, FeedingOperationGenPage.staticSetPk(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _solrId(Wrap<String> w);

	public String getSolrId() {
		return solrId;
	}
	public void setSolrId(String o) {
		this.solrId = FeedingOperationGenPage.staticSetSolrId(siteRequest_, o);
	}
	public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FeedingOperationGenPage solrIdInit() {
		Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
		if(solrId == null) {
			_solrId(solrIdWrap);
			Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
				setSolrId(o);
			});
		}
		return (FeedingOperationGenPage)this;
	}

	public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
		return FeedingOperationGenPage.staticSearchSolrId(siteRequest_, FeedingOperationGenPage.staticSetSolrId(siteRequest_, o)).toString();
	}

	/////////////////////////////
	// pageUriFeedingOperation //
	/////////////////////////////


	/**	 The entity pageUriFeedingOperation
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriFeedingOperation;

	/**	<br> The entity pageUriFeedingOperation
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feedingoperation.FeedingOperationGenPage&fq=entiteVar_enUS_indexed_string:pageUriFeedingOperation">Find the entity pageUriFeedingOperation in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriFeedingOperation(Wrap<String> c);

	public String getPageUriFeedingOperation() {
		return pageUriFeedingOperation;
	}
	public void setPageUriFeedingOperation(String o) {
		this.pageUriFeedingOperation = FeedingOperationGenPage.staticSetPageUriFeedingOperation(siteRequest_, o);
	}
	public static String staticSetPageUriFeedingOperation(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FeedingOperationGenPage pageUriFeedingOperationInit() {
		Wrap<String> pageUriFeedingOperationWrap = new Wrap<String>().var("pageUriFeedingOperation");
		if(pageUriFeedingOperation == null) {
			_pageUriFeedingOperation(pageUriFeedingOperationWrap);
			Optional.ofNullable(pageUriFeedingOperationWrap.getO()).ifPresent(o -> {
				setPageUriFeedingOperation(o);
			});
		}
		return (FeedingOperationGenPage)this;
	}

	public static String staticSearchPageUriFeedingOperation(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriFeedingOperation(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriFeedingOperation(SiteRequest siteRequest_, String o) {
		return FeedingOperationGenPage.staticSearchPageUriFeedingOperation(siteRequest_, FeedingOperationGenPage.staticSetPageUriFeedingOperation(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FeedingOperationGenPageGen<DEV>> promiseDeepFeedingOperationGenPage(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFeedingOperationGenPage();
	}

	public Future<FeedingOperationGenPageGen<DEV>> promiseDeepFeedingOperationGenPage() {
		Promise<FeedingOperationGenPageGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFeedingOperationGenPage(promise2);
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

	public Future<Void> promiseFeedingOperationGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListFeedingOperation_Init();
				listFeedingOperationInit();
				resultCountInit();
				resultInit();
				pkInit();
				solrIdInit();
				pageUriFeedingOperationInit();
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

	@Override public Future<? extends FeedingOperationGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFeedingOperationGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFeedingOperationGenPage(SiteRequest siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFeedingOperationGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFeedingOperationGenPage(v);
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
	public Object obtainFeedingOperationGenPage(String var) {
		FeedingOperationGenPage oFeedingOperationGenPage = (FeedingOperationGenPage)this;
		switch(var) {
			case "searchListFeedingOperation_":
				return oFeedingOperationGenPage.searchListFeedingOperation_;
			case "listFeedingOperation":
				return oFeedingOperationGenPage.listFeedingOperation;
			case "resultCount":
				return oFeedingOperationGenPage.resultCount;
			case "result":
				return oFeedingOperationGenPage.result;
			case "pk":
				return oFeedingOperationGenPage.pk;
			case "solrId":
				return oFeedingOperationGenPage.solrId;
			case "pageUriFeedingOperation":
				return oFeedingOperationGenPage.pageUriFeedingOperation;
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
				o = relateFeedingOperationGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFeedingOperationGenPage(String var, Object val) {
		FeedingOperationGenPage oFeedingOperationGenPage = (FeedingOperationGenPage)this;
		switch(var) {
			default:
				return super.relatePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSetFeedingOperationGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetFeedingOperationGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listFeedingOperation":
			return FeedingOperationGenPage.staticSetListFeedingOperation(siteRequest_, o);
		case "resultCount":
			return FeedingOperationGenPage.staticSetResultCount(siteRequest_, o);
		case "pk":
			return FeedingOperationGenPage.staticSetPk(siteRequest_, o);
		case "solrId":
			return FeedingOperationGenPage.staticSetSolrId(siteRequest_, o);
		case "pageUriFeedingOperation":
			return FeedingOperationGenPage.staticSetPageUriFeedingOperation(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFeedingOperationGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFeedingOperationGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listFeedingOperation":
			return FeedingOperationGenPage.staticSearchListFeedingOperation(siteRequest_, (JsonArray)o);
		case "resultCount":
			return FeedingOperationGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
		case "pk":
			return FeedingOperationGenPage.staticSearchPk(siteRequest_, (Long)o);
		case "solrId":
			return FeedingOperationGenPage.staticSearchSolrId(siteRequest_, (String)o);
		case "pageUriFeedingOperation":
			return FeedingOperationGenPage.staticSearchPageUriFeedingOperation(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFeedingOperationGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFeedingOperationGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listFeedingOperation":
			return FeedingOperationGenPage.staticSearchStrListFeedingOperation(siteRequest_, (String)o);
		case "resultCount":
			return FeedingOperationGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
		case "pk":
			return FeedingOperationGenPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "solrId":
			return FeedingOperationGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
		case "pageUriFeedingOperation":
			return FeedingOperationGenPage.staticSearchStrPageUriFeedingOperation(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFeedingOperationGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFeedingOperationGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listFeedingOperation":
			return FeedingOperationGenPage.staticSearchFqListFeedingOperation(siteRequest_, o);
		case "resultCount":
			return FeedingOperationGenPage.staticSearchFqResultCount(siteRequest_, o);
		case "pk":
			return FeedingOperationGenPage.staticSearchFqPk(siteRequest_, o);
		case "solrId":
			return FeedingOperationGenPage.staticSearchFqSolrId(siteRequest_, o);
		case "pageUriFeedingOperation":
			return FeedingOperationGenPage.staticSearchFqPageUriFeedingOperation(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "FeedingOperationGenPage";
	public static final String VAR_searchListFeedingOperation_ = "searchListFeedingOperation_";
	public static final String VAR_listFeedingOperation = "listFeedingOperation";
	public static final String VAR_resultCount = "resultCount";
	public static final String VAR_result = "result";
	public static final String VAR_pk = "pk";
	public static final String VAR_solrId = "solrId";
	public static final String VAR_pageUriFeedingOperation = "pageUriFeedingOperation";

	public static final String DISPLAY_NAME_searchListFeedingOperation_ = "";
	public static final String DISPLAY_NAME_listFeedingOperation = "";
	public static final String DISPLAY_NAME_resultCount = "";
	public static final String DISPLAY_NAME_result = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_solrId = "";
	public static final String DISPLAY_NAME_pageUriFeedingOperation = "";

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
		return FeedingOperationGenPage.displayNameFeedingOperationGenPage(var);
	}
	public static String displayNameFeedingOperationGenPage(String var) {
		switch(var) {
		case VAR_searchListFeedingOperation_:
			return DISPLAY_NAME_searchListFeedingOperation_;
		case VAR_listFeedingOperation:
			return DISPLAY_NAME_listFeedingOperation;
		case VAR_resultCount:
			return DISPLAY_NAME_resultCount;
		case VAR_result:
			return DISPLAY_NAME_result;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_solrId:
			return DISPLAY_NAME_solrId;
		case VAR_pageUriFeedingOperation:
			return DISPLAY_NAME_pageUriFeedingOperation;
		default:
			return PageLayout.displayNamePageLayout(var);
		}
	}

	public static String descriptionFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.descriptionPageLayout(var);
		}
	}

	public static String classSimpleNameFeedingOperationGenPage(String var) {
		switch(var) {
		case VAR_searchListFeedingOperation_:
			return "SearchList";
		case VAR_listFeedingOperation:
			return "JsonArray";
		case VAR_resultCount:
			return "Integer";
		case VAR_result:
			return "FeedingOperation";
		case VAR_pk:
			return "Long";
		case VAR_solrId:
			return "String";
		case VAR_pageUriFeedingOperation:
			return "String";
			default:
				return PageLayout.classSimpleNamePageLayout(var);
		}
	}

	public static Integer htmColumnFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmColumnPageLayout(var);
		}
	}

	public static Integer htmRowFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmRowPageLayout(var);
		}
	}

	public static Integer htmCellFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmCellPageLayout(var);
		}
	}

	public static Integer lengthMinFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMinPageLayout(var);
		}
	}

	public static Integer lengthMaxFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMaxPageLayout(var);
		}
	}

	public static Integer maxFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.maxPageLayout(var);
		}
	}

	public static Integer minFeedingOperationGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.minPageLayout(var);
		}
	}
}
