package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.request.ReviewFindAllReqDto;
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

    @PostMapping("/create")
    public Response<?> create(@RequestBody ReviewCreateReqDto reqDto){
        ReviewResDto resDto = reviewService.create(reqDto);
        return Response.success(resDto);
    }

    @GetMapping // 위에 /review 있음
    public Response<List<ReviewResDto>> findAll(){
        List<ReviewResDto> resDtoList = reviewService.findAll();
        return Response.success(resDtoList);
    }

    @GetMapping("/findByReviewer/{reviewer}")
    public Response<List<ReviewResDto>> matchByReviewer(@PathVariable String reviewer){
        List<ReviewResDto> resDtoList = reviewService.matchByReviewer(reviewer);
        return Response.success(resDtoList);
    }

    @GetMapping("/findAllByObject")
    public Response<List<ReviewResDto>> findAllByObject(@RequestBody ReviewFindAllReqDto reqDto){
        List<ReviewResDto> resDtoList = reviewService.findAllByObject(reqDto);
        return Response.success(resDtoList);
    }

    @DeleteMapping("/delete/{reviewer}")
    public Response<Void> deleteByReviewer(@PathVariable String reviewer){
        reviewService.deleteByReviewer(reviewer);
        return Response.success();
    }

    @GetMapping("findById/{vId}")
    public Response<ReviewResDto> matchById(@PathVariable Object vId){
        ReviewResDto resDto = reviewService.findById(vId);
        return Response.success(resDto);
    }
}
