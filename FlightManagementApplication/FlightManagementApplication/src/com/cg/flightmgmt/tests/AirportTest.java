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
    assertEquals(155, airport.getAirportId(),0);
  }

  @org.junit.jupiter.api.Test
  void setAirportId() {
    airport.setAirportId(200);
    assertEquals(200, airport.getAirportId());
  }

  @org.junit.jupiter.api.Test
  void getAirportName() {
    assertEquals("CCS Airport", airport.getAirportName());
  }

  @org.junit.jupiter.api.Test
  void setAirportName() {
    airport.setAirportName("Dubai International Airport");
    assertEquals("Dubai International Airport", airport.getAirportName());
  }

  @org.junit.jupiter.api.Test
  void getAirportLocation() {
    assertEquals("Pune",airport.getAirportLocation());
  }

  @org.junit.jupiter.api.Test
  void setAirportLocation() {
  airport.setAirportLocation("New York");
  assertEquals("New York", airport.getAirportLocation());
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