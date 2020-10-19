package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

public class ScheduledFlightServiceImpl implements IScheduledFlightService {

  @Override
  public Flight addFlightSchedule(Flight flight) {
    return null;
  }

  @Override
  public Flight viewFlightSchedule(BigInteger flightno) {
    return null;
  }

  @Override
  public Flight removeFlightSchedule(BigInteger flightno) {
    return null;
  }

  @Override
  public Flight updateFlightSchedule(ScheduledFlight flight) {
    return null;
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights() {
    return null;
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(Date arrivaldate) {
    return null;
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(Date date1, Date date2) {
    return null;
  }
}
