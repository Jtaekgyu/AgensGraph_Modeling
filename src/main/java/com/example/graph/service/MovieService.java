package com.example.graph.service;

import com.example.graph.dto.request.MovieReqDto;
import com.example.graph.dto.response.MovieCreateResDto;
import com.example.graph.dto.response.MovieResDto;

import java.util.List;

public interface MovieService {

    MovieCreateResDto create(MovieReqDto reqDto);

    List<MovieResDto> findAll();

    List<MovieResDto> findByName(String name);

    List<MovieResDto> findAllByObject(MovieReqDto reqDto);

    Integer deleteByName(String name);
}
