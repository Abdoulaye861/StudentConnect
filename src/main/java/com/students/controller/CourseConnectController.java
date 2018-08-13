package com.students.controller;

import com.students.application.CourseApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CourseConnectController {
	@Autowired
	CourseApplicationServices courseApplicationServices;

	@RequestMapping(value="/course", method=RequestMethod.GET)
	public List<CourseDTO> getcourses(){
		return  courseApplicationServices.getCourses();
	}
	
	@RequestMapping(value="/course/{id}", method=RequestMethod.GET)
	public CourseDTO getcourses(@PathVariable Long id){
		return  courseApplicationServices.getCourse(id);
	}


	/*
    @RequestMapping(value="/course/{id}/content", method=RequestMethod.GET)
    @ResponseBody
    public void  getCourseContent(HttpServletResponse response, @PathVariable Long id){
        byte[] bytes = courseApplicationServices.getCourseContent(id);
        response.setContentType("text/pdf");
        response.addHeader("Content-Disposition", "inline;filename=" + id + ".pdf");

        try{
            response.getOutputStream().write(bytes);
        } catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

*/

	/*
	@RequestMapping(value="/course/create/{name}", method=RequestMethod.POST)
	public CourseDTO create(@PathVariable String name){ return  courseApplicationServices.create(name);
	}
*/

    @RequestMapping(value="/course/create", method=RequestMethod.POST,  consumes={"multipart/form-data"})
    public CourseDTO create(@RequestPart("file") MultipartFile file, @RequestPart("name") String  name){

    	return  courseApplicationServices.create(name, file);
    }


	@RequestMapping(value="/course", method=RequestMethod.PUT)
	public CourseDTO update(@RequestBody CourseDTO s){ return courseApplicationServices.save(s);
	}


	@RequestMapping(value="/course/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id){
		courseApplicationServices.supprimer(id);
		return true;
	}	

}

