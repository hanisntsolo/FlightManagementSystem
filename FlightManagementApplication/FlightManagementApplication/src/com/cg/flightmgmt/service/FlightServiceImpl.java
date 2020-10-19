package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import java.math.BigInteger;
import java.util.Set;

public class FlightServiceImpl implements IFlightService {

  @Override
  public Flight addFlight(Flight flight) {
    return null;
  }

  @Override
  public Flight viewFlight(BigInteger flightNo) throws FlightNotFoundException {
    return null;
  }

  @Override
  public Set<Flight> viewAllFlights() {
    return null;
  }

  @Override
  public Flight removeFlight(BigInteger flightNo) {
    return null;
  }

  @Override
  public Flight updateFlight(Flight flight) {
    return null;
  }
}
