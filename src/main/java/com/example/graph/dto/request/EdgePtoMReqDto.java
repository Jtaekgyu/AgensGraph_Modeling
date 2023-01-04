package com.example.graph.dto.request;

import lombok.Getter;

@Getter
public class EdgePtoMReqDto {

    private PersonReqDto personReqDto;
    private MovieReqDto movieReqDto;
    private String edgeName;
}
