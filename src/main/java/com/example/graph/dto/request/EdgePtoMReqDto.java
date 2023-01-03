package com.example.graph.dto.request;

import lombok.Getter;

@Getter
public class EdgePtoMReqDto {

    PersonReqDto personReqDto;
    MovieReqDto movieReqDto;
    String edgeName;
}
