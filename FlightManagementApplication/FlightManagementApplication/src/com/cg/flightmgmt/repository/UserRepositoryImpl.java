package com.cg.flightmgmt.repository;

import com.cg.flightmgmt.dto.Booking;
import java.math.BigInteger;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public User addUser(User user) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return user;
    }
    @Override
    public User validateUser(User user) throws UserNotFoundException
    {   EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        // Validate logic
        em.getTransaction().commit();
        em.close();
        factory.close();
        return user;
    }
    @Override
    public User updateUser(User user) throws UserNotFoundException
    {   EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        // Updating into database
        em.getTransaction().commit();
        em.close();
        factory.close();
        return user;
    }
    @Override
    public User removeUser(BigInteger userid) throws UserNotFoundException
    {   EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        //Remove from database
        User user = em.find(User.class, userid);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return user;
    }
}
