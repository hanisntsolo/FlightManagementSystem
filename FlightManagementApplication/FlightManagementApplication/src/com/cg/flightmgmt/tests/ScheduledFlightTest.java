package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduledFlightTest {
  private static ScheduledFlight scheduledFlight;
  private static ScheduledFlight object;
  private static Flight flight;
  private static Schedule schedule;
  private static Airport airportSource, airportDestination;
  private static LocalDateTime dateTimeArrival, dateTimeDeparture;
  private static LocalDate localDate;
  private static int count = 0;


  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
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
  void getFlight() {
    assertEquals(flight,scheduledFlight.getFlight());
  }

  @Test
  void setFlight() {
    scheduledFlight.setFlight(new Flight(BigInteger.valueOf(2354),"Boeing","Boeing 747 NJ",360));
    assertNotEquals(new Flight(BigInteger.valueOf(4934),"American Airlines","American 647 AJ",340),scheduledFlight.getFlight());
  }

  @Test
  void getAvailableSeats() {
    assertEquals(525,scheduledFlight.getAvailableSeats());
  }

  @Test
  void setAvailableSeats() {
    scheduledFlight.setAvailableSeats(200);
    assertEquals(200,scheduledFlight.getAvailableSeats());
  }

  @Test
  void getSchedule() {
    //assertEquals(new Schedule("Delhi Airport","Dubai International Airport", new LocalTime(03,30), LocalTime.of(22,30), LocalDate.of(2019,12,07)),scheduledFlight.getSchedule());
  }

  @Test
  void setSchedule() {
//    scheduledFlight.setSchedule(new Schedule("Delhi Airport","Dubai International Airport", new LocalTime(03,30), LocalTime.of(22,30), LocalDate.of(2019,12,07)));
//    assertNotEquals(new Schedule("Dubai Internatonal Airport","Delhi Airport", new LocalTime(03,30), LocalTime.of(22,30), LocalDate.of(2019,12,07)),scheduledFlight.getSchedule());
  }

  @Test
  void getFares() {
    assertEquals(2150.00,scheduledFlight.getFares());
  }

  @Test
  void setFares() {
    scheduledFlight.setFares(6499.0);
    assertNotEquals(5499.5,scheduledFlight.getFares());
  }

  @AfterAll
  public static void afterClass(){
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}

