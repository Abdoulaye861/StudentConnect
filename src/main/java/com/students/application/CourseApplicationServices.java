package com.students.application;

import com.students.controller.CourseDTO;
import com.students.dao.CourseRepository;
import com.students.dao.TeacherRepository;
import com.students.entities.Course;
import com.students.entities.Teacher;
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
public class CourseApplicationServices {
	@Autowired
	private CourseRepository courseRepository;


    @Autowired
    TeacherRepository teacherRepository;

	@Autowired
    OrikaBeanMapper mapper;
	public List<CourseDTO> getCourses(){
		return mapper.convertListDTO(courseRepository.findAll(),CourseDTO.class);
	}

	public CourseDTO getCourse(Long id){
		Course course = courseRepository.findOne(id);
		CourseDTO dtos = mapper.map( course, CourseDTO.class);
		return  dtos;
	}

	public CourseDTO create(Long teacheid, String name, MultipartFile file){
        Teacher teacher = teacherRepository.findOne(teacheid);
		Course s = new Course();
		s.setName(name);
		int dot = file.getOriginalFilename().lastIndexOf(".");
		String ext =  file.getOriginalFilename().substring(dot);
		s.setFileName(name + ext);
		s.setPublishedDate(new Date());
		try {
			s.setData(file.getBytes());
			teacher.addCourse(s);
			teacherRepository.save(teacher);
			return  mapper.convertDTO( s, CourseDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public CourseDTO save( CourseDTO c){
		Course s;
		if(c.getId()!= null) {
		s = courseRepository.findOne(c.getId());
		mapper.map(c, s);
		}
		else {
			s = mapper.convertDTO(c, Course.class);
		}
		courseRepository.save(s);
		return  mapper.convertDTO( s, CourseDTO.class);
	}
	
	
	public boolean supprimer( Long id){
		courseRepository.delete(id);
		return true;
	}

	public HttpEntity<byte[]> getCourseContent(Long id) {
		Course course = courseRepository.findOne(id);
		String fileName = course.getFileName();
		byte[] documentBody = course.getData();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + fileName.replace(" ", "_"));
		header.setContentLength(documentBody.length);

		return new HttpEntity<>(documentBody, header);
	}

    public List<CourseDTO> getCourses(Long teacheid) {
        Teacher teacher = teacherRepository.findOne(teacheid);
        return mapper.convertListDTO(teacher.getCourses(), CourseDTO.class);

    }
}
