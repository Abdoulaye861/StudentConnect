package com.students.controller;

import com.students.application.WorkApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class WorkConnectController extends  BaseController{
	@Autowired
	WorkApplicationServices workApplicationServices;

	@RequestMapping(value="/work", method=RequestMethod.GET)
	public List<WorkDTO> getworks(){
		return  workApplicationServices.getWorks();
	}


	@RequestMapping(value="/teacher/{teacherid}/{studentid}/marks", method=RequestMethod.GET)
	public List<WorkAndMarkDTO> getAllStudentWorksForTeacher(@PathVariable Long teacherid,  @PathVariable Long studentid){
		return  workApplicationServices.getAllStudentWorksForTeacher(teacherid, studentid);
	}


	@RequestMapping(value="/work/{id}", method=RequestMethod.GET)
	public WorkDTO getwork(@PathVariable Long id){
		return  workApplicationServices.getWork(id);
	}



    @RequestMapping(value="/work/{id}/content", method=RequestMethod.GET)
    @ResponseBody
    public HttpEntity<byte[]> getCourseContent( @PathVariable Long id){
        return  workApplicationServices.getWorkContent(id);
    }


	@RequestMapping(value="/work/hasWork/{studentid}/{courseid}", method=RequestMethod.GET)
	@ResponseBody
	public boolean hasWork( @PathVariable Long studentid,  @PathVariable Long courseid ){
		return  workApplicationServices.hasWork(studentid,courseid);
	}


    @RequestMapping(value="/student/work/create", method=RequestMethod.POST)
    public WorkDTO create(@RequestParam("studentid") Long studentid, @RequestParam("courseid") Long courseid, @RequestParam("file") MultipartFile file){

    	return  workApplicationServices.create(studentid, courseid, file.getOriginalFilename(), file);
    }


	@RequestMapping(value="/work", method=RequestMethod.PUT)
	public WorkDTO update(@RequestBody WorkDTO s){ return workApplicationServices.save(s);
	}


	@RequestMapping(value="/work/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id){
		workApplicationServices.supprimer(id);
		return true;
	}	

}

