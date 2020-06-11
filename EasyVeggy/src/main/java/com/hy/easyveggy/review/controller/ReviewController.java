package com.hy.easyveggy.review.controller;

import java.util.ArrayList;
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
	public List<Review> getReviews(@RequestParam Map<String, String> data) {
		System.out.println("ReviewController getReviews Method Run");
		List<Review> list = reviewService.getReviews(data);
		List<Review> revList = new ArrayList<>();
		int index = Integer.parseInt(data.get("index"));
		
		try {
			for (int i = 0; i < 5; i++) {
				int cnt = i % 5;
				int idx = cnt + (5 * index);
				revList.add(list.get(idx));
			}
		} catch (IndexOutOfBoundsException e) {
			
		}
		return revList;
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
