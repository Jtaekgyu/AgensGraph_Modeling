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
        return graphConnect(movie1, edge1, movie2);
    }

    public Object createReviewToMovie(EdgeReviewedReqDto reqDto){
        Review review = new Review(reqDto.getReviewCreateReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgeReviewed edge = new EdgeReviewed(review, movie, reqDto.getEdgeName());

        edgeMapper.saveEdgeReviewd(edge);
        return graphConnect(review, edge, movie);
    }
    public Object createEdgePersonToMovie(EdgePtoMReqDto reqDto){
        Person person = new Person(reqDto.getPersonReqDto());
        Movie movie = new Movie(reqDto.getMovieReqDto());
        EdgePersonToMovie edge = new EdgePersonToMovie(person, movie, reqDto.getEdgeName());

        edgeMapper.saveEdgePersonToMovie(edge);
        return graphConnect(person, edge, movie);
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

    public <V1, E, V2> E testgraphMehtod(V1 startV, E edge, V2 endV){
        SimpleDirectedGraph<Object, E> graph = new SimpleDirectedGraph<Object, E>((Class<? extends E>) edge.getClass());
        graph.addVertex(startV);
        graph.addVertex(endV);
        graph.addEdge(startV, endV, edge);
        return graph.getEdge(startV,endV); // 집합은 아니고 startV,endV에 커넥션된 vertex와 edge를 반환한다.
    }

    public <V1, E, V2> Set<E> graphConnect(V1 startV, E edge, V2 endV){
        SimpleDirectedGraph<Object, E> graph = new SimpleDirectedGraph<Object, E>((Class<? extends E>) edge.getClass());

        graph.addVertex(startV);
        graph.addVertex(endV);
        graph.addEdge(startV, endV, edge);
//        return graph.edgesOf(startV); // Vertex에 있는 모든 edge 집합(edge와 연결된 vertex와 edge)을 반환
//        return graph.vertexSet(); // graph에 있는 vertexSet(vertex와 연결된 모든 vertex와 edge)을 반환
//        return graph.getAllEdges(startV, endV); // sourceV와 targetV를 잇는 모든 edgeSet(edge와 연결된 vertex와 edge)을 반환
//        return graph.getEdge(startV,endV); // 집합은 아니고 startV,endV에 커넥션된 vertex와 edge를 반환한다.
        return graph.edgeSet(); // graph의 edgeSet을 반환
    }
    public <V1, E, V2> List<Object> graphConnectList(V1 startV, E edge, V2 endV){
        SimpleDirectedGraph<Object, E> graph = new SimpleDirectedGraph<Object, E>((Class<? extends E>) edge.getClass());

        graph.addVertex(startV);
        graph.addVertex(endV);
        graph.addEdge(startV, endV, edge);

        List<Object> resultList = new ArrayList<>();
        // 사실 지금은 V1-E->V2 하나이다.
        resultList.add(graph.vertexSet());
        resultList.add(graph.edgeSet());
        return resultList;
    }

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
