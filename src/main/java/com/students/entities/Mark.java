package com.students.entities;

import javax.persistence.*;

@Entity
public class Mark {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private  Double markValue;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarkedDate() {
		return markedDate;
	}

	public void setMarkedDate(String markedDate) {
		this.markedDate = markedDate;
	}

	public Double getMarkValue() {
		return markValue;
	}

	public void setMarkValue(Double markValue) {
		this.markValue = markValue;
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
