package com.gft.IsVialidLoginIntercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.gft.entity.User;

public class IsVialidLoginIntercepter implements HandlerInterceptor {
	/**
	 * 拦截器
	 * 
	 * @author shixi
	 *
	 */

	Logger logger = LoggerFactory.getLogger(IsVialidLoginIntercepter.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		logger.debug("正式进入拦截器");
		HttpSession sessions = request.getSession();
		User user = (User) sessions.getAttribute("LoginUser");
		System.out.println("sdfs" + user);
		if (user != null) {
			// 登陆成功的用户
			return true;
		} else {
			// 没有登陆，转向登陆界面
			request.getRequestDispatcher("/cms/cms/login.ftl").forward(request, response);
			return false;
		}
	}

}
