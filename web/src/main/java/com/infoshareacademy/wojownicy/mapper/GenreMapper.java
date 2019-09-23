package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.dto.GenreDto;
import javax.ejb.Stateless;

@Stateless
public class GenreMapper {

  public GenreDto mapEntityToDto(Genre genre) {

    GenreDto genreDto = new GenreDto();
    genreDto.setId(genre.getGenreId());
    genreDto.setName(genre.getGenreName());
    return genreDto;
  }

}
