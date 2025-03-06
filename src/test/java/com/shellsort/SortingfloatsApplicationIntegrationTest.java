package com.shellsort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.shellsort.sortingfloats.SortingfloatsApplication;

public class SortingfloatsApplicationIntegrationTest {
 
    @Test
    public void main() {
        SortingfloatsApplication.main(new String[] {});
        assertTrue(true);
    }
}
