package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightRepository;
import com.cg.flightmgmt.service.FlightServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightServiceImplTest {
  private static IFlightRepository flightRepo;
  private static Flight flight;
  private static List<Flight> listFlight;

  @BeforeEach
  void setUp() {
    flightRepo = new FlightRepositoryImpl();
    flight = new Flight(new BigInteger("112234"), "Indian Airlines", "INDIA554",455 );
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will get executed after each test case.");
  }

  @Test
  void addFlight() {
//    fail("This is yet to be implemented");
    assertEquals(flight, flightRepo.addFlight(flight));
  }

  @Test
  void viewFlight() throws FlightNotFoundException {
//    fail("This is yet to be implemented");
    flightRepo.addFlight(flight);
    assertEquals(flight.getFlightId(), flightRepo.viewFlight(BigInteger.valueOf(112234)).getFlightId());
  }


  @Test
  void viewAllFlights() {
    fail("This is yet to be implemented");
//    assertEquals(listFlight, flightRepo.viewAllFlights());
  }


  @Test
  void removeFlight() throws FlightNotFoundException{
//    fail("This is yet to be implemented");
    assertEquals(flight, flightRepo.removeFlight(BigInteger.valueOf(112234)));
  }


  @Test
  void updateFlight() {
//    fail("This is yet to be implemented");
    assertEquals(flight, flightRepo.updateFlight(flight));
  }
}