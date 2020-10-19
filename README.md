# FlightManagementSystem__
The Flight Management System is a Java-based booking solution for flight tickets. It consolidates data provided by different airline carriers and hence provides the user details and rates in real-time. Travellers may want to make changes in their bookings. The application allows them to book, cancel, view and update their bookings with ease. Other than this, it eases the management of bookings too. All the bookings, flights, schedules and routes can be viewed, added and modified on a single application by the administrator.__

Scopes  
	Inscope:  
	Following is the functionality provided by the system:  
	There are two categories of people who would access the system: customer and  
	administrator. Each of these would have some exclusive privileges.  
		1. The customer can:  
		a. Create his user account.  
		b. Login into the application.  
		c. Check for available flights.  
		d. Make a booking.  
		e. View the bookings made.  
		f. Cancel or modify a booking.  
		2. The administrator can:  
		a. Login into the application.  
		b. Add flight, schedule and route details.  
		c. View the flight, schedule and route details.  
		d. Cancel or modify the flight, schedule and route details.  

Outscope:  
The following functionalities have not been covered under the application:  
      1. The application does not cover boarding pass generation and seating plans.  
      2. Third party applications like email & sms integrations.  
      3. Payments are not yet accepted by the application.  


Class and Method Description:  
DTO Layer:  
1. User : This class stores the user type (admin or the customer) and all user  
information.  
 Attributes :  
        userType: String.  
        userId: BigInteger  
        userName: String  
        userPassword: Password  
        userPhone:BigInteger  
        userEmail: String  
Methods : -__
2. Passenger : This class stores all the details of the travelling passenger.__
 Attributes :__
        pnrNumber: BigInteger__
        passengerName: String__
        passengerAge: Integer__
        passengerUIN: BigInteger__
        Luggage: Double__
Methods : -__
3. Booking : This class stores the details of a booking made by a particular userId. Every__
booking stores a list of passengers travelling in it as well as the flight details.__
 Attributes :__
        bookingId: BigInteger__
        userId: User__
        bookingDate: Date__
        passengerList: List<Passenger>__
        ticketCost: BigDouble__
        flight: Flight__
        noOfPassengers: Integer__
Methods : -__
4. ScheduledFlight : This class stores a flight that is scheduled along with its schedule__
and the vacancy.__
  Attributes :__
        flight: Flight__
        availableSeats: Integer__
        schedule: Schedule__
        Methods : -__
5. Flight : This class stores all the details of a flight.__
  Attributes :__
        flightNumber: BigInteger__
        flightModel: String__
        carrierName: String__
        seatCapacity: Integer__
        Methods : -__
6. Schedule : This class stores a flight schedule.__
  Attributes :__
        sourceAirport: Airport__
        destinationAirport: Airport__
        arrivalTime: DateTime__
        departureTime: DateTime__
        Methods : -__
7. Airport : This class stores the details of an airport.__
  Attributes :__
        airportName: String__
        airportCode: String__
        airportLocation: String__
        Methods : -__
=========================================================================Service Layer:=======================================================================================__
8. UserServiceImpl :__
  Attributes : -__
        Methods:__
          addUser(User):User :-__
          Adds a new user.__
          viewUser(BigInteger):User :-__
          Shows the details of a user identifiable by the user id.__
          viewUser(): List<User> :-__
          Shows the details of all users.__
          updateUser(User):User :-__
          Updates the details of a user.__
          deleteUser(BigInteger):void__
          Removes a user as per the user id.__
          validateUser(User): void :-__
          Validates the attributes of a user.__
9. BookingServiceImpl:__
  Attributes : -__
        Methods:__
          addBooking(Booking):Booking :- Creates a new booking.__
          modifyBooking(Booking): Booking :- Modifies a previous booking. All__
          information related to the booking except the booking id can be__
          modified.__
          viewBooking(BigInteger): List<Booking> :- Retrieves a booking made__
          by the user based on the booking id.__
          viewBooking(): List<Booking> :- Retrieves a list of all the bookings__
          made.__
          deleteBooking(BigInteger): void :-__
          Deletes a previous booking identifiable by the ‘bookingId’.__
          validateBooking(Booking): void :-__
          Validates the attributes of a booking.__
          validatePassenger(Passenger): void :-__
          Validates the attributes of a passenger.__
10. FlightServiceImpl:__
  Attributes : -__
        Methods:__
          addFlight(Flight): Flight :-__
          Adds a new flight which can be scheduled.__
          modifyFlight(Flight): Flight :-__
          Modify the details of a flight.__
          viewFlight(BigInteger): Flight :-__
          Shows the details of a flight specified by the flight number.__
          viewFlight(): List<Flight> :-__
          View the details of all flights.__
          deleteFlight(BigInteger): void :-__
          Removes a flight.__
          validateFlight(Flight): void :-__
          Validates the attributes of a flight.__
