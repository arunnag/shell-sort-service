package com.shellsort.sortingfloats.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

/*
 * Integration test for the SortingfloatsApplication
 * This test class is used to test the REST API endpoints of the application.
 * It uses the TestRestTemplate to send HTTP requests and verify the responses.
 * The test cases cover the sorting functionality and error handling for invalid input.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SortingfloatsApplicationIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  // Test sorting few floating point numbers and check if the response is sorted and returns success
  // status
  @Test
  public void testSortingEndpoint() {
    // Arrange
    String url = "/api/v1/sort";
    Double[] inputArray = {5.4, 2.3, 9.8, 1.2};
    Double[] expectedArray = {1.2, 2.3, 5.4, 9.8};
    // Act
    ResponseEntity<Double[]> response = restTemplate.postForEntity(url, inputArray, Double[].class);

    assertEquals(HttpStatus.OK, response.getStatusCode());

    Double[] actualSortedArray = response.getBody();

    assertArrayEquals(expectedArray, actualSortedArray);
  }

  // Test sorting with non floating point array to see if the response is bad request
  @Test
  public void testStringArrayThrowsBadRequest() {
    // Arrange
    String url = "/api/v1/sort";
    String[] inputArray = {"a", "b", "c"};

    // Act
    ResponseEntity<String> response = restTemplate.postForEntity(url, inputArray, String.class);

    // Assert
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertTrue(response.getBody().contains("Malformed Request body"));
  }
}
