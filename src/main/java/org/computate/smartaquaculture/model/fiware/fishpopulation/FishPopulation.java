package org.computate.smartaquaculture.model.fiware.fishpopulation;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 6
 * Description: Tracking fish population counts, maturation, and incubation over time. 
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
   * HtmCell: 4
   * Facet: true
   **/
  protected void _areaServed(List<Polygon> l) {
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: scientific name
	 * Description: The scientific name of the fish species. 
	 * HtmRow: 4
	 * HtmCell: 5
	 **/
	protected void _scientificName(Wrap<String> w) {
	}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: maturity days begin
   * Description: The range of days from birth for the fish population to become sexually mature. 
   * HtmRowTitleOpen: reproduction parameters
   * HtmRow: 7
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _maturityDaysBegin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(30));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: maturity days end
   * Description: The range of days from birth for the fish population to become sexually mature. 
   * HtmRow: 7
   * HtmCell: 1
   * Precision: 16
   **/
  protected void _maturityDaysEnd(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(160));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation days begin
   * Description: The range of days for egg incubation. 
   * HtmRowTitleOpen: reproduction parameters
   * HtmRow: 7
   * HtmCell: 2
   * Precision: 16
   **/
  protected void _incubationDaysBegin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(20));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation days end
   * Description: The range of days for egg incubation. 
   * HtmRow: 7
   * HtmCell: 3
   * Precision: 16
   **/
  protected void _incubationDaysEnd(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(40));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation number min
   * Description: The range of fish born after incubation. 
   * HtmRowTitleOpen: reproduction parameters
   * HtmRow: 7
   * HtmCell: 3
   **/
  protected void _incubationNumberMin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(30));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation number max
   * Description: The range of fish born after incubation. 
   * HtmRow: 7
   * HtmCell: 4
   **/
  protected void _incubationNumberMax(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(50));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: min percent of population pregnant
   * Description: The the percentage of the population that becomes pregnant at incubation time. 
   * HtmRow: 7
   * HtmCell: 5
   **/
  protected void _percentPopulationPregnantMin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(0.15));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: max percent of population pregnant
   * Description: The the percentage of the population that becomes pregnant at incubation time. 
   * HtmRow: 7
   * HtmCell: 6
   **/
  protected void _percentPopulationPregnantMax(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(0.25));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: populations at birth
   * Description: A list of population counts at birth. 
   * HtmRowTitleOpen: population parameters
   * HtmRow: 7
   * HtmCell: 8
   **/
  protected void _populationsAtBirth(List<Long> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: populations now
   * Description: A list of population counts now, since birth. 
   * HtmRow: 7
   * HtmCell: 9
   **/
  protected void _populationsNow(List<Long> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation date
   * Description: The date and time that incubation started for this fish population. 
   * HtmRow: 7
   * HtmCell: 10
   **/
  protected void _incubationDate(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: previous pouplation
   * Description: The previously known population count. 
   * HtmRow: 7
   * HtmCell: 12
   **/
  protected void _previousPopulation(Wrap<Long> w) {
    w.o(0L);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: incubation days now
   * Description: The current number of days of egg incubation. 
   * HtmRow: 7
   * HtmCell: 11
   * Precision: 16
   **/
  protected void _incubationDaysNow(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: water temperature in Fahrenheit
   * Description: The water temperature can affect fish population survival. 
   * HtmRow: 7
   * HtmCell: 12
   * Precision: 3
   **/
  protected void _waterTemperature(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(60));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: simulation
   * Description: Toggle the digital twin simulation
   * HtmRowTitleOpen: simulation parameters
   * HtmRow: 8
   * HtmCell: 0
   **/
  protected void _simulation(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: simulation delay in milliseconds
   * Description: The number of milliseconds to asynchronously wait before the next update event is sent. 
   * HtmRow: 8
   * HtmCell: 1
   **/
  protected void _simulationDelayMillis(Wrap<Long> w) {
    w.o(500L);
  }
}

