package com.example.project_lecture_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class ProjectLectureApiApplication {

//	http://localhost:8081/  

	public static void main(String[] args) {
		SpringApplication.run(ProjectLectureApiApplication.class, args);
	}
  
}  
  