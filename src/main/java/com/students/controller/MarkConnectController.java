package com.students.controller;

import com.students.application.MarkApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class MarkConnectController extends  BaseController {
	@Autowired
	MarkApplicationServices markApplicationServices;
	
	@RequestMapping(value="/mark", method=RequestMethod.GET)
	public List<MarkDTO> getMarks(){
		return  markApplicationServices.getMarks();
	}
	
	@RequestMapping(value="/mark/{id}", method=RequestMethod.GET)
	public MarkDTO getMark(@PathVariable Long id){
		MarkDTO s = markApplicationServices.getMark(id);
		return s;
	}

	@RequestMapping(value="/mark", method=RequestMethod.PUT)
	public MarkDTO update(@RequestBody MarkDTO s){
		return markApplicationServices.save(s);
	}

	@RequestMapping(value="/mark", method=RequestMethod.POST)
	public MarkDTO save(@RequestBody MarkDTO c){
		return  markApplicationServices.save(c);
	}
	
	@RequestMapping(value="/mark/{id}", method=RequestMethod.DELETE)
	public boolean supprimmer(@PathVariable Long id){
		markApplicationServices.supprimer(id);
		return true;
	}	
	

}

