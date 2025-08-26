package com.datapro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserUpdate {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the EmpId :");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the EmpName :");
		String name=sc.nextLine();
		System.out.println("Enter the EmpBloodGroup :");
		String bg=sc.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("Enter the EmpDOB (yyyy-mm-dd):");
		String date=sc.nextLine();
		try {
			Date date_inp=sdf.parse(date);
			tx=so.beginTransaction();
			String hqlUpdate = "UPDATE Employee SET EmpName = :empname,EmpBg = :empbg, Dob= :empdob WHERE EmpId = :empid";
			Query query=so.createQuery(hqlUpdate);
			query.setParameter("empname", name);
			query.setParameter("empbg", bg);
			query.setParameter("empdob", date_inp);
			query.setParameter("empid", id);
			int result = query.executeUpdate();
            System.out.println("Updated " + result + " record(s).");
			tx.commit();
		}catch(ParseException e) {
			e.printStackTrace();
		}finally{
			so.close();
			sf.close();
		}	
	}

}
