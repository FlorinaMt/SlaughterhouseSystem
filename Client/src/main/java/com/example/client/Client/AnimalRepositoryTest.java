package com.example.client.Client;

import com.example.firststation.Dao.Animal;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class AnimalRepositoryTest {

  private static final String BASE_URL = "http://localhost:8081/animals";

  private RestTemplate restTemplate;

  public AnimalRepositoryTest() {
    this.restTemplate = new RestTemplate();
  }

  public Animal registerAnimal(Animal animal) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Animal> entity = new HttpEntity<>(animal, headers);

    ResponseEntity<Animal> response = restTemplate.exchange(
        BASE_URL, HttpMethod.POST, entity, Animal.class);

    return response.getBody();
  }

  public Animal getAnimal(Long id) {
    String url = BASE_URL + "/" + id;
    return restTemplate.getForObject(url, Animal.class);
  }

  public static void main(String[] args) {
    AnimalRepositoryTest client = new AnimalRepositoryTest();

    // Create an animal to register
    Animal newAnimal = new Animal();
    newAnimal.setAnimalRegNo("A12346");
    newAnimal.setAnimalType("Cow");
    newAnimal.setArrivalDate(LocalDate.now());
    newAnimal.setAnimalWeight(500.00);
    newAnimal.setOrigin("Farm");

    // Register the animal
    Animal registeredAnimal = client.registerAnimal(newAnimal);
    System.out.println("Registered Animal: " + registeredAnimal.getAnimalRegNo());

    // Retrieve the animal
    Animal retrievedAnimal = client.getAnimal(1L);
    System.out.println("Retrieved Animal: " + retrievedAnimal.getAnimalType());
  }
}
