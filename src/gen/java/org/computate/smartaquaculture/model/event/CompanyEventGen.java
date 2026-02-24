/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
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
import java.lang.Integer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.tool.SearchTool;
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
 * <h2>Order: 2</h2>
 * <p>This class contains a comment <b>"Order: 2"</b>, which means this class will be sorted by the given number 2 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 2</h2>
 * <p>This class contains a comment <b>"SqlOrder: 2"</b>, which means this class will be sorted by the given number 2 ascending when SQL code to create and drop the tables is generated. 
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
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.event in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.event&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class CompanyEventGen<DEV> extends BaseResult {
  protected static final Logger LOG = LoggerFactory.getLogger(CompanyEvent.class);

  public static final String Description_frFR = "Voir les événements en personne et en ligne à venir de computate";
  public static final String AName_frFR = "un événement";
  public static final String This_frFR = "ce ";
  public static final String ThisName_frFR = "cet événement";
  public static final String A_frFR = "un ";
  public static final String TheName_frFR = "l'événement";
  public static final String SingularName_frFR = "événement";
  public static final String PluralName_frFR = "événements";
  public static final String NameActual_frFR = "événement actuel";
  public static final String AllName_frFR = "tous événements";
  public static final String SearchAllNameBy_frFR = "rechercher événements par ";
  public static final String SearchAllName_frFR = "rechercher événements";
  public static final String Title_frFR = "événements";
  public static final String ThePluralName_frFR = "les événements";
  public static final String NoNameFound_frFR = "aucun événement trouvé";
  public static final String OfName_frFR = "d'événement";
  public static final String NameAdjectiveSingular_frFR = "événement";
  public static final String NameAdjectivePlural_frFR = "événements";
  public static final String SearchPageFrFR_frFR_OpenApiUri = "/fr-fr/rechercher/evenement";
  public static final String SearchPageFrFR_frFR_StringFormatUri = "/fr-fr/rechercher/evenement";
  public static final String SearchPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/rechercher/evenement";
  public static final String EditPageFrFR_frFR_OpenApiUri = "/fr-fr/edition/evenement/{pageId}";
  public static final String EditPageFrFR_frFR_StringFormatUri = "/fr-fr/edition/evenement/%s";
  public static final String EditPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/edition/evenement/%s";
  public static final String DisplayPageFrFR_frFR_OpenApiUri = "/fr-fr/visiter/evenement/{pageId}";
  public static final String DisplayPageFrFR_frFR_StringFormatUri = "/fr-fr/visiter/evenement/%s";
  public static final String DisplayPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/visiter/evenement/%s";
  public static final String UserPageFrFR_frFR_OpenApiUri = "/fr-fr/utilisateur/evenement/{pageId}";
  public static final String UserPageFrFR_frFR_StringFormatUri = "/fr-fr/utilisateur/evenement/%s";
  public static final String UserPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/utilisateur/evenement/%s";

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

	//////////////
  // nameFrFR //
	//////////////


  /**
   *  The entity nameFrFR
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String nameFrFR;

  /**
   * <br> The entity nameFrFR
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:nameFrFR">Find the entity nameFrFR in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _nameFrFR(Wrap<String> w);

  public String getNameFrFR() {
    return nameFrFR;
  }
  public void setNameFrFR(String o) {
    this.nameFrFR = CompanyEvent.staticSetNameFrFR(siteRequest_, o);
  }
  public static String staticSetNameFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent nameFrFRInit() {
    Wrap<String> nameFrFRWrap = new Wrap<String>().var("nameFrFR");
    if(nameFrFR == null) {
      _nameFrFR(nameFrFRWrap);
      Optional.ofNullable(nameFrFRWrap.getO()).ifPresent(o -> {
        setNameFrFR(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchNameFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrNameFrFR(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNameFrFR(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchNameFrFR(siteRequest_, CompanyEvent.staticSetNameFrFR(siteRequest_, o)).toString();
  }

  public String sqlNameFrFR() {
    return nameFrFR;
  }

  public static String staticJsonNameFrFR(String nameFrFR) {
    return nameFrFR;
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

	/////////////////////
  // descriptionFrFR //
	/////////////////////


  /**
   *  The entity descriptionFrFR
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String descriptionFrFR;

  /**
   * <br> The entity descriptionFrFR
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:descriptionFrFR">Find the entity descriptionFrFR in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _descriptionFrFR(Wrap<String> w);

  public String getDescriptionFrFR() {
    return descriptionFrFR;
  }
  public void setDescriptionFrFR(String o) {
    this.descriptionFrFR = CompanyEvent.staticSetDescriptionFrFR(siteRequest_, o);
  }
  public static String staticSetDescriptionFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent descriptionFrFRInit() {
    Wrap<String> descriptionFrFRWrap = new Wrap<String>().var("descriptionFrFR");
    if(descriptionFrFR == null) {
      _descriptionFrFR(descriptionFrFRWrap);
      Optional.ofNullable(descriptionFrFRWrap.getO()).ifPresent(o -> {
        setDescriptionFrFR(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchDescriptionFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDescriptionFrFR(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDescriptionFrFR(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchDescriptionFrFR(siteRequest_, CompanyEvent.staticSetDescriptionFrFR(siteRequest_, o)).toString();
  }

  public String sqlDescriptionFrFR() {
    return descriptionFrFR;
  }

  public static String staticJsonDescriptionFrFR(String descriptionFrFR) {
    return descriptionFrFR;
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
  public static MathContext staticMathContextPrice() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetPrice(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextPrice());
    return null;
  }
  @JsonIgnore
  public void setPrice(Double o) {
    setPrice(new BigDecimal(o, staticMathContextPrice()));
  }
  @JsonIgnore
  public void setPrice(Integer o) {
    setPrice(new BigDecimal(o, staticMathContextPrice()));
  }
  @JsonIgnore
  public void setPrice(Number o) {
    setPrice(new BigDecimal(o.doubleValue(), staticMathContextPrice()));
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
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
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
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
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

	////////////////////
  // dialogTemplate //
	////////////////////


  /**
   *  The entity dialogTemplate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dialogTemplate;

  /**
   * <br> The entity dialogTemplate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:dialogTemplate">Find the entity dialogTemplate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dialogTemplate(Wrap<String> w);

  public String getDialogTemplate() {
    return dialogTemplate;
  }
  public void setDialogTemplate(String o) {
    this.dialogTemplate = CompanyEvent.staticSetDialogTemplate(siteRequest_, o);
  }
  public static String staticSetDialogTemplate(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent dialogTemplateInit() {
    Wrap<String> dialogTemplateWrap = new Wrap<String>().var("dialogTemplate");
    if(dialogTemplate == null) {
      _dialogTemplate(dialogTemplateWrap);
      Optional.ofNullable(dialogTemplateWrap.getO()).ifPresent(o -> {
        setDialogTemplate(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchDialogTemplate(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDialogTemplate(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDialogTemplate(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchDialogTemplate(siteRequest_, CompanyEvent.staticSetDialogTemplate(siteRequest_, o)).toString();
  }

  public String sqlDialogTemplate() {
    return dialogTemplate;
  }

  public static String staticJsonDialogTemplate(String dialogTemplate) {
    return dialogTemplate;
  }

	////////////////////////
  // dialogTemplateFrFR //
	////////////////////////


  /**
   *  The entity dialogTemplateFrFR
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dialogTemplateFrFR;

  /**
   * <br> The entity dialogTemplateFrFR
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:dialogTemplateFrFR">Find the entity dialogTemplateFrFR in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dialogTemplateFrFR(Wrap<String> w);

  public String getDialogTemplateFrFR() {
    return dialogTemplateFrFR;
  }
  public void setDialogTemplateFrFR(String o) {
    this.dialogTemplateFrFR = CompanyEvent.staticSetDialogTemplateFrFR(siteRequest_, o);
  }
  public static String staticSetDialogTemplateFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent dialogTemplateFrFRInit() {
    Wrap<String> dialogTemplateFrFRWrap = new Wrap<String>().var("dialogTemplateFrFR");
    if(dialogTemplateFrFR == null) {
      _dialogTemplateFrFR(dialogTemplateFrFRWrap);
      Optional.ofNullable(dialogTemplateFrFRWrap.getO()).ifPresent(o -> {
        setDialogTemplateFrFR(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchDialogTemplateFrFR(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDialogTemplateFrFR(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDialogTemplateFrFR(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchDialogTemplateFrFR(siteRequest_, CompanyEvent.staticSetDialogTemplateFrFR(siteRequest_, o)).toString();
  }

  public String sqlDialogTemplateFrFR() {
    return dialogTemplateFrFR;
  }

  public static String staticJsonDialogTemplateFrFR(String dialogTemplateFrFR) {
    return dialogTemplateFrFR;
  }

	//////////////////
  // pageImageUri //
	//////////////////


  /**
   *  The entity pageImageUri
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageImageUri;

  /**
   * <br> The entity pageImageUri
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageImageUri(Wrap<String> w);

  public String getPageImageUri() {
    return pageImageUri;
  }
  public void setPageImageUri(String o) {
    this.pageImageUri = CompanyEvent.staticSetPageImageUri(siteRequest_, o);
  }
  public static String staticSetPageImageUri(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent pageImageUriInit() {
    Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri");
    if(pageImageUri == null) {
      _pageImageUri(pageImageUriWrap);
      Optional.ofNullable(pageImageUriWrap.getO()).ifPresent(o -> {
        setPageImageUri(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchPageImageUri(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageImageUri(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageImageUri(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageImageUri(siteRequest_, CompanyEvent.staticSetPageImageUri(siteRequest_, o)).toString();
  }

  public String sqlPageImageUri() {
    return pageImageUri;
  }

  public static String staticJsonPageImageUri(String pageImageUri) {
    return pageImageUri;
  }

	////////////////////
  // pageImageWidth //
	////////////////////


  /**
   *  The entity pageImageWidth
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer pageImageWidth;

  /**
   * <br> The entity pageImageWidth
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageImageWidth">Find the entity pageImageWidth in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageImageWidth(Wrap<Integer> w);

  public Integer getPageImageWidth() {
    return pageImageWidth;
  }

  public void setPageImageWidth(Integer pageImageWidth) {
    this.pageImageWidth = pageImageWidth;
  }
  @JsonIgnore
  public void setPageImageWidth(String o) {
    this.pageImageWidth = CompanyEvent.staticSetPageImageWidth(siteRequest_, o);
  }
  public static Integer staticSetPageImageWidth(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected CompanyEvent pageImageWidthInit() {
    Wrap<Integer> pageImageWidthWrap = new Wrap<Integer>().var("pageImageWidth");
    if(pageImageWidth == null) {
      _pageImageWidth(pageImageWidthWrap);
      Optional.ofNullable(pageImageWidthWrap.getO()).ifPresent(o -> {
        setPageImageWidth(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static Integer staticSearchPageImageWidth(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrPageImageWidth(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageImageWidth(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageImageWidth(siteRequest_, CompanyEvent.staticSetPageImageWidth(siteRequest_, o)).toString();
  }

	/////////////////////
  // pageImageHeight //
	/////////////////////


  /**
   *  The entity pageImageHeight
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer pageImageHeight;

  /**
   * <br> The entity pageImageHeight
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageImageHeight">Find the entity pageImageHeight in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageImageHeight(Wrap<Integer> c);

  public Integer getPageImageHeight() {
    return pageImageHeight;
  }

  public void setPageImageHeight(Integer pageImageHeight) {
    this.pageImageHeight = pageImageHeight;
  }
  @JsonIgnore
  public void setPageImageHeight(String o) {
    this.pageImageHeight = CompanyEvent.staticSetPageImageHeight(siteRequest_, o);
  }
  public static Integer staticSetPageImageHeight(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected CompanyEvent pageImageHeightInit() {
    Wrap<Integer> pageImageHeightWrap = new Wrap<Integer>().var("pageImageHeight");
    if(pageImageHeight == null) {
      _pageImageHeight(pageImageHeightWrap);
      Optional.ofNullable(pageImageHeightWrap.getO()).ifPresent(o -> {
        setPageImageHeight(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static Integer staticSearchPageImageHeight(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrPageImageHeight(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageImageHeight(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageImageHeight(siteRequest_, CompanyEvent.staticSetPageImageHeight(siteRequest_, o)).toString();
  }

	///////////////////
  // pageImageType //
	///////////////////


  /**
   *  The entity pageImageType
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageImageType;

  /**
   * <br> The entity pageImageType
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageImageType">Find the entity pageImageType in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageImageType(Wrap<String> c);

  public String getPageImageType() {
    return pageImageType;
  }
  public void setPageImageType(String o) {
    this.pageImageType = CompanyEvent.staticSetPageImageType(siteRequest_, o);
  }
  public static String staticSetPageImageType(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent pageImageTypeInit() {
    Wrap<String> pageImageTypeWrap = new Wrap<String>().var("pageImageType");
    if(pageImageType == null) {
      _pageImageType(pageImageTypeWrap);
      Optional.ofNullable(pageImageTypeWrap.getO()).ifPresent(o -> {
        setPageImageType(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchPageImageType(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageImageType(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageImageType(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageImageType(siteRequest_, CompanyEvent.staticSetPageImageType(siteRequest_, o)).toString();
  }

	//////////////////
  // pageImageAlt //
	//////////////////


  /**
   *  The entity pageImageAlt
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageImageAlt;

  /**
   * <br> The entity pageImageAlt
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:pageImageAlt">Find the entity pageImageAlt in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageImageAlt(Wrap<String> c);

  public String getPageImageAlt() {
    return pageImageAlt;
  }
  public void setPageImageAlt(String o) {
    this.pageImageAlt = CompanyEvent.staticSetPageImageAlt(siteRequest_, o);
  }
  public static String staticSetPageImageAlt(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent pageImageAltInit() {
    Wrap<String> pageImageAltWrap = new Wrap<String>().var("pageImageAlt");
    if(pageImageAlt == null) {
      _pageImageAlt(pageImageAltWrap);
      Optional.ofNullable(pageImageAltWrap.getO()).ifPresent(o -> {
        setPageImageAlt(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchPageImageAlt(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageImageAlt(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageImageAlt(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchPageImageAlt(siteRequest_, CompanyEvent.staticSetPageImageAlt(siteRequest_, o)).toString();
  }

  public String sqlPageImageAlt() {
    return pageImageAlt;
  }

  public static String staticJsonPageImageAlt(String pageImageAlt) {
    return pageImageAlt;
  }

	//////////////////
  // labelsString //
	//////////////////


  /**
   *  The entity labelsString
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String labelsString;

  /**
   * <br> The entity labelsString
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:labelsString">Find the entity labelsString in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _labelsString(Wrap<String> w);

  public String getLabelsString() {
    return labelsString;
  }
  public void setLabelsString(String o) {
    this.labelsString = CompanyEvent.staticSetLabelsString(siteRequest_, o);
  }
  public static String staticSetLabelsString(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent labelsStringInit() {
    Wrap<String> labelsStringWrap = new Wrap<String>().var("labelsString");
    if(labelsString == null) {
      _labelsString(labelsStringWrap);
      Optional.ofNullable(labelsStringWrap.getO()).ifPresent(o -> {
        setLabelsString(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchLabelsString(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLabelsString(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLabelsString(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLabelsString(siteRequest_, CompanyEvent.staticSetLabelsString(siteRequest_, o)).toString();
  }

  public String sqlLabelsString() {
    return labelsString;
  }

  public static String staticJsonLabelsString(String labelsString) {
    return labelsString;
  }

	////////////
  // labels //
	////////////


  /**
   *  The entity labels
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> labels = new ArrayList<String>();

  /**
   * <br> The entity labels
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:labels">Find the entity labels in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _labels(List<String> l);

  public List<String> getLabels() {
    return labels;
  }

  public void setLabels(List<String> labels) {
    this.labels = labels;
  }
  @JsonIgnore
  public void setLabels(String o) {
    String l = CompanyEvent.staticSetLabels(siteRequest_, o);
    if(l != null)
      addLabels(l);
  }
  public static String staticSetLabels(SiteRequest siteRequest_, String o) {
    return o;
  }
  public CompanyEvent addLabels(String...objects) {
    for(String o : objects) {
      addLabels(o);
    }
    return (CompanyEvent)this;
  }
  public CompanyEvent addLabels(String o) {
    if(o != null)
      this.labels.add(o);
    return (CompanyEvent)this;
  }
  @JsonIgnore
  public void setLabels(JsonArray objects) {
    labels.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addLabels(o);
    }
  }
  protected CompanyEvent labelsInit() {
    _labels(labels);
    return (CompanyEvent)this;
  }

  public static String staticSearchLabels(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLabels(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLabels(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchLabels(siteRequest_, CompanyEvent.staticSetLabels(siteRequest_, o)).toString();
  }

  public String[] sqlLabels() {
    return labels.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonLabels(List<String> labels) {
    JsonArray a = new JsonArray();
    labels.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////
  // authorName //
	////////////////


  /**
   *  The entity authorName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String authorName;

  /**
   * <br> The entity authorName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:authorName">Find the entity authorName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _authorName(Wrap<String> w);

  public String getAuthorName() {
    return authorName;
  }
  public void setAuthorName(String o) {
    this.authorName = CompanyEvent.staticSetAuthorName(siteRequest_, o);
  }
  public static String staticSetAuthorName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent authorNameInit() {
    Wrap<String> authorNameWrap = new Wrap<String>().var("authorName");
    if(authorName == null) {
      _authorName(authorNameWrap);
      Optional.ofNullable(authorNameWrap.getO()).ifPresent(o -> {
        setAuthorName(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchAuthorName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAuthorName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAuthorName(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchAuthorName(siteRequest_, CompanyEvent.staticSetAuthorName(siteRequest_, o)).toString();
  }

  public String sqlAuthorName() {
    return authorName;
  }

  public static String staticJsonAuthorName(String authorName) {
    return authorName;
  }

	///////////////
  // authorUrl //
	///////////////


  /**
   *  The entity authorUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String authorUrl;

  /**
   * <br> The entity authorUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.event.CompanyEvent&fq=entiteVar_enUS_indexed_string:authorUrl">Find the entity authorUrl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _authorUrl(Wrap<String> w);

  public String getAuthorUrl() {
    return authorUrl;
  }
  public void setAuthorUrl(String o) {
    this.authorUrl = CompanyEvent.staticSetAuthorUrl(siteRequest_, o);
  }
  public static String staticSetAuthorUrl(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected CompanyEvent authorUrlInit() {
    Wrap<String> authorUrlWrap = new Wrap<String>().var("authorUrl");
    if(authorUrl == null) {
      _authorUrl(authorUrlWrap);
      Optional.ofNullable(authorUrlWrap.getO()).ifPresent(o -> {
        setAuthorUrl(o);
      });
    }
    return (CompanyEvent)this;
  }

  public static String staticSearchAuthorUrl(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAuthorUrl(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAuthorUrl(SiteRequest siteRequest_, String o) {
    return CompanyEvent.staticSearchAuthorUrl(siteRequest_, CompanyEvent.staticSetAuthorUrl(siteRequest_, o)).toString();
  }

  public String sqlAuthorUrl() {
    return authorUrl;
  }

  public static String staticJsonAuthorUrl(String authorUrl) {
    return authorUrl;
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
        nameFrFRInit();
        descriptionInit();
        descriptionFrFRInit();
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
        dialogTemplateInit();
        dialogTemplateFrFRInit();
        pageImageUriInit();
        pageImageWidthInit();
        pageImageHeightInit();
        pageImageTypeInit();
        pageImageAltInit();
        labelsStringInit();
        labelsInit();
        authorNameInit();
        authorUrlInit();
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
      case "nameFrFR":
        return oCompanyEvent.nameFrFR;
      case "description":
        return oCompanyEvent.description;
      case "descriptionFrFR":
        return oCompanyEvent.descriptionFrFR;
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
      case "dialogTemplate":
        return oCompanyEvent.dialogTemplate;
      case "dialogTemplateFrFR":
        return oCompanyEvent.dialogTemplateFrFR;
      case "pageImageUri":
        return oCompanyEvent.pageImageUri;
      case "pageImageWidth":
        return oCompanyEvent.pageImageWidth;
      case "pageImageHeight":
        return oCompanyEvent.pageImageHeight;
      case "pageImageType":
        return oCompanyEvent.pageImageType;
      case "pageImageAlt":
        return oCompanyEvent.pageImageAlt;
      case "labelsString":
        return oCompanyEvent.labelsString;
      case "labels":
        return oCompanyEvent.labels;
      case "authorName":
        return oCompanyEvent.authorName;
      case "authorUrl":
        return oCompanyEvent.authorUrl;
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
    case "nameFrFR":
      return CompanyEvent.staticSetNameFrFR(siteRequest_, v);
    case "description":
      return CompanyEvent.staticSetDescription(siteRequest_, v);
    case "descriptionFrFR":
      return CompanyEvent.staticSetDescriptionFrFR(siteRequest_, v);
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
    case "dialogTemplate":
      return CompanyEvent.staticSetDialogTemplate(siteRequest_, v);
    case "dialogTemplateFrFR":
      return CompanyEvent.staticSetDialogTemplateFrFR(siteRequest_, v);
    case "pageImageUri":
      return CompanyEvent.staticSetPageImageUri(siteRequest_, v);
    case "pageImageWidth":
      return CompanyEvent.staticSetPageImageWidth(siteRequest_, v);
    case "pageImageHeight":
      return CompanyEvent.staticSetPageImageHeight(siteRequest_, v);
    case "pageImageType":
      return CompanyEvent.staticSetPageImageType(siteRequest_, v);
    case "pageImageAlt":
      return CompanyEvent.staticSetPageImageAlt(siteRequest_, v);
    case "labelsString":
      return CompanyEvent.staticSetLabelsString(siteRequest_, v);
    case "labels":
      return CompanyEvent.staticSetLabels(siteRequest_, v);
    case "authorName":
      return CompanyEvent.staticSetAuthorName(siteRequest_, v);
    case "authorUrl":
      return CompanyEvent.staticSetAuthorUrl(siteRequest_, v);
      default:
        return BaseResult.staticSetBaseResult(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Future<CompanyEvent> fqCompanyEvent(SiteRequest siteRequest, String var, Object val) {
    Promise<CompanyEvent> promise = Promise.promise();
    try {
      if(val == null) {
        promise.complete();
      } else {
        SearchList<CompanyEvent> searchList = new SearchList<CompanyEvent>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(CompanyEvent.class);
        searchList.fq(String.format("%s:", CompanyEvent.varIndexedCompanyEvent(var)) + SearchTool.escapeQueryChars(val.toString()));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            promise.complete(searchList.getList().stream().findFirst().orElse(null));
          } catch(Throwable ex) {
            LOG.error("Error while querying theevent", ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error("Error while querying theevent", ex);
          promise.fail(ex);
        });
      }
    } catch(Throwable ex) {
      LOG.error("Error while querying theevent", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchCompanyEvent(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchCompanyEvent(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "name":
      return CompanyEvent.staticSearchName(siteRequest_, (String)o);
    case "nameFrFR":
      return CompanyEvent.staticSearchNameFrFR(siteRequest_, (String)o);
    case "description":
      return CompanyEvent.staticSearchDescription(siteRequest_, (String)o);
    case "descriptionFrFR":
      return CompanyEvent.staticSearchDescriptionFrFR(siteRequest_, (String)o);
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
    case "dialogTemplate":
      return CompanyEvent.staticSearchDialogTemplate(siteRequest_, (String)o);
    case "dialogTemplateFrFR":
      return CompanyEvent.staticSearchDialogTemplateFrFR(siteRequest_, (String)o);
    case "pageImageUri":
      return CompanyEvent.staticSearchPageImageUri(siteRequest_, (String)o);
    case "pageImageWidth":
      return CompanyEvent.staticSearchPageImageWidth(siteRequest_, (Integer)o);
    case "pageImageHeight":
      return CompanyEvent.staticSearchPageImageHeight(siteRequest_, (Integer)o);
    case "pageImageType":
      return CompanyEvent.staticSearchPageImageType(siteRequest_, (String)o);
    case "pageImageAlt":
      return CompanyEvent.staticSearchPageImageAlt(siteRequest_, (String)o);
    case "labelsString":
      return CompanyEvent.staticSearchLabelsString(siteRequest_, (String)o);
    case "labels":
      return CompanyEvent.staticSearchLabels(siteRequest_, (String)o);
    case "authorName":
      return CompanyEvent.staticSearchAuthorName(siteRequest_, (String)o);
    case "authorUrl":
      return CompanyEvent.staticSearchAuthorUrl(siteRequest_, (String)o);
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
    case "nameFrFR":
      return CompanyEvent.staticSearchStrNameFrFR(siteRequest_, (String)o);
    case "description":
      return CompanyEvent.staticSearchStrDescription(siteRequest_, (String)o);
    case "descriptionFrFR":
      return CompanyEvent.staticSearchStrDescriptionFrFR(siteRequest_, (String)o);
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
    case "dialogTemplate":
      return CompanyEvent.staticSearchStrDialogTemplate(siteRequest_, (String)o);
    case "dialogTemplateFrFR":
      return CompanyEvent.staticSearchStrDialogTemplateFrFR(siteRequest_, (String)o);
    case "pageImageUri":
      return CompanyEvent.staticSearchStrPageImageUri(siteRequest_, (String)o);
    case "pageImageWidth":
      return CompanyEvent.staticSearchStrPageImageWidth(siteRequest_, (Integer)o);
    case "pageImageHeight":
      return CompanyEvent.staticSearchStrPageImageHeight(siteRequest_, (Integer)o);
    case "pageImageType":
      return CompanyEvent.staticSearchStrPageImageType(siteRequest_, (String)o);
    case "pageImageAlt":
      return CompanyEvent.staticSearchStrPageImageAlt(siteRequest_, (String)o);
    case "labelsString":
      return CompanyEvent.staticSearchStrLabelsString(siteRequest_, (String)o);
    case "labels":
      return CompanyEvent.staticSearchStrLabels(siteRequest_, (String)o);
    case "authorName":
      return CompanyEvent.staticSearchStrAuthorName(siteRequest_, (String)o);
    case "authorUrl":
      return CompanyEvent.staticSearchStrAuthorUrl(siteRequest_, (String)o);
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
    case "nameFrFR":
      return CompanyEvent.staticSearchFqNameFrFR(siteRequest_, o);
    case "description":
      return CompanyEvent.staticSearchFqDescription(siteRequest_, o);
    case "descriptionFrFR":
      return CompanyEvent.staticSearchFqDescriptionFrFR(siteRequest_, o);
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
    case "dialogTemplate":
      return CompanyEvent.staticSearchFqDialogTemplate(siteRequest_, o);
    case "dialogTemplateFrFR":
      return CompanyEvent.staticSearchFqDialogTemplateFrFR(siteRequest_, o);
    case "pageImageUri":
      return CompanyEvent.staticSearchFqPageImageUri(siteRequest_, o);
    case "pageImageWidth":
      return CompanyEvent.staticSearchFqPageImageWidth(siteRequest_, o);
    case "pageImageHeight":
      return CompanyEvent.staticSearchFqPageImageHeight(siteRequest_, o);
    case "pageImageType":
      return CompanyEvent.staticSearchFqPageImageType(siteRequest_, o);
    case "pageImageAlt":
      return CompanyEvent.staticSearchFqPageImageAlt(siteRequest_, o);
    case "labelsString":
      return CompanyEvent.staticSearchFqLabelsString(siteRequest_, o);
    case "labels":
      return CompanyEvent.staticSearchFqLabels(siteRequest_, o);
    case "authorName":
      return CompanyEvent.staticSearchFqAuthorName(siteRequest_, o);
    case "authorUrl":
      return CompanyEvent.staticSearchFqAuthorUrl(siteRequest_, o);
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
      } else if("namefrfr".equals(varLower)) {
        if(val instanceof String) {
          setNameFrFR((String)val);
        }
        saves.add("nameFrFR");
        return val;
      } else if("description".equals(varLower)) {
        if(val instanceof String) {
          setDescription((String)val);
        }
        saves.add("description");
        return val;
      } else if("descriptionfrfr".equals(varLower)) {
        if(val instanceof String) {
          setDescriptionFrFR((String)val);
        }
        saves.add("descriptionFrFR");
        return val;
      } else if("startdatetime".equals(varLower)) {
        if(val instanceof String) {
          setStartDateTime((String)val);
        } else if(val instanceof OffsetDateTime) {
          setStartDateTime(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setStartDateTime((ZonedDateTime)val);
        }
        saves.add("startDateTime");
        return val;
      } else if("enddatetime".equals(varLower)) {
        if(val instanceof String) {
          setEndDateTime((String)val);
        } else if(val instanceof OffsetDateTime) {
          setEndDateTime(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setEndDateTime((ZonedDateTime)val);
        }
        saves.add("endDateTime");
        return val;
      } else if("price".equals(varLower)) {
        if(val instanceof String) {
          setPrice((String)val);
        } else if(val instanceof Number) {
          setPrice(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setPrice((BigDecimal)val);
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
        } else if(val instanceof JsonObject) {
          setLocation((JsonObject)val);
        } else if(val instanceof Point) {
          setLocation((Point)val);
        } else if(val instanceof Point) {
          setLocation((Point)val);
        }
        saves.add("location");
        return val;
      } else if("dialogtemplate".equals(varLower)) {
        if(val instanceof String) {
          setDialogTemplate((String)val);
        }
        saves.add("dialogTemplate");
        return val;
      } else if("dialogtemplatefrfr".equals(varLower)) {
        if(val instanceof String) {
          setDialogTemplateFrFR((String)val);
        }
        saves.add("dialogTemplateFrFR");
        return val;
      } else if("pageimageuri".equals(varLower)) {
        if(val instanceof String) {
          setPageImageUri((String)val);
        }
        saves.add("pageImageUri");
        return val;
      } else if("pageimagealt".equals(varLower)) {
        if(val instanceof String) {
          setPageImageAlt((String)val);
        }
        saves.add("pageImageAlt");
        return val;
      } else if("labelsstring".equals(varLower)) {
        if(val instanceof String) {
          setLabelsString((String)val);
        }
        saves.add("labelsString");
        return val;
      } else if("labels".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addLabels(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addLabels((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addLabels(staticSetLabels(siteRequest_, v.toString())));
        }
        if(!saves.contains("labels")) {
          saves.add("labels");
        }
        return val;
      } else if("authorname".equals(varLower)) {
        if(val instanceof String) {
          setAuthorName((String)val);
        }
        saves.add("authorName");
        return val;
      } else if("authorurl".equals(varLower)) {
        if(val instanceof String) {
          setAuthorUrl((String)val);
        }
        saves.add("authorUrl");
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

      if(saves.contains("nameFrFR")) {
        String nameFrFR = (String)doc.get("nameFrFR_docvalues_string");
        if(nameFrFR != null)
          oCompanyEvent.setNameFrFR(nameFrFR);
      }

      if(saves.contains("description")) {
        String description = (String)doc.get("description_docvalues_string");
        if(description != null)
          oCompanyEvent.setDescription(description);
      }

      if(saves.contains("descriptionFrFR")) {
        String descriptionFrFR = (String)doc.get("descriptionFrFR_docvalues_string");
        if(descriptionFrFR != null)
          oCompanyEvent.setDescriptionFrFR(descriptionFrFR);
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
        Double price = (Double)doc.get("price_docvalues_string");
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

      if(saves.contains("dialogTemplate")) {
        String dialogTemplate = (String)doc.get("dialogTemplate_docvalues_string");
        if(dialogTemplate != null)
          oCompanyEvent.setDialogTemplate(dialogTemplate);
      }

      if(saves.contains("dialogTemplateFrFR")) {
        String dialogTemplateFrFR = (String)doc.get("dialogTemplateFrFR_docvalues_string");
        if(dialogTemplateFrFR != null)
          oCompanyEvent.setDialogTemplateFrFR(dialogTemplateFrFR);
      }

      if(saves.contains("pageImageUri")) {
        String pageImageUri = (String)doc.get("pageImageUri_docvalues_string");
        if(pageImageUri != null)
          oCompanyEvent.setPageImageUri(pageImageUri);
      }

      if(saves.contains("pageImageWidth")) {
        Integer pageImageWidth = (Integer)doc.get("pageImageWidth_docvalues_int");
        if(pageImageWidth != null)
          oCompanyEvent.setPageImageWidth(pageImageWidth);
      }

      if(saves.contains("pageImageHeight")) {
        Integer pageImageHeight = (Integer)doc.get("pageImageHeight_docvalues_int");
        if(pageImageHeight != null)
          oCompanyEvent.setPageImageHeight(pageImageHeight);
      }

      if(saves.contains("pageImageType")) {
        String pageImageType = (String)doc.get("pageImageType_docvalues_string");
        if(pageImageType != null)
          oCompanyEvent.setPageImageType(pageImageType);
      }

      if(saves.contains("pageImageAlt")) {
        String pageImageAlt = (String)doc.get("pageImageAlt_docvalues_string");
        if(pageImageAlt != null)
          oCompanyEvent.setPageImageAlt(pageImageAlt);
      }

      if(saves.contains("labelsString")) {
        String labelsString = (String)doc.get("labelsString_docvalues_string");
        if(labelsString != null)
          oCompanyEvent.setLabelsString(labelsString);
      }

      if(saves.contains("labels")) {
        List<String> labels = (List<String>)doc.get("labels_docvalues_strings");
        if(labels != null) {
          labels.stream().forEach( v -> {
            oCompanyEvent.labels.add(CompanyEvent.staticSetLabels(siteRequest_, v));
          });
        }
      }

      if(saves.contains("authorName")) {
        String authorName = (String)doc.get("authorName_docvalues_string");
        if(authorName != null)
          oCompanyEvent.setAuthorName(authorName);
      }

      if(saves.contains("authorUrl")) {
        String authorUrl = (String)doc.get("authorUrl_docvalues_string");
        if(authorUrl != null)
          oCompanyEvent.setAuthorUrl(authorUrl);
      }
    }

    super.populateBaseResult(doc);
  }

  public void indexCompanyEvent(JsonObject doc) {
    if(name != null) {
      doc.put("name_docvalues_string", name);
    }
    if(nameFrFR != null) {
      doc.put("nameFrFR_docvalues_string", nameFrFR);
    }
    if(description != null) {
      doc.put("description_docvalues_string", description);
    }
    if(descriptionFrFR != null) {
      doc.put("descriptionFrFR_docvalues_string", descriptionFrFR);
    }
    if(startDateTime != null) {
      doc.put("startDateTime_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(startDateTime.toInstant(), ZoneId.of("UTC"))));
    }
    if(endDateTime != null) {
      doc.put("endDateTime_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(endDateTime.toInstant(), ZoneId.of("UTC"))));
    }
    if(price != null) {
      doc.put("price_docvalues_string", price.toPlainString());
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
    if(dialogTemplate != null) {
      doc.put("dialogTemplate_docvalues_string", dialogTemplate);
    }
    if(dialogTemplateFrFR != null) {
      doc.put("dialogTemplateFrFR_docvalues_string", dialogTemplateFrFR);
    }
    if(pageImageUri != null) {
      doc.put("pageImageUri_docvalues_string", pageImageUri);
    }
    if(pageImageWidth != null) {
      doc.put("pageImageWidth_docvalues_int", pageImageWidth);
    }
    if(pageImageHeight != null) {
      doc.put("pageImageHeight_docvalues_int", pageImageHeight);
    }
    if(pageImageType != null) {
      doc.put("pageImageType_docvalues_string", pageImageType);
    }
    if(pageImageAlt != null) {
      doc.put("pageImageAlt_docvalues_string", pageImageAlt);
    }
    if(labelsString != null) {
      doc.put("labelsString_docvalues_string", labelsString);
    }
    if(labels != null) {
      JsonArray l = new JsonArray();
      doc.put("labels_docvalues_strings", l);
      for(String o : labels) {
        l.add(CompanyEvent.staticSearchLabels(siteRequest_, o));
      }
    }
    if(authorName != null) {
      doc.put("authorName_docvalues_string", authorName);
    }
    if(authorUrl != null) {
      doc.put("authorUrl_docvalues_string", authorUrl);
    }
    super.indexBaseResult(doc);

	}

  public static String varStoredCompanyEvent(String entityVar) {
    switch(entityVar) {
      case "name":
        return "name_docvalues_string";
      case "nameFrFR":
        return "nameFrFR_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "descriptionFrFR":
        return "descriptionFrFR_docvalues_string";
      case "startDateTime":
        return "startDateTime_docvalues_date";
      case "endDateTime":
        return "endDateTime_docvalues_date";
      case "price":
        return "price_docvalues_string";
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
      case "dialogTemplate":
        return "dialogTemplate_docvalues_string";
      case "dialogTemplateFrFR":
        return "dialogTemplateFrFR_docvalues_string";
      case "pageImageUri":
        return "pageImageUri_docvalues_string";
      case "pageImageWidth":
        return "pageImageWidth_docvalues_int";
      case "pageImageHeight":
        return "pageImageHeight_docvalues_int";
      case "pageImageType":
        return "pageImageType_docvalues_string";
      case "pageImageAlt":
        return "pageImageAlt_docvalues_string";
      case "labelsString":
        return "labelsString_docvalues_string";
      case "labels":
        return "labels_docvalues_strings";
      case "authorName":
        return "authorName_docvalues_string";
      case "authorUrl":
        return "authorUrl_docvalues_string";
      default:
        return BaseResult.varStoredBaseResult(entityVar);
    }
  }

  public static String varIndexedCompanyEvent(String entityVar) {
    switch(entityVar) {
      case "name":
        return "name_docvalues_string";
      case "nameFrFR":
        return "nameFrFR_docvalues_string";
      case "description":
        return "description_docvalues_string";
      case "descriptionFrFR":
        return "descriptionFrFR_docvalues_string";
      case "startDateTime":
        return "startDateTime_docvalues_date";
      case "endDateTime":
        return "endDateTime_docvalues_date";
      case "price":
        return "price_docvalues_string";
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
      case "dialogTemplate":
        return "dialogTemplate_docvalues_string";
      case "dialogTemplateFrFR":
        return "dialogTemplateFrFR_docvalues_string";
      case "pageImageUri":
        return "pageImageUri_docvalues_string";
      case "pageImageWidth":
        return "pageImageWidth_docvalues_int";
      case "pageImageHeight":
        return "pageImageHeight_docvalues_int";
      case "pageImageType":
        return "pageImageType_docvalues_string";
      case "pageImageAlt":
        return "pageImageAlt_docvalues_string";
      case "labelsString":
        return "labelsString_docvalues_string";
      case "labels":
        return "labels_docvalues_strings";
      case "authorName":
        return "authorName_docvalues_string";
      case "authorUrl":
        return "authorUrl_docvalues_string";
      default:
        return BaseResult.varIndexedBaseResult(entityVar);
    }
  }

  public static String searchVarCompanyEvent(String searchVar) {
    switch(searchVar) {
      case "name_docvalues_string":
        return "name";
      case "nameFrFR_docvalues_string":
        return "nameFrFR";
      case "description_docvalues_string":
        return "description";
      case "descriptionFrFR_docvalues_string":
        return "descriptionFrFR";
      case "startDateTime_docvalues_date":
        return "startDateTime";
      case "endDateTime_docvalues_date":
        return "endDateTime";
      case "price_docvalues_string":
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
      case "dialogTemplate_docvalues_string":
        return "dialogTemplate";
      case "dialogTemplateFrFR_docvalues_string":
        return "dialogTemplateFrFR";
      case "pageImageUri_docvalues_string":
        return "pageImageUri";
      case "pageImageWidth_docvalues_int":
        return "pageImageWidth";
      case "pageImageHeight_docvalues_int":
        return "pageImageHeight";
      case "pageImageType_docvalues_string":
        return "pageImageType";
      case "pageImageAlt_docvalues_string":
        return "pageImageAlt";
      case "labelsString_docvalues_string":
        return "labelsString";
      case "labels_docvalues_strings":
        return "labels";
      case "authorName_docvalues_string":
        return "authorName";
      case "authorUrl_docvalues_string":
        return "authorUrl";
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
    oCompanyEvent.setNameFrFR(Optional.ofNullable(doc.get("nameFrFR_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setDescriptionFrFR(Optional.ofNullable(doc.get("descriptionFrFR_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setStartDateTime(Optional.ofNullable(doc.get("startDateTime_docvalues_date")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setEndDateTime(Optional.ofNullable(doc.get("endDateTime_docvalues_date")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPrice(Optional.ofNullable(doc.get("price_docvalues_string")).map(v -> v.toString()).orElse(null));
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
    oCompanyEvent.setDialogTemplate(Optional.ofNullable(doc.get("dialogTemplate_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setDialogTemplateFrFR(Optional.ofNullable(doc.get("dialogTemplateFrFR_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageImageUri(Optional.ofNullable(doc.get("pageImageUri_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageImageWidth(Optional.ofNullable(doc.get("pageImageWidth_docvalues_int")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageImageHeight(Optional.ofNullable(doc.get("pageImageHeight_docvalues_int")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageImageType(Optional.ofNullable(doc.get("pageImageType_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setPageImageAlt(Optional.ofNullable(doc.get("pageImageAlt_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setLabelsString(Optional.ofNullable(doc.get("labelsString_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("labels_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oCompanyEvent.addLabels(CompanyEvent.staticSetLabels(siteRequest, v.toString()));
    });
    oCompanyEvent.setAuthorName(Optional.ofNullable(doc.get("authorName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oCompanyEvent.setAuthorUrl(Optional.ofNullable(doc.get("authorUrl_docvalues_string")).map(v -> v.toString()).orElse(null));

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
      if(!Objects.equals(nameFrFR, original.getNameFrFR()))
        apiRequest.addVars("nameFrFR");
      if(!Objects.equals(description, original.getDescription()))
        apiRequest.addVars("description");
      if(!Objects.equals(descriptionFrFR, original.getDescriptionFrFR()))
        apiRequest.addVars("descriptionFrFR");
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
      if(!Objects.equals(dialogTemplate, original.getDialogTemplate()))
        apiRequest.addVars("dialogTemplate");
      if(!Objects.equals(dialogTemplateFrFR, original.getDialogTemplateFrFR()))
        apiRequest.addVars("dialogTemplateFrFR");
      if(!Objects.equals(pageImageUri, original.getPageImageUri()))
        apiRequest.addVars("pageImageUri");
      if(!Objects.equals(pageImageWidth, original.getPageImageWidth()))
        apiRequest.addVars("pageImageWidth");
      if(!Objects.equals(pageImageHeight, original.getPageImageHeight()))
        apiRequest.addVars("pageImageHeight");
      if(!Objects.equals(pageImageType, original.getPageImageType()))
        apiRequest.addVars("pageImageType");
      if(!Objects.equals(pageImageAlt, original.getPageImageAlt()))
        apiRequest.addVars("pageImageAlt");
      if(!Objects.equals(labelsString, original.getLabelsString()))
        apiRequest.addVars("labelsString");
      if(!Objects.equals(labels, original.getLabels()))
        apiRequest.addVars("labels");
      if(!Objects.equals(authorName, original.getAuthorName()))
        apiRequest.addVars("authorName");
      if(!Objects.equals(authorUrl, original.getAuthorUrl()))
        apiRequest.addVars("authorUrl");
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
    sb.append(Optional.ofNullable(nameFrFR).map(v -> "nameFrFR: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(description).map(v -> "description: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(descriptionFrFR).map(v -> "descriptionFrFR: \"" + v + "\"\n" ).orElse(""));
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
    sb.append(Optional.ofNullable(dialogTemplate).map(v -> "dialogTemplate: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dialogTemplateFrFR).map(v -> "dialogTemplateFrFR: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(pageImageUri).map(v -> "pageImageUri: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(pageImageWidth).map(v -> "pageImageWidth: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(pageImageHeight).map(v -> "pageImageHeight: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(pageImageType).map(v -> "pageImageType: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(pageImageAlt).map(v -> "pageImageAlt: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(labelsString).map(v -> "labelsString: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(labels).map(v -> "labels: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(authorName).map(v -> "authorName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(authorUrl).map(v -> "authorUrl: \"" + v + "\"\n" ).orElse(""));
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
  public static final String SET_name = "setName";
  public static final String VAR_nameFrFR = "nameFrFR";
  public static final String SET_nameFrFR = "setNameFrFR";
  public static final String VAR_description = "description";
  public static final String SET_description = "setDescription";
  public static final String VAR_descriptionFrFR = "descriptionFrFR";
  public static final String SET_descriptionFrFR = "setDescriptionFrFR";
  public static final String VAR_startDateTime = "startDateTime";
  public static final String SET_startDateTime = "setStartDateTime";
  public static final String VAR_endDateTime = "endDateTime";
  public static final String SET_endDateTime = "setEndDateTime";
  public static final String VAR_price = "price";
  public static final String SET_price = "setPrice";
  public static final String VAR_pageId = "pageId";
  public static final String SET_pageId = "setPageId";
  public static final String VAR_emailTemplate = "emailTemplate";
  public static final String SET_emailTemplate = "setEmailTemplate";
  public static final String VAR_storeUrl = "storeUrl";
  public static final String SET_storeUrl = "setStoreUrl";
  public static final String VAR_location = "location";
  public static final String SET_location = "setLocation";
  public static final String VAR_locationColors = "locationColors";
  public static final String SET_locationColors = "setLocationColors";
  public static final String VAR_locationTitles = "locationTitles";
  public static final String SET_locationTitles = "setLocationTitles";
  public static final String VAR_locationLinks = "locationLinks";
  public static final String SET_locationLinks = "setLocationLinks";
  public static final String VAR_dialogTemplate = "dialogTemplate";
  public static final String SET_dialogTemplate = "setDialogTemplate";
  public static final String VAR_dialogTemplateFrFR = "dialogTemplateFrFR";
  public static final String SET_dialogTemplateFrFR = "setDialogTemplateFrFR";
  public static final String VAR_pageImageUri = "pageImageUri";
  public static final String SET_pageImageUri = "setPageImageUri";
  public static final String VAR_pageImageWidth = "pageImageWidth";
  public static final String SET_pageImageWidth = "setPageImageWidth";
  public static final String VAR_pageImageHeight = "pageImageHeight";
  public static final String SET_pageImageHeight = "setPageImageHeight";
  public static final String VAR_pageImageType = "pageImageType";
  public static final String SET_pageImageType = "setPageImageType";
  public static final String VAR_pageImageAlt = "pageImageAlt";
  public static final String SET_pageImageAlt = "setPageImageAlt";
  public static final String VAR_labelsString = "labelsString";
  public static final String SET_labelsString = "setLabelsString";
  public static final String VAR_labels = "labels";
  public static final String SET_labels = "setLabels";
  public static final String VAR_authorName = "authorName";
  public static final String SET_authorName = "setAuthorName";
  public static final String VAR_authorUrl = "authorUrl";
  public static final String SET_authorUrl = "setAuthorUrl";

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
    vars.add(VAR_nameFrFR);
    vars.add(VAR_description);
    vars.add(VAR_startDateTime);
    vars.add(VAR_endDateTime);
    vars.add(VAR_price);
    vars.add(VAR_pageId);
    vars.add(VAR_emailTemplate);
    vars.add(VAR_storeUrl);
    vars.add(VAR_location);
    vars.add(VAR_pageImageUri);
    vars.add(VAR_authorName);
    vars.add(VAR_authorUrl);
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
  public static final String DISPLAY_NAME_nameFrFR = "";
  public static final String DISPLAY_NAME_description = "event description";
  public static final String DISPLAY_NAME_descriptionFrFR = "";
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
  public static final String DISPLAY_NAME_dialogTemplate = "dialog template";
  public static final String DISPLAY_NAME_dialogTemplateFrFR = "dialog template";
  public static final String DISPLAY_NAME_pageImageUri = "image URI";
  public static final String DISPLAY_NAME_pageImageWidth = "";
  public static final String DISPLAY_NAME_pageImageHeight = "";
  public static final String DISPLAY_NAME_pageImageType = "";
  public static final String DISPLAY_NAME_pageImageAlt = "";
  public static final String DISPLAY_NAME_labelsString = "labels string";
  public static final String DISPLAY_NAME_labels = "labels";
  public static final String DISPLAY_NAME_authorName = "author name";
  public static final String DISPLAY_NAME_authorUrl = "author URL";

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
  public String frFRStringFormatUrlEditPageForClass() {
    return "%s/fr-fr/edition/evenement/%s";
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/event/%s";
  }

  @Override
  public String frFRStringFormatUrlDisplayPageForClass() {
    return "%s/fr-fr/visiter/evenement/%s";
  }

  @Override
  public String enUSStringFormatUrlDisplayPageForClass() {
    return "%s/en-us/shop/event/%s";
  }

  @Override
  public String frFRStringFormatUrlUserPageForClass() {
    return "%s/fr-fr/utilisateur/evenement/%s";
  }

  @Override
  public String enUSStringFormatUrlUserPageForClass() {
    return "%s/en-us/use/event/%s";
  }

  public static String varJsonForClass(String var, Boolean patch) {
    return CompanyEvent.varJsonCompanyEvent(var, patch);
  }
  public static String varJsonCompanyEvent(String var, Boolean patch) {
    switch(var) {
    case VAR_name:
      return patch ? SET_name : VAR_name;
    case VAR_nameFrFR:
      return patch ? SET_nameFrFR : VAR_nameFrFR;
    case VAR_description:
      return patch ? SET_description : VAR_description;
    case VAR_descriptionFrFR:
      return patch ? SET_descriptionFrFR : VAR_descriptionFrFR;
    case VAR_startDateTime:
      return patch ? SET_startDateTime : VAR_startDateTime;
    case VAR_endDateTime:
      return patch ? SET_endDateTime : VAR_endDateTime;
    case VAR_price:
      return patch ? SET_price : VAR_price;
    case VAR_pageId:
      return patch ? SET_pageId : VAR_pageId;
    case VAR_emailTemplate:
      return patch ? SET_emailTemplate : VAR_emailTemplate;
    case VAR_storeUrl:
      return patch ? SET_storeUrl : VAR_storeUrl;
    case VAR_location:
      return patch ? SET_location : VAR_location;
    case VAR_locationColors:
      return patch ? SET_locationColors : VAR_locationColors;
    case VAR_locationTitles:
      return patch ? SET_locationTitles : VAR_locationTitles;
    case VAR_locationLinks:
      return patch ? SET_locationLinks : VAR_locationLinks;
    case VAR_dialogTemplate:
      return patch ? SET_dialogTemplate : VAR_dialogTemplate;
    case VAR_dialogTemplateFrFR:
      return patch ? SET_dialogTemplateFrFR : VAR_dialogTemplateFrFR;
    case VAR_pageImageUri:
      return patch ? SET_pageImageUri : VAR_pageImageUri;
    case VAR_pageImageWidth:
      return patch ? SET_pageImageWidth : VAR_pageImageWidth;
    case VAR_pageImageHeight:
      return patch ? SET_pageImageHeight : VAR_pageImageHeight;
    case VAR_pageImageType:
      return patch ? SET_pageImageType : VAR_pageImageType;
    case VAR_pageImageAlt:
      return patch ? SET_pageImageAlt : VAR_pageImageAlt;
    case VAR_labelsString:
      return patch ? SET_labelsString : VAR_labelsString;
    case VAR_labels:
      return patch ? SET_labels : VAR_labels;
    case VAR_authorName:
      return patch ? SET_authorName : VAR_authorName;
    case VAR_authorUrl:
      return patch ? SET_authorUrl : VAR_authorUrl;
    default:
      return BaseResult.varJsonBaseResult(var, patch);
    }
  }

  public static String displayNameForClass(String var) {
    return CompanyEvent.displayNameCompanyEvent(var);
  }
  public static String displayNameCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return DISPLAY_NAME_name;
    case VAR_nameFrFR:
      return DISPLAY_NAME_nameFrFR;
    case VAR_description:
      return DISPLAY_NAME_description;
    case VAR_descriptionFrFR:
      return DISPLAY_NAME_descriptionFrFR;
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
    case VAR_dialogTemplate:
      return DISPLAY_NAME_dialogTemplate;
    case VAR_dialogTemplateFrFR:
      return DISPLAY_NAME_dialogTemplateFrFR;
    case VAR_pageImageUri:
      return DISPLAY_NAME_pageImageUri;
    case VAR_pageImageWidth:
      return DISPLAY_NAME_pageImageWidth;
    case VAR_pageImageHeight:
      return DISPLAY_NAME_pageImageHeight;
    case VAR_pageImageType:
      return DISPLAY_NAME_pageImageType;
    case VAR_pageImageAlt:
      return DISPLAY_NAME_pageImageAlt;
    case VAR_labelsString:
      return DISPLAY_NAME_labelsString;
    case VAR_labels:
      return DISPLAY_NAME_labels;
    case VAR_authorName:
      return DISPLAY_NAME_authorName;
    case VAR_authorUrl:
      return DISPLAY_NAME_authorUrl;
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
    case VAR_dialogTemplate:
      return "The dialog template for this product. ";
    case VAR_dialogTemplateFrFR:
      return "The dialog template for this product. ";
    case VAR_pageImageUri:
      return "The page image URI";
    case VAR_pageImageWidth:
      return "The image width";
    case VAR_pageImageHeight:
      return "The image height";
    case VAR_pageImageType:
      return "The image type";
    case VAR_pageImageAlt:
      return "The image accessibility text. ";
    case VAR_labelsString:
      return "The labels String for this article comma-separated. ";
    case VAR_labels:
      return "The labels for this article. ";
    case VAR_authorName:
      return "The author name";
    case VAR_authorUrl:
      return "The author URL";
      default:
        return BaseResult.descriptionBaseResult(var);
    }
  }

  public static String classSimpleNameCompanyEvent(String var) {
    switch(var) {
    case VAR_name:
      return "String";
    case VAR_nameFrFR:
      return "String";
    case VAR_description:
      return "String";
    case VAR_descriptionFrFR:
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
    case VAR_dialogTemplate:
      return "String";
    case VAR_dialogTemplateFrFR:
      return "String";
    case VAR_pageImageUri:
      return "String";
    case VAR_pageImageWidth:
      return "Integer";
    case VAR_pageImageHeight:
      return "Integer";
    case VAR_pageImageType:
      return "String";
    case VAR_pageImageAlt:
      return "String";
    case VAR_labelsString:
      return "String";
    case VAR_labels:
      return "List";
    case VAR_authorName:
      return "String";
    case VAR_authorUrl:
      return "String";
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
    case VAR_pageImageUri:
      return 4;
    case VAR_authorName:
      return 3;
    case VAR_authorUrl:
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
    case VAR_pageImageUri:
      return 1;
    case VAR_authorName:
      return 3;
    case VAR_authorUrl:
      return 3;
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
