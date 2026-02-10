/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.smartaquaculture.user;

import java.util.List;
import java.util.Optional;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.api.BaseApiServiceImpl;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.model.user.ComputateSiteUser;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.request.SiteRequest;

/**
 * Order: 1
 * Description.enUS: A user record for each site user
 * Description.frFR: Un enregistrement utilisateur pour chaque utilisateur du site
 * AName.enUS: a site user
 * AName.frFR: un utilisateur du site
 * Icon: <i class="fa-duotone fa-regular fa-user-gear"></i>
 * 
 * Keyword: classSimpleNameSiteUser
 * Filter: userId
 * AuthUser: true
 * 
 * SearchPageUri: /en-us/search/user
 * EditPageUri: /en-us/edit/user/{userId}
 * ApiUri: /en-us/api/user
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: TimeZonePage
 *     ApiUri: /fr-fr/rechercher/utlisateur
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: TimeZonePage
 *     ApiUri: /fr-fr/edition/utilisateur/{entityShortId}
 *   Search:
 *   PATCH:
 *   POST:
 */
public class SiteUser extends SiteUserGen<BaseModel> implements ComputateSiteUser {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Description.enUS: User keys that relate to this user
   * Description.frFR: Clés d'utilisateur qui se rapportent à cet utilisateur
   */
  protected void _userKeys(List<Long> l) {
    l.add(pk);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description.enUS: The unique user ID from the SSO server
   * Description.frFR: L'ID utilisateur unique du serveur SSO
   * VarId: true
   * Unique: true
   */
  protected void _userId(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: user name
   * DisplayName.frFR: nom d'utilisateur
   * Description.enUS: The user's username
   * Description.frFR: Le nom d'utilisateur de l'utilisateur
   * HtmColumn: 0
   */
  protected void _userName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description.enUS: The user's email
   * Description.frFR: L'e-mail de l'utilisateur
   */
  protected void _userEmail(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description.enUS: The user's first name
   * Description.frFR: Le prénom de l'utilisateur
   */
  protected void _userFirstName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description.enUS: The user's last name
   * Description.frFR: Le nom de famille de l'utilisateur
   */
  protected void _userLastName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: full name
   * DisplayName.frFR: nom complet
   * Description.enUS: The user's full name
   * Description.frFR: Le nom complet de l'utilisateur
   * HtmColumn: 1
   */
  protected void _userFullName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: Keycloak user profile
   * DisplayName.frFR: Profil utilisateur Keycloak
   * Description.enUS: View and update your user profile in Keycloak
   * Description.frFR: Voir et mettre à jour votre profil utilisateur dans Keycloak
   * HtmRow: 4
   * HtmCell: 3
   * Link: true
   */
  protected void _userProfileUrl(Wrap<String> w) {
    w.o(String.format("%s/realms/%s/account/", siteRequest_.getConfig().getString(ComputateConfigKeys.AUTH_URL), BaseApiServiceImpl.urlEncode(siteRequest_.getConfig().getString(ComputateConfigKeys.AUTH_REALM))));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 4
   * HtmCell: 0
   * HtmRowTitleOpen: user options
   * DisplayName.enUS: see archived
   * DisplayName.frFR: voir archives
   * Description.enUS: A user field allowing a user to see archived records
   * Description.frFR: Un champ utilisateur permettant à un utilisateur de voir les enregistrements archivés
   */
  protected void _seeArchived(Wrap<Boolean> c) {
    c.o(false);
  }

  /**
   * DocValues: true
   * Persist: true
   * Description.enUS: The display name for this user
   * Description.frFR: Le nom de l'utilisateur
   * VarName: true
   */
  protected void _displayName(Wrap<String> c) {
    c.o(String.format("%s (%s) <%s>", userFullName, userName, userEmail));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 4
   * HtmCell: 1
   * DisplayName.enUS: font size
   * DisplayName.frFR: taille de police
   * Description.enUS: The default font size for the site
   * Description.frFR: La taille de police par défaut pour le site
   * Refresh: true
   * Radio:
   *   small: small
   *   medium: medium
   *   large: large
   */
  protected void _siteFontSize(Wrap<String> w) {
    w.o(Optional.ofNullable(siteRequest_.getUser().attributes().getJsonObject("accessToken")).map(t -> t.getString(SiteUser.VAR_siteFontSize)).orElse("medium"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRow: 4
   * HtmCell: 2
   * DisplayName.enUS: site theme
   * DisplayName.frFR: thème du site
   * Description.enUS: The site theme, either light or dark. 
   * Description.frFR: Le thème du site, soit clair ou sombre. 
   * Refresh: true
   * Radio:
   *   light: Light
   *   dark: Dark
   */
  protected void _siteTheme(Wrap<String> w) {
    w.o(Optional.ofNullable(siteRequest_.getUser().attributes().getJsonObject("accessToken")).map(t -> t.getString(SiteUser.VAR_siteTheme)).orElse("dark"));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: customer profile ID
   * DisplayName.frFR: ID de profil client
   * Description.enUS: Authorize.net customer profile ID. 
   * Description.frFR: ID de profil client Authorize.net. 
   */
  protected void _customerProfileId(Wrap<String> w) {
  }

  /**
   * Description: An implementation for the interface to set the request object
   */
  @Override
  public <T extends ComputateSiteRequest> void setSiteRequest_(T siteRequest) {
    siteRequest_ = (SiteRequest)siteRequest;
  }

  /**
   * Description: An implementation for the interface to create a new API request object
   */
  @Override
  public void apiRequestSiteUser() {
    super.apiRequestSiteUser();
  }
}
