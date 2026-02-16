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
package org.computate.smartaquaculture.page;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.smartaquaculture.result.BaseResult;
import org.computate.smartaquaculture.request.SiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.search.list.SearchList;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;


/**
 * Order: 4
 * Description.enUS: Read the latest articles to learn more
 * Description.frFR: Lisez les derniers articles pour en savoir plus
 * AName.enUS: an article
 * AName.frFR: un article
 * Icon: <i class="fa-duotone fa-regular fa-newspaper"></i>
 * Sort.desc: courseNum
 * Sort.desc: lessonNum
 * Rows: 100
 * 
 * PublicRead: true
 * SearchPageUri: /en-us/search/article
 * EditPageUri: /en-us/edit/article/{pageId}
 * DisplayPageUri: /en-us/view/article/{pageId}
 * ApiUri: /en-us/api/article
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     ApiUri: /fr-fr/rechercher/article
 *   EditPageFrFR:
 *     Language: frFR
 *     ApiUri: /fr-fr/edition/article/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   PUTImport:
 *   DELETE:
 * 
 * AuthGroup:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     SuperAdmin:
 */
public class SitePage extends SitePageGen<BaseResult> {

  /**
   * {@inheritDoc}
   */
  protected void _article(Wrap<Boolean> w) {
    w.o(true);
  }

