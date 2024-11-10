package com.example.thirdstation.Dao;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "slaughterhouse_schema", name = "same_part_product")
public class SamePartProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @Column(name = "partType")
  private String partType;

  @Column(name = "numberOfParts")
  private Integer numberOfParts;

  @Column(name = "weight")
  private Double weight;

  @Column(name = "packageDate")
  private LocalDate packageDate;

  @Column(name = "expirationDate")
  private LocalDate expirationDate;

  public LocalDate getExpirationDate()
  {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate)
  {
    this.expirationDate = expirationDate;
  }

  public LocalDate getPackageDate()
  {
    return packageDate;
  }

  public void setPackageDate(LocalDate packageDate)
  {
    this.packageDate = packageDate;
  }

  public Double getWeight()
  {
    return weight;
  }

  public void setWeight(Double weight)
  {
    this.weight = weight;
  }

  public Integer getNumberOfParts()
  {
    return numberOfParts;
  }

  public void setNumberOfParts(Integer numberOfParts)
  {
    this.numberOfParts = numberOfParts;
  }

  public String getPartType()
  {
    return partType;
  }

  public void setPartType(String partType)
  {
    this.partType = partType;
  }

  public Long getProductId()
  {
    return productId;
  }

  public void setProductId(Long productId)
  {
    this.productId = productId;
  }




}

