package com.spring;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


public class App 
{
    public static void main( String[] args )
    {
    	DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    	reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));

        Student student=(Student)beanFactory.getBean("studentBean");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Course Id:");
        int c_id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Course Name:");
        String c_name=sc.nextLine();
        System.out.println("Enter the Course Duration:");
        int c_dur=sc.nextInt();
        
        System.out.println("Enter the Student Id:");
        int s_id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Student Name:");
        String s_name=sc.nextLine();
        
        Course userCourse=new Course(c_id,c_name,c_dur);
        Student userStudent=new Student(s_id, s_name, userCourse);
        
        userStudent.studentDetails();
        
    }
}
