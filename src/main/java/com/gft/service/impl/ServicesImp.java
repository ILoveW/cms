package com.gft.service.impl;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.dao.Mapper;
import com.gft.entity.Pages;
import com.gft.entity.Temp;
import com.gft.entity.Test;
import com.gft.entity.User;
import com.gft.service.Services;

@Service
public class ServicesImp implements Services {

	@Autowired
	Mapper mapper;

	/* 根据用户名查询用户信息 */
	@Override
	public User queryUser(String username) {

		return mapper.queryUser(username);
	}

	/* 根据用户名查询用户角色 */
	@Override
	public Set<String> getRoles(String username) {

		return null;
	}

	/* 根据用户名查询用户权限 */
	@Override
	public Set<String> getPermissions(String username) {

		return null;
	}

	/* 根据用户名查询用户拥有菜单 */
	@Override
	public List<com.gft.entity.leafTree> leafTree(String username) {
		return mapper.leafTree(username);
	}

	/* Oracle分页 */
	@Override
	public List<Test> FenyeTest(Integer page, Integer rows) {
		return mapper.FenyeTest(page, rows);
	}

	@Override
	public Long FenyeTitle() {
		return mapper.FenyeTitle();
	}

	/* Mysql分页 */
	/*
	 * @Override public Long getCount(String name) { return
	 * mapper.getCount(name); }
	 */

	@Override
	public List<Pages> easyfenye(String name, String tel, String email, int page, int row) {
		return mapper.easyfenye(name, tel, email, page, row);
	}

	public Long getCount() {
		return mapper.getCount();
	}

	/*
	 * @Override public List<Pages> easyfenye(int page, int row) { return
	 * mapper.easyfenye(page, row); }
	 */

	/* 根据用户id删除用户 */
	@Override
	public int deleteUser(String id) {
		return mapper.deleteUser(id);
	}

	/* 添加用户 */
	@Override
	public int addUser(Object[] obj) {
		return mapper.addUser(obj);
	}

	/* 根据用户id修改用户 */
	@Override
	public int updateUser(Object[] obj) {
		return mapper.updateUser(obj);
	}

	/* 根据用户名查询用户 */
	@Override
	public int queryUserbyID(String name) {
		return mapper.queryUserbyID(name);
	}
	/*创建角色*/
	@Override
	public int updateURole1(Object[] obj) {
		// TODO Auto-generated method stub
		return mapper.updateURole1(obj);
	}
}
