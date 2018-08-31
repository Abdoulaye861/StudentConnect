package com.students.application;

import com.students.controller.WorkAndMarkDTO;
import com.students.controller.WorkDTO;
import com.students.dao.CourseRepository;
import com.students.dao.StudentRepository;
import com.students.dao.WorkRepository;
import com.students.entities.Course;
import com.students.entities.Student;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WorkApplicationServices {
	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private StudentRepository studentRepository;


	@Autowired
	private CourseRepository courseRepository;


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

	public WorkDTO create(Long studentid, Long courseid,String name, MultipartFile file){
		Student student = studentRepository.findOne(studentid);
		Course course = courseRepository.findOne(courseid);
		if(student == null || course == null){
		  throw new RuntimeException("student or course is null");
		}
		Work work = new Work();
		work.setFileName(name);
		int dot = file.getOriginalFilename().lastIndexOf(".");
		String ext =  file.getOriginalFilename().substring(dot);
		work.setFileName(name + ext);
		work.setUploadedDate(new Date());
		work.setStudent(student);
		work.setCourse(course);
		try {
			work.setData(file.getBytes());
			workRepository.save(work);
			return  mapper.convertDTO( work, WorkDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public WorkDTO save( WorkDTO c){
		Work work;
		if(c.getId()!= null) {
		work = workRepository.findOne(c.getId());
		mapper.map(c, work);
		}
		else {
			work = mapper.convertDTO(c, Work.class);
		}
		workRepository.save(work);
		return  mapper.convertDTO( work, WorkDTO.class);
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

	public boolean hasWork(Long studentid, Long courseid) {
		Student student = studentRepository.findOne(studentid);
		if (student.getWorks() != null){
			for (Work work: student.getWorks()){
				if (work.getCourse().getId() == courseid){
					return true;
				}
			}
		}
		return false;
	}

	public List<WorkAndMarkDTO> getAllStudentWorksForTeacher(Long teacherid , Long studentid) {
		List<WorkAndMarkDTO> works = new ArrayList<>();
		Student student = studentRepository.findOne(studentid);
		if(student.getWorks() != null){
			for(Work work: student.getWorks()){
				if(work.getCourse().getPublisher().getId()== teacherid){
					WorkAndMarkDTO dto = new WorkAndMarkDTO();
					dto.setCourseid(work.getCourse().getId());
					dto.setCourseName(work.getCourse().getName());
					dto.setWorkid(work.getId());
					dto.setWorkFileName(work.getFileName());
					if(work.getMark() != null){
						dto.setMarkid(work.getMark().getId());
						dto.setMarkValue(work.getMark().getMarkValue());
					}
					works.add(dto);
				}
			}
		}
		return  works;
	}
}
