package com.example.graph.service;

import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.response.ReviewResDto;

import java.util.List;

public interface ReviewService {

    void setGraphPath();

    ReviewResDto create(ReviewCreateReqDto reqDto);

    List<ReviewResDto> findAll();

    List<ReviewResDto> matchByReviewer(String reviewer);

    void deleteByReviewer(String reviewer);

    ReviewResDto findById(Object vId);
}
