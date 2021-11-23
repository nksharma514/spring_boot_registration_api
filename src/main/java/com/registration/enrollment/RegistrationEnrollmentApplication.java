package com.registration.enrollment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.enrollment.method.Student;
import com.registration.enrollment.repository.StudentRepository;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class RegistrationEnrollmentApplication {
	
	@Autowired
	private StudentRepository repository;
	
	
	@PostMapping("/register")
	public String register(@RequestBody Student student) {
		repository.save(student);
		return " Hi " + student.getName() + " Your Registration Process Successfully Completed. ";
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> findAllStudents() {
		return repository.findAll();
	}
	
	@GetMapping("/findStudent/{email}")
	public List<Student> findStudent(@PathVariable String email) {
		return repository.findByEmail(email);
	}
	
	@DeleteMapping("/cancel/{id}")
    public List<Student> cancelRegistration(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student inputStudent) {
		Student student= repository.getById(id);
		student.setName(inputStudent.getName());
		student.setPhone(inputStudent.getPhone());
		student.setEmail(inputStudent.getEmail());
		student.setPassout_year(inputStudent.getPassout_year());
		student.setSubject(inputStudent.getSubject());
		student.setComments(inputStudent.getComments());
		
		return repository.save(student);
	}
	
	
	@RequestMapping("/getById/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> Student = repository.findById(id);
		return Student.get();
				
	}
	
		
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(RegistrationEnrollmentApplication.class, args);
	}

}
