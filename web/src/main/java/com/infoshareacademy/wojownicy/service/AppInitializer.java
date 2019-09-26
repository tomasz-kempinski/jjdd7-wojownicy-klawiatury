package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class AppInitializer {

  @EJB
  private UserDaoBean userDaoBean;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PostConstruct
  public void createSuperAdmin() {
    User user = new User();
    user.setUsername("Wojownicy Klawiatury");
    user.setEmail("wk.bookhub@gmail.com");
    user.setUserType("superadmin");
    userDaoBean.addUser(user);

    logger.info("Created user with super admin privileges");
  }
}
