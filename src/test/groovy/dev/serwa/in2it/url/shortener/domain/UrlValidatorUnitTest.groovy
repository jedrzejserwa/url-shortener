package dev.serwa.in2it.url.shortener.domain

import dev.serwa.in2it.UnitTest

class UrlValidatorUnitTest extends UnitTest {

  def "Should validate valid url"() {
    when:
    UrlValidator.validate(url)

    then:
    noExceptionThrown()

    where:
    _ | url
    _ | "https://sonalake.com"
    _ | "https://google.com"
  }

  def "Should validate invalid url"() {
    when:
    UrlValidator.validate(url)

    then:
    thrown(IllegalArgumentException.class)

    where:
    _ | url
    _ | "not-valid-url.com"
    _ | "sample string"
    _ | ""
    _ | null
    _ | "    "
  }
}