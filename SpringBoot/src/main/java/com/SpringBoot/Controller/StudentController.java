package com.SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Model.Student;
import com.SpringBoot.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping({"/","AllStudents"})
	public List<Student> allStudents() {
		return service.allStudents();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student){
		return service.addStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable("id") Long std_id) {
		return service.deleteStudent(std_id);
	}
	
	@GetMapping("/displayStudent/{id}")
	public Student listStudent(@PathVariable("id") Long std_id) {
		return service.listStudent(std_id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable("id")long id ,@RequestBody Student student) {
		Student e=service.listStudent(id);
		e.setStd_name(student.getStd_name());
		e.setStd_course(student.getStd_course());
		e.setStd_year(student.getStd_year());
		e.setStd_section(student.getStd_section());		
		return service.updateStudent(e);
	}
	
}
