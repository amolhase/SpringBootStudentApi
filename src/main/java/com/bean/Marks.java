package com.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private int math;
	private int eng;
	private int marathi;
	private int social;
	private int science;
	@Column(name="totalmarks")
	private int totalMarks;
	private String grade;
	private int sid;
		
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marks(int mid, int math, int eng, int marathi, int social, int science, int totalMarks, String grade,
			int sid) {
		super();
		this.mid = mid;
		this.math = math;
		this.eng = eng;
		this.marathi = marathi;
		this.social = social;
		this.science = science;
		this.totalMarks = totalMarks;
		this.grade = grade;
		this.sid = sid;
	}

	

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMarathi() {
		return marathi;
	}

	public void setMarathi(int marathi) {
		this.marathi = marathi;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Marks [mid=" + mid + ", math=" + math + ", eng=" + eng + ", marathi=" + marathi + ", social=" + social
				+ ", science=" + science + ", totalMarks=" + totalMarks + ", grade=" + grade + ", sid=" + sid + "]";
	}
	
	
	
}
