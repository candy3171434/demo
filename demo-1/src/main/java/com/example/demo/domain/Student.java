package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student
{
	@Id
	@Column(name = "studentId")
	private int studentId;

	@Column(name = "name")
	private String name;

}
