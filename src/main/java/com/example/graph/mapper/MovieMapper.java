package com.example.graph.mapper;

import com.example.graph.domain.Movie;
import com.example.graph.dto.request.MovieReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    Integer save(Movie movie);

    List<Movie> findAll();

    List<Movie> findByName(String name);

    List<Movie> findAllByObject(MovieReqDto reqDto);

    Integer deleteByName(String name);
}
