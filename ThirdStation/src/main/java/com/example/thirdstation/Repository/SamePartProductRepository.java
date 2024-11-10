package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.SamePartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SamePartProductRepository extends JpaRepository<SamePartProduct, Long>
{
}
