package com.students.application;

import com.students.controller.MarkDTO;
import com.students.dao.MarkRepository;
import com.students.entities.Mark;
import com.students.infrastructure.util.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarkApplicationServices {
	@Autowired
	private MarkRepository markRepository;
	
	@Autowired
    OrikaBeanMapper mapper;
	public List<MarkDTO> getMarks(){
		return mapper.convertListDTO(markRepository.findAll(),MarkDTO.class);
	}
	

	public MarkDTO getMark(Long id){
		Mark mark= markRepository.findOne(id);
		MarkDTO dtos = mapper.map( mark, MarkDTO.class);
		return  dtos;
	}	
	

	public MarkDTO save( MarkDTO c){
		Mark s;
		if(c.getId()!= null) {
		s = markRepository.findOne(c.getId());
		mapper.map(c, s);
		}
		else {
			s = mapper.convertDTO(c, Mark.class);
		}
		return  mapper.convertDTO( markRepository.save(s), MarkDTO.class);
	}
	
	
	public boolean supprimer( Long id){
		markRepository.delete(id);
		return true;
	}	
	
	
}
