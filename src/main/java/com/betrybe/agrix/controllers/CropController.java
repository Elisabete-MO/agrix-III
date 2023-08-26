package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Crop entity.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping()
  public ResponseEntity<List<CropDto>> getAllCrops() {
    return ResponseEntity.ok(cropService.getAllCrops());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<CropDto>> getCropById(@PathVariable Integer id) {
    Optional<CropDto> optionalCrop = cropService.getCropById(id);
    return ResponseEntity.ok(optionalCrop);
  }

  @GetMapping("/search")
  public ResponseEntity<Optional<List<CropDto>>> getCropsByHarvestDateRange(
      @RequestParam LocalDate start, @RequestParam LocalDate end) {
    Optional<List<CropDto>> optionalCrop = cropService.getCropByHarvestDate(start, end);
    return ResponseEntity.ok(optionalCrop);
  }

  /** Associates a fertilizer to a crop.
   *
   * @param cropId identifier of the crop
   * @param fertilizerId identifier of the fertilizer
   * @return A message with the success of the operation.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> addFertilizerToCrop(@PathVariable Integer cropId,
                                                    @PathVariable Integer fertilizerId) {
    cropService.addFertilizerToCrop(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }

  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getAllFertilizersByCropId(
      @PathVariable Integer cropId) {
    List<FertilizerDto> fertilizers = cropService.getAllFertilizersByCropId(cropId);
    return ResponseEntity.ok(fertilizers);
  }
}