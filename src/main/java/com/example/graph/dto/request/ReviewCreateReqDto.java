package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ReviewCreateReqDto {

    String reviewer;

    String review;

    Integer rating;

}
