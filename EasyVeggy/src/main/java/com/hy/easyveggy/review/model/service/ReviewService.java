package com.hy.easyveggy.review.model.service;

import java.util.List;
import java.util.Map;

import com.hy.easyveggy.review.model.vo.Review;

public interface ReviewService {
	public List<Review> getReviews(Map<String, String> data);
}
