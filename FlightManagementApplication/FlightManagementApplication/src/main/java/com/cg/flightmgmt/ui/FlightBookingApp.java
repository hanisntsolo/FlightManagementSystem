package com.cg.flightmgmt.ui;
import java.util.Scanner;

public class FlightBookingApp {

  public static void main(String[] args) {
	  
	  Scanner sc= new Scanner(System.in);
	  System.out.println("WELCOME TO THE FLIGHT BOOKING APPLICATION");
	  System.out.println("-----------------------------------------------");
	  System.out.println("Login as:");
	  System.out.println("1. Admin");
	  System.out.println("2. User");
	  int logChoice= sc.nextInt();
	  
	  if(logChoice==1) {
		  while(true) {
		  System.out.println("1. Add Flights\n2. Modify Flights\n3. Delete Flight\n4. Search Flight\n5. Show Flights\n"
		  		+ "6. Add Schedule\n7. Modify Schedule\n8. Delete Schedule\n9. Search Schedule\n10. Show Schedule\n11. Exit");
		  int choice= sc.nextInt();
		  switch(choice) {
		  
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
			  case 11: System.out.println("Exiting.....");
				  	 System.exit(0);
				  	 break;
		  	  default: System.out.println("Choose from the given options.....");
			  	 
		  	}
		 } 
	  }else if(logChoice==2) {
		  while(true) {
			  System.out.println("1. Search Flights\n2. check availability\n3. Make Booking\n4. Cancel Booking\n5. Exit");
			  int choice= sc.nextInt();
			  switch(choice) {
			  
				  case 1:// search flights
					  	 break;
				  case 2:// check availability
					  	 break;
				  case 3:// Make Booking
					  	 break;
				  case 4:// Cancel Booking
					  	 break;
				  case 5:System.out.println("Exiting....."); 
					  	 System.exit(0);
					  	 break;
			  	  default: System.out.println("Choose from the given options.....");
				  	 
			  	}
		  }
	  }else {
		  System.out.println("Enter correct choice....");
	  }
	  
	  sc.close();
  }

}
