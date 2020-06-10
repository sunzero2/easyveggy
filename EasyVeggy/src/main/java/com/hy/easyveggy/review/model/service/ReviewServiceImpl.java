package com.hy.easyveggy.review.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.easyveggy.review.model.dao.ReviewDao;
import com.hy.easyveggy.review.model.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewDao reviewDao;

	@Override
	public List<Review> getReviews(Map<String, String> data) {
		return reviewDao.getReviews(data);
	}

	@Override
	public int addReview(Review review) {
		return reviewDao.addReview(review);
	}
}
