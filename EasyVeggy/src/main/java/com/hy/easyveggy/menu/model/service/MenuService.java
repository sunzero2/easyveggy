package com.hy.easyveggy.menu.model.service;

import java.util.List;
import java.util.Map;

public interface MenuService {
	public List<String> vLevel(String[] ingArr);
	public List<Map<Object, Object>> recommendMenus(String vlevel);
}
