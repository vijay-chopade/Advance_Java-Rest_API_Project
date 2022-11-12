package com.example.project_lecture_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:8787")
public class StudentController {

//	http://localhost:8081/

	@Autowired
	SessionFactory factory;

	List<Student> arraylist = null;

	public StudentController() {
	}

	@GetMapping("students")
	public List<Student> allStudents() {
		// Session session=factory.openSession(); ==> This step not working so i use
		// sessionFactory.openSession();

		Session session = factory.openSession();
		arraylist = session.createCriteria(Student.class).list();
		System.err.println(arraylist);
		return arraylist;
	}

	@GetMapping("student/{rno}")
	public Student getStudent(@PathVariable int rno) {
		for (Student student : arraylist) {
			if (student.getSid() == rno) {
				return student;
			}
		}
		return null;
	}

	@PostMapping("student")
	public String addStudent(@RequestBody Student student) {
		int[] ids = new int[arraylist.size()];
		int j = 0;
		for (Student oldstudent : arraylist) {
			ids[j] = oldstudent.getSid();
//			System.err.println("User ID: "+oldstudent.getSid());
			j++;
		}
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == student.getSid()) {
				return "Student already prasent...!";
			}
		}
		arraylist.add(student);
		return student.getSid() + " add successfully!";
	}

	@DeleteMapping("student/{rno}")
	public String deleteStudent(@PathVariable int rno) {
		Student deleteStudent = null;
		for (Student student : arraylist) {
			if (student.getSid() == rno) {
				deleteStudent = student;
				break;
			}
		}
		arraylist.remove(deleteStudent);
		return "Student Delete Successfully.";
	}

	@PutMapping("student")
	public List<Student> updateStudent(@RequestBody Student clientStudent) {
		Student updateStudent = null;
		for (Student student : arraylist) {
			if (student.getSid() == clientStudent.getSid()) {
				updateStudent = student;
			}
		}
		updateStudent.setSname(clientStudent.getSname());
		updateStudent.setSmarks(clientStudent.getSmarks());
		return arraylist;
	}

}
