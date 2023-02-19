package com.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentmanagementsystem.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("select s from Student s where s.email = : email")
	public Student getStudentByUsername(@Param("email") String email);
	
	
}
