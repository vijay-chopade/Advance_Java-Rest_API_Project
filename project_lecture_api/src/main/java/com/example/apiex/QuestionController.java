package com.example.apiex;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

	@Autowired
	SessionFactory factory;
	
	@RequestMapping("getall")
	public List<Object[]> getAllData() {
		Session session = factory.openSession();
		Query query = session.createSQLQuery("select question.question_id qid,question ,answer_id aid,answer from question join answer on question.question_id = answer.question_id" );
		List<Object[]> list = query.list();
		return list;
	}
	
	

	@RequestMapping("answer/{id}")
	public List<Object[]> getAnswer(@PathVariable int id) {
		Session session = factory.openSession();
		session.load(Answer.class, id);
		//Query query = session.createSQLQuery(
				//"select question.question_id qid,question ,answer_id aid,answer from question join answer on question.question_id = "+id+" and answer.question_id = "
				//		+ id); // answer with question
		Query query = session.createSQLQuery(
				"select answer_id aid,answer from question join answer on question.question_id = "+id+" and answer.question_id = "
						+ id); // set question number and get only answers
		List<Object[]> list = query.list();
//		for (Object[] objects : list) {
//			for (Object objects2 : objects) {
//				System.out.println(objects2);
//			}
//
//		}
		return list;
	}

	@RequestMapping("question/{id}")
	public Question getQuestion(@PathVariable int id) {
		Session session = factory.openSession();
		Question question = session.load(Question.class, id);
		List<Answer> answer = question.getAnswers();
		return question;
	}

}
