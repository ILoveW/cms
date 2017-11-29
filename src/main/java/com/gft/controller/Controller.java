package com.gft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gft.entity.EasyPage;
import com.gft.entity.Log;
import com.gft.entity.Pages;
import com.gft.entity.Test;
import com.gft.entity.User;
import com.gft.entity.leafTree;
import com.gft.service.LogServices;
import com.gft.service.Services;
import sun.misc.BASE64Encoder;
import org.apache.log4j.Logger;

@org.springframework.stereotype.Controller
@RequestMapping("/BS")
public class Controller {
	protected final static Logger logger = Logger.getLogger(Controller.class);
	@Autowired
	Services service;

	@Autowired
	LogServices logService;

	/* BASE64解密 */
	public static byte[] decryptBASE64(String key) throws Exception {
		// sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		return (new sun.misc.BASE64Decoder()).decodeBuffer(key);
	}

	/* BASE64加密 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/* 跳转到登陆页面 */
	@RequestMapping("/logindemo")
	public String login() {
		return "login";

	}

	/* 跳转到主页面 */
	@RequestMapping("/Main")
	public String main() {
		return "Main";

	}

	/* 跳转到About页面 */
	@RequestMapping("/about")
	public String about() {
		return "about";

	} /* 用户登陆验证 */

