package com.example.graph.dto.request;

import lombok.Getter;

@Getter
public class EdgeDirectedReqDto {

    PersonCreateReqDto personCreateReqDto;
    MovieCreateReqDto movieCreateReqDto;
    String edgeName;
}
