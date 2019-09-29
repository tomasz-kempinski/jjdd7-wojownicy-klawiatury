package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.ReservationsBookStatistics;
import com.infoshareacademy.wojownicy.dto.BookStatisticsDto;
import javax.ejb.Stateless;

@Stateless
public class BookStatisticsMapper {

  public BookStatisticsDto mapEntityToDto(ReservationsBookStatistics rbs){
    BookStatisticsDto bookStatisticsDto = new BookStatisticsDto();
    bookStatisticsDto.setId(rbs.getId());
    bookStatisticsDto.setTitle(rbs.getBook().getTitle());
    bookStatisticsDto.setCount(rbs.getReservedCounter());

    return bookStatisticsDto;
  }
}
