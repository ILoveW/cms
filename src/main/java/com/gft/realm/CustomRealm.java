package com.gft.realm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.gft.entity.Log;
import com.gft.entity.User;
import com.gft.service.LogServices;
import com.gft.service.Services;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	Services service;
	
	@Autowired
	LogServices logService;


	// 为当前登陆成功的用户授予权限和角色，已经登陆成功了
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal(); // 获取用户名
		System.out.println(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(service.getRoles(username));
		authorizationInfo.setStringPermissions(service.getPermissions(username));
		return authorizationInfo;
	}

	public static byte[] decryptBASE64(String key) throws Exception {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		return (new sun.misc.BASE64Decoder()).decodeBuffer(key);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String login="5";
		// token是用户输入的
		// 第一步从token中取出身份信息
		String userCode = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials()); // 得到密码
		// 第二步：根据用户输入的userCode从数据库查询
		User user = service.queryUser(userCode);
		byte[] output;
		String outputStr = null;
		try {
			output = decryptBASE64(user.getPassword());//解密
			outputStr = new String(output);
			/*System.err.println("ream中BASE64解密后:\n" + outputStr);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!user.getName().equals(userCode)) {
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!outputStr.equals(password)) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		/*logService.log(login,user.getName(),user.getName()+"用户登录");*/
		// 如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(userCode, password, getName());

	}

}
