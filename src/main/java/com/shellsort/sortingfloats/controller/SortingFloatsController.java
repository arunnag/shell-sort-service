package com.shellsort.sortingfloats.controller;

import com.shellsort.sortingfloats.service.ShellSortService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SortingFloatsController {

  /** logger for logging information */
  private static final Logger logger = LoggerFactory.getLogger(SortingFloatsController.class);

  /** service for sorting floating-point numbers */
  @Autowired private ShellSortService shellSortService;

  /**
   * Handles POST requests to sort a list of floating-point numbers using the Shell Sort algorithm.
   *
   * @param floats The list of floating-point numbers to be sorted. Must not be null or empty.
   * @return A ResponseEntity containing a list of lists, where each inner list represents the state
   *     of the array after each iteration of the Shell Sort algorithm. Returns with HTTP status 200
   *     (OK).
   */
  @PostMapping("/sort")
  public ResponseEntity<ArrayList<ArrayList<Double>>> sortFloats(
      @NotEmpty @NotNull @RequestBody ArrayList<Double> floats) {

    logger.info("Received request to sort floats: {}", floats);
    ArrayList<ArrayList<Double>> arrayAfterEachIteration = shellSortService.sort(floats);
    logger.info(null, floats, arrayAfterEachIteration);
    return new ResponseEntity<>(arrayAfterEachIteration, HttpStatus.OK);
  }
}
