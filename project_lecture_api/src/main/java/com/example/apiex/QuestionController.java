package com.example.apiex;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

	@Autowired
	SessionFactory factory;
	
	@RequestMapping("question/{id}")
	public Question getQuestion(@PathVariable int id) {
		Session session = factory.openSession();
		Question question = session.load(Question.class, id);
		List<Answer> answer = question.getAnswers();
		return question;
	}
	
}
