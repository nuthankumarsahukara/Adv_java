package com.datapro.Model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "java121smvc")
public class Employee {

	@Id
	@GeneratedValue
	private int emp_id;
	
	@Column(length=20)
	private String emp_name;
	
	@Column(length=20)
	private String emp_gender;
	
	@Column(length=20)
	private String emp_email;
	
	@Column(length=20)
	private String emp_dept;
	
	private double emp_sal;
	
	private long emp_phone;
	
	@Lob
	@Column(name = "emp_photo", columnDefinition = "BLOB")
	private byte[] emp_photo;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int emp_id, String emp_name, String emp_gender, String emp_email, String emp_dept, double emp_sal,
			long emp_phone, byte[] emp_photo) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_email = emp_email;
		this.emp_dept = emp_dept;
		this.emp_sal = emp_sal;
		this.emp_phone = emp_phone;
		this.emp_photo = emp_photo;
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
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public double getEmp_sal() {
		return emp_sal;
	}
	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}
	public long getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
	}
	public byte[] getEmp_photo() {
		return emp_photo;
	}
	public void setEmp_photo(byte[] emp_photo) {
		this.emp_photo = emp_photo;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_gender=" + emp_gender + ", emp_email="
				+ emp_email + ", emp_dept=" + emp_dept + ", emp_sal=" + emp_sal + ", emp_phone=" + emp_phone
				+ ", emp_photo=" + Arrays.toString(emp_photo) + "]";
	}
		
	
}
