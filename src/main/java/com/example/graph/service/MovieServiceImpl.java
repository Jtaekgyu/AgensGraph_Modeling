package com.example.graph.service;

import com.example.graph.domain.Movie;
import com.example.graph.dto.request.MovieReqDto;
import com.example.graph.dto.response.MovieResDto;
import com.example.graph.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService{

    private final MovieMapper movieMapper;

    public MovieResDto create(MovieReqDto reqDto){
        Movie movie = new Movie(reqDto);
        movieMapper.save(movie);
        MovieResDto resDto = new MovieResDto(movie);
        return resDto;
    }

    public List<MovieResDto> findAll(){
        List<MovieResDto> movieResDtoList = new ArrayList<>();
        List<Movie> movieList = movieMapper.findAll();
        for(Movie tmpMovie : movieList){
            movieResDtoList.add(new MovieResDto(tmpMovie));
        }
        return movieResDtoList;
    }

    public List<MovieResDto> findByName(String name){
        List<MovieResDto> movieResDtoList = new ArrayList<>();
        List<Movie> movieList = movieMapper.findByName(name);
        for(Movie movie : movieList){
            movieResDtoList.add(new MovieResDto(movie));
        }
        return movieResDtoList;
    }

    public List<MovieResDto> findAllByObject(MovieReqDto reqDto){
        List<MovieResDto> movieResDtoList = new ArrayList<>();
        List<Movie> movieList = movieMapper.findAllByObject(reqDto);
        for(Movie movie : movieList){
            movieResDtoList.add(new MovieResDto(movie));
        }
        return movieResDtoList;
    }

    public Integer deleteByName(String name){
        Integer result = movieMapper.deleteByName(name);
        return result;
    }
}
