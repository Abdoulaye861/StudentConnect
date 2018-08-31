package com.students.controller;

public class MarkDTO {

	private Long id;
	private  String markValue;
	private String markedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarkedDate() {
		return markedDate;
	}

	public String getMarkValue() {
		return markValue;
	}

	public void setMarkValue(String markValue) {
		this.markValue = markValue;
	}

	public void setMarkedDate(String markedDate) {
		this.markedDate = markedDate;
	}
}
