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

	@OneToOne
	private Work work;
	
	public Mark(String markedDate) {
		super();
		this.markedDate = markedDate;
	}

	public Mark() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub

	}

	public Teacher getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Teacher evaluator) {
		this.evaluator = evaluator;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
}
