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

import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Polygon;

/**
 * Fiware: true
 * Order: 9
 * Description.enUS: A fish processing plant
 * Description.frFR: Une usine de transformation du poisson
 * AName.enUS: a fish processing plant
 * AName.frFR: une usine de transformation du poisson
 * Icon: <i class="fa-duotone fa-regular fa-industry-windows"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M80 88c0-4.4 3.6-8 8-8l48 0c4.4 0 8 3.6 8 8l0 126.7c0 8.6 4.6 16.5 12 20.8s16.6 4.2 24-.1L320 153.8l0 70.9c0 8.8 4.8 16.8 12.5 21.1s17.1 3.9 24.5-.8l139.1-89L496 304l0 16 0 88c0 13.3-10.7 24-24 24l-368 0c-13.3 0-24-10.7-24-24l0-56 0-48L80 88zm48 224l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm120 0l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm120 0l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16z"/><path class="fa-primary" d="M80 88c0-4.4 3.6-8 8-8l48 0c4.4 0 8 3.6 8 8l0 126.7c0 8.6 4.6 16.5 12 20.8s16.6 4.2 24-.1L320 153.8l0 70.9c0 8.8 4.8 16.8 12.5 21.1s17.1 3.9 24.5-.8l139.1-89L496 304l0 16 0 88c0 13.3-10.7 24-24 24l-368 0c-13.3 0-24-10.7-24-24l0-56 0-48L80 88zm8-56C57.1 32 32 57.1 32 88l0 216 0 48 0 56c0 39.8 32.2 72 72 72l368 0c39.8 0 72-32.2 72-72l0-88 0-16 0-148.1c0-37.9-41.9-60.9-73.9-40.4L368 180.8l0-27c0-37-40.2-60.1-72.2-41.5L192 172.9 192 88c0-30.9-25.1-56-56-56L88 32zm56 264c-8.8 0-16 7.2-16 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0zm104 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0c-8.8 0-16 7.2-16 16zm136-16c-8.8 0-16 7.2-16 16l0 48c0 8.8 7.2 16 16 16l48 0c8.8 0 16-7.2 16-16l0-48c0-8.8-7.2-16-16-16l-48 0z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-processing
 * EditPageUri: /en-us/edit/fish-processing/{entityShortId}
 * ApiUri: /en-us/api/fish-processing
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: FishProcessingPage
 *     ApiUri: /fr-fr/rechercher/usine-transformation-poisson
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: FishProcessingPage
 *     ApiUri: /fr-fr/edition/usine-transformation-poisson/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishProcessingViewer:
 *     GET:
 *   FishProcessingEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 **/
public class FishProcessing extends FishProcessingGen<MapModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: address
   * DisplayName.frFR: adresse
   * Description.enUS: The mailing address
   * Description.frFR: L'adresse postale
   * HtmRowTitleOpen: FishPopulation details
   * HtmRow: 6
   * HtmCell: 0
   * Facet: true
   **/
  protected void _address(Wrap<JsonObject> w) {
  }

  @Override
  protected void _color(Wrap<String> w) {
    w.o("#036730ff");
  }

  /**
   * {@inheritDoc}
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served colors
   * DisplayName.frFR: couleurs de la zone desservie
   * Description.enUS: The colors of each areaServed Paths. 
   * Description.frFR: Les couleurs de chaque zone desservie des chemins.
   */
  protected void _areaServedColors(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * AreaTitle: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served titles
   * DisplayName.frFR: titres de la zone desservie
   * Description.enUS: The titles of each areaServed Paths. 
   * Description.frFR: Les titres de chaque zone desservie des chemins.
   */
  protected void _areaServedTitles(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * AreaUrl: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served links
   * DisplayName.frFR: liens de la zone desservie
   * Description.enUS: The links of each areaServed Paths. 
   * Description.frFR: Les liens de chaque zone desservie des chemins.
   */
  protected void _areaServedLinks(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * FiwareType: geo:linestring
   * Area: true
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: area served
   * DisplayName.frFR: zone desservie
   * Description.enUS: The geographic area where a service or offered item is provided
   * Description.frFR: La zone géographique où un service ou un article proposé est fourni
   * HtmRow: 4
   * HtmCell: 1
   * Facet: true
   **/
  protected void _areaServed(List<Polygon> l) {
  }
}
