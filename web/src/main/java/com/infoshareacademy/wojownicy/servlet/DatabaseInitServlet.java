package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.service.SaveToDataBase;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/database-init")
public class DatabaseInitServlet extends HttpServlet {

  @EJB
  private SaveToDataBase saveToDataBase;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    saveToDataBase.saveBooksFromApi();
  }
}
