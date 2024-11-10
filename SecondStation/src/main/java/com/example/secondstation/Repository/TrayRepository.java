package com.example.secondstation.Repository;

import com.example.secondstation.Dao.Tray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository public interface TrayRepository extends JpaRepository<Tray, Long>
{
  List<Tray> findByPartType(String partType);
}

