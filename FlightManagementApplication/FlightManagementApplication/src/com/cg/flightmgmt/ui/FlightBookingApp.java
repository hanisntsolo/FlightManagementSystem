package com.cg.flightmgmt.ui;

import com.cg.flightmgmt.dto.*;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.*;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*******************************************************************************
 * This is the main program to
 * initiate the app and perform
 * operations on Flight reservation.
 * <p>
 * The functionalities provided by the system.
 * There are two categories of people who would access the system: customer and
 * administrator.
 * Each of these would have some exclusive privileges.
 * 1. The customer can:
 * a. Create his user account.
 * b. Login into the application.
 * c. Check for available flights.
 * d. Make a booking.
 * e. View the bookings made.
 * f. Cancel or modify a booking.
 * 2. The administrator can:
 * a. Login into the application.
 * b. Add flight, schedule and route details.
 * c. View the flight, schedule and route details.
 * d. Cancel or modify the flight, schedule and route details.
 */

public class FlightBookingApp {
  static Scanner sc= new Scanner(System.in);
  static IFlightBookingService flightBookingService= new FlightBookingServiceImpl();
  static IScheduledFlightService scheduledFlightService= new ScheduledFlightServiceImpl();
  static IUserService userService= new UserServiceImpl();
  static FlightServiceImpl flightService=new FlightServiceImpl();

 static IAirportService airportService=new AirportServiceImp();

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
  static ScheduledFlight scheduledFlight;

