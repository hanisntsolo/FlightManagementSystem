package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PassengerRepositoryImpl implements IPassengerRepository{

    public Passenger addPassenger(Passenger passenger){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(passenger);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return passenger;
    }
}
