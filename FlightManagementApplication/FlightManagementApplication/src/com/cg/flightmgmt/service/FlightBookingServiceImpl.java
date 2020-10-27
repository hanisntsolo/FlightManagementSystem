package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.FlightBookingRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightBookingRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FlightBookingServiceImpl implements IFlightBookingService {
      IFlightBookingRepository FlightBookingRepository= new FlightBookingRepositoryImpl();
  @Override
  public Booking addBooking(Booking booking) {
    return FlightBookingRepository.addBooking(booking);
  }

  @Override
  public Booking cancelBooking(BigInteger bookingId) throws BookingNotFoundException {
    return FlightBookingRepository.cancelBooking(bookingId);
  }

  @Override
  public Booking viewBooking(BigInteger bookingId) throws BookingNotFoundException {
    return FlightBookingRepository.viewBooking(bookingId);
  }

  @Override
  public List<Booking> viewBookingList(Date bookingDate) {

    return FlightBookingRepository.viewBookingList(bookingDate);
  }

  @Override
  public List<Booking> viewBookingList(BigInteger flightId) {

    return FlightBookingRepository.viewBookingList(flightId);
  }

  @Override
  public List<Booking> viewBookingHistory(BigInteger userId) {

    return FlightBookingRepository.viewBookingHistory(userId);
  }

  @Override
  public Booking updateBooking(Booking booking) {

    return FlightBookingRepository.updateBooking(booking);
  }
}
