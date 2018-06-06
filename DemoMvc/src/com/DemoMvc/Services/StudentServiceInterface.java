package com.DemoMvc.Services;

import java.util.List;

import com.DemoMvc.Model.Student;

public  interface StudentServiceInterface {

	
	public void studentSave(Student stu);
	public List<Student> stuSearch(String name);
	public void update(Student stu);
	public void stuDelete(Student stu);
	
	
}
