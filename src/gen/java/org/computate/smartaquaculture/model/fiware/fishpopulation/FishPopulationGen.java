/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 1
 * Description: 
 * AName: a fish population
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3zM448 256a32 32 0 1 1 -64 0 32 32 0 1 1 64 0z"/><path class="fa-primary" d="M180.8 303.7c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8zM4.2 336.1L50 256 4.2 175.9c-6.9-12.1-5.2-27.2 4.2-37.5s24.3-13.3 36.9-7.5l99.5 45.6c10.5-11.9 22.5-23.8 35.7-35C219.7 108.5 272.6 80 336 80s116.3 28.5 155.5 61.5c39.1 33 66.9 72.4 81 99.8c4.7 9.2 4.7 20.1 0 29.3c-14.1 27.4-41.9 66.8-81 99.8C452.3 403.5 399.4 432 336 432s-116.3-28.5-155.5-61.5c-13.2-11.2-25.1-23.1-35.7-35L45.3 381.1c-12.6 5.8-27.6 2.8-36.9-7.5S-2.7 348.2 4.2 336.1zM416 224a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-population
 * EditPageUri: /en-us/edit/fish-population/{entityShortId}
 * ApiUri: /en-us/api/fish-population
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishPopulationViewer:
 *     GET:
 *   FishPopulationEditor:
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
 *     Admin:
 **/
