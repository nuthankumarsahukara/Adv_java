package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date date = sdf.parse("2024-05-06");
			tx=so.beginTransaction();
			String hqlUpdate = "UPDATE Employee SET EmpName = :empname,EmpSalary = :empsal, EmpBg = :empbg, Dob= :empdob WHERE EmpId = :empid";
            Query queryUpdate = so.createQuery(hqlUpdate);
            queryUpdate.setParameter("empname", "Rama rao");
            queryUpdate.setParameter("empsal", 1900.64);            
            queryUpdate.setParameter("empbg", "o-");
            queryUpdate.setParameter("empdob", date);
            queryUpdate.setParameter("empid", 105);  
            int result = queryUpdate.executeUpdate();
            System.out.println("Updated " + result + " record(s).");
            tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			so.close();
			sf.close();
		}
	}

}
