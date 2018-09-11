package com.students.controller;

import com.students.application.CourseApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class CourseConnectController extends BaseController {
    @Autowired
    CourseApplicationServices courseApplicationServices;

    @RequestMapping(value = "/teacher/{teacheid}/courses", method = RequestMethod.GET)
    public List<CourseDTO> getcourses(@PathVariable Long teacheid) {
        return courseApplicationServices.getCourses(teacheid);
    }


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<CourseDTO> getAllCourses() {
        return courseApplicationServices.getCourses();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public CourseDTO getcourse(@PathVariable Long id) {
        return courseApplicationServices.getCourse(id);
    }


    @RequestMapping(value = "/course/{id}/content", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<byte[]> getCourseContent(@PathVariable Long id) {
        return courseApplicationServices.getCourseContent(id);
    }


    @RequestMapping(value = "/teacher/{teacheid}/course/create", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public CourseDTO create(@PathVariable Long teacheid, @RequestPart("file") MultipartFile file, @RequestPart("name") String name) {

        return courseApplicationServices.create(teacheid, name, file);
    }


    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public CourseDTO update(@RequestBody CourseDTO s) {
        return courseApplicationServices.save(s);
    }


    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Long id) {
        courseApplicationServices.supprimer(id);
        return true;
    }

}

