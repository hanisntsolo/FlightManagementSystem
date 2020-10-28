package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Airport;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AirportRepositoryImp implements IAirportRepository {
    @Override
    public Airport addAirport(Airport airport){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(airport);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return airport;
    }
}
