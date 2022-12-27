package com.example.graph.controller;

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
    public void create(@RequestBody ReviewCreateReqDto reqDto){
        reviewService.create(reqDto);
    }

    @GetMapping("/findByReviewer/{reviewer}")
    public List<ReviewResDto> matchByReviewer(@PathVariable String reviewer){
        List<ReviewResDto> resDto = reviewService.matchByReviewer(reviewer);
        return resDto;
    }

    @GetMapping("findById/{vId}")
    public ReviewResDto matchById(@PathVariable double vId){
        ReviewResDto resDto = reviewService.findById(vId);
        return resDto;
    }
}
