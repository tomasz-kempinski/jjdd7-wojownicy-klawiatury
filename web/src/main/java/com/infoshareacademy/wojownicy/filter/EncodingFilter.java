package com.infoshareacademy.wojownicy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(
    filterName = "EncodingFilter",
    urlPatterns = {"/*"}
)
public class EncodingFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(EncodingFilter.class.getName());

  private final String codingType = "UTF-8";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    logger.info("Coding type is set");
    response.setCharacterEncoding(codingType);
    filterChain.doFilter(request, response);
  }
}


