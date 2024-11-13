package com.example.thirdstation.Client;

import com.example.thirdstation.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ThirdStationClient
{
  public static void main(String[] args)
  {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(
        "localhost", 9090).usePlaintext().build();

    InfoRetrievalServiceGrpc.InfoRetrievalServiceBlockingStub thirdStationStub = InfoRetrievalServiceGrpc.newBlockingStub(
        managedChannel);

    AnimalIdRequest request1 = AnimalIdRequest.newBuilder().setAnimalId(2)
        .build();

    ProductIdRequest request2=ProductIdRequest.newBuilder().setProductId(3).build();

    ProductListResponse response1=thirdStationStub.getProductsForAnimal(request1);

    System.out.println("Products: " + response1);

    AnimalListResponse response2=thirdStationStub.getAnimalsForProduct(request2);

    System.out.println("Animals: " + response2);
  }
}
