package com.datapro;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDataSelect {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=so.beginTransaction();
		String hqlsel="From Employee where EmpId = :empid";
		Query query=so.createQuery(hqlsel);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Emp Id:");
		int id=sc.nextInt();
		query.setParameter("empid", id);
		List<Employee> emplist=query.list();		
		for (Employee e : emplist) {
			System.out.println("Employee ID :"+e.getEmpId());
			System.out.println("Employee Name :"+e.getEmpName());
			System.out.println("Employee Salary :"+e.getEmpSalary());
			System.out.println("Employee BloodGroup :"+e.getEmpBg());
			System.out.println("Employee DOB :"+e.getDob());
        }
        tx.commit();
        so.close();
        sf.close();
	}

}
