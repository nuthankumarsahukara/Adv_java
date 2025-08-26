package com.datapro;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Employee Id :");
		int id=sc.nextInt();
		
		tx=so.beginTransaction();
		String hqldel="DELETE FROM Employee WHERE EmpId = :id";
		Query query=so.createQuery(hqldel);
		query.setParameter("id", id);
		int result=query.executeUpdate();
		System.out.println("Delete "+result+" Records");
		tx.commit();		
		
		tx=so.beginTransaction();
		String hqlsel="FROM Employee";
		Query query1=so.createQuery(hqlsel);
		List<Employee> emplist=query1.list();
		
		for(Employee e:emplist) {
			System.out.println("Employee ID :"+e.getEmpId());
			System.out.println("Employee Name :"+e.getEmpName());
			System.out.println("Employee Salary :"+e.getEmpSalary());
			System.out.println("Employee BloodGroup :"+e.getEmpBg());
			System.out.println("Employee DOB :"+e.getDob());
			System.out.println("----------------------------------------");
		}
		
		so.close();
		sf.close();
	}

}
