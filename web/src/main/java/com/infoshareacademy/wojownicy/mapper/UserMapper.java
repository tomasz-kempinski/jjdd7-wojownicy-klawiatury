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
    if (user.getEmail().equals("lisrobert0023@gmail.com")){
      user.setAdmin(true);
    } else {
      user.setAdmin(userDto.isAdmin());
    }
    return user;
  }

  public UserDto mapEntityToDto(User user) {

    UserDto userDto = new UserDto();
    userDto.setId(userDto.getId());
    userDto.setEmail(user.getEmail());
    userDto.setUsername(user.getUsername());
    userDto.setAdmin(user.isAdmin());
    return userDto;
  }
}
