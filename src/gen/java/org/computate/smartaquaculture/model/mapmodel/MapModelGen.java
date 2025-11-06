package org.computate.smartaquaculture.model.mapmodel;

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
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class MapModelGen into the class MapModel. 
 * </li>
 * <h3>About the MapModel class and it's generated class MapModelGen&lt;BaseModel&gt;: </h3>extends MapModelGen
 * <p>
 * This Java class extends a generated Java class MapModelGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel">Find the class MapModel in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends MapModelGen<BaseModel>
 * <p>This <code>class MapModel extends MapModelGen&lt;BaseModel&gt;</code>, which means it extends a newly generated MapModelGen. 
 * The generated <code>class MapModelGen extends BaseModel</code> which means that MapModel extends MapModelGen which extends BaseModel. 
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
 * <h2>ApiMethode: SearchPage</h2>
 * <p>This class contains a comment <b>"ApiMethod: SearchPage"</b>, which creates an API "SearchPage". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <b>"ApiTag: map models"</b>, which groups all of the OpenAPIs for MapModel objects under the tag "map models". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/map-model</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/map-model"</b>, which defines the base API URI for MapModel objects as "/en-us/api/map-model" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the MapModel class will inherit the helpful inherited class comments from the super class MapModelGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the MapModel API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartaquaculture.model.mapmodel.MapModelPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.mapmodel.MapModelPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the MapModel Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a map model</h2>
 * <p>This class contains a comment <b>"AName.enUS: a map model"</b>, which identifies the language context to describe a MapModel as "a map model". 
 * </p>
 * <p>
 * Delete the class MapModel in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.mapmodel in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class MapModelGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(MapModel.class);

	public static final String Description_enUS = "A map model";
	public static final String AName_enUS = "a map model";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this map model";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the map model";
	public static final String SingularName_enUS = "map model";
	public static final String PluralName_enUS = "map models";
	public static final String NameActual_enUS = "current map model";
	public static final String AllName_enUS = "all map models";
	public static final String SearchAllNameBy_enUS = "search map models by ";
	public static final String SearchAllName_enUS = "search map models";
	public static final String Title_enUS = "map models";
	public static final String ThePluralName_enUS = "the map models";
	public static final String NoNameFound_enUS = "no map model found";
	public static final String ApiUri_enUS = "/en-us/api/map-model";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/map-model";
	public static final String OfName_enUS = "of map model";
	public static final String ANameAdjective_enUS = "a map model";
	public static final String NameAdjectiveSingular_enUS = "map model";
	public static final String NameAdjectivePlural_enUS = "map models";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/map-model";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/map-model";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/map-model";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/map-model/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/map-model/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/map-model/%s";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/map-model";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/map-model";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/map-model";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-map-location-dot\"></i>";
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = MapModel.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchName(siteRequest_, MapModel.staticSetName(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = MapModel.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchDescription(siteRequest_, MapModel.staticSetDescription(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = MapModel.staticSetLocation(siteRequest_, o);
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
		this.location = MapModel.staticSetLocation(siteRequest_, o);
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
	protected MapModel locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (MapModel)this;
	}

	public static Point staticSearchLocation(SiteRequest siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequest siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchLocation(siteRequest_, MapModel.staticSetLocation(siteRequest_, o)).toString();
	}

	public Point sqlLocation() {
		return location;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = MapModel.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchId(siteRequest_, MapModel.staticSetId(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityShortId(Wrap<String> w);

	public String getEntityShortId() {
		return entityShortId;
	}
	public void setEntityShortId(String o) {
		this.entityShortId = MapModel.staticSetEntityShortId(siteRequest_, o);
	}
	public static String staticSetEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel entityShortIdInit() {
		Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
		if(entityShortId == null) {
			_entityShortId(entityShortIdWrap);
			Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
				setEntityShortId(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityShortId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityShortId(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchEntityShortId(siteRequest_, MapModel.staticSetEntityShortId(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:ngsildTenant">Find the entity ngsildTenant in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildTenant(Wrap<String> w);

	public String getNgsildTenant() {
		return ngsildTenant;
	}
	public void setNgsildTenant(String o) {
		this.ngsildTenant = MapModel.staticSetNgsildTenant(siteRequest_, o);
	}
	public static String staticSetNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel ngsildTenantInit() {
		Wrap<String> ngsildTenantWrap = new Wrap<String>().var("ngsildTenant");
		if(ngsildTenant == null) {
			_ngsildTenant(ngsildTenantWrap);
			Optional.ofNullable(ngsildTenantWrap.getO()).ifPresent(o -> {
				setNgsildTenant(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildTenant(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildTenant(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchNgsildTenant(siteRequest_, MapModel.staticSetNgsildTenant(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:ngsildPath">Find the entity ngsildPath in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildPath(Wrap<String> w);

	public String getNgsildPath() {
		return ngsildPath;
	}
	public void setNgsildPath(String o) {
		this.ngsildPath = MapModel.staticSetNgsildPath(siteRequest_, o);
	}
	public static String staticSetNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel ngsildPathInit() {
		Wrap<String> ngsildPathWrap = new Wrap<String>().var("ngsildPath");
		if(ngsildPath == null) {
			_ngsildPath(ngsildPathWrap);
			Optional.ofNullable(ngsildPathWrap.getO()).ifPresent(o -> {
				setNgsildPath(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildPath(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildPath(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchNgsildPath(siteRequest_, MapModel.staticSetNgsildPath(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:ngsildContext">Find the entity ngsildContext in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildContext(Wrap<String> w);

	public String getNgsildContext() {
		return ngsildContext;
	}
	public void setNgsildContext(String o) {
		this.ngsildContext = MapModel.staticSetNgsildContext(siteRequest_, o);
	}
	public static String staticSetNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel ngsildContextInit() {
		Wrap<String> ngsildContextWrap = new Wrap<String>().var("ngsildContext");
		if(ngsildContext == null) {
			_ngsildContext(ngsildContextWrap);
			Optional.ofNullable(ngsildContextWrap.getO()).ifPresent(o -> {
				setNgsildContext(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildContext(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildContext(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchNgsildContext(siteRequest_, MapModel.staticSetNgsildContext(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:ngsildData">Find the entity ngsildData in Solr</a>
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
		this.ngsildData = MapModel.staticSetNgsildData(siteRequest_, o);
	}
	public static JsonObject staticSetNgsildData(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected MapModel ngsildDataInit() {
		Wrap<JsonObject> ngsildDataWrap = new Wrap<JsonObject>().var("ngsildData");
		if(ngsildData == null) {
			_ngsildData(ngsildDataWrap);
			Optional.ofNullable(ngsildDataWrap.getO()).ifPresent(o -> {
				setNgsildData(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchNgsildData(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrNgsildData(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildData(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchNgsildData(siteRequest_, MapModel.staticSetNgsildData(siteRequest_, o)).toString();
	}

	public JsonObject sqlNgsildData() {
		return ngsildData;
	}

	///////////
	// color //
	///////////


	/**	 The entity color
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String color;

	/**	<br> The entity color
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.mapmodel.MapModel&fq=entiteVar_enUS_indexed_string:color">Find the entity color in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _color(Wrap<String> w);

	public String getColor() {
		return color;
	}
	public void setColor(String o) {
		this.color = MapModel.staticSetColor(siteRequest_, o);
	}
	public static String staticSetColor(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected MapModel colorInit() {
		Wrap<String> colorWrap = new Wrap<String>().var("color");
		if(color == null) {
			_color(colorWrap);
			Optional.ofNullable(colorWrap.getO()).ifPresent(o -> {
				setColor(o);
			});
		}
		return (MapModel)this;
	}

	public static String staticSearchColor(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrColor(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqColor(SiteRequest siteRequest_, String o) {
		return MapModel.staticSearchColor(siteRequest_, MapModel.staticSetColor(siteRequest_, o)).toString();
	}

	public String sqlColor() {
		return color;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<MapModelGen<DEV>> promiseDeepMapModel(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepMapModel();
	}

	public Future<MapModelGen<DEV>> promiseDeepMapModel() {
		Promise<MapModelGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseMapModel(promise2);
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

	public Future<Void> promiseMapModel(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				nameInit();
				descriptionInit();
				locationInit();
				idInit();
				entityShortIdInit();
				ngsildTenantInit();
				ngsildPathInit();
				ngsildContextInit();
				ngsildDataInit();
				colorInit();
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

	@Override public Future<? extends MapModelGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepMapModel(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestMapModel(SiteRequest siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestMapModel(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainMapModel(v);
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
	public Object obtainMapModel(String var) {
		MapModel oMapModel = (MapModel)this;
		switch(var) {
			case "name":
				return oMapModel.name;
			case "description":
				return oMapModel.description;
			case "location":
				return oMapModel.location;
			case "id":
				return oMapModel.id;
			case "entityShortId":
				return oMapModel.entityShortId;
			case "ngsildTenant":
				return oMapModel.ngsildTenant;
			case "ngsildPath":
				return oMapModel.ngsildPath;
			case "ngsildContext":
				return oMapModel.ngsildContext;
			case "ngsildData":
				return oMapModel.ngsildData;
			case "color":
				return oMapModel.color;
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
				o = relateMapModel(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateMapModel(String var, Object val) {
		MapModel oMapModel = (MapModel)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, MapModel o) {
		return staticSetMapModel(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetMapModel(String entityVar, SiteRequest siteRequest_, String v, MapModel o) {
		switch(entityVar) {
		case "name":
			return MapModel.staticSetName(siteRequest_, v);
		case "description":
			return MapModel.staticSetDescription(siteRequest_, v);
		case "location":
			return MapModel.staticSetLocation(siteRequest_, v);
		case "id":
			return MapModel.staticSetId(siteRequest_, v);
		case "entityShortId":
			return MapModel.staticSetEntityShortId(siteRequest_, v);
		case "ngsildTenant":
			return MapModel.staticSetNgsildTenant(siteRequest_, v);
		case "ngsildPath":
			return MapModel.staticSetNgsildPath(siteRequest_, v);
		case "ngsildContext":
			return MapModel.staticSetNgsildContext(siteRequest_, v);
		case "ngsildData":
			return MapModel.staticSetNgsildData(siteRequest_, v);
		case "color":
			return MapModel.staticSetColor(siteRequest_, v);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchMapModel(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchMapModel(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return MapModel.staticSearchName(siteRequest_, (String)o);
		case "description":
			return MapModel.staticSearchDescription(siteRequest_, (String)o);
		case "location":
			return MapModel.staticSearchLocation(siteRequest_, (Point)o);
		case "id":
			return MapModel.staticSearchId(siteRequest_, (String)o);
		case "entityShortId":
			return MapModel.staticSearchEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return MapModel.staticSearchNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return MapModel.staticSearchNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return MapModel.staticSearchNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return MapModel.staticSearchNgsildData(siteRequest_, (JsonObject)o);
		case "color":
			return MapModel.staticSearchColor(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrMapModel(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrMapModel(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return MapModel.staticSearchStrName(siteRequest_, (String)o);
		case "description":
			return MapModel.staticSearchStrDescription(siteRequest_, (String)o);
		case "location":
			return MapModel.staticSearchStrLocation(siteRequest_, (Point)o);
		case "id":
			return MapModel.staticSearchStrId(siteRequest_, (String)o);
		case "entityShortId":
			return MapModel.staticSearchStrEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return MapModel.staticSearchStrNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return MapModel.staticSearchStrNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return MapModel.staticSearchStrNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return MapModel.staticSearchStrNgsildData(siteRequest_, (String)o);
		case "color":
			return MapModel.staticSearchStrColor(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqMapModel(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqMapModel(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "name":
			return MapModel.staticSearchFqName(siteRequest_, o);
		case "description":
			return MapModel.staticSearchFqDescription(siteRequest_, o);
		case "location":
			return MapModel.staticSearchFqLocation(siteRequest_, o);
		case "id":
			return MapModel.staticSearchFqId(siteRequest_, o);
		case "entityShortId":
			return MapModel.staticSearchFqEntityShortId(siteRequest_, o);
		case "ngsildTenant":
			return MapModel.staticSearchFqNgsildTenant(siteRequest_, o);
		case "ngsildPath":
			return MapModel.staticSearchFqNgsildPath(siteRequest_, o);
		case "ngsildContext":
			return MapModel.staticSearchFqNgsildContext(siteRequest_, o);
		case "ngsildData":
			return MapModel.staticSearchFqNgsildData(siteRequest_, o);
		case "color":
			return MapModel.staticSearchFqColor(siteRequest_, o);
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
					o = persistMapModel(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistMapModel(String var, Object val) {
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
			} else if("color".equals(varLower)) {
				if(val instanceof String) {
					setColor((String)val);
				}
				saves.add("color");
				return val;
		} else {
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateMapModel(doc);
	}
	public void populateMapModel(SolrResponse.Doc doc) {
		MapModel oMapModel = (MapModel)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oMapModel.setName(name);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oMapModel.setDescription(description);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oMapModel.setLocation(location);
			}

			if(saves.contains("id")) {
				String id = (String)doc.get("id_docvalues_string");
				if(id != null)
					oMapModel.setId(id);
			}

			if(saves.contains("entityShortId")) {
				String entityShortId = (String)doc.get("entityShortId_docvalues_string");
				if(entityShortId != null)
					oMapModel.setEntityShortId(entityShortId);
			}

			if(saves.contains("ngsildTenant")) {
				String ngsildTenant = (String)doc.get("ngsildTenant_docvalues_string");
				if(ngsildTenant != null)
					oMapModel.setNgsildTenant(ngsildTenant);
			}

			if(saves.contains("ngsildPath")) {
				String ngsildPath = (String)doc.get("ngsildPath_docvalues_string");
				if(ngsildPath != null)
					oMapModel.setNgsildPath(ngsildPath);
			}

			if(saves.contains("ngsildContext")) {
				String ngsildContext = (String)doc.get("ngsildContext_docvalues_string");
				if(ngsildContext != null)
					oMapModel.setNgsildContext(ngsildContext);
			}

			if(saves.contains("ngsildData")) {
				String ngsildData = (String)doc.get("ngsildData_docvalues_string");
				if(ngsildData != null)
					oMapModel.setNgsildData(ngsildData);
			}

			if(saves.contains("color")) {
				String color = (String)doc.get("color_docvalues_string");
				if(color != null)
					oMapModel.setColor(color);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexMapModel(JsonObject doc) {
		if(name != null) {
			doc.put("name_docvalues_string", name);
		}
		if(description != null) {
			doc.put("description_docvalues_string", description);
		}
		if(location != null) {
			doc.put("location_docvalues_location", String.format("%s,%s", location.getY(), location.getX()));
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
		if(color != null) {
			doc.put("color_docvalues_string", color);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredMapModel(String entityVar) {
		switch(entityVar) {
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "location":
				return "location_docvalues_location";
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
			case "color":
				return "color_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedMapModel(String entityVar) {
		switch(entityVar) {
			case "name":
				return "name_docvalues_string";
			case "description":
				return "description_docvalues_string";
			case "location":
				return "location_docvalues_location";
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
			case "color":
				return "color_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarMapModel(String searchVar) {
		switch(searchVar) {
			case "name_docvalues_string":
				return "name";
			case "description_docvalues_string":
				return "description";
			case "location_docvalues_location":
				return "location";
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
			case "color_docvalues_string":
				return "color";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchMapModel(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedMapModel(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeMapModel(doc);
	}
	public void storeMapModel(SolrResponse.Doc doc) {
		MapModel oMapModel = (MapModel)this;
		SiteRequest siteRequest = oMapModel.getSiteRequest_();

		oMapModel.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		oMapModel.setId(Optional.ofNullable(doc.get("id_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setEntityShortId(Optional.ofNullable(doc.get("entityShortId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setNgsildTenant(Optional.ofNullable(doc.get("ngsildTenant_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setNgsildPath(Optional.ofNullable(doc.get("ngsildPath_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setNgsildContext(Optional.ofNullable(doc.get("ngsildContext_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setNgsildData(Optional.ofNullable(doc.get("ngsildData_docvalues_string")).map(v -> v.toString()).orElse(null));
		oMapModel.setColor(Optional.ofNullable(doc.get("color_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestMapModel() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof MapModel) {
			MapModel original = (MapModel)o;
			if(!Objects.equals(name, original.getName()))
				apiRequest.addVars("name");
			if(!Objects.equals(description, original.getDescription()))
				apiRequest.addVars("description");
			if(!Objects.equals(location, original.getLocation()))
				apiRequest.addVars("location");
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
			if(!Objects.equals(color, original.getColor()))
				apiRequest.addVars("color");
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
		sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(entityShortId).map(v -> "entityShortId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildTenant).map(v -> "ngsildTenant: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildPath).map(v -> "ngsildPath: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildContext).map(v -> "ngsildContext: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(ngsildData).map(v -> "ngsildData: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(color).map(v -> "color: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "MapModel";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.mapmodel.MapModel";
	public static final String CLASS_AUTH_RESOURCE = "MAPMODEL";
	public static final String CLASS_API_ADDRESS_MapModel = "smart-aquaculture-enUS-MapModel";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_MapModel;
	}
	public static final String VAR_name = "name";
	public static final String VAR_description = "description";
	public static final String VAR_location = "location";
	public static final String VAR_id = "id";
	public static final String VAR_entityShortId = "entityShortId";
	public static final String VAR_ngsildTenant = "ngsildTenant";
	public static final String VAR_ngsildPath = "ngsildPath";
	public static final String VAR_ngsildContext = "ngsildContext";
	public static final String VAR_ngsildData = "ngsildData";
	public static final String VAR_color = "color";

	public static List<String> varsQForClass() {
		return MapModel.varsQMapModel(new ArrayList<String>());
	}
	public static List<String> varsQMapModel(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return MapModel.varsFqMapModel(new ArrayList<String>());
	}
	public static List<String> varsFqMapModel(List<String> vars) {
		vars.add(VAR_name);
		vars.add(VAR_description);
		vars.add(VAR_location);
		vars.add(VAR_id);
		vars.add(VAR_entityShortId);
		vars.add(VAR_ngsildTenant);
		vars.add(VAR_ngsildPath);
		vars.add(VAR_ngsildContext);
		vars.add(VAR_ngsildData);
		vars.add(VAR_color);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return MapModel.varsRangeMapModel(new ArrayList<String>());
	}
	public static List<String> varsRangeMapModel(List<String> vars) {
		vars.add(VAR_location);
		vars.add(VAR_ngsildData);
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_name = "name";
	public static final String DISPLAY_NAME_description = "description";
	public static final String DISPLAY_NAME_location = "location";
	public static final String DISPLAY_NAME_id = "id";
	public static final String DISPLAY_NAME_entityShortId = "short entity ID";
	public static final String DISPLAY_NAME_ngsildTenant = "NGSILD-Tenant";
	public static final String DISPLAY_NAME_ngsildPath = "NGSILD-Path";
	public static final String DISPLAY_NAME_ngsildContext = "NGSILD context";
	public static final String DISPLAY_NAME_ngsildData = "NGSILD data";
	public static final String DISPLAY_NAME_color = "color";

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
		return MapModel.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return description;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return null;
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
		return MapModel.displayNameMapModel(var);
	}
	public static String displayNameMapModel(String var) {
		switch(var) {
		case VAR_name:
			return DISPLAY_NAME_name;
		case VAR_description:
			return DISPLAY_NAME_description;
		case VAR_location:
			return DISPLAY_NAME_location;
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
		case VAR_color:
			return DISPLAY_NAME_color;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionMapModel(String var) {
		if(var == null)
			return null;
		switch(var) {
		case VAR_name:
			return "The name. ";
		case VAR_description:
			return "The description. ";
		case VAR_location:
			return "Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon";
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
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameMapModel(String var) {
		switch(var) {
		case VAR_name:
			return "String";
		case VAR_description:
			return "String";
		case VAR_location:
			return "Point";
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
		case VAR_color:
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
		case VAR_color:
			return "Property";
			default:
				return null;
		}
	}

	public static Object ngsiMapModel(String var, MapModel o) {
		switch(var) {
		case VAR_name:
			return o.getName();
		case VAR_description:
			return o.getDescription();
		case VAR_location:
			return new JsonObject().put("type", "Point").put("coordinates", new JsonArray().add(Double.valueOf(o.getLocation().getX())).add(Double.valueOf(o.getLocation().getY())));
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
		case VAR_color:
			return o.getColor();
			default:
				return null;
		}
	}

	public static Integer htmColumnMapModel(String var) {
		switch(var) {
		case VAR_name:
			return 0;
		case VAR_description:
			return 3;
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowMapModel(String var) {
		switch(var) {
		case VAR_name:
			return 4;
		case VAR_description:
			return 4;
		case VAR_location:
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
		case VAR_color:
			return 4;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellMapModel(String var) {
		switch(var) {
		case VAR_name:
			return 0;
		case VAR_description:
			return 1;
		case VAR_location:
			return 0;
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
		case VAR_color:
			return 3;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinMapModel(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxMapModel(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxMapModel(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minMapModel(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
