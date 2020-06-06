package com.boyal.demo.springr2dbcsamples.repository;

import com.boyal.demo.springr2dbcsamples.entity.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

	@Query(value = """
		 select *
		 from Student
		 where code = :code
			and active = 1 
		""")
	Mono<Student> findByCodeAndActiveTrue(String code);
}
