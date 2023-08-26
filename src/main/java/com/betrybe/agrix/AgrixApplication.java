package com.betrybe.agrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application main class.
 */
@SpringBootApplication
@ComponentScan({
    "com.betrybe.agrix",
    "com.betrybe.agrix.ebytr.staff.repository",
    "com.betrybe.agrix.ebytr.staff.entity"
})
@EnableJpaRepositories(basePackages = {
    "com.betrybe.agrix.ebytr.staff.repository",
    "com.betrybe.agrix.models.repositories"
})
@EntityScan(basePackages = {
    "com.betrybe.agrix.ebytr.staff.entity",
    "com.betrybe.agrix.models.entities"
})
public class AgrixApplication {
  public static void main(String[] args) {
    SpringApplication
        .run(AgrixApplication.class, args);
  }

}
