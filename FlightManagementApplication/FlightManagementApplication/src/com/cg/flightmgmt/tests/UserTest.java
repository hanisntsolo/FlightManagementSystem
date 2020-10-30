package com.cg.flightmgmt.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.flightmgmt.dto.User;
import org.junit.jupiter.api.*;

import java.math.BigInteger;

class UserTest {
  private static User user;
  private static User user1;
  private static int count = 0;

  @BeforeAll
  public static void  beforeClass() {
    System.out.println("This will run before any of the test cases! Test count = " + count++);
  }
  @BeforeEach
  void setUp() {
    user = new User("User","Jordan","ab_cd&789","jordan123@xyz.com","4964852671");
    user1 = new User(new BigInteger("46319543"),"ab_cd&789");
    System.out.println("Running tests..........");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test case "+ count++ +" executed successfully ");
  }

  @Test
  void getMobileNumber() {
    assertEquals("4964852671", user.getMobileNumber());
  }
  @Test
  void setMobileNumber() {
    user.setMobileNumber("4964851571");
    assertEquals("4964851571",user.getMobileNumber());
  }

  @Test
  void getUserId() {
    assertEquals(BigInteger.valueOf(Long.parseLong("46319543")),user1.getUserId());
  }

  @Test
  void setUserId() {
    user1.setUserId(BigInteger.valueOf(46311864));
    assertNotEquals(BigInteger.valueOf(46319461),user1.getUserId());
  }

  @Test
  void getUserType() {
    assertEquals("User",user.getUserType());
  }

  @Test
  void setUserType() {
    user.setUserType("admin");
    assertEquals("admin",user.getUserType());
  }

  @Test
  void getUserName() {
    assertEquals("Jordan",user.getUserName());
  }

  @Test
  void setUserName() {
    user.setUserName("Michael");
    assertNotEquals("Jordan",user.getUserName());
  }

  @Test
  void getPassword() {
    assertEquals("ab_cd&789",user.getPassword());
  }

  @Test
  void setPassword() {
    user.setPassword("xy_kj&789");
    assertEquals("xy_kj&789",user.getPassword());
  }

  @Test
  void getEmail() {
    assertEquals("jordan123@xyz.com",user.getEmail());
  }

  @Test
  void setEmail() {
    user.setEmail("julie245@abc.com");
    assertNotEquals("jordan123@xyz.com",user.getEmail());
  }
  @AfterAll
  public static void afterClass() {
    System.out.println("This will run after all test case get executed. Total tests executed = " + --count);
  }
}