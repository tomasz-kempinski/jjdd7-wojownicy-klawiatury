package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.User;

import com.infoshareacademy.wojownicy.dto.UserDto;
import com.infoshareacademy.wojownicy.mapper.UserMapper;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {

  @EJB
  UserDaoBean userDaoBean;

  @EJB
  UserMapper userMapper;

  public void saveUser(UserDto userDto){
  userDaoBean.addUser(userMapper.mapDtoToEntity(userDto));
  }

  public User getUserByEmail(String email){
   return userDaoBean.findUserByEmail(email);
  }

  public boolean checkIfExistByEmail(String email){
    User user = getUserByEmail(email);

    if (user == null){
      return false;
    }
    return true;
  }
}
