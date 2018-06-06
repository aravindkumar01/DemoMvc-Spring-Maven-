package com.DemoMvc.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DemoMvc.Model.Student;
import com.DemoMvc.Model.Dao.StudentImplementation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

//@Service("serviceinte"
//	+ ""
//+ "rface")
public class StudentServiceImplementation implements StudentServiceInterface {

	StudentImplementation dao;

	@Override
	public void studentSave(Student stu) {
		dao = new StudentImplementation();
		dao.studentInsert(stu);

	}

	@Override
	public List<Student> stuSearch(String name) {

		List<Student> stuList = new ArrayList<Student>();
		try {
			dao = new StudentImplementation();
			stuList = dao.getStudent(name);

			return stuList;

		} catch (Exception e) {
			System.out.println(e); // TODO: handle exception
		}

		return stuList;

	}

	@Override
	public void update(Student stu) {
		// TODO Auto-generated method stub

		dao = new StudentImplementation();
		try {

			dao.update(stu);
		} catch (Exception e) {
			System.out.println(e); // TODO: handle exception
		}
	}

	@Override
	public void stuDelete(Student stu) {
		// TODO Auto-generated method stub

		dao = new StudentImplementation();
		try {

			dao.stuDelete(stu);
		} catch (Exception e) {
			System.out.println(e); // TODO: handle exception
		}
		
		 
	}
}
