package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FlightBookingRepositoryImpl implements IFlightBookingRepository{
    EntityManager entityManager;
    JPAUtil jpaUtil = new JPAUtil();

    public Booking addBooking(Booking booking){
        entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(booking);
        entityManager.getTransaction().commit();
        entityManager.close();
        return booking;
    }

    @Override
    public Booking cancelBooking(BigInteger bookingId) throws BookingNotFoundException{

        entityManager= jpaUtil.getEntityManager();
        Booking booking= entityManager.find(Booking.class, bookingId);
        if(booking==null){
            entityManager.close();
            throw new BookingNotFoundException("Booking not found!");
        }else{
            entityManager.getTransaction().begin();
            entityManager.remove(booking);
            entityManager.getTransaction().commit();
            entityManager.close();
            return booking;
        }
    }
    @Override
    public Booking viewBooking(BigInteger bookingId) throws BookingNotFoundException{

        entityManager= jpaUtil.getEntityManager();
        Booking booking= entityManager.find(Booking.class, bookingId);
        if(booking==null){
            entityManager.close();
            throw new BookingNotFoundException("Booking not found!");
        }else{
            entityManager.close();
            return booking;
        }
    }

    @Override
    public List<Booking> viewBookingList(Date bookingDate){
        entityManager=jpaUtil.getEntityManager();
        List<Booking> bookingList=
                entityManager.createQuery("select b from Booking b where b.bookingDate = :bookingDate",
                Booking.class).setParameter("bookingDate", bookingDate).getResultList();
        entityManager.close();
        return bookingList;
    }

    @Override
    public List<Booking> viewBookingList(BigInteger flightId){
       entityManager=jpaUtil.getEntityManager();
       List<Booking> bookingList= entityManager.createQuery("select b from Booking b where b.flight.flightId= :flightId",
                Booking.class).setParameter("flightId", flightId).getResultList();
       entityManager.close();
       return bookingList;
    }

    @Override
    public List<Booking> viewBookingHistory(BigInteger userId){
      EntityManager entityManager=jpaUtil.getEntityManager();
      List<Booking> bookingList=
                entityManager.createQuery("select b from Booking b where b.userId.userId = :userId",
                Booking.class).setParameter("userId", userId).getResultList();
      entityManager.close();
      return bookingList;
    }

    @Override
    public Booking updateBooking(Booking booking){
        return null;
    }
}
