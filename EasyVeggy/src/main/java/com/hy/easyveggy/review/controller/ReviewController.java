package com.hy.easyveggy.review.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.easyveggy.member.model.vo.Member;
import com.hy.easyveggy.mypage.model.vo.Calendar;
import com.hy.easyveggy.review.model.service.ReviewService;
import com.hy.easyveggy.review.model.vo.Review;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	/**
	  * @Method Name : getReviews
	  * @작성일 : 2020. 6. 9.
	  * @작성자 : 이혜영
	  * @Method 설명 : 리뷰 가져오는 메소드
	  */
	@RequestMapping("/review/getreview.do")
	@ResponseBody
	public Map getReviews(@RequestParam Map<String, String> data) {
		int count = reviewService.reviewCount(data.get("menuId"));
		List<Review> reviews = reviewService.getReviews(data);
		Map reviewMap = new HashMap();
		reviewMap.put("count", count);
		reviewMap.put("reviews", reviews);
		
		return reviewMap;
	}
	
	/**
	  * @Method Name : addReview
	  * @작성일 : 2020. 6. 11.
	  * @작성자 : 이혜영
	  * @Method 설명 : 리뷰 추가하는 메소드
	  */
	@RequestMapping("/review/addreview.do")
	@ResponseBody
	public int addReview(Review review, HttpSession session) {
		review.setUserId(((Member)session.getAttribute("loginInfo")).getUserId());
		return reviewService.addReview(review);
	}
}
