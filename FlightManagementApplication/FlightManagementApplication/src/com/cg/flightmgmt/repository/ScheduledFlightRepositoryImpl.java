package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

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
    public ScheduledFlight addFlightSchedule(ScheduledFlight sFlight)
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(sFlight);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return sFlight;
    }
    @Override
    public ScheduledFlight viewFlightSchedule(BigInteger flightId) throws FlightNotFoundException
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        ScheduledFlight flight= em.find(ScheduledFlight.class, flightId);
        em.getTransaction().commit();
        if(flight!=null) {
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
    public ScheduledFlight removeFlightSchedule(BigInteger flightId) throws FlightNotFoundException
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        ScheduledFlight flight= em.find(ScheduledFlight.class, flightId);
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
    public ScheduledFlight updateFlightSchedule(BigInteger flightId,int availableSeats)
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
       em.createQuery("UPDATE ScheduledFlight  SET availableSeats = :availableSeats ").setParameter("availableSeats",availableSeats).executeUpdate();
        em.getTransaction().commit();
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

        List<ScheduledFlight> flightList=  em.createQuery("select sf from ScheduledFlight sf", ScheduledFlight.class).getResultList();
        em.getTransaction().commit();
        em.close();
        factory.close();
        return flightList;
    }
    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) throws FlightNotFoundException
    {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        List<ScheduledFlight> flightList=
                em.createQuery("select f from ScheduledFlight f where f.schedule.arrivalDate = :arrivalDate",
                ScheduledFlight.class)
                .setParameter("arrivalDate", arrivalDate).getResultList();
        if(flightList.isEmpty()){
            em.close();
            throw new FlightNotFoundException("Flight not found!");
        }else{
            em.close();
            factory.close();
            return flightList;
        }
    }

    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(LocalDate date1,LocalDate date2) {

        /*EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<ScheduledFlight> flightList = em.createQuery(
            "select f from ScheduledFlight f where f.schedule.arrivalDate between :date1 and :date2",
            ScheduledFlight.class)
                .setParameter("date1",date1)
                .setParameter("date2", date2).getResultList();
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
        return em.createQuery("SELECT f " + "FROM ScheduledFlight f "
                + "WHERE LOWER(f.schedule.sourceAirport.airportLocation) = :source "
                + "and LOWER(f.schedule.destinationAirport.airportLocation) = :destination " +
                "AND f.schedule.arrivalDate= :date", ScheduledFlight.class)
                .setParameter("source", source.toLowerCase())
                .setParameter("destination", destination.toLowerCase())
                .setParameter("date", date)
                .getResultList();
    }

}
