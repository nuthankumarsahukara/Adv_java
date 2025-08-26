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
		Scanner sc =new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		System.out.println("Enter the Emp_id :");
		int emp_id=sc.nextInt();
		String query="delete from Employee where emp_id= :emp_id";
		Query deleteQuery=s.createQuery(query);
		deleteQuery.setParameter("emp_id", emp_id);
		deleteQuery.executeUpdate();
		System.out.println("Data Deleted Successfully....");
		tx.commit();
		
		s.close();
		sf.close();
	}

}
