package com.betrybe.agrix.controllers.dto;

/** DTO for the authentication.
 *
 * @param username username
 * @param password password
 */
public record AuthenticationDto(String username, String password) {
}
