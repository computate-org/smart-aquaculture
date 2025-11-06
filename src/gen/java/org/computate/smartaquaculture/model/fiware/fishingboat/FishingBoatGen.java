/**
 * Order: 12
 * Description: A fishing boat that catches fish from a fish population and returns the fish to a dock. 
 * AName: a fishing boat
 * Icon: <i class="fa-duotone fa-regular fa-ship"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 640"><!--!Font Awesome Pro v7.1.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path opacity=".4" d="M141 363.5L296.5 301.3L296.5 464.5C297.3 465.1 298 465.6 298.7 466.2C297.5 465.3 296.2 464.4 294.9 463.4C266.8 442.3 233.6 431.8 200.5 432C197.5 432 194.5 432.1 191.4 432.3C170 413.7 152.6 390.3 141 363.5zM339.9 467.8C341.4 466.8 342.9 465.7 344.5 464.5L344.5 301.3L500 363.5C488.4 390.3 471.1 413.5 449.6 432.3C445.9 432.1 442.2 432 438.5 432C406 432.2 373.6 442.7 346.1 463.4C343.9 465 341.9 466.5 339.9 467.8z"/><path d="M375 501.7C413.4 472.7 465.6 472.7 504 501.7C520.9 514.4 536.9 523.2 551.8 526.3C565.5 529.1 579.2 527.2 594.1 516C604.7 508 619.7 510.1 627.7 520.7C635.7 531.3 633.6 546.3 623 554.3C596.6 574.2 568.8 578.7 542.3 573.4C517 568.3 494.2 554.5 475.1 540.1C453.8 524 425.2 524 403.9 540.1C379.7 558.4 351.6 576 320.5 576C289.4 576 261.4 558.3 237.1 540.1C215.8 524 187.2 524 165.9 540.1C142.2 558 111.8 575.6 77.9 575.4C57.5 575.3 37.2 568.7 18.1 554.3C7.5 546.3 5.4 531.3 13.4 520.7C21.4 510.1 36.4 508 47 516C58.3 524.5 68.6 527.4 78.2 527.5C95.8 527.6 115.5 518.1 137.1 501.8C175.5 472.8 227.7 472.8 266.1 501.8C290.1 519.9 306.8 528.1 320.6 528.1C334.4 528.1 351.1 519.9 375.1 501.8zM368.5 64C395 64 416.5 85.5 416.5 112L416.5 128L432.5 128C476.7 128 512.5 163.8 512.5 208L512.5 316.8L534.1 325.4C548.9 331.3 556.5 347.8 551.5 362.9C541.1 394.2 524.7 422.2 503.8 446C486.5 438.1 468.1 433.5 449.6 432.3C471 413.7 488.4 390.4 500 363.5L344.5 301.3L344.5 464.5C324.2 479.6 316.8 479.6 296.5 464.5L296.5 301.3L141 363.5C152.6 390.4 170 413.7 191.4 432.3C172.8 433.5 154.5 438.1 137.2 446C116.3 422.3 99.9 394.2 89.5 362.9C84.4 347.7 92.1 331.3 106.9 325.3L128.5 316.7L128.5 207.9C128.5 163.7 164.3 127.9 208.5 127.9L224.5 127.9L224.5 111.9C224.5 85.4 246 63.9 272.5 63.9L368.5 63.9zM208.5 176C190.8 176 176.5 190.3 176.5 208L176.5 297.6L296.7 249.5C312 243.4 329 243.4 344.3 249.5L464.5 297.6L464.5 208C464.5 190.3 450.2 176 432.5 176L208.5 176z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-boat
 * EditPageUri: /en-us/edit/fishing-boat/{entityShortId}
 * ApiUri: /en-us/api/fishing-boat
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingBoatViewer:
 *     GET:
 *   FishingBoatEditor:
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
 */
