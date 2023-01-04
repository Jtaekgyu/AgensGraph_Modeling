package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovieTwoCreateReqDto {

    private MovieReqDto movieReqDto1;
    private MovieReqDto movieReqDto2;
}
