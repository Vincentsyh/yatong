package com.lb.yatong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lb.yatong.dao")
public class YatongApplication {

	public static void main(String[] args) {
		SpringApplication.run(YatongApplication.class, args);
	}
}
