package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext content=new ClassPathXmlApplicationContext("applicationContext.xml");
			Student student=(Student) content.getBean("studentBean");
			student.studentDetails();			
	}

}
