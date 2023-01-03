package com.example.graph.domain;

import com.example.graph.dto.request.MovieReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String name;

    private Integer rating;

    public Movie(MovieReqDto reqDto){
        this.name = reqDto.getName();
        this.rating = reqDto.getRating();
    }
}