package com.students.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Date publishedDate;
	private String fileName;
	@Lob
	@Column(length = 500000)
	private byte[] data;

	
	@ManyToOne
	private Teacher publisher;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy ="course")
	private List<Work> work;
	
	
	public Teacher getPublisher() {
		return publisher;
	}

	public void setPublisher(Teacher publisher) {
		this.publisher = publisher;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Work> getWork() {
		return work;
	}

	public void setWork(List<Work> work) {
		this.work = work;
	}

	public Boolean getHasContent() {
		return getFileName() != null;
	}

}
