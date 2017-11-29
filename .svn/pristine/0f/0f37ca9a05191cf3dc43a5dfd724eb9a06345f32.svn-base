package com.gft.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gft.dao.RoleMapper;
import com.gft.entity.Pages;

@Repository
public class RoleMapperimpl implements RoleMapper {
	/* sqlSession映射 */
	@Autowired
	SqlSessionTemplate template;

	@Override
	public List<Pages> easyfenye1(String id, String name, String bewrite, int page, int rows) {
		return template.selectList("com.gft.dao.RoleMapperimpl.easyfenye1", new Pages(id, name, page, bewrite, rows));
	}

	@Override
	public Long getCount1() {
		return template.selectOne("com.gft.dao.RoleMapperimpl.getCount1");
	}

	/* 增加角色 */
	@Override
	public int addRole(Object[] obj) {

		return template.insert("com.gft.dao.RoleMapperimpl.addRole", obj);
	}

	/* 修改角色 */
	@Override
	public int updateRole(Object[] obj) {

		return template.update("com.gft.dao.RoleMapperimpl.updateRole", obj);
	}

	/* 删除角色 */
	@Override
	public int deleteRole(int id) {

		return template.delete("com.gft.dao.RoleMapperimpl.deleteRole", id);
	}

	@Override
	public List<Pages> urfenye(String uname, String name, String bewrite, int page, int rows) {

		return template.selectList("com.gft.dao.RoleMapperimpl.urfenye", new Pages(rows, page, name, bewrite, uname));
	}

	@Override
	public Long urgetCount() {

		return template.selectOne("com.gft.dao.RoleMapperimpl.urgetCount");
	}

	/* 根据用户编号查询用户 */
	@Override
	public int queryUserbyID(String id) {

		return template.selectOne("com.gft.dao.RoleMapperimpl.queryUserbyID", id);
	}

	/* 更新用户角色 */
	@Override
	public int updateURole(Object[] obj) {
		// TODO Auto-generated method stub
		return template.update("com.gft.dao.RoleMapperimpl.updateURole", obj);
	}
}
