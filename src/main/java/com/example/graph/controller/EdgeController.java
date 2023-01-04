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

    @PostMapping("/create")
    public Response<?> setEdge (@RequestBody EdgeReviewedReqDto reqDto){
        edgeService.createEdge(reqDto);
        return null;
    }

    @PostMapping("/CreatMovieToMovie")
    public Response<?> createMovieToMovie(@RequestBody MovieTwoCreateReqDto reqDto){
        Object result = edgeService.createMovieToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/CreateReviewToMovie")
    public Response<?> createReviewToMovie(@RequestBody EdgeReviewedReqDto reqDto){
        Object result = edgeService.createReviewToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/CreatePersonToMovie")
    public Response<?> CreatePersonToMovie(@RequestBody EdgePtoMReqDto reqDto){
        Object result = edgeService.createEdgePersonToMovie(reqDto);
        return Response.success(result);
    }

    @PostMapping("/CreatePersonActedInMovie")
    public Response<?> CreatePersonActedInMovie(@RequestBody EdgePActMReqDto reqDto){
        Object result = edgeService.CreatePersonActedInMovie(reqDto);
        return Response.success(result);
    }

    @GetMapping("/vev")
    public Response<?> findVertexEdgeVertex(@RequestBody VEVReqDto reqDto){
        Object result = edgeService.findVertexEdgeVertex(reqDto);
        return Response.success(result);
    }

}
