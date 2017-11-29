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
import com.gft.service.MenuServices;

@Controller
@RequestMapping("menu")
public class Menucontroller {
	@Autowired
	MenuServices mservices;
	@Autowired
	LogServices logService;

	/* 跳转到分页设计页面 */
	@RequestMapping("/Menu")
	public String test() {
		return "/Menu";

	}

	/* Role页面数据 */
	@RequestMapping("Pages2") // 查询
	@ResponseBody
	public EasyPage easyuifenye(HttpServletRequest request) {
		String name = request.getParameter("menu_name");
		String url = request.getParameter("menu_url");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Pages> list = (List<Pages>) mservices.easyfenye2(name, url, pag, row);
		Long title = mservices.getCount2();
		EasyPage easy = new EasyPage(title, list);
		return easy;

	}

	/* 添加菜单 */
	@RequestMapping("addMenu")
	@ResponseBody
	public Object addRole(HttpServletRequest request, String menu_id, String menu_name, String menu_fid,
			String menu_url) {
		String addUser = "2";// 标识添加菜单
		Object[] obj = { menu_id, menu_name, menu_fid, menu_url };
		HashMap map = new HashMap();
		int result = 0;
		result = mservices.addMenu(obj);
		if (result > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(addUser, user.getName(), "增加" + menu_name + " " + "菜单");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 修改菜单 */
	@RequestMapping("updateMenu")
	@ResponseBody
	public Object updatemenu(HttpServletRequest request, String menu_id, String menu_name, String menu_fid,
			String menu_url) {
		String update = "1";// 标识修改菜单
		Object[] obj = { menu_name, menu_fid, menu_url, menu_id };
		System.out.println(menu_id + "--" + menu_name + "--" + menu_fid + "--" + menu_url);
		HashMap map = new HashMap();
		int result = 0;
		result = mservices.updateMenu(obj);
		if (result > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(update, user.getName(), "修改" + menu_name + " " + "菜单");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 根据id删除菜单 */
	@RequestMapping("/deleteMenu")
	@ResponseBody
	public Object querybyId(HttpServletRequest request) {// Integer id
		String deletemenu = "3";// 删除操作
		String ites = request.getParameter("id");
		HashMap map = new HashMap();
		String[] array = ites.split(",");
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int j = Integer.parseInt(array[i]);
			System.out.println(j);
			count = mservices.deleteMenu(j);
		}
		if (count > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(deletemenu, user.getName(), "删除" + ites + " " + "菜单");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* RM角色菜单管理 */
	/* 跳转到分页设计页面 */
	@RequestMapping("/RMenu")
	public String test1() {
		return "/RMenu";

	}

	/* Role页面数据 */
	@RequestMapping("Pages3") // 查询
	@ResponseBody
	public EasyPage rmfenye(HttpServletRequest request) {
		String role_name = request.getParameter("role_name");
		String name = request.getParameter("menu_name");
		String url = request.getParameter("menu_url");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Pages> list = (List<Pages>) mservices.rmfenye(role_name, name, url, pag, row);
		Long title = mservices.rmgetCount();
		EasyPage easy = new EasyPage(title, list);
		return easy;

	}

	/* 修改角色菜单 */
	@RequestMapping("updateRMenu")
	@ResponseBody
	public Object updatemenu(String role_id, String role_name, HttpServletRequest request) {
		String update = "1";// 标识修改菜单
		String ites = request.getParameter("menu_id");
		String[] array = ites.split(",");
		System.out.println(role_id + "--" + role_name);
		HashMap map = new HashMap();
		mservices.updateRMenu(role_id);
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int menu_id = Integer.parseInt(array[i]);
			Object[] obj = { role_id, menu_id };
			count = mservices.insertRMenu(obj);// 由于创建新的角色(系统不存在的)因此执行插入操作
			System.out.println(menu_id);
		}
		if (count > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(update, user.getName(), "修改" + role_name + " " + "角色菜单");
		} else {
			map.put("code", 250);
		}
		return map;
	}
}
