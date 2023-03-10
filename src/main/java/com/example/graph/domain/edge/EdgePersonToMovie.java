package com.example.graph.domain.edge;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EdgePersonToMovie {

    private Person person;

    private Movie movie;

    String edgeName;

}
