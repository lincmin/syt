package com.lincm.syt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lincm.syt.entity.User;
import com.lincm.syt.mapper.UserMapper;

@SpringBootTest
class SytApplicationTests {
	@Autowired
	private UserMapper userMapper;
	
	//分页查询
	@Test
	public void selectPage() {
		Page<User> page = new Page(1,3);
		Page<User> userPage = userMapper.selectPage(page, null);
		//返回对象得到分页所有数据
		long pages = userPage.getPages();//总页数
		long current = userPage.getCurrent();//当前页
		List<User> records = userPage.getRecords();//查询数据集合
		long total = userPage.getTotal();//总记录数
		boolean hasNext = userPage.hasNext();//下一页
		boolean hasPrevious = userPage.hasPrevious();//上一页
		System.out.println(pages);
		System.out.println(current);
		System.out.println(records);
		System.out.println(total);
		System.out.println(hasNext);
		System.out.println(hasPrevious);
	}
	
	//简单条件查询
	@Test
	public void testSelect2() {
		Map<String,Object> columnMap = new HashMap<>();
		columnMap.put("name","Jack");
		columnMap.put("age",20);
		userMapper.selectByMap(columnMap);
	}
	
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
