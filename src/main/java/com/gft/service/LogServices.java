package com.gft.service;

import org.springframework.transaction.annotation.Transactional;

import com.gft.entity.Log;
  
public interface LogServices {
	  /** 
     * 日志记录 
     * @param log 
     */  
    @Transactional  
    public void log(String Method,String LogName,String Content);  
      
    /** 
     * 获取登录管理员ID 
     */  
    public Long loginUserId();  
}
