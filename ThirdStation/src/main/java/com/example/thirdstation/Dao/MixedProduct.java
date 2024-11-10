package com.example.thirdstation.Dao;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "slaughterhouse_schema", name = "mixed_product")
public class MixedProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @Column(name = "productName")
  private String productName;

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

  public String getProductName()
  {
    return productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
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

