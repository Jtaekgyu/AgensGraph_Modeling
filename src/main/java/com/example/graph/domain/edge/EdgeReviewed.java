package com.example.graph.domain.edge;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EdgeReviewed {

    private Review review;
    private Movie movie;
    private String edgeName;

}
