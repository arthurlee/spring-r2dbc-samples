package com.boyal.demo.springr2dbcsamples.controller;

import com.boyal.demo.springr2dbcsamples.entity.Student;
import com.boyal.demo.springr2dbcsamples.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("")
	public Flux<Student> index() {
		return studentRepository.findAll();
	}


}
