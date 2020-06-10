package com.hy.easyveggy.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.hy.easyveggy.member.model.service.MemberService;
import com.hy.easyveggy.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/member/goin.do")
	public ModelAndView goin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	
	@RequestMapping("/member/login.do")
	public ModelAndView login(@RequestParam Map<String, String> data, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = memberService.login(data);
		if(member != null) {
			session.setAttribute("loginInfo", member);
		}
		mav.setViewName("member/success");
		return mav;
	}
	
	@RequestMapping("/member/logout.do")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.setAttribute("loginInfo", null);
		mav.setViewName("index/index");
		return mav;
	}
	
	@RequestMapping("/member/join.do")
	public ModelAndView join(Member data) {
		ModelAndView mav = new ModelAndView();
		if(memberService.join(data) > 0) {
			mav.addObject("isSuccess", "가입을 축하드립니다!");
			mav.addObject("sendMsg", "가입하신 계정과 비밀번호로 로그인해주세요.");
		} else {
			mav.addObject("isSuccess", "가입 중 오류가 발생하였습니다.");
			mav.addObject("sendMsg", "같은 오류 재발생 시 고객센터로 문의바랍니다.\\n(ERR_CODE = USE001)");
		}
		mav.setViewName("member/success");
		return mav;
	}
	
	@RequestMapping("/member/searchmem.do")
	public ModelAndView searchGoin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/search");
		return mav;
	}
	
	@RequestMapping("/member/searchid.do")
	@ResponseBody
	public String searchId(@RequestParam Map<String, String> data) {
		return memberService.searchId(data);
	}
	
	@RequestMapping("/member/searchpw.do")
	@ResponseBody
	public String searchPw(@RequestParam Map<String, String> data) {
		return memberService.searchPw(data);
	}
	
	@RequestMapping("/member/changepage.do")
	public ModelAndView changePage(String user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("mamber/changePwd");
		return mav;
	}
	
	@RequestMapping("/member/changepw.do")
	@ResponseBody
	public int changePw(@RequestParam Map<String, String> data) {
		return memberService.changePw(data);
	}
}
