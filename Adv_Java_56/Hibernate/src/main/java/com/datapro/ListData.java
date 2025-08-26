package com.datapro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ListData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String query="FROM Employee";
		Query selectq=s.createQuery(query);
		List<Employee> emplist= selectq.list();
		for(Employee e:emplist) {
			System.out.println("Employee ID :"+e.getEmp_id());
			System.out.println("Employee Name :"+e.getEmp_name());
			System.out.println("Employee DOB :"+e.getEmp_dob());
			System.out.println("Employee Gender :"+e.getEmp_gender());
			System.out.println("Employee Department :"+e.getEmp_dept());
			System.out.println("Employee Phone Number :"+e.getEmp_phone());
			System.out.println("-------------------------------");
		}
		tx.commit();
		s.close();
		sf.close();
	}

}
