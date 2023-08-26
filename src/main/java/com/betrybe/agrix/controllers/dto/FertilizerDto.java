package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Fertilizer;

/** Fertilizer DTO.
 *
 * @param id identifier of the fertilizer
 * @param name name of the fertilizer
 * @param brand brand of the fertilizer
 * @param composition composition of the fertilizer
 */
public record FertilizerDto(int id, String name, String brand,
                            String composition) {
  public Fertilizer toFertilizer() {
    return new Fertilizer(id(), name(), brand(), composition());
  }
  
  public static FertilizerDto fromFertilizer(Fertilizer fertilizer) {
    return new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
  }
}
