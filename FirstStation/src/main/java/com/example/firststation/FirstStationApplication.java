package com.example.firststation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication @EntityScan(basePackages = "com.*") @EnableJpaRepositories(basePackages = "com.*") @ComponentScan(basePackages = {"com.*"})
public class FirstStationApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(FirstStationApplication.class, args);
    System.out.println("First station app running...");
  }

}
