package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EdgeReviewedReqDto {
    private ReviewCreateReqDto reviewCreateReqDto;
    private MovieReqDto movieReqDto;
    private String edgeName;
}
