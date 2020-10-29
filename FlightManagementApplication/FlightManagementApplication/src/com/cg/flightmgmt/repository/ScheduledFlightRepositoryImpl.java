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
import com.cg.flightmgmt.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ScheduledFlightRepositoryImpl implements IScheduledFlightRepository {
    JPAUtil jpaUtil= new JPAUtil();
    EntityManager entityManager;

    @Override
    public Flight addFlightSchedule(Flight flight)
    {
        entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
        return flight;
    }

    @Override
    public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight)
    {
        entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(scheduledFlight);
        entityManager.getTransaction().commit();
        entityManager.close();
        return scheduledFlight;
    }

    @Override
    public ScheduledFlight viewFlightSchedule(BigInteger flightId) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        ScheduledFlight flight= entityManager.find(ScheduledFlight.class, flightId);
        if(flight!=null) {
            entityManager.close();
            return flight;
        } else
        {
            entityManager.close();
            throw new FlightNotFoundException("Flight Not Found");
        }
    }

    @Override
    public ScheduledFlight removeFlightSchedule(BigInteger flightId) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        ScheduledFlight flight= entityManager.find(ScheduledFlight.class, flightId);
        if(flight!=null) {
            entityManager.getTransaction().begin();
            entityManager.remove(flight);
            entityManager.getTransaction().commit();
            entityManager.close();
            return flight;
        }
        else
        {
            entityManager.close();
            throw new FlightNotFoundException("Flight Not Found");
        }
    }

    @Override
    public ScheduledFlight updateFlightSchedule(BigInteger flightId,int availableSeats)
    {
        entityManager= jpaUtil.getEntityManager();
        ScheduledFlight scheduledFlight=
                entityManager.find(ScheduledFlight.class, flightId);
        if(scheduledFlight!=null) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("UPDATE ScheduledFlight  SET availableSeats = :availableSeats "
            +"where flight= :flightId")
                    .setParameter("availableSeats", availableSeats)
                    .setParameter("flightId", flightId)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            return scheduledFlight;
        }
        return null;
    }

    @Override
    public List<ScheduledFlight> viewAllScheduledFlights()
    {
        entityManager= jpaUtil.getEntityManager();
        List<ScheduledFlight> flightList=  entityManager.createQuery("select sf from ScheduledFlight sf", ScheduledFlight.class).getResultList();
        entityManager.close();
        return flightList;
    }

    @Override
    public List<ScheduledFlight> viewAllScheduledFlights(LocalDate arrivalDate) throws FlightNotFoundException
    {
        entityManager= jpaUtil.getEntityManager();
        List<ScheduledFlight> flightList=
                entityManager.createQuery("select f from ScheduledFlight f where f.schedule.arrivalDate = :arrivalDate",
                ScheduledFlight.class)
                .setParameter("arrivalDate", arrivalDate).getResultList();
        if(flightList.isEmpty()){
            entityManager.close();
            throw new FlightNotFoundException("Flight not found!");
        }else{
            entityManager.close();
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
        entityManager= jpaUtil.getEntityManager();
        List<ScheduledFlight> list= entityManager.createQuery("SELECT f " + "FROM ScheduledFlight f "
                + "WHERE LOWER(f.schedule.sourceAirport.airportLocation) = :source "
                + "and LOWER(f.schedule.destinationAirport.airportLocation) = :destination " +
                "AND f.schedule.arrivalDate= :date", ScheduledFlight.class)
                .setParameter("source", source.toLowerCase())
                .setParameter("destination", destination.toLowerCase())
                .setParameter("date", date)
                .getResultList();
        entityManager.close();
        return list;
    }

}
