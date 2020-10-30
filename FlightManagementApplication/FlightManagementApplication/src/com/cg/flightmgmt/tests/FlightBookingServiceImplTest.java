package com.cg.flightmgmt.tests;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightBookingRepositoryImpl;
import com.cg.flightmgmt.repository.FlightRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.repository.IFlightRepository;
import com.cg.flightmgmt.service.FlightBookingServiceImpl;
import com.cg.flightmgmt.service.IFlightBookingService;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

class FlightBookingServiceImplTest {
  private static IFlightBookingRepository flightBookingService;
  private static LocalDate date;
  private static Booking booking, booking1, bookingTest;
  private static List<Passenger> passengers,passengersTest;
  private static Booking object;
  private static User userTest;
  private static LocalDate dateTest;
  private static Flight flightTest,flight;
  private static int count = 0;

  @BeforeAll
  static void beforeAll() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }

  @BeforeEach
  void setUp() {
    flightBookingService = new FlightBookingRepositoryImpl();
    passengers = new ArrayList<>();
    userTest = new User(new BigInteger("112233"));
    dateTest = LocalDate.of(2020,10,29);
    flightTest = new Flight(new BigInteger("112233"), "American Airlines", "MEG657", 1000);
    bookingTest = new Booking(new BigInteger("154"), userTest, dateTest, passengersTest, 200.00D, flightTest, 789);
    date = LocalDate.of(2020, 10, 26);
    flight = new Flight(new BigInteger("155"),"Indian Airlines", "BOEING755", 650 );
    booking = new Booking(new BigInteger("455488"), new User(new BigInteger("785598")),date, passengers, 1500.00D, flight, 487);
    booking1 = new Booking(new BigInteger("455489"), new User(new BigInteger("785598")),date, passengers, 1500.00D, flight, 487);

    System.out.println("Running tests.......");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  @Test
  void addBooking() throws FlightNotFoundException {
//    fail("This is yet to be implemented");
    assertEquals(bookingTest,flightBookingService.addBooking(bookingTest));
  }

  @Test
  void cancelBooking() throws BookingNotFoundException {
//    fail("This is yet to be implemented");
  flightBookingService.addBooking(booking);
  assertEquals(booking, flightBookingService.cancelBooking(BigInteger.valueOf(455488)));
  }

  @Test
  void viewBooking() throws BookingNotFoundException {
//    fail("This is yet to be implemented");
  assertEquals(booking, flightBookingService.viewBooking(BigInteger.valueOf(455488)));
  }

//Not implemented in the repo yet
  @Test
  void viewBookingList() {
    fail("This is yet to be implemented");
  }

  @Test
  void testViewBookingList() {
    fail("This is yet to be implemented");
  }

  @Test
  void viewBookingHistory() {
    fail("This is yet to be implemented");
  }

  @Test
  void updateBooking() {
    fail("This is yet to be implemented");
  }
  @AfterAll
  static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}