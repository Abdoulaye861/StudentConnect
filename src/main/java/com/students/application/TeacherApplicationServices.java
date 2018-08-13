package com.students.application;

import java.util.List;

import com.students.infrastructure.util.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.students.controller.TeacherDTO;
import com.students.dao.TeacherRepository;
import com.students.entities.Teacher;

@Service
@Transactional
public class TeacherApplicationServices {
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
    OrikaBeanMapper mapper;
	public List<TeacherDTO> getTeachers(){
		return mapper.convertListDTO(teacherRepository.findAll(),TeacherDTO.class);
	}
	

	public TeacherDTO getTeacher(Long id){
		Teacher t = teacherRepository.findOne(id);
		return mapper.map( t, TeacherDTO.class);
	}	
	

	public TeacherDTO save( TeacherDTO c){
		Teacher s;
		if(c.getId()!= null) {
		s = teacherRepository.findOne(c.getId());
		mapper.map(c, s);
		}
		else {
			s = mapper.convertDTO(c, Teacher.class);
		}
		return  mapper.convertDTO( teacherRepository.save(s), TeacherDTO.class);
	}
	
	
	public boolean supprimmer( Long id){
		teacherRepository.delete(id);
		return true;
	}	
	
	
}
