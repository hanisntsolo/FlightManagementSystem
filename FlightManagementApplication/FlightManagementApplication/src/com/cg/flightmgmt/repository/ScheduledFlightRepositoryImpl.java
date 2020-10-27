package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ScheduledFlightRepositoryImpl implements IScheduledFlightRepository {
    @Override
    public Flight addFlightSchedule(Flight flight)
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
    public Flight viewFlightSchedule(BigInteger flightId)
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Flight flight= em.find(Flight.class, flightId);
        em.close();
        factory.close();
            return flight;
    }
    @Override
    public Flight removeFlightSchedule(BigInteger flightId)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Flight flight= em.find(Flight.class, flightId);
        em.remove(flight);
        em.close();
        factory.close();
        return flight;
    }
    @Override
    public Flight updateFlightSchedule(ScheduledFlight flight)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
       em.createQuery("UPDATE ScheduledFlight SET availableSeats = :flight.availableSeats,Schedule = :flight.schedule").executeUpdate();
        em.close();
        factory.close();
        return null;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights()
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        List<ScheduledFlight> flightList=  em.createQuery("select * from ScheduledFlight", ScheduledFlight.class).getResultList();
        em.close();
        factory.close();
        return flightList;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(Date arrivalDate)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<ScheduledFlight> flightList= em.createQuery("select f from ScheduledFlights f where f.arrivalDate = :arrivalDate",
                ScheduledFlight.class).setParameter("arrivalDate", arrivalDate).getResultList();
        em.close();
        factory.close();
        return flightList;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2)
    {


        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<ScheduledFlight> flightList= em.createQuery("select f from ScheduledFlights f where f.arrivalDate between :date1 and :date2",
                ScheduledFlight.class).getResultList();
        em.close();
        factory.close();
        return flightList;

    }
}
