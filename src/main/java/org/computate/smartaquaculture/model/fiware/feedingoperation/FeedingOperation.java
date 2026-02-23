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
package org.computate.smartaquaculture.model.fiware.feedingoperation;

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
 * SmartDataModel: FeedingOperation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 10
 * Description.enUS: Feeding operation on a group of animals
 * Description.frFR: Opération d'alimentation sur un groupe d'animaux
 * AName.enUS: a feeding operation
 * AName.frFR: une opération d'alimentation
 * Icon: <i class="fa-duotone fa-regular fa-fish-cooked"></i>
 * Rows: 100
 * Ignore: true
 * 
 * SearchPageUri: /en-us/search/feeding-operation
 * EditPageUri: /en-us/edit/feeding-operation/{entityShortId}
 * ApiUri: /en-us/api/feeding-operation
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: FeedingOperationPage
 *     ApiUri: /fr-fr/rechercher/operation-alimentation
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: FeedingOperationPage
 *     ApiUri: /fr-fr/edition/operation-alimentation/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FeedingOperationViewer:
 *     GET:
 *   FeedingOperationEditor:
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
public class FeedingOperation extends FeedingOperationGen<BaseModel> {

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: name
	 * DisplayName.frFR: nom
	 * Description.enUS: The name of this item
	 * Description.frFR: Le nom de cet article
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
	 * DisplayName.enUS: description
	 * DisplayName.frFR: description
	 * Description.enUS: A description of this item
	 * Description.frFR: Une description de cet article
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
	 * DisplayName.enUS: location
	 * DisplayName.frFR: emplacement
	 * Description.enUS: Geojson reference to the item. It can be Point, LineString, Polygon, MultiPoint, MultiLineString or MultiPolygon
	 * Description.frFR: Référence géojson à l'élément. Il peut s'agir d'un Point, d'une LineString, d'un Polygon, d'un MultiPoint, d'une MultiLineString ou d'un MultiPolygon
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
	 * DisplayName.enUS: area served colors
	 * DisplayName.frFR: couleurs de la zone desservie
	 * Description.enUS: The colors of each areaServed Paths. 
	 * Description.frFR: Les couleurs de chaque zone desservie des chemins.
	 */
	protected void _areaServedColors(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * LocationTitle: true
	 * Indexed: true
	 * Stored: true
	 * DisplayName.enUS: area served titles
	 * DisplayName.frFR: titres de la zone desservie
	 * Description.enUS: The titles of each areaServed Paths. 
	 * Description.frFR: Les titres de chaque zone desservie des chemins.
	 */
	protected void _areaServedTitles(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * LocationUrl: true
	 * Indexed: true
	 * Stored: true
	 * DisplayName.enUS: area served links
	 * DisplayName.frFR: liens de la zone desservie
	 * Description.enUS: The links of each areaServed Paths. 
	 * Description.frFR: Les liens de chaque zone desservie des chemins.
	 */
	protected void _areaServedLinks(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * FiwareType: geo:linestring
	 * Area: true
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: area served
	 * DisplayName.frFR: zone desservie
	 * Description.enUS: The geographic area where a service or offered item is provided
	 * Description.frFR: La zone géographique où un service ou un article proposé est fourni
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
	 * DisplayName.enUS: id
	 * DisplayName.frFR: identifiant
	 * Description.enUS: Unique identifier of the entity
	 * Description.frFR: Identifiant unique de l'entité
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
	 * DisplayName.enUS: short entity ID
	 * DisplayName.frFR: identifiant court de l'entité
	 * Description.enUS: A short ID for this Smart Data Model
	 * Description.frFR: Un identifiant court pour ce modèle de données intelligentes
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
	 * DisplayName.enUS: NGSILD-Tenant
	 * DisplayName.frFR: NGSILD-Tenant
	 * Description.enUS: The NGSILD-Tenant or Fiware-Service
	 * Description.frFR: Le NGSILD-Tenant ou Fiware-Service
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
	 * DisplayName.enUS: NGSILD-Path
	 * DisplayName.frFR: NGSILD-Path
	 * Description.enUS: The NGSILD-Path or Fiware-ServicePath
	 * Description.frFR: Le NGSILD-Path ou Fiware-ServicePath
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
	 * DisplayName.enUS: NGSILD context
	 * DisplayName.frFR: NGSILD context
	 * Description.enUS: The NGSILD context URL for @context data
	 * Description.frFR: L'URL du contexte NGSILD pour les données @context
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
	 * DisplayName.enUS: NGSILD data
	 * DisplayName.frFR: données NGSILD
	 * Description.enUS: The NGSILD data with @context from the context broker
	 * Description.frFR: Les données NGSILD avec @context du courtier de contexte
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
	 * DisplayName.enUS: address
	 * DisplayName.frFR: adresse
	 * Description.enUS: The mailing address
	 * Description.frFR: L'adresse postale
	 * HtmRowTitleOpen: FeedingOperation details
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
	 * DisplayName.enUS: alternate name
	 * DisplayName.frFR: nom alternatif
	 * Description.enUS: An alternative name for this item
	 * Description.frFR: Un nom alternatif pour cet article
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
	 * DisplayName.enUS: category
	 * DisplayName.frFR: catégorie
	 * Description.enUS: Defines the type of operation
	 * Description.frFR: Définit le type d'opération
	 * HtmRow: 6
	 * HtmCell: 2
	 * Facet: true
	 **/
	protected void _category(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: data provider
	 * DisplayName.frFR: fournisseur de données
	 * Description.enUS: A sequence of characters identifying the provider of the harmonised data entity
	 * Description.frFR: Une séquence de caractères identifiant le fournisseur de l'entité de données harmonisée
	 * HtmRow: 6
	 * HtmCell: 3
	 * Facet: true
	 **/
	protected void _dataProvider(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: date created
	 * DisplayName.frFR: date de création
	 * Description.enUS: Entity creation timestamp. This will usually be allocated by the storage platform
	 * Description.frFR: Horodatage de la création de l'entité. Cela sera généralement alloué par la plateforme de stockage
	 * HtmRow: 6
	 * HtmCell: 4
	 * Facet: true
	 **/
	protected void _dateCreated(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: date modified
	 * DisplayName.frFR: date de modification
	 * Description.enUS: Timestamp of the last modification of the entity. This will usually be allocated by the storage platform
	 * Description.frFR: Horodatage de la dernière modification de l'entité. Cela sera généralement alloué par la plateforme de stockage
	 * HtmRow: 6
	 * HtmCell: 5
	 * Facet: true
	 **/
	protected void _dateModified(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: endpoint
	 * DisplayName.frFR: point de connexion
	 * Description.enUS: The digital connection point for the operation
	 * Description.frFR: Le point de connexion numérique pour l'opération
	 * HtmRow: 6
	 * HtmCell: 6
	 * Facet: true
	 **/
	protected void _endpoint(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: has provider
	 * DisplayName.frFR: a pour fournisseur
	 * Description.enUS: Provider (Person or Organization) of the application
	 * Description.frFR: Fournisseur (Personne ou Organisation) de l'application
	 * HtmRow: 6
	 * HtmCell: 7
	 * Facet: true
	 **/
	protected void _hasProvider(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: owner
	 * DisplayName.frFR: propriétaire
	 * Description.enUS: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
	 * Description.frFR: Une liste contenant une séquence de caractères encodés en JSON référençant les identifiants uniques des propriétaires
	 * HtmRow: 6
	 * HtmCell: 8
	 * Facet: true
	 **/
	protected void _owner(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: related source
	 * DisplayName.frFR: source liée
	 * Description.enUS: List of IDs the current entity may have in external applications
	 * Description.frFR: Liste des identifiants que l'entité actuelle peut avoir dans des applications externes
	 * HtmRow: 6
	 * HtmCell: 9
	 * Facet: true
	 **/
	protected void _relatedSource(Wrap<JsonObject> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: see also
	 * DisplayName.frFR: voir aussi
	 * Description.enUS: list of uri pointing to additional resources about the item
	 * Description.frFR: liste d'uri pointant vers des ressources supplémentaires sur l'élément
	 * HtmRow: 6
	 * HtmCell: 10
	 * Facet: true
	 **/
	protected void _seeAlso(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: source
	 * DisplayName.frFR: source
	 * Description.enUS: A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object
	 * Description.frFR: Une séquence de caractères donnant la source originale des données de l'entité sous forme d'URL. Il est recommandé d'utiliser le nom de domaine entièrement qualifié du fournisseur de la source, ou l'URL vers l'objet source
	 * HtmRow: 6
	 * HtmCell: 11
	 * Facet: true
	 **/
	protected void _source(Wrap<String> w) {
	}


	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: version
	 * DisplayName.frFR: version
	 * Description.enUS: The version of the operation
	 * Description.frFR: La version de l'opération
	 * HtmRow: 6
	 * HtmCell: 12
	 * Facet: true
	 **/
	protected void _version(Wrap<String> w) {
	}

}

