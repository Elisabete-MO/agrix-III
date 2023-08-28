package com.betrybe.agrix.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * Enum representing a Role.
 */
public enum Role implements GrantedAuthority {
  ADMIN("ROLE_ADMIN"),
  MANAGER("ROLE_MANAGER"),
  USER("ROLE_USER");

  private final String name;

  Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @JsonIgnore
  @Override
  public String getAuthority() {
    return this.getName();
  }
}