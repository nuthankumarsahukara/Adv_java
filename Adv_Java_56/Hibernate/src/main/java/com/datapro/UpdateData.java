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
		Session s=sf.openSession();
		Transaction tx=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse("2008-05-15");
			tx=s.beginTransaction();
			String query="update Employee set emp_name= :emp_name, emp_dob= :emp_dob, emp_gender= :emp_gender, emp_dept= :emp_dept, emp_phone= :emp_phone where emp_id= :emp_id";
			Query updateQuery=s.createQuery(query);
			updateQuery.setParameter("emp_name", "Nuthan Kumar");
			updateQuery.setParameter("emp_dob", date);
			updateQuery.setParameter("emp_gender", "Male");
			updateQuery.setParameter("emp_dept", "SoftwareTrainer");
			updateQuery.setParameter("emp_phone", 9848530641l);
			updateQuery.setParameter("emp_id", 101);
			
			int rows=updateQuery.executeUpdate();
			
			System.out.println("Updated " + rows + " records");
			tx.commit();
			s.close();
			sf.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
