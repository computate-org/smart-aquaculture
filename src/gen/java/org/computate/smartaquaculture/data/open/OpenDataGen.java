package org.computate.smartaquaculture.data.open;

import org.computate.smartaquaculture.request.SiteRequest;
import java.lang.Object;
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>TODO: </h3> * </ol>
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You should add a class comment <b>"ApiTag.enUS: ..."</b> to specify a group name for OpenData objects in the OpenAPI specification. 
 * It can be as simple as "ApiTag.enUS: OpenData". 
 * The OpenAPI spec for this tag can then be automatically generated. 
 * </li><li>You should add a class comment "ApiUri.enUS: /api/..." to specify the base URL for OpenData objects in the RESTful API. 
 * The OpenAPI spec and code to handle API requests to this base URL will then be automatically generated. 
 * </li><li>You should add a class comment "Indexed: true" because the GET, POST, PATCH and PUT APIs rely on a indexed data search engine to paginate, filter, sort and aggregate the data when it's queried. 
 * The code to index and retrieve the OpenData data in the search engine will then be automatically generated. 
 * </li>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class OpenDataGen into the class OpenData. 
 * </li><li>You can add a class comment "Rows: 100" if you wish the OpenData API to return more or less than 10 records by default. 
 * In this case, the API will return 100 records from the API instead of 10 by default. 
 * Each API has built in pagination of the search records to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </li><li>You can add a class comment "Order: " followed by an Integer to sort this class compared to other classes in the project. 
 * There is code that is generated that queries several classes and writes code for each class in a sequence. 
 * The Order comment allows you do define which order the class code is generated. 
 * </li><li>You can add a class comment "Model: true" if you wish to persist these OpenData objects in a relational PostgreSQL database transactionally in the RESTful API. 
 * The code to persist and query the OpenDataGen data in the database will then be automatically generated. 
 * </li>
 * <h3>About the OpenData class and it's generated class OpenDataGen&lt;Object&gt;: </h3>extends OpenDataGen
 * <p>
 * This Java class extends a generated Java class OpenDataGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.data.open.OpenData">Find the class OpenData in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends OpenDataGen<Object>
 * <p>This <code>class OpenData extends OpenDataGen&lt;Object&gt;</code>, which means it extends a newly generated OpenDataGen. 
 * The generated <code>class OpenDataGen extends Object</code> which means that OpenData extends OpenDataGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <p>This class contains a comment <b>"Api: true"</b>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiMethode: GETHomePage</h2>
 * <p>This class contains a comment <b>"ApiMethod: GETHomePage"</b>, which creates an API "GETHomePage". 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the OpenData class will inherit the helpful inherited class comments from the super class OpenDataGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class OpenData in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.data.open.OpenData&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.smartaquaculture.data.open in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaquaculture.data.open&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project smart-aquaculture in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aquaculture&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class OpenDataGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(OpenData.class);

	//////////////
	// initDeep //
	//////////////

	public OpenData initDeepOpenData(SiteRequest siteRequest_) {
		initDeepOpenData();
		return (OpenData)this;
	}

	public void initDeepOpenData() {
		initOpenData();
	}

	public void initOpenData() {
	}

	public void initDeepForClass(SiteRequest siteRequest_) {
		initDeepOpenData(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainOpenData(v);
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
	public Object obtainOpenData(String var) {
		OpenData oOpenData = (OpenData)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateOpenData(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateOpenData(String var, Object val) {
		OpenData oOpenData = (OpenData)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, OpenData o) {
		return staticSetOpenData(entityVar,  siteRequest_, v, o);
	}
	public static Object staticSetOpenData(String entityVar, SiteRequest siteRequest_, String v, OpenData o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchOpenData(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchOpenData(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
		return staticSearchStrOpenData(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrOpenData(String entityVar, SiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
		return staticSearchFqOpenData(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqOpenData(String entityVar, SiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	/////////////
	// persist //
	/////////////

	public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistOpenData(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistOpenData(String var, Object val) {
		String varLower = var.toLowerCase();
		return null;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "OpenData";
	public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.data.open.OpenData";
	public static final String CLASS_API_ADDRESS_OpenData = "smart-aquaculture-enUS-OpenData";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_OpenData;
	}


	public String idForClass() {
		return null;
	}

	public String titleForClass() {
		return null;
	}

	public String nameForClass() {
		return null;
	}

	public String classNameAdjectiveSingularForClass() {
		return null;
	}

	public String descriptionForClass() {
		return null;
	}

	public String classStringFormatUrlEditPageForClass() {
		return null;
	}

	public String classStringFormatUrlDisplayPageForClass() {
		return null;
	}

	public String classStringFormatUrlUserPageForClass() {
		return null;
	}

	public String classStringFormatUrlDownloadForClass() {
		return null;
	}

	public static String displayNameForClass(String var) {
		return OpenData.displayNameOpenData(var);
	}
	public static String displayNameOpenData(String var) {
		switch(var) {
		default:
			return null;
		}
	}

	public static String descriptionOpenData(String var) {
		if(var == null)
			return null;
		switch(var) {
			default:
				return null;
		}
	}

	public static String classSimpleNameOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmColumnOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmRowOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmCellOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMinOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMaxOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer maxOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer minOpenData(String var) {
		switch(var) {
			default:
				return null;
		}
	}
}
