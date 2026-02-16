package org.computate.smartaquaculture.model.fiware.seaportfacility;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaquaculture.model.BaseModel;
import org.computate.smartaquaculture.model.mapmodel.MapModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: SeaportFacilities - Ports - SmartCities
 * Fiware: true
 *
 * Order: 14
 * Description.enUS: The Data Model is intended to provide information about ports that can accommodate pleasure craft, commerce or passenger  transport. It permit to represent the parameters of each port, its location, its mooring capacities and the free or paid services associated with it provided directly by the port or by professionals working on or near the port.
 * Description.frFR: Le modèle de données vise à fournir des informations sur les ports pouvant accueillir des embarcations de plaisance, du commerce ou du transport de passagers. Il permet de représenter les paramètres de chaque port, son emplacement, ses capacités d'amarrage et les services gratuits ou payants qui y sont associés, fournis directement par le port ou par des professionnels travaillant sur ou près du port.
 * AName.enUS: a seaport facility
 * AName.frFR: une installation portuaire
 * PluralName.enUS: seaport facilities
 * PluralName.frFR: installations portuaires
 * Icon: <i class="fa-duotone fa-regular fa-ship"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/seaport-facilities
 * EditPageUri: /en-us/edit/seaport-facilities/{entityShortId}
 * ApiUri: /en-us/api/seaport-facilities
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     ApiUri: /fr-fr/rechercher/installations-portuaires
 *   EditPageFrFR:
 *     Language: frFR
 *     ApiUri: /fr-fr/edition/installations-portuaires/{entityShortId}
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   SeaportFacilityViewer:
 *     GET:
 *   SeaportFacilityEditor:
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
public class SeaportFacility extends SeaportFacilityGen<MapModel> {


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: address
   * DisplayName.frFR: adresse
   * Description.enUS: The mailing address
   * Description.frFR: L'adresse postale
   * HtmRowTitleOpen.enUS: SeaportFacilities details
   * HtmRowTitleOpen.frFR: Détails des installations portuaires
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
   * DisplayName.enUS: authorized propulsion
   * DisplayName.frFR: propulsion autorisée
   * Description.enUS: A Type of propulsion authorized to enter in the harbor. A combination of motor, sail, electric, oar, nuclear, lng, lpg, other
   * Description.frFR: Un type de propulsion autorisée à entrer dans le port. Une combinaison de moteur, voile, électrique, rame, nucléaire, lng, lpg, autre
   * HtmRow: 6
   * HtmCell: 2
   * Facet: true
   **/
  protected void _authorizedPropulsion(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: boat supplying services
   * DisplayName.frFR: services d'approvisionnement pour bateaux
   * Description.enUS: Description of the complementary supplying services for the boat offered by professionals working on or near the harbor. A combination of guarding, fuelStation, fuelTankerTruck , drinkingWaterTankerTruck, provisioning, dryFairing, waterFairing, repair, expertise, gangways, liftingCranes, towing, wasteWaterPumping, boatConveying, boatTransfer, other
   * Description.frFR: Description des services d'approvisionnement complémentaires pour le bateau offerts par des professionnels travaillant sur ou près du port. Une combinaison de garde, station-service carburant, camion-citerne carburant , camion-citerne eau potable, approvisionnement, fairing sec, fairing eau, réparation, expertise technique, échelles de quai, grues de levage, remorquage automatique ou manuel (towing), pompage eaux usées (wasteWaterPumping), transport de bateaux (boatConveying), transfert de bateaux (boatTransfer), autres
   * HtmRow: 6
   * HtmCell: 3
   * Facet: true
   **/
  protected void _boatSupplyingServices(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: contact point
   * DisplayName.frFR: point de contact
   * Description.enUS: https://schema.org/ContactPoint
   * Description.frFR: https://schema.org/ContactPoint
   * HtmRow: 6
   * HtmCell: 4
   * Facet: true
   **/
  protected void _contactPoint(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: contracting authority
   * DisplayName.frFR: autorité contractante
   * Description.enUS: Name of the contracting authority
   * Description.frFR: Nom de l'autorité contractante
   * HtmRow: 6
   * HtmCell: 5
   * Facet: true
   **/
  protected void _contractingAuthority(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: contracting company
   * DisplayName.frFR: société contractante
   * Description.enUS: The Contracting Company responsible of the management of the port
   * Description.frFR: La société contractante responsable de la gestion du port
   * HtmRow: 6
   * HtmCell: 6
   * Facet: true
   **/
  protected void _contractingCompany(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: currency accepted
   * DisplayName.frFR: devise acceptée
   * Description.enUS: A combination of a list of active codes defined in the model [Norme ISO 4217](http://en.wikipedia.org/wiki/ISO_4217), [Crypto Currencies](https://en.wikipedia.org/wiki/List_of_cryptocurrencies) , [Exchange Trading System](https://en.wikipedia.org/wiki/Local_exchange_trading_system
   * Description.frFR: Une combinaison d'une liste de codes actifs définis dans le modèle [Norme ISO 4217](http://en.wikipedia.org/wiki/ISO_4217), [Crypto Currencies](https://fr.wikipedia.org/wiki/Liste_des_cryptomonnaies) , [Exchange Trading System](https://fr.wikipedia.org/wiki/Syst%C3%A8me_d%27%C3%A9change_local)
   * HtmRow: 6
   * HtmCell: 7
   * Facet: true
   **/
  protected void _currencyAccepted(Wrap<JsonObject> w) {
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
   * HtmCell: 8
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
   * HtmCell: 9
   * Facet: true
   **/
  protected void _dateCreated(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: date last reported
   * DisplayName.frFR: date de dernière déclaration
   * Description.enUS: A timestamp which denotes the last time when a flow successfully reported data. The date and time of this Repository in ISO8601 UTCformat
   * Description.frFR: Un horodatage qui indique la dernière fois qu'un flux a signalé des données avec succès. La date et l'heure de ce dépôt au format ISO8601 UTC
   * HtmRow: 6
   * HtmCell: 10
   * Facet: true
   **/
  protected void _dateLastReported(Wrap<String> w) {
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
   * HtmCell: 11
   * Facet: true
   **/
  protected void _dateModified(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: electric transport
   * DisplayName.frFR: transport électrique
   * Description.enUS:  List of the different types of electric transport proposed by the city. A combination of electricCar, electricBycicle, electricMotorBike, electricScooter 
   * Description.frFR: Liste des différents types de transport électrique proposés par la ville. Une combinaison de electricCar, electricBycicle, electricMotorBike, electricScooter 
   * HtmRow: 6
   * HtmCell: 12
   * Facet: true
   **/
  protected void _electricTransport(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: end date
   * DisplayName.frFR: date de fin
   * Description.enUS: The end date and time of the item (in ISO 8601 date format).
   * Description.frFR: La date et l'heure de fin de l'élément (au format ISO 8601).
   * HtmRow: 6
   * HtmCell: 13
   * Facet: true
   **/
  protected void _endDate(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: facilities
   * DisplayName.frFR: installations
   * Description.enUS: Description of the proposed facilities on the harbor. A combination of : toilets, showers, laundry, telephone, dustbins, dumpsters, container, selectiveSortingWaste, electricTerminal, waterTerminal, indoorRoomReservation, wifi, other
   * Description.frFR: Description des installations proposées sur le port. Une combinaison de : toilets, showers, laundry, telephone, dustbins, dumpsters, container, selectiveSortingWaste, electricTerminal, waterTerminal, indoorRoomReservation, wifi, other
   * HtmRow: 6
   * HtmCell: 14
   * Facet: true
   **/
  protected void _facilities(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: max draft
   * DisplayName.frFR: tirant d'eau maximum
   * Description.enUS: A Maximum draft allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter
   * Description.frFR: Un tirant d'eau maximum autorisé pour accéder au port. Le code unité (texte) est donné en utilisant les [Codes Communs UN/CEFACT](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). Par exemple, **MTR** représente Mètre
   * HtmRow: 6
   * HtmCell: 15
   * Facet: true
   **/
  protected void _maxDraft(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: max length
   * DisplayName.frFR: longueur maximale
   * Description.enUS: A Maximum length allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter
   * Description.frFR: Une longueur maximale autorisée pour accéder au port. Le code unité (texte) est donné en utilisant les [Codes Communs UN/CEFACT](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). Par exemple, **MTR** représente Mètre
   * HtmRow: 6
   * HtmCell: 16
   * Facet: true
   **/
  protected void _maxLength(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: max tonnage
   * DisplayName.frFR: tonnage maximum
   * Description.enUS: Maximum tonnage authorized to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **TNE** represents Tonne Metric
   * Description.frFR: Tonnage maximum autorisé pour accéder au port. Le code unité (texte) est donné en utilisant les [Codes Communs UN/CEFACT](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). Par exemple, **TNE** représente Tonne Métrique
   * HtmRow: 6
   * HtmCell: 17
   * Facet: true
   **/
  protected void _maxTonnage(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: max width
   * DisplayName.frFR: largeur maximale
   * Description.enUS: A Maximum width allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes) . For instance, **MTR** represents Meter
   * Description.frFR: Une largeur maximale autorisée pour accéder au port. Le code unité (texte) est donné en utilisant les [Codes Communs UN/CEFACT](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). Par exemple, **MTR** représente Mètre
   * HtmRow: 6
   * HtmCell: 18
   * Facet: true
   **/
  protected void _maxWidth(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: min length
   * DisplayName.frFR: longueur minimale
   * Description.enUS: A Minimum length allowed to access the harbor. The unit code (text) is given using the [UN/CEFACT Common Codes](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). For instance, **MTR** represents Meter
   * Description.frFR: Une longueur minimale autorisée pour accéder au port. Le code unité (texte) est donné en utilisant les [Codes Communs UN/CEFACT](http://wiki.goodrelations-vocabulary.org/Documentation/UN/CEFACT_Common_Codes). Par exemple, **MTR** représente Mètre
   * HtmRow: 6
   * HtmCell: 19
   * Facet: true
   **/
  protected void _minLength(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: nearby services
   * DisplayName.frFR: services à proximité
   * Description.enUS: Description of the additional services on the geographical area on or near the harbor. A combination of :touristOffice, fittingsStores, travelAgency, exchangeOffice, medicalOffice, pharmacy, groceryStores, restaurants, presses, bar, shops, seaExcursions, cityTour, touristicExcursions, others
   * Description.frFR: Description des services supplémentaires sur la zone géographique sur ou près du port. Une combinaison de :touristOffice, fittingsStores, travelAgency, exchangeOffice, medicalOffice, pharmacy, groceryStores, restaurants, presses, bar, shops, seaExcursions, cityTour, touristicExcursions et others
   * HtmRow: 6
   * HtmCell: 20
   * Facet: true
   **/
  protected void _nearbyServices(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: number of place
   * DisplayName.frFR: nombre de places
   * Description.enUS: Total number of place in the harbor
   * Description.frFR: Nombre total de places dans le port
   * HtmRow: 6
   * HtmCell: 21
   * Facet: true
   **/
  protected void _numberOfPlace(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: opening hours
   * DisplayName.frFR: heures d'ouverture
   * Description.enUS: The general opening hours for a business. Opening hours can be specified as a weekly time range, starting with days, then times per day. Multiple days can be listed with commas ',' separating each day. Day or time ranges are specified using a hyphen '-'. Days are specified using the following two-letter combinations: Mo, Tu, We, Th, Fr, Sa, Su. Times are specified using 24:00 format. For example, 3pm is specified as 15:00, 10am as 10:00. Here is an example: <time itemprop='openingHours' datetime='Tu,Th 16:00-20:00'>Tuesdays and Thursdays 4-8pm</time>. If a business is open 7 days a week, then it can be specified as <time itemprop='openingHours' datetime='Mo-Su'>Monday through Sunday, all day</time>
   * Description.frFR: Les heures d'ouverture générales d'une entreprise. Les heures d'ouverture peuvent être spécifiées comme une plage horaire hebdomadaire, en commençant par les jours, puis les heures par jour. Plusieurs jours peuvent être listés avec des virgules ',' séparant chaque jour. Les plages de jours ou d'heures sont spécifiées à l'aide d'un trait d'union '-'. Les jours sont spécifiés en utilisant les combinaisons de deux lettres suivantes : Mo, Tu, We, Th, Fr, Sa, Su. Les heures sont spécifiées en utilisant le format 24:00. Par exemple, 15h est spécifié comme 15:00, 10h comme 10:00. Voici un exemple : <time itemprop='openingHours' datetime='Tu,Th 16:00-20:00'>Mardis et jeudis de 16h à 20h</time>. Si une entreprise est ouverte 7 jours sur 7, cela peut être spécifié comme <time itemprop='openingHours' datetime='Mo-Su'>Du lundi au dimanche, toute la journée</time>
   * HtmRow: 6
   * HtmCell: 22
   * Facet: true
   **/
  protected void _openingHours(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: opening hours specification
   * DisplayName.frFR: spécification des heures d'ouverture
   * Description.enUS: A structured value providing information about the opening hours of a place or a certain service inside a place
   * Description.frFR: Une valeur structurée fournissant des informations sur les heures d'ouverture d'un lieu ou d'un service particulier à l'intérieur d'un lieu
   * HtmRow: 6
   * HtmCell: 23
   * Facet: true
   **/
  protected void _openingHoursSpecification(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: owner
   * DisplayName.frFR: propriétaire
   * Description.enUS: A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
   * Description.frFR: Une liste contenant une séquence encodée en JSON de caractères référençant les identifiants uniques des propriétaires
   * HtmRow: 6
   * HtmCell: 24
   * Facet: true
   **/
  protected void _owner(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: payment accepted
   * DisplayName.frFR: paiement accepté
   * Description.enUS: Accepted payment. A combination of a list of active codes defined in the model : Cash, CreditCard, CryptoCurrency, other
   * Description.frFR: Paiement accepté. Une combinaison de codes actifs définis dans le modèle : Espèces, CarteBancaire, Cryptomonnaie, autre
   * HtmRow: 6
   * HtmCell: 25
   * Facet: true
   **/
  protected void _paymentAccepted(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: port services provided
   * DisplayName.frFR: services portuaires fournis
   * Description.enUS: Description of the services provided directly by the harbor. A combination of : harborOffice, weather, customsServices, porters, boatRingRental, mooringAssistance, handlingAssistance, publicWifi, privateWifi, other
   * Description.frFR: Description des services fournis directement par le port. Une combinaison de : bureauPortuaire, météo, servicesDouane, porteurs, locationAnneauxBateau, assistanceAmarrage, assistanceManutention, wifiPublic, wifiPrivé, autre
   * HtmRow: 6
   * HtmCell: 26
   * Facet: true
   **/
  protected void _portServicesProvided(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref boat authorized
   * DisplayName.frFR: référence bateau autorisé
   * Description.enUS: Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatAuthorized/doc/spec.md)
   * Description.frFR: Référence à une liste d'[Entité](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatAuthorized/doc/spec.md)
   * HtmRow: 6
   * HtmCell: 27
   * Facet: true
   **/
  protected void _refBoatAuthorized(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref boat place available
   * DisplayName.frFR: référence place bateau disponible
   * Description.enUS: Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlaceAvailable/doc/spec.md)
   * Description.frFR: Référence à une liste d'[Entité](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlaceAvailable/doc/spec.md)
   * HtmRow: 6
   * HtmCell: 28
   * Facet: true
   **/
  protected void _refBoatPlaceAvailable(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref boat place pricing
   * DisplayName.frFR: référence prix place bateau
   * Description.enUS: Reference to a list of [Entity](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlacePricing/doc/spec.md)
   * Description.frFR: Référence à une liste d'[Entité](https://github.com/smart-data-models/dataModel.Port/blob/master/BoatPlacePricing/doc/spec.md)
   * HtmRow: 6
   * HtmCell: 29
   * Facet: true
   **/
  protected void _refBoatPlacePricing(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref device
   * DisplayName.frFR: référence appareil
   * Description.enUS: Reference to the Main Entity [Device](https://github.com/smart-data-models/dataModel.Device/blob/master/Device/doc/spec.md) if used as second link
   * Description.frFR: Référence à l'Entité principale [Device](https://github.com/smart-data-models/dataModel.Device/blob/master/Device/doc/spec.md) si utilisée comme deuxième lien
   * HtmRow: 6
   * HtmCell: 30
   * Facet: true
   **/
  protected void _refDevice(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ref point of interest
   * DisplayName.frFR: référence point d'intérêt
   * Description.enUS: Reference to a [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) linked with the Repository
   * Description.frFR: Référence à un [PointOfInterest](https://github.com/smart-data-models/dataModel.PointOfInterest/blob/master/PointOfInterest/doc/spec.md) lié au dépôt
   * HtmRow: 6
   * HtmCell: 31
   * Facet: true
   **/
  protected void _refPointOfInterest(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: rental sale services
   * DisplayName.frFR: services location vente
   * Description.enUS: ADescription of services provided by professional sales or rental agencies on the geographical area on or near the harbor. A combination of : boatRental, boatSale, jetSkiRental, jetSkiSale, carRental, luxuryCarRental, vanRental, bikeRental, scooterRental, Caddie, palletTransport, other
   * Description.frFR: Description des services fournis par des agences professionnelles de vente ou de location sur la zone géographique du port ou à proximité. Une combinaison de : boatRental, boatSale, jetSkiRental, jetSkiSale, carRental, luxuryCarRental, vanRental, bikeRental, scooterRental, Caddie, palletTransport, other
   * HtmRow: 6
   * HtmCell: 32
   * Facet: true
   **/
  protected void _rentalSaleServices(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: route type
   * DisplayName.frFR: type de route
   * Description.enUS: List of the different types of urban transport Mode (Metro, Bus, Tram, ...) from the urban transport Mode GFTS standard [STOP](https://developers.google.com/transit/gtfs/reference/#stopstxt). A combination of values composed only of the attribute 'description' tram(0), metro(1), train(2), bus(3), ferry(4), cableTram(5), cableCar(6), funicular(7), trolleybus(11), monorail(12)
   * Description.frFR: Liste des différents types de modes de transport urbain (Métro, Bus, Tram, ...) selon le standard GFTS [STOP](https://developers.google.com/transit/gtfs/reference/#stopstxt). Une combinaison de valeurs composée uniquement de l'attribut 'description' tram(0), metro(1), train(2), bus(3), ferry(4), cableTram(5), cableCar(6), funicular(7), trolleybus(11), monorail(12)
   * HtmRow: 6
   * HtmCell: 33
   * Facet: true
   **/
  protected void _routeType(Wrap<JsonObject> w) {
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
   * HtmCell: 34
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
   * HtmCell: 35
   * Facet: true
   **/
  protected void _source(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: start date
   * DisplayName.frFR: date de début
   * Description.enUS: The start date and time of the item (in ISO 8601 date format).
   * Description.frFR: La date et l'heure de début de l'élément (au format ISO 8601).
   * HtmRow: 6
   * HtmCell: 36
   * Facet: true
   **/
  protected void _startDate(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: transport services
   * DisplayName.frFR: services de transport
   * Description.enUS: Description of the services provided for dedicated transport and shuttle services. A combination of : parking, shuttlesToAirport, shuttlesToRailway, internalShuttles, taxis, heliport, other
   * Description.frFR: Description des services fournis pour les transports dédiés et les navettes. Une combinaison de : parking, navettesVersAeroport, navettesVersGare, navettesInternes, taxis, hélicoptère, autres
   * HtmRow: 6
   * HtmCell: 37
   * Facet: true
   **/
  protected void _transportServices(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: type of port
   * DisplayName.frFR: type de port
   * Description.enUS: A Type of harbor. A combination of : marina, merchandise, cruise, ferry, passengers, yachting, fishing, military, river, other
   * Description.frFR: Un type de port. Une combinaison de : marina, marchandises, croisière, ferry, passagers, yachting, pêche, militaire, rivière, autres
   * HtmRow: 6
   * HtmCell: 38
   * Facet: true
   **/
  protected void _typeOfPort(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: web site
   * DisplayName.frFR: site web
   * Description.enUS: Link to the official website of the harbor for more information
   * Description.frFR: Lien vers le site officiel du port pour plus d'informations
   * HtmRow: 6
   * HtmCell: 39
   * Facet: true
   **/
  protected void _webSite(Wrap<String> w) {
  }

}

