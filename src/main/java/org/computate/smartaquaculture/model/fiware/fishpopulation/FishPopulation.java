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
package org.computate.smartaquaculture.model.fiware.fishpopulation;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.mapmodel.MapModel;

import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: FishPopulation - Aquaculture - SmartAgrifood
 * Fiware: true
 *
 * Order: 5
 * Description.enUS: Tracking fish population counts, maturation, and incubation over time. 
 * Description.frFR: Suivi du nombre de poissons, de leur maturation et de leur incubation au fil du temps. 
 * AName.enUS: a fish population
 * AName.frFR: une population de poissons
 * PluralName.frFR: populations de poissons
 * Icon: <i class="fa-duotone fa-regular fa-fish"></i>
 * Rows: 100
 * LocationSvg: <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Pro 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2025 Fonticons, Inc.--><path class="fa-secondary" opacity=".4" d="M70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3zM448 256a32 32 0 1 1 -64 0 32 32 0 1 1 64 0z"/><path class="fa-primary" d="M180.8 303.7c9.2 10.4 19.4 20.6 30.7 30.1c33.7 28.5 76 50.2 124.5 50.2s90.8-21.8 124.5-50.2c30.3-25.5 52.7-55.7 65.3-77.8c-12.6-22.1-35-52.2-65.3-77.8C426.8 149.7 384.5 128 336 128s-90.8 21.7-124.5 50.2c-11.3 9.5-21.5 19.7-30.7 30.1c-14 15.8-36.7 20.6-56 11.8L70.6 195.3l21.1 36.9c8.4 14.8 8.4 32.9 0 47.6L70.6 316.7l54.3-24.9c19.2-8.8 41.9-4 56 11.8zM4.2 336.1L50 256 4.2 175.9c-6.9-12.1-5.2-27.2 4.2-37.5s24.3-13.3 36.9-7.5l99.5 45.6c10.5-11.9 22.5-23.8 35.7-35C219.7 108.5 272.6 80 336 80s116.3 28.5 155.5 61.5c39.1 33 66.9 72.4 81 99.8c4.7 9.2 4.7 20.1 0 29.3c-14.1 27.4-41.9 66.8-81 99.8C452.3 403.5 399.4 432 336 432s-116.3-28.5-155.5-61.5c-13.2-11.2-25.1-23.1-35.7-35L45.3 381.1c-12.6 5.8-27.6 2.8-36.9-7.5S-2.7 348.2 4.2 336.1zM416 224a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"/></svg>
 * LocationRadius: 100
 * MenuDetails.enUS: Aquaculture programs
 * MenuDetails.frFR: Programmes d'aquaculture
 * MenuDetailsOpen: true
 * 
 * SearchPageUri: /en-us/search/fish-population
 * EditPageUri: /en-us/edit/fish-population/{entityShortId}
 * ApiUri: /en-us/api/fish-population
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: FishPopulationPage
 *     ApiUri: /fr-fr/rechercher/population-poissons
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: FishPopulationPage
 *     ApiUri: /fr-fr/edition/population-poissons/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   FishPopulationViewer:
 *     GET:
 *   FishPopulationEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 *     Admin:
 **/
