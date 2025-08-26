package com.spring;

public class Student {
	private int std_id;
	private String std_name;
	private Course course;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int std_id,String std_name,Course course) {
		this.std_id=std_id;
		this.std_name=std_name;
		this.course=course;
	}
	
	public void studentDetails() {
		System.out.println("Student Id :"+std_id);
		System.out.println("Student Name :"+std_name);
		course.courseDetails();
	}
	
}
