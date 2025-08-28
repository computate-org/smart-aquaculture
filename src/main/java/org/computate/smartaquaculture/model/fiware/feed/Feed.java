package org.computate.smartaquaculture.model.fiware.feed;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: Feed - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 1
 * Description: Feed tak for a group of animals
 * AName: a Feed
 * Icon: <i class="fa-duotone fa-regular fa-fish-cooked"></i>
 * Rows: 100
 * Ignore: true
 * 
 * SearchPageUri: /en-us/search/feed
 * EditPageUri: /en-us/edit/feed/{entityShortId}
 * ApiUri: /en-us/api/feed
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FeedViewer:
 *     GET:
 *   FeedEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 *     Admin:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 **/
public class Feed extends FeedGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: name
	 * Description: The name of this item
	 * HtmRowTitleOpen: name and description
	 * HtmColumn: 1
	 * VarName: true
	 * HtmRow: 3
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
	 * Description: A description of this item
	 * HtmColumn: 2
	 * VarDescription: true
	 * HtmRow: 3
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
	protected void _areaServed(List<Polygon> l) {
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
		w.o(String.format("urn:ngsi-ld:%s:%s", CLASS_SIMPLE_NAME, toId(name)));
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
			w.o(StringUtils.substringAfter(id, String.format("urn:ngsi-ld:%s:", CLASS_SIMPLE_NAME)));
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
	 * DisplayName: address
	 * Description: The mailing address
	 * HtmRowTitleOpen: Feed details
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
	 * DisplayName: data provider
	 * Description: A sequence of characters identifying the provider of the harmonised data entity
	 * HtmRow: 6
	 * HtmCell: 2
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
	 * HtmCell: 3
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
	 * HtmCell: 4
	 * Facet: true
	 **/
	protected void _dateModified(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: owner
	 * Description: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
	 * HtmRow: 6
	 * HtmCell: 5
	 * Facet: true
	 **/
	protected void _owner(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: related source
	 * Description: List of IDs the current entity may have in external applications
	 * HtmRow: 6
	 * HtmCell: 6
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
	 * HtmCell: 7
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
	 * HtmCell: 8
	 * Facet: true
	 **/
	protected void _source(Wrap<String> w) {
	}

}

