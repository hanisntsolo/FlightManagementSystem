package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(BigInteger flightId) throws FlightNotFoundException;
	public List<Flight> viewAllFlights();
	public Flight removeFlight(BigInteger flightId) throws FlightNotFoundException ;
	public Flight updateFlight(Flight flight);
}
