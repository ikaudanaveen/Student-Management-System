package net.devopsschool.sms1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devopsschool.sms1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
