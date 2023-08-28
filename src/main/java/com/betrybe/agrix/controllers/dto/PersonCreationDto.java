package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** Person DTO.
 *
 * @param id identifier of the person
 * @param username name of the person
 * @param password password of the person
 * @param role role of the person
 */
public record PersonCreationDto(Role role, Long id, String username, String password) {
  public Person toPerson() {
    return new Person(id(), username(), password(), role());
  }
}
