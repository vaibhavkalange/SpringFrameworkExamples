package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model){
		
		model.addAttribute("message", "Welcome to Spring 4 MVC...!");
		return "hello";
	}
	
	//URL e.g. "/hello/name=Vaibhav"
	@RequestMapping(value="/hello/{name:.+}", method=RequestMethod.GET)
	public ModelAndView sayHello(@PathVariable("name") String name){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);
		return model;
	}

}
