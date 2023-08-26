package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service for the Crop entity.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  /** Creates a new crop.
   *
   * @param cropDto  DTO with the crop data.
   * @param farm    Farm that the crop belongs to.
   * @return The crop created.
   */
  public CropDto insertCrop(CropDto cropDto, Farm farm) {
    Crop crop = cropDto.toCrop(farm);
    Crop insertedCrop = cropRepository.save(crop);
    return CropDto.fromCrop(insertedCrop);
  }

  /** Gets all the crops of a farm.
   *
   * @param farmId The farm id.
   * @return A list with all the crops of the farm.
   */
  public List<CropDto> getAllCropsByFarmId(Integer farmId) {
    List<Crop> crops = cropRepository.findAllByFarmId(farmId);
    return crops.stream().map(e -> new CropDto(
        e.getId(),
        e.getName(),
        e.getPlantedArea(),
        e.getPlantedDate(),
        e.getHarvestDate(),
        e.getFarm().getId())).toList();
  }

  /** Gets all the crops.
   *
   * @return A list with all the crops.
   */
  public List<CropDto> getAllCrops() {
    List<Crop> crops = cropRepository.findAll();
    return crops.stream().map(e -> new CropDto(
        e.getId(),
        e.getName(),
        e.getPlantedArea(),
        e.getPlantedDate(),
        e.getHarvestDate(),
        e.getFarm().getId())).toList();
  }

  /** Gets a crop by id.
   *
   * @param id Crop id.
   * @return The crop with the given id.
   */
  public Optional<CropDto> getCropById(Integer id) {
    return cropRepository.findById(id)
        .map(e -> new CropDto(e.getId(), e.getName(), e.getPlantedArea(),
            e.getPlantedDate(), e.getHarvestDate(), e.getFarm().getId()))
        .map(Optional::of)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
  }

  /** Gets a crop by harvest date.
   *
   * @param start The start harvest date.
   * @param end The end harvest date.
   * @return The crop with the given harvest date.
   */
  public Optional<List<CropDto>> getCropByHarvestDate(LocalDate start, LocalDate end) {
    List<Crop> crops = cropRepository.findByHarvestDateBetween(start, end);

    if (crops.isEmpty()) {
      throw new CropNotFoundException("Nenhuma plantação encontrada!");
    }
    return Optional.of(crops.stream().map(e -> new CropDto(e.getId(), e.getName(),
            e.getPlantedArea(), e.getPlantedDate(),
            e.getHarvestDate(), e.getFarm().getId()))
        .collect(Collectors.toList()));
  }

  /** Adds a fertilizer to a crop.
   *
   * @param cropId The crop id.
   * @param fertilizerId The fertilizer id.
   * @return The crop with the fertilizer added.
   */
  public Crop addFertilizerToCrop(Integer cropId, Integer fertilizerId) {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
        .orElseThrow(() -> new FertilizerNotFoundException("Fertilizante não encontrado!"));

    fertilizer.getCrops().add(crop);
    crop.getFertilizers().add(fertilizer);

    fertilizerRepository.save(fertilizer);
    return cropRepository.save(crop);
  }

  /** Gets all the fertilizers of a crop.
   *
   * @param cropId The crop id.
   * @return A list with all the fertilizers of the crop.
   */
  public List<FertilizerDto> getAllFertilizersByCropId(Integer cropId) {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
    List<Fertilizer> fertilizers = fertilizerRepository.findByCropId(cropId);
    return fertilizers.stream().map(e -> new FertilizerDto(
        e.getId(),
        e.getName(),
        e.getBrand(),
        e.getComposition())).toList();
  }
}