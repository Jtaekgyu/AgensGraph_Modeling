package com.example.graph.mapper;

import com.example.graph.domain.Review;
import com.example.graph.dto.request.ReviewFindAllReqDto;
import com.example.graph.dto.response.ReviewResDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    void setGraphPath();

    Integer save(Review review);

    List<Review> findAll();

    List<Review> findByReviewer(String reviewer);

    List<Review> findAllByObject(ReviewFindAllReqDto reqDto);

    Integer deleteByReviewer(String reviewer);

}
