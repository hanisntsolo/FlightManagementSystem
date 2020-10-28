package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface IScheduledFlightRepository {
	
	public Flight addFlightSchedule(Flight flight);
	public Flight viewFlightSchedule(BigInteger flightId);
	public Flight removeFlightSchedule(BigInteger flightId);
	public Flight updateFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate);
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate date1, LocalDate date2);
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date);

}
