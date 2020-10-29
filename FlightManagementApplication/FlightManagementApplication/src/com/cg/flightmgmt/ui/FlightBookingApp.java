package com.cg.flightmgmt.ui;
import com.cg.flightmgmt.dto.*;

/**
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
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IPassengerRepository;
import com.cg.flightmgmt.service.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class FlightBookingApp {
  static Scanner sc = new Scanner(System.in);
  static IFlightBookingService flightBookingService = new FlightBookingServiceImpl();
  static IPassengerService passengerService= new PassengerServiceImpl();
  static IScheduledFlightService scheduledFlightService = new ScheduledFlightServiceImpl();
  static IUserService userService = new UserServiceImpl();

  public static void main(String[] args) {

    System.out.println("\n\n===========WELCOME TO EASEMYFLIGHT=============");
    System.out.println("-----------------------------------------------");
    System.out.println("1. Log in as admin");
    System.out.println("2. Log in as user");
    System.out.println("3. If you don't have an account, please sign up...");
    System.out.println(("Enter your choice: "));
    int logChoice = Integer.parseInt(sc.nextLine());

    if (logChoice == 1) {
      User user = validateAdmin();
      if (user != null) {
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
      } else {
        System.out.println("User not found....\nYou have entered wrong id or password!");
      }
    } else if (logChoice == 2) {
      User user = validateUser();
      if (user != null) {
        while (true) {
          System.out.println("1. check availability\n2. Make Booking\n3. Cancel Booking\n4. Log out");
          int choice = sc.nextInt();
          switch (choice) {
            case 1:
              checkAvailability();
              break;
            case 2:
              makeBooking(user);
              break;
            case 3:
              cancelBooking();
              break;
            case 4:
              System.out.println("Logged out");
              System.exit(0);
              break;
            default:
              System.out.println("Choose from the given options.....");
          }
        }
      } else {
        System.out.println("User not found....\nYou have entered wrong id or password!");
      }
    } else if (logChoice == 3) {
      signUp();
    } else {
      System.out.println("Enter correct choice....");
    }
    sc.close();
  }

  public static User validateUser() {
    System.out.println("Enter user id:");
    BigInteger userId = sc.nextBigInteger();
    System.out.println("Enter password:");
    String password = sc.next();
    try {
      User user = userService.validateUser(new User(userId, password));
      return user;
    } catch (UserNotFoundException e) {
      return null;
    }
  }

  public static User validateAdmin() {
    System.out.println("Enter user id:");
    BigInteger userId = sc.nextBigInteger();
    System.out.println("Enter password:");
    String password = sc.next();
    try {
      User user = userService.validateUser(new User(userId, password));
      if (user.getUserType().equals("admin"))
        return user;
      else
        return null;
    } catch (UserNotFoundException e) {
      return null;
    }
  }
  /*public static void updateUser() throws UserNotFoundException {
    System.out.println("Enter your user Id:");
    BigInteger userId = sc.nextBigInteger();
    System.out.println("Enter Password:");
    String password = sc.next();
    userService.updateUser(new User(userId, password));
  }*/

  public static void signUp() {
    System.out.println("Enter name: ");
    String name = sc.nextLine();
    System.out.println("Enter password (It contains at least 8 characters and at most 20 characters.\n" +
            "at least one digit.\n" +
            "at least one upper case alphabet.\n" +
            "at least one lower case alphabet.\n" +
            "at least one special character which includes !@#$%&*()-+=^.\n" +
            "doesn’t contain any white space.: ");
    String password = sc.next();
    while(true) {
      if (!isValidPassword(password)) {
        System.out.println("Please enter password in the given format!");
        password= sc.next();
      }else{
        break;
      }
    }
    System.out.println("Enter email (example@xyz.com): ");
    String email = sc.next();
    while(true) {
      if (!isValidEmail(email)) {
        System.out.println("Please enter a valid email!");
        email= sc.next();
      }else{
        break;
      }
    }
    System.out.println("Enter mobile no: ");
    String mobileNo = sc.next();
    while(true) {
      if (!isValidMobile(mobileNo)) {
        System.out.println("Please enter a valid 10 digit mobile number!");
        mobileNo= sc.next();
      }else{
        break;
      }
    }
    User user = userService.addUser(new User("user", name, password, email, mobileNo));
    System.out.println("You have successfully signed up. Go to the login page.....");
    System.out.println("======= Your user id is: " + user.getUserId() + " ========");
  }

  public static List<ScheduledFlight> checkAvailability() {
    System.out.println("Enter source: ");
    String source = sc.next();
    System.out.println("Enter destination: ");
    String destination = sc.next();
    System.out.println("Enter date(dd-mm-yyyy): ");
    String date= sc.next();
    while(true) {
      if (!isValidDate(date)) {
        System.out.println("Please enter a valid date in the given format!");
        date= sc.next();
      }else{
        break;
      }
    }
    String[] dateArr = date.split("-");
    LocalDate new_date = LocalDate.of(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[0]));
    List<ScheduledFlight> list = scheduledFlightService.viewAllScheduledFlights(source, destination, new_date);
    if(!list.isEmpty())
      for (int i=0; i<list.size(); i++) {
        System.out.println((i+1)+". "+list.get(i) + "\n");
      }
    else
      System.out.println("No flights available!");
    return list;
  }

  public static void cancelBooking() {
    System.out.println("Please enter booking id: ");
    int bookingId = sc.nextInt();
    try {
      flightBookingService.cancelBooking(new BigInteger(String.valueOf(bookingId)));
      System.out.println("Booking cancelled");
    } catch (BookingNotFoundException e) {
      System.out.println("Booking not found!");
    }
  }

  public static Booking makeBooking(User user) {
    List<Passenger> passengers_list = new ArrayList<>();
    List<ScheduledFlight> flight_list = checkAvailability();
    if (flight_list.isEmpty()) {
      return null;
    }
    System.out.println("Enter your choice: ");
    int choice = sc.nextInt();
    System.out.println("Enter no of passengers: ");
    int noOfPassenger = sc.nextInt();
    System.out.println("Enter details of passengers: ");
    for (int i = 0; i < noOfPassenger; i++) {
      System.out.println("Enter passenger " + (i + 1) + " details");
      Passenger passenger = getPassengerDetails();
      passengers_list.add(passenger);
    }
    double cost = flight_list.get(choice - 1).getFares();
    Flight flight = flight_list.get(choice - 1).getFlight();
    Booking booking = new Booking(user, LocalDate.now(), passengers_list, cost, flight, noOfPassenger);
    for(Passenger passenger: passengers_list){
      passengerService.addPassenger(passenger);
    }
    Booking confirmedBooking = flightBookingService.addBooking(booking);
    System.out.println("\n======Your booking is confirmed======\n");
    System.out.println(confirmedBooking);
    return confirmedBooking;
  }

  public static Passenger getPassengerDetails(){
    Passenger psngr= new Passenger();
    System.out.println("Enter passenger name: ");
    psngr.setPassengerName(sc.next());
    System.out.println("Enter passenger age: ");
    psngr.setAge(sc.nextInt());
    System.out.println("Enter passenger UIN (12 digits): ");
    BigInteger uin= sc.nextBigInteger();
    while(true) {
      if (!uin.toString().matches("^[0-9]{12}$")) {
        System.out.println("Please enter 12 digit user identification number!");
        uin= sc.nextBigInteger();
      }else{
        break;
      }
    }
    psngr.setPassengerUIN(uin);
    System.out.println("Enter luggage: ");
    psngr.setLuggage(sc.nextDouble());
    return psngr;
  }

  public static boolean isValidPassword(String password) {
    String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
    return password.matches(regex);
  }

  public static boolean isValidEmail(String email){
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    return email.matches(regex);
  }

  public static boolean isValidMobile(String mobile){
    String regex = "^[0-9]{10}$";
    return mobile.matches(regex);
  }

  public static boolean isValidDate(String date){
    String regex= "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](20)[2-9]\\d$";
    return date.matches(regex);

    }
  }
