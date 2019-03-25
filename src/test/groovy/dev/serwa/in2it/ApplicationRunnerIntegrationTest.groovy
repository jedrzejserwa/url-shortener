package dev.serwa.in2it

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import spock.lang.Subject

class ApplicationRunnerIntegrationTest extends IntegrationTest {

  @Subject
  @Autowired(required = false)
  ApplicationContext applicationContext

  def "Should run app and inject application context"() {
    expect:
    applicationContext != null
  }
}