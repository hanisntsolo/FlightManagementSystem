package com.cg.flightmgmt.repository;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class FlightRepositoryImpl implements IFlightRepository {
   @Override
    public Flight addFlight(Flight flight)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(flight);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flight;
    }
    @Override
    public Flight viewFlight(BigInteger flightId) throws FlightNotFoundException
    {

           EntityManagerFactory factory = Persistence
                   .createEntityManagerFactory("NewPersistenceUnit");
           EntityManager em = factory.createEntityManager();
           em.getTransaction().begin();
           Flight flight = em.find(Flight.class, flightId);
        em.getTransaction().commit();
            if (flight != null) {
                em.close();
                factory.close();

                return flight;
            }
             else {
                throw new FlightNotFoundException("Flight not found");
            }



    }
    @Override
    public List<Flight> viewAllFlights()
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        List<Flight> flightSet=  em.createQuery("select f from Flight f", Flight.class).getResultList();
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flightSet;
    }
@Override
    public Flight removeFlight(BigInteger flightId) throws FlightNotFoundException
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Flight flight= em.find(Flight.class, flightId);
        if(flight!=null) {
            em.remove(flight);
            em.getTransaction().commit();
            em.close();
            factory.close();
            return flight;
        }
        else
        {
            throw new FlightNotFoundException("Flight Not Found");
        }
    }
    @Override
    public Flight updateFlight(Flight flight)
    {
        //EntityManagerFactory factory = Persistence
        //        .createEntityManagerFactory("NewPersistenceUnit");
      //  EntityManager em = factory.createEntityManager();
       // em.getTransaction().begin();
     //   em.createQuery("UPDATE Flight SET seatCapacity = :flight.seatCapacity").executeUpdate();
      //  em.getTransaction().commit();
      //  em.close();
      //  factory.close();
       return null;
    }

}
