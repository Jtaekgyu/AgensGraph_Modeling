package com.example.graph.service;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Review;
import com.example.graph.domain.edge.Reviewed;
import com.example.graph.dto.request.EdgeCreateReqDto;
import com.example.graph.dto.request.ReviewCreateReqDto;
import com.example.graph.mapper.EdgeMapper;
import lombok.RequiredArgsConstructor;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EdgeServiceImpl implements EdgeService{

    private final EdgeMapper edgeMapper;

    public void createEdge(EdgeCreateReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieCreateReqDto());

        // ★★★ 일단 이거 Vertex가 무조건 같네... 음.. 나는 domain 별로 나눴는데...
        // 그럼 이거 하나의 Vertex를 사용해야할까? ... 음 Vertex 클래스 만들고 나머지를 인터페이스화 하고 implements로 상속 받을까? ... 음... 고민중
//        SimpleDirectedGraph<Review,Reviewed> graph = new SimpleDirectedGraph<Review, Reviewed>(Reviewed.class);
//        SimpleDirectedWeightedGraph<Review, Reviewed> graph = new SimpleDirectedWeightedGraph<Review, Reviewed>(Reviewed.class);

        Reviewed reviewed = new Reviewed(review, movie);
        edgeMapper.saveEdge(reviewed);
    }

}
