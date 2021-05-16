package com.lincm.syt.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class User {
	@TableId(type=IdType.ASSIGN_ID)
	private Long id;
	
	private String name;
	private Integer age;
	private String email;
	
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;//create_time
	
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
}
