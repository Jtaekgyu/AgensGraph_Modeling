package com.example.graph.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonCreateReqDto {

    String name;

    Integer born;

    String job;

}
