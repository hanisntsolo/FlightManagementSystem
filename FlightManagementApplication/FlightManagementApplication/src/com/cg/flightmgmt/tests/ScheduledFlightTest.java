package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

class ScheduledFlightTest {
  private static ScheduledFlight scheduledFlight;
  private Object o;
  private Flight flight;
  private Schedule schedule;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
     /* scheduledFlight = new ScheduledFlight(new Flight(BigInteger.valueOf(2354),"Boeing","Boeing 747 NJ",360),150,
              new Schedule("Delhi Airport","Dubai International Airport", new LocalTime(03,30), LocalTime.of(22,30), LocalDate.of(2019,12,07)),5499.5);
      System.out.println("Running tests..........");*/
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
    assertEquals(scheduledFlight.equals(o),false);
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

