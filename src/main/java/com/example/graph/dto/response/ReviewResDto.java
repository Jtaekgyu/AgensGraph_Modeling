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
        // subString으로 억지로 제거 했는데 바람직하지 않은 방법인듯 하다..
        this.reviewer = review.getReviewer().substring(1, review.getReviewer().length()-1);
        this.review = review.getReview().substring(1, review.getReview().length()-1);
//        this.reviewer = review.getReviewer();
//        this.review = review.getReview();
        this.rating = review.getRating();
    }
}
