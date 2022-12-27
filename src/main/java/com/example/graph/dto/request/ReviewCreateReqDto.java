package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewCreateReqDto {

    String reviewer;

    String review;

    int rating;

}
