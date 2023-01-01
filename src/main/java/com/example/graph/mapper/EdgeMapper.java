package com.example.graph.mapper;

import com.example.graph.domain.edge.EdgeMovieToMovie;
import com.example.graph.domain.edge.EdgeReviewed;
import com.example.graph.domain.edge.Reviewed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdgeMapper {

    void saveEdge(Reviewed reviewed);

    void saveMovieToMovie(EdgeMovieToMovie edge);

    void saveEdgeReviewd(EdgeReviewed edge);
}
