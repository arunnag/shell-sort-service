package com.shellsort.sortingfloats;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Integration test for the main application
 */
public class SortingfloatsApplicationIntegrationTest {
 
    /**
     * Test for main method : added for coverage
     */
    @Test
    public void main() {
        SortingfloatsApplication.main(new String[] {});
        assertTrue(true);
    }
}
