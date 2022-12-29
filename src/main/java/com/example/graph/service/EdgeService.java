package com.example.graph.service;

import com.example.graph.dto.request.EdgeCreateReqDto;

public interface EdgeService {
    void createEdge(EdgeCreateReqDto reqDto);
}
