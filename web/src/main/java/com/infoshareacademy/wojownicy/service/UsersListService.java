package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@Transactional
@RequestScoped
public class UsersListService {
  @EJB
  UserDaoBean userDaoBean;

  public List<User> getUsersList(){
    return userDaoBean.getUsersList();
  }

}
