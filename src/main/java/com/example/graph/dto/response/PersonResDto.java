package com.example.graph.dto.response;

import com.example.graph.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonResDto {

    String name;

    Integer born;

    String job;

    public PersonResDto(Person person){
        this.name = person.getName();
        this.born = person.getBorn();
        this.job = person.getJob();
    }
}
