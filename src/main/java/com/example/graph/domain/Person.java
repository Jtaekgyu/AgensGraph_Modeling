package com.example.graph.domain;

import com.example.graph.dto.request.PersonReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Person {

    private String name;

    private Integer born;

    private String job;

    public Person(PersonReqDto reqDto){
        this.name = reqDto.getName();
        this.born = reqDto.getBorn();
        this.job = reqDto.getJob();
    }
}
