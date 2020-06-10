package com.hy.easyveggy.member.model.service;

import java.util.Map;

import com.hy.easyveggy.member.model.vo.Member;

public interface MemberService {
	public Member login(Map<String, String> data);
	public int join(Member data);
	public String searchId(Map<String, String> data);
	public String searchPw(Map<String, String> data);
	public int changePw(Map<String, String> data);
	
}
