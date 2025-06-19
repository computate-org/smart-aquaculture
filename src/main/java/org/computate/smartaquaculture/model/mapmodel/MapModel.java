package org.computate.smartaquaculture.model.mapmodel;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.vertx.config.ComputateConfigKeys;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * Fiware: true
 * Order: 5
 * Description: A map model
 * AName: a map model
 * Icon: <i class="fa-duotone fa-regular fa-map-location-dot"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/map-model
 * ApiUri: /en-us/api/map-model
 * ApiMethod:
 *   Search:
 *   GET:
 * AuthGroup:
 *   MapModelViewer:
 *     GET:
 *   Admin:
 *     GET:
 **/
public class MapModel extends MapModelGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: name
	 * Description: The name. 
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
	 * Description: The description. 
	 * HtmColumn: 3
	 * VarDescription: true
	 * HtmRow: 4
	 * HtmCell: 1
	 * Facet: true
	 **/
	protected void _description(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * HtmRowTitleOpen: GeoJSON details
	 * FiwareType: geo:point
	 * Location: true
	 * DocValues: true
	 * Persist: true
	 * DisplayName: location
	 * Description: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
	 * HtmRow: 4
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _location(Wrap<Point> w) {
		w.o(staticSetLocation(siteRequest_, siteRequest_.getConfig().getString(ComputateConfigKeys.DEFAULT_MAP_LOCATION)));
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
	protected void _areaServed(Wrap<Polygon> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: id
	 * Description: Unique identifier of the entity
	 * HtmRowTitleOpen: NGSI-LD details
	 * HtmRow: 5
	 * HtmCell: 0
	 * Facet: true
	 **/
	protected void _id(Wrap<String> w) {
		w.o(String.format("urn:ngsi-ld:%s:%s", getClass().getSimpleName(), toId(name)));
	}

	/**
	 * {@inheritDoc}
	 * DisplayName: short entity ID
	 * Description: A short ID for this Smart Data Model
	 * DocValues: true
	 * Facet: true
	 * VarId: true
	 */
	protected void _entityShortId(Wrap<String> w) {
		if(id != null) {
			w.o(StringUtils.substringAfter(id, String.format("urn:ngsi-ld:%s:", getClass().getSimpleName())));
		}
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: NGSILD-Tenant
	 * Description: The NGSILD-Tenant or Fiware-Service
	 * HtmRow: 5
	 * HtmCell: 1
	 * Facet: true
	 */
	protected void _ngsildTenant(Wrap<String> w) {
		w.o(System.getenv("NGSILD_TENANT"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: NGSILD-Path
	 * Description: The NGSILD-Path or Fiware-ServicePath
	 * HtmRow: 5
	 * HtmCell: 2
	 * Facet: true
	 */
	protected void _ngsildPath(Wrap<String> w) {
		w.o(System.getenv("NGSILD_PATH"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: NGSILD context
	 * Description: The NGSILD context URL for @context data
	 * HtmRow: 5
	 * HtmCell: 3
	 * Facet: true
	 */
	protected void _ngsildContext(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: NGSILD data
	 * Description: The NGSILD data with @context from the context broker
	 * HtmRow: 5
	 * HtmCell: 4
	 * Facet: true
	 * Multiline: true
	 */
	protected void _ngsildData(Wrap<JsonObject> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: color
	 * HtmRow: 4
	 * HtmCell: 3
	 * Facet: true
	 * Color: true
	 */
	protected void _color(Wrap<String> w) {
		w.o("magenta");
	}

	@Override
	protected void _classCanonicalNames(List<String> l) { 
		l.add(MapModel.class.getCanonicalName());
		super._classCanonicalNames(l);
	}
}
