package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Crop} entity.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {
  @Query("SELECT c FROM Crop c WHERE c.farm.id = :farmId")
  List<Crop> findAllByFarmId(Integer farmId);

  List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
