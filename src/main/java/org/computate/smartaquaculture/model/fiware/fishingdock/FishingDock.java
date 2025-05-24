package org.computate.smartaquaculture.model.fiware.fishingdock;

import java.time.ZonedDateTime;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.vertx.api.BaseApiServiceImpl;

/**
 * Order: 5
 * Description: A fishing dock
 * AName: a fishing dock
 * Icon: <i class="fa-duotone fa-regular fa-lighthouse"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/fishing-dock
 * EditPageUri: /en-us/edit/fishing-dock/{id}
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
 **/
public class FishingDock extends FishingDockGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: name
	 * Description: The name of this fishing dock
	 * HtmRow: 3
	 * HtmCell: 0
	 * HtmColumn: 0
	 * HtmRowTitleOpen: cluster details
	 * Facet: true
	 * VarName: true
	 **/
	protected void _name(Wrap<String> w) {
    w.o(pk.toString());
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: description
	 * Description: The description of this fishing dock
	 * HtmRow: 3
	 * HtmCell: 1
	 * HtmColumn: 1
	 * Facet: true
	 * VarDescription: true
	 **/
	protected void _description(Wrap<String> w) {}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: ID
	 * Description: The ID of this fishing dock
	 * HtmRow: 3
	 * HtmCell: 2
	 * Facet: true
	 * VarId: true
	 **/
	protected void _id(Wrap<String> w) {
    w.o(toId(name));
  }
}
