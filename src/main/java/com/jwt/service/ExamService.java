package com.jwt.service;

import java.util.List;

import com.jwt.model.Exam;

public interface ExamService {
	
	public void addExam(Exam exam);

	public void deleteExam(int id,int sid);
	
	public List<Exam> getExamBySid(int sid);

	public Exam getExam(int id);

	public Exam updateExam(Exam exam);


}
