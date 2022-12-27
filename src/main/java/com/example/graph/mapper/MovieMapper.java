package com.example.graph.mapper;

import com.example.graph.domain.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    void save(Movie movie);

    List<Movie> findAll();

    List<Movie> findByName(String name);
}
