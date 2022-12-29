package com.example.graph.controller;

import com.example.graph.controller.response.Response;
import com.example.graph.dto.request.EdgeCreateReqDto;
import com.example.graph.service.EdgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edge")
@RequiredArgsConstructor
public class EdgeController {

    private final EdgeService edgeService;

    @PostMapping("/create")
    public Response<?> setEdge (@RequestBody EdgeCreateReqDto reqDto){
        edgeService.createEdge(reqDto);
        return null;
    }
}
