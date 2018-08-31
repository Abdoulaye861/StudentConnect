package com.students.controller;

public class WorkAndMarkDTO {
    Long workid;
    String workFileName;
    Long courseid ;
    String courseName ;
    Long markid;
    Double markValue;

    public Long getWorkid() {
        return workid;
    }

    public void setWorkid(Long workid) {
        this.workid = workid;
    }

    public String getWorkFileName() {
        return workFileName;
    }

    public void setWorkFileName(String workFileName) {
        this.workFileName = workFileName;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getMarkid() {
        return markid;
    }

    public void setMarkid(Long markid) {
        this.markid = markid;
    }

    public Double getMarkValue() {
        return markValue;
    }

    public void setMarkValue(Double markValue) {
        this.markValue = markValue;
    }
}
