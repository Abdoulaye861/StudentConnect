package com.students.controller;

import java.util.List;

import com.students.application.StudentApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class StudentConnectController extends  BaseController {
	@Autowired
	StudentApplicationServices studentApplicationServices;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public List<StudentDTO> getStudents(){
		return  studentApplicationServices.getStudents();
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public StudentDTO getStudents(@PathVariable Long id){
		StudentDTO s = studentApplicationServices.getStudent(id);
		return s;
	}

	@RequestMapping(value="/student", method=RequestMethod.PUT)
	public StudentDTO update(@RequestBody StudentDTO s){
		return studentApplicationServices.save(s);
	}

	@RequestMapping(value="/student", method=RequestMethod.POST)
	public StudentDTO save(@RequestBody StudentDTO c){
		return  studentApplicationServices.save(c);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
	public boolean supprimmer(@PathVariable Long id){
		studentApplicationServices.supprimer(id);
		return true;
	}	
	

}

