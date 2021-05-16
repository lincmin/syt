package com.lincm.syt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lincm.syt.entity.User;
import com.lincm.syt.mapper.UserMapper;

@SpringBootTest
class SytApplicationTests {
	@Autowired
	private UserMapper userMapper;
	
	//修改
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1393757406870331393L);
		user.setName("lucy");
		int count = userMapper.updateById(user);
		System.out.println(count);
	}
	
	//添加
	@Test
	public void testAdd() {
		User user = new User();
		user.setName("mery");
		user.setAge(23);
		user.setEmail("222@qq.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
	
	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
