package com.example.graph.dto.response;

import com.example.graph.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResDto {

//    String prop;
    String reviewer;

    String review;

    Integer rating;

    public ReviewResDto(Review review){
        this.reviewer = review.getReviewer();
        this.review = review.getReview();
        this.rating =review.getRating();
    }
}
