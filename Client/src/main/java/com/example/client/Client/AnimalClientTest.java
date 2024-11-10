package com.example.client.Client;

import com.example.firststation.Dao.Animal;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class AnimalClientTest {
  public static void main(String[] args) {
    RestTemplate restTemplate = new RestTemplate();

    Animal animal = new Animal();
    animal.setAnimalRegNo("A123");
    animal.setAnimalWeight(150.5);
    animal.setArrivalDate(LocalDate.now());
    animal.setOrigin("FarmX");
    animal.setId(1L);

    Animal createdAnimal = restTemplate.postForObject("http://localhost:8081/animals", animal, Animal.class);
    System.out.println("Created Animal: " + createdAnimal);

    Animal fetchedAnimal = restTemplate.getForObject("http://localhost:8081/animals/1", Animal.class);
    System.out.println("Fetched Animal: " + fetchedAnimal);
  }
}

