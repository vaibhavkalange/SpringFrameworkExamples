package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.User;
import com.example.service.UserService;
import com.example.validator.UserFormValidator;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFormValidator userFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model){
		logger.debug("Index()");
		return "redirect:/users";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String showAllUser(Model model){
		logger.debug("showAllUser()");
		model.addAttribute("users", userService.findAllUser());
		return "list";
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.GET)
	public String showAddUserForm(Model model){

		//Setting Default Value
		User user = new User();
		user.setName("Ankita");
		user.setCountry("India");
		user.setEmail("ankita@gmail.com");
		user.setAddress("Pune");
		user.setFrameworks(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
		user.setSkills(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
		
		model.addAttribute("userForm", user);
		populateDefaultModel(model);
		
		return "userForm";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model, final RedirectAttributes attribute){
		
		logger.debug("saveOrUpdateUser() : {}",user);
		
		if(result.hasErrors()){
			populateDefaultModel(model);
			return "userForm";
		}
		
		userService.saveOrUpdate(user);
		
		return "redirect:/users";
		
	}
	
	@RequestMapping(value="/users/{id}/delete", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("id")int id, final RedirectAttributes attribute){
		
		logger.debug("deleteUser() : ID:{}",id);
		userService.delete(id);
		attribute.addFlashAttribute("css", "success");
		attribute.addFlashAttribute("msg", "User deleted...!");
		
		return "redirect:/users";
	}
	
	@RequestMapping(value="/users/{id}/update", method=RequestMethod.GET)
	public String updateUserById(@PathVariable("id")int id, Model model){
		
		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		populateDefaultModel(model);
		
		return "userForm";
	}
	
	private void populateDefaultModel(Model model){
		
		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF 2");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);
		
		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);
		
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);
	}

}
