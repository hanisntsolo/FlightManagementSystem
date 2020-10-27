package com.cg.flightmgmt.tests;

import com.cg.flightmgmt.dto.Airport;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

class AirportTest {
  private static Airport airport;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }

  @BeforeEach
  void setUp() {
    airport = new Airport(155, "CCS Airport", "Pune");
    System.out.println("Running tests..........");
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @Test
  void getAirportId() {
    assertEquals(155, airport.getAirportId(),0);
  }

  @Test
  void setAirportId() {
    airport.setAirportId(200);
    assertEquals(200, airport.getAirportId());
  }

  @Test
  void getAirportName() {
    assertEquals("CCS Airport", airport.getAirportName());
  }

  @Test
  void setAirportName() {
    airport.setAirportName("Dubai International Airport");
    assertEquals("Dubai International Airport", airport.getAirportName());
  }

  @Test
  void getAirportLocation() {
    assertEquals("Pune",airport.getAirportLocation());
  }

  @Test
  void setAirportLocation() {
    airport.setAirportLocation("New York");
    assertEquals("New York", airport.getAirportLocation());
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