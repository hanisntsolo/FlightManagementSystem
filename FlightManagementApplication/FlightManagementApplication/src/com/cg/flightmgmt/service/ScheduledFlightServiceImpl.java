package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

public class ScheduledFlightServiceImpl implements IScheduledFlightService {
	ScheduledFlightRepository scheduledFlightRepository=new ScheduledFlightRepository();

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
	  List<ScheduledFlight> list=new ArrayList<ScheduledFlight>();Flight
	  list=scheduledFlightRepository.viewAllScheduledFlights();
    return list;
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(Date arrivalDate) {
	  List<ScheduledFlight> list1=new ArrayList<ScheduledFlight>();
	  list1=scheduledFlightRepository.viewAllScheduledFlights();
    return list1;
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination) {
    return null;
  }
}
