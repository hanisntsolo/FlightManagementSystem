package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepositoryImpl implements IUserRepository {
    JPAUtil jpaUtil=new JPAUtil();
    @Override
    public User addUser(User user) {
        EntityManager entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public User validateUser(User user) throws UserNotFoundException
    {
        EntityManager entityManager= jpaUtil.getEntityManager();
        User new_user = entityManager.find(User.class, user.getUserId());
            if (new_user.getPassword().equals(user.getPassword())) {
                entityManager.close();
                return new_user;
            } else {
                entityManager.close();
            throw new UserNotFoundException("User not found!");
        }
    }
    @Override
    public User updateUser(User user) throws UserNotFoundException
    {
        EntityManager entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        if(user==null){
            entityManager.close();
            throw new UserNotFoundException("User not found!");
        }else {
            entityManager.merge(user);
            entityManager.close();
            return user;
        }

    }
    @Override
    public User removeUser(BigInteger userid) throws UserNotFoundException
    {
        EntityManager entityManager= jpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user= entityManager.find(User.class,userid);
        if(user==null){
            entityManager.close();
            throw new UserNotFoundException("User not found!");
        }else{
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            return user;
        }
    }
}
