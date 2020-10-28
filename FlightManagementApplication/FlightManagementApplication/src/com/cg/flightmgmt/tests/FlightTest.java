package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightTest {

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @Test
  void getFlightId() {
    fail("This test is yet to be written !");
  }

  @Test
  void setFlightId() {
    fail("This test is yet to be written !");
  }

  @Test
  void getCarrierName() {
    fail("This test is yet to be written !");
  }

  @Test
  void setCarrierName() {
    fail("This test is yet to be written !");
  }

  @Test
  void getFlightModel() {
    fail("This test is yet to be written !");
  }

  @Test
  void setFlightModel() {
    fail("This test is yet to be written !");
  }

  @Test
  void getSeatCapacity() {
    fail("This test is yet to be written !");
  }

  @Test
  void setSeatCapacity() {
    fail("This test is yet to be written !");
  }

  @Test
  void testEquals() {
    fail("This test is yet to be written !");
  }

  @Test
  void testHashCode() {
    fail("This test is yet to be written !");
  }

  @Test
  void testToString() {
    fail("This test is yet to be written !");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}