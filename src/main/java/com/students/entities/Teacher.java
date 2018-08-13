package com.students.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	private Date birthDate;
	private String password;
	private String photo;
	
	// Relation publisher et Cours
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="publisher")
	private List<Course> courses;


	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="evaluator")
	private  List<Mark> mark;
	
	public Teacher(String firstname, String lastname, String email, String phone, String role, Date birthDate,
			String password, String photo) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phone = phone;
		
		this.birthDate = birthDate;
		this.password = password;
		this.photo = photo;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	// Pour ajouter un cours
	public void addCourse(Course c) {
		if( getCourses()== null) {
			this.courses= new ArrayList<>();
		}
		getCourses().add(c);
		c.setPublisher(this);
	}


	public void addMarks(Mark e) {
		if( getMark()== null) {
			this.mark= new ArrayList<>();
		}

		getMark().add(e);
		e.setEvaluator(this);
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
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
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Mark> getMark() {
		return mark;
	}

	public void setMark(List<Mark> mark) {
		this.mark = mark;
	}
}
