package org.computate.smartaquaculture.model.timezone;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.result.BaseResult;

/**
 * Order: 99
 * Description.enUS: For managing time series data in different time zones.
 * Description.frFR: Pour gérer les données de séries chronologiques dans différents fuseaux horaires.
 * AName.enUS: a time zone
 * AName.frFR: un fuseau horaire
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
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: TimeZonePage
 *     ApiUri: /fr-fr/rechercher/fuseau-horaire
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: TimeZonePage
 *     ApiUri: /fr-fr/edition/fuseau-horaire/{entityShortId}
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
   * HtmRowTitleOpen.enUS: time zone details
   * HtmRowTitleOpen.frFR: détails du fuseau horaire
   * HtmRow: 3
   * HtmCell: 0
   * HtmColumn: 1
   * Facet: true
   * DisplayName.enUS: abbreviation
   * DisplayName.frFR: abréviation
   * Description.enUS: The abbreviation for this time zone. 
   * Description.frFR: L'abréviation pour ce fuseau horaire.
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
   * DisplayName.enUS: location
   * DisplayName.frFR: emplacement
   * Description.enUS: The location for this time zone. 
   * Description.frFR: L'emplacement pour ce fuseau horaire.
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
   * DisplayName.enUS: name
   * DisplayName.frFR: nom
   * Description.enUS: The name for this time zone. 
   * Description.frFR: Le nom pour ce fuseau horaire.
   */
  protected void _name(Wrap<String> w) {
  }
  
  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Facet: true
   * DisplayName.enUS: display name
   * DisplayName.frFR: nom d'affichage
   * Description.enUS: The display name for this time zone. 
   * Description.frFR: Le nom d'affichage pour ce fuseau horaire.
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
   * DisplayName.enUS: id
   * DisplayName.frFR: identifiant
   * Description.enUS: The id for this time zone. 
   * Description.frFR: L'identifiant pour ce fuseau horaire.
   * VarId: true
   */
  protected void _id(Wrap<String> w) {
    w.o(toId(displayName));
  }
}
