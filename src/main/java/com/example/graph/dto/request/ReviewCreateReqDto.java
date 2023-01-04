package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ReviewCreateReqDto {

    private String reviewer;

    private String review;

    private Integer rating;

}
