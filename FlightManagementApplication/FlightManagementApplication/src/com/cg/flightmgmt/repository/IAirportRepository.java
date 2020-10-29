package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Airport;


public interface IAirportRepository {
    public Airport addAirport(Airport airport);
    public Airport getAirport(int airportId);
}
