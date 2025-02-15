package com.example.site.model.fiware.crowdflowobserved;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import com.example.site.model.BaseModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: CrowdFlowObserved - Transportation - SmartCities
 * Fiware: true
 *
 * Order: 1
 * Description: CrowdFlowObserved
 * AName: a CrowdFlowObserved
 * Icon: <i class="fa-duotone fa-regular fa-users-viewfinder"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/crowd-flow-observed
 * EditPageUri: /en-us/edit/crowd-flow-observed/{entityShortId}
 * ApiUri: /en-us/api/crowd-flow-observed
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   CrowdFlowObservedViewer:
 *     GET:
 *   CrowdFlowObservedEditor:
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
public class CrowdFlowObserved extends CrowdFlowObservedGen<BaseModel> {

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
	 * HtmRowTitleOpen: CrowdFlowObserved details
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
	 * DisplayName: average crowd speed
	 * Description: Average speed of the crowd transiting during the observation period
	 * HtmRow: 6
	 * HtmCell: 2
	 * Facet: true
	 **/
	protected void _averageCrowdSpeed(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: average headway time
	 * Description: Average headway time. Headway time is the time     elapsed between two consecutive persons
	 * HtmRow: 6
	 * HtmCell: 3
	 * Facet: true
	 **/
	protected void _averageHeadwayTime(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: congested
	 * Description: Flags whether there was a crowd congestion during the observation period in the referred walkway. The absence of this attribute means no crowd congestion
	 * HtmRow: 6
	 * HtmCell: 4
	 * Facet: true
	 **/
	protected void _congested(Wrap<Boolean> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: data provider
	 * Description: A sequence of characters identifying the provider of the harmonised data entity
	 * HtmRow: 6
	 * HtmCell: 5
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
	 * HtmCell: 6
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
	 * HtmCell: 7
	 * Facet: true
	 **/
	protected void _dateModified(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: date observed
	 * Description: The date and time of this observation in ISO8601 UTC format. It can be represented by an specific time instant or by an ISO8601 interval. As a workaround for the lack of support of Orion Context Broker for datetime intervals, it can be used two separate attributes: `dateObservedFrom`, `dateObservedTo`
	 * HtmRow: 6
	 * HtmCell: 8
	 * Facet: true
	 **/
	protected void _dateObserved(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: date observed from
	 * Description: Observation period start date and time. See `dateObserved`
	 * HtmRow: 6
	 * HtmCell: 9
	 * Facet: true
	 **/
	protected void _dateObservedFrom(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: date observed to
	 * Description: Observation period end date and time. See `dateObserved`.
	 * HtmRow: 6
	 * HtmCell: 10
	 * Facet: true
	 **/
	protected void _dateObservedTo(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: direction
	 * Description: Usual direction of travel in the walkway referred by this observation with respect to the city center. Enum:'inbound, outbound'
	 * HtmRow: 6
	 * HtmCell: 11
	 * Facet: true
	 **/
	protected void _direction(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: occupancy
	 * Description: Fraction of the observation time where a person has been occupying the observed walkway
	 * HtmRow: 6
	 * HtmCell: 12
	 * Facet: true
	 **/
	protected void _occupancy(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: owner
	 * Description: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
	 * HtmRow: 6
	 * HtmCell: 13
	 * Facet: true
	 **/
	protected void _owner(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: people count
	 * Description: Total number of people detected during this observation
	 * HtmRow: 6
	 * HtmCell: 14
	 * Facet: true
	 **/
	protected void _peopleCount(Wrap<BigDecimal> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: ref road segment
	 * Description: Concerned road segment on which the observation has been made
	 * HtmRow: 6
	 * HtmCell: 15
	 * Facet: true
	 **/
	protected void _refRoadSegment(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: see also
	 * Description: list of uri pointing to additional resources about the item
	 * HtmRow: 6
	 * HtmCell: 16
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
	 * HtmCell: 17
	 * Facet: true
	 **/
	protected void _source(Wrap<String> w) {
	}

}

