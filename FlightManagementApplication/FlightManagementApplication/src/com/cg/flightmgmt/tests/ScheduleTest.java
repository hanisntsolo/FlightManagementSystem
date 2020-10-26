package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {

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
  void getSourceAirport() {
  }

  @org.junit.jupiter.api.Test
  void setSourceAirport() {
  }

  @org.junit.jupiter.api.Test
  void getDestinationAirport() {
  }

  @org.junit.jupiter.api.Test
  void setDestinationAirport() {
  }

  @org.junit.jupiter.api.Test
  void getArrivalTime() {
  }

  @org.junit.jupiter.api.Test
  void setArrivalTime() {
  }

  @org.junit.jupiter.api.Test
  void getDepartureTime() {
  }

  @org.junit.jupiter.api.Test
  void setDepartureTime() {
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