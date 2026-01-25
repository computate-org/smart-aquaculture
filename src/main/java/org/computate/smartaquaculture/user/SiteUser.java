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
 * Description: A user record for each site user
 * AName: a site user
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
 *   Search:
 *   PATCH:
 *   POST:
 */
public class SiteUser extends SiteUserGen<BaseModel> implements ComputateSiteUser {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Description: User keys that relate to this user
   */
  protected void _userKeys(List<Long> l) {
    l.add(pk);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description: The unique user ID from the SSO server
   * VarId: true
   * Unique: true
   */
  protected void _userId(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: user name
   * Description: The user's username
   * HtmColumn: 0
   */
  protected void _userName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description: The user's email
   */
  protected void _userEmail(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description: The user's first name
   */
  protected void _userFirstName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * Description: The user's last name
   */
  protected void _userLastName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: full name
   * Description: The user's full name
   * HtmColumn: 1
   */
  protected void _userFullName(Wrap<String> c) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: Keycloak user profile
   * Description: View and update your user profile in Keycloak
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
   * DisplayName: see archived
   * Description: A user field allowing a user to see archived records
   */
  protected void _seeArchived(Wrap<Boolean> c) {
    c.o(false);
  }

  /**
   * DocValues: true
   * Persist: true
   * Description: The display name for this user
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
   * DisplayName: font size
   * Description: The default font size for the site
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
   * DisplayName: site theme
   * Description: The site theme, either light or dark. 
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
   * DisplayName: customer profile ID
   * Description: Authorize.net customer profile ID. 
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
