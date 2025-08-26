package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDataInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			System.out.println("Enter the Employee ID :");
			int emp_id=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the Employee Name :");
			String emp_name=sc.nextLine();
			
			System.out.println("Enter the Employee DOB (YYYY-MM-DD) :");
			String emp_date=sc.nextLine();
			
			System.out.println("Enter the Employee Gender :");
			String emp_gender=sc.nextLine();
			
			System.out.println("Enter the Employee Department :");
			String emp_dept=sc.nextLine();
			
			System.out.println("Enter the Employee Phone Number :");
			long emp_phone=sc.nextLong();
			
			
			date=sdf.parse(emp_date);
			tx=so.beginTransaction();
			Employee e=new Employee(emp_id, emp_name, date, emp_gender, emp_dept, emp_phone);
			so.persist(e);
			tx.commit();
			System.out.println("Data inserted Successfully.....");
			so.close();
			sf.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
