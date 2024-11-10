package com.example.firststation.Service;

import com.example.firststation.Dao.Animal;
import com.example.firststation.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service public class AnimalService
{
  @Autowired private AnimalRepository animalRepository;

  public Animal registerAnimal(Animal animal)
  {
    return animalRepository.save(animal);
  }

  public Animal getAnimalById(Long id)
  {
    return animalRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Animal not found"));
  }

  public List<Animal> getAnimalsByDate(LocalDate date) {
    return animalRepository.findByArrivalDate(date);
  }

  public List<Animal> getAnimalsByOrigin(String origin) {
    return animalRepository.findByOrigin(origin);
  }
}
