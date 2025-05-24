package org.computate.smartaquaculture.model.fiware.fishingtrip;

import java.time.ZonedDateTime;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;

/**
 * Order: 5
 * Description: A fishing trip
 * AName: a fishing trip
 * Icon: <i class="fa-duotone fa-regular fa-fish-cooked"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/fishing-trip
 * EditPageUri: /en-us/edit/fishing-trip/{pk}
 * ApiUri: /en-us/api/fishing-trip
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishingTripViewer:
 *     GET:
 *   FishingTripEditor:
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
 **/
public class FishingTrip extends FishingTripGen<BaseModel> {

  /**
   * VarId: true
   */
  @Override
  protected void _pk(Wrap<Long> w) {
  super._pk(w);
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: time zone
	 * Description: The local time zone the fishing trip departure and arrival dates are based on. 
	 * HtmRowTitleOpen: departure/arrival
	 * HtmRow: 3
	 * HtmCell: 0
	 * Facet: true
	 * Zone: true
	 * Relate: TimeZone.id
	 **/
	protected void _timeZone(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: departure date
	 * Description: The date and time the fishing trip departed. 
	 * HtmColumn: 1
	 * HtmRow: 3
	 * HtmCell: 1
	 * Facet: true
	 **/
	protected void _departureDate(Wrap<ZonedDateTime> w) {
    w.o(created);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: arrival date
	 * Description: The date and time the fishing trip returned. 
	 * HtmColumn: 2
	 * HtmRow: 3
	 * HtmCell: 2
	 * Facet: true
	 **/
	protected void _arrivalDate(Wrap<ZonedDateTime> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: name
	 * Description: The name of this fishing trip. 
	 * HtmRowTitleOpen: name and description
	 * HtmColumn: 0
	 * VarName: true
	 * HtmRow: 4
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _name(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: description
	 * Description: A description of this fishing trip. 
	 * HtmColumn: 3
	 * VarDescription: true
	 * HtmRow: 4
	 * HtmCell: 1
	 * Facet: true
	 **/
	protected void _description(Wrap<String> w) {
	}
}
