package com.jwt.dao;

import java.util.List;

import com.jwt.model.Exam;

public interface ExamDAO {
	
	public void addExam(Exam exam);

	public void deleteExam(Integer id);

	public Exam updateExam(Exam exam);

	public Exam getExam(int id);
	
	public List<Exam> getExamBySid(int sid);
	
	public void updateFinalScore(int sid);

}
