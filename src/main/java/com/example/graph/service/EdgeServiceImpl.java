package com.example.graph.service;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Review;
import com.example.graph.domain.edge.EdgeMovieToMovie;
import com.example.graph.domain.edge.EdgeReviewed;
import com.example.graph.domain.edge.Reviewed;
import com.example.graph.domain.Vertex;
import com.example.graph.dto.request.EdgeCreateReqDto;
import com.example.graph.dto.request.MovieCreateReqDto;
import com.example.graph.dto.request.MovieTwoCreateReqDto;
import com.example.graph.mapper.EdgeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EdgeServiceImpl implements EdgeService{

    private final EdgeMapper edgeMapper;

    public void createEdge(EdgeCreateReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieCreateReqDto());
        Reviewed reviewed = new Reviewed(review, movie);
        edgeMapper.saveEdge(reviewed);
    }

    public Object createMovieToMovie(MovieTwoCreateReqDto reqDto){
        Movie movie1 = new Movie(reqDto.getMovieCreateReqDto1());
        Movie movie2 = new Movie(reqDto.getMovieCreateReqDto2());

        SimpleDirectedGraph<Movie, EdgeMovieToMovie> graph = new SimpleDirectedGraph<Movie, EdgeMovieToMovie>(EdgeMovieToMovie.class);
        graph.addVertex(movie1);
        graph.addVertex(movie2);

        EdgeMovieToMovie edge1 = new EdgeMovieToMovie(movie1, movie2);
        graph.addEdge(edge1.getMovie1(), edge1.getMovie2(), edge1);

        edgeMapper.saveMovieToMovie(edge1);
        Object result = edge1;
//        return result;
        return graph.getAllEdges(movie1, movie2);
    }

    public Object createReviewToMovie(EdgeCreateReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieCreateReqDto());

        SimpleDirectedGraph<Object, EdgeReviewed> graph = new SimpleDirectedGraph<Object, EdgeReviewed>(EdgeReviewed.class);
        graph.addVertex(review);
        graph.addVertex(movie);

        EdgeReviewed edge1 = new EdgeReviewed(review, movie);
        graph.addEdge(review, movie, edge1);

        edgeMapper.saveEdgeReviewd(edge1); // 많으면 list로 줘야할듯
        Object result = edge1;
//        List<Object> listResult = new ArrayList<>();
//        listResult.add(graph.getAllEdges(review, movie));
//        listResult.add(graph.getEdge(review, movie));
        return graph.getAllEdges(review, movie);
//        return graph;
//        Vertex review = new Vertex<Review>(reqDto.getEdgeName(), reqDto.getReviewCreateReqDto());
//        Vertex movie = new Vertex<Movie>(reqDto.getEdgeName(), reqDto.getMovieCreateReqDto());

//        Vertex<Review> reviewV = new Vertex<Review>(reqDto.getEdgeName(), reqDto.getReviewCreateReqDto());
//        SimpleDirectedGraph<Vertex,Reviewed> graph = new SimpleDirectedGraph<Vertex, Reviewed>(Reviewed.class);
//        graph.addVertex(review);
//        graph.addVertex(movie);

//        Reviewed edge1 = new Reviewed(review, movie);
//        graph.addEdge(edge1.getReview(), edge1.getMovie()), edge1);
    }

}
