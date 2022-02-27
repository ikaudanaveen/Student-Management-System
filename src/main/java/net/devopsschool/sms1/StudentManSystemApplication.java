package net.devopsschool.sms1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.devopsschool.sms1.entity.Student;
import net.devopsschool.sms1.repository.StudentRepository;

@SpringBootApplication
public class StudentManSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Student student1=new Student("Ramesh","jha","rameshjha@gmail.com");
		studentRepository.save(student1);
		Student student2=new Student("nishtha","jha","nishthajha@gmail.com");
		studentRepository.save(student2);*/
		
	}
	

}
