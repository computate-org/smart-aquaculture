package com.example.site.model.fiware.feed;

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
import com.example.site.model.fiware.feed.Feed;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FeedGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FeedGenPageGen into the class FeedGenPage. 
 * </li>
 * <h3>About the FeedGenPage class and it's generated class FeedGenPageGen&lt;PageLayout&gt;: </h3>extends FeedGenPageGen
 * <p>
 * This Java class extends a generated Java class FeedGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage">Find the class FeedGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FeedGenPageGen<PageLayout>
 * <p>This <code>class FeedGenPage extends FeedGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated FeedGenPageGen. 
 * The generated <code>class FeedGenPageGen extends PageLayout</code> which means that FeedGenPage extends FeedGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FeedGenPage class will inherit the helpful inherited class comments from the super class FeedGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FeedGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class FeedGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package com.example.site.model.fiware.feed in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:com.example.site.model.fiware.feed&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FeedGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(FeedGenPage.class);

	/////////////////////
	// searchListFeed_ //
	/////////////////////


	/**	 The entity searchListFeed_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<Feed> searchListFeed_;

	/**	<br> The entity searchListFeed_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:searchListFeed_">Find the entity searchListFeed_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListFeed_(Wrap<SearchList<Feed>> w);

	public SearchList<Feed> getSearchListFeed_() {
		return searchListFeed_;
	}

	public void setSearchListFeed_(SearchList<Feed> searchListFeed_) {
		this.searchListFeed_ = searchListFeed_;
	}
	public static SearchList<Feed> staticSetSearchListFeed_(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected FeedGenPage searchListFeed_Init() {
		Wrap<SearchList<Feed>> searchListFeed_Wrap = new Wrap<SearchList<Feed>>().var("searchListFeed_");
		if(searchListFeed_ == null) {
			_searchListFeed_(searchListFeed_Wrap);
			Optional.ofNullable(searchListFeed_Wrap.getO()).ifPresent(o -> {
				setSearchListFeed_(o);
			});
		}
		return (FeedGenPage)this;
	}

	//////////////
	// listFeed //
	//////////////


	/**	 The entity listFeed
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonArrayDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listFeed = new JsonArray();

	/**	<br> The entity listFeed
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:listFeed">Find the entity listFeed in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listFeed(JsonArray l);

	public JsonArray getListFeed() {
		return listFeed;
	}

	public void setListFeed(JsonArray listFeed) {
		this.listFeed = listFeed;
	}
	@JsonIgnore
	public void setListFeed(String o) {
		this.listFeed = FeedGenPage.staticSetListFeed(siteRequest_, o);
	}
	public static JsonArray staticSetListFeed(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected FeedGenPage listFeedInit() {
		_listFeed(listFeed);
		return (FeedGenPage)this;
	}

	public static String staticSearchListFeed(SiteRequest siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListFeed(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListFeed(SiteRequest siteRequest_, String o) {
		return FeedGenPage.staticSearchListFeed(siteRequest_, FeedGenPage.staticSetListFeed(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
		this.resultCount = FeedGenPage.staticSetResultCount(siteRequest_, o);
	}
	public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected FeedGenPage resultCountInit() {
		Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
		if(resultCount == null) {
			_resultCount(resultCountWrap);
			Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
				setResultCount(o);
			});
		}
		return (FeedGenPage)this;
	}

	public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
		return FeedGenPage.staticSearchResultCount(siteRequest_, FeedGenPage.staticSetResultCount(siteRequest_, o)).toString();
	}

	////////////
	// result //
	////////////


	/**	 The entity result
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Feed result;

	/**	<br> The entity result
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _result(Wrap<Feed> w);

	public Feed getResult() {
		return result;
	}

	public void setResult(Feed result) {
		this.result = result;
	}
	public static Feed staticSetResult(SiteRequest siteRequest_, String o) {
		return null;
	}
	protected FeedGenPage resultInit() {
		Wrap<Feed> resultWrap = new Wrap<Feed>().var("result");
		if(result == null) {
			_result(resultWrap);
			Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
				setResult(o);
			});
		}
		return (FeedGenPage)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = FeedGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected FeedGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
				setPk(o);
			});
		}
		return (FeedGenPage)this;
	}

	public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
		return FeedGenPage.staticSearchPk(siteRequest_, FeedGenPage.staticSetPk(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _solrId(Wrap<String> w);

	public String getSolrId() {
		return solrId;
	}
	public void setSolrId(String o) {
		this.solrId = FeedGenPage.staticSetSolrId(siteRequest_, o);
	}
	public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FeedGenPage solrIdInit() {
		Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
		if(solrId == null) {
			_solrId(solrIdWrap);
			Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
				setSolrId(o);
			});
		}
		return (FeedGenPage)this;
	}

	public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
		return FeedGenPage.staticSearchSolrId(siteRequest_, FeedGenPage.staticSetSolrId(siteRequest_, o)).toString();
	}

	/////////////////
	// pageUriFeed //
	/////////////////


	/**	 The entity pageUriFeed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriFeed;

	/**	<br> The entity pageUriFeed
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.example.site.model.fiware.feed.FeedGenPage&fq=entiteVar_enUS_indexed_string:pageUriFeed">Find the entity pageUriFeed in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriFeed(Wrap<String> c);

	public String getPageUriFeed() {
		return pageUriFeed;
	}
	public void setPageUriFeed(String o) {
		this.pageUriFeed = FeedGenPage.staticSetPageUriFeed(siteRequest_, o);
	}
	public static String staticSetPageUriFeed(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FeedGenPage pageUriFeedInit() {
		Wrap<String> pageUriFeedWrap = new Wrap<String>().var("pageUriFeed");
		if(pageUriFeed == null) {
			_pageUriFeed(pageUriFeedWrap);
			Optional.ofNullable(pageUriFeedWrap.getO()).ifPresent(o -> {
				setPageUriFeed(o);
			});
		}
		return (FeedGenPage)this;
	}

	public static String staticSearchPageUriFeed(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriFeed(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriFeed(SiteRequest siteRequest_, String o) {
		return FeedGenPage.staticSearchPageUriFeed(siteRequest_, FeedGenPage.staticSetPageUriFeed(siteRequest_, o)).toString();
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FeedGenPageGen<DEV>> promiseDeepFeedGenPage(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFeedGenPage();
	}

	public Future<FeedGenPageGen<DEV>> promiseDeepFeedGenPage() {
		Promise<FeedGenPageGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFeedGenPage(promise2);
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

	public Future<Void> promiseFeedGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListFeed_Init();
				listFeedInit();
				resultCountInit();
				resultInit();
				pkInit();
				solrIdInit();
				pageUriFeedInit();
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

	@Override public Future<? extends FeedGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFeedGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFeedGenPage(SiteRequest siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFeedGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFeedGenPage(v);
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
	public Object obtainFeedGenPage(String var) {
		FeedGenPage oFeedGenPage = (FeedGenPage)this;
		switch(var) {
			case "searchListFeed_":
				return oFeedGenPage.searchListFeed_;
			case "listFeed":
				return oFeedGenPage.listFeed;
			case "resultCount":
				return oFeedGenPage.resultCount;
			case "result":
				return oFeedGenPage.result;
			case "pk":
				return oFeedGenPage.pk;
			case "solrId":
				return oFeedGenPage.solrId;
			case "pageUriFeed":
				return oFeedGenPage.pageUriFeed;
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
				o = relateFeedGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFeedGenPage(String var, Object val) {
		FeedGenPage oFeedGenPage = (FeedGenPage)this;
		switch(var) {
			default:
				return super.relatePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSetFeedGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetFeedGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listFeed":
			return FeedGenPage.staticSetListFeed(siteRequest_, o);
		case "resultCount":
			return FeedGenPage.staticSetResultCount(siteRequest_, o);
		case "pk":
			return FeedGenPage.staticSetPk(siteRequest_, o);
		case "solrId":
			return FeedGenPage.staticSetSolrId(siteRequest_, o);
		case "pageUriFeed":
			return FeedGenPage.staticSetPageUriFeed(siteRequest_, o);
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFeedGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFeedGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listFeed":
			return FeedGenPage.staticSearchListFeed(siteRequest_, (JsonArray)o);
		case "resultCount":
			return FeedGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
		case "pk":
			return FeedGenPage.staticSearchPk(siteRequest_, (Long)o);
		case "solrId":
			return FeedGenPage.staticSearchSolrId(siteRequest_, (String)o);
		case "pageUriFeed":
			return FeedGenPage.staticSearchPageUriFeed(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFeedGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFeedGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "listFeed":
			return FeedGenPage.staticSearchStrListFeed(siteRequest_, (String)o);
		case "resultCount":
			return FeedGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
		case "pk":
			return FeedGenPage.staticSearchStrPk(siteRequest_, (Long)o);
		case "solrId":
			return FeedGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
		case "pageUriFeed":
			return FeedGenPage.staticSearchStrPageUriFeed(siteRequest_, (String)o);
			default:
				return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFeedGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFeedGenPage(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "listFeed":
			return FeedGenPage.staticSearchFqListFeed(siteRequest_, o);
		case "resultCount":
			return FeedGenPage.staticSearchFqResultCount(siteRequest_, o);
		case "pk":
			return FeedGenPage.staticSearchFqPk(siteRequest_, o);
		case "solrId":
			return FeedGenPage.staticSearchFqSolrId(siteRequest_, o);
		case "pageUriFeed":
			return FeedGenPage.staticSearchFqPageUriFeed(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "FeedGenPage";
	public static final String VAR_searchListFeed_ = "searchListFeed_";
	public static final String VAR_listFeed = "listFeed";
	public static final String VAR_resultCount = "resultCount";
	public static final String VAR_result = "result";
	public static final String VAR_pk = "pk";
	public static final String VAR_solrId = "solrId";
	public static final String VAR_pageUriFeed = "pageUriFeed";

	public static final String DISPLAY_NAME_searchListFeed_ = "";
	public static final String DISPLAY_NAME_listFeed = "";
	public static final String DISPLAY_NAME_resultCount = "";
	public static final String DISPLAY_NAME_result = "";
	public static final String DISPLAY_NAME_pk = "";
	public static final String DISPLAY_NAME_solrId = "";
	public static final String DISPLAY_NAME_pageUriFeed = "";

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
		return FeedGenPage.displayNameFeedGenPage(var);
	}
	public static String displayNameFeedGenPage(String var) {
		switch(var) {
		case VAR_searchListFeed_:
			return DISPLAY_NAME_searchListFeed_;
		case VAR_listFeed:
			return DISPLAY_NAME_listFeed;
		case VAR_resultCount:
			return DISPLAY_NAME_resultCount;
		case VAR_result:
			return DISPLAY_NAME_result;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_solrId:
			return DISPLAY_NAME_solrId;
		case VAR_pageUriFeed:
			return DISPLAY_NAME_pageUriFeed;
		default:
			return PageLayout.displayNamePageLayout(var);
		}
	}

	public static String descriptionFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.descriptionPageLayout(var);
		}
	}

	public static String classSimpleNameFeedGenPage(String var) {
		switch(var) {
		case VAR_searchListFeed_:
			return "SearchList";
		case VAR_listFeed:
			return "JsonArray";
		case VAR_resultCount:
			return "Integer";
		case VAR_result:
			return "Feed";
		case VAR_pk:
			return "Long";
		case VAR_solrId:
			return "String";
		case VAR_pageUriFeed:
			return "String";
			default:
				return PageLayout.classSimpleNamePageLayout(var);
		}
	}

	public static Integer htmColumnFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmColumnPageLayout(var);
		}
	}

	public static Integer htmRowFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmRowPageLayout(var);
		}
	}

	public static Integer htmCellFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.htmCellPageLayout(var);
		}
	}

	public static Integer lengthMinFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMinPageLayout(var);
		}
	}

	public static Integer lengthMaxFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.lengthMaxPageLayout(var);
		}
	}

	public static Integer maxFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.maxPageLayout(var);
		}
	}

	public static Integer minFeedGenPage(String var) {
		switch(var) {
			default:
				return PageLayout.minPageLayout(var);
		}
	}
}
