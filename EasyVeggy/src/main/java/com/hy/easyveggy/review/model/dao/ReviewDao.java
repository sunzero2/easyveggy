package com.hy.easyveggy.review.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.easyveggy.review.model.vo.Review;

@Repository
public class ReviewDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<Review> getReviews(Map<String, String> data) {
		return sqlSession.selectList("Review.selectReview", data);
	}
	
	public int addReview(Review review) {
		return sqlSession.insert("Review.insertReview", review);
	}
}
