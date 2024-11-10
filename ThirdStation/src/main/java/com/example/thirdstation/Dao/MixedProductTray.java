package com.example.thirdstation.Dao;

import com.example.secondstation.Dao.Tray;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "slaughterhouse_schema", name = "mixed_product_tray")
public class MixedProductTray implements Serializable
{

  @EmbeddedId
  private MixedProductTrayId id;

  @ManyToOne
  @MapsId("trayId")
  @JoinColumn(name = "trayId")
  private Tray tray;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "productId")
  private MixedProduct product;

  public MixedProduct getProduct()
  {
    return product;
  }

  public void setProduct(MixedProduct product)
  {
    this.product = product;
  }

  public MixedProductTrayId getId()
  {
    return id;
  }

  public void setId(MixedProductTrayId id)
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

}
