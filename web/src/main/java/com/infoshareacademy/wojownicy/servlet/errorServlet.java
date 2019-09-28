package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
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

@WebServlet(urlPatterns = "/errorServlet")
public class errorServlet extends HttpServlet {
  private static final Logger logger = LoggerFactory.getLogger(MainSiteServlet.class.getName());

  @Inject
  TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(),"errorPage.ftlh");

    PrintWriter printWriter = resp.getWriter();

    Map<String, String> dataModel = new HashMap<>();
    dataModel.put("error","Error");

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }


  }
}
