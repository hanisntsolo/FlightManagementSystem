package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface IScheduledFlightService {
	
	public Flight addFlightSchedule(Flight flight);
	public Flight viewFlightSchedule(BigInteger flightId);
	public Flight removeFlightSchedule(BigInteger flightId);
	public Flight updateFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date);
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate);
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination);

}
