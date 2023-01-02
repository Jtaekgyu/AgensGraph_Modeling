package com.example.graph.service;

import com.example.graph.controller.response.Response;
import com.example.graph.domain.Person;
import com.example.graph.dto.request.PersonCreateReqDto;
import com.example.graph.dto.request.PersonObjectReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import com.example.graph.dto.response.PersonResDto;
import com.example.graph.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonMapper personMapper;

    public PersonResDto create(PersonCreateReqDto reqDto){
        Person person = new Person(reqDto);
        personMapper.save(person);
        PersonResDto resDto = new PersonResDto(person);
        return resDto;
    }

    public List<PersonResDto> findAll(){
        List<PersonResDto> personResDtoList = new ArrayList<>();
        List<Person> personList = personMapper.findAll();
        for(Person tmpPerson: personList){
            personResDtoList.add(new PersonResDto(tmpPerson));
        }
        return personResDtoList;
    }

    public List<PersonResDto> findAllByObject(PersonObjectReqDto reqDto){
        List<PersonResDto> personResDtoList = new ArrayList<>();
        List<Person> personList = personMapper.findAllByObject(reqDto);
        for(Person tmpPerson : personList){
            personResDtoList.add(new PersonResDto(tmpPerson));
        }
        return personResDtoList;
    }

    public Integer updateByObject(PersonUpdateReqDto reqDto){
        Integer result = personMapper.updateByObject(reqDto);
        return result;
    }

    public Integer deleteByObject(PersonObjectReqDto reqDto){
        Integer result = personMapper.deleteByObject(reqDto);
        return result;
    }
}
