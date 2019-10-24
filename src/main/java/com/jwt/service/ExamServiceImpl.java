package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.ExamDAO;
import com.jwt.model.Exam;

@Service
@Transactional

public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamDAO examDAO;

	@Override
	@Transactional
	public void addExam(Exam exam) {
		examDAO.addExam(exam);
		examDAO.updateFinalScore(exam.getSid());
	}

	@Override
	@Transactional
	public void deleteExam(int id, int sid) {
		examDAO.deleteExam(id);
		examDAO.updateFinalScore(sid);
	}
	
	public List<Exam> getExamBySid(int sid) {
		return examDAO.getExamBySid(sid);
	}

	public Exam getExam(int id) {
		return examDAO.getExam(id);
	}

	public Exam updateExam(Exam exam) {
		exam = examDAO.updateExam(exam);
		examDAO.updateFinalScore(exam.getSid());
		return exam;
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}


}
