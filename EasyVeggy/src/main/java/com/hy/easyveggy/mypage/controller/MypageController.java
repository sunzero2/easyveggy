package com.hy.easyveggy.mypage.controller;

import java.util.EventListener;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hy.easyveggy.member.model.vo.Member;
import com.hy.easyveggy.mypage.model.service.MypageService;
import com.hy.easyveggy.mypage.model.vo.Calendar;
import com.hy.easyveggy.review.model.vo.Review;

@Controller
public class MypageController {
	@Autowired
	MypageService mypageService;
	
	/**
	  * @Method Name : mypageMain
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 마이페이지로 이동하는 메소드
	  */
	@RequestMapping("/mypage/main.do")
	public ModelAndView mypageMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/mypageMain");
		return mav;
	}
	
	/**
	  * @Method Name : inten
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 채식지향 설정으로 이동하는 메소드
	  */
	@RequestMapping("/mypage/inten.do")
	public ModelAndView inten() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/vganInten");
		return mav;
	}
	
	/**
	  * @Method Name : privacy
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 개인정보 수정으로 이동하는 메소드
	  */
	@RequestMapping("/mypage/privacy.do")
	public ModelAndView privacy() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/privacy");
		return mav;
	}
	
	/**
	  * @Method Name : myReview
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 나의 리뷰보기로 이동하는 메소드
	  */
	@RequestMapping("/mypage/myreview.do")
	@ResponseBody
	public List<Review> myReview(String userId) {
		return mypageService.myReview(userId);
	}
	
	/**
	  * @Method Name : deleteReview
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 리뷰 삭제 메소드
	  */
	@RequestMapping("/mypage/delreview.do")
	@ResponseBody
	public int deleteReview(String revId) {
		return mypageService.deleteReview(revId);
	}
	
	/**
	  * @Method Name : updateReview
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 리뷰 수정 메소드
	  */
	@RequestMapping("/mypage/chgreview.do")
	@ResponseBody
	public int updateReview(@RequestParam Map<String, String> data) {
		return mypageService.updateReview(data);
	}
	
	/**
	  * @Method Name : updateMember
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 개인 정보 수정 메소드
	  */
	@RequestMapping("/mypage/changemem.do")
	public ModelAndView updateMember(@RequestParam Map<String, String> data, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member) session.getAttribute("loginInfo");
		
		if(!data.containsKey("nickname")) {
			data.put("nickname", member.getNickname());
		}
		
		if(!data.containsKey("password")) {
			data.put("pw", member.getPw());
		}
		
		if(!data.containsKey("cell")) {
			data.put("cell", member.getCell());
		}
		
		data.put("userEmail", member.getUserEmail());
		int res = mypageService.updateMember(data);
		
		if(res > 0) {
			member.setNickname(data.get("nickname"));
			member.setCell(data.get("cell"));
			member.setPw(data.get("pw"));
			
			session.setAttribute("loginInfo", member);
			mav.addObject("alertMsg", "회원 정보 수정에 성공하였습니다.");
		} else {
			mav.addObject("alertMsg", "회원 정보 수정에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		mav.setViewName("/mypage/privacy");
		return mav;
	}
	
	/**
	  * @Method Name : updateVLevel
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 채식지향 수정 메소드
	  */
	@RequestMapping("/mypage/changevl.do")
	public ModelAndView updateVLevel(HttpSession session, String vLevel) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member) session.getAttribute("loginInfo");
		Map<String, String> data = new HashMap<String, String>();
		data.put("userEmail", member.getUserEmail());
		data.put("vLevel", vLevel);
		
		int res = mypageService.updateVLevel(data);
		
		if(res > 0) {
			member.setvLId(vLevel);
			session.setAttribute("loginInfo", member);
			mav.addObject("alertMsg", "정상적으로 변경되었습니다.");
		} else {
			mav.addObject("alertMsg", "변경에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		mav.setViewName("mypage/vganInten");
		return mav;
	}
	
	// 캘린더
	/**
	 * @Method Name : calendar
	 * @작성일 : 2020. 7. 14.
	 * @작성자 : 이혜영
	 * @Method 설명 : 캘린더로 이동하는 메소드
	 * 			일정 리스트도 가져옴
	 */
	@RequestMapping("/mypage/calendar.do")
	public ModelAndView calendar(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		GregorianCalendar calendar = new GregorianCalendar();
		String month = String.valueOf(calendar.get(calendar.MONTH) + 1);
		mav.addObject("calList", eventList(month, session));
		mav.setViewName("calendar/calendar");
		return mav;
	}
	
	/**
	  * @Method Name : subCalendar
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 캘린더 서브 페이지로 이동하는 메소드
	  */
	@RequestMapping("/mypage/calsub.do")
	public ModelAndView subCalendar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calendar/calendarSub");
		return mav;
	}
	
	/**
	  * @Method Name : eventList
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정 리스트를 가져오는 메소드(캘린더 페이지에 들어갈 때 사용됨)
	  */
	@RequestMapping("/mypage/eventlist.do")
	@ResponseBody
	public List<Calendar> eventList(String month, HttpSession session) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userId", ((Member)session.getAttribute("loginInfo")).getUserId());
		data.put("month", month);
		return mypageService.eventList(data);
	}
	
	/**
	  * @Method Name : getEvent
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정을 가져오는 리스트(캘린더 서브 페이지로 이동할 때 사용됨)
	  */
	@RequestMapping("/mypage/getevent.do")
	@ResponseBody
	public Calendar getEvent(int day, int month, HttpSession session) {
		String date = "%";
		
		if(month < 10) {
			date += "0" + month;
		} else {
			date += month;
		}
		
		date += "/";
		
		if(day < 10) {
			date += "0" + day;
		} else {
			date += day;
		}
		
		date += "%";
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("userEmail", ((Member) session.getAttribute("loginInfo")).getUserEmail());
		data.put("date", date);
		
		return mypageService.getEvent(data);
	}
	
	/**
	  * @Method Name : event
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정 추가, 삭제, 변경 총괄 메소드(버튼의 값으로 확인)
	  */
	@RequestMapping("/mypage/event.do")
	public ModelAndView event(Calendar calendar, String btn, HttpSession session) {
		ModelAndView mav = null;
		
		calendar.setUserId(((Member) session.getAttribute("loginInfo")).getUserId());
		String date = calendar.getcDate();
		String year = date.substring(0, 4);
		String month = "";
		
		if(date.substring(7, 8).equals("월")) {
			month = "0" + date.substring(6, 7);
		} else {
			month = date.substring(6, 8);
		}
		
		String day = date.substring(date.length()-2, date.length());
		String cDate = year + "/" + month + "/" + day;
		calendar.setcDate(cDate);
		
		if(btn.equals("save")) {
			addEvent(calendar);
		} else if(btn.equals("change")) {
			updateEvent(calendar);
		} else {
			deleteEvent(calendar);
		}
		return mav;
	}
	
	/**
	  * @Method Name : addEvent
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정 추가 메소드
	  */
	public ModelAndView addEvent(Calendar calendar) {
		ModelAndView mav = new ModelAndView();
		int res = mypageService.addEvent(calendar);
		
		if(res > 0) {
			mav.addObject("addEvent", "일정 추가에 성공하였습니다.");
		} else {
			mav.addObject("addEvent", "일정 추가에 실패하였습니다. 다시 시도해주십시오.");
		}
		mav.setViewName("calendar/calendar");
		return mav;
	}
	
	/**
	  * @Method Name : updateEvent
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정 변경 메소드
	  */
	public ModelAndView updateEvent(Calendar calendar) {
		ModelAndView mav = new ModelAndView();
		int res = mypageService.updateEvent(calendar);
		
		if(res > 0) {
			mav.addObject("changeEvent", "일정 변경에 성공하였습니다.");
			mav.addObject("success", "일정 변경에 성공하였습니다.");
		} else {
			mav.addObject("changeEvent", "일정 변경에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		mav.setViewName("calendar/calenar");
		return mav;
	}
	
	/**
	  * @Method Name : deleteEvent
	  * @작성일 : 2020. 7. 14.
	  * @작성자 : 이혜영
	  * @Method 설명 : 일정 삭제 메소드
	  */
	public ModelAndView deleteEvent(Calendar calendar) {
		ModelAndView mav = new ModelAndView();
		int res = mypageService.deleteEvent(calendar);
		
		if(res > 0) {
			mav.addObject("removeEvent", "일정 삭제에 성공하였습니다.");
			mav.addObject("success", "일정 삭제에 성공하였습니다.");
		} else {
			mav.addObject("removeEvent", "일정 삭제에 실패하였습니다. 다시 시도해주십시오.");
		}
		mav.setViewName("calendar/calendar");
		return mav;
	}
}
