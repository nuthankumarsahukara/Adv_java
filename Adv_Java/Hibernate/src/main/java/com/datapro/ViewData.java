package com.datapro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class ViewData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hiber.cnf.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session so=sf.openSession();
		Transaction tx;
		String hqlSelct = "From Employee";
		tx=so.beginTransaction();
		Query query=so.createQuery(hqlSelct);
		List<Employee> empList = query.list();
        
        for (Employee e : empList) {
            //System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getEmpSalary()+ " "+e.getEmpBg()+" "+e.getDob());
        	System.out.println("Employee ID :"+e.getEmpId());
			System.out.println("Employee Name :"+e.getEmpName());
			System.out.println("Employee Salary :"+e.getEmpSalary());
			System.out.println("Employee BloodGroup :"+e.getEmpBg());
			System.out.println("Employee DOB :"+e.getDob());
			System.out.println("----------------------------------------");
        }
        tx.commit();
        
        so.close();
        sf.close();
		
	}

}
