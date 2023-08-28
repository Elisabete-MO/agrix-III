package com.betrybe.agrix.util;

import com.betrybe.agrix.models.entities.Person;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * This class is used to get the current user logged in the application.
 */
public class AuditorAwareUser implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null) {
      return Optional.of("unknown");
    }
    Person auditor = (Person) auth.getPrincipal();
    return Optional.of(auditor.getUsername());
  }
}