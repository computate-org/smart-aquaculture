package org.computate.smartaquaculture.model.fiware.fishingdock;

import java.time.ZonedDateTime;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.smartaquaculture.model.mapmodel.MapModel;
import org.computate.vertx.api.BaseApiServiceImpl;

import io.vertx.core.json.JsonObject;

/**
 * Order: 5
 * Description: A fishing dock
 * AName: a fishing dock
 * Icon: <i class="fa-duotone fa-regular fa-lighthouse"></i>
 * Rows: 100
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
	 * HtmRowTitleOpen: FishPopulation details
	 * HtmRow: 6
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _address(Wrap<JsonObject> w) {
	}
}
