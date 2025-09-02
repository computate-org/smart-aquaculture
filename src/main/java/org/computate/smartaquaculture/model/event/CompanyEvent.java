package org.computate.smartaquaculture.model.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.result.BaseResult;
import org.computate.vertx.config.ComputateConfigKeys;

import io.vertx.pgclient.data.Point;

/**
 * Order: 11
 * Description: See the upcoming computate in-person and online events
 * AName: an event
 * Icon: <i class="fa-duotone fa-regular fa-map-location-dot"></i>
 * Sort.desc: startDateTime
 * 
 * PublicRead: true
 * SearchPageUri: /en-us/search/event
 * EditPageUri: /en-us/edit/event/{pageId}
 * DisplayPageUri: /en-us/shop/event/{pageId}
 * UserPageUri: /en-us/use/event/{pageId}
 * ApiUri: /en-us/api/event
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * 
 * AuthGroup:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     DELETE:
 *     SuperAdmin:
 */
public class CompanyEvent extends CompanyEventGen<BaseResult> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: event name
   * Description: The event name. 
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 2
   * Facet: true
   * VarName: true
   */
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: event description
   * Description: The event description. 
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 3
   * Facet: true
   */
  protected void _description(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: start date time
   * Description: The start date time. 
   * HtmRow: 3
   * HtmCell: 3
   * HtmColumn: 1
   * Facet: true
   */
  protected void _startDateTime(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: end date time
   * Description: The end date time. 
   * HtmRow: 3
   * HtmCell: 4
   * Facet: true
   */
  protected void _endDateTime(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: price
   * Description: The price of the product per developer. 
   * HtmRow: 3
   * HtmCell: 5
   * Facet: true
   */
  protected void _price(Wrap<BigDecimal> w) {
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmRowTitleOpen: Useful URLs
	 * HtmRow: 99
	 * HtmCell: 1
	 * Facet: true
	 * DisplayName: Page ID
	 * Description: The ID for this page. 
	 * VarId: true
	 */
	protected void _pageId(Wrap<String> w) {
		w.o(toId(name));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Facet: true
	 * DisplayName: email template
	 * Description: The HTML email template for this product. 
	 */
	protected void _emailTemplate(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Facet: true
	 * DisplayName: store URL
	 * Description: The store URL for this page. 
	 */
	protected void _storeUrl(Wrap<String> w) {
	}

  /**
   * {@inheritDoc}
   * Location: true
   * DocValues: true
   * Persist: true
   * DisplayName: map location
   * HtmRow: 3
   * HtmCell: 1
   * Facet: true
   */
  protected void _location(Wrap<Point> w) {
  }

  /**
   * {@inheritDoc}
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName: location colors
   * Description: The colors of each location Points. 
   */
  protected void _locationColors(List<String> l) {
    l.add("#3388ff");
  }

  /**
   * {@inheritDoc}
   * LocationTitle: true
   * Indexed: true
   * Stored: true
   * DisplayName: location titles
   * Description: The titles of each location Paths. 
   */
  protected void _locationTitles(List<String> l) {
    l.add(objectTitle);
  }

  /**
   * {@inheritDoc}
   * LocationUrl: true
   * Indexed: true
   * Stored: true
   * DisplayName: location links
   * Description: The links of each location Paths. 
   */
  protected void _locationLinks(List<String> l) {
    l.add(editPage);
  }
}
