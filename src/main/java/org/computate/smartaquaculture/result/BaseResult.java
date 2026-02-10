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
package org.computate.smartaquaculture.result;

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
import org.computate.vertx.result.base.ComputateBaseResult;

import io.vertx.core.Promise;

/**
 * Indexed: true
 * Keyword: classSimpleNameBaseResult
 * Description: A reusable base class for all non-model search classes
 * Order: 0
 * Promise: true
 */
public class BaseResult extends BaseResultGen<Object> implements ComputateBaseResult {

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
   * Persist: true
   * Modify: false
   * VarCreated: true
   * HtmRow: 1
   * HtmCell: 2
   * HidePOST: true
   * HidePATCH: true
   * HtmRowTitle.enUS: ID, created, modified, archive details
   * HtmRowTitle.frFR: ID, créé, modifié, détails d'archivage
   * DisplayName.enUS: created
   * FormatHtm: MMM d, yyyy h:mm:ss a
   * Description: A created timestamp for this record in the database
   * Facet: true
   */
  protected void _created(Wrap<ZonedDateTime> w) {
    w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Modify: false
   * VarModified: true
   * HtmRow: 1
   * HtmCell: 3
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: modified
   * Description: A modified timestamp for this record in the database
   * Facet: true
   */
  protected void _modified(Wrap<ZonedDateTime> w) {
    w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 2
   * HtmCell: 1
   * HidePOST: true
   * HidePATCH: true
   * DisplayName.enUS: archived
   * Description: For archiving this record
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
    l.add(getClass().getCanonicalName());
    l.add(BaseResult.class.getCanonicalName());
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
   * DisplayName: title
   * Description: The title of this page. 
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
   * DisplayName: display page
   * Description: Visit this landing page. 
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
   * DisplayName: display page
   * Description: Visit this landing page. 
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
   * DisplayName: manage
   * Description: Manage this
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
   * DisplayName: manage
   * Description: Manage this
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
   * DisplayName: user
   * Description: User page
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
   * DisplayName: user
   * Description: User page
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
   * DisplayName: download
   * Description: the download URL
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
   * DisplayName: download
   * Description: the download URL
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
   * Description: The indexed field in the search engine for this record while using autosuggest
   * DisplayName: autosuggest
   */
  protected void _objectSuggest(Wrap<String> w) { 
    StringBuilder b = new StringBuilder();
    
    String objectId = idForClass();
    String objectTitle = titleForClass();
    if(objectId != null)
      b.append(" ").append(objectId);
    if(objectTitle != null)
      b.append(" ").append(objectTitle);
    w.o(b.toString());
  }

  /**
   * {@inheritDoc}
   * Text: true
   * Description: The full text search field in the search engine for this record while using autosuggest
   * DisplayName: text
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
   * Persist: true
   * Description: The unique key for this record in the search engine
   */
  protected void _solrId(Wrap<String> w) {
    String objectId = idForClass();
    w.o(String.format("%s_%s_%s", getSiteRequest_().getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION), getClass().getSimpleName(), objectId));
  }

  public static String urlEncode(String str) {
    try {
      if(str == null)
        return null;
      else 
        return URLEncoder.encode(str, "UTF-8");
    } catch(Throwable ex) {
      ExceptionUtils.rethrow(ex);
      return null;
    }
  }
}
