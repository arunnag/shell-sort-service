package com.shellsort.sortingfloats.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test class for FloatList
 */
@SpringBootTest
class FloatListTest {
    
    /**
     * Test for if two FloatsList with the same floats are equal
     */
    @Test
    void testEqualsListByHashCode() {
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(1.1f, 2.2f, 3.3f));
        FloatList floatList1 = new FloatList(floats);
        FloatList floatList2 = new FloatList(floats);
        assertTrue(floatList1.hashCode() == floatList2.hashCode());

        ArrayList<Float> floats2 = new ArrayList<>(Arrays.asList(1f, 2f, 3f));
        FloatList floatList3 = new FloatList(floats2);
        assertTrue(floatList1.hashCode() != floatList3.hashCode());
    }



    /**
     * Test for no argument constructor
     */
    @Test
    void testNoArgsConstructor() {
        FloatList floatList = new FloatList();
        assertNotNull(floatList);
    }

    /**
     * Test for toString method
     */
    @Test
    void testToString() {
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(1.1f, 2.2f, 3.3f));
        FloatList floatList = new FloatList(floats);
        assertEquals("FloatList(floats=[1.1, 2.2, 3.3])", floatList.toString());
    }

    /**
     * Test for equals method
     */
    @Test
    void testEquals() {
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(1.1f, 2.2f, 3.3f));
        FloatList floatList1 = new FloatList(floats);
        FloatList floatList2 = new FloatList(floats);
        assertTrue(floatList1.equals(floatList2));
    }


    /**
     * Test for all argument constructor
     */
    @Test
    void testAllArgsConstructor() {
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(1.1f, 2.2f, 3.3f));
        FloatList floatList = new FloatList(floats);
        assertEquals(floats, floatList.getFloats());
    }

    /**
     * Test for setFloats method
     */
    @Test
    void testSetFloats() {
        FloatList floatList = new FloatList();
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(4.4f, 5.5f, 6.6f));
        floatList.setFloats(floats);
        assertEquals(floats, floatList.getFloats());
    }

    /**
     * Test for getFloats method
     */
    @Test
    void testGetFloats() {
        ArrayList<Float> floats = new ArrayList<>(Arrays.asList(7.7f, 8.8f, 9.9f));
        FloatList floatList = new FloatList(floats);
        assertEquals(floats, floatList.getFloats());
    }
}