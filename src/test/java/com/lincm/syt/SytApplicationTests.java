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
	
	//添加
	@Test
	public void testAdd() {
		User user = new User();
		user.setName("lily");
		user.setAge(22);
		user.setEmail("111@qq.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
	
	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
