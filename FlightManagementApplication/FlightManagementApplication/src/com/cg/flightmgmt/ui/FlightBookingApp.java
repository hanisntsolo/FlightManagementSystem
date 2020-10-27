package com.cg.flightmgmt.ui;

/*
 * This is the main program to
 * initiate the app and perform
 * operations on Flight reservation.
 *
 * The functionalities provided by the system.
 * There are two categories of people who would access the system: customer and
 * administrator.
 * Each of these would have some exclusive privileges.
 * 1. The customer can:
 *    a. Create his user account.
 *    b. Login into the application.
 *    c. Check for available flights.
 *    d. Make a booking.
 *    e. View the bookings made.
 *    f. Cancel or modify a booking.
 * 2. The administrator can:
 *    a. Login into the application.
 *    b. Add flight, schedule and route details.
 *    c. View the flight, schedule and route details.
 *    d. Cancel or modify the flight, schedule and route details.
 *
 *
 */
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.IUserService;
import com.cg.flightmgmt.service.UserServiceImpl;

import java.math.BigInteger;
import java.util.Scanner;

public class FlightBookingApp {
  static Scanner sc= new Scanner(System.in);
  static IUserService userService= new UserServiceImpl();
  public static void main(String[] args){

    System.out.println("===========WELCOME TO EASEMYFLIGHT=============");
    System.out.println("-----------------------------------------------");
    System.out.println("1. Log in as admin");
    System.out.println("2. Log in as user");
    System.out.println("3. If you don't have an account, please sign up...");
    System.out.println(("Enter your choice: "));
    int logChoice= Integer.parseInt(sc.nextLine());

    if(logChoice==1) {
      if(validateUser()) {
        while (true) {
          System.out.println("1. Add Flights\n2. Modify Flights\n3. Delete Flight\n4. Search Flight\n5. Show Flights\n"
                  + "6. Add Schedule\n7. Modify Schedule\n8. Delete Schedule\n9. Search Schedule\n10. Show Schedule\n11. Log out");
          int choice = sc.nextInt();
          switch (choice) {

            case 1:// add flight
              break;
            case 2:// modify flight
              break;
            case 3:// delete flight
              break;
            case 4:// search flight
              break;
            case 5:// show flight
              break;
            case 6:// add schedule
              break;
            case 7:// modify schedule
              break;
            case 8:// delete schedule
              break;
            case 9:// search schedule
              break;
            case 10:// show schedule
              break;
            case 11:
              System.out.println("Logged out");
              System.exit(0);
              break;
            default:
              System.out.println("Choose from the given options.....");

          }
        }
      }else{
        System.out.println("User not found....\nYou have entered wrong id or password!");
      }
    }else if(logChoice==2) {
      if(validateUser()) {
        while (true) {
          System.out.println("1. Search Flights\n2. check availability\n3. Make Booking\n4. Cancel Booking\n5. Log out");
          int choice = sc.nextInt();
          switch (choice) {

            case 1:// search flights
              break;
            case 2:// check availability
              break;
            case 3:
              break;
            case 4:// Cancel Booking
              break;
            case 5:
              System.out.println("Logged out");
              System.exit(0);
              break;
            default:
              System.out.println("Choose from the given options.....");

          }
        }
      }else{
        System.out.println("User not found....\nYou have entered wrong id or password!");
      }
    }else if(logChoice==3) {
      signUp();
    }else{
        System.out.println("Enter correct choice....");
      }
      sc.close();
    }

  public static Boolean validateUser(){
    System.out.println("Enter user id:");
    BigInteger userId= sc.nextBigInteger();
    System.out.println("Enter password:");
    String password= sc.next();
    try {
      userService.validateUser(new User(userId, password));
      return true;
    }catch (UserNotFoundException e){
      return false;
    }
  }

  public  static User signUp(){
    System.out.println("Enter name: ");
    String name= sc.nextLine();
    System.out.println("Enter password: ");
    String password= sc.next();
    System.out.println("Enter email: ");
    String email= sc.next();
    System.out.println("Enter mobile no: ");
    String mobileNo= sc.next();
    User user= userService.addUser(new User("user", name, password, email, mobileNo));
    System.out.println("You have successfully signed up. Go to the login page.....");
    System.out.println("======= Your user id is: " + user.getUserId() + " ========");
    return user;
  }

}

