package org.computate.smartaquaculture.model.fiware.seaportfacility;

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
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class SeaportFacilityGen into the class SeaportFacility. 
 * </li>
 * <h3>About the SeaportFacility class and it's generated class SeaportFacilityGen&lt;MapModel&gt;: </h3>extends SeaportFacilityGen
 * <p>
 * This Java class extends a generated Java class SeaportFacilityGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility">Find the class SeaportFacility in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends SeaportFacilityGen<MapModel>
 * <p>This <code>class SeaportFacility extends SeaportFacilityGen&lt;MapModel&gt;</code>, which means it extends a newly generated SeaportFacilityGen. 
 * The generated <code>class SeaportFacilityGen extends MapModel</code> which means that SeaportFacility extends SeaportFacilityGen which extends MapModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: seaport facilities"</b>, which groups all of the OpenAPIs for SeaportFacility objects under the tag "seaport facilities". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/seaport-facilities</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/seaport-facilities"</b>, which defines the base API URI for SeaportFacility objects as "/en-us/api/seaport-facilities" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the SeaportFacility class will inherit the helpful inherited class comments from the super class SeaportFacilityGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the SeaportFacility API will return a default of 100 records instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>Order: 14</h2>
 * <p>This class contains a comment <b>"Order: 14"</b>, which means this class will be sorted by the given number 14 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 14</h2>
 * <p>This class contains a comment <b>"SqlOrder: 14"</b>, which means this class will be sorted by the given number 14 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <b>"Model: true"</b>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <b>"Page: true"</b>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacilityPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the SeaportFacility Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a seaport facility</h2>
 * <p>This class contains a comment <b>"AName.enUS: a seaport facility"</b>, which identifies the language context to describe a SeaportFacility as "a seaport facility". 
 * </p>
 * <p>
 * Delete the class SeaportFacility in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.seaportfacility in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class SeaportFacilityGen<DEV> extends MapModel {
  protected static final Logger LOG = LoggerFactory.getLogger(SeaportFacility.class);

  public static final String Description_frFR = "Le modèle de données vise à fournir des informations sur les ports pouvant accueillir des embarcations de plaisance, du commerce ou du transport de passagers. Il permet de représenter les paramètres de chaque port, son emplacement, ses capacités d'amarrage et les services gratuits ou payants qui y sont associés, fournis directement par le port ou par des professionnels travaillant sur ou près du port.";
  public static final String AName_frFR = "une installation portuaire";
  public static final String This_frFR = "cette ";
  public static final String ThisName_frFR = "cette installation portuaire";
  public static final String A_frFR = "une ";
  public static final String TheName_frFR = "l'installation portuaire";
  public static final String SingularName_frFR = "installation portuaire";
  public static final String PluralName_frFR = "installations portuaires";
  public static final String NameActual_frFR = "installation portuaire actuelle";
  public static final String AllName_frFR = "toutes installations portuaires";
  public static final String SearchAllNameBy_frFR = "rechercher installations portuaires par ";
  public static final String SearchAllName_frFR = "rechercher installations portuaires";
  public static final String Title_frFR = "installations portuaires";
  public static final String ThePluralName_frFR = "les installations portuaires";
  public static final String NoNameFound_frFR = "aucune installation portuaire trouvée";
  public static final String OfName_frFR = "d'installation portuaire";
  public static final String NameAdjectiveSingular_frFR = "installation portuaire";
  public static final String NameAdjectivePlural_frFR = "installations portuaires";
  public static final String SearchPageFrFR_frFR_OpenApiUri = "/fr-fr/rechercher/installations-portuaires";
  public static final String SearchPageFrFR_frFR_StringFormatUri = "/fr-fr/rechercher/installations-portuaires";
  public static final String SearchPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/rechercher/installations-portuaires";
  public static final String EditPageFrFR_frFR_OpenApiUri = "/fr-fr/edition/installations-portuaires/{entityShortId}";
  public static final String EditPageFrFR_frFR_StringFormatUri = "/fr-fr/edition/installations-portuaires/%s";
  public static final String EditPageFrFR_frFR_StringFormatUrl = "%s/fr-fr/edition/installations-portuaires/%s";

  public static final String Description_enUS = "The Data Model is intended to provide information about ports that can accommodate pleasure craft, commerce or passenger  transport. It permit to represent the parameters of each port, its location, its mooring capacities and the free or paid services associated with it provided directly by the port or by professionals working on or near the port.";
  public static final String AName_enUS = "a seaport facility";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this seaport facility";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "the seaport facility";
  public static final String SingularName_enUS = "seaport facility";
  public static final String PluralName_enUS = "seaport facilities";
  public static final String NameActual_enUS = "current seaport facility";
  public static final String AllName_enUS = "all seaport facilities";
  public static final String SearchAllNameBy_enUS = "search seaport facilities by ";
  public static final String SearchAllName_enUS = "search seaport facilities";
  public static final String Title_enUS = "seaport facilities";
  public static final String ThePluralName_enUS = "the seaport facilities";
  public static final String NoNameFound_enUS = "no seaport facility found";
  public static final String ApiUri_enUS = "/en-us/api/seaport-facilities";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/seaport-facilities";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/seaport-facilities/{entityShortId}";
  public static final String OfName_enUS = "of seaport facility";
  public static final String ANameAdjective_enUS = "a seaport facility";
  public static final String NameAdjectiveSingular_enUS = "seaport facility";
  public static final String NameAdjectivePlural_enUS = "seaport facilities";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/seaport-facilities";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/seaport-facilities";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/seaport-facilities/{entityShortId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/seaport-facilities/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/seaport-facilities";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/seaport-facilities";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/seaport-facilities";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/seaport-facilities";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/seaport-facilities/{entityShortId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/seaport-facilities/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/seaport-facilities-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/seaport-facilities-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/seaport-facilities";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/seaport-facilities";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/seaport-facilities";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/seaport-facilities/{entityShortId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/seaport-facilities/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/seaport-facilities/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/seaport-facilities";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/seaport-facilities";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/seaport-facilities";

  public static final String Icon = "<i class=\"fa-duotone fa-regular fa-ship\"></i>";
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
    this.address = SeaportFacility.staticSetAddress(siteRequest_, o);
  }
  public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility addressInit() {
    Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
    if(address == null) {
      _address(addressWrap);
      Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
        setAddress(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchAddress(siteRequest_, SeaportFacility.staticSetAddress(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _alternateName(Wrap<String> w);

  public String getAlternateName() {
    return alternateName;
  }
  public void setAlternateName(String o) {
    this.alternateName = SeaportFacility.staticSetAlternateName(siteRequest_, o);
  }
  public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility alternateNameInit() {
    Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
    if(alternateName == null) {
      _alternateName(alternateNameWrap);
      Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
        setAlternateName(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchAlternateName(siteRequest_, SeaportFacility.staticSetAlternateName(siteRequest_, o)).toString();
  }

  public String sqlAlternateName() {
    return alternateName;
  }

  public static String staticJsonAlternateName(String alternateName) {
    return alternateName;
  }

	//////////////////////////
  // authorizedPropulsion //
	//////////////////////////


  /**
   *  The entity authorizedPropulsion
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject authorizedPropulsion;

  /**
   * <br> The entity authorizedPropulsion
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:authorizedPropulsion">Find the entity authorizedPropulsion in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _authorizedPropulsion(Wrap<JsonObject> w);

  public JsonObject getAuthorizedPropulsion() {
    return authorizedPropulsion;
  }

  public void setAuthorizedPropulsion(JsonObject authorizedPropulsion) {
    this.authorizedPropulsion = authorizedPropulsion;
  }
  @JsonIgnore
  public void setAuthorizedPropulsion(String o) {
    this.authorizedPropulsion = SeaportFacility.staticSetAuthorizedPropulsion(siteRequest_, o);
  }
  public static JsonObject staticSetAuthorizedPropulsion(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility authorizedPropulsionInit() {
    Wrap<JsonObject> authorizedPropulsionWrap = new Wrap<JsonObject>().var("authorizedPropulsion");
    if(authorizedPropulsion == null) {
      _authorizedPropulsion(authorizedPropulsionWrap);
      Optional.ofNullable(authorizedPropulsionWrap.getO()).ifPresent(o -> {
        setAuthorizedPropulsion(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchAuthorizedPropulsion(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrAuthorizedPropulsion(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAuthorizedPropulsion(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchAuthorizedPropulsion(siteRequest_, SeaportFacility.staticSetAuthorizedPropulsion(siteRequest_, o)).toString();
  }

  public JsonObject sqlAuthorizedPropulsion() {
    return authorizedPropulsion;
  }

  public static JsonObject staticJsonAuthorizedPropulsion(JsonObject authorizedPropulsion) {
    return authorizedPropulsion;
  }

	///////////////////////////
  // boatSupplyingServices //
	///////////////////////////


  /**
   *  The entity boatSupplyingServices
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject boatSupplyingServices;

  /**
   * <br> The entity boatSupplyingServices
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:boatSupplyingServices">Find the entity boatSupplyingServices in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _boatSupplyingServices(Wrap<JsonObject> w);

  public JsonObject getBoatSupplyingServices() {
    return boatSupplyingServices;
  }

  public void setBoatSupplyingServices(JsonObject boatSupplyingServices) {
    this.boatSupplyingServices = boatSupplyingServices;
  }
  @JsonIgnore
  public void setBoatSupplyingServices(String o) {
    this.boatSupplyingServices = SeaportFacility.staticSetBoatSupplyingServices(siteRequest_, o);
  }
  public static JsonObject staticSetBoatSupplyingServices(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility boatSupplyingServicesInit() {
    Wrap<JsonObject> boatSupplyingServicesWrap = new Wrap<JsonObject>().var("boatSupplyingServices");
    if(boatSupplyingServices == null) {
      _boatSupplyingServices(boatSupplyingServicesWrap);
      Optional.ofNullable(boatSupplyingServicesWrap.getO()).ifPresent(o -> {
        setBoatSupplyingServices(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchBoatSupplyingServices(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrBoatSupplyingServices(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqBoatSupplyingServices(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchBoatSupplyingServices(siteRequest_, SeaportFacility.staticSetBoatSupplyingServices(siteRequest_, o)).toString();
  }

  public JsonObject sqlBoatSupplyingServices() {
    return boatSupplyingServices;
  }

  public static JsonObject staticJsonBoatSupplyingServices(JsonObject boatSupplyingServices) {
    return boatSupplyingServices;
  }

	//////////////////
  // contactPoint //
	//////////////////


  /**
   *  The entity contactPoint
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject contactPoint;

  /**
   * <br> The entity contactPoint
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:contactPoint">Find the entity contactPoint in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contactPoint(Wrap<JsonObject> w);

  public JsonObject getContactPoint() {
    return contactPoint;
  }

  public void setContactPoint(JsonObject contactPoint) {
    this.contactPoint = contactPoint;
  }
  @JsonIgnore
  public void setContactPoint(String o) {
    this.contactPoint = SeaportFacility.staticSetContactPoint(siteRequest_, o);
  }
  public static JsonObject staticSetContactPoint(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility contactPointInit() {
    Wrap<JsonObject> contactPointWrap = new Wrap<JsonObject>().var("contactPoint");
    if(contactPoint == null) {
      _contactPoint(contactPointWrap);
      Optional.ofNullable(contactPointWrap.getO()).ifPresent(o -> {
        setContactPoint(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchContactPoint(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrContactPoint(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContactPoint(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchContactPoint(siteRequest_, SeaportFacility.staticSetContactPoint(siteRequest_, o)).toString();
  }

  public JsonObject sqlContactPoint() {
    return contactPoint;
  }

  public static JsonObject staticJsonContactPoint(JsonObject contactPoint) {
    return contactPoint;
  }

	//////////////////////////
  // contractingAuthority //
	//////////////////////////


  /**
   *  The entity contractingAuthority
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contractingAuthority;

  /**
   * <br> The entity contractingAuthority
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:contractingAuthority">Find the entity contractingAuthority in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contractingAuthority(Wrap<String> w);

  public String getContractingAuthority() {
    return contractingAuthority;
  }
  public void setContractingAuthority(String o) {
    this.contractingAuthority = SeaportFacility.staticSetContractingAuthority(siteRequest_, o);
  }
  public static String staticSetContractingAuthority(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility contractingAuthorityInit() {
    Wrap<String> contractingAuthorityWrap = new Wrap<String>().var("contractingAuthority");
    if(contractingAuthority == null) {
      _contractingAuthority(contractingAuthorityWrap);
      Optional.ofNullable(contractingAuthorityWrap.getO()).ifPresent(o -> {
        setContractingAuthority(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchContractingAuthority(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContractingAuthority(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContractingAuthority(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchContractingAuthority(siteRequest_, SeaportFacility.staticSetContractingAuthority(siteRequest_, o)).toString();
  }

  public String sqlContractingAuthority() {
    return contractingAuthority;
  }

  public static String staticJsonContractingAuthority(String contractingAuthority) {
    return contractingAuthority;
  }

	////////////////////////
  // contractingCompany //
	////////////////////////


  /**
   *  The entity contractingCompany
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contractingCompany;

  /**
   * <br> The entity contractingCompany
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:contractingCompany">Find the entity contractingCompany in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contractingCompany(Wrap<String> w);

  public String getContractingCompany() {
    return contractingCompany;
  }
  public void setContractingCompany(String o) {
    this.contractingCompany = SeaportFacility.staticSetContractingCompany(siteRequest_, o);
  }
  public static String staticSetContractingCompany(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility contractingCompanyInit() {
    Wrap<String> contractingCompanyWrap = new Wrap<String>().var("contractingCompany");
    if(contractingCompany == null) {
      _contractingCompany(contractingCompanyWrap);
      Optional.ofNullable(contractingCompanyWrap.getO()).ifPresent(o -> {
        setContractingCompany(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchContractingCompany(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContractingCompany(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContractingCompany(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchContractingCompany(siteRequest_, SeaportFacility.staticSetContractingCompany(siteRequest_, o)).toString();
  }

  public String sqlContractingCompany() {
    return contractingCompany;
  }

  public static String staticJsonContractingCompany(String contractingCompany) {
    return contractingCompany;
  }

	//////////////////////
  // currencyAccepted //
	//////////////////////


  /**
   *  The entity currencyAccepted
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject currencyAccepted;

  /**
   * <br> The entity currencyAccepted
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:currencyAccepted">Find the entity currencyAccepted in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _currencyAccepted(Wrap<JsonObject> w);

  public JsonObject getCurrencyAccepted() {
    return currencyAccepted;
  }

  public void setCurrencyAccepted(JsonObject currencyAccepted) {
    this.currencyAccepted = currencyAccepted;
  }
  @JsonIgnore
  public void setCurrencyAccepted(String o) {
    this.currencyAccepted = SeaportFacility.staticSetCurrencyAccepted(siteRequest_, o);
  }
  public static JsonObject staticSetCurrencyAccepted(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility currencyAcceptedInit() {
    Wrap<JsonObject> currencyAcceptedWrap = new Wrap<JsonObject>().var("currencyAccepted");
    if(currencyAccepted == null) {
      _currencyAccepted(currencyAcceptedWrap);
      Optional.ofNullable(currencyAcceptedWrap.getO()).ifPresent(o -> {
        setCurrencyAccepted(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchCurrencyAccepted(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrCurrencyAccepted(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCurrencyAccepted(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchCurrencyAccepted(siteRequest_, SeaportFacility.staticSetCurrencyAccepted(siteRequest_, o)).toString();
  }

  public JsonObject sqlCurrencyAccepted() {
    return currencyAccepted;
  }

  public static JsonObject staticJsonCurrencyAccepted(JsonObject currencyAccepted) {
    return currencyAccepted;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dataProvider(Wrap<String> w);

  public String getDataProvider() {
    return dataProvider;
  }
  public void setDataProvider(String o) {
    this.dataProvider = SeaportFacility.staticSetDataProvider(siteRequest_, o);
  }
  public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility dataProviderInit() {
    Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
    if(dataProvider == null) {
      _dataProvider(dataProviderWrap);
      Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
        setDataProvider(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchDataProvider(siteRequest_, SeaportFacility.staticSetDataProvider(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateCreated(Wrap<String> w);

  public String getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(String o) {
    this.dateCreated = SeaportFacility.staticSetDateCreated(siteRequest_, o);
  }
  public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility dateCreatedInit() {
    Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
    if(dateCreated == null) {
      _dateCreated(dateCreatedWrap);
      Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
        setDateCreated(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchDateCreated(siteRequest_, SeaportFacility.staticSetDateCreated(siteRequest_, o)).toString();
  }

  public String sqlDateCreated() {
    return dateCreated;
  }

  public static String staticJsonDateCreated(String dateCreated) {
    return dateCreated;
  }

	//////////////////////
  // dateLastReported //
	//////////////////////


  /**
   *  The entity dateLastReported
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateLastReported;

  /**
   * <br> The entity dateLastReported
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:dateLastReported">Find the entity dateLastReported in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateLastReported(Wrap<String> w);

  public String getDateLastReported() {
    return dateLastReported;
  }
  public void setDateLastReported(String o) {
    this.dateLastReported = SeaportFacility.staticSetDateLastReported(siteRequest_, o);
  }
  public static String staticSetDateLastReported(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility dateLastReportedInit() {
    Wrap<String> dateLastReportedWrap = new Wrap<String>().var("dateLastReported");
    if(dateLastReported == null) {
      _dateLastReported(dateLastReportedWrap);
      Optional.ofNullable(dateLastReportedWrap.getO()).ifPresent(o -> {
        setDateLastReported(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchDateLastReported(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateLastReported(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateLastReported(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchDateLastReported(siteRequest_, SeaportFacility.staticSetDateLastReported(siteRequest_, o)).toString();
  }

  public String sqlDateLastReported() {
    return dateLastReported;
  }

  public static String staticJsonDateLastReported(String dateLastReported) {
    return dateLastReported;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateModified(Wrap<String> w);

  public String getDateModified() {
    return dateModified;
  }
  public void setDateModified(String o) {
    this.dateModified = SeaportFacility.staticSetDateModified(siteRequest_, o);
  }
  public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility dateModifiedInit() {
    Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
    if(dateModified == null) {
      _dateModified(dateModifiedWrap);
      Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
        setDateModified(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchDateModified(siteRequest_, SeaportFacility.staticSetDateModified(siteRequest_, o)).toString();
  }

  public String sqlDateModified() {
    return dateModified;
  }

  public static String staticJsonDateModified(String dateModified) {
    return dateModified;
  }

	///////////////////////
  // electricTransport //
	///////////////////////


  /**
   *  The entity electricTransport
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject electricTransport;

  /**
   * <br> The entity electricTransport
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:electricTransport">Find the entity electricTransport in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _electricTransport(Wrap<JsonObject> w);

  public JsonObject getElectricTransport() {
    return electricTransport;
  }

  public void setElectricTransport(JsonObject electricTransport) {
    this.electricTransport = electricTransport;
  }
  @JsonIgnore
  public void setElectricTransport(String o) {
    this.electricTransport = SeaportFacility.staticSetElectricTransport(siteRequest_, o);
  }
  public static JsonObject staticSetElectricTransport(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility electricTransportInit() {
    Wrap<JsonObject> electricTransportWrap = new Wrap<JsonObject>().var("electricTransport");
    if(electricTransport == null) {
      _electricTransport(electricTransportWrap);
      Optional.ofNullable(electricTransportWrap.getO()).ifPresent(o -> {
        setElectricTransport(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchElectricTransport(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrElectricTransport(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqElectricTransport(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchElectricTransport(siteRequest_, SeaportFacility.staticSetElectricTransport(siteRequest_, o)).toString();
  }

  public JsonObject sqlElectricTransport() {
    return electricTransport;
  }

  public static JsonObject staticJsonElectricTransport(JsonObject electricTransport) {
    return electricTransport;
  }

	/////////////
  // endDate //
	/////////////


  /**
   *  The entity endDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String endDate;

  /**
   * <br> The entity endDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:endDate">Find the entity endDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _endDate(Wrap<String> w);

  public String getEndDate() {
    return endDate;
  }
  public void setEndDate(String o) {
    this.endDate = SeaportFacility.staticSetEndDate(siteRequest_, o);
  }
  public static String staticSetEndDate(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility endDateInit() {
    Wrap<String> endDateWrap = new Wrap<String>().var("endDate");
    if(endDate == null) {
      _endDate(endDateWrap);
      Optional.ofNullable(endDateWrap.getO()).ifPresent(o -> {
        setEndDate(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchEndDate(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrEndDate(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEndDate(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchEndDate(siteRequest_, SeaportFacility.staticSetEndDate(siteRequest_, o)).toString();
  }

  public String sqlEndDate() {
    return endDate;
  }

  public static String staticJsonEndDate(String endDate) {
    return endDate;
  }

	////////////////
  // facilities //
	////////////////


  /**
   *  The entity facilities
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject facilities;

  /**
   * <br> The entity facilities
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:facilities">Find the entity facilities in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _facilities(Wrap<JsonObject> w);

  public JsonObject getFacilities() {
    return facilities;
  }

  public void setFacilities(JsonObject facilities) {
    this.facilities = facilities;
  }
  @JsonIgnore
  public void setFacilities(String o) {
    this.facilities = SeaportFacility.staticSetFacilities(siteRequest_, o);
  }
  public static JsonObject staticSetFacilities(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility facilitiesInit() {
    Wrap<JsonObject> facilitiesWrap = new Wrap<JsonObject>().var("facilities");
    if(facilities == null) {
      _facilities(facilitiesWrap);
      Optional.ofNullable(facilitiesWrap.getO()).ifPresent(o -> {
        setFacilities(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchFacilities(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrFacilities(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqFacilities(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchFacilities(siteRequest_, SeaportFacility.staticSetFacilities(siteRequest_, o)).toString();
  }

  public JsonObject sqlFacilities() {
    return facilities;
  }

  public static JsonObject staticJsonFacilities(JsonObject facilities) {
    return facilities;
  }

	//////////////
  // maxDraft //
	//////////////


  /**
   *  The entity maxDraft
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maxDraft;

  /**
   * <br> The entity maxDraft
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:maxDraft">Find the entity maxDraft in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maxDraft(Wrap<BigDecimal> w);

  public BigDecimal getMaxDraft() {
    return maxDraft;
  }

  public void setMaxDraft(BigDecimal maxDraft) {
    this.maxDraft = maxDraft;
  }
  @JsonIgnore
  public void setMaxDraft(String o) {
    this.maxDraft = SeaportFacility.staticSetMaxDraft(siteRequest_, o);
  }
  public static MathContext staticMathContextMaxDraft() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaxDraft(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaxDraft());
    return null;
  }
  @JsonIgnore
  public void setMaxDraft(Double o) {
    setMaxDraft(new BigDecimal(o, staticMathContextMaxDraft()));
  }
  @JsonIgnore
  public void setMaxDraft(Integer o) {
    setMaxDraft(new BigDecimal(o, staticMathContextMaxDraft()));
  }
  @JsonIgnore
  public void setMaxDraft(Number o) {
    setMaxDraft(new BigDecimal(o.doubleValue(), staticMathContextMaxDraft()));
  }
  protected SeaportFacility maxDraftInit() {
    Wrap<BigDecimal> maxDraftWrap = new Wrap<BigDecimal>().var("maxDraft");
    if(maxDraft == null) {
      _maxDraft(maxDraftWrap);
      Optional.ofNullable(maxDraftWrap.getO()).ifPresent(o -> {
        setMaxDraft(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchMaxDraft(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaxDraft(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaxDraft(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchMaxDraft(siteRequest_, SeaportFacility.staticSetMaxDraft(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaxDraft() {
    return maxDraft;
  }

  public static String staticJsonMaxDraft(BigDecimal maxDraft) {
    return Optional.ofNullable(maxDraft).map(v -> v.toString()).orElse(null);
  }

	///////////////
  // maxLength //
	///////////////


  /**
   *  The entity maxLength
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maxLength;

  /**
   * <br> The entity maxLength
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:maxLength">Find the entity maxLength in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maxLength(Wrap<BigDecimal> w);

  public BigDecimal getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(BigDecimal maxLength) {
    this.maxLength = maxLength;
  }
  @JsonIgnore
  public void setMaxLength(String o) {
    this.maxLength = SeaportFacility.staticSetMaxLength(siteRequest_, o);
  }
  public static MathContext staticMathContextMaxLength() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaxLength(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaxLength());
    return null;
  }
  @JsonIgnore
  public void setMaxLength(Double o) {
    setMaxLength(new BigDecimal(o, staticMathContextMaxLength()));
  }
  @JsonIgnore
  public void setMaxLength(Integer o) {
    setMaxLength(new BigDecimal(o, staticMathContextMaxLength()));
  }
  @JsonIgnore
  public void setMaxLength(Number o) {
    setMaxLength(new BigDecimal(o.doubleValue(), staticMathContextMaxLength()));
  }
  protected SeaportFacility maxLengthInit() {
    Wrap<BigDecimal> maxLengthWrap = new Wrap<BigDecimal>().var("maxLength");
    if(maxLength == null) {
      _maxLength(maxLengthWrap);
      Optional.ofNullable(maxLengthWrap.getO()).ifPresent(o -> {
        setMaxLength(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchMaxLength(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaxLength(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaxLength(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchMaxLength(siteRequest_, SeaportFacility.staticSetMaxLength(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaxLength() {
    return maxLength;
  }

  public static String staticJsonMaxLength(BigDecimal maxLength) {
    return Optional.ofNullable(maxLength).map(v -> v.toString()).orElse(null);
  }

	////////////////
  // maxTonnage //
	////////////////


  /**
   *  The entity maxTonnage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maxTonnage;

  /**
   * <br> The entity maxTonnage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:maxTonnage">Find the entity maxTonnage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maxTonnage(Wrap<BigDecimal> w);

  public BigDecimal getMaxTonnage() {
    return maxTonnage;
  }

  public void setMaxTonnage(BigDecimal maxTonnage) {
    this.maxTonnage = maxTonnage;
  }
  @JsonIgnore
  public void setMaxTonnage(String o) {
    this.maxTonnage = SeaportFacility.staticSetMaxTonnage(siteRequest_, o);
  }
  public static MathContext staticMathContextMaxTonnage() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaxTonnage(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaxTonnage());
    return null;
  }
  @JsonIgnore
  public void setMaxTonnage(Double o) {
    setMaxTonnage(new BigDecimal(o, staticMathContextMaxTonnage()));
  }
  @JsonIgnore
  public void setMaxTonnage(Integer o) {
    setMaxTonnage(new BigDecimal(o, staticMathContextMaxTonnage()));
  }
  @JsonIgnore
  public void setMaxTonnage(Number o) {
    setMaxTonnage(new BigDecimal(o.doubleValue(), staticMathContextMaxTonnage()));
  }
  protected SeaportFacility maxTonnageInit() {
    Wrap<BigDecimal> maxTonnageWrap = new Wrap<BigDecimal>().var("maxTonnage");
    if(maxTonnage == null) {
      _maxTonnage(maxTonnageWrap);
      Optional.ofNullable(maxTonnageWrap.getO()).ifPresent(o -> {
        setMaxTonnage(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchMaxTonnage(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaxTonnage(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaxTonnage(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchMaxTonnage(siteRequest_, SeaportFacility.staticSetMaxTonnage(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaxTonnage() {
    return maxTonnage;
  }

  public static String staticJsonMaxTonnage(BigDecimal maxTonnage) {
    return Optional.ofNullable(maxTonnage).map(v -> v.toString()).orElse(null);
  }

	//////////////
  // maxWidth //
	//////////////


  /**
   *  The entity maxWidth
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal maxWidth;

  /**
   * <br> The entity maxWidth
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:maxWidth">Find the entity maxWidth in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _maxWidth(Wrap<BigDecimal> w);

  public BigDecimal getMaxWidth() {
    return maxWidth;
  }

  public void setMaxWidth(BigDecimal maxWidth) {
    this.maxWidth = maxWidth;
  }
  @JsonIgnore
  public void setMaxWidth(String o) {
    this.maxWidth = SeaportFacility.staticSetMaxWidth(siteRequest_, o);
  }
  public static MathContext staticMathContextMaxWidth() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMaxWidth(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMaxWidth());
    return null;
  }
  @JsonIgnore
  public void setMaxWidth(Double o) {
    setMaxWidth(new BigDecimal(o, staticMathContextMaxWidth()));
  }
  @JsonIgnore
  public void setMaxWidth(Integer o) {
    setMaxWidth(new BigDecimal(o, staticMathContextMaxWidth()));
  }
  @JsonIgnore
  public void setMaxWidth(Number o) {
    setMaxWidth(new BigDecimal(o.doubleValue(), staticMathContextMaxWidth()));
  }
  protected SeaportFacility maxWidthInit() {
    Wrap<BigDecimal> maxWidthWrap = new Wrap<BigDecimal>().var("maxWidth");
    if(maxWidth == null) {
      _maxWidth(maxWidthWrap);
      Optional.ofNullable(maxWidthWrap.getO()).ifPresent(o -> {
        setMaxWidth(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchMaxWidth(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMaxWidth(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMaxWidth(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchMaxWidth(siteRequest_, SeaportFacility.staticSetMaxWidth(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMaxWidth() {
    return maxWidth;
  }

  public static String staticJsonMaxWidth(BigDecimal maxWidth) {
    return Optional.ofNullable(maxWidth).map(v -> v.toString()).orElse(null);
  }

	///////////////
  // minLength //
	///////////////


  /**
   *  The entity minLength
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal minLength;

  /**
   * <br> The entity minLength
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:minLength">Find the entity minLength in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _minLength(Wrap<BigDecimal> w);

  public BigDecimal getMinLength() {
    return minLength;
  }

  public void setMinLength(BigDecimal minLength) {
    this.minLength = minLength;
  }
  @JsonIgnore
  public void setMinLength(String o) {
    this.minLength = SeaportFacility.staticSetMinLength(siteRequest_, o);
  }
  public static MathContext staticMathContextMinLength() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetMinLength(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextMinLength());
    return null;
  }
  @JsonIgnore
  public void setMinLength(Double o) {
    setMinLength(new BigDecimal(o, staticMathContextMinLength()));
  }
  @JsonIgnore
  public void setMinLength(Integer o) {
    setMinLength(new BigDecimal(o, staticMathContextMinLength()));
  }
  @JsonIgnore
  public void setMinLength(Number o) {
    setMinLength(new BigDecimal(o.doubleValue(), staticMathContextMinLength()));
  }
  protected SeaportFacility minLengthInit() {
    Wrap<BigDecimal> minLengthWrap = new Wrap<BigDecimal>().var("minLength");
    if(minLength == null) {
      _minLength(minLengthWrap);
      Optional.ofNullable(minLengthWrap.getO()).ifPresent(o -> {
        setMinLength(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchMinLength(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrMinLength(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqMinLength(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchMinLength(siteRequest_, SeaportFacility.staticSetMinLength(siteRequest_, o)).toString();
  }

  public BigDecimal sqlMinLength() {
    return minLength;
  }

  public static String staticJsonMinLength(BigDecimal minLength) {
    return Optional.ofNullable(minLength).map(v -> v.toString()).orElse(null);
  }

	////////////////////
  // nearbyServices //
	////////////////////


  /**
   *  The entity nearbyServices
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject nearbyServices;

  /**
   * <br> The entity nearbyServices
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:nearbyServices">Find the entity nearbyServices in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _nearbyServices(Wrap<JsonObject> w);

  public JsonObject getNearbyServices() {
    return nearbyServices;
  }

  public void setNearbyServices(JsonObject nearbyServices) {
    this.nearbyServices = nearbyServices;
  }
  @JsonIgnore
  public void setNearbyServices(String o) {
    this.nearbyServices = SeaportFacility.staticSetNearbyServices(siteRequest_, o);
  }
  public static JsonObject staticSetNearbyServices(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility nearbyServicesInit() {
    Wrap<JsonObject> nearbyServicesWrap = new Wrap<JsonObject>().var("nearbyServices");
    if(nearbyServices == null) {
      _nearbyServices(nearbyServicesWrap);
      Optional.ofNullable(nearbyServicesWrap.getO()).ifPresent(o -> {
        setNearbyServices(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchNearbyServices(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrNearbyServices(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNearbyServices(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchNearbyServices(siteRequest_, SeaportFacility.staticSetNearbyServices(siteRequest_, o)).toString();
  }

  public JsonObject sqlNearbyServices() {
    return nearbyServices;
  }

  public static JsonObject staticJsonNearbyServices(JsonObject nearbyServices) {
    return nearbyServices;
  }

	///////////////////
  // numberOfPlace //
	///////////////////


  /**
   *  The entity numberOfPlace
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal numberOfPlace;

  /**
   * <br> The entity numberOfPlace
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:numberOfPlace">Find the entity numberOfPlace in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _numberOfPlace(Wrap<BigDecimal> w);

  public BigDecimal getNumberOfPlace() {
    return numberOfPlace;
  }

  public void setNumberOfPlace(BigDecimal numberOfPlace) {
    this.numberOfPlace = numberOfPlace;
  }
  @JsonIgnore
  public void setNumberOfPlace(String o) {
    this.numberOfPlace = SeaportFacility.staticSetNumberOfPlace(siteRequest_, o);
  }
  public static MathContext staticMathContextNumberOfPlace() {
    return new MathContext(2, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetNumberOfPlace(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextNumberOfPlace());
    return null;
  }
  @JsonIgnore
  public void setNumberOfPlace(Double o) {
    setNumberOfPlace(new BigDecimal(o, staticMathContextNumberOfPlace()));
  }
  @JsonIgnore
  public void setNumberOfPlace(Integer o) {
    setNumberOfPlace(new BigDecimal(o, staticMathContextNumberOfPlace()));
  }
  @JsonIgnore
  public void setNumberOfPlace(Number o) {
    setNumberOfPlace(new BigDecimal(o.doubleValue(), staticMathContextNumberOfPlace()));
  }
  protected SeaportFacility numberOfPlaceInit() {
    Wrap<BigDecimal> numberOfPlaceWrap = new Wrap<BigDecimal>().var("numberOfPlace");
    if(numberOfPlace == null) {
      _numberOfPlace(numberOfPlaceWrap);
      Optional.ofNullable(numberOfPlaceWrap.getO()).ifPresent(o -> {
        setNumberOfPlace(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static Double staticSearchNumberOfPlace(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrNumberOfPlace(SiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNumberOfPlace(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchNumberOfPlace(siteRequest_, SeaportFacility.staticSetNumberOfPlace(siteRequest_, o)).toString();
  }

  public BigDecimal sqlNumberOfPlace() {
    return numberOfPlace;
  }

  public static String staticJsonNumberOfPlace(BigDecimal numberOfPlace) {
    return Optional.ofNullable(numberOfPlace).map(v -> v.toString()).orElse(null);
  }

	//////////////////
  // openingHours //
	//////////////////


  /**
   *  The entity openingHours
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String openingHours;

  /**
   * <br> The entity openingHours
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:openingHours">Find the entity openingHours in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openingHours(Wrap<String> w);

  public String getOpeningHours() {
    return openingHours;
  }
  public void setOpeningHours(String o) {
    this.openingHours = SeaportFacility.staticSetOpeningHours(siteRequest_, o);
  }
  public static String staticSetOpeningHours(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility openingHoursInit() {
    Wrap<String> openingHoursWrap = new Wrap<String>().var("openingHours");
    if(openingHours == null) {
      _openingHours(openingHoursWrap);
      Optional.ofNullable(openingHoursWrap.getO()).ifPresent(o -> {
        setOpeningHours(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchOpeningHours(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrOpeningHours(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpeningHours(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchOpeningHours(siteRequest_, SeaportFacility.staticSetOpeningHours(siteRequest_, o)).toString();
  }

  public String sqlOpeningHours() {
    return openingHours;
  }

  public static String staticJsonOpeningHours(String openingHours) {
    return openingHours;
  }

	///////////////////////////////
  // openingHoursSpecification //
	///////////////////////////////


  /**
   *  The entity openingHoursSpecification
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject openingHoursSpecification;

  /**
   * <br> The entity openingHoursSpecification
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:openingHoursSpecification">Find the entity openingHoursSpecification in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openingHoursSpecification(Wrap<JsonObject> w);

  public JsonObject getOpeningHoursSpecification() {
    return openingHoursSpecification;
  }

  public void setOpeningHoursSpecification(JsonObject openingHoursSpecification) {
    this.openingHoursSpecification = openingHoursSpecification;
  }
  @JsonIgnore
  public void setOpeningHoursSpecification(String o) {
    this.openingHoursSpecification = SeaportFacility.staticSetOpeningHoursSpecification(siteRequest_, o);
  }
  public static JsonObject staticSetOpeningHoursSpecification(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility openingHoursSpecificationInit() {
    Wrap<JsonObject> openingHoursSpecificationWrap = new Wrap<JsonObject>().var("openingHoursSpecification");
    if(openingHoursSpecification == null) {
      _openingHoursSpecification(openingHoursSpecificationWrap);
      Optional.ofNullable(openingHoursSpecificationWrap.getO()).ifPresent(o -> {
        setOpeningHoursSpecification(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchOpeningHoursSpecification(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOpeningHoursSpecification(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpeningHoursSpecification(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchOpeningHoursSpecification(siteRequest_, SeaportFacility.staticSetOpeningHoursSpecification(siteRequest_, o)).toString();
  }

  public JsonObject sqlOpeningHoursSpecification() {
    return openingHoursSpecification;
  }

  public static JsonObject staticJsonOpeningHoursSpecification(JsonObject openingHoursSpecification) {
    return openingHoursSpecification;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
    this.owner = SeaportFacility.staticSetOwner(siteRequest_, o);
  }
  public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility ownerInit() {
    Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
    if(owner == null) {
      _owner(ownerWrap);
      Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
        setOwner(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchOwner(siteRequest_, SeaportFacility.staticSetOwner(siteRequest_, o)).toString();
  }

  public JsonObject sqlOwner() {
    return owner;
  }

  public static JsonObject staticJsonOwner(JsonObject owner) {
    return owner;
  }

	/////////////////////
  // paymentAccepted //
	/////////////////////


  /**
   *  The entity paymentAccepted
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject paymentAccepted;

  /**
   * <br> The entity paymentAccepted
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:paymentAccepted">Find the entity paymentAccepted in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _paymentAccepted(Wrap<JsonObject> w);

  public JsonObject getPaymentAccepted() {
    return paymentAccepted;
  }

  public void setPaymentAccepted(JsonObject paymentAccepted) {
    this.paymentAccepted = paymentAccepted;
  }
  @JsonIgnore
  public void setPaymentAccepted(String o) {
    this.paymentAccepted = SeaportFacility.staticSetPaymentAccepted(siteRequest_, o);
  }
  public static JsonObject staticSetPaymentAccepted(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility paymentAcceptedInit() {
    Wrap<JsonObject> paymentAcceptedWrap = new Wrap<JsonObject>().var("paymentAccepted");
    if(paymentAccepted == null) {
      _paymentAccepted(paymentAcceptedWrap);
      Optional.ofNullable(paymentAcceptedWrap.getO()).ifPresent(o -> {
        setPaymentAccepted(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchPaymentAccepted(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrPaymentAccepted(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPaymentAccepted(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchPaymentAccepted(siteRequest_, SeaportFacility.staticSetPaymentAccepted(siteRequest_, o)).toString();
  }

  public JsonObject sqlPaymentAccepted() {
    return paymentAccepted;
  }

  public static JsonObject staticJsonPaymentAccepted(JsonObject paymentAccepted) {
    return paymentAccepted;
  }

	//////////////////////////
  // portServicesProvided //
	//////////////////////////


  /**
   *  The entity portServicesProvided
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject portServicesProvided;

  /**
   * <br> The entity portServicesProvided
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:portServicesProvided">Find the entity portServicesProvided in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _portServicesProvided(Wrap<JsonObject> w);

  public JsonObject getPortServicesProvided() {
    return portServicesProvided;
  }

  public void setPortServicesProvided(JsonObject portServicesProvided) {
    this.portServicesProvided = portServicesProvided;
  }
  @JsonIgnore
  public void setPortServicesProvided(String o) {
    this.portServicesProvided = SeaportFacility.staticSetPortServicesProvided(siteRequest_, o);
  }
  public static JsonObject staticSetPortServicesProvided(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility portServicesProvidedInit() {
    Wrap<JsonObject> portServicesProvidedWrap = new Wrap<JsonObject>().var("portServicesProvided");
    if(portServicesProvided == null) {
      _portServicesProvided(portServicesProvidedWrap);
      Optional.ofNullable(portServicesProvidedWrap.getO()).ifPresent(o -> {
        setPortServicesProvided(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchPortServicesProvided(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrPortServicesProvided(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPortServicesProvided(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchPortServicesProvided(siteRequest_, SeaportFacility.staticSetPortServicesProvided(siteRequest_, o)).toString();
  }

  public JsonObject sqlPortServicesProvided() {
    return portServicesProvided;
  }

  public static JsonObject staticJsonPortServicesProvided(JsonObject portServicesProvided) {
    return portServicesProvided;
  }

	///////////////////////
  // refBoatAuthorized //
	///////////////////////


  /**
   *  The entity refBoatAuthorized
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject refBoatAuthorized;

  /**
   * <br> The entity refBoatAuthorized
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:refBoatAuthorized">Find the entity refBoatAuthorized in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _refBoatAuthorized(Wrap<JsonObject> w);

  public JsonObject getRefBoatAuthorized() {
    return refBoatAuthorized;
  }

  public void setRefBoatAuthorized(JsonObject refBoatAuthorized) {
    this.refBoatAuthorized = refBoatAuthorized;
  }
  @JsonIgnore
  public void setRefBoatAuthorized(String o) {
    this.refBoatAuthorized = SeaportFacility.staticSetRefBoatAuthorized(siteRequest_, o);
  }
  public static JsonObject staticSetRefBoatAuthorized(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility refBoatAuthorizedInit() {
    Wrap<JsonObject> refBoatAuthorizedWrap = new Wrap<JsonObject>().var("refBoatAuthorized");
    if(refBoatAuthorized == null) {
      _refBoatAuthorized(refBoatAuthorizedWrap);
      Optional.ofNullable(refBoatAuthorizedWrap.getO()).ifPresent(o -> {
        setRefBoatAuthorized(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRefBoatAuthorized(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrRefBoatAuthorized(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRefBoatAuthorized(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRefBoatAuthorized(siteRequest_, SeaportFacility.staticSetRefBoatAuthorized(siteRequest_, o)).toString();
  }

  public JsonObject sqlRefBoatAuthorized() {
    return refBoatAuthorized;
  }

  public static JsonObject staticJsonRefBoatAuthorized(JsonObject refBoatAuthorized) {
    return refBoatAuthorized;
  }

	///////////////////////////
  // refBoatPlaceAvailable //
	///////////////////////////


  /**
   *  The entity refBoatPlaceAvailable
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject refBoatPlaceAvailable;

  /**
   * <br> The entity refBoatPlaceAvailable
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:refBoatPlaceAvailable">Find the entity refBoatPlaceAvailable in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _refBoatPlaceAvailable(Wrap<JsonObject> w);

  public JsonObject getRefBoatPlaceAvailable() {
    return refBoatPlaceAvailable;
  }

  public void setRefBoatPlaceAvailable(JsonObject refBoatPlaceAvailable) {
    this.refBoatPlaceAvailable = refBoatPlaceAvailable;
  }
  @JsonIgnore
  public void setRefBoatPlaceAvailable(String o) {
    this.refBoatPlaceAvailable = SeaportFacility.staticSetRefBoatPlaceAvailable(siteRequest_, o);
  }
  public static JsonObject staticSetRefBoatPlaceAvailable(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility refBoatPlaceAvailableInit() {
    Wrap<JsonObject> refBoatPlaceAvailableWrap = new Wrap<JsonObject>().var("refBoatPlaceAvailable");
    if(refBoatPlaceAvailable == null) {
      _refBoatPlaceAvailable(refBoatPlaceAvailableWrap);
      Optional.ofNullable(refBoatPlaceAvailableWrap.getO()).ifPresent(o -> {
        setRefBoatPlaceAvailable(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRefBoatPlaceAvailable(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrRefBoatPlaceAvailable(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRefBoatPlaceAvailable(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRefBoatPlaceAvailable(siteRequest_, SeaportFacility.staticSetRefBoatPlaceAvailable(siteRequest_, o)).toString();
  }

  public JsonObject sqlRefBoatPlaceAvailable() {
    return refBoatPlaceAvailable;
  }

  public static JsonObject staticJsonRefBoatPlaceAvailable(JsonObject refBoatPlaceAvailable) {
    return refBoatPlaceAvailable;
  }

	/////////////////////////
  // refBoatPlacePricing //
	/////////////////////////


  /**
   *  The entity refBoatPlacePricing
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject refBoatPlacePricing;

  /**
   * <br> The entity refBoatPlacePricing
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:refBoatPlacePricing">Find the entity refBoatPlacePricing in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _refBoatPlacePricing(Wrap<JsonObject> w);

  public JsonObject getRefBoatPlacePricing() {
    return refBoatPlacePricing;
  }

  public void setRefBoatPlacePricing(JsonObject refBoatPlacePricing) {
    this.refBoatPlacePricing = refBoatPlacePricing;
  }
  @JsonIgnore
  public void setRefBoatPlacePricing(String o) {
    this.refBoatPlacePricing = SeaportFacility.staticSetRefBoatPlacePricing(siteRequest_, o);
  }
  public static JsonObject staticSetRefBoatPlacePricing(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility refBoatPlacePricingInit() {
    Wrap<JsonObject> refBoatPlacePricingWrap = new Wrap<JsonObject>().var("refBoatPlacePricing");
    if(refBoatPlacePricing == null) {
      _refBoatPlacePricing(refBoatPlacePricingWrap);
      Optional.ofNullable(refBoatPlacePricingWrap.getO()).ifPresent(o -> {
        setRefBoatPlacePricing(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRefBoatPlacePricing(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrRefBoatPlacePricing(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRefBoatPlacePricing(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRefBoatPlacePricing(siteRequest_, SeaportFacility.staticSetRefBoatPlacePricing(siteRequest_, o)).toString();
  }

  public JsonObject sqlRefBoatPlacePricing() {
    return refBoatPlacePricing;
  }

  public static JsonObject staticJsonRefBoatPlacePricing(JsonObject refBoatPlacePricing) {
    return refBoatPlacePricing;
  }

	///////////////
  // refDevice //
	///////////////


  /**
   *  The entity refDevice
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String refDevice;

  /**
   * <br> The entity refDevice
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:refDevice">Find the entity refDevice in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _refDevice(Wrap<String> w);

  public String getRefDevice() {
    return refDevice;
  }
  public void setRefDevice(String o) {
    this.refDevice = SeaportFacility.staticSetRefDevice(siteRequest_, o);
  }
  public static String staticSetRefDevice(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility refDeviceInit() {
    Wrap<String> refDeviceWrap = new Wrap<String>().var("refDevice");
    if(refDevice == null) {
      _refDevice(refDeviceWrap);
      Optional.ofNullable(refDeviceWrap.getO()).ifPresent(o -> {
        setRefDevice(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRefDevice(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRefDevice(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRefDevice(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRefDevice(siteRequest_, SeaportFacility.staticSetRefDevice(siteRequest_, o)).toString();
  }

  public String sqlRefDevice() {
    return refDevice;
  }

  public static String staticJsonRefDevice(String refDevice) {
    return refDevice;
  }

	////////////////////////
  // refPointOfInterest //
	////////////////////////


  /**
   *  The entity refPointOfInterest
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String refPointOfInterest;

  /**
   * <br> The entity refPointOfInterest
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:refPointOfInterest">Find the entity refPointOfInterest in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _refPointOfInterest(Wrap<String> w);

  public String getRefPointOfInterest() {
    return refPointOfInterest;
  }
  public void setRefPointOfInterest(String o) {
    this.refPointOfInterest = SeaportFacility.staticSetRefPointOfInterest(siteRequest_, o);
  }
  public static String staticSetRefPointOfInterest(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility refPointOfInterestInit() {
    Wrap<String> refPointOfInterestWrap = new Wrap<String>().var("refPointOfInterest");
    if(refPointOfInterest == null) {
      _refPointOfInterest(refPointOfInterestWrap);
      Optional.ofNullable(refPointOfInterestWrap.getO()).ifPresent(o -> {
        setRefPointOfInterest(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRefPointOfInterest(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRefPointOfInterest(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRefPointOfInterest(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRefPointOfInterest(siteRequest_, SeaportFacility.staticSetRefPointOfInterest(siteRequest_, o)).toString();
  }

  public String sqlRefPointOfInterest() {
    return refPointOfInterest;
  }

  public static String staticJsonRefPointOfInterest(String refPointOfInterest) {
    return refPointOfInterest;
  }

	////////////////////////
  // rentalSaleServices //
	////////////////////////


  /**
   *  The entity rentalSaleServices
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject rentalSaleServices;

  /**
   * <br> The entity rentalSaleServices
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:rentalSaleServices">Find the entity rentalSaleServices in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rentalSaleServices(Wrap<JsonObject> w);

  public JsonObject getRentalSaleServices() {
    return rentalSaleServices;
  }

  public void setRentalSaleServices(JsonObject rentalSaleServices) {
    this.rentalSaleServices = rentalSaleServices;
  }
  @JsonIgnore
  public void setRentalSaleServices(String o) {
    this.rentalSaleServices = SeaportFacility.staticSetRentalSaleServices(siteRequest_, o);
  }
  public static JsonObject staticSetRentalSaleServices(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility rentalSaleServicesInit() {
    Wrap<JsonObject> rentalSaleServicesWrap = new Wrap<JsonObject>().var("rentalSaleServices");
    if(rentalSaleServices == null) {
      _rentalSaleServices(rentalSaleServicesWrap);
      Optional.ofNullable(rentalSaleServicesWrap.getO()).ifPresent(o -> {
        setRentalSaleServices(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRentalSaleServices(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrRentalSaleServices(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRentalSaleServices(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRentalSaleServices(siteRequest_, SeaportFacility.staticSetRentalSaleServices(siteRequest_, o)).toString();
  }

  public JsonObject sqlRentalSaleServices() {
    return rentalSaleServices;
  }

  public static JsonObject staticJsonRentalSaleServices(JsonObject rentalSaleServices) {
    return rentalSaleServices;
  }

	///////////////
  // routeType //
	///////////////


  /**
   *  The entity routeType
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject routeType;

  /**
   * <br> The entity routeType
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:routeType">Find the entity routeType in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _routeType(Wrap<JsonObject> w);

  public JsonObject getRouteType() {
    return routeType;
  }

  public void setRouteType(JsonObject routeType) {
    this.routeType = routeType;
  }
  @JsonIgnore
  public void setRouteType(String o) {
    this.routeType = SeaportFacility.staticSetRouteType(siteRequest_, o);
  }
  public static JsonObject staticSetRouteType(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility routeTypeInit() {
    Wrap<JsonObject> routeTypeWrap = new Wrap<JsonObject>().var("routeType");
    if(routeType == null) {
      _routeType(routeTypeWrap);
      Optional.ofNullable(routeTypeWrap.getO()).ifPresent(o -> {
        setRouteType(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchRouteType(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrRouteType(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRouteType(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchRouteType(siteRequest_, SeaportFacility.staticSetRouteType(siteRequest_, o)).toString();
  }

  public JsonObject sqlRouteType() {
    return routeType;
  }

  public static JsonObject staticJsonRouteType(JsonObject routeType) {
    return routeType;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _seeAlso(Wrap<String> w);

  public String getSeeAlso() {
    return seeAlso;
  }
  public void setSeeAlso(String o) {
    this.seeAlso = SeaportFacility.staticSetSeeAlso(siteRequest_, o);
  }
  public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility seeAlsoInit() {
    Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
    if(seeAlso == null) {
      _seeAlso(seeAlsoWrap);
      Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
        setSeeAlso(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchSeeAlso(siteRequest_, SeaportFacility.staticSetSeeAlso(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _source(Wrap<String> w);

  public String getSource() {
    return source;
  }
  public void setSource(String o) {
    this.source = SeaportFacility.staticSetSource(siteRequest_, o);
  }
  public static String staticSetSource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility sourceInit() {
    Wrap<String> sourceWrap = new Wrap<String>().var("source");
    if(source == null) {
      _source(sourceWrap);
      Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
        setSource(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchSource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchSource(siteRequest_, SeaportFacility.staticSetSource(siteRequest_, o)).toString();
  }

  public String sqlSource() {
    return source;
  }

  public static String staticJsonSource(String source) {
    return source;
  }

	///////////////
  // startDate //
	///////////////


  /**
   *  The entity startDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String startDate;

  /**
   * <br> The entity startDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:startDate">Find the entity startDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _startDate(Wrap<String> w);

  public String getStartDate() {
    return startDate;
  }
  public void setStartDate(String o) {
    this.startDate = SeaportFacility.staticSetStartDate(siteRequest_, o);
  }
  public static String staticSetStartDate(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility startDateInit() {
    Wrap<String> startDateWrap = new Wrap<String>().var("startDate");
    if(startDate == null) {
      _startDate(startDateWrap);
      Optional.ofNullable(startDateWrap.getO()).ifPresent(o -> {
        setStartDate(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchStartDate(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrStartDate(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqStartDate(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchStartDate(siteRequest_, SeaportFacility.staticSetStartDate(siteRequest_, o)).toString();
  }

  public String sqlStartDate() {
    return startDate;
  }

  public static String staticJsonStartDate(String startDate) {
    return startDate;
  }

	///////////////////////
  // transportServices //
	///////////////////////


  /**
   *  The entity transportServices
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject transportServices;

  /**
   * <br> The entity transportServices
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:transportServices">Find the entity transportServices in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _transportServices(Wrap<JsonObject> w);

  public JsonObject getTransportServices() {
    return transportServices;
  }

  public void setTransportServices(JsonObject transportServices) {
    this.transportServices = transportServices;
  }
  @JsonIgnore
  public void setTransportServices(String o) {
    this.transportServices = SeaportFacility.staticSetTransportServices(siteRequest_, o);
  }
  public static JsonObject staticSetTransportServices(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility transportServicesInit() {
    Wrap<JsonObject> transportServicesWrap = new Wrap<JsonObject>().var("transportServices");
    if(transportServices == null) {
      _transportServices(transportServicesWrap);
      Optional.ofNullable(transportServicesWrap.getO()).ifPresent(o -> {
        setTransportServices(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchTransportServices(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrTransportServices(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTransportServices(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchTransportServices(siteRequest_, SeaportFacility.staticSetTransportServices(siteRequest_, o)).toString();
  }

  public JsonObject sqlTransportServices() {
    return transportServices;
  }

  public static JsonObject staticJsonTransportServices(JsonObject transportServices) {
    return transportServices;
  }

	////////////////
  // typeOfPort //
	////////////////


  /**
   *  The entity typeOfPort
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject typeOfPort;

  /**
   * <br> The entity typeOfPort
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:typeOfPort">Find the entity typeOfPort in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _typeOfPort(Wrap<JsonObject> w);

  public JsonObject getTypeOfPort() {
    return typeOfPort;
  }

  public void setTypeOfPort(JsonObject typeOfPort) {
    this.typeOfPort = typeOfPort;
  }
  @JsonIgnore
  public void setTypeOfPort(String o) {
    this.typeOfPort = SeaportFacility.staticSetTypeOfPort(siteRequest_, o);
  }
  public static JsonObject staticSetTypeOfPort(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected SeaportFacility typeOfPortInit() {
    Wrap<JsonObject> typeOfPortWrap = new Wrap<JsonObject>().var("typeOfPort");
    if(typeOfPort == null) {
      _typeOfPort(typeOfPortWrap);
      Optional.ofNullable(typeOfPortWrap.getO()).ifPresent(o -> {
        setTypeOfPort(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchTypeOfPort(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrTypeOfPort(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTypeOfPort(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchTypeOfPort(siteRequest_, SeaportFacility.staticSetTypeOfPort(siteRequest_, o)).toString();
  }

  public JsonObject sqlTypeOfPort() {
    return typeOfPort;
  }

  public static JsonObject staticJsonTypeOfPort(JsonObject typeOfPort) {
    return typeOfPort;
  }

	/////////////
  // webSite //
	/////////////


  /**
   *  The entity webSite
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String webSite;

  /**
   * <br> The entity webSite
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility&fq=entiteVar_enUS_indexed_string:webSite">Find the entity webSite in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _webSite(Wrap<String> w);

  public String getWebSite() {
    return webSite;
  }
  public void setWebSite(String o) {
    this.webSite = SeaportFacility.staticSetWebSite(siteRequest_, o);
  }
  public static String staticSetWebSite(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected SeaportFacility webSiteInit() {
    Wrap<String> webSiteWrap = new Wrap<String>().var("webSite");
    if(webSite == null) {
      _webSite(webSiteWrap);
      Optional.ofNullable(webSiteWrap.getO()).ifPresent(o -> {
        setWebSite(o);
      });
    }
    return (SeaportFacility)this;
  }

  public static String staticSearchWebSite(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrWebSite(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqWebSite(SiteRequest siteRequest_, String o) {
    return SeaportFacility.staticSearchWebSite(siteRequest_, SeaportFacility.staticSetWebSite(siteRequest_, o)).toString();
  }

  public String sqlWebSite() {
    return webSite;
  }

  public static String staticJsonWebSite(String webSite) {
    return webSite;
  }

  //////////////
  // initDeep //
  //////////////

  public Future<SeaportFacilityGen<DEV>> promiseDeepSeaportFacility(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepSeaportFacility();
  }

  public Future<SeaportFacilityGen<DEV>> promiseDeepSeaportFacility() {
    Promise<SeaportFacilityGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseSeaportFacility(promise2);
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

  public Future<Void> promiseSeaportFacility(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        addressInit();
        alternateNameInit();
        authorizedPropulsionInit();
        boatSupplyingServicesInit();
        contactPointInit();
        contractingAuthorityInit();
        contractingCompanyInit();
        currencyAcceptedInit();
        dataProviderInit();
        dateCreatedInit();
        dateLastReportedInit();
        dateModifiedInit();
        electricTransportInit();
        endDateInit();
        facilitiesInit();
        maxDraftInit();
        maxLengthInit();
        maxTonnageInit();
        maxWidthInit();
        minLengthInit();
        nearbyServicesInit();
        numberOfPlaceInit();
        openingHoursInit();
        openingHoursSpecificationInit();
        ownerInit();
        paymentAcceptedInit();
        portServicesProvidedInit();
        refBoatAuthorizedInit();
        refBoatPlaceAvailableInit();
        refBoatPlacePricingInit();
        refDeviceInit();
        refPointOfInterestInit();
        rentalSaleServicesInit();
        routeTypeInit();
        seeAlsoInit();
        sourceInit();
        startDateInit();
        transportServicesInit();
        typeOfPortInit();
        webSiteInit();
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

  @Override public Future<? extends SeaportFacilityGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepSeaportFacility(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestSeaportFacility(SiteRequest siteRequest_) {
      super.siteRequestMapModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestSeaportFacility(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainSeaportFacility(v);
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
  public Object obtainSeaportFacility(String var) {
    SeaportFacility oSeaportFacility = (SeaportFacility)this;
    switch(var) {
      case "address":
        return oSeaportFacility.address;
      case "alternateName":
        return oSeaportFacility.alternateName;
      case "authorizedPropulsion":
        return oSeaportFacility.authorizedPropulsion;
      case "boatSupplyingServices":
        return oSeaportFacility.boatSupplyingServices;
      case "contactPoint":
        return oSeaportFacility.contactPoint;
      case "contractingAuthority":
        return oSeaportFacility.contractingAuthority;
      case "contractingCompany":
        return oSeaportFacility.contractingCompany;
      case "currencyAccepted":
        return oSeaportFacility.currencyAccepted;
      case "dataProvider":
        return oSeaportFacility.dataProvider;
      case "dateCreated":
        return oSeaportFacility.dateCreated;
      case "dateLastReported":
        return oSeaportFacility.dateLastReported;
      case "dateModified":
        return oSeaportFacility.dateModified;
      case "electricTransport":
        return oSeaportFacility.electricTransport;
      case "endDate":
        return oSeaportFacility.endDate;
      case "facilities":
        return oSeaportFacility.facilities;
      case "maxDraft":
        return oSeaportFacility.maxDraft;
      case "maxLength":
        return oSeaportFacility.maxLength;
      case "maxTonnage":
        return oSeaportFacility.maxTonnage;
      case "maxWidth":
        return oSeaportFacility.maxWidth;
      case "minLength":
        return oSeaportFacility.minLength;
      case "nearbyServices":
        return oSeaportFacility.nearbyServices;
      case "numberOfPlace":
        return oSeaportFacility.numberOfPlace;
      case "openingHours":
        return oSeaportFacility.openingHours;
      case "openingHoursSpecification":
        return oSeaportFacility.openingHoursSpecification;
      case "owner":
        return oSeaportFacility.owner;
      case "paymentAccepted":
        return oSeaportFacility.paymentAccepted;
      case "portServicesProvided":
        return oSeaportFacility.portServicesProvided;
      case "refBoatAuthorized":
        return oSeaportFacility.refBoatAuthorized;
      case "refBoatPlaceAvailable":
        return oSeaportFacility.refBoatPlaceAvailable;
      case "refBoatPlacePricing":
        return oSeaportFacility.refBoatPlacePricing;
      case "refDevice":
        return oSeaportFacility.refDevice;
      case "refPointOfInterest":
        return oSeaportFacility.refPointOfInterest;
      case "rentalSaleServices":
        return oSeaportFacility.rentalSaleServices;
      case "routeType":
        return oSeaportFacility.routeType;
      case "seeAlso":
        return oSeaportFacility.seeAlso;
      case "source":
        return oSeaportFacility.source;
      case "startDate":
        return oSeaportFacility.startDate;
      case "transportServices":
        return oSeaportFacility.transportServices;
      case "typeOfPort":
        return oSeaportFacility.typeOfPort;
      case "webSite":
        return oSeaportFacility.webSite;
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
        o = relateSeaportFacility(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateSeaportFacility(String var, Object val) {
    SeaportFacility oSeaportFacility = (SeaportFacility)this;
    switch(var) {
      default:
        return super.relateMapModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, SeaportFacility o) {
    return staticSetSeaportFacility(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetSeaportFacility(String entityVar, SiteRequest siteRequest_, String v, SeaportFacility o) {
    switch(entityVar) {
    case "address":
      return SeaportFacility.staticSetAddress(siteRequest_, v);
    case "alternateName":
      return SeaportFacility.staticSetAlternateName(siteRequest_, v);
    case "authorizedPropulsion":
      return SeaportFacility.staticSetAuthorizedPropulsion(siteRequest_, v);
    case "boatSupplyingServices":
      return SeaportFacility.staticSetBoatSupplyingServices(siteRequest_, v);
    case "contactPoint":
      return SeaportFacility.staticSetContactPoint(siteRequest_, v);
    case "contractingAuthority":
      return SeaportFacility.staticSetContractingAuthority(siteRequest_, v);
    case "contractingCompany":
      return SeaportFacility.staticSetContractingCompany(siteRequest_, v);
    case "currencyAccepted":
      return SeaportFacility.staticSetCurrencyAccepted(siteRequest_, v);
    case "dataProvider":
      return SeaportFacility.staticSetDataProvider(siteRequest_, v);
    case "dateCreated":
      return SeaportFacility.staticSetDateCreated(siteRequest_, v);
    case "dateLastReported":
      return SeaportFacility.staticSetDateLastReported(siteRequest_, v);
    case "dateModified":
      return SeaportFacility.staticSetDateModified(siteRequest_, v);
    case "electricTransport":
      return SeaportFacility.staticSetElectricTransport(siteRequest_, v);
    case "endDate":
      return SeaportFacility.staticSetEndDate(siteRequest_, v);
    case "facilities":
      return SeaportFacility.staticSetFacilities(siteRequest_, v);
    case "maxDraft":
      return SeaportFacility.staticSetMaxDraft(siteRequest_, v);
    case "maxLength":
      return SeaportFacility.staticSetMaxLength(siteRequest_, v);
    case "maxTonnage":
      return SeaportFacility.staticSetMaxTonnage(siteRequest_, v);
    case "maxWidth":
      return SeaportFacility.staticSetMaxWidth(siteRequest_, v);
    case "minLength":
      return SeaportFacility.staticSetMinLength(siteRequest_, v);
    case "nearbyServices":
      return SeaportFacility.staticSetNearbyServices(siteRequest_, v);
    case "numberOfPlace":
      return SeaportFacility.staticSetNumberOfPlace(siteRequest_, v);
    case "openingHours":
      return SeaportFacility.staticSetOpeningHours(siteRequest_, v);
    case "openingHoursSpecification":
      return SeaportFacility.staticSetOpeningHoursSpecification(siteRequest_, v);
    case "owner":
      return SeaportFacility.staticSetOwner(siteRequest_, v);
    case "paymentAccepted":
      return SeaportFacility.staticSetPaymentAccepted(siteRequest_, v);
    case "portServicesProvided":
      return SeaportFacility.staticSetPortServicesProvided(siteRequest_, v);
    case "refBoatAuthorized":
      return SeaportFacility.staticSetRefBoatAuthorized(siteRequest_, v);
    case "refBoatPlaceAvailable":
      return SeaportFacility.staticSetRefBoatPlaceAvailable(siteRequest_, v);
    case "refBoatPlacePricing":
      return SeaportFacility.staticSetRefBoatPlacePricing(siteRequest_, v);
    case "refDevice":
      return SeaportFacility.staticSetRefDevice(siteRequest_, v);
    case "refPointOfInterest":
      return SeaportFacility.staticSetRefPointOfInterest(siteRequest_, v);
    case "rentalSaleServices":
      return SeaportFacility.staticSetRentalSaleServices(siteRequest_, v);
    case "routeType":
      return SeaportFacility.staticSetRouteType(siteRequest_, v);
    case "seeAlso":
      return SeaportFacility.staticSetSeeAlso(siteRequest_, v);
    case "source":
      return SeaportFacility.staticSetSource(siteRequest_, v);
    case "startDate":
      return SeaportFacility.staticSetStartDate(siteRequest_, v);
    case "transportServices":
      return SeaportFacility.staticSetTransportServices(siteRequest_, v);
    case "typeOfPort":
      return SeaportFacility.staticSetTypeOfPort(siteRequest_, v);
    case "webSite":
      return SeaportFacility.staticSetWebSite(siteRequest_, v);
      default:
        return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchSeaportFacility(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchSeaportFacility(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return SeaportFacility.staticSearchAddress(siteRequest_, (JsonObject)o);
    case "alternateName":
      return SeaportFacility.staticSearchAlternateName(siteRequest_, (String)o);
    case "authorizedPropulsion":
      return SeaportFacility.staticSearchAuthorizedPropulsion(siteRequest_, (JsonObject)o);
    case "boatSupplyingServices":
      return SeaportFacility.staticSearchBoatSupplyingServices(siteRequest_, (JsonObject)o);
    case "contactPoint":
      return SeaportFacility.staticSearchContactPoint(siteRequest_, (JsonObject)o);
    case "contractingAuthority":
      return SeaportFacility.staticSearchContractingAuthority(siteRequest_, (String)o);
    case "contractingCompany":
      return SeaportFacility.staticSearchContractingCompany(siteRequest_, (String)o);
    case "currencyAccepted":
      return SeaportFacility.staticSearchCurrencyAccepted(siteRequest_, (JsonObject)o);
    case "dataProvider":
      return SeaportFacility.staticSearchDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return SeaportFacility.staticSearchDateCreated(siteRequest_, (String)o);
    case "dateLastReported":
      return SeaportFacility.staticSearchDateLastReported(siteRequest_, (String)o);
    case "dateModified":
      return SeaportFacility.staticSearchDateModified(siteRequest_, (String)o);
    case "electricTransport":
      return SeaportFacility.staticSearchElectricTransport(siteRequest_, (JsonObject)o);
    case "endDate":
      return SeaportFacility.staticSearchEndDate(siteRequest_, (String)o);
    case "facilities":
      return SeaportFacility.staticSearchFacilities(siteRequest_, (JsonObject)o);
    case "maxDraft":
      return SeaportFacility.staticSearchMaxDraft(siteRequest_, (BigDecimal)o);
    case "maxLength":
      return SeaportFacility.staticSearchMaxLength(siteRequest_, (BigDecimal)o);
    case "maxTonnage":
      return SeaportFacility.staticSearchMaxTonnage(siteRequest_, (BigDecimal)o);
    case "maxWidth":
      return SeaportFacility.staticSearchMaxWidth(siteRequest_, (BigDecimal)o);
    case "minLength":
      return SeaportFacility.staticSearchMinLength(siteRequest_, (BigDecimal)o);
    case "nearbyServices":
      return SeaportFacility.staticSearchNearbyServices(siteRequest_, (JsonObject)o);
    case "numberOfPlace":
      return SeaportFacility.staticSearchNumberOfPlace(siteRequest_, (BigDecimal)o);
    case "openingHours":
      return SeaportFacility.staticSearchOpeningHours(siteRequest_, (String)o);
    case "openingHoursSpecification":
      return SeaportFacility.staticSearchOpeningHoursSpecification(siteRequest_, (JsonObject)o);
    case "owner":
      return SeaportFacility.staticSearchOwner(siteRequest_, (JsonObject)o);
    case "paymentAccepted":
      return SeaportFacility.staticSearchPaymentAccepted(siteRequest_, (JsonObject)o);
    case "portServicesProvided":
      return SeaportFacility.staticSearchPortServicesProvided(siteRequest_, (JsonObject)o);
    case "refBoatAuthorized":
      return SeaportFacility.staticSearchRefBoatAuthorized(siteRequest_, (JsonObject)o);
    case "refBoatPlaceAvailable":
      return SeaportFacility.staticSearchRefBoatPlaceAvailable(siteRequest_, (JsonObject)o);
    case "refBoatPlacePricing":
      return SeaportFacility.staticSearchRefBoatPlacePricing(siteRequest_, (JsonObject)o);
    case "refDevice":
      return SeaportFacility.staticSearchRefDevice(siteRequest_, (String)o);
    case "refPointOfInterest":
      return SeaportFacility.staticSearchRefPointOfInterest(siteRequest_, (String)o);
    case "rentalSaleServices":
      return SeaportFacility.staticSearchRentalSaleServices(siteRequest_, (JsonObject)o);
    case "routeType":
      return SeaportFacility.staticSearchRouteType(siteRequest_, (JsonObject)o);
    case "seeAlso":
      return SeaportFacility.staticSearchSeeAlso(siteRequest_, (String)o);
    case "source":
      return SeaportFacility.staticSearchSource(siteRequest_, (String)o);
    case "startDate":
      return SeaportFacility.staticSearchStartDate(siteRequest_, (String)o);
    case "transportServices":
      return SeaportFacility.staticSearchTransportServices(siteRequest_, (JsonObject)o);
    case "typeOfPort":
      return SeaportFacility.staticSearchTypeOfPort(siteRequest_, (JsonObject)o);
    case "webSite":
      return SeaportFacility.staticSearchWebSite(siteRequest_, (String)o);
      default:
        return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrSeaportFacility(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrSeaportFacility(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return SeaportFacility.staticSearchStrAddress(siteRequest_, (String)o);
    case "alternateName":
      return SeaportFacility.staticSearchStrAlternateName(siteRequest_, (String)o);
    case "authorizedPropulsion":
      return SeaportFacility.staticSearchStrAuthorizedPropulsion(siteRequest_, (String)o);
    case "boatSupplyingServices":
      return SeaportFacility.staticSearchStrBoatSupplyingServices(siteRequest_, (String)o);
    case "contactPoint":
      return SeaportFacility.staticSearchStrContactPoint(siteRequest_, (String)o);
    case "contractingAuthority":
      return SeaportFacility.staticSearchStrContractingAuthority(siteRequest_, (String)o);
    case "contractingCompany":
      return SeaportFacility.staticSearchStrContractingCompany(siteRequest_, (String)o);
    case "currencyAccepted":
      return SeaportFacility.staticSearchStrCurrencyAccepted(siteRequest_, (String)o);
    case "dataProvider":
      return SeaportFacility.staticSearchStrDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return SeaportFacility.staticSearchStrDateCreated(siteRequest_, (String)o);
    case "dateLastReported":
      return SeaportFacility.staticSearchStrDateLastReported(siteRequest_, (String)o);
    case "dateModified":
      return SeaportFacility.staticSearchStrDateModified(siteRequest_, (String)o);
    case "electricTransport":
      return SeaportFacility.staticSearchStrElectricTransport(siteRequest_, (String)o);
    case "endDate":
      return SeaportFacility.staticSearchStrEndDate(siteRequest_, (String)o);
    case "facilities":
      return SeaportFacility.staticSearchStrFacilities(siteRequest_, (String)o);
    case "maxDraft":
      return SeaportFacility.staticSearchStrMaxDraft(siteRequest_, (Double)o);
    case "maxLength":
      return SeaportFacility.staticSearchStrMaxLength(siteRequest_, (Double)o);
    case "maxTonnage":
      return SeaportFacility.staticSearchStrMaxTonnage(siteRequest_, (Double)o);
    case "maxWidth":
      return SeaportFacility.staticSearchStrMaxWidth(siteRequest_, (Double)o);
    case "minLength":
      return SeaportFacility.staticSearchStrMinLength(siteRequest_, (Double)o);
    case "nearbyServices":
      return SeaportFacility.staticSearchStrNearbyServices(siteRequest_, (String)o);
    case "numberOfPlace":
      return SeaportFacility.staticSearchStrNumberOfPlace(siteRequest_, (Double)o);
    case "openingHours":
      return SeaportFacility.staticSearchStrOpeningHours(siteRequest_, (String)o);
    case "openingHoursSpecification":
      return SeaportFacility.staticSearchStrOpeningHoursSpecification(siteRequest_, (String)o);
    case "owner":
      return SeaportFacility.staticSearchStrOwner(siteRequest_, (String)o);
    case "paymentAccepted":
      return SeaportFacility.staticSearchStrPaymentAccepted(siteRequest_, (String)o);
    case "portServicesProvided":
      return SeaportFacility.staticSearchStrPortServicesProvided(siteRequest_, (String)o);
    case "refBoatAuthorized":
      return SeaportFacility.staticSearchStrRefBoatAuthorized(siteRequest_, (String)o);
    case "refBoatPlaceAvailable":
      return SeaportFacility.staticSearchStrRefBoatPlaceAvailable(siteRequest_, (String)o);
    case "refBoatPlacePricing":
      return SeaportFacility.staticSearchStrRefBoatPlacePricing(siteRequest_, (String)o);
    case "refDevice":
      return SeaportFacility.staticSearchStrRefDevice(siteRequest_, (String)o);
    case "refPointOfInterest":
      return SeaportFacility.staticSearchStrRefPointOfInterest(siteRequest_, (String)o);
    case "rentalSaleServices":
      return SeaportFacility.staticSearchStrRentalSaleServices(siteRequest_, (String)o);
    case "routeType":
      return SeaportFacility.staticSearchStrRouteType(siteRequest_, (String)o);
    case "seeAlso":
      return SeaportFacility.staticSearchStrSeeAlso(siteRequest_, (String)o);
    case "source":
      return SeaportFacility.staticSearchStrSource(siteRequest_, (String)o);
    case "startDate":
      return SeaportFacility.staticSearchStrStartDate(siteRequest_, (String)o);
    case "transportServices":
      return SeaportFacility.staticSearchStrTransportServices(siteRequest_, (String)o);
    case "typeOfPort":
      return SeaportFacility.staticSearchStrTypeOfPort(siteRequest_, (String)o);
    case "webSite":
      return SeaportFacility.staticSearchStrWebSite(siteRequest_, (String)o);
      default:
        return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqSeaportFacility(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqSeaportFacility(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "address":
      return SeaportFacility.staticSearchFqAddress(siteRequest_, o);
    case "alternateName":
      return SeaportFacility.staticSearchFqAlternateName(siteRequest_, o);
    case "authorizedPropulsion":
      return SeaportFacility.staticSearchFqAuthorizedPropulsion(siteRequest_, o);
    case "boatSupplyingServices":
      return SeaportFacility.staticSearchFqBoatSupplyingServices(siteRequest_, o);
    case "contactPoint":
      return SeaportFacility.staticSearchFqContactPoint(siteRequest_, o);
    case "contractingAuthority":
      return SeaportFacility.staticSearchFqContractingAuthority(siteRequest_, o);
    case "contractingCompany":
      return SeaportFacility.staticSearchFqContractingCompany(siteRequest_, o);
    case "currencyAccepted":
      return SeaportFacility.staticSearchFqCurrencyAccepted(siteRequest_, o);
    case "dataProvider":
      return SeaportFacility.staticSearchFqDataProvider(siteRequest_, o);
    case "dateCreated":
      return SeaportFacility.staticSearchFqDateCreated(siteRequest_, o);
    case "dateLastReported":
      return SeaportFacility.staticSearchFqDateLastReported(siteRequest_, o);
    case "dateModified":
      return SeaportFacility.staticSearchFqDateModified(siteRequest_, o);
    case "electricTransport":
      return SeaportFacility.staticSearchFqElectricTransport(siteRequest_, o);
    case "endDate":
      return SeaportFacility.staticSearchFqEndDate(siteRequest_, o);
    case "facilities":
      return SeaportFacility.staticSearchFqFacilities(siteRequest_, o);
    case "maxDraft":
      return SeaportFacility.staticSearchFqMaxDraft(siteRequest_, o);
    case "maxLength":
      return SeaportFacility.staticSearchFqMaxLength(siteRequest_, o);
    case "maxTonnage":
      return SeaportFacility.staticSearchFqMaxTonnage(siteRequest_, o);
    case "maxWidth":
      return SeaportFacility.staticSearchFqMaxWidth(siteRequest_, o);
    case "minLength":
      return SeaportFacility.staticSearchFqMinLength(siteRequest_, o);
    case "nearbyServices":
      return SeaportFacility.staticSearchFqNearbyServices(siteRequest_, o);
    case "numberOfPlace":
      return SeaportFacility.staticSearchFqNumberOfPlace(siteRequest_, o);
    case "openingHours":
      return SeaportFacility.staticSearchFqOpeningHours(siteRequest_, o);
    case "openingHoursSpecification":
      return SeaportFacility.staticSearchFqOpeningHoursSpecification(siteRequest_, o);
    case "owner":
      return SeaportFacility.staticSearchFqOwner(siteRequest_, o);
    case "paymentAccepted":
      return SeaportFacility.staticSearchFqPaymentAccepted(siteRequest_, o);
    case "portServicesProvided":
      return SeaportFacility.staticSearchFqPortServicesProvided(siteRequest_, o);
    case "refBoatAuthorized":
      return SeaportFacility.staticSearchFqRefBoatAuthorized(siteRequest_, o);
    case "refBoatPlaceAvailable":
      return SeaportFacility.staticSearchFqRefBoatPlaceAvailable(siteRequest_, o);
    case "refBoatPlacePricing":
      return SeaportFacility.staticSearchFqRefBoatPlacePricing(siteRequest_, o);
    case "refDevice":
      return SeaportFacility.staticSearchFqRefDevice(siteRequest_, o);
    case "refPointOfInterest":
      return SeaportFacility.staticSearchFqRefPointOfInterest(siteRequest_, o);
    case "rentalSaleServices":
      return SeaportFacility.staticSearchFqRentalSaleServices(siteRequest_, o);
    case "routeType":
      return SeaportFacility.staticSearchFqRouteType(siteRequest_, o);
    case "seeAlso":
      return SeaportFacility.staticSearchFqSeeAlso(siteRequest_, o);
    case "source":
      return SeaportFacility.staticSearchFqSource(siteRequest_, o);
    case "startDate":
      return SeaportFacility.staticSearchFqStartDate(siteRequest_, o);
    case "transportServices":
      return SeaportFacility.staticSearchFqTransportServices(siteRequest_, o);
    case "typeOfPort":
      return SeaportFacility.staticSearchFqTypeOfPort(siteRequest_, o);
    case "webSite":
      return SeaportFacility.staticSearchFqWebSite(siteRequest_, o);
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
          o = persistSeaportFacility(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistSeaportFacility(String var, Object val) {
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
      } else if("authorizedpropulsion".equals(varLower)) {
        if(val instanceof String) {
          setAuthorizedPropulsion((String)val);
        } else if(val instanceof JsonObject) {
          setAuthorizedPropulsion((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setAuthorizedPropulsion((JsonObject)val);
        }
        saves.add("authorizedPropulsion");
        return val;
      } else if("boatsupplyingservices".equals(varLower)) {
        if(val instanceof String) {
          setBoatSupplyingServices((String)val);
        } else if(val instanceof JsonObject) {
          setBoatSupplyingServices((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setBoatSupplyingServices((JsonObject)val);
        }
        saves.add("boatSupplyingServices");
        return val;
      } else if("contactpoint".equals(varLower)) {
        if(val instanceof String) {
          setContactPoint((String)val);
        } else if(val instanceof JsonObject) {
          setContactPoint((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setContactPoint((JsonObject)val);
        }
        saves.add("contactPoint");
        return val;
      } else if("contractingauthority".equals(varLower)) {
        if(val instanceof String) {
          setContractingAuthority((String)val);
        }
        saves.add("contractingAuthority");
        return val;
      } else if("contractingcompany".equals(varLower)) {
        if(val instanceof String) {
          setContractingCompany((String)val);
        }
        saves.add("contractingCompany");
        return val;
      } else if("currencyaccepted".equals(varLower)) {
        if(val instanceof String) {
          setCurrencyAccepted((String)val);
        } else if(val instanceof JsonObject) {
          setCurrencyAccepted((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setCurrencyAccepted((JsonObject)val);
        }
        saves.add("currencyAccepted");
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
      } else if("datelastreported".equals(varLower)) {
        if(val instanceof String) {
          setDateLastReported((String)val);
        }
        saves.add("dateLastReported");
        return val;
      } else if("datemodified".equals(varLower)) {
        if(val instanceof String) {
          setDateModified((String)val);
        }
        saves.add("dateModified");
        return val;
      } else if("electrictransport".equals(varLower)) {
        if(val instanceof String) {
          setElectricTransport((String)val);
        } else if(val instanceof JsonObject) {
          setElectricTransport((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setElectricTransport((JsonObject)val);
        }
        saves.add("electricTransport");
        return val;
      } else if("enddate".equals(varLower)) {
        if(val instanceof String) {
          setEndDate((String)val);
        }
        saves.add("endDate");
        return val;
      } else if("facilities".equals(varLower)) {
        if(val instanceof String) {
          setFacilities((String)val);
        } else if(val instanceof JsonObject) {
          setFacilities((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setFacilities((JsonObject)val);
        }
        saves.add("facilities");
        return val;
      } else if("maxdraft".equals(varLower)) {
        if(val instanceof String) {
          setMaxDraft((String)val);
        } else if(val instanceof Number) {
          setMaxDraft(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaxDraft((BigDecimal)val);
        }
        saves.add("maxDraft");
        return val;
      } else if("maxlength".equals(varLower)) {
        if(val instanceof String) {
          setMaxLength((String)val);
        } else if(val instanceof Number) {
          setMaxLength(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaxLength((BigDecimal)val);
        }
        saves.add("maxLength");
        return val;
      } else if("maxtonnage".equals(varLower)) {
        if(val instanceof String) {
          setMaxTonnage((String)val);
        } else if(val instanceof Number) {
          setMaxTonnage(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaxTonnage((BigDecimal)val);
        }
        saves.add("maxTonnage");
        return val;
      } else if("maxwidth".equals(varLower)) {
        if(val instanceof String) {
          setMaxWidth((String)val);
        } else if(val instanceof Number) {
          setMaxWidth(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMaxWidth((BigDecimal)val);
        }
        saves.add("maxWidth");
        return val;
      } else if("minlength".equals(varLower)) {
        if(val instanceof String) {
          setMinLength((String)val);
        } else if(val instanceof Number) {
          setMinLength(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setMinLength((BigDecimal)val);
        }
        saves.add("minLength");
        return val;
      } else if("nearbyservices".equals(varLower)) {
        if(val instanceof String) {
          setNearbyServices((String)val);
        } else if(val instanceof JsonObject) {
          setNearbyServices((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setNearbyServices((JsonObject)val);
        }
        saves.add("nearbyServices");
        return val;
      } else if("numberofplace".equals(varLower)) {
        if(val instanceof String) {
          setNumberOfPlace((String)val);
        } else if(val instanceof Number) {
          setNumberOfPlace(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setNumberOfPlace((BigDecimal)val);
        }
        saves.add("numberOfPlace");
        return val;
      } else if("openinghours".equals(varLower)) {
        if(val instanceof String) {
          setOpeningHours((String)val);
        }
        saves.add("openingHours");
        return val;
      } else if("openinghoursspecification".equals(varLower)) {
        if(val instanceof String) {
          setOpeningHoursSpecification((String)val);
        } else if(val instanceof JsonObject) {
          setOpeningHoursSpecification((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setOpeningHoursSpecification((JsonObject)val);
        }
        saves.add("openingHoursSpecification");
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
      } else if("paymentaccepted".equals(varLower)) {
        if(val instanceof String) {
          setPaymentAccepted((String)val);
        } else if(val instanceof JsonObject) {
          setPaymentAccepted((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setPaymentAccepted((JsonObject)val);
        }
        saves.add("paymentAccepted");
        return val;
      } else if("portservicesprovided".equals(varLower)) {
        if(val instanceof String) {
          setPortServicesProvided((String)val);
        } else if(val instanceof JsonObject) {
          setPortServicesProvided((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setPortServicesProvided((JsonObject)val);
        }
        saves.add("portServicesProvided");
        return val;
      } else if("refboatauthorized".equals(varLower)) {
        if(val instanceof String) {
          setRefBoatAuthorized((String)val);
        } else if(val instanceof JsonObject) {
          setRefBoatAuthorized((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setRefBoatAuthorized((JsonObject)val);
        }
        saves.add("refBoatAuthorized");
        return val;
      } else if("refboatplaceavailable".equals(varLower)) {
        if(val instanceof String) {
          setRefBoatPlaceAvailable((String)val);
        } else if(val instanceof JsonObject) {
          setRefBoatPlaceAvailable((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setRefBoatPlaceAvailable((JsonObject)val);
        }
        saves.add("refBoatPlaceAvailable");
        return val;
      } else if("refboatplacepricing".equals(varLower)) {
        if(val instanceof String) {
          setRefBoatPlacePricing((String)val);
        } else if(val instanceof JsonObject) {
          setRefBoatPlacePricing((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setRefBoatPlacePricing((JsonObject)val);
        }
        saves.add("refBoatPlacePricing");
        return val;
      } else if("refdevice".equals(varLower)) {
        if(val instanceof String) {
          setRefDevice((String)val);
        }
        saves.add("refDevice");
        return val;
      } else if("refpointofinterest".equals(varLower)) {
        if(val instanceof String) {
          setRefPointOfInterest((String)val);
        }
        saves.add("refPointOfInterest");
        return val;
      } else if("rentalsaleservices".equals(varLower)) {
        if(val instanceof String) {
          setRentalSaleServices((String)val);
        } else if(val instanceof JsonObject) {
          setRentalSaleServices((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setRentalSaleServices((JsonObject)val);
        }
        saves.add("rentalSaleServices");
        return val;
      } else if("routetype".equals(varLower)) {
        if(val instanceof String) {
          setRouteType((String)val);
        } else if(val instanceof JsonObject) {
          setRouteType((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setRouteType((JsonObject)val);
        }
        saves.add("routeType");
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
      } else if("startdate".equals(varLower)) {
        if(val instanceof String) {
          setStartDate((String)val);
        }
        saves.add("startDate");
        return val;
      } else if("transportservices".equals(varLower)) {
        if(val instanceof String) {
          setTransportServices((String)val);
        } else if(val instanceof JsonObject) {
          setTransportServices((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setTransportServices((JsonObject)val);
        }
        saves.add("transportServices");
        return val;
      } else if("typeofport".equals(varLower)) {
        if(val instanceof String) {
          setTypeOfPort((String)val);
        } else if(val instanceof JsonObject) {
          setTypeOfPort((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setTypeOfPort((JsonObject)val);
        }
        saves.add("typeOfPort");
        return val;
      } else if("website".equals(varLower)) {
        if(val instanceof String) {
          setWebSite((String)val);
        }
        saves.add("webSite");
        return val;
    } else {
      return super.persistMapModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateSeaportFacility(doc);
  }
  public void populateSeaportFacility(SolrResponse.Doc doc) {
    SeaportFacility oSeaportFacility = (SeaportFacility)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("address")) {
        String address = (String)doc.get("address_docvalues_string");
        if(address != null)
          oSeaportFacility.setAddress(address);
      }

      if(saves.contains("alternateName")) {
        String alternateName = (String)doc.get("alternateName_docvalues_string");
        if(alternateName != null)
          oSeaportFacility.setAlternateName(alternateName);
      }

      if(saves.contains("authorizedPropulsion")) {
        String authorizedPropulsion = (String)doc.get("authorizedPropulsion_docvalues_string");
        if(authorizedPropulsion != null)
          oSeaportFacility.setAuthorizedPropulsion(authorizedPropulsion);
      }

      if(saves.contains("boatSupplyingServices")) {
        String boatSupplyingServices = (String)doc.get("boatSupplyingServices_docvalues_string");
        if(boatSupplyingServices != null)
          oSeaportFacility.setBoatSupplyingServices(boatSupplyingServices);
      }

      if(saves.contains("contactPoint")) {
        String contactPoint = (String)doc.get("contactPoint_docvalues_string");
        if(contactPoint != null)
          oSeaportFacility.setContactPoint(contactPoint);
      }

      if(saves.contains("contractingAuthority")) {
        String contractingAuthority = (String)doc.get("contractingAuthority_docvalues_string");
        if(contractingAuthority != null)
          oSeaportFacility.setContractingAuthority(contractingAuthority);
      }

      if(saves.contains("contractingCompany")) {
        String contractingCompany = (String)doc.get("contractingCompany_docvalues_string");
        if(contractingCompany != null)
          oSeaportFacility.setContractingCompany(contractingCompany);
      }

      if(saves.contains("currencyAccepted")) {
        String currencyAccepted = (String)doc.get("currencyAccepted_docvalues_string");
        if(currencyAccepted != null)
          oSeaportFacility.setCurrencyAccepted(currencyAccepted);
      }

      if(saves.contains("dataProvider")) {
        String dataProvider = (String)doc.get("dataProvider_docvalues_string");
        if(dataProvider != null)
          oSeaportFacility.setDataProvider(dataProvider);
      }

      if(saves.contains("dateCreated")) {
        String dateCreated = (String)doc.get("dateCreated_docvalues_string");
        if(dateCreated != null)
          oSeaportFacility.setDateCreated(dateCreated);
      }

      if(saves.contains("dateLastReported")) {
        String dateLastReported = (String)doc.get("dateLastReported_docvalues_string");
        if(dateLastReported != null)
          oSeaportFacility.setDateLastReported(dateLastReported);
      }

      if(saves.contains("dateModified")) {
        String dateModified = (String)doc.get("dateModified_docvalues_string");
        if(dateModified != null)
          oSeaportFacility.setDateModified(dateModified);
      }

      if(saves.contains("electricTransport")) {
        String electricTransport = (String)doc.get("electricTransport_docvalues_string");
        if(electricTransport != null)
          oSeaportFacility.setElectricTransport(electricTransport);
      }

      if(saves.contains("endDate")) {
        String endDate = (String)doc.get("endDate_docvalues_string");
        if(endDate != null)
          oSeaportFacility.setEndDate(endDate);
      }

      if(saves.contains("facilities")) {
        String facilities = (String)doc.get("facilities_docvalues_string");
        if(facilities != null)
          oSeaportFacility.setFacilities(facilities);
      }

      if(saves.contains("maxDraft")) {
        Double maxDraft = (Double)doc.get("maxDraft_docvalues_string");
        if(maxDraft != null)
          oSeaportFacility.setMaxDraft(maxDraft);
      }

      if(saves.contains("maxLength")) {
        Double maxLength = (Double)doc.get("maxLength_docvalues_string");
        if(maxLength != null)
          oSeaportFacility.setMaxLength(maxLength);
      }

      if(saves.contains("maxTonnage")) {
        Double maxTonnage = (Double)doc.get("maxTonnage_docvalues_string");
        if(maxTonnage != null)
          oSeaportFacility.setMaxTonnage(maxTonnage);
      }

      if(saves.contains("maxWidth")) {
        Double maxWidth = (Double)doc.get("maxWidth_docvalues_string");
        if(maxWidth != null)
          oSeaportFacility.setMaxWidth(maxWidth);
      }

      if(saves.contains("minLength")) {
        Double minLength = (Double)doc.get("minLength_docvalues_string");
        if(minLength != null)
          oSeaportFacility.setMinLength(minLength);
      }

      if(saves.contains("nearbyServices")) {
        String nearbyServices = (String)doc.get("nearbyServices_docvalues_string");
        if(nearbyServices != null)
          oSeaportFacility.setNearbyServices(nearbyServices);
      }

      if(saves.contains("numberOfPlace")) {
        Double numberOfPlace = (Double)doc.get("numberOfPlace_docvalues_string");
        if(numberOfPlace != null)
          oSeaportFacility.setNumberOfPlace(numberOfPlace);
      }

      if(saves.contains("openingHours")) {
        String openingHours = (String)doc.get("openingHours_docvalues_string");
        if(openingHours != null)
          oSeaportFacility.setOpeningHours(openingHours);
      }

      if(saves.contains("openingHoursSpecification")) {
        String openingHoursSpecification = (String)doc.get("openingHoursSpecification_docvalues_string");
        if(openingHoursSpecification != null)
          oSeaportFacility.setOpeningHoursSpecification(openingHoursSpecification);
      }

      if(saves.contains("owner")) {
        String owner = (String)doc.get("owner_docvalues_string");
        if(owner != null)
          oSeaportFacility.setOwner(owner);
      }

      if(saves.contains("paymentAccepted")) {
        String paymentAccepted = (String)doc.get("paymentAccepted_docvalues_string");
        if(paymentAccepted != null)
          oSeaportFacility.setPaymentAccepted(paymentAccepted);
      }

      if(saves.contains("portServicesProvided")) {
        String portServicesProvided = (String)doc.get("portServicesProvided_docvalues_string");
        if(portServicesProvided != null)
          oSeaportFacility.setPortServicesProvided(portServicesProvided);
      }

      if(saves.contains("refBoatAuthorized")) {
        String refBoatAuthorized = (String)doc.get("refBoatAuthorized_docvalues_string");
        if(refBoatAuthorized != null)
          oSeaportFacility.setRefBoatAuthorized(refBoatAuthorized);
      }

      if(saves.contains("refBoatPlaceAvailable")) {
        String refBoatPlaceAvailable = (String)doc.get("refBoatPlaceAvailable_docvalues_string");
        if(refBoatPlaceAvailable != null)
          oSeaportFacility.setRefBoatPlaceAvailable(refBoatPlaceAvailable);
      }

      if(saves.contains("refBoatPlacePricing")) {
        String refBoatPlacePricing = (String)doc.get("refBoatPlacePricing_docvalues_string");
        if(refBoatPlacePricing != null)
          oSeaportFacility.setRefBoatPlacePricing(refBoatPlacePricing);
      }

      if(saves.contains("refDevice")) {
        String refDevice = (String)doc.get("refDevice_docvalues_string");
        if(refDevice != null)
          oSeaportFacility.setRefDevice(refDevice);
      }

      if(saves.contains("refPointOfInterest")) {
        String refPointOfInterest = (String)doc.get("refPointOfInterest_docvalues_string");
        if(refPointOfInterest != null)
          oSeaportFacility.setRefPointOfInterest(refPointOfInterest);
      }

      if(saves.contains("rentalSaleServices")) {
        String rentalSaleServices = (String)doc.get("rentalSaleServices_docvalues_string");
        if(rentalSaleServices != null)
          oSeaportFacility.setRentalSaleServices(rentalSaleServices);
      }

      if(saves.contains("routeType")) {
        String routeType = (String)doc.get("routeType_docvalues_string");
        if(routeType != null)
          oSeaportFacility.setRouteType(routeType);
      }

      if(saves.contains("seeAlso")) {
        String seeAlso = (String)doc.get("seeAlso_docvalues_string");
        if(seeAlso != null)
          oSeaportFacility.setSeeAlso(seeAlso);
      }

      if(saves.contains("source")) {
        String source = (String)doc.get("source_docvalues_string");
        if(source != null)
          oSeaportFacility.setSource(source);
      }

      if(saves.contains("startDate")) {
        String startDate = (String)doc.get("startDate_docvalues_string");
        if(startDate != null)
          oSeaportFacility.setStartDate(startDate);
      }

      if(saves.contains("transportServices")) {
        String transportServices = (String)doc.get("transportServices_docvalues_string");
        if(transportServices != null)
          oSeaportFacility.setTransportServices(transportServices);
      }

      if(saves.contains("typeOfPort")) {
        String typeOfPort = (String)doc.get("typeOfPort_docvalues_string");
        if(typeOfPort != null)
          oSeaportFacility.setTypeOfPort(typeOfPort);
      }

      if(saves.contains("webSite")) {
        String webSite = (String)doc.get("webSite_docvalues_string");
        if(webSite != null)
          oSeaportFacility.setWebSite(webSite);
      }
    }

    super.populateMapModel(doc);
  }

  public void indexSeaportFacility(JsonObject doc) {
    if(address != null) {
      doc.put("address_docvalues_string", address.encode());
    }
    if(alternateName != null) {
      doc.put("alternateName_docvalues_string", alternateName);
    }
    if(authorizedPropulsion != null) {
      doc.put("authorizedPropulsion_docvalues_string", authorizedPropulsion.encode());
    }
    if(boatSupplyingServices != null) {
      doc.put("boatSupplyingServices_docvalues_string", boatSupplyingServices.encode());
    }
    if(contactPoint != null) {
      doc.put("contactPoint_docvalues_string", contactPoint.encode());
    }
    if(contractingAuthority != null) {
      doc.put("contractingAuthority_docvalues_string", contractingAuthority);
    }
    if(contractingCompany != null) {
      doc.put("contractingCompany_docvalues_string", contractingCompany);
    }
    if(currencyAccepted != null) {
      doc.put("currencyAccepted_docvalues_string", currencyAccepted.encode());
    }
    if(dataProvider != null) {
      doc.put("dataProvider_docvalues_string", dataProvider);
    }
    if(dateCreated != null) {
      doc.put("dateCreated_docvalues_string", dateCreated);
    }
    if(dateLastReported != null) {
      doc.put("dateLastReported_docvalues_string", dateLastReported);
    }
    if(dateModified != null) {
      doc.put("dateModified_docvalues_string", dateModified);
    }
    if(electricTransport != null) {
      doc.put("electricTransport_docvalues_string", electricTransport.encode());
    }
    if(endDate != null) {
      doc.put("endDate_docvalues_string", endDate);
    }
    if(facilities != null) {
      doc.put("facilities_docvalues_string", facilities.encode());
    }
    if(maxDraft != null) {
      doc.put("maxDraft_docvalues_string", maxDraft.toPlainString());
    }
    if(maxLength != null) {
      doc.put("maxLength_docvalues_string", maxLength.toPlainString());
    }
    if(maxTonnage != null) {
      doc.put("maxTonnage_docvalues_string", maxTonnage.toPlainString());
    }
    if(maxWidth != null) {
      doc.put("maxWidth_docvalues_string", maxWidth.toPlainString());
    }
    if(minLength != null) {
      doc.put("minLength_docvalues_string", minLength.toPlainString());
    }
    if(nearbyServices != null) {
      doc.put("nearbyServices_docvalues_string", nearbyServices.encode());
    }
    if(numberOfPlace != null) {
      doc.put("numberOfPlace_docvalues_string", numberOfPlace.toPlainString());
    }
    if(openingHours != null) {
      doc.put("openingHours_docvalues_string", openingHours);
    }
    if(openingHoursSpecification != null) {
      doc.put("openingHoursSpecification_docvalues_string", openingHoursSpecification.encode());
    }
    if(owner != null) {
      doc.put("owner_docvalues_string", owner.encode());
    }
    if(paymentAccepted != null) {
      doc.put("paymentAccepted_docvalues_string", paymentAccepted.encode());
    }
    if(portServicesProvided != null) {
      doc.put("portServicesProvided_docvalues_string", portServicesProvided.encode());
    }
    if(refBoatAuthorized != null) {
      doc.put("refBoatAuthorized_docvalues_string", refBoatAuthorized.encode());
    }
    if(refBoatPlaceAvailable != null) {
      doc.put("refBoatPlaceAvailable_docvalues_string", refBoatPlaceAvailable.encode());
    }
    if(refBoatPlacePricing != null) {
      doc.put("refBoatPlacePricing_docvalues_string", refBoatPlacePricing.encode());
    }
    if(refDevice != null) {
      doc.put("refDevice_docvalues_string", refDevice);
    }
    if(refPointOfInterest != null) {
      doc.put("refPointOfInterest_docvalues_string", refPointOfInterest);
    }
    if(rentalSaleServices != null) {
      doc.put("rentalSaleServices_docvalues_string", rentalSaleServices.encode());
    }
    if(routeType != null) {
      doc.put("routeType_docvalues_string", routeType.encode());
    }
    if(seeAlso != null) {
      doc.put("seeAlso_docvalues_string", seeAlso);
    }
    if(source != null) {
      doc.put("source_docvalues_string", source);
    }
    if(startDate != null) {
      doc.put("startDate_docvalues_string", startDate);
    }
    if(transportServices != null) {
      doc.put("transportServices_docvalues_string", transportServices.encode());
    }
    if(typeOfPort != null) {
      doc.put("typeOfPort_docvalues_string", typeOfPort.encode());
    }
    if(webSite != null) {
      doc.put("webSite_docvalues_string", webSite);
    }
    super.indexMapModel(doc);

	}

  public static String varStoredSeaportFacility(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "authorizedPropulsion":
        return "authorizedPropulsion_docvalues_string";
      case "boatSupplyingServices":
        return "boatSupplyingServices_docvalues_string";
      case "contactPoint":
        return "contactPoint_docvalues_string";
      case "contractingAuthority":
        return "contractingAuthority_docvalues_string";
      case "contractingCompany":
        return "contractingCompany_docvalues_string";
      case "currencyAccepted":
        return "currencyAccepted_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateLastReported":
        return "dateLastReported_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "electricTransport":
        return "electricTransport_docvalues_string";
      case "endDate":
        return "endDate_docvalues_string";
      case "facilities":
        return "facilities_docvalues_string";
      case "maxDraft":
        return "maxDraft_docvalues_string";
      case "maxLength":
        return "maxLength_docvalues_string";
      case "maxTonnage":
        return "maxTonnage_docvalues_string";
      case "maxWidth":
        return "maxWidth_docvalues_string";
      case "minLength":
        return "minLength_docvalues_string";
      case "nearbyServices":
        return "nearbyServices_docvalues_string";
      case "numberOfPlace":
        return "numberOfPlace_docvalues_string";
      case "openingHours":
        return "openingHours_docvalues_string";
      case "openingHoursSpecification":
        return "openingHoursSpecification_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "paymentAccepted":
        return "paymentAccepted_docvalues_string";
      case "portServicesProvided":
        return "portServicesProvided_docvalues_string";
      case "refBoatAuthorized":
        return "refBoatAuthorized_docvalues_string";
      case "refBoatPlaceAvailable":
        return "refBoatPlaceAvailable_docvalues_string";
      case "refBoatPlacePricing":
        return "refBoatPlacePricing_docvalues_string";
      case "refDevice":
        return "refDevice_docvalues_string";
      case "refPointOfInterest":
        return "refPointOfInterest_docvalues_string";
      case "rentalSaleServices":
        return "rentalSaleServices_docvalues_string";
      case "routeType":
        return "routeType_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "startDate":
        return "startDate_docvalues_string";
      case "transportServices":
        return "transportServices_docvalues_string";
      case "typeOfPort":
        return "typeOfPort_docvalues_string";
      case "webSite":
        return "webSite_docvalues_string";
      default:
        return MapModel.varStoredMapModel(entityVar);
    }
  }

  public static String varIndexedSeaportFacility(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "authorizedPropulsion":
        return "authorizedPropulsion_docvalues_string";
      case "boatSupplyingServices":
        return "boatSupplyingServices_docvalues_string";
      case "contactPoint":
        return "contactPoint_docvalues_string";
      case "contractingAuthority":
        return "contractingAuthority_docvalues_string";
      case "contractingCompany":
        return "contractingCompany_docvalues_string";
      case "currencyAccepted":
        return "currencyAccepted_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateLastReported":
        return "dateLastReported_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "electricTransport":
        return "electricTransport_docvalues_string";
      case "endDate":
        return "endDate_docvalues_string";
      case "facilities":
        return "facilities_docvalues_string";
      case "maxDraft":
        return "maxDraft_docvalues_string";
      case "maxLength":
        return "maxLength_docvalues_string";
      case "maxTonnage":
        return "maxTonnage_docvalues_string";
      case "maxWidth":
        return "maxWidth_docvalues_string";
      case "minLength":
        return "minLength_docvalues_string";
      case "nearbyServices":
        return "nearbyServices_docvalues_string";
      case "numberOfPlace":
        return "numberOfPlace_docvalues_string";
      case "openingHours":
        return "openingHours_docvalues_string";
      case "openingHoursSpecification":
        return "openingHoursSpecification_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "paymentAccepted":
        return "paymentAccepted_docvalues_string";
      case "portServicesProvided":
        return "portServicesProvided_docvalues_string";
      case "refBoatAuthorized":
        return "refBoatAuthorized_docvalues_string";
      case "refBoatPlaceAvailable":
        return "refBoatPlaceAvailable_docvalues_string";
      case "refBoatPlacePricing":
        return "refBoatPlacePricing_docvalues_string";
      case "refDevice":
        return "refDevice_docvalues_string";
      case "refPointOfInterest":
        return "refPointOfInterest_docvalues_string";
      case "rentalSaleServices":
        return "rentalSaleServices_docvalues_string";
      case "routeType":
        return "routeType_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "startDate":
        return "startDate_docvalues_string";
      case "transportServices":
        return "transportServices_docvalues_string";
      case "typeOfPort":
        return "typeOfPort_docvalues_string";
      case "webSite":
        return "webSite_docvalues_string";
      default:
        return MapModel.varIndexedMapModel(entityVar);
    }
  }

  public static String searchVarSeaportFacility(String searchVar) {
    switch(searchVar) {
      case "address_docvalues_string":
        return "address";
      case "alternateName_docvalues_string":
        return "alternateName";
      case "authorizedPropulsion_docvalues_string":
        return "authorizedPropulsion";
      case "boatSupplyingServices_docvalues_string":
        return "boatSupplyingServices";
      case "contactPoint_docvalues_string":
        return "contactPoint";
      case "contractingAuthority_docvalues_string":
        return "contractingAuthority";
      case "contractingCompany_docvalues_string":
        return "contractingCompany";
      case "currencyAccepted_docvalues_string":
        return "currencyAccepted";
      case "dataProvider_docvalues_string":
        return "dataProvider";
      case "dateCreated_docvalues_string":
        return "dateCreated";
      case "dateLastReported_docvalues_string":
        return "dateLastReported";
      case "dateModified_docvalues_string":
        return "dateModified";
      case "electricTransport_docvalues_string":
        return "electricTransport";
      case "endDate_docvalues_string":
        return "endDate";
      case "facilities_docvalues_string":
        return "facilities";
      case "maxDraft_docvalues_string":
        return "maxDraft";
      case "maxLength_docvalues_string":
        return "maxLength";
      case "maxTonnage_docvalues_string":
        return "maxTonnage";
      case "maxWidth_docvalues_string":
        return "maxWidth";
      case "minLength_docvalues_string":
        return "minLength";
      case "nearbyServices_docvalues_string":
        return "nearbyServices";
      case "numberOfPlace_docvalues_string":
        return "numberOfPlace";
      case "openingHours_docvalues_string":
        return "openingHours";
      case "openingHoursSpecification_docvalues_string":
        return "openingHoursSpecification";
      case "owner_docvalues_string":
        return "owner";
      case "paymentAccepted_docvalues_string":
        return "paymentAccepted";
      case "portServicesProvided_docvalues_string":
        return "portServicesProvided";
      case "refBoatAuthorized_docvalues_string":
        return "refBoatAuthorized";
      case "refBoatPlaceAvailable_docvalues_string":
        return "refBoatPlaceAvailable";
      case "refBoatPlacePricing_docvalues_string":
        return "refBoatPlacePricing";
      case "refDevice_docvalues_string":
        return "refDevice";
      case "refPointOfInterest_docvalues_string":
        return "refPointOfInterest";
      case "rentalSaleServices_docvalues_string":
        return "rentalSaleServices";
      case "routeType_docvalues_string":
        return "routeType";
      case "seeAlso_docvalues_string":
        return "seeAlso";
      case "source_docvalues_string":
        return "source";
      case "startDate_docvalues_string":
        return "startDate";
      case "transportServices_docvalues_string":
        return "transportServices";
      case "typeOfPort_docvalues_string":
        return "typeOfPort";
      case "webSite_docvalues_string":
        return "webSite";
      default:
        return MapModel.searchVarMapModel(searchVar);
    }
  }

  public static String varSearchSeaportFacility(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSearchMapModel(entityVar);
    }
  }

  public static String varSuggestedSeaportFacility(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSuggestedMapModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeSeaportFacility(doc);
  }
  public void storeSeaportFacility(SolrResponse.Doc doc) {
    SeaportFacility oSeaportFacility = (SeaportFacility)this;
    SiteRequest siteRequest = oSeaportFacility.getSiteRequest_();

    oSeaportFacility.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setAuthorizedPropulsion(Optional.ofNullable(doc.get("authorizedPropulsion_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setBoatSupplyingServices(Optional.ofNullable(doc.get("boatSupplyingServices_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setContactPoint(Optional.ofNullable(doc.get("contactPoint_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setContractingAuthority(Optional.ofNullable(doc.get("contractingAuthority_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setContractingCompany(Optional.ofNullable(doc.get("contractingCompany_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setCurrencyAccepted(Optional.ofNullable(doc.get("currencyAccepted_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setDateLastReported(Optional.ofNullable(doc.get("dateLastReported_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setElectricTransport(Optional.ofNullable(doc.get("electricTransport_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setEndDate(Optional.ofNullable(doc.get("endDate_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setFacilities(Optional.ofNullable(doc.get("facilities_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setMaxDraft(Optional.ofNullable(doc.get("maxDraft_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setMaxLength(Optional.ofNullable(doc.get("maxLength_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setMaxTonnage(Optional.ofNullable(doc.get("maxTonnage_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setMaxWidth(Optional.ofNullable(doc.get("maxWidth_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setMinLength(Optional.ofNullable(doc.get("minLength_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setNearbyServices(Optional.ofNullable(doc.get("nearbyServices_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setNumberOfPlace(Optional.ofNullable(doc.get("numberOfPlace_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setOpeningHours(Optional.ofNullable(doc.get("openingHours_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setOpeningHoursSpecification(Optional.ofNullable(doc.get("openingHoursSpecification_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setPaymentAccepted(Optional.ofNullable(doc.get("paymentAccepted_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setPortServicesProvided(Optional.ofNullable(doc.get("portServicesProvided_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRefBoatAuthorized(Optional.ofNullable(doc.get("refBoatAuthorized_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRefBoatPlaceAvailable(Optional.ofNullable(doc.get("refBoatPlaceAvailable_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRefBoatPlacePricing(Optional.ofNullable(doc.get("refBoatPlacePricing_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRefDevice(Optional.ofNullable(doc.get("refDevice_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRefPointOfInterest(Optional.ofNullable(doc.get("refPointOfInterest_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRentalSaleServices(Optional.ofNullable(doc.get("rentalSaleServices_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setRouteType(Optional.ofNullable(doc.get("routeType_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setStartDate(Optional.ofNullable(doc.get("startDate_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setTransportServices(Optional.ofNullable(doc.get("transportServices_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setTypeOfPort(Optional.ofNullable(doc.get("typeOfPort_docvalues_string")).map(v -> v.toString()).orElse(null));
    oSeaportFacility.setWebSite(Optional.ofNullable(doc.get("webSite_docvalues_string")).map(v -> v.toString()).orElse(null));

    super.storeMapModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestSeaportFacility() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof SeaportFacility) {
      SeaportFacility original = (SeaportFacility)o;
      if(!Objects.equals(address, original.getAddress()))
        apiRequest.addVars("address");
      if(!Objects.equals(alternateName, original.getAlternateName()))
        apiRequest.addVars("alternateName");
      if(!Objects.equals(authorizedPropulsion, original.getAuthorizedPropulsion()))
        apiRequest.addVars("authorizedPropulsion");
      if(!Objects.equals(boatSupplyingServices, original.getBoatSupplyingServices()))
        apiRequest.addVars("boatSupplyingServices");
      if(!Objects.equals(contactPoint, original.getContactPoint()))
        apiRequest.addVars("contactPoint");
      if(!Objects.equals(contractingAuthority, original.getContractingAuthority()))
        apiRequest.addVars("contractingAuthority");
      if(!Objects.equals(contractingCompany, original.getContractingCompany()))
        apiRequest.addVars("contractingCompany");
      if(!Objects.equals(currencyAccepted, original.getCurrencyAccepted()))
        apiRequest.addVars("currencyAccepted");
      if(!Objects.equals(dataProvider, original.getDataProvider()))
        apiRequest.addVars("dataProvider");
      if(!Objects.equals(dateCreated, original.getDateCreated()))
        apiRequest.addVars("dateCreated");
      if(!Objects.equals(dateLastReported, original.getDateLastReported()))
        apiRequest.addVars("dateLastReported");
      if(!Objects.equals(dateModified, original.getDateModified()))
        apiRequest.addVars("dateModified");
      if(!Objects.equals(electricTransport, original.getElectricTransport()))
        apiRequest.addVars("electricTransport");
      if(!Objects.equals(endDate, original.getEndDate()))
        apiRequest.addVars("endDate");
      if(!Objects.equals(facilities, original.getFacilities()))
        apiRequest.addVars("facilities");
      if(!Objects.equals(maxDraft, original.getMaxDraft()) && maxDraft != null && original.getMaxDraft() != null && maxDraft.compareTo(original.getMaxDraft()) != 0)
        apiRequest.addVars("maxDraft");
      if(!Objects.equals(maxLength, original.getMaxLength()) && maxLength != null && original.getMaxLength() != null && maxLength.compareTo(original.getMaxLength()) != 0)
        apiRequest.addVars("maxLength");
      if(!Objects.equals(maxTonnage, original.getMaxTonnage()) && maxTonnage != null && original.getMaxTonnage() != null && maxTonnage.compareTo(original.getMaxTonnage()) != 0)
        apiRequest.addVars("maxTonnage");
      if(!Objects.equals(maxWidth, original.getMaxWidth()) && maxWidth != null && original.getMaxWidth() != null && maxWidth.compareTo(original.getMaxWidth()) != 0)
        apiRequest.addVars("maxWidth");
      if(!Objects.equals(minLength, original.getMinLength()) && minLength != null && original.getMinLength() != null && minLength.compareTo(original.getMinLength()) != 0)
        apiRequest.addVars("minLength");
      if(!Objects.equals(nearbyServices, original.getNearbyServices()))
        apiRequest.addVars("nearbyServices");
      if(!Objects.equals(numberOfPlace, original.getNumberOfPlace()) && numberOfPlace != null && original.getNumberOfPlace() != null && numberOfPlace.compareTo(original.getNumberOfPlace()) != 0)
        apiRequest.addVars("numberOfPlace");
      if(!Objects.equals(openingHours, original.getOpeningHours()))
        apiRequest.addVars("openingHours");
      if(!Objects.equals(openingHoursSpecification, original.getOpeningHoursSpecification()))
        apiRequest.addVars("openingHoursSpecification");
      if(!Objects.equals(owner, original.getOwner()))
        apiRequest.addVars("owner");
      if(!Objects.equals(paymentAccepted, original.getPaymentAccepted()))
        apiRequest.addVars("paymentAccepted");
      if(!Objects.equals(portServicesProvided, original.getPortServicesProvided()))
        apiRequest.addVars("portServicesProvided");
      if(!Objects.equals(refBoatAuthorized, original.getRefBoatAuthorized()))
        apiRequest.addVars("refBoatAuthorized");
      if(!Objects.equals(refBoatPlaceAvailable, original.getRefBoatPlaceAvailable()))
        apiRequest.addVars("refBoatPlaceAvailable");
      if(!Objects.equals(refBoatPlacePricing, original.getRefBoatPlacePricing()))
        apiRequest.addVars("refBoatPlacePricing");
      if(!Objects.equals(refDevice, original.getRefDevice()))
        apiRequest.addVars("refDevice");
      if(!Objects.equals(refPointOfInterest, original.getRefPointOfInterest()))
        apiRequest.addVars("refPointOfInterest");
      if(!Objects.equals(rentalSaleServices, original.getRentalSaleServices()))
        apiRequest.addVars("rentalSaleServices");
      if(!Objects.equals(routeType, original.getRouteType()))
        apiRequest.addVars("routeType");
      if(!Objects.equals(seeAlso, original.getSeeAlso()))
        apiRequest.addVars("seeAlso");
      if(!Objects.equals(source, original.getSource()))
        apiRequest.addVars("source");
      if(!Objects.equals(startDate, original.getStartDate()))
        apiRequest.addVars("startDate");
      if(!Objects.equals(transportServices, original.getTransportServices()))
        apiRequest.addVars("transportServices");
      if(!Objects.equals(typeOfPort, original.getTypeOfPort()))
        apiRequest.addVars("typeOfPort");
      if(!Objects.equals(webSite, original.getWebSite()))
        apiRequest.addVars("webSite");
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
    sb.append(Optional.ofNullable(authorizedPropulsion).map(v -> "authorizedPropulsion: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(boatSupplyingServices).map(v -> "boatSupplyingServices: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(contactPoint).map(v -> "contactPoint: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(contractingAuthority).map(v -> "contractingAuthority: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(contractingCompany).map(v -> "contractingCompany: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(currencyAccepted).map(v -> "currencyAccepted: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateLastReported).map(v -> "dateLastReported: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(electricTransport).map(v -> "electricTransport: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(endDate).map(v -> "endDate: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(facilities).map(v -> "facilities: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(maxDraft).map(v -> "maxDraft: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(maxLength).map(v -> "maxLength: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(maxTonnage).map(v -> "maxTonnage: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(maxWidth).map(v -> "maxWidth: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(minLength).map(v -> "minLength: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(nearbyServices).map(v -> "nearbyServices: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(numberOfPlace).map(v -> "numberOfPlace: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openingHours).map(v -> "openingHours: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(openingHoursSpecification).map(v -> "openingHoursSpecification: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(paymentAccepted).map(v -> "paymentAccepted: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(portServicesProvided).map(v -> "portServicesProvided: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(refBoatAuthorized).map(v -> "refBoatAuthorized: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(refBoatPlaceAvailable).map(v -> "refBoatPlaceAvailable: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(refBoatPlacePricing).map(v -> "refBoatPlacePricing: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(refDevice).map(v -> "refDevice: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(refPointOfInterest).map(v -> "refPointOfInterest: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(rentalSaleServices).map(v -> "rentalSaleServices: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(routeType).map(v -> "routeType: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(startDate).map(v -> "startDate: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(transportServices).map(v -> "transportServices: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(typeOfPort).map(v -> "typeOfPort: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(webSite).map(v -> "webSite: \"" + v + "\"\n" ).orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "SeaportFacility";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.seaportfacility.SeaportFacility";
  public static final String CLASS_AUTH_RESOURCE = "SEAPORTFACILITY";
  public static final String CLASS_API_ADDRESS_SeaportFacility = "smart-aquaculture-enUS-SeaportFacility";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_SeaportFacility;
  }
  public static final String VAR_address = "address";
  public static final String VAR_alternateName = "alternateName";
  public static final String VAR_authorizedPropulsion = "authorizedPropulsion";
  public static final String VAR_boatSupplyingServices = "boatSupplyingServices";
  public static final String VAR_contactPoint = "contactPoint";
  public static final String VAR_contractingAuthority = "contractingAuthority";
  public static final String VAR_contractingCompany = "contractingCompany";
  public static final String VAR_currencyAccepted = "currencyAccepted";
  public static final String VAR_dataProvider = "dataProvider";
  public static final String VAR_dateCreated = "dateCreated";
  public static final String VAR_dateLastReported = "dateLastReported";
  public static final String VAR_dateModified = "dateModified";
  public static final String VAR_electricTransport = "electricTransport";
  public static final String VAR_endDate = "endDate";
  public static final String VAR_facilities = "facilities";
  public static final String VAR_maxDraft = "maxDraft";
  public static final String VAR_maxLength = "maxLength";
  public static final String VAR_maxTonnage = "maxTonnage";
  public static final String VAR_maxWidth = "maxWidth";
  public static final String VAR_minLength = "minLength";
  public static final String VAR_nearbyServices = "nearbyServices";
  public static final String VAR_numberOfPlace = "numberOfPlace";
  public static final String VAR_openingHours = "openingHours";
  public static final String VAR_openingHoursSpecification = "openingHoursSpecification";
  public static final String VAR_owner = "owner";
  public static final String VAR_paymentAccepted = "paymentAccepted";
  public static final String VAR_portServicesProvided = "portServicesProvided";
  public static final String VAR_refBoatAuthorized = "refBoatAuthorized";
  public static final String VAR_refBoatPlaceAvailable = "refBoatPlaceAvailable";
  public static final String VAR_refBoatPlacePricing = "refBoatPlacePricing";
  public static final String VAR_refDevice = "refDevice";
  public static final String VAR_refPointOfInterest = "refPointOfInterest";
  public static final String VAR_rentalSaleServices = "rentalSaleServices";
  public static final String VAR_routeType = "routeType";
  public static final String VAR_seeAlso = "seeAlso";
  public static final String VAR_source = "source";
  public static final String VAR_startDate = "startDate";
  public static final String VAR_transportServices = "transportServices";
  public static final String VAR_typeOfPort = "typeOfPort";
  public static final String VAR_webSite = "webSite";

  public static List<String> varsQForClass() {
    return SeaportFacility.varsQSeaportFacility(new ArrayList<String>());
  }
  public static List<String> varsQSeaportFacility(List<String> vars) {
    MapModel.varsQMapModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return SeaportFacility.varsFqSeaportFacility(new ArrayList<String>());
  }
  public static List<String> varsFqSeaportFacility(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_alternateName);
    vars.add(VAR_authorizedPropulsion);
    vars.add(VAR_boatSupplyingServices);
    vars.add(VAR_contactPoint);
    vars.add(VAR_contractingAuthority);
    vars.add(VAR_contractingCompany);
    vars.add(VAR_currencyAccepted);
    vars.add(VAR_dataProvider);
    vars.add(VAR_dateCreated);
    vars.add(VAR_dateLastReported);
    vars.add(VAR_dateModified);
    vars.add(VAR_electricTransport);
    vars.add(VAR_endDate);
    vars.add(VAR_facilities);
    vars.add(VAR_maxDraft);
    vars.add(VAR_maxLength);
    vars.add(VAR_maxTonnage);
    vars.add(VAR_maxWidth);
    vars.add(VAR_minLength);
    vars.add(VAR_nearbyServices);
    vars.add(VAR_numberOfPlace);
    vars.add(VAR_openingHours);
    vars.add(VAR_openingHoursSpecification);
    vars.add(VAR_owner);
    vars.add(VAR_paymentAccepted);
    vars.add(VAR_portServicesProvided);
    vars.add(VAR_refBoatAuthorized);
    vars.add(VAR_refBoatPlaceAvailable);
    vars.add(VAR_refBoatPlacePricing);
    vars.add(VAR_refDevice);
    vars.add(VAR_refPointOfInterest);
    vars.add(VAR_rentalSaleServices);
    vars.add(VAR_routeType);
    vars.add(VAR_seeAlso);
    vars.add(VAR_source);
    vars.add(VAR_startDate);
    vars.add(VAR_transportServices);
    vars.add(VAR_typeOfPort);
    vars.add(VAR_webSite);
    MapModel.varsFqMapModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return SeaportFacility.varsRangeSeaportFacility(new ArrayList<String>());
  }
  public static List<String> varsRangeSeaportFacility(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_authorizedPropulsion);
    vars.add(VAR_boatSupplyingServices);
    vars.add(VAR_contactPoint);
    vars.add(VAR_currencyAccepted);
    vars.add(VAR_electricTransport);
    vars.add(VAR_facilities);
    vars.add(VAR_maxDraft);
    vars.add(VAR_maxLength);
    vars.add(VAR_maxTonnage);
    vars.add(VAR_maxWidth);
    vars.add(VAR_minLength);
    vars.add(VAR_nearbyServices);
    vars.add(VAR_numberOfPlace);
    vars.add(VAR_openingHoursSpecification);
    vars.add(VAR_owner);
    vars.add(VAR_paymentAccepted);
    vars.add(VAR_portServicesProvided);
    vars.add(VAR_refBoatAuthorized);
    vars.add(VAR_refBoatPlaceAvailable);
    vars.add(VAR_refBoatPlacePricing);
    vars.add(VAR_rentalSaleServices);
    vars.add(VAR_routeType);
    vars.add(VAR_transportServices);
    vars.add(VAR_typeOfPort);
    MapModel.varsRangeMapModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_address = "address";
  public static final String DISPLAY_NAME_alternateName = "alternate name";
  public static final String DISPLAY_NAME_authorizedPropulsion = "authorized propulsion";
  public static final String DISPLAY_NAME_boatSupplyingServices = "boat supplying services";
  public static final String DISPLAY_NAME_contactPoint = "contact point";
  public static final String DISPLAY_NAME_contractingAuthority = "contracting authority";
  public static final String DISPLAY_NAME_contractingCompany = "contracting company";
  public static final String DISPLAY_NAME_currencyAccepted = "currency accepted";
  public static final String DISPLAY_NAME_dataProvider = "data provider";
  public static final String DISPLAY_NAME_dateCreated = "date created";
  public static final String DISPLAY_NAME_dateLastReported = "date last reported";
  public static final String DISPLAY_NAME_dateModified = "date modified";
  public static final String DISPLAY_NAME_electricTransport = "electric transport";
  public static final String DISPLAY_NAME_endDate = "end date";
  public static final String DISPLAY_NAME_facilities = "facilities";
  public static final String DISPLAY_NAME_maxDraft = "max draft";
  public static final String DISPLAY_NAME_maxLength = "max length";
  public static final String DISPLAY_NAME_maxTonnage = "max tonnage";
  public static final String DISPLAY_NAME_maxWidth = "max width";
  public static final String DISPLAY_NAME_minLength = "min length";
  public static final String DISPLAY_NAME_nearbyServices = "nearby services";
  public static final String DISPLAY_NAME_numberOfPlace = "number of place";
  public static final String DISPLAY_NAME_openingHours = "opening hours";
  public static final String DISPLAY_NAME_openingHoursSpecification = "opening hours specification";
  public static final String DISPLAY_NAME_owner = "owner";
  public static final String DISPLAY_NAME_paymentAccepted = "payment accepted";
  public static final String DISPLAY_NAME_portServicesProvided = "port services provided";
  public static final String DISPLAY_NAME_refBoatAuthorized = "ref boat authorized";
  public static final String DISPLAY_NAME_refBoatPlaceAvailable = "ref boat place available";
  public static final String DISPLAY_NAME_refBoatPlacePricing = "ref boat place pricing";
  public static final String DISPLAY_NAME_refDevice = "ref device";
  public static final String DISPLAY_NAME_refPointOfInterest = "ref point of interest";
  public static final String DISPLAY_NAME_rentalSaleServices = "rental sale services";
  public static final String DISPLAY_NAME_routeType = "route type";
  public static final String DISPLAY_NAME_seeAlso = "see also";
  public static final String DISPLAY_NAME_source = "source";
  public static final String DISPLAY_NAME_startDate = "start date";
  public static final String DISPLAY_NAME_transportServices = "transport services";
  public static final String DISPLAY_NAME_typeOfPort = "type of port";
  public static final String DISPLAY_NAME_webSite = "web site";

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
    return SeaportFacility.NameAdjectiveSingular_enUS;
  }

  @Override
  public String descriptionForClass() {
    return null;
  }

  @Override
  public String frFRStringFormatUrlEditPageForClass() {
    return "%s/fr-fr/edition/installations-portuaires/%s";
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/seaport-facilities/%s";
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
    return SeaportFacility.displayNameSeaportFacility(var);
  }
  public static String displayNameSeaportFacility(String var) {
    switch(var) {
    case VAR_address:
      return DISPLAY_NAME_address;
    case VAR_alternateName:
      return DISPLAY_NAME_alternateName;
    case VAR_authorizedPropulsion:
      return DISPLAY_NAME_authorizedPropulsion;
    case VAR_boatSupplyingServices:
      return DISPLAY_NAME_boatSupplyingServices;
    case VAR_contactPoint:
      return DISPLAY_NAME_contactPoint;
    case VAR_contractingAuthority:
      return DISPLAY_NAME_contractingAuthority;
    case VAR_contractingCompany:
      return DISPLAY_NAME_contractingCompany;
    case VAR_currencyAccepted:
      return DISPLAY_NAME_currencyAccepted;
    case VAR_dataProvider:
      return DISPLAY_NAME_dataProvider;
    case VAR_dateCreated:
      return DISPLAY_NAME_dateCreated;
    case VAR_dateLastReported:
      return DISPLAY_NAME_dateLastReported;
    case VAR_dateModified:
      return DISPLAY_NAME_dateModified;
    case VAR_electricTransport:
      return DISPLAY_NAME_electricTransport;
    case VAR_endDate:
      return DISPLAY_NAME_endDate;
    case VAR_facilities:
      return DISPLAY_NAME_facilities;
    case VAR_maxDraft:
      return DISPLAY_NAME_maxDraft;
    case VAR_maxLength:
      return DISPLAY_NAME_maxLength;
    case VAR_maxTonnage:
      return DISPLAY_NAME_maxTonnage;
    case VAR_maxWidth:
      return DISPLAY_NAME_maxWidth;
    case VAR_minLength:
      return DISPLAY_NAME_minLength;
    case VAR_nearbyServices:
      return DISPLAY_NAME_nearbyServices;
    case VAR_numberOfPlace:
      return DISPLAY_NAME_numberOfPlace;
    case VAR_openingHours:
      return DISPLAY_NAME_openingHours;
    case VAR_openingHoursSpecification:
      return DISPLAY_NAME_openingHoursSpecification;
    case VAR_owner:
      return DISPLAY_NAME_owner;
    case VAR_paymentAccepted:
      return DISPLAY_NAME_paymentAccepted;
    case VAR_portServicesProvided:
      return DISPLAY_NAME_portServicesProvided;
    case VAR_refBoatAuthorized:
      return DISPLAY_NAME_refBoatAuthorized;
    case VAR_refBoatPlaceAvailable:
      return DISPLAY_NAME_refBoatPlaceAvailable;
    case VAR_refBoatPlacePricing:
      return DISPLAY_NAME_refBoatPlacePricing;
    case VAR_refDevice:
      return DISPLAY_NAME_refDevice;
    case VAR_refPointOfInterest:
      return DISPLAY_NAME_refPointOfInterest;
    case VAR_rentalSaleServices:
      return DISPLAY_NAME_rentalSaleServices;
    case VAR_routeType:
      return DISPLAY_NAME_routeType;
    case VAR_seeAlso:
      return DISPLAY_NAME_seeAlso;
    case VAR_source:
      return DISPLAY_NAME_source;
    case VAR_startDate:
      return DISPLAY_NAME_startDate;
    case VAR_transportServices:
      return DISPLAY_NAME_transportServices;
    case VAR_typeOfPort:
      return DISPLAY_NAME_typeOfPort;
    case VAR_webSite:
      return DISPLAY_NAME_webSite;
    default:
      return MapModel.displayNameMapModel(var);
    }
  }

  public static String descriptionSeaportFacility(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_address:
      return "The mailing address";
    case VAR_alternateName:
      return "An alternative name for this item";
    case VAR_authorizedPropulsion:
      return "A Type of propulsion authorized to enter in the harbor. A combination of motor, sail, electric, oar, nuclear, lng, lpg, other";
    case VAR_boatSupplyingServices:
      return "Description of the complementary supplying services for the boat offered by professionals working on or near the harbor. A combination of guarding, fuelStation, fuelTankerTruck , drinkingWaterTankerTruck, provisioning, dryFairing, waterFairing, repair, expertise, gangways, liftingCranes, towing, wasteWaterPumping, boatConveying, boatTransfer, other";
    case VAR_contactPoint:
      return "https://schema.org/ContactPoint";
    case VAR_contractingAuthority:
      return "Name of the contracting authority";
    case VAR_contractingCompany:
      return "The Contracting Company responsible of the management of the port";
    case VAR_currencyAccepted:
      return "A combination of a list of active codes defined in the model [Norme ISO 4217](http://en.wikipedia.org/wiki/ISO_4217), [Crypto Currencies](https://en.wikipedia.org/wiki/List_of_cryptocurrencies) , [Exchange Trading System](https://en.wikipedia.org/wiki/Local_exchange_trading_system";
    case VAR_dataProvider:
      return "A sequence of characters identifying the provider of the harmonised data entity";
    case VAR_dateCreated:
      return "Entity creation timestamp. This will usually be allocated by the storage platform";
    case VAR_dateLastReported:
      return "A timestamp which denotes the last time when a flow successfully reported data. The date and time of this Repository in ISO8601 UTCformat";
    case VAR_dateModified:
      return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
    case VAR_electricTransport:
      return " List of the different types of electric transport proposed by the city. A combination of electricCar, electricBycicle, electricMotorBike, electricScooter ";
    case VAR_endDate:
      return "The end date and time of the item (in ISO 8601 date format).";
    case VAR_facilities:
      return "Description of the proposed facilities on the harbor. A combination of : toilets, showers, laundry, telephone, dustbins, dumpsters, container, selectiveSortingWaste, electricTerminal, waterTerminal, indoorRoomReservation, wifi, other";
    case VAR_maxDraft:
      return "A Maximum draft allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter";
    case VAR_maxLength:
      return "A Maximum length allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter";
    case VAR_maxTonnage:
      return "Maximum tonnage authorized to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **TNE** represents Tonne Metric";
    case VAR_maxWidth:
      return "A Maximum width allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter";
    case VAR_minLength:
      return "A Minimum length allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **MTR** represents Meter";
    case VAR_nearbyServices:
      return "Description of the additional services on the geographical area on or near the harbor. A combination of :touristOffice, fittingsStores, travelAgency, exchangeOffice, medicalOffice, pharmacy, groceryStores, restaurants, presses, bar, shops, seaExcursions, cityTour, touristicExcursions, others";
    case VAR_numberOfPlace:
      return "Total number of place in the harbor";
    case VAR_openingHours:
      return "The general opening hours for a business. Opening hours can be specified as a weekly time range, starting with days, then times per day. Multiple days can be listed with commas ',' separating each day. Day or time ranges are specified using a hyphen '-'. Days are specified using the following two-letter combinations: Mo, Tu, We, Th, Fr, Sa, Su. Times are specified using 24:00 format. For example, 3pm is specified as 15:00, 10am as 10:00. Here is an example: <time itemprop='openingHours' datetime='Tu,Th 16:00-20:00'>Tuesdays and Thursdays 4-8pm</time>. If a business is open 7 days a week, then it can be specified as <time itemprop='openingHours' datetime='Mo-Su'>Monday through Sunday, all day</time>";
    case VAR_openingHoursSpecification:
      return "A structured value providing information about the opening hours of a place or a certain service inside a place";
    case VAR_owner:
      return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
    case VAR_paymentAccepted:
      return "Accepted payment. A combination of a list of active codes defined in the model : Cash, CreditCard, CryptoCurrency, other";
    case VAR_portServicesProvided:
      return "Description of the services provided directly by the harbor. A combination of : harborOffice, weather, customsServices, porters, boatRingRental, mooringAssistance, handlingAssistance, publicWifi, privateWifi, other";
    case VAR_refBoatAuthorized:
      return "Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatAuthorized/doc/spec.md)";
    case VAR_refBoatPlaceAvailable:
      return "Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlaceAvailable/doc/spec.md)";
    case VAR_refBoatPlacePricing:
      return "Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlacePricing/doc/spec.md)";
    case VAR_refDevice:
      return "Reference to the Main Entity [Device](https://github.com/smart-data-models/dataModel.Device/blob/master/Device/doc/spec.md) if used as second link";
    case VAR_refPointOfInterest:
      return "Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the Repository";
    case VAR_rentalSaleServices:
      return "ADescription of services provided by professional sales or rental agencies on the geographical area on or near the harbor. A combination of : boatRental, boatSale, jetSkiRental, jetSkiSale, carRental, luxuryCarRental, vanRental, bikeRental, scooterRental, Caddie, palletTransport, other";
    case VAR_routeType:
      return "List of the different types of urban transport Mode (Metro, Bus, Tram, ...) from the urban transport Mode GFTS standard [STOP](https://developers.google.com/transit/gtfs/reference/#stopstxt). A combination of values composed only of the attribute 'description' tram(0), metro(1), train(2), bus(3), ferry(4), cableTram(5), cableCar(6), funicular(7), trolleybus(11), monorail(12)";
    case VAR_seeAlso:
      return "list of uri pointing to additional resources about the item";
    case VAR_source:
      return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
    case VAR_startDate:
      return "The start date and time of the item (in ISO 8601 date format).";
    case VAR_transportServices:
      return "Description of the services provided for dedicated transport and shuttle services. A combination of : parking, shuttlesToAirport, shuttlesToRailway, internalShuttles, taxis, heliport, other";
    case VAR_typeOfPort:
      return "A Type of harbor. A combination of : marina, merchandise, cruise, ferry, passengers, yachting, fishing, military, river, other";
    case VAR_webSite:
      return "Link to the official website of the harbor for more information";
      default:
        return MapModel.descriptionMapModel(var);
    }
  }

  public static String classSimpleNameSeaportFacility(String var) {
    switch(var) {
    case VAR_address:
      return "JsonObject";
    case VAR_alternateName:
      return "String";
    case VAR_authorizedPropulsion:
      return "JsonObject";
    case VAR_boatSupplyingServices:
      return "JsonObject";
    case VAR_contactPoint:
      return "JsonObject";
    case VAR_contractingAuthority:
      return "String";
    case VAR_contractingCompany:
      return "String";
    case VAR_currencyAccepted:
      return "JsonObject";
    case VAR_dataProvider:
      return "String";
    case VAR_dateCreated:
      return "String";
    case VAR_dateLastReported:
      return "String";
    case VAR_dateModified:
      return "String";
    case VAR_electricTransport:
      return "JsonObject";
    case VAR_endDate:
      return "String";
    case VAR_facilities:
      return "JsonObject";
    case VAR_maxDraft:
      return "BigDecimal";
    case VAR_maxLength:
      return "BigDecimal";
    case VAR_maxTonnage:
      return "BigDecimal";
    case VAR_maxWidth:
      return "BigDecimal";
    case VAR_minLength:
      return "BigDecimal";
    case VAR_nearbyServices:
      return "JsonObject";
    case VAR_numberOfPlace:
      return "BigDecimal";
    case VAR_openingHours:
      return "String";
    case VAR_openingHoursSpecification:
      return "JsonObject";
    case VAR_owner:
      return "JsonObject";
    case VAR_paymentAccepted:
      return "JsonObject";
    case VAR_portServicesProvided:
      return "JsonObject";
    case VAR_refBoatAuthorized:
      return "JsonObject";
    case VAR_refBoatPlaceAvailable:
      return "JsonObject";
    case VAR_refBoatPlacePricing:
      return "JsonObject";
    case VAR_refDevice:
      return "String";
    case VAR_refPointOfInterest:
      return "String";
    case VAR_rentalSaleServices:
      return "JsonObject";
    case VAR_routeType:
      return "JsonObject";
    case VAR_seeAlso:
      return "String";
    case VAR_source:
      return "String";
    case VAR_startDate:
      return "String";
    case VAR_transportServices:
      return "JsonObject";
    case VAR_typeOfPort:
      return "JsonObject";
    case VAR_webSite:
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
    case VAR_authorizedPropulsion:
      return "Property";
    case VAR_boatSupplyingServices:
      return "Property";
    case VAR_contactPoint:
      return "Property";
    case VAR_contractingAuthority:
      return "Property";
    case VAR_contractingCompany:
      return "Property";
    case VAR_currencyAccepted:
      return "Property";
    case VAR_dataProvider:
      return "Property";
    case VAR_dateCreated:
      return "Property";
    case VAR_dateLastReported:
      return "Property";
    case VAR_dateModified:
      return "Property";
    case VAR_electricTransport:
      return "Property";
    case VAR_endDate:
      return "Property";
    case VAR_facilities:
      return "Property";
    case VAR_maxDraft:
      return "Property";
    case VAR_maxLength:
      return "Property";
    case VAR_maxTonnage:
      return "Property";
    case VAR_maxWidth:
      return "Property";
    case VAR_minLength:
      return "Property";
    case VAR_nearbyServices:
      return "Property";
    case VAR_numberOfPlace:
      return "Property";
    case VAR_openingHours:
      return "Property";
    case VAR_openingHoursSpecification:
      return "Property";
    case VAR_owner:
      return "Property";
    case VAR_paymentAccepted:
      return "Property";
    case VAR_portServicesProvided:
      return "Property";
    case VAR_refBoatAuthorized:
      return "Property";
    case VAR_refBoatPlaceAvailable:
      return "Property";
    case VAR_refBoatPlacePricing:
      return "Property";
    case VAR_refDevice:
      return "Property";
    case VAR_refPointOfInterest:
      return "Property";
    case VAR_rentalSaleServices:
      return "Property";
    case VAR_routeType:
      return "Property";
    case VAR_seeAlso:
      return "Property";
    case VAR_source:
      return "Property";
    case VAR_startDate:
      return "Property";
    case VAR_transportServices:
      return "Property";
    case VAR_typeOfPort:
      return "Property";
    case VAR_webSite:
      return "Property";
      default:
        return MapModel.ngsiType(var);
    }
  }

  public static Object ngsiSeaportFacility(String var, SeaportFacility o) {
    switch(var) {
    case VAR_address:
      return o.getAddress();
    case VAR_alternateName:
      return o.getAlternateName();
    case VAR_authorizedPropulsion:
      return o.getAuthorizedPropulsion();
    case VAR_boatSupplyingServices:
      return o.getBoatSupplyingServices();
    case VAR_contactPoint:
      return o.getContactPoint();
    case VAR_contractingAuthority:
      return o.getContractingAuthority();
    case VAR_contractingCompany:
      return o.getContractingCompany();
    case VAR_currencyAccepted:
      return o.getCurrencyAccepted();
    case VAR_dataProvider:
      return o.getDataProvider();
    case VAR_dateCreated:
      return o.getDateCreated();
    case VAR_dateLastReported:
      return o.getDateLastReported();
    case VAR_dateModified:
      return o.getDateModified();
    case VAR_electricTransport:
      return o.getElectricTransport();
    case VAR_endDate:
      return o.getEndDate();
    case VAR_facilities:
      return o.getFacilities();
    case VAR_maxDraft:
      return o.getMaxDraft();
    case VAR_maxLength:
      return o.getMaxLength();
    case VAR_maxTonnage:
      return o.getMaxTonnage();
    case VAR_maxWidth:
      return o.getMaxWidth();
    case VAR_minLength:
      return o.getMinLength();
    case VAR_nearbyServices:
      return o.getNearbyServices();
    case VAR_numberOfPlace:
      return o.getNumberOfPlace();
    case VAR_openingHours:
      return o.getOpeningHours();
    case VAR_openingHoursSpecification:
      return o.getOpeningHoursSpecification();
    case VAR_owner:
      return o.getOwner();
    case VAR_paymentAccepted:
      return o.getPaymentAccepted();
    case VAR_portServicesProvided:
      return o.getPortServicesProvided();
    case VAR_refBoatAuthorized:
      return o.getRefBoatAuthorized();
    case VAR_refBoatPlaceAvailable:
      return o.getRefBoatPlaceAvailable();
    case VAR_refBoatPlacePricing:
      return o.getRefBoatPlacePricing();
    case VAR_refDevice:
      return o.getRefDevice();
    case VAR_refPointOfInterest:
      return o.getRefPointOfInterest();
    case VAR_rentalSaleServices:
      return o.getRentalSaleServices();
    case VAR_routeType:
      return o.getRouteType();
    case VAR_seeAlso:
      return o.getSeeAlso();
    case VAR_source:
      return o.getSource();
    case VAR_startDate:
      return o.getStartDate();
    case VAR_transportServices:
      return o.getTransportServices();
    case VAR_typeOfPort:
      return o.getTypeOfPort();
    case VAR_webSite:
      return o.getWebSite();
      default:
        return ngsiMapModel(var, o);
    }
  }

  public static Integer htmColumnSeaportFacility(String var) {
    switch(var) {
      default:
        return MapModel.htmColumnMapModel(var);
    }
  }

  public static Integer htmRowSeaportFacility(String var) {
    switch(var) {
    case VAR_address:
      return 6;
    case VAR_alternateName:
      return 6;
    case VAR_authorizedPropulsion:
      return 6;
    case VAR_boatSupplyingServices:
      return 6;
    case VAR_contactPoint:
      return 6;
    case VAR_contractingAuthority:
      return 6;
    case VAR_contractingCompany:
      return 6;
    case VAR_currencyAccepted:
      return 6;
    case VAR_dataProvider:
      return 6;
    case VAR_dateCreated:
      return 6;
    case VAR_dateLastReported:
      return 6;
    case VAR_dateModified:
      return 6;
    case VAR_electricTransport:
      return 6;
    case VAR_endDate:
      return 6;
    case VAR_facilities:
      return 6;
    case VAR_maxDraft:
      return 6;
    case VAR_maxLength:
      return 6;
    case VAR_maxTonnage:
      return 6;
    case VAR_maxWidth:
      return 6;
    case VAR_minLength:
      return 6;
    case VAR_nearbyServices:
      return 6;
    case VAR_numberOfPlace:
      return 6;
    case VAR_openingHours:
      return 6;
    case VAR_openingHoursSpecification:
      return 6;
    case VAR_owner:
      return 6;
    case VAR_paymentAccepted:
      return 6;
    case VAR_portServicesProvided:
      return 6;
    case VAR_refBoatAuthorized:
      return 6;
    case VAR_refBoatPlaceAvailable:
      return 6;
    case VAR_refBoatPlacePricing:
      return 6;
    case VAR_refDevice:
      return 6;
    case VAR_refPointOfInterest:
      return 6;
    case VAR_rentalSaleServices:
      return 6;
    case VAR_routeType:
      return 6;
    case VAR_seeAlso:
      return 6;
    case VAR_source:
      return 6;
    case VAR_startDate:
      return 6;
    case VAR_transportServices:
      return 6;
    case VAR_typeOfPort:
      return 6;
    case VAR_webSite:
      return 6;
      default:
        return MapModel.htmRowMapModel(var);
    }
  }

  public static Integer htmCellSeaportFacility(String var) {
    switch(var) {
    case VAR_address:
      return 0;
    case VAR_alternateName:
      return 1;
    case VAR_authorizedPropulsion:
      return 2;
    case VAR_boatSupplyingServices:
      return 3;
    case VAR_contactPoint:
      return 4;
    case VAR_contractingAuthority:
      return 5;
    case VAR_contractingCompany:
      return 6;
    case VAR_currencyAccepted:
      return 7;
    case VAR_dataProvider:
      return 8;
    case VAR_dateCreated:
      return 9;
    case VAR_dateLastReported:
      return 10;
    case VAR_dateModified:
      return 11;
    case VAR_electricTransport:
      return 12;
    case VAR_endDate:
      return 13;
    case VAR_facilities:
      return 14;
    case VAR_maxDraft:
      return 15;
    case VAR_maxLength:
      return 16;
    case VAR_maxTonnage:
      return 17;
    case VAR_maxWidth:
      return 18;
    case VAR_minLength:
      return 19;
    case VAR_nearbyServices:
      return 20;
    case VAR_numberOfPlace:
      return 21;
    case VAR_openingHours:
      return 22;
    case VAR_openingHoursSpecification:
      return 23;
    case VAR_owner:
      return 24;
    case VAR_paymentAccepted:
      return 25;
    case VAR_portServicesProvided:
      return 26;
    case VAR_refBoatAuthorized:
      return 27;
    case VAR_refBoatPlaceAvailable:
      return 28;
    case VAR_refBoatPlacePricing:
      return 29;
    case VAR_refDevice:
      return 30;
    case VAR_refPointOfInterest:
      return 31;
    case VAR_rentalSaleServices:
      return 32;
    case VAR_routeType:
      return 33;
    case VAR_seeAlso:
      return 34;
    case VAR_source:
      return 35;
    case VAR_startDate:
      return 36;
    case VAR_transportServices:
      return 37;
    case VAR_typeOfPort:
      return 38;
    case VAR_webSite:
      return 39;
      default:
        return MapModel.htmCellMapModel(var);
    }
  }

  public static Integer lengthMinSeaportFacility(String var) {
    switch(var) {
      default:
        return MapModel.lengthMinMapModel(var);
    }
  }

  public static Integer lengthMaxSeaportFacility(String var) {
    switch(var) {
      default:
        return MapModel.lengthMaxMapModel(var);
    }
  }

  public static Integer maxSeaportFacility(String var) {
    switch(var) {
      default:
        return MapModel.maxMapModel(var);
    }
  }

  public static Integer minSeaportFacility(String var) {
    switch(var) {
      default:
        return MapModel.minMapModel(var);
    }
  }
}
