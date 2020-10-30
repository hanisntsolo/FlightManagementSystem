package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepositoryImpl;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Implement it after implementing EntityTESTS

class ScheduledFlightServiceImplTest {
  private static IScheduledFlightRepository scheduledFlightService;
  private static ScheduledFlight scheduledFlight;
  private static ScheduledFlight object;
  private static Flight flight;
  private static Schedule schedule;
  private static Airport airportSource, airportDestination;
  private static LocalDateTime dateTimeArrival, dateTimeDeparture;
  private static LocalDate localDate;
  private static int count = 0;

  @BeforeAll
  public static void beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
  scheduledFlightService = new ScheduledFlightRepositoryImpl();
    flight = new Flight(new BigInteger("2354"),"Boeing","Boeing 747 NJ",300);
    airportSource = new Airport(155, "CCS airport", "Lucknow");
    airportDestination = new Airport(189, "Chattrapati Sahuji Airport", "Mumbai");
    dateTimeArrival = LocalDateTime.of(2020, Month.OCTOBER,29,12,30);
    dateTimeDeparture = LocalDateTime.of(2020,Month.OCTOBER,30,9,15);
    localDate = LocalDate.of(2020,10,30);
    schedule = new Schedule(airportSource, airportDestination, dateTimeArrival, dateTimeDeparture, localDate);
    scheduledFlight = new ScheduledFlight(flight, 525, schedule, 2150.00D);
    System.out.println("Running a test..........");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
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
  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}