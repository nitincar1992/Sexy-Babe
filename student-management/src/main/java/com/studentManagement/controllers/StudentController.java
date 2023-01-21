package com.studentManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentManagement.api.Student;
import com.studentManagement.dao.StudentDAO;
import com.studentManagement.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/showStudentList")
	public String showStudentList(Model model)
	{
		//doing a service call to get data
		List<Student> students = studentService.loadStudents();
		model.addAttribute("listOfMany", students);
		return "studentList-page";
	}
	
	@GetMapping("/addStudentToList")
	public String addStudentToList(Model model)
	{
		Student student = new Student();
		model.addAttribute("studentDTO", student);
		student.setName("Matya");
		student.setMobile(9999999999L);
		student.setCountry("India");
		return "addStudentToList-page";
	}
	
	@PostMapping("/saveStudentToList")
	public String saveStudentToList(Student student)
	{
		System.out.println(student);
		//Logic for adding and updating record
		//if user doesnt have id or id=0 then do insert else do update
		if(student.getId() == 0)
		{
			//Logic for adding the StudentDTO object to DB and doing a service call to save student
			studentService.saveStudent(student);
		}
		else
		{
			studentService.updateStudent(student);
		}
		return "redirect:showStudentList";
	}
	
	@GetMapping("/updateStudentList")
	public String updateStudentList(@RequestParam("userId") int id, Model model)
	{
		System.out.println("Looking for id number "+ id);
		Student myStudent = studentService.getStudent(id);
		model.addAttribute("studentDTO", myStudent);
		return "addStudentToList-page";
	}

	@GetMapping("/deleteStudentList")
	public String deleteStudentList(@RequestParam("userId") int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/showStudentList";
	}
	
}
