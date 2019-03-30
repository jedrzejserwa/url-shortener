package dev.serwa.in2it.url.shortener

import dev.serwa.in2it.IntegrationTest
import dev.serwa.in2it.infrastructure.rest.RestErrorMessage
import dev.serwa.in2it.url.shortener.domain.UrlShortenerFacade
import dev.serwa.in2it.url.shortener.dto.UrlShortcut
import dev.serwa.in2it.url.shortener.dto.UrlShortenerRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus

class UrlShortenerEndpointIntegrationTest extends IntegrationTest {

  @Autowired
  private UrlShortenerFacade urlShortenerFacade

  def "Should shorten url"() {
    given:
    UrlShortenerRequest request = new UrlShortenerRequest("https://google.com")

    when:
    def response = testRestTemplate.postForEntity("/v1/shorten", request, UrlShortcut.class)

    then:
    response.statusCode == HttpStatus.CREATED
    !response.body.urlShortcut.isBlank()
  }

  def "Shouldn't get redirected when passed wrong shortcut"() {
    when:
    def errorMessage = testRestTemplate.getForEntity("/v1/" + shortcut, RestErrorMessage.class)

    then:
    errorMessage.statusCode == expectedStatusCode
    errorMessage.body.message == expectedMessage

    where:
    shortcut                | expectedStatusCode     | expectedMessage
    "non-existing-shortcut" | HttpStatus.NOT_FOUND   | "non-existing-shortcut was not found in the database"
    " "                     | HttpStatus.BAD_REQUEST | "Url shortcut must contain text"
  }

  def "Should get redirected"() {
    given:
    def urlToRedirect = "https://google.com"
    def urlShortcut = urlShortenerFacade.store(urlToRedirect)

    when:
    def redirection = testRestTemplate.getForEntity("/v1/" + urlShortcut, Object.class)

    then:
    redirection.statusCode == HttpStatus.MOVED_PERMANENTLY
    redirection.headers.get(HttpHeaders.LOCATION).first() == urlToRedirect
  }
}