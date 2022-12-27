package com.example.graph.mapper;

import com.example.graph.domain.Review;
import com.example.graph.dto.response.ReviewResDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    void setGraphPath();

    Long save(Review review); // 왜 Long으로 반환했드라?

//    ReviewResDto findByReviewer(String reviewer);
    List<Review> findByReviewer(String reviewer);

    Review findById(double vId);
}
