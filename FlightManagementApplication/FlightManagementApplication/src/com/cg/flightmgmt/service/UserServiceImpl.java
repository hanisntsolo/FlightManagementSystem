package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import java.math.BigInteger;

public class UserServiceImpl implements IUserService {
	

  @Override
  public User addUser(User user) {
    return user;
  }

  @Override
  public User validateUser(User user) throws UserNotFoundException {
    return null;
  }

  @Override
  public User updateUser(User user) throws UserNotFoundException {
    return null;
  }

  @Override
  public User removeUser(BigInteger userId) throws UserNotFoundException {
    return null;
  }
}
