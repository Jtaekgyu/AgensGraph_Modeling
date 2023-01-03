package com.example.graph.dto.request;

import lombok.Getter;

@Getter
public class EdgePtoMReqDto {

    PersonCreateReqDto personCreateReqDto;
    MovieCreateReqDto movieCreateReqDto;
    String edgeName;
}
