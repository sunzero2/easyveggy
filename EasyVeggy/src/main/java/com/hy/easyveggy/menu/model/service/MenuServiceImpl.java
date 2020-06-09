package com.hy.easyveggy.menu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.easyveggy.menu.model.dao.MenuDao;
import com.hy.easyveggy.menu.model.vo.Menu;

@Repository
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuDao menuDao;
	
	public List<String> vLevel(String[] ingArr) {
		return menuDao.vLevel(ingArr);
	}

	@Override
	public List<Map<Object, Object>> recommendMenus(String vlevel) {
		return menuDao.recommendMenus(vlevel);
	}
}
