package com.studentmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.studentmanagementsystem.entities.Student;
import com.studentmanagementsystem.repository.StudentRepository;

public class StudentDetailsServiceImp implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;
	
	//Fetching Student from database
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student student = studentRepository.getStudentByUsername(username);
		
		if (student == null) {
			
			throw new UsernameNotFoundException("Could Not Found User");
		}
		
		CustomStudentDetails customStudentDetails = new CustomStudentDetails(student);
		
		return customStudentDetails;
	}

}
