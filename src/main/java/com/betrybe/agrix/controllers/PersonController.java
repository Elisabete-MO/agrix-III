package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.services.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Person entity.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  private final PersonService personService;

  /** Constructor for the PersonController class.
   *
   * @param personService the service for the Person entity.
   */
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping()
  public ResponseEntity<List<PersonDto>> getAllPersons() {
    return ResponseEntity.ok(personService.getAllPersons());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<PersonDto>> getPersonById(@PathVariable Long id) {
    Optional<PersonDto> optionalPerson = personService.getPersonById(id);
    return ResponseEntity.ok(optionalPerson);
  }
}