package com.example.graph.domain.edge;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneratorPerActMov {

    private Person person;

    private EdgeActedIn edge;

    private Movie movie;

}
