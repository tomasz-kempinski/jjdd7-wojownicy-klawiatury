package com.infoshareacademy.wojownicy.servlet;


import com.infoshareacademy.wojownicy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/main-site")
public class MainSiteServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //Template template = templateProvider.getTemplate(getServletContext(), "main-site.ftlh");

        req.getRequestDispatcher("WEB-INF/sites-templates/main-site.ftlh").forward(req, resp);

        /*Map<String, Object> dataModel = new HashMap<>();

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }*/
    }
}
