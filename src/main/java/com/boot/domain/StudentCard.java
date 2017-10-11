package com.boot.domain;

import java.io.Serializable;

/**
 * 学生证
 * @author xingwuzhao
 *
 */
@SuppressWarnings("serial")
public class StudentCard implements Serializable {

	private int id;
	private int studentId;
	private int note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
}
