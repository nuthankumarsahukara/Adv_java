package com.datapro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDate {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Empid :");
		int empid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Emp Name:");
		String empname=sc.nextLine();
		System.out.println("Enter the Emp Salary:");
		double empsal=sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the Emp Blood Group :");
		String empbg=sc.nextLine();
		System.out.println("Enter the Emp DOB (yyyy-mm-dd) :");
		String user_date=sc.nextLine();
		try {
			Date date = sdf.parse(user_date);
			tx = so.beginTransaction();
			Employee emp=new Employee(empid,empname,empsal,empbg,date);
			so.persist(emp);
	        tx.commit();
	        System.out.println("Inserted data");
		}catch(ParseException e){
			e.printStackTrace();
		}finally {
			so.close();
			sf.close();
		}
	}

}
