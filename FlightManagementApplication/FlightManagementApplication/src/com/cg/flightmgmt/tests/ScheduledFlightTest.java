package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduledFlightTest {

  @org.junit.jupiter.api.BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp() {
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    System.out.println("This will run after each test case is executed");
  }

  @org.junit.jupiter.api.Test
  void getFlight() {
  }

  @org.junit.jupiter.api.Test
  void setFlight() {
  }

  @org.junit.jupiter.api.Test
  void getAvailableSeats() {
  }

  @org.junit.jupiter.api.Test
  void setAvailableSeats() {
  }

  @org.junit.jupiter.api.Test
  void getSchedule() {
  }

  @org.junit.jupiter.api.Test
  void setSchedule() {
  }

  @org.junit.jupiter.api.Test
  void getFares() {
  }

  @org.junit.jupiter.api.Test
  void setFares() {
  }

  @org.junit.jupiter.api.Test
  void testEquals() {
  }

  @org.junit.jupiter.api.Test
  void testHashCode() {
  }

  @org.junit.jupiter.api.Test
  void testToString() {
  }

  @org.junit.jupiter.api.AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}