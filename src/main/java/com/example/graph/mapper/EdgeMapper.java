package com.example.graph.mapper;

import com.example.graph.domain.edge.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdgeMapper {

    void saveEdge(Reviewed reviewed);

    void saveMovieToMovie(EdgeMovieToMovie edge);

    void saveEdgeReviewd(EdgeReviewed edge);

    void saveEdgePersonToMovie(EdgePersonToMovie edge);

}
