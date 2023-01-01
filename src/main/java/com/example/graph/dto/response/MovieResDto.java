package com.example.graph.dto.response;

import com.example.graph.domain.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieResDto {

    String name;

    Integer rating;

    public MovieResDto(Movie movie){
        this.name = movie.getName();
        this.rating = movie.getRating();
    }
}