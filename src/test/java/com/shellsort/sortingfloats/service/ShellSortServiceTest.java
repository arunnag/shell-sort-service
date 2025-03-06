package com.shellsort.sortingfloats.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class for ShellSortService
 */
class ShellSortServiceTest {

    private final ShellSortService shellSortService = new ShellSortService();

    /**
     * Test for sorting floats
     */
    @Test
    void testSortWithUnsortedList() {
        List<Float> unsortedList = Arrays.asList(3.4f, 1.2f, 5.6f, 2.3f, 4.5f);
        List<Float> sortedList = shellSortService.sort(unsortedList);
        List<Float> expectedList = Arrays.asList(1.2f, 2.3f, 3.4f, 4.5f, 5.6f);
        assertEquals(expectedList, sortedList);
    }

    /**
     * Test for sorting floats with sorted list
     */

    @Test
    void testSortWithSortedList() {
        List<Float> sortedList = Arrays.asList(1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
        List<Float> result = shellSortService.sort(sortedList);
        assertEquals(sortedList, result);
    }

    /**
     * Test for sorting floats with empty list
     */
    @Test
    void testSortWithEmptyList() {
        List<Float> emptyList = Arrays.asList();
        List<Float> result = shellSortService.sort(emptyList);
        assertEquals(emptyList, result);
    }

    /**
     * Test for sorting floats with single element list
     */
    @Test
    void testSortWithSingleElementList() {
        List<Float> singleElementList = Arrays.asList(1.0f);
        List<Float> result = shellSortService.sort(singleElementList);
        assertEquals(singleElementList, result);
    }

    /**
     * Test for sorting floats with duplicates
     */
    @Test
    void testSortWithDuplicates() {
        List<Float> listWithDuplicates = Arrays.asList(3.3f, 1.1f, 2.2f, 3.3f, 1.1f);
        List<Float> sortedList = shellSortService.sort(listWithDuplicates);
        List<Float> expectedList = Arrays.asList(1.1f, 1.1f, 2.2f, 3.3f, 3.3f);
        assertEquals(expectedList, sortedList);
    }
}