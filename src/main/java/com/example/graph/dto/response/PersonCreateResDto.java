package com.example.graph.dto.response;

import com.example.graph.domain.Person;
import lombok.Getter;

@Getter
public class PersonCreateResDto {

    private String name;

    private Integer born;

    private String job;

    public PersonCreateResDto(Person person){
        this.name = person.getName();
        this.born = person.getBorn();
        this.job = person.getJob();
    }
}
