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
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		Scanner sc=new Scanner(System.in);
		try {
			
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
			
			System.out.println("Enter the Emp ID :");
			int emp_id=sc.nextInt();
			
			date=sdf.parse(emp_dob);
			tx=so.beginTransaction();
			String query="UPDATE Employee SET emp_name= :emp_name,emp_dob = :emp_dob,emp_salary = :emp_salary,emp_gender = :emp_gender,emp_dept =:emp_dept WHERE emp_id = :emp_id";
			Query queryUpdate=so.createQuery(query);
			queryUpdate.setParameter("emp_name", emp_name);
			queryUpdate.setParameter("emp_dob", date);
			queryUpdate.setParameter("emp_salary", emp_sal);
			queryUpdate.setParameter("emp_gender", emp_gender);
			queryUpdate.setParameter("emp_dept", emp_dept);
			queryUpdate.setParameter("emp_id", emp_id);
			
			int result = queryUpdate.executeUpdate();
            System.out.println("Updated " + result + " record(s).");
            tx.commit();		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
