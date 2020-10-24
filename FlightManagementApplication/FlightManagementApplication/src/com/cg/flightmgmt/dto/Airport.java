package com.cg.flightmgmt.dto;

import java.util.Objects;

/**
 * This class stores the details of an airport.
 * Class having primary data field like,
 * airportID
 * airportName
 * airportLocation
 * The main functionality of the airport class is to introduce class parameters
 * and contain methods so that userdata can be fetched on method call.
 */
public class Airport {
	private int airportId;
	private String airportName;
	private String airportLocation;

	public Airport() {
	}

	public Airport(int airportId, String airportName, String airportLocation) {
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Airport airport = (Airport) o;
		return airportId == airport.airportId &&
				airportName.equals(airport.airportName) &&
				airportLocation.equals(airport.airportLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airportId, airportName, airportLocation);
	}

	@Override
	public String toString() {
		return "Airport{" +
				"airportId=" + airportId +
				", airportName='" + airportName + '\'' +
				", airportLocation='" + airportLocation + '\'' +
				'}';
	}
}
