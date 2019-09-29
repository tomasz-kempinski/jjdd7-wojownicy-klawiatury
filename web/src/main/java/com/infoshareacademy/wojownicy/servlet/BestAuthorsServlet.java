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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/best-author")
public class BestAuthorsServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(BestAuthorsServlet.class);

  @Inject
  private TemplateProvider templateProvider;
  @Inject
  private StatisticsService statisticsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(),"theBestAuthorList.ftlh");
    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("authorStatList", statisticsService.getAuthorStatisticsList());
    PrintWriter printWriter = resp.getWriter();

    String siteType = (String) req.getAttribute("siteType");
    dataModel.put("siteType", siteType);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }

  }
}
