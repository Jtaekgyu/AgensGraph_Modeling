package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewFindAllReqDto {

    private String reviewer;

    private String review;

    private Integer rating;
}
