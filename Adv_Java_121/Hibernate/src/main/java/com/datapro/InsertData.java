package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Application Started....");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse("2024-08-18");
			tx=s.beginTransaction();
			Employee e=new Employee(104,"Rahul",date,15000,"Male","Accounts");
			s.persist(e);
			tx.commit();
			System.out.println("Insert Data Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
