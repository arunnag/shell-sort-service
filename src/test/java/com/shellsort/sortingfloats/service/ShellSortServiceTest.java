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

  @Test
  void testSortSingleElement() {
    ArrayList<Double> unSortedFloats = new ArrayList<>(Arrays.asList(3.3));
    ArrayList<Double> sortedFloats = new ArrayList<>(Arrays.asList(3.3));

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    assertTrue(unSortedFloats.equals(actualSortedFloats.get(0)));
    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
  }

  /** Test for sorting a list of floats */
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

  /** Test for sorting a list of 20 floats */
  @Test
  void testSortTwentyFloats() {
    ArrayList<Double> unSortedFloats =
        new ArrayList<>(
            Arrays.asList(
                3.3, 2.2, 1.1, -2.0, 7.2, -9.3, 0.0, 5.5, 4.4, 6.6, 8.8, 9.9, 10.1, 11.2, 12.3,
                13.4, 14.5, 15.6, 16.7, 17.8));
    ArrayList<Double> sortedFloats =
        new ArrayList<>(
            Arrays.asList(
                -9.3, -2.0, 0.0, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.2, 8.8, 9.9, 10.1, 11.2, 12.3,
                13.4, 14.5, 15.6, 16.7, 17.8));

    ArrayList<ArrayList<Double>> actualSortedFloats = shellSortService.sort(unSortedFloats);

    int size = actualSortedFloats.size();

    assertTrue(sortedFloats.equals(actualSortedFloats.get(size - 1)));
    assertFalse(sortedFloats.equals(actualSortedFloats.get(0)));
  }
}
