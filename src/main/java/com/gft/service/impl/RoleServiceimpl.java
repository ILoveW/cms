package com.gft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.dao.RoleMapper;
import com.gft.entity.Pages;
import com.gft.service.RoleServices;

@Service
public class RoleServiceimpl implements RoleServices {
	@Autowired
	RoleMapper rmapper;

	/* Mysql分页 */
	@Override
	public List<Pages> easyfenye1(String id, String name, String bewrite, int page, int row) {

		return rmapper.easyfenye1(id, name, bewrite, page, row);
	}

	@Override
	public Long getCount1() {

		return rmapper.getCount1();
	}

	/* 增加角色 */
	@Override
	public int addRole(Object[] obj) {
		return rmapper.addRole(obj);
	}

	/* 修改角色 */
	@Override
	public int updateRole(Object[] obj) {

		return rmapper.updateRole(obj);
	}

	/* 删除角色 */
	@Override
	public int deleteRole(int id) {

		return rmapper.deleteRole(id);
	}

	@Override
	public List<Pages> urfenye(String uname, String name, String bewrite, int page, int row) {
		// TODO Auto-generated method stub
		return rmapper.urfenye(uname, name, bewrite, page, row);
	}

	@Override
	public Long urgetCount() {
		// TODO Auto-generated method stub
		return rmapper.urgetCount();
	}

	/* 根据用户编号查询用户 */
	@Override
	public int queryUserbyID(String id) {
		// TODO Auto-generated method stub
		return rmapper.queryUserbyID(id);
	}

	/* 更新用户角色 */
	@Override
	public int updateURole(Object[] obj) {
		// TODO Auto-generated method stub
		return rmapper.updateURole(obj);
	}
}
