package com.example.graph.domain;

import com.example.graph.dto.request.ReviewCreateReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long reviewId;

    // 이름이 R.reviewer as reviewer(이것)과 같아야 한다.
    private String reviewer;

    private String review;

    private int rating;

    public Review(ReviewCreateReqDto reqDto){
        this.reviewer = reqDto.getReviewer();
        this.review = reqDto.getReview();
        this.rating = reqDto.getRating();
    }
}
