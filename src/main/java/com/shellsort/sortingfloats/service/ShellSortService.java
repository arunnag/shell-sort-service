package com.shellsort.sortingfloats.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ShellSortService provides a method to perform Shell Sort on an array of Double values. It uses
 * the Shell sort algorithm, which is an optimization of insertion sort that allows the exchange of
 * items that are far apart.
 *
 * <p>Shell sort is a generalization of insertion sort that allows the exchange of items that are
 * far apart. The algorithm uses a gap sequence to determine which elements to compare and swap.
 */
@Service
public class ShellSortService {
  /** Logger instance for logging messages. */
  private static final Logger logger = LoggerFactory.getLogger(ShellSortService.class);

  /**
   * Sorts an array of Double values using the Shell Sort algorithm. Shell Sort is an optimization
   * over Insertion Sort that allows the exchange of far-apart elements to improve sorting
   * efficiency.
   *
   * @param floats the array of Double values to be sorted. If the array is null, empty, or contains
   *     a single element, it is returned as is.
   * @return the sorted array of Double values in ascending order.
   *     <p>Time Complexity: O(n^2) in the worst case, but can be significantly better in practice
   *     depending on the gap sequence used. Space Complexity: O(1) as it sorts the array in place.
   */
  public Double[] shellSort(Double[] floats) {

    if ((floats == null) || (floats.length < 2)) {
      logger.warn("Input array is null, empty, or single element. Returning as is.");
      return floats;
    }

    int n = floats.length;
    logger.info("Starting shellSort with input array of size: {}", n);

    // Start with a big gap, then reduce the gap
    for (int gap = n / 2; gap > 0; gap /= 2) {
      logger.debug("Current gap: {}", gap);

      // Do a gapped insertion sort for this gap size.
      for (int i = gap; i < n; i += 1) {
        Double temp = floats[i];
        int j;

        logger.trace("Considering element at index {}: {}", i, temp);

        // Shift earlier gap-sorted elements up until the correct location for floats[i] is found
        for (j = i; j >= gap && floats[j - gap] > temp; j -= gap) {
          logger.trace("Shifting element at index {} to index {}", j - gap, j);
          floats[j] = floats[j - gap];
        }
        floats[j] = temp;
        logger.trace("Placed element {} at index {}", temp, j);
      }

      logger.debug("Array after gap {}: {}", gap, floats);
    }

    logger.info("Sorting completed. Sorted array: {}", floats.toString());
    return floats;
  }
}