	@RequestMapping("/login")
	@ResponseBody
	public Object login(User user, HttpServletRequest request) {
		String login = "5";// 标识登陆
		String verifyCodes = request.getParameter("verifyCode");
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("verifycode1");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
		HashMap map = new HashMap();
		try {
			subject.login(token);// 会跳到我们自定义的realm中
			request.getSession().setAttribute("user", user);
			User userpass = service.queryUser(user.getName());
			byte[] output = decryptBASE64(userpass.getPassword());// 解密
			String outputStr = new String(output);
			if (sessionCode.equals(verifyCodes.toUpperCase()) && verifyCodes != null
					&& user.getPassword().equals(outputStr)) {
				map.put("code", 200);
				logService.log(login, user.getName(), user.getName() + "用户登录");
				return map;
			} else {
				map.put("code", 250);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("user", user);
			request.setAttribute("error", "用户名或密码错误！");
			map.put("code", 250);
			return map;
		}

	}

	/* 安全退出 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		String Logout = "4";// 标识安全退出操作
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			User user = (User) request.getSession().getAttribute("user");
			logService.log(Logout, user.getName(), user.getName() + "用户退出");
			subject.logout();
		}

		request.getSession().invalidate();

		return "/login";
	}

	/* 显示功能菜单 */
	@RequestMapping("/tree")
	@ResponseBody
	public List<leafTree> menuTree(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<leafTree> list = service.leafTree(user.getName());
		return list;
	}

	/* 跳转到分页设计页面 */
	@RequestMapping("/MysqlFenYe")
	public String MysqlfFenYe() {
		return "/author";

	}

	/* 跳转到注册页面 */
	@RequestMapping("/register")
	public String register() {
		return "/register";

	}

	/* Mysql分页 */
	@RequestMapping("Pages") // 查询
	@ResponseBody
	public EasyPage easyuifenye(HttpServletRequest request) {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Pages> list = (List<Pages>) service.easyfenye(name, tel, email, pag, row);
		Long title = service.getCount();
		EasyPage easy = new EasyPage(title, list);
		return easy;

	}

	/* Oracle分页 */
	@RequestMapping("OracleFenYe")
	@ResponseBody
	public EasyPage OracleFenYe(HttpServletRequest request) {
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Integer pag = page * rows - rows;
		Integer row = page * rows;
		List<Test> test = service.FenyeTest(pag, row);
		Long title = service.FenyeTitle();
		EasyPage easy = new EasyPage(title, test);
		return easy;
	}

	/* 根据id删除用户 */
	@RequestMapping("/deletebyId")
	@ResponseBody
	public Object deletebyId(HttpServletRequest request) {// Integer id
		String deleteUser = "3";// 删除操作
		String ites = request.getParameter("id");
		HashMap map = new HashMap();
		String[] array = ites.split(",");
		int count = 0;
		User user = (User) request.getSession().getAttribute("user");
		for (int i = 0; i < array.length; i++) {
			String j = array[i];
			count = service.deleteUser(j);
		}
		if (count > 0) {
			map.put("code", 200);
			logService.log(deleteUser, user.getName(), "删除编号为:" + ites + "用户");
		} else {
			map.put("code", 250);
		}
		return map;
	}

	/* 添加用户 */
	@RequestMapping("/addUser") // 增加用户
	@ResponseBody
	public Object addUser(HttpServletRequest request, String user_name, String user_password, String user_email,
			String user_tel, String user_adress, String user_state) {
		String addUser = "2";// 标识增加用户
		/* 自动生成注册时间 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		/* 自动生成随机数 */
		String user_id = null;
		int radom = (int) (Math.random() * 1000);
		SimpleDateFormat usersdf = new SimpleDateFormat("yyyyMMddHHmm");
		String userid = usersdf.format(new Date());
		user_id = userid + radom;
		/* 加密 */
		String inputStr = user_password;
		byte[] inputData = inputStr.getBytes();
		String code = null;
		try {
			code = encryptBASE64(inputData);// 加密
			/* 解密 */
			byte[] output = decryptBASE64(code);
			String outputStr = new String(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[] obj = { user_id, user_name, code, user_email, user_tel, user_adress, time, user_state };
		String role_id = "3";// 默认为普通用户角色
		Object[] obj1 = { user_id, role_id };
		int result = 0;
		int count = 0;
		count = service.queryUserbyID(user_name);
		HashMap map = new HashMap();
		if (count > 0) {
			map.put("code", 210);
		} else {
			result = service.addUser(obj);

			if (result > 0) {
				service.updateURole1(obj1);// 为注册用户添加角色
				map.put("code", 200);
			} else {
				map.put("code", 250);
			}
		}
		User user = (User) request.getSession().getAttribute("user");
		logService.log(addUser, user.getName(), "增加" + user_name + "用户");
		return map;
	}

	@RequestMapping("/registerUser") // 增加用户
	@ResponseBody
	public Object registerUser(HttpServletRequest request, String user_name, String user_password, String user_email,
			String user_tel, String user_adress, String user_state) {
		String registerUser = "0";// 标识增加用户
		/* 自动生成注册时间 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		/* 自动生成随机数 */
		String user_id = null;
		int radom = (int) (Math.random() * 1000);
		SimpleDateFormat usersdf = new SimpleDateFormat("yyyyMMddHHmm");
		String userid = usersdf.format(new Date());
		user_id = userid + radom;
		/* 加密 */
		String inputStr = user_password;
		byte[] inputData = inputStr.getBytes();
		String code = null;
		try {
			code = encryptBASE64(inputData);// 加密
			/* 解密 */
			byte[] output = decryptBASE64(code);
			String outputStr = new String(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[] obj = { user_id, user_name, code, user_email, user_tel, user_adress, time, user_state };
		String role_id = "3";// 默认为普通用户角色
		Object[] obj1 = { user_id, role_id };
		int result = 0;
		int count = 0;
		count = service.queryUserbyID(user_name);
		HashMap map = new HashMap();
		if (count > 0) {
			map.put("code", 210);
		} else {
			result = service.addUser(obj);

			if (result > 0) {
				service.updateURole1(obj1);// 为注册用户添加角色
				map.put("code", 200);
			} else {
				map.put("code", 250);
			}
		}
		logService.log(registerUser, user_name, "注册" + user_name + "用户");
		return map;
	}
	
	/* 根据用户id修改用户 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public Object updateUser(HttpServletRequest request, String user_id, String user_name, String user_password,
			String user_email, String user_tel, String user_adress, String user_date, String user_state) {
		String update = "1";// 标识修改用户
		/* 加密算法 */
		String inputStr = user_password;
		byte[] inputData = inputStr.getBytes();
		String code = null;
		try {
			code = encryptBASE64(inputData);// 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[] obj = { user_name, code, user_tel, user_email, user_adress, user_date, user_state, user_id };
		int result = 0;
		HashMap map = new HashMap();
		result = service.updateUser(obj);
		if (result > 0) {
			map.put("code", 200);
			User user = (User) request.getSession().getAttribute("user");
			logService.log(update, user.getName(), "修改" + user_name + "用户");
		} else {
			map.put("code", 250);
		}

		return map;
	}
}
