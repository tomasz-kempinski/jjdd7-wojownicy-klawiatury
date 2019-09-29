package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.dto.AuthorStatisticsDto;
import com.infoshareacademy.wojownicy.dto.BookStatisticsDto;
import com.infoshareacademy.wojownicy.service.StatisticsService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/statistics")
@Stateless
public class StatisticsRestService {

  @EJB
  private StatisticsService statisticsService;

  @GET
  @Path("/authors")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBestAuthors(){

    List<AuthorStatisticsDto> authorStatistics = statisticsService.getAuthorStatisticsList();

    return Response.ok(authorStatistics).build();
  }

  @GET
  @Path("/books")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBestBooks(){

    List<BookStatisticsDto> bookStatistics = statisticsService.getBookStatisticsList();

    return Response.ok(bookStatistics).build();
  }
}
