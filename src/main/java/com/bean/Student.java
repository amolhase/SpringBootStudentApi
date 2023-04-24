package com.bean;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	private int sid;
	@Column(unique = true)
	private String email;
	private String password;
	private String sname;
	private int age;
	private String sclass;
	private String section;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sid",referencedColumnName = "mid")
     private Marks marks;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sid",referencedColumnName = "fid")
	private Feedback feedback;

	public Student(int sid, String email, String password, String sname, int age, String sclass, String section,
			Marks marks, Feedback feedback) {
		super();
		this.sid = sid;
		this.email = email;
		this.password = password;
		this.sname = sname;
		this.age = age;
		this.sclass = sclass;
		this.section = section;
		this.marks = marks;
		this.feedback = feedback;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", email=" + email + ", password=" + password + ", sname=" + sname + ", age="
				+ age + ", sclass=" + sclass + ", section=" + section + ", marks=" + marks + ", feedback=" + feedback
				+ "]";
	}
	
	
}
