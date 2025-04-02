package com.shellsort.sortingfloats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The SortingfloatsApplication class serves as the entry point for the Spring Boot application. It
 * contains the main method which launches the application.
 *
 * <p>This application is designed to demonstrate sorting algorithms for floating-point numbers.
 *
 * <p>Usage:
 *
 * <pre>{@code
 * java -jar sortingfloats.jar
 * }</pre>
 *
 * <p>Dependencies:
 *
 * <ul>
 *   <li>Spring Boot
 * </ul>
 *
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 */
@SpringBootApplication
public class SortingfloatsApplication {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(SortingfloatsApplication.class, args);
  }
}
