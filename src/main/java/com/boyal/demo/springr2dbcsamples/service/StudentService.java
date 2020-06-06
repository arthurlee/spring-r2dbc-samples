package com.boyal.demo.springr2dbcsamples.service;

import com.boyal.demo.springr2dbcsamples.entity.Student;
import com.boyal.demo.springr2dbcsamples.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Flux<Student> findAll() {
		return studentRepository.findAll();
	}

	public Mono<Student> findStudentByCode(String code) {
		return studentRepository.findByCodeAndActiveTrue(code)
			.switchIfEmpty(Mono.error(new IllegalArgumentException("invalid student code: " + code)));
	}

	public Mono<Student> updateStudentProfile(Student student, String address, String remark) {
		if (!StringUtils.isEmpty(address) || !StringUtils.isEmpty(remark)) {
			if (!StringUtils.isEmpty(address)) {
				student.setAddress(address);
			}

			if (!StringUtils.isEmpty(remark)) {
				student.setRemark(remark);
			}

			return studentRepository.save(student);
		} else {
			return Mono.error(new IllegalArgumentException("invalid parameters student update profile"));
		}
	}

}
