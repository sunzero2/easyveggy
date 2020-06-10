package com.hy.easyveggy.member.model.service;

import com.hy.easyveggy.member.model.dao.MemberDao;
import com.hy.easyveggy.member.model.vo.Member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	@Override
	public Member login(Map<String, String> data) {
		return memberDao.login(data);
	}

	@Override
	public int join(Member data) {
		return memberDao.join(data);
	}

	@Override
	public String searchId(Map<String, String> data) {
		return memberDao.searchId(data);
	}

	@Override
	public String searchPw(Map<String, String> data) {
		return memberDao.searchPw(data);
	}

	@Override
	public int changePw(Map<String, String> data) {
		return memberDao.changePw(data);
	}
}
