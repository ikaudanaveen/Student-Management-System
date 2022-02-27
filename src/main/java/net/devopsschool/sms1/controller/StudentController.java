package net.devopsschool.sms1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.devopsschool.sms1.entity.Student;
import net.devopsschool.sms1.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Handler method to handle list students and return mode and view 
	@GetMapping("/students")
	public String ListStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//Create student object to hold student form data 
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
		
	}
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		//get student from database by ID 
			Student existingStudent=studentService.getStudentById(id);
			existingStudent.setId(id);
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			existingStudent.setEmail(student.getEmail());
			//Save updated student object
			studentService.updateStudent(existingStudent);
			return "redirect:/students";
			
		
	}
	
	//Handler method to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}

}
