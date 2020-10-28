package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface IScheduledFlightRepository {
	
	public Flight addFlightSchedule(Flight flight);

	public ScheduledFlight viewFlightSchedule(BigInteger flightId) throws FlightNotFoundException;
	public ScheduledFlight removeFlightSchedule(BigInteger flightId) throws FlightNotFoundException;
	public ScheduledFlight updateFlightSchedule(BigInteger flightId,int availableSeats);
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) throws FlightNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDate date1, LocalDate date2);
	public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date);
	public ScheduledFlight addFlightSchedule(ScheduledFlight flight);

}
