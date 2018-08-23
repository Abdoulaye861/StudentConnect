package com.students.application;

import com.students.controller.WorkDTO;
import com.students.dao.WorkRepository;
import com.students.entities.Work;
import com.students.infrastructure.util.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WorkApplicationServices {
	@Autowired
	private WorkRepository workRepository;

	@Autowired
    OrikaBeanMapper mapper;
	public List<WorkDTO> getWorks(){
		return mapper.convertListDTO(workRepository.findAll(),WorkDTO.class);
	}

	public WorkDTO getWork(Long id){
		Work work = workRepository.findOne(id);
		WorkDTO dtos = mapper.map( work, WorkDTO.class);
		return  dtos;
	}

	public WorkDTO create(String name, MultipartFile file){
		Work s = new Work();
		s.setFileName(name);
		int dot = file.getOriginalFilename().lastIndexOf(".");
		String ext =  file.getOriginalFilename().substring(dot);
		s.setFileName(name + ext);
		s.setUploadedDate(new Date());
		try {
			s.setData(file.getBytes());
			workRepository.save(s);
			return  mapper.convertDTO( s, WorkDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public WorkDTO save( WorkDTO c){
		Work s;
		if(c.getId()!= null) {
		s = workRepository.findOne(c.getId());
		mapper.map(c, s);
		}
		else {
			s = mapper.convertDTO(c, Work.class);
		}
		workRepository.save(s);
		return  mapper.convertDTO( s, WorkDTO.class);
	}
	
	
	public boolean supprimer( Long id){
		workRepository.delete(id);
		return true;
	}

	public HttpEntity<byte[]> getWorkContent(Long id) {
		Work work = workRepository.findOne(id);

		String fileName = work.getFileName();
		byte[] documentBody = work.getData();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + fileName.replace(" ", "_"));
		header.setContentLength(documentBody.length);

		return new HttpEntity<>(documentBody, header);
	}
}
