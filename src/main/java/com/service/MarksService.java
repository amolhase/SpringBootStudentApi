package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Marks;
import com.bean.Student;
import com.repository.MarksRepository;

import java.util.List;

@Service
public class MarksService
{
	@Autowired
	MarksRepository marksRepository;
	
	public String storeMarks(Marks marks)
	{
		Optional<Marks> op = marksRepository.findById(marks.getMid());
		if(op.isPresent())
		{
			return "Marks id must be unique";
		}
		
		else
		{
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
				return "fail";
			}
			marksRepository.save(marks);
			return "Student Marks details stored successfully";
		}
	}  
	
	public Marks updateMarks(Marks marks) {
		Optional<Marks> op = marksRepository.findById(marks.getMid());
		if(op.isPresent()) {
			Marks studentMarks = op.get();
			Optional.ofNullable(marks.getEng()).ifPresent(studentMarks::setEng);
			Optional.ofNullable(marks.getMarathi()).ifPresent(studentMarks::setMarathi);
			Optional.ofNullable(marks.getMath()).ifPresent(studentMarks::setMath);
			Optional.ofNullable(marks.getScience()).ifPresent(studentMarks::setScience);
			Optional.ofNullable(marks.getSocial()).ifPresent(studentMarks::setSocial);
			return marksRepository.saveAndFlush(studentMarks);
		}
		else {
			return null;
		}
	}
	
	public List<Marks> getStudentMarks(){
		return marksRepository.findAll();
	}
	
	
	public Marks getStudentMarksBySid(int sid) {
		return marksRepository.findMarksBySid(sid);
	}

	

}
