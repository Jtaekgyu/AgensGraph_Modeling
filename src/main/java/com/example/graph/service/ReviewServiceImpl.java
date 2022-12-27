package com.example.graph.service;

import com.example.graph.domain.Review;
import com.example.graph.dto.request.ReviewCreateReqDto;
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

    public void create(ReviewCreateReqDto reqDto){
        Review review = new Review(reqDto);
        reviewMapper.save(review);
    }

    public List<ReviewResDto> matchByReviewer(String reviewer){
//        return reviewMapper.findByReviewer(reviewer);
        List<ReviewResDto> reviewResDtoList = new ArrayList<>();
        List<Review> reviewList = reviewMapper.findByReviewer(reviewer);
        for(Review tmpReview : reviewList){
            reviewResDtoList.add(new ReviewResDto(tmpReview));
        }
        return reviewResDtoList;
    }

    public ReviewResDto findById(double vId){
         Review review = reviewMapper.findById(vId);
         ReviewResDto resDto = new ReviewResDto(review);
         return resDto;
    }
}
