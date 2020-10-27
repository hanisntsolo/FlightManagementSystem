package com.cg.flightmgmt.service;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.IUserRepository;
import com.cg.flightmgmt.repository.UserRepositoryImpl;

import java.math.BigInteger;

public class UserServiceImpl implements IUserService {
  
  IUserRepository userRepository= new UserRepositoryImpl();
  @Override
  public User addUser(User user) {
    return userRepository.addUser(user);

  }
  @Override
  public User validateUser(User user) throws UserNotFoundException {
    return userRepository.validateUser(user);
  }

  @Override
  public User updateUser(User user) throws UserNotFoundException {
    return userRepository.updateUser(user);
  }

  @Override
  public User removeUser(BigInteger userId) throws UserNotFoundException {
    return userRepository.removeUser(userId);
  }
}
