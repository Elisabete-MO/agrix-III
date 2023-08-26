package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;
import java.util.List;

/** Farm DTO.
 *
 * @param id  identifier of the farm
 * @param name name of the farm
 * @param size area's size of the farm
 */
public record FarmDto(Integer id, String name, Double size) {
  public Farm toFarm() {
    return new Farm(id, name, size, List.of());
  }

  public static FarmDto fromFarm(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }
}
