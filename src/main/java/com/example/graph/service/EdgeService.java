package com.example.graph.service;

import com.example.graph.dto.request.EdgeReviewedReqDto;
import com.example.graph.dto.request.MovieTwoCreateReqDto;

public interface EdgeService {
    void createEdge(EdgeReviewedReqDto reqDto);
    Object createMovieToMovie(MovieTwoCreateReqDto reqDto);
    Object createReviewToMovie(EdgeReviewedReqDto reqDto);

}
