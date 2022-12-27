package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovieCreateReqDto {

    String name;

    Integer rating;
}
