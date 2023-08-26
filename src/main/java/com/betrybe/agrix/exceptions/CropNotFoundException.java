package com.betrybe.agrix.exceptions;

/**
 * This exception is thrown when the given crop is not found.
 */
public class CropNotFoundException extends RuntimeException {
  public CropNotFoundException(String message) {
    super(message);
  }
}
