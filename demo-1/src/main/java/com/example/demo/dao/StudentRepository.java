package com.example.demo.dao;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
}
