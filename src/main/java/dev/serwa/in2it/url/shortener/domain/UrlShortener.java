package dev.serwa.in2it.url.shortener.domain;

import java.util.UUID;

class UrlShortener {

  Url shorten(String url) {
    String urlShortcut = UUID.randomUUID()
      .toString()
      .substring(0, 6);

    return new Url(urlShortcut, url);
  }
}