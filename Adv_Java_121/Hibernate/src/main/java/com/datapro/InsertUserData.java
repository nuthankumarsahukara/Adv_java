package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertUserData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			tx=s.beginTransaction();
			System.out.println("Enter the Emp ID :");
			int emp_id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Emp Name :");
			String emp_name=sc.nextLine();
			System.out.println("Enter the Emp DOB (YYYY-MM-DD) :");
			String emp_dob=sc.nextLine();
			System.out.println("Enter the Emp Salary :");
			int emp_sal=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Emp Gender :");
			String emp_gender=sc.nextLine();
			System.out.println("Enter the Emp Department :");
			String emp_dept=sc.nextLine();
			date=sdf.parse(emp_dob);
			Employee e=new Employee(emp_id,emp_name,date,emp_sal,emp_gender,emp_dept);
			s.persist(e);
			tx.commit();
			System.out.println("Data Inserted Successfully....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
