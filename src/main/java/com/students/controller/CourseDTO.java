package com.students.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class CourseDTO {

	private List<WorkDTO> works;

	private Long id;
	private String name;
	private Date publishedDate;
	private String fileExtension;
	private Boolean hasContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Boolean getHasContent() {
		return hasContent;
	}

	public void setHasContent(Boolean hasContent) {
		this.hasContent = hasContent;
	}

	public List<WorkDTO> getWorks() {
		return works;
	}

	public void setWorks(List<WorkDTO> works) {
		this.works = works;
	}
}
