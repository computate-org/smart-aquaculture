package org.computate.smartaquaculture.model.fiware.crowdflowobserved;

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
import java.lang.String;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPointSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPointDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Polygon;
import org.computate.vertx.serialize.pgclient.PgClientPolygonSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPolygonDeserializer;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.math.BigDecimal;
import java.lang.Boolean;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class CrowdFlowObservedGen into the class CrowdFlowObserved. 
 * </li>
 * <h3>About the CrowdFlowObserved class and it's generated class CrowdFlowObservedGen&lt;BaseModel&gt;: </h3>extends CrowdFlowObservedGen
 * <p>
 * This Java class extends a generated Java class CrowdFlowObservedGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved">Find the class CrowdFlowObserved in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends CrowdFlowObservedGen<BaseModel>
 * <p>This <code>class CrowdFlowObserved extends CrowdFlowObservedGen&lt;BaseModel&gt;</code>, which means it extends a newly generated CrowdFlowObservedGen. 
 * The generated <code>class CrowdFlowObservedGen extends BaseModel</code> which means that CrowdFlowObserved extends CrowdFlowObservedGen which extends BaseModel. 
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
 * <p>This class contains a comment <b>"ApiTag: CrowdFlowObserveds"</b>, which groups all of the OpenAPIs for CrowdFlowObserved objects under the tag "CrowdFlowObserveds". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/crowd-flow-observed</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/crowd-flow-observed"</b>, which defines the base API URI for CrowdFlowObserved objects as "/en-us/api/crowd-flow-observed" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the CrowdFlowObserved class will inherit the helpful inherited class comments from the super class CrowdFlowObservedGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the CrowdFlowObserved API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObservedPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObservedPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the CrowdFlowObserved Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a CrowdFlowObserved</h2>
 * <p>This class contains a comment <b>"AName.enUS: a CrowdFlowObserved"</b>, which identifies the language context to describe a CrowdFlowObserved as "a CrowdFlowObserved". 
 * </p>
 * <p>
 * Delete the class CrowdFlowObserved in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.crowdflowobserved in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class CrowdFlowObservedGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(CrowdFlowObserved.class);

	public static final String Description_enUS = "CrowdFlowObserved";
	public static final String AName_enUS = "a CrowdFlowObserved";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this CrowdFlowObserved";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the CrowdFlowObserved";
	public static final String SingularName_enUS = "CrowdFlowObserved";
	public static final String PluralName_enUS = "CrowdFlowObserveds";
	public static final String NameActual_enUS = "current CrowdFlowObserved";
	public static final String AllName_enUS = "all CrowdFlowObserveds";
	public static final String SearchAllNameBy_enUS = "search CrowdFlowObserveds by ";
	public static final String SearchAllName_enUS = "search CrowdFlowObserveds";
	public static final String Title_enUS = "CrowdFlowObserveds";
	public static final String ThePluralName_enUS = "the CrowdFlowObserveds";
	public static final String NoNameFound_enUS = "no CrowdFlowObserved found";
	public static final String ApiUri_enUS = "/en-us/api/crowd-flow-observed";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/crowd-flow-observed";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/crowd-flow-observed/{entityShortId}";
	public static final String OfName_enUS = "of CrowdFlowObserved";
	public static final String ANameAdjective_enUS = "a CrowdFlowObserved";
	public static final String NameAdjectiveSingular_enUS = "CrowdFlowObserved";
	public static final String NameAdjectivePlural_enUS = "CrowdFlowObserveds";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/crowd-flow-observed";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/crowd-flow-observed";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/crowd-flow-observed";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/crowd-flow-observed/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/crowd-flow-observed/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/crowd-flow-observed/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/crowd-flow-observed";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/crowd-flow-observed";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/crowd-flow-observed";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-users-viewfinder\"></i>";
	public static final Integer Rows = 100;

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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = CrowdFlowObserved.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchName(siteRequest_, CrowdFlowObserved.staticSetName(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = CrowdFlowObserved.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDescription(siteRequest_, CrowdFlowObserved.staticSetDescription(siteRequest_, o)).toString();
	}

	public String sqlDescription() {
		return description;
	}

	//////////////
	// location //
	//////////////


	/**	 The entity location
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPointDeserializer.class)
	@JsonSerialize(using = PgClientPointSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Point location;

	/**	<br> The entity location
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = CrowdFlowObserved.staticSetLocation(siteRequest_, o);
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
		this.location = CrowdFlowObserved.staticSetLocation(siteRequest_, o);
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
	protected CrowdFlowObserved locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Point staticSearchLocation(SiteRequest siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequest siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchLocation(siteRequest_, CrowdFlowObserved.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
		String l = CrowdFlowObserved.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}
	public CrowdFlowObserved addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (CrowdFlowObserved)this;
	}
	public CrowdFlowObserved addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (CrowdFlowObserved)this;
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
	protected CrowdFlowObserved areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAreaServedColors(siteRequest_, CrowdFlowObserved.staticSetAreaServedColors(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
		String l = CrowdFlowObserved.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}
	public CrowdFlowObserved addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (CrowdFlowObserved)this;
	}
	public CrowdFlowObserved addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (CrowdFlowObserved)this;
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
	protected CrowdFlowObserved areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAreaServedTitles(siteRequest_, CrowdFlowObserved.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
		String l = CrowdFlowObserved.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}
	public CrowdFlowObserved addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (CrowdFlowObserved)this;
	}
	public CrowdFlowObserved addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (CrowdFlowObserved)this;
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
	protected CrowdFlowObserved areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAreaServedLinks(siteRequest_, CrowdFlowObserved.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	////////////////
	// areaServed //
	////////////////


	/**	 The entity areaServed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPolygonDeserializer.class)
	@JsonSerialize(using = PgClientPolygonSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Polygon areaServed;

	/**	<br> The entity areaServed
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _areaServed(Wrap<Polygon> w);

	public Polygon getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(Polygon areaServed) {
		this.areaServed = areaServed;
	}
	@JsonIgnore
	public void setAreaServed(String o) {
		this.areaServed = CrowdFlowObserved.staticSetAreaServed(siteRequest_, o);
	}
	public static Polygon staticSetAreaServed(SiteRequest siteRequest_, String o) {
		if(o != null) {
			try {
				Polygon shape = null;
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
					shape = objectMapper.readValue(Json.encode(o), Polygon.class);
				}
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	@JsonIgnore
	public void setAreaServed(JsonObject o) {
		this.areaServed = CrowdFlowObserved.staticSetAreaServed(siteRequest_, o);
	}
	public static Polygon staticSetAreaServed(SiteRequest siteRequest_, JsonObject o) {
		if(o != null) {
			try {
				Polygon shape = new Polygon();
				o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(g -> {
					g.stream().map(a -> (JsonArray)a).forEach(points -> {
						shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
					});
				});
				return shape;
			} catch(Exception ex) {
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	protected CrowdFlowObserved areaServedInit() {
		Wrap<Polygon> areaServedWrap = new Wrap<Polygon>().var("areaServed");
		if(areaServed == null) {
			_areaServed(areaServedWrap);
			Optional.ofNullable(areaServedWrap.getO()).ifPresent(o -> {
				setAreaServed(o);
			});
		}
		return (CrowdFlowObserved)this;
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
		return CrowdFlowObserved.staticSearchAreaServed(siteRequest_, CrowdFlowObserved.staticSetAreaServed(siteRequest_, o)).toString();
	}

	public Polygon sqlAreaServed() {
		return areaServed;
	}

	////////
	// id //
	////////


	/**	 The entity id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String id;

	/**	<br> The entity id
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = CrowdFlowObserved.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchId(siteRequest_, CrowdFlowObserved.staticSetId(siteRequest_, o)).toString();
	}

	public String sqlId() {
		return id;
	}

	///////////////////
	// entityShortId //
	///////////////////


	/**	 The entity entityShortId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String entityShortId;

	/**	<br> The entity entityShortId
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityShortId(Wrap<String> w);

	public String getEntityShortId() {
		return entityShortId;
	}
	public void setEntityShortId(String o) {
		this.entityShortId = CrowdFlowObserved.staticSetEntityShortId(siteRequest_, o);
	}
	public static String staticSetEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved entityShortIdInit() {
		Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
		if(entityShortId == null) {
			_entityShortId(entityShortIdWrap);
			Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
				setEntityShortId(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityShortId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityShortId(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchEntityShortId(siteRequest_, CrowdFlowObserved.staticSetEntityShortId(siteRequest_, o)).toString();
	}

	//////////////////
	// ngsildTenant //
	//////////////////


	/**	 The entity ngsildTenant
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String ngsildTenant;

	/**	<br> The entity ngsildTenant
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:ngsildTenant">Find the entity ngsildTenant in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildTenant(Wrap<String> w);

	public String getNgsildTenant() {
		return ngsildTenant;
	}
	public void setNgsildTenant(String o) {
		this.ngsildTenant = CrowdFlowObserved.staticSetNgsildTenant(siteRequest_, o);
	}
	public static String staticSetNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved ngsildTenantInit() {
		Wrap<String> ngsildTenantWrap = new Wrap<String>().var("ngsildTenant");
		if(ngsildTenant == null) {
			_ngsildTenant(ngsildTenantWrap);
			Optional.ofNullable(ngsildTenantWrap.getO()).ifPresent(o -> {
				setNgsildTenant(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildTenant(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildTenant(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchNgsildTenant(siteRequest_, CrowdFlowObserved.staticSetNgsildTenant(siteRequest_, o)).toString();
	}

	public String sqlNgsildTenant() {
		return ngsildTenant;
	}

	////////////////
	// ngsildPath //
	////////////////


	/**	 The entity ngsildPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String ngsildPath;

	/**	<br> The entity ngsildPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:ngsildPath">Find the entity ngsildPath in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildPath(Wrap<String> w);

	public String getNgsildPath() {
		return ngsildPath;
	}
	public void setNgsildPath(String o) {
		this.ngsildPath = CrowdFlowObserved.staticSetNgsildPath(siteRequest_, o);
	}
	public static String staticSetNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved ngsildPathInit() {
		Wrap<String> ngsildPathWrap = new Wrap<String>().var("ngsildPath");
		if(ngsildPath == null) {
			_ngsildPath(ngsildPathWrap);
			Optional.ofNullable(ngsildPathWrap.getO()).ifPresent(o -> {
				setNgsildPath(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildPath(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildPath(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchNgsildPath(siteRequest_, CrowdFlowObserved.staticSetNgsildPath(siteRequest_, o)).toString();
	}

	public String sqlNgsildPath() {
		return ngsildPath;
	}

	///////////////////
	// ngsildContext //
	///////////////////


	/**	 The entity ngsildContext
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String ngsildContext;

	/**	<br> The entity ngsildContext
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:ngsildContext">Find the entity ngsildContext in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildContext(Wrap<String> w);

	public String getNgsildContext() {
		return ngsildContext;
	}
	public void setNgsildContext(String o) {
		this.ngsildContext = CrowdFlowObserved.staticSetNgsildContext(siteRequest_, o);
	}
	public static String staticSetNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved ngsildContextInit() {
		Wrap<String> ngsildContextWrap = new Wrap<String>().var("ngsildContext");
		if(ngsildContext == null) {
			_ngsildContext(ngsildContextWrap);
			Optional.ofNullable(ngsildContextWrap.getO()).ifPresent(o -> {
				setNgsildContext(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildContext(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildContext(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchNgsildContext(siteRequest_, CrowdFlowObserved.staticSetNgsildContext(siteRequest_, o)).toString();
	}

	public String sqlNgsildContext() {
		return ngsildContext;
	}

	////////////////
	// ngsildData //
	////////////////


	/**	 The entity ngsildData
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject ngsildData;

	/**	<br> The entity ngsildData
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:ngsildData">Find the entity ngsildData in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildData(Wrap<JsonObject> w);

	public JsonObject getNgsildData() {
		return ngsildData;
	}

	public void setNgsildData(JsonObject ngsildData) {
		this.ngsildData = ngsildData;
	}
	@JsonIgnore
	public void setNgsildData(String o) {
		this.ngsildData = CrowdFlowObserved.staticSetNgsildData(siteRequest_, o);
	}
	public static JsonObject staticSetNgsildData(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected CrowdFlowObserved ngsildDataInit() {
		Wrap<JsonObject> ngsildDataWrap = new Wrap<JsonObject>().var("ngsildData");
		if(ngsildData == null) {
			_ngsildData(ngsildDataWrap);
			Optional.ofNullable(ngsildDataWrap.getO()).ifPresent(o -> {
				setNgsildData(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchNgsildData(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrNgsildData(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildData(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchNgsildData(siteRequest_, CrowdFlowObserved.staticSetNgsildData(siteRequest_, o)).toString();
	}

	public JsonObject sqlNgsildData() {
		return ngsildData;
	}

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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = CrowdFlowObserved.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected CrowdFlowObserved addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAddress(siteRequest_, CrowdFlowObserved.staticSetAddress(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = CrowdFlowObserved.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAlternateName(siteRequest_, CrowdFlowObserved.staticSetAlternateName(siteRequest_, o)).toString();
	}

	public String sqlAlternateName() {
		return alternateName;
	}

	///////////////////////
	// averageCrowdSpeed //
	///////////////////////


	/**	 The entity averageCrowdSpeed
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageCrowdSpeed;

	/**	<br> The entity averageCrowdSpeed
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:averageCrowdSpeed">Find the entity averageCrowdSpeed in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageCrowdSpeed(Wrap<BigDecimal> w);

	public BigDecimal getAverageCrowdSpeed() {
		return averageCrowdSpeed;
	}

	public void setAverageCrowdSpeed(BigDecimal averageCrowdSpeed) {
		this.averageCrowdSpeed = averageCrowdSpeed;
	}
	@JsonIgnore
	public void setAverageCrowdSpeed(String o) {
		this.averageCrowdSpeed = CrowdFlowObserved.staticSetAverageCrowdSpeed(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageCrowdSpeed(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageCrowdSpeed(Double o) {
		setAverageCrowdSpeed(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageCrowdSpeed(Integer o) {
		setAverageCrowdSpeed(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageCrowdSpeed(Number o) {
		setAverageCrowdSpeed(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected CrowdFlowObserved averageCrowdSpeedInit() {
		Wrap<BigDecimal> averageCrowdSpeedWrap = new Wrap<BigDecimal>().var("averageCrowdSpeed");
		if(averageCrowdSpeed == null) {
			_averageCrowdSpeed(averageCrowdSpeedWrap);
			Optional.ofNullable(averageCrowdSpeedWrap.getO()).ifPresent(o -> {
				setAverageCrowdSpeed(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Double staticSearchAverageCrowdSpeed(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageCrowdSpeed(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageCrowdSpeed(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAverageCrowdSpeed(siteRequest_, CrowdFlowObserved.staticSetAverageCrowdSpeed(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageCrowdSpeed() {
		return averageCrowdSpeed;
	}

	////////////////////////
	// averageHeadwayTime //
	////////////////////////


	/**	 The entity averageHeadwayTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal averageHeadwayTime;

	/**	<br> The entity averageHeadwayTime
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:averageHeadwayTime">Find the entity averageHeadwayTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _averageHeadwayTime(Wrap<BigDecimal> w);

	public BigDecimal getAverageHeadwayTime() {
		return averageHeadwayTime;
	}

	public void setAverageHeadwayTime(BigDecimal averageHeadwayTime) {
		this.averageHeadwayTime = averageHeadwayTime;
	}
	@JsonIgnore
	public void setAverageHeadwayTime(String o) {
		this.averageHeadwayTime = CrowdFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o);
	}
	public static BigDecimal staticSetAverageHeadwayTime(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Double o) {
		setAverageHeadwayTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Integer o) {
		setAverageHeadwayTime(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setAverageHeadwayTime(Number o) {
		setAverageHeadwayTime(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected CrowdFlowObserved averageHeadwayTimeInit() {
		Wrap<BigDecimal> averageHeadwayTimeWrap = new Wrap<BigDecimal>().var("averageHeadwayTime");
		if(averageHeadwayTime == null) {
			_averageHeadwayTime(averageHeadwayTimeWrap);
			Optional.ofNullable(averageHeadwayTimeWrap.getO()).ifPresent(o -> {
				setAverageHeadwayTime(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Double staticSearchAverageHeadwayTime(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrAverageHeadwayTime(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAverageHeadwayTime(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchAverageHeadwayTime(siteRequest_, CrowdFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o)).toString();
	}

	public BigDecimal sqlAverageHeadwayTime() {
		return averageHeadwayTime;
	}

	///////////////
	// congested //
	///////////////


	/**	 The entity congested
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean congested;

	/**	<br> The entity congested
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:congested">Find the entity congested in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _congested(Wrap<Boolean> w);

	public Boolean getCongested() {
		return congested;
	}

	public void setCongested(Boolean congested) {
		this.congested = congested;
	}
	@JsonIgnore
	public void setCongested(String o) {
		this.congested = CrowdFlowObserved.staticSetCongested(siteRequest_, o);
	}
	public static Boolean staticSetCongested(SiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected CrowdFlowObserved congestedInit() {
		Wrap<Boolean> congestedWrap = new Wrap<Boolean>().var("congested");
		if(congested == null) {
			_congested(congestedWrap);
			Optional.ofNullable(congestedWrap.getO()).ifPresent(o -> {
				setCongested(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Boolean staticSearchCongested(SiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrCongested(SiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqCongested(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchCongested(siteRequest_, CrowdFlowObserved.staticSetCongested(siteRequest_, o)).toString();
	}

	public Boolean sqlCongested() {
		return congested;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = CrowdFlowObserved.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDataProvider(siteRequest_, CrowdFlowObserved.staticSetDataProvider(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = CrowdFlowObserved.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDateCreated(siteRequest_, CrowdFlowObserved.staticSetDateCreated(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = CrowdFlowObserved.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDateModified(siteRequest_, CrowdFlowObserved.staticSetDateModified(siteRequest_, o)).toString();
	}

	public String sqlDateModified() {
		return dateModified;
	}

	//////////////////
	// dateObserved //
	//////////////////


	/**	 The entity dateObserved
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObserved;

	/**	<br> The entity dateObserved
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dateObserved">Find the entity dateObserved in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObserved(Wrap<String> w);

	public String getDateObserved() {
		return dateObserved;
	}
	public void setDateObserved(String o) {
		this.dateObserved = CrowdFlowObserved.staticSetDateObserved(siteRequest_, o);
	}
	public static String staticSetDateObserved(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dateObservedInit() {
		Wrap<String> dateObservedWrap = new Wrap<String>().var("dateObserved");
		if(dateObserved == null) {
			_dateObserved(dateObservedWrap);
			Optional.ofNullable(dateObservedWrap.getO()).ifPresent(o -> {
				setDateObserved(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDateObserved(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObserved(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObserved(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDateObserved(siteRequest_, CrowdFlowObserved.staticSetDateObserved(siteRequest_, o)).toString();
	}

	public String sqlDateObserved() {
		return dateObserved;
	}

	//////////////////////
	// dateObservedFrom //
	//////////////////////


	/**	 The entity dateObservedFrom
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObservedFrom;

	/**	<br> The entity dateObservedFrom
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dateObservedFrom">Find the entity dateObservedFrom in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedFrom(Wrap<String> w);

	public String getDateObservedFrom() {
		return dateObservedFrom;
	}
	public void setDateObservedFrom(String o) {
		this.dateObservedFrom = CrowdFlowObserved.staticSetDateObservedFrom(siteRequest_, o);
	}
	public static String staticSetDateObservedFrom(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dateObservedFromInit() {
		Wrap<String> dateObservedFromWrap = new Wrap<String>().var("dateObservedFrom");
		if(dateObservedFrom == null) {
			_dateObservedFrom(dateObservedFromWrap);
			Optional.ofNullable(dateObservedFromWrap.getO()).ifPresent(o -> {
				setDateObservedFrom(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDateObservedFrom(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedFrom(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedFrom(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDateObservedFrom(siteRequest_, CrowdFlowObserved.staticSetDateObservedFrom(siteRequest_, o)).toString();
	}

	public String sqlDateObservedFrom() {
		return dateObservedFrom;
	}

	////////////////////
	// dateObservedTo //
	////////////////////


	/**	 The entity dateObservedTo
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dateObservedTo;

	/**	<br> The entity dateObservedTo
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:dateObservedTo">Find the entity dateObservedTo in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateObservedTo(Wrap<String> w);

	public String getDateObservedTo() {
		return dateObservedTo;
	}
	public void setDateObservedTo(String o) {
		this.dateObservedTo = CrowdFlowObserved.staticSetDateObservedTo(siteRequest_, o);
	}
	public static String staticSetDateObservedTo(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved dateObservedToInit() {
		Wrap<String> dateObservedToWrap = new Wrap<String>().var("dateObservedTo");
		if(dateObservedTo == null) {
			_dateObservedTo(dateObservedToWrap);
			Optional.ofNullable(dateObservedToWrap.getO()).ifPresent(o -> {
				setDateObservedTo(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDateObservedTo(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateObservedTo(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateObservedTo(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDateObservedTo(siteRequest_, CrowdFlowObserved.staticSetDateObservedTo(siteRequest_, o)).toString();
	}

	public String sqlDateObservedTo() {
		return dateObservedTo;
	}

	///////////////
	// direction //
	///////////////


	/**	 The entity direction
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String direction;

	/**	<br> The entity direction
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:direction">Find the entity direction in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _direction(Wrap<String> w);

	public String getDirection() {
		return direction;
	}
	public void setDirection(String o) {
		this.direction = CrowdFlowObserved.staticSetDirection(siteRequest_, o);
	}
	public static String staticSetDirection(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved directionInit() {
		Wrap<String> directionWrap = new Wrap<String>().var("direction");
		if(direction == null) {
			_direction(directionWrap);
			Optional.ofNullable(directionWrap.getO()).ifPresent(o -> {
				setDirection(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchDirection(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDirection(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDirection(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchDirection(siteRequest_, CrowdFlowObserved.staticSetDirection(siteRequest_, o)).toString();
	}

	public String sqlDirection() {
		return direction;
	}

	///////////////
	// occupancy //
	///////////////


	/**	 The entity occupancy
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal occupancy;

	/**	<br> The entity occupancy
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:occupancy">Find the entity occupancy in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _occupancy(Wrap<BigDecimal> w);

	public BigDecimal getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(BigDecimal occupancy) {
		this.occupancy = occupancy;
	}
	@JsonIgnore
	public void setOccupancy(String o) {
		this.occupancy = CrowdFlowObserved.staticSetOccupancy(siteRequest_, o);
	}
	public static BigDecimal staticSetOccupancy(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setOccupancy(Double o) {
		setOccupancy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setOccupancy(Integer o) {
		setOccupancy(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setOccupancy(Number o) {
		setOccupancy(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected CrowdFlowObserved occupancyInit() {
		Wrap<BigDecimal> occupancyWrap = new Wrap<BigDecimal>().var("occupancy");
		if(occupancy == null) {
			_occupancy(occupancyWrap);
			Optional.ofNullable(occupancyWrap.getO()).ifPresent(o -> {
				setOccupancy(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Double staticSearchOccupancy(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrOccupancy(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOccupancy(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchOccupancy(siteRequest_, CrowdFlowObserved.staticSetOccupancy(siteRequest_, o)).toString();
	}

	public BigDecimal sqlOccupancy() {
		return occupancy;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
		this.owner = CrowdFlowObserved.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected CrowdFlowObserved ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchOwner(siteRequest_, CrowdFlowObserved.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
	}

	/////////////////
	// peopleCount //
	/////////////////


	/**	 The entity peopleCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal peopleCount;

	/**	<br> The entity peopleCount
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:peopleCount">Find the entity peopleCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _peopleCount(Wrap<BigDecimal> w);

	public BigDecimal getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(BigDecimal peopleCount) {
		this.peopleCount = peopleCount;
	}
	@JsonIgnore
	public void setPeopleCount(String o) {
		this.peopleCount = CrowdFlowObserved.staticSetPeopleCount(siteRequest_, o);
	}
	public static BigDecimal staticSetPeopleCount(SiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setPeopleCount(Double o) {
		setPeopleCount(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setPeopleCount(Integer o) {
		setPeopleCount(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	@JsonIgnore
	public void setPeopleCount(Number o) {
		setPeopleCount(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
	}
	protected CrowdFlowObserved peopleCountInit() {
		Wrap<BigDecimal> peopleCountWrap = new Wrap<BigDecimal>().var("peopleCount");
		if(peopleCount == null) {
			_peopleCount(peopleCountWrap);
			Optional.ofNullable(peopleCountWrap.getO()).ifPresent(o -> {
				setPeopleCount(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static Double staticSearchPeopleCount(SiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrPeopleCount(SiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPeopleCount(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchPeopleCount(siteRequest_, CrowdFlowObserved.staticSetPeopleCount(siteRequest_, o)).toString();
	}

	public BigDecimal sqlPeopleCount() {
		return peopleCount;
	}

	////////////////////
	// refRoadSegment //
	////////////////////


	/**	 The entity refRoadSegment
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String refRoadSegment;

	/**	<br> The entity refRoadSegment
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:refRoadSegment">Find the entity refRoadSegment in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _refRoadSegment(Wrap<String> w);

	public String getRefRoadSegment() {
		return refRoadSegment;
	}
	public void setRefRoadSegment(String o) {
		this.refRoadSegment = CrowdFlowObserved.staticSetRefRoadSegment(siteRequest_, o);
	}
	public static String staticSetRefRoadSegment(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved refRoadSegmentInit() {
		Wrap<String> refRoadSegmentWrap = new Wrap<String>().var("refRoadSegment");
		if(refRoadSegment == null) {
			_refRoadSegment(refRoadSegmentWrap);
			Optional.ofNullable(refRoadSegmentWrap.getO()).ifPresent(o -> {
				setRefRoadSegment(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchRefRoadSegment(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRefRoadSegment(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRefRoadSegment(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchRefRoadSegment(siteRequest_, CrowdFlowObserved.staticSetRefRoadSegment(siteRequest_, o)).toString();
	}

	public String sqlRefRoadSegment() {
		return refRoadSegment;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeAlso(Wrap<String> w);

	public String getSeeAlso() {
		return seeAlso;
	}
	public void setSeeAlso(String o) {
		this.seeAlso = CrowdFlowObserved.staticSetSeeAlso(siteRequest_, o);
	}
	public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved seeAlsoInit() {
		Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchSeeAlso(siteRequest_, CrowdFlowObserved.staticSetSeeAlso(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = CrowdFlowObserved.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected CrowdFlowObserved sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (CrowdFlowObserved)this;
	}

	public static String staticSearchSource(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
		return CrowdFlowObserved.staticSearchSource(siteRequest_, CrowdFlowObserved.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<CrowdFlowObservedGen<DEV>> promiseDeepCrowdFlowObserved(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepCrowdFlowObserved();
	}

	public Future<CrowdFlowObservedGen<DEV>> promiseDeepCrowdFlowObserved() {
		Promise<CrowdFlowObservedGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseCrowdFlowObserved(promise2);
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

	public Future<Void> promiseCrowdFlowObserved(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				nameInit();
				descriptionInit();
				locationInit();
				areaServedColorsInit();
				areaServedTitlesInit();
				areaServedLinksInit();
				areaServedInit();
				idInit();
				entityShortIdInit();
				ngsildTenantInit();
				ngsildPathInit();
				ngsildContextInit();
				ngsildDataInit();
				addressInit();
				alternateNameInit();
				averageCrowdSpeedInit();
				averageHeadwayTimeInit();
				congestedInit();
				dataProviderInit();
				dateCreatedInit();
				dateModifiedInit();
				dateObservedInit();
				dateObservedFromInit();
				dateObservedToInit();
				directionInit();
				occupancyInit();
				ownerInit();
				peopleCountInit();
				refRoadSegmentInit();
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

	@Override public Future<? extends CrowdFlowObservedGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepCrowdFlowObserved(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestCrowdFlowObserved(SiteRequest siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestCrowdFlowObserved(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainCrowdFlowObserved(v);
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
	public Object obtainCrowdFlowObserved(String var) {
		CrowdFlowObserved oCrowdFlowObserved = (CrowdFlowObserved)this;
		switch(var) {
			case "name":
				return oCrowdFlowObserved.name;
			case "description":
				return oCrowdFlowObserved.description;
			case "location":
				return oCrowdFlowObserved.location;
			case "areaServedColors":
				return oCrowdFlowObserved.areaServedColors;
			case "areaServedTitles":
				return oCrowdFlowObserved.areaServedTitles;
			case "areaServedLinks":
				return oCrowdFlowObserved.areaServedLinks;
			case "areaServed":
				return oCrowdFlowObserved.areaServed;
			case "id":
				return oCrowdFlowObserved.id;
			case "entityShortId":
				return oCrowdFlowObserved.entityShortId;
			case "ngsildTenant":
				return oCrowdFlowObserved.ngsildTenant;
			case "ngsildPath":
				return oCrowdFlowObserved.ngsildPath;
			case "ngsildContext":
				return oCrowdFlowObserved.ngsildContext;
			case "ngsildData":
				return oCrowdFlowObserved.ngsildData;
			case "address":
				return oCrowdFlowObserved.address;
			case "alternateName":
				return oCrowdFlowObserved.alternateName;
			case "averageCrowdSpeed":
				return oCrowdFlowObserved.averageCrowdSpeed;
			case "averageHeadwayTime":
				return oCrowdFlowObserved.averageHeadwayTime;
			case "congested":
				return oCrowdFlowObserved.congested;
			case "dataProvider":
				return oCrowdFlowObserved.dataProvider;
			case "dateCreated":
				return oCrowdFlowObserved.dateCreated;
			case "dateModified":
				return oCrowdFlowObserved.dateModified;
			case "dateObserved":
				return oCrowdFlowObserved.dateObserved;
			case "dateObservedFrom":
				return oCrowdFlowObserved.dateObservedFrom;
			case "dateObservedTo":
				return oCrowdFlowObserved.dateObservedTo;
			case "direction":
				return oCrowdFlowObserved.direction;
			case "occupancy":
				return oCrowdFlowObserved.occupancy;
			case "owner":
				return oCrowdFlowObserved.owner;
			case "peopleCount":
				return oCrowdFlowObserved.peopleCount;
			case "refRoadSegment":
				return oCrowdFlowObserved.refRoadSegment;
			case "seeAlso":
				return oCrowdFlowObserved.seeAlso;
			case "source":
				return oCrowdFlowObserved.source;
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
				o = relateCrowdFlowObserved(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateCrowdFlowObserved(String var, Object val) {
		CrowdFlowObserved oCrowdFlowObserved = (CrowdFlowObserved)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSetCrowdFlowObserved(entityVar,  siteRequest_, o);
	}
	public static Object staticSetCrowdFlowObserved(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "name":
			return CrowdFlowObserved.staticSetName(siteRequest_, o);
		case "description":
			return CrowdFlowObserved.staticSetDescription(siteRequest_, o);
		case "location":
			return CrowdFlowObserved.staticSetLocation(siteRequest_, o);
		case "areaServedColors":
			return CrowdFlowObserved.staticSetAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return CrowdFlowObserved.staticSetAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return CrowdFlowObserved.staticSetAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return CrowdFlowObserved.staticSetAreaServed(siteRequest_, o);
		case "id":
			return CrowdFlowObserved.staticSetId(siteRequest_, o);
		case "entityShortId":
			return CrowdFlowObserved.staticSetEntityShortId(siteRequest_, o);
		case "ngsildTenant":
			return CrowdFlowObserved.staticSetNgsildTenant(siteRequest_, o);
		case "ngsildPath":
			return CrowdFlowObserved.staticSetNgsildPath(siteRequest_, o);
		case "ngsildContext":
			return CrowdFlowObserved.staticSetNgsildContext(siteRequest_, o);
		case "ngsildData":
			return CrowdFlowObserved.staticSetNgsildData(siteRequest_, o);
		case "address":
			return CrowdFlowObserved.staticSetAddress(siteRequest_, o);
		case "alternateName":
			return CrowdFlowObserved.staticSetAlternateName(siteRequest_, o);
		case "averageCrowdSpeed":
			return CrowdFlowObserved.staticSetAverageCrowdSpeed(siteRequest_, o);
		case "averageHeadwayTime":
			return CrowdFlowObserved.staticSetAverageHeadwayTime(siteRequest_, o);
		case "congested":
			return CrowdFlowObserved.staticSetCongested(siteRequest_, o);
		case "dataProvider":
			return CrowdFlowObserved.staticSetDataProvider(siteRequest_, o);
		case "dateCreated":
			return CrowdFlowObserved.staticSetDateCreated(siteRequest_, o);
		case "dateModified":
			return CrowdFlowObserved.staticSetDateModified(siteRequest_, o);
		case "dateObserved":
			return CrowdFlowObserved.staticSetDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return CrowdFlowObserved.staticSetDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return CrowdFlowObserved.staticSetDateObservedTo(siteRequest_, o);
		case "direction":
			return CrowdFlowObserved.staticSetDirection(siteRequest_, o);
		case "occupancy":
			return CrowdFlowObserved.staticSetOccupancy(siteRequest_, o);
		case "owner":
			return CrowdFlowObserved.staticSetOwner(siteRequest_, o);
		case "peopleCount":
			return CrowdFlowObserved.staticSetPeopleCount(siteRequest_, o);
		case "refRoadSegment":
			return CrowdFlowObserved.staticSetRefRoadSegment(siteRequest_, o);
		case "seeAlso":
			return CrowdFlowObserved.staticSetSeeAlso(siteRequest_, o);
		case "source":
			return CrowdFlowObserved.staticSetSource(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchCrowdFlowObserved(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchCrowdFlowObserved(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return CrowdFlowObserved.staticSearchName(siteRequest_, (String)o);
		case "description":
			return CrowdFlowObserved.staticSearchDescription(siteRequest_, (String)o);
		case "location":
			return CrowdFlowObserved.staticSearchLocation(siteRequest_, (Point)o);
		case "areaServedColors":
			return CrowdFlowObserved.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return CrowdFlowObserved.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return CrowdFlowObserved.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return CrowdFlowObserved.staticSearchAreaServed(siteRequest_, (Polygon)o);
		case "id":
			return CrowdFlowObserved.staticSearchId(siteRequest_, (String)o);
		case "entityShortId":
			return CrowdFlowObserved.staticSearchEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return CrowdFlowObserved.staticSearchNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return CrowdFlowObserved.staticSearchNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return CrowdFlowObserved.staticSearchNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return CrowdFlowObserved.staticSearchNgsildData(siteRequest_, (JsonObject)o);
		case "address":
			return CrowdFlowObserved.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return CrowdFlowObserved.staticSearchAlternateName(siteRequest_, (String)o);
		case "averageCrowdSpeed":
			return CrowdFlowObserved.staticSearchAverageCrowdSpeed(siteRequest_, (BigDecimal)o);
		case "averageHeadwayTime":
			return CrowdFlowObserved.staticSearchAverageHeadwayTime(siteRequest_, (BigDecimal)o);
		case "congested":
			return CrowdFlowObserved.staticSearchCongested(siteRequest_, (Boolean)o);
		case "dataProvider":
			return CrowdFlowObserved.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return CrowdFlowObserved.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return CrowdFlowObserved.staticSearchDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return CrowdFlowObserved.staticSearchDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return CrowdFlowObserved.staticSearchDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return CrowdFlowObserved.staticSearchDateObservedTo(siteRequest_, (String)o);
		case "direction":
			return CrowdFlowObserved.staticSearchDirection(siteRequest_, (String)o);
		case "occupancy":
			return CrowdFlowObserved.staticSearchOccupancy(siteRequest_, (BigDecimal)o);
		case "owner":
			return CrowdFlowObserved.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "peopleCount":
			return CrowdFlowObserved.staticSearchPeopleCount(siteRequest_, (BigDecimal)o);
		case "refRoadSegment":
			return CrowdFlowObserved.staticSearchRefRoadSegment(siteRequest_, (String)o);
		case "seeAlso":
			return CrowdFlowObserved.staticSearchSeeAlso(siteRequest_, (String)o);
		case "source":
			return CrowdFlowObserved.staticSearchSource(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrCrowdFlowObserved(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrCrowdFlowObserved(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return CrowdFlowObserved.staticSearchStrName(siteRequest_, (String)o);
		case "description":
			return CrowdFlowObserved.staticSearchStrDescription(siteRequest_, (String)o);
		case "location":
			return CrowdFlowObserved.staticSearchStrLocation(siteRequest_, (Point)o);
		case "areaServedColors":
			return CrowdFlowObserved.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return CrowdFlowObserved.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return CrowdFlowObserved.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return CrowdFlowObserved.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
		case "id":
			return CrowdFlowObserved.staticSearchStrId(siteRequest_, (String)o);
		case "entityShortId":
			return CrowdFlowObserved.staticSearchStrEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return CrowdFlowObserved.staticSearchStrNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return CrowdFlowObserved.staticSearchStrNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return CrowdFlowObserved.staticSearchStrNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return CrowdFlowObserved.staticSearchStrNgsildData(siteRequest_, (String)o);
		case "address":
			return CrowdFlowObserved.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return CrowdFlowObserved.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "averageCrowdSpeed":
			return CrowdFlowObserved.staticSearchStrAverageCrowdSpeed(siteRequest_, (Double)o);
		case "averageHeadwayTime":
			return CrowdFlowObserved.staticSearchStrAverageHeadwayTime(siteRequest_, (Double)o);
		case "congested":
			return CrowdFlowObserved.staticSearchStrCongested(siteRequest_, (Boolean)o);
		case "dataProvider":
			return CrowdFlowObserved.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return CrowdFlowObserved.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return CrowdFlowObserved.staticSearchStrDateModified(siteRequest_, (String)o);
		case "dateObserved":
			return CrowdFlowObserved.staticSearchStrDateObserved(siteRequest_, (String)o);
		case "dateObservedFrom":
			return CrowdFlowObserved.staticSearchStrDateObservedFrom(siteRequest_, (String)o);
		case "dateObservedTo":
			return CrowdFlowObserved.staticSearchStrDateObservedTo(siteRequest_, (String)o);
		case "direction":
			return CrowdFlowObserved.staticSearchStrDirection(siteRequest_, (String)o);
		case "occupancy":
			return CrowdFlowObserved.staticSearchStrOccupancy(siteRequest_, (Double)o);
		case "owner":
			return CrowdFlowObserved.staticSearchStrOwner(siteRequest_, (String)o);
		case "peopleCount":
			return CrowdFlowObserved.staticSearchStrPeopleCount(siteRequest_, (Double)o);
		case "refRoadSegment":
			return CrowdFlowObserved.staticSearchStrRefRoadSegment(siteRequest_, (String)o);
		case "seeAlso":
			return CrowdFlowObserved.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "source":
			return CrowdFlowObserved.staticSearchStrSource(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqCrowdFlowObserved(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqCrowdFlowObserved(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "name":
			return CrowdFlowObserved.staticSearchFqName(siteRequest_, o);
		case "description":
			return CrowdFlowObserved.staticSearchFqDescription(siteRequest_, o);
		case "location":
			return CrowdFlowObserved.staticSearchFqLocation(siteRequest_, o);
		case "areaServedColors":
			return CrowdFlowObserved.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return CrowdFlowObserved.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return CrowdFlowObserved.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return CrowdFlowObserved.staticSearchFqAreaServed(siteRequest_, o);
		case "id":
			return CrowdFlowObserved.staticSearchFqId(siteRequest_, o);
		case "entityShortId":
			return CrowdFlowObserved.staticSearchFqEntityShortId(siteRequest_, o);
		case "ngsildTenant":
			return CrowdFlowObserved.staticSearchFqNgsildTenant(siteRequest_, o);
		case "ngsildPath":
			return CrowdFlowObserved.staticSearchFqNgsildPath(siteRequest_, o);
		case "ngsildContext":
			return CrowdFlowObserved.staticSearchFqNgsildContext(siteRequest_, o);
		case "ngsildData":
			return CrowdFlowObserved.staticSearchFqNgsildData(siteRequest_, o);
		case "address":
			return CrowdFlowObserved.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return CrowdFlowObserved.staticSearchFqAlternateName(siteRequest_, o);
		case "averageCrowdSpeed":
			return CrowdFlowObserved.staticSearchFqAverageCrowdSpeed(siteRequest_, o);
		case "averageHeadwayTime":
			return CrowdFlowObserved.staticSearchFqAverageHeadwayTime(siteRequest_, o);
		case "congested":
			return CrowdFlowObserved.staticSearchFqCongested(siteRequest_, o);
		case "dataProvider":
			return CrowdFlowObserved.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return CrowdFlowObserved.staticSearchFqDateCreated(siteRequest_, o);
		case "dateModified":
			return CrowdFlowObserved.staticSearchFqDateModified(siteRequest_, o);
		case "dateObserved":
			return CrowdFlowObserved.staticSearchFqDateObserved(siteRequest_, o);
		case "dateObservedFrom":
			return CrowdFlowObserved.staticSearchFqDateObservedFrom(siteRequest_, o);
		case "dateObservedTo":
			return CrowdFlowObserved.staticSearchFqDateObservedTo(siteRequest_, o);
		case "direction":
			return CrowdFlowObserved.staticSearchFqDirection(siteRequest_, o);
		case "occupancy":
			return CrowdFlowObserved.staticSearchFqOccupancy(siteRequest_, o);
		case "owner":
			return CrowdFlowObserved.staticSearchFqOwner(siteRequest_, o);
		case "peopleCount":
			return CrowdFlowObserved.staticSearchFqPeopleCount(siteRequest_, o);
		case "refRoadSegment":
			return CrowdFlowObserved.staticSearchFqRefRoadSegment(siteRequest_, o);
		case "seeAlso":
			return CrowdFlowObserved.staticSearchFqSeeAlso(siteRequest_, o);
		case "source":
			return CrowdFlowObserved.staticSearchFqSource(siteRequest_, o);
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
					o = persistCrowdFlowObserved(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistCrowdFlowObserved(String var, Object val) {
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
			} else if("location".equals(varLower)) {
				if(val instanceof String) {
					setLocation((String)val);
				} else if(val instanceof Point) {
					setLocation((Point)val);
				}
				saves.add("location");
				return val;
			} else if("areaserved".equals(varLower)) {
				if(val instanceof Polygon) {
					setAreaServed((Polygon)val);
				} else {
					setAreaServed(val == null ? null : val.toString());
				}
				saves.add("areaServed");
				return val;
			} else if("id".equals(varLower)) {
				if(val instanceof String) {
					setId((String)val);
				}
				saves.add("id");
				return val;
			} else if("ngsildtenant".equals(varLower)) {
				if(val instanceof String) {
					setNgsildTenant((String)val);
				}
				saves.add("ngsildTenant");
				return val;
			} else if("ngsildpath".equals(varLower)) {
				if(val instanceof String) {
					setNgsildPath((String)val);
				}
				saves.add("ngsildPath");
				return val;
			} else if("ngsildcontext".equals(varLower)) {
				if(val instanceof String) {
					setNgsildContext((String)val);
				}
				saves.add("ngsildContext");
				return val;
			} else if("ngsilddata".equals(varLower)) {
				if(val instanceof String) {
					setNgsildData((String)val);
				} else if(val instanceof JsonObject) {
					setNgsildData((JsonObject)val);
				}
				saves.add("ngsildData");
				return val;
			} else if("address".equals(varLower)) {
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
			} else if("averagecrowdspeed".equals(varLower)) {
				if(val instanceof String) {
					setAverageCrowdSpeed((String)val);
				} else if(val instanceof Number) {
					setAverageCrowdSpeed(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageCrowdSpeed");
				return val;
			} else if("averageheadwaytime".equals(varLower)) {
				if(val instanceof String) {
					setAverageHeadwayTime((String)val);
				} else if(val instanceof Number) {
					setAverageHeadwayTime(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("averageHeadwayTime");
				return val;
			} else if("congested".equals(varLower)) {
				if(val instanceof Boolean) {
					setCongested((Boolean)val);
				} else {
					setCongested(val == null ? null : val.toString());
				}
				saves.add("congested");
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
			} else if("dateobserved".equals(varLower)) {
				if(val instanceof String) {
					setDateObserved((String)val);
				}
				saves.add("dateObserved");
				return val;
			} else if("dateobservedfrom".equals(varLower)) {
				if(val instanceof String) {
					setDateObservedFrom((String)val);
				}
				saves.add("dateObservedFrom");
				return val;
			} else if("dateobservedto".equals(varLower)) {
				if(val instanceof String) {
					setDateObservedTo((String)val);
				}
				saves.add("dateObservedTo");
				return val;
			} else if("direction".equals(varLower)) {
				if(val instanceof String) {
					setDirection((String)val);
				}
				saves.add("direction");
				return val;
			} else if("occupancy".equals(varLower)) {
				if(val instanceof String) {
					setOccupancy((String)val);
				} else if(val instanceof Number) {
					setOccupancy(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("occupancy");
				return val;
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
				return val;
			} else if("peoplecount".equals(varLower)) {
				if(val instanceof String) {
					setPeopleCount((String)val);
				} else if(val instanceof Number) {
					setPeopleCount(new BigDecimal(((Number)val).doubleValue()));
				}
				saves.add("peopleCount");
				return val;
			} else if("refroadsegment".equals(varLower)) {
				if(val instanceof String) {
					setRefRoadSegment((String)val);
				}
				saves.add("refRoadSegment");
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
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateCrowdFlowObserved(doc);
	}
	public void populateCrowdFlowObserved(SolrResponse.Doc doc) {
		CrowdFlowObserved oCrowdFlowObserved = (CrowdFlowObserved)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oCrowdFlowObserved.setName(name);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oCrowdFlowObserved.setDescription(description);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oCrowdFlowObserved.setLocation(location);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null) {
					areaServedColors.stream().forEach( v -> {
						oCrowdFlowObserved.areaServedColors.add(CrowdFlowObserved.staticSetAreaServedColors(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null) {
					areaServedTitles.stream().forEach( v -> {
						oCrowdFlowObserved.areaServedTitles.add(CrowdFlowObserved.staticSetAreaServedTitles(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null) {
					areaServedLinks.stream().forEach( v -> {
						oCrowdFlowObserved.areaServedLinks.add(CrowdFlowObserved.staticSetAreaServedLinks(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServed")) {
				Polygon areaServed = (Polygon)doc.get("areaServed_docvalues_location");
				if(areaServed != null)
					oCrowdFlowObserved.setAreaServed(areaServed);
			}

			if(saves.contains("id")) {
				String id = (String)doc.get("id_docvalues_string");
				if(id != null)
					oCrowdFlowObserved.setId(id);
			}

			if(saves.contains("entityShortId")) {
				String entityShortId = (String)doc.get("entityShortId_docvalues_string");
				if(entityShortId != null)
					oCrowdFlowObserved.setEntityShortId(entityShortId);
			}

			if(saves.contains("ngsildTenant")) {
				String ngsildTenant = (String)doc.get("ngsildTenant_docvalues_string");
				if(ngsildTenant != null)
					oCrowdFlowObserved.setNgsildTenant(ngsildTenant);
			}

			if(saves.contains("ngsildPath")) {
				String ngsildPath = (String)doc.get("ngsildPath_docvalues_string");
				if(ngsildPath != null)
					oCrowdFlowObserved.setNgsildPath(ngsildPath);
			}

			if(saves.contains("ngsildContext")) {
				String ngsildContext = (String)doc.get("ngsildContext_docvalues_string");
				if(ngsildContext != null)
					oCrowdFlowObserved.setNgsildContext(ngsildContext);
			}

			if(saves.contains("ngsildData")) {
				String ngsildData = (String)doc.get("ngsildData_docvalues_string");
				if(ngsildData != null)
					oCrowdFlowObserved.setNgsildData(ngsildData);
			}

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oCrowdFlowObserved.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oCrowdFlowObserved.setAlternateName(alternateName);
			}

			if(saves.contains("averageCrowdSpeed")) {
				Double averageCrowdSpeed = (Double)doc.get("averageCrowdSpeed_docvalues_double");
				if(averageCrowdSpeed != null)
					oCrowdFlowObserved.setAverageCrowdSpeed(averageCrowdSpeed);
			}

			if(saves.contains("averageHeadwayTime")) {
				Double averageHeadwayTime = (Double)doc.get("averageHeadwayTime_docvalues_double");
				if(averageHeadwayTime != null)
					oCrowdFlowObserved.setAverageHeadwayTime(averageHeadwayTime);
			}

			if(saves.contains("congested")) {
				Boolean congested = (Boolean)doc.get("congested_docvalues_boolean");
				if(congested != null)
					oCrowdFlowObserved.setCongested(congested);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oCrowdFlowObserved.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oCrowdFlowObserved.setDateCreated(dateCreated);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oCrowdFlowObserved.setDateModified(dateModified);
			}

			if(saves.contains("dateObserved")) {
				String dateObserved = (String)doc.get("dateObserved_docvalues_string");
				if(dateObserved != null)
					oCrowdFlowObserved.setDateObserved(dateObserved);
			}

			if(saves.contains("dateObservedFrom")) {
				String dateObservedFrom = (String)doc.get("dateObservedFrom_docvalues_string");
				if(dateObservedFrom != null)
					oCrowdFlowObserved.setDateObservedFrom(dateObservedFrom);
			}

			if(saves.contains("dateObservedTo")) {
				String dateObservedTo = (String)doc.get("dateObservedTo_docvalues_string");
				if(dateObservedTo != null)
					oCrowdFlowObserved.setDateObservedTo(dateObservedTo);
			}

			if(saves.contains("direction")) {
				String direction = (String)doc.get("direction_docvalues_string");
				if(direction != null)
					oCrowdFlowObserved.setDirection(direction);
			}

			if(saves.contains("occupancy")) {
				Double occupancy = (Double)doc.get("occupancy_docvalues_double");
				if(occupancy != null)
					oCrowdFlowObserved.setOccupancy(occupancy);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oCrowdFlowObserved.setOwner(owner);
			}

			if(saves.contains("peopleCount")) {
				Double peopleCount = (Double)doc.get("peopleCount_docvalues_double");
				if(peopleCount != null)
					oCrowdFlowObserved.setPeopleCount(peopleCount);
			}

			if(saves.contains("refRoadSegment")) {
				String refRoadSegment = (String)doc.get("refRoadSegment_docvalues_string");
				if(refRoadSegment != null)
					oCrowdFlowObserved.setRefRoadSegment(refRoadSegment);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oCrowdFlowObserved.setSeeAlso(seeAlso);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oCrowdFlowObserved.setSource(source);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexCrowdFlowObserved(JsonObject doc) {
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getY(), location.getX()));
		}
		if(areaServedColors != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedColors_indexedstored_strings", l);
			for(String o : areaServedColors) {
				l.add(CrowdFlowObserved.staticSearchAreaServedColors(siteRequest_, o));
			}
		}
		if(areaServedTitles != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedTitles_indexedstored_strings", l);
			for(String o : areaServedTitles) {
				l.add(CrowdFlowObserved.staticSearchAreaServedTitles(siteRequest_, o));
			}
		}
		if(areaServedLinks != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedLinks_indexedstored_strings", l);
			for(String o : areaServedLinks) {
				l.add(CrowdFlowObserved.staticSearchAreaServedLinks(siteRequest_, o));
			}
		}
		if(areaServed != null) {
			JsonArray pointsArray = new JsonArray();
			areaServed.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
			doc.put("areaServed_docvalues_location", new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString());
		}
		if(id != null) {
			doc.put("id_docvalues_string", id);
		}
		if(entityShortId != null) {
			doc.put("entityShortId_docvalues_string", entityShortId);
		}
		if(ngsildTenant != null) {
			doc.put("ngsildTenant_docvalues_string", ngsildTenant);
		}
		if(ngsildPath != null) {
			doc.put("ngsildPath_docvalues_string", ngsildPath);
		}
		if(ngsildContext != null) {
			doc.put("ngsildContext_docvalues_string", ngsildContext);
		}
		if(ngsildData != null) {
			doc.put("ngsildData_docvalues_string", ngsildData.encode());
		}
		if(address != null) {
			doc.put("address_docvalues_string", address.encode());
		}
		if(alternateName != null) {
			doc.put("alternateName_docvalues_string", alternateName);
		}
		if(averageCrowdSpeed != null) {
			doc.put("averageCrowdSpeed_docvalues_double", averageCrowdSpeed.doubleValue());
		}
		if(averageHeadwayTime != null) {
			doc.put("averageHeadwayTime_docvalues_double", averageHeadwayTime.doubleValue());
		}
		if(congested != null) {
			doc.put("congested_docvalues_boolean", congested);
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
		if(dateObserved != null) {
			doc.put("dateObserved_docvalues_string", dateObserved);
		}
		if(dateObservedFrom != null) {
			doc.put("dateObservedFrom_docvalues_string", dateObservedFrom);
		}
		if(dateObservedTo != null) {
			doc.put("dateObservedTo_docvalues_string", dateObservedTo);
		}
		if(direction != null) {
			doc.put("direction_docvalues_string", direction);
		}
		if(occupancy != null) {
			doc.put("occupancy_docvalues_double", occupancy.doubleValue());
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.encode());
		}
		if(peopleCount != null) {
			doc.put("peopleCount_docvalues_double", peopleCount.doubleValue());
		}
		if(refRoadSegment != null) {
			doc.put("refRoadSegment_docvalues_string", refRoadSegment);
		}
		if(seeAlso != null) {
			doc.put("seeAlso_docvalues_string", seeAlso);
		}
		if(source != null) {
			doc.put("source_docvalues_string", source);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredCrowdFlowObserved(String entityVar) {
		switch(entityVar) {
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "id":
				return "id_docvalues_string";
			case "entityShortId":
				return "entityShortId_docvalues_string";
			case "ngsildTenant":
				return "ngsildTenant_docvalues_string";
			case "ngsildPath":
				return "ngsildPath_docvalues_string";
			case "ngsildContext":
				return "ngsildContext_docvalues_string";
			case "ngsildData":
				return "ngsildData_docvalues_string";
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "averageCrowdSpeed":
				return "averageCrowdSpeed_docvalues_double";
			case "averageHeadwayTime":
				return "averageHeadwayTime_docvalues_double";
			case "congested":
				return "congested_docvalues_boolean";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "dateObserved":
				return "dateObserved_docvalues_string";
			case "dateObservedFrom":
				return "dateObservedFrom_docvalues_string";
			case "dateObservedTo":
				return "dateObservedTo_docvalues_string";
			case "direction":
				return "direction_docvalues_string";
			case "occupancy":
				return "occupancy_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "peopleCount":
				return "peopleCount_docvalues_double";
			case "refRoadSegment":
				return "refRoadSegment_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedCrowdFlowObserved(String entityVar) {
		switch(entityVar) {
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "location":
				return "location_docvalues_location";
			case "areaServedColors":
				return "areaServedColors_indexedstored_strings";
			case "areaServedTitles":
				return "areaServedTitles_indexedstored_strings";
			case "areaServedLinks":
				return "areaServedLinks_indexedstored_strings";
			case "areaServed":
				return "areaServed_docvalues_location";
			case "id":
				return "id_docvalues_string";
			case "entityShortId":
				return "entityShortId_docvalues_string";
			case "ngsildTenant":
				return "ngsildTenant_docvalues_string";
			case "ngsildPath":
				return "ngsildPath_docvalues_string";
			case "ngsildContext":
				return "ngsildContext_docvalues_string";
			case "ngsildData":
				return "ngsildData_docvalues_string";
			case "address":
				return "address_docvalues_string";
			case "alternateName":
				return "alternateName_docvalues_string";
			case "averageCrowdSpeed":
				return "averageCrowdSpeed_docvalues_double";
			case "averageHeadwayTime":
				return "averageHeadwayTime_docvalues_double";
			case "congested":
				return "congested_docvalues_boolean";
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "dateObserved":
				return "dateObserved_docvalues_string";
			case "dateObservedFrom":
				return "dateObservedFrom_docvalues_string";
			case "dateObservedTo":
				return "dateObservedTo_docvalues_string";
			case "direction":
				return "direction_docvalues_string";
			case "occupancy":
				return "occupancy_docvalues_double";
			case "owner":
				return "owner_docvalues_string";
			case "peopleCount":
				return "peopleCount_docvalues_double";
			case "refRoadSegment":
				return "refRoadSegment_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarCrowdFlowObserved(String searchVar) {
		switch(searchVar) {
			case "name_docvalues_string":
				return "name";
			case "description_docvalues_string":
				return "description";
			case "location_docvalues_location":
				return "location";
			case "areaServedColors_indexedstored_strings":
				return "areaServedColors";
			case "areaServedTitles_indexedstored_strings":
				return "areaServedTitles";
			case "areaServedLinks_indexedstored_strings":
				return "areaServedLinks";
			case "areaServed_docvalues_location":
				return "areaServed";
			case "id_docvalues_string":
				return "id";
			case "entityShortId_docvalues_string":
				return "entityShortId";
			case "ngsildTenant_docvalues_string":
				return "ngsildTenant";
			case "ngsildPath_docvalues_string":
				return "ngsildPath";
			case "ngsildContext_docvalues_string":
				return "ngsildContext";
			case "ngsildData_docvalues_string":
				return "ngsildData";
			case "address_docvalues_string":
				return "address";
			case "alternateName_docvalues_string":
				return "alternateName";
			case "averageCrowdSpeed_docvalues_double":
				return "averageCrowdSpeed";
			case "averageHeadwayTime_docvalues_double":
				return "averageHeadwayTime";
			case "congested_docvalues_boolean":
				return "congested";
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
			case "dateModified_docvalues_string":
				return "dateModified";
			case "dateObserved_docvalues_string":
				return "dateObserved";
			case "dateObservedFrom_docvalues_string":
				return "dateObservedFrom";
			case "dateObservedTo_docvalues_string":
				return "dateObservedTo";
			case "direction_docvalues_string":
				return "direction";
			case "occupancy_docvalues_double":
				return "occupancy";
			case "owner_docvalues_string":
				return "owner";
			case "peopleCount_docvalues_double":
				return "peopleCount";
			case "refRoadSegment_docvalues_string":
				return "refRoadSegment";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "source_docvalues_string":
				return "source";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchCrowdFlowObserved(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedCrowdFlowObserved(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeCrowdFlowObserved(doc);
	}
	public void storeCrowdFlowObserved(SolrResponse.Doc doc) {
		CrowdFlowObserved oCrowdFlowObserved = (CrowdFlowObserved)this;
		SiteRequest siteRequest = oCrowdFlowObserved.getSiteRequest_();

		oCrowdFlowObserved.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCrowdFlowObserved.addAreaServedColors(CrowdFlowObserved.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCrowdFlowObserved.addAreaServedTitles(CrowdFlowObserved.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oCrowdFlowObserved.addAreaServedLinks(CrowdFlowObserved.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		oCrowdFlowObserved.setAreaServed(Optional.ofNullable(doc.get("areaServed_docvalues_location")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setId(Optional.ofNullable(doc.get("id_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setEntityShortId(Optional.ofNullable(doc.get("entityShortId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setNgsildTenant(Optional.ofNullable(doc.get("ngsildTenant_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setNgsildPath(Optional.ofNullable(doc.get("ngsildPath_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setNgsildContext(Optional.ofNullable(doc.get("ngsildContext_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setNgsildData(Optional.ofNullable(doc.get("ngsildData_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setAverageCrowdSpeed(Optional.ofNullable(doc.get("averageCrowdSpeed_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setAverageHeadwayTime(Optional.ofNullable(doc.get("averageHeadwayTime_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setCongested(Optional.ofNullable(doc.get("congested_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDateObserved(Optional.ofNullable(doc.get("dateObserved_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDateObservedFrom(Optional.ofNullable(doc.get("dateObservedFrom_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDateObservedTo(Optional.ofNullable(doc.get("dateObservedTo_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setDirection(Optional.ofNullable(doc.get("direction_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setOccupancy(Optional.ofNullable(doc.get("occupancy_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setPeopleCount(Optional.ofNullable(doc.get("peopleCount_docvalues_double")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setRefRoadSegment(Optional.ofNullable(doc.get("refRoadSegment_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oCrowdFlowObserved.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestCrowdFlowObserved() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof CrowdFlowObserved) {
			CrowdFlowObserved original = (CrowdFlowObserved)o;
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
			if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
				apiRequest.addVars("areaServedColors");
			if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
				apiRequest.addVars("areaServedTitles");
			if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
				apiRequest.addVars("areaServedLinks");
			if(!Objects.equals(areaServed, original.getAreaServed()))
				apiRequest.addVars("areaServed");
			if(!Objects.equals(id, original.getId()))
				apiRequest.addVars("id");
			if(!Objects.equals(entityShortId, original.getEntityShortId()))
				apiRequest.addVars("entityShortId");
			if(!Objects.equals(ngsildTenant, original.getNgsildTenant()))
				apiRequest.addVars("ngsildTenant");
			if(!Objects.equals(ngsildPath, original.getNgsildPath()))
				apiRequest.addVars("ngsildPath");
			if(!Objects.equals(ngsildContext, original.getNgsildContext()))
				apiRequest.addVars("ngsildContext");
			if(!Objects.equals(ngsildData, original.getNgsildData()))
				apiRequest.addVars("ngsildData");
			if(!Objects.equals(address, original.getAddress()))
				apiRequest.addVars("address");
			if(!Objects.equals(alternateName, original.getAlternateName()))
				apiRequest.addVars("alternateName");
			if(!Objects.equals(averageCrowdSpeed, original.getAverageCrowdSpeed()) && averageCrowdSpeed != null && original.getAverageCrowdSpeed() != null && averageCrowdSpeed.compareTo(original.getAverageCrowdSpeed()) != 0)
				apiRequest.addVars("averageCrowdSpeed");
			if(!Objects.equals(averageHeadwayTime, original.getAverageHeadwayTime()) && averageHeadwayTime != null && original.getAverageHeadwayTime() != null && averageHeadwayTime.compareTo(original.getAverageHeadwayTime()) != 0)
				apiRequest.addVars("averageHeadwayTime");
			if(!Objects.equals(congested, original.getCongested()))
				apiRequest.addVars("congested");
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
			if(!Objects.equals(dateModified, original.getDateModified()))
				apiRequest.addVars("dateModified");
			if(!Objects.equals(dateObserved, original.getDateObserved()))
				apiRequest.addVars("dateObserved");
			if(!Objects.equals(dateObservedFrom, original.getDateObservedFrom()))
				apiRequest.addVars("dateObservedFrom");
			if(!Objects.equals(dateObservedTo, original.getDateObservedTo()))
				apiRequest.addVars("dateObservedTo");
			if(!Objects.equals(direction, original.getDirection()))
				apiRequest.addVars("direction");
			if(!Objects.equals(occupancy, original.getOccupancy()) && occupancy != null && original.getOccupancy() != null && occupancy.compareTo(original.getOccupancy()) != 0)
				apiRequest.addVars("occupancy");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(peopleCount, original.getPeopleCount()) && peopleCount != null && original.getPeopleCount() != null && peopleCount.compareTo(original.getPeopleCount()) != 0)
				apiRequest.addVars("peopleCount");
			if(!Objects.equals(refRoadSegment, original.getRefRoadSegment()))
				apiRequest.addVars("refRoadSegment");
			if(!Objects.equals(seeAlso, original.getSeeAlso()))
				apiRequest.addVars("seeAlso");
			if(!Objects.equals(source, original.getSource()))
				apiRequest.addVars("source");
			super.apiRequestBaseModel();
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
		sb.append(Optional.ofNullable(location).map(v -> "location: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(entityShortId).map(v -> "entityShortId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildTenant).map(v -> "ngsildTenant: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildPath).map(v -> "ngsildPath: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildContext).map(v -> "ngsildContext: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildData).map(v -> "ngsildData: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(averageCrowdSpeed).map(v -> "averageCrowdSpeed: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(averageHeadwayTime).map(v -> "averageHeadwayTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(congested).map(v -> "congested: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObserved).map(v -> "dateObserved: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedFrom).map(v -> "dateObservedFrom: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateObservedTo).map(v -> "dateObservedTo: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(direction).map(v -> "direction: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(occupancy).map(v -> "occupancy: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(peopleCount).map(v -> "peopleCount: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(refRoadSegment).map(v -> "refRoadSegment: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "CrowdFlowObserved";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.crowdflowobserved.CrowdFlowObserved";
	public static final String CLASS_API_ADDRESS_CrowdFlowObserved = "smart-aquaculture-enUS-CrowdFlowObserved";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_CrowdFlowObserved;
	}
	public static final String VAR_name = "name";
	public static final String VAR_description = "description";
	public static final String VAR_location = "location";
	public static final String VAR_areaServedColors = "areaServedColors";
	public static final String VAR_areaServedTitles = "areaServedTitles";
	public static final String VAR_areaServedLinks = "areaServedLinks";
	public static final String VAR_areaServed = "areaServed";
	public static final String VAR_id = "id";
	public static final String VAR_entityShortId = "entityShortId";
	public static final String VAR_ngsildTenant = "ngsildTenant";
	public static final String VAR_ngsildPath = "ngsildPath";
	public static final String VAR_ngsildContext = "ngsildContext";
	public static final String VAR_ngsildData = "ngsildData";
	public static final String VAR_address = "address";
	public static final String VAR_alternateName = "alternateName";
	public static final String VAR_averageCrowdSpeed = "averageCrowdSpeed";
	public static final String VAR_averageHeadwayTime = "averageHeadwayTime";
	public static final String VAR_congested = "congested";
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_dateObserved = "dateObserved";
	public static final String VAR_dateObservedFrom = "dateObservedFrom";
	public static final String VAR_dateObservedTo = "dateObservedTo";
	public static final String VAR_direction = "direction";
	public static final String VAR_occupancy = "occupancy";
	public static final String VAR_owner = "owner";
	public static final String VAR_peopleCount = "peopleCount";
	public static final String VAR_refRoadSegment = "refRoadSegment";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_source = "source";

	public static List<String> varsQForClass() {
		return CrowdFlowObserved.varsQCrowdFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsQCrowdFlowObserved(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return CrowdFlowObserved.varsFqCrowdFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsFqCrowdFlowObserved(List<String> vars) {
		vars.add(VAR_name);
		vars.add(VAR_description);
		vars.add(VAR_location);
		vars.add(VAR_areaServed);
		vars.add(VAR_id);
		vars.add(VAR_entityShortId);
		vars.add(VAR_ngsildTenant);
		vars.add(VAR_ngsildPath);
		vars.add(VAR_ngsildContext);
		vars.add(VAR_ngsildData);
		vars.add(VAR_address);
		vars.add(VAR_alternateName);
		vars.add(VAR_averageCrowdSpeed);
		vars.add(VAR_averageHeadwayTime);
		vars.add(VAR_congested);
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateModified);
		vars.add(VAR_dateObserved);
		vars.add(VAR_dateObservedFrom);
		vars.add(VAR_dateObservedTo);
		vars.add(VAR_direction);
		vars.add(VAR_occupancy);
		vars.add(VAR_owner);
		vars.add(VAR_peopleCount);
		vars.add(VAR_refRoadSegment);
		vars.add(VAR_seeAlso);
		vars.add(VAR_source);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return CrowdFlowObserved.varsRangeCrowdFlowObserved(new ArrayList<String>());
	}
	public static List<String> varsRangeCrowdFlowObserved(List<String> vars) {
		vars.add(VAR_location);
		vars.add(VAR_ngsildData);
		vars.add(VAR_address);
		vars.add(VAR_averageCrowdSpeed);
		vars.add(VAR_averageHeadwayTime);
		vars.add(VAR_occupancy);
		vars.add(VAR_owner);
		vars.add(VAR_peopleCount);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_location = "location";
	public static final String DISPLAY_NAME_areaServedColors = "area served colors";
	public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
	public static final String DISPLAY_NAME_areaServedLinks = "area served links";
	public static final String DISPLAY_NAME_areaServed = "area served";
	public static final String DISPLAY_NAME_id = "id";
	public static final String DISPLAY_NAME_entityShortId = "short entity ID";
	public static final String DISPLAY_NAME_ngsildTenant = "NGSILD-Tenant";
	public static final String DISPLAY_NAME_ngsildPath = "NGSILD-Path";
	public static final String DISPLAY_NAME_ngsildContext = "NGSILD context";
	public static final String DISPLAY_NAME_ngsildData = "NGSILD data";
	public static final String DISPLAY_NAME_address = "address";
	public static final String DISPLAY_NAME_alternateName = "alternate name";
	public static final String DISPLAY_NAME_averageCrowdSpeed = "average crowd speed";
	public static final String DISPLAY_NAME_averageHeadwayTime = "average headway time";
	public static final String DISPLAY_NAME_congested = "congested";
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_dateObserved = "date observed";
	public static final String DISPLAY_NAME_dateObservedFrom = "date observed from";
	public static final String DISPLAY_NAME_dateObservedTo = "date observed to";
	public static final String DISPLAY_NAME_direction = "direction";
	public static final String DISPLAY_NAME_occupancy = "occupancy";
	public static final String DISPLAY_NAME_owner = "owner";
	public static final String DISPLAY_NAME_peopleCount = "people count";
	public static final String DISPLAY_NAME_refRoadSegment = "ref road segment";
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
		return CrowdFlowObserved.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return description;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/crowd-flow-observed/%s";
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
		return CrowdFlowObserved.displayNameCrowdFlowObserved(var);
	}
	public static String displayNameCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_description:
			return DISPLAY_NAME_description;
		case VAR_location:
			return DISPLAY_NAME_location;
		case VAR_areaServedColors:
			return DISPLAY_NAME_areaServedColors;
		case VAR_areaServedTitles:
			return DISPLAY_NAME_areaServedTitles;
		case VAR_areaServedLinks:
			return DISPLAY_NAME_areaServedLinks;
		case VAR_areaServed:
			return DISPLAY_NAME_areaServed;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_entityShortId:
			return DISPLAY_NAME_entityShortId;
		case VAR_ngsildTenant:
			return DISPLAY_NAME_ngsildTenant;
		case VAR_ngsildPath:
			return DISPLAY_NAME_ngsildPath;
		case VAR_ngsildContext:
			return DISPLAY_NAME_ngsildContext;
		case VAR_ngsildData:
			return DISPLAY_NAME_ngsildData;
		case VAR_address:
			return DISPLAY_NAME_address;
		case VAR_alternateName:
			return DISPLAY_NAME_alternateName;
		case VAR_averageCrowdSpeed:
			return DISPLAY_NAME_averageCrowdSpeed;
		case VAR_averageHeadwayTime:
			return DISPLAY_NAME_averageHeadwayTime;
		case VAR_congested:
			return DISPLAY_NAME_congested;
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
		case VAR_dateModified:
			return DISPLAY_NAME_dateModified;
		case VAR_dateObserved:
			return DISPLAY_NAME_dateObserved;
		case VAR_dateObservedFrom:
			return DISPLAY_NAME_dateObservedFrom;
		case VAR_dateObservedTo:
			return DISPLAY_NAME_dateObservedTo;
		case VAR_direction:
			return DISPLAY_NAME_direction;
		case VAR_occupancy:
			return DISPLAY_NAME_occupancy;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_peopleCount:
			return DISPLAY_NAME_peopleCount;
		case VAR_refRoadSegment:
			return DISPLAY_NAME_refRoadSegment;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_source:
			return DISPLAY_NAME_source;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return "The name of this item";
		case VAR_description:
			return "A description of this item";
		case VAR_location:
			return "Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon";
		case VAR_areaServedColors:
			return "The colors of each areaServed Paths. ";
		case VAR_areaServedTitles:
			return "The titles of each areaServed Paths. ";
		case VAR_areaServedLinks:
			return "The links of each areaServed Paths. ";
		case VAR_areaServed:
			return "The geographic area where a service or offered item is provided";
		case VAR_id:
			return "Unique identifier of the entity";
		case VAR_entityShortId:
			return "A short ID for this Smart Data Model";
		case VAR_ngsildTenant:
			return "The NGSILD-Tenant or Fiware-Service";
		case VAR_ngsildPath:
			return "The NGSILD-Path or Fiware-ServicePath";
		case VAR_ngsildContext:
			return "The NGSILD context URL for @context data";
		case VAR_ngsildData:
			return "The NGSILD data with @context from the context broker";
		case VAR_address:
			return "The mailing address";
		case VAR_alternateName:
			return "An alternative name for this item";
		case VAR_averageCrowdSpeed:
			return "Average speed of the crowd transiting during the observation period";
		case VAR_averageHeadwayTime:
			return "Average headway time. Headway time is the time     elapsed between two consecutive persons";
		case VAR_congested:
			return "Flags whether there was a crowd congestion during the observation period in the referred walkway. The absence of this attribute means no crowd congestion";
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
		case VAR_dateObserved:
			return "The date and time of this observation in ISO8601 UTC format. It can be represented by an specific time instant or by an ISO8601 interval. As a workaround for the lack of support of Orion Context Broker for datetime intervals, it can be used two separate attributes: `dateObservedFrom`, `dateObservedTo`";
		case VAR_dateObservedFrom:
			return "Observation period start date and time. See `dateObserved`";
		case VAR_dateObservedTo:
			return "Observation period end date and time. See `dateObserved`.";
		case VAR_direction:
			return "Usual direction of travel in the walkway referred by this observation with respect to the city center. Enum:'inbound, outbound'";
		case VAR_occupancy:
			return "Fraction of the observation time where a person has been occupying the observed walkway";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_peopleCount:
			return "Total number of people detected during this observation";
		case VAR_refRoadSegment:
			return "Concerned road segment on which the observation has been made";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return "String";
		case VAR_description:
			return "String";
		case VAR_location:
			return "Point";
		case VAR_areaServedColors:
			return "List";
		case VAR_areaServedTitles:
			return "List";
		case VAR_areaServedLinks:
			return "List";
		case VAR_areaServed:
			return "Polygon";
		case VAR_id:
			return "String";
		case VAR_entityShortId:
			return "String";
		case VAR_ngsildTenant:
			return "String";
		case VAR_ngsildPath:
			return "String";
		case VAR_ngsildContext:
			return "String";
		case VAR_ngsildData:
			return "JsonObject";
		case VAR_address:
			return "JsonObject";
		case VAR_alternateName:
			return "String";
		case VAR_averageCrowdSpeed:
			return "BigDecimal";
		case VAR_averageHeadwayTime:
			return "BigDecimal";
		case VAR_congested:
			return "Boolean";
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
			return "String";
		case VAR_dateModified:
			return "String";
		case VAR_dateObserved:
			return "String";
		case VAR_dateObservedFrom:
			return "String";
		case VAR_dateObservedTo:
			return "String";
		case VAR_direction:
			return "String";
		case VAR_occupancy:
			return "BigDecimal";
		case VAR_owner:
			return "JsonObject";
		case VAR_peopleCount:
			return "BigDecimal";
		case VAR_refRoadSegment:
			return "String";
		case VAR_seeAlso:
			return "String";
		case VAR_source:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static String ngsiType(String var) {
		switch(var) {
		case VAR_name:
			return "Property";
		case VAR_description:
			return "Property";
		case VAR_location:
			return "GeoProperty";
		case VAR_areaServedColors:
			return "Property";
		case VAR_areaServedTitles:
			return "Property";
		case VAR_areaServedLinks:
			return "Property";
		case VAR_areaServed:
			return "GeoProperty";
		case VAR_id:
			return "Property";
		case VAR_entityShortId:
			return "Property";
		case VAR_ngsildTenant:
			return "Property";
		case VAR_ngsildPath:
			return "Property";
		case VAR_ngsildContext:
			return "Property";
		case VAR_ngsildData:
			return "Property";
		case VAR_address:
			return "Property";
		case VAR_alternateName:
			return "Property";
		case VAR_averageCrowdSpeed:
			return "Property";
		case VAR_averageHeadwayTime:
			return "Property";
		case VAR_congested:
			return "Property";
		case VAR_dataProvider:
			return "Property";
		case VAR_dateCreated:
			return "Property";
		case VAR_dateModified:
			return "Property";
		case VAR_dateObserved:
			return "Property";
		case VAR_dateObservedFrom:
			return "Property";
		case VAR_dateObservedTo:
			return "Property";
		case VAR_direction:
			return "Property";
		case VAR_occupancy:
			return "Property";
		case VAR_owner:
			return "Property";
		case VAR_peopleCount:
			return "Property";
		case VAR_refRoadSegment:
			return "Property";
		case VAR_seeAlso:
			return "Property";
		case VAR_source:
			return "Property";
			default:
				return null;
		}
	}

	public static Object ngsiCrowdFlowObserved(String var, CrowdFlowObserved o) {
		switch(var) {
		case VAR_name:
			return o.getName();
		case VAR_description:
			return o.getDescription();
		case VAR_location:
			return new JsonObject().put("type", "Point").put("coordinates", new JsonArray().add(Double.valueOf(o.getLocation().getX())).add(Double.valueOf(o.getLocation().getY())));
		case VAR_areaServedColors:
			return o.getAreaServedColors();
		case VAR_areaServedTitles:
			return o.getAreaServedTitles();
		case VAR_areaServedLinks:
			return o.getAreaServedLinks();
		case VAR_areaServed:
			JsonArray pointsArrayAreaServed = new JsonArray();
			o.getAreaServed().getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArrayAreaServed.add(pointArray));
			return new JsonObject().put("type", "LineString").put("coordinates", pointsArrayAreaServed);
		case VAR_id:
			return o.getId();
		case VAR_entityShortId:
			return o.getEntityShortId();
		case VAR_ngsildTenant:
			return o.getNgsildTenant();
		case VAR_ngsildPath:
			return o.getNgsildPath();
		case VAR_ngsildContext:
			return o.getNgsildContext();
		case VAR_ngsildData:
			return o.getNgsildData();
		case VAR_address:
			return o.getAddress();
		case VAR_alternateName:
			return o.getAlternateName();
		case VAR_averageCrowdSpeed:
			return o.getAverageCrowdSpeed();
		case VAR_averageHeadwayTime:
			return o.getAverageHeadwayTime();
		case VAR_congested:
			return o.getCongested();
		case VAR_dataProvider:
			return o.getDataProvider();
		case VAR_dateCreated:
			return o.getDateCreated();
		case VAR_dateModified:
			return o.getDateModified();
		case VAR_dateObserved:
			return o.getDateObserved();
		case VAR_dateObservedFrom:
			return o.getDateObservedFrom();
		case VAR_dateObservedTo:
			return o.getDateObservedTo();
		case VAR_direction:
			return o.getDirection();
		case VAR_occupancy:
			return o.getOccupancy();
		case VAR_owner:
			return o.getOwner();
		case VAR_peopleCount:
			return o.getPeopleCount();
		case VAR_refRoadSegment:
			return o.getRefRoadSegment();
		case VAR_seeAlso:
			return o.getSeeAlso();
		case VAR_source:
			return o.getSource();
			default:
				return null;
		}
	}

	public static Integer htmColumnCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return 1;
		case VAR_description:
			return 2;
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return 3;
		case VAR_description:
			return 3;
		case VAR_location:
			return 4;
		case VAR_areaServed:
			return 4;
		case VAR_id:
			return 5;
		case VAR_ngsildTenant:
			return 5;
		case VAR_ngsildPath:
			return 5;
		case VAR_ngsildContext:
			return 5;
		case VAR_ngsildData:
			return 5;
		case VAR_address:
			return 6;
		case VAR_alternateName:
			return 6;
		case VAR_averageCrowdSpeed:
			return 6;
		case VAR_averageHeadwayTime:
			return 6;
		case VAR_congested:
			return 6;
		case VAR_dataProvider:
			return 6;
		case VAR_dateCreated:
			return 6;
		case VAR_dateModified:
			return 6;
		case VAR_dateObserved:
			return 6;
		case VAR_dateObservedFrom:
			return 6;
		case VAR_dateObservedTo:
			return 6;
		case VAR_direction:
			return 6;
		case VAR_occupancy:
			return 6;
		case VAR_owner:
			return 6;
		case VAR_peopleCount:
			return 6;
		case VAR_refRoadSegment:
			return 6;
		case VAR_seeAlso:
			return 6;
		case VAR_source:
			return 6;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellCrowdFlowObserved(String var) {
		switch(var) {
		case VAR_name:
			return 0;
		case VAR_description:
			return 1;
		case VAR_location:
			return 0;
		case VAR_areaServed:
			return 1;
		case VAR_id:
			return 0;
		case VAR_ngsildTenant:
			return 1;
		case VAR_ngsildPath:
			return 2;
		case VAR_ngsildContext:
			return 3;
		case VAR_ngsildData:
			return 4;
		case VAR_address:
			return 0;
		case VAR_alternateName:
			return 1;
		case VAR_averageCrowdSpeed:
			return 2;
		case VAR_averageHeadwayTime:
			return 3;
		case VAR_congested:
			return 4;
		case VAR_dataProvider:
			return 5;
		case VAR_dateCreated:
			return 6;
		case VAR_dateModified:
			return 7;
		case VAR_dateObserved:
			return 8;
		case VAR_dateObservedFrom:
			return 9;
		case VAR_dateObservedTo:
			return 10;
		case VAR_direction:
			return 11;
		case VAR_occupancy:
			return 12;
		case VAR_owner:
			return 13;
		case VAR_peopleCount:
			return 14;
		case VAR_refRoadSegment:
			return 15;
		case VAR_seeAlso:
			return 16;
		case VAR_source:
			return 17;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinCrowdFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxCrowdFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxCrowdFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minCrowdFlowObserved(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
