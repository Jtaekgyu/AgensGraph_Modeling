package com.example.graph.domain.edge;

import com.example.graph.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EdgeMovieToMovie {

    private Movie movie1;
    private Movie movie2;

    public EdgeMovieToMovie(Movie movie1, Movie movie2){
        this.movie1 = movie1;
        this.movie2 = movie2;
    }
}
