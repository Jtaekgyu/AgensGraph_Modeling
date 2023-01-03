package com.example.graph.service;

import com.example.graph.domain.Movie;
import com.example.graph.domain.Person;
import com.example.graph.domain.Review;
import com.example.graph.domain.edge.EdgeDirected;
import com.example.graph.domain.edge.EdgeMovieToMovie;
import com.example.graph.domain.edge.EdgeReviewed;
import com.example.graph.domain.edge.Reviewed;
import com.example.graph.dto.request.EdgeDirectedReqDto;
import com.example.graph.dto.request.EdgeReviewedReqDto;
import com.example.graph.dto.request.MovieTwoCreateReqDto;
import com.example.graph.mapper.EdgeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EdgeServiceImpl implements EdgeService{

    private final EdgeMapper edgeMapper;

    public void createEdge(EdgeReviewedReqDto reqDto){
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

    public Object createReviewToMovie(EdgeReviewedReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieCreateReqDto());

        SimpleDirectedGraph<Object, EdgeReviewed> graph = new SimpleDirectedGraph<Object, EdgeReviewed>(EdgeReviewed.class);
        graph.addVertex(review);
        graph.addVertex(movie);

        EdgeReviewed edge = new EdgeReviewed(review, movie, reqDto.getEdgeName());
        graph.addEdge(review, movie, edge);

        edgeMapper.saveEdgeReviewd(edge); // 많으면 list로 줘야할듯
        return graph.getAllEdges(review, movie);
    }

    public Object createEdgeDirected(EdgeDirectedReqDto reqDto){
        Person person = new Person(reqDto.getPersonCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieCreateReqDto());

        SimpleDirectedGraph<Object, EdgeDirected> graph = new SimpleDirectedGraph<Object, EdgeDirected>(EdgeDirected.class);
        graph.addVertex(person);
        graph.addVertex(movie);

        EdgeDirected edge = new EdgeDirected(person, movie, reqDto.getEdgeName());
        graph.addEdge(person, movie, edge);

        edgeMapper.saveEdgeDirected(edge);
        return graph.getAllEdges(person, movie);
    }
}
