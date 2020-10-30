package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.User;
import java.math.BigInteger;
import java.sql.PseudoColumnUsage;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingTest {
  private static Booking bookingTest;
  private static Booking object;
  private static List<Passenger> passengersTest;
  private static User userTest;
  private static LocalDate dateTest;
  private static Flight flightTest;
  private static int count = 0;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
    passengersTest.add(new Passenger(new BigInteger("521125"),"Dhirendra", 23, new BigInteger("1844"), 15.65D));
    userTest = new User(new BigInteger("112233"));
    dateTest = LocalDate.of(2020,10,29);
    flightTest = new Flight(new BigInteger("112233"), "American Airlines", "MEG657", 1000);
    bookingTest = new Booking(new BigInteger("154"), userTest, dateTest, passengersTest, 200.00D, flightTest, 789);
    System.out.println("Running Tests................");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  @Test
  void getBookingId() {
//    fail("This test has to be implemented yet");
    assertEquals(BigInteger.valueOf(154), bookingTest.getBookingId());
  }

  @Test
  void setBookingId() {
//    fail("This test has to be implemented yet");
    bookingTest.setBookingId(BigInteger.valueOf(144));
    assertEquals(BigInteger.valueOf(144), bookingTest.getBookingId());
  }


  @Test
  void getUserId() {
//    fail("This test has to be implemented yet");
    assertEquals(userTest, bookingTest.getUserId());
  }

  @Test
  void setUserId() {
//    fail("This test has to be implemented yet");
    userTest.setUserId(new BigInteger("54321"));
    bookingTest.setUserId(userTest);
    assertEquals(userTest, bookingTest.getUserId());
  }


  @Test
  void getBookingDate() {
//    fail("This test has to be implemented yet");
  assertEquals(dateTest, bookingTest.getBookingDate());

  }

  @Test
  void setBookingDate() {
//    fail("This test has to be implemented yet");
    dateTest = LocalDate.of(2020,12,3);
    bookingTest.setBookingDate(dateTest);
    assertEquals(dateTest, bookingTest.getBookingDate());
  }

  @Test
  void getPassengerList() {
    fail("This test has to be implemented yet");
  }

  @Test
  void setPassengerList() {
    fail("This test has to be implemented yet");
  }

  @Test
  void getTicketCost() {
//    fail("This test has to be implemented yet");
    assertEquals(200.00D, bookingTest.getTicketCost());
  }

  @Test
  void setTicketCost() {
//    fail("This test has to be implemented yet");
    bookingTest.setTicketCost(120.00D);
    assertEquals(120.00D, bookingTest.getTicketCost());
  }

  @Test
  void getFlight() {
//    fail("This test has to be implemented yet");
    assertEquals(flightTest, bookingTest.getFlight());
  }

  @Test
  void setFlight() {
//    fail("This test has to be implemented yet");
    bookingTest.setFlight(flightTest);
    assertEquals(flightTest, bookingTest.getFlight());
  }

  @Test
  void getNoOfPassengers() {
//    fail("This test has to be implemented yet");
    assertEquals(789, bookingTest.getNoOfPassengers());
  }

  @Test
  void setNoOfPassengers() {
//    fail("This test has to be implemented yet");
    bookingTest.setNoOfPassengers(225);
    assertEquals(225, bookingTest.getNoOfPassengers());
  }

  @Test
  void testEquals() {
//    fail("This test has to be implemented yet");
    assertEquals(bookingTest.equals(object), false);
  }

//?????? over here......... Thinking to remove
  @Test
  void testHashCode() {
//    fail("This test has to be implemented yet");
    assertNotEquals(bookingTest.hashCode(), Objects.hash(bookingTest));
  }

  @Test
  void testToString() {
    fail("This test has to be implemented yet");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}