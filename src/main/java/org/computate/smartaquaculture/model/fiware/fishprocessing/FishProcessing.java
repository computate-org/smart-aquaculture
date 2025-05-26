package org.computate.smartaquaculture.model.fiware.fishprocessing;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;

/**
 * Order: 5
 * Description: A fish processing plant
 * AName: a fish processing plant
 * Icon: <i class="fa-duotone fa-regular fa-industry-windows"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/fish-processing
 * EditPageUri: /en-us/edit/fish-processing/{entityShortId}
 * ApiUri: /en-us/api/fish-processing
 * ApiMethod:
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
	 * DisplayName: address
	 * Description: The mailing address
	 * HtmRowTitleOpen: FishPopulation details
	 * HtmRow: 6
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _address(Wrap<JsonObject> w) {
	}

  @Override
  protected void _color(Wrap<String> w) {
    w.o("green");
  }
}
