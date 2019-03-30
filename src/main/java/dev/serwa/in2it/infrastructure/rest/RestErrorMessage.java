package dev.serwa.in2it.infrastructure.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestErrorMessage {

  public final String message;

  public RestErrorMessage(Throwable throwable) {
    this.message = throwable.getMessage();
  }

  @JsonCreator
  public RestErrorMessage(@JsonProperty("message") String message) {
    this.message = message;
  }
}