package com.example.project_lecture_api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8787")
public class StudentController {

//	http://localhost:8081/

	@RequestMapping("test")
	public String test() {
		return "Test Pass <br>localhost:8081 Runing.....";
	}

	ArrayList<Student> arrayList = new ArrayList<>();

	public StudentController() {
		Student student1 = new Student(1, "ram", 70);
		Student student2 = new Student(2, "sham", 80);
		Student student3 = new Student(3, "sagar", 90);
		Student student4 = new Student(4, "mangesh", 80);
		arrayList.add(student1);
		arrayList.add(student2);
		arrayList.add(student3);
		arrayList.add(student4);
	}

	@GetMapping("students")
	public ArrayList<Student> allStudents() {

		return arrayList;
	}

	@GetMapping("student/{rno}")
	public Student getStudent(@PathVariable int rno) {
		for (Student student : arrayList) {
			if (student.getSid() == rno) {
				return student;
			}
		}
		return null;
	}

	@PostMapping("student")
	public String addStudent(@RequestBody Student student) {
		int[] ids = new int[arrayList.size()];
		int j = 0;
		for (Student oldstudent : arrayList) {
			ids[j] = oldstudent.getSid();
//			System.err.println("User ID: "+oldstudent.getSid());
			j++;
		}
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == student.getSid()) {
				return "Student already prasent...!";
			}
		}
		arrayList.add(student);
		return student.getSid() + " add successfully!";
	}

	@DeleteMapping("student/{rno}")
	public String deleteStudent(@PathVariable int rno) {
		Student deleteStudent = null;
		for (Student student : arrayList) {
			if (student.getSid() == rno) {
				deleteStudent = student;
				break;
			}
		}
		arrayList.remove(deleteStudent);
		return "Student Delete Successfully.";
	}

	@PutMapping("student")
	public ArrayList updateStudent(@RequestBody Student clientStudent) {
		Student updateStudent = null;
		for (Student student : arrayList) {
			if (student.getSid() == clientStudent.getSid()) {
				updateStudent = student;
			}
		}
		updateStudent.setSname(clientStudent.getSname());
		updateStudent.setSmarks(clientStudent.getSmarks());
		return arrayList;
	}

}
