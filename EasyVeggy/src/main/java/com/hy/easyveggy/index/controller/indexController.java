package com.hy.easyveggy.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
	
	@RequestMapping("/index/index.do")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index/index");
		return mav;
	}
}
