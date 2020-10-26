package com.cg.flightmgmt.tests;

import com.cg.flightmgmt.dto.Airport;
import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
  private static Airport airport;

  @org.junit.jupiter.api.BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    airport = new Airport(155, "CCS Airport", "Pune");
    System.out.println("Running tests..........");
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @org.junit.jupiter.api.Test
  void getAirportId() {
  }

  @org.junit.jupiter.api.Test
  void setAirportId() {
  }

  @org.junit.jupiter.api.Test
  void getAirportName() {
  }

  @org.junit.jupiter.api.Test
  void setAirportName() {
  }

  @org.junit.jupiter.api.Test
  void getAirportLocation() {
  }

  @org.junit.jupiter.api.Test
  void setAirportLocation() {
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