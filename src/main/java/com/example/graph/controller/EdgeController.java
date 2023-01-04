package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.*;
import com.example.graph.service.EdgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edge")
@RequiredArgsConstructor
public class EdgeController {

    private final EdgeService edgeService;

    @PostMapping
    public Response<Integer> setEdge (@RequestBody EdgeReviewedReqDto reqDto){
        Integer result = edgeService.createEdge(reqDto);
        return Response.success(result);
    }

    @PostMapping("/movie-to-movie")
    public Response<?> createMovieToMovie(@RequestBody MovieTwoCreateReqDto reqDto){
        Object result = edgeService.createMovieToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/review-reviewed-movie")
    public Response<?> createReviewToMovie(@RequestBody EdgeReviewedReqDto reqDto){
        Object result = edgeService.createReviewToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/person-edge-movie")
    public Response<?> createPersonToMovie(@RequestBody EdgePtoMReqDto reqDto){
        Object result = edgeService.createEdgePersonToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/person-actedin-movie")
    public Response<?> createPersonActedInMovie(@RequestBody EdgePActMReqDto reqDto){
        Object result = edgeService.CreatePersonActedInMovie(reqDto);
        return Response.success(result);
    }

    @GetMapping("/vev")
    public Response<?> findVertexEdgeVertex(@RequestBody VEVReqDto reqDto){
        Object result = edgeService.findVertexEdgeVertex(reqDto);
        return Response.success(result);
    }

}