public class FishPopulation extends FishPopulationGen<MapModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: address
   * DisplayName.frFR: adresse
   * Description.enUS: The mailing address
   * Description.frFR: L'adresse postale
   * HtmRowTitleOpen.enUS: FishPopulation details
   * HtmRowTitleOpen.frFR: Détails de la population de poissons
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
   * Description.frFR: Un nom alternatif pour cet élément
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
   * DisplayName.enUS: body mass
   * DisplayName.frFR: masse corporelle
   * Description.enUS: The average body mass of cultured fishes
   * Description.frFR: La masse corporelle moyenne des poissons d'élevage
   * HtmRow: 6
   * HtmCell: 2
   * Facet: true
   **/
  protected void _bodyMasse(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: cultured in
   * DisplayName.frFR: élevé dans
   * Description.enUS: Reference to the FishContainment
   * Description.frFR: Référence au FishContainment
   * HtmRow: 6
   * HtmCell: 3
   * Facet: true
   **/
  protected void _culturedIn(Wrap<BigDecimal> w) {
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
   * HtmCell: 4
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
   * Description.frFR: Horodatage de la création de l'entité. Ceci est généralement attribué par la plateforme de stockage
   * HtmRow: 6
   * HtmCell: 5
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
   * Description.frFR: Horodatage de la dernière modification de l'entité. Ceci est généralement attribué par la plateforme de stockage
   * HtmRow: 6
   * HtmCell: 6
   * Facet: true
   **/
  protected void _dateModified(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: fish removed
   * DisplayName.frFR: poissons retirés
   * Description.enUS: Number of removed fishes
   * Description.frFR: Nombre de poissons retirés
   * HtmRow: 6
   * HtmCell: 7
   * Facet: true
   **/
  protected void _fishRemoved(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: initial number
   * DisplayName.frFR: nombre initial
   * Description.enUS: Number of initial number of cultured fishes
   * Description.frFR: Nombre initial de poissons d'élevage
   * HtmRow: 6
   * HtmCell: 8
   * Facet: true
   **/
  protected void _initialNumber(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: owner
   * DisplayName.frFR: propriétaire
   * Description.enUS: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
   * Description.frFR: Une liste contenant une séquence de caractères encodée en JSON faisant référence aux identifiants uniques du ou des propriétaires
   * HtmRow: 6
   * HtmCell: 9
   * Facet: true
   **/
  protected void _owner(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref specie
   * DisplayName.frFR: référence à l'espèce
   * Description.enUS: Reference to the Specie
   * Description.frFR: Référence à l'espèce
   * HtmRow: 6
   * HtmCell: 10
   * Facet: true
   **/
  protected void _refSpecie(Wrap<BigDecimal> w) {
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
   * HtmCell: 11
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
   * HtmCell: 12
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
   * Description.frFR: Une séquence de caractères donnant la source originale des données de l'entité sous forme d'URL. Recommandé d'être le nom de domaine entièrement qualifié du fournisseur de la source, ou l'URL vers l'objet source
   * HtmRow: 6
   * HtmCell: 13
   * Facet: true
   **/
  protected void _source(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
  
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served colors
   * DisplayName.frFR: couleurs de la zone desservie
   * Description.enUS: The colors of each areaServed Paths. 
   * Description.frFR: Les couleurs de chaque chemin de zone desservie.
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
   * Description.frFR: Les titres de chaque chemin de zone desservie.
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
   * Description.frFR: Les liens de chaque chemin de zone desservie.
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
   * HtmCell: 4
   * Facet: true
   **/
  protected void _areaServed(List<Polygon> l) {
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName.enUS: scientific name
	 * DisplayName.frFR: nom scientifique
	 * Description.enUS: The scientific name of the fish species. 
	 * Description.frFR: Le nom scientifique de l'espèce de poisson.
	 * HtmRow: 4
	 * HtmCell: 5
	 **/
	protected void _scientificName(Wrap<String> w) {
	}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: maturity days begin
   * DisplayName.frFR: jours de maturité début
   * Description.enUS: The range of days from birth for the fish population to become sexually mature. 
   * Description.frFR: La plage de jours à partir de la naissance pour que la population de poissons devienne sexuellement mature.
   * HtmRowTitleOpen.enUS: reproduction parameters
   * HtmRowTitleOpen.frFR: paramètres de reproduction
   * HtmRow: 7
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _maturityDaysBegin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(30));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: maturity days end
   * DisplayName.frFR: jours de maturité fin
   * Description.enUS: The range of days from birth for the fish population to become sexually mature. 
   * Description.frFR: La plage de jours à partir de la naissance pour que la population de poissons devienne sexuellement mature.
   * HtmRow: 7
   * HtmCell: 1
   * Precision: 16
   **/
  protected void _maturityDaysEnd(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(160));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation days begin
   * DisplayName.frFR: jours d'incubation début
   * Description.enUS: The range of days for egg incubation. 
   * Description.frFR: La plage de jours pour l'incubation des œufs.
   * HtmRowTitleOpen.enUS: reproduction parameters
   * HtmRowTitleOpen.frFR: paramètres de reproduction
   * HtmRow: 7
   * HtmCell: 2
   * Precision: 16
   **/
  protected void _incubationDaysBegin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(20));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation days end
   * DisplayName.frFR: jours d'incubation fin
   * Description.enUS: The range of days for egg incubation. 
   * Description.frFR: La plage de jours pour l'incubation des œufs.
   * HtmRow: 7
   * HtmCell: 3
   * Precision: 16
   **/
  protected void _incubationDaysEnd(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(40));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation number min
   * DisplayName.frFR: nombre d'incubation min
   * Description.enUS: The range of fish born after incubation. 
   * Description.frFR: La plage de poissons nés après l'incubation.
   * HtmRowTitleOpen.enUS: reproduction parameters
   * HtmRowTitleOpen.frFR: paramètres de reproduction
   * HtmRow: 7
   * HtmCell: 3
   **/
  protected void _incubationNumberMin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(30));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation number max
   * DisplayName.frFR: nombre d'incubation max
   * Description.enUS: The range of fish born after incubation. 
   * Description.frFR: La plage de poissons nés après l'incubation.
   * HtmRow: 7
   * HtmCell: 4
   **/
  protected void _incubationNumberMax(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(50));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: min percent of population pregnant
   * DisplayName.frFR: pourcentage minimum de la population enceinte
   * Description.enUS: The the percentage of the population that becomes pregnant at incubation time. 
   * Description.frFR: Le pourcentage de la population qui devient enceinte à l'heure de l'incubation.
   * HtmRow: 7
   * HtmCell: 5
   **/
  protected void _percentPopulationPregnantMin(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(0.15));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: max percent of population pregnant
   * DisplayName.frFR: pourcentage maximum de la population enceinte
   * Description.enUS: The the percentage of the population that becomes pregnant at incubation time. 
   * Description.frFR: Le pourcentage de la population qui devient enceinte à l'heure de l'incubation.
   * HtmRow: 7
   * HtmCell: 6
   **/
  protected void _percentPopulationPregnantMax(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(0.25));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: populations at birth
   * DisplayName.frFR: populations à la naissance
   * Description.enUS: A list of population counts at birth. 
   * Description.frFR: Une liste de nombres de population à la naissance. 
   * HtmRowTitleOpen.enUS: population parameters
   * HtmRowTitleOpen.frFR: paramètres de population
   * HtmRow: 7
   * HtmCell: 8
   **/
  protected void _populationsAtBirth(List<Long> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: populations now
   * DisplayName.frFR: populations maintenant
   * Description.enUS: A list of population counts now, since birth. 
   * Description.frFR: Une liste de nombres de population maintenant, depuis la naissance. 
   * HtmRow: 7
   * HtmCell: 9
   **/
  protected void _populationsNow(List<Long> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation date
   * DisplayName.frFR: date d'incubation
   * Description.enUS: The date and time that incubation started for this fish population. 
   * Description.frFR: La date et l'heure à laquelle l'incubation a commencé pour cette population de poissons.
   * HtmRow: 7
   * HtmCell: 10
   **/
  protected void _incubationDate(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: previous population
   * DisplayName.frFR: population précédente
   * Description.enUS: The previously known population count. 
   * Description.frFR: Le nombre de population précédemment connu. 
   * HtmRow: 7
   * HtmCell: 12
   **/
  protected void _previousPopulation(Wrap<Long> w) {
    w.o(0L);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: incubation days now
   * DisplayName.frFR: jours d'incubation maintenant
   * Description.enUS: The current number of days of egg incubation. 
   * Description.frFR: Le nombre actuel de jours d'incubation des œufs.
   * HtmRow: 7
   * HtmCell: 11
   * Precision: 16
   **/
  protected void _incubationDaysNow(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: water temperature in Fahrenheit
   * DisplayName.frFR: température de l'eau en Fahrenheit
   * Description.enUS: The water temperature can affect fish population survival. 
   * Description.frFR: La température de l'eau peut affecter la survie de la population de poissons.
   * HtmRow: 7
   * HtmCell: 12
   * Precision: 3
   **/
  protected void _waterTemperature(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(60));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: salinity in ppt
   * DisplayName.frFR: salinité en ppt
   * Description.enUS: The water salinity can affect fish population survival. 
   * Description.frFR: La salinité de l'eau peut affecter la survie de la population de poissons.
   * HtmRow: 7
   * HtmCell: 13
   * Precision: 3
   **/
  protected void _waterSalinity(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(30));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: oxygen in mg/L
   * DisplayName.frFR: oxygène en mg/L
   * Description.enUS: The water oxygen levels can affect fish population survival. 
   * Description.frFR: Les niveaux d'oxygène de l'eau peuvent affecter la survie de la population de poissons.
   * HtmRow: 7
   * HtmCell: 14
   * Precision: 3
   **/
  protected void _waterOxygen(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(5));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: pH
   * DisplayName.frFR: pH
   * Description.enUS: The water pH levels can affect fish population survival. 
   * Description.frFR: Les niveaux de pH de l'eau peuvent affecter la survie de la population de poissons.
   * HtmRow: 7
   * HtmCell: 15
   * Precision: 3
   **/
  protected void _waterPh(Wrap<BigDecimal> w) {
    w.o(new BigDecimal(8.1));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: simulation
   * DisplayName.frFR: simulation
   * Description.enUS: Toggle the digital twin simulation
   * Description.frFR: Basculer la simulation du jumeau numérique
   * HtmRowTitleOpen.enUS: simulation parameters
   * HtmRowTitleOpen.frFR: paramètres de simulation
   * HtmRow: 8
   * HtmCell: 0
   **/
  protected void _simulation(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: simulation delay in milliseconds
   * DisplayName.frFR: délai de simulation en millisecondes
   * Description.enUS: The number of milliseconds to asynchronously wait before the next update event is sent. 
   * Description.frFR: Le nombre de millisecondes à attendre de manière asynchrone avant l'envoi du prochain événement de mise à jour. 
   * HtmRow: 8
   * HtmCell: 1
   **/
  protected void _simulationDelayMillis(Wrap<Long> w) {
    w.o(500L);
  }
}

