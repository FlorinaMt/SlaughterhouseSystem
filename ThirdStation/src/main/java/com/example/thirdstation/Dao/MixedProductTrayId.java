package com.example.thirdstation.Dao;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MixedProductTrayId implements Serializable {
  private Long trayId;
  private Long productId;

  public Long getProductId()
  {
    return productId;
  }

  public void setProductId(Long productId)
  {
    this.productId = productId;
  }

  public Long getTrayId()
  {
    return trayId;
  }

  public void setTrayId(Long trayId)
  {
    this.trayId = trayId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MixedProductTrayId)) return false;
    MixedProductTrayId that = (MixedProductTrayId) o;
    return Objects.equals(trayId, that.trayId) &&
        Objects.equals(productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trayId, productId);
  }
}

