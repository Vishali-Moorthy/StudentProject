package com.jwt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Exam;
import com.jwt.service.ExamService;
import com.jwt.service.StudentService;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	private static final Logger logger = Logger
			.getLogger(ExamController.class);

	public ExamController() {
		System.out.println("ExamController()");
	}

	@Autowired
	private ExamService examService;

	@RequestMapping(value = "/all")
	public ModelAndView listExam(ModelAndView model, HttpServletRequest request) throws IOException {
		int sid=Integer.parseInt(request.getParameter("sid"));
		String name=request.getParameter("sname");
		List<Exam> listExam = examService.getExamBySid(sid);
		for (Exam exam : listExam) {
			System.out.println(exam.getId());
		}
		model.addObject("listExam", listExam);
		model.setViewName("ExamHome");
		return model;
	}

	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newExam(ModelAndView model, HttpServletRequest request) {

		Exam exam = new Exam();
		exam.setSid(Integer.parseInt(request.getParameter("sid")));
		model.addObject("exam", exam);
		model.setViewName("ExamForm");
		return model;
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public ModelAndView saveExam(@ModelAttribute Exam exam) {
		if (exam.getId() == 0) {
			examService.addExam(exam);
		} else {
			examService.updateExam(exam);
		}
		return new ModelAndView("redirect:/exam/all?sid=" +exam.getSid());
	}

	@RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
	public ModelAndView deleteExam(HttpServletRequest request) {
		int examId=Integer.parseInt(request.getParameter("id"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		examService.deleteExam(examId, sid);
		return new ModelAndView("redirect:/exam/all?sid="+sid);
	}

	@RequestMapping(value = "/editExam", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Exam exam = examService.getExam(id);
		ModelAndView model = new ModelAndView("ExamForm");
		model.addObject("exam", exam);

		return model;
	}

}
