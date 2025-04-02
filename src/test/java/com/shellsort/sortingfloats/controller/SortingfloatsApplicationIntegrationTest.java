package com.shellsort.sortingfloats.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SortingfloatsApplicationIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  boolean arraysEqual(ArrayList<Float> arr1, ArrayList<Float> arr2) {
    System.out.println("arr1: " + arr1);
    System.out.println("arr2: " + arr2);
    if (arr1.size() != arr2.size()) {
      return false;
    }
    for (int i = 0; i < arr1.size(); i++) {
      if (!arr1.get(i).equals(arr2.get(i))) {
        return false;
      }
    }
    return true;
  }

  @org.junit.jupiter.api.Test
  public void testSortingEndpoint() {
    // Arrange
    String url = "/api/v1/sort";
    ArrayList<Double> inputArray = new ArrayList<>(java.util.Arrays.asList(5.4, 2.3, 9.8, 1.2));
    Double[] expectedArray = {1.2, 2.3, 5.4, 9.8};
    // Act
    ResponseEntity<ArrayList> response =
        restTemplate.postForEntity(url, inputArray, ArrayList.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());

    @SuppressWarnings("unchecked")
    ArrayList<ArrayList<Double>> allSortingStages = response.getBody();
    int resSz = allSortingStages.size();

    System.out.println("allSortingStages: " + allSortingStages);

    ArrayList<Double> sortedArray = allSortingStages.get(resSz - 1);
    assertArrayEquals(expectedArray, sortedArray.toArray());

    // assertTrue(arraysEqual(expectedArray, sortedArray));
  }
}
