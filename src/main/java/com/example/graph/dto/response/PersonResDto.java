package com.example.graph.dto.response;

import com.example.graph.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonResDto {

    private String name;

    private Integer born;

    private String job;

    public PersonResDto(Person person){
        this.name = person.getName().substring(1, person.getName().length()-1);
        this.born = person.getBorn();
        this.job = person.getJob().substring(1, person.getJob().length()-1);
    }
}
