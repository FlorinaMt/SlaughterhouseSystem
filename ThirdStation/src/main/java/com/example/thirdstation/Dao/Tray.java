package com.example.thirdstation.Dao;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(schema = "slaughterhouse_schema", name = "tray")
public class Tray {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long trayId;

  @Column(name = "part_type", nullable = false)
  private String partType;

  @Column(name = "total_weight")
  private Double currentWeight;

  @Column(name = "capacity", nullable = false)
  private Double maxWeight;


  @OneToMany(mappedBy = "tray")
  private List<MixedProductTray> mixedProductTrays;

  @OneToMany(mappedBy = "tray")
  private List<Part> animalParts;

  @OneToMany (mappedBy = "tray")
  private List<SamePartProductTray> samePartProductTrays;

  public List<MixedProductTray> getMixedProductTrays()
  {
    return mixedProductTrays;
  }

  public void setMixedProductTrays(List<MixedProductTray> mixedProductTrays)
  {
    this.mixedProductTrays = mixedProductTrays;
  }

  public List<Part> getAnimalParts()
  {
    return animalParts;
  }

  public void setAnimalParts(List<Part> animalParts)
  {
    this.animalParts = animalParts;
  }

  public List<SamePartProductTray> getSamePartProductTrays()
  {
    return samePartProductTrays;
  }

  public void setSamePartProductTrays(
      List<SamePartProductTray> samePartProductTrays)
  {
    this.samePartProductTrays = samePartProductTrays;
  }


  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts;
  }

  public void setMaxWeight(Double maxWeight)
  {
    this.maxWeight = maxWeight;
  }

  public void setCurrentWeight(Double currentWeight)
  {
    this.currentWeight = currentWeight;
  }

  @OneToMany(mappedBy = "tray")
  private List<Part> parts;

  public double getMaxWeight()
  {
    return maxWeight;
  }

  public void setMaxWeight(double maxWeight)
  {
    this.maxWeight = maxWeight;
  }

  public String getPartType()
  {
    return partType;
  }

  public void setPartType(String partType)
  {
    this.partType = partType;
  }

  public Long getId()
  {
    return trayId;
  }

  public void setId(Long trayId)
  {
    this.trayId = trayId;
  }

  public Double getCurrentWeight()
  {
    return currentWeight;
  }



}

