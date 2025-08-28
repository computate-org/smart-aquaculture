package org.computate.smartaquaculture.model.timezone;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.result.BaseResult;

/**
 * Order: 0
 * Description: A timezone
 * AName: a time zone
 * Icon: <i class="fa-duotone fa-regular fa-globe"></i>
 * Rows: 10
 * Ignore: true
 * 
 * SearchPageUri: /en-us/search/time-zone
 * EditPageUri: /en-us/edit/time-zone/{id}
 * ApiUri: /en-us/api/time-zone
 * PublicRead: true
 * Sort.asc: id
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     SuperAdmin:
 **/
public class TimeZone extends TimeZoneGen<BaseResult> {
  
	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmRowTitleOpen: time zone details
	 * HtmRow: 3
	 * HtmCell: 0
	 * HtmColumn: 0
	 * Facet: true
	 * DisplayName: id
	 * Description: The id for this time zone. 
	 * VarId: true
	 * VarName: true
	 */
	protected void _id(Wrap<String> w) {
	}
}
