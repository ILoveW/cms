package com.gft.dao;

import java.util.List;
import java.util.Set;
import com.gft.entity.Pages;
import com.gft.entity.Temp;
import com.gft.entity.Test;
import com.gft.entity.User;
import com.gft.entity.leafTree;

public interface Mapper {
	/* 根据用户名查询用户信息 */
	public User queryUser(String username);

	/* 根据用户名查询用户角色 */
	public Set<String> getRoles(String username);

	/* 根据用户名查询用户权限 */
	public Set<String> getPermissions(String username);

	/* 根据用户名查询用户所拥有的菜单 */
	public List<leafTree> leafTree(String username);

	/* Oracle分页 */
	public List<Test> FenyeTest(Integer page, Integer rows);

	public Long FenyeTitle();

	/* Mysql分页 */
	/* public Long getCount(String name); */

	public List<Pages> easyfenye(String name, String tel, String email, int page, int row);

	public Long getCount();

	/*
	 * public List<Pages> easyfenye(int page, int row);
	 */
	/* 根据用户id删除用户 */
	public int deleteUser(String id);

	/* 根据用户名查询用户 */
	public int queryUserbyID(String name);

	/* 添加用户 */
	public int addUser(Object[] obj);

	/* 根据用户id修改用户 */
	public int updateUser(Object[] obj);

	/* 创建角色 */
	public int updateURole1(Object[] obj);

	/* 添加日志信息 */
	public int Log(String id, String Method, String Uname, String AddTime, String Content, String LoginName);
}
