package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.User;

import com.infoshareacademy.wojownicy.dto.UserDto;
import com.infoshareacademy.wojownicy.mapper.UserMapper;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

  @EJB
  UserDaoBean userDaoBean;

  @Inject
  UserMapper userMapper;

  public void saveUser(UserDto userDto){
  userDaoBean.addUser(userMapper.mapDtoToEntity(userDto));
  }

  public UserDto getUserByEmail(String email){
   User user = userDaoBean.findUserByEmail(email);
   return userMapper.mapEntityToDto(user);
  }
}
