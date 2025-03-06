package com.shellsort.sortingfloats.controller;

import com.shellsort.sortingfloats.service.ShellSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for SortingFloatsController
 */
@WebMvcTest(SortingFloatsController.class)
class SortingFloatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShellSortService shellSortService;

    
    /**
     * Test for sorting a list of strings
     * @throws Exception if an error occurs during the request
     */
    @Test
    void testSortStringList() throws Exception {

        ArrayList<Float> unsortedFloats = new ArrayList<>(Arrays.asList(9.4f, 3.2f, 5.6f, 1.1f, 7.8f));
        ArrayList<Float> sortedFloats = new ArrayList<>(Arrays.asList(1.1f, 3.2f, 5.6f, 7.8f, 9.4f));

        ArrayList<ArrayList<Float>> actualSortedFloats = new ArrayList<>(Arrays.asList(unsortedFloats, sortedFloats));

        when(shellSortService.sort(unsortedFloats)).thenReturn(actualSortedFloats);        

        mockMvc.perform(post("/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"floats\":[\"this\", \"is\", \"a\",\"string\",\"list\"]}"))
                .andExpect(status().isBadRequest());
    }


    /**
     * Test for sorting a list of ten floats
     * @throws Exception if an error occurs during the request
     */
    @Test
    void testSortFiveFloats() throws Exception {
        ArrayList<Float> unsortedFloats = new ArrayList<>(Arrays.asList(9.4f, 3.2f, 5.6f, 1.1f, 7.8f));
        ArrayList<Float> sortedFloats = new ArrayList<>(Arrays.asList(1.1f, 3.2f, 5.6f, 7.8f, 9.4f));

        ArrayList<ArrayList<Float>> actualSortedFloats = new ArrayList<>(Arrays.asList(unsortedFloats, sortedFloats));

        when(shellSortService.sort(unsortedFloats)).thenReturn(actualSortedFloats);

        String inputJson = "{\"floats\":[9.4, 3.2, 5.6, 1.1, 7.8]}";
        String outputJson = "[[9.4, 3.2, 5.6, 1.1, 7.8],[1.1, 3.2, 5.6, 7.8, 9.4]]";

        //generte the mock mvc request
        mockMvc.perform(post("/sort")
            .contentType(MediaType.APPLICATION_JSON)
            .content(inputJson))
            .andExpect(status().isOk())
            .andExpect(content().json(outputJson));
    }
}