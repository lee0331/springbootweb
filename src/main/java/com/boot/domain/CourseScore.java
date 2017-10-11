package com.boot.domain;

import java.io.Serializable;

/**
 * 成绩表
 * @author xingwuzhao
 *
 */
@SuppressWarnings("serial")
public class CourseScore implements Serializable {

	private int id;
	private int studentId;
	private Course course;
	private String score;
	
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
