package com.gft.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gft.entity.EasyPage;
import com.gft.entity.Pages;
import com.gft.entity.User;
import com.gft.service.LogServices;
import com.gft.service.RoleServices;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleServices rservices;

	@Autowired
	LogServices logService;

	/* 跳转到分页设计页面 */
	@RequestMapping("/Role")
	public String test() {
		return "/Role";

	}

	/* Role页面数据 */
	@RequestMapping("Pages1") // 查询
	@ResponseBody
	public EasyPage easyuifenye(HttpServletRequest request) {
		String id = request.getParameter("role_id");
		String name = request.getParameter("role_name");
		String bewrite = request.getParameter("role_bewrite");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Pages> list = (List<Pages>) rservices.easyfenye1(id, name, bewrite, pag, row);
		Long title = rservices.getCount1();
		EasyPage easy = new EasyPage(title, list);
		return easy;
	}

	/* 添加角色 */
	@RequestMapping("addRole")
	@ResponseBody
	public Object addRole(HttpServletRequest request, String role_id, String role_name, String role_bewrite) {
		String addRoel = "2";// 标识增加角色
		Object[] obj = { role_id, role_name, role_bewrite };
		HashMap map = new HashMap();
		int result = 0;
		result = rservices.addRole(obj);
		if (result > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(addRoel, user.getName(), "增加" + role_name + "角色");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 修改角色 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Object updaterole(HttpServletRequest request, String role_id, String role_name, String role_bewrite) {
		String update = "1";// 标识修改角色
		Object[] obj = { role_name, role_bewrite, role_id };
		HashMap map = new HashMap();
		int result = 0;
		result = rservices.updateRole(obj);
		if (result > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(update, user.getName(), "修改" + role_name + "角色");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 根据id删除角色 */
	@RequestMapping("/deleteRole")
	@ResponseBody
	public Object querybyId(HttpServletRequest request) {// Integer id
		String deleteUser = "3";// 删除操作
		String ites = request.getParameter("id");
		HashMap map = new HashMap();
		String[] array = ites.split(",");
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int j = Integer.parseInt(array[i]);
			System.out.println(j);
			count = rservices.deleteRole(j);
		}
		if (count > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(deleteUser, user.getName(), "删除编号为:" + ites + "角色");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 用户角色 */
	/* 跳转到分页设计页面 */
	@RequestMapping("/URole")
	public String test1() {
		return "/URole";
	}

	@RequestMapping("Pages2") // 查询
	@ResponseBody
	public EasyPage urfenye(HttpServletRequest request) {
		String uname = request.getParameter("uname");
		String name = request.getParameter("role_name");
		String bewrite = request.getParameter("role_bewrite");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Pages> list = (List<Pages>) rservices.urfenye(uname, name, bewrite, pag, row);
		Long title = rservices.urgetCount();
		EasyPage easy = new EasyPage(title, list);
		return easy;
	}

	/* 修改角色 */
	@RequestMapping("updateURole")
	@ResponseBody
	public Object updateurole(HttpServletRequest request, String user_id, String user_name, String role_id) {
		String update = "1";// 标识修改角色
		int count = 0;
		HashMap map = new HashMap();
		count = rservices.queryUserbyID(user_id);
		if (count > 0) {// 说明该用户已拥有权限，此时进行更新操作
			Object[] obj = { role_id, user_id };
			int result = 0;
			result = rservices.updateURole(obj);
			if (result > 0) {
				map.put("code", 200);
				User user = (User) request.getSession().getAttribute("user");
				logService.log(update, user.getName(), "修改:" + user_name + "角色为:" + role_id);
			} else {
				map.put("code", 250);
			}
		} else {
			map.put("code", 1501);
		}
		return map;
	}

}
