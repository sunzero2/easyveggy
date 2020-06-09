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
	
	@RequestMapping("/menu/vlevel.do")
	@ResponseBody
	public List<String> vLevel(String ingArr) {
		String vLevel = "";
		String[] str = ingArr.split("/");
		List<String> vList = menuService.vLevel(str);

		return vList;
	}
	
	@RequestMapping("/menu/recommendmenu.do")
	@ResponseBody
	public List<Map<Object, Object>> recommendMenus(String vlevel) {
		return menuService.recommendMenus(vlevel);
	}
}
