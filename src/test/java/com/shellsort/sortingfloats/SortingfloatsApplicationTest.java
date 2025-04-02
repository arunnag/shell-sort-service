package com.shellsort.sortingfloats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/** Test class for SortingfloatsApplication */
@SpringBootTest
class SortingfloatsApplicationTest {

  /** Test for context loads */
  @Test
  void contextLoads() {
    assertTrue(true);
  }

  /**
   * Tests the main method of the SortingfloatsApplication class. This test ensures that the
   * application starts up without any issues.
   */
  @Test
  void main() {
    SortingfloatsApplication.main(new String[] {});
    assertTrue(true);
  }
}
