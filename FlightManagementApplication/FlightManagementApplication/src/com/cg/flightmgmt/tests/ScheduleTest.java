package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

class ScheduleTest {
  private static Schedule schedule;
  private static Airport airportSource, airportDestination;
  private static LocalDateTime dateTimeArrival, dateTimeDeparture;
  private static LocalDate localDate;
  private static Schedule o;
  private static int count = 0;


  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
    airportSource = new Airport(155, "CCS airport", "Lucknow");
    airportDestination = new Airport(189, "Chattrapati Sahuji Airport", "Mumbai");
    dateTimeArrival = LocalDateTime.of(2020, Month.OCTOBER,29,12,30);
    dateTimeDeparture = LocalDateTime.of(2020,Month.OCTOBER,30,9,15);
    localDate = LocalDate.of(2020,10,30);
    schedule = new Schedule(airportSource, airportDestination, dateTimeArrival, dateTimeDeparture, localDate);
    System.out.println("Running a test....................");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  @Test
  void getSourceAirport() {
//    fail("This test is yet to be written !");
    assertEquals(airportSource,schedule.getSourceAirport());
  }

  @Test
  void setSourceAirport() {
//    fail("This test is yet to be written !");
    airportSource = new Airport(155, "IndiraGandhi International Airport", "Delhi");
    schedule.setSourceAirport(airportSource);
    assertEquals(airportSource, schedule.getSourceAirport());
  }

  @Test
  void getDestinationAirport() {
//    fail("This test is yet to be written !");
    assertEquals(airportDestination, schedule.getDestinationAirport());
  }

  @Test
  void setDestinationAirport() {
//    fail("This test is yet to be written !");
    airportDestination = new Airport(226, "Leh Airport", "Leh");
    schedule.setDestinationAirport(airportDestination);
    assertEquals(airportDestination, schedule.getDestinationAirport());
  }

  @Test
  void getArrivalTime() {
//    fail("This test is yet to be written !");
    assertEquals(dateTimeArrival, schedule.getArrivalTime());
  }

  @Test
  void setArrivalTime() {
//    fail("This test is yet to be written !");
    dateTimeArrival = LocalDateTime.of(2020,Month.DECEMBER,12,5,30);
    schedule.setArrivalTime(dateTimeArrival);
    assertEquals(dateTimeArrival, schedule.getArrivalTime());
  }

  @Test
  void getDepartureTime() {
//    fail("This test is yet to be written !");
    assertEquals(dateTimeDeparture, schedule.getDepartureTime());
  }

  @Test
  void setDepartureTime() {
//    fail("This test is yet to be written !");
    dateTimeDeparture = LocalDateTime.of(2021,Month.APRIL,15,2,25);
    schedule.setDepartureTime(dateTimeDeparture);
    assertEquals(dateTimeDeparture, schedule.getDepartureTime());
  }

  @Test
  void testEquals() {
//    fail("This test is yet to be written !");
    assertEquals(schedule.equals(o), false);
  }

  /**
   * I will remove this test
   */
//  @Test
//  void testHashCode() {
////    fail("This test is yet to be written !");
//    assertEquals(schedule.hashCode(), Objects.hash(schedule));
//  }
//
//  /**
//   * I will remove this test
//   */
//  @Test
//  void testToString() {
//    fail("This test is yet to be written !");
////    assertEquals(schedule.toString(), "Schedule{" +
////        "sourceAirport=" + sourceAirport +
////        ", destinationAirport=" + destinationAirport +
////        ", arrivalTime=" + arrivalTime +
////        ", departureTime=" + departureTime +
////        '}');
//  }

  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}