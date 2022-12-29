package com.example.graph.mapper;

import com.example.graph.domain.edge.Reviewed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EdgeMapper {

    void saveEdge(Reviewed reviewed);
}
