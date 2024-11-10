package com.example.firststation.Repository;

import com.example.firststation.Dao.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>
{
  List<Animal> findByArrivalDate(LocalDate date);
  List<Animal> findByOrigin(String origin);
}

