package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** Person DTO.
 *
 * @param id identifier of the person
 * @param username name of the person
 * @param role role of the person
 */
public record PersonDto(Role role, Long id, String username) {

  /** Method to convert a person dto to a person entity.
   *
   * @param person person to be converted
   * @return a person dto
   */
  public static PersonDto fromPerson(Person person) {
    return new PersonDto(
        person.getRole(),
        person.getId(),
        person.getUsername());
  }
}
