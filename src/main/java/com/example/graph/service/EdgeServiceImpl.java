package com.example.graph.service;

import com.example.graph.domain.*;
import com.example.graph.domain.edge.*;
import com.example.graph.dto.request.*;
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

    public Integer createEdge(EdgeReviewedReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        Reviewed reviewed = new Reviewed(review, movie);
        return edgeMapper.saveEdge(reviewed);
    }

    public Object createMovieToMovie(MovieTwoCreateReqDto reqDto){
        Movie movie1 = new Movie(reqDto.getMovieReqDto1());
        Movie movie2 = new Movie(reqDto.getMovieReqDto2());

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
        Movie movie = new Movie(reqDto.getMovieReqDto());

        SimpleDirectedGraph<Object, EdgeReviewed> graph = new SimpleDirectedGraph<Object, EdgeReviewed>(EdgeReviewed.class);
        graph.addVertex(review);
        graph.addVertex(movie);

        EdgeReviewed edge = new EdgeReviewed(review, movie, reqDto.getEdgeName());
        graph.addEdge(review, movie, edge);

        edgeMapper.saveEdgeReviewd(edge);
        return graph.edgeSet();
//        return graph.getAllEdges(review, movie);
    }

    public Object createEdgePersonToMovie(EdgePtoMReqDto reqDto){
        Person person = new Person(reqDto.getPersonReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());

        SimpleDirectedGraph<Object, EdgePersonToMovie> graph = new SimpleDirectedGraph<Object, EdgePersonToMovie>(EdgePersonToMovie.class);
        graph.addVertex(person);
        graph.addVertex(movie);

        EdgePersonToMovie edge = new EdgePersonToMovie(person, movie, reqDto.getEdgeName());
        graph.addEdge(person, movie, edge);

        edgeMapper.saveEdgePersonToMovie(edge);
//        return graph.edgesOf(person);
//        return graph.vertexSet();
//        return graph.getAllEdges(person, movie);
        return graph.edgeSet();
    }

    public Object CreatePersonActedInMovie(EdgePActMReqDto reqDto){
        Person person = new Person(reqDto.getPersonReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgeActedIn edge = new EdgeActedIn(reqDto.getEdgeAppearedReqDto());

//        SimpleDirectedGraph<Object, GeneratorPerActMov> graph = new SimpleDirectedGraph<Object, GeneratorPerActMov>(GeneratorPerActMov.class);
        SimpleDirectedGraph<Object, EdgeActedIn> graph = new SimpleDirectedGraph<Object, EdgeActedIn>(EdgeActedIn.class);
        graph.addVertex(person);
        graph.addVertex(movie);

        GeneratorPerActMov generator = new GeneratorPerActMov(person, edge, movie);
        graph.addEdge(person, movie, edge);
//        graph.addEdge(person, movie, generator);
        edgeMapper.saveEdgePersonActedInMovie(generator);

        List<Object> resultList = new ArrayList<>();
        resultList.add(graph.vertexSet());
        resultList.add(graph.edgeSet());
        return resultList;
        // generator를 edge로 사용시 반환
//        return graph.vertexSet(); // vertex들
//        return graph.edgeSet(); // edge들
    }

    public List<Object> findVertexEdgeVertex(VEVReqDto reqDto){
        List<Object> resObjList = new ArrayList<>();
        List<Object> tmpObject = edgeMapper.findAllVEV(reqDto);
        for(Object tmpObj : tmpObject ){
            resObjList.add(tmpObj);
        }
        return resObjList;
    }

    // 현재 person과 movie가 implements Node 하지 않았기 때문에 돌아가지는 않는다.
    /*public Object EdgePersonToMovieByIfc(EdgePtoMReqDto reqDto){
        Vperson vperson = new Vperson(reqDto.getPersonReqDto());
        Vmovie vmovie = new Vmovie(reqDto.getMovieReqDto());

        SimpleDirectedGraph<Vertex<Node>, EdgePersonToMovie> graph
                = new SimpleDirectedGraph<Vertex<Node>, EdgePersonToMovie>(EdgePersonToMovie.class);
        Vertex<Node> vertex = new Vertex(vperson);
        graph.addEdge(vertex);
        graph.addVertex()
    }*/
}
