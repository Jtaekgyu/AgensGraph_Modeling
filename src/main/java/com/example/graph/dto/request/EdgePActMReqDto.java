package com.example.graph.dto.request;

import lombok.Getter;

@Getter
public class EdgePActMReqDto {

    private PersonReqDto personReqDto;
    private MovieReqDto movieReqDto;
    private EdgeAppearedReqDto edgeAppearedReqDto;
}
