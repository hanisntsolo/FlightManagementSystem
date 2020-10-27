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
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.FlightRepositoryImpl;
import com.cg.flightmgmt.service.FlightServiceImpl;
import com.cg.flightmgmt.service.IUserService;
import com.cg.flightmgmt.service.ScheduledFlightServiceImpl;
import com.cg.flightmgmt.service.UserServiceImpl;


import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.time.LocalDateTime;
import java.util.Scanner;

public class FlightBookingApp {
  static Scanner sc= new Scanner(System.in);
  static IUserService userService= new UserServiceImpl();
  static FlightServiceImpl flightService=new FlightServiceImpl();
  static ScheduledFlightServiceImpl scheduledFlightService=new ScheduledFlightServiceImpl();
 static BigInteger flightId;
 static String carrierName;
 static String flightModel;
  static int seatCapacity;
  static Flight flight;
 static int availableSeats;
  static Schedule schedule;
  static double fares;
  static int airportId;
  static String airportName;
  static String airportLocation;
  static Airport sourceAirport;
  static  Airport destinationAirport;

  public static void main(String[] args) throws Exception{

    System.out.println("\n\n===========WELCOME TO EASEMYFLIGHT=============");
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

              System.out.println("Enter Flight Id");
               flightId = sc.nextBigInteger();
              System.out.println("Enter Carrier Name");
               carrierName= sc.nextLine();
              System.out.println("Enter Flight Model");
               flightModel = sc.nextLine();
              System.out.println("Enter Seat Capacity");
               seatCapacity = sc.nextInt();
               flight = new Flight(flightId,carrierName,flightModel,seatCapacity);
              flightService.addFlight(flight);
              System.out.println(flight.toString());
              break;


            case 2:// modify flight
              break;
            case 3:// delete flight
                 System.out.println("Enter Flight Id of Flight to be deleted");
                  flightId=sc.nextBigInteger();
                 flightService.removeFlight(flightId);
              break;

            case 4:// search flight
              try {
                System.out.println("Enter Flight Id of Flight to be searched ");
                 flightId=sc.nextBigInteger();
                 flight=flightService.viewFlight(flightId);
                if(flight==null)
                {
                  throw new FlightNotFoundException("Flight not Found");
                }
                else
                  System.out.println(flight);
              }
              catch (FlightNotFoundException fe)

              {
                System.out.println(fe.getMessage());
              }
              break;

            case 5:// show flight
              System.out.println(flightService.viewAllFlights());
              break;

            case 6:// add schedule
               System.out.println("Enter Flight id");
              flightId=sc.nextBigInteger();

              System.out.println("Enter Carrier Name ");
              carrierName=sc.nextLine();

              System.out.println("Enter Flight Model");
              flightModel=sc.nextLine();

              System.out.println("Enter Seat Capacity");
              seatCapacity=sc.nextInt();

              flight=new Flight(flightId,carrierName,flightModel,seatCapacity);

              System.out.println("Enter no. of Available Seats");
              availableSeats=sc.nextInt();

              System.out.println("Enter Source Airport ID");
               airportId=sc.nextInt();

              System.out.println("Enter Source Airport name");
               airportName=sc.nextLine();

               System.out.println("Enter Source Airport Location");
               airportLocation=sc.nextLine();

               sourceAirport=new Airport(airportId,airportName,airportLocation);

               System.out.println("Enter Destination Airport ID");
               airportId=sc.nextInt();

               System.out.println("Enter Destination Airport Name");
               airportName=sc.nextLine();

               System.out.println("Enter Destination Airport Location");
               airportLocation=sc.nextLine();

               destinationAirport=new Airport(airportId,airportName,airportLocation);

                 System.out.println("Enter Arrival Time");
                 String str=sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime arrivalTime = LocalDateTime.parse(str, formatter);

                System.out.println("Enter Departure Time");
                String s1=sc.nextLine();
                LocalDateTime departureTime = LocalDateTime.parse(s1, formatter);

                System.out.println("Enter Arrival Date");
                String s2=sc.nextLine();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate arrivalDate1=LocalDate.parse(s2,formatter1);

                Schedule schedule=new Schedule(sourceAirport,destinationAirport,arrivalTime,departureTime,arrivalDate1);

                System.out.println("Enter Fares of Flight");
                fares = sc.nextDouble();

                ScheduledFlight scheduledFlight=new ScheduledFlight(flight,availableSeats,schedule,fares);

                scheduledFlightService.addFlightSchedule(flight);

              break;

            case 7:// modify schedule
              break;

            case 8:// delete schedule
                System.out.println("Enter Flight ID of the flight to be deleted");
                flightId=sc.nextBigInteger();
                scheduledFlightService.removeFlightSchedule(flightId);
              break;

            case 9:// search schedule
                System.out.println("Enter FlightID: ");
               flightId=sc.nextBigInteger();
             System.out.println(scheduledFlightService.viewFlightSchedule(flightId));

             break;

            case 10:// show schedule
                System.out.println("Enter Date: ");
                String d1=sc.nextLine();
                Date arrivalDate = Date.valueOf(d1);
                System.out.println(scheduledFlightService.viewAllScheduledFlights( arrivalDate));
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
  public static void updateUser() throws UserNotFoundException {
    System.out.println("Enter your user Id:");
    BigInteger userId = sc.nextBigInteger();
    System.out.println("Enter Password:");
    String password = sc.next();
    userService.updateUser(new User(userId, password));
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

