package com.example.graph.domain.edge;

import com.example.graph.dto.request.EdgeAppearedReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EdgeActedIn {

    String role;

    public EdgeActedIn(EdgeAppearedReqDto reqDto){
        this.role = reqDto.getRole();
    }
}
