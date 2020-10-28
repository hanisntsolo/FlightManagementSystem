package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.repository.IPassengerRepository;
import com.cg.flightmgmt.repository.PassengerRepositoryImpl;

public class PassengerServiceImpl implements IPassengerService{
    IPassengerRepository passengerRepository= new PassengerRepositoryImpl();

    @Override
    public Passenger addPassenger(Passenger passenger){
        return passengerRepository.addPassenger(passenger);
    }
}
