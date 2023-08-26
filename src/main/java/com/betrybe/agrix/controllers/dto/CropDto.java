package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;

import java.time.LocalDate;

/**
 * Crop DTO.
 *
 * @param id          identifier of the crop
 * @param name        name of the crop
 * @param plantedArea area planted with the crop
 * @param farmId      identifier of the farm that the crop belongs to
 * @param plantedDate date when the crop was planted
 * @param harvestDate date when the crop was harvested
 */
public record CropDto(int id, String name, Double plantedArea,
                      LocalDate plantedDate, LocalDate harvestDate, Integer farmId) {
  public Crop toCrop(Farm farm) {
    return new Crop(id(), name(), plantedArea(),
        farm, plantedDate(), harvestDate());
  }

  /** Converts a crop to a DTO.
   *
   * @param crop crop to be converted
   * @return DTO
   */
  public static CropDto fromCrop(Crop crop) {
    return new CropDto(crop.getId(), crop
        .getName(), crop.getPlantedArea(), crop.getPlantedDate(),
        crop.getHarvestDate(), crop.getFarm().getId());
  }
}
