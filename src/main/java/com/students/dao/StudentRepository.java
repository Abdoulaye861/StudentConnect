package com.students.dao;


import com.students.entities.Student;
import com.students.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByEmail(String email);

}

