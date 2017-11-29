package com.gft.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gft.dao.LogMapper;
import com.gft.entity.Log;
@Repository
public class LogMapperImpl implements LogMapper {
	@Autowired
	SqlSessionTemplate Logtemplate;
	@Override
	public void insert(Log log) {
		Logtemplate.insert("com.gft.dao.LogMapperImpl.insert", log);
	}

}
