package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.util.UserRepoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepositoryImpl implements IUserRepository {
    EntityManager em;
    UserRepoUtil userRepoUtil=new UserRepoUtil();

//    EntityManagerFactory factory = Persistence
//            .createEntityManagerFactory("NewPersistenceUnit");
//    EntityManager em = factory.createEntityManager();


    @Override
    public User addUser(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
    @Override
    public User validateUser(User user) throws UserNotFoundException
    {
        em.getTransaction().begin();

            User user1 = em.find(User.class, user.getUserId());
            if (user1.getPassword().equals(user.getPassword())) {
                em.close();
 //               factory.close();
                return user1;

        } else {
            em.close();
 //           factory.close();
            throw new UserNotFoundException("User not found!");
        }
    }
    @Override
    public User updateUser(User user) throws UserNotFoundException
    {
        em.getTransaction().begin();
        if(user==null){
            em.close();
            throw new UserNotFoundException("User not found!");
        }else {
            em.merge(user);
            em.close();
            return user;
        }

    }
    @Override
    public User removeUser(BigInteger userid) throws UserNotFoundException
    {
        em.getTransaction().begin();
        User user= em.find(User.class,userid);
        if(user==null){
            em.close();
//            factory.close();
            throw new UserNotFoundException("User not found!");
        }else{
            em.remove(user);
            em.close();
//            factory.close();
            return user;
        }
    }
}
