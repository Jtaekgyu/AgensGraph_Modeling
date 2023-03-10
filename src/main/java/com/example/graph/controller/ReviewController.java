package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.request.ReviewFindAllReqDto;
import com.example.graph.dto.response.ReviewCreateResDto;
import com.example.graph.dto.response.ReviewResDto;
import com.example.graph.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/set-graph_path")
    public void setGraphPath(){
        reviewService.setGraphPath();
    }

    @PostMapping
    public Response<ReviewCreateResDto> create(@RequestBody ReviewCreateReqDto reqDto){
        ReviewCreateResDto resDto = reviewService.create(reqDto);
        return Response.success(resDto);
    }

    @GetMapping
    public Response<List<ReviewResDto>> findAll(){
        List<ReviewResDto> resDtoList = reviewService.findAll();
        return Response.success(resDtoList);
    }

    @GetMapping("/reviewer/{reviewer}")
    public Response<List<ReviewResDto>> matchByReviewer(@PathVariable String reviewer){
        List<ReviewResDto> resDtoList = reviewService.matchByReviewer(reviewer);
        return Response.success(resDtoList);
    }

    @GetMapping("/object")
    public Response<List<ReviewResDto>> findAllByObject(@RequestBody ReviewFindAllReqDto reqDto){
        List<ReviewResDto> resDtoList = reviewService.findAllByObject(reqDto);
        return Response.success(resDtoList);
    }

    @DeleteMapping("/reviewer/{reviewer}")
    public Response<Integer> deleteByReviewer(@PathVariable String reviewer){
        Integer result = reviewService.deleteByReviewer(reviewer);
        return Response.success(result);
    }

}
