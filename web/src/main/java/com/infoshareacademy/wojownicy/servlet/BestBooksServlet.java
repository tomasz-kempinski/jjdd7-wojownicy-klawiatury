package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.StatisticsService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/best-book")
public class BestBooksServlet extends HttpServlet {

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private StatisticsService statisticsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(),"theBestBooksList.ftlh");

    Map<String,Object> dataModel = new HashMap<>();

    dataModel.put("bookStatList",statisticsService.getBookStatisticsList());

    PrintWriter printWriter = resp.getWriter();

    String siteType = (String) req.getAttribute("siteType");
    dataModel.put("siteType", siteType);

    try {
      template.process(dataModel,printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }

  }
}
