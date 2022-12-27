package com.example.graph.domain;

import com.example.graph.dto.request.MovieCreateReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long movieId;

    private String name;

    private Integer rating;

    public Movie(MovieCreateReqDto reqDto){
        this.name = reqDto.getName();
        this.rating = reqDto.getRating();
    }
}