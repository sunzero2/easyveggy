package com.hy.easyveggy.menu.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.easyveggy.menu.model.vo.Menu;

@Repository
public class MenuDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<String> vLevel(String[] ingArr) {
		return sqlSession.selectList("Menu.vLevel", ingArr);
	}
	
	public List<Map<Object, Object>> recommendMenus(String vlevel) {
		return sqlSession.selectList("Menu.recommend", vlevel);
	}
}
