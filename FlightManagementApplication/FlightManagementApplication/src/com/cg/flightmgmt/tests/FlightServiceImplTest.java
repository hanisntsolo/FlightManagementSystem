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
  private static Flight flight, flight1;
  private static List<Flight> listFlight;

  @BeforeEach
  void setUp() {
    flightRepo = new FlightRepositoryImpl();
    flight = new Flight(new BigInteger("112234"), "Indian Airlines", "INDIA554",455 );
    flight1 = new Flight(new BigInteger("112235"), "Amazon airlines", "INDIA554",455 );

  }

  @AfterEach
  void tearDown() {
    System.out.println("This will get executed after each test case.");
  }

  @Test
  void addFlight() throws Exception {
//    fail("This is yet to be implemented");
    assertEquals(flight, flightRepo.addFlight(flight));
//    assertEquals(flight1, flightRepo.addFlight(flight1));
  }

  @Test
  void viewFlight() throws Exception {
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
  void removeFlight() throws Exception {
//    fail("This is yet to be implemented");
    flightRepo.addFlight(flight1);
    assertEquals(flight1, flightRepo.removeFlight(BigInteger.valueOf(112235)));
  }


  @Test
  void updateFlight() throws FlightNotFoundException {
//    fail("This is yet to be implemented");
//    flight.setCarrierName("Amazon airlines");
    assertEquals("Amazon airlines", flightRepo.updateFlight(flight.getFlightId(), "Amazon airlines").getCarrierName());
  }
}