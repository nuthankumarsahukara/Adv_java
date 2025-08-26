package com.datapro;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateData {

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
			date=sdf.parse("1999-08-20");
			tx=so.beginTransaction();
			String query="UPDATE Employee SET emp_name= :emp_name,emp_dob = :emp_dob,emp_salary = :emp_salary,emp_gender = :emp_gender,emp_dept =:emp_dept WHERE emp_id = :emp_id";
			Query queryUpdate=so.createQuery(query);
			queryUpdate.setParameter("emp_name", "Nuthan Kumar");
			queryUpdate.setParameter("emp_dob", date);
			queryUpdate.setParameter("emp_salary", 18000);
			queryUpdate.setParameter("emp_gender", "male");
			queryUpdate.setParameter("emp_dept", "SoftwareTrainer");
			queryUpdate.setParameter("emp_id",101);
			
			int result = queryUpdate.executeUpdate();
            System.out.println("Updated " + result + " record(s).");
            tx.commit();		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
