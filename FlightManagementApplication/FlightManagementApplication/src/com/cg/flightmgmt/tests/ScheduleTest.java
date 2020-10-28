package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

class ScheduleTest {

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
  void getSourceAirport() {
    fail("This test is yet to be written !");
  }

  @Test
  void setSourceAirport() {
    fail("This test is yet to be written !");
  }

  @Test
  void getDestinationAirport() {
    fail("This test is yet to be written !");
  }

  @Test
  void setDestinationAirport() {
    fail("This test is yet to be written !");
  }

  @Test
  void getArrivalTime() {
    fail("This test is yet to be written !");
  }

  @Test
  void setArrivalTime() {
    fail("This test is yet to be written !");
  }

  @Test
  void getDepartureTime() {
    fail("This test is yet to be written !");
  }

  @Test
  void setDepartureTime() {
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