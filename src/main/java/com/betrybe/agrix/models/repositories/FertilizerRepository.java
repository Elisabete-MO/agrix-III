package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Fertilizer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Fertilizer} entity.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Integer> {

  @Query("SELECT f FROM Fertilizer f JOIN f.crops c WHERE c.id = :cropId")
  List<Fertilizer> findByCropId(Integer cropId);
}
