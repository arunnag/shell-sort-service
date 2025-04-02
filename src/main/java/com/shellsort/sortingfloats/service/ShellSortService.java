package com.shellsort.sortingfloats.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service class that provides sorting functionality using the Shell Sort algorithm. This class is
 * annotated with @Service, making it a Spring service component.
 *
 * <p>The primary method of this class is {@link #sort(ArrayList)}, which sorts a list of
 * floating-point numbers. The sorting process is implemented using the Shell Sort algorithm, which
 * is detailed in the {@link #shellSort(ArrayList)} method.
 *
 * <p>The Shell Sort algorithm sorts elements that are far apart and progressively reduces the gap
 * between elements to be compared, allowing the algorithm to move elements closer to their final
 * positions more quickly.
 *
 * <p>The {@link #shellSort(ArrayList)} method returns a list of lists, where each inner list
 * represents the state of the original list after each gap iteration, providing a step-by-step view
 * of the sorting process.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * ShellSortService shellSortService = new ShellSortService();
 * ArrayList<Float> unsortedList = new ArrayList<>(Arrays.asList(3.4f, 1.2f, 5.6f, 2.1f));
 * ArrayList<ArrayList<Float>> sortedSteps = shellSortService.sort(unsortedList);
 * }</pre>
 */
@Service
public class ShellSortService {
  /** Logger instance for logging messages. */
  private static final Logger logger = LoggerFactory.getLogger(ShellSortService.class);

  /**
   * Sorts the list of floats using shell sort algorithm
   *
   * @param floats list of floats to be sorted
   * @return sorted list of floats
   */
  public ArrayList<ArrayList<Double>> sort(ArrayList<Double> floats) {
    logger.info("Starting sort method with input list: {}", floats);

    // handle edge cases
    if (floats.size() == 1) {
      logger.info("Input list has only one element, returning as is.");
      ArrayList<ArrayList<Double>> result = new ArrayList<>();
      result.add(new ArrayList<>(floats));
      return result;
    }

    ArrayList<ArrayList<Double>> sortedSteps = shellSort(floats);
    logger.info("Sorting completed. Final sorted steps: {}", sortedSteps);
    return sortedSteps;
  }

  /**
   * Sorts a list of floating-point numbers using the Shell Sort algorithm and returns the
   * intermediate steps of the sorting process.
   *
   * @param floats the list of floating-point numbers to be sorted
   * @return a list of lists representing the intermediate steps of the sorting process
   */
  ArrayList<ArrayList<Double>> shellSort(ArrayList<Double> floats) {
    logger.info("Starting shellSort method with input list: {}", floats);

    int n = floats.size();
    ArrayList<ArrayList<Double>> result = new ArrayList<>();

    // Start with a big gap, then reduce the gap
    for (int gap = n / 2; gap > 0; gap /= 2) {
      logger.debug("Current gap: {}", gap);

      for (int i = gap; i < n; i += 1) {
        Double temp = floats.get(i);
        int j;

        // Shift earlier gap-sorted elements up until the correct location for floats[i] is found
        for (j = i; j >= gap && floats.get(j - gap) > temp; j -= gap) {
          floats.set(j, floats.get(j - gap));
        }
        floats.set(j, temp);
      }

      logger.debug("List after gap {}: {}", gap, floats);
      result.add(new ArrayList<>(floats));
    }

    logger.info("Shell sort completed. Returning intermediate steps.");
    return result;
  }
}
