package com.infoshareacademy.wojownicy.filter;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(
    filterName = "AuthorizationFilter",
    urlPatterns = {"/*"}
)
public class AuthorizationFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    Optional<Object> userType = Optional.ofNullable(req.getSession().getAttribute("userType"));

    if (userType.isEmpty()) {
      req.setAttribute("siteType", "guest");
    } else if (userType.get().equals("admin") || userType.get().equals("superadmin")) {
      req.setAttribute("siteType", "admin");
    } else if (userType.get().equals("user")){
      req.setAttribute("siteType", "user");
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