  /**
   * {@inheritDoc}
   */
  protected void _githubOrg(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.GITHUB_ORG));
  }

  /**
   * {@inheritDoc}
   */
  protected void _siteName(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_NAME));
  }

  /**
   * {@inheritDoc}
   */
  protected void _siteDisplayName(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_DISPLAY_NAME));
  }

  /**
   * {@inheritDoc}
   */
  protected void _sitePublicUrl(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_PUBLIC_URL));
  }

  /**
   * {@inheritDoc}
   */
  protected void _mailingListUrl(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.MAILING_LIST_URL));
  }

  /**
   * {@inheritDoc}
   */
  protected void _quayioOrg(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.QUAYIO_ORG));
  }

  /**
   * {@inheritDoc}
   */
  protected void _sitePomGroupId(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_POM_GROUP_ID));
  }

  /**
   * {@inheritDoc}
   */
  protected void _staticBaseUrl(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_BASE_URL));
  }

  /**
   * {@inheritDoc}
   */
  protected void _staticPath(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_PATH));
  }

  /**
   * {@inheritDoc}
   */
  protected void _siteBaseUrl(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: importance
   * DisplayName.frFR: importance
    * Description.enUS: The importance of this page. 
    * Description.frFR: L'importance de cette page.
   * Description: The importance of this page. 
   */
  protected void _importance(Wrap<BigDecimal> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: course number
   * DisplayName.frFR: numéro du cours
   * Description.enUS: The course number for this page. 
   * Description.frFR: Le numéro du cours pour cette page.
   */
  protected void _courseNum(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: lesson number
   * DisplayName.frFR: numéro de la leçon
   * Description.enUS: The lesson number for this page. 
   * Description.frFR: Le numéro de la leçon pour cette page.
   */
  protected void _lessonNum(Wrap<Integer> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: title
   * DisplayName.frFR: titre
   * Description.enUS: The title of this page. 
   * Description.frFR: Le titre de cette page.
   * HtmColumn: 1
   * VarName: true
   */
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: description
   * DisplayName.frFR: description
   * Description.enUS: The description of this page. 
   * Description.frFR: La description de cette page.
   * HtmColumn: 2
   * VarDescription: true
   */
  protected void _description(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 3
   * Facet: true
   * DisplayName.enUS: author name
   * DisplayName.frFR: nom de l'auteur
   * Description.enUS: The author name
   * Description.frFR: Le nom de l'auteur
   */
  protected void _authorName(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 3
   * Facet: true
   * DisplayName.enUS: author URL
   * DisplayName.frFR: URL de l'auteur
   * Description.enUS: The author URL
   * Description.frFR: L'URL de l'auteur
   */
  protected void _authorUrl(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRowTitleOpen: Useful URLs
   * HtmRow: 99
   * HtmCell: 1
   * Facet: true
   * DisplayName.enUS: Page ID
   * DisplayName.frFR: ID de la page
   * Description.enUS: The ID for this page. 
   * Description.frFR: L'ID de cette page.
   * VarId: true
   */
  protected void _pageId(Wrap<String> w) {
    toId(objectTitle);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 4
   * HtmCell: 1
   * Facet: true
   * DisplayName.enUS: image URI
   * DisplayName.frFR: URI de l'image
   * Description.enUS: The page image URI
   * Description.frFR: L'URI de l'image de la page
   */
  protected void _pageImageUri(Wrap<String> w) {
  }
  
  /**
   * DocValues: true
   * Description.enUS: The image width
   * Description.frFR: La largeur de l'image
   */
  protected void _pageImageWidth(Wrap<Integer> w) {
    if(pageImageUri != null) {
      Path path = Paths.get(siteRequest_.getConfig().getString(ConfigKeys.STATIC_PATH), pageImageUri);
      File file = path.toFile();
      if(file.exists()) {
        try {
          BufferedImage img = ImageIO.read(file);
          w.o(img.getWidth());
          setPageImageHeight(img.getHeight());
          setPageImageType(Files.probeContentType(path));
        } catch (Exception ex) {
          ExceptionUtils.rethrow(ex);
        }
      }
    }
  }

  /**
   * DocValues: true
   * Description.enUS: The image height
   * Description.frFR: La hauteur de l'image
   */
  protected void _pageImageHeight(Wrap<Integer> c) {
  }

  /**
   * DocValues: true
   * Description.enUS: The image type
   * Description.frFR: Le format d'image
   */
  protected void _pageImageType(Wrap<String> c) {
  }

  /**
   * Persist: true
   * DocValues: true
   * Description.enUS: The image accessibility text. 
   * Description.frFR: Le texte d'accès de l'image.
   */
  protected void _pageImageAlt(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: prerequisite article IDs
   * DisplayName.frFR: IDs des articles prérequis
   * Description.enUS: The prerequisite article IDs comma-separated. 
   * Description.frFR: Les IDs des articles prérequis séparés par des virgules. 
   */
  protected void _prerequisiteArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _prerequisiteArticleSearch(Promise<SearchList<SitePage>> promise) {
    SearchList<SitePage> l = new SearchList<>();
    if(prerequisiteArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(prerequisiteArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(SitePage.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName.enUS: prerequisite articles
   * DisplayName.frFR: articles prérequis
   * Description.enUS: A JSON array of prerequisite articles. 
   * Description.frFR: Un tableau JSON des articles prérequis. 
   */
  protected void _prerequisiteArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    prerequisiteArticleSearch.getList().stream().forEach(prerequisiteArticle -> {
        JsonObject obj = JsonObject.mapFrom(prerequisiteArticle);
        obj.remove(SitePage.VAR_prerequisiteArticles);
        obj.remove(SitePage.VAR_prerequisiteArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(SitePage.VAR_pageId, obj.getString(SitePage.VAR_pageId));
        obj2.put(SitePage.VAR_name, obj.getString(SitePage.VAR_name));
        obj2.put(SitePage.VAR_pageImageUri, obj.getString(SitePage.VAR_pageImageUri));
        obj2.put(SitePage.VAR_pageImageWidth, obj.getString(SitePage.VAR_pageImageWidth));
        obj2.put(SitePage.VAR_pageImageHeight, obj.getString(SitePage.VAR_pageImageHeight));
        obj2.put(SitePage.VAR_pageImageAlt, obj.getString(SitePage.VAR_pageImageAlt));
        obj2.put(SitePage.VAR_displayPage, obj.getString(SitePage.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: next article IDs
   * DisplayName.frFR: IDs des articles suivants
   * Description.enUS: The next article IDs comma-separated. 
   * Description.frFR: Les IDs des articles suivants séparés par des virgules. 
   */
  protected void _nextArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _nextArticleSearch(Promise<SearchList<SitePage>> promise) {
    SearchList<SitePage> l = new SearchList<>();
    if(nextArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(nextArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(SitePage.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName.enUS: next articles
   * DisplayName.frFR: articles suivants
   * Description.enUS: A JSON array of next articles. 
   * Description.frFR: Un tableau JSON des articles suivants. 
   */
  protected void _nextArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    nextArticleSearch.getList().stream().forEach(nextArticle -> {
        JsonObject obj = JsonObject.mapFrom(nextArticle);
        obj.remove(SitePage.VAR_nextArticles);
        obj.remove(SitePage.VAR_nextArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(SitePage.VAR_pageId, obj.getString(SitePage.VAR_pageId));
        obj2.put(SitePage.VAR_name, obj.getString(SitePage.VAR_name));
        obj2.put(SitePage.VAR_pageImageUri, obj.getString(SitePage.VAR_pageImageUri));
        obj2.put(SitePage.VAR_pageImageWidth, obj.getString(SitePage.VAR_pageImageWidth));
        obj2.put(SitePage.VAR_pageImageHeight, obj.getString(SitePage.VAR_pageImageHeight));
        obj2.put(SitePage.VAR_pageImageAlt, obj.getString(SitePage.VAR_pageImageAlt));
        obj2.put(SitePage.VAR_displayPage, obj.getString(SitePage.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: labels string
   * DisplayName.frFR: texte des étiquettes
   * Description.enUS: The labels String for this article comma-separated. 
   * Description.frFR: Le texte des étiquettes séparé par des virgules pour cet article. 
   */
  protected void _labelsString(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: labels
   * DisplayName.frFR: étiquettes
   * Description.enUS: The labels for this article. 
   * Description.frFR: Les étiquettes pour cet article. 
   */
  protected void _labels(List<String> l) {
    if(labelsString != null) {
      l.addAll(Arrays.asList(StringUtils.split(labelsString, ",")).stream().map(id -> id.trim()).collect(Collectors.toList()));
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: related article IDs
   * DisplayName.frFR: IDs des articles liés
   * Description.enUS: The related article IDs. 
   * Description.frFR: Les IDs des articles liés. 
   */
  protected void _relatedArticleIds(Wrap<String> w) {
  }

  /**
   * Ignore: true
   */
  protected void _relatedArticleSearch(Promise<SearchList<SitePage>> promise) {
    SearchList<SitePage> l = new SearchList<>();
    if(relatedArticleIds != null) {
      List<String> list = Arrays.asList(StringUtils.split(relatedArticleIds, ",")).stream().map(id -> id.trim()).collect(Collectors.toList());
      l.setC(SitePage.class);
      l.q("*:*");
      l.fq(String.format("pageId_docvalues_string:" + list.stream()
          .map(id -> SearchTool.escapeQueryChars(id))
          .collect(Collectors.joining(" OR ", "(", ")"))
          ));
      l.setStore(true);
    }
    promise.complete(l);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName.enUS: related articles
   * DisplayName.frFR: articles liés
   * Description.enUS: A JSON array of related articles. 
   * Description.frFR: Un tableau JSON d'articles liés. 
   */
  protected void _relatedArticles(Wrap<JsonArray> w) {
    JsonArray array = new JsonArray();
    relatedArticleSearch.getList().stream().forEach(relatedArticle -> {
        JsonObject obj = JsonObject.mapFrom(relatedArticle);
        obj.remove(SitePage.VAR_relatedArticles);
        obj.remove(SitePage.VAR_relatedArticleIds);
        JsonObject obj2 = new JsonObject();
        obj2.put(SitePage.VAR_pageId, obj.getString(SitePage.VAR_pageId));
        obj2.put(SitePage.VAR_name, obj.getString(SitePage.VAR_name));
        obj2.put(SitePage.VAR_pageImageUri, obj.getString(SitePage.VAR_pageImageUri));
        obj2.put(SitePage.VAR_pageImageWidth, obj.getString(SitePage.VAR_pageImageWidth));
        obj2.put(SitePage.VAR_pageImageHeight, obj.getString(SitePage.VAR_pageImageHeight));
        obj2.put(SitePage.VAR_pageImageAlt, obj.getString(SitePage.VAR_pageImageAlt));
        obj2.put(SitePage.VAR_displayPage, obj.getString(SitePage.VAR_displayPage));
        array.add(obj2);
    });
    w.o(array);
  }
}
