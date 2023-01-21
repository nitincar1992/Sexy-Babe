package com.studentManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentManagement.api.Student;
import com.studentManagement.rowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Student> loadStudents() {
		
		String sql = "select * from students";
		//Logic to get the list of students from DB
		List<Student> query = template.query(sql, new StudentRowMapper());
		
		return query;
	}

	@Override
	public void saveStudent(Student student) {

		//Logic for saving data to DB
		Object[] obj = {student.getName(), student.getMobile(), student.getCountry()};
		String sql = "insert into students(name, mobile, country) values(?, ?, ?)";
		template.update(sql, obj);
		System.out.println("1 Row added");
	}

	@Override
	public Student getStudent(int id) {
		
		String sql = "SELECT * FROM students WHERE ID=?";
		Student student = template.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {

		String sql = "UPDATE students SET name=?, mobile=?, country=? WHERE id=?";
		template.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
		System.out.println("1 Record updated");
		
	}

	@Override
	public void deleteStudent(int id) {

		String sql = "DELETE FROM students where id=?";
		template.update(sql, id);
		System.out.println("1 Record deleted...");
	}

}
