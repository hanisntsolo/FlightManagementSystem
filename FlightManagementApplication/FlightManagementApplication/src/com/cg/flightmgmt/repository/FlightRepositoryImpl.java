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
    public Flight addFlight(Flight flight) throws Exception
    {
        entityManager = jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flight);
        entityManager.getTransaction().commit();
        entityManager
            .close();
        return flight;
    }

    @Override
    public Flight viewFlight(BigInteger flightId) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        Flight flight = entityManager.find(Flight.class, flightId);
        if(flight==null){
            entityManager.close();
            throw new FlightNotFoundException("Flight not found!");
        }else {
            entityManager.close();
            return flight;
        }
    }

    @Override
    public List<Flight> viewAllFlights()
    {
        entityManager = jpaUtil.getEntityManager();
        List<Flight> flightList=
                entityManager.createQuery("select f from Flight f", Flight.class)
                        .getResultList();
        entityManager.close();
        return flightList;
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
    public Flight updateFlight(BigInteger flightId, String carrierName) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        Flight flight= entityManager.find(Flight.class, flightId);
        if(flight!=null) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("UPDATE Flight SET carrierName = :carrierName"
                    + " where flightId= :flightId")
                    .setParameter("carrierName", carrierName)
                    .setParameter("flightId", flightId)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            Flight flight1 = entityManager.find(Flight.class,flightId);
            entityManager.close();
            return flight1;
        }else{
            entityManager.close();
            throw new FlightNotFoundException("Flight not found!");
        }
    }
}
