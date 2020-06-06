package com.boyal.demo.springr2dbcsamples.repository;

import com.boyal.demo.springr2dbcsamples.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

}
