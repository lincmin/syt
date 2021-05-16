package com.lincm.syt.handler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler{

	//mp执行添加操作,执行这个方法
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("start insert fill ....");
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
		this.setFieldValByName("version", 1, metaObject);
	}

	//mp执行修改操作,执行这个方法
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("start update fill ....");
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}

}
