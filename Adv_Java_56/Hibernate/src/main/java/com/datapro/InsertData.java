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
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse("2025-06-01");
			tx=so.beginTransaction();
			Employee e=new Employee(101, "Sai Kumar", date, "Male", "HR", 9966783739l);
			so.persist(e);
			tx.commit();
			System.out.println("Data inserted Successfully.....");
			so.close();
			sf.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
