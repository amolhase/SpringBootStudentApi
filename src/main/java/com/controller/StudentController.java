package com.controller;

import java.net.http.HttpHeaders;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Marks;
import com.bean.Student;
import com.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController
{
	@Autowired
	StudentService studentService;
	
	//@RequestMapping(value = "storeStudent",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	@PostMapping(value = "storeStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Student student) {
		return studentService.storeStudent(student);
	}
	
	@PutMapping(value = "updateStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudentDetails(student);
	}
	
	@RequestMapping(value = "deleteStudentInfo/{id}",method = RequestMethod.DELETE)
	public String deleteStudentInfo(@PathVariable("id") int id) {   
		return studentService.deleteStudentInfo(id);
	}
	
	@GetMapping(value = "findAllStudent",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAllStudent() {
		return studentService.getAllStudentDetails();
	}
	
	@RequestMapping(value = "updateStudentMarks",method = RequestMethod.PATCH,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String StudentMarks(@RequestBody Student s) {   //@RequestBody : this annotation is use to extract the from the body part. 
		System.out.println(s);     // it will all toString method
		return studentService.updateStudentMarks(s);
	}
	
	@RequestMapping(value = "findStudentById/{id}",method = RequestMethod.GET)
	public String findStudentById(@PathVariable("id") int id) {
		return studentService.findStudentById(id);		
	}
	
	//@RequestMapping(value = "findStudentMarksById",method = RequestMethod.GET)
	@GetMapping("/getMarks/{id}")
	public Marks getMarksById(@PathVariable int id) {
		return studentService.getMarksById(id);		
	}
	
	
	@PostMapping(value="signup" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signup(@RequestBody Student student)
	{
		System.out.println(student.toString());
		return studentService.StudentSignUp(student);
	}
	
	@PostMapping(value="signin" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signin(@RequestBody Student student)
	{
		System.out.println(student.toString());
		return studentService.StudentSignIn(student);
	}


	
}
