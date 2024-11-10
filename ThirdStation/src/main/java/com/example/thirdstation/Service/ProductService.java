package com.example.thirdstation.Service;

import com.example.secondstation.Dao.Tray;
import com.example.secondstation.Repository.TrayRepository;
import com.example.thirdstation.Dao.MixedProduct;
import com.example.thirdstation.Dao.MixedProductTray;
import com.example.thirdstation.Dao.SamePartProduct;
import com.example.thirdstation.Dao.SamePartProductTray;
import com.example.thirdstation.Repository.MixedProductRepository;
import com.example.thirdstation.Repository.MixedProductTrayRepository;
import com.example.thirdstation.Repository.SamePartProductRepository;
import com.example.thirdstation.Repository.SamePartProductTrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service public class ProductService
{
  @Autowired private SamePartProductRepository samePartProductRepository;
  @Autowired private MixedProductRepository mixedProductRepository;
  @Autowired private MixedProductTrayRepository mixedProductTrayRepository;
  @Autowired private SamePartProductTrayRepository samePartProductTrayRepository;
  @Autowired private TrayRepository trayRepository;

  public SamePartProduct saveSamePartProduct(SamePartProduct product)
  {
    return samePartProductRepository.save(product);
  }

  public MixedProduct saveMixedProduct(MixedProduct product)
  {
    return mixedProductRepository.save(product);
  }

  public void addMixedProductTrayAssociation(Long trayId, Long productId)
  {
    Optional<Tray> tray = trayRepository.findById(trayId);
    Optional<MixedProduct> product = mixedProductRepository.findById(productId);
    if (tray.isPresent() && product.isPresent())
    {
      MixedProductTray association = new MixedProductTray();
      association.setTray(tray.get());
      association.setProduct(product.get());
      mixedProductTrayRepository.save(association);
    }
  }

  public void addSamePartProductTrayAssociation(Long trayId, Long productId)
  {
    Optional<Tray> tray = trayRepository.findById(trayId);
    Optional<SamePartProduct> product = samePartProductRepository.findById(
        productId);
    if (tray.isPresent() && product.isPresent())
    {
      SamePartProductTray association = new SamePartProductTray();
      association.setTray(tray.get());
      association.setProduct(product.get());
      samePartProductTrayRepository.save(association);
    }
  }
}
