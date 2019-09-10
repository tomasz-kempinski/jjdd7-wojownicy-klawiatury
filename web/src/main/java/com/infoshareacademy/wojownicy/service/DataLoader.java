package com.infoshareacademy.wojownicy.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class DataLoader {

  @Inject
  private SaveToDataBase saveToDataBase;

  @PostConstruct
  public void loadData(){
    saveToDataBase.saveBooksFromApi();
  }

}
