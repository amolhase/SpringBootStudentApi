package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Marks;
import com.bean.Student;
import com.service.MarksService;
import com.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("marks")
@CrossOrigin(origins = "http://localhost:3000")
public class MarksController {
	@Autowired
	MarksService marksService;

	@GetMapping("/getAllStudentsMarks")
	public List<Marks> getStudentMarks(){
		return marksService.getStudentMarks();
	}
	
	@PostMapping(value = "storeMarks", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeMarks(@RequestBody Marks marks) {
		return marksService.storeMarks(marks);
	}

	@PutMapping(value = "updateMarks")
	public Marks updateMarks(@RequestBody Marks marks) {
		return marksService.updateMarks(marks);
	}
	
	@GetMapping("/getMarksBySid/{id}")
	public Marks getStudentMarksBySid(@PathVariable int id) {
		return marksService.getStudentMarksBySid(id);
	}

}
