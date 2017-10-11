package com.boot.domain;

import java.io.Serializable;

/**
 * 课程表
 * @author xingwuzhao
 *
 */
@SuppressWarnings("serial")
public class Course implements Serializable {

	private int id;
	private String courseName;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
