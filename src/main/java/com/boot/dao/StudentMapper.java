package com.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.domain.Course;
import com.boot.domain.CourseScore;
import com.boot.domain.Student;
import com.boot.domain.StudentCard;

@Mapper
public interface StudentMapper {

	public int updateStudent(Student s);//更新记录接口方法
    public List<Student> getAllStudent();//获取所有表行记录
    public int insertStudent(Student student);
    
    //一对一级联
    public StudentCard findSelfCardByStudentId(int id);
    public Student getStudent(int id);
    
    //一对多级联
    Course getCourse(int id);
    CourseScore findCourseScoreByStudentId(int id);
    
    List<Student> finaStudentInSex(List<String> sex_l);
}
