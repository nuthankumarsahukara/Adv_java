package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
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
			
			System.out.println("Enter the Employee ID :");
			int emp_id=sc.nextInt();
			
			date=sdf.parse(emp_date);
			tx=s.beginTransaction();
			String query="update Employee set emp_name= :emp_name, emp_dob= :emp_dob, emp_gender= :emp_gender, emp_dept= :emp_dept, emp_phone= :emp_phone where emp_id= :emp_id";
			Query updateQuery=s.createQuery(query);
			updateQuery.setParameter("emp_name", emp_name);
			updateQuery.setParameter("emp_dob", date);
			updateQuery.setParameter("emp_gender", emp_gender);
			updateQuery.setParameter("emp_dept", emp_dept);
			updateQuery.setParameter("emp_phone", emp_phone);
			updateQuery.setParameter("emp_id", emp_id);
			
			int rows=updateQuery.executeUpdate();
			
			System.out.println("Updated " + rows + " records");
			tx.commit();
			s.close();
			sf.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
