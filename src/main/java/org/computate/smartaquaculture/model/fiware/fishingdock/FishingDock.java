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
package org.computate.smartaquaculture.model.fiware.fishingdock;

import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Polygon;

/**
 * Fiware: true
 * Order: 6
 * Description: A fishing dock
 * AName: a fishing dock
 * Icon: <i class="fa-duotone fa-regular fa-bridge-water"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M.8 455.3c4 17.2 21.2 27.9 38.4 23.9c24.5-5.7 44.9-16.5 58.2-25C126.5 469.7 159 480 192 480c31.9 0 60.6-9.9 80.4-18.9c5.8-2.7 11.1-5.3 15.6-7.7c4.5 2.4 9.7 5.1 15.6 7.7c19.8 9 48.5 18.9 80.4 18.9c33 0 65.5-10.3 94.5-25.8c13.4 8.4 33.7 19.3 58.2 25c17.2 4 34.4-6.7 38.4-23.9c.6-2.4 .8-4.9 .8-7.3c0-14.5-10-27.7-24.7-31.1c-18.1-4.2-36.2-13.3-50.6-25.2c-5.9-5-13.3-7.6-20.7-7.6c-6.5 0-12.9 2-18.5 5.9C439.4 405.2 410.9 416 384 416c-27.5 0-55-10.6-77.5-26.1c-11.1-7.9-25.9-7.9-37 0C247 405.4 219.5 416 192 416c-26.9 0-55.3-10.8-77.4-26.1C109 386 102.5 384 96 384c-7.4 0-14.8 2.6-20.7 7.6c-14.4 11.9-32.5 21-50.6 25.2c-17.2 4-27.9 21.2-23.9 38.4z"/><path class="fa-primary" d="M32 64C14.3 64 0 78.3 0 96l0 35.6C0 147.3 12.7 160 28.4 160C65.8 160 96 190.2 96 227.6l0 124.9c12.9 0 25.8 3.9 36.9 11.7c18 12.4 40.1 20.3 59.1 20.3c0-.2 0-.3 0-.5l0-128c0-53 43-96 96-96s96 43 96 96l0 128c0 .2 0 .3 0 .5c0 0 0 0 0 0c19 0 41.2-7.9 59.2-20.3c11.1-7.8 24-11.7 36.8-11.7l0-124.9c0-37.3 30.2-67.6 67.6-67.6c15.7 0 28.4-12.7 28.4-28.4L576 96c0-17.7-14.3-32-32-32L32 64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fishing-dock
 * EditPageUri: /en-us/edit/fishing-dock/{entityShortId}
 * ApiUri: /en-us/api/fishing-dock
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingDockViewer:
 *     GET:
 *   FishingDockEditor:
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
public class FishingDock extends FishingDockGen<MapModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: address
	 * Description: The mailing address
	 * HtmRowTitleOpen: fishing dock details
	 * HtmRow: 3
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _address(Wrap<JsonObject> w) {
	}

		@Override
	protected void _color(Wrap<String> w) {
		w.o("#003f9cff");
	}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: time zone
   * Description: The local time zone of the dock. 
   * HtmRow: 3
   * HtmCell: 1
   * Facet: true
   * Zone: true
   * Relate: TimeZone.id
   **/
  protected void _timeZone(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE));
  }

	/**
	 * {@inheritDoc}
	
	 * LocationColor: true
	 * Indexed: true
	 * Stored: true
	 * DisplayName: area served colors
	 * Description: The colors of each areaServed Paths. 
	 */
	protected void _areaServedColors(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * LocationTitle: true
	 * Indexed: true
	 * Stored: true
	 * DisplayName: area served titles
	 * Description: The titles of each areaServed Paths. 
	 */
	protected void _areaServedTitles(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * LocationUrl: true
	 * Indexed: true
	 * Stored: true
	 * DisplayName: area served links
	 * Description: The links of each areaServed Paths. 
	 */
	protected void _areaServedLinks(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * FiwareType: geo:linestring
	 * Area: true
	 * DocValues: true
	 * Persist: true
	 * DisplayName: area served
	 * Description: The geographic area where a service or offered item is provided
	 * HtmRow: 4
	 * HtmCell: 1
	 * Facet: true
	 **/
	protected void _areaServed(List<Polygon> l) {
	}
}
