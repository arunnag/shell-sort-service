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

  @Test
  void main() {
    SortingfloatsApplication.main(new String[] {});
  }
}
