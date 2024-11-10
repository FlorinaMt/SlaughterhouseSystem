package com.example.firststation.Controller;

import com.example.firststation.Dao.Animal;
import com.example.firststation.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
  @Autowired private AnimalService animalService;

  @PostMapping public ResponseEntity<Animal> registerAnimal(@RequestBody Animal animal)
  {
    Animal savedAnimal=animalService.registerAnimal(animal);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
    Animal animal = animalService.getAnimalById(id);
    return ResponseEntity.ok(animal);
  }

  @GetMapping("/date/{date}")
  public List<Animal> getAnimalsByDate(@PathVariable String date) {
    return animalService.getAnimalsByDate(LocalDate.parse(date));
  }

  @GetMapping("/origin/{origin}")
  public List<Animal> getAnimalsByOrigin(@PathVariable String origin) {
    return animalService.getAnimalsByOrigin(origin);
  }

}
