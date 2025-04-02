package com.shellsort.sortingfloats.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/** Test class for ShellSortService */
@SpringBootTest
class ShellSortServiceTest {

  private final ShellSortService shellSortService = new ShellSortService();

  /** Tests the sorting functionality of the ShellSortService with a single-element list. */
  @Test
  void testSortSingleElement() {
    ArrayList<Double> unSortedFloats = new ArrayList<>(Arrays.asList(3.3));
    ArrayList<Double> sortedFloats = new ArrayList<>(Arrays.asList(3.3));

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    assertTrue(unSortedFloats.equals(actualSortedFloats.get(0)));
    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
  }

  /**
   * Tests the sorting functionality of the ShellSortService with a list of floats including positve
   * and negative numbers.
   */
  @Test
  void testSort() {
    ArrayList<Double> unSortedFloats =
        new ArrayList<>(Arrays.asList(3.3, 2.2, 1.1, -2.0, 7.2, -9.3));
    ArrayList<Double> sortedFloats = new ArrayList<>(Arrays.asList(-9.3, -2.0, 1.1, 2.2, 3.3, 7.2));

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    assertFalse(unSortedFloats.equals(actualSortedFloats.get(0)));
    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
  }

  /*
   * Tests the sorting functionality of the ShellSortService with a list of ten thousand floats.
   */
  @Test
  void testSortTenThousandFloats() {
    ArrayList<Double> unSortedFloats = new ArrayList<>();
    ArrayList<Double> sortedFloats = new ArrayList<>();

    // Generate 10,000 random floats between -1000 and 1000
    for (int i = 5000; i > -5000; i--) {
      double randomFloat = -1000 + Math.random() * 2000;
      unSortedFloats.add(randomFloat);
      sortedFloats.add(randomFloat);
    }
    sortedFloats.sort(Double::compareTo);

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    // there should more than 12 iterations for 10,000 elements
    assertTrue(size > 12);
    // Check if the last element is the same as the sorted list
    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
  }
}
