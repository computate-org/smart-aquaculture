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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
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
 * <h2>Order: 9</h2>
 * <p>This class contains a comment <b>"Order: 9"</b>, which means this class will be sorted by the given number 9 ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 9</h2>
 * <p>This class contains a comment <b>"SqlOrder: 9"</b>, which means this class will be sorted by the given number 9 ascending when SQL code to create and drop the tables is generated. 
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
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.fishprocessing in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class FishProcessingGen<DEV> extends MapModel {
  protected static final Logger LOG = LoggerFactory.getLogger(FishProcessing.class);

  public static final String Description_frFR = "A fish processing plant";
  public static final String AName_frFR = "a fish processing plant";
  public static final String SingularName_frFR = "fish processing plant";
  public static final String PluralName_frFR = "fish processing plants";
  public static final String Title_frFR = "fish processing plants";
  public static final String ThePluralName_frFR = "les fish processing plants";
  public static final String NameAdjectiveSingular_frFR = "fish processing plant";
  public static final String NameAdjectivePlural_frFR = "fish processing plants";

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

  public static JsonObject staticJsonAddress(JsonObject address) {
    return address;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
    String l = FishProcessing.staticSetAreaServedColors(siteRequest_, o);
    if(l != null)
      addAreaServedColors(l);
  }
  public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishProcessing addAreaServedColors(String...objects) {
    for(String o : objects) {
      addAreaServedColors(o);
    }
    return (FishProcessing)this;
  }
  public FishProcessing addAreaServedColors(String o) {
    if(o != null)
      this.areaServedColors.add(o);
    return (FishProcessing)this;
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
  protected FishProcessing areaServedColorsInit() {
    _areaServedColors(areaServedColors);
    return (FishProcessing)this;
  }

  public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
    return FishProcessing.staticSearchAreaServedColors(siteRequest_, FishProcessing.staticSetAreaServedColors(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
    String l = FishProcessing.staticSetAreaServedTitles(siteRequest_, o);
    if(l != null)
      addAreaServedTitles(l);
  }
  public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishProcessing addAreaServedTitles(String...objects) {
    for(String o : objects) {
      addAreaServedTitles(o);
    }
    return (FishProcessing)this;
  }
  public FishProcessing addAreaServedTitles(String o) {
    if(o != null)
      this.areaServedTitles.add(o);
    return (FishProcessing)this;
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
  protected FishProcessing areaServedTitlesInit() {
    _areaServedTitles(areaServedTitles);
    return (FishProcessing)this;
  }

  public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
    return FishProcessing.staticSearchAreaServedTitles(siteRequest_, FishProcessing.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
    String l = FishProcessing.staticSetAreaServedLinks(siteRequest_, o);
    if(l != null)
      addAreaServedLinks(l);
  }
  public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public FishProcessing addAreaServedLinks(String...objects) {
    for(String o : objects) {
      addAreaServedLinks(o);
    }
    return (FishProcessing)this;
  }
  public FishProcessing addAreaServedLinks(String o) {
    if(o != null)
      this.areaServedLinks.add(o);
    return (FishProcessing)this;
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
  protected FishProcessing areaServedLinksInit() {
    _areaServedLinks(areaServedLinks);
    return (FishProcessing)this;
  }

  public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
    return FishProcessing.staticSearchAreaServedLinks(siteRequest_, FishProcessing.staticSetAreaServedLinks(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
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
    this.areaServed = FishProcessing.staticSetAreaServed(siteRequest_, o);
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
  public FishProcessing addAreaServed(Polygon...objects) {
    for(Polygon o : objects) {
      addAreaServed(o);
    }
    return (FishProcessing)this;
  }
  public FishProcessing addAreaServed(Polygon o) {
    if(o != null)
      this.areaServed.add(o);
    return (FishProcessing)this;
  }
  protected FishProcessing areaServedInit() {
    _areaServed(areaServed);
    return (FishProcessing)this;
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
        areaServedColorsInit();
        areaServedTitlesInit();
        areaServedLinksInit();
        areaServedInit();
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
      case "areaServedColors":
        return oFishProcessing.areaServedColors;
      case "areaServedTitles":
        return oFishProcessing.areaServedTitles;
      case "areaServedLinks":
        return oFishProcessing.areaServedLinks;
      case "areaServed":
        return oFishProcessing.areaServed;
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
    case "areaServedColors":
      return FishProcessing.staticSetAreaServedColors(siteRequest_, v);
    case "areaServedTitles":
      return FishProcessing.staticSetAreaServedTitles(siteRequest_, v);
    case "areaServedLinks":
      return FishProcessing.staticSetAreaServedLinks(siteRequest_, v);
    case "areaServed":
      return FishProcessing.staticSetAreaServed(siteRequest_, v);
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
    case "areaServedColors":
      return FishProcessing.staticSearchAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return FishProcessing.staticSearchAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return FishProcessing.staticSearchAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return FishProcessing.staticSearchAreaServed(siteRequest_, (Polygon)o);
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
    case "areaServedColors":
      return FishProcessing.staticSearchStrAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return FishProcessing.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return FishProcessing.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return FishProcessing.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
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
    case "areaServedColors":
      return FishProcessing.staticSearchFqAreaServedColors(siteRequest_, o);
    case "areaServedTitles":
      return FishProcessing.staticSearchFqAreaServedTitles(siteRequest_, o);
    case "areaServedLinks":
      return FishProcessing.staticSearchFqAreaServedLinks(siteRequest_, o);
    case "areaServed":
      return FishProcessing.staticSearchFqAreaServed(siteRequest_, o);
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
        } else if(val instanceof JsonObject) {
          setAddress((JsonObject)val);
        }
        saves.add("address");
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

      if(saves.contains("areaServedColors")) {
        List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
        if(areaServedColors != null) {
          areaServedColors.stream().forEach( v -> {
            oFishProcessing.areaServedColors.add(FishProcessing.staticSetAreaServedColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedTitles")) {
        List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
        if(areaServedTitles != null) {
          areaServedTitles.stream().forEach( v -> {
            oFishProcessing.areaServedTitles.add(FishProcessing.staticSetAreaServedTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedLinks")) {
        List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
        if(areaServedLinks != null) {
          areaServedLinks.stream().forEach( v -> {
            oFishProcessing.areaServedLinks.add(FishProcessing.staticSetAreaServedLinks(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServed")) {
        List<Polygon> areaServed = (List<Polygon>)doc.get("areaServed_docvalues_location");
        if(areaServed != null) {
          areaServed.stream().forEach( v -> {
            oFishProcessing.areaServed.add(v);
          });
        }
      }
    }

    super.populateMapModel(doc);
  }

  public void indexFishProcessing(JsonObject doc) {
    if(address != null) {
      doc.put("address_docvalues_string", address.encode());
    }
    if(areaServedColors != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedColors_indexedstored_strings", l);
      for(String o : areaServedColors) {
        l.add(FishProcessing.staticSearchAreaServedColors(siteRequest_, o));
      }
    }
    if(areaServedTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedTitles_indexedstored_strings", l);
      for(String o : areaServedTitles) {
        l.add(FishProcessing.staticSearchAreaServedTitles(siteRequest_, o));
      }
    }
    if(areaServedLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedLinks_indexedstored_strings", l);
      for(String o : areaServedLinks) {
        l.add(FishProcessing.staticSearchAreaServedLinks(siteRequest_, o));
      }
    }
    if(areaServed != null) {
      doc.put("areaServed_docvalues_location", Optional.ofNullable(geojsonAreaServed()).map(geojson -> geojson.toString()).orElse(null));
    }
    super.indexMapModel(doc);

	}

  public static String varStoredFishProcessing(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      default:
        return MapModel.varStoredMapModel(entityVar);
    }
  }

  public static String varIndexedFishProcessing(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      default:
        return MapModel.varIndexedMapModel(entityVar);
    }
  }

  public static String searchVarFishProcessing(String searchVar) {
    switch(searchVar) {
      case "address_docvalues_string":
        return "address";
      case "areaServedColors_indexedstored_strings":
        return "areaServedColors";
      case "areaServedTitles_indexedstored_strings":
        return "areaServedTitles";
      case "areaServedLinks_indexedstored_strings":
        return "areaServedLinks";
      case "areaServed_docvalues_location":
        return "areaServed";
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
    Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishProcessing.addAreaServedColors(FishProcessing.staticSetAreaServedColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishProcessing.addAreaServedTitles(FishProcessing.staticSetAreaServedTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oFishProcessing.addAreaServedLinks(FishProcessing.staticSetAreaServedLinks(siteRequest, v.toString()));
    });
    Optional.ofNullable((String)doc.get("areaServed_docvalues_location")).ifPresent(val -> staticSetAreaServed(siteRequest_, val.toString()).stream().forEach(v -> addAreaServed(v)));

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
      if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
        apiRequest.addVars("areaServedColors");
      if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
        apiRequest.addVars("areaServedTitles");
      if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
        apiRequest.addVars("areaServedLinks");
      if(!Objects.equals(areaServed, original.getAreaServed()))
        apiRequest.addVars("areaServed");
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
    sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "FishProcessing";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishprocessing.FishProcessing";
  public static final String CLASS_AUTH_RESOURCE = "FISHPROCESSING";
  public static final String CLASS_API_ADDRESS_FishProcessing = "smart-aquaculture-enUS-FishProcessing";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_FishProcessing;
  }
  public static final String VAR_address = "address";
  public static final String VAR_areaServedColors = "areaServedColors";
  public static final String VAR_areaServedTitles = "areaServedTitles";
  public static final String VAR_areaServedLinks = "areaServedLinks";
  public static final String VAR_areaServed = "areaServed";

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
    vars.add(VAR_areaServed);
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
  public static final String DISPLAY_NAME_areaServedColors = "area served colors";
  public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
  public static final String DISPLAY_NAME_areaServedLinks = "area served links";
  public static final String DISPLAY_NAME_areaServed = "area served";

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
  public String frFRStringFormatUrlEditPageForClass() {
    return null;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/fish-processing/%s";
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
    return FishProcessing.displayNameFishProcessing(var);
  }
  public static String displayNameFishProcessing(String var) {
    switch(var) {
    case VAR_address:
      return DISPLAY_NAME_address;
    case VAR_areaServedColors:
      return DISPLAY_NAME_areaServedColors;
    case VAR_areaServedTitles:
      return DISPLAY_NAME_areaServedTitles;
    case VAR_areaServedLinks:
      return DISPLAY_NAME_areaServedLinks;
    case VAR_areaServed:
      return DISPLAY_NAME_areaServed;
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
    case VAR_areaServedColors:
      return "The colors of each areaServed Paths. ";
    case VAR_areaServedTitles:
      return "The titles of each areaServed Paths. ";
    case VAR_areaServedLinks:
      return "The links of each areaServed Paths. ";
    case VAR_areaServed:
      return "The geographic area where a service or offered item is provided";
      default:
        return MapModel.descriptionMapModel(var);
    }
  }

  public static String classSimpleNameFishProcessing(String var) {
    switch(var) {
    case VAR_address:
      return "JsonObject";
    case VAR_areaServedColors:
      return "List";
    case VAR_areaServedTitles:
      return "List";
    case VAR_areaServedLinks:
      return "List";
    case VAR_areaServed:
      return "List";
      default:
        return MapModel.classSimpleNameMapModel(var);
    }
  }

  public static String ngsiType(String var) {
    switch(var) {
    case VAR_address:
      return "Property";
    case VAR_areaServedColors:
      return "Property";
    case VAR_areaServedTitles:
      return "Property";
    case VAR_areaServedLinks:
      return "Property";
    case VAR_areaServed:
      return "GeoProperty";
      default:
        return MapModel.ngsiType(var);
    }
  }

  public static Object ngsiFishProcessing(String var, FishProcessing o) {
    switch(var) {
    case VAR_address:
      return o.getAddress();
    case VAR_areaServedColors:
      return o.getAreaServedColors();
    case VAR_areaServedTitles:
      return o.getAreaServedTitles();
    case VAR_areaServedLinks:
      return o.getAreaServedLinks();
    case VAR_areaServed:
      return o.geojsonAreaServed();
      default:
        return ngsiMapModel(var, o);
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
    case VAR_areaServed:
      return 4;
      default:
        return MapModel.htmRowMapModel(var);
    }
  }

  public static Integer htmCellFishProcessing(String var) {
    switch(var) {
    case VAR_address:
      return 0;
    case VAR_areaServed:
      return 1;
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
