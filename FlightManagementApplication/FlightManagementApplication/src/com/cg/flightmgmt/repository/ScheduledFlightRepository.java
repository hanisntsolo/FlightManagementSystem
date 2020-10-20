package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;

public class ScheduledFlightRepository implements IScheduledFlightRepository {
    @Override
    public Flight addFlightSchedule(Flight flight)
    {
        return null;
    }
    @Override
    public Flight viewFlightSchedule(BigInteger flightNo)
    {
        return null;
    }
    @Override
    public Flight removeFlightSchedule(BigInteger flightNo)
    {
        return null;
    }
    @Override
    public Flight updateFlightSchedule(ScheduledFlight flight)
    {
        return null;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights()
    {
        return null;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(Date arrivalDate)
    {
        return null;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2)
    {
        return null;
    }
}
