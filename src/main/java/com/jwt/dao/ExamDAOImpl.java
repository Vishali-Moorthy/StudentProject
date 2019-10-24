package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Exam;
import com.jwt.model.Student;

@Repository
public class ExamDAOImpl implements ExamDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addExam(Exam exam) {
		sessionFactory.getCurrentSession().saveOrUpdate(exam);

	}

	@Override
	public void deleteExam(Integer id) {
		Exam exam = (Exam) sessionFactory.getCurrentSession().load(Exam.class, id);
		if (null != exam) {
			this.sessionFactory.getCurrentSession().delete(exam);
		}

	}
	
	public List<Exam> getExamBySid(int sid) {
		return sessionFactory.getCurrentSession().createQuery("from Exam where sid=" +sid).list();
	}
	
	@Override
	public void updateFinalScore(int sid) {
		List list=sessionFactory.getCurrentSession().createQuery("from Student where id="+sid).list();
		Student st=(Student)list.get(0);
		list = sessionFactory.getCurrentSession().createQuery("select avg(marks) from Exam where sid="+sid).list();
		if(list.get(0)!=null)
			st.setFinalscore(((Double) list.get(0)).floatValue());
		else
			st.setFinalscore(0.0f);
		sessionFactory.getCurrentSession().update(st);
	}

	public Exam getExam(int id) {
		return (Exam) sessionFactory.getCurrentSession().get(
				Exam.class, id);
	}

	@Override
	public Exam updateExam(Exam exam) {
		sessionFactory.getCurrentSession().update(exam);
		return exam;
	}


}
