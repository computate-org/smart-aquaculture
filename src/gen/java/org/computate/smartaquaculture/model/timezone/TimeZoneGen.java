package org.computate.smartaquaculture.model.timezone;

import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.result.BaseResult;
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
import java.lang.String;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;
import io.vertx.core.json.JsonObject;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class TimeZoneGen into the class TimeZone. 
 * </li><li>You can add a class comment "Model: true" if you wish to persist these TimeZone objects in a relational PostgreSQL database transactionally in the RESTful API. 
 * The code to persist and query the TimeZoneGen data in the database will then be automatically generated. 
 * </li>
 * <h3>About the TimeZone class and it's generated class TimeZoneGen&lt;BaseResult&gt;: </h3>extends TimeZoneGen
 * <p>
 * This Java class extends a generated Java class TimeZoneGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZone">Find the class TimeZone in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends TimeZoneGen<BaseResult>
 * <p>This <code>class TimeZone extends TimeZoneGen&lt;BaseResult&gt;</code>, which means it extends a newly generated TimeZoneGen. 
 * The generated <code>class TimeZoneGen extends BaseResult</code> which means that TimeZone extends TimeZoneGen which extends BaseResult. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiMethode: Search</h2>
 * <p>This class contains a comment <b>"ApiMethod: Search"</b>, which creates an API "Search". 
 * </p>
 * <h2>ApiMethode: GET</h2>
 * <p>This class contains a comment <b>"ApiMethod: GET"</b>, which creates an API "GET". 
 * </p>
 * <h2>ApiMethode: PATCH</h2>
 * <p>This class contains a comment <b>"ApiMethod: PATCH"</b>, which creates an API "PATCH". 
 * </p>
 * <h2>ApiMethode: POST</h2>
 * <p>This class contains a comment <b>"ApiMethod: POST"</b>, which creates an API "POST". 
 * </p>
 * <h2>ApiMethode: DELETE</h2>
 * <p>This class contains a comment <b>"ApiMethod: DELETE"</b>, which creates an API "DELETE". 
 * </p>
 * <h2>ApiMethode: PUTImport</h2>
 * <p>This class contains a comment <b>"ApiMethod: PUTImport"</b>, which creates an API "PUTImport". 
 * </p>
 * <h2>ApiMethode: SearchPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: SearchPage"</b>, which creates an API "SearchPage". 
 * </p>
 * <h2>ApiMethode: EditPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: EditPage"</b>, which creates an API "EditPage". 
 * </p>
 * <h2>ApiMethode: DELETEFilter</h2>
 * <p>This class contains a comment <b>"ApiMethod: DELETEFilter"</b>, which creates an API "DELETEFilter". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: time zones"</b>, which groups all of the OpenAPIs for TimeZone objects under the tag "time zones". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/time-zone</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/time-zone"</b>, which defines the base API URI for TimeZone objects as "/en-us/api/time-zone" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the TimeZone class will inherit the helpful inherited class comments from the super class TimeZoneGen. 
 * </p>
 * <h2>Rows: 10</h2>
 * <p>This class contains a comment <b>"Rows: 10"</b>, which means the TimeZone API will return a default of 10 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 0</h2>
 * <p>This class contains a comment <b>"Order: 0"</b>, which means this class will be sorted by the given number 0 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 0</h2>
 * <p>This class contains a comment <b>"SqlOrder: 0"</b>, which means this class will be sorted by the given number 0 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.timezone.TimeZonePage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.timezone.TimeZonePage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the TimeZone Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a time zone</h2>
 * <p>This class contains a comment <b>"AName.enUS: a time zone"</b>, which identifies the language context to describe a TimeZone as "a time zone". 
 * </p>
 * <p>
 * Delete the class TimeZone in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZone&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class TimeZoneGen<DEV> extends BaseResult {
	protected static final Logger LOG = LoggerFactory.getLogger(TimeZone.class);

	public static final String Description_enUS = "AName: a time zone";
	public static final String AName_enUS = "a time zone";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this time zone";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the time zone";
	public static final String SingularName_enUS = "time zone";
	public static final String PluralName_enUS = "time zones";
	public static final String NameActual_enUS = "current time zone";
	public static final String AllName_enUS = "all time zones";
	public static final String SearchAllNameBy_enUS = "search time zones by ";
	public static final String SearchAllName_enUS = "search time zones";
	public static final String Title_enUS = "time zones";
	public static final String ThePluralName_enUS = "the time zones";
	public static final String NoNameFound_enUS = "no time zone found";
	public static final String ApiUri_enUS = "/en-us/api/time-zone";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/time-zone";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/time-zone/{id}";
	public static final String OfName_enUS = "of time zone";
	public static final String ANameAdjective_enUS = "a time zone";
	public static final String NameAdjectiveSingular_enUS = "time zone";
	public static final String NameAdjectivePlural_enUS = "time zones";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/time-zone";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/time-zone";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/time-zone";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/time-zone/{id}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/time-zone/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/time-zone/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/time-zone";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/time-zone";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/time-zone";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/time-zone";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/time-zone";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/time-zone";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/time-zone/{id}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/time-zone/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/time-zone/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/time-zone-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/time-zone-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/time-zone-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/time-zone";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/time-zone";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/time-zone";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/time-zone/{id}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/time-zone/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/time-zone/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/time-zone";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/time-zone";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/time-zone";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-globe\"></i>";
	public static final Integer Rows = 10;

	////////
	// id //
	////////


	/**	 The entity id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String id;

	/**	<br> The entity id
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.timezone.TimeZone&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = TimeZone.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected TimeZone idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (TimeZone)this;
	}

	public static String staticSearchId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequest siteRequest_, String o) {
		return TimeZone.staticSearchId(siteRequest_, TimeZone.staticSetId(siteRequest_, o)).toString();
	}

	public String sqlId() {
		return id;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<TimeZoneGen<DEV>> promiseDeepTimeZone(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepTimeZone();
	}

	public Future<TimeZoneGen<DEV>> promiseDeepTimeZone() {
		Promise<TimeZoneGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseTimeZone(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseResult(siteRequest_).onSuccess(b -> {
				promise.complete(this);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseTimeZone(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				idInit();
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

	@Override public Future<? extends TimeZoneGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepTimeZone(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestTimeZone(SiteRequest siteRequest_) {
			super.siteRequestBaseResult(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestTimeZone(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTimeZone(v);
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
	public Object obtainTimeZone(String var) {
		TimeZone oTimeZone = (TimeZone)this;
		switch(var) {
			case "id":
				return oTimeZone.id;
			default:
				return super.obtainBaseResult(var);
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
				o = relateTimeZone(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateTimeZone(String var, Object val) {
		TimeZone oTimeZone = (TimeZone)this;
		switch(var) {
			default:
				return super.relateBaseResult(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, TimeZone o) {
		return staticSetTimeZone(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetTimeZone(String entityVar, SiteRequest siteRequest_, String v, TimeZone o) {
		switch(entityVar) {
		case "id":
			return TimeZone.staticSetId(siteRequest_, v);
			default:
				return BaseResult.staticSetBaseResult(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchTimeZone(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchTimeZone(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "id":
			return TimeZone.staticSearchId(siteRequest_, (String)o);
			default:
				return BaseResult.staticSearchBaseResult(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrTimeZone(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrTimeZone(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "id":
			return TimeZone.staticSearchStrId(siteRequest_, (String)o);
			default:
				return BaseResult.staticSearchStrBaseResult(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqTimeZone(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqTimeZone(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "id":
			return TimeZone.staticSearchFqId(siteRequest_, o);
			default:
				return BaseResult.staticSearchFqBaseResult(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// persist //
	/////////////

	@Override public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistTimeZone(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistTimeZone(String var, Object val) {
		String varLower = var.toLowerCase();
			if("id".equals(varLower)) {
				if(val instanceof String) {
					setId((String)val);
				}
				saves.add("id");
				return val;
		} else {
			return super.persistBaseResult(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateTimeZone(doc);
	}
	public void populateTimeZone(SolrResponse.Doc doc) {
		TimeZone oTimeZone = (TimeZone)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("id")) {
				String id = (String)doc.get("id_docvalues_string");
				if(id != null)
					oTimeZone.setId(id);
			}
		}

		super.populateBaseResult(doc);
	}

	public void indexTimeZone(JsonObject doc) {
		if(id != null) {
			doc.put("id_docvalues_string", id);
		}
		super.indexBaseResult(doc);

	}

	public static String varStoredTimeZone(String entityVar) {
		switch(entityVar) {
			case "id":
				return "id_docvalues_string";
			default:
				return BaseResult.varStoredBaseResult(entityVar);
		}
	}

	public static String varIndexedTimeZone(String entityVar) {
		switch(entityVar) {
			case "id":
				return "id_docvalues_string";
			default:
				return BaseResult.varIndexedBaseResult(entityVar);
		}
	}

	public static String searchVarTimeZone(String searchVar) {
		switch(searchVar) {
			case "id_docvalues_string":
				return "id";
			default:
				return BaseResult.searchVarBaseResult(searchVar);
		}
	}

	public static String varSearchTimeZone(String entityVar) {
		switch(entityVar) {
			default:
				return BaseResult.varSearchBaseResult(entityVar);
		}
	}

	public static String varSuggestedTimeZone(String entityVar) {
		switch(entityVar) {
			default:
				return BaseResult.varSuggestedBaseResult(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeTimeZone(doc);
	}
	public void storeTimeZone(SolrResponse.Doc doc) {
		TimeZone oTimeZone = (TimeZone)this;
		SiteRequest siteRequest = oTimeZone.getSiteRequest_();

		oTimeZone.setId(Optional.ofNullable(doc.get("id_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseResult(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestTimeZone() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof TimeZone) {
			TimeZone original = (TimeZone)o;
			if(!Objects.equals(id, original.getId()))
				apiRequest.addVars("id");
			super.apiRequestBaseResult();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "TimeZone";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.timezone.TimeZone";
	public static final String CLASS_API_ADDRESS_TimeZone = "smart-aquaculture-enUS-TimeZone";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_TimeZone;
	}
	public static final String VAR_id = "id";

	public static List<String> varsQForClass() {
		return TimeZone.varsQTimeZone(new ArrayList<String>());
	}
	public static List<String> varsQTimeZone(List<String> vars) {
		BaseResult.varsQBaseResult(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return TimeZone.varsFqTimeZone(new ArrayList<String>());
	}
	public static List<String> varsFqTimeZone(List<String> vars) {
		vars.add(VAR_id);
		BaseResult.varsFqBaseResult(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return TimeZone.varsRangeTimeZone(new ArrayList<String>());
	}
	public static List<String> varsRangeTimeZone(List<String> vars) {
		BaseResult.varsRangeBaseResult(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_id = "id";

	@Override
	public String idForClass() {
		return id;
	}

	@Override
	public String titleForClass() {
		return objectTitle;
	}

	@Override
	public String nameForClass() {
		return id;
	}

	@Override
	public String classNameAdjectiveSingularForClass() {
		return TimeZone.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/time-zone/%s";
	}

	@Override
	public String classStringFormatUrlDisplayPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlUserPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlDownloadForClass() {
		return null;
	}

	public static String displayNameForClass(String var) {
		return TimeZone.displayNameTimeZone(var);
	}
	public static String displayNameTimeZone(String var) {
		switch(var) {
		case VAR_id:
			return DISPLAY_NAME_id;
		default:
			return BaseResult.displayNameBaseResult(var);
		}
	}

	public static String descriptionTimeZone(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_id:
			return "The id for this time zone. ";
			default:
				return BaseResult.descriptionBaseResult(var);
		}
	}

	public static String classSimpleNameTimeZone(String var) {
		switch(var) {
		case VAR_id:
			return "String";
			default:
				return BaseResult.classSimpleNameBaseResult(var);
		}
	}

	public static Integer htmColumnTimeZone(String var) {
		switch(var) {
			default:
				return BaseResult.htmColumnBaseResult(var);
		}
	}

	public static Integer htmRowTimeZone(String var) {
		switch(var) {
		case VAR_id:
			return 3;
			default:
				return BaseResult.htmRowBaseResult(var);
		}
	}

	public static Integer htmCellTimeZone(String var) {
		switch(var) {
		case VAR_id:
			return 0;
			default:
				return BaseResult.htmCellBaseResult(var);
		}
	}

	public static Integer lengthMinTimeZone(String var) {
		switch(var) {
			default:
				return BaseResult.lengthMinBaseResult(var);
		}
	}

	public static Integer lengthMaxTimeZone(String var) {
		switch(var) {
			default:
				return BaseResult.lengthMaxBaseResult(var);
		}
	}

	public static Integer maxTimeZone(String var) {
		switch(var) {
			default:
				return BaseResult.maxBaseResult(var);
		}
	}

	public static Integer minTimeZone(String var) {
		switch(var) {
			default:
				return BaseResult.minBaseResult(var);
		}
	}
}
