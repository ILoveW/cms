package com.gft.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.dao.LogMapper;
import com.gft.entity.Log;
import com.gft.service.LogServices;
@Service
public class LogServicesimpl implements LogServices{
	@Autowired
	LogMapper logmapper;
	
	InetAddress ia=null;
	Log log = new Log();
	@Override
	public void log(String Method,String LogName,String Content) {
		try {
			ia=ia.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String ip=ia.getHostAddress();
		if(Method.equals("1")){
			log.setMethod("修改操作");
		}else if(Method.equals("2")){
			log.setMethod("增加操作");
		}else if(Method.equals("0")){
			log.setMethod("注册操作");
		}else if(Method.equals("3")){
			log.setMethod("删除操作");
		}else if(Method.equals("4")){
			log.setMethod("安全退出操作");
		}else if(Method.equals("5")){
			log.setMethod("登陆");
		}
		log.setLoginName(LogName);
		log.setUname(ip);
		log.setContent(Content);
		logmapper.insert(log);
	}

	@Override
	public Long loginUserId() {
		return null;
	}

}
