package com.infoshareacademy.wojownicy.service;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ApiDataHandler {

  private String fileURL;

  public void setFileURL(String fileURL) {
    this.fileURL = fileURL;
  }
}
