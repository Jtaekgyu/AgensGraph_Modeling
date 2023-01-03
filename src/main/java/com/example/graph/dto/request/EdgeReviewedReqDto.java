package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EdgeReviewedReqDto {
    ReviewCreateReqDto reviewCreateReqDto;
    MovieReqDto movieReqDto;
    String edgeName; // 지금은 Request형식만 맞춰주고 굳이 필요없음 고려하자
}
