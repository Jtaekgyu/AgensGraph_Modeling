package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewFindAllReqDto {

    String reviewer;

    String review;

    Integer rating;
}