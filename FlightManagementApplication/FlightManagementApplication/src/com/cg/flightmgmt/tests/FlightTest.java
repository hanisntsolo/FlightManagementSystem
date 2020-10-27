package com.cg.flightmgmt.tests;

import com.cg.flightmgmt.dto.Flight;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
  private static Flight flight;
  private Object o;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
    flight = new Flight(new BigInteger("2354"),"Boeing","Boeing 747 NJ",300);
    System.out.println("Running tests..........");
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @Test
  void getFlightId() {
    assertEquals(BigInteger.valueOf(2354),flight.getFlightId());
  }

  @Test
  void setFlightId() {
    flight.setFlightId(BigInteger.valueOf(3976));
    assertEquals(BigInteger.valueOf(3976),flight.getFlightId());
  }

  @Test
  void getCarrierName() {
    assertNotEquals("Indigo",flight.getCarrierName());
  }

  @Test
  void setCarrierName() {
    flight.setCarrierName("Spice Jet");
    assertEquals("Spice Jet",flight.getCarrierName());
  }

  @Test
  void getFlightModel() {
    assertEquals("Boeing 747 NJ",flight.getFlightModel());
  }

  @Test
  void setFlightModel() {
    flight.setFlightModel("Boeing 465 NY");
    assertNotEquals("Boeing 349 NZ",flight.getFlightModel());
  }

  @Test
  void getSeatCapacity() {
    assertNotEquals(360,flight.getSeatCapacity());
  }

  @Test
  void setSeatCapacity() {
    flight.setSeatCapacity(350);
    assertEquals(350,flight.getSeatCapacity());
  }

  @Test
  void testEquals() {
    assertEquals(flight.equals(o),false);
  }

  @Test
  void testHashCode() {
    assertEquals(flight.hashCode(), Objects.hash(2354,"Boeing","Boeing 747 NJ",300));
  }

  @Test
  void testToString() {
    assertEquals(flight.toString(), "Flight{flightId=2354, carrierName='Boeing', flightModel='Boeing 747 NJ', seatCapacity=300}");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}