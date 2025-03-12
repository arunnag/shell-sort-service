package com.shellsort.sortingfloats.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Service class that provides sorting functionality using the Shell Sort algorithm.
 * This class is annotated with @Service, making it a Spring service component.
 * 
 * The primary method of this class is {@link #sort(ArrayList)}, which sorts a list of floating-point numbers.
 * The sorting process is implemented using the Shell Sort algorithm, which is detailed in the {@link #shellSort(ArrayList)} method.
 * 
 * The Shell Sort algorithm sorts elements that are far apart and progressively reduces the gap between elements to be compared,
 * allowing the algorithm to move elements closer to their final positions more quickly.
 * 
 * The {@link #shellSort(ArrayList)} method returns a list of lists, where each inner list represents the state of the
 * original list after each gap iteration, providing a step-by-step view of the sorting process.
 * 
 * Example usage:
 * <pre>
 * {@code
 * ShellSortService shellSortService = new ShellSortService();
 * ArrayList<Float> unsortedList = new ArrayList<>(Arrays.asList(3.4f, 1.2f, 5.6f, 2.1f));
 * ArrayList<ArrayList<Float>> sortedSteps = shellSortService.sort(unsortedList);
 * }
 * </pre>
 */
@Service
public class ShellSortService {
    /**
     * Sorts the list of floats using shell sort algorithm
     * @param unSortedFloats list of floats to be sorted
     * @return sorted list of floats
     */
    public ArrayList<ArrayList<Float>> sort(ArrayList<Float> unSortedFloats) {
        return shellSort(unSortedFloats);
    }
    
    /**
     * Sorts a list of floating-point numbers using the Shell Sort algorithm and returns
     * the intermediate steps of the sorting process.
     *
     * The Shell Sort algorithm works by initially sorting elements that are far apart
     * from each other and progressively reducing the gap between elements to be compared.
     * This allows the algorithm to move elements closer to their final positions more quickly.
     *
     * The process is as follows:
     * 1. Start with a large gap and reduce the gap by half in each iteration.
     * 2. For each gap, iterate through the list and compare elements that are 'gap' positions apart.
     * 3. If an element is greater than the element 'gap' positions ahead of it, swap them.
     * 4. Continue this process until the gap is reduced to 1, at which point the list should be sorted.
     *
     * The method returns a list of lists, where each inner list represents the state of the
     * original list after each gap iteration.
     *
     * @param floats the list of floating-point numbers to be sorted
     * @return a list of lists representing the intermediate steps of the sorting process
     */
    ArrayList<ArrayList<Float>> shellSort(ArrayList<Float> floats) {
        int n = floats.size();
        ArrayList<ArrayList<Float>> result = new ArrayList<ArrayList<Float>>();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                float temp = floats.get(i);
                int j;
                for (j = i; j >= gap && floats.get(j - gap) > temp; j -= gap) {
                    floats.set(j, floats.get(j - gap));
                }
                floats.set(j, temp);
            }


            result.add(new ArrayList<>(floats));
        }

        return result;
    }
}
