package com.datapro.controller;

import com.datapro.Model.Course;
import com.datapro.View.CourseView;

public class CourseController {
	private Course model;
	private CourseView view;
	
	public CourseController(Course model,CourseView view) {
		this.model=model;
		this.view=view;
	}

	public int getCourseId() {
		return model.getCourseId();
	}
	public void setCourseId(int courseId) {
		model.setCourseId(courseId);
	}
	public String getCourseName() {
		return model.getCourseName();
	}
	public void setCourseName(String courseName) {
		model.setCourseName(courseName);
	}
	public double getCourseFee() {
		return model.getCourseFee();
	}
	public void setCourseFee(double courseFee) {
		model.setCourseFee(courseFee);
	}
	public int getCourseDuration() {
		return model.getCourseDuration();
	}
	public void setCourseDuration(int courseDuration) {
		model.setCourseDuration(courseDuration);
	}
	
	public void UpdateView() {
		view.printDetails(getCourseId(), getCourseName(), getCourseFee(), getCourseDuration());
	}
	
}