11. ScheduleFlightServicesImpl:__
  Attributes : -__
        Methods:__
          scheduleFlight(ScheduledFlight): ScheduledFlight :-__
          Schedules a flight alongwith its timings, locations and capacity__
          viewScheduledFlights(Airport, Airport, LocalDate): List<Scheduled__
          Flight> :-__
          Returns a list of flights between two airports on a specified date.__
          viewScheduledFlights(BigInteger):Flight :-__
          Returns a list of a scheduled flight identifiable by flight number.__
          viewScheduledFlight(): List<ScheduledFlight> :-__
          Shows all the details and status of all flights.__
          modifyScheduledFlight(Flight,Schedule, Integer): ScheduledFlight :-__
          Modifies the details of a scheduled flight.__
          deleteScheduledFlight(BigInteger): void :-__
          Removes a flight from the available flights.__
          validateScheduledFlight(ScheduledFlight): void :-__
          Validates the attributes of a scheduled Flight.__
12. AirportServiceImpl:__
  Attributes : -__
        Methods :__
          viewAirport(): List<Airport> :-__
          Returns the list of all airports.__
          viewAirport(String): Airport :-__
          Returns the details of an airport identifiable by the airport code.__
 ============================================================================DAO Layer:=====================================================================================__
13. UserDaoImpl:__
  Attributes:__
          userList: List<User>__
        Methods:__
          addUser(User):User :-__
          Adds a new user.__
          viewUser(BigInteger):User :-__
          Shows the details of a user identifiable by the user id.__
          viewUser(): List<User> :-__
          Shows the details of all users.__
          updateUser(User):User :-__
          Updates the details of a user.__
          deleteUser(BigInteger):void__
          Removes a user as per the user id.__
14. BookingDaoImpl:__
  Attributes:__
          bookingList: List<Booking>__
        Methods:__
          addBooking(Booking):Booking :- Creates a new booking.__
          modifyBooking(Booking): Booking :- Modifies a previous booking. All__
          information related to the booking except the booking id can be__
          modified.__
          viewBooking(BigInteger): List<Booking> :- Retrieves a booking made__
          by the user based on the booking id.__
          viewBooking(): List<Booking> :- Retrieves a list of all the bookings__
          made.__
          deleteBooking(BigInteger): void :-__
          Deletes a previous booking identifiable by the ‘bookingId’.__
15. FlightDaoImpl:__
  Attributes:__
          flightList: List<Flight>__
        Methods:__
          addFlight(Flight): Flight :-__
          Adds a new flight which can be scheduled.__
          modifyFlight(Flight): Flight :-__
          Modify the details of a flight.__
          viewFlight(BigInteger): Flight :-__
          Shows the details of a flight specified by the flight number.__
          viewFlight(): List<Flight> :-__
          View the details of all flights.__
          deleteFlight(BigInteger): void :-__
          Removes a flight.__
16. ScheduledFlightDaoImpl:__
  Attributes:__
          scheduledFlightList: List<ScheduledFlight>__
        Methods:__
          scheduleFlight(ScheduledFlight): ScheduledFlight :-__
          Schedules a flight alongwith its timings, locations and capacity__
          viewScheduledFlights(Airport, Airport, LocalDate): List<Scheduled__
          Flight> :-__
          Returns a list of flights between two airports on a specified date.__
          viewScheduledFlights(BigInteger):Flight :-__
          Returns a list of a scheduled flight identifiable by flight number.__
          viewScheduledFlight(): List<ScheduledFlight> :-__
          Shows all the details and status of all flights.__
          modifyScheduledFlight(Flight,Schedule,int): ScheduledFlight :-__
          Modifies the details of a scheduled flight.__
          deleteScheduledFlight(BigInteger): void :-__
          Removes a flight from the available flights.__
17. AirportDaoImpl:__
  Attributes:__
          airportList: List<Airport>__
        Methods:__
          viewAirport(): List<Airport> :-__
          Returns the list of all airports.__
          viewAirport(String): Airport :-__
          Returns the details of an airport identifiable by the airport code.__
  
 ==============================================================================Validations:====================================================================================__
1. The ‘userPhone’ should have an exact 10 digit number and the number should not__
start with zero.__
2. Date and Time should be valid i.e date and time that has already elapsed shouldn’t be__
entered__
3. ‘noOfPassenger’ should always be less than equal to that of available seats.__
4. The local part of the email should contain alphanumeric characters only. No special__
characters are to be present as the first character of the id.__
5. The chosen airport’s name should be present inside the Airport database.__
6. The Unique Identification Number should be of 12 digits.__
===============================================================================Assumptions:====================================================================================__
However, we have made a few assumptions with respect to the application, which are:__
1. Administrator and customer are both Users. They are differentiated by a variable__
‘userType’ in the User class.__
2. Every passenger needs to enter a Unique Identification Number while booking is__
being made. For simplicity, we assume it to be a 12-digit Aadhaar Number.__
3. All flights are direct flights.__
4. No flight gets cancelled.__
5. Number of airports is fixed and stored in database.__
6. All the flights are considered to be domestic.__

