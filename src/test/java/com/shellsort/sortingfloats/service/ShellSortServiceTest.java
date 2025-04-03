package com.shellsort.sortingfloats.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/** Test class for ShellSortService */
@SpringBootTest
class ShellSortServiceTest {

  private final ShellSortService shellSortService = new ShellSortService();

  /** Tests the sorting functionality of the ShellSortService with an empty list. */
  @Test
  void testSortEmpty() {
    Double[] unSortedFloats = {};
    Double[] sortedFloats = {};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /** Tests the sorting functionality of the ShellSortService with a null list. */
  @Test
  void testSortNull() {
    Double[] unSortedFloats = null;
    Double[] sortedFloats = null;

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /** Tests the sorting functionality of the ShellSortService with a single-element list. */
  @Test
  void testSortSingleElement() {
    Double[] unSortedFloats = {3.3};
    Double[] sortedFloats = {3.3};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /** Tests the sorting functionality of the ShellSortService with an already sorted list. */
  @Test
  void testSortAlreadySorted() {
    Double[] unSortedFloats = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
    Double[] sortedFloats = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /**
   * Tests the sorting functionality of the ShellSortService with a list of floats including positve
   * and negative numbers and zeros
   */
  @Test
  void testMixOfFloats() {
    Double[] unSortedFloats = {3.3, 2.2, 1.1, -2.0, 7.2, 0.0, -9.3, 0.0, 0.1};
    Double[] sortedFloats = {-9.3, -2.0, 0.0, 0.0, 0.1, 1.1, 2.2, 3.3, 7.2};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /** Tests the sorting functionality of the ShellSortService with a reverse sorted list. */
  @Test
  void testSortReverseSorted() {
    Double[] unSortedFloats = {9.9, 8.8, 7.7, 6.6, 5.5, 4.4, 3.3, 2.2, 1.1};
    Double[] sortedFloats = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /**
   * Tests the sorting functionality of the ShellSortService with a list containing duplicate
   * values.
   */
  @Test
  void testSortWithDuplicates() {
    Double[] unSortedFloats = {3.3, 2.2, 3.3, 1.1, 2.2, 1.1};
    Double[] sortedFloats = {1.1, 1.1, 2.2, 2.2, 3.3, 3.3};

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }

  /*
   * Tests the sorting functionality of the ShellSortService with a list of ten thousand floats.
   */
  @Test
  void testSortTenThousandFloats() {
    Double[] unSortedFloats = new Double[10000];
    Double[] sortedFloats = new Double[10000];

    // Generate 10,000 random floats between -1000 and 1000
    for (int i = 0; i < 10000; i++) {
      double randomFloat = -1000 + Math.random() * 2000;
      unSortedFloats[i] = randomFloat;
      sortedFloats[i] = randomFloat;
    }
    Arrays.sort(sortedFloats);

    Double[] actualSortedFloats = shellSortService.shellSort(unSortedFloats);

    assertArrayEquals(sortedFloats, actualSortedFloats);
  }
}
