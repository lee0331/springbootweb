package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.StudentMapper;
import com.boot.domain.Student;
import com.boot.domain.StudentCard;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> finaAllStudents() {
		return studentMapper.getAllStudent();
	}
	
	@Transactional(rollbackFor = IllegalArgumentException.class)
	public int insertStudent(Student student){
		studentMapper.insertStudent(student);
		if(true) {
			throw new IllegalArgumentException("存在了...");
		}
		return 1;
	}
	
	public int updateStudent(Student s) {
		return studentMapper.updateStudent(s);
	}
	
	//一对一级联
	public StudentCard findSelfCardByStudentId(int id) {
		return studentMapper.findSelfCardByStudentId(id);
	}
	public Student getStudent(int id) {
		return studentMapper.getStudent(id);
	}
	
	public List<Student> finaStudentInSex(List<String> sex_l) {
		return studentMapper.finaStudentInSex(sex_l);
	}
}
