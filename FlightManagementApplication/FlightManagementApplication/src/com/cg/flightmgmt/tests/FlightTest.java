package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class FlightTest {

  @org.junit.jupiter.api.BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @org.junit.jupiter.api.Test
  void getFlightId() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setFlightId() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getCarrierName() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setCarrierName() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getFlightModel() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setFlightModel() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getSeatCapacity() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setSeatCapacity() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void testEquals() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void testHashCode() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}