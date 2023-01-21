package com.studentManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.api.Student;
import com.studentManagement.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> loadStudents() {
		
		List<Student> loadStudents = studentDAO.loadStudents();
		return loadStudents;
	}

	@Override
	public void saveStudent(Student student) {
		//write your business logic here
		//Company criteria
		if(student.getCountry().equals("Nigeria"))
		{
			System.out.println("Mail sent to :"+student.getName());
		}
		studentDAO.saveStudent(student);
		
	}

	@Override
	public Student getStudent(int id) {
		
		Student student = studentDAO.getStudent(id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {

		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int id) {

		studentDAO.deleteStudent(id);
		
	}

}
