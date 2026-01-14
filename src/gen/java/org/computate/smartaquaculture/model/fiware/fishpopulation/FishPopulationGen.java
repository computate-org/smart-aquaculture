/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 6
 * Description.enUS: Tracking fish population counts, maturation, and incubation over time. 
 * Description.frFR: Suivi du nombre de poissons, de leur maturation et de leur incubation au fil du temps. 
 * AName.enUS: a fish population
 * AName.frFR: une population de poissons
 * PluralName.frFR: population de poissons
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3zM448 256a32 32 0 1 1 -64 0 32 32 0 1 1 64 0z"/><path class="fa-primary" d="M180.8 303.7c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8zM4.2 336.1L50 256 4.2 175.9c-6.9-12.1-5.2-27.2 4.2-37.5s24.3-13.3 36.9-7.5l99.5 45.6c10.5-11.9 22.5-23.8 35.7-35C219.7 108.5 272.6 80 336 80s116.3 28.5 155.5 61.5c39.1 33 66.9 72.4 81 99.8c4.7 9.2 4.7 20.1 0 29.3c-14.1 27.4-41.9 66.8-81 99.8C452.3 403.5 399.4 432 336 432s-116.3-28.5-155.5-61.5c-13.2-11.2-25.1-23.1-35.7-35L45.3 381.1c-12.6 5.8-27.6 2.8-36.9-7.5S-2.7 348.2 4.2 336.1zM416 224a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-population
 * EditPageUri: /en-us/edit/fish-population/{entityShortId}
 * ApiUri: /en-us/api/fish-population
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: FishPopulationPage
 *     ApiUri: /fr-fr/rechercher/population-poissons
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: FishPopulationPage
 *     ApiUri: /fr-fr/edition/population-poissons/{entityShortId}
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
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Polygon;
import org.computate.vertx.tool.VertxTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPolygonSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPolygonDeserializer;
import java.lang.Long;
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
import java.lang.Boolean;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
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
 * <h2>Order: 6</h2>
 * <p>This class contains a comment <b>"Order: 6"</b>, which means this class will be sorted by the given number 6 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 6</h2>
 * <p>This class contains a comment <b>"SqlOrder: 6"</b>, which means this class will be sorted by the given number 6 ascending when SQL code to create and drop the tables is generated. 
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

  public static final String Description_frFR = "Suivi du nombre de poissons, de leur maturation et de leur incubation au fil du temps. ";
  public static final String AName_frFR = "une population de poissons";
  public static final String This_frFR = "cette ";
  public static final String ThisName_frFR = "cette population de poissons";
  public static final String A_frFR = "une ";
  public static final String TheName_frFR = "la population de poissons";
  public static final String SingularName_frFR = "population de poissons";
  public static final String PluralName_frFR = "population de poissons";
  public static final String NameActual_frFR = "population de poissons actuelle";
  public static final String AllName_frFR = "toutes population de poissons";
  public static final String SearchAllNameBy_frFR = "rechercher population de poissons par ";
  public static final String SearchAllName_frFR = "rechercher population de poissons";
  public static final String Title_frFR = "population de poissons";
  public static final String ThePluralName_frFR = "les population de poissons";
  public static final String NoNameFound_frFR = "aucune population de poissons trouvée";
  public static final String OfName_frFR = "de population de poissons";
  public static final String NameAdjectiveSingular_frFR = "population de poissons";
  public static final String NameAdjectivePlural_frFR = "population de poissons";
  public static final String SearchPageFrFR_frFR_OpenApiUri = "/fr-fr/rechercher/population-poissons";
  public static final String SearchPageFrFR_frFR_StringFormatUri = "/fr-fr/rechercher/population-poissons";
  public static final String SearchPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/rechercher/population-poissons";
  public static final String EditPageFrFR_frFR_OpenApiUri = "/fr-fr/edition/population-poissons/{entityShortId}";
  public static final String EditPageFrFR_frFR_StringFormatUri = "/fr-fr/edition/population-poissons/%s";
  public static final String EditPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/edition/population-poissons/%s";

  public static final String Description_enUS = "Tracking fish population counts, maturation, and incubation over time. ";
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


  /**
   *  The entity address
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject address;

  /**
   * <br> The entity address
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

  public static JsonObject staticJsonAddress(JsonObject address) {
    return address;
  }

	///////////////////
  // alternateName //
	///////////////////


  /**
   *  The entity alternateName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String alternateName;

  /**
   * <br> The entity alternateName
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

  public static String staticJsonAlternateName(String alternateName) {
    return alternateName;
  }

	///////////////
  // bodyMasse //
	///////////////


  /**
   *  The entity bodyMasse
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal bodyMasse;

  /**
   * <br> The entity bodyMasse
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
  public static MathContext staticMathContextBodyMasse() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetBodyMasse(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextBodyMasse());
    return null;
  }
  @JsonIgnore
  public void setBodyMasse(Double o) {
    setBodyMasse(new BigDecimal(o, staticMathContextBodyMasse()));
  }
  @JsonIgnore
  public void setBodyMasse(Integer o) {
    setBodyMasse(new BigDecimal(o, staticMathContextBodyMasse()));
  }
  @JsonIgnore
  public void setBodyMasse(Number o) {
    setBodyMasse(new BigDecimal(o.doubleValue(), staticMathContextBodyMasse()));
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

  public static String staticJsonBodyMasse(BigDecimal bodyMasse) {
    return Optional.ofNullable(bodyMasse).map(v -> v.toString()).orElse(null);
  }

	////////////////
  // culturedIn //
	////////////////


  /**
   *  The entity culturedIn
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal culturedIn;

  /**
   * <br> The entity culturedIn
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
  public static MathContext staticMathContextCulturedIn() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetCulturedIn(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextCulturedIn());
    return null;
  }
  @JsonIgnore
  public void setCulturedIn(Double o) {
    setCulturedIn(new BigDecimal(o, staticMathContextCulturedIn()));
  }
  @JsonIgnore
  public void setCulturedIn(Integer o) {
    setCulturedIn(new BigDecimal(o, staticMathContextCulturedIn()));
  }
  @JsonIgnore
  public void setCulturedIn(Number o) {
    setCulturedIn(new BigDecimal(o.doubleValue(), staticMathContextCulturedIn()));
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

  public static String staticJsonCulturedIn(BigDecimal culturedIn) {
    return Optional.ofNullable(culturedIn).map(v -> v.toString()).orElse(null);
  }

	//////////////////
  // dataProvider //
	//////////////////


  /**
   *  The entity dataProvider
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dataProvider;

  /**
   * <br> The entity dataProvider
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

  public static String staticJsonDataProvider(String dataProvider) {
    return dataProvider;
  }

	/////////////////
  // dateCreated //
	/////////////////


  /**
   *  The entity dateCreated
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateCreated;

  /**
   * <br> The entity dateCreated
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

  public static String staticJsonDateCreated(String dateCreated) {
    return dateCreated;
  }

	//////////////////
  // dateModified //
	//////////////////


  /**
   *  The entity dateModified
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateModified;

  /**
   * <br> The entity dateModified
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

  public static String staticJsonDateModified(String dateModified) {
    return dateModified;
  }

	/////////////////
  // fishRemoved //
	/////////////////


  /**
   *  The entity fishRemoved
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal fishRemoved;

  /**
   * <br> The entity fishRemoved
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
  public static MathContext staticMathContextFishRemoved() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetFishRemoved(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextFishRemoved());
    return null;
  }
  @JsonIgnore
  public void setFishRemoved(Double o) {
    setFishRemoved(new BigDecimal(o, staticMathContextFishRemoved()));
  }
  @JsonIgnore
  public void setFishRemoved(Integer o) {
    setFishRemoved(new BigDecimal(o, staticMathContextFishRemoved()));
  }
  @JsonIgnore
  public void setFishRemoved(Number o) {
    setFishRemoved(new BigDecimal(o.doubleValue(), staticMathContextFishRemoved()));
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

  public static String staticJsonFishRemoved(BigDecimal fishRemoved) {
    return Optional.ofNullable(fishRemoved).map(v -> v.toString()).orElse(null);
  }

	///////////////////
  // initialNumber //
	///////////////////


  /**
   *  The entity initialNumber
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal initialNumber;

  /**
   * <br> The entity initialNumber
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
  public static MathContext staticMathContextInitialNumber() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetInitialNumber(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextInitialNumber());
    return null;
  }
  @JsonIgnore
  public void setInitialNumber(Double o) {
    setInitialNumber(new BigDecimal(o, staticMathContextInitialNumber()));
  }
  @JsonIgnore
  public void setInitialNumber(Integer o) {
    setInitialNumber(new BigDecimal(o, staticMathContextInitialNumber()));
  }
  @JsonIgnore
  public void setInitialNumber(Number o) {
    setInitialNumber(new BigDecimal(o.doubleValue(), staticMathContextInitialNumber()));
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

  public static String staticJsonInitialNumber(BigDecimal initialNumber) {
    return Optional.ofNullable(initialNumber).map(v -> v.toString()).orElse(null);
  }

	///////////
  // owner //
	///////////


  /**
   *  The entity owner
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject owner;

  /**
   * <br> The entity owner
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

  public static JsonObject staticJsonOwner(JsonObject owner) {
    return owner;
  }

	///////////////
  // refSpecie //
	///////////////


  /**
   *  The entity refSpecie
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal refSpecie;

  /**
   * <br> The entity refSpecie
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
  public static MathContext staticMathContextRefSpecie() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetRefSpecie(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextRefSpecie());
    return null;
  }
  @JsonIgnore
  public void setRefSpecie(Double o) {
    setRefSpecie(new BigDecimal(o, staticMathContextRefSpecie()));
  }
  @JsonIgnore
  public void setRefSpecie(Integer o) {
    setRefSpecie(new BigDecimal(o, staticMathContextRefSpecie()));
  }
  @JsonIgnore
  public void setRefSpecie(Number o) {
    setRefSpecie(new BigDecimal(o.doubleValue(), staticMathContextRefSpecie()));
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

  public static String staticJsonRefSpecie(BigDecimal refSpecie) {
    return Optional.ofNullable(refSpecie).map(v -> v.toString()).orElse(null);
  }

	///////////////////
  // relatedSource //
	///////////////////


  /**
   *  The entity relatedSource
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject relatedSource;

  /**
   * <br> The entity relatedSource
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

  public static JsonObject staticJsonRelatedSource(JsonObject relatedSource) {
    return relatedSource;
  }

	/////////////
  // seeAlso //
	/////////////


  /**
   *  The entity seeAlso
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String seeAlso;

  /**
   * <br> The entity seeAlso
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

  public static String staticJsonSeeAlso(String seeAlso) {
    return seeAlso;
  }

	////////////
  // source //
	////////////


  /**
   *  The entity source
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String source;

  /**
   * <br> The entity source
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

  public static String staticJsonSource(String source) {
    return source;
  }

	//////////////////////
  // areaServedColors //
	//////////////////////


  /**
   *  The entity areaServedColors
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedColors = new ArrayList<String>();

  /**
   * <br> The entity areaServedColors
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
    String l = FishPopulation.staticSetAreaServedColors(siteRequest_, o);
    if(l != null)
      addAreaServedColors(l);
  }
  public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishPopulation addAreaServedColors(String...objects) {
    for(String o : objects) {
      addAreaServedColors(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addAreaServedColors(String o) {
    if(o != null)
      this.areaServedColors.add(o);
    return (FishPopulation)this;
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
  protected FishPopulation areaServedColorsInit() {
    _areaServedColors(areaServedColors);
    return (FishPopulation)this;
  }

  public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchAreaServedColors(siteRequest_, FishPopulation.staticSetAreaServedColors(siteRequest_, o)).toString();
  }

	//////////////////////
  // areaServedTitles //
	//////////////////////


  /**
   *  The entity areaServedTitles
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedTitles = new ArrayList<String>();

  /**
   * <br> The entity areaServedTitles
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
    String l = FishPopulation.staticSetAreaServedTitles(siteRequest_, o);
    if(l != null)
      addAreaServedTitles(l);
  }
  public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishPopulation addAreaServedTitles(String...objects) {
    for(String o : objects) {
      addAreaServedTitles(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addAreaServedTitles(String o) {
    if(o != null)
      this.areaServedTitles.add(o);
    return (FishPopulation)this;
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
  protected FishPopulation areaServedTitlesInit() {
    _areaServedTitles(areaServedTitles);
    return (FishPopulation)this;
  }

  public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchAreaServedTitles(siteRequest_, FishPopulation.staticSetAreaServedTitles(siteRequest_, o)).toString();
  }

	/////////////////////
  // areaServedLinks //
	/////////////////////


  /**
   *  The entity areaServedLinks
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedLinks = new ArrayList<String>();

  /**
   * <br> The entity areaServedLinks
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
    String l = FishPopulation.staticSetAreaServedLinks(siteRequest_, o);
    if(l != null)
      addAreaServedLinks(l);
  }
  public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishPopulation addAreaServedLinks(String...objects) {
    for(String o : objects) {
      addAreaServedLinks(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addAreaServedLinks(String o) {
    if(o != null)
      this.areaServedLinks.add(o);
    return (FishPopulation)this;
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
  protected FishPopulation areaServedLinksInit() {
    _areaServedLinks(areaServedLinks);
    return (FishPopulation)this;
  }

  public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchAreaServedLinks(siteRequest_, FishPopulation.staticSetAreaServedLinks(siteRequest_, o)).toString();
  }

	////////////////
  // areaServed //
	////////////////


  /**
   *  The entity areaServed
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = PgClientPolygonDeserializer.class)
  @JsonSerialize(using = PgClientPolygonSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<Polygon> areaServed = new ArrayList<Polygon>();

  /**
   * <br> The entity areaServed
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _areaServed(List<Polygon> l);

  public List<Polygon> getAreaServed() {
    return areaServed;
  }
  public JsonObject geojsonAreaServed() {
    if(areaServed == null)
      return null;
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    for(Polygon o : areaServed) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      o.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    if(coordinates.size() == 0)
      return null;
    else
      return json;
  }

  public void setAreaServed(List<Polygon> areaServed) {
    this.areaServed = areaServed;
  }
  @JsonIgnore
  public static List<Polygon> staticSetAreaServed(SiteRequest siteRequest_, String o) {
    if(o != null) {
      try {
        List<Polygon> shape = null;
        if(StringUtils.isNotBlank(o)) {
          ObjectMapper objectMapper = new ObjectMapper();
          SimpleModule module = new SimpleModule();
          module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
              if (beanDesc.getBeanClass() == Polygon.class) {
                return new PgClientPolygonDeserializer();
              }
              return deserializer;
            }
          });
          objectMapper.registerModule(module);
          shape = (List<Polygon>)objectMapper.readValue(Json.encode(o), Polygon.class);
        }
        return shape;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  @JsonIgnore
  public void setAreaServed(JsonObject o) {
    this.areaServed = FishPopulation.staticSetAreaServed(siteRequest_, o);
  }
  public static List<Polygon> staticSetAreaServed(SiteRequest siteRequest_, JsonObject o) {
    if(o != null) {
      try {
        List<Polygon> shapes = new ArrayList<>();
        o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(g -> {
          Polygon shape = new Polygon();
          g.stream().map(a -> (JsonArray)a).forEach(points -> {
            shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
          });
            shapes.add(shape);
        });
        return shapes;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  public FishPopulation addAreaServed(Polygon...objects) {
    for(Polygon o : objects) {
      addAreaServed(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addAreaServed(Polygon o) {
    if(o != null)
      this.areaServed.add(o);
    return (FishPopulation)this;
  }
  protected FishPopulation areaServedInit() {
    _areaServed(areaServed);
    return (FishPopulation)this;
  }

  public static Polygon staticSearchAreaServed(SiteRequest siteRequest_, Polygon o) {
    return o;
  }

  public static String staticSearchStrAreaServed(SiteRequest siteRequest_, Polygon o) {
    JsonArray pointsArray = new JsonArray();
    o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
    return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
  }

  public static String staticSearchFqAreaServed(SiteRequest siteRequest_, String o) {
    return o;
  }

  public String sqlAreaServed() {
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    for(Polygon o : areaServed) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      o.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    return json.toString();
  }

  public static JsonObject staticJsonAreaServed(List<Polygon> areaServed) {
    return Optional.ofNullable(areaServed).map(v -> VertxTool.toGeoJson(v)).orElse(null);
  }

	////////////////////
  // scientificName //
	////////////////////


  /**
   *  The entity scientificName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String scientificName;

  /**
   * <br> The entity scientificName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:scientificName">Find the entity scientificName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _scientificName(Wrap<String> w);

  public String getScientificName() {
    return scientificName;
  }
  public void setScientificName(String o) {
    this.scientificName = FishPopulation.staticSetScientificName(siteRequest_, o);
  }
  public static String staticSetScientificName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected FishPopulation scientificNameInit() {
    Wrap<String> scientificNameWrap = new Wrap<String>().var("scientificName");
    if(scientificName == null) {
      _scientificName(scientificNameWrap);
      Optional.ofNullable(scientificNameWrap.getO()).ifPresent(o -> {
        setScientificName(o);
      });
    }
    return (FishPopulation)this;
  }

  public static String staticSearchScientificName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrScientificName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqScientificName(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchScientificName(siteRequest_, FishPopulation.staticSetScientificName(siteRequest_, o)).toString();
  }

  public String sqlScientificName() {
    return scientificName;
  }

  public static String staticJsonScientificName(String scientificName) {
    return scientificName;
  }

	///////////////////////
  // maturityDaysBegin //
	///////////////////////


  /**
   *  The entity maturityDaysBegin
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maturityDaysBegin;

  /**
   * <br> The entity maturityDaysBegin
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:maturityDaysBegin">Find the entity maturityDaysBegin in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maturityDaysBegin(Wrap<BigDecimal> w);

  public BigDecimal getMaturityDaysBegin() {
    return maturityDaysBegin;
  }

  public void setMaturityDaysBegin(BigDecimal maturityDaysBegin) {
    this.maturityDaysBegin = maturityDaysBegin;
  }
  @JsonIgnore
  public void setMaturityDaysBegin(String o) {
    this.maturityDaysBegin = FishPopulation.staticSetMaturityDaysBegin(siteRequest_, o);
  }
  public static MathContext staticMathContextMaturityDaysBegin() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaturityDaysBegin(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaturityDaysBegin());
    return null;
  }
  @JsonIgnore
  public void setMaturityDaysBegin(Double o) {
    setMaturityDaysBegin(new BigDecimal(o, staticMathContextMaturityDaysBegin()));
  }
  @JsonIgnore
  public void setMaturityDaysBegin(Integer o) {
    setMaturityDaysBegin(new BigDecimal(o, staticMathContextMaturityDaysBegin()));
  }
  @JsonIgnore
  public void setMaturityDaysBegin(Number o) {
    setMaturityDaysBegin(new BigDecimal(o.doubleValue(), staticMathContextMaturityDaysBegin()));
  }
  protected FishPopulation maturityDaysBeginInit() {
    Wrap<BigDecimal> maturityDaysBeginWrap = new Wrap<BigDecimal>().var("maturityDaysBegin");
    if(maturityDaysBegin == null) {
      _maturityDaysBegin(maturityDaysBeginWrap);
      Optional.ofNullable(maturityDaysBeginWrap.getO()).ifPresent(o -> {
        setMaturityDaysBegin(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchMaturityDaysBegin(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaturityDaysBegin(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaturityDaysBegin(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchMaturityDaysBegin(siteRequest_, FishPopulation.staticSetMaturityDaysBegin(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaturityDaysBegin() {
    return maturityDaysBegin;
  }

  public static String staticJsonMaturityDaysBegin(BigDecimal maturityDaysBegin) {
    return Optional.ofNullable(maturityDaysBegin).map(v -> v.toString()).orElse(null);
  }

	/////////////////////
  // maturityDaysEnd //
	/////////////////////


  /**
   *  The entity maturityDaysEnd
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maturityDaysEnd;

  /**
   * <br> The entity maturityDaysEnd
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:maturityDaysEnd">Find the entity maturityDaysEnd in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maturityDaysEnd(Wrap<BigDecimal> w);

  public BigDecimal getMaturityDaysEnd() {
    return maturityDaysEnd;
  }

  public void setMaturityDaysEnd(BigDecimal maturityDaysEnd) {
    this.maturityDaysEnd = maturityDaysEnd;
  }
  @JsonIgnore
  public void setMaturityDaysEnd(String o) {
    this.maturityDaysEnd = FishPopulation.staticSetMaturityDaysEnd(siteRequest_, o);
  }
  public static MathContext staticMathContextMaturityDaysEnd() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaturityDaysEnd(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaturityDaysEnd());
    return null;
  }
  @JsonIgnore
  public void setMaturityDaysEnd(Double o) {
    setMaturityDaysEnd(new BigDecimal(o, staticMathContextMaturityDaysEnd()));
  }
  @JsonIgnore
  public void setMaturityDaysEnd(Integer o) {
    setMaturityDaysEnd(new BigDecimal(o, staticMathContextMaturityDaysEnd()));
  }
  @JsonIgnore
  public void setMaturityDaysEnd(Number o) {
    setMaturityDaysEnd(new BigDecimal(o.doubleValue(), staticMathContextMaturityDaysEnd()));
  }
  protected FishPopulation maturityDaysEndInit() {
    Wrap<BigDecimal> maturityDaysEndWrap = new Wrap<BigDecimal>().var("maturityDaysEnd");
    if(maturityDaysEnd == null) {
      _maturityDaysEnd(maturityDaysEndWrap);
      Optional.ofNullable(maturityDaysEndWrap.getO()).ifPresent(o -> {
        setMaturityDaysEnd(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchMaturityDaysEnd(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaturityDaysEnd(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaturityDaysEnd(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchMaturityDaysEnd(siteRequest_, FishPopulation.staticSetMaturityDaysEnd(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaturityDaysEnd() {
    return maturityDaysEnd;
  }

  public static String staticJsonMaturityDaysEnd(BigDecimal maturityDaysEnd) {
    return Optional.ofNullable(maturityDaysEnd).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // incubationDaysBegin //
	/////////////////////////


  /**
   *  The entity incubationDaysBegin
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal incubationDaysBegin;

  /**
   * <br> The entity incubationDaysBegin
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationDaysBegin">Find the entity incubationDaysBegin in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationDaysBegin(Wrap<BigDecimal> w);

  public BigDecimal getIncubationDaysBegin() {
    return incubationDaysBegin;
  }

  public void setIncubationDaysBegin(BigDecimal incubationDaysBegin) {
    this.incubationDaysBegin = incubationDaysBegin;
  }
  @JsonIgnore
  public void setIncubationDaysBegin(String o) {
    this.incubationDaysBegin = FishPopulation.staticSetIncubationDaysBegin(siteRequest_, o);
  }
  public static MathContext staticMathContextIncubationDaysBegin() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetIncubationDaysBegin(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextIncubationDaysBegin());
    return null;
  }
  @JsonIgnore
  public void setIncubationDaysBegin(Double o) {
    setIncubationDaysBegin(new BigDecimal(o, staticMathContextIncubationDaysBegin()));
  }
  @JsonIgnore
  public void setIncubationDaysBegin(Integer o) {
    setIncubationDaysBegin(new BigDecimal(o, staticMathContextIncubationDaysBegin()));
  }
  @JsonIgnore
  public void setIncubationDaysBegin(Number o) {
    setIncubationDaysBegin(new BigDecimal(o.doubleValue(), staticMathContextIncubationDaysBegin()));
  }
  protected FishPopulation incubationDaysBeginInit() {
    Wrap<BigDecimal> incubationDaysBeginWrap = new Wrap<BigDecimal>().var("incubationDaysBegin");
    if(incubationDaysBegin == null) {
      _incubationDaysBegin(incubationDaysBeginWrap);
      Optional.ofNullable(incubationDaysBeginWrap.getO()).ifPresent(o -> {
        setIncubationDaysBegin(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchIncubationDaysBegin(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrIncubationDaysBegin(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIncubationDaysBegin(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchIncubationDaysBegin(siteRequest_, FishPopulation.staticSetIncubationDaysBegin(siteRequest_, o)).toString();
  }

  public BigDecimal sqlIncubationDaysBegin() {
    return incubationDaysBegin;
  }

  public static String staticJsonIncubationDaysBegin(BigDecimal incubationDaysBegin) {
    return Optional.ofNullable(incubationDaysBegin).map(v -> v.toString()).orElse(null);
  }

	///////////////////////
  // incubationDaysEnd //
	///////////////////////


  /**
   *  The entity incubationDaysEnd
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal incubationDaysEnd;

  /**
   * <br> The entity incubationDaysEnd
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationDaysEnd">Find the entity incubationDaysEnd in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationDaysEnd(Wrap<BigDecimal> w);

  public BigDecimal getIncubationDaysEnd() {
    return incubationDaysEnd;
  }

  public void setIncubationDaysEnd(BigDecimal incubationDaysEnd) {
    this.incubationDaysEnd = incubationDaysEnd;
  }
  @JsonIgnore
  public void setIncubationDaysEnd(String o) {
    this.incubationDaysEnd = FishPopulation.staticSetIncubationDaysEnd(siteRequest_, o);
  }
  public static MathContext staticMathContextIncubationDaysEnd() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetIncubationDaysEnd(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextIncubationDaysEnd());
    return null;
  }
  @JsonIgnore
  public void setIncubationDaysEnd(Double o) {
    setIncubationDaysEnd(new BigDecimal(o, staticMathContextIncubationDaysEnd()));
  }
  @JsonIgnore
  public void setIncubationDaysEnd(Integer o) {
    setIncubationDaysEnd(new BigDecimal(o, staticMathContextIncubationDaysEnd()));
  }
  @JsonIgnore
  public void setIncubationDaysEnd(Number o) {
    setIncubationDaysEnd(new BigDecimal(o.doubleValue(), staticMathContextIncubationDaysEnd()));
  }
  protected FishPopulation incubationDaysEndInit() {
    Wrap<BigDecimal> incubationDaysEndWrap = new Wrap<BigDecimal>().var("incubationDaysEnd");
    if(incubationDaysEnd == null) {
      _incubationDaysEnd(incubationDaysEndWrap);
      Optional.ofNullable(incubationDaysEndWrap.getO()).ifPresent(o -> {
        setIncubationDaysEnd(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchIncubationDaysEnd(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrIncubationDaysEnd(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIncubationDaysEnd(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchIncubationDaysEnd(siteRequest_, FishPopulation.staticSetIncubationDaysEnd(siteRequest_, o)).toString();
  }

  public BigDecimal sqlIncubationDaysEnd() {
    return incubationDaysEnd;
  }

  public static String staticJsonIncubationDaysEnd(BigDecimal incubationDaysEnd) {
    return Optional.ofNullable(incubationDaysEnd).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // incubationNumberMin //
	/////////////////////////


  /**
   *  The entity incubationNumberMin
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal incubationNumberMin;

  /**
   * <br> The entity incubationNumberMin
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationNumberMin">Find the entity incubationNumberMin in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationNumberMin(Wrap<BigDecimal> w);

  public BigDecimal getIncubationNumberMin() {
    return incubationNumberMin;
  }

  public void setIncubationNumberMin(BigDecimal incubationNumberMin) {
    this.incubationNumberMin = incubationNumberMin;
  }
  @JsonIgnore
  public void setIncubationNumberMin(String o) {
    this.incubationNumberMin = FishPopulation.staticSetIncubationNumberMin(siteRequest_, o);
  }
  public static MathContext staticMathContextIncubationNumberMin() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetIncubationNumberMin(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextIncubationNumberMin());
    return null;
  }
  @JsonIgnore
  public void setIncubationNumberMin(Double o) {
    setIncubationNumberMin(new BigDecimal(o, staticMathContextIncubationNumberMin()));
  }
  @JsonIgnore
  public void setIncubationNumberMin(Integer o) {
    setIncubationNumberMin(new BigDecimal(o, staticMathContextIncubationNumberMin()));
  }
  @JsonIgnore
  public void setIncubationNumberMin(Number o) {
    setIncubationNumberMin(new BigDecimal(o.doubleValue(), staticMathContextIncubationNumberMin()));
  }
  protected FishPopulation incubationNumberMinInit() {
    Wrap<BigDecimal> incubationNumberMinWrap = new Wrap<BigDecimal>().var("incubationNumberMin");
    if(incubationNumberMin == null) {
      _incubationNumberMin(incubationNumberMinWrap);
      Optional.ofNullable(incubationNumberMinWrap.getO()).ifPresent(o -> {
        setIncubationNumberMin(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchIncubationNumberMin(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrIncubationNumberMin(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIncubationNumberMin(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchIncubationNumberMin(siteRequest_, FishPopulation.staticSetIncubationNumberMin(siteRequest_, o)).toString();
  }

  public BigDecimal sqlIncubationNumberMin() {
    return incubationNumberMin;
  }

  public static String staticJsonIncubationNumberMin(BigDecimal incubationNumberMin) {
    return Optional.ofNullable(incubationNumberMin).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // incubationNumberMax //
	/////////////////////////


  /**
   *  The entity incubationNumberMax
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal incubationNumberMax;

  /**
   * <br> The entity incubationNumberMax
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationNumberMax">Find the entity incubationNumberMax in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationNumberMax(Wrap<BigDecimal> w);

  public BigDecimal getIncubationNumberMax() {
    return incubationNumberMax;
  }

  public void setIncubationNumberMax(BigDecimal incubationNumberMax) {
    this.incubationNumberMax = incubationNumberMax;
  }
  @JsonIgnore
  public void setIncubationNumberMax(String o) {
    this.incubationNumberMax = FishPopulation.staticSetIncubationNumberMax(siteRequest_, o);
  }
  public static MathContext staticMathContextIncubationNumberMax() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetIncubationNumberMax(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextIncubationNumberMax());
    return null;
  }
  @JsonIgnore
  public void setIncubationNumberMax(Double o) {
    setIncubationNumberMax(new BigDecimal(o, staticMathContextIncubationNumberMax()));
  }
  @JsonIgnore
  public void setIncubationNumberMax(Integer o) {
    setIncubationNumberMax(new BigDecimal(o, staticMathContextIncubationNumberMax()));
  }
  @JsonIgnore
  public void setIncubationNumberMax(Number o) {
    setIncubationNumberMax(new BigDecimal(o.doubleValue(), staticMathContextIncubationNumberMax()));
  }
  protected FishPopulation incubationNumberMaxInit() {
    Wrap<BigDecimal> incubationNumberMaxWrap = new Wrap<BigDecimal>().var("incubationNumberMax");
    if(incubationNumberMax == null) {
      _incubationNumberMax(incubationNumberMaxWrap);
      Optional.ofNullable(incubationNumberMaxWrap.getO()).ifPresent(o -> {
        setIncubationNumberMax(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchIncubationNumberMax(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrIncubationNumberMax(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIncubationNumberMax(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchIncubationNumberMax(siteRequest_, FishPopulation.staticSetIncubationNumberMax(siteRequest_, o)).toString();
  }

  public BigDecimal sqlIncubationNumberMax() {
    return incubationNumberMax;
  }

  public static String staticJsonIncubationNumberMax(BigDecimal incubationNumberMax) {
    return Optional.ofNullable(incubationNumberMax).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////
  // percentPopulationPregnantMin //
	//////////////////////////////////


  /**
   *  The entity percentPopulationPregnantMin
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal percentPopulationPregnantMin;

  /**
   * <br> The entity percentPopulationPregnantMin
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:percentPopulationPregnantMin">Find the entity percentPopulationPregnantMin in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _percentPopulationPregnantMin(Wrap<BigDecimal> w);

  public BigDecimal getPercentPopulationPregnantMin() {
    return percentPopulationPregnantMin;
  }

  public void setPercentPopulationPregnantMin(BigDecimal percentPopulationPregnantMin) {
    this.percentPopulationPregnantMin = percentPopulationPregnantMin;
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMin(String o) {
    this.percentPopulationPregnantMin = FishPopulation.staticSetPercentPopulationPregnantMin(siteRequest_, o);
  }
  public static MathContext staticMathContextPercentPopulationPregnantMin() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetPercentPopulationPregnantMin(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextPercentPopulationPregnantMin());
    return null;
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMin(Double o) {
    setPercentPopulationPregnantMin(new BigDecimal(o, staticMathContextPercentPopulationPregnantMin()));
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMin(Integer o) {
    setPercentPopulationPregnantMin(new BigDecimal(o, staticMathContextPercentPopulationPregnantMin()));
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMin(Number o) {
    setPercentPopulationPregnantMin(new BigDecimal(o.doubleValue(), staticMathContextPercentPopulationPregnantMin()));
  }
  protected FishPopulation percentPopulationPregnantMinInit() {
    Wrap<BigDecimal> percentPopulationPregnantMinWrap = new Wrap<BigDecimal>().var("percentPopulationPregnantMin");
    if(percentPopulationPregnantMin == null) {
      _percentPopulationPregnantMin(percentPopulationPregnantMinWrap);
      Optional.ofNullable(percentPopulationPregnantMinWrap.getO()).ifPresent(o -> {
        setPercentPopulationPregnantMin(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchPercentPopulationPregnantMin(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrPercentPopulationPregnantMin(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPercentPopulationPregnantMin(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchPercentPopulationPregnantMin(siteRequest_, FishPopulation.staticSetPercentPopulationPregnantMin(siteRequest_, o)).toString();
  }

  public BigDecimal sqlPercentPopulationPregnantMin() {
    return percentPopulationPregnantMin;
  }

  public static String staticJsonPercentPopulationPregnantMin(BigDecimal percentPopulationPregnantMin) {
    return Optional.ofNullable(percentPopulationPregnantMin).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////
  // percentPopulationPregnantMax //
	//////////////////////////////////


  /**
   *  The entity percentPopulationPregnantMax
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal percentPopulationPregnantMax;

  /**
   * <br> The entity percentPopulationPregnantMax
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:percentPopulationPregnantMax">Find the entity percentPopulationPregnantMax in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _percentPopulationPregnantMax(Wrap<BigDecimal> w);

  public BigDecimal getPercentPopulationPregnantMax() {
    return percentPopulationPregnantMax;
  }

  public void setPercentPopulationPregnantMax(BigDecimal percentPopulationPregnantMax) {
    this.percentPopulationPregnantMax = percentPopulationPregnantMax;
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMax(String o) {
    this.percentPopulationPregnantMax = FishPopulation.staticSetPercentPopulationPregnantMax(siteRequest_, o);
  }
  public static MathContext staticMathContextPercentPopulationPregnantMax() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetPercentPopulationPregnantMax(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextPercentPopulationPregnantMax());
    return null;
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMax(Double o) {
    setPercentPopulationPregnantMax(new BigDecimal(o, staticMathContextPercentPopulationPregnantMax()));
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMax(Integer o) {
    setPercentPopulationPregnantMax(new BigDecimal(o, staticMathContextPercentPopulationPregnantMax()));
  }
  @JsonIgnore
  public void setPercentPopulationPregnantMax(Number o) {
    setPercentPopulationPregnantMax(new BigDecimal(o.doubleValue(), staticMathContextPercentPopulationPregnantMax()));
  }
  protected FishPopulation percentPopulationPregnantMaxInit() {
    Wrap<BigDecimal> percentPopulationPregnantMaxWrap = new Wrap<BigDecimal>().var("percentPopulationPregnantMax");
    if(percentPopulationPregnantMax == null) {
      _percentPopulationPregnantMax(percentPopulationPregnantMaxWrap);
      Optional.ofNullable(percentPopulationPregnantMaxWrap.getO()).ifPresent(o -> {
        setPercentPopulationPregnantMax(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchPercentPopulationPregnantMax(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrPercentPopulationPregnantMax(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPercentPopulationPregnantMax(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchPercentPopulationPregnantMax(siteRequest_, FishPopulation.staticSetPercentPopulationPregnantMax(siteRequest_, o)).toString();
  }

  public BigDecimal sqlPercentPopulationPregnantMax() {
    return percentPopulationPregnantMax;
  }

  public static String staticJsonPercentPopulationPregnantMax(BigDecimal percentPopulationPregnantMax) {
    return Optional.ofNullable(percentPopulationPregnantMax).map(v -> v.toString()).orElse(null);
  }

	////////////////////////
  // populationsAtBirth //
	////////////////////////


  /**
   *  The entity populationsAtBirth
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<Long> populationsAtBirth = new ArrayList<Long>();

  /**
   * <br> The entity populationsAtBirth
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:populationsAtBirth">Find the entity populationsAtBirth in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _populationsAtBirth(List<Long> l);

  public List<Long> getPopulationsAtBirth() {
    return populationsAtBirth;
  }

  public void setPopulationsAtBirth(List<Long> populationsAtBirth) {
    this.populationsAtBirth = populationsAtBirth;
  }
  @JsonIgnore
  public void setPopulationsAtBirth(String o) {
    Long l = FishPopulation.staticSetPopulationsAtBirth(siteRequest_, o);
    if(l != null)
      addPopulationsAtBirth(l);
  }
  public static Long staticSetPopulationsAtBirth(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  public FishPopulation addPopulationsAtBirth(Long...objects) {
    for(Long o : objects) {
      addPopulationsAtBirth(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addPopulationsAtBirth(Long o) {
    if(o != null)
      this.populationsAtBirth.add(o);
    return (FishPopulation)this;
  }
  @JsonIgnore
  public void setPopulationsAtBirth(JsonArray objects) {
    populationsAtBirth.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      setPopulationsAtBirth(o);
    }
  }
  public FishPopulation addPopulationsAtBirth(String o) {
    if(NumberUtils.isParsable(o)) {
      Long p = Long.parseLong(o);
      addPopulationsAtBirth(p);
    }
    return (FishPopulation)this;
  }
  protected FishPopulation populationsAtBirthInit() {
    _populationsAtBirth(populationsAtBirth);
    return (FishPopulation)this;
  }

  public static Long staticSearchPopulationsAtBirth(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPopulationsAtBirth(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPopulationsAtBirth(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchPopulationsAtBirth(siteRequest_, FishPopulation.staticSetPopulationsAtBirth(siteRequest_, o)).toString();
  }

  public Number[] sqlPopulationsAtBirth() {
    return populationsAtBirth.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonPopulationsAtBirth(List<Long> populationsAtBirth) {
    JsonArray a = new JsonArray();
    populationsAtBirth.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////
  // populationsNow //
	////////////////////


  /**
   *  The entity populationsNow
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<Long> populationsNow = new ArrayList<Long>();

  /**
   * <br> The entity populationsNow
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:populationsNow">Find the entity populationsNow in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _populationsNow(List<Long> l);

  public List<Long> getPopulationsNow() {
    return populationsNow;
  }

  public void setPopulationsNow(List<Long> populationsNow) {
    this.populationsNow = populationsNow;
  }
  @JsonIgnore
  public void setPopulationsNow(String o) {
    Long l = FishPopulation.staticSetPopulationsNow(siteRequest_, o);
    if(l != null)
      addPopulationsNow(l);
  }
  public static Long staticSetPopulationsNow(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  public FishPopulation addPopulationsNow(Long...objects) {
    for(Long o : objects) {
      addPopulationsNow(o);
    }
    return (FishPopulation)this;
  }
  public FishPopulation addPopulationsNow(Long o) {
    if(o != null)
      this.populationsNow.add(o);
    return (FishPopulation)this;
  }
  @JsonIgnore
  public void setPopulationsNow(JsonArray objects) {
    populationsNow.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      setPopulationsNow(o);
    }
  }
  public FishPopulation addPopulationsNow(String o) {
    if(NumberUtils.isParsable(o)) {
      Long p = Long.parseLong(o);
      addPopulationsNow(p);
    }
    return (FishPopulation)this;
  }
  protected FishPopulation populationsNowInit() {
    _populationsNow(populationsNow);
    return (FishPopulation)this;
  }

  public static Long staticSearchPopulationsNow(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPopulationsNow(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPopulationsNow(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchPopulationsNow(siteRequest_, FishPopulation.staticSetPopulationsNow(siteRequest_, o)).toString();
  }

  public Number[] sqlPopulationsNow() {
    return populationsNow.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonPopulationsNow(List<Long> populationsNow) {
    JsonArray a = new JsonArray();
    populationsNow.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////
  // incubationDate //
	////////////////////


  /**
   *  The entity incubationDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime incubationDate;

  /**
   * <br> The entity incubationDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationDate">Find the entity incubationDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationDate(Wrap<ZonedDateTime> w);

  public ZonedDateTime getIncubationDate() {
    return incubationDate;
  }

  public void setIncubationDate(ZonedDateTime incubationDate) {
    this.incubationDate = Optional.ofNullable(incubationDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setIncubationDate(Instant o) {
    this.incubationDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setIncubationDate(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.incubationDate = FishPopulation.staticSetIncubationDate(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setIncubationDate(Date o) {
    this.incubationDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetIncubationDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected FishPopulation incubationDateInit() {
    Wrap<ZonedDateTime> incubationDateWrap = new Wrap<ZonedDateTime>().var("incubationDate");
    if(incubationDate == null) {
      _incubationDate(incubationDateWrap);
      Optional.ofNullable(incubationDateWrap.getO()).ifPresent(o -> {
        setIncubationDate(o);
      });
    }
    return (FishPopulation)this;
  }

  public static String staticSearchIncubationDate(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrIncubationDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return FishPopulation.staticSearchIncubationDate(siteRequest_, FishPopulation.staticSetIncubationDate(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqIncubationDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return FishPopulation.staticSearchIncubationDate(siteRequest_, FishPopulation.staticSetIncubationDate(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlIncubationDate() {
    return incubationDate == null ? null : incubationDate.toOffsetDateTime();
  }

  public static String staticJsonIncubationDate(ZonedDateTime incubationDate) {
    return Optional.ofNullable(incubationDate).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	////////////////////////
  // previousPopulation //
	////////////////////////


  /**
   *  The entity previousPopulation
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long previousPopulation;

  /**
   * <br> The entity previousPopulation
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:previousPopulation">Find the entity previousPopulation in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _previousPopulation(Wrap<Long> w);

  public Long getPreviousPopulation() {
    return previousPopulation;
  }

  public void setPreviousPopulation(Long previousPopulation) {
    this.previousPopulation = previousPopulation;
  }
  @JsonIgnore
  public void setPreviousPopulation(String o) {
    this.previousPopulation = FishPopulation.staticSetPreviousPopulation(siteRequest_, o);
  }
  public static Long staticSetPreviousPopulation(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishPopulation previousPopulationInit() {
    Wrap<Long> previousPopulationWrap = new Wrap<Long>().var("previousPopulation");
    if(previousPopulation == null) {
      _previousPopulation(previousPopulationWrap);
      Optional.ofNullable(previousPopulationWrap.getO()).ifPresent(o -> {
        setPreviousPopulation(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Long staticSearchPreviousPopulation(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPreviousPopulation(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPreviousPopulation(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchPreviousPopulation(siteRequest_, FishPopulation.staticSetPreviousPopulation(siteRequest_, o)).toString();
  }

  public Long sqlPreviousPopulation() {
    return previousPopulation;
  }

  public static String staticJsonPreviousPopulation(Long previousPopulation) {
    return Optional.ofNullable(previousPopulation).map(v -> v.toString()).orElse(null);
  }

	///////////////////////
  // incubationDaysNow //
	///////////////////////


  /**
   *  The entity incubationDaysNow
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal incubationDaysNow;

  /**
   * <br> The entity incubationDaysNow
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:incubationDaysNow">Find the entity incubationDaysNow in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _incubationDaysNow(Wrap<BigDecimal> w);

  public BigDecimal getIncubationDaysNow() {
    return incubationDaysNow;
  }

  public void setIncubationDaysNow(BigDecimal incubationDaysNow) {
    this.incubationDaysNow = incubationDaysNow;
  }
  @JsonIgnore
  public void setIncubationDaysNow(String o) {
    this.incubationDaysNow = FishPopulation.staticSetIncubationDaysNow(siteRequest_, o);
  }
  public static MathContext staticMathContextIncubationDaysNow() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetIncubationDaysNow(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextIncubationDaysNow());
    return null;
  }
  @JsonIgnore
  public void setIncubationDaysNow(Double o) {
    setIncubationDaysNow(new BigDecimal(o, staticMathContextIncubationDaysNow()));
  }
  @JsonIgnore
  public void setIncubationDaysNow(Integer o) {
    setIncubationDaysNow(new BigDecimal(o, staticMathContextIncubationDaysNow()));
  }
  @JsonIgnore
  public void setIncubationDaysNow(Number o) {
    setIncubationDaysNow(new BigDecimal(o.doubleValue(), staticMathContextIncubationDaysNow()));
  }
  protected FishPopulation incubationDaysNowInit() {
    Wrap<BigDecimal> incubationDaysNowWrap = new Wrap<BigDecimal>().var("incubationDaysNow");
    if(incubationDaysNow == null) {
      _incubationDaysNow(incubationDaysNowWrap);
      Optional.ofNullable(incubationDaysNowWrap.getO()).ifPresent(o -> {
        setIncubationDaysNow(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchIncubationDaysNow(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrIncubationDaysNow(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIncubationDaysNow(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchIncubationDaysNow(siteRequest_, FishPopulation.staticSetIncubationDaysNow(siteRequest_, o)).toString();
  }

  public BigDecimal sqlIncubationDaysNow() {
    return incubationDaysNow;
  }

  public static String staticJsonIncubationDaysNow(BigDecimal incubationDaysNow) {
    return Optional.ofNullable(incubationDaysNow).map(v -> v.toString()).orElse(null);
  }

	//////////////////////
  // waterTemperature //
	//////////////////////


  /**
   *  The entity waterTemperature
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal waterTemperature;

  /**
   * <br> The entity waterTemperature
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:waterTemperature">Find the entity waterTemperature in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _waterTemperature(Wrap<BigDecimal> w);

  public BigDecimal getWaterTemperature() {
    return waterTemperature;
  }

  public void setWaterTemperature(BigDecimal waterTemperature) {
    this.waterTemperature = waterTemperature;
  }
  @JsonIgnore
  public void setWaterTemperature(String o) {
    this.waterTemperature = FishPopulation.staticSetWaterTemperature(siteRequest_, o);
  }
  public static MathContext staticMathContextWaterTemperature() {
    return new MathContext(3, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetWaterTemperature(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextWaterTemperature());
    return null;
  }
  @JsonIgnore
  public void setWaterTemperature(Double o) {
    setWaterTemperature(new BigDecimal(o, staticMathContextWaterTemperature()));
  }
  @JsonIgnore
  public void setWaterTemperature(Integer o) {
    setWaterTemperature(new BigDecimal(o, staticMathContextWaterTemperature()));
  }
  @JsonIgnore
  public void setWaterTemperature(Number o) {
    setWaterTemperature(new BigDecimal(o.doubleValue(), staticMathContextWaterTemperature()));
  }
  protected FishPopulation waterTemperatureInit() {
    Wrap<BigDecimal> waterTemperatureWrap = new Wrap<BigDecimal>().var("waterTemperature");
    if(waterTemperature == null) {
      _waterTemperature(waterTemperatureWrap);
      Optional.ofNullable(waterTemperatureWrap.getO()).ifPresent(o -> {
        setWaterTemperature(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchWaterTemperature(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrWaterTemperature(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqWaterTemperature(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchWaterTemperature(siteRequest_, FishPopulation.staticSetWaterTemperature(siteRequest_, o)).toString();
  }

  public BigDecimal sqlWaterTemperature() {
    return waterTemperature;
  }

  public static String staticJsonWaterTemperature(BigDecimal waterTemperature) {
    return Optional.ofNullable(waterTemperature).map(v -> v.toString()).orElse(null);
  }

	///////////////////
  // waterSalinity //
	///////////////////


  /**
   *  The entity waterSalinity
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal waterSalinity;

  /**
   * <br> The entity waterSalinity
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:waterSalinity">Find the entity waterSalinity in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _waterSalinity(Wrap<BigDecimal> w);

  public BigDecimal getWaterSalinity() {
    return waterSalinity;
  }

  public void setWaterSalinity(BigDecimal waterSalinity) {
    this.waterSalinity = waterSalinity;
  }
  @JsonIgnore
  public void setWaterSalinity(String o) {
    this.waterSalinity = FishPopulation.staticSetWaterSalinity(siteRequest_, o);
  }
  public static MathContext staticMathContextWaterSalinity() {
    return new MathContext(3, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetWaterSalinity(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextWaterSalinity());
    return null;
  }
  @JsonIgnore
  public void setWaterSalinity(Double o) {
    setWaterSalinity(new BigDecimal(o, staticMathContextWaterSalinity()));
  }
  @JsonIgnore
  public void setWaterSalinity(Integer o) {
    setWaterSalinity(new BigDecimal(o, staticMathContextWaterSalinity()));
  }
  @JsonIgnore
  public void setWaterSalinity(Number o) {
    setWaterSalinity(new BigDecimal(o.doubleValue(), staticMathContextWaterSalinity()));
  }
  protected FishPopulation waterSalinityInit() {
    Wrap<BigDecimal> waterSalinityWrap = new Wrap<BigDecimal>().var("waterSalinity");
    if(waterSalinity == null) {
      _waterSalinity(waterSalinityWrap);
      Optional.ofNullable(waterSalinityWrap.getO()).ifPresent(o -> {
        setWaterSalinity(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchWaterSalinity(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrWaterSalinity(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqWaterSalinity(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchWaterSalinity(siteRequest_, FishPopulation.staticSetWaterSalinity(siteRequest_, o)).toString();
  }

  public BigDecimal sqlWaterSalinity() {
    return waterSalinity;
  }

  public static String staticJsonWaterSalinity(BigDecimal waterSalinity) {
    return Optional.ofNullable(waterSalinity).map(v -> v.toString()).orElse(null);
  }

	/////////////////
  // waterOxygen //
	/////////////////


  /**
   *  The entity waterOxygen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal waterOxygen;

  /**
   * <br> The entity waterOxygen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:waterOxygen">Find the entity waterOxygen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _waterOxygen(Wrap<BigDecimal> w);

  public BigDecimal getWaterOxygen() {
    return waterOxygen;
  }

  public void setWaterOxygen(BigDecimal waterOxygen) {
    this.waterOxygen = waterOxygen;
  }
  @JsonIgnore
  public void setWaterOxygen(String o) {
    this.waterOxygen = FishPopulation.staticSetWaterOxygen(siteRequest_, o);
  }
  public static MathContext staticMathContextWaterOxygen() {
    return new MathContext(3, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetWaterOxygen(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextWaterOxygen());
    return null;
  }
  @JsonIgnore
  public void setWaterOxygen(Double o) {
    setWaterOxygen(new BigDecimal(o, staticMathContextWaterOxygen()));
  }
  @JsonIgnore
  public void setWaterOxygen(Integer o) {
    setWaterOxygen(new BigDecimal(o, staticMathContextWaterOxygen()));
  }
  @JsonIgnore
  public void setWaterOxygen(Number o) {
    setWaterOxygen(new BigDecimal(o.doubleValue(), staticMathContextWaterOxygen()));
  }
  protected FishPopulation waterOxygenInit() {
    Wrap<BigDecimal> waterOxygenWrap = new Wrap<BigDecimal>().var("waterOxygen");
    if(waterOxygen == null) {
      _waterOxygen(waterOxygenWrap);
      Optional.ofNullable(waterOxygenWrap.getO()).ifPresent(o -> {
        setWaterOxygen(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchWaterOxygen(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrWaterOxygen(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqWaterOxygen(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchWaterOxygen(siteRequest_, FishPopulation.staticSetWaterOxygen(siteRequest_, o)).toString();
  }

  public BigDecimal sqlWaterOxygen() {
    return waterOxygen;
  }

  public static String staticJsonWaterOxygen(BigDecimal waterOxygen) {
    return Optional.ofNullable(waterOxygen).map(v -> v.toString()).orElse(null);
  }

	/////////////
  // waterPh //
	/////////////


  /**
   *  The entity waterPh
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal waterPh;

  /**
   * <br> The entity waterPh
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:waterPh">Find the entity waterPh in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _waterPh(Wrap<BigDecimal> w);

  public BigDecimal getWaterPh() {
    return waterPh;
  }

  public void setWaterPh(BigDecimal waterPh) {
    this.waterPh = waterPh;
  }
  @JsonIgnore
  public void setWaterPh(String o) {
    this.waterPh = FishPopulation.staticSetWaterPh(siteRequest_, o);
  }
  public static MathContext staticMathContextWaterPh() {
    return new MathContext(3, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetWaterPh(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextWaterPh());
    return null;
  }
  @JsonIgnore
  public void setWaterPh(Double o) {
    setWaterPh(new BigDecimal(o, staticMathContextWaterPh()));
  }
  @JsonIgnore
  public void setWaterPh(Integer o) {
    setWaterPh(new BigDecimal(o, staticMathContextWaterPh()));
  }
  @JsonIgnore
  public void setWaterPh(Number o) {
    setWaterPh(new BigDecimal(o.doubleValue(), staticMathContextWaterPh()));
  }
  protected FishPopulation waterPhInit() {
    Wrap<BigDecimal> waterPhWrap = new Wrap<BigDecimal>().var("waterPh");
    if(waterPh == null) {
      _waterPh(waterPhWrap);
      Optional.ofNullable(waterPhWrap.getO()).ifPresent(o -> {
        setWaterPh(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Double staticSearchWaterPh(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrWaterPh(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqWaterPh(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchWaterPh(siteRequest_, FishPopulation.staticSetWaterPh(siteRequest_, o)).toString();
  }

  public BigDecimal sqlWaterPh() {
    return waterPh;
  }

  public static String staticJsonWaterPh(BigDecimal waterPh) {
    return Optional.ofNullable(waterPh).map(v -> v.toString()).orElse(null);
  }

	////////////////
  // simulation //
	////////////////


  /**
   *  The entity simulation
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean simulation;

  /**
   * <br> The entity simulation
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:simulation">Find the entity simulation in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _simulation(Wrap<Boolean> w);

  public Boolean getSimulation() {
    return simulation;
  }

  public void setSimulation(Boolean simulation) {
    this.simulation = simulation;
  }
  @JsonIgnore
  public void setSimulation(String o) {
    this.simulation = FishPopulation.staticSetSimulation(siteRequest_, o);
  }
  public static Boolean staticSetSimulation(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected FishPopulation simulationInit() {
    Wrap<Boolean> simulationWrap = new Wrap<Boolean>().var("simulation");
    if(simulation == null) {
      _simulation(simulationWrap);
      Optional.ofNullable(simulationWrap.getO()).ifPresent(o -> {
        setSimulation(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Boolean staticSearchSimulation(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrSimulation(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSimulation(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchSimulation(siteRequest_, FishPopulation.staticSetSimulation(siteRequest_, o)).toString();
  }

  public Boolean sqlSimulation() {
    return simulation;
  }

  public static Boolean staticJsonSimulation(Boolean simulation) {
    return simulation;
  }

	///////////////////////////
  // simulationDelayMillis //
	///////////////////////////


  /**
   *  The entity simulationDelayMillis
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long simulationDelayMillis;

  /**
   * <br> The entity simulationDelayMillis
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulation&fq=entiteVar_enUS_indexed_string:simulationDelayMillis">Find the entity simulationDelayMillis in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _simulationDelayMillis(Wrap<Long> w);

  public Long getSimulationDelayMillis() {
    return simulationDelayMillis;
  }

  public void setSimulationDelayMillis(Long simulationDelayMillis) {
    this.simulationDelayMillis = simulationDelayMillis;
  }
  @JsonIgnore
  public void setSimulationDelayMillis(String o) {
    this.simulationDelayMillis = FishPopulation.staticSetSimulationDelayMillis(siteRequest_, o);
  }
  public static Long staticSetSimulationDelayMillis(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected FishPopulation simulationDelayMillisInit() {
    Wrap<Long> simulationDelayMillisWrap = new Wrap<Long>().var("simulationDelayMillis");
    if(simulationDelayMillis == null) {
      _simulationDelayMillis(simulationDelayMillisWrap);
      Optional.ofNullable(simulationDelayMillisWrap.getO()).ifPresent(o -> {
        setSimulationDelayMillis(o);
      });
    }
    return (FishPopulation)this;
  }

  public static Long staticSearchSimulationDelayMillis(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrSimulationDelayMillis(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSimulationDelayMillis(SiteRequest siteRequest_, String o) {
    return FishPopulation.staticSearchSimulationDelayMillis(siteRequest_, FishPopulation.staticSetSimulationDelayMillis(siteRequest_, o)).toString();
  }

  public Long sqlSimulationDelayMillis() {
    return simulationDelayMillis;
  }

  public static String staticJsonSimulationDelayMillis(Long simulationDelayMillis) {
    return Optional.ofNullable(simulationDelayMillis).map(v -> v.toString()).orElse(null);
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
        areaServedColorsInit();
        areaServedTitlesInit();
        areaServedLinksInit();
        areaServedInit();
        scientificNameInit();
        maturityDaysBeginInit();
        maturityDaysEndInit();
        incubationDaysBeginInit();
        incubationDaysEndInit();
        incubationNumberMinInit();
        incubationNumberMaxInit();
        percentPopulationPregnantMinInit();
        percentPopulationPregnantMaxInit();
        populationsAtBirthInit();
        populationsNowInit();
        incubationDateInit();
        previousPopulationInit();
        incubationDaysNowInit();
        waterTemperatureInit();
        waterSalinityInit();
        waterOxygenInit();
        waterPhInit();
        simulationInit();
        simulationDelayMillisInit();
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
      case "areaServedColors":
        return oFishPopulation.areaServedColors;
      case "areaServedTitles":
        return oFishPopulation.areaServedTitles;
      case "areaServedLinks":
        return oFishPopulation.areaServedLinks;
      case "areaServed":
        return oFishPopulation.areaServed;
      case "scientificName":
        return oFishPopulation.scientificName;
      case "maturityDaysBegin":
        return oFishPopulation.maturityDaysBegin;
      case "maturityDaysEnd":
        return oFishPopulation.maturityDaysEnd;
      case "incubationDaysBegin":
        return oFishPopulation.incubationDaysBegin;
      case "incubationDaysEnd":
        return oFishPopulation.incubationDaysEnd;
      case "incubationNumberMin":
        return oFishPopulation.incubationNumberMin;
      case "incubationNumberMax":
        return oFishPopulation.incubationNumberMax;
      case "percentPopulationPregnantMin":
        return oFishPopulation.percentPopulationPregnantMin;
      case "percentPopulationPregnantMax":
        return oFishPopulation.percentPopulationPregnantMax;
      case "populationsAtBirth":
        return oFishPopulation.populationsAtBirth;
      case "populationsNow":
        return oFishPopulation.populationsNow;
      case "incubationDate":
        return oFishPopulation.incubationDate;
      case "previousPopulation":
        return oFishPopulation.previousPopulation;
      case "incubationDaysNow":
        return oFishPopulation.incubationDaysNow;
      case "waterTemperature":
        return oFishPopulation.waterTemperature;
      case "waterSalinity":
        return oFishPopulation.waterSalinity;
      case "waterOxygen":
        return oFishPopulation.waterOxygen;
      case "waterPh":
        return oFishPopulation.waterPh;
      case "simulation":
        return oFishPopulation.simulation;
      case "simulationDelayMillis":
        return oFishPopulation.simulationDelayMillis;
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
    case "areaServedColors":
      return FishPopulation.staticSetAreaServedColors(siteRequest_, v);
    case "areaServedTitles":
      return FishPopulation.staticSetAreaServedTitles(siteRequest_, v);
    case "areaServedLinks":
      return FishPopulation.staticSetAreaServedLinks(siteRequest_, v);
    case "areaServed":
      return FishPopulation.staticSetAreaServed(siteRequest_, v);
    case "scientificName":
      return FishPopulation.staticSetScientificName(siteRequest_, v);
    case "maturityDaysBegin":
      return FishPopulation.staticSetMaturityDaysBegin(siteRequest_, v);
    case "maturityDaysEnd":
      return FishPopulation.staticSetMaturityDaysEnd(siteRequest_, v);
    case "incubationDaysBegin":
      return FishPopulation.staticSetIncubationDaysBegin(siteRequest_, v);
    case "incubationDaysEnd":
      return FishPopulation.staticSetIncubationDaysEnd(siteRequest_, v);
    case "incubationNumberMin":
      return FishPopulation.staticSetIncubationNumberMin(siteRequest_, v);
    case "incubationNumberMax":
      return FishPopulation.staticSetIncubationNumberMax(siteRequest_, v);
    case "percentPopulationPregnantMin":
      return FishPopulation.staticSetPercentPopulationPregnantMin(siteRequest_, v);
    case "percentPopulationPregnantMax":
      return FishPopulation.staticSetPercentPopulationPregnantMax(siteRequest_, v);
    case "populationsAtBirth":
      return FishPopulation.staticSetPopulationsAtBirth(siteRequest_, v);
    case "populationsNow":
      return FishPopulation.staticSetPopulationsNow(siteRequest_, v);
    case "incubationDate":
    case "previousPopulation":
      return FishPopulation.staticSetPreviousPopulation(siteRequest_, v);
    case "incubationDaysNow":
      return FishPopulation.staticSetIncubationDaysNow(siteRequest_, v);
    case "waterTemperature":
      return FishPopulation.staticSetWaterTemperature(siteRequest_, v);
    case "waterSalinity":
      return FishPopulation.staticSetWaterSalinity(siteRequest_, v);
    case "waterOxygen":
      return FishPopulation.staticSetWaterOxygen(siteRequest_, v);
    case "waterPh":
      return FishPopulation.staticSetWaterPh(siteRequest_, v);
    case "simulation":
      return FishPopulation.staticSetSimulation(siteRequest_, v);
    case "simulationDelayMillis":
      return FishPopulation.staticSetSimulationDelayMillis(siteRequest_, v);
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
    case "areaServedColors":
      return FishPopulation.staticSearchAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return FishPopulation.staticSearchAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return FishPopulation.staticSearchAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return FishPopulation.staticSearchAreaServed(siteRequest_, (Polygon)o);
    case "scientificName":
      return FishPopulation.staticSearchScientificName(siteRequest_, (String)o);
    case "maturityDaysBegin":
      return FishPopulation.staticSearchMaturityDaysBegin(siteRequest_, (BigDecimal)o);
    case "maturityDaysEnd":
      return FishPopulation.staticSearchMaturityDaysEnd(siteRequest_, (BigDecimal)o);
    case "incubationDaysBegin":
      return FishPopulation.staticSearchIncubationDaysBegin(siteRequest_, (BigDecimal)o);
    case "incubationDaysEnd":
      return FishPopulation.staticSearchIncubationDaysEnd(siteRequest_, (BigDecimal)o);
    case "incubationNumberMin":
      return FishPopulation.staticSearchIncubationNumberMin(siteRequest_, (BigDecimal)o);
    case "incubationNumberMax":
      return FishPopulation.staticSearchIncubationNumberMax(siteRequest_, (BigDecimal)o);
    case "percentPopulationPregnantMin":
      return FishPopulation.staticSearchPercentPopulationPregnantMin(siteRequest_, (BigDecimal)o);
    case "percentPopulationPregnantMax":
      return FishPopulation.staticSearchPercentPopulationPregnantMax(siteRequest_, (BigDecimal)o);
    case "populationsAtBirth":
      return FishPopulation.staticSearchPopulationsAtBirth(siteRequest_, (Long)o);
    case "populationsNow":
      return FishPopulation.staticSearchPopulationsNow(siteRequest_, (Long)o);
    case "incubationDate":
      return FishPopulation.staticSearchIncubationDate(siteRequest_, (ZonedDateTime)o);
    case "previousPopulation":
      return FishPopulation.staticSearchPreviousPopulation(siteRequest_, (Long)o);
    case "incubationDaysNow":
      return FishPopulation.staticSearchIncubationDaysNow(siteRequest_, (BigDecimal)o);
    case "waterTemperature":
      return FishPopulation.staticSearchWaterTemperature(siteRequest_, (BigDecimal)o);
    case "waterSalinity":
      return FishPopulation.staticSearchWaterSalinity(siteRequest_, (BigDecimal)o);
    case "waterOxygen":
      return FishPopulation.staticSearchWaterOxygen(siteRequest_, (BigDecimal)o);
    case "waterPh":
      return FishPopulation.staticSearchWaterPh(siteRequest_, (BigDecimal)o);
    case "simulation":
      return FishPopulation.staticSearchSimulation(siteRequest_, (Boolean)o);
    case "simulationDelayMillis":
      return FishPopulation.staticSearchSimulationDelayMillis(siteRequest_, (Long)o);
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
    case "areaServedColors":
      return FishPopulation.staticSearchStrAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return FishPopulation.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return FishPopulation.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return FishPopulation.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
    case "scientificName":
      return FishPopulation.staticSearchStrScientificName(siteRequest_, (String)o);
    case "maturityDaysBegin":
      return FishPopulation.staticSearchStrMaturityDaysBegin(siteRequest_, (Double)o);
    case "maturityDaysEnd":
      return FishPopulation.staticSearchStrMaturityDaysEnd(siteRequest_, (Double)o);
    case "incubationDaysBegin":
      return FishPopulation.staticSearchStrIncubationDaysBegin(siteRequest_, (Double)o);
    case "incubationDaysEnd":
      return FishPopulation.staticSearchStrIncubationDaysEnd(siteRequest_, (Double)o);
    case "incubationNumberMin":
      return FishPopulation.staticSearchStrIncubationNumberMin(siteRequest_, (Double)o);
    case "incubationNumberMax":
      return FishPopulation.staticSearchStrIncubationNumberMax(siteRequest_, (Double)o);
    case "percentPopulationPregnantMin":
      return FishPopulation.staticSearchStrPercentPopulationPregnantMin(siteRequest_, (Double)o);
    case "percentPopulationPregnantMax":
      return FishPopulation.staticSearchStrPercentPopulationPregnantMax(siteRequest_, (Double)o);
    case "populationsAtBirth":
      return FishPopulation.staticSearchStrPopulationsAtBirth(siteRequest_, (Long)o);
    case "populationsNow":
      return FishPopulation.staticSearchStrPopulationsNow(siteRequest_, (Long)o);
    case "incubationDate":
      return FishPopulation.staticSearchStrIncubationDate(siteRequest_, (String)o);
    case "previousPopulation":
      return FishPopulation.staticSearchStrPreviousPopulation(siteRequest_, (Long)o);
    case "incubationDaysNow":
      return FishPopulation.staticSearchStrIncubationDaysNow(siteRequest_, (Double)o);
    case "waterTemperature":
      return FishPopulation.staticSearchStrWaterTemperature(siteRequest_, (Double)o);
    case "waterSalinity":
      return FishPopulation.staticSearchStrWaterSalinity(siteRequest_, (Double)o);
    case "waterOxygen":
      return FishPopulation.staticSearchStrWaterOxygen(siteRequest_, (Double)o);
    case "waterPh":
      return FishPopulation.staticSearchStrWaterPh(siteRequest_, (Double)o);
    case "simulation":
      return FishPopulation.staticSearchStrSimulation(siteRequest_, (Boolean)o);
    case "simulationDelayMillis":
      return FishPopulation.staticSearchStrSimulationDelayMillis(siteRequest_, (Long)o);
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
    case "areaServedColors":
      return FishPopulation.staticSearchFqAreaServedColors(siteRequest_, o);
    case "areaServedTitles":
      return FishPopulation.staticSearchFqAreaServedTitles(siteRequest_, o);
    case "areaServedLinks":
      return FishPopulation.staticSearchFqAreaServedLinks(siteRequest_, o);
    case "areaServed":
      return FishPopulation.staticSearchFqAreaServed(siteRequest_, o);
    case "scientificName":
      return FishPopulation.staticSearchFqScientificName(siteRequest_, o);
    case "maturityDaysBegin":
      return FishPopulation.staticSearchFqMaturityDaysBegin(siteRequest_, o);
    case "maturityDaysEnd":
      return FishPopulation.staticSearchFqMaturityDaysEnd(siteRequest_, o);
    case "incubationDaysBegin":
      return FishPopulation.staticSearchFqIncubationDaysBegin(siteRequest_, o);
    case "incubationDaysEnd":
      return FishPopulation.staticSearchFqIncubationDaysEnd(siteRequest_, o);
    case "incubationNumberMin":
      return FishPopulation.staticSearchFqIncubationNumberMin(siteRequest_, o);
    case "incubationNumberMax":
      return FishPopulation.staticSearchFqIncubationNumberMax(siteRequest_, o);
    case "percentPopulationPregnantMin":
      return FishPopulation.staticSearchFqPercentPopulationPregnantMin(siteRequest_, o);
    case "percentPopulationPregnantMax":
      return FishPopulation.staticSearchFqPercentPopulationPregnantMax(siteRequest_, o);
    case "populationsAtBirth":
      return FishPopulation.staticSearchFqPopulationsAtBirth(siteRequest_, o);
    case "populationsNow":
      return FishPopulation.staticSearchFqPopulationsNow(siteRequest_, o);
    case "incubationDate":
      return FishPopulation.staticSearchFqIncubationDate(siteRequest_, o);
    case "previousPopulation":
      return FishPopulation.staticSearchFqPreviousPopulation(siteRequest_, o);
    case "incubationDaysNow":
      return FishPopulation.staticSearchFqIncubationDaysNow(siteRequest_, o);
    case "waterTemperature":
      return FishPopulation.staticSearchFqWaterTemperature(siteRequest_, o);
    case "waterSalinity":
      return FishPopulation.staticSearchFqWaterSalinity(siteRequest_, o);
    case "waterOxygen":
      return FishPopulation.staticSearchFqWaterOxygen(siteRequest_, o);
    case "waterPh":
      return FishPopulation.staticSearchFqWaterPh(siteRequest_, o);
    case "simulation":
      return FishPopulation.staticSearchFqSimulation(siteRequest_, o);
    case "simulationDelayMillis":
      return FishPopulation.staticSearchFqSimulationDelayMillis(siteRequest_, o);
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
        } else if(val instanceof BigDecimal) {
          setBodyMasse((BigDecimal)val);
        }
        saves.add("bodyMasse");
        return val;
      } else if("culturedin".equals(varLower)) {
        if(val instanceof String) {
          setCulturedIn((String)val);
        } else if(val instanceof Number) {
          setCulturedIn(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setCulturedIn((BigDecimal)val);
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
        } else if(val instanceof BigDecimal) {
          setFishRemoved((BigDecimal)val);
        }
        saves.add("fishRemoved");
        return val;
      } else if("initialnumber".equals(varLower)) {
        if(val instanceof String) {
          setInitialNumber((String)val);
        } else if(val instanceof Number) {
          setInitialNumber(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setInitialNumber((BigDecimal)val);
        }
        saves.add("initialNumber");
        return val;
      } else if("owner".equals(varLower)) {
        if(val instanceof String) {
          setOwner((String)val);
        } else if(val instanceof JsonObject) {
          setOwner((JsonObject)val);
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
        } else if(val instanceof BigDecimal) {
          setRefSpecie((BigDecimal)val);
        }
        saves.add("refSpecie");
        return val;
      } else if("relatedsource".equals(varLower)) {
        if(val instanceof String) {
          setRelatedSource((String)val);
        } else if(val instanceof JsonObject) {
          setRelatedSource((JsonObject)val);
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
      } else if("areaserved".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<Polygon>)val).stream().forEach(v -> addAreaServed(v));
        } else if(val instanceof Polygon[]) {
          Arrays.asList((Polygon[])val).stream().forEach(v -> addAreaServed((Polygon)v));
        } else if(val instanceof JsonObject) {
          Optional.ofNullable(staticSetAreaServed(siteRequest_, val.toString())).ifPresent(u -> u.stream().forEach(v -> addAreaServed(v)));
        } else if(val instanceof String) {
          Optional.ofNullable(staticSetAreaServed(siteRequest_, (String)val)).ifPresent(u -> u.stream().forEach(v -> addAreaServed(v)));
        }
        if(!saves.contains("areaServed")) {
          saves.add("areaServed");
        }
        return val;
      } else if("scientificname".equals(varLower)) {
        if(val instanceof String) {
          setScientificName((String)val);
        }
        saves.add("scientificName");
        return val;
      } else if("maturitydaysbegin".equals(varLower)) {
        if(val instanceof String) {
          setMaturityDaysBegin((String)val);
        } else if(val instanceof Number) {
          setMaturityDaysBegin(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaturityDaysBegin((BigDecimal)val);
        }
        saves.add("maturityDaysBegin");
        return val;
      } else if("maturitydaysend".equals(varLower)) {
        if(val instanceof String) {
          setMaturityDaysEnd((String)val);
        } else if(val instanceof Number) {
          setMaturityDaysEnd(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaturityDaysEnd((BigDecimal)val);
        }
        saves.add("maturityDaysEnd");
        return val;
      } else if("incubationdaysbegin".equals(varLower)) {
        if(val instanceof String) {
          setIncubationDaysBegin((String)val);
        } else if(val instanceof Number) {
          setIncubationDaysBegin(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setIncubationDaysBegin((BigDecimal)val);
        }
        saves.add("incubationDaysBegin");
        return val;
      } else if("incubationdaysend".equals(varLower)) {
        if(val instanceof String) {
          setIncubationDaysEnd((String)val);
        } else if(val instanceof Number) {
          setIncubationDaysEnd(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setIncubationDaysEnd((BigDecimal)val);
        }
        saves.add("incubationDaysEnd");
        return val;
      } else if("incubationnumbermin".equals(varLower)) {
        if(val instanceof String) {
          setIncubationNumberMin((String)val);
        } else if(val instanceof Number) {
          setIncubationNumberMin(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setIncubationNumberMin((BigDecimal)val);
        }
        saves.add("incubationNumberMin");
        return val;
      } else if("incubationnumbermax".equals(varLower)) {
        if(val instanceof String) {
          setIncubationNumberMax((String)val);
        } else if(val instanceof Number) {
          setIncubationNumberMax(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setIncubationNumberMax((BigDecimal)val);
        }
        saves.add("incubationNumberMax");
        return val;
      } else if("percentpopulationpregnantmin".equals(varLower)) {
        if(val instanceof String) {
          setPercentPopulationPregnantMin((String)val);
        } else if(val instanceof Number) {
          setPercentPopulationPregnantMin(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setPercentPopulationPregnantMin((BigDecimal)val);
        }
        saves.add("percentPopulationPregnantMin");
        return val;
      } else if("percentpopulationpregnantmax".equals(varLower)) {
        if(val instanceof String) {
          setPercentPopulationPregnantMax((String)val);
        } else if(val instanceof Number) {
          setPercentPopulationPregnantMax(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setPercentPopulationPregnantMax((BigDecimal)val);
        }
        saves.add("percentPopulationPregnantMax");
        return val;
      } else if("populationsatbirth".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<Long>)val).stream().forEach(v -> addPopulationsAtBirth(v));
        } else if(val instanceof Long[]) {
          Arrays.asList((Long[])val).stream().forEach(v -> addPopulationsAtBirth((Long)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addPopulationsAtBirth(((Number)v).longValue()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addPopulationsAtBirth(staticSetPopulationsAtBirth(siteRequest_, v.toString())));
        }
        if(!saves.contains("populationsAtBirth")) {
          saves.add("populationsAtBirth");
        }
        return val;
      } else if("populationsnow".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<Long>)val).stream().forEach(v -> addPopulationsNow(v));
        } else if(val instanceof Long[]) {
          Arrays.asList((Long[])val).stream().forEach(v -> addPopulationsNow((Long)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addPopulationsNow(((Number)v).longValue()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addPopulationsNow(staticSetPopulationsNow(siteRequest_, v.toString())));
        }
        if(!saves.contains("populationsNow")) {
          saves.add("populationsNow");
        }
        return val;
      } else if("incubationdate".equals(varLower)) {
        if(val instanceof String) {
          setIncubationDate((String)val);
        } else if(val instanceof OffsetDateTime) {
          setIncubationDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setIncubationDate((ZonedDateTime)val);
        }
        saves.add("incubationDate");
        return val;
      } else if("previouspopulation".equals(varLower)) {
        if(val instanceof Long) {
          setPreviousPopulation((Long)val);
        } else {
          setPreviousPopulation(val == null ? null : val.toString());
        }
        saves.add("previousPopulation");
        return val;
      } else if("incubationdaysnow".equals(varLower)) {
        if(val instanceof String) {
          setIncubationDaysNow((String)val);
        } else if(val instanceof Number) {
          setIncubationDaysNow(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setIncubationDaysNow((BigDecimal)val);
        }
        saves.add("incubationDaysNow");
        return val;
      } else if("watertemperature".equals(varLower)) {
        if(val instanceof String) {
          setWaterTemperature((String)val);
        } else if(val instanceof Number) {
          setWaterTemperature(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setWaterTemperature((BigDecimal)val);
        }
        saves.add("waterTemperature");
        return val;
      } else if("watersalinity".equals(varLower)) {
        if(val instanceof String) {
          setWaterSalinity((String)val);
        } else if(val instanceof Number) {
          setWaterSalinity(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setWaterSalinity((BigDecimal)val);
        }
        saves.add("waterSalinity");
        return val;
      } else if("wateroxygen".equals(varLower)) {
        if(val instanceof String) {
          setWaterOxygen((String)val);
        } else if(val instanceof Number) {
          setWaterOxygen(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setWaterOxygen((BigDecimal)val);
        }
        saves.add("waterOxygen");
        return val;
      } else if("waterph".equals(varLower)) {
        if(val instanceof String) {
          setWaterPh((String)val);
        } else if(val instanceof Number) {
          setWaterPh(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setWaterPh((BigDecimal)val);
        }
        saves.add("waterPh");
        return val;
      } else if("simulation".equals(varLower)) {
        if(val instanceof Boolean) {
          setSimulation((Boolean)val);
        } else {
          setSimulation(val == null ? null : val.toString());
        }
        saves.add("simulation");
        return val;
      } else if("simulationdelaymillis".equals(varLower)) {
        if(val instanceof Long) {
          setSimulationDelayMillis((Long)val);
        } else {
          setSimulationDelayMillis(val == null ? null : val.toString());
        }
        saves.add("simulationDelayMillis");
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
        Double bodyMasse = (Double)doc.get("bodyMasse_docvalues_string");
        if(bodyMasse != null)
          oFishPopulation.setBodyMasse(bodyMasse);
      }

      if(saves.contains("culturedIn")) {
        Double culturedIn = (Double)doc.get("culturedIn_docvalues_string");
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
        Double fishRemoved = (Double)doc.get("fishRemoved_docvalues_string");
        if(fishRemoved != null)
          oFishPopulation.setFishRemoved(fishRemoved);
      }

      if(saves.contains("initialNumber")) {
        Double initialNumber = (Double)doc.get("initialNumber_docvalues_string");
        if(initialNumber != null)
          oFishPopulation.setInitialNumber(initialNumber);
      }

      if(saves.contains("owner")) {
        String owner = (String)doc.get("owner_docvalues_string");
        if(owner != null)
          oFishPopulation.setOwner(owner);
      }

      if(saves.contains("refSpecie")) {
        Double refSpecie = (Double)doc.get("refSpecie_docvalues_string");
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

      if(saves.contains("areaServedColors")) {
        List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
        if(areaServedColors != null) {
          areaServedColors.stream().forEach( v -> {
            oFishPopulation.areaServedColors.add(FishPopulation.staticSetAreaServedColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedTitles")) {
        List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
        if(areaServedTitles != null) {
          areaServedTitles.stream().forEach( v -> {
            oFishPopulation.areaServedTitles.add(FishPopulation.staticSetAreaServedTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedLinks")) {
        List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
        if(areaServedLinks != null) {
          areaServedLinks.stream().forEach( v -> {
            oFishPopulation.areaServedLinks.add(FishPopulation.staticSetAreaServedLinks(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServed")) {
        List<Polygon> areaServed = (List<Polygon>)doc.get("areaServed_docvalues_location");
        if(areaServed != null) {
          areaServed.stream().forEach( v -> {
            oFishPopulation.areaServed.add(v);
          });
        }
      }

      if(saves.contains("scientificName")) {
        String scientificName = (String)doc.get("scientificName_docvalues_string");
        if(scientificName != null)
          oFishPopulation.setScientificName(scientificName);
      }

      if(saves.contains("maturityDaysBegin")) {
        Double maturityDaysBegin = (Double)doc.get("maturityDaysBegin_docvalues_string");
        if(maturityDaysBegin != null)
          oFishPopulation.setMaturityDaysBegin(maturityDaysBegin);
      }

      if(saves.contains("maturityDaysEnd")) {
        Double maturityDaysEnd = (Double)doc.get("maturityDaysEnd_docvalues_string");
        if(maturityDaysEnd != null)
          oFishPopulation.setMaturityDaysEnd(maturityDaysEnd);
      }

      if(saves.contains("incubationDaysBegin")) {
        Double incubationDaysBegin = (Double)doc.get("incubationDaysBegin_docvalues_string");
        if(incubationDaysBegin != null)
          oFishPopulation.setIncubationDaysBegin(incubationDaysBegin);
      }

      if(saves.contains("incubationDaysEnd")) {
        Double incubationDaysEnd = (Double)doc.get("incubationDaysEnd_docvalues_string");
        if(incubationDaysEnd != null)
          oFishPopulation.setIncubationDaysEnd(incubationDaysEnd);
      }

      if(saves.contains("incubationNumberMin")) {
        Double incubationNumberMin = (Double)doc.get("incubationNumberMin_docvalues_string");
        if(incubationNumberMin != null)
          oFishPopulation.setIncubationNumberMin(incubationNumberMin);
      }

      if(saves.contains("incubationNumberMax")) {
        Double incubationNumberMax = (Double)doc.get("incubationNumberMax_docvalues_string");
        if(incubationNumberMax != null)
          oFishPopulation.setIncubationNumberMax(incubationNumberMax);
      }

      if(saves.contains("percentPopulationPregnantMin")) {
        Double percentPopulationPregnantMin = (Double)doc.get("percentPopulationPregnantMin_docvalues_string");
        if(percentPopulationPregnantMin != null)
          oFishPopulation.setPercentPopulationPregnantMin(percentPopulationPregnantMin);
      }

      if(saves.contains("percentPopulationPregnantMax")) {
        Double percentPopulationPregnantMax = (Double)doc.get("percentPopulationPregnantMax_docvalues_string");
        if(percentPopulationPregnantMax != null)
          oFishPopulation.setPercentPopulationPregnantMax(percentPopulationPregnantMax);
      }

      if(saves.contains("populationsAtBirth")) {
        List<Long> populationsAtBirth = (List<Long>)doc.get("populationsAtBirth_docvalues_longs");
        if(populationsAtBirth != null) {
          populationsAtBirth.stream().forEach( v -> {
            oFishPopulation.populationsAtBirth.add(v);
          });
        }
      }

      if(saves.contains("populationsNow")) {
        List<Long> populationsNow = (List<Long>)doc.get("populationsNow_docvalues_longs");
        if(populationsNow != null) {
          populationsNow.stream().forEach( v -> {
            oFishPopulation.populationsNow.add(v);
          });
        }
      }

      if(saves.contains("incubationDate")) {
        String incubationDate = (String)doc.get("incubationDate_docvalues_date");
        if(incubationDate != null)
          oFishPopulation.setIncubationDate(incubationDate);
      }

      if(saves.contains("previousPopulation")) {
        Long previousPopulation = (Long)doc.get("previousPopulation_docvalues_long");
        if(previousPopulation != null)
          oFishPopulation.setPreviousPopulation(previousPopulation);
      }

      if(saves.contains("incubationDaysNow")) {
        Double incubationDaysNow = (Double)doc.get("incubationDaysNow_docvalues_string");
        if(incubationDaysNow != null)
          oFishPopulation.setIncubationDaysNow(incubationDaysNow);
      }

      if(saves.contains("waterTemperature")) {
        Double waterTemperature = (Double)doc.get("waterTemperature_docvalues_string");
        if(waterTemperature != null)
          oFishPopulation.setWaterTemperature(waterTemperature);
      }

      if(saves.contains("waterSalinity")) {
        Double waterSalinity = (Double)doc.get("waterSalinity_docvalues_string");
        if(waterSalinity != null)
          oFishPopulation.setWaterSalinity(waterSalinity);
      }

      if(saves.contains("waterOxygen")) {
        Double waterOxygen = (Double)doc.get("waterOxygen_docvalues_string");
        if(waterOxygen != null)
          oFishPopulation.setWaterOxygen(waterOxygen);
      }

      if(saves.contains("waterPh")) {
        Double waterPh = (Double)doc.get("waterPh_docvalues_string");
        if(waterPh != null)
          oFishPopulation.setWaterPh(waterPh);
      }

      if(saves.contains("simulation")) {
        Boolean simulation = (Boolean)doc.get("simulation_docvalues_boolean");
        if(simulation != null)
          oFishPopulation.setSimulation(simulation);
      }

      if(saves.contains("simulationDelayMillis")) {
        Long simulationDelayMillis = (Long)doc.get("simulationDelayMillis_docvalues_long");
        if(simulationDelayMillis != null)
          oFishPopulation.setSimulationDelayMillis(simulationDelayMillis);
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
      doc.put("bodyMasse_docvalues_string", bodyMasse.toPlainString());
    }
    if(culturedIn != null) {
      doc.put("culturedIn_docvalues_string", culturedIn.toPlainString());
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
      doc.put("fishRemoved_docvalues_string", fishRemoved.toPlainString());
    }
    if(initialNumber != null) {
      doc.put("initialNumber_docvalues_string", initialNumber.toPlainString());
    }
    if(owner != null) {
      doc.put("owner_docvalues_string", owner.encode());
    }
    if(refSpecie != null) {
      doc.put("refSpecie_docvalues_string", refSpecie.toPlainString());
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
    if(areaServedColors != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedColors_indexedstored_strings", l);
      for(String o : areaServedColors) {
        l.add(FishPopulation.staticSearchAreaServedColors(siteRequest_, o));
      }
    }
    if(areaServedTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedTitles_indexedstored_strings", l);
      for(String o : areaServedTitles) {
        l.add(FishPopulation.staticSearchAreaServedTitles(siteRequest_, o));
      }
    }
    if(areaServedLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedLinks_indexedstored_strings", l);
      for(String o : areaServedLinks) {
        l.add(FishPopulation.staticSearchAreaServedLinks(siteRequest_, o));
      }
    }
    if(areaServed != null) {
      doc.put("areaServed_docvalues_location", Optional.ofNullable(geojsonAreaServed()).map(geojson -> geojson.toString()).orElse(null));
    }
    if(scientificName != null) {
      doc.put("scientificName_docvalues_string", scientificName);
    }
    if(maturityDaysBegin != null) {
      doc.put("maturityDaysBegin_docvalues_string", maturityDaysBegin.toPlainString());
    }
    if(maturityDaysEnd != null) {
      doc.put("maturityDaysEnd_docvalues_string", maturityDaysEnd.toPlainString());
    }
    if(incubationDaysBegin != null) {
      doc.put("incubationDaysBegin_docvalues_string", incubationDaysBegin.toPlainString());
    }
    if(incubationDaysEnd != null) {
      doc.put("incubationDaysEnd_docvalues_string", incubationDaysEnd.toPlainString());
    }
    if(incubationNumberMin != null) {
      doc.put("incubationNumberMin_docvalues_string", incubationNumberMin.toPlainString());
    }
    if(incubationNumberMax != null) {
      doc.put("incubationNumberMax_docvalues_string", incubationNumberMax.toPlainString());
    }
    if(percentPopulationPregnantMin != null) {
      doc.put("percentPopulationPregnantMin_docvalues_string", percentPopulationPregnantMin.toPlainString());
    }
    if(percentPopulationPregnantMax != null) {
      doc.put("percentPopulationPregnantMax_docvalues_string", percentPopulationPregnantMax.toPlainString());
    }
    if(populationsAtBirth != null) {
      JsonArray l = new JsonArray();
      doc.put("populationsAtBirth_docvalues_longs", l);
      for(Long o : populationsAtBirth) {
        l.add(FishPopulation.staticSearchPopulationsAtBirth(siteRequest_, o));
      }
    }
    if(populationsNow != null) {
      JsonArray l = new JsonArray();
      doc.put("populationsNow_docvalues_longs", l);
      for(Long o : populationsNow) {
        l.add(FishPopulation.staticSearchPopulationsNow(siteRequest_, o));
      }
    }
    if(incubationDate != null) {
      doc.put("incubationDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(incubationDate.toInstant(), ZoneId.of("UTC"))));
    }
    if(previousPopulation != null) {
      doc.put("previousPopulation_docvalues_long", previousPopulation);
    }
    if(incubationDaysNow != null) {
      doc.put("incubationDaysNow_docvalues_string", incubationDaysNow.toPlainString());
    }
    if(waterTemperature != null) {
      doc.put("waterTemperature_docvalues_string", waterTemperature.toPlainString());
    }
    if(waterSalinity != null) {
      doc.put("waterSalinity_docvalues_string", waterSalinity.toPlainString());
    }
    if(waterOxygen != null) {
      doc.put("waterOxygen_docvalues_string", waterOxygen.toPlainString());
    }
    if(waterPh != null) {
      doc.put("waterPh_docvalues_string", waterPh.toPlainString());
    }
    if(simulation != null) {
      doc.put("simulation_docvalues_boolean", simulation);
    }
    if(simulationDelayMillis != null) {
      doc.put("simulationDelayMillis_docvalues_long", simulationDelayMillis);
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
        return "bodyMasse_docvalues_string";
      case "culturedIn":
        return "culturedIn_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "fishRemoved":
        return "fishRemoved_docvalues_string";
      case "initialNumber":
        return "initialNumber_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "refSpecie":
        return "refSpecie_docvalues_string";
      case "relatedSource":
        return "relatedSource_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      case "scientificName":
        return "scientificName_docvalues_string";
      case "maturityDaysBegin":
        return "maturityDaysBegin_docvalues_string";
      case "maturityDaysEnd":
        return "maturityDaysEnd_docvalues_string";
      case "incubationDaysBegin":
        return "incubationDaysBegin_docvalues_string";
      case "incubationDaysEnd":
        return "incubationDaysEnd_docvalues_string";
      case "incubationNumberMin":
        return "incubationNumberMin_docvalues_string";
      case "incubationNumberMax":
        return "incubationNumberMax_docvalues_string";
      case "percentPopulationPregnantMin":
        return "percentPopulationPregnantMin_docvalues_string";
      case "percentPopulationPregnantMax":
        return "percentPopulationPregnantMax_docvalues_string";
      case "populationsAtBirth":
        return "populationsAtBirth_docvalues_longs";
      case "populationsNow":
        return "populationsNow_docvalues_longs";
      case "incubationDate":
        return "incubationDate_docvalues_date";
      case "previousPopulation":
        return "previousPopulation_docvalues_long";
      case "incubationDaysNow":
        return "incubationDaysNow_docvalues_string";
      case "waterTemperature":
        return "waterTemperature_docvalues_string";
      case "waterSalinity":
        return "waterSalinity_docvalues_string";
      case "waterOxygen":
        return "waterOxygen_docvalues_string";
      case "waterPh":
        return "waterPh_docvalues_string";
      case "simulation":
        return "simulation_docvalues_boolean";
      case "simulationDelayMillis":
        return "simulationDelayMillis_docvalues_long";
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
        return "bodyMasse_docvalues_string";
      case "culturedIn":
        return "culturedIn_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "fishRemoved":
        return "fishRemoved_docvalues_string";
      case "initialNumber":
        return "initialNumber_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "refSpecie":
        return "refSpecie_docvalues_string";
      case "relatedSource":
        return "relatedSource_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      case "scientificName":
        return "scientificName_docvalues_string";
      case "maturityDaysBegin":
        return "maturityDaysBegin_docvalues_string";
      case "maturityDaysEnd":
        return "maturityDaysEnd_docvalues_string";
      case "incubationDaysBegin":
        return "incubationDaysBegin_docvalues_string";
      case "incubationDaysEnd":
        return "incubationDaysEnd_docvalues_string";
      case "incubationNumberMin":
        return "incubationNumberMin_docvalues_string";
      case "incubationNumberMax":
        return "incubationNumberMax_docvalues_string";
      case "percentPopulationPregnantMin":
        return "percentPopulationPregnantMin_docvalues_string";
      case "percentPopulationPregnantMax":
        return "percentPopulationPregnantMax_docvalues_string";
      case "populationsAtBirth":
        return "populationsAtBirth_docvalues_longs";
      case "populationsNow":
        return "populationsNow_docvalues_longs";
      case "incubationDate":
        return "incubationDate_docvalues_date";
      case "previousPopulation":
        return "previousPopulation_docvalues_long";
      case "incubationDaysNow":
        return "incubationDaysNow_docvalues_string";
      case "waterTemperature":
        return "waterTemperature_docvalues_string";
      case "waterSalinity":
        return "waterSalinity_docvalues_string";
      case "waterOxygen":
        return "waterOxygen_docvalues_string";
      case "waterPh":
        return "waterPh_docvalues_string";
      case "simulation":
        return "simulation_docvalues_boolean";
      case "simulationDelayMillis":
        return "simulationDelayMillis_docvalues_long";
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
      case "bodyMasse_docvalues_string":
        return "bodyMasse";
      case "culturedIn_docvalues_string":
        return "culturedIn";
      case "dataProvider_docvalues_string":
        return "dataProvider";
      case "dateCreated_docvalues_string":
        return "dateCreated";
      case "dateModified_docvalues_string":
        return "dateModified";
      case "fishRemoved_docvalues_string":
        return "fishRemoved";
      case "initialNumber_docvalues_string":
        return "initialNumber";
      case "owner_docvalues_string":
        return "owner";
      case "refSpecie_docvalues_string":
        return "refSpecie";
      case "relatedSource_docvalues_string":
        return "relatedSource";
      case "seeAlso_docvalues_string":
        return "seeAlso";
      case "source_docvalues_string":
        return "source";
      case "areaServedColors_indexedstored_strings":
        return "areaServedColors";
      case "areaServedTitles_indexedstored_strings":
        return "areaServedTitles";
      case "areaServedLinks_indexedstored_strings":
        return "areaServedLinks";
      case "areaServed_docvalues_location":
        return "areaServed";
      case "scientificName_docvalues_string":
        return "scientificName";
      case "maturityDaysBegin_docvalues_string":
        return "maturityDaysBegin";
      case "maturityDaysEnd_docvalues_string":
        return "maturityDaysEnd";
      case "incubationDaysBegin_docvalues_string":
        return "incubationDaysBegin";
      case "incubationDaysEnd_docvalues_string":
        return "incubationDaysEnd";
      case "incubationNumberMin_docvalues_string":
        return "incubationNumberMin";
      case "incubationNumberMax_docvalues_string":
        return "incubationNumberMax";
      case "percentPopulationPregnantMin_docvalues_string":
        return "percentPopulationPregnantMin";
      case "percentPopulationPregnantMax_docvalues_string":
        return "percentPopulationPregnantMax";
      case "populationsAtBirth_docvalues_longs":
        return "populationsAtBirth";
      case "populationsNow_docvalues_longs":
        return "populationsNow";
      case "incubationDate_docvalues_date":
        return "incubationDate";
      case "previousPopulation_docvalues_long":
        return "previousPopulation";
      case "incubationDaysNow_docvalues_string":
        return "incubationDaysNow";
      case "waterTemperature_docvalues_string":
        return "waterTemperature";
      case "waterSalinity_docvalues_string":
        return "waterSalinity";
      case "waterOxygen_docvalues_string":
        return "waterOxygen";
      case "waterPh_docvalues_string":
        return "waterPh";
      case "simulation_docvalues_boolean":
        return "simulation";
      case "simulationDelayMillis_docvalues_long":
        return "simulationDelayMillis";
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
    oFishPopulation.setBodyMasse(Optional.ofNullable(doc.get("bodyMasse_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setCulturedIn(Optional.ofNullable(doc.get("culturedIn_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setFishRemoved(Optional.ofNullable(doc.get("fishRemoved_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setInitialNumber(Optional.ofNullable(doc.get("initialNumber_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setRefSpecie(Optional.ofNullable(doc.get("refSpecie_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setRelatedSource(Optional.ofNullable(doc.get("relatedSource_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishPopulation.addAreaServedColors(FishPopulation.staticSetAreaServedColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishPopulation.addAreaServedTitles(FishPopulation.staticSetAreaServedTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishPopulation.addAreaServedLinks(FishPopulation.staticSetAreaServedLinks(siteRequest, v.toString()));
    });
    Optional.ofNullable((String)doc.get("areaServed_docvalues_location")).ifPresent(val -> staticSetAreaServed(siteRequest_, val.toString()).stream().forEach(v -> addAreaServed(v)));
    oFishPopulation.setScientificName(Optional.ofNullable(doc.get("scientificName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setMaturityDaysBegin(Optional.ofNullable(doc.get("maturityDaysBegin_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setMaturityDaysEnd(Optional.ofNullable(doc.get("maturityDaysEnd_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setIncubationDaysBegin(Optional.ofNullable(doc.get("incubationDaysBegin_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setIncubationDaysEnd(Optional.ofNullable(doc.get("incubationDaysEnd_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setIncubationNumberMin(Optional.ofNullable(doc.get("incubationNumberMin_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setIncubationNumberMax(Optional.ofNullable(doc.get("incubationNumberMax_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setPercentPopulationPregnantMin(Optional.ofNullable(doc.get("percentPopulationPregnantMin_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setPercentPopulationPregnantMax(Optional.ofNullable(doc.get("percentPopulationPregnantMax_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("populationsAtBirth_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishPopulation.addPopulationsAtBirth(FishPopulation.staticSetPopulationsAtBirth(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("populationsNow_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishPopulation.addPopulationsNow(FishPopulation.staticSetPopulationsNow(siteRequest, v.toString()));
    });
    oFishPopulation.setIncubationDate(Optional.ofNullable(doc.get("incubationDate_docvalues_date")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setPreviousPopulation(Optional.ofNullable(doc.get("previousPopulation_docvalues_long")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setIncubationDaysNow(Optional.ofNullable(doc.get("incubationDaysNow_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setWaterTemperature(Optional.ofNullable(doc.get("waterTemperature_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setWaterSalinity(Optional.ofNullable(doc.get("waterSalinity_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setWaterOxygen(Optional.ofNullable(doc.get("waterOxygen_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setWaterPh(Optional.ofNullable(doc.get("waterPh_docvalues_string")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setSimulation(Optional.ofNullable(doc.get("simulation_docvalues_boolean")).map(v -> v.toString()).orElse(null));
    oFishPopulation.setSimulationDelayMillis(Optional.ofNullable(doc.get("simulationDelayMillis_docvalues_long")).map(v -> v.toString()).orElse(null));

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
      if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
        apiRequest.addVars("areaServedColors");
      if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
        apiRequest.addVars("areaServedTitles");
      if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
        apiRequest.addVars("areaServedLinks");
      if(!Objects.equals(areaServed, original.getAreaServed()))
        apiRequest.addVars("areaServed");
      if(!Objects.equals(scientificName, original.getScientificName()))
        apiRequest.addVars("scientificName");
      if(!Objects.equals(maturityDaysBegin, original.getMaturityDaysBegin()) && maturityDaysBegin != null && original.getMaturityDaysBegin() != null && maturityDaysBegin.compareTo(original.getMaturityDaysBegin()) != 0)
        apiRequest.addVars("maturityDaysBegin");
      if(!Objects.equals(maturityDaysEnd, original.getMaturityDaysEnd()) && maturityDaysEnd != null && original.getMaturityDaysEnd() != null && maturityDaysEnd.compareTo(original.getMaturityDaysEnd()) != 0)
        apiRequest.addVars("maturityDaysEnd");
      if(!Objects.equals(incubationDaysBegin, original.getIncubationDaysBegin()) && incubationDaysBegin != null && original.getIncubationDaysBegin() != null && incubationDaysBegin.compareTo(original.getIncubationDaysBegin()) != 0)
        apiRequest.addVars("incubationDaysBegin");
      if(!Objects.equals(incubationDaysEnd, original.getIncubationDaysEnd()) && incubationDaysEnd != null && original.getIncubationDaysEnd() != null && incubationDaysEnd.compareTo(original.getIncubationDaysEnd()) != 0)
        apiRequest.addVars("incubationDaysEnd");
      if(!Objects.equals(incubationNumberMin, original.getIncubationNumberMin()) && incubationNumberMin != null && original.getIncubationNumberMin() != null && incubationNumberMin.compareTo(original.getIncubationNumberMin()) != 0)
        apiRequest.addVars("incubationNumberMin");
      if(!Objects.equals(incubationNumberMax, original.getIncubationNumberMax()) && incubationNumberMax != null && original.getIncubationNumberMax() != null && incubationNumberMax.compareTo(original.getIncubationNumberMax()) != 0)
        apiRequest.addVars("incubationNumberMax");
      if(!Objects.equals(percentPopulationPregnantMin, original.getPercentPopulationPregnantMin()) && percentPopulationPregnantMin != null && original.getPercentPopulationPregnantMin() != null && percentPopulationPregnantMin.compareTo(original.getPercentPopulationPregnantMin()) != 0)
        apiRequest.addVars("percentPopulationPregnantMin");
      if(!Objects.equals(percentPopulationPregnantMax, original.getPercentPopulationPregnantMax()) && percentPopulationPregnantMax != null && original.getPercentPopulationPregnantMax() != null && percentPopulationPregnantMax.compareTo(original.getPercentPopulationPregnantMax()) != 0)
        apiRequest.addVars("percentPopulationPregnantMax");
      if(!Objects.equals(populationsAtBirth, original.getPopulationsAtBirth()))
        apiRequest.addVars("populationsAtBirth");
      if(!Objects.equals(populationsNow, original.getPopulationsNow()))
        apiRequest.addVars("populationsNow");
      if(!Objects.equals(incubationDate, original.getIncubationDate()))
        apiRequest.addVars("incubationDate");
      if(!Objects.equals(previousPopulation, original.getPreviousPopulation()))
        apiRequest.addVars("previousPopulation");
      if(!Objects.equals(incubationDaysNow, original.getIncubationDaysNow()) && incubationDaysNow != null && original.getIncubationDaysNow() != null && incubationDaysNow.compareTo(original.getIncubationDaysNow()) != 0)
        apiRequest.addVars("incubationDaysNow");
      if(!Objects.equals(waterTemperature, original.getWaterTemperature()) && waterTemperature != null && original.getWaterTemperature() != null && waterTemperature.compareTo(original.getWaterTemperature()) != 0)
        apiRequest.addVars("waterTemperature");
      if(!Objects.equals(waterSalinity, original.getWaterSalinity()) && waterSalinity != null && original.getWaterSalinity() != null && waterSalinity.compareTo(original.getWaterSalinity()) != 0)
        apiRequest.addVars("waterSalinity");
      if(!Objects.equals(waterOxygen, original.getWaterOxygen()) && waterOxygen != null && original.getWaterOxygen() != null && waterOxygen.compareTo(original.getWaterOxygen()) != 0)
        apiRequest.addVars("waterOxygen");
      if(!Objects.equals(waterPh, original.getWaterPh()) && waterPh != null && original.getWaterPh() != null && waterPh.compareTo(original.getWaterPh()) != 0)
        apiRequest.addVars("waterPh");
      if(!Objects.equals(simulation, original.getSimulation()))
        apiRequest.addVars("simulation");
      if(!Objects.equals(simulationDelayMillis, original.getSimulationDelayMillis()))
        apiRequest.addVars("simulationDelayMillis");
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
    sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(scientificName).map(v -> "scientificName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(maturityDaysBegin).map(v -> "maturityDaysBegin: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(maturityDaysEnd).map(v -> "maturityDaysEnd: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationDaysBegin).map(v -> "incubationDaysBegin: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationDaysEnd).map(v -> "incubationDaysEnd: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationNumberMin).map(v -> "incubationNumberMin: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationNumberMax).map(v -> "incubationNumberMax: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(percentPopulationPregnantMin).map(v -> "percentPopulationPregnantMin: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(percentPopulationPregnantMax).map(v -> "percentPopulationPregnantMax: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(populationsAtBirth).map(v -> "populationsAtBirth: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(populationsNow).map(v -> "populationsNow: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationDate).map(v -> "incubationDate: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(previousPopulation).map(v -> "previousPopulation: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(incubationDaysNow).map(v -> "incubationDaysNow: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(waterTemperature).map(v -> "waterTemperature: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(waterSalinity).map(v -> "waterSalinity: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(waterOxygen).map(v -> "waterOxygen: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(waterPh).map(v -> "waterPh: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(simulation).map(v -> "simulation: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(simulationDelayMillis).map(v -> "simulationDelayMillis: " + v + "\n").orElse(""));
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
  public static final String VAR_areaServedColors = "areaServedColors";
  public static final String VAR_areaServedTitles = "areaServedTitles";
  public static final String VAR_areaServedLinks = "areaServedLinks";
  public static final String VAR_areaServed = "areaServed";
  public static final String VAR_scientificName = "scientificName";
  public static final String VAR_maturityDaysBegin = "maturityDaysBegin";
  public static final String VAR_maturityDaysEnd = "maturityDaysEnd";
  public static final String VAR_incubationDaysBegin = "incubationDaysBegin";
  public static final String VAR_incubationDaysEnd = "incubationDaysEnd";
  public static final String VAR_incubationNumberMin = "incubationNumberMin";
  public static final String VAR_incubationNumberMax = "incubationNumberMax";
  public static final String VAR_percentPopulationPregnantMin = "percentPopulationPregnantMin";
  public static final String VAR_percentPopulationPregnantMax = "percentPopulationPregnantMax";
  public static final String VAR_populationsAtBirth = "populationsAtBirth";
  public static final String VAR_populationsNow = "populationsNow";
  public static final String VAR_incubationDate = "incubationDate";
  public static final String VAR_previousPopulation = "previousPopulation";
  public static final String VAR_incubationDaysNow = "incubationDaysNow";
  public static final String VAR_waterTemperature = "waterTemperature";
  public static final String VAR_waterSalinity = "waterSalinity";
  public static final String VAR_waterOxygen = "waterOxygen";
  public static final String VAR_waterPh = "waterPh";
  public static final String VAR_simulation = "simulation";
  public static final String VAR_simulationDelayMillis = "simulationDelayMillis";

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
    vars.add(VAR_areaServed);
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
  public static final String DISPLAY_NAME_areaServedColors = "area served colors";
  public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
  public static final String DISPLAY_NAME_areaServedLinks = "area served links";
  public static final String DISPLAY_NAME_areaServed = "area served";
  public static final String DISPLAY_NAME_scientificName = "scientific name";
  public static final String DISPLAY_NAME_maturityDaysBegin = "maturity days begin";
  public static final String DISPLAY_NAME_maturityDaysEnd = "maturity days end";
  public static final String DISPLAY_NAME_incubationDaysBegin = "incubation days begin";
  public static final String DISPLAY_NAME_incubationDaysEnd = "incubation days end";
  public static final String DISPLAY_NAME_incubationNumberMin = "incubation number min";
  public static final String DISPLAY_NAME_incubationNumberMax = "incubation number max";
  public static final String DISPLAY_NAME_percentPopulationPregnantMin = "min percent of population pregnant";
  public static final String DISPLAY_NAME_percentPopulationPregnantMax = "max percent of population pregnant";
  public static final String DISPLAY_NAME_populationsAtBirth = "populations at birth";
  public static final String DISPLAY_NAME_populationsNow = "populations now";
  public static final String DISPLAY_NAME_incubationDate = "incubation date";
  public static final String DISPLAY_NAME_previousPopulation = "previous pouplation";
  public static final String DISPLAY_NAME_incubationDaysNow = "incubation days now";
  public static final String DISPLAY_NAME_waterTemperature = "water temperature in Fahrenheit";
  public static final String DISPLAY_NAME_waterSalinity = "salinity in ppt";
  public static final String DISPLAY_NAME_waterOxygen = "oxygen in mg/L";
  public static final String DISPLAY_NAME_waterPh = "pH";
  public static final String DISPLAY_NAME_simulation = "simulation";
  public static final String DISPLAY_NAME_simulationDelayMillis = "simulation delay in milliseconds";

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
  public String frFRStringFormatUrlEditPageForClass() {
    return "%s/fr-fr/edition/population-poissons/%s";
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/fish-population/%s";
  }

  @Override
  public String frFRStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlUserPageForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlDownloadForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlDownloadForClass() {
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
    case VAR_areaServedColors:
      return DISPLAY_NAME_areaServedColors;
    case VAR_areaServedTitles:
      return DISPLAY_NAME_areaServedTitles;
    case VAR_areaServedLinks:
      return DISPLAY_NAME_areaServedLinks;
    case VAR_areaServed:
      return DISPLAY_NAME_areaServed;
    case VAR_scientificName:
      return DISPLAY_NAME_scientificName;
    case VAR_maturityDaysBegin:
      return DISPLAY_NAME_maturityDaysBegin;
    case VAR_maturityDaysEnd:
      return DISPLAY_NAME_maturityDaysEnd;
    case VAR_incubationDaysBegin:
      return DISPLAY_NAME_incubationDaysBegin;
    case VAR_incubationDaysEnd:
      return DISPLAY_NAME_incubationDaysEnd;
    case VAR_incubationNumberMin:
      return DISPLAY_NAME_incubationNumberMin;
    case VAR_incubationNumberMax:
      return DISPLAY_NAME_incubationNumberMax;
    case VAR_percentPopulationPregnantMin:
      return DISPLAY_NAME_percentPopulationPregnantMin;
    case VAR_percentPopulationPregnantMax:
      return DISPLAY_NAME_percentPopulationPregnantMax;
    case VAR_populationsAtBirth:
      return DISPLAY_NAME_populationsAtBirth;
    case VAR_populationsNow:
      return DISPLAY_NAME_populationsNow;
    case VAR_incubationDate:
      return DISPLAY_NAME_incubationDate;
    case VAR_previousPopulation:
      return DISPLAY_NAME_previousPopulation;
    case VAR_incubationDaysNow:
      return DISPLAY_NAME_incubationDaysNow;
    case VAR_waterTemperature:
      return DISPLAY_NAME_waterTemperature;
    case VAR_waterSalinity:
      return DISPLAY_NAME_waterSalinity;
    case VAR_waterOxygen:
      return DISPLAY_NAME_waterOxygen;
    case VAR_waterPh:
      return DISPLAY_NAME_waterPh;
    case VAR_simulation:
      return DISPLAY_NAME_simulation;
    case VAR_simulationDelayMillis:
      return DISPLAY_NAME_simulationDelayMillis;
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
    case VAR_areaServedColors:
      return "The colors of each areaServed Paths. ";
    case VAR_areaServedTitles:
      return "The titles of each areaServed Paths. ";
    case VAR_areaServedLinks:
      return "The links of each areaServed Paths. ";
    case VAR_areaServed:
      return "The geographic area where a service or offered item is provided";
    case VAR_scientificName:
      return "The scientific name of the fish species. ";
    case VAR_maturityDaysBegin:
      return "The range of days from birth for the fish population to become sexually mature. ";
    case VAR_maturityDaysEnd:
      return "The range of days from birth for the fish population to become sexually mature. ";
    case VAR_incubationDaysBegin:
      return "The range of days for egg incubation. ";
    case VAR_incubationDaysEnd:
      return "The range of days for egg incubation. ";
    case VAR_incubationNumberMin:
      return "The range of fish born after incubation. ";
    case VAR_incubationNumberMax:
      return "The range of fish born after incubation. ";
    case VAR_percentPopulationPregnantMin:
      return "The the percentage of the population that becomes pregnant at incubation time. ";
    case VAR_percentPopulationPregnantMax:
      return "The the percentage of the population that becomes pregnant at incubation time. ";
    case VAR_populationsAtBirth:
      return "A list of population counts at birth. ";
    case VAR_populationsNow:
      return "A list of population counts now, since birth. ";
    case VAR_incubationDate:
      return "The date and time that incubation started for this fish population. ";
    case VAR_previousPopulation:
      return "The previously known population count. ";
    case VAR_incubationDaysNow:
      return "The current number of days of egg incubation. ";
    case VAR_waterTemperature:
      return "The water temperature can affect fish population survival. ";
    case VAR_waterSalinity:
      return "The water salinity can affect fish population survival. ";
    case VAR_waterOxygen:
      return "The water oxygen levels can affect fish population survival. ";
    case VAR_waterPh:
      return "The water pH levels can affect fish population survival. ";
    case VAR_simulation:
      return "Toggle the digital twin simulation";
    case VAR_simulationDelayMillis:
      return "The number of milliseconds to asynchronously wait before the next update event is sent. ";
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
    case VAR_areaServedColors:
      return "List";
    case VAR_areaServedTitles:
      return "List";
    case VAR_areaServedLinks:
      return "List";
    case VAR_areaServed:
      return "List";
    case VAR_scientificName:
      return "String";
    case VAR_maturityDaysBegin:
      return "BigDecimal";
    case VAR_maturityDaysEnd:
      return "BigDecimal";
    case VAR_incubationDaysBegin:
      return "BigDecimal";
    case VAR_incubationDaysEnd:
      return "BigDecimal";
    case VAR_incubationNumberMin:
      return "BigDecimal";
    case VAR_incubationNumberMax:
      return "BigDecimal";
    case VAR_percentPopulationPregnantMin:
      return "BigDecimal";
    case VAR_percentPopulationPregnantMax:
      return "BigDecimal";
    case VAR_populationsAtBirth:
      return "List";
    case VAR_populationsNow:
      return "List";
    case VAR_incubationDate:
      return "ZonedDateTime";
    case VAR_previousPopulation:
      return "Long";
    case VAR_incubationDaysNow:
      return "BigDecimal";
    case VAR_waterTemperature:
      return "BigDecimal";
    case VAR_waterSalinity:
      return "BigDecimal";
    case VAR_waterOxygen:
      return "BigDecimal";
    case VAR_waterPh:
      return "BigDecimal";
    case VAR_simulation:
      return "Boolean";
    case VAR_simulationDelayMillis:
      return "Long";
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
    case VAR_areaServedColors:
      return "Property";
    case VAR_areaServedTitles:
      return "Property";
    case VAR_areaServedLinks:
      return "Property";
    case VAR_areaServed:
      return "GeoProperty";
    case VAR_scientificName:
      return "Property";
    case VAR_maturityDaysBegin:
      return "Property";
    case VAR_maturityDaysEnd:
      return "Property";
    case VAR_incubationDaysBegin:
      return "Property";
    case VAR_incubationDaysEnd:
      return "Property";
    case VAR_incubationNumberMin:
      return "Property";
    case VAR_incubationNumberMax:
      return "Property";
    case VAR_percentPopulationPregnantMin:
      return "Property";
    case VAR_percentPopulationPregnantMax:
      return "Property";
    case VAR_populationsAtBirth:
      return "Property";
    case VAR_populationsNow:
      return "Property";
    case VAR_incubationDate:
      return "Property";
    case VAR_previousPopulation:
      return "Property";
    case VAR_incubationDaysNow:
      return "Property";
    case VAR_waterTemperature:
      return "Property";
    case VAR_waterSalinity:
      return "Property";
    case VAR_waterOxygen:
      return "Property";
    case VAR_waterPh:
      return "Property";
    case VAR_simulation:
      return "Property";
    case VAR_simulationDelayMillis:
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
    case VAR_areaServedColors:
      return o.getAreaServedColors();
    case VAR_areaServedTitles:
      return o.getAreaServedTitles();
    case VAR_areaServedLinks:
      return o.getAreaServedLinks();
    case VAR_areaServed:
      return o.geojsonAreaServed();
    case VAR_scientificName:
      return o.getScientificName();
    case VAR_maturityDaysBegin:
      return o.getMaturityDaysBegin();
    case VAR_maturityDaysEnd:
      return o.getMaturityDaysEnd();
    case VAR_incubationDaysBegin:
      return o.getIncubationDaysBegin();
    case VAR_incubationDaysEnd:
      return o.getIncubationDaysEnd();
    case VAR_incubationNumberMin:
      return o.getIncubationNumberMin();
    case VAR_incubationNumberMax:
      return o.getIncubationNumberMax();
    case VAR_percentPopulationPregnantMin:
      return o.getPercentPopulationPregnantMin();
    case VAR_percentPopulationPregnantMax:
      return o.getPercentPopulationPregnantMax();
    case VAR_populationsAtBirth:
      return o.getPopulationsAtBirth();
    case VAR_populationsNow:
      return o.getPopulationsNow();
    case VAR_incubationDate:
      return o.getIncubationDate();
    case VAR_previousPopulation:
      return o.getPreviousPopulation();
    case VAR_incubationDaysNow:
      return o.getIncubationDaysNow();
    case VAR_waterTemperature:
      return o.getWaterTemperature();
    case VAR_waterSalinity:
      return o.getWaterSalinity();
    case VAR_waterOxygen:
      return o.getWaterOxygen();
    case VAR_waterPh:
      return o.getWaterPh();
    case VAR_simulation:
      return o.getSimulation();
    case VAR_simulationDelayMillis:
      return o.getSimulationDelayMillis();
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
    case VAR_areaServed:
      return 4;
    case VAR_scientificName:
      return 4;
    case VAR_maturityDaysBegin:
      return 7;
    case VAR_maturityDaysEnd:
      return 7;
    case VAR_incubationDaysBegin:
      return 7;
    case VAR_incubationDaysEnd:
      return 7;
    case VAR_incubationNumberMin:
      return 7;
    case VAR_incubationNumberMax:
      return 7;
    case VAR_percentPopulationPregnantMin:
      return 7;
    case VAR_percentPopulationPregnantMax:
      return 7;
    case VAR_populationsAtBirth:
      return 7;
    case VAR_populationsNow:
      return 7;
    case VAR_incubationDate:
      return 7;
    case VAR_previousPopulation:
      return 7;
    case VAR_incubationDaysNow:
      return 7;
    case VAR_waterTemperature:
      return 7;
    case VAR_waterSalinity:
      return 7;
    case VAR_waterOxygen:
      return 7;
    case VAR_waterPh:
      return 7;
    case VAR_simulation:
      return 8;
    case VAR_simulationDelayMillis:
      return 8;
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
    case VAR_areaServed:
      return 4;
    case VAR_scientificName:
      return 5;
    case VAR_maturityDaysBegin:
      return 0;
    case VAR_maturityDaysEnd:
      return 1;
    case VAR_incubationDaysBegin:
      return 2;
    case VAR_incubationDaysEnd:
      return 3;
    case VAR_incubationNumberMin:
      return 3;
    case VAR_incubationNumberMax:
      return 4;
    case VAR_percentPopulationPregnantMin:
      return 5;
    case VAR_percentPopulationPregnantMax:
      return 6;
    case VAR_populationsAtBirth:
      return 8;
    case VAR_populationsNow:
      return 9;
    case VAR_incubationDate:
      return 10;
    case VAR_previousPopulation:
      return 12;
    case VAR_incubationDaysNow:
      return 11;
    case VAR_waterTemperature:
      return 12;
    case VAR_waterSalinity:
      return 13;
    case VAR_waterOxygen:
      return 14;
    case VAR_waterPh:
      return 15;
    case VAR_simulation:
      return 0;
    case VAR_simulationDelayMillis:
      return 1;
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
