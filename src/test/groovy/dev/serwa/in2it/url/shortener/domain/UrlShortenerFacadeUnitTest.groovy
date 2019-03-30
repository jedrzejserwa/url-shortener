package dev.serwa.in2it.url.shortener.domain

import dev.serwa.in2it.UnitTest
import dev.serwa.in2it.url.shortener.dto.UrlNotFoundException
import spock.lang.Subject

class UrlShortenerFacadeUnitTest extends UnitTest {

  @Subject
  private UrlShortenerFacade urlShortenerFacade

  void setup() {
    urlShortenerFacade = new UrlShortenerFacadeConfiguration().inMemoryImplementation()
  }

  def "Should shorter the url"() {
    given:
    def url = "https://sonalake.com"

    when:
    String urlHash = urlShortenerFacade.store(url)

    then:
    !urlHash.isEmpty()
  }

  def "Should not shorten invalid url"() {
    when:
    urlShortenerFacade.store(url)

    then:
    thrown(IllegalArgumentException.class)

    where:
    _ | url
    _ | ""
    _ | "   "
    _ | null
    _ | "not-valid-url.com"
  }

  def "Should get url shortcut"() {
    given:
    def urlToStore = "https://sonalake.com"
    def urlShortcut = urlShortenerFacade.store(urlToStore)

    when:
    def url = urlShortenerFacade.getUrl(urlShortcut)

    then:
    !url.isEmpty()
    url == urlToStore
  }

  def "Shouldn't get url for invalid url shortcut"() {
    when:
    urlShortenerFacade.getUrl(urlShortcut)

    then:
    thrown(exception)

    where:
    urlShortcut | exception
    ""          | IllegalArgumentException.class
    "  "        | IllegalArgumentException.class
    null        | IllegalArgumentException.class
    "2sasd312"  | UrlNotFoundException.class
  }
}