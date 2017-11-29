package com.gft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.dao.MenuMapper;
import com.gft.entity.Pages;
import com.gft.service.MenuServices;

@Service
public class MenuServicesimpl implements MenuServices {

	@Autowired
	MenuMapper mmapper;

	/* Mysql分页 */
	@Override
	public List<Pages> easyfenye2(String name, String url, int page, int row) {

		return mmapper.easyfenye2(name, url, page, row);
	}

	@Override
	public Long getCount2() {

		return mmapper.getCount2();
	}

	/* 增加菜单选项 */
	@Override
	public int addMenu(Object[] obj) {

		return mmapper.addMenu(obj);
	}

	/* 修改菜单选项 */
	@Override
	public int updateMenu(Object[] obj) {

		return mmapper.updateMenu(obj);
	}

	/* 删除菜单选项 */
	@Override
	public int deleteMenu(int id) {

		return mmapper.deleteMenu(id);
	}

	/* 分页 */
	@Override
	public List<Pages> rmfenye(String role_name, String name, String url, int page, int row) {
		// TODO Auto-generated method stub
		return mmapper.rmfenye(role_name, name, url, page, row);
	}

	@Override
	public Long rmgetCount() {
		// TODO Auto-generated method stub
		return mmapper.rmgetCount();
	}

	/* 修改角色菜单 */
	@Override
	public int insertRMenu(Object[] obj) {

		return mmapper.insertRMenu(obj);
	}

	@Override
	public int updateRMenu(String role_id) {
		// TODO Auto-generated method stub
		return mmapper.updateRMenu(role_id);
	}

}
