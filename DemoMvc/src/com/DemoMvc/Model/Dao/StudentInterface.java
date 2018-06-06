package com.DemoMvc.Model.Dao;

import java.util.List;

import com.DemoMvc.Model.Student;

public interface StudentInterface {

	public void studentInsert(Student stu);
	public List<Student> getStudent(String name);
	public void update(Student stu);
	public void stuDelete(Student stu);
	
}