package org.computate.smartaquaculture.model.fiware.fishingboat;

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
import java.lang.String;
import org.computate.smartaquaculture.model.timezone.TimeZone;
import org.computate.smartaquaculture.model.fiware.fishingdock.FishingDock;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPathSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPathDeserializer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishingBoatGen into the class FishingBoat. 
 * </li>
 * <h3>About the FishingBoat class and it's generated class FishingBoatGen&lt;MapModel&gt;: </h3>extends FishingBoatGen
 * <p>
 * This Java class extends a generated Java class FishingBoatGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat">Find the class FishingBoat in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishingBoatGen<MapModel>
 * <p>This <code>class FishingBoat extends FishingBoatGen&lt;MapModel&gt;</code>, which means it extends a newly generated FishingBoatGen. 
 * The generated <code>class FishingBoatGen extends MapModel</code> which means that FishingBoat extends FishingBoatGen which extends MapModel. 
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
 * <p>This class contains a comment <b>"ApiTag: fishing boats"</b>, which groups all of the OpenAPIs for FishingBoat objects under the tag "fishing boats". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/fishing-boat</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/fishing-boat"</b>, which defines the base API URI for FishingBoat objects as "/en-us/api/fishing-boat" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishingBoat class will inherit the helpful inherited class comments from the super class FishingBoatGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the FishingBoat API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 12</h2>
 * <p>This class contains a comment <b>"Order: 12"</b>, which means this class will be sorted by the given number 12 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 12</h2>
 * <p>This class contains a comment <b>"SqlOrder: 12"</b>, which means this class will be sorted by the given number 12 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoatPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishingBoat Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a fishing boat</h2>
 * <p>This class contains a comment <b>"AName.enUS: a fishing boat"</b>, which identifies the language context to describe a FishingBoat as "a fishing boat". 
 * </p>
 * <p>
 * Delete the class FishingBoat in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishingboat in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishingBoatGen<DEV> extends MapModel {
	protected static final Logger LOG = LoggerFactory.getLogger(FishingBoat.class);

	public static final String Description_enUS = "A fishing boat that catches fish from a fish population and returns the fish to a dock. ";
	public static final String AName_enUS = "a fishing boat";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this fishing boat";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the fishing boat";
	public static final String SingularName_enUS = "fishing boat";
	public static final String PluralName_enUS = "fishing boats";
	public static final String NameActual_enUS = "current fishing boat";
	public static final String AllName_enUS = "all fishing boats";
	public static final String SearchAllNameBy_enUS = "search fishing boats by ";
	public static final String SearchAllName_enUS = "search fishing boats";
	public static final String Title_enUS = "fishing boats";
	public static final String ThePluralName_enUS = "the fishing boats";
	public static final String NoNameFound_enUS = "no fishing boat found";
	public static final String ApiUri_enUS = "/en-us/api/fishing-boat";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/fishing-boat";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/fishing-boat/{entityShortId}";
	public static final String OfName_enUS = "of fishing boat";
	public static final String ANameAdjective_enUS = "a fishing boat";
	public static final String NameAdjectiveSingular_enUS = "fishing boat";
	public static final String NameAdjectivePlural_enUS = "fishing boats";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/fishing-boat";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/fishing-boat";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/fishing-boat/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/fishing-boat/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/fishing-boat";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/fishing-boat";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/fishing-boat";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/fishing-boat";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/fishing-boat/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/fishing-boat/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/fishing-boat-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/fishing-boat-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/fishing-boat";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/fishing-boat";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/fishing-boat";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/fishing-boat/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/fishing-boat/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/fishing-boat/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/fishing-boat";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/fishing-boat";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/fishing-boat";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-ship\"></i>";
	public static final Integer Rows = 100;

	//////////////
	// timeZone //
	//////////////


	/**	 The entity timeZone
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String timeZone;

	/**	<br> The entity timeZone
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:timeZone">Find the entity timeZone in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _timeZone(Wrap<String> w);

	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String o) {
		this.timeZone = FishingBoat.staticSetTimeZone(siteRequest_, o);
	}
	public static String staticSetTimeZone(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishingBoat timeZoneInit() {
		Wrap<String> timeZoneWrap = new Wrap<String>().var("timeZone");
		if(timeZone == null) {
			_timeZone(timeZoneWrap);
			Optional.ofNullable(timeZoneWrap.getO()).ifPresent(o -> {
				setTimeZone(o);
			});
		}
		return (FishingBoat)this;
	}

	public static String staticSearchTimeZone(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTimeZone(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTimeZone(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchTimeZone(siteRequest_, FishingBoat.staticSetTimeZone(siteRequest_, o)).toString();
	}

	public String sqlTimeZone() {
		return timeZone;
	}

	///////////////////
	// fishingDockId //
	///////////////////


	/**	 The entity fishingDockId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String fishingDockId;

	/**	<br> The entity fishingDockId
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:fishingDockId">Find the entity fishingDockId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fishingDockId(Wrap<String> w);

	public String getFishingDockId() {
		return fishingDockId;
	}
	public void setFishingDockId(String o) {
		this.fishingDockId = FishingBoat.staticSetFishingDockId(siteRequest_, o);
	}
	public static String staticSetFishingDockId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishingBoat fishingDockIdInit() {
		Wrap<String> fishingDockIdWrap = new Wrap<String>().var("fishingDockId");
		if(fishingDockId == null) {
			_fishingDockId(fishingDockIdWrap);
			Optional.ofNullable(fishingDockIdWrap.getO()).ifPresent(o -> {
				setFishingDockId(o);
			});
		}
		return (FishingBoat)this;
	}

	public static String staticSearchFishingDockId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFishingDockId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFishingDockId(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchFishingDockId(siteRequest_, FishingBoat.staticSetFishingDockId(siteRequest_, o)).toString();
	}

	public String sqlFishingDockId() {
		return fishingDockId;
	}

	///////////////////
	// departureDate //
	///////////////////


	/**	 The entity departureDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime departureDate;

	/**	<br> The entity departureDate
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:departureDate">Find the entity departureDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _departureDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(ZonedDateTime departureDate) {
		this.departureDate = Optional.ofNullable(departureDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
	}
	@JsonIgnore
	public void setDepartureDate(Instant o) {
		this.departureDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setDepartureDate(String o) {
		ZoneId zoneId = Optional.ofNullable(timeZone).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")));
		this.departureDate = FishingBoat.staticSetDepartureDate(siteRequest_, o, zoneId);
	}
	@JsonIgnore
	public void setDepartureDate(Date o) {
		this.departureDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	public static ZonedDateTime staticSetDepartureDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
	}
	protected FishingBoat departureDateInit() {
		Wrap<ZonedDateTime> departureDateWrap = new Wrap<ZonedDateTime>().var("departureDate");
		if(departureDate == null) {
			_departureDate(departureDateWrap);
			Optional.ofNullable(departureDateWrap.getO()).ifPresent(o -> {
				setDepartureDate(o);
			});
		}
		return (FishingBoat)this;
	}

	public static String staticSearchDepartureDate(SiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrDepartureDate(SiteRequest siteRequest_, String o) {
		ZoneId zoneId = ZoneId.of("UTC");
		return FishingBoat.staticSearchDepartureDate(siteRequest_, FishingBoat.staticSetDepartureDate(siteRequest_, o, zoneId));
	}

	public static String staticSearchFqDepartureDate(SiteRequest siteRequest_, String o) {
		ZoneId zoneId = ZoneId.of("UTC");
		return FishingBoat.staticSearchDepartureDate(siteRequest_, FishingBoat.staticSetDepartureDate(siteRequest_, o, zoneId)).toString();
	}

	public OffsetDateTime sqlDepartureDate() {
		return departureDate == null ? null : departureDate.toOffsetDateTime();
	}

	/////////////////
	// arrivalDate //
	/////////////////


	/**	 The entity arrivalDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime arrivalDate;

	/**	<br> The entity arrivalDate
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:arrivalDate">Find the entity arrivalDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _arrivalDate(Wrap<ZonedDateTime> w);

	public ZonedDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(ZonedDateTime arrivalDate) {
		this.arrivalDate = Optional.ofNullable(arrivalDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
	}
	@JsonIgnore
	public void setArrivalDate(Instant o) {
		this.arrivalDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setArrivalDate(String o) {
		ZoneId zoneId = Optional.ofNullable(timeZone).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")));
		this.arrivalDate = FishingBoat.staticSetArrivalDate(siteRequest_, o, zoneId);
	}
	@JsonIgnore
	public void setArrivalDate(Date o) {
		this.arrivalDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	public static ZonedDateTime staticSetArrivalDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
	}
	protected FishingBoat arrivalDateInit() {
		Wrap<ZonedDateTime> arrivalDateWrap = new Wrap<ZonedDateTime>().var("arrivalDate");
		if(arrivalDate == null) {
			_arrivalDate(arrivalDateWrap);
			Optional.ofNullable(arrivalDateWrap.getO()).ifPresent(o -> {
				setArrivalDate(o);
			});
		}
		return (FishingBoat)this;
	}

	public static String staticSearchArrivalDate(SiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrArrivalDate(SiteRequest siteRequest_, String o) {
		ZoneId zoneId = ZoneId.of("UTC");
		return FishingBoat.staticSearchArrivalDate(siteRequest_, FishingBoat.staticSetArrivalDate(siteRequest_, o, zoneId));
	}

	public static String staticSearchFqArrivalDate(SiteRequest siteRequest_, String o) {
		ZoneId zoneId = ZoneId.of("UTC");
		return FishingBoat.staticSearchArrivalDate(siteRequest_, FishingBoat.staticSetArrivalDate(siteRequest_, o, zoneId)).toString();
	}

	public OffsetDateTime sqlArrivalDate() {
		return arrivalDate == null ? null : arrivalDate.toOffsetDateTime();
	}

	///////////////////
	// avgSpeedInMph //
	///////////////////


	/**	 The entity avgSpeedInMph
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal avgSpeedInMph;

	/**	<br> The entity avgSpeedInMph
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:avgSpeedInMph">Find the entity avgSpeedInMph in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _avgSpeedInMph(Wrap<BigDecimal> w);

	public BigDecimal getAvgSpeedInMph() {
		return avgSpeedInMph;
	}

	public void setAvgSpeedInMph(BigDecimal avgSpeedInMph) {
		this.avgSpeedInMph = avgSpeedInMph;
	}
	@JsonIgnore
	public void setAvgSpeedInMph(String o) {
		this.avgSpeedInMph = FishingBoat.staticSetAvgSpeedInMph(siteRequest_, o);
	}
	public static BigDecimal staticSetAvgSpeedInMph(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAvgSpeedInMph(Double o) {
		setAvgSpeedInMph(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAvgSpeedInMph(Integer o) {
		setAvgSpeedInMph(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAvgSpeedInMph(Number o) {
		setAvgSpeedInMph(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishingBoat avgSpeedInMphInit() {
		Wrap<BigDecimal> avgSpeedInMphWrap = new Wrap<BigDecimal>().var("avgSpeedInMph");
		if(avgSpeedInMph == null) {
			_avgSpeedInMph(avgSpeedInMphWrap);
			Optional.ofNullable(avgSpeedInMphWrap.getO()).ifPresent(o -> {
				setAvgSpeedInMph(o);
			});
		}
		return (FishingBoat)this;
	}

	public static Double staticSearchAvgSpeedInMph(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAvgSpeedInMph(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAvgSpeedInMph(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchAvgSpeedInMph(siteRequest_, FishingBoat.staticSetAvgSpeedInMph(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAvgSpeedInMph() {
		return avgSpeedInMph;
	}

	///////////////////
	// maxSpeedInMph //
	///////////////////


	/**	 The entity maxSpeedInMph
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal maxSpeedInMph;

	/**	<br> The entity maxSpeedInMph
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:maxSpeedInMph">Find the entity maxSpeedInMph in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _maxSpeedInMph(Wrap<BigDecimal> w);

	public BigDecimal getMaxSpeedInMph() {
		return maxSpeedInMph;
	}

	public void setMaxSpeedInMph(BigDecimal maxSpeedInMph) {
		this.maxSpeedInMph = maxSpeedInMph;
	}
	@JsonIgnore
	public void setMaxSpeedInMph(String o) {
		this.maxSpeedInMph = FishingBoat.staticSetMaxSpeedInMph(siteRequest_, o);
	}
	public static BigDecimal staticSetMaxSpeedInMph(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMaxSpeedInMph(Double o) {
		setMaxSpeedInMph(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaxSpeedInMph(Integer o) {
		setMaxSpeedInMph(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMaxSpeedInMph(Number o) {
		setMaxSpeedInMph(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishingBoat maxSpeedInMphInit() {
		Wrap<BigDecimal> maxSpeedInMphWrap = new Wrap<BigDecimal>().var("maxSpeedInMph");
		if(maxSpeedInMph == null) {
			_maxSpeedInMph(maxSpeedInMphWrap);
			Optional.ofNullable(maxSpeedInMphWrap.getO()).ifPresent(o -> {
				setMaxSpeedInMph(o);
			});
		}
		return (FishingBoat)this;
	}

	public static Double staticSearchMaxSpeedInMph(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMaxSpeedInMph(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMaxSpeedInMph(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchMaxSpeedInMph(siteRequest_, FishingBoat.staticSetMaxSpeedInMph(siteRequest_, o)).toString();
	}

	public BigDecimal sqlMaxSpeedInMph() {
		return maxSpeedInMph;
	}

	////////////////////
	// milesPerGallon //
	////////////////////


	/**	 The entity milesPerGallon
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal milesPerGallon;

	/**	<br> The entity milesPerGallon
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:milesPerGallon">Find the entity milesPerGallon in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _milesPerGallon(Wrap<BigDecimal> w);

	public BigDecimal getMilesPerGallon() {
		return milesPerGallon;
	}

	public void setMilesPerGallon(BigDecimal milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}
	@JsonIgnore
	public void setMilesPerGallon(String o) {
		this.milesPerGallon = FishingBoat.staticSetMilesPerGallon(siteRequest_, o);
	}
	public static BigDecimal staticSetMilesPerGallon(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setMilesPerGallon(Double o) {
		setMilesPerGallon(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMilesPerGallon(Integer o) {
		setMilesPerGallon(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setMilesPerGallon(Number o) {
		setMilesPerGallon(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishingBoat milesPerGallonInit() {
		Wrap<BigDecimal> milesPerGallonWrap = new Wrap<BigDecimal>().var("milesPerGallon");
		if(milesPerGallon == null) {
			_milesPerGallon(milesPerGallonWrap);
			Optional.ofNullable(milesPerGallonWrap.getO()).ifPresent(o -> {
				setMilesPerGallon(o);
			});
		}
		return (FishingBoat)this;
	}

	public static Double staticSearchMilesPerGallon(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrMilesPerGallon(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqMilesPerGallon(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchMilesPerGallon(siteRequest_, FishingBoat.staticSetMilesPerGallon(siteRequest_, o)).toString();
	}

	public BigDecimal sqlMilesPerGallon() {
		return milesPerGallon;
	}

	//////////////////
	// gallonsOfGas //
	//////////////////


	/**	 The entity gallonsOfGas
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal gallonsOfGas;

	/**	<br> The entity gallonsOfGas
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:gallonsOfGas">Find the entity gallonsOfGas in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _gallonsOfGas(Wrap<BigDecimal> w);

	public BigDecimal getGallonsOfGas() {
		return gallonsOfGas;
	}

	public void setGallonsOfGas(BigDecimal gallonsOfGas) {
		this.gallonsOfGas = gallonsOfGas;
	}
	@JsonIgnore
	public void setGallonsOfGas(String o) {
		this.gallonsOfGas = FishingBoat.staticSetGallonsOfGas(siteRequest_, o);
	}
	public static BigDecimal staticSetGallonsOfGas(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setGallonsOfGas(Double o) {
		setGallonsOfGas(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setGallonsOfGas(Integer o) {
		setGallonsOfGas(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setGallonsOfGas(Number o) {
		setGallonsOfGas(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected FishingBoat gallonsOfGasInit() {
		Wrap<BigDecimal> gallonsOfGasWrap = new Wrap<BigDecimal>().var("gallonsOfGas");
		if(gallonsOfGas == null) {
			_gallonsOfGas(gallonsOfGasWrap);
			Optional.ofNullable(gallonsOfGasWrap.getO()).ifPresent(o -> {
				setGallonsOfGas(o);
			});
		}
		return (FishingBoat)this;
	}

	public static Double staticSearchGallonsOfGas(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrGallonsOfGas(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqGallonsOfGas(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchGallonsOfGas(siteRequest_, FishingBoat.staticSetGallonsOfGas(siteRequest_, o)).toString();
	}

	public BigDecimal sqlGallonsOfGas() {
		return gallonsOfGas;
	}

	//////////////////////
	// areaServedColors //
	//////////////////////


	/**	 The entity areaServedColors
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedColors = new ArrayList<String>();

	/**	<br> The entity areaServedColors
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedColors(List<String> l);

	public List<String> getAreaServedColors() {
		return areaServedColors;
	}

	public void setAreaServedColors(List<String> areaServedColors) {
		this.areaServedColors = areaServedColors;
	}
	@JsonIgnore
	public void setAreaServedColors(String o) {
		String l = FishingBoat.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}
	public FishingBoat addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (FishingBoat)this;
	}
	public FishingBoat addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (FishingBoat)this;
	}
	@JsonIgnore
	public void setAreaServedColors(JsonArray objects) {
		areaServedColors.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedColors(o);
		}
	}
	protected FishingBoat areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (FishingBoat)this;
	}

	public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchAreaServedColors(siteRequest_, FishingBoat.staticSetAreaServedColors(siteRequest_, o)).toString();
	}

	//////////////////////
	// areaServedTitles //
	//////////////////////


	/**	 The entity areaServedTitles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedTitles = new ArrayList<String>();

	/**	<br> The entity areaServedTitles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedTitles(List<String> l);

	public List<String> getAreaServedTitles() {
		return areaServedTitles;
	}

	public void setAreaServedTitles(List<String> areaServedTitles) {
		this.areaServedTitles = areaServedTitles;
	}
	@JsonIgnore
	public void setAreaServedTitles(String o) {
		String l = FishingBoat.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}
	public FishingBoat addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (FishingBoat)this;
	}
	public FishingBoat addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (FishingBoat)this;
	}
	@JsonIgnore
	public void setAreaServedTitles(JsonArray objects) {
		areaServedTitles.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedTitles(o);
		}
	}
	protected FishingBoat areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (FishingBoat)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchAreaServedTitles(siteRequest_, FishingBoat.staticSetAreaServedTitles(siteRequest_, o)).toString();
	}

	/////////////////////
	// areaServedLinks //
	/////////////////////


	/**	 The entity areaServedLinks
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> areaServedLinks = new ArrayList<String>();

	/**	<br> The entity areaServedLinks
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _areaServedLinks(List<String> l);

	public List<String> getAreaServedLinks() {
		return areaServedLinks;
	}

	public void setAreaServedLinks(List<String> areaServedLinks) {
		this.areaServedLinks = areaServedLinks;
	}
	@JsonIgnore
	public void setAreaServedLinks(String o) {
		String l = FishingBoat.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}
	public FishingBoat addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (FishingBoat)this;
	}
	public FishingBoat addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (FishingBoat)this;
	}
	@JsonIgnore
	public void setAreaServedLinks(JsonArray objects) {
		areaServedLinks.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAreaServedLinks(o);
		}
	}
	protected FishingBoat areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (FishingBoat)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchAreaServedLinks(siteRequest_, FishingBoat.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	//////////
	// path //
	//////////


	/**	 The entity path
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPathDeserializer.class)
	@JsonSerialize(using = PgClientPathSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Path path;

	/**	<br> The entity path
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat&fq=entiteVar_enUS_indexed_string:path">Find the entity path in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _path(Wrap<Path> w);

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	@JsonIgnore
	public void setPath(String o) {
		this.path = FishingBoat.staticSetPath(siteRequest_, o);
	}
	public static Path staticSetPath(SiteRequest siteRequest_, String o) {
		if(o != null) {
			try {
				Path shape = null;
				if(StringUtils.isNotBlank(o)) {
					ObjectMapper objectMapper = new ObjectMapper();
					SimpleModule module = new SimpleModule();
					module.setDeserializerModifier(new BeanDeserializerModifier() {
						@Override
						public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
							if (beanDesc.getBeanClass() == Path.class) {
								return new PgClientPathDeserializer();
							}
							return deserializer;
						}
					});
					objectMapper.registerModule(module);
					shape = objectMapper.readValue(Json.encode(o), Path.class);
				}
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	@JsonIgnore
	public void setPath(JsonObject o) {
		this.path = FishingBoat.staticSetPath(siteRequest_, o);
	}
	public static Path staticSetPath(SiteRequest siteRequest_, JsonObject o) {
		if(o != null) {
			try {
				Path shape = new Path();
				o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(points -> {
					shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
				});
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	protected FishingBoat pathInit() {
		Wrap<Path> pathWrap = new Wrap<Path>().var("path");
		if(path == null) {
			_path(pathWrap);
			Optional.ofNullable(pathWrap.getO()).ifPresent(o -> {
				setPath(o);
			});
		}
		return (FishingBoat)this;
	}

	public static Path staticSearchPath(SiteRequest siteRequest_, Path o) {
		return o;
	}

	public static String staticSearchStrPath(SiteRequest siteRequest_, Path o) {
		JsonArray pointsArray = new JsonArray();
		o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
		return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
	}

	public static String staticSearchFqPath(SiteRequest siteRequest_, String o) {
		return FishingBoat.staticSearchPath(siteRequest_, FishingBoat.staticSetPath(siteRequest_, o)).toString();
	}

	public Path sqlPath() {
		return path;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FishingBoatGen<DEV>> promiseDeepFishingBoat(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFishingBoat();
	}

	public Future<FishingBoatGen<DEV>> promiseDeepFishingBoat() {
		Promise<FishingBoatGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFishingBoat(promise2);
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

	public Future<Void> promiseFishingBoat(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				timeZoneInit();
				fishingDockIdInit();
				departureDateInit();
				arrivalDateInit();
				avgSpeedInMphInit();
				maxSpeedInMphInit();
				milesPerGallonInit();
				gallonsOfGasInit();
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				pathInit();
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

	@Override public Future<? extends FishingBoatGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFishingBoat(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFishingBoat(SiteRequest siteRequest_) {
			super.siteRequestMapModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFishingBoat(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFishingBoat(v);
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
	public Object obtainFishingBoat(String var) {
		FishingBoat oFishingBoat = (FishingBoat)this;
		switch(var) {
			case "timeZone":
				return oFishingBoat.timeZone;
			case "fishingDockId":
				return oFishingBoat.fishingDockId;
			case "departureDate":
				return oFishingBoat.departureDate;
			case "arrivalDate":
				return oFishingBoat.arrivalDate;
			case "avgSpeedInMph":
				return oFishingBoat.avgSpeedInMph;
			case "maxSpeedInMph":
				return oFishingBoat.maxSpeedInMph;
			case "milesPerGallon":
				return oFishingBoat.milesPerGallon;
			case "gallonsOfGas":
				return oFishingBoat.gallonsOfGas;
			case "areaServedColors":
				return oFishingBoat.areaServedColors;
			case "areaServedTitles":
				return oFishingBoat.areaServedTitles;
			case "areaServedLinks":
				return oFishingBoat.areaServedLinks;
			case "path":
				return oFishingBoat.path;
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
				o = relateFishingBoat(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFishingBoat(String var, Object val) {
		FishingBoat oFishingBoat = (FishingBoat)this;
		switch(var) {
			case "timeZone":
				if(oFishingBoat.getTimeZone() == null)
					oFishingBoat.setTimeZone(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
				if(!saves.contains("timeZone"))
					saves.add("timeZone");
				return val;
			case "fishingDockId":
				if(oFishingBoat.getFishingDockId() == null)
					oFishingBoat.setFishingDockId(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
				if(!saves.contains("fishingDockId"))
					saves.add("fishingDockId");
				return val;
			default:
				return super.relateMapModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishingBoat o) {
		return staticSetFishingBoat(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetFishingBoat(String entityVar, SiteRequest siteRequest_, String v, FishingBoat o) {
		switch(entityVar) {
		case "timeZone":
			return FishingBoat.staticSetTimeZone(siteRequest_, v);
		case "fishingDockId":
			return FishingBoat.staticSetFishingDockId(siteRequest_, v);
		case "departureDate":
			return FishingBoat.staticSetDepartureDate(siteRequest_, v, Optional.ofNullable(o.getTimeZone()).map(zoneId -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
		case "arrivalDate":
			return FishingBoat.staticSetArrivalDate(siteRequest_, v, Optional.ofNullable(o.getTimeZone()).map(zoneId -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
		case "avgSpeedInMph":
			return FishingBoat.staticSetAvgSpeedInMph(siteRequest_, v);
		case "maxSpeedInMph":
			return FishingBoat.staticSetMaxSpeedInMph(siteRequest_, v);
		case "milesPerGallon":
			return FishingBoat.staticSetMilesPerGallon(siteRequest_, v);
		case "gallonsOfGas":
			return FishingBoat.staticSetGallonsOfGas(siteRequest_, v);
		case "areaServedColors":
			return FishingBoat.staticSetAreaServedColors(siteRequest_, v);
		case "areaServedTitles":
			return FishingBoat.staticSetAreaServedTitles(siteRequest_, v);
		case "areaServedLinks":
			return FishingBoat.staticSetAreaServedLinks(siteRequest_, v);
		case "path":
			return FishingBoat.staticSetPath(siteRequest_, v);
			default:
				return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFishingBoat(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFishingBoat(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "timeZone":
			return FishingBoat.staticSearchTimeZone(siteRequest_, (String)o);
		case "fishingDockId":
			return FishingBoat.staticSearchFishingDockId(siteRequest_, (String)o);
		case "departureDate":
			return FishingBoat.staticSearchDepartureDate(siteRequest_, (ZonedDateTime)o);
		case "arrivalDate":
			return FishingBoat.staticSearchArrivalDate(siteRequest_, (ZonedDateTime)o);
		case "avgSpeedInMph":
			return FishingBoat.staticSearchAvgSpeedInMph(siteRequest_, (BigDecimal)o);
		case "maxSpeedInMph":
			return FishingBoat.staticSearchMaxSpeedInMph(siteRequest_, (BigDecimal)o);
		case "milesPerGallon":
			return FishingBoat.staticSearchMilesPerGallon(siteRequest_, (BigDecimal)o);
		case "gallonsOfGas":
			return FishingBoat.staticSearchGallonsOfGas(siteRequest_, (BigDecimal)o);
		case "areaServedColors":
			return FishingBoat.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return FishingBoat.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return FishingBoat.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "path":
			return FishingBoat.staticSearchPath(siteRequest_, (Path)o);
			default:
				return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFishingBoat(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFishingBoat(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "timeZone":
			return FishingBoat.staticSearchStrTimeZone(siteRequest_, (String)o);
		case "fishingDockId":
			return FishingBoat.staticSearchStrFishingDockId(siteRequest_, (String)o);
		case "departureDate":
			return FishingBoat.staticSearchStrDepartureDate(siteRequest_, (String)o);
		case "arrivalDate":
			return FishingBoat.staticSearchStrArrivalDate(siteRequest_, (String)o);
		case "avgSpeedInMph":
			return FishingBoat.staticSearchStrAvgSpeedInMph(siteRequest_, (Double)o);
		case "maxSpeedInMph":
			return FishingBoat.staticSearchStrMaxSpeedInMph(siteRequest_, (Double)o);
		case "milesPerGallon":
			return FishingBoat.staticSearchStrMilesPerGallon(siteRequest_, (Double)o);
		case "gallonsOfGas":
			return FishingBoat.staticSearchStrGallonsOfGas(siteRequest_, (Double)o);
		case "areaServedColors":
			return FishingBoat.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return FishingBoat.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return FishingBoat.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "path":
			return FishingBoat.staticSearchStrPath(siteRequest_, (Path)o);
			default:
				return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFishingBoat(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFishingBoat(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "timeZone":
			return FishingBoat.staticSearchFqTimeZone(siteRequest_, o);
		case "fishingDockId":
			return FishingBoat.staticSearchFqFishingDockId(siteRequest_, o);
		case "departureDate":
			return FishingBoat.staticSearchFqDepartureDate(siteRequest_, o);
		case "arrivalDate":
			return FishingBoat.staticSearchFqArrivalDate(siteRequest_, o);
		case "avgSpeedInMph":
			return FishingBoat.staticSearchFqAvgSpeedInMph(siteRequest_, o);
		case "maxSpeedInMph":
			return FishingBoat.staticSearchFqMaxSpeedInMph(siteRequest_, o);
		case "milesPerGallon":
			return FishingBoat.staticSearchFqMilesPerGallon(siteRequest_, o);
		case "gallonsOfGas":
			return FishingBoat.staticSearchFqGallonsOfGas(siteRequest_, o);
		case "areaServedColors":
			return FishingBoat.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return FishingBoat.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return FishingBoat.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "path":
			return FishingBoat.staticSearchFqPath(siteRequest_, o);
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
					o = persistFishingBoat(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFishingBoat(String var, Object val) {
		String varLower = var.toLowerCase();
			if("timezone".equals(varLower)) {
				if(val instanceof String) {
					setTimeZone((String)val);
				}
				saves.add("timeZone");
				return val;
			} else if("fishingdockid".equals(varLower)) {
				if(val instanceof String) {
					setFishingDockId((String)val);
				}
				saves.add("fishingDockId");
				return val;
			} else if("departuredate".equals(varLower)) {
				if(val instanceof String) {
					setDepartureDate((String)val);
				} else if(val instanceof OffsetDateTime) {
					setDepartureDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				}
				saves.add("departureDate");
				return val;
			} else if("arrivaldate".equals(varLower)) {
				if(val instanceof String) {
					setArrivalDate((String)val);
				} else if(val instanceof OffsetDateTime) {
					setArrivalDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				}
				saves.add("arrivalDate");
				return val;
			} else if("avgspeedinmph".equals(varLower)) {
				if(val instanceof String) {
					setAvgSpeedInMph((String)val);
				} else if(val instanceof Number) {
					setAvgSpeedInMph(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("avgSpeedInMph");
				return val;
			} else if("maxspeedinmph".equals(varLower)) {
				if(val instanceof String) {
					setMaxSpeedInMph((String)val);
				} else if(val instanceof Number) {
					setMaxSpeedInMph(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("maxSpeedInMph");
				return val;
			} else if("milespergallon".equals(varLower)) {
				if(val instanceof String) {
					setMilesPerGallon((String)val);
				} else if(val instanceof Number) {
					setMilesPerGallon(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("milesPerGallon");
				return val;
			} else if("gallonsofgas".equals(varLower)) {
				if(val instanceof String) {
					setGallonsOfGas((String)val);
				} else if(val instanceof Number) {
					setGallonsOfGas(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("gallonsOfGas");
				return val;
			} else if("path".equals(varLower)) {
				if(val instanceof Path) {
					setPath((Path)val);
				} else {
					setPath(val == null ? null : val.toString());
				}
				saves.add("path");
				return val;
		} else {
			return super.persistMapModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateFishingBoat(doc);
	}
	public void populateFishingBoat(SolrResponse.Doc doc) {
		FishingBoat oFishingBoat = (FishingBoat)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			String timeZone = (String)doc.get("timeZone_docvalues_string");
			if(timeZone != null)
				oFishingBoat.setTimeZone(timeZone);

			String fishingDockId = (String)doc.get("fishingDockId_docvalues_string");
			if(fishingDockId != null)
				oFishingBoat.setFishingDockId(fishingDockId);

			if(saves.contains("departureDate")) {
				String departureDate = (String)doc.get("departureDate_docvalues_date");
				if(departureDate != null)
					oFishingBoat.setDepartureDate(departureDate);
			}

			if(saves.contains("arrivalDate")) {
				String arrivalDate = (String)doc.get("arrivalDate_docvalues_date");
				if(arrivalDate != null)
					oFishingBoat.setArrivalDate(arrivalDate);
			}

			if(saves.contains("avgSpeedInMph")) {
				Double avgSpeedInMph = (Double)doc.get("avgSpeedInMph_docvalues_double");
				if(avgSpeedInMph != null)
					oFishingBoat.setAvgSpeedInMph(avgSpeedInMph);
			}

			if(saves.contains("maxSpeedInMph")) {
				Double maxSpeedInMph = (Double)doc.get("maxSpeedInMph_docvalues_double");
				if(maxSpeedInMph != null)
					oFishingBoat.setMaxSpeedInMph(maxSpeedInMph);
			}

			if(saves.contains("milesPerGallon")) {
				Double milesPerGallon = (Double)doc.get("milesPerGallon_docvalues_double");
				if(milesPerGallon != null)
					oFishingBoat.setMilesPerGallon(milesPerGallon);
			}

			if(saves.contains("gallonsOfGas")) {
				Double gallonsOfGas = (Double)doc.get("gallonsOfGas_docvalues_double");
				if(gallonsOfGas != null)
					oFishingBoat.setGallonsOfGas(gallonsOfGas);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null) {
					areaServedColors.stream().forEach( v -> {
						oFishingBoat.areaServedColors.add(FishingBoat.staticSetAreaServedColors(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null) {
					areaServedTitles.stream().forEach( v -> {
						oFishingBoat.areaServedTitles.add(FishingBoat.staticSetAreaServedTitles(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null) {
					areaServedLinks.stream().forEach( v -> {
						oFishingBoat.areaServedLinks.add(FishingBoat.staticSetAreaServedLinks(siteRequest_, v));
					});
				}
			}

			if(saves.contains("path")) {
				Path path = (Path)doc.get("path_docvalues_location");
				if(path != null)
					oFishingBoat.setPath(path);
			}
		}

		super.populateMapModel(doc);
	}

	public void indexFishingBoat(JsonObject doc) {
		if(timeZone != null) {
			doc.put("timeZone_docvalues_string", timeZone);
		}
		if(fishingDockId != null) {
			doc.put("fishingDockId_docvalues_string", fishingDockId);
		}
		if(departureDate != null) {
			doc.put("departureDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(departureDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(arrivalDate != null) {
			doc.put("arrivalDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(arrivalDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(avgSpeedInMph != null) {
			doc.put("avgSpeedInMph_docvalues_double", avgSpeedInMph.doubleValue());
		}
		if(maxSpeedInMph != null) {
			doc.put("maxSpeedInMph_docvalues_double", maxSpeedInMph.doubleValue());
		}
		if(milesPerGallon != null) {
			doc.put("milesPerGallon_docvalues_double", milesPerGallon.doubleValue());
		}
		if(gallonsOfGas != null) {
			doc.put("gallonsOfGas_docvalues_double", gallonsOfGas.doubleValue());
		}
		if(areaServedColors != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedColors_indexedstored_strings", l);
			for(String o : areaServedColors) {
				l.add(FishingBoat.staticSearchAreaServedColors(siteRequest_, o));
			}
		}
		if(areaServedTitles != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedTitles_indexedstored_strings", l);
			for(String o : areaServedTitles) {
				l.add(FishingBoat.staticSearchAreaServedTitles(siteRequest_, o));
			}
		}
		if(areaServedLinks != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedLinks_indexedstored_strings", l);
			for(String o : areaServedLinks) {
				l.add(FishingBoat.staticSearchAreaServedLinks(siteRequest_, o));
			}
		}
		if(path != null) {
			JsonArray pointsArray = new JsonArray();
			path.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
			doc.put("path_docvalues_location", new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString());
		}
		super.indexMapModel(doc);

	}

	public static String varStoredFishingBoat(String entityVar) {
		switch(entityVar) {
			case "timeZone":
				return "timeZone_docvalues_string";
			case "fishingDockId":
				return "fishingDockId_docvalues_string";
			case "departureDate":
				return "departureDate_docvalues_date";
			case "arrivalDate":
				return "arrivalDate_docvalues_date";
			case "avgSpeedInMph":
				return "avgSpeedInMph_docvalues_double";
			case "maxSpeedInMph":
				return "maxSpeedInMph_docvalues_double";
			case "milesPerGallon":
				return "milesPerGallon_docvalues_double";
			case "gallonsOfGas":
				return "gallonsOfGas_docvalues_double";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "path":
				return "path_docvalues_location";
			default:
				return MapModel.varStoredMapModel(entityVar);
		}
	}

	public static String varIndexedFishingBoat(String entityVar) {
		switch(entityVar) {
			case "timeZone":
				return "timeZone_docvalues_string";
			case "fishingDockId":
				return "fishingDockId_docvalues_string";
			case "departureDate":
				return "departureDate_docvalues_date";
			case "arrivalDate":
				return "arrivalDate_docvalues_date";
			case "avgSpeedInMph":
				return "avgSpeedInMph_docvalues_double";
			case "maxSpeedInMph":
				return "maxSpeedInMph_docvalues_double";
			case "milesPerGallon":
				return "milesPerGallon_docvalues_double";
			case "gallonsOfGas":
				return "gallonsOfGas_docvalues_double";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "path":
				return "path_docvalues_location";
			default:
				return MapModel.varIndexedMapModel(entityVar);
		}
	}

	public static String searchVarFishingBoat(String searchVar) {
		switch(searchVar) {
			case "timeZone_docvalues_string":
				return "timeZone";
			case "fishingDockId_docvalues_string":
				return "fishingDockId";
			case "departureDate_docvalues_date":
				return "departureDate";
			case "arrivalDate_docvalues_date":
				return "arrivalDate";
			case "avgSpeedInMph_docvalues_double":
				return "avgSpeedInMph";
			case "maxSpeedInMph_docvalues_double":
				return "maxSpeedInMph";
			case "milesPerGallon_docvalues_double":
				return "milesPerGallon";
			case "gallonsOfGas_docvalues_double":
				return "gallonsOfGas";
			case "areaServedColors_indexedstored_strings":
				return "areaServedColors";
			case "areaServedTitles_indexedstored_strings":
				return "areaServedTitles";
			case "areaServedLinks_indexedstored_strings":
				return "areaServedLinks";
			case "path_docvalues_location":
				return "path";
			default:
				return MapModel.searchVarMapModel(searchVar);
		}
	}

	public static String varSearchFishingBoat(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSearchMapModel(entityVar);
		}
	}

	public static String varSuggestedFishingBoat(String entityVar) {
		switch(entityVar) {
			default:
				return MapModel.varSuggestedMapModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFishingBoat(doc);
	}
	public void storeFishingBoat(SolrResponse.Doc doc) {
		FishingBoat oFishingBoat = (FishingBoat)this;
		SiteRequest siteRequest = oFishingBoat.getSiteRequest_();

		oFishingBoat.setTimeZone(Optional.ofNullable(doc.get("timeZone_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setFishingDockId(Optional.ofNullable(doc.get("fishingDockId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setDepartureDate(Optional.ofNullable(doc.get("departureDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setArrivalDate(Optional.ofNullable(doc.get("arrivalDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setAvgSpeedInMph(Optional.ofNullable(doc.get("avgSpeedInMph_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setMaxSpeedInMph(Optional.ofNullable(doc.get("maxSpeedInMph_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setMilesPerGallon(Optional.ofNullable(doc.get("milesPerGallon_docvalues_double")).map(v -> v.toString()).orElse(null));
		oFishingBoat.setGallonsOfGas(Optional.ofNullable(doc.get("gallonsOfGas_docvalues_double")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFishingBoat.addAreaServedColors(FishingBoat.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFishingBoat.addAreaServedTitles(FishingBoat.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFishingBoat.addAreaServedLinks(FishingBoat.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		oFishingBoat.setPath(Optional.ofNullable(doc.get("path_docvalues_location")).map(v -> v.toString()).orElse(null));

		super.storeMapModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFishingBoat() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof FishingBoat) {
			FishingBoat original = (FishingBoat)o;
			if(!Objects.equals(timeZone, original.getTimeZone()))
				apiRequest.addVars("timeZone");
			if(!Objects.equals(fishingDockId, original.getFishingDockId()))
				apiRequest.addVars("fishingDockId");
			if(!Objects.equals(departureDate, original.getDepartureDate()))
				apiRequest.addVars("departureDate");
			if(!Objects.equals(arrivalDate, original.getArrivalDate()))
				apiRequest.addVars("arrivalDate");
			if(!Objects.equals(avgSpeedInMph, original.getAvgSpeedInMph()) && avgSpeedInMph != null && original.getAvgSpeedInMph() != null && avgSpeedInMph.compareTo(original.getAvgSpeedInMph()) != 0)
				apiRequest.addVars("avgSpeedInMph");
			if(!Objects.equals(maxSpeedInMph, original.getMaxSpeedInMph()) && maxSpeedInMph != null && original.getMaxSpeedInMph() != null && maxSpeedInMph.compareTo(original.getMaxSpeedInMph()) != 0)
				apiRequest.addVars("maxSpeedInMph");
			if(!Objects.equals(milesPerGallon, original.getMilesPerGallon()) && milesPerGallon != null && original.getMilesPerGallon() != null && milesPerGallon.compareTo(original.getMilesPerGallon()) != 0)
				apiRequest.addVars("milesPerGallon");
			if(!Objects.equals(gallonsOfGas, original.getGallonsOfGas()) && gallonsOfGas != null && original.getGallonsOfGas() != null && gallonsOfGas.compareTo(original.getGallonsOfGas()) != 0)
				apiRequest.addVars("gallonsOfGas");
			if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
				apiRequest.addVars("areaServedColors");
			if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
				apiRequest.addVars("areaServedTitles");
			if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
				apiRequest.addVars("areaServedLinks");
			if(!Objects.equals(path, original.getPath()))
				apiRequest.addVars("path");
			super.apiRequestMapModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(timeZone).map(v -> "timeZone: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(fishingDockId).map(v -> "fishingDockId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(departureDate).map(v -> "departureDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(arrivalDate).map(v -> "arrivalDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(avgSpeedInMph).map(v -> "avgSpeedInMph: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(maxSpeedInMph).map(v -> "maxSpeedInMph: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(milesPerGallon).map(v -> "milesPerGallon: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(gallonsOfGas).map(v -> "gallonsOfGas: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(path).map(v -> "path: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "FishingBoat";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishingboat.FishingBoat";
	public static final String CLASS_AUTH_RESOURCE = "FISHINGBOAT";
	public static final String CLASS_API_ADDRESS_FishingBoat = "smart-aquaculture-enUS-FishingBoat";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_FishingBoat;
	}
	public static final String VAR_timeZone = "timeZone";
	public static final String VAR_fishingDockId = "fishingDockId";
	public static final String VAR_departureDate = "departureDate";
	public static final String VAR_arrivalDate = "arrivalDate";
	public static final String VAR_avgSpeedInMph = "avgSpeedInMph";
	public static final String VAR_maxSpeedInMph = "maxSpeedInMph";
	public static final String VAR_milesPerGallon = "milesPerGallon";
	public static final String VAR_gallonsOfGas = "gallonsOfGas";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_path = "path";

	public static List<String> varsQForClass() {
		return FishingBoat.varsQFishingBoat(new ArrayList<String>());
	}
	public static List<String> varsQFishingBoat(List<String> vars) {
		MapModel.varsQMapModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return FishingBoat.varsFqFishingBoat(new ArrayList<String>());
	}
	public static List<String> varsFqFishingBoat(List<String> vars) {
		vars.add(VAR_timeZone);
		vars.add(VAR_fishingDockId);
		vars.add(VAR_departureDate);
		vars.add(VAR_arrivalDate);
		vars.add(VAR_avgSpeedInMph);
		vars.add(VAR_maxSpeedInMph);
		vars.add(VAR_milesPerGallon);
		vars.add(VAR_gallonsOfGas);
		vars.add(VAR_path);
		MapModel.varsFqMapModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return FishingBoat.varsRangeFishingBoat(new ArrayList<String>());
	}
	public static List<String> varsRangeFishingBoat(List<String> vars) {
		vars.add(VAR_departureDate);
		vars.add(VAR_arrivalDate);
		vars.add(VAR_avgSpeedInMph);
		vars.add(VAR_maxSpeedInMph);
		vars.add(VAR_milesPerGallon);
		vars.add(VAR_gallonsOfGas);
		MapModel.varsRangeMapModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_timeZone = "time zone";
	public static final String DISPLAY_NAME_fishingDockId = "fishing dock";
	public static final String DISPLAY_NAME_departureDate = "departure date";
	public static final String DISPLAY_NAME_arrivalDate = "arrival date";
	public static final String DISPLAY_NAME_avgSpeedInMph = "average speed (MPH)";
	public static final String DISPLAY_NAME_maxSpeedInMph = "max speed (MPH)";
	public static final String DISPLAY_NAME_milesPerGallon = "miles per gallon (MPG)";
	public static final String DISPLAY_NAME_gallonsOfGas = "gallons of gas";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_path = "path";

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
		return FishingBoat.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/fishing-boat/%s";
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
		return FishingBoat.displayNameFishingBoat(var);
	}
	public static String displayNameFishingBoat(String var) {
		switch(var) {
		case VAR_timeZone:
			return DISPLAY_NAME_timeZone;
		case VAR_fishingDockId:
			return DISPLAY_NAME_fishingDockId;
		case VAR_departureDate:
			return DISPLAY_NAME_departureDate;
		case VAR_arrivalDate:
			return DISPLAY_NAME_arrivalDate;
		case VAR_avgSpeedInMph:
			return DISPLAY_NAME_avgSpeedInMph;
		case VAR_maxSpeedInMph:
			return DISPLAY_NAME_maxSpeedInMph;
		case VAR_milesPerGallon:
			return DISPLAY_NAME_milesPerGallon;
		case VAR_gallonsOfGas:
			return DISPLAY_NAME_gallonsOfGas;
		case VAR_areaServedColors:
			return DISPLAY_NAME_areaServedColors;
		case VAR_areaServedTitles:
			return DISPLAY_NAME_areaServedTitles;
		case VAR_areaServedLinks:
			return DISPLAY_NAME_areaServedLinks;
		case VAR_path:
			return DISPLAY_NAME_path;
		default:
			return MapModel.displayNameMapModel(var);
		}
	}

	public static String descriptionFishingBoat(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_timeZone:
			return "The local time zone the fishing trip departure and arrival dates are based on. ";
		case VAR_fishingDockId:
			return "The primary fishing dock of this boat. ";
		case VAR_departureDate:
			return "The date and time the fishing trip departed. ";
		case VAR_arrivalDate:
			return "The date and time the fishing trip returned. ";
		case VAR_avgSpeedInMph:
			return "The average speed of the boat in miles per hour. ";
		case VAR_maxSpeedInMph:
			return "The max speed of the boat in miles per hour. ";
		case VAR_milesPerGallon:
			return "The miles per gallon of the boat. ";
		case VAR_gallonsOfGas:
			return "The number of gallons of gas in the boat. ";
		case VAR_areaServedColors:
			return "The colors of each areaServed Paths. ";
		case VAR_areaServedTitles:
			return "The titles of each areaServed Paths. ";
		case VAR_areaServedLinks:
			return "The links of each areaServed Paths. ";
		case VAR_path:
			return "The geographic area where the boat goes fishing. ";
			default:
				return MapModel.descriptionMapModel(var);
		}
	}

	public static String classSimpleNameFishingBoat(String var) {
		switch(var) {
		case VAR_timeZone:
			return "String";
		case VAR_fishingDockId:
			return "String";
		case VAR_departureDate:
			return "ZonedDateTime";
		case VAR_arrivalDate:
			return "ZonedDateTime";
		case VAR_avgSpeedInMph:
			return "BigDecimal";
		case VAR_maxSpeedInMph:
			return "BigDecimal";
		case VAR_milesPerGallon:
			return "BigDecimal";
		case VAR_gallonsOfGas:
			return "BigDecimal";
		case VAR_areaServedColors:
			return "List";
		case VAR_areaServedTitles:
			return "List";
		case VAR_areaServedLinks:
			return "List";
		case VAR_path:
			return "Path";
			default:
				return MapModel.classSimpleNameMapModel(var);
		}
	}

	public static Integer htmColumnFishingBoat(String var) {
		switch(var) {
		case VAR_departureDate:
			return 1;
		case VAR_arrivalDate:
			return 2;
		case VAR_avgSpeedInMph:
			return 2;
		case VAR_maxSpeedInMph:
			return 2;
		case VAR_milesPerGallon:
			return 2;
		case VAR_gallonsOfGas:
			return 2;
			default:
				return MapModel.htmColumnMapModel(var);
		}
	}

	public static Integer htmRowFishingBoat(String var) {
		switch(var) {
		case VAR_timeZone:
			return 3;
		case VAR_fishingDockId:
			return 3;
		case VAR_departureDate:
			return 3;
		case VAR_arrivalDate:
			return 3;
		case VAR_avgSpeedInMph:
			return 3;
		case VAR_maxSpeedInMph:
			return 3;
		case VAR_milesPerGallon:
			return 3;
		case VAR_gallonsOfGas:
			return 3;
		case VAR_path:
			return 4;
			default:
				return MapModel.htmRowMapModel(var);
		}
	}

	public static Integer htmCellFishingBoat(String var) {
		switch(var) {
		case VAR_timeZone:
			return 0;
		case VAR_fishingDockId:
			return 0;
		case VAR_departureDate:
			return 1;
		case VAR_arrivalDate:
			return 2;
		case VAR_avgSpeedInMph:
			return 2;
		case VAR_maxSpeedInMph:
			return 2;
		case VAR_milesPerGallon:
			return 2;
		case VAR_gallonsOfGas:
			return 2;
		case VAR_path:
			return 1;
			default:
				return MapModel.htmCellMapModel(var);
		}
	}

	public static Integer lengthMinFishingBoat(String var) {
		switch(var) {
			default:
				return MapModel.lengthMinMapModel(var);
		}
	}

	public static Integer lengthMaxFishingBoat(String var) {
		switch(var) {
			default:
				return MapModel.lengthMaxMapModel(var);
		}
	}

	public static Integer maxFishingBoat(String var) {
		switch(var) {
			default:
				return MapModel.maxMapModel(var);
		}
	}

	public static Integer minFishingBoat(String var) {
		switch(var) {
			default:
				return MapModel.minMapModel(var);
		}
	}
}
