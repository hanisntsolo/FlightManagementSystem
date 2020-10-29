package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Implement it after implementing EntityTESTS

class ScheduledFlightServiceImplTest {
  private static IScheduledFlightRepository scheduledFlightService;
  private static ScheduledFlight scheduledFlight;

  @BeforeEach
  void setUp() {
  scheduledFlightService = new ScheduledFlightRepositoryImpl();
  scheduledFlight = new ScheduledFlight();
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will execute after each test gets executed.");
  }

  @Test
  void addFlightSchedule() {
    fail("This is yet to be implemented");
  }

  @Test
  void viewFlightSchedule() {
    fail("This is yet to be implemented");
  }

  @Test
  void removeFlightSchedule() {
    fail("This is yet to be implemented");
  }

  @Test
  void updateFlightSchedule() {
    fail("This is yet to be implemented");
  }

  @Test
  void viewAllScheduledFlights() {
    fail("This is yet to be implemented");
  }

  @Test
  void testViewAllScheduledFlights() {
    fail("This is yet to be implemented");
  }

  @Test
  void testViewAllScheduledFlights1() {
    fail("This is yet to be implemented");
  }
}