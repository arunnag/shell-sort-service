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

    for (int i = 5000; i > -5000; i--) {
      unSortedFloats.add((double) i);
      sortedFloats.add((double) i);
    }
    sortedFloats.sort(Double::compareTo);

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
    assertFalse(sortedFloats.equals(actualSortedFloats.get(0)));
  }
}
