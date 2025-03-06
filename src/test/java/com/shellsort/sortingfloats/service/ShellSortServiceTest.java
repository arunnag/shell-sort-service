package com.shellsort.sortingfloats.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for ShellSortService
 */
@SpringBootTest
class ShellSortServiceTest {

    private final ShellSortService shellSortService = new ShellSortService();


    //generate tests for sorting a list of floats
    /**
     * Test for sorting a list of floats
     */
    @Test
    void testSort() {
        ArrayList<Float> unSortedFloats = new ArrayList<>(Arrays.asList(3.3f, 2.2f, 1.1f, -2f, 7.2f, -9.3f));
        ArrayList<Float> sortedFloats = new ArrayList<>(Arrays.asList(-9.3f, -2f, 1.1f, 2.2f, 3.3f, 7.2f));

        ArrayList<ArrayList<Float>> actualSortedFloats = shellSortService.sort(unSortedFloats);

        int size = actualSortedFloats.size();

        assertFalse(unSortedFloats.equals(actualSortedFloats.get(0)));
        assertTrue(sortedFloats.equals(actualSortedFloats.get(size-1)));
    }

    //generate test with doc string for array size of 20 floats
    /**
     * Test for sorting a list of 20 floats
     */
    @Test
    void testSortTwentyFloats() {
        ArrayList<Float> unSortedFloats = new ArrayList<>(Arrays.asList(3.3f, 2.2f, 1.1f, -2f, 7.2f, -9.3f, 0.0f, 5.5f, 4.4f, 6.6f, 8.8f, 9.9f, 10.1f, 11.2f, 12.3f, 13.4f, 14.5f, 15.6f, 16.7f, 17.8f));
        ArrayList<Float> sortedFloats = new ArrayList<>(Arrays.asList(-9.3f, -2f, 0.0f, 1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f, 7.2f, 8.8f, 9.9f, 10.1f, 11.2f, 12.3f, 13.4f, 14.5f, 15.6f, 16.7f, 17.8f));

        ArrayList<ArrayList<Float>> actualSortedFloats = shellSortService.sort(unSortedFloats);

        int size = actualSortedFloats.size();


        assertTrue(sortedFloats.equals(actualSortedFloats.get(size-1)));
        assertFalse(sortedFloats.equals(actualSortedFloats.get(0)));
    }
}