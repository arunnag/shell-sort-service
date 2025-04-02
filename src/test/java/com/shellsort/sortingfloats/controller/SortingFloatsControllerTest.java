package com.shellsort.sortingfloats.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shellsort.sortingfloats.service.ShellSortService;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/** Test class for SortingFloatsController */
class SortingFloatsControllerTest {

  private MockMvc mockMvc;

  @Mock private ShellSortService shellSortService;

  @InjectMocks private SortingFloatsController sortingFloatsController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(sortingFloatsController).build();
  }

  /**
   * Test for sorting a list of ten floats
   *
   * @throws Exception if an error occurs during the request
   */
  @Test
  void testSortFiveFloats() throws Exception {
    ArrayList<Double> unsortedFloats = new ArrayList<>(Arrays.asList(9.4, 3.2, 5.6, 1.1, 7.8));
    ArrayList<Double> sortedFloats = new ArrayList<>(Arrays.asList(1.1, 3.2, 5.6, 7.8, 9.4));

    ArrayList<ArrayList<Double>> actualSortedFloats =
        new ArrayList<>(Arrays.asList(unsortedFloats, sortedFloats));

    // mock the shellSortService to return the expected sorted floats
    when(shellSortService.sort(unsortedFloats)).thenReturn(actualSortedFloats);

    String inputJson = "[9.4, 3.2, 5.6, 1.1, 7.8]";
    String outputJson = "[[9.4, 3.2, 5.6, 1.1, 7.8],[1.1, 3.2, 5.6, 7.8, 9.4]]";

    // generte the mock mvc request
    mockMvc
        .perform(post("/api/v1/sort").contentType(MediaType.APPLICATION_JSON).content(inputJson))
        .andExpect(status().isOk())
        .andExpect(content().json(outputJson));
  }

  /**
   * Test for Empty body which should result in bad request
   *
   * @throws Exception if an error occurs during the request
   */
  @Test
  void testEmptyBody() throws Exception {
    // for empty input the controller should return a 400 Bad Request status
    mockMvc
        .perform(post("/api/v1/sort").contentType(MediaType.APPLICATION_JSON).content("[]"))
        .andExpect(status().isBadRequest());
  }

  /**
   * Test for null body which should result in bad request
   *
   * @throws Exception if an error occurs during the request
   */
  @Test
  void testNullBody() throws Exception {
    // for null input the controller should return a 400 Bad Request status
    mockMvc
        .perform(post("/api/v1/sort").contentType(MediaType.APPLICATION_JSON).content("null"))
        .andExpect(status().isBadRequest());
  }

  /**
   * Test for sorting a list with postive and negative floats
   *
   * @throws Exception if an error occurs during the request
   */
  @Test
  void testSortMixOfloats() throws Exception {
    ArrayList<Double> unsortedFloats = new ArrayList<>(Arrays.asList(-9.4, 3.2, -5.6, 1.1, 7.8));
    ArrayList<Double> sortedFloats = new ArrayList<>(Arrays.asList(-9.4, -5.6, 1.1, 3.2, 7.8));

    ArrayList<ArrayList<Double>> actualSortedFloats =
        new ArrayList<>(Arrays.asList(unsortedFloats, sortedFloats));

    //
    when(shellSortService.sort(unsortedFloats)).thenReturn(actualSortedFloats);

    String inputJson = "[-9.4, 3.2, -5.6, 1.1, 7.8]";
    String outputJson = "[[-9.4, 3.2, -5.6, 1.1, 7.8],[-9.4, -5.6, 1.1, 3.2, 7.8]]";

    // generate the mock mvc request and check the response
    mockMvc
        .perform(post("/api/v1/sort").contentType(MediaType.APPLICATION_JSON).content(inputJson))
        .andExpect(status().isOk())
        .andExpect(content().json(outputJson));
  }
}
