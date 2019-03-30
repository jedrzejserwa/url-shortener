package dev.serwa.in2it.url.shortener.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlShortcut {

  public final String urlShortcut;

  @JsonCreator
  public UrlShortcut(@JsonProperty("urlShortcut") String urlShortcut) {
    this.urlShortcut = urlShortcut;
  }

  @Override
  public String toString() {
    return "UrlShortcut{" +
      "urlShortcut='" + urlShortcut + '\'' +
      '}';
  }
}