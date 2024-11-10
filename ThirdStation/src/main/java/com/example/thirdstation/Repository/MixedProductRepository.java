package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.MixedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MixedProductRepository extends JpaRepository<MixedProduct, Long>
{
}
