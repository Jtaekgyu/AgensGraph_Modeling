package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.MovieCreateReqDto;
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

    @PostMapping("/create")
    public Response<?> create(@RequestBody MovieCreateReqDto reqDto){
        MovieResDto resDto = movieService.create(reqDto);
        return Response.success(resDto);
    }

    @GetMapping
    public Response<List<MovieResDto>> findAll(){
        List<MovieResDto> resDtoList = movieService.findAll();
        return Response.success(resDtoList);
    }

    @GetMapping("/findByName/{name}")
    public Response<List<MovieResDto>> findByName(@PathVariable String name){
        List<MovieResDto> resDtoList = movieService.findByName(name);
        return Response.success(resDtoList);
    }

}
