package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PassengerTest {
  private static Passenger passenger;
  private static Booking booking;
  private Passenger o;
  private static int count = 0;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
    booking= null;
    passenger = new Passenger(new BigInteger("469532187649"),"Thomas",45,new BigInteger("793546182796"),7.4,booking);
    System.out.println("Running tests............");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  @Test
  void getPnrNumber() {
    assertEquals(new BigInteger("469532187649"),passenger.getPnrNumber());
  }

  @Test
  void setPnrNumber() {
    passenger.setPnrNumber(new BigInteger("469532187649"));
    assertEquals(new BigInteger("469532187649"),passenger.getPnrNumber());
  }

  @Test
  void getPassengerName() {
    assertEquals("Thomas",passenger.getPassengerName());
  }

  @Test
  void setPassengerName() {
    passenger.setPassengerName("Roger");
    assertNotEquals("Zara",passenger.getPassengerName());
  }

  @Test
  void getAge() {
    assertEquals(45,passenger.getAge());
  }

  @Test
  void setAge() {
    passenger.setAge(41);
    assertEquals(41,passenger.getAge());
  }

  @Test
  void getPassengerUIN() {
    assertEquals(new BigInteger("793546182796"),passenger.getPassengerUIN());
  }

  @Test
  void setPassengerUIN() {
    passenger.setPassengerUIN(new BigInteger("462394269249"));
    assertNotEquals(new BigInteger("433179544476"),passenger.getPassengerUIN());
  }

  @Test
  void getLuggage() {
    assertNotEquals(5.0,passenger.getLuggage());
  }

  @Test
  void setLuggage() {
    passenger.setLuggage(9.6);
    assertEquals(9.6,passenger.getLuggage());
  }

  @Test
  void testEquals() {
    assertEquals(passenger.equals(o),false);  }

  @Test
  void testHashCode() {
    assertEquals(passenger.hashCode(), Objects.hash(new BigInteger("469532187649"),"Thomas",45,new BigInteger("793546182796"),7.4));
  }

  @Test
  void testToString() {
    assertEquals(passenger.toString(), "Passenger{pnrNumber=469532187649, passengerName='Thomas', age=45, passengerUIN=793546182796, luggage=7.4}");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}