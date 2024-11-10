package com.example.firststation.Dao;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(schema = "slaughterhouse_schema", name = "animal") public class Animal
{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(name = "animalRegNo", unique = true, nullable = false) private String animalRegNo;

  @Column(name = "animalType") private String animalType;

  @Column(name = "arrivalDate", nullable = false) private LocalDate arrivalDate;

  @Column(name = "animalWeight", nullable = false) private Double animalWeight;

  @Column(name = "origin", nullable = false) private String origin;

  public String getAnimalType()
  {
    return animalType;
  }

  public void setAnimalType(String animalType)
  {
    this.animalType = animalType;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getAnimalRegNo()
  {
    return animalRegNo;
  }

  public void setAnimalRegNo(String animalRegNo)
  {
    this.animalRegNo = animalRegNo;
  }

  public double getAnimalWeight()
  {
    return animalWeight;
  }

  public void setAnimalWeight(double animalWeight)
  {
    this.animalWeight = animalWeight;
  }

  public LocalDate getArrivalDate()
  {
    return arrivalDate;
  }

  public void setArrivalDate(LocalDate arrivalDate)
  {
    this.arrivalDate = arrivalDate;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }
}

