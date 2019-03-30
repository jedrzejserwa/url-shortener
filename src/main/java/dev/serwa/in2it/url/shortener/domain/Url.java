package dev.serwa.in2it.url.shortener.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("urls")
class Url {

  @Id
  final String id;

  final String url;

  Url(String id, String url) {
    this.id = id;
    this.url = url;
  }
}