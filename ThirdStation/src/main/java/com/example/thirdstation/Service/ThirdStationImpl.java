package com.example.thirdstation.Service;

import com.example.thirdstation.Repository.*;
import com.example.thirdstation.grpc.Animal;
import com.example.thirdstation.grpc.InfoRetrievalServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.thirdstation.grpc.*;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService public class ThirdStationImpl
    extends InfoRetrievalServiceGrpc.InfoRetrievalServiceImplBase
{
 @Autowired private ProductRepository productRepository;
  @Autowired private AnimalRepository animalRepository;

  @Override public void getAnimalsForProduct(ProductIdRequest request,
      io.grpc.stub.StreamObserver<AnimalListResponse> responseObserver)
  {
    System.out.println(
        "Received request for animals from product" + request.getProductId());

    List<Object[]> animals = animalRepository.findAnimalsFromProduct(
        request.getProductId());

    AnimalListResponse response = AnimalListResponse.newBuilder().addAllAnimals(animals.stream().map(
        animal -> Animal.newBuilder().setId((Long) animal[0])
            .setRegistrationNumber((String) animal[1])
            .setAnimalType((String) animal[2]).setOrigin((String) animal[3])
            .build()).collect(Collectors.toList())).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override public void getProductsForAnimal(AnimalIdRequest request,
      io.grpc.stub.StreamObserver<ProductListResponse> responseObserver)
  {
    System.out.println(
        "Received request for products from animal" + request.getAnimalId());

    List<Object[]> products = productRepository.findProductsFromAnimal(request.getAnimalId());

    ProductListResponse response=ProductListResponse.newBuilder().addAllProducts(products.stream().map(
        product -> Product.newBuilder().setId((Long) product[0])
            .setProductType((String) product[1])
            .build()).collect(Collectors.toList())).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
