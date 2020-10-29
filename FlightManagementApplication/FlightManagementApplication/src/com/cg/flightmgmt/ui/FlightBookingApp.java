package com.cg.flightmgmt.ui;

import com.cg.flightmgmt.dto.*;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  static IPassengerService passengerService= new PassengerServiceImpl();
  static IScheduledFlightService scheduledFlightService= new ScheduledFlightServiceImpl();
  static IUserService userService= new UserServiceImpl();
  static IFlightService flightService=new FlightServiceImpl();
  static IAirportService airportService=new AirportServiceImp();

//  static int count= 0;
  public static void main(String[] args){
          try {
              System.out.println("*******************************************************");
              System.out.println("\n\n===========WELCOME TO EASE_MY_FLIGHT=============");
              System.out.println("-----------------------------------------------");
              System.out.println("1. Log in as admin");
              System.out.println("2. Log in as user");
              System.out.println("3. If you don't have an account, please sign up...");
              System.out.println(("Enter your choice: "));
              int logChoice = Integer.parseInt(sc.nextLine());
//              if(count==0)
//                logChoice = Integer.parseInt(sc.nextLine());
//              else{
//                  sc.nextLine();
//                  logChoice= Integer.parseInt(sc.nextLine());
//              }

              if (logChoice == 1) {
                  User user = validateUser();
                  if (user != null) {
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
                              case 1:
                                  addFlight();     //add flight
                                  break;
                              case 2:
                                  modifyFlight();  // modify flight
                                  break;
                              case 3:
                                  deleteFlight();
                                  break;               // delete flight
                              case 4:
                                  searchFlight();
                                  break;               // search flight
                              case 5:
                                  showFlight();
                                  break;               // show flight
                              case 6:
                                  addSchedule();
                                  break;               // add schedule
                              case 7:
                                  modifySchedule();
                                  break;                // modify schedule
                              case 8:
                                  deleteSchedule();
                                  break;                // delete schedule
                              case 9:
                                  searchSchedule();
                                  break;                // search schedule
                              case 10:
                                  showSchedule();
                                  break;                // show schedule
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
          } catch (Exception e) {
              System.out.println("Some error occurred, Please enter valid data!");
          }
      }


    public static User validateAdmin(){
      try{
        System.out.println("Enter user id:");
        BigInteger userId= sc.nextBigInteger();
        System.out.println("Enter password:");
        String password= sc.next();
            User user= userService.validateUser(new User(userId, password));
            if(user.getUserType().equals("admin")) {
                return user;
            }else{
                return null;
            }
        }catch (UserNotFoundException e){
            return null;
        }catch (Exception e){
          System.out.println("Some error occurred, please enter valid data!");
          return null;
      }
    }

  public static User validateUser(){
    try {
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
    }catch(Exception e){
        System.out.println("Some error occurred, Please enter valid data!");
        return null;
    }
  }

  public  static void signUp() {
      try{
      System.out.println("Enter name: ");
      String name = sc.nextLine();
      System.out.println(
              "Enter password (It contains at least 8 characters and at most 20 characters,\n" +
              "at least one digit,\n" +
              "at least one upper case alphabet,\n" +
              "at least one lower case alphabet,\n" +
              "at least one special character which includes !@#$%&*()-+=^,\n" +
              "doesn’t contain any white space. ");
      String password = sc.next();
      while (true) {
          if(!isValidPassword(password)){
              System.out.println("Please enter password in the given format!");
              password= sc.next();
          }else{
              break;
          }
      }
      System.out.println("Enter email (example@xyz.com): ");
      String email = sc.next();
      while (true) {
          if(!isValidEmail(email)){
              System.out.println("Please enter a valid email!");
              email= sc.next();
          }else{
              break;
          }
      }
      System.out.println("Enter mobile no: ");
      String mobileNo = sc.next();
      while (true) {
          if(!isValidMobile(mobileNo)){
              System.out.println("Please enter a valid 10 digit mobile number!");
              mobileNo= sc.next();
          }else{
              break;
          }
      }
      User user = userService.addUser(new User("user", name, password, email, mobileNo));
      System.out.println("You have successfully signed up. Go to the login page.....");
      System.out.println("======= Your user id is: " + user.getUserId() + " ========");
      }catch (Exception e){
          System.out.println("Some error occurred, Please enter valid data!");
      }
  }

  public static List<ScheduledFlight> checkAvailability() {
      try {
          System.out.println("Enter source: ");
          String source = sc.next();
          System.out.println("Enter destination: ");
          String destination = sc.next();
          System.out.println("Enter date (dd-mm-yyyy): ");
          String date = sc.next();
          while (true) {
              if (!isValidDate(date)) {
                  System.out.println("Please enter a valid date in the given format!");
                  date = sc.next();
              } else {
                  break;
              }
          }
          String[] dateArr = date.split("-");
          LocalDate new_date = LocalDate.of(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[0]));
          List<ScheduledFlight> list = scheduledFlightService.viewAllScheduledFlights(source, destination, new_date);
          if (!list.isEmpty())
              System.out.println(list);
          else
              System.out.println("No flights available");
          return list;
      }catch (Exception e){
          System.out.println("Some error occurred, Please enter valid data!");
          return null;
      }
  }

  public static void cancelBooking () {
      try {
          System.out.println("Please enter booking id: ");
          BigInteger bookingId = sc.nextBigInteger();
          flightBookingService.cancelBooking(bookingId);
          System.out.println("Booking cancelled");
      } catch (BookingNotFoundException e) {
          System.out.println("Booking not found!");
      }catch (Exception e){
          System.out.println("Some error occurred, Please enter valid data!");
      }
  }

  public static Booking makeBooking(User user) {
      try {
          List<Passenger> passengers_list = new ArrayList<>();
          List<ScheduledFlight> flight_list = checkAvailability();
          if (flight_list.isEmpty())
              return null;
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
          for (Passenger passenger : passengers_list) {
              passengerService.addPassenger(passenger);
          }
          Booking confirmedBooking = flightBookingService.addBooking(booking);
//    for(Passenger passenger: passengers_list){
//      passenger.setBooking(confirmedBooking);
//    }
          System.out.println("\n======Your booking is confirmed======\n");
          System.out.println(confirmedBooking);
          return confirmedBooking;
      }catch (Exception e){
          System.out.println("Some error occurred, Please enter valid data!");
          return null;
      }
  }

  public static Passenger getPassengerDetails(){
      Passenger psngr= new Passenger();
      System.out.println("Enter passenger name: ");
      sc.nextLine();
      psngr.setPassengerName(sc.nextLine());
      System.out.println("Enter passenger age: ");
      psngr.setAge(sc.nextInt());
      System.out.println("Enter passenger UIN: ");
      BigInteger uin= sc.nextBigInteger();
      while (true) {
          if(!isValidUIN(uin.toString())){
              System.out.println("Please enter a valid 12 digit user identification number!");
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

  public static  void addFlight() {
      try {
          System.out.println("Enter Flight Id");
          BigInteger flightId = sc.nextBigInteger();
          System.out.println("Enter Carrier Name");
          sc.nextLine();
          String carrierName = sc.nextLine();
          System.out.println("Enter Flight Model");
          String flightModel = sc.nextLine();
          System.out.println("Enter Seat Capacity");
          int seatCapacity = sc.nextInt();
          Flight flight = new Flight(flightId, carrierName, flightModel, seatCapacity);
          flightService.addFlight(flight);
          System.out.println(flight.toString());
          System.out.println("-----YOU HAVE SUCCESSFULLY ADDED FLIGHT DETAILS-----");
      }catch (Exception e){
          System.out.println("Some error occurred, Flight can not be added!");
      }
  }
  public static void modifyFlight()
  {
      System.out.println("Enter Flight Id of Flight to be modified: ");
      BigInteger flightId= sc.nextBigInteger();
      System.out.println("Enter new carrier name: ");
      sc.nextLine();
      String carrierName= sc.nextLine();
      try{
          Flight flight= flightService.updateFlight(flightId, carrierName);
          System.out.println("Flight has been successfully updated...");
          System.out.println(flight);
      }catch (FlightNotFoundException e){
          System.out.println("Flight not found!");
      }
  }

  public static void deleteFlight()
  {
      System.out.println("Enter Flight Id of Flight to be deleted");
      BigInteger flightId=sc.nextBigInteger();
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
          System.out.println("Enter Flight Id of flight to be searched: ");
          BigInteger flightId=sc.nextBigInteger();
          Flight flight=flightService.viewFlight(flightId);
          System.out.println(flight);
      }
      catch (FlightNotFoundException e) {
          System.out.println(e.getMessage());
      }catch (Exception e){
          System.out.println("Please Enter correct flight id!");
      }
  }

  public static void showFlight() {
      List<Flight> flightList=flightService.viewAllFlights();
      Iterator iterator= flightList.iterator();
      while (iterator.hasNext())
      {
          System.out.println(iterator.next());
      }
  }

  public static void addSchedule()
  {
      Flight flight;
      System.out.println("Enter Flight id");
      BigInteger flightId=sc.nextBigInteger();
      try {
          flight=flightService.viewFlight(flightId);

      } catch (FlightNotFoundException e) {
          flight= null;
          System.out.println(("Flight with the given flight id does not exist!"));
      }

      System.out.println("Enter no. of Available Seats");
      int availableSeats=sc.nextInt();

      System.out.println("Enter Fares of Flight");
      Double fares = sc.nextDouble();

      Schedule schedule= getScheduleDetails();

      ScheduledFlight scheduledFlight=
              new ScheduledFlight(flight,availableSeats,schedule,fares);

      scheduledFlightService.addFlightSchedule(scheduledFlight);

      System.out.println("--------FLIGHT SCHEDULE SUCCESSFULLY ADDED-----");
  }

    public static Airport getAirportDetails() {
        Airport airport;
        System.out.println("Enter Source Airport ID");
        int airportId = sc.nextInt();
        Airport new_airport = airportService.getAirport(airportId);
        if (new_airport != null) {
            airport = new_airport;
        } else{
            System.out.println("Enter Source Airport name");
            sc.nextLine();
            String airportName = sc.nextLine();

            System.out.println("Enter Source Airport Location");
            String airportLocation = sc.nextLine();

            airport = new Airport(airportId, airportName, airportLocation);
        }
        return airport;
    }

    public static Schedule getScheduleDetails(){
        Airport sourceAirport= getAirportDetails();
        airportService.addAirport(sourceAirport);
        Airport destinationAirport= getAirportDetails();
        airportService.addAirport(destinationAirport);
        System.out.println("Enter Arrival Time in format(YYYY-MM-DD-HH-MM)");
        String timeStamp1= sc.next();
        while (true) {
            if (!isValidTimeStamp(timeStamp1)) {
                System.out.println("Please enter a valid date-time format!");
                timeStamp1 = sc.next();
            } else {
                break;
            }
        }
        String[] arrivalTimeArr=timeStamp1.split("-");
        LocalDateTime arrivalTime = LocalDateTime.of(Integer
                .parseInt(arrivalTimeArr[0]),Integer.parseInt(arrivalTimeArr[1]),Integer.parseInt(arrivalTimeArr[2]),Integer.parseInt(arrivalTimeArr[3]),Integer.parseInt(arrivalTimeArr[4]));

        System.out.println("Enter Departure Time in Format(YYYY-MM-DD-HH-MM)");
        String timeStamp2= sc.next();
        while (true) {
            if (!isValidDate(timeStamp2)) {
                System.out.println("Please enter a valid date-time format!");
                timeStamp2 = sc.next();
            } else {
                break;
            }
        }
        String[] departureTimeArr= timeStamp2.split("-");
        LocalDateTime departureTime = LocalDateTime
                .of(Integer.parseInt(departureTimeArr[0]),Integer.parseInt(departureTimeArr[1]),Integer.parseInt(departureTimeArr[2]),Integer.parseInt(departureTimeArr[3]),Integer.parseInt(departureTimeArr[4]));

        System.out.println("Enter Arrival Date in Format(DD-MM-YYYY)");
        String date= sc.next();
        while (true) {
            if (!isValidDate(date)) {
                System.out.println("Please enter a valid date in the given format!");
                date = sc.next();
            } else {
                break;
            }
        }
        String[] arrivalDateArr= date.split("-");
        LocalDate arrivalDate = LocalDate
                .of(Integer.parseInt(arrivalDateArr[2]),Integer.parseInt(arrivalDateArr[1]),Integer.parseInt(arrivalDateArr[0]));

        return new Schedule(sourceAirport,destinationAirport,arrivalTime,departureTime,arrivalDate);

    }

  public static void modifySchedule() {
      System.out.println("Enter FlightId");
      BigInteger flightId=sc.nextBigInteger();
      System.out.println("Enter updated Available Seats ");
      int availableSeat=sc.nextInt();
      try {
          ScheduledFlight scheduledFlight = scheduledFlightService.viewFlightSchedule(flightId);
          scheduledFlightService.updateFlightSchedule(flightId, availableSeat);
      }
      catch(FlightNotFoundException e)
      {
          System.out.println("Flight not found!");
      }
      System.out.println("------SUCCESSFULLY UPDATED-----");
  }

  public static void deleteSchedule() {
      System.out.println("Enter Flight ID of the flight to be deleted");
      BigInteger flightId=sc.nextBigInteger();
      try {
          scheduledFlightService.removeFlightSchedule(flightId);
      }
      catch(FlightNotFoundException e)
      {
          System.out.println("Flight not found!");
      }
      System.out.println("-------FLIGHT SCHEDULE SUCCESSFULLY DELETED----");
  }

  public static void  searchSchedule()
  {
      System.out.println("Enter FlightID: ");
      BigInteger flightId=sc.nextBigInteger();
      try {
          System.out.println(scheduledFlightService.viewFlightSchedule(flightId));
      }
      catch(FlightNotFoundException e)
      {
          System.out.println("Flight not found!");
      }
  }

  public static void showSchedule()
  {
    System.out.println("Enter Date: ");
    String[] arrivalDateArr=sc.next().split("-");
    LocalDate arrivalDate = LocalDate.of(Integer.parseInt(arrivalDateArr[0]),Integer.parseInt(arrivalDateArr[1]),Integer.parseInt(arrivalDateArr[2]));
    try {
        List<ScheduledFlight> scheduledFlightList
                = scheduledFlightService.viewAllScheduledFlights(arrivalDate);
        Iterator<ScheduledFlight> itr1 = scheduledFlightList.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    } catch (FlightNotFoundException e)
      {
            System.out.println("No flight available for the given date!");
      }
  }

  public static boolean isValidDate(String date){
      String regex= "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](20)[2-9]\\d$";
      return date.matches(regex);
  }

    public static boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        return password.matches(regex);
    }

    public static boolean isValidMobile(String mobileNo){
        String regex= "^[0-9]{10}$";
        return mobileNo.matches(regex);
    }

    public static boolean isValidEmail(String email){
        String regex= "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return email.matches(regex);
    }

    public static boolean isValidUIN(String uin){
        String regex= "^[0-9]{12}$";
        return uin.matches(regex);
    }

    public static boolean isValidTimeStamp(String timeStamp){
      String regex= "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])"
        +"(2[0-3]|[01][0-9]):[0-5][0-9]$";
      return timeStamp.matches(regex);
    }
}

