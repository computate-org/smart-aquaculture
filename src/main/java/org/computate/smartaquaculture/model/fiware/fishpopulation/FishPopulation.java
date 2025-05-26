package org.computate.smartaquaculture.model.fiware.fishpopulation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.smartaquaculture.model.mapmodel.MapModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 1
 * Description: 
 * AName: a fish population
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
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

