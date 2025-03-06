package com.shellsort.sortingfloats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shellsort.sortingfloats.dto.FloatList;
import com.shellsort.sortingfloats.service.ShellSortService;


import java.util.List;

import javax.validation.Valid;


/**
 * Controller class for sorting floats
 */
@RestController
public class SortingFloatsController {

    /**
     * Service for shell sort
     */
    @Autowired
    private ShellSortService shellSortService;

    /**
     * Sorts the list of floats using shell sort algorithm
     * @param floats list of floats to be sorted
     * @return sorted list of floats
     */
    

    @PostMapping("/sort")
    public List<Float> sortFloats(@Valid @RequestBody FloatList floats) {
        return shellSortService.sort(floats.getFloats());
    }
}
