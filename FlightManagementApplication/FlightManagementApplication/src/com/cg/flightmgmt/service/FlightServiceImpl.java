package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightBookingRepositoryImpl;
import com.cg.flightmgmt.repository.FlightRepositoryImpl;
import com.cg.flightmgmt.repository.IFlightRepository;

import java.math.BigInteger;
import java.util.List;

public class FlightServiceImpl implements IFlightService {
  IFlightRepository Flight=new FlightRepositoryImpl();

  @Override
  public Flight addFlight(Flight flight) {

    return Flight.addFlight(flight);
  }

  @Override
  public Flight viewFlight(BigInteger flightNo) throws FlightNotFoundException {
    return Flight.viewFlight(flightNo);
  }

  @Override
  public List<Flight> viewAllFlights() {
    return Flight.viewAllFlights();
  }

  @Override
  public Flight removeFlight(BigInteger flightId) throws FlightNotFoundException {

    return Flight.removeFlight(flightId);
  }

  @Override
  public Flight updateFlight(Flight flight) {

    return Flight.updateFlight(flight);
  }
}
