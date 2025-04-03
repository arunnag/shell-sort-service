package com.shellsort.sortingfloats.controller;

import com.shellsort.sortingfloats.service.ShellSortService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SortingFloatsController handles HTTP requests for sorting floating-point numbers. It uses the
 * ShellSortService to perform the sorting operation.
 *
 * <p>This controller provides an endpoint to sort an array of Double values using the Shell Sort
 * algorithm.
 */
@RestController
@RequestMapping("/api/v1")
public class SortingfloatsController {

  /** logger for logging information */
  private static final Logger logger = LoggerFactory.getLogger(SortingfloatsController.class);

  /** service for sorting floating-point numbers */
  private final ShellSortService shellSortService;

  public SortingfloatsController(ShellSortService shellSortService) {
    this.shellSortService = shellSortService;
  }

  /**
   * Endpoint to sort an array of floating-point numbers using the Shell Sort algorithm.
   *
   * @param floats the array of Double values to be sorted
   * @return ResponseEntity containing the sorted array and HTTP status
   */
  @PostMapping("/sort")
  public ResponseEntity<Double[]> sortFloats(
      @Valid
          @RequestBody
          @NotNull(message = "Input array must not be null")
          @NotEmpty(message = "Input array must not be empty")
          Double[] floats) {
    if (floats == null) {
      logger.error("Received null input for sorting.");
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    logger.info("Received array for sorting: {}", Arrays.toString(floats));

    Double[] sortedArray = shellSortService.shellSort(floats);

    logger.info("Sorted array: {}", Arrays.toString(sortedArray));

    return new ResponseEntity<>(sortedArray, HttpStatus.OK);
  }
}
