package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

public interface IFlightBookingService {

	public Booking addBooking(Booking booking);
	public Booking cancelBooking(BigInteger bookingId) throws BookingNotFoundException;
	public Booking viewBooking(BigInteger bookingId) throws BookingNotFoundException;
	public List<Booking> viewBookingList(Date bookingDate);
	public List<Booking> viewBookingList(BigInteger flightId);
	public List<Booking> viewBookingHistory(BigInteger userId);
	public Booking updateBooking(Booking booking);
}
