package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for the Fertilizer entity.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /** Inserts a new fertilizer.
   *
   * @param fertilizerDto DTO with the fertilizer data.
   * @return The fertilizer created.
   */
  public FertilizerDto insertFertilizer(FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerDto.toFertilizer();
    Fertilizer insertedFertilizer = fertilizerRepository.save(fertilizer);
    return FertilizerDto.fromFertilizer(insertedFertilizer);
  }

  /** Gets all fertilizers.
   *
   * @return All the fertilizers.
   */
  public List<FertilizerDto> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerRepository.findAll();
    return fertilizers.stream().map(e -> new FertilizerDto(
        e.getId(),
        e.getName(),
        e.getBrand(),
        e.getComposition())).toList();
  }

  /** Gets a fertilizer by id.
   *
   * @param id The fertilizer id.
   * @return The fertilizer with the given id.
   */
  public Optional<FertilizerDto> getFertilizerById(Integer id) {
    return fertilizerRepository.findById(id)
        .map(e -> new FertilizerDto(e.getId(), e.getName(),
            e.getBrand(), e.getComposition()))
        .map(Optional::of)
        .orElseThrow(() -> new FertilizerNotFoundException("Fertilizante não encontrado!"));
  }
}