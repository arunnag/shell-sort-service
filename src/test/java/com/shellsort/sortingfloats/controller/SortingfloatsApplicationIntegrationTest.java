package com.shellsort.sortingfloats.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SortingfloatsApplicationIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  @Test
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

    ArrayList<Double> sortedArray = allSortingStages.get(resSz - 1);
    assertArrayEquals(expectedArray, sortedArray.toArray());
  }

  @Test
  public void testStringArrayThrowsBadRequest() {
    // Arrange
    String url = "/api/v1/sort";
    ArrayList<String> inputArray = new ArrayList<>(Arrays.asList("a", "b", "c"));

    // Act
    ResponseEntity<String> response = restTemplate.postForEntity(url, inputArray, String.class);

    // Assert
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(response.getBody().contains("Malformed Request body"));
  }
}
