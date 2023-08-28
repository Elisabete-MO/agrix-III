package com.betrybe.agrix.solution;

import com.betrybe.agrix.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;
import com.betrybe.agrix.exceptions.PersonNotFoundException;
import com.betrybe.agrix.models.repositories.PersonRepository;
import com.betrybe.agrix.services.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class PersonServiceTest {

  @Autowired
  private PersonService personService;
  @MockBean
  private PersonRepository personRepository;

  @Test
  @DisplayName("1 - Person Creation - Service Layer")
  public void TestPersonCreation() {
    // Arrange
    PersonCreationDto personCreationDto = createTestPerson();
    Person personToReturn = createTestPersonWithId(42L);

    when(personRepository.save(any(Person.class))).thenReturn(personToReturn);

    // Act
    PersonDto savedPerson = personService.create(personCreationDto);

    // Assert
    verify(personRepository).save(any(Person.class));
    assertPersonEquals(PersonDto.fromPerson(personToReturn), Optional.ofNullable(savedPerson));
  }

  @Test
  @DisplayName("2 - Get Person By ID - Service Layer")
  public void TestGetPersonById() {
    // Arrange
    Long id = 1L;
    Person personToReturn = createTestPersonWithId(id);

    when(personRepository.findById(anyLong())).thenReturn(Optional.of(personToReturn));

    // Act
    Optional<PersonDto> result = personService.getPersonById(id);

    // Assert
    verify(personRepository).findById(eq(id));
    assertPersonEquals(createTestPersonDto(), result);
  }

  @Test
  @DisplayName("3 - Get Person By ID Throw Error - Service Layer")
  public void testGetPersonByIdNotFound() {
    // Arrange
    Long id = 1L;

    when(personRepository.findById(anyLong())).thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(id));
    verify(personRepository).findById(eq(id));
  }

  @Test
  @DisplayName("4 - Get Person By Username - Service Layer")
  public void TestGetPersonByUsername() {
    // Arrange
    Person personToReturn = createTestPersonWithId(1L);

    when(personRepository.findByUsername(eq("Teste"))).thenReturn(Optional.of(personToReturn));

    // Act
    Optional<PersonDto> result = personService.getPersonByUsername("Teste");

    // Assert
    verify(personRepository).findByUsername(eq("Teste"));
    assertPersonEquals(PersonDto.fromPerson(personToReturn), result);
  }

  @Test
  @DisplayName("5 - Get Person By Username Throw Error - Service Layer")
  public void testGetPersonByUsernameNotFound() {
    // Arrange
    when(personRepository.findByUsername(eq("Teste")))
        .thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(PersonNotFoundException.class, () -> personService
        .getPersonByUsername("Teste"));
    verify(personRepository).findByUsername(eq("Teste"));
  }

  // Helper methods
  private PersonCreationDto createTestPerson() {
    return new PersonCreationDto( Role.ADMIN,null, "Teste", "123456");
  }

  private Person createTestPersonWithId(Long id) {
    Person person = createTestPerson().toPerson();
    person.setId(id);
    return person;
  }

  private PersonDto createTestPersonDto() {
    return new PersonDto(Role.ADMIN, 1L, "Teste");
  }

  private void assertPersonEquals(PersonDto expected, Optional<PersonDto> actual) {
    assertNotNull(actual);
    assertEquals(expected.id(), actual.get().id());
    assertEquals(expected.username(), actual.get().username());
  }
}
