package org.computate.smartaquaculture.model.event;

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
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import org.computate.vertx.tool.VertxTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class CompanyEventGen into the class CompanyEvent. 
 * </li><li>You can add a class comment "Rows: 100" if you wish the CompanyEvent API to return more or less than 10 records by default. 
 * In this case, the API will return 100 records from the API instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </li><li>You can add a class comment "Model: true" if you wish to persist these CompanyEvent objects in a relational PostgreSQL database transactionally in the RESTful API. 
 * The code to persist and query the CompanyEventGen data in the database will then be automatically generated. 
 * </li>
 * <h3>About the CompanyEvent class and it's generated class CompanyEventGen&lt;BaseResult&gt;: </h3>extends CompanyEventGen
 * <p>
 * This Java class extends a generated Java class CompanyEventGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent">Find the class CompanyEvent in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends CompanyEventGen<BaseResult>
 * <p>This <code>class CompanyEvent extends CompanyEventGen&lt;BaseResult&gt;</code>, which means it extends a newly generated CompanyEventGen. 
 * The generated <code>class CompanyEventGen extends BaseResult</code> which means that CompanyEvent extends CompanyEventGen which extends BaseResult. 
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
 * <h2>ApiMethode: DisplayPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: DisplayPage"</b>, which creates an API "DisplayPage". 
 * </p>
 * <h2>ApiMethode: UserPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: UserPage"</b>, which creates an API "UserPage". 
 * </p>
 * <h2>ApiMethode: DELETEFilter</h2>
 * <p>This class contains a comment <b>"ApiMethod: DELETEFilter"</b>, which creates an API "DELETEFilter". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: events"</b>, which groups all of the OpenAPIs for CompanyEvent objects under the tag "events". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/event</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/event"</b>, which defines the base API URI for CompanyEvent objects as "/en-us/api/event" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the CompanyEvent class will inherit the helpful inherited class comments from the super class CompanyEventGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Order: 11</h2>
 * <p>This class contains a comment <b>"Order: 11"</b>, which means this class will be sorted by the given number 11 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 11</h2>
 * <p>This class contains a comment <b>"SqlOrder: 11"</b>, which means this class will be sorted by the given number 11 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.event.CompanyEventPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.event.CompanyEventPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the CompanyEvent Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: an event</h2>
 * <p>This class contains a comment <b>"AName.enUS: an event"</b>, which identifies the language context to describe a CompanyEvent as "an event". 
 * </p>
 * <p>
 * Delete the class CompanyEvent in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.event in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.event&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class CompanyEventGen<DEV> extends BaseResult {
  protected static final Logger LOG = LoggerFactory.getLogger(CompanyEvent.class);

  public static final String Description_enUS = "See the upcoming computate in-person and online events";
  public static final String AName_enUS = "an event";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this event";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "theevent";
  public static final String SingularName_enUS = "event";
  public static final String PluralName_enUS = "events";
  public static final String NameActual_enUS = "current event";
  public static final String AllName_enUS = "all events";
  public static final String SearchAllNameBy_enUS = "search events by ";
  public static final String SearchAllName_enUS = "search events";
  public static final String Title_enUS = "events";
  public static final String ThePluralName_enUS = "the events";
  public static final String NoNameFound_enUS = "no event found";
  public static final String ApiUri_enUS = "/en-us/api/event";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/event";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/event/{pageId}";
  public static final String OfName_enUS = "of event";
  public static final String ANameAdjective_enUS = "an event";
  public static final String NameAdjectiveSingular_enUS = "event";
  public static final String NameAdjectivePlural_enUS = "events";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/event";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/event";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/event";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/event/{pageId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/event/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/event/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/event";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/event";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/event";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/event";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/event";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/event";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/event/{pageId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/event/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/event/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/event-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/event-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/event-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/event";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/event";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/event";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/event/{pageId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/event/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/event/%s";
  public static final String DisplayPage_enUS_OpenApiUri = "/en-us/shop/event/{pageId}";
  public static final String DisplayPage_enUS_StringFormatUri = "/en-us/shop/event/%s";
  public static final String DisplayPage_enUS_StringFormatUrl = "%s/en-us/shop/event/%s";
  public static final String UserPage_enUS_OpenApiUri = "/en-us/use/event/{pageId}";
  public static final String UserPage_enUS_StringFormatUri = "/en-us/use/event/%s";
  public static final String UserPage_enUS_StringFormatUrl = "%s/en-us/use/event/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/event";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/event";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/event";

  public static final String Icon = "<i class=\"fa-duotone fa-regular fa-map-location-dot\"></i>";

	//////////
  // name //
	//////////


  /**
   *  The entity name
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String name;

  /**
   * <br> The entity name
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _name(Wrap<String> w);

  public String getName() {
    return name;
  }
  public void setName(String o) {
    this.name = CompanyEvent.staticSetName(siteRequest_, o);
  }
  public static String staticSetName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent nameInit() {
    Wrap<String> nameWrap = new Wrap<String>().var("name");
    if(name == null) {
      _name(nameWrap);
      Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
        setName(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchName(siteRequest_, CompanyEvent.staticSetName(siteRequest_, o)).toString();
  }

  public String sqlName() {
    return name;
  }

  public static String staticJsonName(String name) {
    return name;
  }

	/////////////////
  // description //
	/////////////////


  /**
   *  The entity description
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String description;

  /**
   * <br> The entity description
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _description(Wrap<String> w);

  public String getDescription() {
    return description;
  }
  public void setDescription(String o) {
    this.description = CompanyEvent.staticSetDescription(siteRequest_, o);
  }
  public static String staticSetDescription(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent descriptionInit() {
    Wrap<String> descriptionWrap = new Wrap<String>().var("description");
    if(description == null) {
      _description(descriptionWrap);
      Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
        setDescription(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchDescription(siteRequest_, CompanyEvent.staticSetDescription(siteRequest_, o)).toString();
  }

  public String sqlDescription() {
    return description;
  }

  public static String staticJsonDescription(String description) {
    return description;
  }

	///////////////////
  // startDateTime //
	///////////////////


  /**
   *  The entity startDateTime
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime startDateTime;

  /**
   * <br> The entity startDateTime
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:startDateTime">Find the entity startDateTime in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _startDateTime(Wrap<ZonedDateTime> w);

  public ZonedDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(ZonedDateTime startDateTime) {
    this.startDateTime = Optional.ofNullable(startDateTime).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setStartDateTime(Instant o) {
    this.startDateTime = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setStartDateTime(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.startDateTime = CompanyEvent.staticSetStartDateTime(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setStartDateTime(Date o) {
    this.startDateTime = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetStartDateTime(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected CompanyEvent startDateTimeInit() {
    Wrap<ZonedDateTime> startDateTimeWrap = new Wrap<ZonedDateTime>().var("startDateTime");
    if(startDateTime == null) {
      _startDateTime(startDateTimeWrap);
      Optional.ofNullable(startDateTimeWrap.getO()).ifPresent(o -> {
        setStartDateTime(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchStartDateTime(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrStartDateTime(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return CompanyEvent.staticSearchStartDateTime(siteRequest_, CompanyEvent.staticSetStartDateTime(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqStartDateTime(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return CompanyEvent.staticSearchStartDateTime(siteRequest_, CompanyEvent.staticSetStartDateTime(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlStartDateTime() {
    return startDateTime == null ? null : startDateTime.toOffsetDateTime();
  }

  public static String staticJsonStartDateTime(ZonedDateTime startDateTime) {
    return Optional.ofNullable(startDateTime).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	/////////////////
  // endDateTime //
	/////////////////


  /**
   *  The entity endDateTime
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime endDateTime;

  /**
   * <br> The entity endDateTime
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:endDateTime">Find the entity endDateTime in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _endDateTime(Wrap<ZonedDateTime> w);

  public ZonedDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(ZonedDateTime endDateTime) {
    this.endDateTime = Optional.ofNullable(endDateTime).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setEndDateTime(Instant o) {
    this.endDateTime = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setEndDateTime(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.endDateTime = CompanyEvent.staticSetEndDateTime(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setEndDateTime(Date o) {
    this.endDateTime = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetEndDateTime(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected CompanyEvent endDateTimeInit() {
    Wrap<ZonedDateTime> endDateTimeWrap = new Wrap<ZonedDateTime>().var("endDateTime");
    if(endDateTime == null) {
      _endDateTime(endDateTimeWrap);
      Optional.ofNullable(endDateTimeWrap.getO()).ifPresent(o -> {
        setEndDateTime(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchEndDateTime(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrEndDateTime(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return CompanyEvent.staticSearchEndDateTime(siteRequest_, CompanyEvent.staticSetEndDateTime(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqEndDateTime(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return CompanyEvent.staticSearchEndDateTime(siteRequest_, CompanyEvent.staticSetEndDateTime(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlEndDateTime() {
    return endDateTime == null ? null : endDateTime.toOffsetDateTime();
  }

  public static String staticJsonEndDateTime(ZonedDateTime endDateTime) {
    return Optional.ofNullable(endDateTime).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	///////////
  // price //
	///////////


  /**
   *  The entity price
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal price;

  /**
   * <br> The entity price
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:price">Find the entity price in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _price(Wrap<BigDecimal> w);

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  @JsonIgnore
  public void setPrice(String o) {
    this.price = CompanyEvent.staticSetPrice(siteRequest_, o);
  }
  public static BigDecimal staticSetPrice(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
    return null;
  }
  @JsonIgnore
  public void setPrice(Double o) {
    setPrice(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  @JsonIgnore
  public void setPrice(Integer o) {
    setPrice(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  @JsonIgnore
  public void setPrice(Number o) {
    setPrice(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  protected CompanyEvent priceInit() {
    Wrap<BigDecimal> priceWrap = new Wrap<BigDecimal>().var("price");
    if(price == null) {
      _price(priceWrap);
      Optional.ofNullable(priceWrap.getO()).ifPresent(o -> {
        setPrice(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static Double staticSearchPrice(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrPrice(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPrice(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPrice(siteRequest_, CompanyEvent.staticSetPrice(siteRequest_, o)).toString();
  }

  public BigDecimal sqlPrice() {
    return price;
  }

  public static String staticJsonPrice(BigDecimal price) {
    return Optional.ofNullable(price).map(v -> v.toString()).orElse(null);
  }

	////////////
  // pageId //
	////////////


  /**
   *  The entity pageId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageId;

  /**
   * <br> The entity pageId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageId">Find the entity pageId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageId(Wrap<String> w);

  public String getPageId() {
    return pageId;
  }
  public void setPageId(String o) {
    this.pageId = CompanyEvent.staticSetPageId(siteRequest_, o);
  }
  public static String staticSetPageId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent pageIdInit() {
    Wrap<String> pageIdWrap = new Wrap<String>().var("pageId");
    if(pageId == null) {
      _pageId(pageIdWrap);
      Optional.ofNullable(pageIdWrap.getO()).ifPresent(o -> {
        setPageId(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchPageId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageId(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageId(siteRequest_, CompanyEvent.staticSetPageId(siteRequest_, o)).toString();
  }

  public String sqlPageId() {
    return pageId;
  }

  public static String staticJsonPageId(String pageId) {
    return pageId;
  }

	///////////////////
  // emailTemplate //
	///////////////////


  /**
   *  The entity emailTemplate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String emailTemplate;

  /**
   * <br> The entity emailTemplate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:emailTemplate">Find the entity emailTemplate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _emailTemplate(Wrap<String> w);

  public String getEmailTemplate() {
    return emailTemplate;
  }
  public void setEmailTemplate(String o) {
    this.emailTemplate = CompanyEvent.staticSetEmailTemplate(siteRequest_, o);
  }
  public static String staticSetEmailTemplate(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent emailTemplateInit() {
    Wrap<String> emailTemplateWrap = new Wrap<String>().var("emailTemplate");
    if(emailTemplate == null) {
      _emailTemplate(emailTemplateWrap);
      Optional.ofNullable(emailTemplateWrap.getO()).ifPresent(o -> {
        setEmailTemplate(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchEmailTemplate(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrEmailTemplate(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEmailTemplate(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchEmailTemplate(siteRequest_, CompanyEvent.staticSetEmailTemplate(siteRequest_, o)).toString();
  }

  public String sqlEmailTemplate() {
    return emailTemplate;
  }

  public static String staticJsonEmailTemplate(String emailTemplate) {
    return emailTemplate;
  }

	//////////////
  // storeUrl //
	//////////////


  /**
   *  The entity storeUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String storeUrl;

  /**
   * <br> The entity storeUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:storeUrl">Find the entity storeUrl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _storeUrl(Wrap<String> w);

  public String getStoreUrl() {
    return storeUrl;
  }
  public void setStoreUrl(String o) {
    this.storeUrl = CompanyEvent.staticSetStoreUrl(siteRequest_, o);
  }
  public static String staticSetStoreUrl(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent storeUrlInit() {
    Wrap<String> storeUrlWrap = new Wrap<String>().var("storeUrl");
    if(storeUrl == null) {
      _storeUrl(storeUrlWrap);
      Optional.ofNullable(storeUrlWrap.getO()).ifPresent(o -> {
        setStoreUrl(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchStoreUrl(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrStoreUrl(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqStoreUrl(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchStoreUrl(siteRequest_, CompanyEvent.staticSetStoreUrl(siteRequest_, o)).toString();
  }

  public String sqlStoreUrl() {
    return storeUrl;
  }

  public static String staticJsonStoreUrl(String storeUrl) {
    return storeUrl;
  }

	//////////////
  // location //
	//////////////


  /**
   *  The entity location
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = PgClientPointDeserializer.class)
  @JsonSerialize(using = PgClientPointSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Point location;

  /**
   * <br> The entity location
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _location(Wrap<Point> w);

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }
  @JsonIgnore
  public void setLocation(String o) {
    this.location = CompanyEvent.staticSetLocation(siteRequest_, o);
  }
  public static Point staticSetLocation(SiteRequest siteRequest_, String o) {
    if(o != null) {
      try {
        Point shape = null;
        if(StringUtils.isNotBlank(o)) {
          ObjectMapper objectMapper = new ObjectMapper();
          SimpleModule module = new SimpleModule();
          module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
              if (beanDesc.getBeanClass() == Point.class) {
                return new PgClientPointDeserializer();
              }
              return deserializer;
            }
          });
          objectMapper.registerModule(module);
          shape = objectMapper.readValue(Json.encode(o), Point.class);
        }
        return shape;
      } catch(Exception ex) {
        ExceptionUtils.rethrow(ex);
      }
    }
    return null;
  }
  @JsonIgnore
  public void setLocation(JsonObject o) {
    this.location = CompanyEvent.staticSetLocation(siteRequest_, o);
  }
  public static Point staticSetLocation(SiteRequest siteRequest_, JsonObject o) {
    if(o != null) {
      try {
        Point shape = new Point();
        JsonArray coordinates = o.getJsonArray("coordinates");
        shape.setX(coordinates.getDouble(0));
        shape.setY(coordinates.getDouble(1));
        return shape;
      } catch(Exception ex) {
        ExceptionUtils.rethrow(ex);
      }
    }
    return null;
  }
  protected CompanyEvent locationInit() {
    Wrap<Point> locationWrap = new Wrap<Point>().var("location");
    if(location == null) {
      _location(locationWrap);
      Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
        setLocation(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static Point staticSearchLocation(SiteRequest siteRequest_, Point o) {
    return o;
  }

  public static String staticSearchStrLocation(SiteRequest siteRequest_, Point o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocation(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLocation(siteRequest_, CompanyEvent.staticSetLocation(siteRequest_, o)).toString();
  }

  public Point sqlLocation() {
    return location;
  }

  public static JsonObject staticJsonLocation(Point location) {
    return Optional.ofNullable(location).map(v -> VertxTool.toGeoJson(v)).orElse(null);
  }

	////////////////////
  // locationColors //
	////////////////////


  /**
   *  The entity locationColors
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationColors = new ArrayList<String>();

  /**
   * <br> The entity locationColors
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:locationColors">Find the entity locationColors in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationColors(List<String> l);

  public List<String> getLocationColors() {
    return locationColors;
  }

  public void setLocationColors(List<String> locationColors) {
    this.locationColors = locationColors;
  }
  @JsonIgnore
  public void setLocationColors(String o) {
    String l = CompanyEvent.staticSetLocationColors(siteRequest_, o);
    if(l != null)
      addLocationColors(l);
  }
  public static String staticSetLocationColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public CompanyEvent addLocationColors(String...objects) {
    for(String o : objects) {
      addLocationColors(o);
    }
    return (CompanyEvent)this;
  }
  public CompanyEvent addLocationColors(String o) {
    if(o != null)
      this.locationColors.add(o);
    return (CompanyEvent)this;
  }
  @JsonIgnore
  public void setLocationColors(JsonArray objects) {
    locationColors.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationColors(o);
    }
  }
  protected CompanyEvent locationColorsInit() {
    _locationColors(locationColors);
    return (CompanyEvent)this;
  }

  public static String staticSearchLocationColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationColors(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLocationColors(siteRequest_, CompanyEvent.staticSetLocationColors(siteRequest_, o)).toString();
  }

	////////////////////
  // locationTitles //
	////////////////////


  /**
   *  The entity locationTitles
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationTitles = new ArrayList<String>();

  /**
   * <br> The entity locationTitles
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:locationTitles">Find the entity locationTitles in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationTitles(List<String> l);

  public List<String> getLocationTitles() {
    return locationTitles;
  }

  public void setLocationTitles(List<String> locationTitles) {
    this.locationTitles = locationTitles;
  }
  @JsonIgnore
  public void setLocationTitles(String o) {
    String l = CompanyEvent.staticSetLocationTitles(siteRequest_, o);
    if(l != null)
      addLocationTitles(l);
  }
  public static String staticSetLocationTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public CompanyEvent addLocationTitles(String...objects) {
    for(String o : objects) {
      addLocationTitles(o);
    }
    return (CompanyEvent)this;
  }
  public CompanyEvent addLocationTitles(String o) {
    if(o != null)
      this.locationTitles.add(o);
    return (CompanyEvent)this;
  }
  @JsonIgnore
  public void setLocationTitles(JsonArray objects) {
    locationTitles.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationTitles(o);
    }
  }
  protected CompanyEvent locationTitlesInit() {
    _locationTitles(locationTitles);
    return (CompanyEvent)this;
  }

  public static String staticSearchLocationTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationTitles(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLocationTitles(siteRequest_, CompanyEvent.staticSetLocationTitles(siteRequest_, o)).toString();
  }

	///////////////////
  // locationLinks //
	///////////////////


  /**
   *  The entity locationLinks
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> locationLinks = new ArrayList<String>();

  /**
   * <br> The entity locationLinks
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:locationLinks">Find the entity locationLinks in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _locationLinks(List<String> l);

  public List<String> getLocationLinks() {
    return locationLinks;
  }

  public void setLocationLinks(List<String> locationLinks) {
    this.locationLinks = locationLinks;
  }
  @JsonIgnore
  public void setLocationLinks(String o) {
    String l = CompanyEvent.staticSetLocationLinks(siteRequest_, o);
    if(l != null)
      addLocationLinks(l);
  }
  public static String staticSetLocationLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public CompanyEvent addLocationLinks(String...objects) {
    for(String o : objects) {
      addLocationLinks(o);
    }
    return (CompanyEvent)this;
  }
  public CompanyEvent addLocationLinks(String o) {
    if(o != null)
      this.locationLinks.add(o);
    return (CompanyEvent)this;
  }
  @JsonIgnore
  public void setLocationLinks(JsonArray objects) {
    locationLinks.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLocationLinks(o);
    }
  }
  protected CompanyEvent locationLinksInit() {
    _locationLinks(locationLinks);
    return (CompanyEvent)this;
  }

  public static String staticSearchLocationLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLocationLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLocationLinks(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLocationLinks(siteRequest_, CompanyEvent.staticSetLocationLinks(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<CompanyEventGen<DEV>> promiseDeepCompanyEvent(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepCompanyEvent();
  }

  public Future<CompanyEventGen<DEV>> promiseDeepCompanyEvent() {
    Promise<CompanyEventGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseCompanyEvent(promise2);
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

  public Future<Void> promiseCompanyEvent(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        nameInit();
        descriptionInit();
        startDateTimeInit();
        endDateTimeInit();
        priceInit();
        pageIdInit();
        emailTemplateInit();
        storeUrlInit();
        locationInit();
        locationColorsInit();
        locationTitlesInit();
        locationLinksInit();
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

  @Override public Future<? extends CompanyEventGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepCompanyEvent(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestCompanyEvent(SiteRequest siteRequest_) {
      super.siteRequestBaseResult(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestCompanyEvent(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainCompanyEvent(v);
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
  public Object obtainCompanyEvent(String var) {
    CompanyEvent oCompanyEvent = (CompanyEvent)this;
    switch(var) {
      case "name":
        return oCompanyEvent.name;
      case "description":
        return oCompanyEvent.description;
      case "startDateTime":
        return oCompanyEvent.startDateTime;
      case "endDateTime":
        return oCompanyEvent.endDateTime;
      case "price":
        return oCompanyEvent.price;
      case "pageId":
        return oCompanyEvent.pageId;
      case "emailTemplate":
        return oCompanyEvent.emailTemplate;
      case "storeUrl":
        return oCompanyEvent.storeUrl;
      case "location":
        return oCompanyEvent.location;
      case "locationColors":
        return oCompanyEvent.locationColors;
      case "locationTitles":
        return oCompanyEvent.locationTitles;
      case "locationLinks":
        return oCompanyEvent.locationLinks;
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
        o = relateCompanyEvent(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateCompanyEvent(String var, Object val) {
    CompanyEvent oCompanyEvent = (CompanyEvent)this;
    switch(var) {
      default:
        return super.relateBaseResult(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, CompanyEvent o) {
    return staticSetCompanyEvent(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetCompanyEvent(String entityVar, SiteRequest siteRequest_, String v, CompanyEvent o) {
    switch(entityVar) {
    case "name":
      return CompanyEvent.staticSetName(siteRequest_, v);
    case "description":
      return CompanyEvent.staticSetDescription(siteRequest_, v);
    case "startDateTime":
    case "endDateTime":
    case "price":
      return CompanyEvent.staticSetPrice(siteRequest_, v);
    case "pageId":
      return CompanyEvent.staticSetPageId(siteRequest_, v);
    case "emailTemplate":
      return CompanyEvent.staticSetEmailTemplate(siteRequest_, v);
    case "storeUrl":
      return CompanyEvent.staticSetStoreUrl(siteRequest_, v);
    case "location":
      return CompanyEvent.staticSetLocation(siteRequest_, v);
    case "locationColors":
      return CompanyEvent.staticSetLocationColors(siteRequest_, v);
    case "locationTitles":
      return CompanyEvent.staticSetLocationTitles(siteRequest_, v);
    case "locationLinks":
      return CompanyEvent.staticSetLocationLinks(siteRequest_, v);
      default:
        return BaseResult.staticSetBaseResult(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchCompanyEvent(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchCompanyEvent(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "name":
      return CompanyEvent.staticSearchName(siteRequest_, (String)o);
    case "description":
      return CompanyEvent.staticSearchDescription(siteRequest_, (String)o);
    case "startDateTime":
      return CompanyEvent.staticSearchStartDateTime(siteRequest_, (ZonedDateTime)o);
    case "endDateTime":
      return CompanyEvent.staticSearchEndDateTime(siteRequest_, (ZonedDateTime)o);
    case "price":
      return CompanyEvent.staticSearchPrice(siteRequest_, (BigDecimal)o);
    case "pageId":
      return CompanyEvent.staticSearchPageId(siteRequest_, (String)o);
    case "emailTemplate":
      return CompanyEvent.staticSearchEmailTemplate(siteRequest_, (String)o);
    case "storeUrl":
      return CompanyEvent.staticSearchStoreUrl(siteRequest_, (String)o);
    case "location":
      return CompanyEvent.staticSearchLocation(siteRequest_, (Point)o);
    case "locationColors":
      return CompanyEvent.staticSearchLocationColors(siteRequest_, (String)o);
    case "locationTitles":
      return CompanyEvent.staticSearchLocationTitles(siteRequest_, (String)o);
    case "locationLinks":
      return CompanyEvent.staticSearchLocationLinks(siteRequest_, (String)o);
      default:
        return BaseResult.staticSearchBaseResult(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrCompanyEvent(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrCompanyEvent(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "name":
      return CompanyEvent.staticSearchStrName(siteRequest_, (String)o);
    case "description":
      return CompanyEvent.staticSearchStrDescription(siteRequest_, (String)o);
    case "startDateTime":
      return CompanyEvent.staticSearchStrStartDateTime(siteRequest_, (String)o);
    case "endDateTime":
      return CompanyEvent.staticSearchStrEndDateTime(siteRequest_, (String)o);
    case "price":
      return CompanyEvent.staticSearchStrPrice(siteRequest_, (Double)o);
    case "pageId":
      return CompanyEvent.staticSearchStrPageId(siteRequest_, (String)o);
    case "emailTemplate":
      return CompanyEvent.staticSearchStrEmailTemplate(siteRequest_, (String)o);
    case "storeUrl":
      return CompanyEvent.staticSearchStrStoreUrl(siteRequest_, (String)o);
    case "location":
      return CompanyEvent.staticSearchStrLocation(siteRequest_, (Point)o);
    case "locationColors":
      return CompanyEvent.staticSearchStrLocationColors(siteRequest_, (String)o);
    case "locationTitles":
      return CompanyEvent.staticSearchStrLocationTitles(siteRequest_, (String)o);
    case "locationLinks":
      return CompanyEvent.staticSearchStrLocationLinks(siteRequest_, (String)o);
      default:
        return BaseResult.staticSearchStrBaseResult(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqCompanyEvent(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqCompanyEvent(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "name":
      return CompanyEvent.staticSearchFqName(siteRequest_, o);
    case "description":
      return CompanyEvent.staticSearchFqDescription(siteRequest_, o);
    case "startDateTime":
      return CompanyEvent.staticSearchFqStartDateTime(siteRequest_, o);
    case "endDateTime":
      return CompanyEvent.staticSearchFqEndDateTime(siteRequest_, o);
    case "price":
      return CompanyEvent.staticSearchFqPrice(siteRequest_, o);
    case "pageId":
      return CompanyEvent.staticSearchFqPageId(siteRequest_, o);
    case "emailTemplate":
      return CompanyEvent.staticSearchFqEmailTemplate(siteRequest_, o);
    case "storeUrl":
      return CompanyEvent.staticSearchFqStoreUrl(siteRequest_, o);
    case "location":
      return CompanyEvent.staticSearchFqLocation(siteRequest_, o);
    case "locationColors":
      return CompanyEvent.staticSearchFqLocationColors(siteRequest_, o);
    case "locationTitles":
      return CompanyEvent.staticSearchFqLocationTitles(siteRequest_, o);
    case "locationLinks":
      return CompanyEvent.staticSearchFqLocationLinks(siteRequest_, o);
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
          o = persistCompanyEvent(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistCompanyEvent(String var, Object val) {
    String varLower = var.toLowerCase();
      if("name".equals(varLower)) {
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
      } else if("startdatetime".equals(varLower)) {
        if(val instanceof String) {
          setStartDateTime((String)val);
        } else if(val instanceof OffsetDateTime) {
          setStartDateTime(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        }
        saves.add("startDateTime");
        return val;
      } else if("enddatetime".equals(varLower)) {
        if(val instanceof String) {
          setEndDateTime((String)val);
        } else if(val instanceof OffsetDateTime) {
          setEndDateTime(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        }
        saves.add("endDateTime");
        return val;
      } else if("price".equals(varLower)) {
        if(val instanceof String) {
          setPrice((String)val);
        } else if(val instanceof Number) {
          setPrice(new BigDecimal(((Number)val).doubleValue()));
        }
        saves.add("price");
        return val;
      } else if("pageid".equals(varLower)) {
        if(val instanceof String) {
          setPageId((String)val);
        }
        saves.add("pageId");
        return val;
      } else if("emailtemplate".equals(varLower)) {
        if(val instanceof String) {
          setEmailTemplate((String)val);
        }
        saves.add("emailTemplate");
        return val;
      } else if("storeurl".equals(varLower)) {
        if(val instanceof String) {
          setStoreUrl((String)val);
        }
        saves.add("storeUrl");
        return val;
      } else if("location".equals(varLower)) {
        if(val instanceof String) {
          setLocation((String)val);
        } else if(val instanceof Point) {
          setLocation((Point)val);
        }
        saves.add("location");
        return val;
    } else {
      return super.persistBaseResult(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateCompanyEvent(doc);
  }
  public void populateCompanyEvent(SolrResponse.Doc doc) {
    CompanyEvent oCompanyEvent = (CompanyEvent)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("name")) {
        String name = (String)doc.get("name_docvalues_string");
        if(name != null)
          oCompanyEvent.setName(name);
      }

      if(saves.contains("description")) {
        String description = (String)doc.get("description_docvalues_string");
        if(description != null)
          oCompanyEvent.setDescription(description);
      }

      if(saves.contains("startDateTime")) {
        String startDateTime = (String)doc.get("startDateTime_docvalues_date");
        if(startDateTime != null)
          oCompanyEvent.setStartDateTime(startDateTime);
      }

      if(saves.contains("endDateTime")) {
        String endDateTime = (String)doc.get("endDateTime_docvalues_date");
        if(endDateTime != null)
          oCompanyEvent.setEndDateTime(endDateTime);
      }

      if(saves.contains("price")) {
        Double price = (Double)doc.get("price_docvalues_double");
        if(price != null)
          oCompanyEvent.setPrice(price);
      }

      if(saves.contains("pageId")) {
        String pageId = (String)doc.get("pageId_docvalues_string");
        if(pageId != null)
          oCompanyEvent.setPageId(pageId);
      }

      if(saves.contains("emailTemplate")) {
        String emailTemplate = (String)doc.get("emailTemplate_docvalues_string");
        if(emailTemplate != null)
          oCompanyEvent.setEmailTemplate(emailTemplate);
      }

      if(saves.contains("storeUrl")) {
        String storeUrl = (String)doc.get("storeUrl_docvalues_string");
        if(storeUrl != null)
          oCompanyEvent.setStoreUrl(storeUrl);
      }

      if(saves.contains("location")) {
        Point location = (Point)doc.get("location_docvalues_location");
        if(location != null)
          oCompanyEvent.setLocation(location);
      }

      if(saves.contains("locationColors")) {
        List<String> locationColors = (List<String>)doc.get("locationColors_indexedstored_strings");
        if(locationColors != null) {
          locationColors.stream().forEach( v -> {
            oCompanyEvent.locationColors.add(CompanyEvent.staticSetLocationColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("locationTitles")) {
        List<String> locationTitles = (List<String>)doc.get("locationTitles_indexedstored_strings");
        if(locationTitles != null) {
          locationTitles.stream().forEach( v -> {
            oCompanyEvent.locationTitles.add(CompanyEvent.staticSetLocationTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("locationLinks")) {
        List<String> locationLinks = (List<String>)doc.get("locationLinks_indexedstored_strings");
        if(locationLinks != null) {
          locationLinks.stream().forEach( v -> {
            oCompanyEvent.locationLinks.add(CompanyEvent.staticSetLocationLinks(siteRequest_, v));
          });
        }
      }
    }

    super.populateBaseResult(doc);
  }

  public void indexCompanyEvent(JsonObject doc) {
    if(name != null) {
      doc.put("name_docvalues_string", name);
    }
    if(description != null) {
      doc.put("description_docvalues_string", description);
    }
    if(startDateTime != null) {
      doc.put("startDateTime_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(startDateTime.toInstant(), ZoneId.of("UTC"))));
    }
    if(endDateTime != null) {
      doc.put("endDateTime_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(endDateTime.toInstant(), ZoneId.of("UTC"))));
    }
    if(price != null) {
      doc.put("price_docvalues_double", price.doubleValue());
    }
    if(pageId != null) {
      doc.put("pageId_docvalues_string", pageId);
    }
    if(emailTemplate != null) {
      doc.put("emailTemplate_docvalues_string", emailTemplate);
    }
    if(storeUrl != null) {
      doc.put("storeUrl_docvalues_string", storeUrl);
    }
    if(location != null) {
      doc.put("location_docvalues_location", String.format("%s,%s", location.getY(), location.getX()));
    }
    if(locationColors != null) {
      JsonArray l = new JsonArray();
      doc.put("locationColors_indexedstored_strings", l);
      for(String o : locationColors) {
        l.add(CompanyEvent.staticSearchLocationColors(siteRequest_, o));
      }
    }
    if(locationTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("locationTitles_indexedstored_strings", l);
      for(String o : locationTitles) {
        l.add(CompanyEvent.staticSearchLocationTitles(siteRequest_, o));
      }
    }
    if(locationLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("locationLinks_indexedstored_strings", l);
      for(String o : locationLinks) {
        l.add(CompanyEvent.staticSearchLocationLinks(siteRequest_, o));
      }
    }
    super.indexBaseResult(doc);

	}

  public static String varStoredCompanyEvent(String entityVar) {
    switch(entityVar) {
      case "name":
        return "name_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "startDateTime":
        return "startDateTime_docvalues_date";
      case "endDateTime":
        return "endDateTime_docvalues_date";
      case "price":
        return "price_docvalues_double";
      case "pageId":
        return "pageId_docvalues_string";
      case "emailTemplate":
        return "emailTemplate_docvalues_string";
      case "storeUrl":
        return "storeUrl_docvalues_string";
      case "location":
        return "location_docvalues_location";
      case "locationColors":
        return "locationColors_indexedstored_strings";
      case "locationTitles":
        return "locationTitles_indexedstored_strings";
      case "locationLinks":
        return "locationLinks_indexedstored_strings";
      default:
        return BaseResult.varStoredBaseResult(entityVar);
    }
  }

  public static String varIndexedCompanyEvent(String entityVar) {
    switch(entityVar) {
      case "name":
        return "name_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "startDateTime":
        return "startDateTime_docvalues_date";
      case "endDateTime":
        return "endDateTime_docvalues_date";
      case "price":
        return "price_docvalues_double";
      case "pageId":
        return "pageId_docvalues_string";
      case "emailTemplate":
        return "emailTemplate_docvalues_string";
      case "storeUrl":
        return "storeUrl_docvalues_string";
      case "location":
        return "location_docvalues_location";
      case "locationColors":
        return "locationColors_indexedstored_strings";
      case "locationTitles":
        return "locationTitles_indexedstored_strings";
      case "locationLinks":
        return "locationLinks_indexedstored_strings";
      default:
        return BaseResult.varIndexedBaseResult(entityVar);
    }
  }

  public static String searchVarCompanyEvent(String searchVar) {
    switch(searchVar) {
      case "name_docvalues_string":
        return "name";
      case "description_docvalues_string":
        return "description";
      case "startDateTime_docvalues_date":
        return "startDateTime";
      case "endDateTime_docvalues_date":
        return "endDateTime";
      case "price_docvalues_double":
        return "price";
      case "pageId_docvalues_string":
        return "pageId";
      case "emailTemplate_docvalues_string":
        return "emailTemplate";
      case "storeUrl_docvalues_string":
        return "storeUrl";
      case "location_docvalues_location":
        return "location";
      case "locationColors_indexedstored_strings":
        return "locationColors";
      case "locationTitles_indexedstored_strings":
        return "locationTitles";
      case "locationLinks_indexedstored_strings":
        return "locationLinks";
      default:
        return BaseResult.searchVarBaseResult(searchVar);
    }
  }

  public static String varSearchCompanyEvent(String entityVar) {
    switch(entityVar) {
      default:
        return BaseResult.varSearchBaseResult(entityVar);
    }
  }

  public static String varSuggestedCompanyEvent(String entityVar) {
    switch(entityVar) {
      default:
        return BaseResult.varSuggestedBaseResult(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeCompanyEvent(doc);
  }
  public void storeCompanyEvent(SolrResponse.Doc doc) {
    CompanyEvent oCompanyEvent = (CompanyEvent)this;
    SiteRequest siteRequest = oCompanyEvent.getSiteRequest_();

    oCompanyEvent.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setStartDateTime(Optional.ofNullable(doc.get("startDateTime_docvalues_date")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setEndDateTime(Optional.ofNullable(doc.get("endDateTime_docvalues_date")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPrice(Optional.ofNullable(doc.get("price_docvalues_double")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageId(Optional.ofNullable(doc.get("pageId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setEmailTemplate(Optional.ofNullable(doc.get("emailTemplate_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setStoreUrl(Optional.ofNullable(doc.get("storeUrl_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("locationColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oCompanyEvent.addLocationColors(CompanyEvent.staticSetLocationColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("locationTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oCompanyEvent.addLocationTitles(CompanyEvent.staticSetLocationTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("locationLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oCompanyEvent.addLocationLinks(CompanyEvent.staticSetLocationLinks(siteRequest, v.toString()));
    });

    super.storeBaseResult(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestCompanyEvent() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof CompanyEvent) {
      CompanyEvent original = (CompanyEvent)o;
      if(!Objects.equals(name, original.getName()))
        apiRequest.addVars("name");
      if(!Objects.equals(description, original.getDescription()))
        apiRequest.addVars("description");
      if(!Objects.equals(startDateTime, original.getStartDateTime()))
        apiRequest.addVars("startDateTime");
      if(!Objects.equals(endDateTime, original.getEndDateTime()))
        apiRequest.addVars("endDateTime");
      if(!Objects.equals(price, original.getPrice()) && price != null && original.getPrice() != null && price.compareTo(original.getPrice()) != 0)
        apiRequest.addVars("price");
      if(!Objects.equals(pageId, original.getPageId()))
        apiRequest.addVars("pageId");
      if(!Objects.equals(emailTemplate, original.getEmailTemplate()))
        apiRequest.addVars("emailTemplate");
      if(!Objects.equals(storeUrl, original.getStoreUrl()))
        apiRequest.addVars("storeUrl");
      if(!Objects.equals(location, original.getLocation()))
        apiRequest.addVars("location");
      if(!Objects.equals(locationColors, original.getLocationColors()))
        apiRequest.addVars("locationColors");
      if(!Objects.equals(locationTitles, original.getLocationTitles()))
        apiRequest.addVars("locationTitles");
      if(!Objects.equals(locationLinks, original.getLocationLinks()))
        apiRequest.addVars("locationLinks");
      super.apiRequestBaseResult();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(startDateTime).map(v -> "startDateTime: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(endDateTime).map(v -> "endDateTime: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(price).map(v -> "price: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(pageId).map(v -> "pageId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(emailTemplate).map(v -> "emailTemplate: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(storeUrl).map(v -> "storeUrl: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(locationColors).map(v -> "locationColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(locationTitles).map(v -> "locationTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(locationLinks).map(v -> "locationLinks: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "CompanyEvent";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.event.CompanyEvent";
  public static final String CLASS_AUTH_RESOURCE = "COMPANYEVENT";
  public static final String CLASS_API_ADDRESS_CompanyEvent = "smart-aquaculture-enUS-CompanyEvent";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_CompanyEvent;
  }
  public static final String VAR_name = "name";
  public static final String VAR_description = "description";
  public static final String VAR_startDateTime = "startDateTime";
  public static final String VAR_endDateTime = "endDateTime";
  public static final String VAR_price = "price";
  public static final String VAR_pageId = "pageId";
  public static final String VAR_emailTemplate = "emailTemplate";
  public static final String VAR_storeUrl = "storeUrl";
  public static final String VAR_location = "location";
  public static final String VAR_locationColors = "locationColors";
  public static final String VAR_locationTitles = "locationTitles";
  public static final String VAR_locationLinks = "locationLinks";

  public static List<String> varsQForClass() {
    return CompanyEvent.varsQCompanyEvent(new ArrayList<String>());
  }
  public static List<String> varsQCompanyEvent(List<String> vars) {
    BaseResult.varsQBaseResult(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return CompanyEvent.varsFqCompanyEvent(new ArrayList<String>());
  }
  public static List<String> varsFqCompanyEvent(List<String> vars) {
    vars.add(VAR_name);
    vars.add(VAR_description);
    vars.add(VAR_startDateTime);
    vars.add(VAR_endDateTime);
    vars.add(VAR_price);
    vars.add(VAR_pageId);
    vars.add(VAR_emailTemplate);
    vars.add(VAR_storeUrl);
    vars.add(VAR_location);
    BaseResult.varsFqBaseResult(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return CompanyEvent.varsRangeCompanyEvent(new ArrayList<String>());
  }
  public static List<String> varsRangeCompanyEvent(List<String> vars) {
    vars.add(VAR_startDateTime);
    vars.add(VAR_endDateTime);
    vars.add(VAR_price);
    vars.add(VAR_location);
    BaseResult.varsRangeBaseResult(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_name = "event name";
  public static final String DISPLAY_NAME_description = "event description";
  public static final String DISPLAY_NAME_startDateTime = "start date time";
  public static final String DISPLAY_NAME_endDateTime = "end date time";
  public static final String DISPLAY_NAME_price = "price";
  public static final String DISPLAY_NAME_pageId = "Page ID";
  public static final String DISPLAY_NAME_emailTemplate = "email template";
  public static final String DISPLAY_NAME_storeUrl = "store URL";
  public static final String DISPLAY_NAME_location = "map location";
  public static final String DISPLAY_NAME_locationColors = "location colors";
  public static final String DISPLAY_NAME_locationTitles = "location titles";
  public static final String DISPLAY_NAME_locationLinks = "location links";

  @Override
  public String idForClass() {
    return pageId;
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
    return CompanyEvent.NameAdjectiveSingular_enUS;
  }

  @Override
  public String descriptionForClass() {
    return null;
  }

  @Override
  public String classStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/event/%s";
  }

  @Override
  public String classStringFormatUrlDisplayPageForClass() {
    return "%s/en-us/shop/event/%s";
  }

  @Override
  public String classStringFormatUrlUserPageForClass() {
    return "%s/en-us/use/event/%s";
  }

  @Override
  public String classStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return CompanyEvent.displayNameCompanyEvent(var);
  }
  public static String displayNameCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return DISPLAY_NAME_name;
    case VAR_description:
      return DISPLAY_NAME_description;
    case VAR_startDateTime:
      return DISPLAY_NAME_startDateTime;
    case VAR_endDateTime:
      return DISPLAY_NAME_endDateTime;
    case VAR_price:
      return DISPLAY_NAME_price;
    case VAR_pageId:
      return DISPLAY_NAME_pageId;
    case VAR_emailTemplate:
      return DISPLAY_NAME_emailTemplate;
    case VAR_storeUrl:
      return DISPLAY_NAME_storeUrl;
    case VAR_location:
      return DISPLAY_NAME_location;
    case VAR_locationColors:
      return DISPLAY_NAME_locationColors;
    case VAR_locationTitles:
      return DISPLAY_NAME_locationTitles;
    case VAR_locationLinks:
      return DISPLAY_NAME_locationLinks;
    default:
      return BaseResult.displayNameBaseResult(var);
    }
  }

  public static String descriptionCompanyEvent(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_name:
      return "The event name. ";
    case VAR_description:
      return "The event description. ";
    case VAR_startDateTime:
      return "The start date time. ";
    case VAR_endDateTime:
      return "The end date time. ";
    case VAR_price:
      return "The price of the product per developer. ";
    case VAR_pageId:
      return "The ID for this page. ";
    case VAR_emailTemplate:
      return "The HTML email template for this product. ";
    case VAR_storeUrl:
      return "The store URL for this page. ";
    case VAR_locationColors:
      return "The colors of each location Points. ";
    case VAR_locationTitles:
      return "The titles of each location Paths. ";
    case VAR_locationLinks:
      return "The links of each location Paths. ";
      default:
        return BaseResult.descriptionBaseResult(var);
    }
  }

  public static String classSimpleNameCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return "String";
    case VAR_description:
      return "String";
    case VAR_startDateTime:
      return "ZonedDateTime";
    case VAR_endDateTime:
      return "ZonedDateTime";
    case VAR_price:
      return "BigDecimal";
    case VAR_pageId:
      return "String";
    case VAR_emailTemplate:
      return "String";
    case VAR_storeUrl:
      return "String";
    case VAR_location:
      return "Point";
    case VAR_locationColors:
      return "List";
    case VAR_locationTitles:
      return "List";
    case VAR_locationLinks:
      return "List";
      default:
        return BaseResult.classSimpleNameBaseResult(var);
    }
  }

  public static Integer htmColumnCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return 2;
    case VAR_description:
      return 3;
    case VAR_startDateTime:
      return 1;
      default:
        return BaseResult.htmColumnBaseResult(var);
    }
  }

  public static Integer htmRowCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return 3;
    case VAR_description:
      return 3;
    case VAR_startDateTime:
      return 3;
    case VAR_endDateTime:
      return 3;
    case VAR_price:
      return 3;
    case VAR_pageId:
      return 99;
    case VAR_location:
      return 3;
      default:
        return BaseResult.htmRowBaseResult(var);
    }
  }

  public static Integer htmCellCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return 1;
    case VAR_description:
      return 2;
    case VAR_startDateTime:
      return 3;
    case VAR_endDateTime:
      return 4;
    case VAR_price:
      return 5;
    case VAR_pageId:
      return 1;
    case VAR_location:
      return 1;
      default:
        return BaseResult.htmCellBaseResult(var);
    }
  }

  public static Integer lengthMinCompanyEvent(String var) {
    switch(var) {
      default:
        return BaseResult.lengthMinBaseResult(var);
    }
  }

  public static Integer lengthMaxCompanyEvent(String var) {
    switch(var) {
      default:
        return BaseResult.lengthMaxBaseResult(var);
    }
  }

  public static Integer maxCompanyEvent(String var) {
    switch(var) {
      default:
        return BaseResult.maxBaseResult(var);
    }
  }

  public static Integer minCompanyEvent(String var) {
    switch(var) {
      default:
        return BaseResult.minBaseResult(var);
    }
  }
}
