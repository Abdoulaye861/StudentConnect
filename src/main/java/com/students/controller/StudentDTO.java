package com.students.controller;

import com.students.entities.Work;

import java.util.Date;
import java.util.List;


public class StudentDTO{


	private Long id;
	private String firstName;
	private String lastName;
  
	private String email;
	private String phone;

	private Date birthDate;
	private String password;
	private String photo;

	private List<WorkDTO> works;
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<WorkDTO> getWorks() {
		return works;
	}

	public void setWorks(List<WorkDTO> works) {
		this.works = works;
	}
}
