package com.students.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Work {
 @Id 
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String FileName;
 private String Extention;
 private String FileContent;
 private String UploadedDate;

 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

 @ManyToOne
 private Student student;

 @ManyToOne
 private Mark mark;

 @ManyToOne
 private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getExtention() {
		return Extention;
	}

	public void setExtention(String extention) {
		Extention = extention;
	}

	public String getFileContent() {
		return FileContent;
	}

	public void setFileContent(String fileContent) {
		FileContent = fileContent;
	}

	public String getUploadedDate() {
		return UploadedDate;
	}

	public void setUploadedDate(String uploadedDate) {
		UploadedDate = uploadedDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
