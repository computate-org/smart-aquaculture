/**
 * Order: 5
 * Description: A fish processing plant
 * AName: a fish processing plant
 * Icon: <i class="fa-duotone fa-regular fa-industry-windows"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M80 88c0-4.4 3.6-8 8-8l48 0c4.4 0 8 3.6 8 8l0 126.7c0 8.6 4.6 16.5 12 20.8s16.6 4.2 24-.1L320 153.8l0 70.9c0 8.8 4.8 16.8 12.5 21.1s17.1 3.9 24.5-.8l139.1-89L496 304l0 16 0 88c0 13.3-10.7 24-24 24l-368 0c-13.3 0-24-10.7-24-24l0-56 0-48L80 88zm48 224l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm120 0l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm120 0l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16z"/><path class="fa-primary" d="M80 88c0-4.4 3.6-8 8-8l48 0c4.4 0 8 3.6 8 8l0 126.7c0 8.6 4.6 16.5 12 20.8s16.6 4.2 24-.1L320 153.8l0 70.9c0 8.8 4.8 16.8 12.5 21.1s17.1 3.9 24.5-.8l139.1-89L496 304l0 16 0 88c0 13.3-10.7 24-24 24l-368 0c-13.3 0-24-10.7-24-24l0-56 0-48L80 88zm8-56C57.1 32 32 57.1 32 88l0 216 0 48 0 56c0 39.8 32.2 72 72 72l368 0c39.8 0 72-32.2 72-72l0-88 0-16 0-148.1c0-37.9-41.9-60.9-73.9-40.4L368 180.8l0-27c0-37-40.2-60.1-72.2-41.5L192 172.9 192 88c0-30.9-25.1-56-56-56L88 32zm56 264c-8.8 0-16 7.2-16 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0zm104 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm136-16c-8.8 0-16 7.2-16 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-processing
 * EditPageUri: /en-us/edit/fish-processing/{entityShortId}
 * ApiUri: /en-us/api/fish-processing
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishProcessingViewer:
 *     GET:
 *   FishProcessingEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 **/
package org.computate.smartaquaculture.model.fiware.fishprocessing;

