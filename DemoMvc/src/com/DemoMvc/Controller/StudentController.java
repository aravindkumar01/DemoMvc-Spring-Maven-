package com.DemoMvc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DemoMvc.Model.Student;
import com.DemoMvc.Services.StudentServiceImplementation;
import com.DemoMvc.Services.StudentServiceInterface;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;

import org.json.JSONObject;



@Controller
public class StudentController {

	public StudentServiceInterface service;

	@RequestMapping(value = "/StudentSave", method = RequestMethod.POST)

	/*
	 * public ModelAndView addUser(HttpServletRequest request, HttpServletResponse
	 * response,
	 * 
	 * @ModelAttribute("student") Student student, @RequestParam String action,Model
	 * model) {
	 */

	public String addStudent(@ModelAttribute("student") Student student, @RequestParam String action, Model model) {

/*		System.out.println(student.getName());
		System.out.println(student.getDegree());
		System.out.println(student.getPhone());
		System.out.println(student.getAddress());
		System.out.println(action);
		*/service = new StudentServiceImplementation();

		switch (action.toLowerCase()) {
		case "save":
			service.studentSave(student);
			break;

		case "update":
           	service.update(student);
           	break;
         
		case "delete":
		     service.stuDelete(student);
		     break;
		default:
			break;
		}

		// return new ModelAndView("redirect:/");

		return "welcome";

	}

	@RequestMapping(value = "/ListSearch/{search}", method = RequestMethod.GET, produces = "application/json")

	public @ResponseBody List<Student> stuList(@PathVariable("search") String search) {
		service = new StudentServiceImplementation();
		List<Student> list = new ArrayList();
		list = service.stuSearch(search);
		return list;

	}

}