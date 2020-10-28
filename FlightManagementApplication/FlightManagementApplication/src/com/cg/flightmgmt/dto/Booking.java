package com.cg.flightmgmt.dto;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This class stores the details of a booking
 * made by a particular userId.
 * Every booking stores a list of passengers travelling in it
 * as well as the flight details.
 */
@Entity
@Table(name= "booking")
//@SequenceGenerator(name = "seq", initialValue = 12000, allocationSize = 50)
public class Booking {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private BigInteger bookingId;
@ManyToOne
private User userId;
private LocalDate bookingDate;
@OneToMany(mappedBy = "booking")
private List<Passenger> passengerList= new ArrayList<Passenger>();
private double ticketCost;
@OneToOne
private Flight flight;
private int noOfPassengers;
	public Booking() {
	}

	public Booking(User userId, LocalDate bookingDate,
			List<Passenger> passengerList, double ticketCost, Flight flight, int noOfPassengers) {
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}

    public Booking(BigInteger bigInteger, User user, LocalDate date, List<Passenger> passengers, double v, Flight flight, int i) {
    }

    public BigInteger getBookingId() {
	return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Booking booking = (Booking) o;
		return Double.compare(booking.ticketCost, ticketCost) == 0 &&
				noOfPassengers == booking.noOfPassengers &&
				bookingId.equals(booking.bookingId) &&
				userId.equals(booking.userId) &&
				bookingDate.equals(booking.bookingDate) &&
				passengerList.equals(booking.passengerList) &&
				flight.equals(booking.flight);
	}

	@Override
	public int hashCode() {
		return Objects
				.hash(bookingId,  bookingDate, passengerList, ticketCost, flight, noOfPassengers);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"bookingId=" + bookingId +
				"userId=" + userId +
				", bookingDate=" + bookingDate +
				", passengerList=" + passengerList +
				", ticketCost=" + ticketCost +
				", flight=" + flight +
				", noOfPassengers=" + noOfPassengers +
				'}';
	}
}
