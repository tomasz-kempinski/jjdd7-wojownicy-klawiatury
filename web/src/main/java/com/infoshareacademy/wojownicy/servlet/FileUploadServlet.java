package com.infoshareacademy.wojownicy.servlet;

import com.infoshareacademy.wojownicy.cdi.FileUploadProcessor;
import com.infoshareacademy.wojownicy.exception.UserFileNotFound;
import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import com.infoshareacademy.wojownicy.service.ApiDataHandler;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/admin-panel")
public class FileUploadServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  FileUploadProcessor fileUploadProcessor;

  @Inject
  ApiDataHandler apiDataHandler;

  private static final Logger logger = Logger.getLogger(FileUploadServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");

    Template template = templateProvider.getTemplate(getServletContext(), "file-upload.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

    PrintWriter printWriter = resp.getWriter();
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    Part file = req.getPart("file");

    String fileURL = "";

    try {
      fileURL = "/admin-panel/" + fileUploadProcessor
          .uploadFile(file).getName();
    } catch (UserFileNotFound userFileNotFound) {
      logger.warning(userFileNotFound.getMessage());
    }
    apiDataHandler.setFileURL(fileURL);

    resp.sendRedirect("/admin-panel");
  }
}
