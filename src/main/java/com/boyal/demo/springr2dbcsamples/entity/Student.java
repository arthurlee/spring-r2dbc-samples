package com.boyal.demo.springr2dbcsamples.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
public class Student extends EntityBase {
	private String code;
	private String name;
	private LocalDate birthday;
	private String address;
}
