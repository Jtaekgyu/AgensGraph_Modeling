package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.MovieReqDto;
import com.example.graph.dto.response.MovieCreateResDto;
import com.example.graph.dto.response.MovieResDto;
import com.example.graph.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public Response<MovieCreateResDto> create(@RequestBody MovieReqDto reqDto){
        MovieCreateResDto resDto = movieService.create(reqDto);
        return Response.success(resDto);
    }

    @GetMapping
    public Response<List<MovieResDto>> findAll(){
        List<MovieResDto> resDtoList = movieService.findAll();
        return Response.success(resDtoList);
    }

    @GetMapping("/name/{name}")
    public Response<List<MovieResDto>> findByName(@PathVariable String name){
        List<MovieResDto> resDtoList = movieService.findByName(name);
        return Response.success(resDtoList);
    }

    @GetMapping("/object")
    public Response<List<MovieResDto>> findAllByObject(@RequestBody MovieReqDto reqDto){
        List<MovieResDto> resDtoList = movieService.findAllByObject(reqDto);
        return Response.success(resDtoList);
    }

    @DeleteMapping("/name/{name}")
    public Response<Integer> deleteByName(@PathVariable String name){
        Integer result =  movieService.deleteByName(name);
        return Response.success(result);
    }

}
