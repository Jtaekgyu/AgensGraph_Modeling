package com.example.graph.service;

import com.example.graph.dto.request.*;

public interface EdgeService {
    Integer createEdge(EdgeReviewedReqDto reqDto);
    Object createMovieToMovie(MovieTwoCreateReqDto reqDto);
    Object createReviewToMovie(EdgeReviewedReqDto reqDto);
    Object createEdgePersonToMovie(EdgePtoMReqDto reqDto);
    Object createPersonActedInMovie(EdgePActMReqDto reqDto);
    Object findVertexEdgeVertex(VEVReqDto reqDto);
}
