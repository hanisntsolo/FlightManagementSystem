package com.cg.flightmgmt.tests;

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
  }

  @org.junit.jupiter.api.Test
  void setFlightId() {
  }

  @org.junit.jupiter.api.Test
  void getCarrierName() {
  }

  @org.junit.jupiter.api.Test
  void setCarrierName() {
  }

  @org.junit.jupiter.api.Test
  void getFlightModel() {
  }

  @org.junit.jupiter.api.Test
  void setFlightModel() {
  }

  @org.junit.jupiter.api.Test
  void getSeatCapacity() {
  }

  @org.junit.jupiter.api.Test
  void setSeatCapacity() {
  }

  @org.junit.jupiter.api.Test
  void testEquals() {
  }

  @org.junit.jupiter.api.Test
  void testHashCode() {
  }

  @org.junit.jupiter.api.Test
  void testToString() {
  }

  @org.junit.jupiter.api.AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}