package com.datapro.Model;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "java56smvc")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
	private long std_id;
	
	@Column(length=20)
	private String std_name;
	
	@Column
	private Date std_date;
	
	@Column(length = 7)
	private String std_gender;
	
	private long std_phone;
	
	@Column(length = 25)
	private String std_course;
	
	@Column(length = 25)
	private String std_email;
	
	@Lob
	private byte[] std_photo;

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

	public Date getStd_date() {
		return std_date;
	}

	public void setStd_date(Date std_date) {
		this.std_date = std_date;
	}

	public String getStd_gender() {
		return std_gender;
	}

	public void setStd_gender(String std_gender) {
		this.std_gender = std_gender;
	}

	public long getStd_phone() {
		return std_phone;
	}

	public void setStd_phone(long std_phone) {
		this.std_phone = std_phone;
	}

	public String getStd_course() {
		return std_course;
	}

	public void setStd_course(String std_course) {
		this.std_course = std_course;
	}

	public String getStd_email() {
		return std_email;
	}

	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}

	public byte[] getStd_photo() {
		return std_photo;
	}

	public void setStd_photo(byte[] std_photo) {
		this.std_photo = std_photo;
	}

	public Student(long std_id, String std_name, Date std_date, String std_gender, long std_phone, String std_course,
			String std_email, byte[] std_photo) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_date = std_date;
		this.std_gender = std_gender;
		this.std_phone = std_phone;
		this.std_course = std_course;
		this.std_email = std_email;
		this.std_photo = std_photo;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_date=" + std_date + ", std_gender="
				+ std_gender + ", std_phone=" + std_phone + ", std_course=" + std_course + ", std_email=" + std_email
				+ ", std_photo=" + Arrays.toString(std_photo) + "]";
	}
	
	
	
}
