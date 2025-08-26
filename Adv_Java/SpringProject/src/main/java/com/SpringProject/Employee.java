package com.SpringProject;

public class Employee {
	private int emp_id;
	private String emp_name;
	private double emp_sal; 
	private Department dept;
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public void display_emp() {
		System.out.println("Employee Id :"+emp_id);
		System.out.println("Employee Name :"+emp_name);
		System.out.println("Employee Salary :"+emp_sal);
		dept.display_dept();
	}
	
}
