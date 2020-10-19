package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FlightBookingServiceImpl implements IFlightBookingService {

  @Override
  public Booking addBooking(Booking booking) {
    return null;
  }

  @Override
  public Booking cancelBooking(BigInteger bookingid) throws BookingNotFoundException {
    return null;
  }

  @Override
  public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
    return null;
  }

  @Override
  public List<Booking> viewBookingList(Date bookingdate) {
    return null;
  }

  @Override
  public List<Booking> viewBookingList(BigInteger flightid) {
    return null;
  }

  @Override
  public List<Booking> viewBookingHistory(BigInteger userid) {
    return null;
  }

  @Override
  public Booking updateBooking(Booking booking) {
    return null;
  }
}
