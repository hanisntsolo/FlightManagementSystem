package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;

import com.cg.flightmgmt.exception.FlightNotFoundException;

import java.math.BigInteger;
import java.sql.Date;

import com.cg.flightmgmt.repository.IScheduledFlightRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepositoryImpl;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class ScheduledFlightServiceImpl implements IScheduledFlightService {

  IScheduledFlightRepository scheduledFlightRepository = new ScheduledFlightRepositoryImpl();

  @Override
  public Flight addFlightSchedule(Flight flight) {
    return scheduledFlightRepository.addFlightSchedule(flight);
  }

  @Override
  public ScheduledFlight viewFlightSchedule(BigInteger flightId) throws FlightNotFoundException {
    return scheduledFlightRepository.viewFlightSchedule(flightId);
  }

  @Override
  public ScheduledFlight removeFlightSchedule(BigInteger flightId) throws FlightNotFoundException {
    return scheduledFlightRepository.removeFlightSchedule(flightId);
  }

  @Override
  public ScheduledFlight updateFlightSchedule(BigInteger flightId,int availableSeat) {
    return scheduledFlightRepository.updateFlightSchedule(flightId,availableSeat);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date) {
    return scheduledFlightRepository.viewAllScheduledFlights(source, destination, date);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) throws FlightNotFoundException {
    return scheduledFlightRepository.viewAllScheduledFlights(arrivalDate);
  }

  @Override
  public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination) {
    return null;
  }

  @Override
  public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight) {
return scheduledFlightRepository.addFlightSchedule(scheduledFlight);
  }
}