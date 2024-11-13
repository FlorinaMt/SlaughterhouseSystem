package com.example.thirdstation.Dao;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "slaughterhouse_schema", name = "same_part_product_tray")
public class SamePartProductTray implements Serializable
{
  @EmbeddedId
  private SamePartProductTrayId id;

  @ManyToOne
  @MapsId("trayId")
  @JoinColumn(name = "tray_id")
  private Tray tray;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private SamePartProduct product;

  public SamePartProductTrayId getId()
  {
    return id;
  }

  public void setId(SamePartProductTrayId id)
  {
    this.id = id;
  }

  public Tray getTray()
  {
    return tray;
  }

  public void setTray(Tray tray)
  {
    this.tray = tray;
  }

  public SamePartProduct getProduct()
  {
    return product;
  }

  public void setProduct(SamePartProduct product)
  {
    this.product = product;
  }

}
