
package org.computate.smartaquaculture.model;

import java.net.URLEncoder;
import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.model.base.ComputateBaseModel;

/**
 * Indexed: true
 * Model: true
 * Keyword: classSimpleNameBaseModel
 * Description: A reusable base class for all database model classes
 * Order: 0
 */
public class BaseModel extends BaseModelGen<Object> implements ComputateBaseModel {

  /**
   * {@inheritDoc}
   * Ignore: true
   * Description: The current request object
   */
  protected void _siteRequest_(Wrap<SiteRequest> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * PrimaryKey: true
   * Modify: false
   * HtmRowTitle: primary key, ID, created, modified, archive details
   * HtmRow: 1
   * HtmCell: 1
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: primary key
   * DisplayName.frFR: clé primaire
   * Description.enUS: The primary key of this object in the database
   * Description.frFR: La clé primaire de cet objet dans la base de données
   * Facet: true
   */
  protected void _pk(Wrap<Long> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Modify: false
   * VarCreated: true
   * HtmRow: 1
   * HtmCell: 3
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: created
   * DisplayName.frFR: créé
   * FormatHtm: MMM d, yyyy h:mm:ss a
   * Description.enUS: A created timestamp for this record in the database
   * Description.frFR: Un horodatage de création pour cet enregistrement dans la base de données
   * Facet: true
   */
  protected void _created(Wrap<ZonedDateTime> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Modify: false
   * VarModified: true
   * HtmRow: 1
   * HtmCell: 4
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: modified
   * DisplayName.frFR: modifié
   * Description.enUS: A modified timestamp for this record in the database
   * Description.frFR: Un horodatage de modification pour cet enregistrement dans la base de données
   * Facet: true
   */
  protected void _modified(Wrap<ZonedDateTime> w) {
    w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * HtmRow: 2
   * HtmCell: 1
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: archive
   * DisplayName.frFR: archiver
   * Description.enUS: For archiving this record
   * Description.frFR: Pour archiver cet enregistrement
   */
  protected void _archived(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Description: the canonical name of this Java class
   */
  protected void _classCanonicalName(Wrap<String> w) {
    w.o(getClass().getCanonicalName());
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Description: The simple name of this Java class
   * DisplayName.enUS: object type
   * Facet: true
   */
  protected void _classSimpleName(Wrap<String> w) {
    w.o(getClass().getSimpleName());
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Description: All the inherited canonical names of this Java class
   */
  protected void _classCanonicalNames(List<String> l) { 
    Class<?> cl = getClass();
    if(!cl.equals(BaseModel.class))
      l.add(cl.getCanonicalName());
    l.add(BaseModel.class.getCanonicalName());
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Modify: false
   * Description: The session ID of the user that created this object
   */
  protected void _sessionId(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Modify: false
   * Description: The primary key of the user that created this record
   */
  protected void _userKey(Wrap<Long> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Saves: true
   * Description: A list of fields that are saved for this record in the database
   */
  protected void _saves(List<String> l) {
  }

  /**
   * Description: A helper method for generating a URL friendly unique ID for this object
   */
  public static String toId(String s) {
    if(s != null) {
      s = Normalizer.normalize(s, Normalizer.Form.NFD);
      s = StringUtils.lowerCase(s);
      s = StringUtils.trim(s);
      s = StringUtils.replacePattern(s, "\\s{1,}", "-");
      s = StringUtils.replacePattern(s, "[^\\w-]", "");
      s = StringUtils.replacePattern(s, "-{2,}", "-");
    }

    return s;
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: title
   * DisplayName.frFR: titre
   * Description.enUS: The title of this page. 
   * Description.frFR: Le titre de cette page.
   * VarTitle: true
   */
  protected void _objectTitle(Wrap<String> w) {
    w.o(String.format("%s — %s", classNameAdjectiveSingularForClass(), nameForClass()));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: display page
   * DisplayName.frFR: page d'affichage
   * Description.enUS: Visit this landing page. 
   * Description.frFR: Visitez cette page d'accueil. 
   * Link: true
   * VarUrlDisplayPage.enUS: true
   */
  protected void _displayPage(Wrap<String> w) {
    String f = enUSStringFormatUrlDisplayPageForClass();
    if(f != null) {
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
    } else {
      f = enUSStringFormatUrlEditPageForClass();
      if(f != null) {
        w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: display page
   * DisplayName.frFR: page d'affichage
   * Description.enUS: Visit this landing page. 
   * Description.frFR: Visitez cette page d'accueil. 
   * Link: true
   * VarUrlDisplayPage.frFR: true
   */
  protected void _displayPageFrFR(Wrap<String> w) {
    String f = frFRStringFormatUrlDisplayPageForClass();
    if(f != null) {
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
    } else {
      f = frFRStringFormatUrlEditPageForClass();
      if(f != null) {
        w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: manage
   * DisplayName.frFR: gérer
   * Description.enUS: Manage this
   * Description.frFR: Gérer ceci
   * Link: true
   * Icon: <i class="fa-duotone fa-regular fa-pen-to-square"></i>
   * VarUrlEditPage.enUS: true
   */
  protected void _editPage(Wrap<String> w) {
    String f = enUSStringFormatUrlEditPageForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: manage
   * DisplayName.frFR: gérer
   * Description.enUS: Manage this
   * Description.frFR: Gérer ceci
   * Link: true
   * Icon: <i class="fa-duotone fa-regular fa-pen-to-square"></i>
   * VarUrlEditPage.frFR: true
   */
  protected void _editPageFrFR(Wrap<String> w) {
    String f = frFRStringFormatUrlEditPageForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: user
   * DisplayName.frFR: utilisateur
   * Description.enUS: User page
   * Description.frFR: Page utilisateur
   * Link: true
   * VarUrlUserPage.enUS: true
   */
  protected void _userPage(Wrap<String> w) {
    String f = enUSStringFormatUrlUserPageForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: user
   * DisplayName.frFR: utilisateur
   * Description.enUS: User page
   * Description.frFR: Page utilisateur
   * Link: true
   * VarUrlUserPage.frFR: true
   */
  protected void _userPageFrFR(Wrap<String> w) {
    String f = frFRStringFormatUrlUserPageForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: download
   * DisplayName.frFR: télécharger
   * Description.enUS: the download URL
   * Description.frFR: l'URL de téléchargement
   * Link: true
   * VarUrlDownload.enUS: true
   */
  protected void _download(Wrap<String> w) {
    String f = enUSStringFormatUrlDownloadForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: download
   * DisplayName.frFR: télécharger
   * Description.enUS: the download URL
   * Description.frFR: l'URL de téléchargement
   * Link: true
   * VarUrlDownload.frFR: true
   */
  protected void _downloadFrFR(Wrap<String> w) {
    String f = frFRStringFormatUrlDownloadForClass();
    if(f != null)
      w.o(String.format(f, siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), urlEncode(idForClass())));
  }

  /**
   * {@inheritDoc}
   * Suggested: true
   * DisplayName.enUS: autosuggest
   * DisplayName.frFR: suggérer automatiquement
   * Description.enUS: The indexed field in the search engine for this record while using autosuggest
   * Description.frFR: Le champ indexé dans le moteur de recherche pour cet enregistrement lors de l'utilisation de la suggestion automatique
   */
  protected void _objectSuggest(Wrap<String> w) { 
    StringBuilder b = new StringBuilder();
    String objectId = idForClass();
    String objectTitle = titleForClass();
    if(pk != null)
      b.append(" ").append(pk);
    if(objectId != null)
      b.append(" ").append(objectId);
    if(objectTitle != null)
      b.append(" ").append(objectTitle);
    w.o(b.toString());
  }

  /**
   * {@inheritDoc}
   * Text: true
   * DisplayName.enUS: text
   * DisplayName.frFR: texte
   * Description.enUS: The full text search field in the search engine for this record while using autosuggest
   * Description.frFR: Le champ de recherche plein texte dans le moteur de recherche pour cet enregistrement lors de l'utilisation de la suggestion automatique
   */
  protected void _objectText(List<String> l) { 
    String objectId = idForClass();
    String objectTitle = titleForClass();
    if(objectId != null)
      l.add(objectId);
    if(objectTitle != null)
      l.add(objectTitle);
  }

  /**
   * {@inheritDoc}
   * UniqueKey: true
   * Description: The unique key for this record in the search engine
   */
  protected void _solrId(Wrap<String> w) {
    if(pk != null)
      w.o(String.format("%s_%s_%s", getSiteRequest_().getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION), getClass().getSimpleName(), pk.toString()));
  }

  public static String urlEncode(String str) {
    try {
      return URLEncoder.encode(str, "UTF-8");
    } catch(Throwable ex) {
      ExceptionUtils.rethrow(ex);
      return null;
    }
  }
}
