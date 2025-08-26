package com.datapro;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		System.out.println("Enter the Employee ID :");
		int emp_id=sc.nextInt();
		String query="delete from Employee where emp_id= :emp_id";
		Query delete=s.createQuery(query);
		delete.setParameter("emp_id", emp_id);
		delete.executeUpdate();
		System.out.println("Delete Data Sucessfully...");
		tx.commit();
		s.close();
		sf.close();
	}

}
