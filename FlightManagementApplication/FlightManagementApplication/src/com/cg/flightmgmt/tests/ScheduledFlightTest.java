package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduledFlightTest {

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @Test
  void getFlight() {
    fail("This test is yet to be written !");
  }

  @Test
  void setFlight() {
    fail("This test is yet to be written !");
  }

  @Test
  void getAvailableSeats() {
    fail("This test is yet to be written !");
  }

  @Test
  void setAvailableSeats() {
    fail("This test is yet to be written !");
  }

  @Test
  void getSchedule() {
    fail("This test is yet to be written !");
  }

  @Test
  void setSchedule() {
    fail("This test is yet to be written !");
  }

  @Test
  void getFares() {
    fail("This test is yet to be written !");
  }

  @Test
  void setFares() {
    fail("This test is yet to be written !");
  }

  @Test
  void testEquals() {
    fail("This test is yet to be written !");
  }

  @Test
  void testHashCode() {
    fail("This test is yet to be written !");
  }

  @Test
  void testToString() {
    fail("This test is yet to be written !");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}