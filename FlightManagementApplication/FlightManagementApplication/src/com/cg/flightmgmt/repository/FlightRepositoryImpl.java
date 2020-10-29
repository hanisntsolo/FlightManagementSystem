package com.cg.flightmgmt.repository;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class FlightRepositoryImpl implements IFlightRepository {
    EntityManager entityManager;
    JPAUtil jpaUtil = new JPAUtil();

    @Override
    public Flight addFlight(Flight flight)
    {
        entityManager = jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flight);
        entityManager.getTransaction().commit();
//        factory.close();
        return flight;
    }
    @Override
    public Flight viewFlight(BigInteger flightId) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flightId);
        entityManager.getTransaction().commit();
        Flight flight = entityManager.find(Flight.class, flightId);
        if(flight==null){
            throw new FlightNotFoundException("Flight not found!");
        }else {
            return flight;
        }


    }
    @Override
    public List<Flight> viewAllFlights()
    {
        entityManager = jpaUtil.getEntityManager();
//        entityManager.getTransaction().begin();
        List<Flight> flightSet=  entityManager.createQuery("select f from Flight f", Flight.class).getResultList();
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        fact.close();
        return flightSet;
    }
    @Override
    public Flight removeFlight(BigInteger flightId) throws FlightNotFoundException{
        entityManager= jpaUtil.getEntityManager();
        Flight flight= entityManager.find(Flight.class, flightId);
        if(flight==null){
            entityManager.close();
            throw new FlightNotFoundException("Flight not found!");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.remove(flight);
            entityManager.getTransaction().commit();
            entityManager.close();
            return flight;
        }
    }

    @Override
    public Flight updateFlight(Flight flight)
    {
        entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Flight SET seatCapacity = :seatCapacity")
                .setParameter("seatCapacity", flight.getSeatCapacity()).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return flight;
    }
}
