package net.devopsschool.sms1.service;

import java.util.List;

import net.devopsschool.sms1.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
