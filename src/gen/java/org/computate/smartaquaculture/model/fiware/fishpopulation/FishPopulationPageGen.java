package org.computate.smartaquaculture.model.fiware.fishpopulation;

import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationGenPage;
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
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FishPopulationPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FishPopulationPageGen into the class FishPopulationPage. 
 * </li>
 * <h3>About the FishPopulationPage class and it's generated class FishPopulationPageGen&lt;FishPopulationGenPage&gt;: </h3>extends FishPopulationPageGen
 * <p>
 * This Java class extends a generated Java class FishPopulationPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationPage">Find the class FishPopulationPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FishPopulationPageGen<FishPopulationGenPage>
 * <p>This <code>class FishPopulationPage extends FishPopulationPageGen&lt;FishPopulationGenPage&gt;</code>, which means it extends a newly generated FishPopulationPageGen. 
 * The generated <code>class FishPopulationPageGen extends FishPopulationGenPage</code> which means that FishPopulationPage extends FishPopulationPageGen which extends FishPopulationGenPage. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FishPopulationPage class will inherit the helpful inherited class comments from the super class FishPopulationPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the FishPopulationPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class FishPopulationPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class FishPopulationPageGen<DEV> extends FishPopulationGenPage {
  protected static final Logger LOG = LoggerFactory.getLogger(FishPopulationPage.class);

  //////////////
  // initDeep //
  //////////////

  public Future<FishPopulationPageGen<DEV>> promiseDeepFishPopulationPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepFishPopulationPage();
  }

  public Future<FishPopulationPageGen<DEV>> promiseDeepFishPopulationPage() {
    Promise<FishPopulationPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseFishPopulationPage(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepFishPopulationGenPage(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseFishPopulationPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
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

  @Override public Future<? extends FishPopulationPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepFishPopulationPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestFishPopulationPage(SiteRequest siteRequest_) {
      super.siteRequestFishPopulationGenPage(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestFishPopulationPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainFishPopulationPage(v);
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
  public Object obtainFishPopulationPage(String var) {
    FishPopulationPage oFishPopulationPage = (FishPopulationPage)this;
    switch(var) {
      default:
        return super.obtainFishPopulationGenPage(var);
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
        o = relateFishPopulationPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateFishPopulationPage(String var, Object val) {
    FishPopulationPage oFishPopulationPage = (FishPopulationPage)this;
    switch(var) {
      default:
        return super.relateFishPopulationGenPage(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, FishPopulationPage o) {
    return staticSetFishPopulationPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetFishPopulationPage(String entityVar, SiteRequest siteRequest_, String v, FishPopulationPage o) {
    switch(entityVar) {
      default:
        return FishPopulationGenPage.staticSetFishPopulationGenPage(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchFishPopulationPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchFishPopulationPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return FishPopulationGenPage.staticSearchFishPopulationGenPage(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrFishPopulationPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrFishPopulationPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return FishPopulationGenPage.staticSearchStrFishPopulationGenPage(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqFishPopulationPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqFishPopulationPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
      default:
        return FishPopulationGenPage.staticSearchFqFishPopulationGenPage(entityVar,  siteRequest_, o);
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "FishPopulationPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaquaculture.model.fiware.fishpopulation.FishPopulationPage";
  public static final String CLASS_AUTH_RESOURCE = "";


  @Override
  public String idForClass() {
    return null;
  }

  @Override
  public String titleForClass() {
    return null;
  }

  @Override
  public String nameForClass() {
    return null;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return null;
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
    return null;
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
    return FishPopulationPage.displayNameFishPopulationPage(var);
  }
  public static String displayNameFishPopulationPage(String var) {
    switch(var) {
    default:
      return FishPopulationGenPage.displayNameFishPopulationGenPage(var);
    }
  }

  public static String descriptionFishPopulationPage(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return FishPopulationGenPage.descriptionFishPopulationGenPage(var);
    }
  }

  public static String classSimpleNameFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.classSimpleNameFishPopulationGenPage(var);
    }
  }

  public static Integer htmColumnFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.htmColumnFishPopulationGenPage(var);
    }
  }

  public static Integer htmRowFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.htmRowFishPopulationGenPage(var);
    }
  }

  public static Integer htmCellFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.htmCellFishPopulationGenPage(var);
    }
  }

  public static Integer lengthMinFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.lengthMinFishPopulationGenPage(var);
    }
  }

  public static Integer lengthMaxFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.lengthMaxFishPopulationGenPage(var);
    }
  }

  public static Integer maxFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.maxFishPopulationGenPage(var);
    }
  }

  public static Integer minFishPopulationPage(String var) {
    switch(var) {
      default:
        return FishPopulationGenPage.minFishPopulationGenPage(var);
    }
  }
}
