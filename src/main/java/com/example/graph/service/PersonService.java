package com.example.graph.service;

import com.example.graph.dto.request.PersonCreateReqDto;
import com.example.graph.dto.request.PersonObjectReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import com.example.graph.dto.response.PersonResDto;

import java.util.List;

public interface PersonService {

    PersonResDto create(PersonCreateReqDto reqDto);

    List<PersonResDto> findAll();

    List<PersonResDto> findAllByObject(PersonObjectReqDto reqDto);

    Integer updateByObject(PersonUpdateReqDto reqDto);

    Integer deleteByObject(PersonObjectReqDto reqDto);
}
