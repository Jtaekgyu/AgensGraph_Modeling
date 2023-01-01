package com.example.graph.service;

import com.example.graph.dto.request.EdgeCreateReqDto;
import com.example.graph.dto.request.MovieTwoCreateReqDto;

public interface EdgeService {
    void createEdge(EdgeCreateReqDto reqDto);
    Object createMovieToMovie(MovieTwoCreateReqDto reqDto);
    Object createReviewToMovie(EdgeCreateReqDto reqDto);

}
