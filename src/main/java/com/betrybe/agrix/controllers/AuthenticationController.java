package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.AuthenticationDto;
import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.services.PersonService;
import com.betrybe.agrix.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Person entity.
 */
@RestController
@RequestMapping(value = "/persons")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final PersonService personService;

  private final TokenService tokenService;

  /** Constructor for the AuthorizationController class.
   *
   * @param personService service for the person entity
   */
  @Autowired
  public AuthenticationController(AuthenticationManager authenticationManager,
                                  PersonService personService,
                                  TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.personService = personService;
    this.tokenService = tokenService;
  }

  @PostMapping()
  public ResponseEntity<PersonDto> createPerson(
      @RequestBody PersonCreationDto personCreationDto) {
    PersonDto newPerson = personService.create(personCreationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
  }

  /** Method to register a new person.
   *
   * @param authenticationDto dto with the username, role and password
   * @return a response entity with the token
   */
  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody AuthenticationDto authenticationDto) {
    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(authenticationDto
            .username(), authenticationDto.password());
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    Person person = (Person) auth.getPrincipal();
    if (new BCryptPasswordEncoder().matches(authenticationDto.password(), person.getPassword())) {
      return ResponseEntity.status(HttpStatus.OK).body(tokenService.generateToken(person));
      // ("Pessoa autenticada com sucesso!"
    }
    throw new IllegalArgumentException("Senha incorreta!");
  }
}