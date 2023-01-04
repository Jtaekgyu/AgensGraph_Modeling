package com.example.graph.dto.response;

import com.example.graph.domain.Movie;
import lombok.Getter;

@Getter
public class MovieCreateResDto {

    private String name;

    private Integer rating;

    public MovieCreateResDto(Movie movie){
        this.name = movie.getName();
        this.rating = movie.getRating();
    }
}
