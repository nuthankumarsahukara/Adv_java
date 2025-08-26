package com.datapro;

public class Student {
	private int std_id;
	private String std_name;
	Course course;
	
	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
