package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bean.Marks;
import com.bean.Student;
import com.repository.MarksRepository;
import com.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MarksRepository marksRepository;
	
	public String StudentSignUp(Student student) 
	{
		Optional<Student> op = studentRepository.findById(student.getSid());
		if(op.isPresent()) 
		{
			return "Student Already Exist, SignIn Once again.....";
		}
		else
		{
			studentRepository.save(student);
			return "Congratulations,Student Account Sucessfully Created Login Once Again ";
		}
		
	}
	
	public String StudentSignIn(Student student)
	{
		Optional<Student> op = studentRepository.findEmailIid(student.getEmail());
		if(op.isPresent())
		{
			Student s = op.get();
			if(s.getPassword().equals(student.getPassword()))
			{
				return "Student Successfully login.....";
			}
			else
			{
				return "Password is wrong.....";
			}
		}
		else {
	
			return "Account Not Exist SignUp First";
		}
	}


	public String storeStudent(Student student) {
	Optional<Student> op = studentRepository.findById(student.getSid());
	if(op.isPresent()) {
		return "Student id must be unique";
	}else {
		
		//Marks marks = student.getMarks();

//		int total_marks=marks.getEng()+marks.getMarathi()+marks.getMath()+marks.getScience()+marks.getSocial();
//		marks.setTotalMarks(total_marks);
//		if(total_marks>500 && total_marks<600)
//		{
//			marks.setGrade("A");
//		}
//		else if(total_marks>400 && total_marks<500)
//		{
//			marks.setGrade("B");
//		}
//		else if(total_marks>300 && total_marks<400)
//		{
//			marks.setGrade("C");
//		}
//		else
//		{
//			marks.setGrade("Fail");
//		}
//		student.setMarks(marks);
		studentRepository.save(student);
		return "Student details stored successfully";
	}
	}
	
	public String updateStudentDetails(Student sr) {
		Optional<Student> op = studentRepository.findById(sr.getSid());
		if(op.isPresent()) {
			Student s = op.get();
				s.setSname(sr.getSname());
				s.setAge(sr.getAge());
				s.setSclass(sr.getSclass());
				s.setSection(sr.getSection());
				studentRepository.saveAndFlush(s);
			return "Studnet details updated successfully";
		}else {
			return "Student not exists";
		}
	}
	
	public String deleteStudentInfo(int id) {
		Optional<Student> result	= studentRepository.findById(id);
		if(result.isPresent()) {
			Student stud = result.get();
			studentRepository.delete(stud);					// delete query 
			return "Student record deleted sucessfully";
		}else {
			return "Student record not present";
		}
	}
	public List<Student> getAllStudentDetails() {
		return studentRepository.findAll();
	}
	
	public String updateStudentMarks(@RequestBody Student s) 
	{

		Optional<Student> result	= studentRepository.findById(s.getSid());
		
		if(result.isPresent())
		{
			Student stud =result.get();
			
			stud.setMarks(s.getMarks());
			Marks marks = (Marks) stud.getMarks();

			int total_marks=marks.getEng()+marks.getMarathi()+marks.getMath()+marks.getScience()+marks.getSocial();
			marks.setTotalMarks(total_marks);
			if(total_marks>500 && total_marks<600)
			{
				marks.setGrade("A");
			}
			else if(total_marks>400 && total_marks<500)
			{
				marks.setGrade("B");
			}
			else if(total_marks>300 && total_marks<400)
			{
				marks.setGrade("C");
			}
			else
			{
				marks.setGrade("Fail");
			}
			s.setMarks(marks);
			studentRepository.saveAndFlush(stud);
			
			return "Student Marks updated successfully";
		}
		else 
		{
			return "Student Marks not updated ";
		}
	}
	
	public String findStudentById(int id) 
	{
		Optional<Student> op = studentRepository.findById(id);
		if(op.isPresent())
		{
			 Student s = op.get();
		
		return s.toString();		// convert object into string format. 
		}
		else 
		{
		return "Record not present with id as "+id;
		}
		
 }
	
	public Marks getMarksById(int id) {
		Optional<Marks> op = marksRepository.findById(id);
		if(op.isPresent()) {
			Marks m = op.get();
			m.getEng();
			m.getMarathi();
			m.getMath();
			m.getScience();
			m.getSocial();
			m.getGrade();
		return m; 
		}else {
			return null;
		}
	}	
	
}
