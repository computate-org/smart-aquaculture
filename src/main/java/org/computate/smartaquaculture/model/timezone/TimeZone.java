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
   * HtmColumn: 1
   * Facet: true
   * DisplayName: abbreviation
   * Description: The abbreviation for this time zone. 
   */
  protected void _abbreviation(Wrap<String> w) {
  }
  
  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 2
   * Facet: true
   * DisplayName: location
   * Description: The location for this time zone. 
   */
  protected void _location(Wrap<String> w) {
  }
  
  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 3
   * Facet: true
   * DisplayName: name
   * Description: The name for this time zone. 
   */
  protected void _name(Wrap<String> w) {
  }
  
  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName: display name
   * Description: The display name for this time zone. 
   * VarName: true
   */
  protected void _displayName(Wrap<String> w) {
    w.o(String.format("%s %s %s", location, name, abbreviation));
  }
  
  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 0
   * Facet: true
   * DisplayName: id
   * Description: The id for this time zone. 
   * VarId: true
   */
  protected void _id(Wrap<String> w) {
    w.o(toId(displayName));
  }
}
