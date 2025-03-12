package com.shellsort.sortingfloats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shellsort.sortingfloats.dto.FloatList;
import com.shellsort.sortingfloats.service.ShellSortService;

import java.util.ArrayList;

import javax.validation.Valid;


/**
 * Controller for sorting a list of floats using the Shell Sort algorithm.
 * This controller provides an endpoint to sort the list of floats.
 * 
 * <p>
 * The controller uses {@link ShellSortService} to perform the sorting.
 * </p>
 * 
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * POST /sort
 * Request Body: {
 *   "floats": [3.4, 1.2, 5.6, 2.1, -2.7, 1.95, 4, 30, -30]
 * }
 * Response Body: [
 * [-30, 1.2, 4, 2.1, -2.7, 1.95, 5.6, 30, 3.4],
 * [-30, 1.2, -2.7, 1.95, 3.4, 2.1, 4, 30, 5.6],
 * [-30, -2.7, 1.2, 1.95, 2.1, 3.4, 4, 5.6, 30]
 * ]
 * }
 * </pre>
 * </p>
 * 
 * @see ShellSortService
 */

@RestController
public class SortingFloatsController {

    /**
     * Service for shell sort
     */
    @Autowired
    private ShellSortService shellSortService;


    /**
     * Endpoint to sort a list of floating-point numbers using the Shell Sort algorithm.
     *
     * @param floats the list of floating-point numbers to be sorted, wrapped in a FloatList object.
     * @return a sorted list of floating-point numbers, wrapped in an ArrayList of ArrayLists of Floats.
     */
    @PostMapping("/sort")
    public ArrayList<ArrayList<Float>> sortFloats(@Valid @RequestBody FloatList floats) {
        return shellSortService.sort(floats.getFloats());
    }
}
