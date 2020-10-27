package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FlightBookingRepositoryImpl implements IFlightBookingRepository{

    public Booking addBooking(Booking booking){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(booking);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return booking;
    }
    public Booking cancelBooking(BigInteger bookingId) throws BookingNotFoundException{
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Booking booking= em.find(Booking.class, bookingId);
        if(booking==null){
            em.close();
            factory.close();
            throw new BookingNotFoundException("Booking not found!");
        }else{
            em.remove(booking);
            em.close();
            factory.close();
            return booking;
        }
    }
    public Booking viewBooking(BigInteger bookingId) throws BookingNotFoundException{
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Booking booking= em.find(Booking.class, bookingId);
        em.close();
        factory.close();
        if(booking==null){
            throw new BookingNotFoundException("Booking not found!");
        }else{
            return booking;
        }
    }
    public List<Booking> viewBookingList(Date bookingDate){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Booking> bookingList= em.createQuery("select b from Booking b where b.bookingDate = :bookingDate",
                Booking.class).setParameter("bookingDate", bookingDate).getResultList();
        em.close();
        factory.close();
        return bookingList;
    }
    public List<Booking> viewBookingList(BigInteger flightId){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Booking> bookingList= em.createQuery("select b from Booking b where b.flight = :flightId",
                Booking.class).setParameter("flightId", flightId).getResultList();
        em.close();
        factory.close();
        return bookingList;
    }
    public List<Booking> viewBookingHistory(BigInteger userId){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Booking> bookingList= em.createQuery("select b from Booking b where b.userId = :userId",
                Booking.class).setParameter("userId", userId).getResultList();
        em.close();
        factory.close();
        return bookingList;
    }
    public Booking updateBooking(Booking booking){
        return null;
    }
}
