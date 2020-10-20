package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

public class UserRepository implements IUserRepository {
    @Override
    public User addUser(User user)
    {
        return null;
    }

    @Override
    public User validateUser(User user) throws UserNotFoundException
    {
        return null;
    }
    @Override
    public User updateUser(User user) throws UserNotFoundException
    {
        return null;
    }
    @Override
    public User removeUser(BigInteger userid) throws UserNotFoundException
    {
        return null;
    }
}
