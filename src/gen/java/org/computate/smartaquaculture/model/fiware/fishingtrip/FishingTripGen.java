package org.computate.smartaquaculture.model.fiware.fishingtrip;

import org.computate.smartaquaculture.request.SiteRequest;
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
import java.lang.Long;
import java.lang.String;
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishingTripGen into the class FishingTrip. 
 * </li>
 * <h3>About the FishingTrip class and it's generated class FishingTripGen&lt;BaseModel&gt;: </h3>extends FishingTripGen
 * <p>
 * This Java class extends a generated Java class FishingTripGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip">Find the class FishingTrip in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishingTripGen<BaseModel>
 * <p>This <code>class FishingTrip extends FishingTripGen&lt;BaseModel&gt;</code>, which means it extends a newly generated FishingTripGen. 
 * The generated <code>class FishingTripGen extends BaseModel</code> which means that FishingTrip extends FishingTripGen which extends BaseModel. 
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
 * <p>This class contains a comment <b>"ApiTag: fishing trips"</b>, which groups all of the OpenAPIs for FishingTrip objects under the tag "fishing trips". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/fishing-trip</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/fishing-trip"</b>, which defines the base API URI for FishingTrip objects as "/en-us/api/fishing-trip" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishingTrip class will inherit the helpful inherited class comments from the super class FishingTripGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the FishingTrip API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTripPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTripPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishingTrip Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a fishing trip</h2>
 * <p>This class contains a comment <b>"AName.enUS: a fishing trip"</b>, which identifies the language context to describe a FishingTrip as "a fishing trip". 
 * </p>
 * <p>
 * Delete the class FishingTrip in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishingtrip in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FishingTripGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(FishingTrip.class);

	public static final String Description_enUS = "A fishing trip";
	public static final String AName_enUS = "a fishing trip";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this fishing trip";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the fishing trip";
	public static final String SingularName_enUS = "fishing trip";
	public static final String PluralName_enUS = "fishing trips";
	public static final String NameActual_enUS = "current fishing trip";
	public static final String AllName_enUS = "all fishing trips";
	public static final String SearchAllNameBy_enUS = "search fishing trips by ";
	public static final String SearchAllName_enUS = "search fishing trips";
	public static final String Title_enUS = "fishing trips";
	public static final String ThePluralName_enUS = "the fishing trips";
	public static final String NoNameFound_enUS = "no fishing trip found";
	public static final String ApiUri_enUS = "/en-us/api/fishing-trip";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/fishing-trip";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/fishing-trip/{pk}";
	public static final String OfName_enUS = "of fishing trip";
	public static final String ANameAdjective_enUS = "a fishing trip";
	public static final String NameAdjectiveSingular_enUS = "fishing trip";
	public static final String NameAdjectivePlural_enUS = "fishing trips";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/fishing-trip";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/fishing-trip";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/fishing-trip/{pk}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/fishing-trip/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/fishing-trip";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/fishing-trip";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/fishing-trip";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/fishing-trip";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/fishing-trip/{pk}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/fishing-trip/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/fishing-trip-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/fishing-trip-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/fishing-trip";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/fishing-trip";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/fishing-trip";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/fishing-trip/{pk}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/fishing-trip/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/fishing-trip/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/fishing-trip";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/fishing-trip";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/fishing-trip";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-fish-cooked\"></i>";
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&fq=entiteVar_enUS_indexed_string:timeZone">Find the entity timeZone in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _timeZone(Wrap<String> w);

	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String o) {
		this.timeZone = FishingTrip.staticSetTimeZone(siteRequest_, o);
	}
	public static String staticSetTimeZone(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishingTrip timeZoneInit() {
		Wrap<String> timeZoneWrap = new Wrap<String>().var("timeZone");
		if(timeZone == null) {
			_timeZone(timeZoneWrap);
			Optional.ofNullable(timeZoneWrap.getO()).ifPresent(o -> {
				setTimeZone(o);
			});
		}
		return (FishingTrip)this;
	}

	public static String staticSearchTimeZone(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTimeZone(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTimeZone(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchTimeZone(siteRequest_, FishingTrip.staticSetTimeZone(siteRequest_, o)).toString();
	}

	public String sqlTimeZone() {
		return timeZone;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&fq=entiteVar_enUS_indexed_string:departureDate">Find the entity departureDate in Solr</a>
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
		this.departureDate = FishingTrip.staticSetDepartureDate(siteRequest_, o);
	}
	@JsonIgnore
	public void setDepartureDate(Date o) {
		this.departureDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	public static ZonedDateTime staticSetDepartureDate(SiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected FishingTrip departureDateInit() {
		Wrap<ZonedDateTime> departureDateWrap = new Wrap<ZonedDateTime>().var("departureDate");
		if(departureDate == null) {
			_departureDate(departureDateWrap);
			Optional.ofNullable(departureDateWrap.getO()).ifPresent(o -> {
				setDepartureDate(o);
			});
		}
		return (FishingTrip)this;
	}

	public static String staticSearchDepartureDate(SiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrDepartureDate(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchDepartureDate(siteRequest_, FishingTrip.staticSetDepartureDate(siteRequest_, o));
	}

	public static String staticSearchFqDepartureDate(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchDepartureDate(siteRequest_, FishingTrip.staticSetDepartureDate(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&fq=entiteVar_enUS_indexed_string:arrivalDate">Find the entity arrivalDate in Solr</a>
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
		this.arrivalDate = FishingTrip.staticSetArrivalDate(siteRequest_, o);
	}
	@JsonIgnore
	public void setArrivalDate(Date o) {
		this.arrivalDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	public static ZonedDateTime staticSetArrivalDate(SiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected FishingTrip arrivalDateInit() {
		Wrap<ZonedDateTime> arrivalDateWrap = new Wrap<ZonedDateTime>().var("arrivalDate");
		if(arrivalDate == null) {
			_arrivalDate(arrivalDateWrap);
			Optional.ofNullable(arrivalDateWrap.getO()).ifPresent(o -> {
				setArrivalDate(o);
			});
		}
		return (FishingTrip)this;
	}

	public static String staticSearchArrivalDate(SiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
	}

	public static String staticSearchStrArrivalDate(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchArrivalDate(siteRequest_, FishingTrip.staticSetArrivalDate(siteRequest_, o));
	}

	public static String staticSearchFqArrivalDate(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchArrivalDate(siteRequest_, FishingTrip.staticSetArrivalDate(siteRequest_, o)).toString();
	}

	public OffsetDateTime sqlArrivalDate() {
		return arrivalDate == null ? null : arrivalDate.toOffsetDateTime();
	}

	//////////
	// name //
	//////////


	/**	 The entity name
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String name;

	/**	<br> The entity name
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = FishingTrip.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishingTrip nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (FishingTrip)this;
	}

	public static String staticSearchName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchName(siteRequest_, FishingTrip.staticSetName(siteRequest_, o)).toString();
	}

	public String sqlName() {
		return name;
	}

	/////////////////
	// description //
	/////////////////


	/**	 The entity description
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String description;

	/**	<br> The entity description
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = FishingTrip.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected FishingTrip descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (FishingTrip)this;
	}

	public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
		return FishingTrip.staticSearchDescription(siteRequest_, FishingTrip.staticSetDescription(siteRequest_, o)).toString();
	}

	public String sqlDescription() {
		return description;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FishingTripGen<DEV>> promiseDeepFishingTrip(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFishingTrip();
	}

	public Future<FishingTripGen<DEV>> promiseDeepFishingTrip() {
		Promise<FishingTripGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFishingTrip(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete(this);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseFishingTrip(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				timeZoneInit();
				departureDateInit();
				arrivalDateInit();
				nameInit();
				descriptionInit();
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

	@Override public Future<? extends FishingTripGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFishingTrip(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFishingTrip(SiteRequest siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFishingTrip(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFishingTrip(v);
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
	public Object obtainFishingTrip(String var) {
		FishingTrip oFishingTrip = (FishingTrip)this;
		switch(var) {
			case "timeZone":
				return oFishingTrip.timeZone;
			case "departureDate":
				return oFishingTrip.departureDate;
			case "arrivalDate":
				return oFishingTrip.arrivalDate;
			case "name":
				return oFishingTrip.name;
			case "description":
				return oFishingTrip.description;
			default:
				return super.obtainBaseModel(var);
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
				o = relateFishingTrip(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFishingTrip(String var, Object val) {
		FishingTrip oFishingTrip = (FishingTrip)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSetFishingTrip(entityVar,  siteRequest_, o);
	}
	public static Object staticSetFishingTrip(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "timeZone":
			return FishingTrip.staticSetTimeZone(siteRequest_, o);
		case "departureDate":
			return FishingTrip.staticSetDepartureDate(siteRequest_, o);
		case "arrivalDate":
			return FishingTrip.staticSetArrivalDate(siteRequest_, o);
		case "name":
			return FishingTrip.staticSetName(siteRequest_, o);
		case "description":
			return FishingTrip.staticSetDescription(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFishingTrip(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFishingTrip(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "timeZone":
			return FishingTrip.staticSearchTimeZone(siteRequest_, (String)o);
		case "departureDate":
			return FishingTrip.staticSearchDepartureDate(siteRequest_, (ZonedDateTime)o);
		case "arrivalDate":
			return FishingTrip.staticSearchArrivalDate(siteRequest_, (ZonedDateTime)o);
		case "name":
			return FishingTrip.staticSearchName(siteRequest_, (String)o);
		case "description":
			return FishingTrip.staticSearchDescription(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFishingTrip(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFishingTrip(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "timeZone":
			return FishingTrip.staticSearchStrTimeZone(siteRequest_, (String)o);
		case "departureDate":
			return FishingTrip.staticSearchStrDepartureDate(siteRequest_, (String)o);
		case "arrivalDate":
			return FishingTrip.staticSearchStrArrivalDate(siteRequest_, (String)o);
		case "name":
			return FishingTrip.staticSearchStrName(siteRequest_, (String)o);
		case "description":
			return FishingTrip.staticSearchStrDescription(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFishingTrip(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFishingTrip(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "timeZone":
			return FishingTrip.staticSearchFqTimeZone(siteRequest_, o);
		case "departureDate":
			return FishingTrip.staticSearchFqDepartureDate(siteRequest_, o);
		case "arrivalDate":
			return FishingTrip.staticSearchFqArrivalDate(siteRequest_, o);
		case "name":
			return FishingTrip.staticSearchFqName(siteRequest_, o);
		case "description":
			return FishingTrip.staticSearchFqDescription(siteRequest_, o);
			default:
				return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
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
					o = persistFishingTrip(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFishingTrip(String var, Object val) {
		String varLower = var.toLowerCase();
			if("timezone".equals(varLower)) {
				if(val instanceof String) {
					setTimeZone((String)val);
				}
				saves.add("timeZone");
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
			} else if("name".equals(varLower)) {
				if(val instanceof String) {
					setName((String)val);
				}
				saves.add("name");
				return val;
			} else if("description".equals(varLower)) {
				if(val instanceof String) {
					setDescription((String)val);
				}
				saves.add("description");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateFishingTrip(doc);
	}
	public void populateFishingTrip(SolrResponse.Doc doc) {
		FishingTrip oFishingTrip = (FishingTrip)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("timeZone")) {
				String timeZone = (String)doc.get("timeZone_docvalues_string");
				if(timeZone != null)
					oFishingTrip.setTimeZone(timeZone);
			}

			if(saves.contains("departureDate")) {
				String departureDate = (String)doc.get("departureDate_docvalues_date");
				if(departureDate != null)
					oFishingTrip.setDepartureDate(departureDate);
			}

			if(saves.contains("arrivalDate")) {
				String arrivalDate = (String)doc.get("arrivalDate_docvalues_date");
				if(arrivalDate != null)
					oFishingTrip.setArrivalDate(arrivalDate);
			}

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oFishingTrip.setName(name);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oFishingTrip.setDescription(description);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexFishingTrip(JsonObject doc) {
		if(timeZone != null) {
			doc.put("timeZone_docvalues_string", timeZone);
		}
		if(departureDate != null) {
			doc.put("departureDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(departureDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(arrivalDate != null) {
			doc.put("arrivalDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(arrivalDate.toInstant(), ZoneId.of("UTC"))));
		}
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredFishingTrip(String entityVar) {
		switch(entityVar) {
			case "timeZone":
				return "timeZone_docvalues_string";
			case "departureDate":
				return "departureDate_docvalues_date";
			case "arrivalDate":
				return "arrivalDate_docvalues_date";
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedFishingTrip(String entityVar) {
		switch(entityVar) {
			case "timeZone":
				return "timeZone_docvalues_string";
			case "departureDate":
				return "departureDate_docvalues_date";
			case "arrivalDate":
				return "arrivalDate_docvalues_date";
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarFishingTrip(String searchVar) {
		switch(searchVar) {
			case "timeZone_docvalues_string":
				return "timeZone";
			case "departureDate_docvalues_date":
				return "departureDate";
			case "arrivalDate_docvalues_date":
				return "arrivalDate";
			case "name_docvalues_string":
				return "name";
			case "description_docvalues_string":
				return "description";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchFishingTrip(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedFishingTrip(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFishingTrip(doc);
	}
	public void storeFishingTrip(SolrResponse.Doc doc) {
		FishingTrip oFishingTrip = (FishingTrip)this;
		SiteRequest siteRequest = oFishingTrip.getSiteRequest_();

		oFishingTrip.setTimeZone(Optional.ofNullable(doc.get("timeZone_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishingTrip.setDepartureDate(Optional.ofNullable(doc.get("departureDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oFishingTrip.setArrivalDate(Optional.ofNullable(doc.get("arrivalDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oFishingTrip.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFishingTrip.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFishingTrip() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof FishingTrip) {
			FishingTrip original = (FishingTrip)o;
			if(!Objects.equals(timeZone, original.getTimeZone()))
				apiRequest.addVars("timeZone");
			if(!Objects.equals(departureDate, original.getDepartureDate()))
				apiRequest.addVars("departureDate");
			if(!Objects.equals(arrivalDate, original.getArrivalDate()))
				apiRequest.addVars("arrivalDate");
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(timeZone).map(v -> "timeZone: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(departureDate).map(v -> "departureDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(arrivalDate).map(v -> "arrivalDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "FishingTrip";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishingtrip.FishingTrip";
	public static final String CLASS_API_ADDRESS_FishingTrip = "smart-aquaculture-enUS-FishingTrip";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_FishingTrip;
	}
	public static final String VAR_timeZone = "timeZone";
	public static final String VAR_departureDate = "departureDate";
	public static final String VAR_arrivalDate = "arrivalDate";
	public static final String VAR_name = "name";
	public static final String VAR_description = "description";

	public static List<String> varsQForClass() {
		return FishingTrip.varsQFishingTrip(new ArrayList<String>());
	}
	public static List<String> varsQFishingTrip(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return FishingTrip.varsFqFishingTrip(new ArrayList<String>());
	}
	public static List<String> varsFqFishingTrip(List<String> vars) {
		vars.add(VAR_timeZone);
		vars.add(VAR_departureDate);
		vars.add(VAR_arrivalDate);
		vars.add(VAR_name);
		vars.add(VAR_description);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return FishingTrip.varsRangeFishingTrip(new ArrayList<String>());
	}
	public static List<String> varsRangeFishingTrip(List<String> vars) {
		vars.add(VAR_departureDate);
		vars.add(VAR_arrivalDate);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_timeZone = "time zone";
	public static final String DISPLAY_NAME_departureDate = "departure date";
	public static final String DISPLAY_NAME_arrivalDate = "arrival date";
	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_description = "description";

	@Override
	public String idForClass() {
		return Optional.ofNullable(pk).map(o -> o.toString()).orElse(null);
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
		return FishingTrip.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return description;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/fishing-trip/%s";
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
		return FishingTrip.displayNameFishingTrip(var);
	}
	public static String displayNameFishingTrip(String var) {
		switch(var) {
		case VAR_timeZone:
			return DISPLAY_NAME_timeZone;
		case VAR_departureDate:
			return DISPLAY_NAME_departureDate;
		case VAR_arrivalDate:
			return DISPLAY_NAME_arrivalDate;
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_description:
			return DISPLAY_NAME_description;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionFishingTrip(String var) {
		switch(var) {
		case VAR_timeZone:
			return "The local time zone the fishing trip departure and arrival dates are based on. ";
		case VAR_departureDate:
			return "The date and time the fishing trip departed. ";
		case VAR_arrivalDate:
			return "The date and time the fishing trip returned. ";
		case VAR_name:
			return "The name of this fishing trip. ";
		case VAR_description:
			return "A description of this fishing trip. ";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameFishingTrip(String var) {
		switch(var) {
		case VAR_timeZone:
			return "String";
		case VAR_departureDate:
			return "ZonedDateTime";
		case VAR_arrivalDate:
			return "ZonedDateTime";
		case VAR_name:
			return "String";
		case VAR_description:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmColumnFishingTrip(String var) {
		switch(var) {
		case VAR_departureDate:
			return 1;
		case VAR_arrivalDate:
			return 2;
		case VAR_name:
			return 0;
		case VAR_description:
			return 3;
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowFishingTrip(String var) {
		switch(var) {
		case VAR_timeZone:
			return 3;
		case VAR_departureDate:
			return 3;
		case VAR_arrivalDate:
			return 3;
		case VAR_name:
			return 4;
		case VAR_description:
			return 4;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellFishingTrip(String var) {
		switch(var) {
		case VAR_timeZone:
			return 0;
		case VAR_departureDate:
			return 1;
		case VAR_arrivalDate:
			return 2;
		case VAR_name:
			return 0;
		case VAR_description:
			return 1;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinFishingTrip(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxFishingTrip(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxFishingTrip(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minFishingTrip(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
