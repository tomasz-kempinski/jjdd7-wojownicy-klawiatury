package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.service.SaveToDataBase;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/database-init")
public class DatabaseInitServlet extends HttpServlet {

    @Inject
    private SaveToDataBase saveToDataBase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        saveToDataBase.saveBooksFromApi();
    }
}
