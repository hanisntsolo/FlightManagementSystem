package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import org.apache.maven.lifecycle.Schedule;

public interface IScheduledFlightService {
	
	public Flight addFlightSchedule(Flight flight);
	public ScheduledFlight viewFlightSchedule(BigInteger flightId) throws FlightNotFoundException;
	public ScheduledFlight removeFlightSchedule(BigInteger flightId) throws FlightNotFoundException;
	public ScheduledFlight updateFlightSchedule(BigInteger flightId,int availableSeats);
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date);
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) throws FlightNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination);
	public ScheduledFlight addFlightSchedule(ScheduledFlight sFlight);
}
