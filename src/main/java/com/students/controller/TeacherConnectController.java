package com.students.controller;

import java.util.List;

import com.students.application.TeacherApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class TeacherConnectController {
	@Autowired
    TeacherApplicationServices teacherApplicationServices;
	
	@RequestMapping(value="/teacher", method=RequestMethod.GET)
	public List<TeacherDTO> getTeachers(){
		return  teacherApplicationServices.getTeachers();
	}
	
	@RequestMapping(value="/teacher/{id}", method=RequestMethod.GET)
	public TeacherDTO getTeacher(@PathVariable Long id){
		return  teacherApplicationServices.getTeacher(id);
	}

	@RequestMapping(value="/teacher", method=RequestMethod.PUT)
	public TeacherDTO update(@RequestBody TeacherDTO s){
		return teacherApplicationServices.save(s);
	}

	@RequestMapping(value="/teacher", method=RequestMethod.POST)
	public TeacherDTO save(@RequestBody TeacherDTO c){
		return  teacherApplicationServices.save(c);
	}
	
	@RequestMapping(value="/teacher/{id}", method=RequestMethod.DELETE)
	public boolean supprimmer(@PathVariable Long id){
		teacherApplicationServices.supprimmer(id);
		return true;
	}	
	

}
