package dev.serwa.in2it.url.shortener.domain;

import org.springframework.util.StringUtils;

import static org.springframework.util.ResourceUtils.isUrl;

class UrlValidator {

  static void validate(String url) {
    if (url == null) {
      throw new IllegalArgumentException("Url can't be null");
    }

    if (!StringUtils.hasText(url)) {
      throw new IllegalArgumentException("Url must have text");
    }

    if (!isUrl(url)) {
      throw new IllegalArgumentException(url + " is not valid url");
    }
  }
}
