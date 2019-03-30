package dev.serwa.in2it

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import redis.embedded.RedisServer
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class IntegrationTest extends Specification {

  @Autowired
  protected TestRestTemplate testRestTemplate

  private static RedisServer redisServer

  void setupSpec() {
    redisServer = new RedisServer(6063)
    redisServer.start()
  }

  void cleanupSpec() {
    redisServer.stop()
  }
}