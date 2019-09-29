package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.service.StatisticsService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.print.attribute.standard.Media;
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

    List<ReservationsAuthorStatistics> authorStats =
    statisticsService.getAuthorStatisticsList();
  }

}
