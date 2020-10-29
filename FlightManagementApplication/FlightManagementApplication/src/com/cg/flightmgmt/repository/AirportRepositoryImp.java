package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.util.JPAUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AirportRepositoryImp implements IAirportRepository {
    JPAUtil jpaUtil= new JPAUtil();
    @Override
    public Airport addAirport(Airport airport){
        EntityManager entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(airport);
        entityManager.getTransaction().commit();
        entityManager.close();
        return airport;
    }

    public Airport getAirport(int airportId){
        EntityManager entityManager= jpaUtil.getEntityManager();
        Airport airport= entityManager.find(Airport.class, airportId);
        entityManager.close();
        return airport;
    }
}
