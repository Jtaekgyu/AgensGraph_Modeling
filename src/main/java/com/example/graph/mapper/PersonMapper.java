package com.example.graph.mapper;

import com.example.graph.domain.Person;
import com.example.graph.dto.request.PersonReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    void save(Person person);

    List<Person> findAll();

    List<Person> findAllByObject(PersonReqDto reqDto);

    Integer updateByObject(PersonUpdateReqDto reqDto);

    Integer deleteByObject(PersonReqDto reqDto);
}
