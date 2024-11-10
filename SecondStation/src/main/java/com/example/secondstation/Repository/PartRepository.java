package com.example.secondstation.Repository;

import com.example.secondstation.Dao.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>
{
  List<Part> findByAnimalId(Long animalId);
}

