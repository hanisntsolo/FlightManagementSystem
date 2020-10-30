package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;
import com.cg.flightmgmt.repository.UserRepositoryImpl;
import com.cg.flightmgmt.service.UserServiceImpl;
import java.math.BigInteger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {
  private static IUserRepository userService;
  private static User user, user1,user2;
  private static int count = 0;

  @BeforeAll
  public static void beforeClass_userService() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp_userService() {
  userService = new UserRepositoryImpl();
  user = new User("User","Jordan","ab_cd&789","jordan123@xyz.com","4964852671");
  user1 = new User("User","Joudan","ab_cd&789","jordan123@xyz.com","4964852671");

//  user1 = new User(new BigInteger("215"),"dontGuessMe");
//  user2 = new User();
    System.out.println("Running a test.....");
  }

  @AfterEach
  void tearDown_userService() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  /**
   * Functionality number one
   * adding user
   * @throws Exception
   */
  @Test
  void addUser_userService() throws Exception {
//    fail("This is yet to be implemented");
    assertEquals(user, userService.addUser(user));
  }
  @Test
  void notAddUser_userService() {
    userService.addUser(user1);
    assertNotEquals(user1, userService.addUser(user));
  }
  @Test
  void addNotUser_userService() {
    assertThrows(IllegalArgumentException.class, ()->{
    user = null;
    assertEquals(null, userService.addUser(null));
    });
  }
  /**
   * Functionality number two
   * validating user
   * @throws Exception
   */
  @Test
  void validateUser_userService() throws UserNotFoundException {
    userService.addUser(user);
    assertEquals(user, userService.validateUser(user));
  }
  @Test
  void notValidateUser_userService() throws UserNotFoundException {
    userService.addUser(user1);
    userService.addUser(user);
    assertNotEquals(user, userService.validateUser(user1));
  }
  @Test
  void validateNotUser_userService() {
    assertThrows(UserNotFoundException.class, ()->{
      userService.addUser(user);
      userService.removeUser(user.getUserId());
      assertNotEquals(user.getUserId(), userService.validateUser(user).getUserId());
    });
  }
  /**
   * Functionality number three
   * updating user
   * @throws Exception
   */
  @Test
  void updateUser_userService() throws UserNotFoundException {
//    fail("This is yet to be implemented");
    userService.addUser(user);
    assertEquals(user, userService.updateUser(user));
  }
  @Test
  void notUpdateUser_userService() throws UserNotFoundException {
    userService.addUser(user);
    userService.addUser(user1);
    assertNotEquals(user1, userService.updateUser(user));
  }
  @Test
  void updateNotUser_userService() {
    assertThrows(UserNotFoundException.class, ()->{
      userService.addUser(user);
      userService.removeUser(user.getUserId());
      assertEquals(user, userService.updateUser(user));
    });
  }

  /**
   * Functionality number four
   * removing user
   * @throws Exception
   */

  @Test
  void removeUser_userService() throws UserNotFoundException {
//    fail("This is yet to be implemented");
    userService.addUser(user);
    assertEquals(user, userService.removeUser(user.getUserId()));
  }
  @Test
  void removeNotUser_userService() throws UserNotFoundException{
    userService.addUser(user);
    userService.addUser(user1);
    assertNotEquals(user1, userService.removeUser(user.getUserId()));
  }
  @Test
  void notRemoveUser_userService() {
    assertThrows(UserNotFoundException.class, ()->{
      userService.addUser(user);
      userService.addUser(user1);
      userService.removeUser(user.getUserId());
      assertNotEquals(user,userService.removeUser(user.getUserId()));
    });
  }
  @AfterAll
  static void afterClass_userService () {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}