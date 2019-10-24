package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.StudentDAO;
import com.jwt.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudent();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer rollnum) {
		studentDAO.deleteStudent(rollnum);
	}

	public Student getStudent(int empid) {
		return studentDAO.getStudent(empid);
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
