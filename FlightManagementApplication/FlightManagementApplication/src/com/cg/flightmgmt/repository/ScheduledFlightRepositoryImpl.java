package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
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
        em.getTransaction().commit();
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
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flight;
    }
    @Override
    public Flight updateFlightSchedule(ScheduledFlight flight)
    {
       /* EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
       em.createQuery("UPDATE ScheduledFlight SET availableSeats = :flight.availableSeats,Schedule = :flight.schedule").executeUpdate();
        em.getTransaction().commit();
        em.close();
        factory.close();*/
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
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flightList;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<ScheduledFlight> flightList= em.createQuery("select f from ScheduledFlight f where f.schedule.arrivalDate = :arrivalDate",
                ScheduledFlight.class).setParameter("arrivalDate", arrivalDate).getResultList();
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flightList;
    }

    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(LocalDate date1,LocalDate date2)
    {
        /*EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<ScheduledFlight> flightList= em.createQuery("select f from ScheduledFlight f where f.schedule.arrivalDate between :date1 and :date2",
                ScheduledFlight.class).getResultList();
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flightList;*/
        return null;
    }

    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(String source, String destination, LocalDate date){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        return em.createQuery("select f " + "from ScheduledFlight f " + "where f.schedule.sourceAirport.airportLocation= :source "
                + "and f.schedule.destinationAirport.airportLocation= :destination and f.schedule.arrivalDate= :date")
                .getResultList();
    }

}
