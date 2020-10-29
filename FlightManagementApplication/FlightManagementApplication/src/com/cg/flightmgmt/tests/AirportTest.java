package com.cg.flightmgmt.tests;

import com.cg.flightmgmt.dto.Airport;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
  private static Airport airport;
  private static Airport o;

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
    assertNotEquals("Pune Airport", airport.getAirportName());
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
  assertNotEquals("Las Vegas", airport.getAirportLocation());
  }

  @Test
  void testEquals() {
    assertEquals(airport.equals(o),false);  }

  @Test
  void testHashCode() {
    assertEquals(airport.hashCode(), Objects.hash(155, "CCS Airport", "Pune"));
  }

  @Test
  void testToString() {
    assertEquals(airport.toString(),"Airport{airportId=155, airportName='CCS Airport', airportLocation='Pune'}");
      }

  @AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}