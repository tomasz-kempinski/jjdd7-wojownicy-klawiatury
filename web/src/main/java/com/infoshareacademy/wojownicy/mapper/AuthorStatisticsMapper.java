package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsAuthorStatistics;
import com.infoshareacademy.wojownicy.dto.AuthorStatisticsDto;
import javax.ejb.Stateless;

@Stateless
public class AuthorStatisticsMapper {

  public AuthorStatisticsDto mapEntityToDao(ReservationsAuthorStatistics ras){
    AuthorStatisticsDto authorStatisticsDto = new AuthorStatisticsDto();
    authorStatisticsDto.setId(ras.getId());
    authorStatisticsDto.setName(ras.getAuthor().getAuthorName());
    authorStatisticsDto.setCount(ras.getReservedCounter());

    return authorStatisticsDto;
  }
}
