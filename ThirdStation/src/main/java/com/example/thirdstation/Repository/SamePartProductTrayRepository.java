package com.example.thirdstation.Repository;

import com.example.thirdstation.Dao.SamePartProductTray;
import com.example.thirdstation.Dao.SamePartProductTrayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SamePartProductTrayRepository extends JpaRepository<SamePartProductTray, SamePartProductTrayId>
{
}
