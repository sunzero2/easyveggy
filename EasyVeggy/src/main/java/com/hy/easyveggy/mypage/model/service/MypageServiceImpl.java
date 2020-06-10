package com.hy.easyveggy.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.easyveggy.mypage.model.dao.MypageDao;
import com.hy.easyveggy.mypage.model.vo.Calendar;
import com.hy.easyveggy.review.model.vo.Review;

@Service
public class MypageServiceImpl implements MypageService {
	@Autowired
	MypageDao mypageDao;

	@Override
	public List<Review> myReview(String userId) {
		return mypageDao.myReview(userId);
	}

	@Override
	public int deleteReview(String revId) {
		return mypageDao.deleteReview(revId);
	}

	@Override
	public int updateReview(Map<String, String> data) {
		return mypageDao.updateReview(data);
	}

	@Override
	public int updateMember(Map<String, String> data) {
		return mypageDao.updateMember(data);
	}

	@Override
	public int updateVLevel(Map<String, String> data) {
		return mypageDao.updateVLevel(data);
	}

	@Override
	public List<Calendar> eventList(Map<String, String> data) {
		return mypageDao.eventList(data);
	}
	
	@Override
	public Calendar getEvent(Map<String, String> data) {
		return mypageDao.getEvent(data);
	}

	@Override
	public int addEvent(Calendar calendar) {
		return mypageDao.addEvent(calendar);
	}

	@Override
	public int updateEvent(Calendar calendar) {
		return mypageDao.updateEvent(calendar);
	}

	@Override
	public int deleteEvent(Calendar calendar) {
		return mypageDao.deleteEvent(calendar);
	}
}
