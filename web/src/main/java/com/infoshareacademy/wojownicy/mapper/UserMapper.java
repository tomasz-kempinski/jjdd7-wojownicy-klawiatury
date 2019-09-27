package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.dto.UserDto;
import javax.ejb.Stateless;

@Stateless
public class UserMapper {

  public User mapDtoToEntity(UserDto userDto) {

    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setUserType(userDto.getUserType());
    return user;
  }

  public UserDto mapEntityToDto(User user) {

    UserDto userDto = new UserDto();
    userDto.setId(user.getUserId());
    userDto.setUsername(user.getUsername());
    userDto.setEmail(user.getEmail());
    userDto.setUserType(user.getUserType());
    return userDto;
  }
}
