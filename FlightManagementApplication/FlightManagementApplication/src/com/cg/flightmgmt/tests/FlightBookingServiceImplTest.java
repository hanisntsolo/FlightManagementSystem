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
  private static Flight flight;
  private static Booking booking, booking1;
  private static List<Passenger> passengers;
  @BeforeAll
  static void beforeAll() {
    System.out.println("This will run before any of the test cases gets executed");
  }

  @BeforeEach
  void setUp() {
    flightBookingService = new FlightBookingRepositoryImpl();
    passengers = new ArrayList<>();
    date = LocalDate.of(2020, 10, 26);
    flight = new Flight(new BigInteger("155"),"Indian Airlines", "BOEING755", 650 );
    booking = new Booking(new BigInteger("455488"), new User(new BigInteger("785598")),date, passengers, 1500.00D, flight, 487);
    booking1 = new Booking(new BigInteger("455488"), new User(new BigInteger("785598")),date, passengers, 1500.00D, flight, 487);

    System.out.println("Running tests.......");
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed.");
  }

  @Test
  void addBooking() throws FlightNotFoundException {
//    This test case is yet to be implemented........
//    fail("This is yet to be implemented");
    assertEquals(booking1,flightBookingService.addBooking(booking));
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
    System.out.println("This will execute after all test cases.");
  }
}