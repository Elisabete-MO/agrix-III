package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Fertilizer entity.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping()
  public ResponseEntity<FertilizerDto> createFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    FertilizerDto newFertilizer = fertilizerService.insertFertilizer(fertilizerDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(newFertilizer);
  }

  @GetMapping()
  @Secured("ROLE_ADMIN")
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers() {
    return ResponseEntity.ok(fertilizerService.getAllFertilizers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<FertilizerDto>> getFertilizerById(@PathVariable Integer id) {
    Optional<FertilizerDto> optionalFertilizer = fertilizerService.getFertilizerById(id);
    return ResponseEntity.ok(optionalFertilizer);
  }
}