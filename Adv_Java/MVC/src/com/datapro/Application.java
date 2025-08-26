package com.datapro;

import com.datapro.Model.Course;
import com.datapro.View.CourseView;
import com.datapro.controller.CourseController;

public class Application {
	
	public static Course data(){
		Course course=new Course();
		course.setCourseId(101);
		course.setCourseName("Java Full Stack");
		course.setCourseDuration(6);
		course.setCourseFee(25000);
		return course;
	}

	public static void main(String[] args) {
		Course model=data();
		CourseView view=new CourseView();
		CourseController controller=new CourseController(model, view);
		controller.UpdateView();
		 controller.setCourseName("JAVA FULL STACK");  
         System.out.println("\nCourse Details after updating: ");  
  
         controller.UpdateView();  
	}

}
