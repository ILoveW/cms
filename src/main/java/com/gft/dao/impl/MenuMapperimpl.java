package com.gft.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gft.dao.MenuMapper;
import com.gft.entity.Pages;

@Repository
public class MenuMapperimpl implements MenuMapper {

	/* sqlSession映射 */
	@Autowired
	SqlSessionTemplate menutemplate;

	@Override
	public List<Pages> easyfenye2(String name, String url, int page, int rows) {

		return menutemplate.selectList("com.gft.dao.MenuMapperimpl.easyfenye2", new Pages(rows, page, name, url));
	}

	@Override
	public Long getCount2() {

		return menutemplate.selectOne("com.gft.dao.MenuMapperimpl.getCount2");
	}

	/* 增加菜单 */
	@Override
	public int addMenu(Object[] obj) {

		return menutemplate.update("com.gft.dao.MenuMapperimpl.addMenu", obj);
	}

	/* 修改菜单 */
	@Override
	public int updateMenu(Object[] obj) {

		return menutemplate.update("com.gft.dao.MenuMapperimpl.updateMenu", obj);
	}

	/* 删除菜单 */
	@Override
	public int deleteMenu(int id) {

		return menutemplate.delete("com.gft.dao.MenuMapperimpl.deleteMenu", id);
	}

	/* 分页 */
	@Override
	public List<Pages> rmfenye(String role_name, String name, String url, int page, int rows) {

		return menutemplate.selectList("com.gft.dao.MenuMapperimpl.rmfenye",
				new Pages(name, url, rows, page, role_name));
	}

	@Override
	public Long rmgetCount() {

		return menutemplate.selectOne("com.gft.dao.MenuMapperimpl.rmgetCount");
	}

	/* 角色菜单修改 */
	@Override
	public int insertRMenu(Object[] obj) {

		return menutemplate.update("com.gft.dao.MenuMapperimpl.insertRMenu", obj);
	}


	@Override
	public int updateRMenu(String role_id) {
		// TODO Auto-generated method stub
		return menutemplate.delete("com.gft.dao.MenuMapperimpl.updateRMenu", role_id);
	}

}
