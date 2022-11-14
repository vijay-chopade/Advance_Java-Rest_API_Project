package com.example.project_lecture_api;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8787")
public class StudentController {

//	http://localhost:8081/

	@Autowired
	SessionFactory factory;

	List<Student> arraylist = null;

	public StudentController() {
//		System.err.println("Student Bean was diste....StudentController(){}");
	}

	@GetMapping("students")
	public List<Student> allStudents() {
		// Session session=factory.openSession(); ==> This step not working so i use
		// sessionFactory.openSession();

		Session session = factory.openSession();
		arraylist = session.createCriteria(Student.class).list();
		return arraylist;
	}

	@GetMapping("student/{rno}")
	public Student getStudent(@PathVariable int rno) {
		Session session = factory.openSession();
		Student student = session.load(Student.class, rno);
		return student;
	}

	@PostMapping("student")
	public String addStudent(@RequestBody Student student) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(student);

		tr.commit();
		List<Student> list = allStudents();
		return student.getSid() + " add successfully!";
	}

	@DeleteMapping("student/{rno}")
	public String deleteStudent(@PathVariable int rno) {
		Session session = factory.openSession();
		Student student = session.load(Student.class, rno);
		Transaction tr = session.beginTransaction();
		session.delete(student);
		tr.commit();
		return "Student deleted.";
	}

	@PutMapping("student")
	public List<Student> updateStudent(@RequestBody Student Student) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(Student);
		tr.commit();
		List<Student> list = allStudents();
		return list;
	}

}
