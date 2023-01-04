package com.example.graph.service;

import com.example.graph.dto.request.PersonReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import com.example.graph.dto.response.PersonCreateResDto;
import com.example.graph.dto.response.PersonResDto;

import java.util.List;

public interface PersonService {

    PersonCreateResDto create(PersonReqDto reqDto);

    List<PersonResDto> findAll();

    List<PersonResDto> findAllByObject(PersonReqDto reqDto);

    Integer updateByObject(PersonUpdateReqDto reqDto);

    Integer deleteByObject(PersonReqDto reqDto);
}
