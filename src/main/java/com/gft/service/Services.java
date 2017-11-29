package com.gft.service;

import java.util.List;
import java.util.Set;
import com.gft.entity.Pages;
import com.gft.entity.Temp;
import com.gft.entity.Test;
import com.gft.entity.User;
import com.gft.entity.leafTree;

public interface Services {
	/* 根据用户名查询用户信息 */
	public User queryUser(String username);

	/* 根据用户名查询用户角色 */
	public Set<String> getRoles(String username);

	/* 根据用户名查询用户权限 */
	public Set<String> getPermissions(String username);

	/* 根据用户名查询菜单 */
	public List<leafTree> leafTree(String username);

	/* Oracle分页 */
	public List<Test> FenyeTest(Integer page, Integer rows);

	public Long FenyeTitle();

	/* Mysql分页 */
	/* public Long getCount(String name); */

	public List<Pages> easyfenye(String name, String tel, String email, int page, int row);

	public Long getCount();

	/* public List<Pages> easyfenye(int page, int row); */
	/* 删除用户 */
	public int deleteUser(String id);

	/* 添加用户 */
	public int addUser(Object[] obj);

	/* 修改用户 */
	public int updateUser(Object[] obj);

	/* 根据用户名查询用户 */
	public int queryUserbyID(String name);

	/* 创建角色 */
	public int updateURole1(Object[] obj);
}
