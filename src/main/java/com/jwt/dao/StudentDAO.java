package com.jwt.dao;

import java.util.List;
import com.jwt.model.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public List<Student> getAllStudent();

	public void deleteStudent(Integer rollnum);

	public Student updateStudent(Student student);

	public Student getStudent(int rollnum);
}
