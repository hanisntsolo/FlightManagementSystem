package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PassengerRepositoryImpl implements IPassengerRepository{
    JPAUtil jpaUtil= new JPAUtil();
    public Passenger addPassenger(Passenger passenger){
        EntityManager entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();
        entityManager.close();
        return passenger;
    }
}
