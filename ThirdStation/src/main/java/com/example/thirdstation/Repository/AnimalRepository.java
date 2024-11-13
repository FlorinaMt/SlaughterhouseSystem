package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.Animal;
import com.example.thirdstation.Dao.MixedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository public interface AnimalRepository extends CrudRepository<Animal, Long>
{
  @Query(nativeQuery = true, value= """
      SELECT animal.id, animal_reg_no, animal_type, origin FROM slaughterhouse_schema.animal
               JOIN slaughterhouse_schema.animal_part on animal.id = animal_part.origin_animal_id
               JOIN slaughterhouse_schema.tray on animal_part.tray_id = tray.tray_id
               JOIN slaughterhouse_schema.mixed_product_tray on tray.tray_id = mixed_product_tray.tray_id
               JOIN slaughterhouse_schema.mixed_product on mixed_product_tray.product_id = mixed_product.product_id
      WHERE mixed_product.product_id = :productId
      UNION
      SELECT animal.id, animal_reg_no, animal_type, origin
      FROM slaughterhouse_schema.animal
               JOIN slaughterhouse_schema.animal_part on animal.id = animal_part.origin_animal_id
               JOIN slaughterhouse_schema.tray on animal_part.tray_id = tray.tray_id
               JOIN slaughterhouse_schema.same_part_product_tray on tray.tray_id = same_part_product_tray.tray_id
               JOIN slaughterhouse_schema.same_part_product on same_part_product_tray.product_id = same_part_product.product_id
      WHERE same_part_product.product_id = :productId;""") List<Object[]> findAnimalsFromProduct(@Param("productId") Long productId);


}
