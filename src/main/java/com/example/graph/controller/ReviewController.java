package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.ReviewCreateReqDto;
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

    @GetMapping("/findByReviewer/{reviewer}")
    public Response<List<ReviewResDto>> matchByReviewer(@PathVariable String reviewer){
        List<ReviewResDto> resDto = reviewService.matchByReviewer(reviewer);
        return Response.success(resDto);
    }

    @GetMapping("findById/{vId}")
    public ReviewResDto matchById(@PathVariable double vId){
        ReviewResDto resDto = reviewService.findById(vId);
        return resDto;
    }
}
