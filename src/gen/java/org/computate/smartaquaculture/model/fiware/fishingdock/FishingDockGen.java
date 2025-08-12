/**
 * Fiware: true
 * Order: 5
 * Description: A fishing dock
 * AName: a fishing dock
 * Icon: <i class="fa-duotone fa-regular fa-bridge-water"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M.8 455.3c4 17.2 21.2 27.9 38.4 23.9c24.5-5.7 44.9-16.5 58.2-25C126.5 469.7 159 480 192 480c31.9 0 60.6-9.9 80.4-18.9c5.8-2.7 11.1-5.3 15.6-7.7c4.5 2.4 9.7 5.1 15.6 7.7c19.8 9 48.5 18.9 80.4 18.9c33 0 65.5-10.3 94.5-25.8c13.4 8.4 33.7 19.3 58.2 25c17.2 4 34.4-6.7 38.4-23.9c.6-2.4 .8-4.9 .8-7.3c0-14.5-10-27.7-24.7-31.1c-18.1-4.2-36.2-13.3-50.6-25.2c-5.9-5-13.3-7.6-20.7-7.6c-6.5 0-12.9 2-18.5 5.9C439.4 405.2 410.9 416 384 416c-27.5 0-55-10.6-77.5-26.1c-11.1-7.9-25.9-7.9-37 0C247 405.4 219.5 416 192 416c-26.9 0-55.3-10.8-77.4-26.1C109 386 102.5 384 96 384c-7.4 0-14.8 2.6-20.7 7.6c-14.4 11.9-32.5 21-50.6 25.2c-17.2 4-27.9 21.2-23.9 38.4z"/><path class="fa-primary" d="M32 64C14.3 64 0 78.3 0 96l0 35.6C0 147.3 12.7 160 28.4 160C65.8 160 96 190.2 96 227.6l0 124.9c12.9 0 25.8 3.9 36.9 11.7c18 12.4 40.1 20.3 59.1 20.3c0-.2 0-.3 0-.5l0-128c0-53 43-96 96-96s96 43 96 96l0 128c0 .2 0 .3 0 .5c0 0 0 0 0 0c19 0 41.2-7.9 59.2-20.3c11.1-7.8 24-11.7 36.8-11.7l0-124.9c0-37.3 30.2-67.6 67.6-67.6c15.7 0 28.4-12.7 28.4-28.4L576 96c0-17.7-14.3-32-32-32L32 64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-dock
 * EditPageUri: /en-us/edit/fishing-dock/{entityShortId}
 * ApiUri: /en-us/api/fishing-dock
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingDockViewer:
 *     GET:
 *   FishingDockEditor:
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
package org.computate.smartaquaculture.model.fiware.fishingdock;

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
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishingDockGen into the class FishingDock. 
 * </li>
 * <h3>About the FishingDock class and it's generated class FishingDockGen&lt;MapModel&gt;: </h3>extends FishingDockGen
 * <p>
 * This Java class extends a generated Java class FishingDockGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock">Find the class FishingDock in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishingDockGen<MapModel>
 * <p>This <code>class FishingDock extends FishingDockGen&lt;MapModel&gt;</code>, which means it extends a newly generated FishingDockGen. 
 * The generated <code>class FishingDockGen extends MapModel</code> which means that FishingDock extends FishingDockGen which extends MapModel. 
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
 * <p>This class contains a comment <b>"ApiTag: fishing docks"</b>, which groups all of the OpenAPIs for FishingDock objects under the tag "fishing docks". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/fishing-dock</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/fishing-dock"</b>, which defines the base API URI for FishingDock objects as "/en-us/api/fishing-dock" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishingDock class will inherit the helpful inherited class comments from the super class FishingDockGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the FishingDock API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.fishingdock.FishingDockPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishingDock Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a fishing dock</h2>
 * <p>This class contains a comment <b>"AName.enUS: a fishing dock"</b>, which identifies the language context to describe a FishingDock as "a fishing dock". 
 * </p>
 * <p>
 * Delete the class FishingDock in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class FishingDockGen<DEV> extends MapModel {
	protected static final Logger LOG = LoggerFactory.getLogger(FishingDock.class);

	public static final String Description_enUS = "A fishing dock";
	public static final String AName_enUS = "a fishing dock";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this fishing dock";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the fishing dock";
	public static final String SingularName_enUS = "fishing dock";
	public static final String PluralName_enUS = "fishing docks";
	public static final String NameActual_enUS = "current fishing dock";
	public static final String AllName_enUS = "all fishing docks";
	public static final String SearchAllNameBy_enUS = "search fishing docks by ";
	public static final String SearchAllName_enUS = "search fishing docks";
	public static final String Title_enUS = "fishing docks";
	public static final String ThePluralName_enUS = "the fishing docks";
	public static final String NoNameFound_enUS = "no fishing dock found";
	public static final String ApiUri_enUS = "/en-us/api/fishing-dock";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/fishing-dock";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/fishing-dock/{entityShortId}";
	public static final String OfName_enUS = "of fishing dock";
	public static final String ANameAdjective_enUS = "a fishing dock";
	public static final String NameAdjectiveSingular_enUS = "fishing dock";
	public static final String NameAdjectivePlural_enUS = "fishing docks";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/fishing-dock";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/fishing-dock";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/fishing-dock/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/fishing-dock/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/fishing-dock";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/fishing-dock";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/fishing-dock";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/fishing-dock";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/fishing-dock/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/fishing-dock/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/fishing-dock-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/fishing-dock-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/fishing-dock";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/fishing-dock";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/fishing-dock";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/fishing-dock/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/fishing-dock/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/fishing-dock/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/fishing-dock";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/fishing-dock";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/fishing-dock";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-bridge-water\"></i>";
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = FishingDock.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FishingDock addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (FishingDock)this;
	}

	public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
		return FishingDock.staticSearchAddress(siteRequest_, FishingDock.staticSetAddress(siteRequest_, o)).toString();
	}

	public JsonObject sqlAddress() {
		return address;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FishingDockGen<DEV>> promiseDeepFishingDock(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFishingDock();
	}

	public Future<FishingDockGen<DEV>> promiseDeepFishingDock() {
		Promise<FishingDockGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFishingDock(promise2);
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

	public Future<Void> promiseFishingDock(Promise<Void> promise) {
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

	@Override public Future<? extends FishingDockGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFishingDock(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFishingDock(SiteRequest siteRequest_) {
			super.siteRequestMapModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFishingDock(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFishingDock(v);
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
	public Object obtainFishingDock(String var) {
		FishingDock oFishingDock = (FishingDock)this;
		switch(var) {
			case "address":
				return oFishingDock.address;
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
				o = relateFishingDock(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFishingDock(String var, Object val) {
		FishingDock oFishingDock = (FishingDock)this;
		switch(var) {
			default:
				return super.relateMapModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishingDock o) {
		return staticSetFishingDock(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetFishingDock(String entityVar, SiteRequest siteRequest_, String v, FishingDock o) {
		switch(entityVar) {
		case "address":
			return FishingDock.staticSetAddress(siteRequest_, v);
			default:
				return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFishingDock(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFishingDock(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishingDock.staticSearchAddress(siteRequest_, (JsonObject)o);
			default:
				return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFishingDock(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFishingDock(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishingDock.staticSearchStrAddress(siteRequest_, (String)o);
			default:
				return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFishingDock(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFishingDock(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "address":
			return FishingDock.staticSearchFqAddress(siteRequest_, o);
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
					o = persistFishingDock(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFishingDock(String var, Object val) {
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
		populateFishingDock(doc);
	}
	public void populateFishingDock(SolrResponse.Doc doc) {
		FishingDock oFishingDock = (FishingDock)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oFishingDock.setAddress(address);
			}
		}

		super.populateMapModel(doc);
	}

	public void indexFishingDock(JsonObject doc) {
		if(address != null) {
			doc.put("address_docvalues_string", address.encode());
		}
		super.indexMapModel(doc);

	}

	public static String varStoredFishingDock(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			default:
				return MapModel.varStoredMapModel(entityVar);
		}
	}

	public static String varIndexedFishingDock(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			default:
				return MapModel.varIndexedMapModel(entityVar);
		}
	}

	public static String searchVarFishingDock(String searchVar) {
		switch(searchVar) {
			case "address_docvalues_string":
				return "address";
			default:
				return MapModel.searchVarMapModel(searchVar);
		}
	}

	public static String varSearchFishingDock(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSearchMapModel(entityVar);
		}
	}

	public static String varSuggestedFishingDock(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSuggestedMapModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFishingDock(doc);
	}
	public void storeFishingDock(SolrResponse.Doc doc) {
		FishingDock oFishingDock = (FishingDock)this;
		SiteRequest siteRequest = oFishingDock.getSiteRequest_();

		oFishingDock.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeMapModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFishingDock() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof FishingDock) {
			FishingDock original = (FishingDock)o;
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

	public static final String CLASS_SIMPLE_NAME = "FishingDock";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock";
	public static final String CLASS_AUTH_RESOURCE = "FISHINGDOCK";
	public static final String CLASS_API_ADDRESS_FishingDock = "smart-aquaculture-enUS-FishingDock";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_FishingDock;
	}
	public static final String VAR_address = "address";

	public static List<String> varsQForClass() {
		return FishingDock.varsQFishingDock(new ArrayList<String>());
	}
	public static List<String> varsQFishingDock(List<String> vars) {
		MapModel.varsQMapModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return FishingDock.varsFqFishingDock(new ArrayList<String>());
	}
	public static List<String> varsFqFishingDock(List<String> vars) {
		vars.add(VAR_address);
		MapModel.varsFqMapModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return FishingDock.varsRangeFishingDock(new ArrayList<String>());
	}
	public static List<String> varsRangeFishingDock(List<String> vars) {
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
		return FishingDock.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/fishing-dock/%s";
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
		return FishingDock.displayNameFishingDock(var);
	}
	public static String displayNameFishingDock(String var) {
		switch(var) {
		case VAR_address:
			return DISPLAY_NAME_address;
		default:
			return MapModel.displayNameMapModel(var);
		}
	}

	public static String descriptionFishingDock(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_address:
			return "The mailing address";
			default:
				return MapModel.descriptionMapModel(var);
		}
	}

	public static String classSimpleNameFishingDock(String var) {
		switch(var) {
		case VAR_address:
			return "JsonObject";
			default:
				return MapModel.classSimpleNameMapModel(var);
		}
	}

	public static String ngsiType(String var) {
		switch(var) {
		case VAR_address:
			return "Property";
			default:
				return MapModel.ngsiType(var);
		}
	}

	public static Object ngsiFishingDock(String var, FishingDock o) {
		switch(var) {
		case VAR_address:
			return o.getAddress();
			default:
				return ngsiMapModel(var, o);
		}
	}

	public static Integer htmColumnFishingDock(String var) {
		switch(var) {
			default:
				return MapModel.htmColumnMapModel(var);
		}
	}

	public static Integer htmRowFishingDock(String var) {
		switch(var) {
		case VAR_address:
			return 6;
			default:
				return MapModel.htmRowMapModel(var);
		}
	}

	public static Integer htmCellFishingDock(String var) {
		switch(var) {
		case VAR_address:
			return 0;
			default:
				return MapModel.htmCellMapModel(var);
		}
	}

	public static Integer lengthMinFishingDock(String var) {
		switch(var) {
			default:
				return MapModel.lengthMinMapModel(var);
		}
	}

	public static Integer lengthMaxFishingDock(String var) {
		switch(var) {
			default:
				return MapModel.lengthMaxMapModel(var);
		}
	}

	public static Integer maxFishingDock(String var) {
		switch(var) {
			default:
				return MapModel.maxMapModel(var);
		}
	}

	public static Integer minFishingDock(String var) {
		switch(var) {
			default:
				return MapModel.minMapModel(var);
		}
	}
}
