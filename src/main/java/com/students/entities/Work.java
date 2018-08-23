package com.students.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Work {
 @Id 
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String name;
 private String FileName;
 private String FileContent;
 private Date UploadedDate;

 @Lob
 @Column(length = 500000)
 private byte[] data;



 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

 @ManyToOne
 private Student student;

 @OneToOne
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

	public String getFileContent() {
		return FileContent;
	}

	public void setFileContent(String fileContent) {
		FileContent = fileContent;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUploadedDate(Date uploadedDate) {
		UploadedDate = uploadedDate;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setUploadedDate(String s) {

	}

	public void setData() {

	}
}
