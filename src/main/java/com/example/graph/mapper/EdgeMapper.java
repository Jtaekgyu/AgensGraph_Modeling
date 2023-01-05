package com.example.graph.mapper;

import com.example.graph.domain.edge.*;
import com.example.graph.dto.request.VEVReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EdgeMapper {

    Integer saveEdge(Reviewed reviewed);

    void saveMovieToMovie(EdgeMovieToMovie edge);

    void saveEdgeReviewd(EdgeReviewed edge);

    void saveEdgePersonToMovie(EdgePersonToMovie edge);

    void saveEdgePersonActedInMovie(EdgeGenPerActMov generator);

    List<Object> findAllVEV(VEVReqDto reqDto);
}
