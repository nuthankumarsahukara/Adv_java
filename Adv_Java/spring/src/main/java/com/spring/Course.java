package com.spring;

public class Course {
	private int course_id;
	private String course_name;
	private int course_duration;
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int course_id,String course_name,int course_duration) {
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_duration=course_duration;
	}
	
	public void courseDetails() {
		System.out.println("Course Id :"+course_id);
		System.out.println("Course Name :"+course_name);
		System.out.println("Course Duration :"+course_duration);
		
	}

}
