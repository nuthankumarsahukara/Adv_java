package com.datapro;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="hibernate")
public class Employee {

	private int EmpId;
	private String EmpName;
	private double EmpSalary;
	private String EmpBg;
	@Temporal(TemporalType.DATE)
	private Date Dob;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId, String empName, double empSalary, String empBg, Date dob) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpSalary = empSalary;
		EmpBg = empBg;
		Dob = dob;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public double getEmpSalary() {
		return EmpSalary;
	}

	public void setEmpSalary(double empSalary) {
		EmpSalary = empSalary;
	}

	public String getEmpBg() {
		return EmpBg;
	}

	public void setEmpBg(String empBg) {
		EmpBg = empBg;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpSalary=" + EmpSalary + ", EmpBg=" + EmpBg
				+ ", Dob=" + Dob + "]";
	}

	
	
	

}
