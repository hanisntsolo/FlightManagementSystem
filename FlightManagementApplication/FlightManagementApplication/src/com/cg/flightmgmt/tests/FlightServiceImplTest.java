package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightRepository;
import com.cg.flightmgmt.service.FlightServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightServiceImplTest {
  private static IFlightRepository flightRepo;
  private static Flight flight, flight1;
  private static List<Flight> listFlight;
  private static int count = 0;

  @BeforeAll
  public static void beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);

  }
  @BeforeEach
  void setUp() {
    flightRepo = new FlightRepositoryImpl();
    flight = new Flight(new BigInteger("112234"), "Indian Airlines", "INDIA554",455 );
    flight1 = new Flight(new BigInteger("112235"), "Amazon airlines", "INDIA554",455 );

  }

  @AfterEach
  void tearDown() throws FlightNotFoundException {
//    flightRepo.removeFlight(flight.getFlightId());
//    flightRepo.removeFlight(flight1.getFlightId());
    System.out.println("Test case "+ count++ +" executed successfully ");
  }
  /**
   * Functionality number one
   * adding flight
   * @throws Exception
   */
  @Test
  void addFlight() throws Exception {
//    fail("This is yet to be implemented");
    assertEquals(flight, flightRepo.addFlight(flight));
//    assertEquals(flight1, flightRepo.addFlight(flight1));
    flightRepo.removeFlight(flight.getFlightId());
  }
  @Test
  void addNotFlight() throws Exception {
    assertNotEquals(flight, flightRepo.addFlight(flight1));
    flightRepo.removeFlight(flight1.getFlightId());
  }
  @Test
  void notAddFlight() {
    assertThrows(IllegalArgumentException.class, ()->{
      flight = null;
      assertEquals(null, flightRepo.addFlight(null));
    });
  }
  /**
   * Functionality number one
   * viewing flight
   * @throws Exception
   */
  @Test
  void viewFlight() throws Exception {
//    fail("This is yet to be implemented");
    flightRepo.addFlight(flight);
    assertEquals(flight.getFlightId(), flightRepo.viewFlight(BigInteger.valueOf(112234)).getFlightId());
    flightRepo.removeFlight(flight.getFlightId());
  }
  @Test
  void viewNotFlight() throws Exception {
    flightRepo.addFlight(flight);
    flightRepo.addFlight(flight1);
//    assertNotEquals(flight1.getFlightId(), flightRepo.viewFlight(flight.).getFlightId());
    assertNotEquals(flight1.getFlightId(), flightRepo.viewFlight(BigInteger.valueOf(112234)).getFlightId());
    flightRepo.removeFlight(flight.getFlightId());
    flightRepo.removeFlight(flight1.getFlightId());
  }
  @Test
  void notViewFlight() {
    assertThrows(FlightNotFoundException.class, ()->{
      flightRepo.removeFlight(flight.getFlightId());
      flightRepo.viewFlight(flight.getFlightId());
    });
  }
  /**
   * Functionality number one
   * viewing all flight
   * @throws Exception
   */
  @Test
  void viewAllFlights() {
    fail("This is yet to be implemented");
//    assertEquals(listFlight, flightRepo.viewAllFlights());
  }
//  @Test
//  @Test
  /**
   * Functionality number one
   * removing flight
   * @throws Exception
   */
  @Test
  void removeFlight() throws Exception {
//    fail("This is yet to be implemented");
    flightRepo.addFlight(flight1);
    assertEquals(flight1, flightRepo.removeFlight(flight1.getFlightId()));
  }
  @Test
  void removeNotFlight() throws Exception {
    flightRepo.addFlight(flight);
    flightRepo.addFlight(flight1);
    assertNotEquals(flight, flightRepo.removeFlight(flight1.getFlightId()));
  }
  @Test
  void notRemoveFlight() {
    assertThrows(FlightNotFoundException.class, ()->{
      flightRepo.removeFlight(flight1.getFlightId());
    });
  }
  /**
   * Functionality number one
   * updating flight
   * @throws FlightNotFoundException
   */
  @Test
  void updateFlight() throws FlightNotFoundException {
//    fail("This is yet to be implemented");
//    flight.setCarrierName("Amazon airlines");
    assertEquals("Amazon airlines", flightRepo.updateFlight(flight.getFlightId(), "Amazon airlines").getCarrierName());
  }
  @Test
  void updateNotFlight() throws Exception {
    flightRepo.addFlight(flight);
    assertNotEquals("Indian airlines", flightRepo.updateFlight(flight.getFlightId(), "Amazon airlines").getCarrierName());
  }
  @Test
  void notUpdateFlight() {
    assertThrows(FlightNotFoundException.class, ()->{
      flightRepo.removeFlight(flight.getFlightId());
      flightRepo.updateFlight(flight.getFlightId(), "Amazon Airlines");
    });
  }
  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);

  }
}