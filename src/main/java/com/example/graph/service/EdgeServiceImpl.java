package com.example.graph.service;

import com.example.graph.domain.*;
import com.example.graph.domain.edge.*;
import com.example.graph.dto.request.*;
import com.example.graph.mapper.EdgeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.springframework.stereotype.Service;

import java.util.*;

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
        EdgeMovieToMovie edge1 = new EdgeMovieToMovie(movie1, movie2);

        edgeMapper.saveMovieToMovie(edge1);
        return graphMethod(movie1, edge1, movie2);
    }

    public Object createReviewToMovie(EdgeReviewedReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgeReviewed edge = new EdgeReviewed(review, movie, reqDto.getEdgeName());

        edgeMapper.saveEdgeReviewd(edge);
        return graphMethod(review, edge, movie);
    }
    public Object createEdgePersonToMovie(EdgePtoMReqDto reqDto){
        Person person = new Person(reqDto.getPersonReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgePersonToMovie edge = new EdgePersonToMovie(person, movie, reqDto.getEdgeName());

        edgeMapper.saveEdgePersonToMovie(edge);
        return graphMethod(person, edge, movie);
//        return graph.edgesOf(person);
//        return graph.vertexSet();
//        return graph.getAllEdges(person, movie);
//        return graph.edgeSet();
    }

    public Object createPersonActedInMovie(EdgePActMReqDto reqDto){
        Person person = new Person(reqDto.getPersonReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgeActedIn edge = new EdgeActedIn(reqDto.getEdgeAppearedReqDto());
        EdgeGenPerActMov edgeGen = new EdgeGenPerActMov(person, edge, movie);
        edgeMapper.saveEdgePersonActedInMovie(edgeGen);

        return graphConnectList(person, edge, movie);
    }

    public List<Object> findVertexEdgeVertex(VEVReqDto reqDto){
        List<Object> resObjList = new ArrayList<>();
        List<Object> tmpObject = edgeMapper.findAllVEV(reqDto);
        for(Object tmpObj : tmpObject ){
            resObjList.add(tmpObj);
        }
        return resObjList;
    }

    public <V1, E, V2> Set<E> graphMethod(V1 startV, E edge, V2 endV){
        SimpleDirectedGraph<Object, E> graph = new SimpleDirectedGraph<Object, E>((Class<? extends E>) edge.getClass());

        graph.addVertex(startV);
        graph.addVertex(endV);
        graph.addEdge(startV, endV, edge);

        return graph.edgeSet();
    }

    public <V1, E, V2> List<Object> graphConnectList(V1 startV, E edge, V2 endV){
        SimpleDirectedGraph<Object, E> graph = new SimpleDirectedGraph<Object, E>((Class<? extends E>) edge.getClass());

        graph.addVertex(startV);
        graph.addVertex(endV);
        graph.addEdge(startV, endV, edge);

        List<Object> resultList = new ArrayList<>();
        resultList.add(graph.vertexSet());
        resultList.add(graph.edgeSet());
        return resultList;
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