import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.model.mapmodel.MapModel;
import org.computate.smartaquaculture.model.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
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
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.String;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishProcessingGen into the class FishProcessing. 
 * </li>
 * <h3>About the FishProcessing class and it's generated class FishProcessingGen&lt;MapModel&gt;: </h3>extends FishProcessingGen
 * <p>
 * This Java class extends a generated Java class FishProcessingGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing">Find the class FishProcessing in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishProcessingGen<MapModel>
 * <p>This <code>class FishProcessing extends FishProcessingGen&lt;MapModel&gt;</code>, which means it extends a newly generated FishProcessingGen. 
 * The generated <code>class FishProcessingGen extends MapModel</code> which means that FishProcessing extends FishProcessingGen which extends MapModel. 
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
 * <p>This class contains a comment <b>"ApiTag: fish processing plants"</b>, which groups all of the OpenAPIs for FishProcessing objects under the tag "fish processing plants". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/fish-processing</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/fish-processing"</b>, which defines the base API URI for FishProcessing objects as "/en-us/api/fish-processing" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishProcessing class will inherit the helpful inherited class comments from the super class FishProcessingGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the FishProcessing API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 5</h2>
 * <p>This class contains a comment <b>"Order: 5"</b>, which means this class will be sorted by the given number 5 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 5</h2>
 * <p>This class contains a comment <b>"SqlOrder: 5"</b>, which means this class will be sorted by the given number 5 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessingPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishProcessing Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a fish processing plant</h2>
 * <p>This class contains a comment <b>"AName.enUS: a fish processing plant"</b>, which identifies the language context to describe a FishProcessing as "a fish processing plant". 
 * </p>
 * <p>
 * Delete the class FishProcessing in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishprocessing in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishProcessingGen<DEV> extends MapModel {
	protected static final Logger LOG = LoggerFactory.getLogger(FishProcessing.class);

	public static final String Description_enUS = "A fish processing plant";
	public static final String AName_enUS = "a fish processing plant";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this fish processing plant";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the fish processing plant";
	public static final String SingularName_enUS = "fish processing plant";
	public static final String PluralName_enUS = "fish processing plants";
	public static final String NameActual_enUS = "current fish processing plant";
	public static final String AllName_enUS = "all fish processing plants";
	public static final String SearchAllNameBy_enUS = "search fish processing plants by ";
	public static final String SearchAllName_enUS = "search fish processing plants";
	public static final String Title_enUS = "fish processing plants";
	public static final String ThePluralName_enUS = "the fish processing plants";
	public static final String NoNameFound_enUS = "no fish processing plant found";
	public static final String ApiUri_enUS = "/en-us/api/fish-processing";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/fish-processing";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/fish-processing/{entityShortId}";
	public static final String OfName_enUS = "of fish processing plant";
	public static final String ANameAdjective_enUS = "a fish processing plant";
	public static final String NameAdjectiveSingular_enUS = "fish processing plant";
	public static final String NameAdjectivePlural_enUS = "fish processing plants";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/fish-processing";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/fish-processing";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/fish-processing";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/fish-processing/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/fish-processing/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/fish-processing/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/fish-processing";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/fish-processing";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/fish-processing";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/fish-processing";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/fish-processing";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/fish-processing";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/fish-processing/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/fish-processing/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/fish-processing/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/fish-processing-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/fish-processing-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/fish-processing-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/fish-processing";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/fish-processing";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/fish-processing";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/fish-processing/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/fish-processing/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/fish-processing/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/fish-processing";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/fish-processing";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/fish-processing";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-industry-windows\"></i>";
	public static final Integer Rows = 100;

	/////////////
	// address //
	/////////////


	/**	 The entity address
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject address;

	/**	<br> The entity address
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _address(Wrap<JsonObject> w);

	public JsonObject getAddress() {
		return address;
	}

	public void setAddress(JsonObject address) {
		this.address = address;
	}
	@JsonIgnore
	public void setAddress(String o) {
		this.address = FishProcessing.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FishProcessing addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (FishProcessing)this;
	}

	public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
		return FishProcessing.staticSearchAddress(siteRequest_, FishProcessing.staticSetAddress(siteRequest_, o)).toString();
	}

	public JsonObject sqlAddress() {
		return address;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FishProcessingGen<DEV>> promiseDeepFishProcessing(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFishProcessing();
	}

	public Future<FishProcessingGen<DEV>> promiseDeepFishProcessing() {
		Promise<FishProcessingGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFishProcessing(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepMapModel(siteRequest_).onSuccess(b -> {
				promise.complete(this);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseFishProcessing(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				addressInit();
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

	@Override public Future<? extends FishProcessingGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFishProcessing(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFishProcessing(SiteRequest siteRequest_) {
			super.siteRequestMapModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFishProcessing(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFishProcessing(v);
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
	public Object obtainFishProcessing(String var) {
		FishProcessing oFishProcessing = (FishProcessing)this;
		switch(var) {
			case "address":
				return oFishProcessing.address;
			default:
				return super.obtainMapModel(var);
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
				o = relateFishProcessing(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFishProcessing(String var, Object val) {
		FishProcessing oFishProcessing = (FishProcessing)this;
		switch(var) {
			default:
				return super.relateMapModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishProcessing o) {
		return staticSetFishProcessing(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetFishProcessing(String entityVar, SiteRequest siteRequest_, String v, FishProcessing o) {
		switch(entityVar) {
		case "address":
			return FishProcessing.staticSetAddress(siteRequest_, v);
			default:
				return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFishProcessing(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFishProcessing(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishProcessing.staticSearchAddress(siteRequest_, (JsonObject)o);
			default:
				return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFishProcessing(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFishProcessing(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishProcessing.staticSearchStrAddress(siteRequest_, (String)o);
			default:
				return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFishProcessing(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFishProcessing(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "address":
			return FishProcessing.staticSearchFqAddress(siteRequest_, o);
			default:
				return MapModel.staticSearchFqMapModel(entityVar,  siteRequest_, o);
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
					o = persistFishProcessing(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFishProcessing(String var, Object val) {
		String varLower = var.toLowerCase();
			if("address".equals(varLower)) {
				if(val instanceof String) {
					setAddress((String)val);
				} else if(val instanceof JsonObject) {
					setAddress((JsonObject)val);
				}
				saves.add("address");
				return val;
		} else {
			return super.persistMapModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateFishProcessing(doc);
	}
	public void populateFishProcessing(SolrResponse.Doc doc) {
		FishProcessing oFishProcessing = (FishProcessing)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oFishProcessing.setAddress(address);
			}
		}

		super.populateMapModel(doc);
	}

	public void indexFishProcessing(JsonObject doc) {
		if(address != null) {
			doc.put("address_docvalues_string", address.encode());
		}
		super.indexMapModel(doc);

	}

	public static String varStoredFishProcessing(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			default:
				return MapModel.varStoredMapModel(entityVar);
		}
	}

	public static String varIndexedFishProcessing(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			default:
				return MapModel.varIndexedMapModel(entityVar);
		}
	}

	public static String searchVarFishProcessing(String searchVar) {
		switch(searchVar) {
			case "address_docvalues_string":
				return "address";
			default:
				return MapModel.searchVarMapModel(searchVar);
		}
	}

	public static String varSearchFishProcessing(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSearchMapModel(entityVar);
		}
	}

	public static String varSuggestedFishProcessing(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSuggestedMapModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFishProcessing(doc);
	}
	public void storeFishProcessing(SolrResponse.Doc doc) {
		FishProcessing oFishProcessing = (FishProcessing)this;
		SiteRequest siteRequest = oFishProcessing.getSiteRequest_();

		oFishProcessing.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeMapModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFishProcessing() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof FishProcessing) {
			FishProcessing original = (FishProcessing)o;
			if(!Objects.equals(address, original.getAddress()))
				apiRequest.addVars("address");
			super.apiRequestMapModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "FishProcessing";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing";
	public static final String CLASS_API_ADDRESS_FishProcessing = "smart-aquaculture-enUS-FishProcessing";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_FishProcessing;
	}
	public static final String VAR_address = "address";

	public static List<String> varsQForClass() {
		return FishProcessing.varsQFishProcessing(new ArrayList<String>());
	}
	public static List<String> varsQFishProcessing(List<String> vars) {
		MapModel.varsQMapModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return FishProcessing.varsFqFishProcessing(new ArrayList<String>());
	}
	public static List<String> varsFqFishProcessing(List<String> vars) {
		vars.add(VAR_address);
		MapModel.varsFqMapModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return FishProcessing.varsRangeFishProcessing(new ArrayList<String>());
	}
	public static List<String> varsRangeFishProcessing(List<String> vars) {
		vars.add(VAR_address);
		MapModel.varsRangeMapModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_address = "address";

	@Override
	public String idForClass() {
		return entityShortId;
	}

	@Override
	public String titleForClass() {
		return objectTitle;
	}

	@Override
	public String nameForClass() {
		return name;
	}

	@Override
	public String classNameAdjectiveSingularForClass() {
		return FishProcessing.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/fish-processing/%s";
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
		return FishProcessing.displayNameFishProcessing(var);
	}
	public static String displayNameFishProcessing(String var) {
		switch(var) {
		case VAR_address:
			return DISPLAY_NAME_address;
		default:
			return MapModel.displayNameMapModel(var);
		}
	}

	public static String descriptionFishProcessing(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_address:
			return "The mailing address";
			default:
				return MapModel.descriptionMapModel(var);
		}
	}

	public static String classSimpleNameFishProcessing(String var) {
		switch(var) {
		case VAR_address:
			return "JsonObject";
			default:
				return MapModel.classSimpleNameMapModel(var);
		}
	}

	public static Integer htmColumnFishProcessing(String var) {
		switch(var) {
			default:
				return MapModel.htmColumnMapModel(var);
		}
	}

	public static Integer htmRowFishProcessing(String var) {
		switch(var) {
		case VAR_address:
			return 6;
			default:
				return MapModel.htmRowMapModel(var);
		}
	}

	public static Integer htmCellFishProcessing(String var) {
		switch(var) {
		case VAR_address:
			return 0;
			default:
				return MapModel.htmCellMapModel(var);
		}
	}

	public static Integer lengthMinFishProcessing(String var) {
		switch(var) {
			default:
				return MapModel.lengthMinMapModel(var);
		}
	}

	public static Integer lengthMaxFishProcessing(String var) {
		switch(var) {
			default:
				return MapModel.lengthMaxMapModel(var);
		}
	}

	public static Integer maxFishProcessing(String var) {
		switch(var) {
			default:
				return MapModel.maxMapModel(var);
		}
	}

	public static Integer minFishProcessing(String var) {
		switch(var) {
			default:
				return MapModel.minMapModel(var);
		}
	}
}
