package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.UsersListService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users-list")
public class UsersListServlet extends HttpServlet {
  @Inject
  private TemplateProvider templateProvider;

  @Inject
  UsersListService usersListService;

  private static final Logger logger = LoggerFactory.getLogger(UsersListServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(),"users-list.ftlh");

    List<User> usersList = usersListService.getUsersList();

    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("users", usersList);

    PrintWriter printWriter = resp.getWriter();

    try {
      template.process(dataModel,printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
