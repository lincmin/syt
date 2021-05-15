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
	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
