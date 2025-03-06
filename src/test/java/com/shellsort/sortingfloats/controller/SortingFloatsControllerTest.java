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

    // public String jsonString(List<Float> floats) throws JSONException {
    //     JSONObject jsonObject = new JSONObject();
    //     jsonObject.put("floats", floats);
    //     return jsonObject.toString();
    // }

    
    // generate test for list of string should return bad request with docstring
    /**
     * Test for sorting a list of strings
     * @throws Exception if an error occurs during the request
     */
    @Test
    void testSortStringList() throws Exception {
        List<Float> unsortedFloats = Arrays.asList(1.1f, 2.2f, 3.3f);
        List<Float> sortedFloats = Arrays.asList(1.1f, 2.2f, 3.3f);

        when(shellSortService.sort(unsortedFloats)).thenReturn(sortedFloats);

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
    void testSortTenFloats() throws Exception {
        List<Float> unsortedFloats = Arrays.asList(9.4f, 3.2f, 5.6f, 1.1f, 7.8f, 2.3f, 6.5f, 4.4f, 8.9f, 0.5f);
        List<Float> sortedFloats = Arrays.asList(0.5f, 1.1f, 2.3f, 3.2f, 4.4f, 5.6f, 6.5f, 7.8f, 8.9f, 9.4f);

        when(shellSortService.sort(unsortedFloats)).thenReturn(sortedFloats);

        mockMvc.perform(post("/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"floats\":[9.4, 3.2, 5.6, 1.1, 7.8, 2.3, 6.5, 4.4, 8.9, 0.5]}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[0.5, 1.1, 2.3, 3.2, 4.4, 5.6, 6.5, 7.8, 8.9, 9.4]"));
    }


    /**
     * Test for sorting an empty list of floats
     * @throws Exception if an error occurs during the request
     */
    @Test
    void testSortEmptyList() throws Exception {
        List<Float> emptyList = Arrays.asList();

        when(shellSortService.sort(emptyList)).thenReturn(emptyList);

        mockMvc.perform(post("/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"floats\":[]}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    /**
     * Test for sorting a list of floats with a single element
     * @throws Exception if an error occurs during the request
     */
    @Test
    void testSortSingleElementList() throws Exception {
        List<Float> singleElementList = Arrays.asList(1.2f);

        when(shellSortService.sort(singleElementList)).thenReturn(singleElementList);

        mockMvc.perform(post("/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"floats\":[1.2]}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[1.2]"));
    }


    
}