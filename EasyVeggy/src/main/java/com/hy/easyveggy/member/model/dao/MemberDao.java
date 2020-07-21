package com.hy.easyveggy.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.easyveggy.member.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	public Member login(Map<String, String> data) {
		return sqlSession.selectOne("Member.login", data);
	}
	
	public int join(Member data) {
		return sqlSession.insert("Member.join", data);
	}
	
	public String searchId(Map<String, String> data) {
		return sqlSession.selectOne("Member.searchId", data);
	}
	
	public String searchPw(Map<String, String> data) {
		return sqlSession.selectOne("Member.searchPw", data);
	}
	
	public int changePw(Map<String, String> data) {
		return sqlSession.update("Member.changePw", data);
	}
	
	public String emailCheck(String userEmail) {
		return sqlSession.selectOne("Member.emailCheck", userEmail);
	}
	
	public int secession(int userId) {
		return sqlSession.update("Member.secession", userId);
	}
}
