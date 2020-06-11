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
	
	@RequestMapping("/mypage/main.do")
	public ModelAndView mypageMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/mypageMain");
		return mav;
	}
	
	@RequestMapping("/mypage/calendar.do")
	public ModelAndView calendar(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		GregorianCalendar calendar = new GregorianCalendar();
		String month = String.valueOf(calendar.get(calendar.MONTH) + 1);
		mav.addObject("calList", eventList(month, session));
		mav.setViewName("calendar/calendar");
		return mav;
	}
	
	@RequestMapping("/mypage/inten.do")
	public ModelAndView inten() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/vganInten");
		return mav;
	}
	
	@RequestMapping("/mypage/privacy.do")
	public ModelAndView privacy() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/privacy");
		return mav;
	}
	
	@RequestMapping("/mypage/myreview.do")
	@ResponseBody
	public List<Review> myReview(String userId) {
		return mypageService.myReview(userId);
	}
	
	@RequestMapping("/mypage/delreview.do")
	@ResponseBody
	public int deleteReview(String revId) {
		return mypageService.deleteReview(revId);
	}
	
	@RequestMapping("/mypage/chgreview.do")
	@ResponseBody
	public int updateReview(@RequestParam Map<String, String> data) {
		return mypageService.updateReview(data);
	}
	
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
			
			switch (vLevel) {
			case "FXT":
				vLevel = "플렉시테리언";
				break;
			case "POP":
				vLevel = "폴로페스코";
				break;
			case "PSC":
				vLevel = "페스코";
				break;
			case "POL":
				vLevel = "폴로";
				break;
			case "LOV":
				vLevel = "락토오보";
				break;
			case "LTO":
				vLevel = "락토";
				break;
			case "OVO":
				vLevel = "오보";
				break;
			case "VGN":
				vLevel = "비건";
				break;
			case "FTN":
				vLevel = "프루테리언";
				break;
			}
			mav.addObject("setVLevel", vLevel);
			mav.addObject("alertMsg", "정상적으로 변경되었습니다.");
		} else {
			mav.addObject("alertMsg", "변경에 실패하였습니다. 다시 시도해주십시오.");
		}
		
		mav.setViewName("mypage/vganInten");
		return mav;
	}
	
	@RequestMapping("/mypage/calsub.do")
	public ModelAndView subCalendar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calendar/calendarSub");
		return mav;
	}
	
	@RequestMapping("/mypage/eventlist.do")
	@ResponseBody
	public List<Calendar> eventList(String month, HttpSession session) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userId", ((Member)session.getAttribute("loginInfo")).getUserId());
		data.put("month", month);
		return mypageService.eventList(data);
	}
	
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
			
		} else if(btn.equals("change")) {
			
		} else {
			
		}
		return mav;
	}
	
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
