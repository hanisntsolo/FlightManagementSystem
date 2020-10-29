package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import java.time.Month;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

class ScheduledFlightTest {
  private static ScheduledFlight scheduledFlight;
  private static ScheduledFlight object;
  private static Flight flight;
  private static Schedule schedule;
  private static Airport airportSource, airportDestination;
  private static LocalDateTime dateTimeArrival, dateTimeDeparture;
  private static LocalDate localDate;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
//    flight = new Flight(new BigInteger("2354"),"Boeing","Boeing 747 NJ",300);
//    airportSource = new Airport(155, "CCS airport", "Lucknow");
//    airportDestination = new Airport(189, "Chattrapati Sahuji Airport", "Mumbai");
//    dateTimeArrival = LocalDateTime.of(2020, Month.OCTOBER,29,12,30);
//    dateTimeDeparture = LocalDateTime.of(2020,Month.OCTOBER,30,9,15);
//    localDate = LocalDate.of(2020,10,30);
//    schedule = new Schedule(airportSource, airportDestination, dateTimeArrival, dateTimeDeparture, localDate);
//     scheduledFlight = new ScheduledFlight();
      System.out.println("Running tests..........");
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @Test
  void getFlight() {
    assertEquals(new Flight(BigInteger.valueOf(2354),"Boeing","Boeing 747 NJ",360),scheduledFlight.getFlight());
  }

  @Test
  void setFlight() {
    scheduledFlight.setFlight(new Flight(BigInteger.valueOf(2354),"Boeing","Boeing 747 NJ",360));
    assertNotEquals(new Flight(BigInteger.valueOf(4934),"American Airlines","American 647 AJ",340),scheduledFlight.getFlight());
  }

  @Test
  void getAvailableSeats() {
    assertEquals(150,scheduledFlight.getAvailableSeats());
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
    assertEquals(5499.5,scheduledFlight.getFares());
  }

  @Test
  void setFares() {
    scheduledFlight.setFares(6499.0);
    assertNotEquals(5499.5,scheduledFlight.getFares());
  }

  @Test
  void testEquals() {
    assertEquals(scheduledFlight.equals(object),false);
  }

  @Test
  void testHashCode() {
//    assertEquals(scheduledFlight.hashCode(), Objects.hash((new Flight(BigInteger.valueOf(2354),"Boeing","Boeing 747 NJ",360)),150,
//            new Schedule("Delhi Airport","Dubai International Airport", new LocalTime(03,30), LocalTime.of(22,30), LocalDate.of(2019,12,07)),5499.5));
  }

  @Test
  void testToString() {
    assertEquals(scheduledFlight.toString(), "ScheduledFlight{flight=(2354,'Boeing','Boeing 747 NJ',360), availableSeats=150, schedule=('Delhi Airport','Dubai International Airport','03:30','22:30'), fares=5499.5}");
  }
  @AfterAll
  public static void afterClass(){
    System.out.println ("This will execute after all test cases!");
  }
}

