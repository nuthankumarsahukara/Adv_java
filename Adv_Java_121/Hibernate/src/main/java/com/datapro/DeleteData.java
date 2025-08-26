package com.datapro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String query="delete from Employee where emp_id= :emp_id";
		Query deleteQuery=s.createQuery(query);
		deleteQuery.setParameter("emp_id", 103);
		deleteQuery.executeUpdate();
		System.out.println("Data Deleted Successfully....");
		tx.commit();
		
		s.close();
		sf.close();
	}

}
