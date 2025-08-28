package org.computate.smartaquaculture.model.fiware.fishpopulation;

import java.math.BigDecimal;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;

/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 6
 * Description: 
 * AName: a fish population
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3zM448 256a32 32 0 1 1 -64 0 32 32 0 1 1 64 0z"/><path class="fa-primary" d="M180.8 303.7c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8zM4.2 336.1L50 256 4.2 175.9c-6.9-12.1-5.2-27.2 4.2-37.5s24.3-13.3 36.9-7.5l99.5 45.6c10.5-11.9 22.5-23.8 35.7-35C219.7 108.5 272.6 80 336 80s116.3 28.5 155.5 61.5c39.1 33 66.9 72.4 81 99.8c4.7 9.2 4.7 20.1 0 29.3c-14.1 27.4-41.9 66.8-81 99.8C452.3 403.5 399.4 432 336 432s-116.3-28.5-155.5-61.5c-13.2-11.2-25.1-23.1-35.7-35L45.3 381.1c-12.6 5.8-27.6 2.8-36.9-7.5S-2.7 348.2 4.2 336.1zM416 224a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"/></svg>
 * LocationRadius: 100
 * 
 * SearchPageUri: /en-us/search/fish-population
 * EditPageUri: /en-us/edit/fish-population/{entityShortId}
 * ApiUri: /en-us/api/fish-population
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishPopulationViewer:
 *     GET:
 *   FishPopulationEditor:
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
 *     Admin:
 **/
public class FishPopulation extends FishPopulationGen<MapModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: address
	 * Description: The mailing address
	 * HtmRowTitleOpen: FishPopulation details
	 * HtmRow: 6
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _address(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: alternate name
	 * Description: An alternative name for this item
	 * HtmRow: 6
	 * HtmCell: 1
	 * Facet: true
	 **/
	protected void _alternateName(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: body masse
	 * Description: The average body masse cultured fishes
	 * HtmRow: 6
	 * HtmCell: 2
	 * Facet: true
	 **/
	protected void _bodyMasse(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: cultured in
	 * Description: Reference to the FishContainment
	 * HtmRow: 6
	 * HtmCell: 3
	 * Facet: true
	 **/
	protected void _culturedIn(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: data provider
	 * Description: A sequence of characters identifying the provider of the harmonised data entity
	 * HtmRow: 6
	 * HtmCell: 4
	 * Facet: true
	 **/
	protected void _dataProvider(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: date created
	 * Description: Entity creation timestamp. This will usually be allocated by the storage platform
	 * HtmRow: 6
	 * HtmCell: 5
	 * Facet: true
	 **/
	protected void _dateCreated(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: date modified
	 * Description: Timestamp of the last modification of the entity. This will usually be allocated by the storage platform
	 * HtmRow: 6
	 * HtmCell: 6
	 * Facet: true
	 **/
	protected void _dateModified(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: fish removed
	 * Description: Number of removed fishes
	 * HtmRow: 6
	 * HtmCell: 7
	 * Facet: true
	 **/
	protected void _fishRemoved(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: initial number
	 * Description: Number of initial number of cultured fishes
	 * HtmRow: 6
	 * HtmCell: 8
	 * Facet: true
	 **/
	protected void _initialNumber(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: owner
	 * Description: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
	 * HtmRow: 6
	 * HtmCell: 9
	 * Facet: true
	 **/
	protected void _owner(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: ref specie
	 * Description: Reference to the Specie
	 * HtmRow: 6
	 * HtmCell: 10
	 * Facet: true
	 **/
	protected void _refSpecie(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: related source
	 * Description: List of IDs the current entity may have in external applications
	 * HtmRow: 6
	 * HtmCell: 11
	 * Facet: true
	 **/
	protected void _relatedSource(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: see also
	 * Description: list of uri pointing to additional resources about the item
	 * HtmRow: 6
	 * HtmCell: 12
	 * Facet: true
	 **/
	protected void _seeAlso(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: source
	 * Description: A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object
	 * HtmRow: 6
	 * HtmCell: 13
	 * Facet: true
	 **/
	protected void _source(Wrap<String> w) {
	}

}

