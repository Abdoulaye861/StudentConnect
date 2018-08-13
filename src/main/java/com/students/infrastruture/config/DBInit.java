package com.students.infrastruture.config;

import javax.annotation.PostConstruct;


import com.students.dao.MarkRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.students.dao.StudentRepository;
import com.students.dao.TeacherRepository;
import com.students.dao.WorkRepository;

import com.students.entities.Course;
import com.students.entities.Student;
import com.students.entities.Teacher;
import com.students.entities.Work;
import com.students.entities.Mark;



@Configuration
public class DBInit {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;


	@Autowired
	private WorkRepository workRepository;


	@Autowired
	private MarkRepository markRepository;


	@PostConstruct
	@Transactional(readOnly = false)
	public void init() {
	 Student  erik= new Student();
	 erik.setFirstName("Erik");
	 erik.setLastName("Gollot");
	 erik.setEmail("golloerik@gmail.com");
	 erik.setPhone("0751985917");
	 erik.setBirthDate(new DateTime().withDate(2018, 6, 18).toDate());
	 erik.setPassword("erik");
	 erik.setPhoto("photo1");
	 studentRepository.save(erik);


	 Teacher stephane= new Teacher();
	 stephane.setFirstName("stephane");
	 stephane.setLastName("Gollot");
	 stephane.setEmail("golloerik@gmail.com");
	 stephane.setPhone("0751985917");
	 stephane.setBirthDate(new DateTime().withDate(2018, 6, 18).toDate());
	 stephane.setPassword("erik");
	 stephane.setPhoto("photo1");

	 Course c = new Course();
	 c.setName("Java course");
	 c.setFileName("pdf");
	 stephane.addCourse(c);


	 Work d = new Work();
	 d.setFileName("Géometrie");
	 d.setExtention("jpg");
	 d.setFileContent("apiflo");
	 d.setUploadedDate("25/08/2018");
	 erik.addWork(d);
	 workRepository.save(d);

	 Mark e = new Mark();
	 e.setMarkedDate("26/6/2018");
	 stephane.addMarks(e);
	 d.setMark(e);
	 teacherRepository.save(stephane);
	}

	}

