package com.students.application;

import java.util.List;

import com.students.infrastructure.util.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.students.controller.StudentDTO;
import com.students.dao.StudentRepository;
import com.students.entities.Student;

@Service
@Transactional
public class StudentApplicationServices {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
    OrikaBeanMapper mapper;
	public List<StudentDTO> getStudents(){
		return mapper.convertListDTO(studentRepository.findAll(),StudentDTO.class);
	}
	

	public StudentDTO getStudent(Long id){
		Student student = studentRepository.findOne(id);
		StudentDTO dtos = mapper.map( student, StudentDTO.class);
		return  dtos;
	}	
	

	public StudentDTO save( StudentDTO c){
		Student s;
		if(c.getId()!= null) {
		s = studentRepository.findOne(c.getId());
		mapper.map(c, s);
		}
		else {
			s = mapper.convertDTO(c, Student.class);
		}
		return  mapper.convertDTO( studentRepository.save(s), StudentDTO.class);
	}
	
	
	public boolean supprimer( Long id){
		studentRepository.delete(id);
		return true;
	}	
	
	
}
