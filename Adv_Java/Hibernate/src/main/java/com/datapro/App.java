package com.datapro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		System.out.println("Application started");
		Configuration cfg = new Configuration();
		cfg.configure("hiber.cnf.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session so = sf.openSession();
        Transaction tx = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
		try {
			date = sdf.parse("2024-08-18");
			tx = so.beginTransaction();
	        Employee emp = new Employee(104, "Kiran", 19850.23, "A+", date);
	        so.persist(emp);
	        tx.commit();
	        System.out.println("Inserted data");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        

	}

}
