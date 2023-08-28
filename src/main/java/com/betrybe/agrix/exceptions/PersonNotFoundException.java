package com.betrybe.agrix.exceptions;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(String message) {
    super(message);
  }

}
