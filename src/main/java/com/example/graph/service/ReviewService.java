package com.example.graph.service;

import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.response.ReviewResDto;

import java.util.List;

public interface ReviewService {

    void setGraphPath();

    void create(ReviewCreateReqDto reqDto);

    List<ReviewResDto> matchByReviewer(String reviewer);

    ReviewResDto findById(double vId);
}
