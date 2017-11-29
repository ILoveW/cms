package com.gft.dao;

import java.util.List;
import com.gft.entity.Pages;

public interface RoleMapper {
	/* Mysql分页 */

	public List<Pages> easyfenye1(String uname, String name, String bewrite, int page, int row);

	public Long getCount1();

	/* 添加角色 */
	public int addRole(Object[] obj);

	/* 修改角色 */
	public int updateRole(Object[] obj);

	/* 删除角色 */
	public int deleteRole(int id);

	/* URole */
	/* Mysql分页 */
	public List<Pages> urfenye(String id, String name, String bewrite, int page, int row);

	public Long urgetCount();

	/* 根据用户编号查询用户 */
	public int queryUserbyID(String id);

	/* 更新用户角色 */
	public int updateURole(Object[] obj);
}
