package com.SpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        	Employee emp=(Employee) context.getBean("empBean");
        	emp.display_emp();
    }
}
