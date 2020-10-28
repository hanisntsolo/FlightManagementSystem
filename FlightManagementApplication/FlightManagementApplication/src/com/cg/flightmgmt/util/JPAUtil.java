package com.cg.flightmgmt.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManager getEntityManager()
    {
        EntityManagerFactory fact= Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em=fact.createEntityManager();
        return em;
    }
}
