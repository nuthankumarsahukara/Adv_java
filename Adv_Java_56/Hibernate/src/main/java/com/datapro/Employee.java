package com.datapro;

import java.util.Date;

public class Employee {
	
	private int emp_id;	
	private String emp_name;
	private Date emp_dob;
	private String emp_gender;
	private String emp_dept;
	private long emp_phone;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int emp_id, String emp_name, Date emp_dob, String emp_gender, String emp_dept, long emp_phone) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dob = emp_dob;
		this.emp_gender = emp_gender;
		this.emp_dept = emp_dept;
		this.emp_phone = emp_phone;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getEmp_dob() {
		return emp_dob;
	}
	public void setEmp_dob(Date emp_dob) {
		this.emp_dob = emp_dob;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public long getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_dob=" + emp_dob + ", emp_gender="
				+ emp_gender + ", emp_dept=" + emp_dept + ", emp_phone=" + emp_phone + "]";
	}
}
