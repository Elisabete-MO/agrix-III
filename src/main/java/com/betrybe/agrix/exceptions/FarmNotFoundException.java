package com.betrybe.agrix.exceptions;

/**
 * This exception is thrown when the given farm is not found.
 */
public class FarmNotFoundException extends RuntimeException {
  public FarmNotFoundException(String message) {
    super(message);
  }
}
