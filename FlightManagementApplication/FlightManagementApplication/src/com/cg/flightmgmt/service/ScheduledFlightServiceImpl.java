package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepositoryImpl;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScheduledFlightServiceImpl implements IScheduledFlightService {

  IScheduledFlightRepository scheduledFlightRepository=new ScheduledFlightRepositoryImpl();

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
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date) {
    return scheduledFlightRepository.viewAllScheduledFlights(source, destination, date);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) {
	  return scheduledFlightRepository.viewAllScheduledFlights(arrivalDate);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination) {
    return null;
  }
}
