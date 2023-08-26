package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for the Farm entity.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public FarmDto insertFarm(FarmDto farmDto) {
    return FarmDto.fromFarm(farmRepository.save(farmDto.toFarm()));
  }

  /** Gets all the farms.
   *
   * @return A list with all the farms.
   */
  public List<FarmDto> getAllFarms() {
    List<Farm> farms = farmRepository.findAll();
    return farms.stream().map(e -> new FarmDto(
        e.getId(),
        e.getName(),
        e.getSize())).toList();
  }

  /** Gets a farm by its id.
   *
   * @param id The farm id.
   * @return The farm with the given id.
   */
  public Optional<FarmDto> getFarmById(Integer id) {
    return farmRepository.findById(id)
        .map(e -> new FarmDto(e.getId(), e.getName(), e.getSize()))
        .map(Optional::of)
        .orElseThrow(() -> new FarmNotFoundException("Fazenda não encontrada!"));
  }
}
