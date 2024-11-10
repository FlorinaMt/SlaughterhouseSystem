package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.MixedProductTray;
import com.example.thirdstation.Dao.MixedProductTrayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MixedProductTrayRepository extends JpaRepository<MixedProductTray, MixedProductTrayId>
{
}
