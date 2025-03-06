package com.shellsort.sortingfloats.dto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Test class for FloatList
 */
@SpringBootTest
class FloatListTest {
    
    /**
     * Test for no argument constructor
     */
    @Test
    void testNoArgsConstructor() {
        FloatList floatList = new FloatList();
        assertNotNull(floatList);
    }

    /**
     * Test for all argument constructor
     */
    @Test
    void testAllArgsConstructor() {
        List<Float> floats = Arrays.asList(1.1f, 2.2f, 3.3f);
        FloatList floatList = new FloatList(floats);
        assertEquals(floats, floatList.getFloats());
    }

    /**
     * Test for setFloats method
     */
    @Test
    void testSetFloats() {
        FloatList floatList = new FloatList();
        List<Float> floats = Arrays.asList(4.4f, 5.5f, 6.6f);
        floatList.setFloats(floats);
        assertEquals(floats, floatList.getFloats());
    }

    /**
     * Test for getFloats method
     */
    @Test
    void testGetFloats() {
        List<Float> floats = Arrays.asList(7.7f, 8.8f, 9.9f);
        FloatList floatList = new FloatList(floats);
        assertEquals(floats, floatList.getFloats());
    }
}