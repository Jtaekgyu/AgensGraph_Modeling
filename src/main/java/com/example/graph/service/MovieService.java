package com.example.graph.service;

import com.example.graph.dto.request.MovieCreateReqDto;
import com.example.graph.dto.response.MovieResDto;

import java.util.List;

public interface MovieService {

    MovieResDto create(MovieCreateReqDto reqDto);

    List<MovieResDto> findAll();

    List<MovieResDto> findByName(String name);

    void deleteByName(String name);
}
