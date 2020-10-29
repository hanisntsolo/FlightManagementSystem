package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.FlightBookingRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightBookingRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FlightBookingServiceImpl implements IFlightBookingService {
      IFlightBookingRepository flightBookingRepository= new FlightBookingRepositoryImpl();
  @Override
  public Booking addBooking(Booking booking) {
    return flightBookingRepository.addBooking(booking);
  }

  @Override
  public Booking cancelBooking(BigInteger bookingId) throws BookingNotFoundException {
    return flightBookingRepository.cancelBooking(bookingId);
  }

  @Override
  public Booking viewBooking(BigInteger bookingId) throws BookingNotFoundException {
    return flightBookingRepository.viewBooking(bookingId);
  }

  @Override
  public List<Booking> viewBookingList(Date bookingDate) {

    return flightBookingRepository.viewBookingList(bookingDate);
  }

  @Override
  public List<Booking> viewBookingList(BigInteger flightId) {

    return flightBookingRepository.viewBookingList(flightId);
  }

  @Override
  public List<Booking> viewBookingHistory(BigInteger userId) {

    return flightBookingRepository.viewBookingHistory(userId);
  }

  @Override
  public Booking updateBooking(Booking booking) {

    return flightBookingRepository.updateBooking(booking);
  }
}
