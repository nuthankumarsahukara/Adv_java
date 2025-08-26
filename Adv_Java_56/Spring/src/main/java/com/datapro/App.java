package com.datapro;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student=(Student) context.getBean("studentBean");
		Course course=(Course) context.getBean("courseBean");
		
		student.setStd_id(10001);
		student.setStd_name("Nuthan");
		course.setCourse_id(100);
		course.setCourse_name("Power BI");
		course.setCourse_fee(18000);
		course.setCourse_duration("4 Months");
		
		student.setCourse(course);
		
		System.out.println("Student ID "+student.getStd_id());
		System.out.println("Student Name "+student.getStd_name());
		System.out.println("Course ID :"+student.getCourse().getCourse_id());
		System.out.println("Course Name :"+student.getCourse().getCourse_name());
		System.out.println("Course Fee :"+student.getCourse().getCourse_fee());
		System.out.println("Course Duration :"+student.getCourse().getCourse_duration());
		
		
	}

}
