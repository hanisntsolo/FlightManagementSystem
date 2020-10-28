package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.UserServiceImpl;
import java.math.BigInteger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {
  private static UserServiceImpl userService;
  private static User user, user1;

  @BeforeAll
  public static void beforeClass_userService() {
    System.out.println("This will run before any of the test cases!");
  }
  @BeforeEach
  void setUp_userService() {
  userService = new UserServiceImpl();
  user = new User(new BigInteger("155"), "guessMe");
  user1 = new User(new BigInteger("215"),"dontGuessMe");
  }

  @AfterEach
  void tearDown_userService() {
    System.out.println("This will run after each test case gets executed");
  }

  @Test
  void addUser_userService() throws UserNotFoundException {
//    fail("This is yet to be implemented");
    assertEquals(user1, userService.addUser(user1));
  }

  @Test
  void validateUser_userService() throws UserNotFoundException {
    assertEquals(user, userService.validateUser(user));
  }

  @Test
  void updateUser_userService() throws UserNotFoundException {
//    fail("This is yet to be implemented");
    assertEquals(user, userService.updateUser(user));
  }


  @Test
  void removeUser_userService() throws UserNotFoundException {
//    fail("This is yet to be implemented");
    userService.addUser(user1);
    //Having return type user, asserting it to removed user.
    assertEquals(user1, userService.removeUser(new BigInteger("215")));
  }
  @AfterAll
  static void afterClass_userService () {
    System.out.println("This will run after all test case get executed.");
  }
}