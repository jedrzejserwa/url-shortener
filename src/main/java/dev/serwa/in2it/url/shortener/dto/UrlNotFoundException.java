package dev.serwa.in2it.url.shortener.dto;

public class UrlNotFoundException extends RuntimeException {

  public UrlNotFoundException(String message) {
    super(message);
  }
}