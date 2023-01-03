package com.example.graph.service;

import com.example.graph.domain.Review;
import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.dto.request.ReviewFindAllReqDto;
import com.example.graph.dto.response.ReviewCreateResDto;
import com.example.graph.dto.response.ReviewResDto;
import com.example.graph.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper reviewMapper;

    public void setGraphPath(){
        reviewMapper.setGraphPath();
    }

    public ReviewCreateResDto create(ReviewCreateReqDto reqDto){
        Review review = new Review(reqDto);
        reviewMapper.save(review);
        ReviewCreateResDto resDto = new ReviewCreateResDto(review);
        return resDto;
    }

    public List<ReviewResDto> findAll(){
        List<ReviewResDto> reviewResDtoList = new ArrayList<>();
        List<Review> reviewList = reviewMapper.findAll();
        for(Review tmpReview : reviewList){
            reviewResDtoList.add(new ReviewResDto(tmpReview));
        }
        return reviewResDtoList;
    }

    public List<ReviewResDto> matchByReviewer(String reviewer){
        List<ReviewResDto> reviewResDtoList = new ArrayList<>();
        List<Review> reviewList = reviewMapper.findByReviewer(reviewer);
        for(Review tmpReview : reviewList){
            reviewResDtoList.add(new ReviewResDto(tmpReview));
        }
        return reviewResDtoList;
    }

    public List<ReviewResDto> findAllByObject(ReviewFindAllReqDto reqDto){
        List<ReviewResDto> reviewResDtoList = new ArrayList<>();
        List<Review> reviewList = reviewMapper.findAllByObject(reqDto);
        for(Review tmpReview : reviewList){
            reviewResDtoList.add(new ReviewResDto(tmpReview));
        }
        return reviewResDtoList;
    }

    public Integer deleteByReviewer(String reviewer){
        Integer result = reviewMapper.deleteByReviewer(reviewer);
        return result;
    }

}
