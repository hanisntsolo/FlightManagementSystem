package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ScheduledFlightServiceImpl implements IScheduledFlightService {
  ScheduledFlightServiceImpl scheduledFlightRepository=new ScheduledFlightServiceImpl();

  @Override
  public Flight addFlightSchedule(Flight flight) {
    return scheduledFlightRepository.addFlightSchedule(flight);
  }

  @Override
  public Flight viewFlightSchedule(BigInteger flightId) {
    return scheduledFlightRepository.viewFlightSchedule(flightId);
  }

  @Override
  public Flight removeFlightSchedule(BigInteger flightId) {
    return scheduledFlightRepository.removeFlightSchedule(flightId);
  }

  @Override
  public Flight updateFlightSchedule(ScheduledFlight flight) {
    return scheduledFlightRepository.updateFlightSchedule(flight);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights() {
	  List<ScheduledFlight> list=new ArrayList<ScheduledFlight>();
	   return scheduledFlightRepository.viewAllScheduledFlights();

  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(Date arrivalDate) {
	  List<ScheduledFlight> list1=new ArrayList<ScheduledFlight>();
	  return scheduledFlightRepository.viewAllScheduledFlights();

  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination) {
    return null;
  }
}