package org.computate.smartaquaculture.model.fiware.fishpopulation;

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
import java.math.BigDecimal;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishPopulationGen into the class FishPopulation. 
 * </li>
 * <h3>About the FishPopulation class and it's generated class FishPopulationGen&lt;MapModel&gt;: </h3>extends FishPopulationGen
 * <p>
 * This Java class extends a generated Java class FishPopulationGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation">Find the class FishPopulation in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishPopulationGen<MapModel>
 * <p>This <code>class FishPopulation extends FishPopulationGen&lt;MapModel&gt;</code>, which means it extends a newly generated FishPopulationGen. 
 * The generated <code>class FishPopulationGen extends MapModel</code> which means that FishPopulation extends FishPopulationGen which extends MapModel. 
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
 * <p>This class contains a comment <b>"ApiTag: fish populations"</b>, which groups all of the OpenAPIs for FishPopulation objects under the tag "fish populations". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/fish-population</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/fish-population"</b>, which defines the base API URI for FishPopulation objects as "/en-us/api/fish-population" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishPopulation class will inherit the helpful inherited class comments from the super class FishPopulationGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the FishPopulation API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 1</h2>
 * <p>This class contains a comment <b>"Order: 1"</b>, which means this class will be sorted by the given number 1 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 1</h2>
 * <p>This class contains a comment <b>"SqlOrder: 1"</b>, which means this class will be sorted by the given number 1 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishPopulation Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a fish population</h2>
 * <p>This class contains a comment <b>"AName.enUS: a fish population"</b>, which identifies the language context to describe a FishPopulation as "a fish population". 
 * </p>
 * <p>
 * Delete the class FishPopulation in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishpopulation in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishPopulationGen<DEV> extends MapModel {
	protected static final Logger LOG = LoggerFactory.getLogger(FishPopulation.class);

	public static final String Description_enUS = "AName: a fish population";
	public static final String AName_enUS = "a fish population";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this fish population";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the fish population";
	public static final String SingularName_enUS = "fish population";
	public static final String PluralName_enUS = "fish populations";
	public static final String NameActual_enUS = "current fish population";
	public static final String AllName_enUS = "all fish populations";
	public static final String SearchAllNameBy_enUS = "search fish populations by ";
	public static final String SearchAllName_enUS = "search fish populations";
	public static final String Title_enUS = "fish populations";
	public static final String ThePluralName_enUS = "the fish populations";
	public static final String NoNameFound_enUS = "no fish population found";
	public static final String ApiUri_enUS = "/en-us/api/fish-population";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/fish-population";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/fish-population/{entityShortId}";
	public static final String OfName_enUS = "of fish population";
	public static final String ANameAdjective_enUS = "a fish population";
	public static final String NameAdjectiveSingular_enUS = "fish population";
	public static final String NameAdjectivePlural_enUS = "fish populations";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/fish-population";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/fish-population";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/fish-population";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/fish-population/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/fish-population/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/fish-population/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/fish-population";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/fish-population";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/fish-population";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/fish-population";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/fish-population";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/fish-population";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/fish-population/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/fish-population/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/fish-population/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/fish-population-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/fish-population-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/fish-population-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/fish-population";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/fish-population";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/fish-population";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/fish-population/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/fish-population/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/fish-population/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/fish-population";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/fish-population";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/fish-population";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-fish\"></i>";
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = FishPopulation.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FishPopulation addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchAddress(siteRequest_, FishPopulation.staticSetAddress(siteRequest_, o)).toString();
	}

	public JsonObject sqlAddress() {
		return address;
	}

	///////////////////
	// alternateName //
	///////////////////


	/**	 The entity alternateName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String alternateName;

	/**	<br> The entity alternateName
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = FishPopulation.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchAlternateName(siteRequest_, FishPopulation.staticSetAlternateName(siteRequest_, o)).toString();
	}

	public String sqlAlternateName() {
		return alternateName;
	}

	///////////////
	// bodyMasse //
	///////////////


	/**	 The entity bodyMasse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal bodyMasse;

	/**	<br> The entity bodyMasse
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:bodyMasse">Find the entity bodyMasse in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _bodyMasse(Wrap<BigDecimal> w);

	public BigDecimal getBodyMasse() {
		return bodyMasse;
	}

	public void setBodyMasse(BigDecimal bodyMasse) {
		this.bodyMasse = bodyMasse;
	}
	@JsonIgnore
	public void setBodyMasse(String o) {
		this.bodyMasse = FishPopulation.staticSetBodyMasse(siteRequest_, o);
	}
	public static BigDecimal staticSetBodyMasse(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setBodyMasse(Double o) {
		setBodyMasse(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setBodyMasse(Integer o) {
		setBodyMasse(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setBodyMasse(Number o) {
		setBodyMasse(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishPopulation bodyMasseInit() {
		Wrap<BigDecimal> bodyMasseWrap = new Wrap<BigDecimal>().var("bodyMasse");
		if(bodyMasse == null) {
			_bodyMasse(bodyMasseWrap);
			Optional.ofNullable(bodyMasseWrap.getO()).ifPresent(o -> {
				setBodyMasse(o);
			});
		}
		return (FishPopulation)this;
	}

	public static Double staticSearchBodyMasse(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrBodyMasse(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqBodyMasse(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchBodyMasse(siteRequest_, FishPopulation.staticSetBodyMasse(siteRequest_, o)).toString();
	}

	public BigDecimal sqlBodyMasse() {
		return bodyMasse;
	}

	////////////////
	// culturedIn //
	////////////////


	/**	 The entity culturedIn
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal culturedIn;

	/**	<br> The entity culturedIn
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:culturedIn">Find the entity culturedIn in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _culturedIn(Wrap<BigDecimal> w);

	public BigDecimal getCulturedIn() {
		return culturedIn;
	}

	public void setCulturedIn(BigDecimal culturedIn) {
		this.culturedIn = culturedIn;
	}
	@JsonIgnore
	public void setCulturedIn(String o) {
		this.culturedIn = FishPopulation.staticSetCulturedIn(siteRequest_, o);
	}
	public static BigDecimal staticSetCulturedIn(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setCulturedIn(Double o) {
		setCulturedIn(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCulturedIn(Integer o) {
		setCulturedIn(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setCulturedIn(Number o) {
		setCulturedIn(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishPopulation culturedInInit() {
		Wrap<BigDecimal> culturedInWrap = new Wrap<BigDecimal>().var("culturedIn");
		if(culturedIn == null) {
			_culturedIn(culturedInWrap);
			Optional.ofNullable(culturedInWrap.getO()).ifPresent(o -> {
				setCulturedIn(o);
			});
		}
		return (FishPopulation)this;
	}

	public static Double staticSearchCulturedIn(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrCulturedIn(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCulturedIn(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchCulturedIn(siteRequest_, FishPopulation.staticSetCulturedIn(siteRequest_, o)).toString();
	}

	public BigDecimal sqlCulturedIn() {
		return culturedIn;
	}

	//////////////////
	// dataProvider //
	//////////////////


	/**	 The entity dataProvider
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dataProvider;

	/**	<br> The entity dataProvider
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = FishPopulation.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchDataProvider(siteRequest_, FishPopulation.staticSetDataProvider(siteRequest_, o)).toString();
	}

	public String sqlDataProvider() {
		return dataProvider;
	}

	/////////////////
	// dateCreated //
	/////////////////


	/**	 The entity dateCreated
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateCreated;

	/**	<br> The entity dateCreated
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = FishPopulation.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchDateCreated(siteRequest_, FishPopulation.staticSetDateCreated(siteRequest_, o)).toString();
	}

	public String sqlDateCreated() {
		return dateCreated;
	}

	//////////////////
	// dateModified //
	//////////////////


	/**	 The entity dateModified
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateModified;

	/**	<br> The entity dateModified
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = FishPopulation.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchDateModified(siteRequest_, FishPopulation.staticSetDateModified(siteRequest_, o)).toString();
	}

	public String sqlDateModified() {
		return dateModified;
	}

	/////////////////
	// fishRemoved //
	/////////////////


	/**	 The entity fishRemoved
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal fishRemoved;

	/**	<br> The entity fishRemoved
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:fishRemoved">Find the entity fishRemoved in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fishRemoved(Wrap<BigDecimal> w);

	public BigDecimal getFishRemoved() {
		return fishRemoved;
	}

	public void setFishRemoved(BigDecimal fishRemoved) {
		this.fishRemoved = fishRemoved;
	}
	@JsonIgnore
	public void setFishRemoved(String o) {
		this.fishRemoved = FishPopulation.staticSetFishRemoved(siteRequest_, o);
	}
	public static BigDecimal staticSetFishRemoved(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setFishRemoved(Double o) {
		setFishRemoved(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setFishRemoved(Integer o) {
		setFishRemoved(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setFishRemoved(Number o) {
		setFishRemoved(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishPopulation fishRemovedInit() {
		Wrap<BigDecimal> fishRemovedWrap = new Wrap<BigDecimal>().var("fishRemoved");
		if(fishRemoved == null) {
			_fishRemoved(fishRemovedWrap);
			Optional.ofNullable(fishRemovedWrap.getO()).ifPresent(o -> {
				setFishRemoved(o);
			});
		}
		return (FishPopulation)this;
	}

	public static Double staticSearchFishRemoved(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrFishRemoved(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFishRemoved(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchFishRemoved(siteRequest_, FishPopulation.staticSetFishRemoved(siteRequest_, o)).toString();
	}

	public BigDecimal sqlFishRemoved() {
		return fishRemoved;
	}

	///////////////////
	// initialNumber //
	///////////////////


	/**	 The entity initialNumber
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal initialNumber;

	/**	<br> The entity initialNumber
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:initialNumber">Find the entity initialNumber in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _initialNumber(Wrap<BigDecimal> w);

	public BigDecimal getInitialNumber() {
		return initialNumber;
	}

	public void setInitialNumber(BigDecimal initialNumber) {
		this.initialNumber = initialNumber;
	}
	@JsonIgnore
	public void setInitialNumber(String o) {
		this.initialNumber = FishPopulation.staticSetInitialNumber(siteRequest_, o);
	}
	public static BigDecimal staticSetInitialNumber(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setInitialNumber(Double o) {
		setInitialNumber(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setInitialNumber(Integer o) {
		setInitialNumber(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setInitialNumber(Number o) {
		setInitialNumber(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishPopulation initialNumberInit() {
		Wrap<BigDecimal> initialNumberWrap = new Wrap<BigDecimal>().var("initialNumber");
		if(initialNumber == null) {
			_initialNumber(initialNumberWrap);
			Optional.ofNullable(initialNumberWrap.getO()).ifPresent(o -> {
				setInitialNumber(o);
			});
		}
		return (FishPopulation)this;
	}

	public static Double staticSearchInitialNumber(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrInitialNumber(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInitialNumber(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchInitialNumber(siteRequest_, FishPopulation.staticSetInitialNumber(siteRequest_, o)).toString();
	}

	public BigDecimal sqlInitialNumber() {
		return initialNumber;
	}

	///////////
	// owner //
	///////////


	/**	 The entity owner
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject owner;

	/**	<br> The entity owner
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _owner(Wrap<JsonObject> w);

	public JsonObject getOwner() {
		return owner;
	}

	public void setOwner(JsonObject owner) {
		this.owner = owner;
	}
	@JsonIgnore
	public void setOwner(String o) {
		this.owner = FishPopulation.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FishPopulation ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchOwner(siteRequest_, FishPopulation.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
	}

	///////////////
	// refSpecie //
	///////////////


	/**	 The entity refSpecie
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal refSpecie;

	/**	<br> The entity refSpecie
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:refSpecie">Find the entity refSpecie in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refSpecie(Wrap<BigDecimal> w);

	public BigDecimal getRefSpecie() {
		return refSpecie;
	}

	public void setRefSpecie(BigDecimal refSpecie) {
		this.refSpecie = refSpecie;
	}
	@JsonIgnore
	public void setRefSpecie(String o) {
		this.refSpecie = FishPopulation.staticSetRefSpecie(siteRequest_, o);
	}
	public static BigDecimal staticSetRefSpecie(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setRefSpecie(Double o) {
		setRefSpecie(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setRefSpecie(Integer o) {
		setRefSpecie(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setRefSpecie(Number o) {
		setRefSpecie(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishPopulation refSpecieInit() {
		Wrap<BigDecimal> refSpecieWrap = new Wrap<BigDecimal>().var("refSpecie");
		if(refSpecie == null) {
			_refSpecie(refSpecieWrap);
			Optional.ofNullable(refSpecieWrap.getO()).ifPresent(o -> {
				setRefSpecie(o);
			});
		}
		return (FishPopulation)this;
	}

	public static Double staticSearchRefSpecie(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrRefSpecie(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefSpecie(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchRefSpecie(siteRequest_, FishPopulation.staticSetRefSpecie(siteRequest_, o)).toString();
	}

	public BigDecimal sqlRefSpecie() {
		return refSpecie;
	}

	///////////////////
	// relatedSource //
	///////////////////


	/**	 The entity relatedSource
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject relatedSource;

	/**	<br> The entity relatedSource
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:relatedSource">Find the entity relatedSource in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _relatedSource(Wrap<JsonObject> w);

	public JsonObject getRelatedSource() {
		return relatedSource;
	}

	public void setRelatedSource(JsonObject relatedSource) {
		this.relatedSource = relatedSource;
	}
	@JsonIgnore
	public void setRelatedSource(String o) {
		this.relatedSource = FishPopulation.staticSetRelatedSource(siteRequest_, o);
	}
	public static JsonObject staticSetRelatedSource(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FishPopulation relatedSourceInit() {
		Wrap<JsonObject> relatedSourceWrap = new Wrap<JsonObject>().var("relatedSource");
		if(relatedSource == null) {
			_relatedSource(relatedSourceWrap);
			Optional.ofNullable(relatedSourceWrap.getO()).ifPresent(o -> {
				setRelatedSource(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchRelatedSource(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRelatedSource(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRelatedSource(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchRelatedSource(siteRequest_, FishPopulation.staticSetRelatedSource(siteRequest_, o)).toString();
	}

	public JsonObject sqlRelatedSource() {
		return relatedSource;
	}

	/////////////
	// seeAlso //
	/////////////


	/**	 The entity seeAlso
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String seeAlso;

	/**	<br> The entity seeAlso
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeAlso(Wrap<String> w);

	public String getSeeAlso() {
		return seeAlso;
	}
	public void setSeeAlso(String o) {
		this.seeAlso = FishPopulation.staticSetSeeAlso(siteRequest_, o);
	}
	public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation seeAlsoInit() {
		Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchSeeAlso(siteRequest_, FishPopulation.staticSetSeeAlso(siteRequest_, o)).toString();
	}

	public String sqlSeeAlso() {
		return seeAlso;
	}

	////////////
	// source //
	////////////


	/**	 The entity source
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String source;

	/**	<br> The entity source
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = FishPopulation.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishPopulation sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (FishPopulation)this;
	}

	public static String staticSearchSource(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
		return FishPopulation.staticSearchSource(siteRequest_, FishPopulation.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FishPopulationGen<DEV>> promiseDeepFishPopulation(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFishPopulation();
	}

	public Future<FishPopulationGen<DEV>> promiseDeepFishPopulation() {
		Promise<FishPopulationGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFishPopulation(promise2);
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

	public Future<Void> promiseFishPopulation(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				addressInit();
				alternateNameInit();
				bodyMasseInit();
				culturedInInit();
				dataProviderInit();
				dateCreatedInit();
				dateModifiedInit();
				fishRemovedInit();
				initialNumberInit();
				ownerInit();
				refSpecieInit();
				relatedSourceInit();
				seeAlsoInit();
				sourceInit();
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

	@Override public Future<? extends FishPopulationGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFishPopulation(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFishPopulation(SiteRequest siteRequest_) {
			super.siteRequestMapModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFishPopulation(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFishPopulation(v);
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
	public Object obtainFishPopulation(String var) {
		FishPopulation oFishPopulation = (FishPopulation)this;
		switch(var) {
			case "address":
				return oFishPopulation.address;
			case "alternateName":
				return oFishPopulation.alternateName;
			case "bodyMasse":
				return oFishPopulation.bodyMasse;
			case "culturedIn":
				return oFishPopulation.culturedIn;
			case "dataProvider":
				return oFishPopulation.dataProvider;
			case "dateCreated":
				return oFishPopulation.dateCreated;
			case "dateModified":
				return oFishPopulation.dateModified;
			case "fishRemoved":
				return oFishPopulation.fishRemoved;
			case "initialNumber":
				return oFishPopulation.initialNumber;
			case "owner":
				return oFishPopulation.owner;
			case "refSpecie":
				return oFishPopulation.refSpecie;
			case "relatedSource":
				return oFishPopulation.relatedSource;
			case "seeAlso":
				return oFishPopulation.seeAlso;
			case "source":
				return oFishPopulation.source;
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
				o = relateFishPopulation(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFishPopulation(String var, Object val) {
		FishPopulation oFishPopulation = (FishPopulation)this;
		switch(var) {
			default:
				return super.relateMapModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishPopulation o) {
		return staticSetFishPopulation(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetFishPopulation(String entityVar, SiteRequest siteRequest_, String v, FishPopulation o) {
		switch(entityVar) {
		case "address":
			return FishPopulation.staticSetAddress(siteRequest_, v);
		case "alternateName":
			return FishPopulation.staticSetAlternateName(siteRequest_, v);
		case "bodyMasse":
			return FishPopulation.staticSetBodyMasse(siteRequest_, v);
		case "culturedIn":
			return FishPopulation.staticSetCulturedIn(siteRequest_, v);
		case "dataProvider":
			return FishPopulation.staticSetDataProvider(siteRequest_, v);
		case "dateCreated":
			return FishPopulation.staticSetDateCreated(siteRequest_, v);
		case "dateModified":
			return FishPopulation.staticSetDateModified(siteRequest_, v);
		case "fishRemoved":
			return FishPopulation.staticSetFishRemoved(siteRequest_, v);
		case "initialNumber":
			return FishPopulation.staticSetInitialNumber(siteRequest_, v);
		case "owner":
			return FishPopulation.staticSetOwner(siteRequest_, v);
		case "refSpecie":
			return FishPopulation.staticSetRefSpecie(siteRequest_, v);
		case "relatedSource":
			return FishPopulation.staticSetRelatedSource(siteRequest_, v);
		case "seeAlso":
			return FishPopulation.staticSetSeeAlso(siteRequest_, v);
		case "source":
			return FishPopulation.staticSetSource(siteRequest_, v);
			default:
				return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFishPopulation(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFishPopulation(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishPopulation.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return FishPopulation.staticSearchAlternateName(siteRequest_, (String)o);
		case "bodyMasse":
			return FishPopulation.staticSearchBodyMasse(siteRequest_, (BigDecimal)o);
		case "culturedIn":
			return FishPopulation.staticSearchCulturedIn(siteRequest_, (BigDecimal)o);
		case "dataProvider":
			return FishPopulation.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return FishPopulation.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return FishPopulation.staticSearchDateModified(siteRequest_, (String)o);
		case "fishRemoved":
			return FishPopulation.staticSearchFishRemoved(siteRequest_, (BigDecimal)o);
		case "initialNumber":
			return FishPopulation.staticSearchInitialNumber(siteRequest_, (BigDecimal)o);
		case "owner":
			return FishPopulation.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "refSpecie":
			return FishPopulation.staticSearchRefSpecie(siteRequest_, (BigDecimal)o);
		case "relatedSource":
			return FishPopulation.staticSearchRelatedSource(siteRequest_, (JsonObject)o);
		case "seeAlso":
			return FishPopulation.staticSearchSeeAlso(siteRequest_, (String)o);
		case "source":
			return FishPopulation.staticSearchSource(siteRequest_, (String)o);
			default:
				return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFishPopulation(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFishPopulation(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "address":
			return FishPopulation.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return FishPopulation.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "bodyMasse":
			return FishPopulation.staticSearchStrBodyMasse(siteRequest_, (Double)o);
		case "culturedIn":
			return FishPopulation.staticSearchStrCulturedIn(siteRequest_, (Double)o);
		case "dataProvider":
			return FishPopulation.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return FishPopulation.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return FishPopulation.staticSearchStrDateModified(siteRequest_, (String)o);
		case "fishRemoved":
			return FishPopulation.staticSearchStrFishRemoved(siteRequest_, (Double)o);
		case "initialNumber":
			return FishPopulation.staticSearchStrInitialNumber(siteRequest_, (Double)o);
		case "owner":
			return FishPopulation.staticSearchStrOwner(siteRequest_, (String)o);
		case "refSpecie":
			return FishPopulation.staticSearchStrRefSpecie(siteRequest_, (Double)o);
		case "relatedSource":
			return FishPopulation.staticSearchStrRelatedSource(siteRequest_, (String)o);
		case "seeAlso":
			return FishPopulation.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "source":
			return FishPopulation.staticSearchStrSource(siteRequest_, (String)o);
			default:
				return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFishPopulation(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFishPopulation(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "address":
			return FishPopulation.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return FishPopulation.staticSearchFqAlternateName(siteRequest_, o);
		case "bodyMasse":
			return FishPopulation.staticSearchFqBodyMasse(siteRequest_, o);
		case "culturedIn":
			return FishPopulation.staticSearchFqCulturedIn(siteRequest_, o);
		case "dataProvider":
			return FishPopulation.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return FishPopulation.staticSearchFqDateCreated(siteRequest_, o);
		case "dateModified":
			return FishPopulation.staticSearchFqDateModified(siteRequest_, o);
		case "fishRemoved":
			return FishPopulation.staticSearchFqFishRemoved(siteRequest_, o);
		case "initialNumber":
			return FishPopulation.staticSearchFqInitialNumber(siteRequest_, o);
		case "owner":
			return FishPopulation.staticSearchFqOwner(siteRequest_, o);
		case "refSpecie":
			return FishPopulation.staticSearchFqRefSpecie(siteRequest_, o);
		case "relatedSource":
			return FishPopulation.staticSearchFqRelatedSource(siteRequest_, o);
		case "seeAlso":
			return FishPopulation.staticSearchFqSeeAlso(siteRequest_, o);
		case "source":
			return FishPopulation.staticSearchFqSource(siteRequest_, o);
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
					o = persistFishPopulation(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFishPopulation(String var, Object val) {
		String varLower = var.toLowerCase();
			if("address".equals(varLower)) {
				if(val instanceof String) {
					setAddress((String)val);
				} else if(val instanceof JsonObject) {
					setAddress((JsonObject)val);
				}
				saves.add("address");
				return val;
			} else if("alternatename".equals(varLower)) {
				if(val instanceof String) {
					setAlternateName((String)val);
				}
				saves.add("alternateName");
				return val;
			} else if("bodymasse".equals(varLower)) {
				if(val instanceof String) {
					setBodyMasse((String)val);
				} else if(val instanceof Number) {
					setBodyMasse(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("bodyMasse");
				return val;
			} else if("culturedin".equals(varLower)) {
				if(val instanceof String) {
					setCulturedIn((String)val);
				} else if(val instanceof Number) {
					setCulturedIn(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("culturedIn");
				return val;
			} else if("dataprovider".equals(varLower)) {
				if(val instanceof String) {
					setDataProvider((String)val);
				}
				saves.add("dataProvider");
				return val;
			} else if("datecreated".equals(varLower)) {
				if(val instanceof String) {
					setDateCreated((String)val);
				}
				saves.add("dateCreated");
				return val;
			} else if("datemodified".equals(varLower)) {
				if(val instanceof String) {
					setDateModified((String)val);
				}
				saves.add("dateModified");
				return val;
			} else if("fishremoved".equals(varLower)) {
				if(val instanceof String) {
					setFishRemoved((String)val);
				} else if(val instanceof Number) {
					setFishRemoved(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("fishRemoved");
				return val;
			} else if("initialnumber".equals(varLower)) {
				if(val instanceof String) {
					setInitialNumber((String)val);
				} else if(val instanceof Number) {
					setInitialNumber(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("initialNumber");
				return val;
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
				return val;
			} else if("refspecie".equals(varLower)) {
				if(val instanceof String) {
					setRefSpecie((String)val);
				} else if(val instanceof Number) {
					setRefSpecie(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("refSpecie");
				return val;
			} else if("relatedsource".equals(varLower)) {
				if(val instanceof String) {
					setRelatedSource((String)val);
				} else if(val instanceof JsonObject) {
					setRelatedSource((JsonObject)val);
				}
				saves.add("relatedSource");
				return val;
			} else if("seealso".equals(varLower)) {
				if(val instanceof String) {
					setSeeAlso((String)val);
				}
				saves.add("seeAlso");
				return val;
			} else if("source".equals(varLower)) {
				if(val instanceof String) {
					setSource((String)val);
				}
				saves.add("source");
				return val;
		} else {
			return super.persistMapModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateFishPopulation(doc);
	}
	public void populateFishPopulation(SolrResponse.Doc doc) {
		FishPopulation oFishPopulation = (FishPopulation)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oFishPopulation.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oFishPopulation.setAlternateName(alternateName);
			}

			if(saves.contains("bodyMasse")) {
				Double bodyMasse = (Double)doc.get("bodyMasse_docvalues_double");
				if(bodyMasse != null)
					oFishPopulation.setBodyMasse(bodyMasse);
			}

			if(saves.contains("culturedIn")) {
				Double culturedIn = (Double)doc.get("culturedIn_docvalues_double");
				if(culturedIn != null)
					oFishPopulation.setCulturedIn(culturedIn);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oFishPopulation.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oFishPopulation.setDateCreated(dateCreated);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oFishPopulation.setDateModified(dateModified);
			}

			if(saves.contains("fishRemoved")) {
				Double fishRemoved = (Double)doc.get("fishRemoved_docvalues_double");
				if(fishRemoved != null)
					oFishPopulation.setFishRemoved(fishRemoved);
			}

			if(saves.contains("initialNumber")) {
				Double initialNumber = (Double)doc.get("initialNumber_docvalues_double");
				if(initialNumber != null)
					oFishPopulation.setInitialNumber(initialNumber);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oFishPopulation.setOwner(owner);
			}

			if(saves.contains("refSpecie")) {
				Double refSpecie = (Double)doc.get("refSpecie_docvalues_double");
				if(refSpecie != null)
					oFishPopulation.setRefSpecie(refSpecie);
			}

			if(saves.contains("relatedSource")) {
				String relatedSource = (String)doc.get("relatedSource_docvalues_string");
				if(relatedSource != null)
					oFishPopulation.setRelatedSource(relatedSource);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oFishPopulation.setSeeAlso(seeAlso);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oFishPopulation.setSource(source);
			}
		}

		super.populateMapModel(doc);
	}

	public void indexFishPopulation(JsonObject doc) {
		if(address != null) {
			doc.put("address_docvalues_string", address.encode());
		}
		if(alternateName != null) {
			doc.put("alternateName_docvalues_string", alternateName);
		}
		if(bodyMasse != null) {
			doc.put("bodyMasse_docvalues_double", bodyMasse.doubleValue());
		}
		if(culturedIn != null) {
			doc.put("culturedIn_docvalues_double", culturedIn.doubleValue());
		}
		if(dataProvider != null) {
			doc.put("dataProvider_docvalues_string", dataProvider);
		}
		if(dateCreated != null) {
			doc.put("dateCreated_docvalues_string", dateCreated);
		}
		if(dateModified != null) {
			doc.put("dateModified_docvalues_string", dateModified);
		}
		if(fishRemoved != null) {
			doc.put("fishRemoved_docvalues_double", fishRemoved.doubleValue());
		}
		if(initialNumber != null) {
			doc.put("initialNumber_docvalues_double", initialNumber.doubleValue());
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.encode());
		}
		if(refSpecie != null) {
			doc.put("refSpecie_docvalues_double", refSpecie.doubleValue());
		}
		if(relatedSource != null) {
			doc.put("relatedSource_docvalues_string", relatedSource.encode());
		}
		if(seeAlso != null) {
			doc.put("seeAlso_docvalues_string", seeAlso);
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		super.indexMapModel(doc);

	}

	public static String varStoredFishPopulation(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "bodyMasse":
				return "bodyMasse_docvalues_double";
			case "culturedIn":
				return "culturedIn_docvalues_double";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "fishRemoved":
				return "fishRemoved_docvalues_double";
			case "initialNumber":
				return "initialNumber_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "refSpecie":
				return "refSpecie_docvalues_double";
			case "relatedSource":
				return "relatedSource_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return MapModel.varStoredMapModel(entityVar);
		}
	}

	public static String varIndexedFishPopulation(String entityVar) {
		switch(entityVar) {
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "bodyMasse":
				return "bodyMasse_docvalues_double";
			case "culturedIn":
				return "culturedIn_docvalues_double";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "fishRemoved":
				return "fishRemoved_docvalues_double";
			case "initialNumber":
				return "initialNumber_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "refSpecie":
				return "refSpecie_docvalues_double";
			case "relatedSource":
				return "relatedSource_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return MapModel.varIndexedMapModel(entityVar);
		}
	}

	public static String searchVarFishPopulation(String searchVar) {
		switch(searchVar) {
			case "address_docvalues_string":
				return "address";
			case "alternateName_docvalues_string":
				return "alternateName";
			case "bodyMasse_docvalues_double":
				return "bodyMasse";
			case "culturedIn_docvalues_double":
				return "culturedIn";
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
			case "dateModified_docvalues_string":
				return "dateModified";
			case "fishRemoved_docvalues_double":
				return "fishRemoved";
			case "initialNumber_docvalues_double":
				return "initialNumber";
			case "owner_docvalues_string":
				return "owner";
			case "refSpecie_docvalues_double":
				return "refSpecie";
			case "relatedSource_docvalues_string":
				return "relatedSource";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "source_docvalues_string":
				return "source";
			default:
				return MapModel.searchVarMapModel(searchVar);
		}
	}

	public static String varSearchFishPopulation(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSearchMapModel(entityVar);
		}
	}

	public static String varSuggestedFishPopulation(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSuggestedMapModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFishPopulation(doc);
	}
	public void storeFishPopulation(SolrResponse.Doc doc) {
		FishPopulation oFishPopulation = (FishPopulation)this;
		SiteRequest siteRequest = oFishPopulation.getSiteRequest_();

		oFishPopulation.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setBodyMasse(Optional.ofNullable(doc.get("bodyMasse_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setCulturedIn(Optional.ofNullable(doc.get("culturedIn_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setFishRemoved(Optional.ofNullable(doc.get("fishRemoved_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setInitialNumber(Optional.ofNullable(doc.get("initialNumber_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setRefSpecie(Optional.ofNullable(doc.get("refSpecie_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setRelatedSource(Optional.ofNullable(doc.get("relatedSource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishPopulation.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeMapModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFishPopulation() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof FishPopulation) {
			FishPopulation original = (FishPopulation)o;
			if(!Objects.equals(address, original.getAddress()))
				apiRequest.addVars("address");
			if(!Objects.equals(alternateName, original.getAlternateName()))
				apiRequest.addVars("alternateName");
			if(!Objects.equals(bodyMasse, original.getBodyMasse()) && bodyMasse != null && original.getBodyMasse() != null && bodyMasse.compareTo(original.getBodyMasse()) != 0)
				apiRequest.addVars("bodyMasse");
			if(!Objects.equals(culturedIn, original.getCulturedIn()) && culturedIn != null && original.getCulturedIn() != null && culturedIn.compareTo(original.getCulturedIn()) != 0)
				apiRequest.addVars("culturedIn");
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
			if(!Objects.equals(dateModified, original.getDateModified()))
				apiRequest.addVars("dateModified");
			if(!Objects.equals(fishRemoved, original.getFishRemoved()) && fishRemoved != null && original.getFishRemoved() != null && fishRemoved.compareTo(original.getFishRemoved()) != 0)
				apiRequest.addVars("fishRemoved");
			if(!Objects.equals(initialNumber, original.getInitialNumber()) && initialNumber != null && original.getInitialNumber() != null && initialNumber.compareTo(original.getInitialNumber()) != 0)
				apiRequest.addVars("initialNumber");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(refSpecie, original.getRefSpecie()) && refSpecie != null && original.getRefSpecie() != null && refSpecie.compareTo(original.getRefSpecie()) != 0)
				apiRequest.addVars("refSpecie");
			if(!Objects.equals(relatedSource, original.getRelatedSource()))
				apiRequest.addVars("relatedSource");
			if(!Objects.equals(seeAlso, original.getSeeAlso()))
				apiRequest.addVars("seeAlso");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
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
		sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(bodyMasse).map(v -> "bodyMasse: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(culturedIn).map(v -> "culturedIn: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(fishRemoved).map(v -> "fishRemoved: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(initialNumber).map(v -> "initialNumber: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refSpecie).map(v -> "refSpecie: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(relatedSource).map(v -> "relatedSource: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "FishPopulation";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation";
	public static final String CLASS_AUTH_RESOURCE = "FISHPOPULATION";
	public static final String CLASS_API_ADDRESS_FishPopulation = "smart-aquaculture-enUS-FishPopulation";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_FishPopulation;
	}
	public static final String VAR_address = "address";
	public static final String VAR_alternateName = "alternateName";
	public static final String VAR_bodyMasse = "bodyMasse";
	public static final String VAR_culturedIn = "culturedIn";
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_fishRemoved = "fishRemoved";
	public static final String VAR_initialNumber = "initialNumber";
	public static final String VAR_owner = "owner";
	public static final String VAR_refSpecie = "refSpecie";
	public static final String VAR_relatedSource = "relatedSource";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_source = "source";

	public static List<String> varsQForClass() {
		return FishPopulation.varsQFishPopulation(new ArrayList<String>());
	}
	public static List<String> varsQFishPopulation(List<String> vars) {
		MapModel.varsQMapModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return FishPopulation.varsFqFishPopulation(new ArrayList<String>());
	}
	public static List<String> varsFqFishPopulation(List<String> vars) {
		vars.add(VAR_address);
		vars.add(VAR_alternateName);
		vars.add(VAR_bodyMasse);
		vars.add(VAR_culturedIn);
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateModified);
		vars.add(VAR_fishRemoved);
		vars.add(VAR_initialNumber);
		vars.add(VAR_owner);
		vars.add(VAR_refSpecie);
		vars.add(VAR_relatedSource);
		vars.add(VAR_seeAlso);
		vars.add(VAR_source);
		MapModel.varsFqMapModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return FishPopulation.varsRangeFishPopulation(new ArrayList<String>());
	}
	public static List<String> varsRangeFishPopulation(List<String> vars) {
		vars.add(VAR_address);
		vars.add(VAR_bodyMasse);
		vars.add(VAR_culturedIn);
		vars.add(VAR_fishRemoved);
		vars.add(VAR_initialNumber);
		vars.add(VAR_owner);
		vars.add(VAR_refSpecie);
		vars.add(VAR_relatedSource);
		MapModel.varsRangeMapModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_address = "address";
	public static final String DISPLAY_NAME_alternateName = "alternate name";
	public static final String DISPLAY_NAME_bodyMasse = "body masse";
	public static final String DISPLAY_NAME_culturedIn = "cultured in";
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_fishRemoved = "fish removed";
	public static final String DISPLAY_NAME_initialNumber = "initial number";
	public static final String DISPLAY_NAME_owner = "owner";
	public static final String DISPLAY_NAME_refSpecie = "ref specie";
	public static final String DISPLAY_NAME_relatedSource = "related source";
	public static final String DISPLAY_NAME_seeAlso = "see also";
	public static final String DISPLAY_NAME_source = "source";

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
		return FishPopulation.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/fish-population/%s";
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
		return FishPopulation.displayNameFishPopulation(var);
	}
	public static String displayNameFishPopulation(String var) {
		switch(var) {
		case VAR_address:
			return DISPLAY_NAME_address;
		case VAR_alternateName:
			return DISPLAY_NAME_alternateName;
		case VAR_bodyMasse:
			return DISPLAY_NAME_bodyMasse;
		case VAR_culturedIn:
			return DISPLAY_NAME_culturedIn;
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
		case VAR_dateModified:
			return DISPLAY_NAME_dateModified;
		case VAR_fishRemoved:
			return DISPLAY_NAME_fishRemoved;
		case VAR_initialNumber:
			return DISPLAY_NAME_initialNumber;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_refSpecie:
			return DISPLAY_NAME_refSpecie;
		case VAR_relatedSource:
			return DISPLAY_NAME_relatedSource;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_source:
			return DISPLAY_NAME_source;
		default:
			return MapModel.displayNameMapModel(var);
		}
	}

	public static String descriptionFishPopulation(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_address:
			return "The mailing address";
		case VAR_alternateName:
			return "An alternative name for this item";
		case VAR_bodyMasse:
			return "The average body masse cultured fishes";
		case VAR_culturedIn:
			return "Reference to the FishContainment";
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
		case VAR_fishRemoved:
			return "Number of removed fishes";
		case VAR_initialNumber:
			return "Number of initial number of cultured fishes";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_refSpecie:
			return "Reference to the Specie";
		case VAR_relatedSource:
			return "List of IDs the current entity may have in external applications";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
			default:
				return MapModel.descriptionMapModel(var);
		}
	}

	public static String classSimpleNameFishPopulation(String var) {
		switch(var) {
		case VAR_address:
			return "JsonObject";
		case VAR_alternateName:
			return "String";
		case VAR_bodyMasse:
			return "BigDecimal";
		case VAR_culturedIn:
			return "BigDecimal";
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
			return "String";
		case VAR_dateModified:
			return "String";
		case VAR_fishRemoved:
			return "BigDecimal";
		case VAR_initialNumber:
			return "BigDecimal";
		case VAR_owner:
			return "JsonObject";
		case VAR_refSpecie:
			return "BigDecimal";
		case VAR_relatedSource:
			return "JsonObject";
		case VAR_seeAlso:
			return "String";
		case VAR_source:
			return "String";
			default:
				return MapModel.classSimpleNameMapModel(var);
		}
	}

	public static String ngsiType(String var) {
		switch(var) {
		case VAR_address:
			return "Property";
		case VAR_alternateName:
			return "Property";
		case VAR_bodyMasse:
			return "Property";
		case VAR_culturedIn:
			return "Property";
		case VAR_dataProvider:
			return "Property";
		case VAR_dateCreated:
			return "Property";
		case VAR_dateModified:
			return "Property";
		case VAR_fishRemoved:
			return "Property";
		case VAR_initialNumber:
			return "Property";
		case VAR_owner:
			return "Property";
		case VAR_refSpecie:
			return "Property";
		case VAR_relatedSource:
			return "Property";
		case VAR_seeAlso:
			return "Property";
		case VAR_source:
			return "Property";
			default:
				return MapModel.ngsiType(var);
		}
	}

	public static Object ngsiFishPopulation(String var, FishPopulation o) {
		switch(var) {
		case VAR_address:
			return o.getAddress();
		case VAR_alternateName:
			return o.getAlternateName();
		case VAR_bodyMasse:
			return o.getBodyMasse();
		case VAR_culturedIn:
			return o.getCulturedIn();
		case VAR_dataProvider:
			return o.getDataProvider();
		case VAR_dateCreated:
			return o.getDateCreated();
		case VAR_dateModified:
			return o.getDateModified();
		case VAR_fishRemoved:
			return o.getFishRemoved();
		case VAR_initialNumber:
			return o.getInitialNumber();
		case VAR_owner:
			return o.getOwner();
		case VAR_refSpecie:
			return o.getRefSpecie();
		case VAR_relatedSource:
			return o.getRelatedSource();
		case VAR_seeAlso:
			return o.getSeeAlso();
		case VAR_source:
			return o.getSource();
			default:
				return ngsiMapModel(var, o);
		}
	}

	public static Integer htmColumnFishPopulation(String var) {
		switch(var) {
			default:
				return MapModel.htmColumnMapModel(var);
		}
	}

	public static Integer htmRowFishPopulation(String var) {
		switch(var) {
		case VAR_address:
			return 6;
		case VAR_alternateName:
			return 6;
		case VAR_bodyMasse:
			return 6;
		case VAR_culturedIn:
			return 6;
		case VAR_dataProvider:
			return 6;
		case VAR_dateCreated:
			return 6;
		case VAR_dateModified:
			return 6;
		case VAR_fishRemoved:
			return 6;
		case VAR_initialNumber:
			return 6;
		case VAR_owner:
			return 6;
		case VAR_refSpecie:
			return 6;
		case VAR_relatedSource:
			return 6;
		case VAR_seeAlso:
			return 6;
		case VAR_source:
			return 6;
			default:
				return MapModel.htmRowMapModel(var);
		}
	}

	public static Integer htmCellFishPopulation(String var) {
		switch(var) {
		case VAR_address:
			return 0;
		case VAR_alternateName:
			return 1;
		case VAR_bodyMasse:
			return 2;
		case VAR_culturedIn:
			return 3;
		case VAR_dataProvider:
			return 4;
		case VAR_dateCreated:
			return 5;
		case VAR_dateModified:
			return 6;
		case VAR_fishRemoved:
			return 7;
		case VAR_initialNumber:
			return 8;
		case VAR_owner:
			return 9;
		case VAR_refSpecie:
			return 10;
		case VAR_relatedSource:
			return 11;
		case VAR_seeAlso:
			return 12;
		case VAR_source:
			return 13;
			default:
				return MapModel.htmCellMapModel(var);
		}
	}

	public static Integer lengthMinFishPopulation(String var) {
		switch(var) {
			default:
				return MapModel.lengthMinMapModel(var);
		}
	}

	public static Integer lengthMaxFishPopulation(String var) {
		switch(var) {
			default:
				return MapModel.lengthMaxMapModel(var);
		}
	}

	public static Integer maxFishPopulation(String var) {
		switch(var) {
			default:
				return MapModel.maxMapModel(var);
		}
	}

	public static Integer minFishPopulation(String var) {
		switch(var) {
			default:
				return MapModel.minMapModel(var);
		}
	}
}
