package com.example.project_lecture_api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //
public class MyController {

	@RequestMapping("apicall")
	public String apicall() {

		return "APICall";
	}
//	modelAndView : if i want to show/send my java api data on jsp then i use modelandview;
//	if i want to show my data on client site inadvance then i simply call my jsp page

	@RequestMapping("test")
	public ModelAndView test() {
		ArrayList<String> arraylist = new ArrayList<>();
		arraylist.add("vijay");
		arraylist.add("sagar");
		arraylist.add("mangesh");
		String atribute = "data";
		ArrayList<String> value = arraylist;
//		model means data which will display on server using *test.jsp* {in case this case}
//		ModelAndView(string viewName, string Modelname, string objectname);
		ModelAndView modelanndview = new ModelAndView("test", atribute, value);

		return modelanndview;
	}
}
