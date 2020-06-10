package com.hy.easyveggy.mypage.model.service;

import java.util.List;
import java.util.Map;

import com.hy.easyveggy.mypage.model.vo.Calendar;
import com.hy.easyveggy.review.model.vo.Review;

public interface MypageService {
	public List<Review> myReview(String userId);
	public int deleteReview(String revId);
	public int updateReview(Map<String, String> data);
	public int updateMember(Map<String, String> data);
	public int updateVLevel(Map<String, String> data);
	public List<Calendar> eventList(Map<String, String> data);
	public Calendar getEvent(Map<String, String> data);
	public int addEvent(Calendar calendar);
	public int updateEvent(Calendar calendar);
	public int deleteEvent(Calendar calendar);
}
