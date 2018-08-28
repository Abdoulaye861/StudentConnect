package com.students.entities;

import javax.persistence.*;

@Entity
public class Mark {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String markedDate;

	@ManyToOne
	private Teacher evaluator;


	public Mark(String markedDate) {
		super();
		this.markedDate = markedDate;
	}

	public Mark() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarkedDate() {
		return markedDate;
	}

	public void setMarkedDate(String markedDate) {
		this.markedDate = markedDate;
	}

	public static void main(String[] args) {

	}

	public Teacher getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Teacher evaluator) {
		this.evaluator = evaluator;
	}


}
