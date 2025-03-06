package com.shellsort.sortingfloats.controller;

import com.shellsort.sortingfloats.service.ShellSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//doc string for the class and all test functions
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
     * Test for sorting floats
     * @throws Exception
     */
    @Test
    void sortFloats() throws Exception {
        List<Float> input = Arrays.asList(3.2f, 1.5f, 4.8f);
        List<Float> sorted = Arrays.asList(1.5f, 3.2f, 4.8f);

        when(shellSortService.sort(input)).thenReturn(sorted);

        mockMvc.perform(post("/sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[3.2, 1.5, 4.8]"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1.5, 3.2, 4.8]"));
    }

    /**
     * Test for sorting floats with empty list
     * @throws Exception
     */

    @Test
    void sortFloatsWithEmptyList() throws Exception {
        List<Float> input = Arrays.asList();
        List<Float> sorted = Arrays.asList();

        when(shellSortService.sort(input)).thenReturn(sorted);

        mockMvc.perform(post("/sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[]"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    /**
     * Test for sorting floats with single element
     * @throws Exception
     */

    @Test
    void sortFloatsWithSingleElement() throws Exception {
        List<Float> input = Arrays.asList(1.0f);
        List<Float> sorted = Arrays.asList(1.0f);

        when(shellSortService.sort(input)).thenReturn(sorted);

        mockMvc.perform(post("/sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[1.0]"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1.0]"));
    }

    /**
     * Test for sorting floats with duplicates
     * @throws Exception
     */    
    @Test
    void sortFloatsWithDuplicates() throws Exception {
        List<Float> input = Arrays.asList(3.3f, 1.1f, 2.2f, 3.3f, 1.1f);
        List<Float> sorted = Arrays.asList(1.1f, 1.1f, 2.2f, 3.3f, 3.3f);

        when(shellSortService.sort(input)).thenReturn(sorted);

        mockMvc.perform(post("/sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[3.3, 1.1, 2.2, 3.3, 1.1]"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1.1, 1.1, 2.2, 3.3, 3.3]"));
    }
}