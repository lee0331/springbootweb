package com.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.boot.domain.Student;
import com.boot.domain.StudentCard;
import com.boot.service.StudentService;

/**
 * 用于演示 级联操作
 * @author xingwuzhao
 *
 */
@Controller
public class StudentController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/findSelfCardByStudentId", method = RequestMethod.GET)
	public @ResponseBody String findSelfCardByStudentId(int id) {
		StudentCard s_c = studentService.findSelfCardByStudentId(id);
		return JSON.toJSONString(s_c);
	}
	
	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public @ResponseBody String getStudent(int id) {
		Student s = studentService.getStudent(id);
		logger.debug(s.toString());
		return JSON.toJSONString(s);
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public @ResponseBody String updateStudent(Student s) {
		int rv = studentService.updateStudent(s);
		return JSON.toJSONString(rv);
	}
	
	@RequestMapping(value = "/finaStudentInSex", method = RequestMethod.GET)
	public @ResponseBody String finaStudentInSex() {
		List<String> sex_l = new ArrayList<>();
		sex_l.add("男");
		sex_l.add("女");
		return JSON.toJSONString(studentService.finaStudentInSex(sex_l));
	}
	
	@RequestMapping(value = "/insertStudent", method = RequestMethod.GET)
	private @ResponseBody String insertStudent() throws Exception {
		Student student = new Student();
		student.setAge((byte)12);
		int id = new Random().nextInt(100);
		student.setId(String.valueOf(id));
		student.setName("test" + "_" + id);
		student.setSex("男");
		studentService.insertStudent(student);
		throw new Exception();
	}
}
