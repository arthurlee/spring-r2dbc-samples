package com.boyal.demo.springr2dbcsamples.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
	@Id
	private Long id;

	private String code;
	private String name;
	private LocalDate birthday;
	private String address;

	private String remark;
	private boolean active;

	@Column("createdAt")
	private LocalDateTime createdAt;

	//	@CreatedBy
	@Column("createdBy")
	private String createdBy;

	@Column("updatedAt")
	private LocalDateTime updatedAt;

	@Column("updatedBy")
	private String updatedBy;
}
