package com.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot.Model.Student;
import com.SpringBoot.Repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public Student addStudent(Student student) {		
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public Student deleteStudent(Long std_id) {
		repo.deleteById(std_id);
		return null;
	}

	@Override
	public List<Student> allStudents() {		
		return repo.findAll();
	}

	@Override
	public Student listStudent(Long std_id) {
		return repo.findById(std_id).get();
	}
}
