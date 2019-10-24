package com.jwt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="rollnum")
	private int rollNum;

	@Column(name="sname")
	private String name;

	@Column
	private int age;

	@Column
	private String gender;
	
	@Column
	private String country;
	
	@Column
	private Date doj;
	
	@Column
	private float finalscore;
	
	@Transient
	private String grade;

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public float getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(float finalscore) {
		this.finalscore = finalscore;
	}

	public String getGrade() {
		GradeInterface gradeInterface=(float x)->  {
			
			String grade =
			        (x <= 40) ? "FAIL" :
			        (x <= 60) ? "AVERAGE" :
			        (x <= 75) ? "FIRST CLASS" : "DISTINCTION";
				return grade;};
		return gradeInterface.gradeCalc(finalscore);
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}

	
