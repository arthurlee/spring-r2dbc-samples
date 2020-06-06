package com.boyal.demo.springr2dbcsamples.controller;

import com.boyal.demo.springr2dbcsamples.controller.Result.ResultBase;
import com.boyal.demo.springr2dbcsamples.entity.Student;
import com.boyal.demo.springr2dbcsamples.service.StudentService;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/students")
public class StudentController {

	// Spring recommend final and passed in constructor
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// can be visited by /api/students or /api/students/
	// @GetMapping("/") can only be visited via /api/students/
	@GetMapping("")
	public Flux<Student> index() {
		return studentService.findAll();
	}

	@Data
	static class ModifyReq {
		private String address;
		private String remark;
	}

	@PutMapping("/{code}")
	public Mono<ResultBase> modify(
		  @PathVariable("code") String code
		, @Validated ModifyReq req
	) {
		return studentService.findStudentByCode(code)
			.zipWhen(student -> studentService.updateStudentProfile(student, req.address, req.remark),
				(student, studentSaved) -> studentSaved
			)
			.map(student -> ResultBase.OK())
			;
	}
}
