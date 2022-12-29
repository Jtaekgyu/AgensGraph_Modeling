package com.example.graph.domain.edge;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Review;
import com.example.graph.dto.request.EdgeCreateReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reviewed {

    private Long reviewedId;

    // 모든 Vertex를 가지고 있어야 겠네
    private Review review;
    private Movie movie;

    public Reviewed(Review review, Movie movie){
        this.review = review;
        this.movie = movie;
    }
}
