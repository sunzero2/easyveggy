package com.hy.easyveggy.mypage.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.easyveggy.mypage.model.vo.Calendar;
import com.hy.easyveggy.review.model.vo.Review;

@Repository
public class MypageDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<Review> myReview(String userId) {
		return sqlSession.selectList("Mypage.selectReview", userId);
	}
	
	public int deleteReview(String revId) {
		return sqlSession.delete("Mypage.deleteReview", revId);
	}
	
	public int updateReview(Map<String, String> data) {
		return sqlSession.update("Mypage.updateReview", data);
	}
	
	public int updateMember(Map<String, String> data) {
		return sqlSession.update("Mypage.updateMember", data);
	}
	
	public int updateVLevel(Map<String, String> data) {
		return sqlSession.update("Mypage.updateVL", data);
	}
	
	public List<Calendar> eventList(Map<String, String> data) {
		return sqlSession.selectList("Mypage.eventList", data);
	}
	
	public Calendar getEvent(Map<String, String> data) {
		return sqlSession.selectOne("Mypage.getEvent", data);
	}
	
	public int addEvent(Calendar calendar) {
		return sqlSession.insert("Mypage.addEvent", calendar);
	}
	
	public int updateEvent(Calendar calendar) {
		return sqlSession.update("Mypage.updateEvent", calendar);
	}
	
	public int deleteEvent(Calendar calendar) {
		return sqlSession.delete("Mypage.deleteEvent", calendar);
	}
}
