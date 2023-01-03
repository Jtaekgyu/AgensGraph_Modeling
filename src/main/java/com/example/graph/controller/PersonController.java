package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.PersonReqDto;
import com.example.graph.dto.request.PersonUpdateReqDto;
import com.example.graph.dto.response.PersonResDto;
import com.example.graph.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/create")
    public Response<?> create(@RequestBody PersonReqDto reqDto){
        PersonResDto resDto = personService.create(reqDto);
        return Response.success(resDto);
    }

    @GetMapping
    public Response<List<PersonResDto>> findAll(){
        List<PersonResDto> resDtoList = personService.findAll();
        return Response.success(resDtoList);
    }

    @GetMapping("/Object")
    public Response<List<PersonResDto>> findAllByObject(@RequestBody PersonReqDto reqDto){
        List<PersonResDto> resDtoList = personService.findAllByObject(reqDto);
        return Response.success(resDtoList);
    }

    @PutMapping
    public Response<Integer> updateByObject(@RequestBody PersonUpdateReqDto reqDto){
        Integer result = personService.updateByObject(reqDto);
        return Response.success(result);
    }

    @DeleteMapping("/object")
    public Response<Integer> deleteByObject(@RequestBody PersonReqDto reqDto){
        Integer result = personService.deleteByObject(reqDto);
        return Response.success(result);
    }

}
