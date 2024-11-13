package com.example.thirdstation.Dao;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.time.LocalDate;
import java.util.List;

@Entity @Table(schema = "slaughterhouse_schema", name = "animal") public class Animal
{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(name = "animal_reg_no", unique = true, nullable = false) private String animalRegNo;

  @Column(name = "animal_type") private String animalType;

  @Column(name = "arrival_date", nullable = false) private LocalDate arrivalDate;

  @Column(name = "animal_weight", nullable = false) private Double animalWeight;

  @Column(name = "origin", nullable = false) private String origin;
  @OneToMany (mappedBy = "originAnimal") private List<Part> animalParts;


  public List<Part> getAnimalParts()
  {
    return animalParts;
  }

  public void setAnimalParts(List<Part> animalParts)
  {
    this.animalParts = animalParts;
  }

  public void setAnimalWeight(Double animalWeight)
  {
    this.animalWeight = animalWeight;
  }


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

