package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface IFlightRepository {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(BigInteger flightId) throws FlightNotFoundException;
	public List<Flight> viewAllFlights();
	public Flight removeFlight(BigInteger flightId) throws FlightNotFoundException;
	public Flight updateFlight(Flight flight);
}