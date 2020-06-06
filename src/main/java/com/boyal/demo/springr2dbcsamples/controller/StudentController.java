package com.boyal.demo.springr2dbcsamples.controller;

import com.boyal.demo.springr2dbcsamples.controller.Result.ResultBase;
import com.boyal.demo.springr2dbcsamples.entity.Student;
import com.boyal.demo.springr2dbcsamples.repository.StudentRepository;
import lombok.Data;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
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
		return studentRepository.findByCodeAndActiveTrue(code)
			.switchIfEmpty(Mono.error(new IllegalArgumentException("invalid code")))
			.zipWhen(student -> {
					if (!StringUtils.isEmpty(req.address) || !StringUtils.isEmpty(req.remark)) {
						if (!StringUtils.isEmpty(req.address)) {
							student.setAddress(req.address);
						}

						if (!StringUtils.isEmpty(req.remark)) {
							student.setRemark(req.remark);
						}

						return studentRepository.save(student);
					} else {
						return Mono.error(new IllegalArgumentException("invalid parameters"));
					}
				},
				(student, studentSaved) -> studentSaved
			)
			.map(student -> ResultBase.OK())
			;
	}
}
