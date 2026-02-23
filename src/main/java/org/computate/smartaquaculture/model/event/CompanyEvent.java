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
package org.computate.smartaquaculture.model.event;

import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.result.BaseResult;
import org.computate.vertx.config.ComputateConfigKeys;

import io.vertx.pgclient.data.Point;

/**
 * Order: 2
 * Description.enUS: See the upcoming computate in-person and online events
 * Description.frFR: Voir les événements en personne et en ligne à venir de computate
 * AName.enUS: an event
 * AName.frFR: un événement
 * Icon: <i class="fa-duotone fa-regular fa-map-location-dot"></i>
 * Sort.desc: startDateTime
 * MenuDetails.enUS: info
 * MenuDetails.frFR: info
 * MenuDetailsOpen: true
 * 
 * PublicRead: true
 * SearchPageUri: /en-us/search/event
 * EditPageUri: /en-us/edit/event/{pageId}
 * DisplayPageUri: /en-us/shop/event/{pageId}
 * UserPageUri: /en-us/use/event/{pageId}
 * ApiUri: /en-us/api/event
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: CompanyEventPage
 *     ApiUri: /fr-fr/rechercher/evenement
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: CompanyEventPage
 *     ApiUri: /fr-fr/edition/evenement/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
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
public class CompanyEvent extends CompanyEventGen<BaseResult> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: event name
   * DisplayName.frFR: nom de l'événement
   * Description.enUS: The event name. 
   * Description.frFR: Le nom de l'événement. 
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 2
   * Facet: true
   * VarName: true
   */
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: event description
   * DisplayName.frFR: description de l'événement
   * Description.enUS: The event description. 
   * Description.frFR: La description de l'événement. 
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 3
   * Facet: true
   */
  protected void _description(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: start date time
   * DisplayName.frFR: date et heure de début
   * Description.enUS: The start date time. 
   * Description.frFR: La date et heure de début. 
   * HtmRow: 3
   * HtmCell: 3
   * HtmColumn: 1
   * Facet: true
   */
  protected void _startDateTime(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: end date time
   * DisplayName.frFR: date et heure de fin
   * Description.enUS: The end date time. 
   * Description.frFR: La date et heure de fin. 
   * HtmRow: 3
   * HtmCell: 4
   * Facet: true
   */
  protected void _endDateTime(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: price
   * DisplayName.frFR: prix
   * Description.enUS: The price of the product per developer. 
   * Description.frFR: Le prix du produit par développeur. 
   * HtmRow: 3
   * HtmCell: 5
   * Facet: true
   */
  protected void _price(Wrap<BigDecimal> w) {
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
   * Description.frFR: L'ID pour cette page.
   * VarId: true
   */
  protected void _pageId(Wrap<String> w) {
    w.o(toId(name));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: email template
   * DisplayName.frFR: modèle de courriel
   * Description.enUS: The HTML email template for this product. 
   * Description.frFR: Le modèle de courriel HTML pour ce produit. 
   */
  protected void _emailTemplate(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: store URL
   * DisplayName.frFR: URL du magasin
   * Description.enUS: The store URL for this page. 
   * Description.frFR: L'URL du magasin pour cette page.
   */
  protected void _storeUrl(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * Location: true
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: map location
   * DisplayName.frFR: emplacement sur la carte
   * HtmRow: 3
   * HtmCell: 1
   * Facet: true
   */
  protected void _location(Wrap<Point> w) {
  }

  /**
   * {@inheritDoc}
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: location colors
   * DisplayName.frFR: couleurs des emplacements
   * Description.enUS: The colors of each location Points. 
   * Description.frFR: Les couleurs de chaque point d'emplacement. 
   */
  protected void _locationColors(List<String> l) {
    l.add("#3388ff");
  }

  /**
   * {@inheritDoc}
   * LocationTitle: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: location titles
   * DisplayName.frFR: titres des emplacements
   * Description.enUS: The titles of each location Paths. 
   * Description.frFR: Les titres de chaque chemin d'emplacement. 
   */
  protected void _locationTitles(List<String> l) {
    l.add(objectTitle);
  }

  /**
   * {@inheritDoc}
   * LocationUrl: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: location links
   * DisplayName.frFR: liens des emplacements
   * Description.enUS: The links of each location Paths. 
   * Description.frFR: Les liens de chaque chemin d'emplacement. 
   */
  protected void _locationLinks(List<String> l) {
    l.add(editPage);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: dialog template
   * DisplayName.frFR: modèle de dialogue
   * Description.enUS: The dialog template for this product. 
   * Description.frFR: Le modèle de dialogue pour ce produit.
   */
  protected void _dialogTemplate(Wrap<String> w) {
    w.o(String.format("en-us/shop/event/%s/dialog.inc", pageId));
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
   * Description.frFR: Le type d'image
   */
  protected void _pageImageType(Wrap<String> c) {
  }

  /**
   * Persist: true
   * DocValues: true
   * Description.enUS: The image accessibility text. 
   * Description.frFR: Le texte d'accessibilité de l'image. 
   */
  protected void _pageImageAlt(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: labels string
   * DisplayName.frFR: chaîne d'étiquettes
   * Description.enUS: The labels String for this article comma-separated. 
   * Description.frFR: La chaîne d'étiquettes pour cet article, séparées par des virgules. 
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
}
