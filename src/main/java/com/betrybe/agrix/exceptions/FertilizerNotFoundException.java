package com.betrybe.agrix.exceptions;

/**
 * This exception is thrown when the given fertilizer is not found.
 */
public class FertilizerNotFoundException extends RuntimeException {
  public FertilizerNotFoundException(String message) {
    super(message);
  }
}
