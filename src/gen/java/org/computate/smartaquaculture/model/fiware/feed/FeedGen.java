package org.computate.smartaquaculture.model.fiware.feed;

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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FeedGen into the class Feed. 
 * </li>
 * <h3>About the Feed class and it's generated class FeedGen&lt;BaseModel&gt;: </h3>extends FeedGen
 * <p>
 * This Java class extends a generated Java class FeedGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed">Find the class Feed in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FeedGen<BaseModel>
 * <p>This <code>class Feed extends FeedGen&lt;BaseModel&gt;</code>, which means it extends a newly generated FeedGen. 
 * The generated <code>class FeedGen extends BaseModel</code> which means that Feed extends FeedGen which extends BaseModel. 
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
 * <p>This class contains a comment <b>"ApiTag: Feeds"</b>, which groups all of the OpenAPIs for Feed objects under the tag "Feeds". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/feed</h2>
 * <p>This class contains a comment <b>"ApiUri: /en-us/api/feed"</b>, which defines the base API URI for Feed objects as "/en-us/api/feed" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <b>"Indexed: true"</b>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Feed class will inherit the helpful inherited class comments from the super class FeedGen. 
 * </p>
 * <h2>Rows: 100</h2>
 * <p>This class contains a comment <b>"Rows: 100"</b>, which means the Feed API will return a default of 100 records instead of 10 by default. 
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
 * This creates a new Java class org.computate.smartaquaculture.model.fiware.feed.FeedPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <b>"SuperPage.enUS: PageLayout"</b>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaquaculture.model.fiware.feed.FeedPage extends org.computate.smartaquaculture.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Feed Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a Feed</h2>
 * <p>This class contains a comment <b>"AName.enUS: a Feed"</b>, which identifies the language context to describe a Feed as "a Feed". 
 * </p>
 * <p>
 * Delete the class Feed in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.model.fiware.feed in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FeedGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(Feed.class);

	public static final String Description_enUS = "Feed tak for a group of animals";
	public static final String AName_enUS = "a Feed";
	public static final String This_enUS = "this ";
	public static final String ThisName_enUS = "this Feed";
	public static final String A_enUS = "a ";
	public static final String TheName_enUS = "the Feed";
	public static final String SingularName_enUS = "Feed";
	public static final String PluralName_enUS = "Feeds";
	public static final String NameActual_enUS = "current Feed";
	public static final String AllName_enUS = "all Feeds";
	public static final String SearchAllNameBy_enUS = "search Feeds by ";
	public static final String SearchAllName_enUS = "search Feeds";
	public static final String Title_enUS = "Feeds";
	public static final String ThePluralName_enUS = "the Feeds";
	public static final String NoNameFound_enUS = "no Feed found";
	public static final String ApiUri_enUS = "/en-us/api/feed";
	public static final String ApiUriSearchPage_enUS = "/en-us/search/feed";
	public static final String ApiUriEditPage_enUS = "/en-us/edit/feed/{entityShortId}";
	public static final String OfName_enUS = "of Feed";
	public static final String ANameAdjective_enUS = "a Feed";
	public static final String NameAdjectiveSingular_enUS = "Feed";
	public static final String NameAdjectivePlural_enUS = "Feeds";
	public static final String Search_enUS_OpenApiUri = "/en-us/api/feed";
	public static final String Search_enUS_StringFormatUri = "/en-us/api/feed";
	public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/feed";
	public static final String GET_enUS_OpenApiUri = "/en-us/api/feed/{entityShortId}";
	public static final String GET_enUS_StringFormatUri = "/en-us/api/feed/%s";
	public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/feed/%s";
	public static final String PATCH_enUS_OpenApiUri = "/en-us/api/feed";
	public static final String PATCH_enUS_StringFormatUri = "/en-us/api/feed";
	public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/feed";
	public static final String POST_enUS_OpenApiUri = "/en-us/api/feed";
	public static final String POST_enUS_StringFormatUri = "/en-us/api/feed";
	public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/feed";
	public static final String DELETE_enUS_OpenApiUri = "/en-us/api/feed/{entityShortId}";
	public static final String DELETE_enUS_StringFormatUri = "/en-us/api/feed/%s";
	public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/feed/%s";
	public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/feed-import";
	public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/feed-import";
	public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/feed-import";
	public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/feed";
	public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/feed";
	public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/feed";
	public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/feed/{entityShortId}";
	public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/feed/%s";
	public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/feed/%s";
	public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/feed";
	public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/feed";
	public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/feed";

	public static final String Icon = "<i class=\"fa-duotone fa-regular fa-fish-cooked\"></i>";
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _name(Wrap<String> w);

	public String getName() {
		return name;
	}
	public void setName(String o) {
		this.name = Feed.staticSetName(siteRequest_, o);
	}
	public static String staticSetName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed nameInit() {
		Wrap<String> nameWrap = new Wrap<String>().var("name");
		if(name == null) {
			_name(nameWrap);
			Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
				setName(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchName(siteRequest_, Feed.staticSetName(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:description">Find the entity description in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _description(Wrap<String> w);

	public String getDescription() {
		return description;
	}
	public void setDescription(String o) {
		this.description = Feed.staticSetDescription(siteRequest_, o);
	}
	public static String staticSetDescription(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed descriptionInit() {
		Wrap<String> descriptionWrap = new Wrap<String>().var("description");
		if(description == null) {
			_description(descriptionWrap);
			Optional.ofNullable(descriptionWrap.getO()).ifPresent(o -> {
				setDescription(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchDescription(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDescription(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDescription(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchDescription(siteRequest_, Feed.staticSetDescription(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:location">Find the entity location in Solr</a>
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
		this.location = Feed.staticSetLocation(siteRequest_, o);
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
		this.location = Feed.staticSetLocation(siteRequest_, o);
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
	protected Feed locationInit() {
		Wrap<Point> locationWrap = new Wrap<Point>().var("location");
		if(location == null) {
			_location(locationWrap);
			Optional.ofNullable(locationWrap.getO()).ifPresent(o -> {
				setLocation(o);
			});
		}
		return (Feed)this;
	}

	public static Point staticSearchLocation(SiteRequest siteRequest_, Point o) {
		return o;
	}

	public static String staticSearchStrLocation(SiteRequest siteRequest_, Point o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLocation(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchLocation(siteRequest_, Feed.staticSetLocation(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
		String l = Feed.staticSetAreaServedColors(siteRequest_, o);
		if(l != null)
			addAreaServedColors(l);
	}
	public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}
	public Feed addAreaServedColors(String...objects) {
		for(String o : objects) {
			addAreaServedColors(o);
		}
		return (Feed)this;
	}
	public Feed addAreaServedColors(String o) {
		if(o != null)
			this.areaServedColors.add(o);
		return (Feed)this;
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
	protected Feed areaServedColorsInit() {
		_areaServedColors(areaServedColors);
		return (Feed)this;
	}

	public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchAreaServedColors(siteRequest_, Feed.staticSetAreaServedColors(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
		String l = Feed.staticSetAreaServedTitles(siteRequest_, o);
		if(l != null)
			addAreaServedTitles(l);
	}
	public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}
	public Feed addAreaServedTitles(String...objects) {
		for(String o : objects) {
			addAreaServedTitles(o);
		}
		return (Feed)this;
	}
	public Feed addAreaServedTitles(String o) {
		if(o != null)
			this.areaServedTitles.add(o);
		return (Feed)this;
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
	protected Feed areaServedTitlesInit() {
		_areaServedTitles(areaServedTitles);
		return (Feed)this;
	}

	public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchAreaServedTitles(siteRequest_, Feed.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
		String l = Feed.staticSetAreaServedLinks(siteRequest_, o);
		if(l != null)
			addAreaServedLinks(l);
	}
	public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}
	public Feed addAreaServedLinks(String...objects) {
		for(String o : objects) {
			addAreaServedLinks(o);
		}
		return (Feed)this;
	}
	public Feed addAreaServedLinks(String o) {
		if(o != null)
			this.areaServedLinks.add(o);
		return (Feed)this;
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
	protected Feed areaServedLinksInit() {
		_areaServedLinks(areaServedLinks);
		return (Feed)this;
	}

	public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchAreaServedLinks(siteRequest_, Feed.staticSetAreaServedLinks(siteRequest_, o)).toString();
	}

	////////////////
	// areaServed //
	////////////////


	/**	 The entity areaServed
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonDeserialize(using = PgClientPolygonDeserializer.class)
	@JsonSerialize(using = PgClientPolygonSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<Polygon> areaServed = new ArrayList<Polygon>();

	/**	<br> The entity areaServed
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
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
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	@JsonIgnore
	public void setAreaServed(JsonObject o) {
		this.areaServed = Feed.staticSetAreaServed(siteRequest_, o);
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
				ExceptionUtils.rethrow(ex);
			}
		}
		return null;
	}
	public Feed addAreaServed(Polygon...objects) {
		for(Polygon o : objects) {
			addAreaServed(o);
		}
		return (Feed)this;
	}
	public Feed addAreaServed(Polygon o) {
		if(o != null)
			this.areaServed.add(o);
		return (Feed)this;
	}
	protected Feed areaServedInit() {
		_areaServed(areaServed);
		return (Feed)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = Feed.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchId(siteRequest_, Feed.staticSetId(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:entityShortId">Find the entity entityShortId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entityShortId(Wrap<String> w);

	public String getEntityShortId() {
		return entityShortId;
	}
	public void setEntityShortId(String o) {
		this.entityShortId = Feed.staticSetEntityShortId(siteRequest_, o);
	}
	public static String staticSetEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed entityShortIdInit() {
		Wrap<String> entityShortIdWrap = new Wrap<String>().var("entityShortId");
		if(entityShortId == null) {
			_entityShortId(entityShortIdWrap);
			Optional.ofNullable(entityShortIdWrap.getO()).ifPresent(o -> {
				setEntityShortId(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchEntityShortId(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEntityShortId(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEntityShortId(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchEntityShortId(siteRequest_, Feed.staticSetEntityShortId(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:ngsildTenant">Find the entity ngsildTenant in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildTenant(Wrap<String> w);

	public String getNgsildTenant() {
		return ngsildTenant;
	}
	public void setNgsildTenant(String o) {
		this.ngsildTenant = Feed.staticSetNgsildTenant(siteRequest_, o);
	}
	public static String staticSetNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed ngsildTenantInit() {
		Wrap<String> ngsildTenantWrap = new Wrap<String>().var("ngsildTenant");
		if(ngsildTenant == null) {
			_ngsildTenant(ngsildTenantWrap);
			Optional.ofNullable(ngsildTenantWrap.getO()).ifPresent(o -> {
				setNgsildTenant(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchNgsildTenant(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildTenant(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildTenant(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchNgsildTenant(siteRequest_, Feed.staticSetNgsildTenant(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:ngsildPath">Find the entity ngsildPath in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildPath(Wrap<String> w);

	public String getNgsildPath() {
		return ngsildPath;
	}
	public void setNgsildPath(String o) {
		this.ngsildPath = Feed.staticSetNgsildPath(siteRequest_, o);
	}
	public static String staticSetNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed ngsildPathInit() {
		Wrap<String> ngsildPathWrap = new Wrap<String>().var("ngsildPath");
		if(ngsildPath == null) {
			_ngsildPath(ngsildPathWrap);
			Optional.ofNullable(ngsildPathWrap.getO()).ifPresent(o -> {
				setNgsildPath(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchNgsildPath(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildPath(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildPath(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchNgsildPath(siteRequest_, Feed.staticSetNgsildPath(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:ngsildContext">Find the entity ngsildContext in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _ngsildContext(Wrap<String> w);

	public String getNgsildContext() {
		return ngsildContext;
	}
	public void setNgsildContext(String o) {
		this.ngsildContext = Feed.staticSetNgsildContext(siteRequest_, o);
	}
	public static String staticSetNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed ngsildContextInit() {
		Wrap<String> ngsildContextWrap = new Wrap<String>().var("ngsildContext");
		if(ngsildContext == null) {
			_ngsildContext(ngsildContextWrap);
			Optional.ofNullable(ngsildContextWrap.getO()).ifPresent(o -> {
				setNgsildContext(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchNgsildContext(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNgsildContext(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildContext(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchNgsildContext(siteRequest_, Feed.staticSetNgsildContext(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:ngsildData">Find the entity ngsildData in Solr</a>
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
		this.ngsildData = Feed.staticSetNgsildData(siteRequest_, o);
	}
	public static JsonObject staticSetNgsildData(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected Feed ngsildDataInit() {
		Wrap<JsonObject> ngsildDataWrap = new Wrap<JsonObject>().var("ngsildData");
		if(ngsildData == null) {
			_ngsildData(ngsildDataWrap);
			Optional.ofNullable(ngsildDataWrap.getO()).ifPresent(o -> {
				setNgsildData(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchNgsildData(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrNgsildData(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNgsildData(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchNgsildData(siteRequest_, Feed.staticSetNgsildData(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
		this.address = Feed.staticSetAddress(siteRequest_, o);
	}
	public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected Feed addressInit() {
		Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
		if(address == null) {
			_address(addressWrap);
			Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
				setAddress(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchAddress(siteRequest_, Feed.staticSetAddress(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _alternateName(Wrap<String> w);

	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String o) {
		this.alternateName = Feed.staticSetAlternateName(siteRequest_, o);
	}
	public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed alternateNameInit() {
		Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
		if(alternateName == null) {
			_alternateName(alternateNameWrap);
			Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
				setAlternateName(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchAlternateName(siteRequest_, Feed.staticSetAlternateName(siteRequest_, o)).toString();
	}

	public String sqlAlternateName() {
		return alternateName;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataProvider(Wrap<String> w);

	public String getDataProvider() {
		return dataProvider;
	}
	public void setDataProvider(String o) {
		this.dataProvider = Feed.staticSetDataProvider(siteRequest_, o);
	}
	public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed dataProviderInit() {
		Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
		if(dataProvider == null) {
			_dataProvider(dataProviderWrap);
			Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
				setDataProvider(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchDataProvider(siteRequest_, Feed.staticSetDataProvider(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateCreated(Wrap<String> w);

	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String o) {
		this.dateCreated = Feed.staticSetDateCreated(siteRequest_, o);
	}
	public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed dateCreatedInit() {
		Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
		if(dateCreated == null) {
			_dateCreated(dateCreatedWrap);
			Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
				setDateCreated(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchDateCreated(siteRequest_, Feed.staticSetDateCreated(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dateModified(Wrap<String> w);

	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String o) {
		this.dateModified = Feed.staticSetDateModified(siteRequest_, o);
	}
	public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed dateModifiedInit() {
		Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
		if(dateModified == null) {
			_dateModified(dateModifiedWrap);
			Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
				setDateModified(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchDateModified(siteRequest_, Feed.staticSetDateModified(siteRequest_, o)).toString();
	}

	public String sqlDateModified() {
		return dateModified;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
		this.owner = Feed.staticSetOwner(siteRequest_, o);
	}
	public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected Feed ownerInit() {
		Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
		if(owner == null) {
			_owner(ownerWrap);
			Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
				setOwner(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchOwner(siteRequest_, Feed.staticSetOwner(siteRequest_, o)).toString();
	}

	public JsonObject sqlOwner() {
		return owner;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:relatedSource">Find the entity relatedSource in Solr</a>
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
		this.relatedSource = Feed.staticSetRelatedSource(siteRequest_, o);
	}
	public static JsonObject staticSetRelatedSource(SiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected Feed relatedSourceInit() {
		Wrap<JsonObject> relatedSourceWrap = new Wrap<JsonObject>().var("relatedSource");
		if(relatedSource == null) {
			_relatedSource(relatedSourceWrap);
			Optional.ofNullable(relatedSourceWrap.getO()).ifPresent(o -> {
				setRelatedSource(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchRelatedSource(SiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrRelatedSource(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRelatedSource(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchRelatedSource(siteRequest_, Feed.staticSetRelatedSource(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeAlso(Wrap<String> w);

	public String getSeeAlso() {
		return seeAlso;
	}
	public void setSeeAlso(String o) {
		this.seeAlso = Feed.staticSetSeeAlso(siteRequest_, o);
	}
	public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed seeAlsoInit() {
		Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
		if(seeAlso == null) {
			_seeAlso(seeAlsoWrap);
			Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
				setSeeAlso(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchSeeAlso(siteRequest_, Feed.staticSetSeeAlso(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.feed.Feed&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _source(Wrap<String> w);

	public String getSource() {
		return source;
	}
	public void setSource(String o) {
		this.source = Feed.staticSetSource(siteRequest_, o);
	}
	public static String staticSetSource(SiteRequest siteRequest_, String o) {
		return o;
	}
	protected Feed sourceInit() {
		Wrap<String> sourceWrap = new Wrap<String>().var("source");
		if(source == null) {
			_source(sourceWrap);
			Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
				setSource(o);
			});
		}
		return (Feed)this;
	}

	public static String staticSearchSource(SiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
		return Feed.staticSearchSource(siteRequest_, Feed.staticSetSource(siteRequest_, o)).toString();
	}

	public String sqlSource() {
		return source;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<FeedGen<DEV>> promiseDeepFeed(SiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepFeed();
	}

	public Future<FeedGen<DEV>> promiseDeepFeed() {
		Promise<FeedGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseFeed(promise2);
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

	public Future<Void> promiseFeed(Promise<Void> promise) {
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
				dataProviderInit();
				dateCreatedInit();
				dateModifiedInit();
				ownerInit();
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

	@Override public Future<? extends FeedGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
		return promiseDeepFeed(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFeed(SiteRequest siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequest siteRequest_) {
		siteRequestFeed(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFeed(v);
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
	public Object obtainFeed(String var) {
		Feed oFeed = (Feed)this;
		switch(var) {
			case "name":
				return oFeed.name;
			case "description":
				return oFeed.description;
			case "location":
				return oFeed.location;
			case "areaServedColors":
				return oFeed.areaServedColors;
			case "areaServedTitles":
				return oFeed.areaServedTitles;
			case "areaServedLinks":
				return oFeed.areaServedLinks;
			case "areaServed":
				return oFeed.areaServed;
			case "id":
				return oFeed.id;
			case "entityShortId":
				return oFeed.entityShortId;
			case "ngsildTenant":
				return oFeed.ngsildTenant;
			case "ngsildPath":
				return oFeed.ngsildPath;
			case "ngsildContext":
				return oFeed.ngsildContext;
			case "ngsildData":
				return oFeed.ngsildData;
			case "address":
				return oFeed.address;
			case "alternateName":
				return oFeed.alternateName;
			case "dataProvider":
				return oFeed.dataProvider;
			case "dateCreated":
				return oFeed.dateCreated;
			case "dateModified":
				return oFeed.dateModified;
			case "owner":
				return oFeed.owner;
			case "relatedSource":
				return oFeed.relatedSource;
			case "seeAlso":
				return oFeed.seeAlso;
			case "source":
				return oFeed.source;
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
				o = relateFeed(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateFeed(String var, Object val) {
		Feed oFeed = (Feed)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Feed o) {
		return staticSetFeed(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetFeed(String entityVar, SiteRequest siteRequest_, String v, Feed o) {
		switch(entityVar) {
		case "name":
			return Feed.staticSetName(siteRequest_, v);
		case "description":
			return Feed.staticSetDescription(siteRequest_, v);
		case "location":
			return Feed.staticSetLocation(siteRequest_, v);
		case "areaServedColors":
			return Feed.staticSetAreaServedColors(siteRequest_, v);
		case "areaServedTitles":
			return Feed.staticSetAreaServedTitles(siteRequest_, v);
		case "areaServedLinks":
			return Feed.staticSetAreaServedLinks(siteRequest_, v);
		case "areaServed":
			return Feed.staticSetAreaServed(siteRequest_, v);
		case "id":
			return Feed.staticSetId(siteRequest_, v);
		case "entityShortId":
			return Feed.staticSetEntityShortId(siteRequest_, v);
		case "ngsildTenant":
			return Feed.staticSetNgsildTenant(siteRequest_, v);
		case "ngsildPath":
			return Feed.staticSetNgsildPath(siteRequest_, v);
		case "ngsildContext":
			return Feed.staticSetNgsildContext(siteRequest_, v);
		case "ngsildData":
			return Feed.staticSetNgsildData(siteRequest_, v);
		case "address":
			return Feed.staticSetAddress(siteRequest_, v);
		case "alternateName":
			return Feed.staticSetAlternateName(siteRequest_, v);
		case "dataProvider":
			return Feed.staticSetDataProvider(siteRequest_, v);
		case "dateCreated":
			return Feed.staticSetDateCreated(siteRequest_, v);
		case "dateModified":
			return Feed.staticSetDateModified(siteRequest_, v);
		case "owner":
			return Feed.staticSetOwner(siteRequest_, v);
		case "relatedSource":
			return Feed.staticSetRelatedSource(siteRequest_, v);
		case "seeAlso":
			return Feed.staticSetSeeAlso(siteRequest_, v);
		case "source":
			return Feed.staticSetSource(siteRequest_, v);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, v, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchFeed(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFeed(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return Feed.staticSearchName(siteRequest_, (String)o);
		case "description":
			return Feed.staticSearchDescription(siteRequest_, (String)o);
		case "location":
			return Feed.staticSearchLocation(siteRequest_, (Point)o);
		case "areaServedColors":
			return Feed.staticSearchAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return Feed.staticSearchAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return Feed.staticSearchAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return Feed.staticSearchAreaServed(siteRequest_, (Polygon)o);
		case "id":
			return Feed.staticSearchId(siteRequest_, (String)o);
		case "entityShortId":
			return Feed.staticSearchEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return Feed.staticSearchNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return Feed.staticSearchNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return Feed.staticSearchNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return Feed.staticSearchNgsildData(siteRequest_, (JsonObject)o);
		case "address":
			return Feed.staticSearchAddress(siteRequest_, (JsonObject)o);
		case "alternateName":
			return Feed.staticSearchAlternateName(siteRequest_, (String)o);
		case "dataProvider":
			return Feed.staticSearchDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return Feed.staticSearchDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return Feed.staticSearchDateModified(siteRequest_, (String)o);
		case "owner":
			return Feed.staticSearchOwner(siteRequest_, (JsonObject)o);
		case "relatedSource":
			return Feed.staticSearchRelatedSource(siteRequest_, (JsonObject)o);
		case "seeAlso":
			return Feed.staticSearchSeeAlso(siteRequest_, (String)o);
		case "source":
			return Feed.staticSearchSource(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrFeed(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFeed(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "name":
			return Feed.staticSearchStrName(siteRequest_, (String)o);
		case "description":
			return Feed.staticSearchStrDescription(siteRequest_, (String)o);
		case "location":
			return Feed.staticSearchStrLocation(siteRequest_, (Point)o);
		case "areaServedColors":
			return Feed.staticSearchStrAreaServedColors(siteRequest_, (String)o);
		case "areaServedTitles":
			return Feed.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
		case "areaServedLinks":
			return Feed.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
		case "areaServed":
			return Feed.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
		case "id":
			return Feed.staticSearchStrId(siteRequest_, (String)o);
		case "entityShortId":
			return Feed.staticSearchStrEntityShortId(siteRequest_, (String)o);
		case "ngsildTenant":
			return Feed.staticSearchStrNgsildTenant(siteRequest_, (String)o);
		case "ngsildPath":
			return Feed.staticSearchStrNgsildPath(siteRequest_, (String)o);
		case "ngsildContext":
			return Feed.staticSearchStrNgsildContext(siteRequest_, (String)o);
		case "ngsildData":
			return Feed.staticSearchStrNgsildData(siteRequest_, (String)o);
		case "address":
			return Feed.staticSearchStrAddress(siteRequest_, (String)o);
		case "alternateName":
			return Feed.staticSearchStrAlternateName(siteRequest_, (String)o);
		case "dataProvider":
			return Feed.staticSearchStrDataProvider(siteRequest_, (String)o);
		case "dateCreated":
			return Feed.staticSearchStrDateCreated(siteRequest_, (String)o);
		case "dateModified":
			return Feed.staticSearchStrDateModified(siteRequest_, (String)o);
		case "owner":
			return Feed.staticSearchStrOwner(siteRequest_, (String)o);
		case "relatedSource":
			return Feed.staticSearchStrRelatedSource(siteRequest_, (String)o);
		case "seeAlso":
			return Feed.staticSearchStrSeeAlso(siteRequest_, (String)o);
		case "source":
			return Feed.staticSearchStrSource(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqFeed(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFeed(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "name":
			return Feed.staticSearchFqName(siteRequest_, o);
		case "description":
			return Feed.staticSearchFqDescription(siteRequest_, o);
		case "location":
			return Feed.staticSearchFqLocation(siteRequest_, o);
		case "areaServedColors":
			return Feed.staticSearchFqAreaServedColors(siteRequest_, o);
		case "areaServedTitles":
			return Feed.staticSearchFqAreaServedTitles(siteRequest_, o);
		case "areaServedLinks":
			return Feed.staticSearchFqAreaServedLinks(siteRequest_, o);
		case "areaServed":
			return Feed.staticSearchFqAreaServed(siteRequest_, o);
		case "id":
			return Feed.staticSearchFqId(siteRequest_, o);
		case "entityShortId":
			return Feed.staticSearchFqEntityShortId(siteRequest_, o);
		case "ngsildTenant":
			return Feed.staticSearchFqNgsildTenant(siteRequest_, o);
		case "ngsildPath":
			return Feed.staticSearchFqNgsildPath(siteRequest_, o);
		case "ngsildContext":
			return Feed.staticSearchFqNgsildContext(siteRequest_, o);
		case "ngsildData":
			return Feed.staticSearchFqNgsildData(siteRequest_, o);
		case "address":
			return Feed.staticSearchFqAddress(siteRequest_, o);
		case "alternateName":
			return Feed.staticSearchFqAlternateName(siteRequest_, o);
		case "dataProvider":
			return Feed.staticSearchFqDataProvider(siteRequest_, o);
		case "dateCreated":
			return Feed.staticSearchFqDateCreated(siteRequest_, o);
		case "dateModified":
			return Feed.staticSearchFqDateModified(siteRequest_, o);
		case "owner":
			return Feed.staticSearchFqOwner(siteRequest_, o);
		case "relatedSource":
			return Feed.staticSearchFqRelatedSource(siteRequest_, o);
		case "seeAlso":
			return Feed.staticSearchFqSeeAlso(siteRequest_, o);
		case "source":
			return Feed.staticSearchFqSource(siteRequest_, o);
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
					o = persistFeed(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistFeed(String var, Object val) {
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
				if(val instanceof List<?>) {
					((List<Polygon>)val).stream().forEach(v -> addAreaServed(v));
				} else if(val instanceof Polygon[]) {
					Arrays.asList((Polygon[])val).stream().forEach(v -> addAreaServed((Polygon)v));
				} else if(val instanceof JsonObject) {
					staticSetAreaServed(siteRequest_, val.toString()).stream().forEach(v -> addAreaServed(v));
				} else if(val instanceof String) {
					staticSetAreaServed(siteRequest_, (String)val).stream().forEach(v -> addAreaServed(v));
				}
				if(!saves.contains("areaServed")) {
					saves.add("areaServed");
				}
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
			} else if("owner".equals(varLower)) {
				if(val instanceof String) {
					setOwner((String)val);
				} else if(val instanceof JsonObject) {
					setOwner((JsonObject)val);
				}
				saves.add("owner");
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
			return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateFeed(doc);
	}
	public void populateFeed(SolrResponse.Doc doc) {
		Feed oFeed = (Feed)this;
		saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
		if(saves != null) {

			if(saves.contains("name")) {
				String name = (String)doc.get("name_docvalues_string");
				if(name != null)
					oFeed.setName(name);
			}

			if(saves.contains("description")) {
				String description = (String)doc.get("description_docvalues_string");
				if(description != null)
					oFeed.setDescription(description);
			}

			if(saves.contains("location")) {
				Point location = (Point)doc.get("location_docvalues_location");
				if(location != null)
					oFeed.setLocation(location);
			}

			if(saves.contains("areaServedColors")) {
				List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
				if(areaServedColors != null) {
					areaServedColors.stream().forEach( v -> {
						oFeed.areaServedColors.add(Feed.staticSetAreaServedColors(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedTitles")) {
				List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
				if(areaServedTitles != null) {
					areaServedTitles.stream().forEach( v -> {
						oFeed.areaServedTitles.add(Feed.staticSetAreaServedTitles(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServedLinks")) {
				List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
				if(areaServedLinks != null) {
					areaServedLinks.stream().forEach( v -> {
						oFeed.areaServedLinks.add(Feed.staticSetAreaServedLinks(siteRequest_, v));
					});
				}
			}

			if(saves.contains("areaServed")) {
				List<Polygon> areaServed = (List<Polygon>)doc.get("areaServed_docvalues_location");
				if(areaServed != null) {
					areaServed.stream().forEach( v -> {
						oFeed.areaServed.add(v);
					});
				}
			}

			if(saves.contains("id")) {
				String id = (String)doc.get("id_docvalues_string");
				if(id != null)
					oFeed.setId(id);
			}

			if(saves.contains("entityShortId")) {
				String entityShortId = (String)doc.get("entityShortId_docvalues_string");
				if(entityShortId != null)
					oFeed.setEntityShortId(entityShortId);
			}

			if(saves.contains("ngsildTenant")) {
				String ngsildTenant = (String)doc.get("ngsildTenant_docvalues_string");
				if(ngsildTenant != null)
					oFeed.setNgsildTenant(ngsildTenant);
			}

			if(saves.contains("ngsildPath")) {
				String ngsildPath = (String)doc.get("ngsildPath_docvalues_string");
				if(ngsildPath != null)
					oFeed.setNgsildPath(ngsildPath);
			}

			if(saves.contains("ngsildContext")) {
				String ngsildContext = (String)doc.get("ngsildContext_docvalues_string");
				if(ngsildContext != null)
					oFeed.setNgsildContext(ngsildContext);
			}

			if(saves.contains("ngsildData")) {
				String ngsildData = (String)doc.get("ngsildData_docvalues_string");
				if(ngsildData != null)
					oFeed.setNgsildData(ngsildData);
			}

			if(saves.contains("address")) {
				String address = (String)doc.get("address_docvalues_string");
				if(address != null)
					oFeed.setAddress(address);
			}

			if(saves.contains("alternateName")) {
				String alternateName = (String)doc.get("alternateName_docvalues_string");
				if(alternateName != null)
					oFeed.setAlternateName(alternateName);
			}

			if(saves.contains("dataProvider")) {
				String dataProvider = (String)doc.get("dataProvider_docvalues_string");
				if(dataProvider != null)
					oFeed.setDataProvider(dataProvider);
			}

			if(saves.contains("dateCreated")) {
				String dateCreated = (String)doc.get("dateCreated_docvalues_string");
				if(dateCreated != null)
					oFeed.setDateCreated(dateCreated);
			}

			if(saves.contains("dateModified")) {
				String dateModified = (String)doc.get("dateModified_docvalues_string");
				if(dateModified != null)
					oFeed.setDateModified(dateModified);
			}

			if(saves.contains("owner")) {
				String owner = (String)doc.get("owner_docvalues_string");
				if(owner != null)
					oFeed.setOwner(owner);
			}

			if(saves.contains("relatedSource")) {
				String relatedSource = (String)doc.get("relatedSource_docvalues_string");
				if(relatedSource != null)
					oFeed.setRelatedSource(relatedSource);
			}

			if(saves.contains("seeAlso")) {
				String seeAlso = (String)doc.get("seeAlso_docvalues_string");
				if(seeAlso != null)
					oFeed.setSeeAlso(seeAlso);
			}

			if(saves.contains("source")) {
				String source = (String)doc.get("source_docvalues_string");
				if(source != null)
					oFeed.setSource(source);
			}
		}

		super.populateBaseModel(doc);
	}

	public void indexFeed(JsonObject doc) {
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
				l.add(Feed.staticSearchAreaServedColors(siteRequest_, o));
			}
		}
		if(areaServedTitles != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedTitles_indexedstored_strings", l);
			for(String o : areaServedTitles) {
				l.add(Feed.staticSearchAreaServedTitles(siteRequest_, o));
			}
		}
		if(areaServedLinks != null) {
			JsonArray l = new JsonArray();
			doc.put("areaServedLinks_indexedstored_strings", l);
			for(String o : areaServedLinks) {
				l.add(Feed.staticSearchAreaServedLinks(siteRequest_, o));
			}
		}
		if(areaServed != null) {
			doc.put("areaServed_docvalues_location", Optional.ofNullable(geojsonAreaServed()).map(geojson -> geojson.toString()).orElse(null));
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
		if(dataProvider != null) {
			doc.put("dataProvider_docvalues_string", dataProvider);
		}
		if(dateCreated != null) {
			doc.put("dateCreated_docvalues_string", dateCreated);
		}
		if(dateModified != null) {
			doc.put("dateModified_docvalues_string", dateModified);
		}
		if(owner != null) {
			doc.put("owner_docvalues_string", owner.encode());
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
		super.indexBaseModel(doc);

	}

	public static String varStoredFeed(String entityVar) {
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
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "owner":
				return "owner_docvalues_string";
			case "relatedSource":
				return "relatedSource_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedFeed(String entityVar) {
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
			case "dataProvider":
				return "dataProvider_docvalues_string";
			case "dateCreated":
				return "dateCreated_docvalues_string";
			case "dateModified":
				return "dateModified_docvalues_string";
			case "owner":
				return "owner_docvalues_string";
			case "relatedSource":
				return "relatedSource_docvalues_string";
			case "seeAlso":
				return "seeAlso_docvalues_string";
			case "source":
				return "source_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarFeed(String searchVar) {
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
			case "dataProvider_docvalues_string":
				return "dataProvider";
			case "dateCreated_docvalues_string":
				return "dateCreated";
			case "dateModified_docvalues_string":
				return "dateModified";
			case "owner_docvalues_string":
				return "owner";
			case "relatedSource_docvalues_string":
				return "relatedSource";
			case "seeAlso_docvalues_string":
				return "seeAlso";
			case "source_docvalues_string":
				return "source";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchFeed(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedFeed(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeFeed(doc);
	}
	public void storeFeed(SolrResponse.Doc doc) {
		Feed oFeed = (Feed)this;
		SiteRequest siteRequest = oFeed.getSiteRequest_();

		oFeed.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setDescription(Optional.ofNullable(doc.get("description_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setLocation(Optional.ofNullable(doc.get("location_docvalues_location")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFeed.addAreaServedColors(Feed.staticSetAreaServedColors(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFeed.addAreaServedTitles(Feed.staticSetAreaServedTitles(siteRequest, v.toString()));
		});
		Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oFeed.addAreaServedLinks(Feed.staticSetAreaServedLinks(siteRequest, v.toString()));
		});
		Optional.ofNullable((String)doc.get("areaServed_docvalues_location")).ifPresent(val -> staticSetAreaServed(siteRequest_, val.toString()).stream().forEach(v -> addAreaServed(v)));
		oFeed.setId(Optional.ofNullable(doc.get("id_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setEntityShortId(Optional.ofNullable(doc.get("entityShortId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setNgsildTenant(Optional.ofNullable(doc.get("ngsildTenant_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setNgsildPath(Optional.ofNullable(doc.get("ngsildPath_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setNgsildContext(Optional.ofNullable(doc.get("ngsildContext_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setNgsildData(Optional.ofNullable(doc.get("ngsildData_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setRelatedSource(Optional.ofNullable(doc.get("relatedSource_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
		oFeed.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestFeed() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof Feed) {
			Feed original = (Feed)o;
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
			if(!Objects.equals(dataProvider, original.getDataProvider()))
				apiRequest.addVars("dataProvider");
			if(!Objects.equals(dateCreated, original.getDateCreated()))
				apiRequest.addVars("dateCreated");
			if(!Objects.equals(dateModified, original.getDateModified()))
				apiRequest.addVars("dateModified");
			if(!Objects.equals(owner, original.getOwner()))
				apiRequest.addVars("owner");
			if(!Objects.equals(relatedSource, original.getRelatedSource()))
				apiRequest.addVars("relatedSource");
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
		sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(relatedSource).map(v -> "relatedSource: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "Feed";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.feed.Feed";
	public static final String CLASS_API_ADDRESS_Feed = "smart-aquaculture-enUS-Feed";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_Feed;
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
	public static final String VAR_dataProvider = "dataProvider";
	public static final String VAR_dateCreated = "dateCreated";
	public static final String VAR_dateModified = "dateModified";
	public static final String VAR_owner = "owner";
	public static final String VAR_relatedSource = "relatedSource";
	public static final String VAR_seeAlso = "seeAlso";
	public static final String VAR_source = "source";

	public static List<String> varsQForClass() {
		return Feed.varsQFeed(new ArrayList<String>());
	}
	public static List<String> varsQFeed(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return Feed.varsFqFeed(new ArrayList<String>());
	}
	public static List<String> varsFqFeed(List<String> vars) {
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
		vars.add(VAR_dataProvider);
		vars.add(VAR_dateCreated);
		vars.add(VAR_dateModified);
		vars.add(VAR_owner);
		vars.add(VAR_relatedSource);
		vars.add(VAR_seeAlso);
		vars.add(VAR_source);
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return Feed.varsRangeFeed(new ArrayList<String>());
	}
	public static List<String> varsRangeFeed(List<String> vars) {
		vars.add(VAR_location);
		vars.add(VAR_ngsildData);
		vars.add(VAR_address);
		vars.add(VAR_owner);
		vars.add(VAR_relatedSource);
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
	public static final String DISPLAY_NAME_dataProvider = "data provider";
	public static final String DISPLAY_NAME_dateCreated = "date created";
	public static final String DISPLAY_NAME_dateModified = "date modified";
	public static final String DISPLAY_NAME_owner = "owner";
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
		return Feed.NameAdjectiveSingular_enUS;
	}

	@Override
	public String descriptionForClass() {
		return description;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return "%s/en-us/edit/feed/%s";
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
		return Feed.displayNameFeed(var);
	}
	public static String displayNameFeed(String var) {
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
		case VAR_dataProvider:
			return DISPLAY_NAME_dataProvider;
		case VAR_dateCreated:
			return DISPLAY_NAME_dateCreated;
		case VAR_dateModified:
			return DISPLAY_NAME_dateModified;
		case VAR_owner:
			return DISPLAY_NAME_owner;
		case VAR_relatedSource:
			return DISPLAY_NAME_relatedSource;
		case VAR_seeAlso:
			return DISPLAY_NAME_seeAlso;
		case VAR_source:
			return DISPLAY_NAME_source;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionFeed(String var) {
		if(var == null)
			return null;
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
		case VAR_dataProvider:
			return "A sequence of characters identifying the provider of the harmonised data entity";
		case VAR_dateCreated:
			return "Entity creation timestamp. This will usually be allocated by the storage platform";
		case VAR_dateModified:
			return "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform";
		case VAR_owner:
			return "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)";
		case VAR_relatedSource:
			return "List of IDs the current entity may have in external applications";
		case VAR_seeAlso:
			return "list of uri pointing to additional resources about the item";
		case VAR_source:
			return "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object";
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameFeed(String var) {
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
			return "List";
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
		case VAR_dataProvider:
			return "String";
		case VAR_dateCreated:
			return "String";
		case VAR_dateModified:
			return "String";
		case VAR_owner:
			return "JsonObject";
		case VAR_relatedSource:
			return "JsonObject";
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
		case VAR_dataProvider:
			return "Property";
		case VAR_dateCreated:
			return "Property";
		case VAR_dateModified:
			return "Property";
		case VAR_owner:
			return "Property";
		case VAR_relatedSource:
			return "Property";
		case VAR_seeAlso:
			return "Property";
		case VAR_source:
			return "Property";
			default:
				return null;
		}
	}

	public static Object ngsiFeed(String var, Feed o) {
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
			return o.geojsonAreaServed();
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
		case VAR_dataProvider:
			return o.getDataProvider();
		case VAR_dateCreated:
			return o.getDateCreated();
		case VAR_dateModified:
			return o.getDateModified();
		case VAR_owner:
			return o.getOwner();
		case VAR_relatedSource:
			return o.getRelatedSource();
		case VAR_seeAlso:
			return o.getSeeAlso();
		case VAR_source:
			return o.getSource();
			default:
				return null;
		}
	}

	public static Integer htmColumnFeed(String var) {
		switch(var) {
		case VAR_name:
			return 1;
		case VAR_description:
			return 2;
			default:
				return BaseModel.htmColumnBaseModel(var);
		}
	}

	public static Integer htmRowFeed(String var) {
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
		case VAR_dataProvider:
			return 6;
		case VAR_dateCreated:
			return 6;
		case VAR_dateModified:
			return 6;
		case VAR_owner:
			return 6;
		case VAR_relatedSource:
			return 6;
		case VAR_seeAlso:
			return 6;
		case VAR_source:
			return 6;
			default:
				return BaseModel.htmRowBaseModel(var);
		}
	}

	public static Integer htmCellFeed(String var) {
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
		case VAR_dataProvider:
			return 2;
		case VAR_dateCreated:
			return 3;
		case VAR_dateModified:
			return 4;
		case VAR_owner:
			return 5;
		case VAR_relatedSource:
			return 6;
		case VAR_seeAlso:
			return 7;
		case VAR_source:
			return 8;
			default:
				return BaseModel.htmCellBaseModel(var);
		}
	}

	public static Integer lengthMinFeed(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxFeed(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxFeed(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minFeed(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
