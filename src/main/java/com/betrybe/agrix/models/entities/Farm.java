package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Farm entity.
 */
@Entity
@Table(name = "farm")
//@EntityListeners(AuditingEntityListener.class)
//@Audited
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Double size;

  @OneToMany(mappedBy = "farm")
  private List<Crop> crops = new ArrayList<>();

  //  @Column(name = "created_by")
  //  @CreatedBy
  //  private String createdBy;
  //
  //  @Column(name = "modified_by")
  //  @LastModifiedBy
  //  private String modifiedBy;

  public Farm() {
  }

  /** Farm constructor.
   *
   * @param id identifier of the crop
   * @param name name of the crop
   * @param size area's size of the farm
   * @param crops list of crops
   */
  public Farm(Integer id, String name, Double size, List<Crop> crops) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.crops = crops;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public void addCrop(Crop crop) {
    crops.add(crop);
    crop.setFarm(this);
  }

  public List<Crop> getCrops() {
    return crops;
  }
}
