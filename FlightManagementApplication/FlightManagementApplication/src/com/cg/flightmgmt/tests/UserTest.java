package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

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
  void getMobileNumber() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setMobileNumber() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getUserId() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setUserId() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getUserType() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setUserType() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getUserName() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setUserName() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getPassword() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setPassword() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void getEmail() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.Test
  void setEmail() {
    fail("This test is yet to be written !");
  }

  @org.junit.jupiter.api.AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}