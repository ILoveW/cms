package com.gft.dao.impl;

import java.util.List;
import java.util.Set;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gft.dao.Mapper;
import com.gft.entity.Pages;
import com.gft.entity.Temp;
import com.gft.entity.Test;
import com.gft.entity.User;
import com.gft.entity.leafTree;

@Repository
public class MapperImp implements Mapper {
	/* sqlSession映射 */
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;

	/* 根据用户名查询数据信息 */
	@Override
	public User queryUser(String username) {

		return sqlsessiontemplate.selectOne("com.gft.dao.impl.queryUser", username);
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

	/* 根据用户名查询用户所拥有的菜单 */
	@Override
	public List<leafTree> leafTree(String username) {
		return sqlsessiontemplate.selectList("com.gft.dao.impl.leafTree", username);
	}

	/* Oracle分页 */
	@Override
	public List<Test> FenyeTest(Integer page, Integer rows) {
		return sqlsessiontemplate.selectList("com.gft.dao.impl.FenyeTest", new Pages(page, rows));
	}

	@Override
	public Long FenyeTitle() {
		return sqlsessiontemplate.selectOne("com.gft.dao.impl.FenyeTitle");
	}

	/* Mysql分页 */
	/*
	 * @Override public Long getCount(String name) { return
	 * sqlsessiontemplate.selectOne("com.gft.dao.impl.getCount",name); }
	 */

	@Override
	public List<Pages> easyfenye(String name, String tel, String email, int page, int rows) {
		return sqlsessiontemplate.selectList("com.gft.dao.impl.easyfenye", new Pages(name, tel, email, page, rows));
	}

	@Override
	public Long getCount() {
		return sqlsessiontemplate.selectOne("com.gft.dao.impl.getCount");
	}

	/*
	 * @Override public List<Pages> easyfenye(int page, int rows) { return
	 * sqlsessiontemplate.selectList("com.gft.dao.impl.easyfenye", new
	 * Pages(rows, page)); }
	 */

	/* 根据用户id删除用户 */
	@Override
	public int deleteUser(String id) {
		return sqlsessiontemplate.delete("com.gft.dao.impl.deleteUser", id);
	}

	/* 添加用户 */
	@Override
	public int addUser(Object[] obj) {
		return sqlsessiontemplate.update("com.gft.dao.impl.addUser", obj);
	}

	/* 根据用户id修改用户 */
	@Override
	public int updateUser(Object[] obj) {
		return sqlsessiontemplate.update("com.gft.dao.impl.updateUser", obj);
	}

	/* 根据用户id查询用户--添加用户时去除名字相同 */
	@Override
	public int queryUserbyID(String name) {
		return sqlsessiontemplate.selectOne("com.gft.dao.impl.queryUserbyID", name);
	}

	/* 创建用户角色 */
	@Override
	public int updateURole1(Object[] obj) {

		return sqlsessiontemplate.update("com.gft.dao.impl.updateURole1", obj);
	}

	@Override
	public int Log(String id, String Method, String Uname, String AddTime, String Content, String LoginName) {
		return sqlsessiontemplate.insert("com.gft.dao.impl.Log",
				new Object[] { id, Method, Uname, AddTime, Content, LoginName });
	}

}
