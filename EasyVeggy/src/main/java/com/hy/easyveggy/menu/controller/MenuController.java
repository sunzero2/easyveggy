package com.hy.easyveggy.menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hy.easyveggy.menu.model.service.MenuServiceImpl;
import com.hy.easyveggy.menu.model.vo.Menu;

@Controller
public class MenuController {
	@Autowired
	MenuServiceImpl menuService;
	
	/**
	  * @Method Name : vLevel
	  * @작성일 : 2020. 6. 9.
	  * @작성자 : 이혜영
	  * @Method 설명 : 선택한 재료를 토대로 채식 지향을 반환하는 메소드
	  */
	@RequestMapping("/menu/vlevel.do")
	@ResponseBody
	public List<String> vLevel(String ingArr) {
		String vLevel = "";
		String[] str = ingArr.split("/");
		List<String> vList = menuService.vLevel(str);

		return vList;
	}
	
	/**
	  * @Method Name : recommendMenus
	  * @작성일 : 2020. 6. 9.
	  * @작성자 : 이혜영
	  * @Method 설명 : 채식 지향을 토대로 추천 메뉴를 반환하는 메소드
	  */
	@RequestMapping("/menu/recommendmenu.do")
	@ResponseBody
	public List<Map<Object, Object>> recommendMenus(String vlevel) {
		return menuService.recommendMenus(vlevel);
	}
}
