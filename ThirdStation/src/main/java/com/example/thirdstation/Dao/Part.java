package com.example.thirdstation.Dao;

import com.example.thirdstation.Dao.Animal;
//import com.example.firststation.Dao.Animal;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.*;

@Entity @Table(schema = "slaughterhouse_schema", name = "animal_part") public class Part
{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(name = "part_type", nullable = false) private String partType;

  @Column(name = "part_weight", nullable = false) private Double weight;
  @ManyToOne @JoinColumn(name = "origin_animal_id") private Animal originAnimal;

  @ManyToOne @JoinColumn(name = "tray_id") private Tray tray;

  public Animal getOriginAnimal()
  {
    return originAnimal;
  }

  public void setOriginAnimal(Animal originAnimal)
  {
    this.originAnimal = originAnimal;
  }

  public Tray getTray()
  {
    return tray;
  }

  public void setTray(Tray tray)
  {
    this.tray = tray;
  }

  public void setWeight(Double weight)
  {
    this.weight = weight;
  }

  public Double getWeight()
  {
    return weight;
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
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

}

