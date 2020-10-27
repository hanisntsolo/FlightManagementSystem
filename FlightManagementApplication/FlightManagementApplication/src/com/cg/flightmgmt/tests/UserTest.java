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
  }

  @org.junit.jupiter.api.Test
  void setMobileNumber() {
  }

  @org.junit.jupiter.api.Test
  void getUserId() {
  }

  @org.junit.jupiter.api.Test
  void setUserId() {
  }

  @org.junit.jupiter.api.Test
  void getUserType() {
  }

  @org.junit.jupiter.api.Test
  void setUserType() {
  }

  @org.junit.jupiter.api.Test
  void getUserName() {
  }

  @org.junit.jupiter.api.Test
  void setUserName() {
  }

  @org.junit.jupiter.api.Test
  void getPassword() {
  }

  @org.junit.jupiter.api.Test
  void setPassword() {
  }

  @org.junit.jupiter.api.Test
  void getEmail() {
  }

  @org.junit.jupiter.api.Test
  void setEmail() {
  }

  @org.junit.jupiter.api.AfterAll
  public static void afterClass() {
    System.out.println ("This will execute after all test cases!");
  }
}