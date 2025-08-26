package com.SpringProject;

public class Department {
	private int dept_id;
	private String dept_name;
	
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public void display_dept() {
		System.out.println("Department ID :"+dept_id);
		System.out.println("Department Name :"+dept_name);
	}
	
}
