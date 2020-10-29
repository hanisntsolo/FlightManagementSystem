package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.IUserService;
import com.cg.flightmgmt.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class UserServiceImplTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void addUser() {
    fail("This is yet to be implemented");
  }

  @Test
  void validateUser () throws UserNotFoundException {
    User user= new User();
    user.setUserId(new BigInteger("14657"));
    user.setPassword("abc");
    IUserService userService= new UserServiceImpl();
    assertEquals(user, userService.validateUser(user));
  }

  @Test
  void updateUser() {
    fail("This is yet to be implemented");
  }

  @Test
  void removeUser() {
    fail("This is yet to be implemented");
  }
}