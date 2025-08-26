package com.SpringBoot.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private long std_id;
	@Column(length = 20)
	private String std_name;
	@Column(length = 20)
	private String std_course;
	@Column(length = 10)
	private String std_section;
	private int std_year;
	
	public long getStd_id() {
		return std_id;
	}
	public void setStd_id(long std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_course() {
		return std_course;
	}
	public void setStd_course(String std_course) {
		this.std_course = std_course;
	}
	public String getStd_section() {
		return std_section;
	}
	public void setStd_section(String std_section) {
		this.std_section = std_section;
	}
	public int getStd_year() {
		return std_year;
	}
	public void setStd_year(int std_year) {
		this.std_year = std_year;
	}
	public Student(long std_id, String std_name, String std_course, String std_section, int std_year) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_course = std_course;
		this.std_section = std_section;
		this.std_year = std_year;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_course=" + std_course + ", std_section="
				+ std_section + ", std_year=" + std_year + "]";
	}	
	
}
