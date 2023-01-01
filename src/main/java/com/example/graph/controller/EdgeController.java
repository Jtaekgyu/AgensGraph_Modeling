package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.EdgeCreateReqDto;
import com.example.graph.dto.request.MovieTwoCreateReqDto;
import com.example.graph.service.EdgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edge")
@RequiredArgsConstructor
public class EdgeController {

    private final EdgeService edgeService;

    @PostMapping("/create")
    public Response<?> setEdge (@RequestBody EdgeCreateReqDto reqDto){
        edgeService.createEdge(reqDto);
        return null;
    }

    @PostMapping("/CreatMovieToMovie")
    public Response<?> createMovieToMovie(@RequestBody MovieTwoCreateReqDto reqDto){
        Object result = edgeService.createMovieToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/CreateReviewToMovie")
    public Response<?> createReviewToMovie(@RequestBody EdgeCreateReqDto reqDto){
        Object result = edgeService.createReviewToMovie(reqDto);
        return Response.success(result);
    }

}