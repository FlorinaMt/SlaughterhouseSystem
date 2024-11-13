package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.MixedProduct;
import com.example.thirdstation.Dao.SamePartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<SamePartProduct, Long>
{
  @Query(nativeQuery = true, value= """
      SELECT mixed_product.product_id, mixed_product.product_name
      FROM slaughterhouse_schema.mixed_product
      JOIN slaughterhouse_schema.mixed_product_tray on mixed_product.product_id = mixed_product_tray.product_id
JOIN slaughterhouse_schema.tray on mixed_product_tray.tray_id = tray.tray_id
JOIN slaughterhouse_schema.animal_part on tray.tray_id = animal_part.tray_id
JOIN slaughterhouse_schema.animal on animal_part.origin_animal_id = animal.id
WHERE animal.id =:animalId
UNION
SELECT same_part_product.product_id, same_part_product.part_type
FROM slaughterhouse_schema.same_part_product
JOIN slaughterhouse_schema.same_part_product_tray on same_part_product.product_id = same_part_product_tray.product_id
JOIN slaughterhouse_schema.tray on same_part_product_tray.tray_id = tray.tray_id
JOIN slaughterhouse_schema.animal_part on tray.tray_id = animal_part.tray_id
JOIN slaughterhouse_schema.animal on animal_part.origin_animal_id = animal.id
WHERE animal.id = :animalId;""") List<Object[]> findProductsFromAnimal(@Param("animalId") Long animalId);

}
