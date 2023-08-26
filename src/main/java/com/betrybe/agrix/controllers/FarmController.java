package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Farm entity.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final CropService cropService;
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.cropService = cropService;
    this.farmService = farmService;
  }

  /** Creates a new farm.
   *
   * @param farmDto DTO with the farm data.
   * @return The farm created.
   */
  @PostMapping()
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    FarmDto newFarm = farmService.insertFarm(farmDto);
    //ResponseDTO<Farm> responseDTO = new ResponseDTO<>(newFarm);
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  @GetMapping()
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    return ResponseEntity.ok(farmService.getAllFarms());
  }


  @GetMapping("/{id}")
  public ResponseEntity<Optional<FarmDto>> getFarmById(@PathVariable Integer id) {
    Optional<FarmDto> optionalFarm = farmService.getFarmById(id);
    return ResponseEntity.ok(optionalFarm);
  }

  /** Creates a new crop.
   *
   * @param cropDto   DTO with the crop data.
   * @param farmId   Farm that the crop belongs to.
   * @return The crop created.
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(
      @RequestBody CropDto cropDto, @PathVariable Integer farmId) {
    Optional<FarmDto> optionalFarm = farmService.getFarmById(farmId);
    CropDto insertedCrop = cropService.insertCrop(cropDto, optionalFarm.get().toFarm());

    return ResponseEntity.status(HttpStatus.CREATED).body(insertedCrop);
  }

  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getAllCrops(@PathVariable Integer farmId) {
    Optional<FarmDto> optionalFarm = farmService.getFarmById(farmId);
    return ResponseEntity.ok(cropService.getAllCropsByFarmId(farmId));
  }
}
