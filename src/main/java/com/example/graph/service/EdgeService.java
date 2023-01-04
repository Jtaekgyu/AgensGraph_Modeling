package com.example.graph.service;

import com.example.graph.dto.request.*;

public interface EdgeService {
    void createEdge(EdgeReviewedReqDto reqDto);
    Object createMovieToMovie(MovieTwoCreateReqDto reqDto);
    Object createReviewToMovie(EdgeReviewedReqDto reqDto);
    Object createEdgePersonToMovie(EdgePtoMReqDto reqDto);
    Object CreatePersonActedInMovie(EdgePActMReqDto reqDto);
    Object findVertexEdgeVertex(VEVReqDto reqDto);
}
