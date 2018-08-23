package com.students.controller;

import java.util.List;

public class WorkDTO {

 private Long id;
 private String FileName;
 private String Extention;
 private String FileContent;
 private String UploadedDate;

 private MarkDTO marks;
 private  List<CourseDTO> courses;


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

	public MarkDTO getMarks() {
		return marks;
	}

	public void setMarks(MarkDTO marks) {
		this.marks = marks;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}
}
