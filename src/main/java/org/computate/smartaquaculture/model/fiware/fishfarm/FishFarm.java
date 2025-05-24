package org.computate.smartaquaculture.model.fiware.fishfarm;

import java.time.ZonedDateTime;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;

/**
 * Order: 5
 * Description: A fish farm
 * AName: a fish farm
 * Icon: <i class="fa-duotone fa-regular fa-fish-fins"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/fish-farm
 * EditPageUri: /en-us/edit/fish-farm/{id}
 * ApiUri: /en-us/api/fish-farm
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishFarmViewer:
 *     GET:
 *   FishFarmEditor:
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
public class FishFarm extends FishFarmGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: name
	 * Description: The name of this fish farm
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
	 * Description: The description of this fish farm
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
	 * Description: The ID of this fish farm
	 * HtmRow: 3
	 * HtmCell: 2
	 * Facet: true
	 * VarId: true
	 **/
	protected void _id(Wrap<String> w) {
    w.o(toId(name));
  }
}
