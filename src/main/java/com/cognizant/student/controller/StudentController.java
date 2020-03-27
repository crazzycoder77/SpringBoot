package com.cognizant.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.student.model.Student;
import com.cognizant.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public ModelAndView indexCOntroller() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("view")
	public ModelAndView viewController() {
		ModelAndView mv = new ModelAndView("view");
		List<Student> students = studentService.getAll();
		mv.addObject("students", students);
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertGet() {
		ModelAndView mv = new ModelAndView("student");
		mv.addObject("student", new Student());
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insertPost(@ModelAttribute("student") Student student) {
		ModelAndView mv;
		if (studentService.insert(student)) {
			mv = viewController();
			mv.addObject("success", "Insertion Sucessful");
		} else {
			mv = new ModelAndView("student");
			mv.addObject("student", student);
			mv.addObject("error", "Record Insertion failed");
		}
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updateGet(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("student");
		mv.addObject("student", studentService.getStudent(id));
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@ModelAttribute("student") Student student) {
		ModelAndView mv;
		if (studentService.update(student)) {
			mv = viewController();
			mv.addObject("success", "Updation Sucessful");
		} else {
			mv = new ModelAndView("student");
			mv.addObject("student", student);
			mv.addObject("error", "Record Updation failed");
		}
		return mv;
	}

	@RequestMapping(value = "delete")
	public ModelAndView deleteGet(@RequestParam int id, ModelMap model) {
		ModelAndView mv;
		boolean delete = studentService.delete(id);
		mv = viewController();
		if(delete)
			mv.addObject("success", "Deletion Successfull");
		else
			mv.addObject("success", "Deletion Failed");
		return mv;
	}

}
