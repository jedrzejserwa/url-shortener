package dev.serwa.in2it.url.shortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlShortenerRequest {

  public final String url;

  @JsonCreator
  public UrlShortenerRequest(@JsonProperty("url") String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "UrlShortenerRequest{" +
      "url='" + url + '\'' +
      '}';
  }
}