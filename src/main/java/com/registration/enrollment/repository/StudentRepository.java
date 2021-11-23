package com.registration.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.enrollment.method.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByEmail(String email);

//	List<Student> updateStudent(Student student);

}
