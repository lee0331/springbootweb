package com.boot.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 学生表
 * @author xingwuzhao
 *
 */
@SuppressWarnings("serial")
public class Student implements Serializable {
	
	private String id;
	private String name;
	private byte age;
	private String sex;
	private StudentCard studentCard;
	private List<CourseScore> courseScoreList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public StudentCard getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(StudentCard studentCard) {
		this.studentCard = studentCard;
	}

	public List<CourseScore> getCourseScoreList() {
		return courseScoreList;
	}

	public void setCourseScoreList(List<CourseScore> courseScoreList) {
		this.courseScoreList = courseScoreList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", studentCard=" + studentCard
				+ ", courseScoreList=" + courseScoreList + "]";
	}
}