package com.students.application;

import com.students.controller.UserDTO;
import com.students.dao.StudentRepository;
import com.students.dao.TeacherRepository;
import com.students.entities.Student;
import com.students.entities.Teacher;
import com.students.infrastructure.util.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class UserApplicationServices {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    OrikaBeanMapper mapper;

    public  UserDTO login(String email) {

        Teacher teacher = teacherRepository.findByEmail(email);
        if(teacher != null){
            UserDTO u =  mapper.map(teacher, UserDTO.class);
            u.setType("teacher");
            return  u;
        } else{
            Student student = studentRepository.findByEmail(email);
            if(student != null){
               UserDTO u =  mapper.map(student, UserDTO.class);
               u.setType("student");
               return  u;
            }
        }
        return  null;
    }


}

