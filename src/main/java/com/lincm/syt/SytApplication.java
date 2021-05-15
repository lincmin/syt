package com.lincm.syt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lincm.syt.mapper")
public class SytApplication {

	public static void main(String[] args) {
		SpringApplication.run(SytApplication.class, args);
	}

}