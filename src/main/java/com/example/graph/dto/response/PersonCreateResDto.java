package com.example.graph.dto.response;

import com.example.graph.domain.Person;
import lombok.Getter;

@Getter
public class PersonCreateResDto {

    String name;

    Integer born;

    String job;

    public PersonCreateResDto(Person person){
        this.name = person.getName();
        this.born = person.getBorn();
        this.job = person.getJob();
    }
}
