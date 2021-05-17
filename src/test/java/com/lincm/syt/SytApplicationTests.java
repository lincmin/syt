package com.lincm.syt;

import java.util.Arrays;
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
	//多个id批量查询
	@Test
	public void testSelect1() {
	List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
		System.out.println(users);
	}
	
	//测试乐观锁
	@Test
	public void testOptimisticLocker() {
		//根据id查询
		User user = userMapper.selectById(1393944776873738241L);
		//修改
		user.setName("张三");
		userMapper.updateById(user);
	}
	
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
		user.setName("李四");
		user.setAge(24);
		user.setEmail("333@qq.com");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
	
	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
