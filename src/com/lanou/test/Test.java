package com.lanou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.entity.Score;
import com.lanou.service.UserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		UserService dao = (UserService) ac.getBean("userService");
		for (Score string : dao.findScore(10)) {
			System.out.println(string.getDate());
		}
	}
}
