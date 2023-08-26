package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
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
    Person person = createTestPerson();
    Person personToReturn = createTestPersonWithId(42L);

    when(personRepository.save(any(Person.class))).thenReturn(personToReturn);

    // Act
    Person savedPerson = personService.create(person);

    // Assert
    verify(personRepository).save(any(Person.class));
    assertPersonEquals(personToReturn, savedPerson);
  }

  @Test
  @DisplayName("2 - Get Person By ID - Service Layer")
  public void TestGetPersonById() {
    // Arrange
    Long id = 1L;
    Person personToReturn = createTestPersonWithId(id);

    when(personRepository.findById(anyLong())).thenReturn(Optional.of(personToReturn));

    // Act
    Person result = personService.getPersonById(id);

    // Assert
    verify(personRepository).findById(eq(id));
    assertPersonEquals(personToReturn, result);
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
    Person result = personService.getPersonByUsername("Teste");

    // Assert
    verify(personRepository).findByUsername(eq("Teste"));
    assertPersonEquals(personToReturn, result);
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
  private Person createTestPerson() {
    Person person = new Person();
    person.setUsername("Teste");
    person.setPassword("123456");
    return person;
  }

  private Person createTestPersonWithId(Long id) {
    Person person = createTestPerson();
    person.setId(id);
    return person;
  }

  private void assertPersonEquals(Person expected, Person actual) {
    assertNotNull(actual);
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getUsername(), actual.getUsername());
    assertEquals(expected.getPassword(), actual.getPassword());
  }
}
