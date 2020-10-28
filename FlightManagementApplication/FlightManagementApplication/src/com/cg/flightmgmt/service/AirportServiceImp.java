package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.repository.AirportRepositoryImp;
import com.cg.flightmgmt.repository.IAirportRepository;

public class AirportServiceImp implements IAirportService{
    IAirportRepository airportRepository=new AirportRepositoryImp();
    @Override
    public Airport addAirport(Airport airport)
    {
        return airportRepository.addAirport(airport);
    }
}
