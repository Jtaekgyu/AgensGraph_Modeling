package com.example.graph.mapper;

import com.example.graph.domain.Person;
import com.example.graph.dto.request.PersonObjectReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    void save(Person person);

    List<Person> findAll();

    List<Person> findAllByObject(PersonObjectReqDto reqDto);

    Integer updateByObject(PersonUpdateReqDto reqDto);

    Integer deleteByObject(PersonObjectReqDto reqDto);
}
