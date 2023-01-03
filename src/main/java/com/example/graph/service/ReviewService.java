package com.example.graph.service;

import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.request.ReviewFindAllReqDto;
import com.example.graph.dto.response.ReviewCreateResDto;
import com.example.graph.dto.response.ReviewResDto;

import java.util.List;

public interface ReviewService {

    void setGraphPath();

    ReviewCreateResDto create(ReviewCreateReqDto reqDto);

    List<ReviewResDto> findAll();

    List<ReviewResDto> matchByReviewer(String reviewer);

    List<ReviewResDto> findAllByObject(ReviewFindAllReqDto reqDto);

    Integer deleteByReviewer(String reviewer);

}
