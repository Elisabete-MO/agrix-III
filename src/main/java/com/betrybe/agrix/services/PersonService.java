package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.exceptions.PersonNotFoundException;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.models.repositories.PersonRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service layer class for handling persons business logic.
 */
@Service
public class PersonService implements UserDetailsService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  /** Gets all persons.
   *
   * @return a list of all persons.
   */
  public List<PersonDto> getAllPersons() {
    List<Person> persons = personRepository.findAll();
    return persons.stream().map(e -> new PersonDto(
        e.getRole(), e.getId(), e.getUsername())).toList();
  }

  /**
   * Returns a person for a given ID.
   */
  public Optional<PersonDto> getPersonById(Long id) {
    return personRepository.findById(id)
        .map(e -> new PersonDto(e.getRole(), e.getId(), e.getUsername()))
        .map(Optional::of)
        .orElseThrow(() -> new PersonNotFoundException("Pessoa não encontrada!"));
  }

  /**
   * Returns a person for a given username.
   */
  public Optional<PersonDto> getPersonByUsername(String username) {
    return personRepository.findByUsername(username)
        .map(e -> new PersonDto(e.getRole(), e.getId(), e.getUsername()))
        .map(Optional::of)
        .orElseThrow(() -> new PersonNotFoundException("Pessoa não encontrada!"));
  }

  /**
   * Creates a new person.
   */
  public PersonDto create(PersonCreationDto personCreationDto) {
    Person person = personCreationDto.toPerson();
    personRepository.findByUsername(person.getUsername())
        .ifPresent(e -> {
          throw new IllegalArgumentException("Nome de usuário já existe!");
        });
    String hashedPassword = new BCryptPasswordEncoder().encode(person.getPassword());
    person.setPassword(hashedPassword);
    return PersonDto.fromPerson(personRepository.save(person));
  }

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Optional<Person> personOptional = personRepository.findByUsername(username);
    Person person = personOptional
        .orElseThrow(() -> new PersonNotFoundException("Pessoa não encontrada!"));
    List<GrantedAuthority> authorities = person.getAuthorities().stream()
        .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
        .collect(Collectors.toList());
    return new User(
        person.getUsername(),
        person.getPassword(),
        authorities
    );
  }
}
