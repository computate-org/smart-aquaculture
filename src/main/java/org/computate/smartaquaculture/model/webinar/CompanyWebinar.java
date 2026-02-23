package org.computate.smartaquaculture.model.webinar;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.search.list.SearchList;
import org.computate.smartaquaculture.config.ConfigKeys;
import org.computate.smartaquaculture.model.BaseModel;

import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * Order: 3
 * Description.enUS: Join the Computate community for regular weekly webinars
 * Description.frFR: Rejoignez la communauté Computate pour des webinaires hebdomadaires réguliers
 * AName.enUS: a webinar
 * AName.frFR: un webinar
 * PluralName: webinars
 * Icon: <i class="fa-duotone fa-regular fa-video"></i>
 * 
 * PublicRead: true
 * SearchPageUri: /en-us/search/webinar
 * EditPageUri: /en-us/edit/webinar/{pageId}
 * DisplayPageUri: /en-us/view/webinar/{pageId}
 * UserPageUri: /en-us/join/webinar/{pageId}
 * ApiUri: /en-us/api/webinar
 * ApiMethod:
 *   SearchPageFrFR:
 *     Language: frFR
 *     Page: CompanyWebinarPage
 *     ApiUri: /fr-fr/rechercher/webinar
 *   EditPageFrFR:
 *     Language: frFR
 *     Page: CompanyWebinarPage
 *     ApiUri: /fr-fr/edition/webinar/{entityShortId}
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
public class CompanyWebinar extends CompanyWebinarGen<BaseModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: name
   * DisplayName.frFR: nom
   * Description.enUS: The name of this webinar
   * Description.frFR: Le nom de ce webinar
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 0
   * HtmRowTitle: webinar details
   * Facet: true
   * VarName: true
   **/
  protected void _name(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: description
   * DisplayName.frFR: description
   * Description.enUS: A description of this webinar
   * Description.frFR: Une description de ce webinar
   * HtmRow: 3
   * HtmCell: 2
   * Facet: true
   * HtmColumn: 3
   * VarDescription: true
   **/
  protected void _description(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * HtmRowTitleOpen: Useful URLs
   * HtmRow: 99
   * HtmCell: 1
   * Facet: true
   * DisplayName.enUS: Page ID
   * DisplayName.frFR: ID de la page
   * Description.enUS: The ID for this page. 
   * Description.frFR: L'ID de cette page. 
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
   * DisplayName.enUS: join URI
   * DisplayName.frFR: URI de participation
   * Description.enUS: The join relative URI for this page. 
   * Description.frFR: L'URI relative de participation pour cette page.
   */
  protected void _joinUri(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: Webinar URL Americas
   * DisplayName.frFR: URL du webinar en Amériques
   * Description.enUS: The actual link to the Webinar in Americas
   * Description.frFR: Le lien réel vers le webinar en Amériques
   * HtmRow: 4
   * HtmCell: 1
   * Facet: true
   **/
  protected void _webinarUrlAmericas(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: Webinar URL APAC
   * DisplayName.frFR: URL du webinar en APAC
   * Description.enUS: The actual link to the Webinar in APAC
   * Description.frFR: Le lien réel vers le webinar en APAC
   * HtmRow: 4
   * HtmCell: 2
   * Facet: true
   **/
  protected void _webinarUrlApac(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: Webinar URL EMEA
   * DisplayName.frFR: URL du webinar en EMEA
   * Description.enUS: The actual link to the Webinar in EMEA
   * Description.frFR: Le lien réel vers le webinar en EMEA
   * HtmRow: 4
   * HtmCell: 3
   * Facet: true
   **/
  protected void _webinarUrlEmea(Wrap<String> w) {}

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: ICal URL
   * DisplayName.frFR: URL ICal
   * Description.enUS: The ICalendar URL for the events. 
   * Description.frFR: L'URL ICalendar pour les événements. 
   * HtmRow: 4
   * HtmCell: 4
   * Facet: true
   **/
  protected void _icalUrl(Wrap<String> w) {}

  /**
   * Val.Fail.enUS: Failed to query the ICal file: %s
   */
  protected void _caldav(Promise<String> promise) {
    if(icalUrl == null) {
      promise.complete();
    } else {
      try {
        ZoneId zoneIdSite = ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE));
        ZonedDateTime now = ZonedDateTime.now(zoneIdSite);
        String utcDateTimeFormat = "yyyyMMdd'T'HHmmss";
        ZoneId zoneId = ZoneId.of("UTC");
        DateTimeFormatter utcDateTimeFormatter = DateTimeFormatter.ofPattern(utcDateTimeFormat);
        String start = utcDateTimeFormatter.format(Instant.now().minus(1, ChronoUnit.HOURS).atZone(zoneId));
        String end = utcDateTimeFormatter.format(Instant.now().plus(1, ChronoUnit.DAYS).atZone(zoneId));
        URL url = new URL(icalUrl);
        String host = url.getHost();
        Integer port = Optional.of(url.getPort()).map(p -> p.equals(-1) ? null : p).orElse("https".equals(url.getProtocol()) ? 443 : 80);
        Boolean ssl = "https".equals(url.getProtocol());
        String uri = url.getPath();
        siteRequest_.getWebClient().get(port, host, uri).ssl(ssl)
            .followRedirects(true)
            .send().onSuccess(response -> {
          try {
            String icalStr = response.body().toString();
            Matcher mEvent = Pattern.compile("^BEGIN:VEVENT($[\\w\\W]+?)^END:VEVENT$", Pattern.MULTILINE).matcher(icalStr);
            boolean mFound = mEvent.find();
            List<String> nextWebinarsName = new ArrayList<>();
            List<String> nextWebinarsDescription = new ArrayList<>();
            while (mFound) {
              String eventStr = mEvent.group(1);

              Matcher mStart = Pattern.compile("^DTSTART;TZID=(.*):(.*)", Pattern.MULTILINE).matcher(eventStr);
              mStart.find();
              String startZoneId = mStart.group(1);
              String startDateStr = mStart.group(2);
              ZonedDateTime startDateTime = ZonedDateTime.parse(startDateStr, ComputateZonedDateTimeSerializer.ICAL_FORMATTER.withZone(ZoneId.of(startZoneId)));

              Matcher mEnd = Pattern.compile("^DTEND;TZID=(.*):(.*)", Pattern.MULTILINE).matcher(eventStr);
              mEnd.find();
              String endZoneId = mEnd.group(1);
              String endDateStr = mEnd.group(2);
              ZonedDateTime endDateTime = ZonedDateTime.parse(endDateStr, ComputateZonedDateTimeSerializer.ICAL_FORMATTER.withZone(ZoneId.of(endZoneId)));

              Matcher mDescription = Pattern.compile("^DESCRIPTION:(.*)", Pattern.MULTILINE).matcher(eventStr);
              String description = null;
              if(mEnd.find())
                description = mDescription.group(1);

              ZonedDateTime nextStart = null;
              ZonedDateTime nextEnd = null;
              ZonedDateTime until = null;
              Matcher mRule = Pattern.compile("^RRULE:(.*)", Pattern.MULTILINE).matcher(eventStr);
              if(mRule.find()) {
                String ruleStr = mRule.group(1);
                ArrayList<String> byDaysNext = new ArrayList<>();
                if(ruleStr.contains("FREQ=WEEKLY")) {
                  if(ruleStr.contains("BYDAY=")) {
                    Matcher mByDay = Pattern.compile("\\;BYDAY=([^\\;\\n]+)", Pattern.MULTILINE).matcher(ruleStr);
                    mByDay.find();
                    if(ruleStr.contains("UNTIL=")) {
                      Matcher mUntil = Pattern.compile("\\;UNTIL=([^\\;\\n]+)Z", Pattern.MULTILINE).matcher(ruleStr);
                      mUntil.find();
                      String untilStr = mUntil.group(1);
                      until = ZonedDateTime.parse(untilStr, ComputateZonedDateTimeSerializer.ICAL_FORMATTER.withZone(ZoneId.of("UTC"))).withZoneSameInstant(ZoneId.of(startZoneId));
                    }
                    String byDayStr = mByDay.group(1);
                    List<String> byDays = Arrays.asList(byDayStr.split(","));
                    DayOfWeek nowDayOfWeek = now.getDayOfWeek();
                    int nowDayOfWeekIndex = nowDayOfWeek.getValue() - 1;
                    for(int i = 0; i < 7; i++) {
                      int currentDayOfWeekIndex = (nowDayOfWeekIndex + i) % 7;
                      DayOfWeek currentDayOfWeek = DayOfWeek.of(currentDayOfWeekIndex + 1);
                      String currentByDay = currentDayOfWeek.getDisplayName(TextStyle.FULL, Locale.US).substring(0, 2).toUpperCase();
                      if(byDays.contains(currentByDay))
                        byDaysNext.add(currentByDay);
                    }
                  } else {
                    DayOfWeek startDayOfWeek = startDateTime.getDayOfWeek();
                    int startDayOfWeekIndex = startDayOfWeek.getValue() - 1;
                    DayOfWeek currentDayOfWeek = DayOfWeek.of(startDayOfWeekIndex + 1);
                    String currentByDay = currentDayOfWeek.getDisplayName(TextStyle.FULL, Locale.US).substring(0, 2).toUpperCase();
                    byDaysNext.add(currentByDay);
                  }

                  ZonedDateTime currentWeek = now
                      .withHour(endDateTime.getHour())
                      .withMinute(endDateTime.getMinute())
                      .withSecond(endDateTime.getSecond())
                      .withNano(endDateTime.getNano())
                      ;
                  while(until == null || currentWeek.isBefore(until)) {
                    for(String byDay : byDaysNext) {
                      String byDayValue = null;
                      switch(byDay) {
                        case "SU":
                          byDayValue = "SUNDAY";
                          break;
                        case "MO":
                          byDayValue = "MONDAY";
                          break;
                        case "TU":
                          byDayValue = "TUESDAY";
                          break;
                        case "WE":
                          byDayValue = "WEDNESDAY";
                          break;
                        case "TH":
                          byDayValue = "THURSDAY";
                          break;
                        case "FR":
                          byDayValue = "FRIDAY";
                          break;
                        default:
                          byDayValue = "SATURDAY";
                          break;
                      }

                      ZonedDateTime nextGuess = currentWeek
                          .withHour(endDateTime.getHour())
                          .withMinute(endDateTime.getMinute())
                          .withSecond(endDateTime.getSecond())
                          .withNano(endDateTime.getNano())
                          .with(TemporalAdjusters.nextOrSame(DayOfWeek.valueOf(byDayValue)));
                      if(until != null && nextGuess.isAfter(until)) {
                        break;
                      } else {
                        nextEnd = nextGuess;
                        ZonedDateTime nextStart2 = nextGuess
                            .withHour(startDateTime.getHour())
                            .withMinute(startDateTime.getMinute())
                            .withSecond(startDateTime.getSecond())
                            .withNano(startDateTime.getNano());

                        if(nextGuess.isBefore(now)) {
                          nextEnd = null;
                          nextStart = null;
                          nextWebinarsBegin.add(nextStart2);
                          nextWebinarsDescription.add(description);
                          continue;
                        } else {
                          Matcher mException = Pattern.compile("^EXDATE;TZID=(.*):(.*)", Pattern.MULTILINE).matcher(eventStr);
                          boolean mExceptionFound = mException.find();
                          while(mExceptionFound) {
                            String exceptionZoneId = mException.group(1);
                            String exceptionDateStr = mException.group(2);
                            ZonedDateTime exceptionDateTime = ZonedDateTime.parse(exceptionDateStr, ComputateZonedDateTimeSerializer.ICAL_FORMATTER.withZone(ZoneId.of(exceptionZoneId)));
                            if(exceptionDateTime.isEqual(nextStart2)
                                || exceptionDateTime.isEqual(nextEnd)
                                || exceptionDateTime.isAfter(nextStart2) && exceptionDateTime.isBefore(nextEnd)) {
                              nextStart2 = null;
                              nextEnd = null;
                              break;
                            }
                            mExceptionFound = mException.find();
                          }
                          if(nextStart2 != null) {
                            if(nextStart == null)
                              nextStart = nextStart2;
                            nextWebinarsBegin.add(nextStart2);
                            nextWebinarsDescription.add(description);
                          } else {
                            nextStart = null;
                          }
                        }
                      }
                    }
                    if(nextStart != null) {
                      break;
                    } else {
                      currentWeek = currentWeek.plusWeeks(1);
                    }
                  }
                }
              } else {
                if(endDateTime.isBefore(now)) {
                  mFound = mEvent.find();
                  continue;
                }
              }

              if(nextStart != null) {
                if(nextWebinar == null || nextWebinar.compareTo(nextStart) > 0)
                  nextWebinar = nextStart;
                mFound = mEvent.find();
                continue;
              } else {
                mFound = mEvent.find();
                continue;
              }
            }
            Collections.sort(nextWebinarsBegin);
            promise.complete();
          } catch(Throwable ex) {
            LOG.error(String.format(caldavFail_enUS, icalUrl), ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format(caldavFail_enUS, icalUrl), ex);
          promise.fail(ex);
        });
      } catch(Throwable ex) {
        LOG.error(String.format(caldavFail_enUS, icalUrl), ex);
        promise.fail(ex);
      }
    }
  }

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Modify: false
	 * HtmRow: 4
	 * HtmCell: 5
   * HtmColumn: 1
	 * DisplayName.enUS: next webinar
   * DisplayName.frFR: prochain webinar
	 * Description.enUS: The start date time of the next webinar. 
   * Description.frFR: La date et l'heure de début du prochain webinar.
	 * FormatHtm: MMM d, yyyy h:mm:ss a
	 * Facet: true
	 */
	protected void _nextWebinar(Wrap<ZonedDateTime> w) {}

	/**
	 * {@inheritDoc}
	 * Stored: true
	 * Indexed: true
	 * Modify: false
	 * DisplayName.enUS: next webinars begin
   * DisplayName.frFR: début des prochains webinars
	 * Description.enUS: The start date time of the next webinars for the week. 
   * Description.frFR: La date et l'heure de début des prochains webinars pour la semaine.
	 * FormatHtm: MMM d, yyyy h:mm:ss a
	 */
	protected void _nextWebinarsBegin(List<ZonedDateTime> w) {}

  /**
   * {@inheritDoc}
   * Persist: true
   * DocValues: true
   * Link: true
   * HtmColumn: 2
   * DisplayName.enUS: Join the webinar
   * DisplayName.frFR: Rejoindre le webinar
   * Description.enUS: Access the webinar links. 
   * Description.frFR: Accéder aux liens du webinar.
   * Icon: <i class="fa-duotone fa-regular fa-video"></i>
   */
  protected void _joinUrl(Wrap<String> w) {
    w.o(String.format("%s%s", siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_BASE_URL), joinUri));
  }
}
