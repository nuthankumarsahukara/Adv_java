package com.datapro;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String query="FROM Employee where emp_id= :emp_id";
		System.out.println("Enter the Employee ID :");
		int emp_id=sc.nextInt();
		Query selectQuery=s.createQuery(query);
		selectQuery.setParameter("emp_id", emp_id);
		List<Employee> emplist=selectQuery.list();
		
		for(Employee e:emplist) {
			System.out.println("Employee ID :"+e.getEmp_id());
			System.out.println("Employee Name :"+e.getEmp_name());
			System.out.println("Employee DOB :"+e.getEmp_dob());
			System.out.println("Employee Salary :"+e.getEmp_salary());
			System.out.println("Employee Gender :"+e.getEmp_gender());
			System.out.println("Employee Department :"+e.getEmp_dept());
			System.out.println("--------------------------------------");
		}
		
		tx.commit();
		sf.close();
		s.close();
	}

}
