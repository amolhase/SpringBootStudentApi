package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Feedback;
import com.repository.FeedbackRepository;

@Service
public class FeedbackService
{

	@Autowired
	FeedbackRepository feedbackRepository;
	
	public String GiveFeedback(Feedback feedback)
	{
		Optional<Feedback>op=feedbackRepository.findById(feedback.getFid());
		if(op.isPresent())
		{
			return "Feedback Already Available......!";
		}
		else
		{
			feedbackRepository.save(feedback);
			return "Feedback Store Successfully";
		}
	}

	public List<Feedback> findAllfeedback() 
	{
		return feedbackRepository.findAll();
      }
}