  public static void main(String[] args) throws Exception{
    System.out.println("*******************************************************");
    System.out.println("\n\n===========WELCOME TO EASE_MY_FLIGHT=============");
    System.out.println("-----------------------------------------------");
    System.out.println("1. Log in as admin");
    System.out.println("2. Log in as user");
    System.out.println("3. If you don't have an account, please sign up...");
    System.out.println(("Enter your choice: "));
    int logChoice= Integer.parseInt(sc.nextLine());

    if(logChoice==1) {
      User user= validateUser();
      if(user!= null) {
        while (true) {
          System.out.println("1. Add Flights\n"
                           + "2. Modify Flights\n"
                           + "3. Delete Flight\n"
                           + "4. Search Flight\n"
                           + "5. Show Flights\n"
                           + "6. Add Schedule\n"
                           + "7. Modify Schedule\n"
                           + "8. Delete Schedule\n"
                           + "9. Search Schedule\n"
                           + "10. Show Schedule\n"
                           + "11. Log out");
          int choice = sc.nextInt();

          switch (choice) {

            case 1:// add flight

              addFlight();
              break;


            case 2:// modify flight
              break;
            case 3:// delete flight
                 deleteFlight();
              break;

            case 4:// search flight
                searchFlight();
             break;

            case 5:// show flight
                showFlight();
              break;

            case 6:// add schedule
               addSchedule();

              break;

            case 7:// modify schedule
                modifySchedule();
              break;

            case 8:// delete schedule
                deleteSchedule();
              break;

            case 9:// search schedule
                searchSchedule();

             break;

            case 10:// show schedule
                showSchedule();
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
      User user= validateUser();
      if(user!= null) {
        while (true) {
          System.out.println("1. check availability\n2. Make Booking\n3. Cancel Booking\n4. Log out");
          int choice = sc.nextInt();
          switch (choice) {
            case 1: checkAvailability();
              break;
            case 2: makeBooking(user);
              break;
            case 3: cancelBooking();
              break;
            case 4:
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

  public static User validateUser(){
    System.out.println("Enter user id:");
    BigInteger userId= sc.nextBigInteger();
    System.out.println("Enter password:");
    String password= sc.next();
    try {
      User user= userService.validateUser(new User(userId, password));
      return user;
    }catch (UserNotFoundException e){
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

  public  static void signUp(){
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
  }

  public static List<ScheduledFlight> checkAvailability(){
    System.out.println("Enter source: ");
    String source= sc.next();
    System.out.println("Enter destination: ");
    String destination= sc.next();
    System.out.println("Enter date: ");
    String[] dateArr= sc.next().split("-");
    LocalDate date= LocalDate.of(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
    List<ScheduledFlight> list= scheduledFlightService.viewAllScheduledFlights(source, destination, date);
    if(list!= null)
      System.out.println(list);
    else
      System.out.println("No flights available");
    return list;
  }

  public static void cancelBooking() {
    System.out.println("Please enter booking id: ");
    BigInteger bookingId = sc.nextBigInteger();
    try {
      flightBookingService.cancelBooking(bookingId);
      System.out.println("Booking cancelled");
    } catch (BookingNotFoundException e) {
      System.out.println("Booking not found!");
    }
  }

  public static void makeBooking(User user){
    List<Passenger> passengers_list= new ArrayList<>();
    List<ScheduledFlight> flight_list= checkAvailability();
    if(flight_list==null)
      return;
    System.out.println("Enter your choice: ");
    int choice= sc.nextInt();
    System.out.println("Enter no of passengers: ");
    int noOfPassenger= sc.nextInt();
    System.out.println("Enter details of passengers: ");
    for(int i=0; i<noOfPassenger; i++){
      Passenger psngr= new Passenger();
      System.out.println("Enter passenger " + (i+1) + " details");
      System.out.println("Enter passenger name: ");
      psngr.setPassengerName(sc.nextLine());
      System.out.println("Enter passenger age: ");
      psngr.setAge(sc.nextInt());
      System.out.println("Enter passenger UIN: ");
      psngr.setPassengerUIN(sc.nextBigInteger());
      System.out.println("Enter luggage: ");
      psngr.setLuggage(sc.nextDouble());
      passengers_list.add(psngr);
    }
    double cost= flight_list.get(choice-1).getFares();
    Flight flight= flight_list.get(choice-1).getFlight();
    Booking booking= new Booking(user, LocalDate.now(), passengers_list, cost, flight, noOfPassenger);
    Booking confirmedBooking= flightBookingService.addBooking(booking);
    for(Passenger passenger: passengers_list){
      passenger.setBooking(confirmedBooking);
    }
    System.out.println("Your booking is confirmed");
    System.out.println(confirmedBooking);
  }
  public static  void addFlight()
  {
      System.out.println("Enter Flight Id");
      flightId = sc.nextBigInteger();
      System.out.println("Enter Carrier Name");
      sc.nextLine();
      carrierName= sc.nextLine();
      System.out.println("Enter Flight Model");
      flightModel = sc.nextLine();
      System.out.println("Enter Seat Capacity");
      seatCapacity = sc.nextInt();
      flight = new Flight(flightId,carrierName,flightModel,seatCapacity);
      flightService.addFlight(flight);
      System.out.println(flight.toString());
      System.out.println("-----YOU HAVE SUCCESSFULLY ADDED FLIGHT DETAILS-----");
  }
  public static void modifyFlight()
  {
     //code to update flight
  }
  public static void deleteFlight()
  {
      System.out.println("Enter Flight Id of Flight to be deleted");
      flightId=sc.nextBigInteger();
      try {
          flightService.removeFlight(flightId);
      }
      catch(FlightNotFoundException fe)
      {
          System.out.println(fe.getMessage());
      }
      System.out.println("---SUCCESSFULLY DELETED-----");
  }
  public static void searchFlight()
  {
      try {
          System.out.println("Enter Flight Id of Flight to be searched ");
          flightId=sc.nextBigInteger();
          flight=flightService.viewFlight(flightId);
          if(flight==null)
          {
              throw new FlightNotFoundException("Flight not Found");
          }
          else {
              System.out.println(flight);
          }
      }
      catch (FlightNotFoundException fe)

      {
          System.out.println(fe.getMessage());
      }
  }
  public static void showFlight()
  {
      List<Flight> flightList=flightService.viewAllFlights();
      Iterator itr=flightList.iterator();
      while (itr.hasNext())
      {
          System.out.println(itr.next());
      }
  }
  public static void addSchedule()
  {
      System.out.println("Enter Flight id");
      flightId=sc.nextBigInteger();
      try {
          flight=flightService.viewFlight(flightId);

      } catch (FlightNotFoundException e) {
          e.printStackTrace();
      }

      System.out.println("Enter no. of Available Seats");
      availableSeats=sc.nextInt();

      System.out.println("Enter Source Airport ID");
      airportId=sc.nextInt();

      System.out.println("Enter Source Airport name");
      sc.nextLine();
      airportName=sc.nextLine();

      System.out.println("Enter Source Airport Location");
      airportLocation=sc.nextLine();

      sourceAirport=new Airport(airportId,airportName,airportLocation);
      airportService.addAirport(sourceAirport);

      System.out.println("Enter Destination Airport ID");
      airportId=sc.nextInt();

      System.out.println("Enter Destination Airport Name");
      sc.nextLine();
      airportName=sc.nextLine();

      System.out.println("Enter Destination Airport Location");
      airportLocation=sc.nextLine();

      destinationAirport=new Airport(airportId,airportName,airportLocation);
      airportService.addAirport(destinationAirport);

      System.out.println("Enter Arrival Time in format(YYYY-MM-DD-HH-MM)");
      String[] arrivalTimeArr=sc.next().split("-");
      LocalDateTime arrivalTime = LocalDateTime.of(Integer.parseInt(arrivalTimeArr[0]),Integer.parseInt(arrivalTimeArr[1]),Integer.parseInt(arrivalTimeArr[2]),Integer.parseInt(arrivalTimeArr[3]),Integer.parseInt(arrivalTimeArr[4]));

      System.out.println("Enter Departure Time in Format(YYYY-MM-DD-HH-MM)");
      String[] departureTimeArr=sc.next().split("-");
      LocalDateTime departureTime = LocalDateTime.of(Integer.parseInt(departureTimeArr[0]),Integer.parseInt(departureTimeArr[1]),Integer.parseInt(departureTimeArr[2]),Integer.parseInt(departureTimeArr[3]),Integer.parseInt(departureTimeArr[4]));

      System.out.println("Enter Arrival Date in Format(YYYY-MM-DD)");
      String[] arrivalDateArr=sc.next().split("-");
      LocalDate arrivalDate = LocalDate.of(Integer.parseInt(arrivalDateArr[0]),Integer.parseInt(arrivalDateArr[1]),Integer.parseInt(arrivalDateArr[2]));
      Schedule schedule=new Schedule(sourceAirport,destinationAirport,arrivalTime,departureTime,arrivalDate);

      System.out.println("Enter Fares of Flight");
      fares = sc.nextDouble();

      scheduledFlight=new ScheduledFlight(flight,availableSeats,schedule,fares);

      scheduledFlightService.addFlightSchedule(scheduledFlight);

      System.out.println("--------FLIGHT SCHEDULE SUCCESSFULLY ADDED-----");
  }
  public static void modifySchedule()
  {
      System.out.println("Enter FlightId");
      flightId=sc.nextBigInteger();
      System.out.println("Enter updated Available Seats ");
      int availableSeat=sc.nextInt();
      try {
          scheduledFlight = scheduledFlightService.viewFlightSchedule(flightId);
          scheduledFlightService.updateFlightSchedule(flightId, availableSeat);
      }
      catch(FlightNotFoundException fe)
      {
          System.out.println(fe.getMessage());
      }
      System.out.println("------SUCCESSFULLY UPDATED-----");
  }
  public static void deleteSchedule()
  {
      System.out.println("Enter Flight ID of the flight to be deleted");
      flightId=sc.nextBigInteger();
      try {
          scheduledFlightService.removeFlightSchedule(flightId);
      }
      catch(FlightNotFoundException fe)
      {
          System.out.println(fe.getMessage());
      }
      System.out.println("-------FLIGHT SCHEDULE SUCCESSFULLY DELETED----");
  }
  public static void  searchSchedule()
  {
      System.out.println("Enter FlightID: ");
      flightId=sc.nextBigInteger();
      try {
          System.out.println(scheduledFlightService.viewFlightSchedule(flightId));
      }
      catch(FlightNotFoundException fe)
      {
          System.out.println(fe.getMessage());
      }
  }
  public static void showSchedule()
  {
      System.out.println("Enter Date: ");
      String[] arrivalDateArr=sc.next().split("-");
      LocalDate arrivalDate = LocalDate.of(Integer.parseInt(arrivalDateArr[0]),Integer.parseInt(arrivalDateArr[1]),Integer.parseInt(arrivalDateArr[2]));
try {
    List<ScheduledFlight> scheduledFlightList = scheduledFlightService.viewAllScheduledFlights(arrivalDate);
    Iterator<ScheduledFlight> itr1 = scheduledFlightList.iterator();
    while (itr1.hasNext()) {
        System.out.println(itr1.next());
    }
}
catch (FlightNotFoundException fe)
{
    System.out.println(fe.getMessage());
}
  }
}

