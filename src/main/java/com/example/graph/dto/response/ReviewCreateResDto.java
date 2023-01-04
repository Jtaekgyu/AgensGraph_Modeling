package com.example.graph.dto.response;

import com.example.graph.domain.Review;
import lombok.Getter;

@Getter
public class ReviewCreateResDto {

    private String reviewer;

    private String review;

    private Integer rating;

    public ReviewCreateResDto(Review review){
        this.reviewer = review.getReviewer();
        this.review = review.getReview();
        this.rating = review.getRating();
    }
}
